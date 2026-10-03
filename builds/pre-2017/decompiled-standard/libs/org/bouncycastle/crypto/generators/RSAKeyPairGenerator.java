/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class RSAKeyPairGenerator
implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private RSAKeyGenerationParameters param;

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (RSAKeyGenerationParameters)keyGenerationParameters;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        int n = this.param.getStrength();
        int n2 = (n + 1) / 2;
        int n3 = n - n2;
        int n4 = n / 3;
        BigInteger bigInteger5 = this.param.getPublicExponent();
        while ((bigInteger4 = new BigInteger(n2, 1, this.param.getRandom())).mod(bigInteger5).equals(ONE) || !bigInteger4.isProbablePrime(this.param.getCertainty()) || !bigInteger5.gcd(bigInteger4.subtract(ONE)).equals(ONE)) {
        }
        while (true) {
            if ((bigInteger3 = new BigInteger(n3, 1, this.param.getRandom())).subtract(bigInteger4).abs().bitLength() < n4 || bigInteger3.mod(bigInteger5).equals(ONE) || !bigInteger3.isProbablePrime(this.param.getCertainty()) || !bigInteger5.gcd(bigInteger3.subtract(ONE)).equals(ONE)) {
                continue;
            }
            bigInteger2 = bigInteger4.multiply(bigInteger3);
            if (bigInteger2.bitLength() == this.param.getStrength()) break;
            bigInteger4 = bigInteger4.max(bigInteger3);
        }
        if (bigInteger4.compareTo(bigInteger3) < 0) {
            bigInteger = bigInteger4;
            bigInteger4 = bigInteger3;
            bigInteger3 = bigInteger;
        }
        BigInteger bigInteger6 = bigInteger4.subtract(ONE);
        BigInteger bigInteger7 = bigInteger3.subtract(ONE);
        bigInteger = bigInteger6.multiply(bigInteger7);
        BigInteger bigInteger8 = bigInteger5.modInverse(bigInteger);
        BigInteger bigInteger9 = bigInteger8.remainder(bigInteger6);
        BigInteger bigInteger10 = bigInteger8.remainder(bigInteger7);
        BigInteger bigInteger11 = bigInteger3.modInverse(bigInteger4);
        return new AsymmetricCipherKeyPair(new RSAKeyParameters(false, bigInteger2, bigInteger5), new RSAPrivateCrtKeyParameters(bigInteger2, bigInteger5, bigInteger8, bigInteger4, bigInteger3, bigInteger9, bigInteger10, bigInteger11));
    }
}

