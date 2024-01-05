package br.com.pointel.arkhing;

import java.io.File;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 *
 * @author emuvi
 */
public class ArkhDocsLoad {
    
    private final ArkhDocs arkhDocs;

    private final Deque<File> files;

    public ArkhDocsLoad(ArkhDocs arkhDocs) {
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
    
    private void loadDocument(File file) {
        var fileFolder = file.getParentFile();
    }
    
    private static final Integer THREADS_VERIFIERS = 8;
    
}
