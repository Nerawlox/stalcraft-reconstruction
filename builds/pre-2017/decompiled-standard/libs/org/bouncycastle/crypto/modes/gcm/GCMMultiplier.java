/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes.gcm;

public interface GCMMultiplier {
    public void init(byte[] var1);

    public void multiplyH(byte[] var1);
}

