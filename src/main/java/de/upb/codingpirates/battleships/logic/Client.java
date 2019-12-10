package de.upb.codingpirates.battleships.logic;

import java.io.Serializable;

import javax.annotation.Nonnull;

/**
 * Represents a client.
 *
 * This class implements {@link Serializable} in order to allow it to be serialized and transferred via the
 * {@link javafx.scene.input.Clipboard} or any of its subclasses using the {@code application/x-java-serialized-object}
 * MIME type.
 *
 * @author Interdoc committee
 * @author Paul Becker
 * @author Andre Blanke
 */
public class Client implements Serializable {

    /**
     * The unique ID of this {@code Client}.
     */
    private final int id;

    /**
     * The user name selected by this {@code Client}.
     */
    @Nonnull
    private final String name;

    public Client(final int id, @Nonnull final String name) {
        this.id   = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
