/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;

class SunJCE_p
extends ByteArrayInputStream
implements Cloneable {
    SunJCE_p(byte[] byArray) {
        super(byArray);
    }

    SunJCE_p(byte[] byArray, int n, int n2) {
        super(byArray, n, n2);
    }

    SunJCE_p a() {
        try {
            SunJCE_p sunJCE_p = (SunJCE_p)this.clone();
            sunJCE_p.mark(Integer.MAX_VALUE);
            return sunJCE_p;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new IllegalArgumentException(cloneNotSupportedException.toString());
        }
    }

    byte[] b() {
        int n = this.available();
        if (n <= 0) {
            return null;
        }
        byte[] byArray = new byte[n];
        System.arraycopy(this.buf, this.pos, byArray, 0, n);
        return byArray;
    }

    int c() throws IOException {
        if (this.pos >= this.count) {
            throw new IOException("out of data");
        }
        return this.buf[this.pos];
    }

    public boolean equals(Object object) {
        if (object instanceof SunJCE_p) {
            return this.a((SunJCE_p)object);
        }
        return false;
    }

    boolean a(SunJCE_p sunJCE_p) {
        if (this == sunJCE_p) {
            return true;
        }
        int n = this.available();
        if (sunJCE_p.available() != n) {
            return false;
        }
        int n2 = 0;
        while (n2 < n) {
            if (this.buf[this.pos + n2] != sunJCE_p.buf[sunJCE_p.pos + n2]) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public int hashCode() {
        int n = 0;
        int n2 = this.available();
        int n3 = this.pos;
        int n4 = 0;
        while (n4 < n2) {
            n += this.buf[n3 + n4] * n4;
            ++n4;
        }
        return n;
    }

    void a(int n) throws IOException {
        if (n > this.available()) {
            throw new IOException("insufficient data");
        }
        this.count = this.pos + n;
    }

    BigInteger b(int n) throws IOException {
        if (n > this.available()) {
            throw new IOException("short read of integer");
        }
        if (n == 0) {
            throw new IOException("Invalid encoding: zero length Int value");
        }
        byte[] byArray = new byte[n];
        System.arraycopy(this.buf, this.pos, byArray, 0, n);
        this.skip(n);
        return new BigInteger(byArray);
    }

    public int c(int n) throws IOException {
        BigInteger bigInteger = this.b(n);
        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            throw new IOException("Integer below minimum valid value");
        }
        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IOException("Integer exceeds maximum valid value");
        }
        return bigInteger.intValue();
    }

    byte[] d() {
        if (this.pos >= this.count || this.buf[this.pos] != 0) {
            return null;
        }
        int n = this.available();
        byte[] byArray = new byte[n - 1];
        System.arraycopy(this.buf, this.pos + 1, byArray, 0, n - 1);
        this.pos = this.count;
        return byArray;
    }
}

