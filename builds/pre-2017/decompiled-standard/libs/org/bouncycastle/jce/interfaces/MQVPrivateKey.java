/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.interfaces;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface MQVPrivateKey
extends PrivateKey {
    public PrivateKey getStaticPrivateKey();

    public PrivateKey getEphemeralPrivateKey();

    public PublicKey getEphemeralPublicKey();
}

