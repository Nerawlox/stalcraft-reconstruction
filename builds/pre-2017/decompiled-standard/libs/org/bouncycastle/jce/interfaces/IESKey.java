/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.interfaces;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

public interface IESKey
extends Key {
    public PublicKey getPublic();

    public PrivateKey getPrivate();
}

