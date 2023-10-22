package com.kncept.lur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class IntegerLurCoordTest {

    @Test
    public void equivalentIsEqual() {
        IntegerLurCoord lur1 = new IntegerLurCoord(0, 0, 0);
        IntegerLurCoord lur2 = new IntegerLurCoord(0, 0, 0);
        Assertions.assertEquals(lur1, lur2);
        Assertions.assertNotSame(lur1, lur2);

    }
    @Test
    public void minimalFormReturnsSelfReference() {
        IntegerLurCoord lur1 = new IntegerLurCoord(0, 0, 0);
        Assertions.assertSame(lur1, lur1.minimise());
        Assertions.assertTrue(lur1.isMinimalForm());

        IntegerLurCoord lur2 = new IntegerLurCoord(0, 3, 5);
        Assertions.assertSame(lur2, lur2.minimise());
        Assertions.assertTrue(lur2.isMinimalForm());
    }

    @Test
    public void minimalFormConversion() {
        IntegerLurCoord lur1 = new IntegerLurCoord(1, 2, 2);
        Assertions.assertNotEquals(lur1, lur1.minimise());
        Assertions.assertFalse(lur1.isMinimalForm());
        Assertions.assertEquals(new IntegerLurCoord(0, 1, 1), lur1.minimise());

        IntegerLurCoord lur2 = new IntegerLurCoord(0, -3, 5);
        Assertions.assertNotEquals(lur2, lur2.minimise());
        Assertions.assertFalse(lur2.isMinimalForm());
        Assertions.assertNotEquals(new IntegerLurCoord(3, 0, 8), lur2.minimise());
    }

    @Test
    public void verifyUnitLur() {
        Assertions.assertFalse(new IntegerLurCoord(0,0,0).isUnitLur());

        Assertions.assertTrue(new IntegerLurCoord(1,0,0).isUnitLur());
        Assertions.assertTrue(new IntegerLurCoord(1,1,0).isUnitLur());
        Assertions.assertTrue(new IntegerLurCoord(0,1,0).isUnitLur());
        Assertions.assertTrue(new IntegerLurCoord(0,1,1).isUnitLur());
        Assertions.assertTrue(new IntegerLurCoord(0,0,1).isUnitLur());
        Assertions.assertTrue(new IntegerLurCoord(1,0,1).isUnitLur());

        Assertions.assertFalse(new IntegerLurCoord(1,1,1).isUnitLur());
        Assertions.assertFalse(new IntegerLurCoord(2,0,0).isUnitLur());
    }

    @Test
    public void hexMoveRingSize() {
        for(int radius = 1; radius < 10; radius++) {
            List<IntegerLurCoord> hexRing = new IntegerLurCoord(0,0,0).hexMoveRing(radius);
            Assertions.assertEquals(6 * radius, hexRing.size());
        }
    }
}
