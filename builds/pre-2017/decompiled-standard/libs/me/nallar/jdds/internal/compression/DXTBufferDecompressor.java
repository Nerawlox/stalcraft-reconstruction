/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.compression;

import gr.zdimensions.jsquish.Squish;
import java.awt.Dimension;
import java.nio.ByteBuffer;
import me.nallar.jdds.internal.compression.BufferDecompressor;

public class DXTBufferDecompressor
extends BufferDecompressor {
    public DXTBufferDecompressor(ByteBuffer compressedBuffer, int width, int height, Squish.CompressionType type2) {
        this(compressedBuffer, new Dimension(width, height), type2);
    }

    public DXTBufferDecompressor(byte[] compressedData, int width, int height, Squish.CompressionType compressionType) {
        this(ByteBuffer.wrap(compressedData), new Dimension(width, height), compressionType);
    }

    public DXTBufferDecompressor(ByteBuffer compressedBuffer, Dimension dimension, Squish.CompressionType type2) {
        this.uncompressedBuffer = DXTBufferDecompressor.squishDecompressBuffer(compressedBuffer, dimension.width, dimension.height, type2);
        this.dimension = dimension;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static byte[] squishDecompressToArray(byte[] compressedData, int width, int height, Squish.CompressionType type2) throws OutOfMemoryError {
        if (type2 != null) {
            Class<Squish> clazz = Squish.class;
            synchronized (Squish.class) {
                // ** MonitorExit[var4_4] (shouldn't be in output)
                return Squish.decompressImage(null, width, height, compressedData, type2);
            }
        }
        return compressedData;
    }

    public static ByteBuffer squishDecompress(byte[] compressedData, int width, int height, Squish.CompressionType type2) throws OutOfMemoryError {
        return ByteBuffer.wrap(DXTBufferDecompressor.squishDecompressToArray(compressedData, width, height, type2));
    }

    private static ByteBuffer squishDecompressBuffer(ByteBuffer byteBuffer, int width, int height, Squish.CompressionType type2) throws OutOfMemoryError {
        byte[] data2 = new byte[byteBuffer.capacity()];
        byteBuffer.get(data2);
        return DXTBufferDecompressor.squishDecompress(data2, width, height, type2);
    }
}

