package de.upb.codingpirates.battleships.logic;

import javax.annotation.Nonnull;

/**
 * Represents the unique position of a ship.
 *
 * @author Interdoc committee & Paul Becker
 */
public class PlacementInfo {

    /**
     * Is the point in the coordinate system, on
     * the ship is positioned.
     */
    @Nonnull
    private Point2D position;
    /**
     * Is the clockwise rotation of the
     * ship
     */
    @Nonnull
    private Rotation rotation;

    public PlacementInfo(@Nonnull Point2D position, @Nonnull Rotation rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    @Nonnull
    public Point2D getPosition() {
        return position;
    }

    @Nonnull
    public Rotation getRotation() {
        return rotation;
    }
}
