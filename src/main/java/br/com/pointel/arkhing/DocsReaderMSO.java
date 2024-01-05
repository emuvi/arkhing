package br.com.pointel.arkhing;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.extractor.SlideShowExtractor;
import org.apache.poi.sl.usermodel.SlideShowFactory;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author emuvi
 */
public class DocsReaderMSO {
    
    public static boolean canRead(File file) {
        return DocsReaderMSOUtils.isMSWordFile(file)
                || DocsReaderMSOUtils.isMSExcelFile(file)
                || DocsReaderMSOUtils.isMSPowerPointFile(file);
    }
    

    private final File path;

    public DocsReaderMSO(File path) {
        this.path = path;
    }

    public String read() throws Exception {
        if (DocsReaderMSOUtils.isMSWordFile(path)) {
            return extractTextFromWord();
        } else if (DocsReaderMSOUtils.isMSExcelFile(path)) {
            return extractTextFromExcel();
        } else if (DocsReaderMSOUtils.isMSPowerPointFile(path)) {
            return extractTextFromPowerPoint();
        } else {
            throw new Exception("File type not expected: " + path.getName());
        }
    }

    private String extractTextFromWord() throws Exception {
        try (var fis = new FileInputStream(path)) {
            try (var document = new XWPFDocument(fis)) {
                var extractor = new XWPFWordExtractor(document);
                return extractor.getText();
            }
        }
    }

    private String extractTextFromExcel() throws Exception {
        try (var fis = new FileInputStream(path)) {
            try (var workBook = new HSSFWorkbook(new POIFSFileSystem(fis))) {
                var extractor = new ExcelExtractor(workBook);
                extractor.setFormulasNotResults(false);
                extractor.setIncludeSheetNames(true);
                return extractor.getText();
            }
        }
    }

    private String extractTextFromPowerPoint() throws Exception {
        try (var fis = new FileInputStream(path)) {
            try (var slideShow = SlideShowFactory.create(fis)) {
                var extractor = new SlideShowExtractor(slideShow);
                extractor.setMasterByDefault(true);
                extractor.setSlidesByDefault(true);
                extractor.setNotesByDefault(true);
                extractor.setCommentsByDefault(true);
                return extractor.getText();
            }
        }
    }

}
