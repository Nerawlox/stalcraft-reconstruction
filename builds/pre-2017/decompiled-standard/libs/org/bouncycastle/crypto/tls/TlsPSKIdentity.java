/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.tls;

public interface TlsPSKIdentity {
    public void skipIdentityHint();

    public void notifyIdentityHint(byte[] var1);

    public byte[] getPSKIdentity();

    public byte[] getPSK();
}

