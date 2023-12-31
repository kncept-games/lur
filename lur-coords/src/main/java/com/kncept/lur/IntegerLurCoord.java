package com.kncept.lur;

import java.util.*;

import static com.kncept.lur.util.SerializationUtils.intsToString;
import static com.kncept.lur.util.SerializationUtils.stringToInts;

public class IntegerLurCoord {
    private final int l,u,r;

    public IntegerLurCoord(int l, int u, int r) {
        this.l = l;
        this.u = u;
        this.r = r;
    }
    public IntegerLurCoord(String value) {
        int[] values = stringToInts(value);
        if (values.length != 3) throw new IllegalArgumentException("Unable to parse lur: " + value);
        l = values[0];
        u = values[1];
        r = values[2];
    }

    public int getL() {
        return l;
    }

    public int getU() {
        return u;
    }

    public int getR() {
        return r;
    }

    public boolean isUnitLur() {
        int zeroCount = 0;
//        int oneCount = 0; // simplifies out
        int otherCount = 0;
        switch (l) {
            case 0: zeroCount++; break;
            case 1: break;
            default: otherCount++;
        }
        switch (u) {
            case 0: zeroCount++; break;
            case 1: break;
            default: otherCount++;
        }
        switch (r) {
            case 0: zeroCount++; break;
            case 1: break;
            default: otherCount++;
        }
        return
                otherCount == 0 &&
                (zeroCount == 1 || zeroCount == 2);
    }

    public boolean isMinimalForm() {
        return l >= 0 && u >= 0 && r >= 0 && (l == 0 || u == 0 || r == 0);
    }

    public IntegerLurCoord minimise() {
        // if all are positive, and at least one offset is zero, this _is_ normalized
        if (isMinimalForm()) return this;

        int l = this.l;
        int u = this.u;
        int r = this.r;

        int common = Math.min(Math.min(l, u), r);

        l -= common;
        u -= common;
        r -= common;
        return new IntegerLurCoord(l, u, r);
    }

    public IntegerLurCoord addL(int delta) {
        return new IntegerLurCoord(l + delta, u, r);
    }
    public IntegerLurCoord addU(int delta) {
        return new IntegerLurCoord(l, u + delta, r);
    }
    public IntegerLurCoord addR(int delta) {
        return new IntegerLurCoord(l, u, r + delta);
    }

    public IntegerLurCoord add(IntegerLurCoord coord) {
        return new IntegerLurCoord(l + coord.l, u + coord.u, r + coord.r);
    }
    public IntegerLurCoord subtract(IntegerLurCoord coord) {
        return new IntegerLurCoord(l - coord.l, u - coord.u, r - coord.r);
    }

    public IntegerLurCoord multiply(int scale) {
        return new IntegerLurCoord(scale * l, scale * u, scale * r);
    }

    public float distanceSq(IntegerLurCoord other) {
        return HexUtils2D.calculateCentralOffset(this, 0.5f).distanceSq(HexUtils2D.calculateCentralOffset(other, 0.5f));
    }

    public List<IntegerLurCoord> hexMoveRing(int radius) {
        if (radius < 0) throw new RuntimeException("-ve Radius not valid");
        if (radius == 0) return Collections.singletonList(this);

        List<IntegerLurCoord> ring = new ArrayList<>(6*radius);

        IntegerLurCoordDirection direction = IntegerLurCoordDirection.U;
        for(int i = 0; i < 6; i++) {
            IntegerLurCoord spar = add(direction.getDirection().multiply(radius));
            ring.add(spar);
            IntegerLurCoordDirection antiWalkDirection = direction.anticlockwise();
            direction = direction.clockwise();
            for(int j = 1; j < radius; j++) {
                spar = spar.subtract(antiWalkDirection.getDirection());
                ring.add(spar);
            }
        }
        return ring;
    }

    public List<IntegerLurCoord> hexesWithinRadius(float radius) {
        if (radius <= 0) throw new RuntimeException("Invalid Radius");

        List<IntegerLurCoord> area = new ArrayList<>();
        area.add(this);
        int currentRadius = (int)radius;
        float distanceSq = radius * radius;
        for(int i = 1; i <= radius; i++)
            area.addAll(hexMoveRing(i));

        boolean lastRingAdded = true;
        while (lastRingAdded) {
            lastRingAdded = false;
            currentRadius++;
            Iterator<IntegerLurCoord> candidates = hexMoveRing(currentRadius).iterator();
            while (candidates.hasNext()) {
                IntegerLurCoord next = candidates.next();
                if (distanceSq > next.distanceSq(this)) {
                    area.add(next);
                    lastRingAdded = true;
                }
            }
        }
        return area;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerLurCoord that = (IntegerLurCoord) o;
        return l == that.l && u == that.u && r == that.r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(l, u, r);
    }

    @Override
    public String toString() {
        return intsToString(l,u,r);
    }
}
