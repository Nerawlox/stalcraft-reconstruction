/*
 * Decompiled with CFR 0.152.
 */
package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAValidationParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

public class DSAParametersGenerator {
    private int L;
    private int N;
    private int certainty;
    private SecureRandom random;
    private static final BigInteger ZERO = BigInteger.valueOf(0L);
    private static final BigInteger ONE = BigInteger.valueOf(1L);
    private static final BigInteger TWO = BigInteger.valueOf(2L);

    public void init(int n, int n2, SecureRandom secureRandom) {
        this.init(n, DSAParametersGenerator.getDefaultN(n), n2, secureRandom);
    }

    private void init(int n, int n2, int n3, SecureRandom secureRandom) {
        this.L = n;
        this.N = n2;
        this.certainty = n3;
        this.random = secureRandom;
    }

    public DSAParameters generateParameters() {
        return this.L > 1024 ? this.generateParameters_FIPS186_3() : this.generateParameters_FIPS186_2();
    }

    /*
     * Unable to fully structure code
     */
    private DSAParameters generateParameters_FIPS186_2() {
        var1_1 = new byte[20];
        var2_2 = new byte[20];
        var3_3 = new byte[20];
        var4_4 = new byte[20];
        var5_5 = new SHA1Digest();
        var6_6 = (this.L - 1) / 160;
        var7_7 = new byte[this.L / 8];
        block0: while (true) {
            this.random.nextBytes(var1_1);
            DSAParametersGenerator.hash(var5_5, var1_1, var2_2);
            System.arraycopy(var1_1, 0, var3_3, 0, var1_1.length);
            DSAParametersGenerator.inc(var3_3);
            DSAParametersGenerator.hash(var5_5, var3_3, var3_3);
            for (var8_9 = 0; var8_9 != var4_4.length; ++var8_9) {
                var4_4[var8_9] = (byte)(var2_2[var8_9] ^ var3_3[var8_9]);
            }
            var4_4[0] = (byte)(var4_4[0] | -128);
            var4_4[19] = (byte)(var4_4[19] | 1);
            var8_8 = new BigInteger(1, var4_4);
            if (!var8_8.isProbablePrime(this.certainty)) continue;
            var9_10 = Arrays.clone(var1_1);
            DSAParametersGenerator.inc(var9_10);
            var10_11 = 0;
            while (true) {
                if (var10_11 < 4096) ** break;
                continue block0;
                for (var11_13 = 0; var11_13 < var6_6; ++var11_13) {
                    DSAParametersGenerator.inc(var9_10);
                    DSAParametersGenerator.hash(var5_5, var9_10, var2_2);
                    System.arraycopy(var2_2, 0, var7_7, var7_7.length - (var11_13 + 1) * var2_2.length, var2_2.length);
                }
                DSAParametersGenerator.inc(var9_10);
                DSAParametersGenerator.hash(var5_5, var9_10, var2_2);
                System.arraycopy(var2_2, var2_2.length - (var7_7.length - var6_6 * var2_2.length), var7_7, 0, var7_7.length - var6_6 * var2_2.length);
                var7_7[0] = (byte)(var7_7[0] | -128);
                var11_12 = new BigInteger(1, var7_7);
                var12_14 = var11_12.mod(var8_8.shiftLeft(1));
                var13_15 = var11_12.subtract(var12_14.subtract(DSAParametersGenerator.ONE));
                if (var13_15.bitLength() == this.L && var13_15.isProbablePrime(this.certainty)) {
                    var14_16 = DSAParametersGenerator.calculateGenerator_FIPS186_2(var13_15, var8_8, this.random);
                    return new DSAParameters(var13_15, var8_8, var14_16, new DSAValidationParameters(var1_1, var10_11));
                }
                ++var10_11;
            }
            break;
        }
    }

    private static BigInteger calculateGenerator_FIPS186_2(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        BigInteger bigInteger5 = bigInteger.subtract(ONE).divide(bigInteger2);
        BigInteger bigInteger6 = bigInteger.subtract(TWO);
        while ((bigInteger4 = (bigInteger3 = BigIntegers.createRandomInRange(TWO, bigInteger6, secureRandom)).modPow(bigInteger5, bigInteger)).bitLength() <= 1) {
        }
        return bigInteger4;
    }

    /*
     * Unable to fully structure code
     */
    private DSAParameters generateParameters_FIPS186_3() {
        var1_1 = new SHA256Digest();
        var2_2 = var1_1.getDigestSize() * 8;
        var3_3 = this.N;
        var4_4 = new byte[var3_3 / 8];
        var5_5 = (this.L - 1) / var2_2;
        var6_6 = (this.L - 1) % var2_2;
        var7_7 = new byte[var1_1.getDigestSize()];
        block0: while (true) {
            this.random.nextBytes(var4_4);
            DSAParametersGenerator.hash(var1_1, var4_4, var7_7);
            var8_8 = new BigInteger(1, var7_7).mod(DSAParametersGenerator.ONE.shiftLeft(this.N - 1));
            var9_9 = DSAParametersGenerator.ONE.shiftLeft(this.N - 1).add(var8_8).add(DSAParametersGenerator.ONE).subtract(var8_8.mod(DSAParametersGenerator.TWO));
            if (!var9_9.isProbablePrime(this.certainty)) continue;
            var10_10 = Arrays.clone(var4_4);
            var11_11 = 4 * this.L;
            var12_12 = 0;
            while (true) {
                if (var12_12 < var11_11) ** break;
                continue block0;
                var13_13 = DSAParametersGenerator.ZERO;
                var14_15 = 0;
                var15_17 = 0;
                while (var14_15 <= var5_5) {
                    DSAParametersGenerator.inc(var10_10);
                    DSAParametersGenerator.hash(var1_1, var10_10, var7_7);
                    var16_18 = new BigInteger(1, var7_7);
                    if (var14_15 == var5_5) {
                        var16_18 = var16_18.mod(DSAParametersGenerator.ONE.shiftLeft(var6_6));
                    }
                    var13_13 = var13_13.add(var16_18.shiftLeft(var15_17));
                    ++var14_15;
                    var15_17 += var2_2;
                }
                var14_14 = var13_13.add(DSAParametersGenerator.ONE.shiftLeft(this.L - 1));
                var16_18 = var14_14.subtract((var15_16 = var14_14.mod(var9_9.shiftLeft(1))).subtract(DSAParametersGenerator.ONE));
                if (var16_18.bitLength() == this.L && var16_18.isProbablePrime(this.certainty)) {
                    var17_19 = DSAParametersGenerator.calculateGenerator_FIPS186_3_Unverifiable(var16_18, var9_9, this.random);
                    return new DSAParameters(var16_18, var9_9, var17_19, new DSAValidationParameters(var4_4, var12_12));
                }
                ++var12_12;
            }
            break;
        }
    }

    private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return DSAParametersGenerator.calculateGenerator_FIPS186_2(bigInteger, bigInteger2, secureRandom);
    }

    private static void hash(Digest digest, byte[] byArray, byte[] byArray2) {
        digest.update(byArray, 0, byArray.length);
        digest.doFinal(byArray2, 0);
    }

    private static int getDefaultN(int n) {
        return n > 1024 ? 256 : 160;
    }

    private static void inc(byte[] byArray) {
        for (int i = byArray.length - 1; i >= 0; --i) {
            byte by;
            byArray[i] = by = (byte)(byArray[i] + 1 & 0xFF);
            if (by != 0) break;
        }
    }
}

