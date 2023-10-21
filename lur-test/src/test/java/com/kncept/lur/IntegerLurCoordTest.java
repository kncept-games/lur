package com.kncept.lur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerLurCoordTest {

    @Test
    public void equivalentIsEqual() {
        IntegerLurCoord lur1 = new IntegerLurCoord(0, 0, 0);
        IntegerLurCoord lur2 = new IntegerLurCoord(0, 0, 0);
        Assertions.assertEquals(lur1, lur2);
        Assertions.assertNotSame(lur1, lur2);

    }
    @Test
    public void normalizeReturnsSelfReference() {
        IntegerLurCoord lur1 = new IntegerLurCoord(0, 0, 0);
        Assertions.assertSame(lur1, lur1.normalize());
        Assertions.assertTrue(lur1.isNormalized());

        IntegerLurCoord lur2 = new IntegerLurCoord(0, 3, 5);
        Assertions.assertSame(lur2, lur2.normalize());
        Assertions.assertTrue(lur2.isNormalized());
    }

    @Test
    public void canNormalize() {
        IntegerLurCoord lur1 = new IntegerLurCoord(1, 2, 2);
        Assertions.assertNotEquals(lur1, lur1.normalize());
        Assertions.assertFalse(lur1.isNormalized());
        Assertions.assertEquals(new IntegerLurCoord(0, 1, 1), lur1.normalize());

        IntegerLurCoord lur2 = new IntegerLurCoord(0, -3, 5);
        Assertions.assertNotEquals(lur2, lur2.normalize());
        Assertions.assertFalse(lur2.isNormalized());
        Assertions.assertNotEquals(new IntegerLurCoord(3, 0, 8), lur2.normalize());
    }
}
