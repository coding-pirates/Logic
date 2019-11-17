package de.upb.codingpirates.battleships.logic.util;

import javax.annotation.Nullable;

public class Pair<T, Z> {

    private @Nullable
    T first;
    private @Nullable
    Z second;

    public Pair(@Nullable T first, @Nullable Z second) {
        this.first = first;
        this.second = second;
    }

    public @Nullable
    T getFirst() {
        return first;
    }

    public @Nullable
    Z getSecond() {
        return second;
    }

    public static <T, Z> Pair<T, Z> of(@Nullable T first, @Nullable Z second) {
        return new Pair<>(first, second);
    }
}