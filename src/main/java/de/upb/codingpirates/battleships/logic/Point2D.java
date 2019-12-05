package de.upb.codingpirates.battleships.logic;

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

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

    public Point2D getPointWithOffset(int x, int y){
        return new Point2D(this.x + x, this.y + y);
    }

    public Point2D getPointWithOffset(Point2D point){
        return new Point2D(this.x + point.x, this.y + point.y);
    }

    @Override
    public String toString() {
        return "[" + this.x + ", "+ this.y + "]";
    }
}
