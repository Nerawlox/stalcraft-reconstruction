/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_l;
import com.sun.crypto.provider.SunJCE_n;
import com.sun.crypto.provider.SunJCE_t;
import com.sun.crypto.provider.SunJCE_v;
import java.io.IOException;
import java.io.OutputStream;

class SunJCE_ah {
    private static final int[] a = new int[]{1, 2, 840, 113549, 1, 3, 1};
    private static final SunJCE_v b = new SunJCE_v(a);
    private static final int[] c = new int[]{1, 2, 840, 10046, 2, 1};
    private static final SunJCE_v d = new SunJCE_v(c);
    private static final int[] e = new int[]{1, 3, 14, 3, 2, 12};
    private static final SunJCE_v f = new SunJCE_v(e);
    private static final int[] g = new int[]{1, 2, 840, 10040, 4, 1};
    private static final SunJCE_v h = new SunJCE_v(g);
    private static final int[] i = new int[]{1, 2, 5, 8, 1, 1};
    private static final SunJCE_v j = new SunJCE_v(i);
    private static final int[] k = new int[]{1, 2, 840, 113549, 1, 1, 1};
    private static final SunJCE_v l = new SunJCE_v(k);
    private SunJCE_v m;
    private SunJCE_t n;
    private byte[] o;

    public SunJCE_ah(SunJCE_t sunJCE_t) throws IOException {
        if (sunJCE_t.e != 48) {
            throw new IOException("algid parse error: not a sequence");
        }
        SunJCE_n sunJCE_n = sunJCE_t.x();
        this.m = sunJCE_n.h();
        if (sunJCE_n.t() == 0) {
            this.n = null;
        } else {
            this.n = sunJCE_n.i();
            if (this.n.e == 5) {
                this.n = null;
            }
        }
        if (this.n != null) {
            this.o = this.n.w();
        }
    }

    public SunJCE_ah(SunJCE_v sunJCE_v, byte[] byArray) throws IOException {
        this.m = sunJCE_v;
        this.o = (byte[])byArray.clone();
        this.n = new SunJCE_t(this.o);
    }

    public SunJCE_ah(String string, byte[] byArray) throws IOException {
        this.m = new SunJCE_v(string);
        this.o = (byte[])byArray.clone();
        this.n = new SunJCE_t(this.o);
    }

    public SunJCE_v a() {
        return this.m;
    }

    public byte[] b() {
        return this.o;
    }

    public void a(OutputStream outputStream) throws IOException {
        SunJCE_l sunJCE_l = new SunJCE_l();
        SunJCE_l sunJCE_l2 = new SunJCE_l();
        sunJCE_l.a(this.m);
        if (this.n == null) {
            sunJCE_l.a();
        } else {
            sunJCE_l.a(this.n);
        }
        sunJCE_l2.a((byte)48, sunJCE_l);
        outputStream.write(sunJCE_l2.toByteArray());
    }

    static String a(SunJCE_v sunJCE_v) {
        if (sunJCE_v.b(l) || sunJCE_v.b(j)) {
            return "RSA";
        }
        if (sunJCE_v.b(b) || sunJCE_v.b(d)) {
            return "DiffieHellman";
        }
        if (sunJCE_v.b(h) || sunJCE_v.b(f)) {
            return "DSA";
        }
        return sunJCE_v.toString();
    }
}

