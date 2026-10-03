/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_m;
import com.sun.crypto.provider.SunJCE_t;
import com.sun.crypto.provider.SunJCE_v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

class SunJCE_l
extends ByteArrayOutputStream
implements SunJCE_m {
    public SunJCE_l(int n) {
        super(n);
    }

    public SunJCE_l() {
    }

    public void a(byte by, byte[] byArray) throws IOException {
        this.write(by);
        this.c(byArray.length);
        this.write(byArray, 0, byArray.length);
    }

    public void a(byte by, SunJCE_l sunJCE_l) throws IOException {
        this.write(by);
        this.c(sunJCE_l.count);
        this.write(sunJCE_l.buf, 0, sunJCE_l.count);
    }

    public void b(byte by, SunJCE_l sunJCE_l) throws IOException {
        this.write(by);
        this.write(sunJCE_l.buf, 1, sunJCE_l.count - 1);
    }

    public void a(SunJCE_t sunJCE_t) throws IOException {
        sunJCE_t.a(this);
    }

    public void a(boolean bl) throws IOException {
        this.write(1);
        this.c(1);
        if (bl) {
            this.write(255);
        } else {
            this.write(0);
        }
    }

    public void a(int n) throws IOException {
        this.write(10);
        this.b(n);
    }

    public void a(BigInteger bigInteger) throws IOException {
        this.write(2);
        byte[] byArray = bigInteger.toByteArray();
        this.c(byArray.length);
        this.write(byArray, 0, byArray.length);
    }

    public void a(Integer n) throws IOException {
        this.b(n);
    }

    public void b(int n) throws IOException {
        int n2;
        byte[] byArray = new byte[4];
        int n3 = 0;
        byArray[3] = (byte)(n & 0xFF);
        byArray[2] = (byte)((n & 0xFF00) >>> 8);
        byArray[1] = (byte)((n & 0xFF0000) >>> 16);
        byArray[0] = (byte)((n & 0xFF000000) >>> 24);
        if (byArray[0] == 255) {
            n2 = 0;
            while (n2 < 3) {
                if (byArray[n2] == 255 && (byArray[n2 + 1] & 0x80) == 128) {
                    ++n3;
                    ++n2;
                    continue;
                }
                break;
            }
        } else if (byArray[0] == 0) {
            n2 = 0;
            while (n2 < 3) {
                if (byArray[n2] == 0 && (byArray[n2 + 1] & 0x80) == 0) {
                    ++n3;
                    ++n2;
                    continue;
                }
                break;
            }
        }
        this.write(2);
        this.c(4 - n3);
        n2 = n3;
        while (n2 < 4) {
            this.write(byArray[n2]);
            ++n2;
        }
    }

    public void a(byte[] byArray) throws IOException {
        this.write(3);
        this.c(byArray.length + 1);
        this.write(0);
        this.write(byArray);
    }

    public void b(byte[] byArray) throws IOException {
        this.a((byte)4, byArray);
    }

    public void a() throws IOException {
        this.write(5);
        this.c(0);
    }

    public void a(SunJCE_v sunJCE_v) throws IOException {
        sunJCE_v.a(this);
    }

    public void a(SunJCE_t[] sunJCE_tArray) throws IOException {
        SunJCE_l sunJCE_l = new SunJCE_l();
        int n = 0;
        while (n < sunJCE_tArray.length) {
            sunJCE_tArray[n].a(sunJCE_l);
            ++n;
        }
        this.a((byte)48, sunJCE_l);
    }

    public void b(SunJCE_t[] sunJCE_tArray) throws IOException {
        SunJCE_l sunJCE_l = new SunJCE_l();
        int n = 0;
        while (n < sunJCE_tArray.length) {
            sunJCE_tArray[n].a(sunJCE_l);
            ++n;
        }
        this.a((byte)49, sunJCE_l);
    }

    public void a(String string) throws IOException {
        this.a(string, (byte)12, "UTF8");
    }

    public void b(String string) throws IOException {
        this.a(string, (byte)19, "ASCII");
    }

    public void c(String string) throws IOException {
        this.a(string, (byte)20, "ISO-8859-1");
    }

    public void d(String string) throws IOException {
        this.a(string, (byte)22, "ASCII");
    }

    public void e(String string) throws IOException {
        this.a(string, (byte)30, "UnicodeBigUnmarked");
    }

    public void f(String string) throws IOException {
        this.a(string, (byte)27, "ASCII");
    }

    private void a(String string, byte by, String string2) throws IOException {
        byte[] byArray = string.getBytes(string2);
        this.write(by);
        this.c(byArray.length);
        this.write(byArray);
    }

    public void c(int n) throws IOException {
        if (n < 128) {
            this.write((byte)n);
        } else if (n < 256) {
            this.write(-127);
            this.write((byte)n);
        } else if (n < 65536) {
            this.write(-126);
            this.write((byte)(n >> 8));
            this.write((byte)n);
        } else if (n < 0x1000000) {
            this.write(-125);
            this.write((byte)(n >> 16));
            this.write((byte)(n >> 8));
            this.write((byte)n);
        } else {
            this.write(-124);
            this.write((byte)(n >> 24));
            this.write((byte)(n >> 16));
            this.write((byte)(n >> 8));
            this.write((byte)n);
        }
    }

    public void a(byte by, boolean bl, byte by2) {
        byte by3 = (byte)(by | by2);
        if (bl) {
            by3 = (byte)(by3 | 0x20);
        }
        this.write(by3);
    }

    public void a(OutputStream outputStream) throws IOException {
        outputStream.write(this.toByteArray());
    }
}

