package de.upb.codingpirates.battleships.logic.util;

/**
 * Represents a point in a two-dimensional coordinate system
 *
 * @author Interdoc committee & Paul Becker
 */
public class Point2D {

    /**
     * x-coordinate of the point
     */
    private int x;
    /**
     * y-coordinate of the point
     */
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
