/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;
import org.bouncycastle.math.ec.WNafPreCompInfo;

class WNafMultiplier
implements ECMultiplier {
    WNafMultiplier() {
    }

    public byte[] windowNaf(byte by, BigInteger bigInteger) {
        Object object;
        byte[] byArray = new byte[bigInteger.bitLength() + 1];
        short s = (short)(1 << by);
        BigInteger bigInteger2 = BigInteger.valueOf(s);
        int n = 0;
        int n2 = 0;
        while (bigInteger.signum() > 0) {
            if (bigInteger.testBit(0)) {
                object = bigInteger.mod(bigInteger2);
                byArray[n] = ((BigInteger)object).testBit(by - 1) ? (byte)(((BigInteger)object).intValue() - s) : (byte)((BigInteger)object).intValue();
                bigInteger = bigInteger.subtract(BigInteger.valueOf(byArray[n]));
                n2 = n;
            } else {
                byArray[n] = 0;
            }
            bigInteger = bigInteger.shiftRight(1);
            ++n;
        }
        object = new byte[++n2];
        System.arraycopy(byArray, 0, object, 0, n2);
        return object;
    }

    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        int n;
        Object[] objectArray;
        int n2;
        byte by;
        WNafPreCompInfo wNafPreCompInfo = preCompInfo != null && preCompInfo instanceof WNafPreCompInfo ? (WNafPreCompInfo)preCompInfo : new WNafPreCompInfo();
        int n3 = bigInteger.bitLength();
        if (n3 < 13) {
            by = 2;
            n2 = 1;
        } else if (n3 < 41) {
            by = 3;
            n2 = 2;
        } else if (n3 < 121) {
            by = 4;
            n2 = 4;
        } else if (n3 < 337) {
            by = 5;
            n2 = 8;
        } else if (n3 < 897) {
            by = 6;
            n2 = 16;
        } else if (n3 < 2305) {
            by = 7;
            n2 = 32;
        } else {
            by = 8;
            n2 = 127;
        }
        int n4 = 1;
        ECPoint[] eCPointArray = wNafPreCompInfo.getPreComp();
        ECPoint eCPoint2 = wNafPreCompInfo.getTwiceP();
        if (eCPointArray == null) {
            eCPointArray = new ECPoint[]{eCPoint};
        } else {
            n4 = eCPointArray.length;
        }
        if (eCPoint2 == null) {
            eCPoint2 = eCPoint.twice();
        }
        if (n4 < n2) {
            objectArray = eCPointArray;
            eCPointArray = new ECPoint[n2];
            System.arraycopy(objectArray, 0, eCPointArray, 0, n4);
            for (n = n4; n < n2; ++n) {
                eCPointArray[n] = eCPoint2.add(eCPointArray[n - 1]);
            }
        }
        objectArray = this.windowNaf(by, bigInteger);
        n = objectArray.length;
        ECPoint eCPoint3 = eCPoint.getCurve().getInfinity();
        for (int i = n - 1; i >= 0; --i) {
            eCPoint3 = eCPoint3.twice();
            if (objectArray[i] == false) continue;
            eCPoint3 = objectArray[i] > 0 ? eCPoint3.add(eCPointArray[(objectArray[i] - true) / 2]) : eCPoint3.subtract(eCPointArray[(-objectArray[i] - true) / 2]);
        }
        wNafPreCompInfo.setPreComp(eCPointArray);
        wNafPreCompInfo.setTwiceP(eCPoint2);
        eCPoint.setPreCompInfo(wNafPreCompInfo);
        return eCPoint3;
    }
}

