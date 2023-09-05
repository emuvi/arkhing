package br.com.pointel.arkhing;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author emuvi
 */
public class ArkhBase implements Closeable {
    
    public final File root;
    private final int rootLength;
    
    public final ArkhBaseData baseData;
    public final ArkhBaseLoad baseLoad;

    public ArkhBase(File root) throws Exception {
        if (!root.exists() || !root.isDirectory()) {
            throw new Exception("Could not find the root directory.");
        }
        this.root = root;
        this.rootLength = this.root.getAbsolutePath().length();
        this.baseData = new ArkhBaseData(this);
        this.baseLoad = new ArkhBaseLoad(this);
    }
    
    public ArkhBase load() throws Exception {
        this.baseLoad.start();
        return this;
    }
    
    public String getPlace(File file) {
        return file.getAbsolutePath().substring(this.rootLength);
    }

    @Override
    public void close() throws IOException {
        this.baseLoad.stop();
        this.baseData.close();
    }
    
}
