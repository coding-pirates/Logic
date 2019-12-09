package de.upb.codingpirates.battleships.logic;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Nonnull;

/**
 * Represents a shot.
 *
 * @author Interdoc committee & Paul Becker
 */
public class Shot {
    /**
     * Is the ID of the client to whom the shot
     * is fired on
     */
    private final int clientId;
    /**
     * the position to which the shot is fired
     */
    @Nonnull
    @SerializedName("position")
    private final Point2D targetField;

    public Shot(int clientId, @Nonnull Point2D targetField) {
        this.clientId = clientId;
        this.targetField = targetField;
    }

    /**
     * @return {@link #clientId}
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * @return {@link #targetField}
     */
    @Nonnull
    public Point2D getTargetField() {
        return targetField;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Shot) {
            return ((Shot) obj).clientId == clientId && ((Shot) obj).targetField == targetField;

        }
        return false;
    }
}
