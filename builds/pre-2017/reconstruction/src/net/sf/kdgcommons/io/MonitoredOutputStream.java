/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.IOException;
import java.io.OutputStream;

public class MonitoredOutputStream
extends OutputStream {
    private OutputStream _delegate;
    private long _totalBytes;

    public MonitoredOutputStream(OutputStream outputStream) {
        this._delegate = outputStream;
    }

    public void write(int n) throws IOException {
        this._delegate.write(n);
        ++this._totalBytes;
        this.progress(1L, this._totalBytes);
    }

    public void write(byte[] byArray) throws IOException {
        this.write(byArray, 0, byArray.length);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        this._delegate.write(byArray, n, n2);
        this._totalBytes += (long)n2;
        this.progress(n2, this._totalBytes);
    }

    public void flush() throws IOException {
        this._delegate.flush();
    }

    public void close() throws IOException {
        this._delegate.close();
    }

    public void progress(long l, long l2) {
    }
}

