package de.upb.codingpirates.battleships.logic;

import javax.annotation.Nonnull;

/**
 * Represents a game.
 *
 * @author Interdoc committee & Paul Becker
 */
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
    private boolean ownedByTournament;

    public Game(
            final int id,
            @Nonnull final String        name,
            @Nonnull final GameState     state,
            @Nonnull final Configuration config,
            final boolean ownedByTournament) {
        this.name              = name;
        this.id                = id;
        this.config            = config;
        this.ownedByTournament = ownedByTournament;

        setState(state);
    }

    public int getId() {
        return id;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public Configuration getConfig() {
        return config;
    }

    public boolean isOwnedByTournament() {
        return ownedByTournament;
    }

    public int getCurrentPlayerCount() {
        return currentPlayerCount;
    }

    /**
     * Increments the current player count of this {@code Game} by one.
     */
    public void incrementCurrentPlayerCount() {
        currentPlayerCount.set(Math.max(0, currentPlayerCount.get() + 1));
    }

    /**
     * Decrements the current player count of this {@code Game} by one.
     */
    public void decrementCurrentPlayerCount() {
        currentPlayerCount.set(Math.max(0, currentPlayerCount.get() - 1));
    }

    @Nonnull
    public GameState getState() {
        return state;
    }

    public void setState(@Nonnull GameState state) {
        this.state = state;
    }
}
