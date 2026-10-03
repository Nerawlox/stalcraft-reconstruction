/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class RC5ParameterSpec
implements AlgorithmParameterSpec {
    private byte[] a;
    private int b;
    private int c;
    private int d;

    public RC5ParameterSpec(int n, int n2, int n3) {
        this.b = n;
        this.c = n2;
        this.d = n3;
    }

    public RC5ParameterSpec(int n, int n2, int n3, byte[] byArray) {
        this(n, n2, n3, byArray, 0);
    }

    public RC5ParameterSpec(int n, int n2, int n3, byte[] byArray, int n4) {
        this.b = n;
        this.c = n2;
        this.d = n3;
        if (byArray == null) {
            throw new IllegalArgumentException("IV missing");
        }
        int n5 = n3 / 8 * 2;
        if (byArray.length - n4 < n5) {
            throw new IllegalArgumentException("IV too short");
        }
        this.a = new byte[n5];
        System.arraycopy(byArray, n4, this.a, 0, n5);
    }

    public int getVersion() {
        return this.b;
    }

    public int getRounds() {
        return this.c;
    }

    public int getWordSize() {
        return this.d;
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
        if (!(object instanceof RC5ParameterSpec)) {
            return false;
        }
        RC5ParameterSpec rC5ParameterSpec = (RC5ParameterSpec)object;
        return this.b == rC5ParameterSpec.b && this.c == rC5ParameterSpec.c && this.d == rC5ParameterSpec.d && Arrays.equals(this.a, rC5ParameterSpec.a);
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
        return n += this.b + this.c + this.d;
    }
}

