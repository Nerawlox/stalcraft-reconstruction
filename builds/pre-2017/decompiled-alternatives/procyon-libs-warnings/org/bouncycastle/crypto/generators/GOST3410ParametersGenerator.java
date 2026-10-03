// 
// Decompiled by Procyon v0.6.0
// 

package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.params.GOST3410ValidationParameters;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import java.util.Random;
import java.math.BigInteger;
import java.security.SecureRandom;

public class GOST3410ParametersGenerator
{
    private int size;
    private int typeproc;
    private SecureRandom init_random;
    private static final BigInteger ONE;
    private static final BigInteger TWO;
    
    public void init(final int size, final int typeproc, final SecureRandom init_random) {
        this.size = size;
        this.typeproc = typeproc;
        this.init_random = init_random;
    }
    
    private int procedure_A(int n, int n2, final BigInteger[] array, final int n3) {
        while (n < 0 || n > 65536) {
            n = this.init_random.nextInt() / 32768;
        }
        while (n2 < 0 || n2 > 65536 || n2 / 2 == 0) {
            n2 = this.init_random.nextInt() / 32768 + 1;
        }
        final BigInteger bigInteger = new BigInteger(Integer.toString(n2));
        final BigInteger bigInteger2 = new BigInteger("19381");
        BigInteger[] array2 = { new BigInteger(Integer.toString(n)) };
        int[] array3 = { n3 };
        int n4 = 0;
        for (int n5 = 0; array3[n5] >= 17; ++n5) {
            final int[] array4 = new int[array3.length + 1];
            System.arraycopy(array3, 0, array4, 0, array3.length);
            array3 = new int[array4.length];
            System.arraycopy(array4, 0, array3, 0, array4.length);
            array3[n5 + 1] = array3[n5] / 2;
            n4 = n5 + 1;
        }
        final BigInteger[] array5 = new BigInteger[n4 + 1];
        array5[n4] = new BigInteger("8003", 16);
        int n6 = n4 - 1;
        for (int i = 0; i < n4; ++i) {
            final int n7 = array3[n6] / 16;
        Block_10:
            while (true) {
                final BigInteger[] array6 = new BigInteger[array2.length];
                System.arraycopy(array2, 0, array6, 0, array2.length);
                array2 = new BigInteger[n7 + 1];
                System.arraycopy(array6, 0, array2, 0, array6.length);
                for (int j = 0; j < n7; ++j) {
                    array2[j + 1] = array2[j].multiply(bigInteger2).add(bigInteger).mod(GOST3410ParametersGenerator.TWO.pow(16));
                }
                BigInteger add = new BigInteger("0");
                for (int k = 0; k < n7; ++k) {
                    add = add.add(array2[k].multiply(GOST3410ParametersGenerator.TWO.pow(16 * k)));
                }
                array2[0] = array2[n7];
                BigInteger bigInteger3 = GOST3410ParametersGenerator.TWO.pow(array3[n6] - 1).divide(array5[n6 + 1]).add(GOST3410ParametersGenerator.TWO.pow(array3[n6] - 1).multiply(add).divide(array5[n6 + 1].multiply(GOST3410ParametersGenerator.TWO.pow(16 * n7))));
                if (bigInteger3.mod(GOST3410ParametersGenerator.TWO).compareTo(GOST3410ParametersGenerator.ONE) == 0) {
                    bigInteger3 = bigInteger3.add(GOST3410ParametersGenerator.ONE);
                }
                int n8 = 0;
                while (true) {
                    array5[n6] = array5[n6 + 1].multiply(bigInteger3.add(BigInteger.valueOf(n8))).add(GOST3410ParametersGenerator.ONE);
                    if (array5[n6].compareTo(GOST3410ParametersGenerator.TWO.pow(array3[n6])) == 1) {
                        break;
                    }
                    if (GOST3410ParametersGenerator.TWO.modPow(array5[n6 + 1].multiply(bigInteger3.add(BigInteger.valueOf(n8))), array5[n6]).compareTo(GOST3410ParametersGenerator.ONE) == 0 && GOST3410ParametersGenerator.TWO.modPow(bigInteger3.add(BigInteger.valueOf(n8)), array5[n6]).compareTo(GOST3410ParametersGenerator.ONE) != 0) {
                        break Block_10;
                    }
                    n8 += 2;
                }
            }
            --n6;
            if (n6 < 0) {
                array[0] = array5[0];
                array[1] = array5[1];
                return array2[0].intValue();
            }
        }
        return array2[0].intValue();
    }
    
