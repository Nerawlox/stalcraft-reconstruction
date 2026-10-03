/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto;

public interface Digest {
    public String getAlgorithmName();

    public int getDigestSize();

    public void update(byte var1);

    public void update(byte[] var1, int var2, int var3);

    public int doFinal(byte[] var1, int var2);

    public void reset();
}

