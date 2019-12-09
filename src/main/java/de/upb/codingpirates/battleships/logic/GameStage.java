package de.upb.codingpirates.battleships.logic;

/**
 * Stage in which the game is while in {@link GameState#IN_PROGRESS}
 * @author Paul Becker
 */
@SuppressWarnings("JavadocReference")
public enum GameStage {
    /**
     * All stuff which should be done before the game should be finished here
     */
    START,
    /**
     * Waiting for shots requests from the clients and perform shots
     */
    SHOTS,
    /**
     * Waits for {@link Configuration#visualizationTime} and perform pre round analytics
     */

    VISUALIZATION,
    /**
     * Waiting for place ships requests from the clients and perform place ships
     */
    PLACESHIPS,
    /**
     * perform all tasks that should be done when the game is finished
     */
    FINISHED
}
