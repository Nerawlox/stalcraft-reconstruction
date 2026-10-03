/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.util;

public abstract class Pack {
    public static int bigEndianToInt(byte[] byArray, int n) {
        int n2 = byArray[n] << 24;
        n2 |= (byArray[++n] & 0xFF) << 16;
        n2 |= (byArray[++n] & 0xFF) << 8;
        return n2 |= byArray[++n] & 0xFF;
    }

    public static void bigEndianToInt(byte[] byArray, int n, int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = Pack.bigEndianToInt(byArray, n);
            n += 4;
        }
    }

    public static void intToBigEndian(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)(n >>> 24);
        byArray[++n2] = (byte)(n >>> 16);
        byArray[++n2] = (byte)(n >>> 8);
        byArray[++n2] = (byte)n;
    }

    public static void intToBigEndian(int[] nArray, byte[] byArray, int n) {
        for (int i = 0; i < nArray.length; ++i) {
            Pack.intToBigEndian(nArray[i], byArray, n);
            n += 4;
        }
    }

    public static long bigEndianToLong(byte[] byArray, int n) {
        int n2 = Pack.bigEndianToInt(byArray, n);
        int n3 = Pack.bigEndianToInt(byArray, n + 4);
        return ((long)n2 & 0xFFFFFFFFL) << 32 | (long)n3 & 0xFFFFFFFFL;
    }

    public static void longToBigEndian(long l, byte[] byArray, int n) {
        Pack.intToBigEndian((int)(l >>> 32), byArray, n);
        Pack.intToBigEndian((int)(l & 0xFFFFFFFFL), byArray, n + 4);
    }

    public static int littleEndianToInt(byte[] byArray, int n) {
        int n2 = byArray[n] & 0xFF;
        n2 |= (byArray[++n] & 0xFF) << 8;
        n2 |= (byArray[++n] & 0xFF) << 16;
        return n2 |= byArray[++n] << 24;
    }

    public static void littleEndianToInt(byte[] byArray, int n, int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = Pack.littleEndianToInt(byArray, n);
            n += 4;
        }
    }

    public static void intToLittleEndian(int n, byte[] byArray, int n2) {
        byArray[n2] = (byte)n;
        byArray[++n2] = (byte)(n >>> 8);
        byArray[++n2] = (byte)(n >>> 16);
        byArray[++n2] = (byte)(n >>> 24);
    }

    public static void intToLittleEndian(int[] nArray, byte[] byArray, int n) {
        for (int i = 0; i < nArray.length; ++i) {
            Pack.intToLittleEndian(nArray[i], byArray, n);
            n += 4;
        }
    }

    public static long littleEndianToLong(byte[] byArray, int n) {
        int n2 = Pack.littleEndianToInt(byArray, n);
        int n3 = Pack.littleEndianToInt(byArray, n + 4);
        return ((long)n3 & 0xFFFFFFFFL) << 32 | (long)n2 & 0xFFFFFFFFL;
    }

    public static void longToLittleEndian(long l, byte[] byArray, int n) {
        Pack.intToLittleEndian((int)(l & 0xFFFFFFFFL), byArray, n);
        Pack.intToLittleEndian((int)(l >>> 32), byArray, n + 4);
    }
}

