package de.upb.codingpirates.battleships.logic.util;

import javax.annotation.Nullable;

/**
 * A Pair of two objects
 *
 * @author Paul Becker
 */
public class Pair<T, Z> {

    private T key;
    private Z value;

    private Pair(T key, Z value) {
        this.key = key;
        this.value = value;
    }

    public static <T, Z> Pair<T, Z> of(@Nullable T first,@Nullable Z second) {
        return new Pair<>(first, second);
    }

    /**
     * @return {@link #key}
     */
    public T getKey() {
        return key;
    }

    /**
     * @return {@link #value}
     */
    public Z getValue() {
        return value;
    }
}
