/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.Tnaf;

public abstract class ECCurve {
    ECFieldElement a;
    ECFieldElement b;

    public abstract int getFieldSize();

    public abstract ECFieldElement fromBigInteger(BigInteger var1);

    public abstract ECPoint createPoint(BigInteger var1, BigInteger var2, boolean var3);

    public abstract ECPoint decodePoint(byte[] var1);

    public abstract ECPoint getInfinity();

    public ECFieldElement getA() {
        return this.a;
    }

    public ECFieldElement getB() {
        return this.b;
    }

    public static class F2m
    extends ECCurve {
        private int m;
        private int k1;
        private int k2;
        private int k3;
        private BigInteger n;
        private BigInteger h;
        private ECPoint.F2m infinity;
        private byte mu = 0;
        private BigInteger[] si = null;

        public F2m(int n, int n2, BigInteger bigInteger, BigInteger bigInteger2) {
            this(n, n2, 0, 0, bigInteger, bigInteger2, null, null);
        }

        public F2m(int n, int n2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(n, n2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        public F2m(int n, int n2, int n3, int n4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(n, n2, n3, n4, bigInteger, bigInteger2, null, null);
        }

        public F2m(int n, int n2, int n3, int n4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this.m = n;
            this.k1 = n2;
            this.k2 = n3;
            this.k3 = n4;
            this.n = bigInteger3;
            this.h = bigInteger4;
            if (n2 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            }
            if (n3 == 0) {
                if (n4 != 0) {
                    throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                }
            } else {
                if (n3 <= n2) {
                    throw new IllegalArgumentException("k2 must be > k1");
                }
                if (n4 <= n3) {
                    throw new IllegalArgumentException("k3 must be > k2");
                }
            }
            this.a = this.fromBigInteger(bigInteger);
            this.b = this.fromBigInteger(bigInteger2);
            this.infinity = new ECPoint.F2m(this, null, null);
        }

        public int getFieldSize() {
            return this.m;
        }

        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, bigInteger);
        }

        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean bl) {
            return new ECPoint.F2m(this, this.fromBigInteger(bigInteger), this.fromBigInteger(bigInteger2), bl);
        }

