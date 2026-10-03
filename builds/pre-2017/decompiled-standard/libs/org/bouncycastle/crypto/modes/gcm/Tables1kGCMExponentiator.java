/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.crypto.modes.gcm.GCMExponentiator;
import org.bouncycastle.crypto.modes.gcm.GCMUtil;
import org.bouncycastle.util.Arrays;

public class Tables1kGCMExponentiator
implements GCMExponentiator {
    byte[][] lookupPowX2 = new byte[64][];

    public void init(byte[] byArray) {
        this.lookupPowX2[0] = GCMUtil.oneAsBytes();
        this.lookupPowX2[1] = Arrays.clone(byArray);
        for (int i = 2; i != 64; ++i) {
            byte[] byArray2 = Arrays.clone(this.lookupPowX2[i - 1]);
            GCMUtil.multiply(byArray2, byArray2);
            this.lookupPowX2[i] = byArray2;
        }
    }

    public void exponentiateX(long l, byte[] byArray) {
        byte[] byArray2 = GCMUtil.oneAsBytes();
        int n = 1;
        while (l > 0L) {
            if ((l & 1L) != 0L) {
                GCMUtil.multiply(byArray2, this.lookupPowX2[n]);
            }
            ++n;
            l >>>= 1;
        }
        System.arraycopy(byArray2, 0, byArray, 0, 16);
    }
}

