/*
 * Decompiled with CFR 0.152.
 */
package LZMA;

import LZMA.LzmaException;
import java.io.IOException;
import java.io.InputStream;

class CRangeDecoder {
    static final int kNumTopBits = 24;
    static final int kTopValue = 0x1000000;
    static final int kTopValueMask = -16777216;
    static final int kNumBitModelTotalBits = 11;
    static final int kBitModelTotal = 2048;
    static final int kNumMoveBits = 5;
    InputStream inStream;
    int Range;
    int Code;
    byte[] buffer = new byte[16384];
    int buffer_size;
    int buffer_ind;
    static final int kNumPosBitsMax = 4;
    static final int kNumPosStatesMax = 16;
    static final int kLenNumLowBits = 3;
    static final int kLenNumLowSymbols = 8;
    static final int kLenNumMidBits = 3;
    static final int kLenNumMidSymbols = 8;
    static final int kLenNumHighBits = 8;
    static final int kLenNumHighSymbols = 256;
    static final int LenChoice = 0;
    static final int LenChoice2 = 1;
    static final int LenLow = 2;
    static final int LenMid = 130;
    static final int LenHigh = 258;
    static final int kNumLenProbs = 514;

    CRangeDecoder(InputStream inputStream) throws IOException {
        this.inStream = inputStream;
        this.Code = 0;
        this.Range = -1;
        for (int i = 0; i < 5; ++i) {
            this.Code = this.Code << 8 | this.Readbyte();
        }
    }

    int Readbyte() throws IOException {
        if (this.buffer_size == this.buffer_ind) {
            this.buffer_size = this.inStream.read(this.buffer);
            this.buffer_ind = 0;
            if (this.buffer_size < 1) {
                throw new LzmaException("LZMA : Data Error");
            }
        }
        return this.buffer[this.buffer_ind++] & 0xFF;
    }

    int DecodeDirectBits(int n) throws IOException {
        int n2 = 0;
        for (int i = n; i > 0; --i) {
            this.Range >>>= 1;
            int n3 = this.Code - this.Range >>> 31;
            this.Code -= this.Range & n3 - 1;
            n2 = n2 << 1 | 1 - n3;
            if (this.Range >= 0x1000000) continue;
            this.Code = this.Code << 8 | this.Readbyte();
            this.Range <<= 8;
        }
        return n2;
    }

    int BitDecode(int[] nArray, int n) throws IOException {
        int n2 = (this.Range >>> 11) * nArray[n];
        if (((long)this.Code & 0xFFFFFFFFL) < ((long)n2 & 0xFFFFFFFFL)) {
            this.Range = n2;
            int n3 = n;
            nArray[n3] = nArray[n3] + (2048 - nArray[n] >>> 5);
            if ((this.Range & 0xFF000000) == 0) {
                this.Code = this.Code << 8 | this.Readbyte();
                this.Range <<= 8;
            }
            return 0;
        }
        this.Range -= n2;
        this.Code -= n2;
        int n4 = n;
        nArray[n4] = nArray[n4] - (nArray[n] >>> 5);
        if ((this.Range & 0xFF000000) == 0) {
            this.Code = this.Code << 8 | this.Readbyte();
            this.Range <<= 8;
        }
        return 1;
    }

    int BitTreeDecode(int[] nArray, int n, int n2) throws IOException {
        int n3 = 1;
        for (int i = n2; i > 0; --i) {
            n3 = n3 + n3 + this.BitDecode(nArray, n + n3);
        }
        return n3 - (1 << n2);
    }

    int ReverseBitTreeDecode(int[] nArray, int n, int n2) throws IOException {
        int n3 = 1;
        int n4 = 0;
        for (int i = 0; i < n2; ++i) {
            int n5 = this.BitDecode(nArray, n + n3);
            n3 = n3 + n3 + n5;
            n4 |= n5 << i;
        }
        return n4;
    }

    byte LzmaLiteralDecode(int[] nArray, int n) throws IOException {
        int n2 = 1;
        while ((n2 = n2 + n2 | this.BitDecode(nArray, n + n2)) < 256) {
        }
        return (byte)n2;
    }

    byte LzmaLiteralDecodeMatch(int[] nArray, int n, byte by) throws IOException {
        int n2 = 1;
        do {
            int n3 = by >> 7 & 1;
            by = (byte)(by << 1);
            int n4 = this.BitDecode(nArray, n + (1 + n3 << 8) + n2);
            n2 = n2 << 1 | n4;
            if (n3 == n4) continue;
            while (n2 < 256) {
                n2 = n2 + n2 | this.BitDecode(nArray, n + n2);
            }
            break;
        } while (n2 < 256);
        return (byte)n2;
    }

    int LzmaLenDecode(int[] nArray, int n, int n2) throws IOException {
        if (this.BitDecode(nArray, n + 0) == 0) {
            return this.BitTreeDecode(nArray, n + 2 + (n2 << 3), 3);
        }
        if (this.BitDecode(nArray, n + 1) == 0) {
            return 8 + this.BitTreeDecode(nArray, n + 130 + (n2 << 3), 3);
        }
        return 16 + this.BitTreeDecode(nArray, n + 258, 8);
    }
}

