package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * Represents the configuration for a game.
 *
 * @author Interdoc committee & Paul Becker
 */
public class Configuration {
    public static final Configuration DEFAULT = new Configuration(0, 0, 0, 0, 0, 0, 0, 0, Maps.newHashMap(), 1, PenaltyType.POINTLOSS);

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

    @Nonnull
    public Map<Integer, ShipType> getShipTypes() {
        return ImmutableMap.copyOf(ships);
    }

    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getShotCount() {
        return shotCount;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getSunkPoints() {
        return sunkPoints;
    }

    public long getRoundTime() {
        return roundTime;
    }

    public long getVisualizationTime() {
        return visualizationTime;
    }

    public int getPenaltyMinusPoints() {
        return penaltyMinusPoints;
    }

    public PenaltyType getPenaltyKind() {
        return penaltyKind;
    }

    @Nonnull
    public Map<Integer, ShipType> getShips() {
        return ships;
    }
}
