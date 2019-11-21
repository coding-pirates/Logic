package de.upb.codingpirates.battleships.logic;

import java.util.Collection;
import java.util.List;

public class Ship {

    private ShipType shipType;
    private Collection<Point2D> positions;

    public Ship(ShipType type) {
        this.positions = type.getPosition();
        this.shipType = type;
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

    public ShipType getShipType() {
        return shipType;
    }
}
