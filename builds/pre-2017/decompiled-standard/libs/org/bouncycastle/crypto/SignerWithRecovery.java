/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto;

import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Signer;

public interface SignerWithRecovery
extends Signer {
    public boolean hasFullMessage();

    public byte[] getRecoveredMessage();

    public void updateWithRecoveredMessage(byte[] var1) throws InvalidCipherTextException;
}

