package de.upb.codingpirates.battleships.logic;

/**
 * Represents the penalty type of a irregularity
 *
 * @author Interdoc committee & Paul Becker
 */
public enum PenaltyType {
    /**
     * No punishment
     */
    NOTHING,
    /**
     * Exclusion from the game
     */
    KICK,
    /**
     * point deduction
     */
    POINTLOSS
}
