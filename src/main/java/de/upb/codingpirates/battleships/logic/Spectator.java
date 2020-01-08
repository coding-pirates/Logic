package de.upb.codingpirates.battleships.logic;

import javax.annotation.Nonnull;

public class Spectator extends AbstractClient{

    public Spectator(int id, @Nonnull String name) {
        super(id, name);
    }

    @Override
    public ClientType getClientType() {
        return ClientType.SPECTATOR;
    }
}
