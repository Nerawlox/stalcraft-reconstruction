/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import java.io.IOException;
import java.util.ArrayList;

class SunJCE_o {
    private static final int a = 31;
    private static final int b = 32;
    private static final int c = 192;
    private static final int d = 128;
    private static final int e = 127;
    private static final int f = 2;
    private byte[] g;
    private byte[] h;
    private int i;
    private int j;
    private int k;
    private int l;
    private ArrayList m = new ArrayList();
    private int n = 0;

    private boolean c(int n) {
        return (n & 0x1F) == 0 && (n & 0x20) == 0 && (n & 0xC0) == 0;
    }

    static boolean a(int n) {
        return (n & 0x80) == 128;
    }

    SunJCE_o() {
    }

    static boolean b(int n) {
        return SunJCE_o.a(n) && (n & 0x7F) == 0;
    }

    private void a() throws IOException {
        if (this.j == this.k) {
            return;
        }
        if (this.c(this.g[this.j]) && this.g[this.j + 1] == 0) {
            int n = 0;
            Object var2_2 = null;
            int n2 = this.m.size() - 1;
            while (n2 >= 0) {
                var2_2 = this.m.get(n2);
                if (var2_2 instanceof Integer) break;
                n += ((byte[])var2_2).length - 3;
                --n2;
            }
            if (n2 < 0) {
                throw new IOException("EOC does not have matching indefinite-length tag");
            }
            int n3 = this.j - (Integer)var2_2 + n;
            byte[] byArray = this.e(n3);
            this.m.set(n2, byArray);
            this.n += byArray.length - 3;
        }
        ++this.j;
    }

    private void b() {
        byte by;
        if (this.j == this.k) {
            return;
        }
        if (this.c(by = this.g[this.j++]) && this.g[this.j] == 0) {
            ++this.j;
            this.b();
        } else {
            this.h[this.i++] = by;
        }
    }

    private int c() throws IOException {
        int n;
        int n2 = 0;
        if (this.j == this.k) {
            return n2;
        }
        if (SunJCE_o.b(n = this.g[this.j++] & 0xFF)) {
            this.m.add(new Integer(this.j));
            return n2;
        }
        if (SunJCE_o.a(n)) {
            if ((n &= 0x7F) > 4) {
                throw new IOException("Too much data");
            }
            if (this.k - this.j < n + 1) {
                throw new IOException("Too little data");
            }
            int n3 = 0;
            while (n3 < n) {
                n2 = (n2 << 8) + (this.g[this.j++] & 0xFF);
                ++n3;
            }
        } else {
            n2 = n & 0x7F;
        }
        return n2;
    }

    private void d() throws IOException {
        int n;
        if (this.j == this.k) {
            return;
        }
        int n2 = 0;
        if (SunJCE_o.b(n = this.g[this.j++] & 0xFF)) {
            byte[] byArray = (byte[])this.m.get(this.l++);
            System.arraycopy(byArray, 0, this.h, this.i, byArray.length);
            this.i += byArray.length;
            return;
        }
        if (SunJCE_o.a(n)) {
            n &= 0x7F;
            int n3 = 0;
            while (n3 < n) {
                n2 = (n2 << 8) + (this.g[this.j++] & 0xFF);
                ++n3;
            }
        } else {
            n2 = n & 0x7F;
        }
        this.d(n2);
        this.h(n2);
    }

    private void d(int n) {
        if (n < 128) {
            this.h[this.i++] = (byte)n;
        } else if (n < 256) {
            this.h[this.i++] = -127;
            this.h[this.i++] = (byte)n;
        } else if (n < 65536) {
            this.h[this.i++] = -126;
            this.h[this.i++] = (byte)(n >> 8);
            this.h[this.i++] = (byte)n;
        } else if (n < 0x1000000) {
            this.h[this.i++] = -125;
            this.h[this.i++] = (byte)(n >> 16);
            this.h[this.i++] = (byte)(n >> 8);
            this.h[this.i++] = (byte)n;
        } else {
            this.h[this.i++] = -124;
            this.h[this.i++] = (byte)(n >> 24);
            this.h[this.i++] = (byte)(n >> 16);
            this.h[this.i++] = (byte)(n >> 8);
            this.h[this.i++] = (byte)n;
        }
    }

    private byte[] e(int n) {
        byte[] byArray;
        int n2 = 0;
        if (n < 128) {
            byArray = new byte[1];
            byArray[n2++] = (byte)n;
        } else if (n < 256) {
            byArray = new byte[2];
            byArray[n2++] = -127;
            byArray[n2++] = (byte)n;
        } else if (n < 65536) {
            byArray = new byte[3];
            byArray[n2++] = -126;
            byArray[n2++] = (byte)(n >> 8);
            byArray[n2++] = (byte)n;
        } else if (n < 0x1000000) {
            byArray = new byte[4];
            byArray[n2++] = -125;
            byArray[n2++] = (byte)(n >> 16);
            byArray[n2++] = (byte)(n >> 8);
            byArray[n2++] = (byte)n;
        } else {
            byArray = new byte[5];
            byArray[n2++] = -124;
            byArray[n2++] = (byte)(n >> 24);
            byArray[n2++] = (byte)(n >> 16);
            byArray[n2++] = (byte)(n >> 8);
            byArray[n2++] = (byte)n;
        }
        return byArray;
    }

    private int f(int n) {
        int n2 = 0;
        n2 = n < 128 ? 1 : (n < 256 ? 2 : (n < 65536 ? 3 : (n < 0x1000000 ? 4 : 5)));
        return n2;
    }

    private void g(int n) {
        this.j += n;
    }

    private void h(int n) {
        int n2 = 0;
        while (n2 < n) {
            this.h[this.i++] = this.g[this.j++];
            ++n2;
        }
    }

    byte[] a(byte[] byArray) throws IOException {
        this.g = byArray;
        this.j = 0;
        this.l = 0;
        this.k = this.g.length;
        int n = 0;
        while (this.j < this.k) {
            this.a();
            n = this.c();
            this.g(n);
        }
        this.h = new byte[this.k + this.n];
        this.j = 0;
        this.i = 0;
        this.l = 0;
        while (this.j < this.k) {
            this.b();
            this.d();
        }
        return this.h;
    }
}

