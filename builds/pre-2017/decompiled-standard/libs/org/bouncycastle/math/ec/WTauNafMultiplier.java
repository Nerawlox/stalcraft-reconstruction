/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.PreCompInfo;
import org.bouncycastle.math.ec.Tnaf;
import org.bouncycastle.math.ec.WTauNafPreCompInfo;
import org.bouncycastle.math.ec.ZTauElement;

class WTauNafMultiplier
implements ECMultiplier {
    WTauNafMultiplier() {
    }

    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        if (!(eCPoint instanceof ECPoint.F2m)) {
            throw new IllegalArgumentException("Only ECPoint.F2m can be used in WTauNafMultiplier");
        }
        ECPoint.F2m f2m = (ECPoint.F2m)eCPoint;
        ECCurve.F2m f2m2 = (ECCurve.F2m)f2m.getCurve();
        int n = f2m2.getM();
        byte by = f2m2.getA().toBigInteger().byteValue();
        byte by2 = f2m2.getMu();
        BigInteger[] bigIntegerArray = f2m2.getSi();
        ZTauElement zTauElement = Tnaf.partModReduction(bigInteger, n, by, bigIntegerArray, by2, (byte)10);
        return this.multiplyWTnaf(f2m, zTauElement, preCompInfo, by, by2);
    }

    private ECPoint.F2m multiplyWTnaf(ECPoint.F2m f2m, ZTauElement zTauElement, PreCompInfo preCompInfo, byte by, byte by2) {
        ZTauElement[] zTauElementArray = by == 0 ? Tnaf.alpha0 : Tnaf.alpha1;
        BigInteger bigInteger = Tnaf.getTw(by2, 4);
        byte[] byArray = Tnaf.tauAdicWNaf(by2, zTauElement, (byte)4, BigInteger.valueOf(16L), bigInteger, zTauElementArray);
        return WTauNafMultiplier.multiplyFromWTnaf(f2m, byArray, preCompInfo);
    }

    private static ECPoint.F2m multiplyFromWTnaf(ECPoint.F2m f2m, byte[] byArray, PreCompInfo preCompInfo) {
        ECPoint.F2m[] f2mArray;
        ECCurve.F2m f2m2 = (ECCurve.F2m)f2m.getCurve();
        byte by = f2m2.getA().toBigInteger().byteValue();
        if (preCompInfo == null || !(preCompInfo instanceof WTauNafPreCompInfo)) {
            f2mArray = Tnaf.getPreComp(f2m, by);
            f2m.setPreCompInfo(new WTauNafPreCompInfo(f2mArray));
        } else {
            f2mArray = ((WTauNafPreCompInfo)preCompInfo).getPreComp();
        }
        ECPoint.F2m f2m3 = (ECPoint.F2m)f2m.getCurve().getInfinity();
        for (int i = byArray.length - 1; i >= 0; --i) {
            f2m3 = Tnaf.tau(f2m3);
            if (byArray[i] == 0) continue;
            f2m3 = byArray[i] > 0 ? f2m3.addSimple(f2mArray[byArray[i]]) : f2m3.subtractSimple(f2mArray[-byArray[i]]);
        }
        return f2m3;
    }
}

