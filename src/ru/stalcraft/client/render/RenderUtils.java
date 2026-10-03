/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.render;

public class RenderUtils {
    public static float interpolateRotation(float prev, float current, float frame) {
        float f3;
        for (f3 = current - prev; f3 < -180.0f; f3 += 360.0f) {
        }
        while (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        return prev + frame * f3;
    }
}

