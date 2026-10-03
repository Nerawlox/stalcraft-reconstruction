/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.crypto.modes.gcm.GCMMultiplier;
import org.bouncycastle.crypto.modes.gcm.GCMUtil;
import org.bouncycastle.crypto.util.Pack;

public class Tables64kGCMMultiplier
implements GCMMultiplier {
    private final int[][][] M = new int[16][256][];

    /*
     * Unable to fully structure code
     */
    public void init(byte[] var1_1) {
        this.M[0][0] = new int[4];
        this.M[0][128] = GCMUtil.asInts(var1_1);
        for (var2_2 = 64; var2_2 >= 1; var2_2 >>= 1) {
            var3_3 = new int[4];
            System.arraycopy(this.M[0][var2_2 + var2_2], 0, var3_3, 0, 4);
            GCMUtil.multiplyP(var3_3);
            this.M[0][var2_2] = var3_3;
        }
        var2_2 = 0;
        while (true) {
            for (var3_4 = 2; var3_4 < 256; var3_4 += var3_4) {
                for (var4_5 = 1; var4_5 < var3_4; ++var4_5) {
                    var5_7 = new int[4];
                    System.arraycopy(this.M[var2_2][var3_4], 0, var5_7, 0, 4);
                    GCMUtil.xor(var5_7, this.M[var2_2][var4_5]);
                    this.M[var2_2][var3_4 + var4_5] = var5_7;
                }
            }
            if (++var2_2 == 16) {
                return;
            }
            this.M[var2_2][0] = new int[4];
            var3_4 = 128;
            while (true) {
                if (var3_4 <= 0) ** continue;
                var4_6 = new int[4];
                System.arraycopy(this.M[var2_2 - 1][var3_4], 0, var4_6, 0, 4);
                GCMUtil.multiplyP8(var4_6);
                this.M[var2_2][var3_4] = var4_6;
                var3_4 >>= 1;
            }
            break;
        }
    }

    public void multiplyH(byte[] byArray) {
        int[] nArray = new int[4];
        for (int i = 15; i >= 0; --i) {
            int[] nArray2 = this.M[i][byArray[i] & 0xFF];
            nArray[0] = nArray[0] ^ nArray2[0];
            nArray[1] = nArray[1] ^ nArray2[1];
            nArray[2] = nArray[2] ^ nArray2[2];
            nArray[3] = nArray[3] ^ nArray2[3];
        }
        Pack.intToBigEndian(nArray, byArray, 0);
    }
}

