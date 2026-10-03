/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.StreamCipher;

public class CipherOutputStream
extends FilterOutputStream {
    private BufferedBlockCipher bufferedBlockCipher;
    private StreamCipher streamCipher;
    private byte[] oneByte = new byte[1];
    private byte[] buf;

    public CipherOutputStream(OutputStream outputStream, BufferedBlockCipher bufferedBlockCipher) {
        super(outputStream);
        this.bufferedBlockCipher = bufferedBlockCipher;
        this.buf = new byte[bufferedBlockCipher.getBlockSize()];
    }

    public CipherOutputStream(OutputStream outputStream, StreamCipher streamCipher) {
        super(outputStream);
        this.streamCipher = streamCipher;
    }

    public void write(int n) throws IOException {
        this.oneByte[0] = (byte)n;
        if (this.bufferedBlockCipher != null) {
            int n2 = this.bufferedBlockCipher.processBytes(this.oneByte, 0, 1, this.buf, 0);
            if (n2 != 0) {
                this.out.write(this.buf, 0, n2);
            }
        } else {
            this.out.write(this.streamCipher.returnByte((byte)n));
        }
    }

    public void write(byte[] byArray) throws IOException {
        this.write(byArray, 0, byArray.length);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (this.bufferedBlockCipher != null) {
            byte[] byArray2 = new byte[this.bufferedBlockCipher.getOutputSize(n2)];
            int n3 = this.bufferedBlockCipher.processBytes(byArray, n, n2, byArray2, 0);
            if (n3 != 0) {
                this.out.write(byArray2, 0, n3);
            }
        } else {
            byte[] byArray3 = new byte[n2];
            this.streamCipher.processBytes(byArray, n, n2, byArray3, 0);
            this.out.write(byArray3, 0, n2);
        }
    }

    public void flush() throws IOException {
        super.flush();
    }

    public void close() throws IOException {
        try {
            byte[] byArray;
            int n;
            if (this.bufferedBlockCipher != null && (n = this.bufferedBlockCipher.doFinal(byArray = new byte[this.bufferedBlockCipher.getOutputSize(0)], 0)) != 0) {
                this.out.write(byArray, 0, n);
            }
        }
        catch (Exception exception) {
            throw new IOException("Error closing stream: " + exception.toString());
        }
        this.flush();
        super.close();
    }
}

