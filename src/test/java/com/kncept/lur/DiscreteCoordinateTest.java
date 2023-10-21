package com.kncept.lur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscreteCoordinateTest {

    @Test
    public void equivalentIsEqual() {
        DiscreteCoordinate lur1 = new DiscreteCoordinate(0, 0, 0);
        DiscreteCoordinate lur2 = new DiscreteCoordinate(0, 0, 0);
        Assertions.assertEquals(lur1, lur2);
        Assertions.assertNotSame(lur1, lur2);

    }
    @Test
    public void normalizeReturnsSelfReference() {
        DiscreteCoordinate lur1 = new DiscreteCoordinate(0, 0, 0);
        DiscreteCoordinate lur2 = new DiscreteCoordinate(0, 3, 5);
        Assertions.assertSame(lur1, lur1.normalize());
        Assertions.assertSame(lur2, lur2.normalize());
    }
}
