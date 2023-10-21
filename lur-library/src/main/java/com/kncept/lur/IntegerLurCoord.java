package com.kncept.lur;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class IntegerLurCoord {
    private final int l,u,r;

    public IntegerLurCoord(int l, int u, int r) {
        this.l = l;
        this.u = u;
        this.r = r;
    }

    public boolean isNormalized() {
        return l >= 0 && u >= 0 && r >= 0 && l == 0 || u == 0 || r == 0;
    }

    public IntegerLurCoord normalize() {
        // if all are positive, and at least one offset is zero, this _is_ normalized
        if (isNormalized()) return this;

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

    public List<IntegerLurCoord> encircle(int radius) {
    // build up the 6 sides

        return Collections.emptyList();
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
        return "(" + l + "," + u + "," + r + ")";
    }
}
