/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbyproject;

import gameobjects.Blobby;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.util.Set;

/**
 *
 * @author koller
 */
public class Game {
    private Blobby player1;
    private Blobby player2;
    private final Set<Integer> keys;
    private Dimension dim;
    
    public Game(Set<Integer> keys, Dimension dim) {
        player1 = new Blobby(Blobby.Side.LEFT, dim);
        player2 = new Blobby(Blobby.Side.RIGHT, dim);
        this.keys = keys;
        this.dim = dim;
    }
    
    /**
     * Updates the game
     */
    public void update() {
        keyCtl(player1, keys.contains(KeyEvent.VK_UP), 
                keys.contains(KeyEvent.VK_DOWN), 
                keys.contains(KeyEvent.VK_LEFT),
                keys.contains(KeyEvent.VK_RIGHT));
        keyCtl(player2, keys.contains(KeyEvent.VK_W), 
                keys.contains(KeyEvent.VK_S), 
                keys.contains(KeyEvent.VK_A),
                keys.contains(KeyEvent.VK_D));
    }
    
    /**
     * 
     * @param blob
     * @param up
     * @param down
     * @param right
     * @param left 
     */
    private void keyCtl(Blobby blob, 
            boolean up, boolean down, boolean left, boolean right) {
        blob.getMoveVector().setX(0);
        if(left) {
            blob.getMoveVector().add(Blobby.ACCEL.inverted());
        } 
        if (right) {
            blob.getMoveVector().add(Blobby.ACCEL);
        }
        if(up) {
            blob.jump();
        }
        blob.update();
    }
    
    /**
     * Draws the game to a graphics context
     * @param g 
     */
    public void draw(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, (int)dim.getWidth(), (int)dim.getHeight());
        player1.draw(g);
        player2.draw(g);
    }
    
    public Blobby getPlayer1() {
        return player1;
    }

    public void setPlayer1(Blobby player1) {
        this.player1 = player1;
    }

    public Blobby getPlayer2() {
        return player2;
    }

    public void setPlayer2(Blobby player2) {
        this.player2 = player2;
    }
    
    
}
