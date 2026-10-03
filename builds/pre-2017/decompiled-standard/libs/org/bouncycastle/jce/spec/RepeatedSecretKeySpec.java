/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.spec;

import javax.crypto.SecretKey;

public class RepeatedSecretKeySpec
implements SecretKey {
    private String algorithm;

    public RepeatedSecretKeySpec(String string) {
        this.algorithm = string;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getFormat() {
        return null;
    }

    public byte[] getEncoded() {
        return null;
    }
}

