/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.eidj;

public class pidb {
    public final int _a;
    public final int _b;
    public final List _c = new ArrayList();
    public int _d;
    public int _e;
    public int _f;

    public pidb(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    public eidj _a(double d, double d2, double d3, double d4, double d5, double d6) {
        eidj eidj2;
        if (this._d >= this._c.size()) {
            eidj2 = new eidj(d, d2, d3, d4, d5, d6);
            this._c.add(eidj2);
        } else {
            eidj2 = (eidj)this._c.get(this._d);
            eidj2._b(d, d2, d3, d4, d5, d6);
        }
        ++this._d;
        return eidj2;
    }

    public void _a() {
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
        this._d = 0;
        this._c.clear();
    }

    public int _c() {
        return this._c.size();
    }

    public int _d() {
        return this._d;
    }
}

