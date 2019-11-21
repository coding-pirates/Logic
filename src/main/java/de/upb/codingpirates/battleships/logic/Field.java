package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Field {
    private int height;
    private int width;
    private Table<Integer, Integer, Ship> field;

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
        this.field = HashBasedTable.create();
    }

    /**
     * if ship exists at point the ship gets hit and removed from {@link #field}
     *
     * @param point
     * @return {@link HitType#NONE} if no ship exists, {@link HitType#HIT} if a ship got hit, {@link HitType#SUNK} if a ship got hit and not remaining parts are left, {@link HitType#FAIL} if the point is not in the field
     */
    public HitType hit(Point2D point) {//TODO
        return HitType.NONE;
    }

    public Ship placeShip(ShipType ship, PlacementInfo placementInfo) {
        return null;
    }
}
