package de.upb.codingpirates.battleships.logic.util;

import javax.annotation.Nullable;

public class Pair<T, Z> {

    private @Nullable
    T key;
    private @Nullable
    Z value;

    public Pair(@Nullable T key, @Nullable Z value) {
        this.key = key;
        this.value = value;
    }

    public @Nullable
    T getKey() {
        return key;
    }

    public @Nullable
    Z getValue() {
        return value;
    }

    public static <T, Z> Pair<T, Z> of(@Nullable T first, @Nullable Z second) {
        return new Pair<>(first, second);
    }
}
