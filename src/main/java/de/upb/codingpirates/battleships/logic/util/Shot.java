package de.upb.codingpirates.battleships.logic.util;

import javax.annotation.Nonnull;

/**
 * Represents a shot.
 *
 * @author Interdoc committee & Paul Becker
 */
public class Shot {
    /**
     * Is the ID of the client to whom the shot
     * is fired
     */
    private final int clientId;
    /**
     * Is the position to which fired the shot
     * becomes
     */
    @Nonnull
    private final Point2D position;

    public Shot(int clientId, @Nonnull Point2D position) {
        this.clientId = clientId;
        this.position = position;
    }

    public int getClientId() {
        return clientId;
    }

    @Nonnull
    public Point2D getPosition() {
        return position;
    }
}
