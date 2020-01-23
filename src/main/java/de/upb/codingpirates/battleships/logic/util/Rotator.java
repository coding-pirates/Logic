package de.upb.codingpirates.battleships.logic.util;

import de.upb.codingpirates.battleships.logic.Point2D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Helper Class for rotating ships and making all their coordinates positive
 * Uses a rotation matrix: rotating the ship object around the zero point.
 * Moves them also in the positive area of the coordinate system using a {@link ZeroPointMover}.
 * <p>
 * Used for getting all possible rotations of one ship.
 *
 * @author Benjamin Kasten, (Leonie Lender)
 */
public class Rotator {
    private static final Logger logger = LogManager.getLogger();
    ZeroPointMover mover = new ZeroPointMover();


    /**
     * Constructor for {@link Rotator}.
     *
     * @param
     */
    public Rotator() {

    }

    /**
     * Creates a collection of collections of all possible ship rotations
     *
     * @param ships Collection of points which represents a ship
     * @return allPossibleTurns ArrayList of arrayLists for each possible rotation
     */
    public ArrayList<ArrayList<Point2D>> rotateShips(Collection<Point2D> ships) {
        ZeroPointMover mover = new ZeroPointMover();
        ArrayList<ArrayList<Point2D>> allPossibleTurns = new ArrayList<>();
        //no turn
        allPossibleTurns.add(mover.moveToZeroPoint(ships));
        //90 degrees
        allPossibleTurns.add(turn90(ships));
        //180 degrees
        ArrayList<Point2D> temp180;
        temp180 = turn90(ships);
        temp180 = turn90(temp180);
        allPossibleTurns.add(temp180);

        //270 degrees
        ArrayList<Point2D> temp270;
        temp270 = turn90(ships);
        temp270 = turn90(temp270);
        temp270 = turn90(temp270);
        allPossibleTurns.add(temp270);
        return allPossibleTurns;

    }

    /**
     * Turns a ship (collection of points) 90 degree around the zeropoint and calls the {@link ZeroPointMover#moveToZeroPoint(Collection)}
     * method
     *
     * @param positions all points of a ship
     * @return a ArrayList of points, which includes the 90 degree turned and (now) positive points.
     */
    public ArrayList<Point2D> turn90(Collection<Point2D> positions) {
        ArrayList<Point2D> turned = new ArrayList<>();

        for (Point2D p : positions) {
            //uses a rotation matrix for 90 degree (here simplified)
            int newX = (-1) * p.getY();
            int newY = p.getX();
            turned.add(new Point2D(newX, newY));
        }

        return mover.moveToZeroPoint(turned);
    }


}
