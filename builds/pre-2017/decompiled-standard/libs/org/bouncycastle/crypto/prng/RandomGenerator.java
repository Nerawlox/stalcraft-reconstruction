/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.prng;

public interface RandomGenerator {
    public void addSeedMaterial(byte[] var1);

    public void addSeedMaterial(long var1);

    public void nextBytes(byte[] var1);

    public void nextBytes(byte[] var1, int var2, int var3);
}

