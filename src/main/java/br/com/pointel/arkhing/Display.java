package br.com.pointel.arkhing;

import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class Display {

    private final GraphicsDevice device;

    public Display(GraphicsDevice device) {
        this.device = device;
    }

    public Rectangle getBounds() {
        return device.getDefaultConfiguration().getBounds();
    }
    
    public BufferedImage capture() throws Exception {
        return new Robot().createScreenCapture(getBounds());
    }

    @Override
    public String toString() {
        return device.getIDstring();
    }
    
}
