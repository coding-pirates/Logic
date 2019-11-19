package de.upb.codingpirates.battleships.logic.util;

import com.google.gson.annotations.SerializedName;

/**
 * @author Paul Becker
 */
public enum Rotation {
    @SerializedName("0") NONE, @SerializedName("1") CLOCKWISE_90, @SerializedName("2") CLOCKWISE_180, @SerializedName("3") COUNTERCLOCKWISE_90
}
