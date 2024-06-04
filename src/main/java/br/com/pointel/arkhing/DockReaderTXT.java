package br.com.pointel.arkhing;

import java.io.File;
import java.nio.file.Files;
import org.apache.commons.io.FilenameUtils;

public class DockReaderTXT {
    
    public static boolean canRead(File file) {
        return DockReaderTXTUtils.isTXTFile(file);
    }
    
    private final File file;

    public DockReaderTXT(File file) {
        this.file = file;
    }

    public String read() throws Exception {
        return Files.readString(file.toPath());
    }

}
