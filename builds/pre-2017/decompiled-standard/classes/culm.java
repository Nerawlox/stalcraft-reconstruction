/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.amww;
import gloomyfolken.mods.core.misc.ezey;
import net.minecraft.util.jxtc;

public interface culm
extends amww {
    default public float _c_(cvzo cvzo2) {
        if (!cvzo2._f()) {
            return 1.0f;
        }
        if (cvzo2._j() == cvzo2._k()) {
            return 0.0f;
        }
        float f = this._g(cvzo2);
        if (f < 0.25f) {
            return 1.0f;
        }
        if (f < 0.5f) {
            return culm._a(1.0f, 0.95f, (f - 0.25f) * 4.0f);
        }
        if (f < 0.75f) {
            return culm._a(0.95f, 0.8f, (f - 0.5f) * 4.0f);
        }
        return culm._a(0.8f, 0.5f, (f - 0.75f) * 4.0f);
    }

    default public float _g(cvzo cvzo2) {
        if (!cvzo2._f()) {
            return 0.0f;
        }
        if (cvzo2._j() == cvzo2._k()) {
            return 1.0f;
        }
        return (float)(this._h(cvzo2) / (double)cvzo2._k());
    }

    default public double _h(cvzo cvzo2) {
        double d = ncwh._c(cvzo2)._i("dmg");
        if (!Double.isFinite(d)) {
            int n = this._h().getMaxDamage(cvzo2);
            this._a(cvzo2, n);
            return n;
        }
        return d;
    }

    default public void _a(cvzo cvzo2, double d) {
        ncwh._b(cvzo2)._a("dmg", Math.min(d, (double)this._h().getMaxDamage(cvzo2)));
    }

    default public void _b(cvzo cvzo2, double d) {
        int n = this._h().getMaxDamage(cvzo2);
        if (n > 0 && GloomyCore.enableItemsDamage) {
            this._a(cvzo2, Math.min((double)n, this._h(cvzo2) + d));
        }
    }

    default public void _a(cvzo cvzo2, jxtc jxtc2, double d) {
        d = Math.min(d, 20.0);
        pjov pjov2 = this._i(cvzo2);
        if (pjov2 != null) {
            d *= (double)pjov2._a(ezey._a(jxtc2));
        }
        this._b(cvzo2, d);
    }

    default public pjov _i(cvzo cvzo2) {
        return null;
    }

    public static float _a(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }
}

