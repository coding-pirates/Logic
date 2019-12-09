package de.upb.codingpirates.battleships.logic;

/**
 * @author Paul Becker
 */
public class BoundingBox {
    private final int x;
    private final int y;

    public BoundingBox(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXSize() {
        return x;
    }

    public int getYSize() {
        return y;
    }

    public int getSize() {
        return x * y;
    }
}
