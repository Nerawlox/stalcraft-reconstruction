/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.amww;
import gloomyfolken.mods.core.misc.ezey;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public interface culm
extends amww {
    default public float _c_(ItemStack itemStack) {
        if (!itemStack._f()) {
            return 1.0f;
        }
        if (itemStack._j() == itemStack._k()) {
            return 0.0f;
        }
        float f = this._g(itemStack);
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

    default public float _g(ItemStack itemStack) {
        if (!itemStack._f()) {
            return 0.0f;
        }
        if (itemStack._j() == itemStack._k()) {
            return 1.0f;
        }
        return (float)(this._h(itemStack) / (double)itemStack._k());
    }

    default public double _h(ItemStack itemStack) {
        double d = ncwh._c(itemStack)._i("dmg");
        if (!Double.isFinite(d)) {
            int n = this._h().getMaxDamage(itemStack);
            this._a(itemStack, n);
            return n;
        }
        return d;
    }

    default public void _a(ItemStack itemStack, double d) {
        ncwh._b(itemStack)._a("dmg", Math.min(d, (double)this._h().getMaxDamage(itemStack)));
    }

    default public void _b(ItemStack itemStack, double d) {
        int n = this._h().getMaxDamage(itemStack);
        if (n > 0 && GloomyCore.enableItemsDamage) {
            this._a(itemStack, Math.min((double)n, this._h(itemStack) + d));
        }
    }

    default public void _a(ItemStack itemStack, DamageSource damageSource, double d) {
        d = Math.min(d, 20.0);
        pjov pjov2 = this._i(itemStack);
        if (pjov2 != null) {
            d *= (double)pjov2._a(ezey._a(damageSource));
        }
        this._b(itemStack, d);
    }

    default public pjov _i(ItemStack itemStack) {
        return null;
    }

    public static float _a(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }
}

