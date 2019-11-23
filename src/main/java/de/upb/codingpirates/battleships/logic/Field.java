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
     * if ship exists at shot the ship gets hit and removed from {@link #field}
     *
     * @return {@link HitType#NONE} if no ship exists, {@link HitType#HIT} if a ship got hit, {@link HitType#SUNK} if a ship got hit and not remaining parts are left, {@link HitType#FAIL} if the shot is not in the field
     */
    public ShotHit hit(Shot shot) {
        if (shot.getTargetField().getX() > width || shot.getTargetField().getY() > height)
            return new ShotHit(HitType.FAIL);
        if (field.contains(shot.getTargetField().getX(), shot.getTargetField().getY())){
            Ship ship = field.remove(shot.getTargetField().getX(), shot.getTargetField().getY());
            if (ship == null)
                return new ShotHit(HitType.NONE);
            if (ship.hit(shot.getTargetField()))
                return new ShotHit(ship, shot,HitType.SUNK);
            return new ShotHit(ship, shot,HitType.HIT);
        }
        return new ShotHit(HitType.NONE);
    }

    /**
     * turns a {@link ShipType} with relative positions into a ship with absolute positions. Places the ship at the absolute positions to {@link #field} and returns the ship.
     */
    public Ship placeShip(ShipType ship, PlacementInfo placementInfo) {//TODO fill
        Collection<Point2D> positions = ship.getPositions();

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
