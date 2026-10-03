/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECPoint;

public class ECDSASigner
implements ECConstants,
DSA {
    ECKeyParameters key;
    SecureRandom random;

    public void init(boolean bl, CipherParameters cipherParameters) {
        if (bl) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom)cipherParameters;
                this.random = parametersWithRandom.getRandom();
                this.key = (ECPrivateKeyParameters)parametersWithRandom.getParameters();
            } else {
                this.random = new SecureRandom();
                this.key = (ECPrivateKeyParameters)cipherParameters;
            }
        } else {
            this.key = (ECPublicKeyParameters)cipherParameters;
        }
    }

    public BigInteger[] generateSignature(byte[] byArray) {
        Object object;
        BigInteger[] bigIntegerArray;
        BigInteger bigInteger = this.key.getParameters().getN();
        BigInteger bigInteger2 = this.calculateE(bigInteger, byArray);
        BigInteger bigInteger3 = null;
        BigInteger bigInteger4 = null;
        do {
            BigInteger bigInteger5;
            bigIntegerArray = null;
            int n = bigInteger.bitLength();
            while ((bigIntegerArray = new BigInteger(n, this.random)).equals(ZERO) || bigIntegerArray.compareTo(bigInteger) >= 0 || (bigInteger3 = (bigInteger5 = ((ECPoint)(object = this.key.getParameters().getG().multiply((BigInteger)bigIntegerArray))).getX().toBigInteger()).mod(bigInteger)).equals(ZERO)) {
            }
            object = ((ECPrivateKeyParameters)this.key).getD();
        } while ((bigInteger4 = bigIntegerArray.modInverse(bigInteger).multiply(bigInteger2.add(((BigInteger)object).multiply(bigInteger3))).mod(bigInteger)).equals(ZERO));
        bigIntegerArray = new BigInteger[]{bigInteger3, bigInteger4};
        return bigIntegerArray;
    }

    public boolean verifySignature(byte[] byArray, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = this.key.getParameters().getN();
        BigInteger bigInteger4 = this.calculateE(bigInteger3, byArray);
        if (bigInteger.compareTo(ONE) < 0 || bigInteger.compareTo(bigInteger3) >= 0) {
            return false;
        }
        if (bigInteger2.compareTo(ONE) < 0 || bigInteger2.compareTo(bigInteger3) >= 0) {
            return false;
        }
        BigInteger bigInteger5 = bigInteger2.modInverse(bigInteger3);
        BigInteger bigInteger6 = bigInteger4.multiply(bigInteger5).mod(bigInteger3);
        BigInteger bigInteger7 = bigInteger.multiply(bigInteger5).mod(bigInteger3);
        ECPoint eCPoint = this.key.getParameters().getG();
        ECPoint eCPoint2 = ((ECPublicKeyParameters)this.key).getQ();
        ECPoint eCPoint3 = ECAlgorithms.sumOfTwoMultiplies(eCPoint, bigInteger6, eCPoint2, bigInteger7);
        BigInteger bigInteger8 = eCPoint3.getX().toBigInteger().mod(bigInteger3);
        return bigInteger8.equals(bigInteger);
    }

    private BigInteger calculateE(BigInteger bigInteger, byte[] byArray) {
        int n;
        int n2 = bigInteger.bitLength();
        if (n2 >= (n = byArray.length * 8)) {
            return new BigInteger(1, byArray);
        }
        BigInteger bigInteger2 = new BigInteger(1, byArray);
        bigInteger2 = bigInteger2.shiftRight(n - n2);
        return bigInteger2;
    }
}

