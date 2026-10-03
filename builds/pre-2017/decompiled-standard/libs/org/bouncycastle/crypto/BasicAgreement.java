/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public interface BasicAgreement {
    public void init(CipherParameters var1);

    public BigInteger calculateAgreement(CipherParameters var1);
}

