/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;

class FpNafMultiplier
implements ECMultiplier {
    FpNafMultiplier() {
    }

    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        BigInteger bigInteger2 = bigInteger;
        BigInteger bigInteger3 = bigInteger2.multiply(BigInteger.valueOf(3L));
        ECPoint eCPoint2 = eCPoint.negate();
        ECPoint eCPoint3 = eCPoint;
        for (int i = bigInteger3.bitLength() - 2; i > 0; --i) {
            boolean bl;
            eCPoint3 = eCPoint3.twice();
            boolean bl2 = bigInteger3.testBit(i);
            if (bl2 == (bl = bigInteger2.testBit(i))) continue;
            eCPoint3 = eCPoint3.add(bl2 ? eCPoint : eCPoint2);
        }
        return eCPoint3;
    }
}

