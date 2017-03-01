/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbyproject;

import java.awt.Graphics2D;

/**
 *
 * @author koller
 */
public class Blobby {

    public static enum Side {
        LEFT, RIGHT
    };

    private double posX;
    private double posY;
    private double radius = 50;
    private double speed = 3;

    private int width;
    private Side side;

    /**
     * Creates a new Blobby
     *
     * @param side can either be LEFT or RIGHT
     * @param width width of the field (panel)
     */
    public Blobby(Side side, int width) {
        this.side = side;
    }

    /**
     * resets the position to the default position of the Blobby, based on the
     * side
     */
    public void resetPosition() {
        if (side == Side.LEFT) {
            posX = width / 2 - width / 4;
        } else if (side == Side.RIGHT) {
            posX = width / 2 + width / 4;
        }
    }

    /**
     * Draws the Blobby to a graphics context.
     *
     * @param g Graphics context
     */
    public void draw(Graphics2D g) {

    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
