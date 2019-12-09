package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Represents a field for a player
 *
 * @author Carolin Mensendiek & Leonie Lender
 */
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
        LOGGER.info("Shot at {}, for clientId {}", shot.getTargetField(), shot.getClientId());
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

    /**
     * turns a {@link ShipType} with relative positions into a ship with absolute positions. Places the ship at the absolute positions to {@link #field} and returns the ship.
     */
    public Ship placeShip(ShipType ship, PlacementInfo placementInfo) {
        List<Point2D> positions = Lists.newArrayList(ship.getPositions());
        LOGGER.info("Place shipType with {} for player {}", positions, clientId);
        int square_length = getSquareLength(positions);
        HashBasedTable<Integer, Integer, Point2D> square = createSquare(square_length, positions);
        if (checkPositions(square_length, placementInfo.getPosition())) {
            square = rotate(square_length, placementInfo.getRotation().ordinal(), square);
            square = checkPoints(square, square_length);
            return fillField(placementInfo.getPosition(), square, square_length, ship);
        } else {
            return null;
        }
    }

    /**
     * checks the table if the first column (column =0) is empty, or the first row (row =0) is empty, then move the point upwards /leftwards
     *
     * @param table  with the points of the ship
     * @param length of the square
     * @return the movedTable
     */
    private HashBasedTable<Integer, Integer, Point2D> checkPoints(HashBasedTable<Integer, Integer, Point2D> table, int length) {
        HashBasedTable<Integer, Integer, Point2D> newTable = HashBasedTable.create();
        if (table.column(0).isEmpty()) {
            for (int row = 0; row < length + 1; row++) {
                for (int col = 0; col < length + 1; col++) {
                    if (table.get(row, col) != null) {
                        LOGGER.debug("in checkPoints column");
                        newTable.put(row, col - 1, table.get(row, col));
                    }
                }
            }
            LOGGER.debug("in checkPoints {}",newTable);
            return newTable;
        } else if (table.row(0).isEmpty()) {
            System.out.println(table.row(0).toString());
            for (int row = 0; row < length + 1; row++) {
                for (int col = 0; col < length + 1; col++) {
                    if (table.get(row, col) != null) {
                        LOGGER.debug("in checkPoints row");
                        newTable.put(row - 1, col, table.get(row, col));
                    }
                }
            }
            LOGGER.debug("in checkPoints {}", newTable);
            return newTable;
        }

        LOGGER.debug("in checkPoints {}", table);
        return table;
    }

    /**
     * @param positions Collection with points of one ship
     * @return int length für square
     */
    private int getSquareLength(List<Point2D> positions) {
        int maxColumn = 0, minColumn = Integer.MAX_VALUE;
        int maxRow = 0, minRow = Integer.MAX_VALUE;
        for (Point2D point : positions) {
            maxColumn = Math.max(maxColumn, point.getX());
            minColumn = Math.min(minColumn, point.getX());
            minRow = Math.min(minRow, point.getY());
            maxRow = Math.max(maxRow, point.getY());
        }
        LOGGER.debug("Max ship size: {}, {}", maxColumn, maxRow);
        //transform points of ship to (0,0)
        int finalMinColumn = minColumn;
        int finalMinRow = minRow;
        positions.replaceAll(point2D -> point2D.getPointWithOffset(point2D.getX() - finalMinColumn, point2D.getY() - finalMinRow));
        return Math.max(maxColumn - minColumn, maxRow - minRow) + 1; //+1 for the Element with index 0
    }

    /**
     * @param length    length of the square
     * @param positions position of the ship
     *                  creates square around ship
     * @return HashBasedTable for each position (x,y,Point2D)-ship or (x,y,null)-no ship
     **/
    private HashBasedTable<Integer, Integer, Point2D> createSquare(int length, Collection<Point2D> positions) {
        HashBasedTable<Integer, Integer, Point2D> table = HashBasedTable.create();
        //System.out.println("in createsquare  square länge"+ length);
        for (int row = 0; row < length + 1; row++) {
            for (int col = 0; col < length + 1; col++) {
                for (Point2D p : positions) {
                    if (p.getX() == row && p.getY() == col) {
                        //LOGGER.debug("in createsquare  square {}, {}", p.getX(), p.getY());
                        table.put(row, col, p);
                        break;
                    }
                }
            }
        }
        //LOGGER.debug("in createsquare  square {}",table.isEmpty());
        LOGGER.info("createquare {}", table);
        return table;
    }

    /**
     * checks if the ship fit at this position in the field
     */
    private boolean checkPositions(int length, Point2D point) {
        return point.getX() >= 0 && point.getY() >= 0 && point.getX() + length < width && point.getY() + length < height;
    }

    /**
     * @param length   length of the square
     * @param rotation 0=0°, 1=90°, 2=180°, 3=270°
     * @param table    square around ship
     *                 rotate square with the right angle
     * @return HashBasedTable for each position (x,y,Point2D)-ship or (x,y,null)-no ship
     */
    private HashBasedTable<Integer, Integer, Point2D> rotate(int length, int rotation, HashBasedTable<Integer, Integer, Point2D> table) {
        HashBasedTable<Integer, Integer, Point2D> tableRotated = HashBasedTable.create(table);
        LOGGER.info("rotate table");
        for (int r = rotation; r > 0; r--) {
            tableRotated = rotate90(length, tableRotated);
        }
        return tableRotated;
    }

    /**
     * @param length length of the square
     * @param table  square around ship
     *               rotate square with 90°
     * @return HashBasedTable for each position (x,y,Point2D)-ship or (x,y,null)-no ship
     */
    private HashBasedTable<Integer, Integer, Point2D> rotate90(int length, HashBasedTable<Integer, Integer, Point2D> table) {
        HashBasedTable<Integer, Integer, Point2D> tableRotated = HashBasedTable.create();
        int totalColumn = length - 1;
        int totalRows = length - 1;
        for (int j = 0; j <= totalRows; j++) {
            for (int i = 0; i <= totalColumn; i++) {
                if (table.get(j, i) != null) {
                    tableRotated.put(i, length - 1 - j, table.get(j, i));
                }
            }
        }
        LOGGER.info("rotated {}", tableRotated);
        return tableRotated;
    }

    /**
     * @param point  startingpoint (left, upper)
     * @param table  coordinates of the ship
     * @param length length of the square
     *               place the ship in the field, at the correct positions
     */
    private Ship fillField(Point2D point, HashBasedTable<Integer, Integer, Point2D> table, int length, ShipType type) {
        Ship ship = new Ship(type, table.values());
        LOGGER.info("Fill ship to field");
        //LOGGER.debug("in fillField2+table {}", table.isEmpty());
        if (table.get(0, 0) != null) {
            for (int row = 0; row < length; row++) {
                for (int col = 0; col < length; col++) {
                    Point2D shipPoint = table.get(row, col);
                    //LOGGER.debug("in fillField: {}", shipPoint==null);
                    if (shipPoint != null) {
                        LOGGER.debug("found shippoint {}", shipPoint);
                        field.put(point.getX() + row, point.getY() + col, ship);
                    }
                }
            }
        } else {
            Map<Integer, Point2D> tableRow = table.row(0);
            //LOGGER.debug("in else"+tableRow.isEmpty());
            int min = Collections.min(tableRow.keySet());
            HashBasedTable<Integer, Integer, Point2D> movedTable = HashBasedTable.create();
            for (int row = 0; row < length; row++) {
                for (int col = 0; col < length; col++) {
                    if (table.get(row, col) != null) {
                        movedTable.put(row, col - min, table.get(row, col));
                    }
                }
            }
            System.out.println(movedTable.toString());
            for (int r = 0; r < length; r++) {
                int minKeyRows = Collections.min(movedTable.row(r).keySet());
                //LOGGER.debug(minKeyRows);
                //LOGGER.debug("in movedTable1 {} row {}",movedTable.row(r).keySet(),r);
                while (minKeyRows < 0) {
                    //LOGGER.debug("in movedTable {}",minKeyRows);
                    field.put(point.getX() + r, point.getY() + minKeyRows, ship);
                    movedTable.remove(r, minKeyRows);
                    minKeyRows = Collections.min(table.row(r).keySet());
                }
                for (int col = 0; col < length; col++) {
                    Point2D shipPoint = movedTable.get(r, col);
                    //LOGGER.debug("in fillField: {}",shipPoint==null);
                    if (shipPoint != null) {
                        //LOGGER.debug("found shippoint {}", movedTable);
                        field.put(point.getX() + r, point.getY() + col, ship);
                    }
                }
            }
        }
        LOGGER.info("end fillfield {}", field);
        return ship;
    }

    public Table<Integer, Integer, Ship> getField() {
        return field;
    }
}
