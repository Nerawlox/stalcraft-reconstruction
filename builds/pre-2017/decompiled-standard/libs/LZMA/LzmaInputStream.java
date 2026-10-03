/*
 * Decompiled with CFR 0.152.
 */
package LZMA;

import LZMA.CRangeDecoder;
import LZMA.LzmaException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LzmaInputStream
extends FilterInputStream {
    boolean isClosed = false;
    CRangeDecoder RangeDecoder;
    byte[] dictionary;
    int dictionarySize;
    int dictionaryPos;
    int GlobalPos;
    int rep0;
    int rep1;
    int rep2;
    int rep3;
    int lc;
    int lp;
    int pb;
    int State;
    boolean PreviousIsMatch;
    int RemainLen;
    int[] probs;
    byte[] uncompressed_buffer;
    int uncompressed_size;
    int uncompressed_offset;
    long GlobalNowPos;
    long GlobalOutSize;
    static final int LZMA_BASE_SIZE = 1846;
    static final int LZMA_LIT_SIZE = 768;
    static final int kBlockSize = 65536;
    static final int kNumStates = 12;
    static final int kStartPosModelIndex = 4;
    static final int kEndPosModelIndex = 14;
    static final int kNumFullDistances = 128;
    static final int kNumPosSlotBits = 6;
    static final int kNumLenToPosStates = 4;
    static final int kNumAlignBits = 4;
    static final int kAlignTableSize = 16;
    static final int kMatchMinLen = 2;
    static final int IsMatch = 0;
    static final int IsRep = 192;
    static final int IsRepG0 = 204;
    static final int IsRepG1 = 216;
    static final int IsRepG2 = 228;
    static final int IsRep0Long = 240;
    static final int PosSlot = 432;
    static final int SpecPos = 688;
    static final int Align = 802;
    static final int LenCoder = 818;
    static final int RepLenCoder = 1332;
    static final int Literal = 1846;

    public LzmaInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        this.readHeader();
        this.fill_buffer();
    }

    private void LzmaDecode(int n) throws IOException {
        int n2;
        int n3 = (1 << this.pb) - 1;
        int n4 = (1 << this.lp) - 1;
        this.uncompressed_size = 0;
        if (this.RemainLen == -1) {
            return;
        }
        while (this.RemainLen > 0 && this.uncompressed_size < n) {
            n2 = this.dictionaryPos - this.rep0;
            if (n2 < 0) {
                n2 += this.dictionarySize;
            }
            this.uncompressed_buffer[this.uncompressed_size++] = this.dictionary[this.dictionaryPos] = this.dictionary[n2];
            if (++this.dictionaryPos == this.dictionarySize) {
                this.dictionaryPos = 0;
            }
            --this.RemainLen;
        }
        byte by = this.dictionaryPos == 0 ? this.dictionary[this.dictionarySize - 1] : this.dictionary[this.dictionaryPos - 1];
        while (this.uncompressed_size < n) {
            int n5;
            int n6;
            n2 = this.uncompressed_size + this.GlobalPos & n3;
            if (this.RangeDecoder.BitDecode(this.probs, 0 + (this.State << 4) + n2) == 0) {
                n6 = 1846 + 768 * (((this.uncompressed_size + this.GlobalPos & n4) << this.lc) + ((by & 0xFF) >> 8 - this.lc));
                this.State = this.State < 4 ? 0 : (this.State < 10 ? (this.State -= 3) : (this.State -= 6));
                if (this.PreviousIsMatch) {
                    n5 = this.dictionaryPos - this.rep0;
                    if (n5 < 0) {
                        n5 += this.dictionarySize;
                    }
                    byte by2 = this.dictionary[n5];
                    by = this.RangeDecoder.LzmaLiteralDecodeMatch(this.probs, n6, by2);
                    this.PreviousIsMatch = false;
                } else {
                    by = this.RangeDecoder.LzmaLiteralDecode(this.probs, n6);
                }
                this.uncompressed_buffer[this.uncompressed_size++] = by;
                this.dictionary[this.dictionaryPos] = by;
                if (++this.dictionaryPos != this.dictionarySize) continue;
                this.dictionaryPos = 0;
                continue;
            }
            this.PreviousIsMatch = true;
            if (this.RangeDecoder.BitDecode(this.probs, 192 + this.State) == 1) {
                if (this.RangeDecoder.BitDecode(this.probs, 204 + this.State) == 0) {
                    if (this.RangeDecoder.BitDecode(this.probs, 240 + (this.State << 4) + n2) == 0) {
                        if (this.uncompressed_size + this.GlobalPos == 0) {
                            throw new LzmaException("LZMA : Data Error");
                        }
                        this.State = this.State < 7 ? 9 : 11;
                        n6 = this.dictionaryPos - this.rep0;
                        if (n6 < 0) {
                            n6 += this.dictionarySize;
                        }
                        this.dictionary[this.dictionaryPos] = by = this.dictionary[n6];
                        if (++this.dictionaryPos == this.dictionarySize) {
                            this.dictionaryPos = 0;
                        }
                        this.uncompressed_buffer[this.uncompressed_size++] = by;
                        continue;
                    }
                } else {
                    if (this.RangeDecoder.BitDecode(this.probs, 216 + this.State) == 0) {
                        n6 = this.rep1;
                    } else {
                        if (this.RangeDecoder.BitDecode(this.probs, 228 + this.State) == 0) {
                            n6 = this.rep2;
                        } else {
                            n6 = this.rep3;
                            this.rep3 = this.rep2;
                        }
                        this.rep2 = this.rep1;
                    }
                    this.rep1 = this.rep0;
                    this.rep0 = n6;
                }
                this.RemainLen = this.RangeDecoder.LzmaLenDecode(this.probs, 1332, n2);
                this.State = this.State < 7 ? 8 : 11;
            } else {
                this.rep3 = this.rep2;
                this.rep2 = this.rep1;
                this.rep1 = this.rep0;
                this.State = this.State < 7 ? 7 : 10;
                this.RemainLen = this.RangeDecoder.LzmaLenDecode(this.probs, 818, n2);
                n6 = this.RangeDecoder.BitTreeDecode(this.probs, 432 + ((this.RemainLen < 4 ? this.RemainLen : 3) << 6), 6);
                if (n6 >= 4) {
                    n5 = (n6 >> 1) - 1;
                    this.rep0 = (2 | n6 & 1) << n5;
                    if (n6 < 14) {
                        this.rep0 += this.RangeDecoder.ReverseBitTreeDecode(this.probs, 688 + this.rep0 - n6 - 1, n5);
                    } else {
                        this.rep0 += this.RangeDecoder.DecodeDirectBits(n5 - 4) << 4;
                        this.rep0 += this.RangeDecoder.ReverseBitTreeDecode(this.probs, 802, 4);
                    }
                } else {
                    this.rep0 = n6;
                }
                ++this.rep0;
            }
            if (this.rep0 == 0) {
                this.RemainLen = -1;
                break;
            }
            if (this.rep0 > this.uncompressed_size + this.GlobalPos) {
                throw new LzmaException("LZMA : Data Error");
            }
            this.RemainLen += 2;
            do {
                if ((n6 = this.dictionaryPos - this.rep0) < 0) {
                    n6 += this.dictionarySize;
                }
                this.dictionary[this.dictionaryPos] = by = this.dictionary[n6];
                if (++this.dictionaryPos == this.dictionarySize) {
                    this.dictionaryPos = 0;
                }
                this.uncompressed_buffer[this.uncompressed_size++] = by;
                --this.RemainLen;
            } while (this.RemainLen > 0 && this.uncompressed_size < n);
        }
        this.GlobalPos += this.uncompressed_size;
    }

    private void fill_buffer() throws IOException {
        if (this.GlobalNowPos < this.GlobalOutSize) {
            this.uncompressed_offset = 0;
            long l = this.GlobalOutSize - this.GlobalNowPos;
            int n = l > 65536L ? 65536 : (int)l;
            this.LzmaDecode(n);
            if (this.uncompressed_size == 0) {
                this.GlobalOutSize = this.GlobalNowPos;
            } else {
                this.GlobalNowPos += (long)this.uncompressed_size;
            }
        }
    }

    private void readHeader() throws IOException {
        int n;
        int n2;
        int n3;
        byte[] byArray = new byte[5];
        if (5 != this.in.read(byArray)) {
            throw new LzmaException("LZMA header corrupted : Properties error");
        }
        this.GlobalOutSize = 0L;
        for (n3 = 0; n3 < 8; ++n3) {
            n2 = this.in.read();
            if (n2 == -1) {
                throw new LzmaException("LZMA header corrupted : Size error");
            }
            this.GlobalOutSize += (long)n2 << n3 * 8;
        }
        if (this.GlobalOutSize == -1L) {
            this.GlobalOutSize = Long.MAX_VALUE;
        }
        if ((n3 = byArray[0] & 0xFF) >= 225) {
            throw new LzmaException("LZMA header corrupted : Properties error");
        }
        this.pb = 0;
        while (n3 >= 45) {
            ++this.pb;
            n3 -= 45;
        }
        this.lp = 0;
        while (n3 >= 9) {
            ++this.lp;
            n3 -= 9;
        }
        this.lc = n3;
        n2 = 1846 + (768 << this.lc + this.lp);
        this.probs = new int[n2];
        this.dictionarySize = 0;
        for (n = 0; n < 4; ++n) {
            this.dictionarySize += (byArray[1 + n] & 0xFF) << n * 8;
        }
        this.dictionary = new byte[this.dictionarySize];
        if (this.dictionary == null) {
            throw new LzmaException("LZMA : can't allocate");
        }
        n = 1846 + (768 << this.lc + this.lp);
        this.RangeDecoder = new CRangeDecoder(this.in);
        this.dictionaryPos = 0;
        this.GlobalPos = 0;
        this.rep3 = 1;
        this.rep2 = 1;
        this.rep1 = 1;
        this.rep0 = 1;
        this.State = 0;
        this.PreviousIsMatch = false;
        this.RemainLen = 0;
        this.dictionary[this.dictionarySize - 1] = 0;
        for (int i = 0; i < n; ++i) {
            this.probs[i] = 1024;
        }
        this.uncompressed_buffer = new byte[65536];
        this.uncompressed_size = 0;
        this.uncompressed_offset = 0;
        this.GlobalNowPos = 0L;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        if (this.isClosed) {
            throw new IOException("stream closed");
        }
        if ((n | n2 | n + n2 | byArray.length - (n + n2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (n2 == 0) {
            return 0;
        }
        if (this.uncompressed_offset == this.uncompressed_size) {
            this.fill_buffer();
        }
        if (this.uncompressed_offset == this.uncompressed_size) {
            return -1;
        }
        int n3 = Math.min(n2, this.uncompressed_size - this.uncompressed_offset);
        System.arraycopy(this.uncompressed_buffer, this.uncompressed_offset, byArray, n, n3);
        this.uncompressed_offset += n3;
        return n3;
    }

    public void close() throws IOException {
        this.isClosed = true;
        super.close();
    }
}

