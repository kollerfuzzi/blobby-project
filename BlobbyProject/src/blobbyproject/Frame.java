/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbyproject;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;

/**
 *
 * @author koller
 */
public class Frame extends JFrame implements KeyListener {
    
    private final Set<Integer> keys = new HashSet<>();
    private DataContainer cont = null;

    public Frame() {
    }
    
    /**
     * inits the JFrame: size etc.
     */
    public void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.addKeyListener(this);
        cont = new DataContainer(keys, this.getSize());
        UpdateFrame uf = new UpdateFrame(getBufferStrategy());
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.remove(e.getKeyCode());
    }
    
    
}
