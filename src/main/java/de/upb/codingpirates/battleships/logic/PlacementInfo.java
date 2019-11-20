package de.upb.codingpirates.battleships.logic;

public class PlacementInfo {
    private Point2D position;
    private int rotation;

    public PlacementInfo(Point2D position, int rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
}
