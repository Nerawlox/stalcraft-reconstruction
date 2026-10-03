/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto;

import org.bouncycastle.crypto.CipherParameters;

public class AsymmetricCipherKeyPair {
    private CipherParameters publicParam;
    private CipherParameters privateParam;

    public AsymmetricCipherKeyPair(CipherParameters cipherParameters, CipherParameters cipherParameters2) {
        this.publicParam = cipherParameters;
        this.privateParam = cipherParameters2;
    }

    public CipherParameters getPublic() {
        return this.publicParam;
    }

    public CipherParameters getPrivate() {
        return this.privateParam;
    }
}

