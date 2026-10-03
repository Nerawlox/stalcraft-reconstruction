/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.util.sajh;

public enum ugqi {
    _a,
    _b,
    _c,
    _d,
    _e,
    _f;


    public int _a(double d) {
        double d2 = d - ((double)sajh._c(d) + 0.5);
        switch (this) {
            case _a: {
                if (d2 < 0.0 ? d2 < -0.3125 : d2 < 0.3125) {
                    return sajh._e(d * 32.0);
                }
                return sajh._c(d * 32.0);
            }
            case _b: {
                if (d2 < 0.0 ? d2 < -0.3125 : d2 < 0.3125) {
                    return sajh._c(d * 32.0);
                }
                return sajh._e(d * 32.0);
            }
            case _c: {
                if (d2 > 0.0) {
                    return sajh._c(d * 32.0);
                }
                return sajh._e(d * 32.0);
            }
            case _d: {
                if (d2 < 0.0 ? d2 < -0.1875 : d2 < 0.1875) {
                    return sajh._e(d * 32.0);
                }
                return sajh._c(d * 32.0);
            }
            case _e: {
                if (d2 < 0.0 ? d2 < -0.1875 : d2 < 0.1875) {
                    return sajh._c(d * 32.0);
                }
                return sajh._e(d * 32.0);
            }
        }
        if (d2 > 0.0) {
            return sajh._e(d * 32.0);
        }
        return sajh._c(d * 32.0);
    }
}

