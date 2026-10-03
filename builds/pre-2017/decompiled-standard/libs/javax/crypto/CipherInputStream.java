/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NullCipher;

public class CipherInputStream
extends FilterInputStream {
    private Cipher a;
    InputStream b;
    private byte[] c = new byte[512];
    private int d;
    private boolean e = false;
    private byte[] f;
    int g = 0;
    int h = 0;

    private int a() throws IOException {
        if (this.e) {
            return -1;
        }
        int n = this.b.read(this.c);
        if (n == -1) {
            this.e = true;
            try {
                this.f = this.a.doFinal();
            }
            catch (IllegalBlockSizeException illegalBlockSizeException) {
                this.f = null;
            }
            catch (BadPaddingException badPaddingException) {
                this.f = null;
            }
            if (this.f == null) {
                return -1;
            }
            this.g = 0;
            this.h = this.f.length;
            return this.h;
        }
        try {
            this.f = this.a.update(this.c, 0, n);
        }
        catch (IllegalStateException illegalStateException) {
            this.f = null;
        }
        this.g = 0;
        this.h = this.f == null ? 0 : this.f.length;
        return this.h;
    }

    public CipherInputStream(InputStream inputStream, Cipher cipher) {
        super(inputStream);
        this.b = inputStream;
        this.a = cipher;
    }

    protected CipherInputStream(InputStream inputStream) {
        super(inputStream);
        this.b = inputStream;
        this.a = new NullCipher();
    }

    public int read() throws IOException {
        if (this.g >= this.h) {
            int n = 0;
            while (n == 0) {
                n = this.a();
            }
            if (n == -1) {
                return -1;
            }
        }
        return this.f[this.g++] & 0xFF;
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        if (this.g >= this.h) {
            n3 = 0;
            while (n3 == 0) {
                n3 = this.a();
            }
            if (n3 == -1) {
                return -1;
            }
        }
        if (n2 <= 0) {
            return 0;
        }
        n3 = this.h - this.g;
        if (n2 < n3) {
            n3 = n2;
        }
        if (byArray != null) {
            int n4 = 0;
            while (n4 < n3) {
                byArray[n + n4] = this.f[this.g + n4];
                ++n4;
            }
        }
        this.g += n3;
        return n3;
    }

    public long skip(long l) throws IOException {
        int n = this.h - this.g;
        if (l > (long)n) {
            l = n;
        }
        if (l < 0L) {
            return 0L;
        }
        this.g = (int)((long)this.g + l);
        return l;
    }

    public int available() throws IOException {
        return this.h - this.g;
    }

    public void close() throws IOException {
        this.b.close();
        try {
            this.a.doFinal();
        }
        catch (BadPaddingException badPaddingException) {
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            // empty catch block
        }
        this.h = 0;
        this.g = 0;
    }

    public boolean markSupported() {
        return false;
    }
}

