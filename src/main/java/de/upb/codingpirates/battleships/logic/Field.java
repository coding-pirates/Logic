package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import de.upb.codingpirates.battleships.logic.util.LogicMarker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Iterator;

public class Field {
    private static final Logger LOGGER = LogManager.getLogger();

    private int height;
    private int width;
    private Table<Integer, Integer, Ship> field;
    private int clientId;

    public Field(int height, int width, int clientId) {
        this.height = height;
        this.width = width;
        this.field = HashBasedTable.create();
        this.clientId = clientId;
    }

    /**
     * if ship exists at shot the ship gets hit and removed from {@link #field}
     *
     * @return {@link HitType#NONE} if no ship exists, {@link HitType#HIT} if a ship got hit, {@link HitType#SUNK} if a ship got hit and not remaining parts are left, {@link HitType#FAIL} if the shot is not in the field
     */
    public ShotHit hit(Shot shot) {
        LOGGER.debug(LogicMarker.SHOTSPLACEMENT,"Shot at {}, for clientId {}",shot.getTargetField(), shot.getClientId());
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
    public Ship placeShip(ShipType ship, PlacementInfo placementInfo) {
        Collection<Point2D> positions = ship.getPositions();
        LOGGER.debug(LogicMarker.SHIPPLACEMENT,"Place ship at {} for player {}",positions,clientId);
        int square_length = getSquareLength(positions);
        HashBasedTable<Integer, Integer, Point2D> square = createSquare(square_length, positions);
        if (checkPositions(square_length, placementInfo.getPosition())){
            square = rotate(square_length, placementInfo.getRotation().ordinal(), square);
            return fillField(placementInfo.getPosition(), square, square_length, ship);
        } else{
            return null;
        }
    }

    /**
     * @param  positions Collection with points of one ship
     * @return int length für square
     */
    private int getSquareLength(Collection<Point2D> positions){
        int maxX=0;
        int maxY=0;
        for (Iterator it = positions.iterator(); it.hasNext(); ){
            Point2D point = (Point2D) it.next();
            maxX = Math.max(maxX, point.getX());
            maxY = Math.max(maxY, point.getY());
        }
        LOGGER.debug(LogicMarker.SHIPPLACEMENT,"Max ship size: {}, {}",maxX, maxY);
        return Math.max(maxX+1, maxY+1); //+1 für das Element mit Index 0
    }

    /**
     * @param length length of the square
     * @param positions position of the ship
     * creates square around ship
     * @return HashBasedTable for each position (x,y,Point2D)-ship or (x,y,null)-no ship
     **/
    private  HashBasedTable<Integer, Integer, Point2D> createSquare(int length, Collection<Point2D> positions){
        HashBasedTable<Integer, Integer, Point2D> table = HashBasedTable.create();
        for (int x=0; x<length+1; x++){
            for (int y=0; y<length+1;y++){
                boolean found = false;
                for (Point2D p: positions){
                    if (p.getX() == x && p.getY() == y){
                        found = true;
                        table.put(x,y,p);
                        break;
                    }}
            }
        }
//        LOGGER.debug("createquare"+table);
        return table;
    }

    /**
     * checks if the ship fit at this position in the field
     */
    private boolean checkPositions(int length, Point2D point){
        return point.getX()>= 0 && point.getY() >= 0 && point.getX()+length< width && point.getY()+length < height;
    }

    /**
     * @param length length of the square
     * @param rotation 0=0°, 1=90°, 2=180°, 3=270°
     * @param table square around ship
     * rotate square with the right angle
     * @return HashBasedTable for each position (x,y,Point2D)-ship or (x,y,null)-no ship
     */
    private HashBasedTable<Integer, Integer, Point2D> rotate (int length, int rotation, HashBasedTable<Integer, Integer, Point2D> table){
        HashBasedTable<Integer, Integer, Point2D> tableRotated = HashBasedTable.create(table);
        LOGGER.debug(LogicMarker.SHIPPLACEMENT,"Rotate ship");
        for (int r = rotation; r>0; r--){
            tableRotated = rotate90(length, tableRotated);
        }
        return tableRotated;
    }

    /**@param length length of the square
     * @param table square around ship
     * rotate square with 90°
     * @return HashBasedTable for each position (x,y,Point2D)-ship or (x,y,null)-no ship
     */
    private HashBasedTable<Integer, Integer, Point2D> rotate90 (int length, HashBasedTable<Integer, Integer, Point2D> table){
        HashBasedTable<Integer, Integer, Point2D> tableRotated = HashBasedTable.create();
        int totalColumn = length-1;
        int totalRows= length-1;
        for(int i=0; i<=totalRows; i++){
            for(int j=0; j<=totalColumn;j++){
                if(table.get(i, j)!= null){
                    tableRotated.put(j, totalColumn-i, table.get(i,j));
                }}
        }
        LOGGER.debug(LogicMarker.SHIPPLACEMENT,"Rotated ship");
        return tableRotated;
    }

    /**
     * @param point startingpoint (left, upper)
     * @param table coordinates of the ship
     * @param length length of the square
     * place the ship in the field, at the correct positions
     */
    private Ship fillField(Point2D point, HashBasedTable<Integer, Integer, Point2D> table, int length, ShipType type){
        LOGGER.debug(LogicMarker.SHIPPLACEMENT,"Fill ship to field");
        table.columnMap().forEach((x,map)-> map.replaceAll((y, point1)-> point.getPointWithOffset(x,y)));
        Ship ship = new Ship(type, table.values());
        table.values().forEach(point1 -> field.put(point1.getX(),point1.getY(),ship));
        return ship;
    }
}
