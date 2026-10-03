/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.crypto.modes.gcm.GCMMultiplier;
import org.bouncycastle.crypto.modes.gcm.GCMUtil;
import org.bouncycastle.crypto.util.Pack;

public class Tables8kGCMMultiplier
implements GCMMultiplier {
    private final int[][][] M = new int[32][16][];

    /*
     * Unable to fully structure code
     */
    public void init(byte[] var1_1) {
        this.M[0][0] = new int[4];
        this.M[1][0] = new int[4];
        this.M[1][8] = GCMUtil.asInts(var1_1);
        for (var2_2 = 4; var2_2 >= 1; var2_2 >>= 1) {
            var3_5 = new int[4];
            System.arraycopy(this.M[1][var2_2 + var2_2], 0, var3_5, 0, 4);
            GCMUtil.multiplyP(var3_5);
            this.M[1][var2_2] = var3_5;
        }
        var2_3 = new int[4];
        System.arraycopy(this.M[1][1], 0, var2_3, 0, 4);
        GCMUtil.multiplyP(var2_3);
        this.M[0][8] = var2_3;
        for (var2_4 = 4; var2_4 >= 1; var2_4 >>= 1) {
            var3_5 = new int[4];
            System.arraycopy(this.M[0][var2_4 + var2_4], 0, var3_5, 0, 4);
            GCMUtil.multiplyP(var3_5);
            this.M[0][var2_4] = var3_5;
        }
        var2_4 = 0;
        while (true) lbl-1000:
        // 4 sources

        {
            for (var3_6 = 2; var3_6 < 16; var3_6 += var3_6) {
                for (var4_7 = 1; var4_7 < var3_6; ++var4_7) {
                    var5_9 = new int[4];
                    System.arraycopy(this.M[var2_4][var3_6], 0, var5_9, 0, 4);
                    GCMUtil.xor(var5_9, this.M[var2_4][var4_7]);
                    this.M[var2_4][var3_6 + var4_7] = var5_9;
                }
            }
            if (++var2_4 == 32) {
                return;
            }
            if (var2_4 <= 1) ** continue;
            this.M[var2_4][0] = new int[4];
            var3_6 = 8;
            while (true) {
                if (var3_6 > 0) ** break;
                ** continue;
                var4_8 = new int[4];
                System.arraycopy(this.M[var2_4 - 2][var3_6], 0, var4_8, 0, 4);
                GCMUtil.multiplyP8(var4_8);
                this.M[var2_4][var3_6] = var4_8;
                var3_6 >>= 1;
            }
            break;
        }
    }

    public void multiplyH(byte[] byArray) {
        int[] nArray = new int[4];
        for (int i = 15; i >= 0; --i) {
            int[] nArray2 = this.M[i + i][byArray[i] & 0xF];
            nArray[0] = nArray[0] ^ nArray2[0];
            nArray[1] = nArray[1] ^ nArray2[1];
            nArray[2] = nArray[2] ^ nArray2[2];
            nArray[3] = nArray[3] ^ nArray2[3];
            nArray2 = this.M[i + i + 1][(byArray[i] & 0xF0) >>> 4];
            nArray[0] = nArray[0] ^ nArray2[0];
            nArray[1] = nArray[1] ^ nArray2[1];
            nArray[2] = nArray[2] ^ nArray2[2];
            nArray[3] = nArray[3] ^ nArray2[3];
        }
        Pack.intToBigEndian(nArray, byArray, 0);
    }
}

