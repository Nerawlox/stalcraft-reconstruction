/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

public class srok {
    public static long _a(int n, int n2, int n3) {
        long l = (long)(n * 3129871) ^ (long)n3 * 116129781L ^ (long)n2;
        return l * l * 42317861L + l * 11L;
    }

    public static float _a(long l) {
        return (float)(l >> 16 & 0xFL) / 15.0f;
    }

    public static float _b(long l) {
        return (float)(l >> 24 & 0xFL) / 15.0f;
    }
}

