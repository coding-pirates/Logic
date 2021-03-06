package de.upb.codingpirates.battleships.logic;

import com.google.common.base.Objects;

import javax.annotation.Nonnull;
import java.io.Serializable;

/**
 * Represents a player.
 *
 * @author Interdoc committee
 * @author Paul Becker
 * @author Andre Blanke
 */
public class Client extends AbstractClient {

    private boolean dead;
    private boolean spectator;

    public Client(final int id, @Nonnull final String name) {
        super(id, name);
    }

    @Nonnull
    @Override
    public ClientType getClientType() {
        return ClientType.PLAYER;
    }

    public boolean isDead() {
        return dead;
    }

    @Nonnull
    @Override
    public ClientType handleClientAs() {
        return spectator ? ClientType.SPECTATOR : ClientType.PLAYER;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setSpectator(boolean spectator) {
        this.spectator = spectator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return dead == client.dead &&
                spectator == client.spectator;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dead, spectator);
    }
}
