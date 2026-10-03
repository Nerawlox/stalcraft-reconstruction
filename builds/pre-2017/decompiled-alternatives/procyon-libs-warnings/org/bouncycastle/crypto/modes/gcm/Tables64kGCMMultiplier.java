// 
// Decompiled by Procyon v0.6.0
// 

package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.crypto.util.Pack;

public class Tables64kGCMMultiplier implements GCMMultiplier
{
    private final int[][][] M;
    
    public Tables64kGCMMultiplier() {
        this.M = new int[16][256][];
    }
    
    public void init(final byte[] array) {
        this.M[0][0] = new int[4];
        this.M[0][128] = GCMUtil.asInts(array);
        for (int i = 64; i >= 1; i >>= 1) {
            final int[] array2 = new int[4];
            System.arraycopy(this.M[0][i + i], 0, array2, 0, 4);
            GCMUtil.multiplyP(array2);
            this.M[0][i] = array2;
        }
        int n = 0;
        while (true) {
            for (int j = 2; j < 256; j += j) {
                for (int k = 1; k < j; ++k) {
                    final int[] array3 = new int[4];
                    System.arraycopy(this.M[n][j], 0, array3, 0, 4);
                    GCMUtil.xor(array3, this.M[n][k]);
                    this.M[n][j + k] = array3;
                }
            }
            if (++n == 16) {
                break;
            }
            this.M[n][0] = new int[4];
            for (int l = 128; l > 0; l >>= 1) {
                final int[] array4 = new int[4];
                System.arraycopy(this.M[n - 1][l], 0, array4, 0, 4);
                GCMUtil.multiplyP8(array4);
                this.M[n][l] = array4;
            }
        }
    }
    
    public void multiplyH(final byte[] array) {
        final int[] array2 = new int[4];
        for (int i = 15; i >= 0; --i) {
            final int[] array3 = this.M[i][array[i] & 0xFF];
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
        }
        Pack.intToBigEndian(array2, array, 0);
    }
}
