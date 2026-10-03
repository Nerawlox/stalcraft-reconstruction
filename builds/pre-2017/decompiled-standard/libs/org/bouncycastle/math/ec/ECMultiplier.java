/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;

interface ECMultiplier {
    public ECPoint multiply(ECPoint var1, BigInteger var2, PreCompInfo var3);
}

