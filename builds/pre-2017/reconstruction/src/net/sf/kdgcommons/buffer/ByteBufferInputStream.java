/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferInputStream
extends InputStream {
    private ByteBuffer _buf;
    private int _mark = -1;
    private boolean _isClosed = false;

    public ByteBufferInputStream(ByteBuffer byteBuffer) {
        this(byteBuffer, 0);
    }

    public ByteBufferInputStream(ByteBuffer byteBuffer, int n) {
        this._buf = byteBuffer;
        this._buf.position(n);
    }

    public int available() throws IOException {
        return this._buf.limit() - this._buf.position();
    }

    public void close() throws IOException {
        this._isClosed = true;
    }

    public synchronized void mark(int n) {
        this._mark = this._buf.position();
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        if (this._isClosed) {
            throw new IOException("stream is closed");
        }
        if (this.available() <= 0) {
            return -1;
        }
        return this._buf.get() & 0xFF;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        if (this._isClosed) {
            throw new IOException("stream is closed");
        }
        int n3 = Math.min(n2, this.available());
        if (n3 == 0) {
            return -1;
        }
        this._buf.get(byArray, n, n3);
        return n3;
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public synchronized void reset() throws IOException {
        if (this._mark < 0) {
            throw new IOException("mark not set");
        }
        this._buf.position(this._mark);
    }

    public long skip(long l) throws IOException {
        int n = l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)l;
        int n2 = Math.min(n, this.available());
        int n3 = n2 + this._buf.position();
        this._buf.position(n3);
        return n2;
    }
}

