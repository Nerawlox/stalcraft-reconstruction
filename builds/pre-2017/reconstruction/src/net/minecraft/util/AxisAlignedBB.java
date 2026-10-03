/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.kjui;
import net.minecraft.util.pidb;

public class AxisAlignedBB {
    public static final ThreadLocal _a = new kjui();
    public double _b;
    public double _c;
    public double _d;
    public double _e;
    public double _f;
    public double _g;

    public static AxisAlignedBB _a(double d, double d2, double d3, double d4, double d5, double d6) {
        return new AxisAlignedBB(d, d2, d3, d4, d5, d6);
    }

    public static pidb _a() {
        return (pidb)_a.get();
    }

    public AxisAlignedBB(double d, double d2, double d3, double d4, double d5, double d6) {
        this._b = d;
        this._c = d2;
        this._d = d3;
        this._e = d4;
        this._f = d5;
        this._g = d6;
    }

    public AxisAlignedBB _b(double d, double d2, double d3, double d4, double d5, double d6) {
        this._b = d;
        this._c = d2;
        this._d = d3;
        this._e = d4;
        this._f = d5;
        this._g = d6;
        return this;
    }

    public AxisAlignedBB _a(double d, double d2, double d3) {
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
        return AxisAlignedBB._a()._a(d4, d5, d6, d7, d8, d9);
    }

    public AxisAlignedBB _b(double d, double d2, double d3) {
        double d4 = this._b - d;
        double d5 = this._c - d2;
        double d6 = this._d - d3;
        double d7 = this._e + d;
        double d8 = this._f + d2;
        double d9 = this._g + d3;
        return AxisAlignedBB._a()._a(d4, d5, d6, d7, d8, d9);
    }

    public AxisAlignedBB _a(AxisAlignedBB axisAlignedBB) {
        double d = Math.min(this._b, axisAlignedBB._b);
        double d2 = Math.min(this._c, axisAlignedBB._c);
        double d3 = Math.min(this._d, axisAlignedBB._d);
        double d4 = Math.max(this._e, axisAlignedBB._e);
        double d5 = Math.max(this._f, axisAlignedBB._f);
        double d6 = Math.max(this._g, axisAlignedBB._g);
        return AxisAlignedBB._a()._a(d, d2, d3, d4, d5, d6);
    }

    public AxisAlignedBB _c(double d, double d2, double d3) {
        return AxisAlignedBB._a()._a(this._b + d, this._c + d2, this._d + d3, this._e + d, this._f + d2, this._g + d3);
    }

    public double _a(AxisAlignedBB axisAlignedBB, double d) {
        double d2;
        if (axisAlignedBB._f <= this._c || axisAlignedBB._c >= this._f) {
            return d;
        }
        if (axisAlignedBB._g <= this._d || axisAlignedBB._d >= this._g) {
            return d;
        }
        if (d > 0.0 && axisAlignedBB._e <= this._b && (d2 = this._b - axisAlignedBB._e) < d) {
            d = d2;
        }
        if (d < 0.0 && axisAlignedBB._b >= this._e && (d2 = this._e - axisAlignedBB._b) > d) {
            d = d2;
        }
        return d;
    }

    public double _b(AxisAlignedBB axisAlignedBB, double d) {
        double d2;
        if (axisAlignedBB._e <= this._b || axisAlignedBB._b >= this._e) {
            return d;
        }
        if (axisAlignedBB._g <= this._d || axisAlignedBB._d >= this._g) {
            return d;
        }
        if (d > 0.0 && axisAlignedBB._f <= this._c && (d2 = this._c - axisAlignedBB._f) < d) {
            d = d2;
        }
        if (d < 0.0 && axisAlignedBB._c >= this._f && (d2 = this._f - axisAlignedBB._c) > d) {
            d = d2;
        }
        return d;
    }

    public double _c(AxisAlignedBB axisAlignedBB, double d) {
        double d2;
        if (axisAlignedBB._e <= this._b || axisAlignedBB._b >= this._e) {
            return d;
        }
        if (axisAlignedBB._f <= this._c || axisAlignedBB._c >= this._f) {
            return d;
        }
        if (d > 0.0 && axisAlignedBB._g <= this._d && (d2 = this._d - axisAlignedBB._g) < d) {
            d = d2;
        }
        if (d < 0.0 && axisAlignedBB._d >= this._g && (d2 = this._g - axisAlignedBB._d) > d) {
            d = d2;
        }
        return d;
    }

    public boolean _b(AxisAlignedBB axisAlignedBB) {
        if (axisAlignedBB._e <= this._b || axisAlignedBB._b >= this._e) {
            return false;
        }
        if (axisAlignedBB._f <= this._c || axisAlignedBB._c >= this._f) {
            return false;
        }
        return !(axisAlignedBB._g <= this._d) && !(axisAlignedBB._d >= this._g);
    }

