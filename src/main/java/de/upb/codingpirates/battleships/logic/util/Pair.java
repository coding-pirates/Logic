package de.upb.codingpirates.battleships.logic.util;


public class Pair<T, Z> {

    private T key;
    private Z value;

    public Pair(T key, Z value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public Z getValue() {
        return value;
    }

    public static <T, Z> Pair<T, Z> of(T first, Z second) {
        return new Pair<>(first, second);
    }
}
