package de.upb.codingpirates.battleships.logic;

import javax.annotation.Nonnull;

/**
 * Represents a client
 *
 * @author Interdoc committee & Paul Becker
 */
public class Client {

    /**
     * A unique ID of a client
     */
    private final int id;
    /**
     * Contains the selected name of a client
     */
    @Nonnull
    private final String name;

    public Client(int id, @Nonnull String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return Id of the {@link Client}
     */
    public int getId() {
        return id;
    }

    /**
     * @return Name of the {@link Client}
     */
    @Nonnull
    public String getName() {
        return name;
    }
}
