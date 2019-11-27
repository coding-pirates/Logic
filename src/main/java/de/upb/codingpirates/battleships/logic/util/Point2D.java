package de.upb.codingpirates.battleships.logic.util;

/**
 * Represents a point in a two-dimensional coordinate system
 *
 * @author Interdoc committee
 * @author Paul Becker
 * @author Andre Blanke
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

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Point2D))
            return false;
        final Point2D other = (Point2D) object;

        return (other.getX() == getX()) && (other.getY() == getY());
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
