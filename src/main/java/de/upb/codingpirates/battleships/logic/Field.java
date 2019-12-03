package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Field {
    private static final Logger LOGGER = LogManager.getLogger();

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
     * @return {@link HitType#NONE} if no ship exists, {@link HitType#HIT} if a ship got hit, {@link HitType#SUNK} if a ship got hit and not remaining parts are left, {@link HitType#FAIL} if the point is not in the field
     */
    public HitType hit(Point2D point) {
        if (point.getX() > width || point.getY() > height)
            return HitType.FAIL;
        if (field.contains(point.getX(), point.getY())){
            Ship ship = field.remove(point.getX(), point.getY());
            if (ship == null)
                return HitType.NONE;
            if (ship.hit(point))
                return HitType.SUNK;
            return HitType.HIT;
        }
        return HitType.NONE;
    }

    /**
     * turns a {@link ShipType} with relative positions into a ship with absolute positions. Places the ship at the absolute positions to {@link #field} and returns the ship.
     */
    public Ship placeShip(ShipType ship, PlacementInfo placementInfo) {
        Collection<Point2D> positions = ship.getPositions().stream().map(point2D -> point2D.getPointWithOffset(placementInfo.getPosition())).collect(Collectors.toList());
        LOGGER.debug("placeship"+positions);
        int square_length = getSquareLength(positions);
        //System.out.println("quadratlänge"+square_length);
        HashBasedTable<Integer, Integer, Point2D> square = createSquare(square_length, positions);
        //System.out.println("in placeship  square"+square.isEmpty());
        if (checkPositions(square_length, placementInfo.getPosition())){
            //System.out.println("In if in placeShip");
            square = rotate(square_length, placementInfo.getRotation().ordinal(), square);
            //System.out.println("in placeship  square"+square.isEmpty());
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
        int maxX=0, minX = 1000000000;
        int maxY=0, minY = 1000000000;
        for (Iterator it = positions.iterator(); it.hasNext(); ){
            Point2D point = (Point2D) it.next();
            minX = Math.min(minX, point.getX());
            minY = Math.min(minY, point.getY());
            maxX = Math.max(maxX, point.getX());
            maxY = Math.max(maxY, point.getY());
        }
        LOGGER.debug("max"+maxX+""+ maxY);
        //Ship to (0,0)
        for (Point2D p: positions){
            p.setX(p.getX()-minX);
            p.setY(p.getY()-minY);
        }
        return Math.max(maxX-minX, maxY-minY)+1; //+1 for the Element with index 0
    }

    /**
     * @param length length of the square
     * @param positions position of the ship
     * creates square around ship
     * @return HashBasedTable for each position (x,y,Point2D)-ship or (x,y,null)-no ship
     **/
    private  HashBasedTable<Integer, Integer, Point2D> createSquare(int length, Collection<Point2D> positions){
        HashBasedTable<Integer, Integer, Point2D> table = HashBasedTable.create();
        //System.out.println("in createsquare  square länge "+ length);
        for (int x=0; x<length+1; x++){
            for (int y=0; y<length+1;y++){
                //boolean found = false;
                for (Point2D p: positions){
                    if (p.getX() == x && p.getY() == y){
                        //found = true;
                        //System.out.println("in createsquare  square"+p.getX()+p.getY());
                        table.put(x,y,p);
                        break;
                    }}
            }
        }
        //System.out.println("in createsquare  square"+table.isEmpty());
        LOGGER.debug("createquare"+table);
        return table;
    }

    /**
     * checks if the ship fit at this position in the field
     */
    private boolean checkPositions(int length, Point2D point){
        //System.out.println("in checkPositions"+"x:"+point.getX()+"länge"+length+"breite"+width+"y"+ point.getY()+"länge"+length);
        //System.out.println((point.getX()+length<=width && point.getY()-length>=0));
        return (point.getX()+length<=width && point.getY()-length>=0);
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
        LOGGER.debug("rotate table");
        for (int r = rotation; r>0; r--){
            tableRotated = rotate90(length, tableRotated);
        }
        LOGGER.debug("finish rotate");
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
        LOGGER.debug("rotated"+tableRotated);
        return tableRotated;
    }

    /**
     * @param point startingpoint (left, upper)
     * @param table coordinates of the ship
     * @param length length of the square
     * place the ship in the field, at the correct positions
     */
    private Ship fillField(Point2D point, HashBasedTable<Integer, Integer, Point2D> table, int length, ShipType type){
        Ship ship = new Ship(type, table.values());
        //System.out.println("in fillField");
        LOGGER.debug("in fillField");
        //System.out.println("in fillField2+table"+table.isEmpty());
        for (int x=0; x<length;x++) {
            for (int y = 0; y < length; y++) {
                Point2D shipPoint = table.get(x,y);
                //System.out.println("in fillField:"+shipPoint==null);
                if (shipPoint != null){
                    //System.out.print(1);
                    field.put(point.getY()+shipPoint.getY(),point.getX()+shipPoint.getX(), ship);
                }
            }
        }
        LOGGER.debug("end fillfield"+field);
        return ship;
    }

    public Table<Integer, Integer, Ship> getField() {
        return field;
    }
}
