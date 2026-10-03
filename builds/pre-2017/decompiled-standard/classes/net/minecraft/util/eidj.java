/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.hank;
import net.minecraft.util.kjui;
import net.minecraft.util.ofbx;
import net.minecraft.util.pidb;

public class eidj {
    public static final ThreadLocal _a = new kjui();
    public double _b;
    public double _c;
    public double _d;
    public double _e;
    public double _f;
    public double _g;

    public static eidj _a(double d, double d2, double d3, double d4, double d5, double d6) {
        return new eidj(d, d2, d3, d4, d5, d6);
    }

    public static pidb _a() {
        return (pidb)_a.get();
    }

    public eidj(double d, double d2, double d3, double d4, double d5, double d6) {
        this._b = d;
        this._c = d2;
        this._d = d3;
        this._e = d4;
        this._f = d5;
        this._g = d6;
    }

    public eidj _b(double d, double d2, double d3, double d4, double d5, double d6) {
        this._b = d;
        this._c = d2;
        this._d = d3;
        this._e = d4;
        this._f = d5;
        this._g = d6;
        return this;
    }

    public eidj _a(double d, double d2, double d3) {
        double d4 = this._b;
        double d5 = this._c;
        double d6 = this._d;
        double d7 = this._e;
        double d8 = this._f;
        double d9 = this._g;
        if (d < 0.0) {
            d4 += d;
        }
        if (d > 0.0) {
            d7 += d;
        }
        if (d2 < 0.0) {
            d5 += d2;
        }
        if (d2 > 0.0) {
            d8 += d2;
        }
        if (d3 < 0.0) {
            d6 += d3;
        }
        if (d3 > 0.0) {
            d9 += d3;
        }
        return eidj._a()._a(d4, d5, d6, d7, d8, d9);
    }

    public eidj _b(double d, double d2, double d3) {
        double d4 = this._b - d;
        double d5 = this._c - d2;
        double d6 = this._d - d3;
        double d7 = this._e + d;
        double d8 = this._f + d2;
        double d9 = this._g + d3;
        return eidj._a()._a(d4, d5, d6, d7, d8, d9);
    }

    public eidj _a(eidj eidj2) {
        double d = Math.min(this._b, eidj2._b);
        double d2 = Math.min(this._c, eidj2._c);
        double d3 = Math.min(this._d, eidj2._d);
        double d4 = Math.max(this._e, eidj2._e);
        double d5 = Math.max(this._f, eidj2._f);
        double d6 = Math.max(this._g, eidj2._g);
        return eidj._a()._a(d, d2, d3, d4, d5, d6);
    }

    public eidj _c(double d, double d2, double d3) {
        return eidj._a()._a(this._b + d, this._c + d2, this._d + d3, this._e + d, this._f + d2, this._g + d3);
    }

    public double _a(eidj eidj2, double d) {
        double d2;
        if (eidj2._f <= this._c || eidj2._c >= this._f) {
            return d;
        }
        if (eidj2._g <= this._d || eidj2._d >= this._g) {
            return d;
        }
        if (d > 0.0 && eidj2._e <= this._b && (d2 = this._b - eidj2._e) < d) {
            d = d2;
        }
        if (d < 0.0 && eidj2._b >= this._e && (d2 = this._e - eidj2._b) > d) {
            d = d2;
        }
        return d;
    }

    public double _b(eidj eidj2, double d) {
        double d2;
        if (eidj2._e <= this._b || eidj2._b >= this._e) {
            return d;
        }
        if (eidj2._g <= this._d || eidj2._d >= this._g) {
            return d;
        }
        if (d > 0.0 && eidj2._f <= this._c && (d2 = this._c - eidj2._f) < d) {
            d = d2;
        }
        if (d < 0.0 && eidj2._c >= this._f && (d2 = this._f - eidj2._c) > d) {
            d = d2;
        }
        return d;
    }

    public double _c(eidj eidj2, double d) {
        double d2;
        if (eidj2._e <= this._b || eidj2._b >= this._e) {
            return d;
        }
        if (eidj2._f <= this._c || eidj2._c >= this._f) {
            return d;
        }
        if (d > 0.0 && eidj2._g <= this._d && (d2 = this._d - eidj2._g) < d) {
            d = d2;
        }
        if (d < 0.0 && eidj2._d >= this._g && (d2 = this._g - eidj2._d) > d) {
            d = d2;
        }
        return d;
    }

    public boolean _b(eidj eidj2) {
        if (eidj2._e <= this._b || eidj2._b >= this._e) {
            return false;
        }
        if (eidj2._f <= this._c || eidj2._c >= this._f) {
            return false;
        }
        return !(eidj2._g <= this._d) && !(eidj2._d >= this._g);
    }

