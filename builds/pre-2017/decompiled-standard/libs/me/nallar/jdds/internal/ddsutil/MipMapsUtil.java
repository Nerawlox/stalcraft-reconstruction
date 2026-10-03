/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.ddsutil;

public class MipMapsUtil {
    public static int calculateMaxNumberOfMipMaps(int width, int height) {
        return (int)Math.floor(Math.log(Math.max(width, height)) / Math.log(2.0)) + 1;
    }
}

