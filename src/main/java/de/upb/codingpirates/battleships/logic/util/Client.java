package de.upb.codingpirates.battleships.logic.util;

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

    public int getId() {
        return id;
    }

    @Nonnull
    public String getName() {
        return name;
    }
}
