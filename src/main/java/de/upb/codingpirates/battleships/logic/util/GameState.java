package de.upb.codingpirates.battleships.logic.util;

/**
 * @author Interdoc committee & Paul Becker
 */
public enum GameState {
    /**
     * Planned game to join the player
     * can
     */
    LOBBY,
    /**
     * Currently running game
     */
    IN_PROGRESS,
    /**
     * Currently paused game
     */
    PAUSED,
    /**
     * Finished game
     */
    FINISHED;
}
