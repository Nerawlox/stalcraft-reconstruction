/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.model;

import gr.zdimensions.jsquish.Squish;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import me.nallar.jdds.internal.ddsutil.ByteBufferedImage;
import me.nallar.jdds.internal.model.AbstractTextureMap;

public class SingleTextureMap
extends AbstractTextureMap {
    final BufferedImage bi;

    public SingleTextureMap(BufferedImage bi) {
        this.bi = bi;
    }

    @Override
    public ByteBuffer[] getDXTCompressedBuffer(Squish.CompressionType compressionType) {
        ByteBuffer[] buffer = new ByteBuffer[]{super.compress(this.bi, compressionType)};
        return buffer;
    }

    @Override
    public int getHeight() {
        return this.bi.getHeight();
    }

    @Override
    public int getWidth() {
        return this.bi.getWidth();
    }

    @Override
    public ByteBuffer[] getUncompressedBuffer() {
        ByteBuffer[] mipmapBuffer = new ByteBuffer[]{ByteBuffer.wrap(ByteBufferedImage.convertBIintoARGBArray(this.bi))};
        return mipmapBuffer;
    }
}

