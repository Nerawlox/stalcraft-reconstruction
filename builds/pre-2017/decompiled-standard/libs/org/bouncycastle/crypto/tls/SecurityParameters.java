/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

public class SecurityParameters {
    byte[] clientRandom = null;
    byte[] serverRandom = null;
    byte[] masterSecret = null;

    public byte[] getClientRandom() {
        return this.clientRandom;
    }

    public byte[] getServerRandom() {
        return this.serverRandom;
    }

    public byte[] getMasterSecret() {
        return this.masterSecret;
    }
}

