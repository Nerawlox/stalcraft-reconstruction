/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.modes.gcm;

public interface GCMExponentiator {
    public void init(byte[] var1);

    public void exponentiateX(long var1, byte[] var3);
}

