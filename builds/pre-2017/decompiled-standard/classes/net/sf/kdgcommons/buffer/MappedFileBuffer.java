/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.buffer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import net.sf.kdgcommons.buffer.BufferFacade;
import net.sf.kdgcommons.io.IOUtil;

public class MappedFileBuffer
implements Cloneable,
BufferFacade {
    private static final int MAX_SEGMENT_SIZE = 0x8000000;
    private File _file;
    private boolean _isWritable;
    private long _segmentSize;
    private MappedByteBuffer[] _buffers;

    public MappedFileBuffer(File file) throws IOException {
        this(file, 0x8000000, false);
    }

    public MappedFileBuffer(File file, boolean bl) throws IOException {
        this(file, 0x8000000, bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MappedFileBuffer(File file, int n, boolean bl) throws IOException {
        if (n > 0x8000000) {
            throw new IllegalArgumentException("segment size too large (max is 134217728): " + n);
        }
        this._file = file;
        this._isWritable = bl;
        this._segmentSize = n;
        RandomAccessFile randomAccessFile = null;
        try {
            String string = bl ? "rw" : "r";
            FileChannel.MapMode mapMode = bl ? FileChannel.MapMode.READ_WRITE : FileChannel.MapMode.READ_ONLY;
            randomAccessFile = new RandomAccessFile(file, string);
            FileChannel fileChannel = randomAccessFile.getChannel();
            long l = file.length();
            int n2 = (int)(l / (long)n) + (l % (long)n != 0L ? 1 : 0);
            this._buffers = new MappedByteBuffer[n2];
            int n3 = 0;
            for (long i = 0L; i < l; i += (long)n) {
                long l2 = l - i;
                long l3 = Math.min(2L * (long)n, l2);
                this._buffers[n3++] = fileChannel.map(mapMode, i, l3);
            }
        }
        catch (Throwable throwable) {
            IOUtil.closeQuietly(randomAccessFile);
            throw throwable;
        }
        IOUtil.closeQuietly(randomAccessFile);
    }

    public long capacity() {
        return this._file.length();
    }

    public long limit() {
        return this.capacity();
    }

    public File file() {
        return this._file;
    }

    public boolean isWritable() {
        return this._isWritable;
    }

    public ByteOrder getByteOrder() {
        return this._buffers[0].order();
    }

    public void setByteOrder(ByteOrder byteOrder) {
        for (MappedByteBuffer mappedByteBuffer : this._buffers) {
            mappedByteBuffer.order(byteOrder);
        }
    }

    public byte get(long l) {
        return this.buffer(l).get();
    }

    public void put(long l, byte by) {
        this.buffer(l).put(by);
    }

    public int getInt(long l) {
        return this.buffer(l).getInt();
    }

    public void putInt(long l, int n) {
        this.buffer(l).putInt(n);
    }

    public long getLong(long l) {
        return this.buffer(l).getLong();
    }

    public void putLong(long l, long l2) {
        this.buffer(l).putLong(l2);
    }

    public short getShort(long l) {
        return this.buffer(l).getShort();
    }

    public void putShort(long l, short s) {
        this.buffer(l).putShort(s);
    }

    public float getFloat(long l) {
        return this.buffer(l).getFloat();
    }

    public void putFloat(long l, float f) {
        this.buffer(l).putFloat(f);
    }

    public double getDouble(long l) {
        return this.buffer(l).getDouble();
    }

    public void putDouble(long l, double d) {
        this.buffer(l).putDouble(d);
    }

    public char getChar(long l) {
        return this.buffer(l).getChar();
    }

    public void putChar(long l, char c) {
        this.buffer(l).putChar(c);
    }

    public byte[] getBytes(long l, int n) {
        byte[] byArray = new byte[n];
        return this.getBytes(l, byArray, 0, n);
    }

    public byte[] getBytes(long l, byte[] byArray, int n, int n2) {
        while (n2 > 0) {
            ByteBuffer byteBuffer = this.buffer(l);
            int n3 = Math.min(n2, byteBuffer.remaining());
            byteBuffer.get(byArray, n, n3);
            l += (long)n3;
            n += n3;
            n2 -= n3;
        }
        return byArray;
    }

    public void putBytes(long l, byte[] byArray) {
        this.putBytes(l, byArray, 0, byArray.length);
    }

    public void putBytes(long l, byte[] byArray, int n, int n2) {
        while (n2 > 0) {
            ByteBuffer byteBuffer = this.buffer(l);
            int n3 = Math.min(n2, byteBuffer.remaining());
            byteBuffer.put(byArray, n, n3);
            l += (long)n3;
            n += n3;
            n2 -= n3;
        }
    }

    public ByteBuffer slice(long l) {
        return this.buffer(l).slice();
    }

    public void force() {
        for (MappedByteBuffer mappedByteBuffer : this._buffers) {
            mappedByteBuffer.force();
        }
    }

    public MappedFileBuffer clone() {
        try {
            MappedFileBuffer mappedFileBuffer = (MappedFileBuffer)super.clone();
            mappedFileBuffer._buffers = new MappedByteBuffer[this._buffers.length];
            for (int i = 0; i < this._buffers.length; ++i) {
                if (this._buffers[i] == null) continue;
                mappedFileBuffer._buffers[i] = (MappedByteBuffer)this._buffers[i].duplicate();
            }
            return mappedFileBuffer;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException("unreachable code", cloneNotSupportedException);
        }
    }

    protected ByteBuffer buffer(long l) {
        MappedByteBuffer mappedByteBuffer = this._buffers[(int)(l / this._segmentSize)];
        ((ByteBuffer)mappedByteBuffer).position((int)(l % this._segmentSize));
        return mappedByteBuffer;
    }
}

