/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_l;
import com.sun.crypto.provider.SunJCE_n;
import com.sun.crypto.provider.SunJCE_o;
import com.sun.crypto.provider.SunJCE_p;
import com.sun.crypto.provider.SunJCE_v;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

class SunJCE_t {
    public static final byte a = 0;
    public static final byte b = 64;
    public static final byte c = -128;
    public static final byte d = -64;
    public byte e;
    protected SunJCE_p f;
    public SunJCE_n g;
    private int h;
    public static final byte i = 1;
    public static final byte j = 2;
    public static final byte k = 3;
    public static final byte l = 4;
    public static final byte m = 5;
    public static final byte n = 6;
    public static final byte o = 10;
    public static final byte p = 12;
    public static final byte q = 19;
    public static final byte r = 20;
    public static final byte s = 22;
    public static final byte t = 27;
    public static final byte u = 28;
    public static final byte v = 30;
    public static final byte w = 48;
    public static final byte x = 48;
    public static final byte y = 49;
    public static final byte z = 49;

    public boolean a() {
        return (this.e & 0xC0) == 0;
    }

    public boolean b() {
        return (this.e & 0xC0) == 64;
    }

    public boolean c() {
        return (this.e & 0xC0) == 128;
    }

    public boolean a(byte by) {
        if (!this.c()) {
            return false;
        }
        return (this.e & 0x1F) == by;
    }

    boolean d() {
        return (this.e & 0xC0) == 192;
    }

    public boolean e() {
        return (this.e & 0x20) == 32;
    }

    public boolean b(byte by) {
        if (!this.e()) {
            return false;
        }
        return (this.e & 0x1F) == by;
    }

    public SunJCE_t(String string) throws IOException {
        boolean bl = true;
        int n = 0;
        while (n < string.length()) {
            if (!SunJCE_t.a(string.charAt(n))) {
                bl = false;
                break;
            }
            ++n;
        }
        this.a(bl ? (byte)19 : 12, string);
    }

    public SunJCE_t(byte by, String string) throws IOException {
        this.a(by, string);
    }

    public SunJCE_t(byte by, byte[] byArray) {
        this.e = by;
        this.f = new SunJCE_p((byte[])byArray.clone());
        this.h = byArray.length;
        this.g = new SunJCE_n(this.f);
        this.g.d(Integer.MAX_VALUE);
    }

    SunJCE_t(SunJCE_p sunJCE_p) throws IOException {
        this.e = (byte)sunJCE_p.read();
        this.h = SunJCE_n.a(sunJCE_p);
        if (this.h == -1) {
            sunJCE_p.reset();
            byte[] byArray = new byte[sunJCE_p.available()];
            DataInputStream dataInputStream = new DataInputStream(sunJCE_p);
            dataInputStream.readFully(byArray);
            dataInputStream.close();
            SunJCE_o sunJCE_o = new SunJCE_o();
            sunJCE_p = new SunJCE_p(sunJCE_o.a(byArray));
            if (this.e != sunJCE_p.read()) {
                throw new IOException("Indefinite length encoding not supported");
            }
            this.h = SunJCE_n.a(sunJCE_p);
        }
        this.f = sunJCE_p.a();
        this.f.a(this.h);
        this.g = new SunJCE_n(this.f);
        sunJCE_p.skip(this.h);
    }

    public SunJCE_t(byte[] byArray) throws IOException {
        this.a(true, new ByteArrayInputStream(byArray));
    }

    public SunJCE_t(byte[] byArray, int n, int n2) throws IOException {
        this.a(true, new ByteArrayInputStream(byArray, n, n2));
    }

    public SunJCE_t(InputStream inputStream) throws IOException {
        this.a(false, inputStream);
    }

    private void a(byte by, String string) throws IOException {
        String string2 = null;
        this.e = by;
        switch (by) {
            case 19: 
            case 22: 
            case 27: {
                string2 = "ASCII";
                break;
            }
            case 20: {
                string2 = "ISO-8859-1";
                break;
            }
            case 30: {
                string2 = "UnicodeBigUnmarked";
                break;
            }
            case 12: {
                string2 = "UTF8";
                break;
            }
            default: {
                throw new IllegalArgumentException("Unsupported DER string type");
            }
        }
        byte[] byArray = string.getBytes(string2);
        this.h = byArray.length;
        this.f = new SunJCE_p(byArray);
        this.g = new SunJCE_n(this.f);
        this.g.d(Integer.MAX_VALUE);
    }

