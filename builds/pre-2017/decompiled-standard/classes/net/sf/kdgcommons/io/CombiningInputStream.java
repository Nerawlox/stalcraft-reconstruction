/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.IOException;
import java.io.InputStream;

public class CombiningInputStream
extends InputStream {
    private InputStream[] _constituents;
    private int _current;
    private int _marked = -1;
    private int _markLimit = -1;

    public CombiningInputStream(InputStream ... inputStreamArray) {
        this._constituents = inputStreamArray;
    }

    private boolean isEOF() {
        return this._current == this._constituents.length;
    }

    private boolean switchStreams() {
        ++this._current;
        if (!this.isEOF() && this._markLimit > 0) {
            this.getCurrent().mark(this._markLimit);
        }
        return this.isEOF();
    }

    private InputStream getCurrent() {
        return this.isEOF() ? null : this._constituents[this._current];
    }

    public int available() throws IOException {
        return this.isEOF() ? 0 : this.getCurrent().available();
    }

    public void close() throws IOException {
        IOException iOException = null;
        for (int i = 0; i < this._constituents.length; ++i) {
            try {
                this._constituents[i].close();
                continue;
            }
            catch (IOException iOException2) {
                iOException = iOException2;
            }
        }
        if (iOException != null) {
            throw iOException;
        }
    }

    public int read() throws IOException {
        if (this.isEOF()) {
            return -1;
        }
        int n = this.getCurrent().read();
        if (n < 0) {
            this.switchStreams();
            return this.read();
        }
        --this._markLimit;
        return n;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        if (this.isEOF()) {
            return -1;
        }
        int n3 = 0;
        while (n2 > 0) {
            int n4 = this.getCurrent().read(byArray, n, n2);
            if (n4 < 0) {
                if (!this.switchStreams() && this.getCurrent().available() != 0) continue;
                break;
            }
            n3 += n4;
            n += n4;
            n2 -= n4;
            this._markLimit -= n4;
        }
        return n3;
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public boolean markSupported() {
        boolean bl = true;
        for (int i = this._current; i < this._constituents.length; ++i) {
            bl &= this._constituents[i].markSupported();
        }
        return bl;
    }

    public void mark(int n) {
        if (!this.isEOF()) {
            this._marked = this._current;
            this._markLimit = n;
            this.getCurrent().mark(n);
        }
    }

    public void reset() throws IOException {
        if (this._marked < 0) {
            throw new IOException("no mark set");
        }
        if (this.isEOF()) {
            --this._current;
        }
        while (this._current > this._marked) {
            this.getCurrent().reset();
            --this._current;
        }
        this.getCurrent().reset();
    }

    public long skip(long l) throws IOException {
        if (this.isEOF()) {
            return -1L;
        }
        long l2 = 0L;
        while (l > 0L && !this.isEOF()) {
            long l3 = this.getCurrent().skip(l);
            if (l3 <= 0L) {
                int n = this.read();
                if (n < 0) break;
                l3 = 1L;
            }
            l2 += l3;
            l -= l3;
        }
        return l2;
    }
}

