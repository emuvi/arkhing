package br.com.pointel.arkhing;

import java.io.File;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

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
                arkhDocs.arkhBase.sendToListeners("{DOCK} Verifing: " + file.getName());
                if (DocsReader.canRead(file)) {
                    loadDocument(file);
                }
            } catch (Exception e) {
                arkhDocs.arkhBase.sendToListeners("{DOCK} [ERROR] Verifing: " + e.getMessage());   
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
        if (lastLoad != null && lastLoad >= file.lastModified()) {
            return;
        }
    }
    
    private static final Integer THREADS_VERIFIERS = 8;
    
}
