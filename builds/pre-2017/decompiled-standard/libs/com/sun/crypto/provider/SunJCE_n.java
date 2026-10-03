/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_o;
import com.sun.crypto.provider.SunJCE_p;
import com.sun.crypto.provider.SunJCE_t;
import com.sun.crypto.provider.SunJCE_v;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Vector;

class SunJCE_n {
    SunJCE_p a;

    public SunJCE_n(byte[] byArray) throws IOException {
        this.a(byArray, 0, byArray.length);
    }

    public SunJCE_n(byte[] byArray, int n, int n2) throws IOException {
        this.a(byArray, n, n2);
    }

    private void a(byte[] byArray, int n, int n2) throws IOException {
        if (n + 2 > byArray.length || n + n2 > byArray.length) {
            throw new IOException("Encoding bytes too short");
        }
        if (SunJCE_o.b(byArray[n + 1])) {
            byte[] byArray2 = new byte[n2];
            System.arraycopy(byArray, n, byArray2, 0, n2);
            SunJCE_o sunJCE_o = new SunJCE_o();
            this.a = new SunJCE_p(sunJCE_o.a(byArray2));
        } else {
            this.a = new SunJCE_p(byArray, n, n2);
        }
        this.a.mark(Integer.MAX_VALUE);
    }

    SunJCE_n(SunJCE_p sunJCE_p) {
        this.a = sunJCE_p;
        this.a.mark(Integer.MAX_VALUE);
    }

    public SunJCE_n a(int n, boolean bl) throws IOException {
        SunJCE_p sunJCE_p = this.a.a();
        sunJCE_p.a(n);
        if (bl) {
            this.a.skip(n);
        }
        return new SunJCE_n(sunJCE_p);
    }

    public byte[] a() {
        return this.a.b();
    }

    public int b() throws IOException {
        if (this.a.read() != 2) {
            throw new IOException("DER input, Integer tag error");
        }
        return this.a.c(SunJCE_n.a(this.a));
    }

    public BigInteger c() throws IOException {
        if (this.a.read() != 2) {
            throw new IOException("DER input, Integer tag error");
        }
        return this.a.b(SunJCE_n.a(this.a));
    }

    public int d() throws IOException {
        if (this.a.read() != 10) {
            throw new IOException("DER input, Enumerated tag error");
        }
        return this.a.c(SunJCE_n.a(this.a));
    }

    public byte[] e() throws IOException {
        if (this.a.read() != 3) {
            throw new IOException("DER input not an bit string");
        }
        int n = SunJCE_n.a(this.a);
        if (this.a.read() != 0) {
            throw new IOException("unaligned bit string");
        }
        byte[] byArray = new byte[--n];
        if (n != 0 && this.a.read(byArray) != n) {
            throw new IOException("short read of DER bit string");
        }
        return byArray;
    }

    public byte[] f() throws IOException {
        if (this.a.read() != 4) {
            throw new IOException("DER input not an octet string");
        }
        int n = SunJCE_n.a(this.a);
        byte[] byArray = new byte[n];
        if (n != 0 && this.a.read(byArray) != n) {
            throw new IOException("short read of DER octet string");
        }
        return byArray;
    }

    public void a(byte[] byArray) throws IOException {
        if (byArray.length != 0 && this.a.read(byArray) != byArray.length) {
            throw new IOException("short read of DER octet string");
        }
    }

    public void g() throws IOException {
        if (this.a.read() != 5 || this.a.read() != 0) {
            throw new IOException("getNull, bad data");
        }
    }

    public SunJCE_v h() throws IOException {
        return new SunJCE_v(this);
    }

    public SunJCE_t[] a(int n) throws IOException {
        if (this.a.read() != 48) {
            throw new IOException("Sequence tag error");
        }
        return this.c(n);
    }

    public SunJCE_t[] b(int n) throws IOException {
        if (this.a.read() != 49) {
            throw new IOException("Set tag error");
        }
        return this.c(n);
    }

    public SunJCE_t[] b(int n, boolean bl) throws IOException {
        int n2 = this.a.read();
        if (!bl && n2 != 49) {
            throw new IOException("Set tag error");
        }
        return this.c(n);
    }

    protected SunJCE_t[] c(int n) throws IOException {
        int n2 = SunJCE_n.a(this.a);
        if (n2 == 0) {
            return new SunJCE_t[0];
        }
        SunJCE_n sunJCE_n = this.a.available() == n2 ? this : this.a(n2, true);
        Vector<SunJCE_t> vector = new Vector<SunJCE_t>(n, 5);
        do {
            SunJCE_t sunJCE_t = new SunJCE_t(sunJCE_n.a);
            vector.addElement(sunJCE_t);
        } while (sunJCE_n.t() > 0);
        if (sunJCE_n.t() != 0) {
            throw new IOException("extra data at end of vector");
        }
        int n3 = vector.size();
        SunJCE_t[] sunJCE_tArray = new SunJCE_t[n3];
        int n4 = 0;
        while (n4 < n3) {
            sunJCE_tArray[n4] = (SunJCE_t)vector.elementAt(n4);
            ++n4;
        }
        return sunJCE_tArray;
    }

    public SunJCE_t i() throws IOException {
        return new SunJCE_t(this.a);
    }

    public String j() throws IOException {
        return this.a((byte)12, "UTF-8", "UTF8");
    }

    public String k() throws IOException {
        return this.a((byte)19, "Printable", "ASCII");
    }

    public String l() throws IOException {
        return this.a((byte)20, "T61", "ISO-8859-1");
    }

    public String m() throws IOException {
        return this.a((byte)22, "IA5", "ASCII");
    }

    public String n() throws IOException {
        return this.a((byte)30, "BMP", "UnicodeBigUnmarked");
    }

    public String o() throws IOException {
        return this.a((byte)27, "General", "ASCII");
    }

    private String a(byte by, String string, String string2) throws IOException {
        if (this.a.read() != by) {
            throw new IOException("DER input not a " + string + " string");
        }
        int n = SunJCE_n.a(this.a);
        byte[] byArray = new byte[n];
        if (n != 0 && this.a.read(byArray) != n) {
            throw new IOException("short read of DER " + string + " string");
        }
        return new String(byArray, string2);
    }

    int p() throws IOException {
        return 0xFF & this.a.read();
    }

    public int q() throws IOException {
        return this.a.c();
    }

    int r() throws IOException {
        return SunJCE_n.a(this.a);
    }

    static int a(InputStream inputStream) throws IOException {
        return SunJCE_n.a(inputStream.read(), inputStream);
    }

    static int a(int n, InputStream inputStream) throws IOException {
        int n2;
        int n3 = n;
        if ((n3 & 0x80) == 0) {
            n2 = n3;
        } else {
            if ((n3 &= 0x7F) == 0) {
                return -1;
            }
            if (n3 < 0 || n3 > 4) {
                throw new IOException("DerInputStream.getLength(): lengthTag=" + n3 + ", " + (n3 < 0 ? "incorrect DER encoding." : "too big."));
            }
            n2 = 0;
            while (n3 > 0) {
                n2 <<= 8;
                n2 += 0xFF & inputStream.read();
                --n3;
            }
        }
        return n2;
    }

    public void d(int n) {
        this.a.mark(n);
    }

    public void s() {
        this.a.reset();
    }

    public int t() {
        return this.a.available();
    }
}

