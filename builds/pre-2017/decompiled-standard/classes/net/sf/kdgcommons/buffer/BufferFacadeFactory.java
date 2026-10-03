/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.buffer;

import java.nio.ByteBuffer;
import net.sf.kdgcommons.buffer.BufferFacade;
import net.sf.kdgcommons.buffer.ByteBufferThreadLocal;
import net.sf.kdgcommons.buffer.MappedFileBuffer;
import net.sf.kdgcommons.buffer.MappedFileBufferThreadLocal;

public class BufferFacadeFactory {
    public static BufferFacade create(ByteBuffer byteBuffer) {
        return new ByteBufferFacade(byteBuffer);
    }

    public static BufferFacade create(ByteBuffer byteBuffer, long l) {
        return new ByteBufferFacade(byteBuffer, (int)l);
    }

    public static BufferFacade createThreadsafe(ByteBuffer byteBuffer) {
        return new ByteBufferTLFacade(byteBuffer);
    }

    public static BufferFacade createThreadsafe(ByteBuffer byteBuffer, long l) {
        return new ByteBufferTLFacade(byteBuffer, (int)l);
    }

    public static BufferFacade create(MappedFileBuffer mappedFileBuffer) {
        return mappedFileBuffer;
    }

    public static BufferFacade create(MappedFileBuffer mappedFileBuffer, long l) {
        return new MappedFileBufferFacade(mappedFileBuffer, l);
    }

    public static BufferFacade createThreadsafe(MappedFileBuffer mappedFileBuffer) {
        return new MappedFileBufferTLFacade(mappedFileBuffer);
    }

    public static BufferFacade createThreadsafe(MappedFileBuffer mappedFileBuffer, long l) {
        return new MappedFileBufferTLFacade(mappedFileBuffer, (int)l);
    }

    public static class MappedFileBufferTLFacade
    implements BufferFacade {
        private MappedFileBufferThreadLocal _tl;
        private long _base;

        public MappedFileBufferTLFacade(MappedFileBuffer mappedFileBuffer) {
            this._tl = new MappedFileBufferThreadLocal(mappedFileBuffer);
        }

        public MappedFileBufferTLFacade(MappedFileBuffer mappedFileBuffer, long l) {
            this(mappedFileBuffer);
            this._base = l;
        }

        public byte get(long l) {
            return ((MappedFileBuffer)this._tl.get()).get(l + this._base);
        }

        public void put(long l, byte by) {
            ((MappedFileBuffer)this._tl.get()).put(l + this._base, by);
        }

        public short getShort(long l) {
            return ((MappedFileBuffer)this._tl.get()).getShort(l + this._base);
        }

        public void putShort(long l, short s) {
            ((MappedFileBuffer)this._tl.get()).putShort(l + this._base, s);
        }

        public int getInt(long l) {
            return ((MappedFileBuffer)this._tl.get()).getInt(l + this._base);
        }

        public void putInt(long l, int n) {
            ((MappedFileBuffer)this._tl.get()).putInt(l + this._base, n);
        }

        public long getLong(long l) {
            return ((MappedFileBuffer)this._tl.get()).getLong(l + this._base);
        }

        public void putLong(long l, long l2) {
            ((MappedFileBuffer)this._tl.get()).putLong(l + this._base, l2);
        }

        public float getFloat(long l) {
            return ((MappedFileBuffer)this._tl.get()).getFloat(l + this._base);
        }

        public void putFloat(long l, float f) {
            ((MappedFileBuffer)this._tl.get()).putFloat(l + this._base, f);
        }

        public double getDouble(long l) {
            return ((MappedFileBuffer)this._tl.get()).getDouble(l + this._base);
        }

        public void putDouble(long l, double d) {
            ((MappedFileBuffer)this._tl.get()).putDouble(l + this._base, d);
        }

        public char getChar(long l) {
            return ((MappedFileBuffer)this._tl.get()).getChar(l + this._base);
        }

        public void putChar(long l, char c) {
            ((MappedFileBuffer)this._tl.get()).putChar(l + this._base, c);
        }

        public byte[] getBytes(long l, int n) {
            return ((MappedFileBuffer)this._tl.get()).getBytes(l + this._base, n);
        }

        public void putBytes(long l, byte[] byArray) {
            ((MappedFileBuffer)this._tl.get()).putBytes(l + this._base, byArray);
        }

        public ByteBuffer slice(long l) {
            return ((MappedFileBuffer)this._tl.get()).slice(l + this._base);
        }

        public long capacity() {
            return ((MappedFileBuffer)this._tl.get()).capacity() - this._base;
        }

        public long limit() {
            return ((MappedFileBuffer)this._tl.get()).limit() - this._base;
        }
    }

