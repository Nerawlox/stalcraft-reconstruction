/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.util.BigIntegers;

class DHKeyGeneratorHelper {
    static final DHKeyGeneratorHelper INSTANCE = new DHKeyGeneratorHelper();
    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private static final BigInteger TWO = BigInteger.valueOf(2L);

    private DHKeyGeneratorHelper() {
    }

    BigInteger calculatePrivate(DHParameters dHParameters, SecureRandom secureRandom) {
        BigInteger bigInteger = dHParameters.getP();
        int n = dHParameters.getL();
        if (n != 0) {
            return new BigInteger(n, secureRandom).setBit(n - 1);
        }
        BigInteger bigInteger2 = TWO;
        int n2 = dHParameters.getM();
        if (n2 != 0) {
            bigInteger2 = ONE.shiftLeft(n2 - 1);
        }
        BigInteger bigInteger3 = bigInteger.subtract(TWO);
        BigInteger bigInteger4 = dHParameters.getQ();
        if (bigInteger4 != null) {
            bigInteger3 = bigInteger4.subtract(TWO);
        }
        return BigIntegers.createRandomInRange(bigInteger2, bigInteger3, secureRandom);
    }

    BigInteger calculatePublic(DHParameters dHParameters, BigInteger bigInteger) {
        return dHParameters.getG().modPow(bigInteger, dHParameters.getP());
    }
}

