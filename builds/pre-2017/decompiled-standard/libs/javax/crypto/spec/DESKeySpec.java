/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.spec;

import java.security.InvalidKeyException;
import java.security.spec.KeySpec;

public class DESKeySpec
implements KeySpec {
    public static final int DES_KEY_LEN = 8;
    private byte[] a;
    private static final byte[] b = new byte[]{-128, 64, 32, 16, 8, 4, 2};
    private static final byte[][] c = new byte[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {-2, -2, -2, -2, -2, -2, -2, -2}, {31, 31, 31, 31, 31, 31, 31, 31}, {-32, -32, -32, -32, -32, -32, -32, -32}, {1, -2, 1, -2, 1, -2, 1, -2}, {31, -32, 31, -32, 14, -15, 14, -15}, {1, -32, 1, -32, 1, -15, 1, -15}, {31, -2, 31, -2, 14, -2, 14, -2}, {1, 31, 1, 31, 1, 14, 1, 14}, {-32, -2, -32, -2, -15, -2, -15, -2}, {-2, 1, -2, 1, -2, 1, -2, 1}, {-32, 31, -32, 31, -15, 14, -15, 14}, {-32, 1, -32, 1, -15, 1, -15, 1}, {-2, 31, -2, 31, -2, 14, -2, 14}, {31, 1, 31, 1, 14, 1, 14, 1}, {-2, -32, -2, -32, -2, -15, -2, -15}};

    public DESKeySpec(byte[] byArray) throws InvalidKeyException {
        this(byArray, 0);
    }

    public DESKeySpec(byte[] byArray, int n) throws InvalidKeyException {
        if (byArray.length - n < 8) {
            throw new InvalidKeyException("Wrong key size");
        }
        this.a = new byte[8];
        System.arraycopy(byArray, n, this.a, 0, 8);
    }

    public byte[] getKey() {
        return (byte[])this.a.clone();
    }

    public static boolean isParityAdjusted(byte[] byArray, int n) throws InvalidKeyException {
        if (byArray == null) {
            throw new InvalidKeyException("null key");
        }
        if (byArray.length - n < 8) {
            throw new InvalidKeyException("Wrong key size");
        }
        int n2 = 0;
        while (n2 < 8) {
            int n3 = 0;
            int n4 = 0;
            while (n4 < b.length) {
                if ((byArray[n2 + n] & b[n4]) == b[n4]) {
                    ++n3;
                }
                ++n4;
            }
            if (n3 & true ? (byArray[n2 + n] & 1) == 1 : (byArray[n2 + n] & 1) != 1) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public static boolean isWeak(byte[] byArray, int n) throws InvalidKeyException {
        if (byArray == null) {
            throw new InvalidKeyException("null key");
        }
        if (byArray.length - n < 8) {
            throw new InvalidKeyException("Wrong key size");
        }
        int n2 = 0;
        while (n2 < c.length) {
            boolean bl = true;
            int n3 = 0;
            while (n3 < 8 && bl) {
                if (c[n2][n3] != byArray[n3 + n]) {
                    bl = false;
                }
                ++n3;
            }
            if (bl) {
                return bl;
            }
            ++n2;
        }
        return false;
    }
}

