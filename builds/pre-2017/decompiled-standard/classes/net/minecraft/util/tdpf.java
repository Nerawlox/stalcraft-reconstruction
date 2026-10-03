/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.client.xpzm;

public class tdpf {
    public float _a;
    public double _b;
    public int _c;
    public float _d;
    public float _e = 1.0f;
    public float _f;
    public long _g;
    public long _h;
    public long _i;
    public double _j = 1.0;

    public tdpf(float f) {
        this._a = f;
        this._g = xpzm._M();
        this._h = System.nanoTime() / 1000000L;
    }

    public void _a() {
        long l = xpzm._M();
        long l2 = l - this._g;
        long l3 = System.nanoTime() / 1000000L;
        double d = (double)l3 / 1000.0;
        if (l2 > 1000L || l2 < 0L) {
            this._b = d;
        } else {
            this._i += l2;
            if (this._i > 1000L) {
                long l4 = l3 - this._h;
                double d2 = (double)this._i / (double)l4;
                this._j += (d2 - this._j) * (double)0.2f;
                this._h = l3;
                this._i = 0L;
            }
            if (this._i < 0L) {
                this._h = l3;
            }
        }
        this._g = l;
        double d3 = (d - this._b) * this._j;
        this._b = d;
        if (d3 < 0.0) {
            d3 = 0.0;
        }
        if (d3 > 1.0) {
            d3 = 1.0;
        }
        this._f = (float)((double)this._f + d3 * (double)this._e * (double)this._a);
        this._c = (int)this._f;
        this._f -= (float)this._c;
        if (this._c > 10) {
            this._c = 10;
        }
        this._d = this._f;
    }
}

