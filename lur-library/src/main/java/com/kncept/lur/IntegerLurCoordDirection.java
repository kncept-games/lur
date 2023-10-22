package com.kncept.lur;

public enum IntegerLurCoordDirection {
    U(new IntegerLurCoord(0,1,0)),
    UR(new IntegerLurCoord(0,1,1)),
    R(new IntegerLurCoord(0,0,1)),
    RL(new IntegerLurCoord(1,0,1)),
    L(new IntegerLurCoord(1,0,0)),
    LU(new IntegerLurCoord(1,1,0));

    private final IntegerLurCoord direction;
    private IntegerLurCoordDirection(
            IntegerLurCoord direction
    ) {
        this.direction = direction;
    }

    public IntegerLurCoord getDirection() {
        return direction;
    }

    public IntegerLurCoordDirection clockwise() {
        return IntegerLurCoordDirection.values() [
                (ordinal() + 1) %
                        IntegerLurCoordDirection.values().length
                ];
    }
    public IntegerLurCoordDirection anticlockwise() {
        return IntegerLurCoordDirection.values() [
                (ordinal() + IntegerLurCoordDirection.values().length - 1) %
                        IntegerLurCoordDirection.values().length
                ];
    }
}