    public eidj _d(double d, double d2, double d3) {
        this._b += d;
        this._c += d2;
        this._d += d3;
        this._e += d;
        this._f += d2;
        this._g += d3;
        return this;
    }

    public boolean _a(ofbx ofbx2) {
        if (ofbx2._c <= this._b || ofbx2._c >= this._e) {
            return false;
        }
        if (ofbx2._d <= this._c || ofbx2._d >= this._f) {
            return false;
        }
        return !(ofbx2._e <= this._d) && !(ofbx2._e >= this._g);
    }

    public double _b() {
        double d = this._e - this._b;
        double d2 = this._f - this._c;
        double d3 = this._g - this._d;
        return (d + d2 + d3) / 3.0;
    }

    public eidj _e(double d, double d2, double d3) {
        double d4 = this._b + d;
        double d5 = this._c + d2;
        double d6 = this._d + d3;
        double d7 = this._e - d;
        double d8 = this._f - d2;
        double d9 = this._g - d3;
        return eidj._a()._a(d4, d5, d6, d7, d8, d9);
    }

    public eidj _c() {
        return eidj._a()._a(this._b, this._c, this._d, this._e, this._f, this._g);
    }

    public hank _a(ofbx ofbx2, ofbx ofbx3) {
        ofbx ofbx4 = ofbx2._a(ofbx3, this._b);
        ofbx ofbx5 = ofbx2._a(ofbx3, this._e);
        ofbx ofbx6 = ofbx2._b(ofbx3, this._c);
        ofbx ofbx7 = ofbx2._b(ofbx3, this._f);
        ofbx ofbx8 = ofbx2._c(ofbx3, this._d);
        ofbx ofbx9 = ofbx2._c(ofbx3, this._g);
        if (!this._b(ofbx4)) {
            ofbx4 = null;
        }
        if (!this._b(ofbx5)) {
            ofbx5 = null;
        }
        if (!this._c(ofbx6)) {
            ofbx6 = null;
        }
        if (!this._c(ofbx7)) {
            ofbx7 = null;
        }
        if (!this._d(ofbx8)) {
            ofbx8 = null;
        }
        if (!this._d(ofbx9)) {
            ofbx9 = null;
        }
        ofbx ofbx10 = null;
        if (ofbx4 != null && (ofbx10 == null || ofbx2._e(ofbx4) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx4;
        }
        if (ofbx5 != null && (ofbx10 == null || ofbx2._e(ofbx5) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx5;
        }
        if (ofbx6 != null && (ofbx10 == null || ofbx2._e(ofbx6) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx6;
        }
        if (ofbx7 != null && (ofbx10 == null || ofbx2._e(ofbx7) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx7;
        }
        if (ofbx8 != null && (ofbx10 == null || ofbx2._e(ofbx8) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx8;
        }
        if (ofbx9 != null && (ofbx10 == null || ofbx2._e(ofbx9) < ofbx2._e(ofbx10))) {
            ofbx10 = ofbx9;
        }
        if (ofbx10 == null) {
            return null;
        }
        int n = -1;
        if (ofbx10 == ofbx4) {
            n = 4;
        }
        if (ofbx10 == ofbx5) {
            n = 5;
        }
        if (ofbx10 == ofbx6) {
            n = 0;
        }
        if (ofbx10 == ofbx7) {
            n = 1;
        }
        if (ofbx10 == ofbx8) {
            n = 2;
        }
        if (ofbx10 == ofbx9) {
            n = 3;
        }
        return new hank(0, 0, 0, n, ofbx10);
    }

    public boolean _b(ofbx ofbx2) {
        if (ofbx2 == null) {
            return false;
        }
        return ofbx2._d >= this._c && ofbx2._d <= this._f && ofbx2._e >= this._d && ofbx2._e <= this._g;
    }

    public boolean _c(ofbx ofbx2) {
        if (ofbx2 == null) {
            return false;
        }
        return ofbx2._c >= this._b && ofbx2._c <= this._e && ofbx2._e >= this._d && ofbx2._e <= this._g;
    }

    public boolean _d(ofbx ofbx2) {
        if (ofbx2 == null) {
            return false;
        }
        return ofbx2._c >= this._b && ofbx2._c <= this._e && ofbx2._d >= this._c && ofbx2._d <= this._f;
    }

    public void _c(eidj eidj2) {
        this._b = eidj2._b;
        this._c = eidj2._c;
        this._d = eidj2._d;
        this._e = eidj2._e;
        this._f = eidj2._f;
        this._g = eidj2._g;
    }

    public String toString() {
        return "box[" + this._b + ", " + this._c + ", " + this._d + " -> " + this._e + ", " + this._f + ", " + this._g + "]";
    }
}

