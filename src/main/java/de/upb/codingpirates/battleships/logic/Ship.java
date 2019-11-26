package de.upb.codingpirates.battleships.logic;

import java.util.Collection;

public class Ship {

    private ShipType shipType;
    private Collection<Point2D> leftShipParts;

    public Ship(ShipType type, Collection<Point2D> positions) {
        this.leftShipParts = positions;
        this.shipType = type;
    }

    /**
     * removes point from {@link #leftShipParts}
     *
     * @return if {@link #leftShipParts} is empty returns true
     */
    public boolean hit(Point2D point) {
        leftShipParts.remove(point);
        return leftShipParts.isEmpty();
    }

    public ShipType getShipType() {
        return shipType;
    }
}
