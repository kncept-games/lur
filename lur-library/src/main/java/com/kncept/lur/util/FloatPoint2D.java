package com.kncept.lur.util;

public class FloatPoint2D {
    public final float x;
    public final float y;

    public FloatPoint2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public IntegerPoint2D toClosestDiscretePoint() {
        return new IntegerPoint2D(Math.round(x), Math.round(y));
    }
}
