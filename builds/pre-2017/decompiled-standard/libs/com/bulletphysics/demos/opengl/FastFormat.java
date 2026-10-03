/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.opengl;

public class FastFormat {
    private static final char[] DIGITS = "0123456789".toCharArray();

    public static void append(StringBuilder b, int i) {
        if (i < 0) {
            b.append('-');
            i = Math.abs(i);
        }
        boolean first = true;
        for (int digit = 1000000000; digit >= 1; digit /= 10) {
            int v = i / digit;
            if (v != 0 || !first) {
                b.append(DIGITS[v]);
                first = false;
            }
            i -= v * digit;
        }
        if (first) {
            b.append('0');
        }
    }

    public static void append(StringBuilder b, float f) {
        FastFormat.append(b, f, 2);
    }

    public static void append(StringBuilder b, float f, int fracDigits) {
        int mult = 10 * fracDigits;
        int val = Math.round(f * (float)mult);
        FastFormat.append(b, val / mult);
        b.append('.');
        FastFormat.append(b, Math.abs(val % mult));
    }
}

