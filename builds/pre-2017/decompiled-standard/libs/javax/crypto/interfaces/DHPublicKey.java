/*
 * Decompiled with CFR 0.152.
 */
package javax.crypto.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;
import javax.crypto.interfaces.DHKey;

public interface DHPublicKey
extends DHKey,
PublicKey {
    public BigInteger getY();
}

