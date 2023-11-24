package com.kncept.lur.point;

import java.util.Objects;

import static com.kncept.lur.util.SerializationUtils.intsToString;
import static com.kncept.lur.util.SerializationUtils.stringToInts;

public class IntegerPoint2D {
    public final int x;
    public final int y;

    public IntegerPoint2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public IntegerPoint2D(String value) {
        int[] values = stringToInts(value);
        if (values.length != 2) throw new IllegalArgumentException("Unable to parse point: " + value);
        x = values[0];
        y = values[1];
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

    @Override
    public String toString() {
        return intsToString(x,y);
    }
}
