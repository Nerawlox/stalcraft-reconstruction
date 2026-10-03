/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.nio.ByteBuffer;
import java.util.Arrays;
import net.jpountz.lz4.LZ4ByteBufferUtils;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4SafeUtils;
import net.jpountz.lz4.LZ4Utils;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;

final class LZ4HCJavaSafeCompressor
extends LZ4Compressor {
    public static final LZ4Compressor INSTANCE = new LZ4HCJavaSafeCompressor();
    private final int maxAttempts;
    final int compressionLevel;

    LZ4HCJavaSafeCompressor() {
        this(9);
    }

    LZ4HCJavaSafeCompressor(int compressionLevel) {
        this.maxAttempts = 1 << compressionLevel - 1;
        this.compressionLevel = compressionLevel;
    }

    @Override
    public int compress(byte[] src, int srcOff, int srcLen, byte[] dest, int destOff, int maxDestLen) {
        SafeUtils.checkRange(src, srcOff, srcLen);
        SafeUtils.checkRange(dest, destOff, maxDestLen);
        int srcEnd = srcOff + srcLen;
        int destEnd = destOff + maxDestLen;
        int mfLimit = srcEnd - 12;
        int matchLimit = srcEnd - 5;
        int sOff = srcOff;
        int dOff = destOff;
        int anchor = sOff++;
        HashTable ht = new HashTable(srcOff);
        LZ4Utils.Match match0 = new LZ4Utils.Match();
        LZ4Utils.Match match1 = new LZ4Utils.Match();
        LZ4Utils.Match match2 = new LZ4Utils.Match();
        LZ4Utils.Match match3 = new LZ4Utils.Match();
        block0: while (sOff < mfLimit) {
            if (!ht.insertAndFindBestMatch(src, sOff, matchLimit, match1)) {
                ++sOff;
                continue;
            }
            LZ4Utils.copyTo(match1, match0);
            block1: while (true) {
                assert (match1.start >= anchor);
                if (match1.end() >= mfLimit || !ht.insertAndFindWiderMatch(src, match1.end() - 2, match1.start + 1, matchLimit, match1.len, match2)) {
                    dOff = LZ4SafeUtils.encodeSequence(src, anchor, match1.start, match1.ref, match1.len, dest, dOff, destEnd);
                    anchor = sOff = match1.end();
                    continue block0;
                }
                if (match0.start < match1.start && match2.start < match1.start + match0.len) {
                    LZ4Utils.copyTo(match0, match1);
                }
                assert (match2.start > match1.start);
                if (match2.start - match1.start < 3) {
                    LZ4Utils.copyTo(match2, match1);
                    continue;
                }
                while (true) {
                    int correction;
                    if (match2.start - match1.start < 18) {
                        int correction2;
                        int newMatchLen = match1.len;
                        if (newMatchLen > 18) {
                            newMatchLen = 18;
                        }
                        if (match1.start + newMatchLen > match2.end() - 4) {
                            newMatchLen = match2.start - match1.start + match2.len - 4;
                        }
                        if ((correction2 = newMatchLen - (match2.start - match1.start)) > 0) {
                            match2.fix(correction2);
                        }
                    }
                    if (match2.start + match2.len >= mfLimit || !ht.insertAndFindWiderMatch(src, match2.end() - 3, match2.start, matchLimit, match2.len, match3)) {
                        if (match2.start < match1.end()) {
                            match1.len = match2.start - match1.start;
                        }
                        dOff = LZ4SafeUtils.encodeSequence(src, anchor, match1.start, match1.ref, match1.len, dest, dOff, destEnd);
                        anchor = sOff = match1.end();
                        dOff = LZ4SafeUtils.encodeSequence(src, anchor, match2.start, match2.ref, match2.len, dest, dOff, destEnd);
                        anchor = sOff = match2.end();
                        continue block0;
                    }
                    if (match3.start < match1.end() + 3) {
                        if (match3.start >= match1.end()) {
                            if (match2.start < match1.end()) {
                                correction = match1.end() - match2.start;
                                match2.fix(correction);
                                if (match2.len < 4) {
                                    LZ4Utils.copyTo(match3, match2);
                                }
                            }
                            dOff = LZ4SafeUtils.encodeSequence(src, anchor, match1.start, match1.ref, match1.len, dest, dOff, destEnd);
                            anchor = sOff = match1.end();
                            LZ4Utils.copyTo(match3, match1);
                            LZ4Utils.copyTo(match2, match0);
                            continue block1;
                        }
                        LZ4Utils.copyTo(match3, match2);
                        continue;
                    }
                    if (match2.start < match1.end()) {
                        if (match2.start - match1.start < 15) {
                            if (match1.len > 18) {
                                match1.len = 18;
                            }
                            if (match1.end() > match2.end() - 4) {
                                match1.len = match2.end() - match1.start - 4;
                            }
                            correction = match1.end() - match2.start;
                            match2.fix(correction);
                        } else {
                            match1.len = match2.start - match1.start;
                        }
                    }
                    dOff = LZ4SafeUtils.encodeSequence(src, anchor, match1.start, match1.ref, match1.len, dest, dOff, destEnd);
                    anchor = sOff = match1.end();
                    LZ4Utils.copyTo(match2, match1);
                    LZ4Utils.copyTo(match3, match2);
                }
                break;
            }
        }
        dOff = LZ4SafeUtils.lastLiterals(src, anchor, srcEnd - anchor, dest, dOff, destEnd);
        return dOff - destOff;
    }

    @Override
    public int compress(ByteBuffer src, int srcOff, int srcLen, ByteBuffer dest, int destOff, int maxDestLen) {
        if (src.hasArray() && dest.hasArray()) {
            return this.compress(src.array(), srcOff + src.arrayOffset(), srcLen, dest.array(), destOff + dest.arrayOffset(), maxDestLen);
        }
        src = ByteBufferUtils.inNativeByteOrder(src);
        dest = ByteBufferUtils.inNativeByteOrder(dest);
        ByteBufferUtils.checkRange(src, srcOff, srcLen);
        ByteBufferUtils.checkRange(dest, destOff, maxDestLen);
        int srcEnd = srcOff + srcLen;
        int destEnd = destOff + maxDestLen;
        int mfLimit = srcEnd - 12;
        int matchLimit = srcEnd - 5;
        int sOff = srcOff;
        int dOff = destOff;
        int anchor = sOff++;
        HashTable ht = new HashTable(srcOff);
        LZ4Utils.Match match0 = new LZ4Utils.Match();
        LZ4Utils.Match match1 = new LZ4Utils.Match();
        LZ4Utils.Match match2 = new LZ4Utils.Match();
        LZ4Utils.Match match3 = new LZ4Utils.Match();
        block0: while (sOff < mfLimit) {
            if (!ht.insertAndFindBestMatch(src, sOff, matchLimit, match1)) {
                ++sOff;
                continue;
            }
            LZ4Utils.copyTo(match1, match0);
            block1: while (true) {
                assert (match1.start >= anchor);
                if (match1.end() >= mfLimit || !ht.insertAndFindWiderMatch(src, match1.end() - 2, match1.start + 1, matchLimit, match1.len, match2)) {
                    dOff = LZ4ByteBufferUtils.encodeSequence(src, anchor, match1.start, match1.ref, match1.len, dest, dOff, destEnd);
                    anchor = sOff = match1.end();
                    continue block0;
                }
                if (match0.start < match1.start && match2.start < match1.start + match0.len) {
                    LZ4Utils.copyTo(match0, match1);
                }
                assert (match2.start > match1.start);
                if (match2.start - match1.start < 3) {
                    LZ4Utils.copyTo(match2, match1);
                    continue;
                }
                while (true) {
                    int correction;
                    if (match2.start - match1.start < 18) {
                        int correction2;
                        int newMatchLen = match1.len;
                        if (newMatchLen > 18) {
                            newMatchLen = 18;
                        }
                        if (match1.start + newMatchLen > match2.end() - 4) {
                            newMatchLen = match2.start - match1.start + match2.len - 4;
                        }
                        if ((correction2 = newMatchLen - (match2.start - match1.start)) > 0) {
                            match2.fix(correction2);
                        }
                    }
                    if (match2.start + match2.len >= mfLimit || !ht.insertAndFindWiderMatch(src, match2.end() - 3, match2.start, matchLimit, match2.len, match3)) {
                        if (match2.start < match1.end()) {
                            match1.len = match2.start - match1.start;
                        }
                        dOff = LZ4ByteBufferUtils.encodeSequence(src, anchor, match1.start, match1.ref, match1.len, dest, dOff, destEnd);
                        anchor = sOff = match1.end();
                        dOff = LZ4ByteBufferUtils.encodeSequence(src, anchor, match2.start, match2.ref, match2.len, dest, dOff, destEnd);
                        anchor = sOff = match2.end();
                        continue block0;
                    }
                    if (match3.start < match1.end() + 3) {
                        if (match3.start >= match1.end()) {
                            if (match2.start < match1.end()) {
                                correction = match1.end() - match2.start;
                                match2.fix(correction);
                                if (match2.len < 4) {
                                    LZ4Utils.copyTo(match3, match2);
                                }
                            }
                            dOff = LZ4ByteBufferUtils.encodeSequence(src, anchor, match1.start, match1.ref, match1.len, dest, dOff, destEnd);
                            anchor = sOff = match1.end();
                            LZ4Utils.copyTo(match3, match1);
                            LZ4Utils.copyTo(match2, match0);
                            continue block1;
                        }
                        LZ4Utils.copyTo(match3, match2);
                        continue;
                    }
                    if (match2.start < match1.end()) {
                        if (match2.start - match1.start < 15) {
                            if (match1.len > 18) {
                                match1.len = 18;
                            }
                            if (match1.end() > match2.end() - 4) {
                                match1.len = match2.end() - match1.start - 4;
                            }
                            correction = match1.end() - match2.start;
                            match2.fix(correction);
                        } else {
                            match1.len = match2.start - match1.start;
                        }
                    }
                    dOff = LZ4ByteBufferUtils.encodeSequence(src, anchor, match1.start, match1.ref, match1.len, dest, dOff, destEnd);
                    anchor = sOff = match1.end();
                    LZ4Utils.copyTo(match2, match1);
                    LZ4Utils.copyTo(match3, match2);
                }
                break;
            }
        }
        dOff = LZ4ByteBufferUtils.lastLiterals(src, anchor, srcEnd - anchor, dest, dOff, destEnd);
        return dOff - destOff;
    }

    private class HashTable {
        static final int MASK = 65535;
        int nextToUpdate;
        private final int base;
        private final int[] hashTable;
        private final short[] chainTable;

        HashTable(int base) {
            this.base = base;
            this.nextToUpdate = base;
            this.hashTable = new int[32768];
            Arrays.fill(this.hashTable, -1);
            this.chainTable = new short[65536];
        }

        private int hashPointer(byte[] bytes, int off) {
            int v = SafeUtils.readInt(bytes, off);
            return this.hashPointer(v);
        }

        private int hashPointer(ByteBuffer bytes, int off) {
            int v = ByteBufferUtils.readInt(bytes, off);
            return this.hashPointer(v);
        }

        private int hashPointer(int v) {
            int h = LZ4Utils.hashHC(v);
            return this.hashTable[h];
        }

        private int next(int off) {
            return off - (this.chainTable[off & 0xFFFF] & 0xFFFF);
        }

        private void addHash(byte[] bytes, int off) {
            int v = SafeUtils.readInt(bytes, off);
            this.addHash(v, off);
        }

        private void addHash(ByteBuffer bytes, int off) {
            int v = ByteBufferUtils.readInt(bytes, off);
            this.addHash(v, off);
        }

        private void addHash(int v, int off) {
            int h = LZ4Utils.hashHC(v);
            int delta = off - this.hashTable[h];
            assert (delta > 0) : delta;
            if (delta >= 65536) {
                delta = 65535;
            }
            this.chainTable[off & 0xFFFF] = (short)delta;
            this.hashTable[h] = off;
        }

        void insert(int off, byte[] bytes) {
            while (this.nextToUpdate < off) {
                this.addHash(bytes, this.nextToUpdate);
                ++this.nextToUpdate;
            }
        }

        void insert(int off, ByteBuffer bytes) {
            while (this.nextToUpdate < off) {
                this.addHash(bytes, this.nextToUpdate);
                ++this.nextToUpdate;
            }
        }

        boolean insertAndFindBestMatch(byte[] buf, int off, int matchLimit, LZ4Utils.Match match) {
            match.start = off;
            match.len = 0;
            int delta = 0;
            int repl = 0;
            this.insert(off, buf);
            int ref = this.hashPointer(buf, off);
            if (ref >= off - 4 && ref <= off && ref >= this.base) {
                if (LZ4SafeUtils.readIntEquals(buf, ref, off)) {
                    delta = off - ref;
                    repl = match.len = 4 + LZ4SafeUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
                    match.ref = ref;
                }
                ref = this.next(ref);
            }
            for (int i = 0; i < LZ4HCJavaSafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; ++i) {
                int matchLen;
                if (LZ4SafeUtils.readIntEquals(buf, ref, off) && (matchLen = 4 + LZ4SafeUtils.commonBytes(buf, ref + 4, off + 4, matchLimit)) > match.len) {
                    match.ref = ref;
                    match.len = matchLen;
                }
                ref = this.next(ref);
            }
            if (repl != 0) {
                int ptr;
                int end = off + repl - 3;
                for (ptr = off; ptr < end - delta; ++ptr) {
                    this.chainTable[ptr & 0xFFFF] = (short)delta;
                }
                do {
                    this.chainTable[ptr & 0xFFFF] = (short)delta;
                    this.hashTable[LZ4Utils.hashHC((int)SafeUtils.readInt((byte[])buf, (int)ptr))] = ptr;
                } while (++ptr < end);
                this.nextToUpdate = end;
            }
            return match.len != 0;
        }

        boolean insertAndFindWiderMatch(byte[] buf, int off, int startLimit, int matchLimit, int minLen, LZ4Utils.Match match) {
            match.len = minLen;
            this.insert(off, buf);
            int delta = off - startLimit;
            int ref = this.hashPointer(buf, off);
            for (int i = 0; i < LZ4HCJavaSafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; ++i) {
                if (LZ4SafeUtils.readIntEquals(buf, ref, off)) {
                    int matchLenForward = 4 + LZ4SafeUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
                    int matchLenBackward = LZ4SafeUtils.commonBytesBackward(buf, ref, off, this.base, startLimit);
                    int matchLen = matchLenBackward + matchLenForward;
                    if (matchLen > match.len) {
                        match.len = matchLen;
                        match.ref = ref - matchLenBackward;
                        match.start = off - matchLenBackward;
                    }
                }
                ref = this.next(ref);
            }
            return match.len > minLen;
        }

        boolean insertAndFindBestMatch(ByteBuffer buf, int off, int matchLimit, LZ4Utils.Match match) {
            match.start = off;
            match.len = 0;
            int delta = 0;
            int repl = 0;
            this.insert(off, buf);
            int ref = this.hashPointer(buf, off);
            if (ref >= off - 4 && ref <= off && ref >= this.base) {
                if (LZ4ByteBufferUtils.readIntEquals(buf, ref, off)) {
                    delta = off - ref;
                    repl = match.len = 4 + LZ4ByteBufferUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
                    match.ref = ref;
                }
                ref = this.next(ref);
            }
            for (int i = 0; i < LZ4HCJavaSafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; ++i) {
                int matchLen;
                if (LZ4ByteBufferUtils.readIntEquals(buf, ref, off) && (matchLen = 4 + LZ4ByteBufferUtils.commonBytes(buf, ref + 4, off + 4, matchLimit)) > match.len) {
                    match.ref = ref;
                    match.len = matchLen;
                }
                ref = this.next(ref);
            }
            if (repl != 0) {
                int ptr;
                int end = off + repl - 3;
                for (ptr = off; ptr < end - delta; ++ptr) {
                    this.chainTable[ptr & 0xFFFF] = (short)delta;
                }
                do {
                    this.chainTable[ptr & 0xFFFF] = (short)delta;
                    this.hashTable[LZ4Utils.hashHC((int)ByteBufferUtils.readInt((ByteBuffer)buf, (int)ptr))] = ptr;
                } while (++ptr < end);
                this.nextToUpdate = end;
            }
            return match.len != 0;
        }

        boolean insertAndFindWiderMatch(ByteBuffer buf, int off, int startLimit, int matchLimit, int minLen, LZ4Utils.Match match) {
            match.len = minLen;
            this.insert(off, buf);
            int delta = off - startLimit;
            int ref = this.hashPointer(buf, off);
            for (int i = 0; i < LZ4HCJavaSafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; ++i) {
                if (LZ4ByteBufferUtils.readIntEquals(buf, ref, off)) {
                    int matchLenForward = 4 + LZ4ByteBufferUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
                    int matchLenBackward = LZ4ByteBufferUtils.commonBytesBackward(buf, ref, off, this.base, startLimit);
                    int matchLen = matchLenBackward + matchLenForward;
                    if (matchLen > match.len) {
                        match.len = matchLen;
                        match.ref = ref - matchLenBackward;
                        match.start = off - matchLenBackward;
                    }
                }
                ref = this.next(ref);
            }
            return match.len > minLen;
        }
    }
}

