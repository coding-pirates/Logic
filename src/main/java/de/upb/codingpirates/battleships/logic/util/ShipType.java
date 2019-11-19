package de.upb.codingpirates.battleships.logic.util;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Represents a shiptype.
 *
 * @author Interdoc committee & Paul Becker
 */
public class ShipType {

    /**
     * A collection showing the relative positions
     * of the individual parts of the ship
     */
    @Nonnull
    private final Collection<Point2D> position;

    public ShipType(@Nonnull Collection<Point2D> position) {
        this.position = position;
    }

    @Nonnull
    public Collection<Point2D> getPosition() {
        return position;
    }
}