    public AxisAlignedBB _d(double d, double d2, double d3) {
        this._b += d;
        this._c += d2;
        this._d += d3;
        this._e += d;
        this._f += d2;
        this._g += d3;
        return this;
    }

    public boolean _a(Vec3 vec3) {
        if (vec3._c <= this._b || vec3._c >= this._e) {
            return false;
        }
        if (vec3._d <= this._c || vec3._d >= this._f) {
            return false;
        }
        return !(vec3._e <= this._d) && !(vec3._e >= this._g);
    }

    public double _b() {
        double d = this._e - this._b;
        double d2 = this._f - this._c;
        double d3 = this._g - this._d;
        return (d + d2 + d3) / 3.0;
    }

    public AxisAlignedBB _e(double d, double d2, double d3) {
        double d4 = this._b + d;
        double d5 = this._c + d2;
        double d6 = this._d + d3;
        double d7 = this._e - d;
        double d8 = this._f - d2;
        double d9 = this._g - d3;
        return AxisAlignedBB._a()._a(d4, d5, d6, d7, d8, d9);
    }

    public AxisAlignedBB _c() {
        return AxisAlignedBB._a()._a(this._b, this._c, this._d, this._e, this._f, this._g);
    }

    public MovingObjectPosition _a(Vec3 vec3, Vec3 vec32) {
        Vec3 vec33 = vec3._a(vec32, this._b);
        Vec3 vec34 = vec3._a(vec32, this._e);
        Vec3 vec35 = vec3._b(vec32, this._c);
        Vec3 vec36 = vec3._b(vec32, this._f);
        Vec3 vec37 = vec3._c(vec32, this._d);
        Vec3 vec38 = vec3._c(vec32, this._g);
        if (!this._b(vec33)) {
            vec33 = null;
        }
        if (!this._b(vec34)) {
            vec34 = null;
        }
        if (!this._c(vec35)) {
            vec35 = null;
        }
        if (!this._c(vec36)) {
            vec36 = null;
        }
        if (!this._d(vec37)) {
            vec37 = null;
        }
        if (!this._d(vec38)) {
            vec38 = null;
        }
        Vec3 vec39 = null;
        if (vec33 != null && (vec39 == null || vec3._e(vec33) < vec3._e(vec39))) {
            vec39 = vec33;
        }
        if (vec34 != null && (vec39 == null || vec3._e(vec34) < vec3._e(vec39))) {
            vec39 = vec34;
        }
        if (vec35 != null && (vec39 == null || vec3._e(vec35) < vec3._e(vec39))) {
            vec39 = vec35;
        }
        if (vec36 != null && (vec39 == null || vec3._e(vec36) < vec3._e(vec39))) {
            vec39 = vec36;
        }
        if (vec37 != null && (vec39 == null || vec3._e(vec37) < vec3._e(vec39))) {
            vec39 = vec37;
        }
        if (vec38 != null && (vec39 == null || vec3._e(vec38) < vec3._e(vec39))) {
            vec39 = vec38;
        }
        if (vec39 == null) {
            return null;
        }
        int n = -1;
        if (vec39 == vec33) {
            n = 4;
        }
        if (vec39 == vec34) {
            n = 5;
        }
        if (vec39 == vec35) {
            n = 0;
        }
        if (vec39 == vec36) {
            n = 1;
        }
        if (vec39 == vec37) {
            n = 2;
        }
        if (vec39 == vec38) {
            n = 3;
        }
        return new MovingObjectPosition(0, 0, 0, n, vec39);
    }

    public boolean _b(Vec3 vec3) {
        if (vec3 == null) {
            return false;
        }
        return vec3._d >= this._c && vec3._d <= this._f && vec3._e >= this._d && vec3._e <= this._g;
    }

    public boolean _c(Vec3 vec3) {
        if (vec3 == null) {
            return false;
        }
        return vec3._c >= this._b && vec3._c <= this._e && vec3._e >= this._d && vec3._e <= this._g;
    }

    public boolean _d(Vec3 vec3) {
        if (vec3 == null) {
            return false;
        }
        return vec3._c >= this._b && vec3._c <= this._e && vec3._d >= this._c && vec3._d <= this._f;
    }

    public void _c(AxisAlignedBB axisAlignedBB) {
        this._b = axisAlignedBB._b;
        this._c = axisAlignedBB._c;
        this._d = axisAlignedBB._d;
        this._e = axisAlignedBB._e;
        this._f = axisAlignedBB._f;
        this._g = axisAlignedBB._g;
    }

    public String toString() {
        return "box[" + this._b + ", " + this._c + ", " + this._d + " -> " + this._e + ", " + this._f + ", " + this._g + "]";
    }
}

