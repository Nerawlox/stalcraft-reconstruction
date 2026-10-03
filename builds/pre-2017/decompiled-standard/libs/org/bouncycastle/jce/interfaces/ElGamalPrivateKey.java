/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;
import org.bouncycastle.jce.interfaces.ElGamalKey;

public interface ElGamalPrivateKey
extends ElGamalKey,
PrivateKey {
    public BigInteger getX();
}

