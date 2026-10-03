/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.model;

import java.io.File;
import java.io.IOException;

public interface TextureImage {
    public void write(File var1) throws IOException;

    public static enum PixelFormat {
        DXT5,
        DXT4,
        DXT3,
        DXT2,
        DXT1,
        X8R8G8B8,
        R8G8B8,
        Unknown;

    }

    public static enum TextureType {
        TEXTURE,
        CUBEMAP,
        VOLUME;

    }
}

