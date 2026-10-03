/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;
import org.bouncycastle.jce.interfaces.ElGamalKey;

public interface ElGamalPublicKey
extends ElGamalKey,
PublicKey {
    public BigInteger getY();
}

