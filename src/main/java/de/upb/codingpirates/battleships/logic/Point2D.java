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

    public Point2D north(){
        Point2D upperPoint = new Point2D(this.getX(), this.getY()+1);
        return upperPoint;
    }

    public Point2D west(){
        Point2D leftPoint = new Point2D(this.getX()-1, this.getY());
        return leftPoint;
    }

    public Point2D south(){
        Point2D lowerPoint = new Point2D(this.getX(), this.getY()-1);
        return lowerPoint;
    }

    public Point2D east(){
        Point2D rightPoint = new Point2D(this.getX()+1, this.getY());
        return rightPoint;
    }

    public Point2D getPointWithOffset(int x, int y){
        return new Point2D(this.x + x, this.y + y);
    }

    public Point2D getPointWithOffset(Point2D point){
        return new Point2D(this.x + point.x, this.y + point.y);
    }

    @Override
    public String toString() {
        return "[ " + this.x + ", "+ this.y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point2D){
            return ((Point2D)obj).x == x && ((Point2D)obj).y == y;
        }
        return false;
    }
}
