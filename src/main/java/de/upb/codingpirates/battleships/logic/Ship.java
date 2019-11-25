package de.upb.codingpirates.battleships.logic;

import java.util.Collection;

public class Ship {

    private ShipType shipType;
    private Collection<Point2D> positions;

    public Ship(ShipType type, Collection<Point2D> positions) {
        this.positions = positions;
        this.shipType = type;
    }

    /**
     * removes point from {@link #positions}
     *
     * @return if {@link #positions} is empty returns true
     */
    public boolean hit(Point2D point) {
        positions.remove(point);
        return positions.isEmpty();
    }

    public ShipType getShipType() {
        return shipType;
    }
}
