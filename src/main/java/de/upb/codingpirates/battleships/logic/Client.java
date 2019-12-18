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
     * Return the specific Client ID
     * @return {@link #id}
     */
    public int getId() {
        return id;
    }

    /**
     * Return the specific name of the client
     * @return {@link #name}
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * Return the specific name of the client
     * @return {@link String}
     */
    @Override
    public String toString() {
        return name;
    }
}
