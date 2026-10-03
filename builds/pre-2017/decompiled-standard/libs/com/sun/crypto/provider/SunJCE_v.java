/*
 * Decompiled with CFR 0.152.
 */
package com.sun.crypto.provider;

import com.sun.crypto.provider.SunJCE_l;
import com.sun.crypto.provider.SunJCE_n;
import com.sun.crypto.provider.SunJCE_p;
import java.io.IOException;
import java.io.Serializable;

final class SunJCE_v
implements Serializable {
    private static final long serialVersionUID = 8697030238860181294L;
    private int[] a;
    private int b;
    private static final int c = 5;

    public SunJCE_v(String string) {
        int n = 46;
        int n2 = 0;
        int n3 = 0;
        this.b = 0;
        while ((n3 = string.indexOf(n, n2)) != -1) {
            n2 = n3 + 1;
            ++this.b;
        }
        ++this.b;
        this.a = new int[this.b];
        n2 = 0;
        int n4 = 0;
        String string2 = null;
        while ((n3 = string.indexOf(n, n2)) != -1) {
            string2 = string.substring(n2, n3);
            this.a[n4++] = Integer.valueOf(string2);
            n2 = n3 + 1;
        }
        string2 = string.substring(n2);
        this.a[n4] = Integer.valueOf(string2);
    }

    public SunJCE_v(int[] nArray) {
        try {
            this.a = (int[])nArray.clone();
            this.b = nArray.length;
        }
        catch (Throwable throwable) {
            System.out.println("X509.ObjectIdentifier(), no cloning!");
        }
    }

    public SunJCE_v(SunJCE_n sunJCE_n) throws IOException {
        byte by = (byte)sunJCE_n.p();
        if (by != 6) {
            throw new IOException("X509.ObjectIdentifier() -- data isn't an object ID (tag = " + by + ")");
        }
        int n = sunJCE_n.t() - sunJCE_n.r() - 1;
        if (n < 0) {
            throw new IOException("X509.ObjectIdentifier() -- not enough data");
        }
        this.a(sunJCE_n, n);
    }

    SunJCE_v(SunJCE_p sunJCE_p) throws IOException {
        this.a(new SunJCE_n(sunJCE_p), 0);
    }

    private void a(SunJCE_n sunJCE_n, int n) throws IOException {
        boolean bl = true;
        this.a = new int[5];
        this.b = 0;
        while (sunJCE_n.t() > n) {
            int n2 = SunJCE_v.a(sunJCE_n);
            if (bl) {
                int n3 = n2 < 40 ? 0 : (n2 < 80 ? 1 : 2);
                int n4 = n2 - n3 * 40;
                this.a[0] = n3;
                this.a[1] = n4;
                this.b = 2;
                bl = false;
                continue;
            }
            if (this.b >= this.a.length) {
                int[] nArray = new int[this.a.length + 5];
                System.arraycopy(this.a, 0, nArray, 0, this.a.length);
                this.a = nArray;
            }
            this.a[this.b++] = n2;
        }
        if (sunJCE_n.t() != n) {
            throw new IOException("X509.ObjectIdentifier() -- malformed input data");
        }
    }

    void a(SunJCE_l sunJCE_l) throws IOException {
        SunJCE_l sunJCE_l2 = new SunJCE_l();
        sunJCE_l2.write(this.a[0] * 40 + this.a[1]);
        int n = 2;
        while (n < this.b) {
            SunJCE_v.a(sunJCE_l2, this.a[n]);
            ++n;
        }
        sunJCE_l.a((byte)6, sunJCE_l2);
    }

    private static int a(SunJCE_n sunJCE_n) throws IOException {
        int n = 0;
        int n2 = 0;
        while (n < 4) {
            n2 <<= 7;
            int n3 = sunJCE_n.p();
            n2 |= n3 & 0x7F;
            if ((n3 & 0x80) == 0) {
                return n2;
            }
            ++n;
        }
        throw new IOException("X509.OID, component value too big");
    }

    private static void a(SunJCE_l sunJCE_l, int n) throws IOException {
        byte[] byArray = new byte[4];
        int n2 = 0;
        while (n2 < 4) {
            byArray[n2] = (byte)(n & 0x7F);
            if ((n >>>= 7) == 0) break;
            ++n2;
        }
        while (n2 > 0) {
            sunJCE_l.write(byArray[n2] | 0x80);
            --n2;
        }
        sunJCE_l.write(byArray[0]);
    }

    public boolean a(SunJCE_v sunJCE_v) {
        if (sunJCE_v == this || this.b < sunJCE_v.b) {
            return false;
        }
        if (sunJCE_v.b < this.b) {
            return true;
        }
        int n = 0;
        while (n < this.b) {
            if (sunJCE_v.a[n] < this.a[n]) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public boolean equals(Object object) {
        if (object instanceof SunJCE_v) {
            return this.b((SunJCE_v)object);
        }
        return false;
    }

    public boolean b(SunJCE_v sunJCE_v) {
        if (sunJCE_v == this) {
            return true;
        }
        if (this.b != sunJCE_v.b) {
            return false;
        }
        int n = 0;
        while (n < this.b) {
            if (this.a[n] != sunJCE_v.a[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    public String toString() {
        int n = 0;
        String string = "";
        while (n < this.b) {
            if (n != 0) {
                string = string + ".";
            }
            string = string + this.a[n];
            ++n;
        }
        return string;
    }
}

