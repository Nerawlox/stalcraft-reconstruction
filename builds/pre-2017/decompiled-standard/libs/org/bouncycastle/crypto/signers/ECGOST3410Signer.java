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

public class ECGOST3410Signer
implements DSA {
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
        byte[] byArray2 = new byte[byArray.length];
        for (int i = 0; i != byArray2.length; ++i) {
            byArray2[i] = byArray[byArray2.length - 1 - i];
        }
        BigInteger bigInteger = new BigInteger(1, byArray2);
        BigInteger bigInteger2 = this.key.getParameters().getN();
        BigInteger bigInteger3 = null;
        BigInteger bigInteger4 = null;
        do {
            BigInteger bigInteger5;
            bigIntegerArray = null;
            while ((bigIntegerArray = new BigInteger(bigInteger2.bitLength(), this.random)).equals(ECConstants.ZERO) || (bigInteger3 = (bigInteger5 = ((ECPoint)(object = this.key.getParameters().getG().multiply((BigInteger)bigIntegerArray))).getX().toBigInteger()).mod(bigInteger2)).equals(ECConstants.ZERO)) {
            }
            object = ((ECPrivateKeyParameters)this.key).getD();
        } while ((bigInteger4 = bigIntegerArray.multiply(bigInteger).add(((BigInteger)object).multiply(bigInteger3)).mod(bigInteger2)).equals(ECConstants.ZERO));
        bigIntegerArray = new BigInteger[]{bigInteger3, bigInteger4};
        return bigIntegerArray;
    }

    public boolean verifySignature(byte[] byArray, BigInteger bigInteger, BigInteger bigInteger2) {
        byte[] byArray2 = new byte[byArray.length];
        for (int i = 0; i != byArray2.length; ++i) {
            byArray2[i] = byArray[byArray2.length - 1 - i];
        }
        BigInteger bigInteger3 = new BigInteger(1, byArray2);
        BigInteger bigInteger4 = this.key.getParameters().getN();
        if (bigInteger.compareTo(ECConstants.ONE) < 0 || bigInteger.compareTo(bigInteger4) >= 0) {
            return false;
        }
        if (bigInteger2.compareTo(ECConstants.ONE) < 0 || bigInteger2.compareTo(bigInteger4) >= 0) {
            return false;
        }
        BigInteger bigInteger5 = bigInteger3.modInverse(bigInteger4);
        BigInteger bigInteger6 = bigInteger2.multiply(bigInteger5).mod(bigInteger4);
        BigInteger bigInteger7 = bigInteger4.subtract(bigInteger).multiply(bigInteger5).mod(bigInteger4);
        ECPoint eCPoint = this.key.getParameters().getG();
        ECPoint eCPoint2 = ((ECPublicKeyParameters)this.key).getQ();
        ECPoint eCPoint3 = ECAlgorithms.sumOfTwoMultiplies(eCPoint, bigInteger6, eCPoint2, bigInteger7);
        BigInteger bigInteger8 = eCPoint3.getX().toBigInteger().mod(bigInteger4);
        return bigInteger8.equals(bigInteger);
    }
}

