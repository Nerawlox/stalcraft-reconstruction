/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.model;

import java.io.File;
import me.nallar.jdds.internal.ddsutil.PixelFormats;
import me.nallar.jdds.internal.model.MipMaps;
import me.nallar.jdds.internal.model.TextureImage;

public abstract class AbstractTextureImage
implements TextureImage {
    protected int height;
    protected int width;
    protected int pixelformat;
    protected File file = null;
    protected boolean hasMipMaps = false;
    protected int numMipMaps = 0;
    protected MipMaps mipMaps = new MipMaps();

    public File getFile() {
        return this.file;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getPixelformat() {
        return this.pixelformat;
    }

    public boolean hasMipMaps() {
        return this.hasMipMaps;
    }

    public int getNumMipMaps() {
        return this.numMipMaps;
    }

    public boolean isCompressed() {
        return PixelFormats.isDXTCompressed(this.pixelformat);
    }

    public static boolean isPowerOfTwo(int value) {
        double p = Math.floor(Math.log(value) / Math.log(2.0));
        double n = Math.pow(2.0, p);
        return n == (double)value;
    }
}

