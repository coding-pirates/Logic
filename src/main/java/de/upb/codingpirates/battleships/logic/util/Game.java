package de.upb.codingpirates.battleships.logic.util;

import javax.annotation.Nonnull;

/**
 * Represents a game.
 *
 * @author Interdoc committee & Paul Becker
 */
public class Game {

    /**
     * Is the name of the game
     */
    @Nonnull
    private String name;
    /**
     * Is the unique ID of the game
     */
    private int id;
    /**
     * Contains the number of currently registered
     * player
     */
    private int currentPlayerCount;
    /**
     * Contains the status of the game
     */
    @Nonnull
    private GameState state;
    /**
     * Contains the configuration of the game
     */
    @Nonnull
    private Configuration config;
    /**
     * Indicates whether the game belongs to a tournament
     */
    private boolean tournament;

    public Game(@Nonnull String name, int id, int currentPlayerCount, @Nonnull GameState state, @Nonnull Configuration config) {
        this.name = name;
        this.id = id;
        this.currentPlayerCount = currentPlayerCount;
        this.state = state;
        this.config = config;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCurrentPlayerCount() {
        return currentPlayerCount;
    }

    @Nonnull
    public GameState getState() {
        return state;
    }

    @Nonnull
    public Configuration getConfig() {
        return config;
    }

    public boolean isTournament() {
        return tournament;
    }

    public void setTournament(boolean tournament) {
        this.tournament = tournament;
    }
}
