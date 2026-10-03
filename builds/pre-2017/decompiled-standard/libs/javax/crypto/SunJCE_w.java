/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto;

import java.security.cert.X509Certificate;
import java.util.Arrays;

class SunJCE_w {
    X509Certificate[] a = null;
    int b = -1;

    SunJCE_w(X509Certificate[] x509CertificateArray) {
        this.a = x509CertificateArray;
    }

    public boolean equals(Object object) {
        if (!(object instanceof SunJCE_w)) {
            return false;
        }
        SunJCE_w sunJCE_w = (SunJCE_w)object;
        return Arrays.equals(this.a, sunJCE_w.a);
    }

    public int hashCode() {
        if (this.b != -1) {
            return this.b;
        }
        if (this.a == null) {
            this.b = 0;
        } else {
            int n = this.a.length;
            int n2 = 0;
            while (n2 < this.a.length) {
                n += this.a[n2].hashCode() * (n2 + 1);
                ++n2;
            }
            this.b = n;
        }
        return this.b;
    }

    public X509Certificate[] toArray() {
        return this.a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        int n = 0;
        while (n < this.a.length) {
            stringBuffer.append("\tcert[" + n + "]: " + this.a[n].getSubjectDN().toString() + "\n");
            ++n;
        }
        return stringBuffer.toString();
    }
}

