package br.com.pointel.arkhing;

import java.awt.image.BufferedImage;

public class WizImage {
       
    public static boolean isSame(BufferedImage imageA, BufferedImage imageB) {
        if (imageA.getWidth() != imageB.getWidth() || imageA.getHeight() != imageB.getHeight()) {
            return false;
        }    
        var total = imageA.getWidth() * imageA.getHeight();
        var diffs = 0;
        for (int x = 0; x < imageA.getWidth(); x++) {
            for (int y = 0; y < imageA.getHeight(); y++) {
                if (imageA.getRGB(x, y) != imageB.getRGB(x, y)) {
                    diffs++;
                }
            }
        }
        var percent = (0.0 + diffs) / total;
        return percent < 0.1;
    }
    
}
