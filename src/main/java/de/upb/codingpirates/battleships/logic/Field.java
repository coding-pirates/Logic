package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import de.upb.codingpirates.battleships.logic.util.LogicMarker;
import de.upb.codingpirates.battleships.logic.util.Rotator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Represents a field of one player
 *
 * @author Interdoc committee, Paul Becker & Carolin Mensendiek
 */
public class Field {
    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * height of the field
     */
    private int height;
    /**
     * width of the field
     */
    private int width;
    /**
     * Table with Index of the Row, Index of the Column, Ship
     */
    private Table<Integer, Integer, Ship> field;
    /**
     * field belongs to the player with this clientID
     */
    private int clientId;

    /**
     * Constructor of the class Field
     * @param height height of the field
     * @param width width of the field
     * @param clientId player's ID to whom the field belongs to
     */
    public Field(int height, int width, int clientId) {
        this.height = height;
        this.width = width;
        this.field = HashBasedTable.create();
        this.clientId = clientId;
    }

    public Table<Integer, Integer, Ship> getField() {
        return field;
    }

    /**
     * if ship exists at shot the ship gets hit and removed from {@link #field}
     *
     * @return {@link HitType#NONE} if no ship exists,
     *         {@link HitType#HIT} if a ship got hit,
     *         {@link HitType#SUNK} if a ship got hit and not remaining parts are left,
     *         {@link HitType#FAIL} if the shot is not in the field
     */
    public ShotHit hit(Shot shot) {
        LOGGER.info(LogicMarker.SHOTS, "Shot at {}, for clientId {}", shot.getTargetField(), shot.getClientId());
        if (shot.getTargetField().getX() > width || shot.getTargetField().getY() > height)
            return new ShotHit(HitType.FAIL);
        if (field.contains(shot.getTargetField().getX(), shot.getTargetField().getY())) {
            Ship ship = field.remove(shot.getTargetField().getX(), shot.getTargetField().getY());
            if (ship == null)
                return new ShotHit(HitType.NONE);
            if (ship.hit(shot.getTargetField()))
                return new ShotHit(ship, shot, HitType.SUNK);
            return new ShotHit(ship, shot, HitType.HIT);
        }
        return new ShotHit(HitType.NONE);
    }


    public Ship placeShip(ShipType shiptype, PlacementInfo placementInfo) {
        Rotator rotator = new Rotator();
        ArrayList<Point2D> shipPositions = new ArrayList<>();
        ArrayList<ArrayList<Point2D>> rotatedShipPositions = rotator.rotateShips((ArrayList<Point2D>)shiptype.getPositions());
        if (placementInfo.getRotation() == Rotation.NONE){
            for (Point2D p : rotatedShipPositions.get(0)){
            shipPositions.add(p);
            }
        }
        else if (placementInfo.getRotation() == Rotation.CLOCKWISE_90){
            for (Point2D p : rotatedShipPositions.get(3)){
                shipPositions.add(p);
            }
        }
        else if (placementInfo.getRotation() == Rotation.CLOCKWISE_180){
            for (Point2D p : rotatedShipPositions.get(2)){
                shipPositions.add(p);
            }
        }
        else if (placementInfo.getRotation() == Rotation.COUNTERCLOCKWISE_90){
            for (Point2D p : rotatedShipPositions.get(1)){
                shipPositions.add(p);
            }
        }
        ArrayList<Point2D> positionsOnField = new ArrayList<>();
        for (Point2D p : shipPositions){
            positionsOnField.add(new Point2D(p.getX()+placementInfo.getPosition().getX(), p.getY()+placementInfo.getPosition().getY()));
        }
        Ship shipWithPositionsOnField = new Ship(shiptype, positionsOnField);
        positionsOnField.forEach(x -> field.put(x.getX(),x.getY(),shipWithPositionsOnField));
        return shipWithPositionsOnField;
    }
}
