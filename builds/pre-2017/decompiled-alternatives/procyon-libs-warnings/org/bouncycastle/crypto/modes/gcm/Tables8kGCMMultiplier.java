// 
// Decompiled by Procyon v0.6.0
// 

package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.crypto.util.Pack;

public class Tables8kGCMMultiplier implements GCMMultiplier
{
    private final int[][][] M;
    
    public Tables8kGCMMultiplier() {
        this.M = new int[32][16][];
    }
    
    public void init(final byte[] array) {
        this.M[0][0] = new int[4];
        this.M[1][0] = new int[4];
        this.M[1][8] = GCMUtil.asInts(array);
        for (int i = 4; i >= 1; i >>= 1) {
            final int[] array2 = new int[4];
            System.arraycopy(this.M[1][i + i], 0, array2, 0, 4);
            GCMUtil.multiplyP(array2);
            this.M[1][i] = array2;
        }
        final int[] array3 = new int[4];
        System.arraycopy(this.M[1][1], 0, array3, 0, 4);
        GCMUtil.multiplyP(array3);
        this.M[0][8] = array3;
        for (int j = 4; j >= 1; j >>= 1) {
            final int[] array4 = new int[4];
            System.arraycopy(this.M[0][j + j], 0, array4, 0, 4);
            GCMUtil.multiplyP(array4);
            this.M[0][j] = array4;
        }
        int n = 0;
        while (true) {
            for (int k = 2; k < 16; k += k) {
                for (int l = 1; l < k; ++l) {
                    final int[] array5 = new int[4];
                    System.arraycopy(this.M[n][k], 0, array5, 0, 4);
                    GCMUtil.xor(array5, this.M[n][l]);
                    this.M[n][k + l] = array5;
                }
            }
            if (++n == 32) {
                break;
            }
            if (n <= 1) {
                continue;
            }
            this.M[n][0] = new int[4];
            for (int n2 = 8; n2 > 0; n2 >>= 1) {
                final int[] array6 = new int[4];
                System.arraycopy(this.M[n - 2][n2], 0, array6, 0, 4);
                GCMUtil.multiplyP8(array6);
                this.M[n][n2] = array6;
            }
        }
    }
    
    public void multiplyH(final byte[] array) {
        final int[] array2 = new int[4];
        for (int i = 15; i >= 0; --i) {
            final int[] array3 = this.M[i + i][array[i] & 0xF];
            final int[] array4 = array2;
            final int n = 0;
            array4[n] ^= array3[0];
            final int[] array5 = array2;
            final int n2 = 1;
            array5[n2] ^= array3[1];
            final int[] array6 = array2;
            final int n3 = 2;
            array6[n3] ^= array3[2];
            final int[] array7 = array2;
            final int n4 = 3;
            array7[n4] ^= array3[3];
            final int[] array8 = this.M[i + i + 1][(array[i] & 0xF0) >>> 4];
            final int[] array9 = array2;
            final int n5 = 0;
            array9[n5] ^= array8[0];
            final int[] array10 = array2;
            final int n6 = 1;
            array10[n6] ^= array8[1];
            final int[] array11 = array2;
            final int n7 = 2;
            array11[n7] ^= array8[2];
            final int[] array12 = array2;
            final int n8 = 3;
            array12[n8] ^= array8[3];
        }
        Pack.intToBigEndian(array2, array, 0);
    }
}
