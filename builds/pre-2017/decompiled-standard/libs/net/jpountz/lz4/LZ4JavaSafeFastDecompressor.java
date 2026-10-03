/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.nio.ByteBuffer;
import net.jpountz.lz4.LZ4ByteBufferUtils;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4FastDecompressor;
import net.jpountz.lz4.LZ4SafeUtils;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;

final class LZ4JavaSafeFastDecompressor
extends LZ4FastDecompressor {
    public static final LZ4FastDecompressor INSTANCE = new LZ4JavaSafeFastDecompressor();

    LZ4JavaSafeFastDecompressor() {
    }

    @Override
    public int decompress(byte[] src, int srcOff, byte[] dest, int destOff, int destLen) {
        int literalCopyEnd;
        int literalLen;
        SafeUtils.checkRange(src, srcOff);
        SafeUtils.checkRange(dest, destOff, destLen);
        if (destLen == 0) {
            if (SafeUtils.readByte(src, srcOff) != 0) {
                throw new LZ4Exception("Malformed input at " + srcOff);
            }
            return 1;
        }
        int destEnd = destOff + destLen;
        int sOff = srcOff;
        int dOff = destOff;
        while (true) {
            int matchCopyEnd;
            int token = SafeUtils.readByte(src, sOff) & 0xFF;
            ++sOff;
            literalLen = token >>> 4;
            if (literalLen == 15) {
                int len = -1;
                while (true) {
                    byte by = SafeUtils.readByte(src, sOff++);
                    len = by;
                    if (by != -1) break;
                    literalLen += 255;
                }
                literalLen += len & 0xFF;
            }
            if ((literalCopyEnd = dOff + literalLen) > destEnd - 8) {
                if (literalCopyEnd != destEnd) {
                    throw new LZ4Exception("Malformed input at " + sOff);
                }
                break;
            }
            LZ4SafeUtils.wildArraycopy(src, sOff, dest, dOff, literalLen);
            dOff = literalCopyEnd;
            int matchDec = SafeUtils.readShortLE(src, sOff += literalLen);
            sOff += 2;
            int matchOff = dOff - matchDec;
            if (matchOff < destOff) {
                throw new LZ4Exception("Malformed input at " + sOff);
            }
            int matchLen = token & 0xF;
            if (matchLen == 15) {
                int len = -1;
                while (true) {
                    byte by = SafeUtils.readByte(src, sOff++);
                    len = by;
                    if (by != -1) break;
                    matchLen += 255;
                }
                matchLen += len & 0xFF;
            }
            if ((matchCopyEnd = dOff + (matchLen += 4)) > destEnd - 8) {
                if (matchCopyEnd > destEnd) {
                    throw new LZ4Exception("Malformed input at " + sOff);
                }
                LZ4SafeUtils.safeIncrementalCopy(dest, matchOff, dOff, matchLen);
            } else {
                LZ4SafeUtils.wildIncrementalCopy(dest, matchOff, dOff, matchCopyEnd);
            }
            dOff = matchCopyEnd;
        }
        LZ4SafeUtils.safeArraycopy(src, sOff, dest, dOff, literalLen);
        dOff = literalCopyEnd;
        return (sOff += literalLen) - srcOff;
    }

    @Override
    public int decompress(ByteBuffer src, int srcOff, ByteBuffer dest, int destOff, int destLen) {
        int literalCopyEnd;
        int literalLen;
        if (src.hasArray() && dest.hasArray()) {
            return this.decompress(src.array(), srcOff + src.arrayOffset(), dest.array(), destOff + dest.arrayOffset(), destLen);
        }
        src = ByteBufferUtils.inNativeByteOrder(src);
        dest = ByteBufferUtils.inNativeByteOrder(dest);
        ByteBufferUtils.checkRange(src, srcOff);
        ByteBufferUtils.checkRange(dest, destOff, destLen);
        if (destLen == 0) {
            if (ByteBufferUtils.readByte(src, srcOff) != 0) {
                throw new LZ4Exception("Malformed input at " + srcOff);
            }
            return 1;
        }
        int destEnd = destOff + destLen;
        int sOff = srcOff;
        int dOff = destOff;
        while (true) {
            int matchCopyEnd;
            int token = ByteBufferUtils.readByte(src, sOff) & 0xFF;
            ++sOff;
            literalLen = token >>> 4;
            if (literalLen == 15) {
                int len = -1;
                while (true) {
                    byte by = ByteBufferUtils.readByte(src, sOff++);
                    len = by;
                    if (by != -1) break;
                    literalLen += 255;
                }
                literalLen += len & 0xFF;
            }
            if ((literalCopyEnd = dOff + literalLen) > destEnd - 8) {
                if (literalCopyEnd != destEnd) {
                    throw new LZ4Exception("Malformed input at " + sOff);
                }
                break;
            }
            LZ4ByteBufferUtils.wildArraycopy(src, sOff, dest, dOff, literalLen);
            dOff = literalCopyEnd;
            int matchDec = ByteBufferUtils.readShortLE(src, sOff += literalLen);
            sOff += 2;
            int matchOff = dOff - matchDec;
            if (matchOff < destOff) {
                throw new LZ4Exception("Malformed input at " + sOff);
            }
            int matchLen = token & 0xF;
            if (matchLen == 15) {
                int len = -1;
                while (true) {
                    byte by = ByteBufferUtils.readByte(src, sOff++);
                    len = by;
                    if (by != -1) break;
                    matchLen += 255;
                }
                matchLen += len & 0xFF;
            }
            if ((matchCopyEnd = dOff + (matchLen += 4)) > destEnd - 8) {
                if (matchCopyEnd > destEnd) {
                    throw new LZ4Exception("Malformed input at " + sOff);
                }
                LZ4ByteBufferUtils.safeIncrementalCopy(dest, matchOff, dOff, matchLen);
            } else {
                LZ4ByteBufferUtils.wildIncrementalCopy(dest, matchOff, dOff, matchCopyEnd);
            }
            dOff = matchCopyEnd;
        }
        LZ4ByteBufferUtils.safeArraycopy(src, sOff, dest, dOff, literalLen);
        dOff = literalCopyEnd;
        return (sOff += literalLen) - srcOff;
    }
}

