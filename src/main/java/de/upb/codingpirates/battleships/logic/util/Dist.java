package de.upb.codingpirates.battleships.logic.util;

public enum  Dist {
    SERVER("de.upb.codingpirates.battleships.server.handler"),CLIENT("de.upb.codingpirates.battleships.client.handler");

    private final String messageHandlerPackage;

    private Dist(String messageHandlerPackage) {
        this.messageHandlerPackage = messageHandlerPackage;
    }

    public String getMessageHandlerPackage() {
        return messageHandlerPackage;
    }
}
