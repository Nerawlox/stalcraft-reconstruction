/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.IntArray;

public abstract class ECFieldElement
implements ECConstants {
    public abstract BigInteger toBigInteger();

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement add(ECFieldElement var1);

    public abstract ECFieldElement subtract(ECFieldElement var1);

    public abstract ECFieldElement multiply(ECFieldElement var1);

    public abstract ECFieldElement divide(ECFieldElement var1);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement square();

    public abstract ECFieldElement invert();

    public abstract ECFieldElement sqrt();

    public String toString() {
        return this.toBigInteger().toString(2);
    }

    public static class F2m
    extends ECFieldElement {
        public static final int GNB = 1;
        public static final int TPB = 2;
        public static final int PPB = 3;
        private int representation;
        private int m;
        private int k1;
        private int k2;
        private int k3;
        private IntArray x;
        private int t;

        public F2m(int n, int n2, int n3, int n4, BigInteger bigInteger) {
            this.t = n + 31 >> 5;
            this.x = new IntArray(bigInteger, this.t);
            if (n3 == 0 && n4 == 0) {
                this.representation = 2;
            } else {
                if (n3 >= n4) {
                    throw new IllegalArgumentException("k2 must be smaller than k3");
                }
                if (n3 <= 0) {
                    throw new IllegalArgumentException("k2 must be larger than 0");
                }
                this.representation = 3;
            }
            if (bigInteger.signum() < 0) {
                throw new IllegalArgumentException("x value cannot be negative");
            }
            this.m = n;
            this.k1 = n2;
            this.k2 = n3;
            this.k3 = n4;
        }

        public F2m(int n, int n2, BigInteger bigInteger) {
            this(n, n2, 0, 0, bigInteger);
        }

        private F2m(int n, int n2, int n3, int n4, IntArray intArray) {
            this.t = n + 31 >> 5;
            this.x = intArray;
            this.m = n;
            this.k1 = n2;
            this.k2 = n3;
            this.k3 = n4;
            this.representation = n3 == 0 && n4 == 0 ? 2 : 3;
        }

        public BigInteger toBigInteger() {
            return this.x.toBigInteger();
        }

        public String getFieldName() {
            return "F2m";
        }

        public int getFieldSize() {
            return this.m;
        }

        public static void checkFieldElements(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if (!(eCFieldElement instanceof F2m) || !(eCFieldElement2 instanceof F2m)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            F2m f2m = (F2m)eCFieldElement;
            F2m f2m2 = (F2m)eCFieldElement2;
            if (f2m.m != f2m2.m || f2m.k1 != f2m2.k1 || f2m.k2 != f2m2.k2 || f2m.k3 != f2m2.k3) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            }
            if (f2m.representation != f2m2.representation) {
                throw new IllegalArgumentException("One of the field elements are not elements has incorrect representation");
            }
        }

        public ECFieldElement add(ECFieldElement eCFieldElement) {
            IntArray intArray = (IntArray)this.x.clone();
            F2m f2m = (F2m)eCFieldElement;
            intArray.addShifted(f2m.x, 0);
            return new F2m(this.m, this.k1, this.k2, this.k3, intArray);
        }

        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return this.add(eCFieldElement);
        }

        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            F2m f2m = (F2m)eCFieldElement;
            IntArray intArray = this.x.multiply(f2m.x, this.m);
            intArray.reduce(this.m, new int[]{this.k1, this.k2, this.k3});
            return new F2m(this.m, this.k1, this.k2, this.k3, intArray);
        }

        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            ECFieldElement eCFieldElement2 = eCFieldElement.invert();
            return this.multiply(eCFieldElement2);
        }

        public ECFieldElement negate() {
            return this;
        }

        public ECFieldElement square() {
            IntArray intArray = this.x.square(this.m);
            intArray.reduce(this.m, new int[]{this.k1, this.k2, this.k3});
            return new F2m(this.m, this.k1, this.k2, this.k3, intArray);
        }

        public ECFieldElement invert() {
            IntArray intArray = (IntArray)this.x.clone();
            IntArray intArray2 = new IntArray(this.t);
            intArray2.setBit(this.m);
            intArray2.setBit(0);
            intArray2.setBit(this.k1);
            if (this.representation == 3) {
                intArray2.setBit(this.k2);
                intArray2.setBit(this.k3);
            }
            IntArray intArray3 = new IntArray(this.t);
            intArray3.setBit(0);
            IntArray intArray4 = new IntArray(this.t);
            while (!intArray.isZero()) {
                int n = intArray.bitLength() - intArray2.bitLength();
                if (n < 0) {
                    IntArray intArray5 = intArray;
                    intArray = intArray2;
                    intArray2 = intArray5;
                    IntArray intArray6 = intArray3;
                    intArray3 = intArray4;
                    intArray4 = intArray6;
                    n = -n;
                }
                int n2 = n >> 5;
                int n3 = n & 0x1F;
                IntArray intArray7 = intArray2.shiftLeft(n3);
                intArray.addShifted(intArray7, n2);
                IntArray intArray8 = intArray4.shiftLeft(n3);
                intArray3.addShifted(intArray8, n2);
            }
            return new F2m(this.m, this.k1, this.k2, this.k3, intArray4);
        }

        public ECFieldElement sqrt() {
            throw new RuntimeException("Not implemented");
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int getM() {
            return this.m;
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

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m)object;
            return this.m == f2m.m && this.k1 == f2m.k1 && this.k2 == f2m.k2 && this.k3 == f2m.k3 && this.representation == f2m.representation && this.x.equals(f2m.x);
        }

        public int hashCode() {
            return this.x.hashCode() ^ this.m ^ this.k1 ^ this.k2 ^ this.k3;
        }
    }

    public static class Fp
    extends ECFieldElement {
        BigInteger x;
        BigInteger q;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this.x = bigInteger2;
            if (bigInteger2.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value too large in field element");
            }
            this.q = bigInteger;
        }

        public BigInteger toBigInteger() {
            return this.x;
        }

        public String getFieldName() {
            return "Fp";
        }

        public int getFieldSize() {
            return this.q.bitLength();
        }

        public BigInteger getQ() {
            return this.q;
        }

        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.x.add(eCFieldElement.toBigInteger()).mod(this.q));
        }

        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.x.subtract(eCFieldElement.toBigInteger()).mod(this.q));
        }

        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.x.multiply(eCFieldElement.toBigInteger()).mod(this.q));
        }

        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.x.multiply(eCFieldElement.toBigInteger().modInverse(this.q)).mod(this.q));
        }

        public ECFieldElement negate() {
            return new Fp(this.q, this.x.negate().mod(this.q));
        }

        public ECFieldElement square() {
            return new Fp(this.q, this.x.multiply(this.x).mod(this.q));
        }

        public ECFieldElement invert() {
            return new Fp(this.q, this.x.modInverse(this.q));
        }

        public ECFieldElement sqrt() {
            if (!this.q.testBit(0)) {
                throw new RuntimeException("not done yet");
            }
            if (this.q.testBit(1)) {
                Fp fp = new Fp(this.q, this.x.modPow(this.q.shiftRight(2).add(ECConstants.ONE), this.q));
                return ((ECFieldElement)fp).square().equals(this) ? fp : null;
            }
            BigInteger bigInteger = this.q.subtract(ECConstants.ONE);
            BigInteger bigInteger2 = bigInteger.shiftRight(1);
            if (!this.x.modPow(bigInteger2, this.q).equals(ECConstants.ONE)) {
                return null;
            }
            BigInteger bigInteger3 = bigInteger.shiftRight(2);
            BigInteger bigInteger4 = bigInteger3.shiftLeft(1).add(ECConstants.ONE);
            BigInteger bigInteger5 = this.x;
            BigInteger bigInteger6 = bigInteger5.shiftLeft(2).mod(this.q);
            Random random = new Random();
            while (true) {
                BigInteger bigInteger7;
                if ((bigInteger7 = new BigInteger(this.q.bitLength(), random)).compareTo(this.q) >= 0 || !bigInteger7.multiply(bigInteger7).subtract(bigInteger6).modPow(bigInteger2, this.q).equals(bigInteger)) {
                    continue;
                }
                BigInteger[] bigIntegerArray = Fp.lucasSequence(this.q, bigInteger7, bigInteger5, bigInteger4);
                BigInteger bigInteger8 = bigIntegerArray[0];
                BigInteger bigInteger9 = bigIntegerArray[1];
                if (bigInteger9.multiply(bigInteger9).mod(this.q).equals(bigInteger6)) {
                    if (bigInteger9.testBit(0)) {
                        bigInteger9 = bigInteger9.add(this.q);
                    }
                    bigInteger9 = bigInteger9.shiftRight(1);
                    return new Fp(this.q, bigInteger9);
                }
                if (!bigInteger8.equals(ECConstants.ONE) && !bigInteger8.equals(bigInteger)) break;
            }
            return null;
        }

        private static BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            int n;
            int n2 = bigInteger4.bitLength();
            int n3 = bigInteger4.getLowestSetBit();
            BigInteger bigInteger5 = ECConstants.ONE;
            BigInteger bigInteger6 = ECConstants.TWO;
            BigInteger bigInteger7 = bigInteger2;
            BigInteger bigInteger8 = ECConstants.ONE;
            BigInteger bigInteger9 = ECConstants.ONE;
            for (n = n2 - 1; n >= n3 + 1; --n) {
                bigInteger8 = bigInteger8.multiply(bigInteger9).mod(bigInteger);
                if (bigInteger4.testBit(n)) {
                    bigInteger9 = bigInteger8.multiply(bigInteger3).mod(bigInteger);
                    bigInteger5 = bigInteger5.multiply(bigInteger7).mod(bigInteger);
                    bigInteger6 = bigInteger7.multiply(bigInteger6).subtract(bigInteger2.multiply(bigInteger8)).mod(bigInteger);
                    bigInteger7 = bigInteger7.multiply(bigInteger7).subtract(bigInteger9.shiftLeft(1)).mod(bigInteger);
                    continue;
                }
                bigInteger9 = bigInteger8;
                bigInteger5 = bigInteger5.multiply(bigInteger6).subtract(bigInteger8).mod(bigInteger);
                bigInteger7 = bigInteger7.multiply(bigInteger6).subtract(bigInteger2.multiply(bigInteger8)).mod(bigInteger);
                bigInteger6 = bigInteger6.multiply(bigInteger6).subtract(bigInteger8.shiftLeft(1)).mod(bigInteger);
            }
            bigInteger8 = bigInteger8.multiply(bigInteger9).mod(bigInteger);
            bigInteger9 = bigInteger8.multiply(bigInteger3).mod(bigInteger);
            bigInteger5 = bigInteger5.multiply(bigInteger6).subtract(bigInteger8).mod(bigInteger);
            bigInteger6 = bigInteger7.multiply(bigInteger6).subtract(bigInteger2.multiply(bigInteger8)).mod(bigInteger);
            bigInteger8 = bigInteger8.multiply(bigInteger9).mod(bigInteger);
            for (n = 1; n <= n3; ++n) {
                bigInteger5 = bigInteger5.multiply(bigInteger6).mod(bigInteger);
                bigInteger6 = bigInteger6.multiply(bigInteger6).subtract(bigInteger8.shiftLeft(1)).mod(bigInteger);
                bigInteger8 = bigInteger8.multiply(bigInteger8).mod(bigInteger);
            }
            return new BigInteger[]{bigInteger5, bigInteger6};
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp)object;
            return this.q.equals(fp.q) && this.x.equals(fp.x);
        }

        public int hashCode() {
            return this.q.hashCode() ^ this.x.hashCode();
        }
    }
}

