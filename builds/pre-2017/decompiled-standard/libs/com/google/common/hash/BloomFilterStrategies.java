/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;

enum BloomFilterStrategies implements BloomFilter.Strategy
{
    MURMUR128_MITZ_32{

        @Override
        public <T> boolean put(T object, Funnel<? super T> funnel, int numHashFunctions, BitArray bits) {
            long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
            int hash1 = (int)hash64;
            int hash2 = (int)(hash64 >>> 32);
            boolean bitsChanged = false;
            for (int i = 1; i <= numHashFunctions; ++i) {
                int nextHash = hash1 + i * hash2;
                if (nextHash < 0) {
                    nextHash ^= 0xFFFFFFFF;
                }
                bitsChanged |= bits.set(nextHash % bits.size());
            }
            return bitsChanged;
        }

        @Override
        public <T> boolean mightContain(T object, Funnel<? super T> funnel, int numHashFunctions, BitArray bits) {
            long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
            int hash1 = (int)hash64;
            int hash2 = (int)(hash64 >>> 32);
            for (int i = 1; i <= numHashFunctions; ++i) {
                int nextHash = hash1 + i * hash2;
                if (nextHash < 0) {
                    nextHash ^= 0xFFFFFFFF;
                }
                if (bits.get(nextHash % bits.size())) continue;
                return false;
            }
            return true;
        }
    };


    static class BitArray {
        final long[] data;
        int bitCount;

        BitArray(long bits) {
            this(new long[Ints.checkedCast(LongMath.divide(bits, 64L, RoundingMode.CEILING))]);
        }

        BitArray(long[] data2) {
            Preconditions.checkArgument(data2.length > 0, "data length is zero!");
            this.data = data2;
            int bitCount = 0;
            for (long value : data2) {
                bitCount += Long.bitCount(value);
            }
            this.bitCount = bitCount;
        }

        boolean set(int index) {
            if (!this.get(index)) {
                int n = index >> 6;
                this.data[n] = this.data[n] | 1L << index;
                ++this.bitCount;
                return true;
            }
            return false;
        }

        boolean get(int index) {
            return (this.data[index >> 6] & 1L << index) != 0L;
        }

        int size() {
            return this.data.length * 64;
        }

        int bitCount() {
            return this.bitCount;
        }

        BitArray copy() {
            return new BitArray((long[])this.data.clone());
        }

        public boolean equals(Object o) {
            if (o instanceof BitArray) {
                BitArray bitArray = (BitArray)o;
                return Arrays.equals(this.data, bitArray.data);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.data);
        }
    }
}

