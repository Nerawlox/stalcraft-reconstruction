/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.IOException;
import java.io.InputStream;

public abstract class GeneratedInputStream
extends InputStream {
    private byte[] _buf;
    private int _off;
    private boolean _isClosed;

    public int available() throws IOException {
        return this._buf == null ? 0 : this._buf.length - this._off;
    }

    public void close() throws IOException {
        this._isClosed = true;
    }

    public synchronized void mark(int n) {
    }

    public boolean markSupported() {
        return false;
    }

    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    public int read() throws IOException {
        if (this.isAvailable()) {
            return this._buf[this._off++] & 0xFF;
        }
        return -1;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = 0;
        while (n2 > 0 && this.isAvailable()) {
            int n4 = Math.min(this._buf.length - this._off, n2 - n3);
            System.arraycopy(this._buf, this._off, byArray, n, n4);
            n3 += n4;
            n += n4;
            n2 -= n4;
            this._off += n4;
        }
        return n3;
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public long skip(long l) throws IOException {
        long l2 = 0L;
        byte[] byArray = new byte[1024];
        while (l > 0L && this.isAvailable()) {
            int n = this.read(byArray, 0, (int)Math.min((long)byArray.length, l));
            l -= (long)n;
            l2 += (long)n;
        }
        return l2;
    }

    protected abstract byte[] nextBuffer() throws IOException;

    private boolean isAvailable() throws IOException {
        if (this._isClosed) {
            throw new IOException("stream is closed");
        }
        if (this._buf == null || this._off >= this._buf.length) {
            this._buf = this.nextBuffer();
            this._off = 0;
        }
        return this._buf != null;
    }
}

