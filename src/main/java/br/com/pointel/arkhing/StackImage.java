package br.com.pointel.arkhing;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class StackImage {

    private final List<BufferedImage> images = new ArrayList<>();

    public void stackFromClipboard() throws Exception {
        Transferable content = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if (content == null) {
            throw new Exception("error: nothing found in clipboard");
            
        }
        if (!content.isDataFlavorSupported(DataFlavor.imageFlavor)) {
            throw new Exception("error: no image found in clipbaord");
        }
        BufferedImage image = (BufferedImage) content.getTransferData(DataFlavor.imageFlavor);
        images.add(image);
    }

}
