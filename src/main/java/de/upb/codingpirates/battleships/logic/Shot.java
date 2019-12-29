package de.upb.codingpirates.battleships.logic;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Nonnull;

/**
 * Represents a shot.
 *
 * @author Interdoc committee, Paul Becker
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

    /**
     * Constructor of the class Shot
     * @param clientId id of the clied, to which this shot belongs to
     * @param targetField {@link Point2D}, where the shot was placed
     */
    public Shot(int clientId, @Nonnull Point2D targetField) {
        this.clientId = clientId;
        this.targetField = targetField;
    }

    /**
     * Return Id of the Client, to which this shot belongs to
     * @return {@link #clientId}
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Return Point, which is the target of this shot
     * @return {@link #targetField}
     */
    @Nonnull
    public Point2D getTargetField() {
        return targetField;
    }

    /**
     * Compares Client with a given new Client
     * @param obj client to compare to
     * @return {@link Boolean #true} if the id of the given an dold client is the same,
     *         {@link Boolean #false} if the ids are different
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Shot) {
            return ((Shot) obj).clientId == clientId && ((Shot) obj).targetField == targetField;

        }
        return false;
    }

    @Override
    public String toString(){
        return "[ClientId: " + this.getClientId() + ", Point: " + this.getTargetField().toString() + "]";
    }
}
