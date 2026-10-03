/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.iurn;
import net.minecraft.util.sajh;

public class ofbx {
    public static final iurn _a = new iurn(-1, -1);
    public final iurn _b;
    public double _c;
    public double _d;
    public double _e;

    public static ofbx _a(double d, double d2, double d3) {
        return new ofbx(_a, d, d2, d3);
    }

    public ofbx(iurn iurn2, double d, double d2, double d3) {
        if (d == -0.0) {
            d = 0.0;
        }
        if (d2 == -0.0) {
            d2 = 0.0;
        }
        if (d3 == -0.0) {
            d3 = 0.0;
        }
        this._c = d;
        this._d = d2;
        this._e = d3;
        this._b = iurn2;
    }

    public ofbx _b(double d, double d2, double d3) {
        this._c = d;
        this._d = d2;
        this._e = d3;
        return this;
    }

    public ofbx _a(ofbx ofbx2) {
        return this._b._a(ofbx2._c - this._c, ofbx2._d - this._d, ofbx2._e - this._e);
    }

    public ofbx _a() {
        double d = sajh._a(this._c * this._c + this._d * this._d + this._e * this._e);
        if (d < 1.0E-4) {
            return this._b._a(0.0, 0.0, 0.0);
        }
        return this._b._a(this._c / d, this._d / d, this._e / d);
    }

    public double _b(ofbx ofbx2) {
        return this._c * ofbx2._c + this._d * ofbx2._d + this._e * ofbx2._e;
    }

    public ofbx _c(ofbx ofbx2) {
        return this._b._a(this._d * ofbx2._e - this._e * ofbx2._d, this._e * ofbx2._c - this._c * ofbx2._e, this._c * ofbx2._d - this._d * ofbx2._c);
    }

    public ofbx _c(double d, double d2, double d3) {
        return this._b._a(this._c + d, this._d + d2, this._e + d3);
    }

    public double _d(ofbx ofbx2) {
        double d = ofbx2._c - this._c;
        double d2 = ofbx2._d - this._d;
        double d3 = ofbx2._e - this._e;
        return sajh._a(d * d + d2 * d2 + d3 * d3);
    }

    public double _e(ofbx ofbx2) {
        double d = ofbx2._c - this._c;
        double d2 = ofbx2._d - this._d;
        double d3 = ofbx2._e - this._e;
        return d * d + d2 * d2 + d3 * d3;
    }

    public double _d(double d, double d2, double d3) {
        double d4 = d - this._c;
        double d5 = d2 - this._d;
        double d6 = d3 - this._e;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public double _b() {
        return sajh._a(this._c * this._c + this._d * this._d + this._e * this._e);
    }

    public ofbx _a(ofbx ofbx2, double d) {
        double d2 = ofbx2._c - this._c;
        double d3 = ofbx2._d - this._d;
        double d4 = ofbx2._e - this._e;
        if (d2 * d2 < (double)1.0E-7f) {
            return null;
        }
        double d5 = (d - this._c) / d2;
        if (d5 < 0.0 || d5 > 1.0) {
            return null;
        }
        return this._b._a(this._c + d2 * d5, this._d + d3 * d5, this._e + d4 * d5);
    }

    public ofbx _b(ofbx ofbx2, double d) {
        double d2 = ofbx2._c - this._c;
        double d3 = ofbx2._d - this._d;
        double d4 = ofbx2._e - this._e;
        if (d3 * d3 < (double)1.0E-7f) {
            return null;
        }
        double d5 = (d - this._d) / d3;
        if (d5 < 0.0 || d5 > 1.0) {
            return null;
        }
        return this._b._a(this._c + d2 * d5, this._d + d3 * d5, this._e + d4 * d5);
    }

    public ofbx _c(ofbx ofbx2, double d) {
        double d2 = ofbx2._c - this._c;
        double d3 = ofbx2._d - this._d;
        double d4 = ofbx2._e - this._e;
        if (d4 * d4 < (double)1.0E-7f) {
            return null;
        }
        double d5 = (d - this._e) / d4;
        if (d5 < 0.0 || d5 > 1.0) {
            return null;
        }
        return this._b._a(this._c + d2 * d5, this._d + d3 * d5, this._e + d4 * d5);
    }

    public String toString() {
        return "(" + this._c + ", " + this._d + ", " + this._e + ")";
    }

    public void _a(float f) {
        float f2 = sajh._b(f);
        float f3 = sajh._a(f);
        double d = this._c;
        double d2 = this._d * (double)f2 + this._e * (double)f3;
        double d3 = this._e * (double)f2 - this._d * (double)f3;
        this._c = d;
        this._d = d2;
        this._e = d3;
    }

    public void _b(float f) {
        float f2 = sajh._b(f);
        float f3 = sajh._a(f);
        double d = this._c * (double)f2 + this._e * (double)f3;
        double d2 = this._d;
        double d3 = this._e * (double)f2 - this._c * (double)f3;
        this._c = d;
        this._d = d2;
        this._e = d3;
    }

    public void _c(float f) {
        float f2 = sajh._b(f);
        float f3 = sajh._a(f);
        double d = this._c * (double)f2 + this._d * (double)f3;
        double d2 = this._d * (double)f2 - this._c * (double)f3;
        double d3 = this._e;
        this._c = d;
        this._d = d2;
        this._e = d3;
    }
}

