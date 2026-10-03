/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.IOException;
import java.io.OutputStream;

public class TeeOutputStream
extends OutputStream {
    private OutputStream _base;
    private OutputStream _tee;
    private boolean _flushTee;

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        this._base = outputStream;
        this._tee = outputStream2;
    }

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2, boolean bl) {
        this(outputStream, outputStream2);
        this._flushTee = bl;
    }

    public void close() throws IOException {
        this._base.close();
    }

    public void flush() throws IOException {
        this._base.flush();
        this._tee.flush();
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        this._base.write(byArray, n, n2);
        this._tee.write(byArray, n, n2);
        if (this._flushTee) {
            this._tee.flush();
        }
    }

    public void write(byte[] byArray) throws IOException {
        this._base.write(byArray);
        this._tee.write(byArray);
        if (this._flushTee) {
            this._tee.flush();
        }
    }

    public void write(int n) throws IOException {
        this._base.write(n);
        this._tee.write(n);
        if (this._flushTee) {
            this._tee.flush();
        }
    }
}

