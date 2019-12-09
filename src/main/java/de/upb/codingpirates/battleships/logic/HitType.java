package de.upb.codingpirates.battleships.logic;

/**
 * Represents the result type of a {@link Shot} on a {@link Field}
 *
 * @author Paul Becker
 */
public enum HitType {
    /**
     * some sort of failure while trying to hit the field
     * - hit coordinates not on field
     */
    FAIL,
    /**
     * the shot hit no ship
     */
    NONE,
    /**
     * the shot hits a ship, but not sink it
     */
    HIT,
    /**
     * the shot hits a ship, which results in a destroyed ship
     */
    SUNK
}
