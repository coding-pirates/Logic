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

    /**
     * Constructor of the class Point2D
     * @param x x-coordinate of the point
     * @param y y-coordinate of the point
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the x-coordinate of the point
     * @return {@link #x}
     */
    public int getX() {
        return x;
    }

    /**
     * Return the y-coordinate of the point
     * @return {@link #y}
     */
    public int getY() {
        return y;
    }

    /**
     * Set new point with coordinates of the old point and differences for x and y coordinates
     * @param x difference to new x-coordinate
     * @param y difference to new y-coordinate
     * @return new {@link Point2D}
     */
    public Point2D getPointWithOffset(int x, int y) {
        return new Point2D(this.x + x, this.y + y);
    }

    /**
     * Set new point with coordinates of the old point and add coordinates of a given new point
     * @param point new point, which coordinates are added to the coordinates of the old point
     * @return new {@link Point2D}
     */
    public Point2D getPointWithOffset(Point2D point) {
        return new Point2D(this.x + point.x, this.y + point.y);
    }

    /**
     * Return Point coordinates in a String
     * @return {@link String} of this point
     */
    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }

    /**
     * Compares own coordinates with coordinates of given Point
     * @param obj Point, with which should this point compared with
     * @return {@link Boolean #true} if the points habe equal coordinates,
     * {@link Boolean #false} if the points have different coordinates
     */
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
