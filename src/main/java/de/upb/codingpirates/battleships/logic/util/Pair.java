package de.upb.codingpirates.battleships.logic.util;


public class Pair<T, Z> {

    private T key;
    private Z value;

    public Pair( T first,  Z second) {
        this.first = first;
        this.second = second;
    }

    public T getKey() {
        return key;
    }

    public Z gtValue() {
        return value;
    }

    public static <T, Z> Pair<T, Z> of( T first,  Z second) {
        return new Pair<>(first, second);
    }
}