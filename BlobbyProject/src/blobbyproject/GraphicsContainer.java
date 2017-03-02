/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbyproject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author alex
 */
public class GraphicsContainer {
    private BufferedImage image;
    private Graphics g2;
    private Dimension dim;
    public GraphicsContainer(Dimension dim) {
        this.dim = dim;
        this. image = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_RGB);
        g2 = image.getGraphics();
    }
    
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Graphics getG2() {
        return g2;
    }

    public void setG2(Graphics g2) {
        this.g2 = g2;
    }

    
}
