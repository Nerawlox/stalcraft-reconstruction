/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.core.misc.amww;
import java.util.concurrent.ThreadLocalRandom;

public interface srli
extends amww {
    public static final String _a = "stats_random";

    default public boolean _a(cvzo cvzo2) {
        return ncwh._c(cvzo2)._c(_a);
    }

    default public float _f_(cvzo cvzo2) {
        return ncwh._c(cvzo2)._h(_a);
    }

    default public float _e(cvzo cvzo2) {
        return Math.max(0.0f, 1.0f + this._f_(cvzo2) * this._a());
    }

    default public void _f(cvzo cvzo2) {
        if (!this._a(cvzo2)) {
            ncwh._b(cvzo2)._a(_a, (float)ThreadLocalRandom.current().nextGaussian());
        }
    }

    default public float _a() {
        return 0.1f;
    }
}

