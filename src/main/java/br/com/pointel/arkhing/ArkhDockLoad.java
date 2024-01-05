package br.com.pointel.arkhing;

import java.io.File;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.regex.Pattern;

/**
 *
 * @author emuvi
 */
public class ArkhDockLoad {
    
    private final ArkhDock arkhDocs;

    private final Deque<File> files;

    public ArkhDockLoad(ArkhDock arkhDocs) {
        this.arkhDocs = arkhDocs;
        this.files = new ConcurrentLinkedDeque<>();
    }
    
    public void start() {
        for (int i = 1; i <= THREADS_VERIFIERS; i++) {
            new Thread("ArkhLoad - Verifier " + i) {
                @Override
                public void run() {
                    loadVerifiers();
                }
            }.start();
        }
    }
    
    public void addToVerify(File file) {
        files.add(file);
    }
    
    private void loadVerifiers() {
        while (true) {
            var file = files.pollFirst();
            if (file == null) {
                if (isBaseDoneLoad()) {
                    break;
                } else {
                    WizBase.sleep(100);
                    continue;
                }
            }
            try {
                arkhDocs.arkhBase.sendToListeners("[DOCK] Verifing: " + file.getName());
                if (DockReader.canRead(file)) {
                    loadDocument(file);
                    arkhDocs.arkhBase.sendToListeners("[DOCK] Putted: " + file.getName());
                }
            } catch (Exception e) {
                arkhDocs.arkhBase.sendToListeners("[DOCK] Error: " + e.getMessage());   
            }
        }
    }
    
    private boolean isBaseDoneLoad() {
        return arkhDocs.arkhBase.baseLoad.isDone();
    }
    
    private void loadDocument(File file) throws Exception {
        var folder = file.getParentFile();
        var dockData = arkhDocs.getDockData(folder);
        var lastLoad = dockData.getModifiedByName(file.getName());
        if (lastLoad != null && lastLoad != file.lastModified()) {
            return;
        }
        var source = new DockReader(file).read();
        var parts = SPACER_PATTERN.split(source);
        var words = new HashSet<String>();
        for (var part : parts) {
            if (!part.chars().anyMatch((c) -> !Character.isLetter(c))) {
                words.add(part.toLowerCase());
            }
        }
        dockData.putDock(file.getName(), file.lastModified(), words);
    }
    
    private static final Integer THREADS_VERIFIERS = 8;
    public static final String SPACER_REGEX = "([^\\p{L}\\p{N}])+";
    public static final Pattern SPACER_PATTERN = Pattern.compile(SPACER_REGEX);
    
}
