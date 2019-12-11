package de.upb.codingpirates.battleships.logic;

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

    public Game(@Nonnull String name, int id, @Nonnull GameState state, @Nonnull Configuration config, boolean tournament) {
        this.name = name;
        this.id = id;
        this.currentPlayerCount = 0;
        this.state = state;
        this.config = config;
        this.tournament = tournament;
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

    /**
     * increases the {@link #currentPlayerCount}
     *
     * @return new {@link #currentPlayerCount}
     */
    public int addPlayer() {
        return currentPlayerCount = Math.max(0, ++currentPlayerCount);
    }

    /**
     * decreases the {@link #currentPlayerCount}
     *
     * @return new {@link #currentPlayerCount}
     */
    public int removePlayer() {
        return currentPlayerCount = Math.max(0, --currentPlayerCount);
    }

    @Nonnull
    public GameState getState() {
        return state;
    }

    public void setState(@Nonnull GameState state) {
        this.state = state;
    }

    @Nonnull
    public Configuration getConfig() {
        return config;
    }

    public boolean ownedByTournament() {
        return tournament;
    }
}
