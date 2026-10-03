/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.compression;

import java.awt.Dimension;
import java.nio.ByteBuffer;
import me.nallar.jdds.internal.compression.BufferDecompressor;

public class ARGBBufferDecompressor
extends BufferDecompressor {
    public ARGBBufferDecompressor(ByteBuffer compressedBuffer, int width, int height, int pixelformat) {
        this(compressedBuffer, new Dimension(width, height), pixelformat);
    }

    public ARGBBufferDecompressor(ByteBuffer databuffer, Dimension dimension, int pixelformat) {
        this.uncompressedBuffer = this.decompressBuffer(databuffer, dimension.width, dimension.height, pixelformat);
        this.dimension = dimension;
    }

    private ByteBuffer decompressBuffer(ByteBuffer dataBuffer, int width, int height, Object pix) {
        return dataBuffer;
    }
}

