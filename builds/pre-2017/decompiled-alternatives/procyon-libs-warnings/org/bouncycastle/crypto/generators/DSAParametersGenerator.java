// 
// Decompiled by Procyon v0.6.0
// 

package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.crypto.params.DSAValidationParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.DSAParameters;
import java.math.BigInteger;
import java.security.SecureRandom;

public class DSAParametersGenerator
{
    private int L;
    private int N;
    private int certainty;
    private SecureRandom random;
    private static final BigInteger ZERO;
    private static final BigInteger ONE;
    private static final BigInteger TWO;
    
    public void init(final int n, final int n2, final SecureRandom secureRandom) {
        this.init(n, getDefaultN(n), n2, secureRandom);
    }
    
    private void init(final int l, final int n, final int certainty, final SecureRandom random) {
        this.L = l;
        this.N = n;
        this.certainty = certainty;
        this.random = random;
    }
    
    public DSAParameters generateParameters() {
        return (this.L > 1024) ? this.generateParameters_FIPS186_3() : this.generateParameters_FIPS186_2();
    }
    
    private DSAParameters generateParameters_FIPS186_2() {
        final byte[] array = new byte[20];
        final byte[] array2 = new byte[20];
        final byte[] array3 = new byte[20];
        final byte[] array4 = new byte[20];
        final SHA1Digest sha1Digest = new SHA1Digest();
        final int n = (this.L - 1) / 160;
        final byte[] array5 = new byte[this.L / 8];
        BigInteger bigInteger = null;
        int j = 0;
        BigInteger subtract = null;
    Block_6:
        while (true) {
            this.random.nextBytes(array);
            hash((Digest)sha1Digest, array, array2);
            System.arraycopy(array, 0, array3, 0, array.length);
            inc(array3);
            hash((Digest)sha1Digest, array3, array3);
            for (int i = 0; i != array4.length; ++i) {
                array4[i] = (byte)(array2[i] ^ array3[i]);
            }
            final byte[] array6 = array4;
            final int n2 = 0;
            array6[n2] |= 0xFFFFFF80;
            final byte[] array7 = array4;
            final int n3 = 19;
            array7[n3] |= 0x1;
            bigInteger = new BigInteger(1, array4);
            if (!bigInteger.isProbablePrime(this.certainty)) {
                continue;
            }
            final byte[] clone = Arrays.clone(array);
            inc(clone);
            for (j = 0; j < 4096; ++j) {
                for (int k = 0; k < n; ++k) {
                    inc(clone);
                    hash((Digest)sha1Digest, clone, array2);
                    System.arraycopy(array2, 0, array5, array5.length - (k + 1) * array2.length, array2.length);
                }
                inc(clone);
                hash((Digest)sha1Digest, clone, array2);
                System.arraycopy(array2, array2.length - (array5.length - n * array2.length), array5, 0, array5.length - n * array2.length);
                final byte[] array8 = array5;
                final int n4 = 0;
                array8[n4] |= 0xFFFFFF80;
                final BigInteger bigInteger2 = new BigInteger(1, array5);
                subtract = bigInteger2.subtract(bigInteger2.mod(bigInteger.shiftLeft(1)).subtract(DSAParametersGenerator.ONE));
                if (subtract.bitLength() == this.L) {
                    if (subtract.isProbablePrime(this.certainty)) {
                        break Block_6;
                    }
                }
            }
        }
        return new DSAParameters(subtract, bigInteger, calculateGenerator_FIPS186_2(subtract, bigInteger, this.random), new DSAValidationParameters(array, j));
    }
    
    private static BigInteger calculateGenerator_FIPS186_2(final BigInteger bigInteger, final BigInteger bigInteger2, final SecureRandom secureRandom) {
        final BigInteger divide = bigInteger.subtract(DSAParametersGenerator.ONE).divide(bigInteger2);
        final BigInteger subtract = bigInteger.subtract(DSAParametersGenerator.TWO);
        BigInteger modPow;
        do {
            modPow = BigIntegers.createRandomInRange(DSAParametersGenerator.TWO, subtract, secureRandom).modPow(divide, bigInteger);
        } while (modPow.bitLength() <= 1);
        return modPow;
    }
    
    private DSAParameters generateParameters_FIPS186_3() {
        final SHA256Digest sha256Digest = new SHA256Digest();
        final int n = ((Digest)sha256Digest).getDigestSize() * 8;
        final byte[] array = new byte[this.N / 8];
        final int n2 = (this.L - 1) / n;
        final int n3 = (this.L - 1) % n;
        final byte[] array2 = new byte[((Digest)sha256Digest).getDigestSize()];
        BigInteger subtract = null;
        int i = 0;
        BigInteger subtract2 = null;
    Block_6:
        while (true) {
            this.random.nextBytes(array);
            hash((Digest)sha256Digest, array, array2);
            final BigInteger mod = new BigInteger(1, array2).mod(DSAParametersGenerator.ONE.shiftLeft(this.N - 1));
            subtract = DSAParametersGenerator.ONE.shiftLeft(this.N - 1).add(mod).add(DSAParametersGenerator.ONE).subtract(mod.mod(DSAParametersGenerator.TWO));
            if (!subtract.isProbablePrime(this.certainty)) {
                continue;
            }
            final byte[] clone = Arrays.clone(array);
            for (final int n4 = 4 * this.L, i = 0; i < n4; ++i) {
                BigInteger bigInteger = DSAParametersGenerator.ZERO;
                for (int j = 0, n5 = 0; j <= n2; ++j, n5 += n) {
                    inc(clone);
                    hash((Digest)sha256Digest, clone, array2);
                    BigInteger mod2 = new BigInteger(1, array2);
                    if (j == n2) {
                        mod2 = mod2.mod(DSAParametersGenerator.ONE.shiftLeft(n3));
                    }
                    bigInteger = bigInteger.add(mod2.shiftLeft(n5));
                }
                final BigInteger add = bigInteger.add(DSAParametersGenerator.ONE.shiftLeft(this.L - 1));
                subtract2 = add.subtract(add.mod(subtract.shiftLeft(1)).subtract(DSAParametersGenerator.ONE));
                if (subtract2.bitLength() == this.L) {
                    if (subtract2.isProbablePrime(this.certainty)) {
                        break Block_6;
                    }
                }
            }
        }
        return new DSAParameters(subtract2, subtract, calculateGenerator_FIPS186_3_Unverifiable(subtract2, subtract, this.random), new DSAValidationParameters(array, i));
    }
    
    private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(final BigInteger bigInteger, final BigInteger bigInteger2, final SecureRandom secureRandom) {
        return calculateGenerator_FIPS186_2(bigInteger, bigInteger2, secureRandom);
    }
    
    private static void hash(final Digest digest, final byte[] array, final byte[] array2) {
        digest.update(array, 0, array.length);
        digest.doFinal(array2, 0);
    }
    
    private static int getDefaultN(final int n) {
        return (n > 1024) ? 256 : 160;
    }
    
    private static void inc(final byte[] array) {
        for (int n = array.length - 1; n >= 0 && (array[n] = (byte)(array[n] + 1 & 0xFF)) == 0; --n) {}
    }
    
    static {
        ZERO = BigInteger.valueOf(0L);
        ONE = BigInteger.valueOf(1L);
        TWO = BigInteger.valueOf(2L);
    }
}
