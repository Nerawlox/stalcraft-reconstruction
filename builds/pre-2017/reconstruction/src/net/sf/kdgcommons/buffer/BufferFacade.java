/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.buffer;

import java.nio.ByteBuffer;

public interface BufferFacade {
    public byte get(long var1);

    public void put(long var1, byte var3);

    public short getShort(long var1);

    public void putShort(long var1, short var3);

    public int getInt(long var1);

    public void putInt(long var1, int var3);

    public long getLong(long var1);

    public void putLong(long var1, long var3);

    public float getFloat(long var1);

    public void putFloat(long var1, float var3);

    public double getDouble(long var1);

    public void putDouble(long var1, double var3);

    public char getChar(long var1);

    public void putChar(long var1, char var3);

    public byte[] getBytes(long var1, int var3);

    public void putBytes(long var1, byte[] var3);

    public ByteBuffer slice(long var1);

    public long capacity();

    public long limit();
}

