/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.core.misc.amww;

public interface vjta
extends amww {
    public static final String _c_ = "material";

    default public String _i_(cvzo cvzo2) {
        if (cvzo2._e == null || !cvzo2._e._c(_c_)) {
            return null;
        }
        return cvzo2._e._j(_c_);
    }

    default public void _a(cvzo cvzo2, String string) {
        ncwh._b(cvzo2)._a(_c_, string);
    }
}

