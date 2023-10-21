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

//    private final double sqrt3 = Math.sqrt(3d);

    public static FloatPoint2D calculateCentralOffset(IntegerLurCoord lur) {
        return new FloatPoint2D(0f, 0f);
    }


}