    private long procedure_Aa(long n, long n2, final BigInteger[] array, final int n3) {
        while (n < 0L || n > 4294967296L) {
            n = this.init_random.nextInt() * 2;
        }
        while (n2 < 0L || n2 > 4294967296L || n2 / 2L == 0L) {
            n2 = this.init_random.nextInt() * 2 + 1;
        }
        final BigInteger bigInteger = new BigInteger(Long.toString(n2));
        final BigInteger bigInteger2 = new BigInteger("97781173");
        BigInteger[] array2 = { new BigInteger(Long.toString(n)) };
        int[] array3 = { n3 };
        int n4 = 0;
        for (int n5 = 0; array3[n5] >= 33; ++n5) {
            final int[] array4 = new int[array3.length + 1];
            System.arraycopy(array3, 0, array4, 0, array3.length);
            array3 = new int[array4.length];
            System.arraycopy(array4, 0, array3, 0, array4.length);
            array3[n5 + 1] = array3[n5] / 2;
            n4 = n5 + 1;
        }
        final BigInteger[] array5 = new BigInteger[n4 + 1];
        array5[n4] = new BigInteger("8000000B", 16);
        int n6 = n4 - 1;
        for (int i = 0; i < n4; ++i) {
            final int n7 = array3[n6] / 32;
        Block_10:
            while (true) {
                final BigInteger[] array6 = new BigInteger[array2.length];
                System.arraycopy(array2, 0, array6, 0, array2.length);
                array2 = new BigInteger[n7 + 1];
                System.arraycopy(array6, 0, array2, 0, array6.length);
                for (int j = 0; j < n7; ++j) {
                    array2[j + 1] = array2[j].multiply(bigInteger2).add(bigInteger).mod(GOST3410ParametersGenerator.TWO.pow(32));
                }
                BigInteger add = new BigInteger("0");
                for (int k = 0; k < n7; ++k) {
                    add = add.add(array2[k].multiply(GOST3410ParametersGenerator.TWO.pow(32 * k)));
                }
                array2[0] = array2[n7];
                BigInteger bigInteger3 = GOST3410ParametersGenerator.TWO.pow(array3[n6] - 1).divide(array5[n6 + 1]).add(GOST3410ParametersGenerator.TWO.pow(array3[n6] - 1).multiply(add).divide(array5[n6 + 1].multiply(GOST3410ParametersGenerator.TWO.pow(32 * n7))));
                if (bigInteger3.mod(GOST3410ParametersGenerator.TWO).compareTo(GOST3410ParametersGenerator.ONE) == 0) {
                    bigInteger3 = bigInteger3.add(GOST3410ParametersGenerator.ONE);
                }
                int n8 = 0;
                while (true) {
                    array5[n6] = array5[n6 + 1].multiply(bigInteger3.add(BigInteger.valueOf(n8))).add(GOST3410ParametersGenerator.ONE);
                    if (array5[n6].compareTo(GOST3410ParametersGenerator.TWO.pow(array3[n6])) == 1) {
                        break;
                    }
                    if (GOST3410ParametersGenerator.TWO.modPow(array5[n6 + 1].multiply(bigInteger3.add(BigInteger.valueOf(n8))), array5[n6]).compareTo(GOST3410ParametersGenerator.ONE) == 0 && GOST3410ParametersGenerator.TWO.modPow(bigInteger3.add(BigInteger.valueOf(n8)), array5[n6]).compareTo(GOST3410ParametersGenerator.ONE) != 0) {
                        break Block_10;
                    }
                    n8 += 2;
                }
            }
            --n6;
            if (n6 < 0) {
                array[0] = array5[0];
                array[1] = array5[1];
                return array2[0].longValue();
            }
        }
        return array2[0].longValue();
    }
    
