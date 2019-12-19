package de.upb.codingpirates.battleships.logic;

import javax.annotation.Nonnull;

/**
 * Represents a single game.
 *
 * @author Interdoc committee
 * @author Paul Becker
 * @author Andre Blanke
 */
public final class Game {

    /**
     * The name of this {@code Game} set by the host at creation time.
     */
    @Nonnull
    private String name;

    /**
     * The unique ID of this {@code Game}.
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
     * Contains the {@link Configuration} associated with this {@code Game}.
     */
    @Nonnull
    private Configuration config;

    /**
     * Indicates whether the game belongs to a tournament.
     */
    private boolean tournament;

    /**
     * Instantiates a new {@code Game} object.
     *
     * @param id The integer responsible for uniquely identifying this {@code Game}.
     *
     * @param name The name of this {@code Game}, e.g. for display in the user interface.
     *
     * @param state The initial {@link GameState} of the {@code Game} instance to be created.
     *
     * @param config The {@link Configuration} specifying the behaviour of this instance.
     *
     * @param tournament Whether this {@code Game} is part of a tournament.
     */
    public Game(
            final int id,
            @Nonnull final String        name,
            @Nonnull final GameState     state,
            @Nonnull final Configuration config,
            final boolean tournament) {
        this.name       = name;
        this.id         = id;
        this.state      = state;
        this.config     = config;
        this.tournament = tournament;
    }

    /**
     * Returns the unique ID associated with this {@code Game}.
     *
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    /**
     * Return the name of the {@code Game}, e.g. for display in the user interface.
     *
     * @return {@link #name}
     */
    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public Configuration getConfig() {
        return config;
    }

    /**
     * Returns whether this {@code Game} is part of a tournament.
     *
     * @return {@code true} if this {@code Game} is part of a tournament, otherwise {@code false}.
     */
    public boolean isTournament() {
        return tournament;
    }

    /**
     * Return current amount of players who are playing this game.
     *
     * @return {@link #currentPlayerCount}
     */
    public int getCurrentPlayerCount() {
        return currentPlayerCount;
    }

    public void setCurrentPlayerCount(final int currentPlayerCount) {
        if (currentPlayerCount < 0)
            throw new IllegalArgumentException("currentPlayerCount cannot be less than zero.");
        this.currentPlayerCount = currentPlayerCount;
    }

    /**
     * Return status of the {@code Game}.
     *
     * @return {@link #state}
     */
    @Nonnull
    public GameState getState() {
        return state;
    }

    public void setState(@Nonnull final GameState state) {
        this.state = state;
    }
}
