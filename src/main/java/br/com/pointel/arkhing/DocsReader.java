package br.com.pointel.arkhing;

import java.io.File;

public class DocsReader {

    public static boolean canRead(File file) {
        return DocsReaderPDF.canRead(file)
                || DocsReaderMSO.canRead(file)
                || DocsReaderTXT.canRead(file);
    }

    private final File file;

    public DocsReader(File file) {
        this.file = file;
    }

    public String read() throws Exception {
        if (DocsReaderPDF.canRead(file)) {
            return new DocsReaderPDF(file).read();
        } else if (DocsReaderMSO.canRead(file)) {
            return new DocsReaderMSO(file).read();
        } else if (DocsReaderTXT.canRead(file)) {
            return new DocsReaderTXT(file).read();
        } else {
            throw new Exception("Can not read this file type.");
        }
    }

}
