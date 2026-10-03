/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.util;

import java.math.BigInteger;

public final class Arrays {
    private Arrays() {
    }

    public static boolean areEqual(boolean[] blArray, boolean[] blArray2) {
        if (blArray == blArray2) {
            return true;
        }
        if (blArray == null || blArray2 == null) {
            return false;
        }
        if (blArray.length != blArray2.length) {
            return false;
        }
        for (int i = 0; i != blArray.length; ++i) {
            if (blArray[i] == blArray2[i]) continue;
            return false;
        }
        return true;
    }

    public static boolean areEqual(char[] cArray, char[] cArray2) {
        if (cArray == cArray2) {
            return true;
        }
        if (cArray == null || cArray2 == null) {
            return false;
        }
        if (cArray.length != cArray2.length) {
            return false;
        }
        for (int i = 0; i != cArray.length; ++i) {
            if (cArray[i] == cArray2[i]) continue;
            return false;
        }
        return true;
    }

    public static boolean areEqual(byte[] byArray, byte[] byArray2) {
        if (byArray == byArray2) {
            return true;
        }
        if (byArray == null || byArray2 == null) {
            return false;
        }
        if (byArray.length != byArray2.length) {
            return false;
        }
        for (int i = 0; i != byArray.length; ++i) {
            if (byArray[i] == byArray2[i]) continue;
            return false;
        }
        return true;
    }

    public static boolean constantTimeAreEqual(byte[] byArray, byte[] byArray2) {
        if (byArray == byArray2) {
            return true;
        }
        if (byArray == null || byArray2 == null) {
            return false;
        }
        if (byArray.length != byArray2.length) {
            return false;
        }
        int n = 0;
        for (int i = 0; i != byArray.length; ++i) {
            n |= byArray[i] ^ byArray2[i];
        }
        return n == 0;
    }

    public static boolean areEqual(int[] nArray, int[] nArray2) {
        if (nArray == nArray2) {
            return true;
        }
        if (nArray == null || nArray2 == null) {
            return false;
        }
        if (nArray.length != nArray2.length) {
            return false;
        }
        for (int i = 0; i != nArray.length; ++i) {
            if (nArray[i] == nArray2[i]) continue;
            return false;
        }
        return true;
    }

    public static boolean areEqual(long[] lArray, long[] lArray2) {
        if (lArray == lArray2) {
            return true;
        }
        if (lArray == null || lArray2 == null) {
            return false;
        }
        if (lArray.length != lArray2.length) {
            return false;
        }
        for (int i = 0; i != lArray.length; ++i) {
            if (lArray[i] == lArray2[i]) continue;
            return false;
        }
        return true;
    }

    public static boolean areEqual(BigInteger[] bigIntegerArray, BigInteger[] bigIntegerArray2) {
        if (bigIntegerArray == bigIntegerArray2) {
            return true;
        }
        if (bigIntegerArray == null || bigIntegerArray2 == null) {
            return false;
        }
        if (bigIntegerArray.length != bigIntegerArray2.length) {
            return false;
        }
        for (int i = 0; i != bigIntegerArray.length; ++i) {
            if (bigIntegerArray[i].equals(bigIntegerArray2[i])) continue;
            return false;
        }
        return true;
    }