    private static class MappedFileBufferFacade
    implements BufferFacade {
        private MappedFileBuffer _buf;
        private long _base;

        public MappedFileBufferFacade(MappedFileBuffer mappedFileBuffer) {
            this._buf = mappedFileBuffer;
        }

        public MappedFileBufferFacade(MappedFileBuffer mappedFileBuffer, long l) {
            this(mappedFileBuffer);
            this._base = l;
        }

        public byte get(long l) {
            return this._buf.get(l + this._base);
        }

        public void put(long l, byte by) {
            this._buf.put(l + this._base, by);
        }

        public short getShort(long l) {
            return this._buf.getShort(l + this._base);
        }

        public void putShort(long l, short s) {
            this._buf.putShort(l + this._base, s);
        }

        public int getInt(long l) {
            return this._buf.getInt(l + this._base);
        }

        public void putInt(long l, int n) {
            this._buf.putInt(l + this._base, n);
        }

        public long getLong(long l) {
            return this._buf.getLong(l + this._base);
        }

        public void putLong(long l, long l2) {
            this._buf.putLong(l + this._base, l2);
        }

        public float getFloat(long l) {
            return this._buf.getFloat(l + this._base);
        }

        public void putFloat(long l, float f) {
            this._buf.putFloat(l + this._base, f);
        }

        public double getDouble(long l) {
            return this._buf.getDouble(l + this._base);
        }

        public void putDouble(long l, double d) {
            this._buf.putDouble(l + this._base, d);
        }

        public char getChar(long l) {
            return this._buf.getChar(l + this._base);
        }

        public void putChar(long l, char c) {
            this._buf.putChar(l + this._base, c);
        }

        public byte[] getBytes(long l, int n) {
            return this._buf.getBytes(l + this._base, n);
        }

        public void putBytes(long l, byte[] byArray) {
            this._buf.putBytes(l + this._base, byArray);
        }

        public ByteBuffer slice(long l) {
            return this._buf.slice(l + this._base);
        }

        public long capacity() {
            return this._buf.capacity() - this._base;
        }

        public long limit() {
            return this._buf.limit() - this._base;
        }
    }

