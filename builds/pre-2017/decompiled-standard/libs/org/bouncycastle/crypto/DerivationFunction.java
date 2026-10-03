/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.Digest;

public interface DerivationFunction {
    public void init(DerivationParameters var1);

    public Digest getDigest();

    public int generateBytes(byte[] var1, int var2, int var3) throws DataLengthException, IllegalArgumentException;
}

