package br.com.pointel.arkhing;

import java.io.File;
import org.apache.commons.io.FilenameUtils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class DocsReaderPDF {
    
    public static boolean canRead(File file) {
        return DocsReaderPDFUtils.isPDFFile(file);
    }
    
    private final File file;

    public DocsReaderPDF(File file) {
        this.file = file;
    }

    public String read() throws Exception {
        try (var doc = PDDocument.load(file)) {
            var stripper = new PDFTextStripper();
            stripper.setStartPage(1);
            stripper.setEndPage(doc.getNumberOfPages());
            return stripper.getText(doc);
        }
    }
}