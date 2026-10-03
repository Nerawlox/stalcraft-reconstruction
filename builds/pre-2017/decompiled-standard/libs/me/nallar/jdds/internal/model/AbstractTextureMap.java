/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.model;

import gr.zdimensions.jsquish.Squish;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import javax.activation.UnsupportedDataTypeException;
import me.nallar.jdds.internal.compression.DXTBufferCompressor;
import me.nallar.jdds.internal.ddsutil.PixelFormats;
import me.nallar.jdds.internal.model.TextureMap;

public abstract class AbstractTextureMap
implements TextureMap {
    @Override
    public ByteBuffer[] getDXTCompressedBuffer(int pixelformat) throws UnsupportedDataTypeException {
        Squish.CompressionType compressionType = PixelFormats.getSquishCompressionFormat(pixelformat);
        return this.getDXTCompressedBuffer(compressionType);
    }

    public ByteBuffer compress(BufferedImage bi, Squish.CompressionType compressionType) {
        DXTBufferCompressor compi = new DXTBufferCompressor(bi, compressionType);
        return compi.getByteBuffer();
    }
}

