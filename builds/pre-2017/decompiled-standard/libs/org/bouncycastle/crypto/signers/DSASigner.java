/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.DSAKeyParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class DSASigner
implements DSA {
    DSAKeyParameters key;
    SecureRandom random;

    public void init(boolean bl, CipherParameters cipherParameters) {
        if (bl) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom)cipherParameters;
                this.random = parametersWithRandom.getRandom();
                this.key = (DSAPrivateKeyParameters)parametersWithRandom.getParameters();
            } else {
                this.random = new SecureRandom();
                this.key = (DSAPrivateKeyParameters)cipherParameters;
            }
        } else {
            this.key = (DSAPublicKeyParameters)cipherParameters;
        }
    }

    public BigInteger[] generateSignature(byte[] byArray) {
        BigInteger bigInteger;
        DSAParameters dSAParameters = this.key.getParameters();
        BigInteger bigInteger2 = this.calculateE(dSAParameters.getQ(), byArray);
        int n = dSAParameters.getQ().bitLength();
        while ((bigInteger = new BigInteger(n, this.random)).compareTo(dSAParameters.getQ()) >= 0) {
        }
        BigInteger bigInteger3 = dSAParameters.getG().modPow(bigInteger, dSAParameters.getP()).mod(dSAParameters.getQ());
        bigInteger = bigInteger.modInverse(dSAParameters.getQ()).multiply(bigInteger2.add(((DSAPrivateKeyParameters)this.key).getX().multiply(bigInteger3)));
        BigInteger bigInteger4 = bigInteger.mod(dSAParameters.getQ());
        BigInteger[] bigIntegerArray = new BigInteger[]{bigInteger3, bigInteger4};
        return bigIntegerArray;
    }

    public boolean verifySignature(byte[] byArray, BigInteger bigInteger, BigInteger bigInteger2) {
        DSAParameters dSAParameters = this.key.getParameters();
        BigInteger bigInteger3 = this.calculateE(dSAParameters.getQ(), byArray);
        BigInteger bigInteger4 = BigInteger.valueOf(0L);
        if (bigInteger4.compareTo(bigInteger) >= 0 || dSAParameters.getQ().compareTo(bigInteger) <= 0) {
            return false;
        }
        if (bigInteger4.compareTo(bigInteger2) >= 0 || dSAParameters.getQ().compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger bigInteger5 = bigInteger2.modInverse(dSAParameters.getQ());
        BigInteger bigInteger6 = bigInteger3.multiply(bigInteger5).mod(dSAParameters.getQ());
        BigInteger bigInteger7 = bigInteger.multiply(bigInteger5).mod(dSAParameters.getQ());
        bigInteger6 = dSAParameters.getG().modPow(bigInteger6, dSAParameters.getP());
        bigInteger7 = ((DSAPublicKeyParameters)this.key).getY().modPow(bigInteger7, dSAParameters.getP());
        BigInteger bigInteger8 = bigInteger6.multiply(bigInteger7).mod(dSAParameters.getP()).mod(dSAParameters.getQ());
        return bigInteger8.equals(bigInteger);
    }

    private BigInteger calculateE(BigInteger bigInteger, byte[] byArray) {
        if (bigInteger.bitLength() >= byArray.length * 8) {
            return new BigInteger(1, byArray);
        }
        byte[] byArray2 = new byte[bigInteger.bitLength() / 8];
        System.arraycopy(byArray, 0, byArray2, 0, byArray2.length);
        return new BigInteger(1, byArray2);
    }
}

