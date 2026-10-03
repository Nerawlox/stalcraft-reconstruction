/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.crypto.modes.gcm.GCMExponentiator;
import org.bouncycastle.crypto.modes.gcm.GCMUtil;
import org.bouncycastle.util.Arrays;

public class BasicGCMExponentiator
implements GCMExponentiator {
    private byte[] x;

    public void init(byte[] byArray) {
        this.x = Arrays.clone(byArray);
    }

    public void exponentiateX(long l, byte[] byArray) {
        byte[] byArray2 = GCMUtil.oneAsBytes();
        if (l > 0L) {
            byte[] byArray3 = Arrays.clone(this.x);
            do {
                if ((l & 1L) != 0L) {
                    GCMUtil.multiply(byArray2, byArray3);
                }
                GCMUtil.multiply(byArray3, byArray3);
            } while ((l >>>= 1) > 0L);
        }
        System.arraycopy(byArray2, 0, byArray, 0, 16);
    }
}

