package de.upb.codingpirates.battleships.logic;

import java.util.Objects;

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

    public Point2D getPointWithOffset(int x, int y) {
        return new Point2D(this.x + x, this.y + y);
    }

    public Point2D getPointWithOffset(Point2D point) {
        return new Point2D(this.x + point.x, this.y + point.y);
    }

    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }

    @Override
    public boolean equals(final Object object) {
        return (object instanceof Point2D) && equals((Point2D) object);
    }

    public boolean equals(final Point2D other) {
        return (other != null) && (getX() == other.getX()) && (getY() == other.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
