package com.kncept.lur;

import java.util.Objects;

public class DiscreteCoordinate {
    private final int l,u,r;

    public DiscreteCoordinate(int l, int u, int r) {
        this.l = l;
        this.u = u;
        this.r = r;
    }

    public DiscreteCoordinate normalize() {
        // if all are positive, and at least one offset is zero, this _is_ normalized
        if (l >= 0 && u >= 0 && r >= 0 && l == 0 || u == 0 || r == 0) return this;

        int l = this.l;
        int u = this.u;
        int r = this.r;

        // get rid of any -ve terms
        while (l < 0) {
            l++;
            u--;
            r--;
        }
        while(u < 0) {
            l--;
            u++;
            r--;
        }
        while (r < 0) {
            l--;
            u--;
            r++;
        }

        int common = Math.min(Math.min(l, u), r);
        l -= common;
        u -= common;
        r -= common;
        return new DiscreteCoordinate(l, u, r);
    }

    public DiscreteCoordinate addL(int delta) {
        return new DiscreteCoordinate(l + delta, u, r);
    }
    public DiscreteCoordinate addU(int delta) {
        return new DiscreteCoordinate(l, u + delta, r);
    }
    public DiscreteCoordinate addR(int delta) {
        return new DiscreteCoordinate(l, u, r + delta);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscreteCoordinate that = (DiscreteCoordinate) o;
        return l == that.l && u == that.u && r == that.r;
    }

    @Override
    public int hashCode() {
        return Objects.hash(l, u, r);
    }
}
