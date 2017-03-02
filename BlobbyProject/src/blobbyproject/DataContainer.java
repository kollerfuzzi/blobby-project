/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbyproject;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Set;

/**
 *
 * @author koller
 */
public class DataContainer {
    private Blobby player1;
    private Blobby player2;
    private Set<Integer> keys;
    
    public DataContainer(Set<Integer> keys, Dimension dim) {
        player1 = new Blobby(Blobby.Side.LEFT, dim);
        player2 = new Blobby(Blobby.Side.RIGHT, dim);
        this.keys = keys;
    }
    
    /**
     * Draws the Game to a graphics context
     * @param g Graphics context
     */
    private void draw(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
    }
    
    /**
     * Updates the game
     */
    private void update() {
        
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
