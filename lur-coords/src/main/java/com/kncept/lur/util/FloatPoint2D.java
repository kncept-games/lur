package com.kncept.lur.util;

public class FloatPoint2D {
    public final float x;
    public final float y;

    public FloatPoint2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public FloatPoint2D negate() {
        return new FloatPoint2D(-x, -y);
    }
    public FloatPoint2D negateY() {
        return new FloatPoint2D(x, -y);
    }
    public FloatPoint2D negateX() {
        return new FloatPoint2D(-x, y);
    }

    public float distanceSq(FloatPoint2D other) {
        float deltaX = x - other.x;
        float deltaY = y - other.y;
        return (deltaX * deltaX) + (deltaY * deltaY);
    }


    public IntegerPoint2D toClosestDiscretePoint() {
        return new IntegerPoint2D(Math.round(x), Math.round(y));
    }
}
