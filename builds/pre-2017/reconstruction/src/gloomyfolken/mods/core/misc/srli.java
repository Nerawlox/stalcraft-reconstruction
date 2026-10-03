/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.core.misc.amww;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.item.ItemStack;

public interface srli
extends amww {
    public static final String _a = "stats_random";

    default public boolean _a(ItemStack itemStack) {
        return ncwh._c(itemStack)._c(_a);
    }

    default public float _f_(ItemStack itemStack) {
        return ncwh._c(itemStack)._h(_a);
    }

    default public float _e(ItemStack itemStack) {
        return Math.max(0.0f, 1.0f + this._f_(itemStack) * this._a());
    }

    default public void _f(ItemStack itemStack) {
        if (!this._a(itemStack)) {
            ncwh._b(itemStack)._a(_a, (float)ThreadLocalRandom.current().nextGaussian());
        }
    }

    default public float _a() {
        return 0.1f;
    }
}

