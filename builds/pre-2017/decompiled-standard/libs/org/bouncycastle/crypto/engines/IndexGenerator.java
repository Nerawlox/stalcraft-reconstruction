/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.crypto.params.NTRUEncryptionParameters
 */
package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.NTRUEncryptionParameters;
import org.bouncycastle.util.Arrays;

public class IndexGenerator {
    private byte[] seed;
    private int N;
    private int c;
    private int minCallsR;
    private int totLen;
    private int remLen;
    private BitString buf;
    private int counter;
    private boolean initialized;
    private Digest hashAlg;
    private int hLen;

    IndexGenerator(byte[] byArray, NTRUEncryptionParameters nTRUEncryptionParameters) {
        this.seed = byArray;
        this.N = nTRUEncryptionParameters.N;
        this.c = nTRUEncryptionParameters.c;
        this.minCallsR = nTRUEncryptionParameters.minCallsR;
        this.totLen = 0;
        this.remLen = 0;
        this.counter = 0;
        this.hashAlg = nTRUEncryptionParameters.hashAlg;
        this.hLen = this.hashAlg.getDigestSize();
        this.initialized = false;
    }

    int nextIndex() {
        int n;
        Object object;
        if (!this.initialized) {
            this.buf = new BitString();
            object = new byte[this.hashAlg.getDigestSize()];
            while (this.counter < this.minCallsR) {
                this.appendHash(this.buf, (byte[])object);
                ++this.counter;
            }
            this.remLen = this.totLen = this.minCallsR * 8 * this.hLen;
            this.initialized = true;
        }
        do {
            this.totLen += this.c;
            object = this.buf.getTrailing(this.remLen);
            if (this.remLen < this.c) {
                n = this.c - this.remLen;
                int n2 = this.counter + (n + this.hLen - 1) / this.hLen;
                byte[] byArray = new byte[this.hashAlg.getDigestSize()];
                while (this.counter < n2) {
                    this.appendHash((BitString)object, byArray);
                    ++this.counter;
                    if (n <= 8 * this.hLen) continue;
                    n -= 8 * this.hLen;
                }
                this.remLen = 8 * this.hLen - n;
                this.buf = new BitString();
                this.buf.appendBits(byArray);
                continue;
            }
            this.remLen -= this.c;
        } while ((n = ((BitString)object).getLeadingAsInt(this.c)) >= (1 << this.c) - (1 << this.c) % this.N);
        return n % this.N;
    }

    private void appendHash(BitString bitString, byte[] byArray) {
        this.hashAlg.update(this.seed, 0, this.seed.length);
        this.putInt(this.hashAlg, this.counter);
        this.hashAlg.doFinal(byArray, 0);
        bitString.appendBits(byArray);
    }

    private void putInt(Digest digest, int n) {
        digest.update((byte)(n >> 24));
        digest.update((byte)(n >> 16));
        digest.update((byte)(n >> 8));
        digest.update((byte)n);
    }

    private static byte[] copyOf(byte[] byArray, int n) {
        byte[] byArray2 = new byte[n];
        System.arraycopy(byArray, 0, byArray2, 0, n < byArray.length ? n : byArray.length);
        return byArray2;
    }

    public static class BitString {
        byte[] bytes = new byte[4];
        int numBytes;
        int lastByteBits;

        void appendBits(byte[] byArray) {
            for (int i = 0; i != byArray.length; ++i) {
                this.appendBits(byArray[i]);
            }
        }

        public void appendBits(byte by) {
            if (this.numBytes == this.bytes.length) {
                this.bytes = IndexGenerator.copyOf(this.bytes, 2 * this.bytes.length);
            }
            if (this.numBytes == 0) {
                this.numBytes = 1;
                this.bytes[0] = by;
                this.lastByteBits = 8;
            } else if (this.lastByteBits == 8) {
                this.bytes[this.numBytes++] = by;
            } else {
                int n = 8 - this.lastByteBits;
                int n2 = this.numBytes - 1;
                this.bytes[n2] = (byte)(this.bytes[n2] | (by & 0xFF) << this.lastByteBits);
                this.bytes[this.numBytes++] = (byte)((by & 0xFF) >> n);
            }
        }

        public BitString getTrailing(int n) {
            int n2;
            BitString bitString = new BitString();
            bitString.numBytes = (n + 7) / 8;
            bitString.bytes = new byte[bitString.numBytes];
            for (n2 = 0; n2 < bitString.numBytes; ++n2) {
                bitString.bytes[n2] = this.bytes[n2];
            }
            bitString.lastByteBits = n % 8;
            if (bitString.lastByteBits == 0) {
                bitString.lastByteBits = 8;
            } else {
                n2 = 32 - bitString.lastByteBits;
                bitString.bytes[bitString.numBytes - 1] = (byte)(bitString.bytes[bitString.numBytes - 1] << n2 >>> n2);
            }
            return bitString;
        }

        public int getLeadingAsInt(int n) {
            int n2 = (this.numBytes - 1) * 8 + this.lastByteBits - n;
            int n3 = n2 / 8;
            int n4 = n2 % 8;
            int n5 = (this.bytes[n3] & 0xFF) >>> n4;
            int n6 = 8 - n4;
            for (int i = n3 + 1; i < this.numBytes; ++i) {
                n5 |= (this.bytes[i] & 0xFF) << n6;
                n6 += 8;
            }
            return n5;
        }

        public byte[] getBytes() {
            return Arrays.clone(this.bytes);
        }
    }
}

