/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.nio.ByteBuffer;
import java.util.Arrays;
import net.jpountz.lz4.LZ4ByteBufferUtils;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Constants;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4SafeUtils;
import net.jpountz.lz4.LZ4Utils;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;

final class LZ4JavaSafeCompressor
extends LZ4Compressor {
    public static final LZ4Compressor INSTANCE = new LZ4JavaSafeCompressor();

    LZ4JavaSafeCompressor() {
    }

    static int compress64k(byte[] src, int srcOff, int srcLen, byte[] dest, int destOff, int destEnd) {
        int srcEnd = srcOff + srcLen;
        int srcLimit = srcEnd - 5;
        int mflimit = srcEnd - 12;
        int sOff = srcOff;
        int dOff = destOff;
        int anchor = sOff++;
        if (srcLen >= 13) {
            short[] hashTable = new short[8192];
            block0: while (true) {
                int ref;
                int forwardOff = sOff;
                int step = 1;
                int searchMatchNb = 1 << LZ4Constants.SKIP_STRENGTH;
                do {
                    sOff = forwardOff;
                    if ((forwardOff += (step = searchMatchNb++ >>> LZ4Constants.SKIP_STRENGTH)) > mflimit) break block0;
                    int h = LZ4Utils.hash64k(SafeUtils.readInt(src, sOff));
                    ref = srcOff + SafeUtils.readShort(hashTable, h);
                    SafeUtils.writeShort(hashTable, h, sOff - srcOff);
                } while (!LZ4SafeUtils.readIntEquals(src, ref, sOff));
                int excess = LZ4SafeUtils.commonBytesBackward(src, ref, sOff, srcOff, anchor);
                ref -= excess;
                int runLen = (sOff -= excess) - anchor;
                int tokenOff = dOff++;
                if (dOff + runLen + 8 + (runLen >>> 8) > destEnd) {
                    throw new LZ4Exception("maxDestLen is too small");
                }
                if (runLen >= 15) {
                    SafeUtils.writeByte(dest, tokenOff, 240);
                    dOff = LZ4SafeUtils.writeLen(runLen - 15, dest, dOff);
                } else {
                    SafeUtils.writeByte(dest, tokenOff, runLen << 4);
                }
                LZ4SafeUtils.wildArraycopy(src, anchor, dest, dOff, runLen);
                dOff += runLen;
                while (true) {
                    SafeUtils.writeShortLE(dest, dOff, (short)(sOff - ref));
                    int matchLen = LZ4SafeUtils.commonBytes(src, ref += 4, sOff += 4, srcLimit);
                    if ((dOff += 2) + 6 + (matchLen >>> 8) > destEnd) {
                        throw new LZ4Exception("maxDestLen is too small");
                    }
                    sOff += matchLen;
                    if (matchLen >= 15) {
                        SafeUtils.writeByte(dest, tokenOff, SafeUtils.readByte(dest, tokenOff) | 0xF);
                        dOff = LZ4SafeUtils.writeLen(matchLen - 15, dest, dOff);
                    } else {
                        SafeUtils.writeByte(dest, tokenOff, SafeUtils.readByte(dest, tokenOff) | matchLen);
                    }
                    if (sOff > mflimit) {
                        anchor = sOff;
                        break block0;
                    }
                    SafeUtils.writeShort(hashTable, LZ4Utils.hash64k(SafeUtils.readInt(src, sOff - 2)), sOff - 2 - srcOff);
                    int h = LZ4Utils.hash64k(SafeUtils.readInt(src, sOff));
                    ref = srcOff + SafeUtils.readShort(hashTable, h);
                    SafeUtils.writeShort(hashTable, h, sOff - srcOff);
                    if (!LZ4SafeUtils.readIntEquals(src, sOff, ref)) break;
                    tokenOff = dOff++;
                    SafeUtils.writeByte(dest, tokenOff, 0);
                }
                anchor = sOff++;
            }
        }
        dOff = LZ4SafeUtils.lastLiterals(src, anchor, srcEnd - anchor, dest, dOff, destEnd);
        return dOff - destOff;
    }

    @Override
    public int compress(byte[] src, int srcOff, int srcLen, byte[] dest, int destOff, int maxDestLen) {
        SafeUtils.checkRange(src, srcOff, srcLen);
        SafeUtils.checkRange(dest, destOff, maxDestLen);
        int destEnd = destOff + maxDestLen;
        if (srcLen < 65547) {
            return LZ4JavaSafeCompressor.compress64k(src, srcOff, srcLen, dest, destOff, destEnd);
        }
        int srcEnd = srcOff + srcLen;
        int srcLimit = srcEnd - 5;
        int mflimit = srcEnd - 12;
        int sOff = srcOff;
        int dOff = destOff;
        int anchor = sOff++;
        int[] hashTable = new int[4096];
        Arrays.fill(hashTable, anchor);
        block0: while (true) {
            int ref;
            int back;
            int forwardOff = sOff;
            int step = 1;
            int searchMatchNb = 1 << LZ4Constants.SKIP_STRENGTH;
            do {
                sOff = forwardOff;
                if ((forwardOff += (step = searchMatchNb++ >>> LZ4Constants.SKIP_STRENGTH)) > mflimit) break block0;
                int h = LZ4Utils.hash(SafeUtils.readInt(src, sOff));
                ref = SafeUtils.readInt(hashTable, h);
                back = sOff - ref;
                SafeUtils.writeInt(hashTable, h, sOff);
            } while (back >= 65536 || !LZ4SafeUtils.readIntEquals(src, ref, sOff));
            int excess = LZ4SafeUtils.commonBytesBackward(src, ref, sOff, srcOff, anchor);
            ref -= excess;
            int runLen = (sOff -= excess) - anchor;
            int tokenOff = dOff++;
            if (dOff + runLen + 8 + (runLen >>> 8) > destEnd) {
                throw new LZ4Exception("maxDestLen is too small");
            }
            if (runLen >= 15) {
                SafeUtils.writeByte(dest, tokenOff, 240);
                dOff = LZ4SafeUtils.writeLen(runLen - 15, dest, dOff);
            } else {
                SafeUtils.writeByte(dest, tokenOff, runLen << 4);
            }
            LZ4SafeUtils.wildArraycopy(src, anchor, dest, dOff, runLen);
            dOff += runLen;
            while (true) {
                SafeUtils.writeShortLE(dest, dOff, back);
                int matchLen = LZ4SafeUtils.commonBytes(src, ref + 4, sOff += 4, srcLimit);
                if ((dOff += 2) + 6 + (matchLen >>> 8) > destEnd) {
                    throw new LZ4Exception("maxDestLen is too small");
                }
                sOff += matchLen;
                if (matchLen >= 15) {
                    SafeUtils.writeByte(dest, tokenOff, SafeUtils.readByte(dest, tokenOff) | 0xF);
                    dOff = LZ4SafeUtils.writeLen(matchLen - 15, dest, dOff);
                } else {
                    SafeUtils.writeByte(dest, tokenOff, SafeUtils.readByte(dest, tokenOff) | matchLen);
                }
                if (sOff > mflimit) {
                    anchor = sOff;
                    break block0;
                }
                SafeUtils.writeInt(hashTable, LZ4Utils.hash(SafeUtils.readInt(src, sOff - 2)), sOff - 2);
                int h = LZ4Utils.hash(SafeUtils.readInt(src, sOff));
                ref = SafeUtils.readInt(hashTable, h);
                SafeUtils.writeInt(hashTable, h, sOff);
                back = sOff - ref;
                if (back >= 65536 || !LZ4SafeUtils.readIntEquals(src, ref, sOff)) break;
                tokenOff = dOff++;
                SafeUtils.writeByte(dest, tokenOff, 0);
            }
            anchor = sOff++;
        }
        dOff = LZ4SafeUtils.lastLiterals(src, anchor, srcEnd - anchor, dest, dOff, destEnd);
        return dOff - destOff;
    }

    static int compress64k(ByteBuffer src, int srcOff, int srcLen, ByteBuffer dest, int destOff, int destEnd) {
        int srcEnd = srcOff + srcLen;
        int srcLimit = srcEnd - 5;
        int mflimit = srcEnd - 12;
        int sOff = srcOff;
        int dOff = destOff;
        int anchor = sOff++;
        if (srcLen >= 13) {
            short[] hashTable = new short[8192];
            block0: while (true) {
                int ref;
                int forwardOff = sOff;
                int step = 1;
                int searchMatchNb = 1 << LZ4Constants.SKIP_STRENGTH;
                do {
                    sOff = forwardOff;
                    if ((forwardOff += (step = searchMatchNb++ >>> LZ4Constants.SKIP_STRENGTH)) > mflimit) break block0;
                    int h = LZ4Utils.hash64k(ByteBufferUtils.readInt(src, sOff));
                    ref = srcOff + SafeUtils.readShort(hashTable, h);
                    SafeUtils.writeShort(hashTable, h, sOff - srcOff);
                } while (!LZ4ByteBufferUtils.readIntEquals(src, ref, sOff));
                int excess = LZ4ByteBufferUtils.commonBytesBackward(src, ref, sOff, srcOff, anchor);
                ref -= excess;
                int runLen = (sOff -= excess) - anchor;
                int tokenOff = dOff++;
                if (dOff + runLen + 8 + (runLen >>> 8) > destEnd) {
                    throw new LZ4Exception("maxDestLen is too small");
                }
                if (runLen >= 15) {
                    ByteBufferUtils.writeByte(dest, tokenOff, 240);
                    dOff = LZ4ByteBufferUtils.writeLen(runLen - 15, dest, dOff);
                } else {
                    ByteBufferUtils.writeByte(dest, tokenOff, runLen << 4);
                }
                LZ4ByteBufferUtils.wildArraycopy(src, anchor, dest, dOff, runLen);
                dOff += runLen;
                while (true) {
                    ByteBufferUtils.writeShortLE(dest, dOff, (short)(sOff - ref));
                    int matchLen = LZ4ByteBufferUtils.commonBytes(src, ref += 4, sOff += 4, srcLimit);
                    if ((dOff += 2) + 6 + (matchLen >>> 8) > destEnd) {
                        throw new LZ4Exception("maxDestLen is too small");
                    }
                    sOff += matchLen;
                    if (matchLen >= 15) {
                        ByteBufferUtils.writeByte(dest, tokenOff, ByteBufferUtils.readByte(dest, tokenOff) | 0xF);
                        dOff = LZ4ByteBufferUtils.writeLen(matchLen - 15, dest, dOff);
                    } else {
                        ByteBufferUtils.writeByte(dest, tokenOff, ByteBufferUtils.readByte(dest, tokenOff) | matchLen);
                    }
                    if (sOff > mflimit) {
                        anchor = sOff;
                        break block0;
                    }
                    SafeUtils.writeShort(hashTable, LZ4Utils.hash64k(ByteBufferUtils.readInt(src, sOff - 2)), sOff - 2 - srcOff);
                    int h = LZ4Utils.hash64k(ByteBufferUtils.readInt(src, sOff));
                    ref = srcOff + SafeUtils.readShort(hashTable, h);
                    SafeUtils.writeShort(hashTable, h, sOff - srcOff);
                    if (!LZ4ByteBufferUtils.readIntEquals(src, sOff, ref)) break;
                    tokenOff = dOff++;
                    ByteBufferUtils.writeByte(dest, tokenOff, 0);
                }
                anchor = sOff++;
            }
        }
        dOff = LZ4ByteBufferUtils.lastLiterals(src, anchor, srcEnd - anchor, dest, dOff, destEnd);
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
        int destEnd = destOff + maxDestLen;
        if (srcLen < 65547) {
            return LZ4JavaSafeCompressor.compress64k(src, srcOff, srcLen, dest, destOff, destEnd);
        }
        int srcEnd = srcOff + srcLen;
        int srcLimit = srcEnd - 5;
        int mflimit = srcEnd - 12;
        int sOff = srcOff;
        int dOff = destOff;
        int anchor = sOff++;
        int[] hashTable = new int[4096];
        Arrays.fill(hashTable, anchor);
        block0: while (true) {
            int ref;
            int back;
            int forwardOff = sOff;
            int step = 1;
            int searchMatchNb = 1 << LZ4Constants.SKIP_STRENGTH;
            do {
                sOff = forwardOff;
                if ((forwardOff += (step = searchMatchNb++ >>> LZ4Constants.SKIP_STRENGTH)) > mflimit) break block0;
                int h = LZ4Utils.hash(ByteBufferUtils.readInt(src, sOff));
                ref = SafeUtils.readInt(hashTable, h);
                back = sOff - ref;
                SafeUtils.writeInt(hashTable, h, sOff);
            } while (back >= 65536 || !LZ4ByteBufferUtils.readIntEquals(src, ref, sOff));
            int excess = LZ4ByteBufferUtils.commonBytesBackward(src, ref, sOff, srcOff, anchor);
            ref -= excess;
            int runLen = (sOff -= excess) - anchor;
            int tokenOff = dOff++;
            if (dOff + runLen + 8 + (runLen >>> 8) > destEnd) {
                throw new LZ4Exception("maxDestLen is too small");
            }
            if (runLen >= 15) {
                ByteBufferUtils.writeByte(dest, tokenOff, 240);
                dOff = LZ4ByteBufferUtils.writeLen(runLen - 15, dest, dOff);
            } else {
                ByteBufferUtils.writeByte(dest, tokenOff, runLen << 4);
            }
            LZ4ByteBufferUtils.wildArraycopy(src, anchor, dest, dOff, runLen);
            dOff += runLen;
            while (true) {
                ByteBufferUtils.writeShortLE(dest, dOff, back);
                int matchLen = LZ4ByteBufferUtils.commonBytes(src, ref + 4, sOff += 4, srcLimit);
                if ((dOff += 2) + 6 + (matchLen >>> 8) > destEnd) {
                    throw new LZ4Exception("maxDestLen is too small");
                }
                sOff += matchLen;
                if (matchLen >= 15) {
                    ByteBufferUtils.writeByte(dest, tokenOff, ByteBufferUtils.readByte(dest, tokenOff) | 0xF);
                    dOff = LZ4ByteBufferUtils.writeLen(matchLen - 15, dest, dOff);
                } else {
                    ByteBufferUtils.writeByte(dest, tokenOff, ByteBufferUtils.readByte(dest, tokenOff) | matchLen);
                }
                if (sOff > mflimit) {
                    anchor = sOff;
                    break block0;
                }
                SafeUtils.writeInt(hashTable, LZ4Utils.hash(ByteBufferUtils.readInt(src, sOff - 2)), sOff - 2);
                int h = LZ4Utils.hash(ByteBufferUtils.readInt(src, sOff));
                ref = SafeUtils.readInt(hashTable, h);
                SafeUtils.writeInt(hashTable, h, sOff);
                back = sOff - ref;
                if (back >= 65536 || !LZ4ByteBufferUtils.readIntEquals(src, ref, sOff)) break;
                tokenOff = dOff++;
                ByteBufferUtils.writeByte(dest, tokenOff, 0);
            }
            anchor = sOff++;
        }
        dOff = LZ4ByteBufferUtils.lastLiterals(src, anchor, srcEnd - anchor, dest, dOff, destEnd);
        return dOff - destOff;
    }
}

