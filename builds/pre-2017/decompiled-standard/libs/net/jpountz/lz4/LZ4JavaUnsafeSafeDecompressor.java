/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.nio.ByteBuffer;
import net.jpountz.lz4.LZ4ByteBufferUtils;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4SafeDecompressor;
import net.jpountz.lz4.LZ4UnsafeUtils;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.UnsafeUtils;

final class LZ4JavaUnsafeSafeDecompressor
extends LZ4SafeDecompressor {
    public static final LZ4SafeDecompressor INSTANCE = new LZ4JavaUnsafeSafeDecompressor();

    LZ4JavaUnsafeSafeDecompressor() {
    }

    @Override
    public int decompress(byte[] src, int srcOff, int srcLen, byte[] dest, int destOff, int destLen) {
        int literalCopyEnd;
        UnsafeUtils.checkRange(src, srcOff, srcLen);
        UnsafeUtils.checkRange(dest, destOff, destLen);
        if (destLen == 0) {
            if (srcLen != 1 || UnsafeUtils.readByte(src, srcOff) != 0) {
                throw new LZ4Exception("Output buffer too small");
            }
            return 0;
        }
        int srcEnd = srcOff + srcLen;
        int destEnd = destOff + destLen;
        int sOff = srcOff;
        int dOff = destOff;
        while (true) {
            int matchCopyEnd;
            int token = UnsafeUtils.readByte(src, sOff) & 0xFF;
            ++sOff;
            int literalLen = token >>> 4;
            if (literalLen == 15) {
                int len = -1;
                while (sOff < srcEnd) {
                    byte by = UnsafeUtils.readByte(src, sOff++);
                    len = by;
                    if (by != -1) break;
                    literalLen += 255;
                }
                literalLen += len & 0xFF;
            }
            if ((literalCopyEnd = dOff + literalLen) > destEnd - 8 || sOff + literalLen > srcEnd - 8) {
                if (literalCopyEnd > destEnd) {
                    throw new LZ4Exception();
                }
                if (sOff + literalLen != srcEnd) {
                    throw new LZ4Exception("Malformed input at " + sOff);
                }
                LZ4UnsafeUtils.safeArraycopy(src, sOff, dest, dOff, literalLen);
                sOff += literalLen;
                break;
            }
            LZ4UnsafeUtils.wildArraycopy(src, sOff, dest, dOff, literalLen);
            dOff = literalCopyEnd;
            int matchDec = UnsafeUtils.readShortLE(src, sOff += literalLen);
            sOff += 2;
            int matchOff = dOff - matchDec;
            if (matchOff < destOff) {
                throw new LZ4Exception("Malformed input at " + sOff);
            }
            int matchLen = token & 0xF;
            if (matchLen == 15) {
                int len = -1;
                while (sOff < srcEnd) {
                    byte by = UnsafeUtils.readByte(src, sOff++);
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
                LZ4UnsafeUtils.safeIncrementalCopy(dest, matchOff, dOff, matchLen);
            } else {
                LZ4UnsafeUtils.wildIncrementalCopy(dest, matchOff, dOff, matchCopyEnd);
            }
            dOff = matchCopyEnd;
        }
        dOff = literalCopyEnd;
        return dOff - destOff;
    }

    @Override
    public int decompress(ByteBuffer src, int srcOff, int srcLen, ByteBuffer dest, int destOff, int destLen) {
        int literalCopyEnd;
        if (src.hasArray() && dest.hasArray()) {
            return this.decompress(src.array(), srcOff + src.arrayOffset(), srcLen, dest.array(), destOff + dest.arrayOffset(), destLen);
        }
        src = ByteBufferUtils.inNativeByteOrder(src);
        dest = ByteBufferUtils.inNativeByteOrder(dest);
        ByteBufferUtils.checkRange(src, srcOff, srcLen);
        ByteBufferUtils.checkRange(dest, destOff, destLen);
        if (destLen == 0) {
            if (srcLen != 1 || ByteBufferUtils.readByte(src, srcOff) != 0) {
                throw new LZ4Exception("Output buffer too small");
            }
            return 0;
        }
        int srcEnd = srcOff + srcLen;
        int destEnd = destOff + destLen;
        int sOff = srcOff;
        int dOff = destOff;
        while (true) {
            int matchCopyEnd;
            int token = ByteBufferUtils.readByte(src, sOff) & 0xFF;
            ++sOff;
            int literalLen = token >>> 4;
            if (literalLen == 15) {
                int len = -1;
                while (sOff < srcEnd) {
                    byte by = ByteBufferUtils.readByte(src, sOff++);
                    len = by;
                    if (by != -1) break;
                    literalLen += 255;
                }
                literalLen += len & 0xFF;
            }
            if ((literalCopyEnd = dOff + literalLen) > destEnd - 8 || sOff + literalLen > srcEnd - 8) {
                if (literalCopyEnd > destEnd) {
                    throw new LZ4Exception();
                }
                if (sOff + literalLen != srcEnd) {
                    throw new LZ4Exception("Malformed input at " + sOff);
                }
                LZ4ByteBufferUtils.safeArraycopy(src, sOff, dest, dOff, literalLen);
                sOff += literalLen;
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
                while (sOff < srcEnd) {
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
        dOff = literalCopyEnd;
        return dOff - destOff;
    }
}

