package de.upb.codingpirates.battleships.logic;

import javax.annotation.Nonnull;

import javafx.beans.property.*;

/*
 * Some features of this class are realized via the various Property<T> implementations located inside the
 * javafx.beans.property package instead of the usual getter and setter approach with a backing field.
 *
 * This is the case to allow data binding from the UI (e.g. for TableViews).
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
     * The unique ID of this {@code Game}.
     */
    private int id;

    /**
     * The name of this {@code Game} set by the host at creation time.
     */
    @Nonnull
    private String name;

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

    // <editor-fold desc="currentPlayerCount">
    /**
     * The current amount of {@link Client}s with {@link ClientType#PLAYER} which are part of this {@code Game}.
     */
    private final IntegerProperty currentPlayerCount = new SimpleIntegerProperty();

    public int getCurrentPlayerCount() {
        return currentPlayerCount.get();
    }

    @SuppressWarnings("unused")
    public ReadOnlyIntegerProperty currentPlayerCountProperty() {
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
    // </editor-fold>

    // <editor-fold desc="state">
    private final ObjectProperty<GameState> state = new SimpleObjectProperty<>();

    @Nonnull
    public GameState getState() {
        return state.get();
    }

    public void setState(@Nonnull final GameState state) {
        this.state.set(state);
    }

    @SuppressWarnings("unused")
    public ObjectProperty<GameState> stateProperty() {
        return state;
    }
    // </editor-fold>

    /**
     * "Synthetic" getter acting as a delegate to {@link Configuration#getMaxPlayerCount()}.
     *
     * This getter is required because JavaFX's {@code PropertyValueFactory}, which is used to access the property
     * values of {@code Game} instances for display in a {@code TableView}, is not able to handle nested properties
     * (e.g. {@code config.maxPlayerCount}).
     *
     * @return The maximum amount of players supported by this {@code Game} instance according to its {@link #config}.
     */
    @SuppressWarnings("unused")
    public int getMaxPlayerCount() {
        return config.getMaxPlayerCount();
    }
}
