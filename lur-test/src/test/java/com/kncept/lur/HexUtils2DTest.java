package com.kncept.lur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kncept.lur.util.IntegerPoint2D;
import org.junit.jupiter.api.Test;

import com.kncept.lur.util.FloatPoint2D;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class HexUtils2DTest {
    private final float delta = 0.001f; //flo

    @ParameterizedTest
    @MethodSource("matchedCoordinates")
    void pointWithRadiusToLurMapping(PointToLurMap mapping) {
        float radius = 100;
        assertEquals(mapping.point, HexUtils2D.calculateCentralOffset(mapping.lur, radius).toClosestDiscretePoint());
        assertEquals(mapping.lur, HexUtils2D.calculateLurFromXY(mapping.point, radius));
    }

    public static PointToLurMap[] matchedCoordinates() {
        float radius = 100;
        return new PointToLurMap[] {
                new PointToLurMap(new IntegerPoint2D(0,0), new IntegerLurCoord(0,0,0)),
                new PointToLurMap(new IntegerPoint2D(0, 200), new IntegerLurCoord(0,1,0)),
                new PointToLurMap(new IntegerPoint2D(-520, 300), new IntegerLurCoord(3,3,0)),
                new PointToLurMap(new IntegerPoint2D(173,-300), new IntegerLurCoord(1,0,2)),
        };
    }

    private static class PointToLurMap {
        private final IntegerPoint2D point;
        private final IntegerLurCoord lur;

        public PointToLurMap(IntegerPoint2D point, IntegerLurCoord lur) {
            this.point = point;
            this.lur = lur;
        }
    }
}
