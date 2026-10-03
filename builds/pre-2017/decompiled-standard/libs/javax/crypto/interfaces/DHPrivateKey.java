/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;
import javax.crypto.interfaces.DHKey;

public interface DHPrivateKey
extends DHKey,
PrivateKey {
    public BigInteger getX();
}

