/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NullCipher;

public class CipherOutputStream
extends FilterOutputStream {
    private Cipher a;
    OutputStream b;
    private byte[] c = new byte[1];
    private byte[] d;

    public CipherOutputStream(OutputStream outputStream, Cipher cipher) {
        super(outputStream);
        this.b = outputStream;
        this.a = cipher;
    }

    protected CipherOutputStream(OutputStream outputStream) {
        super(outputStream);
        this.b = outputStream;
        this.a = new NullCipher();
    }

    public void write(int n) throws IOException {
        this.c[0] = (byte)n;
        this.d = this.a.update(this.c, 0, 1);
        if (this.d != null) {
            this.b.write(this.d);
            this.d = null;
        }
    }

    public void write(byte[] byArray) throws IOException {
        this.write(byArray, 0, byArray.length);
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        this.d = this.a.update(byArray, n, n2);
        if (this.d != null) {
            this.b.write(this.d);
            this.d = null;
        }
    }

    public void flush() throws IOException {
        if (this.d != null) {
            this.b.write(this.d);
            this.d = null;
        }
        this.b.flush();
    }

    public void close() throws IOException {
        try {
            this.d = this.a.doFinal();
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            this.d = null;
        }
        catch (BadPaddingException badPaddingException) {
            this.d = null;
        }
        try {
            this.flush();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this.out.close();
    }
}

