package de.upb.codingpirates.battleships.logic.util;

import javax.annotation.Nonnull;

public enum Dist {
    SERVER("de.upb.codingpirates.battleships.server.handler"),
    CLIENT("de.upb.codingpirates.battleships.client.handler");

    private final String messageHandlerPackage;

    Dist(@Nonnull final String messageHandlerPackage) {
        this.messageHandlerPackage = messageHandlerPackage;
    }

    public String getMessageHandlerPackage() {
        return messageHandlerPackage;
    }
}
