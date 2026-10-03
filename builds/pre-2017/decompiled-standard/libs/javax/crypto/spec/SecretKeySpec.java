/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKey;

public class SecretKeySpec
implements KeySpec,
SecretKey {
    private byte[] key;
    private String algorithm;

    public SecretKeySpec(byte[] byArray, String string) {
        if (byArray == null || string == null) {
            throw new IllegalArgumentException("Missing argument");
        }
        if (byArray.length == 0) {
            throw new IllegalArgumentException("Empty key");
        }
        this.key = (byte[])byArray.clone();
        this.algorithm = string;
    }

    public SecretKeySpec(byte[] byArray, int n, int n2, String string) {
        if (byArray == null || string == null) {
            throw new IllegalArgumentException("Missing argument");
        }
        if (byArray.length == 0) {
            throw new IllegalArgumentException("Empty key");
        }
        if (byArray.length - n < n2) {
            throw new IllegalArgumentException("Invalid offset/length combination");
        }
        this.key = new byte[n2];
        System.arraycopy(byArray, n, this.key, 0, n2);
        this.algorithm = string;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getFormat() {
        return "RAW";
    }

    public byte[] getEncoded() {
        return (byte[])this.key.clone();
    }

    public int hashCode() {
        int n = 0;
        int n2 = 1;
        while (n2 < this.key.length) {
            n += this.key[n2] * n2;
            ++n2;
        }
        if (this.algorithm.equalsIgnoreCase("TripleDES")) {
            return n ^= "desede".hashCode();
        }
        return n ^= this.algorithm.toLowerCase().hashCode();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SecretKey)) {
            return false;
        }
        String string = ((SecretKey)object).getAlgorithm();
        if (!(string.equalsIgnoreCase(this.algorithm) || string.equalsIgnoreCase("DESede") && this.algorithm.equalsIgnoreCase("TripleDES") || string.equalsIgnoreCase("TripleDES") && this.algorithm.equalsIgnoreCase("DESede"))) {
            return false;
        }
        byte[] byArray = ((SecretKey)object).getEncoded();
        return Arrays.equals(this.key, byArray);
    }
}

