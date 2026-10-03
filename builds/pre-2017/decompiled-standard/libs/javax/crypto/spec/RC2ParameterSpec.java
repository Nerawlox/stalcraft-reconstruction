/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class RC2ParameterSpec
implements AlgorithmParameterSpec {
    private byte[] a;
    private int b;

    public RC2ParameterSpec(int n) {
        this.b = n;
    }

    public RC2ParameterSpec(int n, byte[] byArray) {
        this(n, byArray, 0);
    }

    public RC2ParameterSpec(int n, byte[] byArray, int n2) {
        this.b = n;
        if (byArray == null) {
            throw new IllegalArgumentException("IV missing");
        }
        int n3 = 8;
        if (byArray.length - n2 < n3) {
            throw new IllegalArgumentException("IV too short");
        }
        this.a = new byte[n3];
        System.arraycopy(byArray, n2, this.a, 0, n3);
    }

    public int getEffectiveKeyBits() {
        return this.b;
    }

    public byte[] getIV() {
        if (this.a != null) {
            return (byte[])this.a.clone();
        }
        return null;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof RC2ParameterSpec)) {
            return false;
        }
        RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec)object;
        return this.b == rC2ParameterSpec.b && Arrays.equals(this.a, rC2ParameterSpec.a);
    }

    public int hashCode() {
        int n = 0;
        if (this.a != null) {
            int n2 = 1;
            while (n2 < this.a.length) {
                n += this.a[n2] * n2;
                ++n2;
            }
        }
        return n += this.b;
    }
}