    private void a(boolean bl, InputStream inputStream) throws IOException {
        this.e = (byte)inputStream.read();
        byte by = (byte)inputStream.read();
        this.h = SunJCE_n.a(by & 0xFF, inputStream);
        if (this.h == -1) {
            int n = inputStream.available();
            int n2 = 2;
            byte[] byArray = new byte[n + n2];
            byArray[0] = this.e;
            byArray[1] = by;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            dataInputStream.readFully(byArray, n2, n);
            dataInputStream.close();
            SunJCE_o sunJCE_o = new SunJCE_o();
            inputStream = new ByteArrayInputStream(sunJCE_o.a(byArray));
            if (this.e != inputStream.read()) {
                throw new IOException("Indefinite length encoding not supported");
            }
            this.h = SunJCE_n.a(inputStream);
        }
        if (this.h == 0) {
            return;
        }
        if (bl && inputStream.available() != this.h) {
            throw new IOException("extra data given to DerValue constructor");
        }
        byte[] byArray = new byte[this.h];
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        dataInputStream.readFully(byArray);
        this.f = new SunJCE_p(byArray);
        this.g = new SunJCE_n(this.f);
    }

    public void a(SunJCE_l sunJCE_l) throws IOException {
        sunJCE_l.write(this.e);
        sunJCE_l.c(this.h);
        if (this.h > 0) {
            byte[] byArray = new byte[this.h];
            SunJCE_p sunJCE_p = this.f;
            synchronized (sunJCE_p) {
                this.f.reset();
                if (this.f.read(byArray) != this.h) {
                    throw new IOException("short DER value read (encode)");
                }
                sunJCE_l.write(byArray);
            }
        }
    }

    public final SunJCE_n f() {
        return this.g;
    }

    public final byte g() {
        return this.e;
    }

    public boolean h() throws IOException {
        if (this.e != 1) {
            throw new IOException("DerValue.getBoolean, not a BOOLEAN " + this.e);
        }
        if (this.h != 1) {
            throw new IOException("DerValue.getBoolean, invalid length " + this.h);
        }
        return this.f.read() != 0;
    }

    public SunJCE_v i() throws IOException {
        if (this.e != 6) {
            throw new IOException("DerValue.getOID, not an OID " + this.e);
        }
        return new SunJCE_v(this.f);
    }

