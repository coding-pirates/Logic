package de.upb.codingpirates.battleships.logic;

import javax.annotation.Nonnull;

/**
 * Represents a client.
 *
 * @author Interdoc committee
 * @author Paul Becker
 * @author Andre Blanke
 */
public abstract class AbstractClient {

    /**
     * The unique ID of this {@code Client}.
     */
    protected final int id;

    /**
     * The user name selected by this {@code Client}.
     */
    @Nonnull
    protected final String name;

    protected AbstractClient(final int id, @Nonnull final String name) {
        this.id   = id;
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

    public abstract ClientType getClientType();

}
