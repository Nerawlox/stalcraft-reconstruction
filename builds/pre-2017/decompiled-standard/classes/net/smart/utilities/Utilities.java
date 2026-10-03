/*
 * Decompiled with CFR 0.152.
 */
package net.smart.utilities;

public abstract class Utilities {
    public static final float Whole = (float)Math.PI * 2;
    public static final float Half = (float)Math.PI;
    public static final float Quarter = 1.5707964f;
    public static final float Eighth = 0.7853982f;
    public static final float Sixteenth = 0.3926991f;
    public static final float Thirtytwoth = 0.19634955f;
    public static final float Sixtyfourth = 0.09817477f;
    public static final float RadiantToAngle = 57.295776f;

    public static float getHorizontalCollisionangle(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (bl) {
            if (!bl2) {
                if (bl3) {
                    if (bl4) {
                        return 0.0f;
                    }
                    return 45.0f;
                }
                if (bl4) {
                    return 315.0f;
                }
                return 0.0f;
            }
            if (bl3) {
                if (!bl4) {
                    return 90.0f;
                }
            } else if (bl4) {
                return 270.0f;
            }
        } else {
            if (bl2) {
                if (bl3) {
                    if (bl4) {
                        return 180.0f;
                    }
                    return 135.0f;
                }
                if (bl4) {
                    return 225.0f;
                }
                return 180.0f;
            }
            if (bl3) {
                if (!bl4) {
                    return 90.0f;
                }
            } else if (bl4) {
                return 270.0f;
            }
        }
        return Float.NaN;
    }

    public static float getAngle(double d, double d2) {
        if (d == 0.0) {
            return d2 == 0.0 ? Float.NaN : (d2 < 0.0 ? 270.0f : 90.0f);
        }
        if (d2 == 0.0) {
            return d < 0.0 ? 180.0f : 0.0f;
        }
        float f = (float)Math.atan(d2 / d) * 57.295776f;
        return d < 0.0 ? 180.0f + f : (d2 < 0.0 && d > 0.0 ? 360.0f + f : f);
    }
}

