/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.compression;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import me.nallar.jdds.internal.ddsutil.ByteBufferedImage;

public abstract class BufferDecompressor {
    protected ByteBuffer uncompressedBuffer;
    protected Dimension dimension;

    public BufferedImage getImage() {
        return new ByteBufferedImage(this.dimension.width, this.dimension.height, this.uncompressedBuffer);
    }
}

