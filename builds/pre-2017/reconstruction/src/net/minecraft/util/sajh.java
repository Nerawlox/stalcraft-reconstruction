/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import gloomyfolken.mods.anticheat.pidb;
import java.util.Random;

public class sajh {
    public static final int _a = 12;
    public static final int _b = 4095;
    public static final int _c = 4096;
    public static final float _d = (float)Math.PI;
    public static final float _e = (float)Math.PI * 2;
    public static final float _f = 1.5707964f;
    public static final float _g = (float)Math.PI * 2;
    public static final float _h = 360.0f;
    public static final float _i = 651.8986f;
    public static final float _j = 11.377778f;
    public static final float _k = (float)Math.PI / 180;
    public static final float[] _l;
    public static boolean _m;
    public static float[] _n;

    public static final float _a(float f) {
        float f2 = pidb._a(null, f);
        return f2;
    }

    public static final float _b(float f) {
        float f2 = pidb._b(null, f);
        return f2;
    }

    public static final float _c(float f) {
        return (float)Math.sqrt(f);
    }

    public static final float _a(double d) {
        return (float)Math.sqrt(d);
    }

    public static int _d(float f) {
        int n = (int)f;
        return f < (float)n ? n - 1 : n;
    }

    public static int _b(double d) {
        return (int)(d + 1024.0) - 1024;
    }

    public static int _c(double d) {
        int n = (int)d;
        return d < (double)n ? n - 1 : n;
    }

    public static long _d(double d) {
        long l = (long)d;
        return d < (double)l ? l - 1L : l;
    }

    public static float _e(float f) {
        return f >= 0.0f ? f : -f;
    }

    public static int _a(int n) {
        return n >= 0 ? n : -n;
    }

    public static int _f(float f) {
        int n = (int)f;
        return f > (float)n ? n + 1 : n;
    }

    public static int _e(double d) {
        int n = (int)d;
        return d > (double)n ? n + 1 : n;
    }

    public static int _a(int n, int n2, int n3) {
        return n < n2 ? n2 : (n > n3 ? n3 : n);
    }

    public static float _a(float f, float f2, float f3) {
        return f < f2 ? f2 : (f > f3 ? f3 : f);
    }

    public static double _a(double d, double d2) {
        if (d < 0.0) {
            d = -d;
        }
        if (d2 < 0.0) {
            d2 = -d2;
        }
        return d > d2 ? d : d2;
    }

    public static int _a(int n, int n2) {
        return n < 0 ? -((-n - 1) / n2) - 1 : n / n2;
    }

    public static boolean _a(String string) {
        return string == null || string.length() == 0;
    }

    public static int _a(Random random, int n, int n2) {
        return n >= n2 ? n : random.nextInt(n2 - n + 1) + n;
    }

    public static double _a(Random random, double d, double d2) {
        return d >= d2 ? d : random.nextDouble() * (d2 - d) + d;
    }

    public static double _a(long[] lArray) {
        long l = 0L;
        long[] lArray2 = lArray;
        int n = lArray.length;
        for (int i = 0; i < n; ++i) {
            long l2 = lArray2[i];
            l += l2;
        }
        return (double)l / (double)lArray.length;
    }

    public static float _g(float f) {
        if ((f %= 360.0f) >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static double _f(double d) {
        if ((d %= 360.0) >= 180.0) {
            d -= 360.0;
        }
        if (d < -180.0) {
            d += 360.0;
        }
        return d;
    }

    public static int _a(String string, int n) {
        int n2 = n;
        try {
            n2 = Integer.parseInt(string);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return n2;
    }

    public static int _a(String string, int n, int n2) {
        int n3 = n;
        try {
            n3 = Integer.parseInt(string);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (n3 < n2) {
            n3 = n2;
        }
        return n3;
    }

    public static double _a(String string, double d) {
        double d2 = d;
        try {
            d2 = Double.parseDouble(string);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return d2;
    }

    public static double _a(String string, double d, double d2) {
        double d3 = d;
        try {
            d3 = Double.parseDouble(string);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (d3 < d2) {
            d3 = d2;
        }
        return d3;
    }

    static {
        int n;
        _l = new float[4096];
        _m = false;
        _n = new float[65536];
        for (n = 0; n < 65536; ++n) {
            sajh._n[n] = (float)Math.sin((double)n * Math.PI * 2.0 / 65536.0);
        }
        for (n = 0; n < 4096; ++n) {
            sajh._l[n] = (float)Math.sin(((float)n + 0.5f) / 4096.0f * ((float)Math.PI * 2));
        }
        for (n = 0; n < 360; n += 90) {
            sajh._l[(int)((float)n * 11.377778f) & 0xFFF] = (float)Math.sin((float)n * ((float)Math.PI / 180));
        }
    }
}

