/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Utils;
import net.jpountz.util.SafeUtils;

enum LZ4SafeUtils {


    static int hash(byte[] buf, int i) {
        return LZ4Utils.hash(SafeUtils.readInt(buf, i));
    }

    static int hash64k(byte[] buf, int i) {
        return LZ4Utils.hash64k(SafeUtils.readInt(buf, i));
    }

    static boolean readIntEquals(byte[] buf, int i, int j) {
        return buf[i] == buf[j] && buf[i + 1] == buf[j + 1] && buf[i + 2] == buf[j + 2] && buf[i + 3] == buf[j + 3];
    }

    static void safeIncrementalCopy(byte[] dest, int matchOff, int dOff, int matchLen) {
        for (int i = 0; i < matchLen; ++i) {
            dest[dOff + i] = dest[matchOff + i];
        }
    }

    static void wildIncrementalCopy(byte[] dest, int matchOff, int dOff, int matchCopyEnd) {
        do {
            LZ4SafeUtils.copy8Bytes(dest, matchOff, dest, dOff);
            matchOff += 8;
        } while ((dOff += 8) < matchCopyEnd);
    }

    static void copy8Bytes(byte[] src, int sOff, byte[] dest, int dOff) {
        for (int i = 0; i < 8; ++i) {
            dest[dOff + i] = src[sOff + i];
        }
    }

    static int commonBytes(byte[] b, int o1, int o2, int limit) {
        int count = 0;
        while (o2 < limit && b[o1++] == b[o2++]) {
            ++count;
        }
        return count;
    }

    static int commonBytesBackward(byte[] b, int o1, int o2, int l1, int l2) {
        int count = 0;
        while (o1 > l1 && o2 > l2 && b[--o1] == b[--o2]) {
            ++count;
        }
        return count;
    }

    static void safeArraycopy(byte[] src, int sOff, byte[] dest, int dOff, int len) {
        System.arraycopy(src, sOff, dest, dOff, len);
    }

    static void wildArraycopy(byte[] src, int sOff, byte[] dest, int dOff, int len) {
        try {
            for (int i = 0; i < len; i += 8) {
                LZ4SafeUtils.copy8Bytes(src, sOff + i, dest, dOff + i);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new LZ4Exception("Malformed input at offset " + sOff);
        }
    }

    static int encodeSequence(byte[] src, int anchor, int matchOff, int matchRef, int matchLen, byte[] dest, int dOff, int destEnd) {
        int token;
        int runLen = matchOff - anchor;
        int tokenOff = dOff++;
        if (dOff + runLen + 8 + (runLen >>> 8) > destEnd) {
            throw new LZ4Exception("maxDestLen is too small");
        }
        if (runLen >= 15) {
            token = -16;
            dOff = LZ4SafeUtils.writeLen(runLen - 15, dest, dOff);
        } else {
            token = runLen << 4;
        }
        LZ4SafeUtils.wildArraycopy(src, anchor, dest, dOff, runLen);
        dOff += runLen;
        int matchDec = matchOff - matchRef;
        dest[dOff++] = (byte)matchDec;
        dest[dOff++] = (byte)(matchDec >>> 8);
        if (dOff + 6 + ((matchLen -= 4) >>> 8) > destEnd) {
            throw new LZ4Exception("maxDestLen is too small");
        }
        if (matchLen >= 15) {
            token |= 0xF;
            dOff = LZ4SafeUtils.writeLen(matchLen - 15, dest, dOff);
        } else {
            token |= matchLen;
        }
        dest[tokenOff] = (byte)token;
        return dOff;
    }

    static int lastLiterals(byte[] src, int sOff, int srcLen, byte[] dest, int dOff, int destEnd) {
        int runLen = srcLen;
        if (dOff + runLen + 1 + (runLen + 255 - 15) / 255 > destEnd) {
            throw new LZ4Exception();
        }
        if (runLen >= 15) {
            dest[dOff++] = -16;
            dOff = LZ4SafeUtils.writeLen(runLen - 15, dest, dOff);
        } else {
            dest[dOff++] = (byte)(runLen << 4);
        }
        System.arraycopy(src, sOff, dest, dOff, runLen);
        return dOff += runLen;
    }

    static int writeLen(int len, byte[] dest, int dOff) {
        while (len >= 255) {
            dest[dOff++] = -1;
            len -= 255;
        }
        dest[dOff++] = (byte)len;
        return dOff;
    }

    static void copyTo(Match m1, Match m2) {
        m2.len = m1.len;
        m2.start = m1.start;
        m2.ref = m1.ref;
    }

    static class Match {
        int start;
        int ref;
        int len;

        Match() {
        }

        void fix(int correction) {
            this.start += correction;
            this.ref += correction;
            this.len -= correction;
        }

        int end() {
            return this.start + this.len;
        }
    }
}

