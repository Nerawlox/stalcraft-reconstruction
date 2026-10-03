/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;

class ReferenceMultiplier
implements ECMultiplier {
    ReferenceMultiplier() {
    }

    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        ECPoint eCPoint2 = eCPoint.getCurve().getInfinity();
        int n = bigInteger.bitLength();
        for (int i = 0; i < n; ++i) {
            if (bigInteger.testBit(i)) {
                eCPoint2 = eCPoint2.add(eCPoint);
            }
            eCPoint = eCPoint.twice();
        }
        return eCPoint2;
    }
}

