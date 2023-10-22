package com.kncept.lur;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class IntegerLurCoordDirectionTest {

    @ParameterizedTest
    @EnumSource(IntegerLurCoordDirection.class)
    public void allDirectionsAreUnitLur(IntegerLurCoordDirection direction) {
        assertTrue(direction.getDirection().isUnitLur());
        assertTrue(direction.getDirection().isMinimalForm());
    }

}