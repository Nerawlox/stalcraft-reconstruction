/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.security.InvalidKeyException;
import java.security.spec.KeySpec;
import javax.crypto.spec.DESKeySpec;

public class DESedeKeySpec
implements KeySpec {
    public static final int DES_EDE_KEY_LEN = 24;
    private byte[] a;

    public DESedeKeySpec(byte[] byArray) throws InvalidKeyException {
        this(byArray, 0);
    }

    public DESedeKeySpec(byte[] byArray, int n) throws InvalidKeyException {
        if (byArray.length - n < 24) {
            throw new InvalidKeyException("Wrong key size");
        }
        this.a = new byte[24];
        System.arraycopy(byArray, n, this.a, 0, 24);
    }

    public byte[] getKey() {
        return (byte[])this.a.clone();
    }

    public static boolean isParityAdjusted(byte[] byArray, int n) throws InvalidKeyException {
        if (byArray.length - n < 24) {
            throw new InvalidKeyException("Wrong key size");
        }
        return DESKeySpec.isParityAdjusted(byArray, n) && DESKeySpec.isParityAdjusted(byArray, n + 8) && DESKeySpec.isParityAdjusted(byArray, n + 16);
    }
}

