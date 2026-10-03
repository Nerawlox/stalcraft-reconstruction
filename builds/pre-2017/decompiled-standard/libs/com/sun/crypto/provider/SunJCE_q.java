/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_r;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

class SunJCE_q
extends SunJCE_r {
    private int a;
    private int b;
    private int c;
    private byte[] d = new byte[16];

    SunJCE_q() {
    }

    static void a(PrintStream printStream, byte by) {
        char c = (char)(by >> 4 & 0xF);
        c = c > '\t' ? (char)(c - 10 + 65) : (char)(c + 48);
        printStream.write(c);
        c = (char)(by & 0xF);
        c = c > '\t' ? (char)(c - 10 + 65) : (char)(c + 48);
        printStream.write(c);
    }

    protected int a() {
        return 1;
    }

    protected int b() {
        return 16;
    }

    protected void a(OutputStream outputStream) throws IOException {
        this.a = 0;
        super.a(outputStream);
    }

    protected void a(OutputStream outputStream, int n) throws IOException {
        SunJCE_q.a(((SunJCE_r)this).a, (byte)(this.a >>> 8 & 0xFF));
        SunJCE_q.a(((SunJCE_r)this).a, (byte)(this.a & 0xFF));
        ((SunJCE_r)this).a.print(": ");
        this.c = 0;
        this.b = n;
    }

    protected void a(OutputStream outputStream, byte[] byArray, int n, int n2) throws IOException {
        this.d[this.c] = byArray[n];
        SunJCE_q.a(((SunJCE_r)this).a, byArray[n]);
        ((SunJCE_r)this).a.print(" ");
        ++this.c;
        if (this.c == 8) {
            ((SunJCE_r)this).a.print("  ");
        }
    }

    protected void b(OutputStream outputStream) throws IOException {
        int n;
        if (this.b < 16) {
            n = this.b;
            while (n < 16) {
                ((SunJCE_r)this).a.print("   ");
                if (n == 7) {
                    ((SunJCE_r)this).a.print("  ");
                }
                ++n;
            }
        }
        ((SunJCE_r)this).a.print(" ");
        n = 0;
        while (n < this.b) {
            if (this.d[n] < 32 || this.d[n] > 122) {
                ((SunJCE_r)this).a.print(".");
            } else {
                ((SunJCE_r)this).a.write(this.d[n]);
            }
            ++n;
        }
        ((SunJCE_r)this).a.println();
        this.a += this.b;
    }
}

