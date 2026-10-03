/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.IOException;
import java.io.InputStream;

public class MonitoredInputStream
extends InputStream {
    private InputStream _delegate;
    private long _totalBytes;

    public MonitoredInputStream(InputStream inputStream) {
        this._delegate = inputStream;
    }

    public int available() throws IOException {
        return this._delegate.available();
    }

    public void close() throws IOException {
        this._delegate.close();
    }

    public int read() throws IOException {
        int n = this._delegate.read();
        long l = n < 0 ? 0L : 1L;
        this._totalBytes += l;
        this.progress(l, this._totalBytes);
        return n;
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = this._delegate.read(byArray, n, n2);
        long l = n3 < 0 ? 0L : (long)n3;
        this._totalBytes += l;
        this.progress(l, this._totalBytes);
        return n3;
    }

    public boolean markSupported() {
        return this._delegate.markSupported();
    }

    public synchronized void mark(int n) {
        this._delegate.mark(n);
    }

    public synchronized void reset() throws IOException {
        this._delegate.reset();
    }

    public long skip(long l) throws IOException {
        long l2 = this._delegate.skip(l);
        this._totalBytes += l2;
        this.progress(l2, this._totalBytes);
        return l2;
    }

    public void progress(long l, long l2) {
    }
}

