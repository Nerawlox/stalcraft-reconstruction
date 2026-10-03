/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.FpNafMultiplier;
import org.bouncycastle.math.ec.PreCompInfo;
import org.bouncycastle.math.ec.WNafMultiplier;
import org.bouncycastle.math.ec.WTauNafMultiplier;

public abstract class ECPoint {
    ECCurve curve;
    ECFieldElement x;
    ECFieldElement y;
    protected boolean withCompression;
    protected ECMultiplier multiplier = null;
    protected PreCompInfo preCompInfo = null;
    private static X9IntegerConverter converter = new X9IntegerConverter();

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this.curve = eCCurve;
        this.x = eCFieldElement;
        this.y = eCFieldElement2;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECFieldElement getX() {
        return this.x;
    }

    public ECFieldElement getY() {
        return this.y;
    }

    public boolean isInfinity() {
        return this.x == null && this.y == null;
    }

    public boolean isCompressed() {
        return this.withCompression;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ECPoint)) {
            return false;
        }
        ECPoint eCPoint = (ECPoint)object;
        if (this.isInfinity()) {
            return eCPoint.isInfinity();
        }
        return this.x.equals(eCPoint.x) && this.y.equals(eCPoint.y);
    }

    public int hashCode() {
        if (this.isInfinity()) {
            return 0;
        }
        return this.x.hashCode() ^ this.y.hashCode();
    }

    void setPreCompInfo(PreCompInfo preCompInfo) {
        this.preCompInfo = preCompInfo;
    }

    public abstract byte[] getEncoded();

    public abstract ECPoint add(ECPoint var1);

    public abstract ECPoint subtract(ECPoint var1);

    public abstract ECPoint negate();

    public abstract ECPoint twice();

    synchronized void assertECMultiplier() {
        if (this.multiplier == null) {
            this.multiplier = new FpNafMultiplier();
        }
    }

    public ECPoint multiply(BigInteger bigInteger) {
        if (bigInteger.signum() < 0) {
            throw new IllegalArgumentException("The multiplicator cannot be negative");
        }
        if (this.isInfinity()) {
            return this;
        }
        if (bigInteger.signum() == 0) {
            return this.curve.getInfinity();
        }
        this.assertECMultiplier();
        return this.multiplier.multiply(this, bigInteger, this.preCompInfo);
    }

    public static class F2m
    extends ECPoint {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean bl) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if (eCFieldElement != null && eCFieldElement2 == null || eCFieldElement == null && eCFieldElement2 != null) {
                throw new IllegalArgumentException("Exactly one of the field elements is null");
            }
            if (eCFieldElement != null) {
                ECFieldElement.F2m.checkFieldElements(this.x, this.y);
                if (eCCurve != null) {
                    ECFieldElement.F2m.checkFieldElements(this.x, this.curve.getA());
                }
            }
            this.withCompression = bl;
        }

        public byte[] getEncoded() {
            byte[] byArray;
            if (this.isInfinity()) {
                return new byte[1];
            }
            int n = converter.getByteLength(this.x);
            byte[] byArray2 = converter.integerToBytes(this.getX().toBigInteger(), n);
            if (this.withCompression) {
                byArray = new byte[n + 1];
                byArray[0] = 2;
                if (!this.getX().toBigInteger().equals(ECConstants.ZERO) && this.getY().multiply(this.getX().invert()).toBigInteger().testBit(0)) {
                    byArray[0] = 3;
                }
                System.arraycopy(byArray2, 0, byArray, 1, n);
            } else {
                byte[] byArray3 = converter.integerToBytes(this.getY().toBigInteger(), n);
                byArray = new byte[n + n + 1];
                byArray[0] = 4;
                System.arraycopy(byArray2, 0, byArray, 1, n);
                System.arraycopy(byArray3, 0, byArray, n + 1, n);
            }
            return byArray;
        }

        private static void checkPoints(ECPoint eCPoint, ECPoint eCPoint2) {
            if (!eCPoint.curve.equals(eCPoint2.curve)) {
                throw new IllegalArgumentException("Only points on the same curve can be added or subtracted");
            }
        }

        public ECPoint add(ECPoint eCPoint) {
            F2m.checkPoints(this, eCPoint);
            return this.addSimple((F2m)eCPoint);
        }

        public F2m addSimple(F2m f2m) {
            F2m f2m2 = f2m;
            if (this.isInfinity()) {
                return f2m2;
            }
            if (f2m2.isInfinity()) {
                return this;
            }
            ECFieldElement.F2m f2m3 = (ECFieldElement.F2m)f2m2.getX();
            ECFieldElement.F2m f2m4 = (ECFieldElement.F2m)f2m2.getY();
            if (this.x.equals(f2m3)) {
                if (this.y.equals(f2m4)) {
                    return (F2m)this.twice();
                }
                return (F2m)this.curve.getInfinity();
            }
            ECFieldElement.F2m f2m5 = (ECFieldElement.F2m)this.y.add(f2m4).divide(this.x.add(f2m3));
            ECFieldElement.F2m f2m6 = (ECFieldElement.F2m)f2m5.square().add(f2m5).add(this.x).add(f2m3).add(this.curve.getA());
            ECFieldElement.F2m f2m7 = (ECFieldElement.F2m)f2m5.multiply(this.x.add(f2m6)).add(f2m6).add(this.y);
            return new F2m(this.curve, f2m6, f2m7, this.withCompression);
        }

        public ECPoint subtract(ECPoint eCPoint) {
            F2m.checkPoints(this, eCPoint);
            return this.subtractSimple((F2m)eCPoint);
        }

        public F2m subtractSimple(F2m f2m) {
            if (f2m.isInfinity()) {
                return this;
            }
            return this.addSimple((F2m)f2m.negate());
        }

        public ECPoint twice() {
            if (this.isInfinity()) {
                return this;
            }
            if (this.x.toBigInteger().signum() == 0) {
                return this.curve.getInfinity();
            }
            ECFieldElement.F2m f2m = (ECFieldElement.F2m)this.x.add(this.y.divide(this.x));
            ECFieldElement.F2m f2m2 = (ECFieldElement.F2m)f2m.square().add(f2m).add(this.curve.getA());
            ECFieldElement eCFieldElement = this.curve.fromBigInteger(ECConstants.ONE);
            ECFieldElement.F2m f2m3 = (ECFieldElement.F2m)this.x.square().add(f2m2.multiply(f2m.add(eCFieldElement)));
            return new F2m(this.curve, f2m2, f2m3, this.withCompression);
        }

        public ECPoint negate() {
            return new F2m(this.curve, this.getX(), this.getY().add(this.getX()), this.withCompression);
        }

        synchronized void assertECMultiplier() {
            if (this.multiplier == null) {
                this.multiplier = ((ECCurve.F2m)this.curve).isKoblitz() ? new WTauNafMultiplier() : new WNafMultiplier();
            }
        }
    }

    public static class Fp
    extends ECPoint {
        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean bl) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if (eCFieldElement != null && eCFieldElement2 == null || eCFieldElement == null && eCFieldElement2 != null) {
                throw new IllegalArgumentException("Exactly one of the field elements is null");
            }
            this.withCompression = bl;
        }

        public byte[] getEncoded() {
            if (this.isInfinity()) {
                return new byte[1];
            }
            int n = converter.getByteLength(this.x);
            if (this.withCompression) {
                int n2 = this.getY().toBigInteger().testBit(0) ? 3 : 2;
                byte[] byArray = converter.integerToBytes(this.getX().toBigInteger(), n);
                byte[] byArray2 = new byte[byArray.length + 1];
                byArray2[0] = n2;
                System.arraycopy(byArray, 0, byArray2, 1, byArray.length);
                return byArray2;
            }
            byte[] byArray = converter.integerToBytes(this.getX().toBigInteger(), n);
            byte[] byArray3 = converter.integerToBytes(this.getY().toBigInteger(), n);
            byte[] byArray4 = new byte[byArray.length + byArray3.length + 1];
            byArray4[0] = 4;
            System.arraycopy(byArray, 0, byArray4, 1, byArray.length);
            System.arraycopy(byArray3, 0, byArray4, byArray.length + 1, byArray3.length);
            return byArray4;
        }

        public ECPoint add(ECPoint eCPoint) {
            if (this.isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return this;
            }
            if (this.x.equals(eCPoint.x)) {
                if (this.y.equals(eCPoint.y)) {
                    return this.twice();
                }
                return this.curve.getInfinity();
            }
            ECFieldElement eCFieldElement = eCPoint.y.subtract(this.y).divide(eCPoint.x.subtract(this.x));
            ECFieldElement eCFieldElement2 = eCFieldElement.square().subtract(this.x).subtract(eCPoint.x);
            ECFieldElement eCFieldElement3 = eCFieldElement.multiply(this.x.subtract(eCFieldElement2)).subtract(this.y);
            return new Fp(this.curve, eCFieldElement2, eCFieldElement3);
        }

        public ECPoint twice() {
            if (this.isInfinity()) {
                return this;
            }
            if (this.y.toBigInteger().signum() == 0) {
                return this.curve.getInfinity();
            }
            ECFieldElement eCFieldElement = this.curve.fromBigInteger(BigInteger.valueOf(2L));
            ECFieldElement eCFieldElement2 = this.curve.fromBigInteger(BigInteger.valueOf(3L));
            ECFieldElement eCFieldElement3 = this.x.square().multiply(eCFieldElement2).add(this.curve.a).divide(this.y.multiply(eCFieldElement));
            ECFieldElement eCFieldElement4 = eCFieldElement3.square().subtract(this.x.multiply(eCFieldElement));
            ECFieldElement eCFieldElement5 = eCFieldElement3.multiply(this.x.subtract(eCFieldElement4)).subtract(this.y);
            return new Fp(this.curve, eCFieldElement4, eCFieldElement5, this.withCompression);
        }

        public ECPoint subtract(ECPoint eCPoint) {
            if (eCPoint.isInfinity()) {
                return this;
            }
            return this.add(eCPoint.negate());
        }

        public ECPoint negate() {
            return new Fp(this.curve, this.x, this.y.negate(), this.withCompression);
        }

        synchronized void assertECMultiplier() {
            if (this.multiplier == null) {
                this.multiplier = new WNafMultiplier();
            }
        }
    }
}

