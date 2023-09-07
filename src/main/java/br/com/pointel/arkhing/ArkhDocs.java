package br.com.pointel.arkhing;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 *
 * @author emuvi
 */
public class ArkhDocs {

    private final File path;

    public ArkhDocs(File path) {
        this.path = path;
    }

    public void print() {
        try {
            FileInputStream fis = new FileInputStream(path);
            XWPFDocument document = new XWPFDocument(fis);
            var paragraphs = document.getParagraphs();
            for (int i = 0; i < paragraphs.size(); i++) {
                System.out.println(paragraphs.get(i).getParagraphText());
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
