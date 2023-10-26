package com.kncept.lur.util;

import java.util.Objects;

public class IntegerPoint2D {
    public final int x;
    public final int y;

    public IntegerPoint2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distanceSq(IntegerPoint2D other) {
        int deltaX = x - other.x;
        int deltaY = y - other.y;
        return (deltaX * deltaX) + (deltaY * deltaY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerPoint2D that = (IntegerPoint2D) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
