/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

/**
 *
 * @author koller
 */
public class Vector {

    private double x;
    private double y;

    /**
     * Creates a 2-Dimensional Vector
     *
     * @param xVal x-value
     * @param yVal y-value
     */
    public Vector(int xVal, int yVal) {
        this.x = xVal;
        this.y = yVal;
    }

    /**
     * Getter for the x-value of the Vector
     * @return the x-value
     */
    public double getX() {
        return this.x;
    }

    /**
     * Getter for the y-value of the Vector
     * @return the y-value
     */
    public double getY() {
        return this.y;
    }

    /**
     * Inverts the Vector's orientation
     * @return copy of the Vector
     */
    public Vector invert() {
        this.x = this.x * (-1);
        this.y = this.y * (-1);
        return this;
    }
    
    /**
     * Calculates the length of the vector
     * @return length of the vector
     */
    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    
    /**
     * Adds 2 Vectors 
     * @param v vector to add
     * @return copy of the Vector
     */
    public Vector add(Vector v) {
        this.x += v.getX();
        this.y += v.getY();
        return this;
    }
}
