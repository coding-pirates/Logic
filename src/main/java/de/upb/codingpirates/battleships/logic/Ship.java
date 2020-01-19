package de.upb.codingpirates.battleships.logic;

import java.util.Collection;

/**
 * Represents one Ship
 *
 * @author
 */
public class Ship {

    /**
     * type of the ship
     */
    private ShipType shipType;
    /**
     * every point of the ship, which is not hit yet
     */
    private Collection<Point2D> leftShipParts;

    /**
     * Constructor of the class Ship
     * @param type type of the ship
     * @param positions every single part of the ship as Collection with {@link Point2D}
     */
    public Ship(ShipType type, Collection<Point2D> positions) {
        this.leftShipParts = positions;
        this.shipType = type;
    }

    public Ship(ShipType shipType) {
    }

    /**
     * removes point from {@link #leftShipParts}
     *
     * @return if {@link #leftShipParts} is empty returns true
     */
    public boolean hit(Point2D point) {
        this.leftShipParts.remove(point);
        return leftShipParts.isEmpty();
    }

    /**
     * Return type of the ship
     * @return {@link #shipType}
     */
    public ShipType getShipType() {
        return shipType;
    }
}
