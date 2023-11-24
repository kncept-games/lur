package com.kncept.lur.point;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerPoint2DTest {

    @Test
    public void jsonStyleSerialization() {
        IntegerPoint2D source = new IntegerPoint2D(1,2);
        String stringified = source.toString();
        IntegerPoint2D reconstituted = new IntegerPoint2D(stringified);
        Assertions.assertEquals(source, reconstituted);
        Assertions.assertEquals(stringified, reconstituted.toString());
    }
}
