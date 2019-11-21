package de.upb.codingpirates.battleships.logic;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("maxPlayerCount")
    public final int MAXPLAYERCOUNT;
    /**
     * Specifies the height of the playing field
     */
    @SerializedName("height")
    public final int HEIGHT;
    /**
     * Specifies the width of the playing field
     */
    @SerializedName("width")
    public final int WIDTH;
    /**
     * Gives the number of possible shots per
     * Round on
     */
    @SerializedName("shotCount")
    public final int SHOTCOUNT;
    /**
     * Indicates the number of points a hit gives
     */
    @SerializedName("hitPoints")
    public final int HITPOINTS;
    /**
     * Indicates the number of points a sunken ship gives
     */
    @SerializedName("sunkPoints")
    public final int SUNKPOINTS;
    /**
     * time to place the shots
     */
    @SerializedName("roundTime")
    public final long ROUNDTIME;
    /**
     * Sets the time for animations to run.
     * before the timer for
     * the roundTime starts
     */
    @SerializedName("visualizationTime")
    public final long VISUALIZATIONTIME;
    /**
     * Sets the points to subtract
     * if an invalid move is made
     */
    @SerializedName("penaltyMinusPoints")
    public final int PENALTYMINUSPOINTS;
    /**
     * Sets the type of penalty for an invalid
     * Play
     */
    @SerializedName("penaltyKind")
    public final PenaltyType PENALTYTYPE;
    /**
     * A map that maps from unique ID
     * to a shipType
     */
    @Nonnull
    @SerializedName("ships")
    private final Map<Integer, ShipType> SHIPTYPES;

    public Configuration(int maxPlayerCount, int height, int width, int shotCount, int hitPoints, int sunkPoints, long roundTime, long visualizationTime, @Nonnull Map<Integer, ShipType> shipTypes, int penaltyMinusPoints, PenaltyType penaltyType) {
        this.MAXPLAYERCOUNT = maxPlayerCount;
        this.HEIGHT = height;
        this.WIDTH = width;
        this.SHOTCOUNT = shotCount;
        this.HITPOINTS = hitPoints;
        this.SUNKPOINTS = sunkPoints;
        this.ROUNDTIME = roundTime;
        this.VISUALIZATIONTIME = visualizationTime;
        this.SHIPTYPES = ImmutableMap.copyOf(shipTypes);
        this.PENALTYMINUSPOINTS = penaltyMinusPoints;
        this.PENALTYTYPE = penaltyType;
    }

    @Nonnull
    public Map<Integer, ShipType> getShips() {
        return ImmutableMap.copyOf(SHIPTYPES);
    }
}
