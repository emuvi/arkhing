package br.com.pointel.arkhing;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;

public class FolderMirror {

    private final File origin;
    private final String originPath;
    private final File destiny;
    private final Deque<File> founds;
    private final AtomicBoolean doneFinder;
    private final AtomicInteger doneLoader;
    private final List<Consumer<String>> observers;

    public FolderMirror(File origin, File destiny) {
        this.origin = origin;
        this.originPath = origin.getAbsolutePath();
        this.destiny = destiny;
        this.founds = new ConcurrentLinkedDeque<>();
        this.doneFinder = new AtomicBoolean(false);
        this.doneLoader = new AtomicInteger(0);
        this.observers = new ArrayList<>();
    }
    
    public FolderMirror addObserver(Consumer<String> observer) {
        this.observers.add(observer);
        return this;
    }

    public FolderMirror start() {
        new Thread(() -> find(), "FolderMirror - Finder").start();
        for (int i = 1; i <= VELOCITY; i++) {
            new Thread(() -> load(), "FolderMirror - Loader " + i).start();
        }
        return this;
    }

    public boolean isDone() {
        return doneFinder.get() && doneLoader.get() == VELOCITY;
    }
    
    private void send(String message) {
        for (var observer : observers) {
            observer.accept(message);
        }
    }

    private void find() {
        find(origin);
        doneFinder.set(true);
    }

    private void find(File path) {
        if (path.isDirectory()) {
            for (var inside : path.listFiles()) {
                find(inside);
            }
        } else {
            founds.add(path);
            send("Found " + path.getAbsolutePath());
        }
    }

    private void load() {
        try {
            while (!doneFinder.get() || !founds.isEmpty()) {
                var found = founds.pollFirst();
                if (found == null) {
                    continue;
                }
                var relative = getRelative(found);
                var shouldCopy = !relative.exists() || relative.length() != found.length();
                if (shouldCopy) {
                    try {
                        send("Started copying: " + relative.getAbsolutePath());
                        relative.getParentFile().mkdirs();
                        Files.copy(found.toPath(), relative.toPath(),
                                StandardCopyOption.COPY_ATTRIBUTES, 
                                StandardCopyOption.REPLACE_EXISTING);
                        send("Finished copying: " + relative.getAbsolutePath());
                    } catch (Exception e) {
                        send("Error on copy: " + e.getMessage());
                    }
                } else {
                    send("No need to copy: " + relative.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            send("Error on load: " + e.getMessage());
        } finally {
            doneLoader.incrementAndGet();
        }
    }

    private File getRelative(File ofOrigin) {
        return new File(destiny,
                ofOrigin.getAbsolutePath().substring(originPath.length()));
    }

    private static final int VELOCITY = 4;
}
