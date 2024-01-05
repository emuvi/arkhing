package br.com.pointel.arkhing;

import java.io.File;
import java.nio.file.Files;
import org.apache.commons.io.FilenameUtils;

public class DocsReaderTXT {
    
    public static boolean canRead(File file) {
        return DocsReaderTXTUtils.isTXTFile(file);
    }
    
    private final File file;

    public DocsReaderTXT(File file) {
        this.file = file;
    }

    public String read() throws Exception {
        return Files.readString(file.toPath());
    }

}
