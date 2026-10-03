/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.jxtc;

public class jgro {
    public final jxtc _a;
    public final int _b;
    public final float _c;
    public final float _d;
    public final String _e;
    public final float _f;

    public jgro(jxtc jxtc2, int n, float f, float f2, String string, float f3) {
        this._a = jxtc2;
        this._b = n;
        this._c = f2;
        this._d = f;
        this._e = string;
        this._f = f3;
    }

    public jxtc _a() {
        return this._a;
    }

    public float _b() {
        return this._c;
    }

    public boolean _c() {
        return this._a.func_76346_g() instanceof EntityLivingBase;
    }

    public String _d() {
        return this._e;
    }

    public String _e() {
        return this._a().func_76346_g() == null ? null : this._a().func_76346_g().func_96090_ax();
    }

    public float _f() {
        if (this._a == jxtc.field_76380_i) {
            return Float.MAX_VALUE;
        }
        return this._f;
    }
}

