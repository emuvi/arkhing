package br.com.pointel.arkhing;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    
    public ArkhDockData getDockData(File folder) throws Exception {
        synchronized (this.arkhDocsDatas) {
            if (this.arkhDocsDatas.containsKey(folder)) {
                return this.arkhDocsDatas.get(folder);
            } else {
                var arkhDocsData = new ArkhDockData(folder);
                this.arkhDocsDatas.put(folder, arkhDocsData);
                return arkhDocsData;
            }
        }
    }
    
    public List<ArkhDockData> getAllDockData() throws Exception {
        var result = new ArrayList<ArkhDockData>();
        synchronized (this.arkhDocsDatas) {
            result.addAll(this.arkhDocsDatas.values());
        }
        return result;
    }
    
    public void delDock(File file) throws Exception {
        var folder = file.getParentFile();
        var dockData = getDockData(folder);
        dockData.delDock(file.getName());
    }
    
    public void freeFolder(File folder) throws Exception {
        synchronized (this.arkhDocsDatas) {
            if (this.arkhDocsDatas.containsKey(folder)) {
                this.arkhDocsDatas.get(folder).free();
            }
        }
    }
    
    public void freeAll() throws Exception {
        synchronized (this.arkhDocsDatas) {
            for (var dockData : this.arkhDocsDatas.values()) {
                dockData.free();
            }
        }
    }
    
}
