/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 *
 * @author koller
 */
public final class Blobby {

    public static enum Side {
        LEFT, RIGHT
    };

    private double radius = 50;
    private final Vector moveVector = new Vector(0, 0);
    private final Vector posVector = new Vector(0, 0);
    public static final Vector GRAVITY = new Vector(0, 2);
    public static final Vector ACCEL = new Vector(12, 0);

    private Dimension size;
    private Side side;

    /**
     * Creates a new Blobby
     *
     * @param side can either be LEFT or RIGHT
     * @param dim dimension of the field (panel)
     */
    public Blobby(Side side, Dimension dim) {
        this.side = side;
        this.size = dim;
        resetPosition();
    }

    /**
     * resets the position to the default position of the Blobby, based on the
     * side
     */
    public void resetPosition() {
        if (side == Side.LEFT) {
            posVector.setX(size.width / 2 - size.width / 4);
        } else if (side == Side.RIGHT) {
            posVector.setX(size.width / 2 + size.width / 4);
        }
        posVector.setY(size.height - 30);
    }

    /**
     * Draws the Blobby to a graphics context.
     *
     * @param g Graphics context
     */
    public void draw(Graphics2D g) {
        g.drawLine(400, 0, 400, 600);
        int size = 50;
        g.setColor(Color.red);
        g.fillOval((int) (posVector.getX() - size), (int) (posVector.getY() - size),
                (int) (size), (int) (size));
    }

    public void update() {
        if (posVector.getY() <= 550) {
            this.moveVector.add(GRAVITY);
        } else if(this.moveVector.getY() > 0 && posVector.getY() >= 400) {
            this.moveVector.setY(0);
        }
        this.posVector.add(moveVector);
    }

    public void jump() {
        if (posVector.getY() >= 550) {
            this.moveVector.add(new Vector(0, -35));
        }
    }

    public Dimension getWidth() {
        return size;
    }

    public void setWidth(Dimension width) {
        this.size = width;
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

    public Vector getMoveVector() {
        return moveVector;
    }

    public Vector getPosVector() {
        return posVector;
    }

}
