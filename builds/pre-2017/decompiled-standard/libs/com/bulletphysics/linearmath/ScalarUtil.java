/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

public class ScalarUtil {
    public static float fsel(float a, float b, float c) {
        return a >= 0.0f ? b : c;
    }

    public static boolean fuzzyZero(float x) {
        return Math.abs(x) < 1.1920929E-7f;
    }

    public static float atan2Fast(float y, float x) {
        float angle;
        float coeff_1 = 0.7853982f;
        float coeff_2 = 3.0f * coeff_1;
        float abs_y = Math.abs(y);
        if (x >= 0.0f) {
            float r = (x - abs_y) / (x + abs_y);
            angle = coeff_1 - coeff_1 * r;
        } else {
            float r = (x + abs_y) / (abs_y - x);
            angle = coeff_2 - coeff_1 * r;
        }
        return y < 0.0f ? -angle : angle;
    }
}

