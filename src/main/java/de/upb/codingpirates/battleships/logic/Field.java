package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Field {
    private static final Logger LOGGER = Logger.getLogger(Field.class.getName());

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
     * if ship exists at point the ship gets hit and removed from {@link #field}
     *
     * @return {@link HitType#NONE} if no ship exists, {@link HitType#HIT} if a ship got hit, {@link HitType#SUNK} if a ship got hit and not remaining parts are left, {@link HitType#FAIL} if the point is not in the field
     */
    public ShotHit hit(Shot shot) {
        LOGGER.log(Level.INFO,"Shot at "+shot.getTargetField()+", for clientId "+shot.getClientId());
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
        LOGGER.log(Level.INFO,"Place ship at "+positions+" for player "+clientId);
        int square_length = getSquareLength(positions);
        HashBasedTable<Integer, Integer, Point2D> square = createSquare(square_length, positions);
        if (checkPositions(square_length, placementInfo.getPosition())){
            square = rotate(square_length, placementInfo.getRotation().ordinal(), square);
            HashBasedTable<Integer, Integer, Point2D> check = checkPoints(square, square_length);
            if (check != null){
                square = check;
            }
            return fillField(placementInfo.getPosition(), square, square_length, ship);
        } else{
            return null;
        }
    }

    /**
     * checks the table if the first column (column =0) is empty, or the first row (row =0) is empty, then move the point upwards /leftwards
     * @param table with the points of the ship
     * @param length of the square
     * @return the movedTable
     */
    private HashBasedTable<Integer, Integer, Point2D> checkPoints(HashBasedTable<Integer, Integer, Point2D> table, int length){
        HashBasedTable<Integer, Integer, Point2D> newTable = HashBasedTable.create();
        if (table.column(0).isEmpty()){
            for (int row=0; row<length+1; row++){
                for (int col=0; col<length+1; col++){
                            if(table.get(row, col) != null){
                                System.out.println("in checkPoints column");
                                newTable.put(row, col-1, table.get(row, col));
                            }
                        }}
            System.out.println("in checkPoints"+newTable);
        return newTable;
        }
        else if (table.row(0).isEmpty()){
            System.out.println(table.row(0).toString());
            for (int row=0; row<length+1; row++){
                for (int col=0; col<length+1; col++){
                    if(table.get(row, col) != null){
                        System.out.println("in checkPoints row");
                        newTable.put(row-1, col, table.get(row, col));
                    }
                }}
            System.out.println("in checkPoints"+newTable);
            return newTable;
        }

        System.out.println("in checkPoints"+table);
        return table;
        }

    /**
     * @param  positions Collection with points of one ship
     * @return int length für square
     */
    private int getSquareLength(Collection<Point2D> positions){
        int maxColumn=0, minColumn = 1000000000;
        int maxRow=0, minRow = 1000000000;
        for (Iterator it = positions.iterator(); it.hasNext(); ){
            Point2D point = (Point2D) it.next();
            maxColumn = Math.max(maxColumn, point.getX());
            minColumn = Math.min(minColumn, point.getX());
            minRow = Math.min(minRow, point.getY());
            maxRow = Math.max(maxRow, point.getY());
        }
        LOGGER.log(Level.INFO,"max"+maxColumn+""+ maxRow);
        //transform points of ship to (0,0)
        for (Point2D p: positions){
            p.setX(p.getX()-minColumn);
            p.setY(p.getY()-minRow);
        }
        return Math.max(maxColumn-minColumn, maxRow-minRow)+1; //+1 for the Element with index 0
    }

    /**
     * @param length length of the square
     * @param positions position of the ship
     * creates square around ship
     * @return HashBasedTable for each position (x,y,Point2D)-ship or (x,y,null)-no ship
     **/
    private HashBasedTable<Integer, Integer, Point2D> createSquare(int length, Collection<Point2D> positions){
        HashBasedTable<Integer, Integer, Point2D> table = HashBasedTable.create();
        //System.out.println("in createsquare  square länge"+ length);
        for (int row=0; row<length+1; row++){
            for (int col=0; col<length+1; col++){
                for (Point2D p: positions){
                    if (p.getX() == row && p.getY() == col){
                        //System.out.println("in createsquare  square"+p.getX()+p.getY());
                        table.put(row,col,p);
                        break;
                    }}
            }
        }
        //System.out.println("in createsquare  square"+table.isEmpty());
        LOGGER.log(Level.INFO, "createquare"+table);
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
        LOGGER.log(Level.INFO,"rotate table");
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
        for(int j=0; j<=totalRows;j++){
            for(int i=0; i<=totalColumn; i++){
                if(table.get(j,i) != null){
                    tableRotated.put(i, length-1-j, table.get(j,i));
                }}
        }
        LOGGER.log(Level.INFO,"rotated"+tableRotated);
        return tableRotated;
    }

    /**
     * @param point startingpoint (left, upper)
     * @param table coordinates of the ship
     * @param length length of the square
     * place the ship in the field, at the correct positions
     */
    private Ship fillField(Point2D point, HashBasedTable<Integer, Integer, Point2D> table, int length, ShipType type){
        LOGGER.log(Level.INFO,"Fill ship to field");
        table.columnMap().forEach((x,map)-> map.replaceAll((y, point1)-> point.getPointWithOffset(x,y)));
        Ship ship = new Ship(type, table.values());
        System.out.println("in fillField"+point.toString());
        LOGGER.log(Level. INFO,"in fillField");
        //System.out.println("in fillField2+table"+table.isEmpty());
        if (table.get(0,0)!= null) {
            for (int row = 0; row < length; row++) {
                for (int col = 0; col < length; col++) {
                    Point2D shipPoint = table.get(row, col);
                    //System.out.println("in fillField:"+shipPoint==null);
                    if (shipPoint != null) {
                        System.out.println("found shippoint" + shipPoint.toString());
                        field.put(point.getX() + row, point.getY() + col, ship);
                    }
                }
            }
        }
        else {
            Map<Integer, Point2D> tableRow = table.row(0);
            //System.out.println("in else"+tableRow.isEmpty());
            int min = (int) Collections.min(tableRow.keySet());
            HashBasedTable<Integer, Integer, Point2D> movedTable = HashBasedTable.create();
            for (int row = 0; row < length; row++) {
                for (int col = 0; col < length; col++) {
                    if(table.get(row, col) != null){
                    movedTable.put(row, col-min, table.get(row, col));
                }}
            }
            System.out.println(movedTable.toString());
            for (int r = 0; r < length; r++) {
                int minKeyRows =  Collections.min(movedTable.row(r).keySet());
                //System.out.println(minKeyRows);
                //System.out.println("in movedTable1"+movedTable.row(r).keySet()+"row"+r);
                while(minKeyRows<0){
                    //System.out.println("in movedTable"+minKeyRows);
                    field.put(point.getX() + r, (int) (point.getY() + minKeyRows), ship);
                    movedTable.remove(r, minKeyRows);
                    minKeyRows = (int) Collections.min(table.row(r).keySet());
                }
                for (int col = 0; col < length; col++) {
                    Point2D shipPoint = movedTable.get(r, col);
                    //System.out.println("in fillField:"+shipPoint==null);
                    if (shipPoint != null) {
                        //System.out.println("found shippoint" + movedTable.toString());
                        field.put(point.getX() + r, (int) (point.getY() + col), ship);
                    }
                }
            }
        }
        LOGGER.log(Level.INFO,"end fillfield"+field);
        table.values().forEach(point1 -> field.put(point1.getX(),point1.getY(),ship));
        return ship;
    }

    public Table<Integer, Integer, Ship> getField() {
        return field;
    }
}
