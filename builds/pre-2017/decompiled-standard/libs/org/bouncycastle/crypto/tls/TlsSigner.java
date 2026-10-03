/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

interface TlsSigner {
    public byte[] calculateRawSignature(SecureRandom var1, AsymmetricKeyParameter var2, byte[] var3) throws CryptoException;

    public Signer createVerifyer(AsymmetricKeyParameter var1);

    public boolean isValidPublicKey(AsymmetricKeyParameter var1);
}

