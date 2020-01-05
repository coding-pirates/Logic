package de.upb.codingpirates.battleships.logic;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Nonnull;

/**
 * Represents a ship.
 *
 * @author Interdoc committee
 * @author Paul Becker
 * @author Andre Blanke
 */
public class ShipType {

    /**
     * A collection showing the relative positions
     * of the individual parts of the ship
     */
    @Nonnull
    private final Collection<Point2D> positions;

    public ShipType(@Nonnull final Point2D... positions) {
        this(Arrays.asList(positions));
    }

    /**
     * Constructor of the class ShipType
     * @param positions collection over all parts of the ship({@link Point2D})
     */
    public ShipType(@Nonnull final Collection<Point2D> positions) {
        this.positions = positions;
    }

    /**
     * Return all positions of the ship
     * @return {@link Collection<Point2D>}
     */
    @Nonnull
    public Collection<Point2D> getPositions() {
        return positions;
    }
}
