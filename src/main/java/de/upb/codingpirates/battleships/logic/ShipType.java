package de.upb.codingpirates.battleships.logic;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * Represents a ship.
 *
 * @author Interdoc committee & Paul Becker
 */
public class ShipType {

    /**
     * A collection showing the relative positions
     * of the individual parts of the ship
     */
    @Nonnull
    private final Collection<Point2D> positions;

    public ShipType(@Nonnull Collection<Point2D> positions) {
        this.positions = positions;
    }

    @Nonnull
    public Collection<Point2D> getPositions() {
        return positions;
    }
}