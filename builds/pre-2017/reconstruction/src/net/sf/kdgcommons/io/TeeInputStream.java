/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TeeInputStream
extends InputStream {
    private InputStream _base;
    private OutputStream _tee;

    public TeeInputStream(InputStream inputStream, OutputStream outputStream) {
        this._base = inputStream;
        this._tee = outputStream;
    }

    public int available() throws IOException {
        return this._base.available();
    }

    public void close() throws IOException {
        this._base.close();
    }

    public int read() throws IOException {
        int n = this._base.read();
        if (n >= 0) {
            this._tee.write(n);
        }
        return n;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = this._base.read(byArray, n, n2);
        if (n3 > 0) {
            this._tee.write(byArray, n, n3);
        }
        return n3;
    }

    public int read(byte[] byArray) throws IOException {
        int n = this._base.read(byArray);
        if (n > 0) {
            this._tee.write(byArray, 0, n);
        }
        return n;
    }

    public boolean markSupported() {
        return this._base.markSupported();
    }

    public synchronized void mark(int n) {
        this._base.mark(n);
    }

    public synchronized void reset() throws IOException {
        this._base.reset();
    }

    public long skip(long l) throws IOException {
        return this._base.skip(l);
    }
}

