/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamCipher;

public class StreamBlockCipher
implements StreamCipher {
    private BlockCipher cipher;
    private byte[] oneByte = new byte[1];

    public StreamBlockCipher(BlockCipher blockCipher) {
        if (blockCipher.getBlockSize() != 1) {
            throw new IllegalArgumentException("block cipher block size != 1.");
        }
        this.cipher = blockCipher;
    }

    public void init(boolean bl, CipherParameters cipherParameters) {
        this.cipher.init(bl, cipherParameters);
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    public byte returnByte(byte by) {
        this.oneByte[0] = by;
        this.cipher.processBlock(this.oneByte, 0, this.oneByte, 0);
        return this.oneByte[0];
    }

    public void processBytes(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws DataLengthException {
        if (n3 + n2 > byArray2.length) {
            throw new DataLengthException("output buffer too small in processBytes()");
        }
        for (int i = 0; i != n2; ++i) {
            this.cipher.processBlock(byArray, n + i, byArray2, n3 + i);
        }
    }

    public void reset() {
        this.cipher.reset();
    }
}

