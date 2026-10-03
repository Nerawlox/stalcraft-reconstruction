/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.IOException;
import java.io.InputStream;

public class BOMExclusionInputStream
extends InputStream {
    private InputStream _delegate;
    private int[] _firstBytes;
    private int _fbLen;
    private int _fbIndex;
    private boolean _markedAtStart;

    public BOMExclusionInputStream(InputStream inputStream) {
        this._delegate = inputStream;
    }

    private int readFirstBytes() throws IOException {
        if (this._firstBytes == null) {
            this._firstBytes = new int[3];
            int n = this._delegate.read();
            if (n < 0 || n != 239) {
                return n;
            }
            int n2 = this._delegate.read();
            int n3 = this._delegate.read();
            if (n2 == 187 && n3 == 191) {
                return this._delegate.read();
            }
            this._firstBytes[this._fbLen++] = n;
            this._firstBytes[this._fbLen++] = n2;
            this._firstBytes[this._fbLen++] = n3;
        }
        return this._fbIndex < this._fbLen ? this._firstBytes[this._fbIndex++] : -1;
    }

    public int available() throws IOException {
        return this._delegate.available();
    }

    public void close() throws IOException {
        this._delegate.close();
    }

    public int read() throws IOException {
        int n = this.readFirstBytes();
        return n >= 0 ? n : this._delegate.read();
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3 = 0;
        int n4 = 0;
        while (n2 > 0 && n4 >= 0) {
            n4 = this.readFirstBytes();
            if (n4 < 0) continue;
            byArray[n++] = (byte)(n4 & 0xFF);
            --n2;
            ++n3;
        }
        int n5 = this._delegate.read(byArray, n, n2);
        return n5 < 0 ? n3 : n3 + n5;
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public boolean markSupported() {
        return this._delegate.markSupported();
    }

    public synchronized void mark(int n) {
        this._markedAtStart = this._firstBytes == null;
        this._delegate.mark(n);
    }

    public synchronized void reset() throws IOException {
        if (this._markedAtStart) {
            this._firstBytes = null;
        }
        this._delegate.reset();
    }

    public long skip(long l) throws IOException {
        while (l > 0L && this.readFirstBytes() >= 0) {
            --l;
        }
        return this._delegate.skip(l);
    }
}

