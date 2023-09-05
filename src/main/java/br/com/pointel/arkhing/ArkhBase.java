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
    
    public final ArkhData arkhData;
    public final ArkhLoad arkhLoad;

    public ArkhBase(File root) throws Exception {
        if (!root.exists() || !root.isDirectory()) {
            throw new Exception("Could not find the root directory.");
        }
        this.root = root;
        this.rootLength = this.root.getAbsolutePath().length();
        this.arkhData = new ArkhData(this);
        this.arkhLoad = new ArkhLoad(this);
    }
    
    public ArkhBase load() throws Exception {
        this.arkhLoad.start();
        return this;
    }
    
    public String getPlace(File file) {
        return file.getAbsolutePath().substring(this.rootLength);
    }

    @Override
    public void close() throws IOException {
        this.arkhLoad.stop();
        this.arkhData.close();
    }
    
}
