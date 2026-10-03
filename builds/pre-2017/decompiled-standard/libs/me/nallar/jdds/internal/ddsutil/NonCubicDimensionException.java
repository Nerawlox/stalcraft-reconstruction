/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.ddsutil;

public class NonCubicDimensionException
extends IllegalArgumentException {
    public NonCubicDimensionException() {
        super("MipMaps can not be generated, The image dimensions must be a power of 2");
    }
}

