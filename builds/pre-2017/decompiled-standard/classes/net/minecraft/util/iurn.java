/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.ofbx;

public class iurn {
    public final int _a;
    public final int _b;
    public final List _c = new ArrayList();
    public int _d;
    public int _e;
    public int _f;

    public iurn(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    public ofbx _a(double d, double d2, double d3) {
        ofbx ofbx2;
        if (this._e()) {
            return new ofbx(this, d, d2, d3);
        }
        if (this._d >= this._c.size()) {
            ofbx2 = new ofbx(this, d, d2, d3);
            this._c.add(ofbx2);
        } else {
            ofbx2 = (ofbx)this._c.get(this._d);
            ofbx2._b(d, d2, d3);
        }
        ++this._d;
        return ofbx2;
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

