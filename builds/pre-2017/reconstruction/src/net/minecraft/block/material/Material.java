/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block.material;

import net.minecraft.block.material.MapColor;

public class Material {
    public static final Material _a = new jipp(MapColor._b);
    public static final Material _b = new Material(MapColor._c);
    public static final Material _c = new Material(MapColor._l);
    public static final Material _d = new Material(MapColor._o)._g();
    public static final Material _e = new Material(MapColor._m)._f();
    public static final Material _f = new Material(MapColor._h)._f();
    public static final Material _g = new Material(MapColor._h)._f()._o();
    public static final Material _h = new ndzx(MapColor._n)._n();
    public static final Material _i = new ndzx(MapColor._f)._n();
    public static final Material _j = new Material(MapColor._i)._g()._e()._n();
    public static final Material _k = new stkg(MapColor._i)._n();
    public static final Material _l = new stkg(MapColor._i)._g()._n()._i();
    public static final Material _m = new Material(MapColor._e);
    public static final Material _n = new Material(MapColor._e)._g();
    public static final Material _o = new jipp(MapColor._b)._n();
    public static final Material _p = new Material(MapColor._d);
    public static final Material _q = new stkg(MapColor._b)._n();
    public static final Material _r = new stkg(MapColor._e)._g();
    public static final Material _s = new Material(MapColor._b)._e()._p();
    public static final Material _t = new Material(MapColor._b)._p();
    public static final Material _u = new Material(MapColor._f)._g()._e();
    public static final Material _v = new Material(MapColor._i)._n();
    public static final Material _w = new Material(MapColor._g)._e()._p();
    public static final Material _x = new stkg(MapColor._j)._i()._e()._f()._n();
    public static final Material _y = new Material(MapColor._j)._f();
    public static final Material _z = new Material(MapColor._i)._e()._n();
    public static final Material _A = new Material(MapColor._k);
    public static final Material _B = new Material(MapColor._i)._n();
    public static final Material _C = new Material(MapColor._i)._n();
    public static final Material _D = new jipn(MapColor._b)._o();
    public static final Material _E = new Material(MapColor._b)._n();
    public static final Material _F = new vlru(MapColor._e)._f()._n();
    public static final Material _G = new Material(MapColor._m)._o();
    public boolean _H;
    public boolean _I;
    public boolean _J;
    public final MapColor _K;
    public boolean _L = true;
    public int _M;
    public boolean _N;

    public Material(MapColor mapColor) {
        this._K = mapColor;
    }

    public boolean _d() {
        return false;
    }

    public boolean _a() {
        return true;
    }

    public boolean _b() {
        return true;
    }

    public boolean _c() {
        return true;
    }

    public Material _e() {
        this._J = true;
        return this;
    }

    public Material _f() {
        this._L = false;
        return this;
    }

    public Material _g() {
        this._H = true;
        return this;
    }

    public boolean _h() {
        return this._H;
    }

    public Material _i() {
        this._I = true;
        return this;
    }

    public boolean _j() {
        return this._I;
    }

    public boolean _k() {
        if (this._J) {
            return false;
        }
        return this._c();
    }

    public boolean _l() {
        return this._L;
    }

    public int _m() {
        return this._M;
    }

    public Material _n() {
        this._M = 1;
        return this;
    }

    public Material _o() {
        this._M = 2;
        return this;
    }

    public Material _p() {
        this._N = true;
        return this;
    }

    public boolean _q() {
        return this._N;
    }
}

