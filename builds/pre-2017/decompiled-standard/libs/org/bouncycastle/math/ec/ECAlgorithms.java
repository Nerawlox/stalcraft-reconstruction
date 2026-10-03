/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECAlgorithms {
    public static ECPoint sumOfTwoMultiplies(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECCurve.F2m f2m;
        ECCurve eCCurve = eCPoint.getCurve();
        if (!eCCurve.equals(eCPoint2.getCurve())) {
            throw new IllegalArgumentException("P and Q must be on same curve");
        }
        if (eCCurve instanceof ECCurve.F2m && (f2m = (ECCurve.F2m)eCCurve).isKoblitz()) {
            return eCPoint.multiply(bigInteger).add(eCPoint2.multiply(bigInteger2));
        }
        return ECAlgorithms.implShamirsTrick(eCPoint, bigInteger, eCPoint2, bigInteger2);
    }

    public static ECPoint shamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        if (!eCPoint.getCurve().equals(eCPoint2.getCurve())) {
            throw new IllegalArgumentException("P and Q must be on same curve");
        }
        return ECAlgorithms.implShamirsTrick(eCPoint, bigInteger, eCPoint2, bigInteger2);
    }

    private static ECPoint implShamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        int n = Math.max(bigInteger.bitLength(), bigInteger2.bitLength());
        ECPoint eCPoint3 = eCPoint.add(eCPoint2);
        ECPoint eCPoint4 = eCPoint.getCurve().getInfinity();
        for (int i = n - 1; i >= 0; --i) {
            eCPoint4 = eCPoint4.twice();
            if (bigInteger.testBit(i)) {
                if (bigInteger2.testBit(i)) {
                    eCPoint4 = eCPoint4.add(eCPoint3);
                    continue;
                }
                eCPoint4 = eCPoint4.add(eCPoint);
                continue;
            }
            if (!bigInteger2.testBit(i)) continue;
            eCPoint4 = eCPoint4.add(eCPoint2);
        }
        return eCPoint4;
    }
}

