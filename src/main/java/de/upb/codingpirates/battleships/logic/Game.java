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

    /**
     * Constructor for the class Game
     * @param name name of the game
     * @param id id of the game
     * @param state state of the game {@Link GameState}
     * @param config configuration which is used
     * @param tournament is this a tournament
     */
    public Game(@Nonnull String name, int id, @Nonnull GameState state, @Nonnull Configuration config, boolean tournament) {
        this.name = name;
        this.id = id;
        this.currentPlayerCount = 0;
        this.state = state;
        this.config = config;
        this.tournament = tournament;
    }

    /**
     * Return the name of the game
     * @return {@link #name}
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * Return ID of the game
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    /**
     * Return current amount of player who are playing this game
     * @return {@link #currentPlayerCount}
     */
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

    /**
     * Return status of the game
     * @return new {@link #state}
     */
    @Nonnull
    public GameState getState() {
        return state;
    }

    /**
     * Return status of the game
     * @param state {@link GameState} of the game
     */
    public void setState(@Nonnull GameState state) {
        this.state = state;
    }

    /**
     * Return configuration of the game
     * @return {@link #config}
     */
    @Nonnull
    public Configuration getConfig() {
        return config;
    }

    /**
     * Return tournament status of game
     * @return {@link #tournament}
     */
    public boolean ownedByTournament() {
        return tournament;
    }
}
