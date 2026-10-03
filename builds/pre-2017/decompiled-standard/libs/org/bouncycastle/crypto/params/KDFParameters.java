/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;

public class KDFParameters
implements DerivationParameters {
    byte[] iv;
    byte[] shared;

    public KDFParameters(byte[] byArray, byte[] byArray2) {
        this.shared = byArray;
        this.iv = byArray2;
    }

    public byte[] getSharedSecret() {
        return this.shared;
    }

    public byte[] getIV() {
        return this.iv;
    }
}

