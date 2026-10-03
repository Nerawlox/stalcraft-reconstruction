/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.StreamCipher;

public class CipherInputStream
extends FilterInputStream {
    private BufferedBlockCipher bufferedBlockCipher;
    private StreamCipher streamCipher;
    private byte[] buf;
    private byte[] inBuf;
    private int bufOff;
    private int maxBuf;
    private boolean finalized;
    private static final int INPUT_BUF_SIZE = 2048;

    public CipherInputStream(InputStream inputStream, BufferedBlockCipher bufferedBlockCipher) {
        super(inputStream);
        this.bufferedBlockCipher = bufferedBlockCipher;
        this.buf = new byte[bufferedBlockCipher.getOutputSize(2048)];
        this.inBuf = new byte[2048];
    }

    public CipherInputStream(InputStream inputStream, StreamCipher streamCipher) {
        super(inputStream);
        this.streamCipher = streamCipher;
        this.buf = new byte[2048];
        this.inBuf = new byte[2048];
    }

    private int nextChunk() throws IOException {
        int n = super.available();
        if (n <= 0) {
            n = 1;
        }
        if ((n = n > this.inBuf.length ? super.read(this.inBuf, 0, this.inBuf.length) : super.read(this.inBuf, 0, n)) < 0) {
            if (this.finalized) {
                return -1;
            }
            try {
                this.maxBuf = this.bufferedBlockCipher != null ? this.bufferedBlockCipher.doFinal(this.buf, 0) : 0;
            }
            catch (Exception exception) {
                throw new IOException("error processing stream: " + exception.toString());
            }
            this.bufOff = 0;
            this.finalized = true;
            if (this.bufOff == this.maxBuf) {
                return -1;
            }
        } else {
            this.bufOff = 0;
            try {
                if (this.bufferedBlockCipher != null) {
                    this.maxBuf = this.bufferedBlockCipher.processBytes(this.inBuf, 0, n, this.buf, 0);
                } else {
                    this.streamCipher.processBytes(this.inBuf, 0, n, this.buf, 0);
                    this.maxBuf = n;
                }
            }
            catch (Exception exception) {
                throw new IOException("error processing stream: " + exception.toString());
            }
            if (this.maxBuf == 0) {
                return this.nextChunk();
            }
        }
        return this.maxBuf;
    }

    public int read() throws IOException {
        if (this.bufOff == this.maxBuf && this.nextChunk() < 0) {
            return -1;
        }
        return this.buf[this.bufOff++] & 0xFF;
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        if (this.bufOff == this.maxBuf && this.nextChunk() < 0) {
            return -1;
        }
        int n3 = this.maxBuf - this.bufOff;
        if (n2 > n3) {
            System.arraycopy(this.buf, this.bufOff, byArray, n, n3);
            this.bufOff = this.maxBuf;
            return n3;
        }
        System.arraycopy(this.buf, this.bufOff, byArray, n, n2);
        this.bufOff += n2;
        return n2;
    }

    public long skip(long l) throws IOException {
        if (l <= 0L) {
            return 0L;
        }
        int n = this.maxBuf - this.bufOff;
        if (l > (long)n) {
            this.bufOff = this.maxBuf;
            return n;
        }
        this.bufOff += (int)l;
        return (int)l;
    }

    public int available() throws IOException {
        return this.maxBuf - this.bufOff;
    }

    public void close() throws IOException {
        super.close();
    }

    public boolean markSupported() {
        return false;
    }
}

