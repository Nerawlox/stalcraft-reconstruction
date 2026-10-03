/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Utils;
import net.jpountz.util.ByteBufferUtils;

final class LZ4ByteBufferUtils
extends Enum<LZ4ByteBufferUtils> {
    private static final /* synthetic */ LZ4ByteBufferUtils[] $VALUES;

    public static LZ4ByteBufferUtils[] values() {
        return (LZ4ByteBufferUtils[])$VALUES.clone();
    }

    public static LZ4ByteBufferUtils valueOf(String name2) {
        return Enum.valueOf(LZ4ByteBufferUtils.class, name2);
    }

    static int hash(ByteBuffer buf, int i) {
        return LZ4Utils.hash(ByteBufferUtils.readInt(buf, i));
    }

    static int hash64k(ByteBuffer buf, int i) {
        return LZ4Utils.hash64k(ByteBufferUtils.readInt(buf, i));
    }

    static boolean readIntEquals(ByteBuffer buf, int i, int j) {
        return buf.getInt(i) == buf.getInt(j);
    }

    static void safeIncrementalCopy(ByteBuffer dest, int matchOff, int dOff, int matchLen) {
        for (int i = 0; i < matchLen; ++i) {
            dest.put(dOff + i, dest.get(matchOff + i));
        }
    }

    static void wildIncrementalCopy(ByteBuffer dest, int matchOff, int dOff, int matchCopyEnd) {
        if (dOff - matchOff < 4) {
            for (int i = 0; i < 4; ++i) {
                ByteBufferUtils.writeByte(dest, dOff + i, ByteBufferUtils.readByte(dest, matchOff + i));
            }
            int dec = 0;
            assert ((dOff += 4) >= (matchOff += 4) && dOff - matchOff < 8);
            switch (dOff - matchOff) {
                case 1: {
                    matchOff -= 3;
                    break;
                }
                case 2: {
                    matchOff -= 2;
                    break;
                }
                case 3: {
                    matchOff -= 3;
                    dec = -1;
                    break;
                }
                case 5: {
                    dec = 1;
                    break;
                }
                case 6: {
                    dec = 2;
                    break;
                }
                case 7: {
                    dec = 3;
                    break;
                }
            }
            ByteBufferUtils.writeInt(dest, dOff, ByteBufferUtils.readInt(dest, matchOff));
            dOff += 4;
            matchOff -= dec;
        } else if (dOff - matchOff < 8) {
            ByteBufferUtils.writeLong(dest, dOff, ByteBufferUtils.readLong(dest, matchOff));
            dOff += dOff - matchOff;
        }
        while (dOff < matchCopyEnd) {
            ByteBufferUtils.writeLong(dest, dOff, ByteBufferUtils.readLong(dest, matchOff));
            dOff += 8;
            matchOff += 8;
        }
    }

    static int commonBytes(ByteBuffer src, int ref, int sOff, int srcLimit) {
        int matchLen = 0;
        while (sOff <= srcLimit - 8) {
            if (ByteBufferUtils.readLong(src, sOff) == ByteBufferUtils.readLong(src, ref)) {
                matchLen += 8;
                ref += 8;
                sOff += 8;
                continue;
            }
            int zeroBits = src.order() == ByteOrder.BIG_ENDIAN ? Long.numberOfLeadingZeros(ByteBufferUtils.readLong(src, sOff) ^ ByteBufferUtils.readLong(src, ref)) : Long.numberOfTrailingZeros(ByteBufferUtils.readLong(src, sOff) ^ ByteBufferUtils.readLong(src, ref));
            return matchLen + (zeroBits >>> 3);
        }
        while (sOff < srcLimit && ByteBufferUtils.readByte(src, ref++) == ByteBufferUtils.readByte(src, sOff++)) {
            ++matchLen;
        }
        return matchLen;
    }

    static int commonBytesBackward(ByteBuffer b, int o1, int o2, int l1, int l2) {
        int count = 0;
        while (o1 > l1 && o2 > l2 && b.get(--o1) == b.get(--o2)) {
            ++count;
        }
        return count;
    }

    static void safeArraycopy(ByteBuffer src, int sOff, ByteBuffer dest, int dOff, int len) {
        for (int i = 0; i < len; ++i) {
            dest.put(dOff + i, src.get(sOff + i));
        }
    }

    static void wildArraycopy(ByteBuffer src, int sOff, ByteBuffer dest, int dOff, int len) {
        assert (src.order().equals(dest.order()));
        try {
            for (int i = 0; i < len; i += 8) {
                dest.putLong(dOff + i, src.getLong(sOff + i));
            }
        }
        catch (IndexOutOfBoundsException e) {
            throw new LZ4Exception("Malformed input at offset " + sOff);
        }
    }

    static int encodeSequence(ByteBuffer src, int anchor, int matchOff, int matchRef, int matchLen, ByteBuffer dest, int dOff, int destEnd) {
        int token;
        int runLen = matchOff - anchor;
        int tokenOff = dOff++;
        if (dOff + runLen + 8 + (runLen >>> 8) > destEnd) {
            throw new LZ4Exception("maxDestLen is too small");
        }
        if (runLen >= 15) {
            token = -16;
            dOff = LZ4ByteBufferUtils.writeLen(runLen - 15, dest, dOff);
        } else {
            token = runLen << 4;
        }
        LZ4ByteBufferUtils.wildArraycopy(src, anchor, dest, dOff, runLen);
        dOff += runLen;
        int matchDec = matchOff - matchRef;
        dest.put(dOff++, (byte)matchDec);
        dest.put(dOff++, (byte)(matchDec >>> 8));
        if (dOff + 6 + ((matchLen -= 4) >>> 8) > destEnd) {
            throw new LZ4Exception("maxDestLen is too small");
        }
        if (matchLen >= 15) {
            token |= 0xF;
            dOff = LZ4ByteBufferUtils.writeLen(matchLen - 15, dest, dOff);
        } else {
            token |= matchLen;
        }
        dest.put(tokenOff, (byte)token);
        return dOff;
    }

    static int lastLiterals(ByteBuffer src, int sOff, int srcLen, ByteBuffer dest, int dOff, int destEnd) {
        int runLen = srcLen;
        if (dOff + runLen + 1 + (runLen + 255 - 15) / 255 > destEnd) {
            throw new LZ4Exception();
        }
        if (runLen >= 15) {
            dest.put(dOff++, (byte)-16);
            dOff = LZ4ByteBufferUtils.writeLen(runLen - 15, dest, dOff);
        } else {
            dest.put(dOff++, (byte)(runLen << 4));
        }
        LZ4ByteBufferUtils.safeArraycopy(src, sOff, dest, dOff, runLen);
        return dOff += runLen;
    }

    static int writeLen(int len, ByteBuffer dest, int dOff) {
        while (len >= 255) {
            dest.put(dOff++, (byte)-1);
            len -= 255;
        }
        dest.put(dOff++, (byte)len);
        return dOff;
    }

    static void copyTo(Match m1, Match m2) {
        m2.len = m1.len;
        m2.start = m1.start;
        m2.ref = m1.ref;
    }

    static {
        $VALUES = new LZ4ByteBufferUtils[0];
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