    private byte[] a(byte[] byArray, byte[] byArray2) {
        if (byArray == null) {
            return byArray2;
        }
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length, byArray2.length);
        return byArray3;
    }

    public byte[] j() throws IOException {
        if (this.e != 4 && !this.b((byte)4)) {
            throw new IOException("DerValue.getOctetString, not an Octet String: " + this.e);
        }
        byte[] byArray = new byte[this.h];
        if (this.f.read(byArray) != this.h) {
            throw new IOException("short read on DerValue buffer");
        }
        if (this.e()) {
            SunJCE_n sunJCE_n = new SunJCE_n(byArray);
            byArray = null;
            while (sunJCE_n.t() != 0) {
                byArray = this.a(byArray, sunJCE_n.f());
            }
        }
        return byArray;
    }

    public int k() throws IOException {
        if (this.e != 2) {
            throw new IOException("DerValue.getInteger, not an int " + this.e);
        }
        return this.f.c(this.g.t());
    }

    public BigInteger l() throws IOException {
        if (this.e != 2) {
            throw new IOException("DerValue.getBigInteger, not an int " + this.e);
        }
        return this.f.b(this.g.t());
    }

    public int m() throws IOException {
        if (this.e != 10) {
            throw new IOException("DerValue.getEnumerated, incorrect tag: " + this.e);
        }
        return this.f.c(this.g.t());
    }

    public String n() throws IOException {
        if (this.e == 12) {
            return this.u();
        }
        if (this.e == 19) {
            return this.q();
        }
        if (this.e == 20) {
            return this.r();
        }
        if (this.e == 22) {
            return this.s();
        }
        if (this.e == 30) {
            return this.t();
        }
        if (this.e == 27) {
            return this.v();
        }
        return null;
    }

    public byte[] o() throws IOException {
        if (this.e != 3) {
            throw new IOException("DerValue.getBitString, not a bit string " + this.e);
        }
        return this.f.d();
    }

    public byte[] a(boolean bl) throws IOException {
        if (!bl && this.e != 3) {
            throw new IOException("DerValue.getBitString, not a bit string " + this.e);
        }
        return this.f.d();
    }

    public byte[] p() throws IOException {
        byte[] byArray = new byte[this.h];
        SunJCE_n sunJCE_n = this.g;
        synchronized (sunJCE_n) {
            this.g.s();
            this.g.a(byArray);
        }
        return byArray;
    }

    public String q() throws IOException {
        if (this.e != 19) {
            throw new IOException("DerValue.getPrintableString, not a string " + this.e);
        }
        return new String(this.p(), "ASCII");
    }

    public String r() throws IOException {
        if (this.e != 20) {
            throw new IOException("DerValue.getT61String, not T61 " + this.e);
        }
        return new String(this.p(), "ISO-8859-1");
    }

    public String s() throws IOException {
        if (this.e != 22) {
            throw new IOException("DerValue.getIA5String, not IA5 " + this.e);
        }
        return new String(this.p(), "ASCII");
    }

    public String t() throws IOException {
        if (this.e != 30) {
            throw new IOException("DerValue.getBMPString, not BMP " + this.e);
        }
        return new String(this.p(), "UnicodeBigUnmarked");
    }

    public String u() throws IOException {
        if (this.e != 12) {
            throw new IOException("DerValue.getUTF8String, not UTF-8 " + this.e);
        }
        return new String(this.p(), "UTF8");
    }

    public String v() throws IOException {
        if (this.e != 27) {
            throw new IOException("DerValue.getGeneralString, not GeneralString " + this.e);
        }
        return new String(this.p(), "ASCII");
    }

    public boolean equals(Object object) {
        if (object instanceof SunJCE_t) {
            return this.a((SunJCE_t)object);
        }
        return false;
    }

    public boolean a(SunJCE_t sunJCE_t) {
        this.g.s();
        sunJCE_t.g.s();
        if (this == sunJCE_t) {
            return true;
        }
        if (this.e != sunJCE_t.e) {
            return false;
        }
        return this.f.a(sunJCE_t.f);
    }

    public String toString() {
        try {
            String string = this.n();
            if (string != null) {
                return "\"" + string + "\"";
            }
            if (this.e == 5) {
                return "[DerValue, null]";
            }
            if (this.e == 6) {
                return "OID." + this.i();
            }
            return "[DerValue, tag = " + this.e + ", length = " + this.h + "]";
        }
        catch (IOException iOException) {
            throw new IllegalArgumentException("misformatted DER value");
        }
    }

    public byte[] w() throws IOException {
        SunJCE_l sunJCE_l = new SunJCE_l();
        this.a(sunJCE_l);
        this.g.s();
        return sunJCE_l.toByteArray();
    }

    public SunJCE_n x() throws IOException {
        if (this.e == 48 || this.e == 49) {
            return new SunJCE_n(this.f);
        }
        throw new IOException("toDerInputStream rejects tag type " + this.e);
    }

    public int y() {
        return this.h;
    }

    public static boolean a(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
            return true;
        }
        switch (c) {
            case ' ': 
            case '\'': 
            case '(': 
            case ')': 
            case '+': 
            case ',': 
            case '-': 
            case '.': 
            case '/': 
            case ':': 
            case '=': 
            case '?': {
                return true;
            }
        }
        return false;
    }

    public static byte a(byte by, boolean bl, byte by2) {
        byte by3 = (byte)(by | by2);
        if (bl) {
            by3 = (byte)(by3 | 0x20);
        }
        return by3;
    }

    public void c(byte by) {
        this.e = by;
    }

    public int hashCode() {
        return this.toString().hashCode();
    }
}