    private void procedure_B(int n, int n2, final BigInteger[] array) {
        while (n < 0 || n > 65536) {
            n = this.init_random.nextInt() / 32768;
        }
        while (n2 < 0 || n2 > 65536 || n2 / 2 == 0) {
            n2 = this.init_random.nextInt() / 32768 + 1;
        }
        final BigInteger[] array2 = new BigInteger[2];
        final BigInteger bigInteger = new BigInteger(Integer.toString(n2));
        final BigInteger bigInteger2 = new BigInteger("19381");
        n = this.procedure_A(n, n2, array2, 256);
        final BigInteger bigInteger3 = array2[0];
        n = this.procedure_A(n, n2, array2, 512);
        final BigInteger bigInteger4 = array2[0];
        final BigInteger[] array3 = new BigInteger[65];
        array3[0] = new BigInteger(Integer.toString(n));
        final int n3 = 1024;
        BigInteger add2 = null;
    Block_8:
        while (true) {
            for (int i = 0; i < 64; ++i) {
                array3[i + 1] = array3[i].multiply(bigInteger2).add(bigInteger).mod(GOST3410ParametersGenerator.TWO.pow(16));
            }
            BigInteger add = new BigInteger("0");
            for (int j = 0; j < 64; ++j) {
                add = add.add(array3[j].multiply(GOST3410ParametersGenerator.TWO.pow(16 * j)));
            }
            array3[0] = array3[64];
            BigInteger bigInteger5 = GOST3410ParametersGenerator.TWO.pow(n3 - 1).divide(bigInteger3.multiply(bigInteger4)).add(GOST3410ParametersGenerator.TWO.pow(n3 - 1).multiply(add).divide(bigInteger3.multiply(bigInteger4).multiply(GOST3410ParametersGenerator.TWO.pow(1024))));
            if (bigInteger5.mod(GOST3410ParametersGenerator.TWO).compareTo(GOST3410ParametersGenerator.ONE) == 0) {
                bigInteger5 = bigInteger5.add(GOST3410ParametersGenerator.ONE);
            }
            int n4 = 0;
            while (true) {
                add2 = bigInteger3.multiply(bigInteger4).multiply(bigInteger5.add(BigInteger.valueOf(n4))).add(GOST3410ParametersGenerator.ONE);
                if (add2.compareTo(GOST3410ParametersGenerator.TWO.pow(n3)) == 1) {
                    break;
                }
                if (GOST3410ParametersGenerator.TWO.modPow(bigInteger3.multiply(bigInteger4).multiply(bigInteger5.add(BigInteger.valueOf(n4))), add2).compareTo(GOST3410ParametersGenerator.ONE) == 0 && GOST3410ParametersGenerator.TWO.modPow(bigInteger3.multiply(bigInteger5.add(BigInteger.valueOf(n4))), add2).compareTo(GOST3410ParametersGenerator.ONE) != 0) {
                    break Block_8;
                }
                n4 += 2;
            }
        }
        array[0] = add2;
        array[1] = bigInteger3;
    }
    
