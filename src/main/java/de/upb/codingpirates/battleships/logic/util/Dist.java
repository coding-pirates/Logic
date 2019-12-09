package de.upb.codingpirates.battleships.logic.util;

import javax.annotation.Nonnull;

/**
 * This enum hold Distribution related values
 *
 * @author Paul Becker
 */
public enum Dist {
    SERVER("de.upb.codingpirates.battleships.server.handler"), CLIENT("de.upb.codingpirates.battleships.client.handler");

    /**
     * Package in which the MessageHandler are to find
     */
    @Nonnull
    private final String messageHandlerPackage;

    Dist(@Nonnull String messageHandlerPackage) {
        this.messageHandlerPackage = messageHandlerPackage;
    }

    /**
     * @return the package in which the MessageHandler are to find
     */
    @Nonnull
    public String getMessageHandlerPackage() {
        return messageHandlerPackage;
    }
}
