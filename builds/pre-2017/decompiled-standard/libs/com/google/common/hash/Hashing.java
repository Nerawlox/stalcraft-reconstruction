/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.hash.AbstractCompositeHashFunction;
import com.google.common.hash.ChecksumHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashCodes;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.MessageDigestHashFunction;
import com.google.common.hash.Murmur3_128HashFunction;
import com.google.common.hash.Murmur3_32HashFunction;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

@Beta
public final class Hashing {
    private static final int GOOD_FAST_HASH_SEED = (int)System.currentTimeMillis();
    private static final HashFunction GOOD_FAST_HASH_FUNCTION_32 = Hashing.murmur3_32(GOOD_FAST_HASH_SEED);
    private static final HashFunction GOOD_FAST_HASH_FUNCTION_128 = Hashing.murmur3_128(GOOD_FAST_HASH_SEED);
    private static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    private static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    private static final HashFunction MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");
    private static final HashFunction SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
    private static final HashFunction SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
    private static final HashFunction SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
    private static final HashFunction CRC_32 = Hashing.checksumHashFunction(ChecksumType.CRC_32, "Hashing.crc32()");
    private static final HashFunction ADLER_32 = Hashing.checksumHashFunction(ChecksumType.ADLER_32, "Hashing.adler32()");

    private Hashing() {
    }

    public static HashFunction goodFastHash(int minimumBits) {
        int bits = Hashing.checkPositiveAndMakeMultipleOf32(minimumBits);
        if (bits == 32) {
            return GOOD_FAST_HASH_FUNCTION_32;
        }
        if (bits <= 128) {
            return GOOD_FAST_HASH_FUNCTION_128;
        }
        int hashFunctionsNeeded = (bits + 127) / 128;
        HashFunction[] hashFunctions = new HashFunction[hashFunctionsNeeded];
        hashFunctions[0] = GOOD_FAST_HASH_FUNCTION_128;
        int seed = GOOD_FAST_HASH_SEED;
        for (int i = 1; i < hashFunctionsNeeded; ++i) {
            hashFunctions[i] = Hashing.murmur3_128(seed += 1500450271);
        }
        return new ConcatenatedHashFunction(hashFunctions);
    }

    public static HashFunction murmur3_32(int seed) {
        return new Murmur3_32HashFunction(seed);
    }

    public static HashFunction murmur3_32() {
        return MURMUR3_32;
    }

    public static HashFunction murmur3_128(int seed) {
        return new Murmur3_128HashFunction(seed);
    }

    public static HashFunction murmur3_128() {
        return MURMUR3_128;
    }

    public static HashFunction md5() {
        return MD5;
    }

    public static HashFunction sha1() {
        return SHA_1;
    }

    public static HashFunction sha256() {
        return SHA_256;
    }

    public static HashFunction sha512() {
        return SHA_512;
    }

    public static HashFunction crc32() {
        return CRC_32;
    }

    public static HashFunction adler32() {
        return ADLER_32;
    }

    private static HashFunction checksumHashFunction(ChecksumType type2, String toString2) {
        return new ChecksumHashFunction(type2, type2.bits, toString2);
    }

    @Deprecated
    public static long padToLong(HashCode hashCode2) {
        return hashCode2.padToLong();
    }

    public static int consistentHash(HashCode hashCode2, int buckets) {
        return Hashing.consistentHash(hashCode2.padToLong(), buckets);
    }

    public static int consistentHash(long input, int buckets) {
        int next;
        Preconditions.checkArgument(buckets > 0, "buckets must be positive: %s", buckets);
        LinearCongruentialGenerator generator = new LinearCongruentialGenerator(input);
        int candidate = 0;
        while ((next = (int)((double)(candidate + 1) / generator.nextDouble())) >= 0 && next < buckets) {
            candidate = next;
        }
        return candidate;
    }

    public static HashCode combineOrdered(Iterable<HashCode> hashCodes) {
        Iterator<HashCode> iterator2 = hashCodes.iterator();
        Preconditions.checkArgument(iterator2.hasNext(), "Must be at least 1 hash code to combine.");
        int bits = iterator2.next().bits();
        byte[] resultBytes = new byte[bits / 8];
        for (HashCode hashCode2 : hashCodes) {
            byte[] nextBytes = hashCode2.asBytes();
            Preconditions.checkArgument(nextBytes.length == resultBytes.length, "All hashcodes must have the same bit length.");
            for (int i = 0; i < nextBytes.length; ++i) {
                resultBytes[i] = (byte)(resultBytes[i] * 37 ^ nextBytes[i]);
            }
        }
        return HashCodes.fromBytesNoCopy(resultBytes);
    }

    public static HashCode combineUnordered(Iterable<HashCode> hashCodes) {
        Iterator<HashCode> iterator2 = hashCodes.iterator();
        Preconditions.checkArgument(iterator2.hasNext(), "Must be at least 1 hash code to combine.");
        byte[] resultBytes = new byte[iterator2.next().bits() / 8];
        for (HashCode hashCode2 : hashCodes) {
            byte[] nextBytes = hashCode2.asBytes();
            Preconditions.checkArgument(nextBytes.length == resultBytes.length, "All hashcodes must have the same bit length.");
            for (int i = 0; i < nextBytes.length; ++i) {
                int n = i;
                resultBytes[n] = (byte)(resultBytes[n] + nextBytes[i]);
            }
        }
        return HashCodes.fromBytesNoCopy(resultBytes);
    }

    static int checkPositiveAndMakeMultipleOf32(int bits) {
        Preconditions.checkArgument(bits > 0, "Number of bits must be positive");
        return bits + 31 & 0xFFFFFFE0;
    }

    private static final class LinearCongruentialGenerator {
        private long state;

        public LinearCongruentialGenerator(long seed) {
            this.state = seed;
        }

        public double nextDouble() {
            this.state = 2862933555777941757L * this.state + 1L;
            return (double)((int)(this.state >>> 33) + 1) / 2.147483648E9;
        }
    }

    @VisibleForTesting
    static final class ConcatenatedHashFunction
    extends AbstractCompositeHashFunction {
        private final int bits;

        ConcatenatedHashFunction(HashFunction ... functions2) {
            super(functions2);
            int bitSum = 0;
            for (HashFunction function : functions2) {
                bitSum += function.bits();
            }
            this.bits = bitSum;
        }

        @Override
        HashCode makeHash(Hasher[] hashers) {
            byte[] bytes = new byte[this.bits / 8];
            ByteBuffer buffer = ByteBuffer.wrap(bytes);
            for (Hasher hasher : hashers) {
                buffer.put(hasher.hash().asBytes());
            }
            return HashCodes.fromBytesNoCopy(bytes);
        }

        @Override
        public int bits() {
            return this.bits;
        }
    }

    static enum ChecksumType implements Supplier<Checksum>
    {
        CRC_32(32){

            @Override
            public Checksum get() {
                return new CRC32();
            }
        }
        ,
        ADLER_32(32){

            @Override
            public Checksum get() {
                return new Adler32();
            }
        };

        private final int bits;

        private ChecksumType(int bits) {
            this.bits = bits;
        }

        @Override
        public abstract Checksum get();
    }
}

