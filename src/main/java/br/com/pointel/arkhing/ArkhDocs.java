package br.com.pointel.arkhing;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author emuvi
 */
public class ArkhDocs {
    
    public final ArkhBase arkhBase;
    public final ArkhDocsLoad docsLoad;
    
    private final Map<File, ArkhDocsData> arkhDocsDatas;

    public ArkhDocs(ArkhBase arkhBase) {
        this.arkhBase = arkhBase;
        this.arkhDocsDatas = new HashMap<>();
        this.docsLoad = new ArkhDocsLoad(this);
        this.docsLoad.start();
    }
    
    public void addToVerify(File file) {
        docsLoad.addToVerify(file);
    }
    
    public ArkhDocsData getDocsData(File folder) throws Exception {
        synchronized (this.arkhDocsDatas) {
            if (this.arkhDocsDatas.containsKey(folder)) {
                return this.arkhDocsDatas.get(folder);
            } else {
                var arkhDocsData = new ArkhDocsData(this, folder);
                this.arkhDocsDatas.put(folder, arkhDocsData);
                return arkhDocsData;
            }
        }
    }
    
}
