/*
 * Decompiled with CFR 0.152.
 */
package me.nallar.jdds.internal.model;

import gr.zdimensions.jsquish.Squish;
import java.nio.ByteBuffer;
import javax.activation.UnsupportedDataTypeException;

public interface TextureMap {
    public int getHeight();

    public int getWidth();

    public ByteBuffer[] getDXTCompressedBuffer(Squish.CompressionType var1);

    public ByteBuffer[] getUncompressedBuffer();

    public ByteBuffer[] getDXTCompressedBuffer(int var1) throws UnsupportedDataTypeException;
}

