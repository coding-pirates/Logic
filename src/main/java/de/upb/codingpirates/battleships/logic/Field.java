package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Collection;

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
        if (field.contains(point.getX(), point.getY())){

        }
        return HitType.NONE;
    }

    public Ship placeShip(ShipType ship, PlacementInfo placementInfo) {
        Collection<Point2D> p = ship.getPositions();
        /*if (rotation == 0)//0Grad gedreht
        {
            for (Iterator it = p.iterator(); it.hasNext(); ){
                    ;
            }
        }
        else //noinspection StatementWithEmptyBody
            if (rotation ==1) //90Grad nach rechts gedreht
        {
            ;
        }
        else if(rotation == 2) //180Grad nach rechts gedreht
        {
            ;
        }
        else //90grad nach links
            {
                ;
        }*/
        return null;
    }
}
