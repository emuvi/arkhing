package br.com.pointel.arkhing;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author emuvi
 */
public class ArkhDock {
    
    public final ArkhBase arkhBase;
    public final ArkhDockLoad docsLoad;
    
    private final Map<File, ArkhDockData> arkhDocsDatas;

    public ArkhDock(ArkhBase arkhBase) {
        this.arkhBase = arkhBase;
        this.arkhDocsDatas = new HashMap<>();
        this.docsLoad = new ArkhDockLoad(this);
        this.docsLoad.start();
    }
    
    public void addToVerify(File file) {
        docsLoad.addToVerify(file);
    }
    
    public ArkhDockData getDocsData(File folder) throws Exception {
        synchronized (this.arkhDocsDatas) {
            if (this.arkhDocsDatas.containsKey(folder)) {
                return this.arkhDocsDatas.get(folder);
            } else {
                var arkhDocsData = new ArkhDockData(this, folder);
                this.arkhDocsDatas.put(folder, arkhDocsData);
                return arkhDocsData;
            }
        }
    }
    
}