    public static void fill(byte[] byArray, byte by) {
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = by;
        }
    }

    public static void fill(long[] lArray, long l) {
        for (int i = 0; i < lArray.length; ++i) {
            lArray[i] = l;
        }
    }

    public static void fill(short[] sArray, short s) {
        for (int i = 0; i < sArray.length; ++i) {
            sArray[i] = s;
        }
    }

    public static void fill(int[] nArray, int n) {
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = n;
        }
    }

    public static int hashCode(byte[] byArray) {
        if (byArray == null) {
            return 0;
        }
        int n = byArray.length;
        int n2 = n + 1;
        while (--n >= 0) {
            n2 *= 257;
            n2 ^= byArray[n];
        }
        return n2;
    }

    public static int hashCode(char[] cArray) {
        if (cArray == null) {
            return 0;
        }
        int n = cArray.length;
        int n2 = n + 1;
        while (--n >= 0) {
            n2 *= 257;
            n2 ^= cArray[n];
        }
        return n2;
    }

    public static int hashCode(int[] nArray) {
        if (nArray == null) {
            return 0;
        }
        int n = nArray.length;
        int n2 = n + 1;
        while (--n >= 0) {
            n2 *= 257;
            n2 ^= nArray[n];
        }
        return n2;
    }

    public static int hashCode(BigInteger[] bigIntegerArray) {
        if (bigIntegerArray == null) {
            return 0;
        }
        int n = bigIntegerArray.length;
        int n2 = n + 1;
        while (--n >= 0) {
            n2 *= 257;
            n2 ^= bigIntegerArray[n].hashCode();
        }
        return n2;
    }

    public static byte[] clone(byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        byte[] byArray2 = new byte[byArray.length];
        System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
        return byArray2;
    }

    public static int[] clone(int[] nArray) {
        if (nArray == null) {
            return null;
        }
        int[] nArray2 = new int[nArray.length];
        System.arraycopy(nArray, 0, nArray2, 0, nArray.length);
        return nArray2;
    }

    public static BigInteger[] clone(BigInteger[] bigIntegerArray) {
        if (bigIntegerArray == null) {
            return null;
        }
        BigInteger[] bigIntegerArray2 = new BigInteger[bigIntegerArray.length];
        System.arraycopy(bigIntegerArray, 0, bigIntegerArray2, 0, bigIntegerArray.length);
        return bigIntegerArray2;
    }

    public static byte[] copyOf(byte[] byArray, int n) {
        byte[] byArray2 = new byte[n];
        if (n < byArray.length) {
            System.arraycopy(byArray, 0, byArray2, 0, n);
        } else {
            System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
        }
        return byArray2;
    }

    public static int[] copyOf(int[] nArray, int n) {
        int[] nArray2 = new int[n];
        if (n < nArray.length) {
            System.arraycopy(nArray, 0, nArray2, 0, n);
        } else {
            System.arraycopy(nArray, 0, nArray2, 0, nArray.length);
        }
        return nArray2;
    }

    public static long[] copyOf(long[] lArray, int n) {
        long[] lArray2 = new long[n];
        if (n < lArray.length) {
            System.arraycopy(lArray, 0, lArray2, 0, n);
        } else {
            System.arraycopy(lArray, 0, lArray2, 0, lArray.length);
        }
        return lArray2;
    }

    public static BigInteger[] copyOf(BigInteger[] bigIntegerArray, int n) {
        BigInteger[] bigIntegerArray2 = new BigInteger[n];
        if (n < bigIntegerArray.length) {
            System.arraycopy(bigIntegerArray, 0, bigIntegerArray2, 0, n);
        } else {
            System.arraycopy(bigIntegerArray, 0, bigIntegerArray2, 0, bigIntegerArray.length);
        }
        return bigIntegerArray2;
    }

    public static byte[] copyOfRange(byte[] byArray, int n, int n2) {
        int n3 = Arrays.getLength(n, n2);
        byte[] byArray2 = new byte[n3];
        if (byArray.length - n < n3) {
            System.arraycopy(byArray, n, byArray2, 0, byArray.length - n);
        } else {
            System.arraycopy(byArray, n, byArray2, 0, n3);
        }
        return byArray2;
    }

    public static int[] copyOfRange(int[] nArray, int n, int n2) {
        int n3 = Arrays.getLength(n, n2);
        int[] nArray2 = new int[n3];
        if (nArray.length - n < n3) {
            System.arraycopy(nArray, n, nArray2, 0, nArray.length - n);
        } else {
            System.arraycopy(nArray, n, nArray2, 0, n3);
        }
        return nArray2;
    }

    public static long[] copyOfRange(long[] lArray, int n, int n2) {
        int n3 = Arrays.getLength(n, n2);
        long[] lArray2 = new long[n3];
        if (lArray.length - n < n3) {
            System.arraycopy(lArray, n, lArray2, 0, lArray.length - n);
        } else {
            System.arraycopy(lArray, n, lArray2, 0, n3);
        }
        return lArray2;
    }

    public static BigInteger[] copyOfRange(BigInteger[] bigIntegerArray, int n, int n2) {
        int n3 = Arrays.getLength(n, n2);
        BigInteger[] bigIntegerArray2 = new BigInteger[n3];
        if (bigIntegerArray.length - n < n3) {
            System.arraycopy(bigIntegerArray, n, bigIntegerArray2, 0, bigIntegerArray.length - n);
        } else {
            System.arraycopy(bigIntegerArray, n, bigIntegerArray2, 0, n3);
        }
        return bigIntegerArray2;
    }

    private static int getLength(int n, int n2) {
        int n3 = n2 - n;
        if (n3 < 0) {
            throw new IllegalArgumentException(n + " > " + n2);
        }
        return n3;
    }
}

