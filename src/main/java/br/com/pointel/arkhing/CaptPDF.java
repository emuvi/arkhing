package br.com.pointel.arkhing;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class CaptPDF {

    private final File folder;

    public CaptPDF(File folder) {
        this.folder = folder;
    }

    public void make() throws Exception {
        try (PDDocument document = new PDDocument()) {
            var hasPages = false;
            for (var inside : folder.listFiles()) {
                if (WizImage.isImage(inside)) {
                    addPage(document, inside);
                    hasPages = true;
                }
            }
            if (hasPages) {
                var destiny = new File(folder, "document.pdf");
                destiny.delete();
                document.save(destiny);
            }
        }
    }

    private void addPage(PDDocument inDocument, File fromImageFile) throws Exception {
        PDImageXObject imageItem = PDImageXObject.createFromFileByExtension(fromImageFile, inDocument);
        PDPage newPage = new PDPage(new PDRectangle(imageItem.getWidth(), imageItem.getHeight()));
        inDocument.addPage(newPage);
        try (PDPageContentStream contents = new PDPageContentStream(inDocument, newPage)) {
            contents.drawImage(imageItem, 0, 0);
        }
    }

}
