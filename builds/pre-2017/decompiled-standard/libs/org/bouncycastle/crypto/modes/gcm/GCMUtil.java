/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.crypto.util.Pack;
import org.bouncycastle.util.Arrays;

abstract class GCMUtil {
    GCMUtil() {
    }

    static byte[] oneAsBytes() {
        byte[] byArray = new byte[16];
        byArray[0] = -128;
        return byArray;
    }

    static int[] oneAsInts() {
        int[] nArray = new int[4];
        nArray[0] = Integer.MIN_VALUE;
        return nArray;
    }

    static int[] asInts(byte[] byArray) {
        int[] nArray = new int[]{Pack.bigEndianToInt(byArray, 0), Pack.bigEndianToInt(byArray, 4), Pack.bigEndianToInt(byArray, 8), Pack.bigEndianToInt(byArray, 12)};
        return nArray;
    }

    static void multiply(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = Arrays.clone(byArray);
        byte[] byArray4 = new byte[16];
        for (int i = 0; i < 16; ++i) {
            byte by = byArray2[i];
            for (int j = 7; j >= 0; --j) {
                if ((by & 1 << j) != 0) {
                    GCMUtil.xor(byArray4, byArray3);
                }
                boolean bl = (byArray3[15] & 1) != 0;
                GCMUtil.shiftRight(byArray3);
                if (!bl) continue;
                byArray3[0] = (byte)(byArray3[0] ^ 0xFFFFFFE1);
            }
        }
        System.arraycopy(byArray4, 0, byArray, 0, 16);
    }

    static void multiplyP(int[] nArray) {
        boolean bl = (nArray[3] & 1) != 0;
        GCMUtil.shiftRight(nArray);
        if (bl) {
            nArray[0] = nArray[0] ^ 0xE1000000;
        }
    }

    static void multiplyP8(int[] nArray) {
        int n = nArray[3];
        GCMUtil.shiftRightN(nArray, 8);
        for (int i = 7; i >= 0; --i) {
            if ((n & 1 << i) == 0) continue;
            nArray[0] = nArray[0] ^ -520093696 >>> 7 - i;
        }
    }

    static void shiftRight(byte[] byArray) {
        int n = 0;
        int n2 = 0;
        while (true) {
            int n3 = byArray[n] & 0xFF;
            byArray[n] = (byte)(n3 >>> 1 | n2);
            if (++n == 16) break;
            n2 = (n3 & 1) << 7;
        }
    }

    static void shiftRight(int[] nArray) {
        int n = 0;
        int n2 = 0;
        while (true) {
            int n3 = nArray[n];
            nArray[n] = n3 >>> 1 | n2;
            if (++n == 4) break;
            n2 = n3 << 31;
        }
    }

    static void shiftRightN(int[] nArray, int n) {
        int n2 = 0;
        int n3 = 0;
        while (true) {
            int n4 = nArray[n2];
            nArray[n2] = n4 >>> n | n3;
            if (++n2 == 4) break;
            n3 = n4 << 32 - n;
        }
    }

    static void xor(byte[] byArray, byte[] byArray2) {
        for (int i = 15; i >= 0; --i) {
            int n = i;
            byArray[n] = (byte)(byArray[n] ^ byArray2[i]);
        }
    }

    static void xor(int[] nArray, int[] nArray2) {
        for (int i = 3; i >= 0; --i) {
            int n = i;
            nArray[n] = nArray[n] ^ nArray2[i];
        }
    }
}

