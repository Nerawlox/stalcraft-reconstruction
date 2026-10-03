/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.Vec3;

public class Vec3Pool {
    public final int _a;
    public final int _b;
    public final List _c = new ArrayList();
    public int _d;
    public int _e;
    public int _f;

    public Vec3Pool(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    public Vec3 _a(double d, double d2, double d3) {
        Vec3 vec3;
        if (this._e()) {
            return new Vec3(this, d, d2, d3);
        }
        if (this._d >= this._c.size()) {
            vec3 = new Vec3(this, d, d2, d3);
            this._c.add(vec3);
        } else {
            vec3 = (Vec3)this._c.get(this._d);
            vec3._b(d, d2, d3);
        }
        ++this._d;
        return vec3;
    }

    public void _a() {
        if (this._e()) {
            return;
        }
        if (this._d > this._e) {
            this._e = this._d;
        }
        if (this._f++ == this._a) {
            int n = Math.max(this._e, this._c.size() - this._b);
            while (this._c.size() > n) {
                this._c.remove(n);
            }
            this._e = 0;
            this._f = 0;
        }
        this._d = 0;
    }

    public void _b() {
        if (this._e()) {
            return;
        }
        this._d = 0;
        this._c.clear();
    }

    public int _c() {
        return this._c.size();
    }

    public int _d() {
        return this._d;
    }

    public boolean _e() {
        return this._b < 0 || this._a < 0;
    }
}

