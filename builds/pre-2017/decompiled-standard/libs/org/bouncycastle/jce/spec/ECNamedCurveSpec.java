/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.bouncycastle.math.ec.ECCurve;

public class ECNamedCurveSpec
extends ECParameterSpec {
    private String name;

    private static EllipticCurve convertCurve(ECCurve eCCurve, byte[] byArray) {
        if (eCCurve instanceof ECCurve.Fp) {
            return new EllipticCurve(new ECFieldFp(((ECCurve.Fp)eCCurve).getQ()), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), byArray);
        }
        ECCurve.F2m f2m = (ECCurve.F2m)eCCurve;
        if (f2m.isTrinomial()) {
            int[] nArray = new int[]{f2m.getK1()};
            return new EllipticCurve(new ECFieldF2m(f2m.getM(), nArray), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), byArray);
        }
        int[] nArray = new int[]{f2m.getK3(), f2m.getK2(), f2m.getK1()};
        return new EllipticCurve(new ECFieldF2m(f2m.getM(), nArray), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), byArray);
    }

    private static ECPoint convertPoint(org.bouncycastle.math.ec.ECPoint eCPoint) {
        return new ECPoint(eCPoint.getX().toBigInteger(), eCPoint.getY().toBigInteger());
    }

    public ECNamedCurveSpec(String string, ECCurve eCCurve, org.bouncycastle.math.ec.ECPoint eCPoint, BigInteger bigInteger) {
        super(ECNamedCurveSpec.convertCurve(eCCurve, null), ECNamedCurveSpec.convertPoint(eCPoint), bigInteger, 1);
        this.name = string;
    }

    public ECNamedCurveSpec(String string, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger) {
        super(ellipticCurve, eCPoint, bigInteger, 1);
        this.name = string;
    }

    public ECNamedCurveSpec(String string, ECCurve eCCurve, org.bouncycastle.math.ec.ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ECNamedCurveSpec.convertCurve(eCCurve, null), ECNamedCurveSpec.convertPoint(eCPoint), bigInteger, bigInteger2.intValue());
        this.name = string;
    }

    public ECNamedCurveSpec(String string, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ellipticCurve, eCPoint, bigInteger, bigInteger2.intValue());
        this.name = string;
    }

    public ECNamedCurveSpec(String string, ECCurve eCCurve, org.bouncycastle.math.ec.ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] byArray) {
        super(ECNamedCurveSpec.convertCurve(eCCurve, byArray), ECNamedCurveSpec.convertPoint(eCPoint), bigInteger, bigInteger2.intValue());
        this.name = string;
    }

    public String getName() {
        return this.name;
    }
}

