package de.upb.codingpirates.battleships.logic;

/**
 * State in which the overall game is in
 *
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
    FINISHED
}
