/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

public class qlgf {
    private static final int _a = 7;
    private static final int _b = 14;
    private static final int _c = 16383;
    private static final int _d = 16384;
    private static final int _e = (int)Math.sqrt(16384.0);
    private static final float _f = 1.0f / (float)(_e - 1);
    private static final float _g = 57.295776f;
    private static final float[] _h = new float[16384];

    public static float _a(float f, float f2) {
        return qlgf._c(f, f2) * 57.295776f;
    }

    public static float _b(float f, float f2) {
        return (float)Math.atan2(f, f2) * 57.295776f;
    }

    public static float _c(float f, float f2) {
        float f3;
        float f4;
        if (f2 < 0.0f) {
            if (f < 0.0f) {
                f2 = -f2;
                f = -f;
                f4 = 1.0f;
            } else {
                f2 = -f2;
                f4 = -1.0f;
            }
            f3 = (float)(-Math.PI);
        } else {
            if (f < 0.0f) {
                f = -f;
                f4 = -1.0f;
            } else {
                f4 = 1.0f;
            }
            f3 = 0.0f;
        }
        float f5 = 1.0f / ((f2 < f ? f : f2) * _f);
        int n = (int)(f2 * f5);
        int n2 = (int)(f * f5);
        return (_h[n2 * _e + n] + f3) * f4;
    }

    static {
        for (int i = 0; i < _e; ++i) {
            for (int j = 0; j < _e; ++j) {
                float f = (float)i / (float)_e;
                float f2 = (float)j / (float)_e;
                qlgf._h[j * qlgf._e + i] = (float)Math.atan2(f2, f);
            }
        }
    }
}