        public ECPoint decodePoint(byte[] byArray) {
            ECPoint eCPoint = null;
            switch (byArray[0]) {
                case 0: {
                    if (byArray.length > 1) {
                        throw new RuntimeException("Invalid point encoding");
                    }
                    eCPoint = this.getInfinity();
                    break;
                }
                case 2: 
                case 3: {
                    byte[] byArray2 = new byte[byArray.length - 1];
                    System.arraycopy(byArray, 1, byArray2, 0, byArray2.length);
                    if (byArray[0] == 2) {
                        eCPoint = this.decompressPoint(byArray2, 0);
                        break;
                    }
                    eCPoint = this.decompressPoint(byArray2, 1);
                    break;
                }
                case 4: 
                case 6: 
                case 7: {
                    byte[] byArray3 = new byte[(byArray.length - 1) / 2];
                    byte[] byArray4 = new byte[(byArray.length - 1) / 2];
                    System.arraycopy(byArray, 1, byArray3, 0, byArray3.length);
                    System.arraycopy(byArray, byArray3.length + 1, byArray4, 0, byArray4.length);
                    eCPoint = new ECPoint.F2m(this, new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, new BigInteger(1, byArray3)), new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, new BigInteger(1, byArray4)), false);
                    break;
                }
                default: {
                    throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(byArray[0], 16));
                }
            }
            return eCPoint;
        }

        public ECPoint getInfinity() {
            return this.infinity;
        }

        public boolean isKoblitz() {
            return this.n != null && this.h != null && (this.a.toBigInteger().equals(ECConstants.ZERO) || this.a.toBigInteger().equals(ECConstants.ONE)) && this.b.toBigInteger().equals(ECConstants.ONE);
        }

        synchronized byte getMu() {
            if (this.mu == 0) {
                this.mu = Tnaf.getMu(this);
            }
            return this.mu;
        }

        synchronized BigInteger[] getSi() {
            if (this.si == null) {
                this.si = Tnaf.getSi(this);
            }
            return this.si;
        }

        private ECPoint decompressPoint(byte[] byArray, int n) {
            ECFieldElement.F2m f2m = new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, new BigInteger(1, byArray));
            ECFieldElement eCFieldElement = null;
            if (((ECFieldElement)f2m).toBigInteger().equals(ECConstants.ZERO)) {
                eCFieldElement = (ECFieldElement.F2m)this.b;
                for (int i = 0; i < this.m - 1; ++i) {
                    eCFieldElement = ((ECFieldElement)eCFieldElement).square();
                }
            } else {
                ECFieldElement eCFieldElement2 = ((ECFieldElement)f2m).add(this.a).add(this.b.multiply(((ECFieldElement)f2m).square().invert()));
                ECFieldElement eCFieldElement3 = this.solveQuadradicEquation(eCFieldElement2);
                if (eCFieldElement3 == null) {
                    throw new RuntimeException("Invalid point compression");
                }
                int n2 = 0;
                if (eCFieldElement3.toBigInteger().testBit(0)) {
                    n2 = 1;
                }
                if (n2 != n) {
                    eCFieldElement3 = eCFieldElement3.add(new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, ECConstants.ONE));
                }
                eCFieldElement = ((ECFieldElement)f2m).multiply(eCFieldElement3);
            }
            return new ECPoint.F2m(this, f2m, eCFieldElement);
        }

        private ECFieldElement solveQuadradicEquation(ECFieldElement eCFieldElement) {
            ECFieldElement.F2m f2m = new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, ECConstants.ZERO);
            if (eCFieldElement.toBigInteger().equals(ECConstants.ZERO)) {
                return f2m;
            }
            ECFieldElement eCFieldElement2 = null;
            ECFieldElement eCFieldElement3 = f2m;
            Random random = new Random();
            do {
                ECFieldElement.F2m f2m2 = new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, new BigInteger(this.m, random));
                eCFieldElement2 = f2m;
                ECFieldElement eCFieldElement4 = eCFieldElement;
                for (int i = 1; i <= this.m - 1; ++i) {
                    ECFieldElement eCFieldElement5 = eCFieldElement4.square();
                    eCFieldElement2 = ((ECFieldElement)eCFieldElement2).square().add(eCFieldElement5.multiply(f2m2));
                    eCFieldElement4 = eCFieldElement5.add(eCFieldElement);
                }
                if (eCFieldElement4.toBigInteger().equals(ECConstants.ZERO)) continue;
                return null;
            } while ((eCFieldElement3 = ((ECFieldElement)eCFieldElement2).square().add(eCFieldElement2)).toBigInteger().equals(ECConstants.ZERO));
            return eCFieldElement2;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m)object;
            return this.m == f2m.m && this.k1 == f2m.k1 && this.k2 == f2m.k2 && this.k3 == f2m.k3 && this.a.equals(f2m.a) && this.b.equals(f2m.b);
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode() ^ this.m ^ this.k1 ^ this.k2 ^ this.k3;
        }

        public int getM() {
            return this.m;
        }

        public boolean isTrinomial() {
            return this.k2 == 0 && this.k3 == 0;
        }

        public int getK1() {
            return this.k1;
        }

        public int getK2() {
            return this.k2;
        }

        public int getK3() {
            return this.k3;
        }

        public BigInteger getN() {
            return this.n;
        }

        public BigInteger getH() {
            return this.h;
        }
    }

    public static class Fp
    extends ECCurve {
        BigInteger q;
        ECPoint.Fp infinity;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this.q = bigInteger;
            this.a = this.fromBigInteger(bigInteger2);
            this.b = this.fromBigInteger(bigInteger3);
            this.infinity = new ECPoint.Fp(this, null, null);
        }

        public BigInteger getQ() {
            return this.q;
        }

        public int getFieldSize() {
            return this.q.bitLength();
        }

        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.Fp(this.q, bigInteger);
        }

        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean bl) {
            return new ECPoint.Fp(this, this.fromBigInteger(bigInteger), this.fromBigInteger(bigInteger2), bl);
        }

        public ECPoint decodePoint(byte[] byArray) {
            ECPoint eCPoint = null;
            switch (byArray[0]) {
                case 0: {
                    if (byArray.length > 1) {
                        throw new RuntimeException("Invalid point encoding");
                    }
                    eCPoint = this.getInfinity();
                    break;
                }
                case 2: 
                case 3: {
                    int n;
                    int n2 = byArray[0] & 1;
                    byte[] byArray2 = new byte[byArray.length - 1];
                    System.arraycopy(byArray, 1, byArray2, 0, byArray2.length);
                    ECFieldElement.Fp fp = new ECFieldElement.Fp(this.q, new BigInteger(1, byArray2));
                    ECFieldElement eCFieldElement = ((ECFieldElement)fp).multiply(((ECFieldElement)fp).square().add(this.a)).add(this.b);
                    ECFieldElement eCFieldElement2 = eCFieldElement.sqrt();
                    if (eCFieldElement2 == null) {
                        throw new RuntimeException("Invalid point compression");
                    }
                    int n3 = n = eCFieldElement2.toBigInteger().testBit(0) ? 1 : 0;
                    if (n == n2) {
                        eCPoint = new ECPoint.Fp(this, fp, eCFieldElement2, true);
                        break;
                    }
                    eCPoint = new ECPoint.Fp(this, fp, new ECFieldElement.Fp(this.q, this.q.subtract(eCFieldElement2.toBigInteger())), true);
                    break;
                }
                case 4: 
                case 6: 
                case 7: {
                    byte[] byArray3 = new byte[(byArray.length - 1) / 2];
                    byte[] byArray4 = new byte[(byArray.length - 1) / 2];
                    System.arraycopy(byArray, 1, byArray3, 0, byArray3.length);
                    System.arraycopy(byArray, byArray3.length + 1, byArray4, 0, byArray4.length);
                    eCPoint = new ECPoint.Fp(this, new ECFieldElement.Fp(this.q, new BigInteger(1, byArray3)), new ECFieldElement.Fp(this.q, new BigInteger(1, byArray4)));
                    break;
                }
                default: {
                    throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(byArray[0], 16));
                }
            }
            return eCPoint;
        }

        public ECPoint getInfinity() {
            return this.infinity;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp)object;
            return this.q.equals(fp.q) && this.a.equals(fp.a) && this.b.equals(fp.b);
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode() ^ this.q.hashCode();
        }
    }
}

