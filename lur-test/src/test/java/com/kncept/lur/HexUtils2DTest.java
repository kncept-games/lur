package com.kncept.lur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.kncept.lur.util.FloatPoint2D;

public class HexUtils2DTest {
    private final float delta = 0.001f; //flo

    @Test
    void calculateCentralOffset() {
        FloatPoint2D offset = HexUtils2D.calculateCentralOffset(new IntegerLurCoord(0, 0, 0), 100);
        assertEquals(0, offset.x, delta);
        assertEquals(0, offset.y, delta);

        // vertical only offset is pretty simple.
        offset = HexUtils2D.calculateCentralOffset(new IntegerLurCoord(0, 1, 0), 100);
        assertEquals(0, offset.x, delta);
        assertEquals(200, offset.y, delta);


        offset = HexUtils2D.calculateCentralOffset(new IntegerLurCoord(3, 3, 0), 100);
        assertEquals(-519.615234375, offset.x, delta); // -300 * root 3
        assertEquals(300, offset.y, delta);

        offset = HexUtils2D.calculateCentralOffset(new IntegerLurCoord(1, 0, 2), 100);
        assertEquals(173.205078125, offset.x, delta); // 100 * root 3
        assertEquals(-300, offset.y, delta);
    }
}
