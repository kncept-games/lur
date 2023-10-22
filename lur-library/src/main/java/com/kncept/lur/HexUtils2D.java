package com.kncept.lur;

import com.kncept.lur.util.FloatPoint2D;

/**
 * This assumes that the LUR(0,0,0) Hex lies at (0,0) on the 2D Plain.
 *
 *    /---\
 *   /     \
 *   \     /
 *    \---/
 */
public class HexUtils2D {

    private static final float rootThree = (float)(Math.sqrt(3d));

    public static FloatPoint2D calculateCentralOffset(
        IntegerLurCoord lur,
        float radius
    ) {
        float x = (lur.getR() - lur.getL()) * rootThree * radius;
        float y = (lur.getU() * 2 * radius) - ((lur.getL() + lur.getR()) * radius);
        return new FloatPoint2D(x, y);
    }


}
