/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.interfaces;

import java.security.PublicKey;

public interface MQVPublicKey
extends PublicKey {
    public PublicKey getStaticKey();

    public PublicKey getEphemeralKey();
}

