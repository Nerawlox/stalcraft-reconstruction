/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;

public class NullEngine
implements BlockCipher {
    private boolean initialised;
    protected static final int BLOCK_SIZE = 1;

    public void init(boolean bl, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.initialised = true;
    }

    public String getAlgorithmName() {
        return "Null";
    }

    public int getBlockSize() {
        return 1;
    }

    public int processBlock(byte[] byArray, int n, byte[] byArray2, int n2) throws DataLengthException, IllegalStateException {
        if (!this.initialised) {
            throw new IllegalStateException("Null engine not initialised");
        }
        if (n + 1 > byArray.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (n2 + 1 > byArray2.length) {
            throw new DataLengthException("output buffer too short");
        }
        for (int i = 0; i < 1; ++i) {
            byArray2[n2 + i] = byArray[n + i];
        }
        return 1;
    }

    public void reset() {
    }
}

