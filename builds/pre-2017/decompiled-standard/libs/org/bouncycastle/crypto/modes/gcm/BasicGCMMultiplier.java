/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.crypto.modes.gcm.GCMMultiplier;
import org.bouncycastle.crypto.modes.gcm.GCMUtil;
import org.bouncycastle.util.Arrays;

public class BasicGCMMultiplier
implements GCMMultiplier {
    private byte[] H;

    public void init(byte[] byArray) {
        this.H = Arrays.clone(byArray);
    }

    public void multiplyH(byte[] byArray) {
        GCMUtil.multiply(byArray, this.H);
    }
}

