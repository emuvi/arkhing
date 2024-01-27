package br.com.pointel.arkhing;

import java.io.File;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author emuvi
 */
public class ArkhDockLoad {

    private final ArkhDock arkhDocs;

    private final Deque<File> files;

    private final AtomicBoolean isRunning;
    private final AtomicBoolean shouldStop;
    private final AtomicInteger doneLoadVerifiers;
    private final AtomicBoolean doneLinterClean;

    public ArkhDockLoad(ArkhDock arkhDocs) {
        this.arkhDocs = arkhDocs;
        this.files = new ConcurrentLinkedDeque<>();
        this.isRunning = new AtomicBoolean(false);
        this.shouldStop = new AtomicBoolean(false);
        this.doneLoadVerifiers = new AtomicInteger(0);
        this.doneLinterClean = new AtomicBoolean(false);
    }

    public void start() {
        isRunning.set(true);
        doneLoadVerifiers.set(0);
        doneLinterClean.set(false);
        for (int i = 1; i <= THREADS_VERIFIERS; i++) {
            new Thread("ArkhDockLoad - Verifier " + i) {
                @Override
                public void run() {
                    loadVerifiers();
                    doneLoadVerifiers.incrementAndGet();
                }
            }.start();
        }
        new Thread("ArkhDockLoad - Linter") {
            @Override
            public void run() {
                makeLinterClean();
                doneLinterClean.set(true);
                isRunning.set(false);
            }
        }.start();
    }

    public void stop() {
        shouldStop.set(true);
        while (!isDone()) {
            WizBase.sleep(10);
        }
    }

    public Boolean isDone() {
        return isDoneVerifiers()
                && doneLinterClean.get();
    }

    public Boolean isDoneVerifiers() {
        return doneLoadVerifiers.get() == THREADS_VERIFIERS;
    }

    public void addToVerify(File file) {
        files.add(file);
        if (!isRunning.get()) { 
            start();
        }
    }

    private void loadVerifiers() {
        var attempts = 0;
        while (true) {
            attempts++;
            if (shouldStop.get()) {
                return;
            }
            var file = files.pollFirst();
            if (file == null) {
                if (attempts > 120) {
                    break;
                }
                WizBase.sleep(1000);
                continue;
            }
            attempts = 0;
            try {
                arkhDocs.arkhBase.sendToListeners("[DOCK] Verifing: " + file.getName());
                if (DockReader.canRead(file)) {
                    loadDock(file);
                    arkhDocs.arkhBase.sendToListeners("[DOCK] Putted: " + file.getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
                arkhDocs.arkhBase.sendToListeners("[DOCK] Error: " + e.getMessage());
            }
        }
    }

    private void loadDock(File file) throws Exception {
        var folder = file.getParentFile();
        var dockData = arkhDocs.getDockData(folder);
        var lastLoad = dockData.getModifiedByName(file.getName());
        if (lastLoad != null && lastLoad == file.lastModified()) {
            return;
        }
        var source = new DockReader(file).read();
        var words = WizChars.getWords(source);
        dockData.putDock(file.getName(), file.lastModified(), words);
    }

    private void makeLinterClean() {
        try {
            while (!isDoneVerifiers()) {
                WizBase.sleep(100);
                if (shouldStop.get()) {
                    return;
                }
            }
            arkhDocs.freeAll();
        } catch (Exception e) {
            e.printStackTrace();
            arkhDocs.arkhBase.sendToListeners("[DOCK] Error: " + e.getMessage());
        }
    }

    private static final Integer THREADS_VERIFIERS = 4;

}
