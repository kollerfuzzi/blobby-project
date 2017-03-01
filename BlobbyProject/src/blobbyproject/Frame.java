/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbyproject;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

/**
 *
 * @author koller
 */
public class Frame extends JFrame {

    public Frame() {
        
    }
    
    /**
     * inits the JFrame: size etc.
     */
    public void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setVisible(true);
    }
    
    
    
    /**
     * Draws the 
     * @param g Graphics context
     */
    private void draw(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //code here
    }
    
    /**
     * this Method prints the String "Eichelcasio" to the Console
     */
    public void tolleMethode() {
        System.out.println("Eichelcasio");
    }
    
}
