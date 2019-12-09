package de.upb.codingpirates.battleships.logic;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the rotation of a ship
 *
 * @author Paul Becker
 */
public enum Rotation {
    /**
     * not rotated
     */
    @SerializedName("0")
    NONE,
    /**
     * rotated with 90°
     */
    @SerializedName("1")
    CLOCKWISE_90,
    /**
     * rotated with 180°
     */
    @SerializedName("2")
    CLOCKWISE_180,
    /**
     * rotated with 270°
     */
    @SerializedName("3")
    COUNTERCLOCKWISE_90;
}
