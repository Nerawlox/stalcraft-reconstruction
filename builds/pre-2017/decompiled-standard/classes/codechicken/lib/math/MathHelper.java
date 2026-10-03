/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.math;

import net.minecraft.util.sajh;

public class MathHelper {
    public static final double phi = 1.618033988749894;
    public static final double pi = Math.PI;
    public static final double todeg = 57.29577951308232;
    public static final double torad = 0.017453292519943;
    public static final double sqrt2 = 1.414213562373095;
    public static double[] SIN_TABLE = new double[65536];

    public static double sin(double d) {
        return SIN_TABLE[(int)((float)d * 10430.378f) & 0xFFFF];
    }

    public static double cos(double d) {
        return SIN_TABLE[(int)((float)d * 10430.378f + 16384.0f) & 0xFFFF];
    }

    public static float approachLinear(float f, float f2, float f3) {
        return f > f2 ? (f - f2 < f3 ? f2 : f - f3) : (f2 - f < f3 ? f2 : f + f3);
    }

    public static double approachLinear(double d, double d2, double d3) {
        return d > d2 ? (d - d2 < d3 ? d2 : d - d3) : (d2 - d < d3 ? d2 : d + d3);
    }

    public static float interpolate(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    public static double interpolate(double d, double d2, double d3) {
        return d + (d2 - d) * d3;
    }

    public static double approachExp(double d, double d2, double d3) {
        return d + (d2 - d) * d3;
    }

    public static double approachExp(double d, double d2, double d3, double d4) {
        double d5 = (d2 - d) * d3;
        if (Math.abs(d5) > d4) {
            d5 = Math.signum(d5) * d4;
        }
        return d + d5;
    }

    public static double retreatExp(double d, double d2, double d3, double d4, double d5) {
        double d6 = (Math.abs(d3 - d) + d5) * d4;
        if (d6 > Math.abs(d2 - d)) {
            return d2;
        }
        return d + Math.signum(d2 - d) * d6;
    }

    public static double clip(double d, double d2, double d3) {
        if (d > d3) {
            d = d3;
        }
        if (d < d2) {
            d = d2;
        }
        return d;
    }

    public static boolean between(double d, double d2, double d3) {
        return d <= d2 && d2 <= d3;
    }

    public static int approachExpI(int n, int n2, double d) {
        int n3 = (int)Math.round(MathHelper.approachExp(n, n2, d));
        return n3 == n ? n2 : n3;
    }

    public static int retreatExpI(int n, int n2, int n3, double d, int n4) {
        int n5 = (int)Math.round(MathHelper.retreatExp(n, n2, n3, d, n4));
        return n5 == n ? n2 : n5;
    }

    public static int floor_double(double d) {
        return sajh._c(d);
    }

    public static int roundAway(double d) {
        return (int)(d < 0.0 ? Math.floor(d) : Math.ceil(d));
    }

    public static int compare(int n, int n2) {
        return n == n2 ? 0 : (n < n2 ? -1 : 1);
    }

    public static int compare(double d, double d2) {
        return d == d2 ? 0 : (d < d2 ? -1 : 1);
    }

    static {
        for (int i = 0; i < 65536; ++i) {
            MathHelper.SIN_TABLE[i] = Math.sin((double)i / 65536.0 * 2.0 * Math.PI);
        }
        MathHelper.SIN_TABLE[0] = 0.0;
        MathHelper.SIN_TABLE[16384] = 1.0;
        MathHelper.SIN_TABLE[32768] = 0.0;
        MathHelper.SIN_TABLE[49152] = 1.0;
    }
}