    private void procedure_Bb(long n, long n2, final BigInteger[] array) {
        while (n < 0L || n > 4294967296L) {
            n = this.init_random.nextInt() * 2;
        }
        while (n2 < 0L || n2 > 4294967296L || n2 / 2L == 0L) {
            n2 = this.init_random.nextInt() * 2 + 1;
        }
        final BigInteger[] array2 = new BigInteger[2];
        final BigInteger bigInteger = new BigInteger(Long.toString(n2));
        final BigInteger bigInteger2 = new BigInteger("97781173");
        n = this.procedure_Aa(n, n2, array2, 256);
        final BigInteger bigInteger3 = array2[0];
        n = this.procedure_Aa(n, n2, array2, 512);
        final BigInteger bigInteger4 = array2[0];
        final BigInteger[] array3 = new BigInteger[33];
        array3[0] = new BigInteger(Long.toString(n));
        final int n3 = 1024;
        BigInteger add2 = null;
    Block_8:
        while (true) {
            for (int i = 0; i < 32; ++i) {
                array3[i + 1] = array3[i].multiply(bigInteger2).add(bigInteger).mod(GOST3410ParametersGenerator.TWO.pow(32));
            }
            BigInteger add = new BigInteger("0");
            for (int j = 0; j < 32; ++j) {
                add = add.add(array3[j].multiply(GOST3410ParametersGenerator.TWO.pow(32 * j)));
            }
            array3[0] = array3[32];
            BigInteger bigInteger5 = GOST3410ParametersGenerator.TWO.pow(n3 - 1).divide(bigInteger3.multiply(bigInteger4)).add(GOST3410ParametersGenerator.TWO.pow(n3 - 1).multiply(add).divide(bigInteger3.multiply(bigInteger4).multiply(GOST3410ParametersGenerator.TWO.pow(1024))));
            if (bigInteger5.mod(GOST3410ParametersGenerator.TWO).compareTo(GOST3410ParametersGenerator.ONE) == 0) {
                bigInteger5 = bigInteger5.add(GOST3410ParametersGenerator.ONE);
            }
            int n4 = 0;
            while (true) {
                add2 = bigInteger3.multiply(bigInteger4).multiply(bigInteger5.add(BigInteger.valueOf(n4))).add(GOST3410ParametersGenerator.ONE);
                if (add2.compareTo(GOST3410ParametersGenerator.TWO.pow(n3)) == 1) {
                    break;
                }
                if (GOST3410ParametersGenerator.TWO.modPow(bigInteger3.multiply(bigInteger4).multiply(bigInteger5.add(BigInteger.valueOf(n4))), add2).compareTo(GOST3410ParametersGenerator.ONE) == 0 && GOST3410ParametersGenerator.TWO.modPow(bigInteger3.multiply(bigInteger5.add(BigInteger.valueOf(n4))), add2).compareTo(GOST3410ParametersGenerator.ONE) != 0) {
                    break Block_8;
                }
                n4 += 2;
            }
        }
        array[0] = add2;
        array[1] = bigInteger3;
    }
    
    private BigInteger procedure_C(final BigInteger bigInteger, final BigInteger bigInteger2) {
        final BigInteger subtract = bigInteger.subtract(GOST3410ParametersGenerator.ONE);
        final BigInteger divide = subtract.divide(bigInteger2);
        final int bitLength = bigInteger.bitLength();
        BigInteger modPow;
        while (true) {
            final BigInteger bigInteger3 = new BigInteger(bitLength, this.init_random);
            if (bigInteger3.compareTo(GOST3410ParametersGenerator.ONE) > 0 && bigInteger3.compareTo(subtract) < 0) {
                modPow = bigInteger3.modPow(divide, bigInteger);
                if (modPow.compareTo(GOST3410ParametersGenerator.ONE) != 0) {
                    break;
                }
                continue;
            }
        }
        return modPow;
    }
    
    public GOST3410Parameters generateParameters() {
        final BigInteger[] array = new BigInteger[2];
        if (this.typeproc == 1) {
            final int nextInt = this.init_random.nextInt();
            final int nextInt2 = this.init_random.nextInt();
            switch (this.size) {
                case 512: {
                    this.procedure_A(nextInt, nextInt2, array, 512);
                    break;
                }
                case 1024: {
                    this.procedure_B(nextInt, nextInt2, array);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Ooops! key size 512 or 1024 bit.");
                }
            }
            final BigInteger bigInteger = array[0];
            final BigInteger bigInteger2 = array[1];
            return new GOST3410Parameters(bigInteger, bigInteger2, this.procedure_C(bigInteger, bigInteger2), new GOST3410ValidationParameters(nextInt, nextInt2));
        }
        final long nextLong = this.init_random.nextLong();
        final long nextLong2 = this.init_random.nextLong();
        switch (this.size) {
            case 512: {
                this.procedure_Aa(nextLong, nextLong2, array, 512);
                break;
            }
            case 1024: {
                this.procedure_Bb(nextLong, nextLong2, array);
                break;
            }
            default: {
                throw new IllegalStateException("Ooops! key size 512 or 1024 bit.");
            }
        }
        final BigInteger bigInteger3 = array[0];
        final BigInteger bigInteger4 = array[1];
        return new GOST3410Parameters(bigInteger3, bigInteger4, this.procedure_C(bigInteger3, bigInteger4), new GOST3410ValidationParameters(nextLong, nextLong2));
    }
    
    static {
        ONE = BigInteger.valueOf(1L);
        TWO = BigInteger.valueOf(2L);
    }
}