    public static class ByteBufferTLFacade
    implements BufferFacade {
        private ByteBufferThreadLocal _tl;
        private int _base;

        public ByteBufferTLFacade(ByteBuffer byteBuffer) {
            this._tl = new ByteBufferThreadLocal(byteBuffer);
        }

        public ByteBufferTLFacade(ByteBuffer byteBuffer, int n) {
            this(byteBuffer);
            this._base = n;
        }

        public byte get(long l) {
            return ((ByteBuffer)this._tl.get()).get((int)l + this._base);
        }

        public void put(long l, byte by) {
            ((ByteBuffer)this._tl.get()).put((int)l + this._base, by);
        }

        public short getShort(long l) {
            return ((ByteBuffer)this._tl.get()).getShort((int)l + this._base);
        }

        public void putShort(long l, short s) {
            ((ByteBuffer)this._tl.get()).putShort((int)l + this._base, s);
        }

        public int getInt(long l) {
            return ((ByteBuffer)this._tl.get()).getInt((int)l + this._base);
        }

        public void putInt(long l, int n) {
            ((ByteBuffer)this._tl.get()).putInt((int)l + this._base, n);
        }

        public long getLong(long l) {
            return ((ByteBuffer)this._tl.get()).getLong((int)l + this._base);
        }

        public void putLong(long l, long l2) {
            ((ByteBuffer)this._tl.get()).putLong((int)l + this._base, l2);
        }

        public float getFloat(long l) {
            return ((ByteBuffer)this._tl.get()).getFloat((int)l + this._base);
        }

        public void putFloat(long l, float f) {
            ((ByteBuffer)this._tl.get()).putFloat((int)l + this._base, f);
        }

        public double getDouble(long l) {
            return ((ByteBuffer)this._tl.get()).getDouble((int)l + this._base);
        }

        public void putDouble(long l, double d) {
            ((ByteBuffer)this._tl.get()).putDouble((int)l + this._base, d);
        }

        public char getChar(long l) {
            return ((ByteBuffer)this._tl.get()).getChar((int)l + this._base);
        }

        public void putChar(long l, char c) {
            ((ByteBuffer)this._tl.get()).putChar((int)l + this._base, c);
        }

        public byte[] getBytes(long l, int n) {
            ByteBuffer byteBuffer = (ByteBuffer)this._tl.get();
            byteBuffer.position((int)l + this._base);
            byte[] byArray = new byte[n];
            byteBuffer.get(byArray);
            return byArray;
        }

        public void putBytes(long l, byte[] byArray) {
            ByteBuffer byteBuffer = (ByteBuffer)this._tl.get();
            byteBuffer.position((int)l + this._base);
            byteBuffer.put(byArray);
        }

        public ByteBuffer slice(long l) {
            ByteBuffer byteBuffer = (ByteBuffer)this._tl.get();
            byteBuffer.position((int)l + this._base);
            return byteBuffer.slice();
        }

        public long capacity() {
            return ((ByteBuffer)this._tl.get()).capacity() - this._base;
        }

        public long limit() {
            return ((ByteBuffer)this._tl.get()).limit() - this._base;
        }
    }

    public static class ByteBufferFacade
    implements BufferFacade {
        private ByteBuffer _buf;
        private int _base;

        public ByteBufferFacade(ByteBuffer byteBuffer) {
            this._buf = byteBuffer;
        }

        public ByteBufferFacade(ByteBuffer byteBuffer, int n) {
            this(byteBuffer);
            this._base = n;
        }

        public byte get(long l) {
            return this._buf.get((int)l + this._base);
        }

        public void put(long l, byte by) {
            this._buf.put((int)l + this._base, by);
        }

        public short getShort(long l) {
            return this._buf.getShort((int)l + this._base);
        }

        public void putShort(long l, short s) {
            this._buf.putShort((int)l + this._base, s);
        }

        public int getInt(long l) {
            return this._buf.getInt((int)l + this._base);
        }

        public void putInt(long l, int n) {
            this._buf.putInt((int)l + this._base, n);
        }

        public long getLong(long l) {
            return this._buf.getLong((int)l + this._base);
        }

        public void putLong(long l, long l2) {
            this._buf.putLong((int)l + this._base, l2);
        }

        public float getFloat(long l) {
            return this._buf.getFloat((int)l + this._base);
        }

        public void putFloat(long l, float f) {
            this._buf.putFloat((int)l + this._base, f);
        }

        public double getDouble(long l) {
            return this._buf.getDouble((int)l + this._base);
        }

        public void putDouble(long l, double d) {
            this._buf.putDouble((int)l + this._base, d);
        }

        public char getChar(long l) {
            return this._buf.getChar((int)l + this._base);
        }

        public void putChar(long l, char c) {
            this._buf.putChar((int)l + this._base, c);
        }

        public byte[] getBytes(long l, int n) {
            this._buf.position((int)l + this._base);
            byte[] byArray = new byte[n];
            this._buf.get(byArray);
            return byArray;
        }

        public void putBytes(long l, byte[] byArray) {
            this._buf.position((int)l + this._base);
            this._buf.put(byArray);
        }

        public ByteBuffer slice(long l) {
            this._buf.position((int)l + this._base);
            return this._buf.slice();
        }

        public long capacity() {
            return this._buf.capacity() - this._base;
        }

        public long limit() {
            return this._buf.limit() - this._base;
        }
    }
}

