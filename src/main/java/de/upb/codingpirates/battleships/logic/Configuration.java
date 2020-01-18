package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;


/**
 * Represents the configuration for a game.
 *
 * @author Interdoc committee, Paul Becker
 */
public class Configuration {
    public static final Configuration DEFAULT = new Configuration(4, 10, 10, 4, 1, 1, 10000, 1000, new HashMap<Integer, ShipType>() {
        {
        put(0, new ShipType(Lists.newArrayList(new Point2D(3, 3), new Point2D(4, 3), new Point2D(3, 4))));
    }
    }, 1, PenaltyType.POINTLOSS);

    /**
     * max player possible in one game
     */
    private final int maxPlayerCount;
    /**
     * Specifies the height of the playing field
     */
    private final int height;
    /**
     * Specifies the width of the playing field
     */
    private final int width;
    /**
     * Gives the number of possible shots per
     * Round on
     */
    private final int shotCount;
    /**
     * Indicates the number of points a hit gives
     */
    private final int hitPoints;
    /**
     * Indicates the number of points a sunken ship gives
     */
    private final int sunkPoints;
    /**
     * time to place the shots
     */
    private final long roundTime;
    /**
     * Sets the time for animations to run.
     * before the timer for
     * the roundTime starts
     */
    private final long visualizationTime;
    /**
     * Sets the points to subtract
     * if an invalid move is made
     */
    private final int penaltyMinusPoints;
    /**
     * Sets the type of penalty for an invalid
     * Play
     */
    private final PenaltyType penaltyKind;
    /**
     * A map that maps from unique ID
     * to a shipType
     */
    @Nonnull
    private final Map<Integer, ShipType> ships;

    /**
     * Constructor of the class Configuration
     *
     * @param maxPlayerCount max amount od players
     * @param height height of the field
     * @param width width of the field
     * @param shotCount amount of shots per move
     * @param hitPoints amount of points for hitting the ship
     * @param sunkPoints amount of points for sinking a ship
     * @param roundTime duration for one move
     * @param visualizationTime duration for visualize the move
     * @param shipTypes types of the ships
     * @param penaltyMinusPoints amount of reducing points for penalty
     * @param penaltyType type of penalty
     */
    public Configuration(int maxPlayerCount, int height, int width, int shotCount, int hitPoints, int sunkPoints, long roundTime, long visualizationTime, @Nonnull Map<Integer, ShipType> shipTypes, int penaltyMinusPoints, PenaltyType penaltyType) {
        this.maxPlayerCount = maxPlayerCount;
        this.height = height;
        this.width = width;
        this.shotCount = shotCount;
        this.hitPoints = hitPoints;
        this.sunkPoints = sunkPoints;
        this.roundTime = roundTime;
        this.visualizationTime = visualizationTime;
        this.ships = ImmutableMap.copyOf(shipTypes);
        this.penaltyMinusPoints = penaltyMinusPoints;
        this.penaltyKind = penaltyType;
    }

    /**
     * Return max amount of players in one match
     * @return {@link #maxPlayerCount}
     */
    public int getMaxPlayerCount() {

        return maxPlayerCount;
    }

    /**
     * Return height of field
     * @return {@link #height}
     */
    public int getHeight() {
        return height;
    }

    /**
     * Return width of field
     * @return {@link #width}
     */
    public int getWidth() {

        return width;
    }

    /**
     * Return amount of shots per move
     * @return {@link #shotCount}
     */
    public int getShotCount() {

        return shotCount;
    }

    /**
     * Return points for hitting a ship in 0.25 steps
     * @return {@link #hitPoints}
     */
    public int getHitPointsRaw() {

        return hitPoints;
    }


    /**
     * Return points for hitting a ship in the right scale (multiply with 4)
     * @return {@link #hitPoints*4}
     */
    public int getHitPoints() {

        return hitPoints * 4;
    }

    /**
     * Return points for a sunken ship in 0.25 steps
     * @return {@link #sunkPoints}
     */
    public int getSunkPointsRaw() {

        return sunkPoints;
    }

    /**
     * Return points for a sunken ship in the right scale (multiply with 4)
     * @return {@link #sunkPoints*4}
     */
    public int getSunkPoints() {

        return sunkPoints * 4;
    }

    /**
     * Return time to place a shot
     * @return {@link #roundTime}
     */
    public long getRoundTime() {

        return roundTime;
    }

    /**
     * Return time to visualize the shot
     * @return {@link #visualizationTime}
     */
    public long getVisualizationTime() {

        return visualizationTime;
    }

    /**
     * Return amount of reducing points for penalty
     * @return {@link #penaltyMinusPoints}
     */
    public int getPenaltyMinusPoints() {

        return penaltyMinusPoints;
    }

    /**
     * Return the type of the Penalty
     * @return {@link #penaltyKind}
     */
    public PenaltyType getPenaltyKind() {

        return penaltyKind;
    }

    /**
     * Return a map that maps from unique ID to a shipType
     * @return {@link #ships}
     */
    @Nonnull
    public Map<Integer, ShipType> getShips() {
        return ships;
    }
}