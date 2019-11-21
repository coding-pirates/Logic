package de.upb.codingpirates.battleships.logic;

import java.util.List;

public class Ship {

    private List<Point2D> positions;

    public Ship(List<Point2D> positions) {
        this.positions = positions;
    }

    /**
     * removes point from {@link #positions}
     *
     * @param point
     * @return if {@link #positions} is empty returns true
     */
    public boolean hit(Point2D point) {//TODO
        return false;
    }
}
