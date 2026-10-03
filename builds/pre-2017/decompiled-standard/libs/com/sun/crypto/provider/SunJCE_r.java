/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public abstract class SunJCE_r {
    protected PrintStream a;

    protected abstract int a();

    protected abstract int b();

    protected void a(OutputStream outputStream) throws IOException {
        this.a = new PrintStream(outputStream);
    }

    protected void c(OutputStream outputStream) throws IOException {
    }

    protected void a(OutputStream outputStream, int n) throws IOException {
    }

    protected void b(OutputStream outputStream) throws IOException {
        this.a.println();
    }

    protected abstract void a(OutputStream var1, byte[] var2, int var3, int var4) throws IOException;

    protected int a(InputStream inputStream, byte[] byArray) throws IOException {
        int n = 0;
        while (n < byArray.length) {
            int n2 = inputStream.read();
            if (n2 == -1) {
                return n;
            }
            byArray[n] = (byte)n2;
            ++n;
        }
        return byArray.length;
    }

    public void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        int n;
        byte[] byArray = new byte[this.b()];
        this.a(outputStream);
        while ((n = this.a(inputStream, byArray)) != 0) {
            this.a(outputStream, n);
            int n2 = 0;
            while (n2 < n) {
                if (n2 + this.a() <= n) {
                    this.a(outputStream, byArray, n2, this.a());
                } else {
                    this.a(outputStream, byArray, n2, n - n2);
                }
                n2 += this.a();
            }
            if (n < this.b()) break;
            this.b(outputStream);
        }
        this.c(outputStream);
    }

    public void a(byte[] byArray, OutputStream outputStream) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        this.a((InputStream)byteArrayInputStream, outputStream);
    }

    public String a(byte[] byArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        String string = null;
        try {
            this.a((InputStream)byteArrayInputStream, (OutputStream)byteArrayOutputStream);
            string = byteArrayOutputStream.toString("8859_1");
        }
        catch (Exception exception) {
            throw new Error("ChracterEncoder::encodeBuffer internal error");
        }
        return string;
    }

    public void b(InputStream inputStream, OutputStream outputStream) throws IOException {
        int n;
        byte[] byArray = new byte[this.b()];
        this.a(outputStream);
        while ((n = this.a(inputStream, byArray)) != 0) {
            this.a(outputStream, n);
            int n2 = 0;
            while (n2 < n) {
                if (n2 + this.a() <= n) {
                    this.a(outputStream, byArray, n2, this.a());
                } else {
                    this.a(outputStream, byArray, n2, n - n2);
                }
                n2 += this.a();
            }
            this.b(outputStream);
            if (n >= this.b()) continue;
        }
        this.c(outputStream);
    }

    public void b(byte[] byArray, OutputStream outputStream) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        this.b(byteArrayInputStream, outputStream);
    }

    public String b(byte[] byArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        try {
            this.b(byteArrayInputStream, (OutputStream)byteArrayOutputStream);
        }
        catch (Exception exception) {
            throw new Error("ChracterEncoder::encodeBuffer internal error");
        }
        return byteArrayOutputStream.toString();
    }
}

