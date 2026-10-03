/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.bouncycastle.jcajce.provider.asymmetric.ec.ECUtil;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;

public class EC5Util {
    public static EllipticCurve convertCurve(ECCurve eCCurve, byte[] byArray) {
        if (eCCurve instanceof ECCurve.Fp) {
            return new EllipticCurve(new ECFieldFp(((ECCurve.Fp)eCCurve).getQ()), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), null);
        }
        ECCurve.F2m f2m = (ECCurve.F2m)eCCurve;
        if (f2m.isTrinomial()) {
            int[] nArray = new int[]{f2m.getK1()};
            return new EllipticCurve(new ECFieldF2m(f2m.getM(), nArray), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), null);
        }
        int[] nArray = new int[]{f2m.getK3(), f2m.getK2(), f2m.getK1()};
        return new EllipticCurve(new ECFieldF2m(f2m.getM(), nArray), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), null);
    }

    public static ECCurve convertCurve(EllipticCurve ellipticCurve) {
        ECField eCField = ellipticCurve.getField();
        BigInteger bigInteger = ellipticCurve.getA();
        BigInteger bigInteger2 = ellipticCurve.getB();
        if (eCField instanceof ECFieldFp) {
            return new ECCurve.Fp(((ECFieldFp)eCField).getP(), bigInteger, bigInteger2);
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m)eCField;
        int n = eCFieldF2m.getM();
        int[] nArray = ECUtil.convertMidTerms(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new ECCurve.F2m(n, nArray[0], nArray[1], nArray[2], bigInteger, bigInteger2);
    }

    public static ECParameterSpec convertSpec(EllipticCurve ellipticCurve, org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        if (eCParameterSpec instanceof ECNamedCurveParameterSpec) {
            return new ECNamedCurveSpec(((ECNamedCurveParameterSpec)eCParameterSpec).getName(), ellipticCurve, new ECPoint(eCParameterSpec.getG().getX().toBigInteger(), eCParameterSpec.getG().getY().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH());
        }
        return new ECParameterSpec(ellipticCurve, new ECPoint(eCParameterSpec.getG().getX().toBigInteger(), eCParameterSpec.getG().getY().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
    }

    public static org.bouncycastle.jce.spec.ECParameterSpec convertSpec(ECParameterSpec eCParameterSpec, boolean bl) {
        ECCurve eCCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
        return new org.bouncycastle.jce.spec.ECParameterSpec(eCCurve, EC5Util.convertPoint(eCCurve, eCParameterSpec.getGenerator(), bl), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
    }

    public static org.bouncycastle.math.ec.ECPoint convertPoint(ECParameterSpec eCParameterSpec, ECPoint eCPoint, boolean bl) {
        return EC5Util.convertPoint(EC5Util.convertCurve(eCParameterSpec.getCurve()), eCPoint, bl);
    }

    public static org.bouncycastle.math.ec.ECPoint convertPoint(ECCurve eCCurve, ECPoint eCPoint, boolean bl) {
        return eCCurve.createPoint(eCPoint.getAffineX(), eCPoint.getAffineY(), bl);
    }
}

