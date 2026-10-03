/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;
import net.jpountz.xxhash.XXHash64;

final class XXHash64JavaSafe
extends XXHash64 {
    public static final XXHash64 INSTANCE = new XXHash64JavaSafe();

    XXHash64JavaSafe() {
    }

    @Override
    public long hash(byte[] buf, int off, int len, long seed) {
        long h64;
        SafeUtils.checkRange(buf, off, len);
        int end = off + len;
        if (len >= 32) {
            int limit = end - 32;
            long v1 = seed + -7046029288634856825L + -4417276706812531889L;
            long v2 = seed + -4417276706812531889L;
            long v3 = seed + 0L;
            long v4 = seed - -7046029288634856825L;
            do {
                v1 += SafeUtils.readLongLE(buf, off) * -4417276706812531889L;
                v1 = Long.rotateLeft(v1, 31);
                v1 *= -7046029288634856825L;
                v2 += SafeUtils.readLongLE(buf, off += 8) * -4417276706812531889L;
                v2 = Long.rotateLeft(v2, 31);
                v2 *= -7046029288634856825L;
                v3 += SafeUtils.readLongLE(buf, off += 8) * -4417276706812531889L;
                v3 = Long.rotateLeft(v3, 31);
                v3 *= -7046029288634856825L;
                v4 += SafeUtils.readLongLE(buf, off += 8) * -4417276706812531889L;
                v4 = Long.rotateLeft(v4, 31);
                v4 *= -7046029288634856825L;
            } while ((off += 8) <= limit);
            h64 = Long.rotateLeft(v1, 1) + Long.rotateLeft(v2, 7) + Long.rotateLeft(v3, 12) + Long.rotateLeft(v4, 18);
            v1 *= -4417276706812531889L;
            v1 = Long.rotateLeft(v1, 31);
            h64 ^= (v1 *= -7046029288634856825L);
            h64 = h64 * -7046029288634856825L + -8796714831421723037L;
            v2 *= -4417276706812531889L;
            v2 = Long.rotateLeft(v2, 31);
            h64 ^= (v2 *= -7046029288634856825L);
            h64 = h64 * -7046029288634856825L + -8796714831421723037L;
            v3 *= -4417276706812531889L;
            v3 = Long.rotateLeft(v3, 31);
            h64 ^= (v3 *= -7046029288634856825L);
            h64 = h64 * -7046029288634856825L + -8796714831421723037L;
            v4 *= -4417276706812531889L;
            v4 = Long.rotateLeft(v4, 31);
            h64 ^= (v4 *= -7046029288634856825L);
            h64 = h64 * -7046029288634856825L + -8796714831421723037L;
        } else {
            h64 = seed + 2870177450012600261L;
        }
        h64 += (long)len;
        while (off <= end - 8) {
            long k1 = SafeUtils.readLongLE(buf, off);
            k1 *= -4417276706812531889L;
            k1 = Long.rotateLeft(k1, 31);
            h64 ^= (k1 *= -7046029288634856825L);
            h64 = Long.rotateLeft(h64, 27) * -7046029288634856825L + -8796714831421723037L;
            off += 8;
        }
        if (off <= end - 4) {
            h64 ^= ((long)SafeUtils.readIntLE(buf, off) & 0xFFFFFFFFL) * -7046029288634856825L;
            h64 = Long.rotateLeft(h64, 23) * -4417276706812531889L + 1609587929392839161L;
            off += 4;
        }
        while (off < end) {
            h64 ^= (long)(SafeUtils.readByte(buf, off) & 0xFF) * 2870177450012600261L;
            h64 = Long.rotateLeft(h64, 11) * -7046029288634856825L;
            ++off;
        }
        h64 ^= h64 >>> 33;
        h64 *= -4417276706812531889L;
        h64 ^= h64 >>> 29;
        h64 *= 1609587929392839161L;
        h64 ^= h64 >>> 32;
        return h64;
    }

    @Override
    public long hash(ByteBuffer buf, int off, int len, long seed) {
        long h64;
        if (buf.hasArray()) {
            return this.hash(buf.array(), off + buf.arrayOffset(), len, seed);
        }
        ByteBufferUtils.checkRange(buf, off, len);
        buf = ByteBufferUtils.inLittleEndianOrder(buf);
        int end = off + len;
        if (len >= 32) {
            int limit = end - 32;
            long v1 = seed + -7046029288634856825L + -4417276706812531889L;
            long v2 = seed + -4417276706812531889L;
            long v3 = seed + 0L;
            long v4 = seed - -7046029288634856825L;
            do {
                v1 += ByteBufferUtils.readLongLE(buf, off) * -4417276706812531889L;
                v1 = Long.rotateLeft(v1, 31);
                v1 *= -7046029288634856825L;
                v2 += ByteBufferUtils.readLongLE(buf, off += 8) * -4417276706812531889L;
                v2 = Long.rotateLeft(v2, 31);
                v2 *= -7046029288634856825L;
                v3 += ByteBufferUtils.readLongLE(buf, off += 8) * -4417276706812531889L;
                v3 = Long.rotateLeft(v3, 31);
                v3 *= -7046029288634856825L;
                v4 += ByteBufferUtils.readLongLE(buf, off += 8) * -4417276706812531889L;
                v4 = Long.rotateLeft(v4, 31);
                v4 *= -7046029288634856825L;
            } while ((off += 8) <= limit);
            h64 = Long.rotateLeft(v1, 1) + Long.rotateLeft(v2, 7) + Long.rotateLeft(v3, 12) + Long.rotateLeft(v4, 18);
            v1 *= -4417276706812531889L;
            v1 = Long.rotateLeft(v1, 31);
            h64 ^= (v1 *= -7046029288634856825L);
            h64 = h64 * -7046029288634856825L + -8796714831421723037L;
            v2 *= -4417276706812531889L;
            v2 = Long.rotateLeft(v2, 31);
            h64 ^= (v2 *= -7046029288634856825L);
            h64 = h64 * -7046029288634856825L + -8796714831421723037L;
            v3 *= -4417276706812531889L;
            v3 = Long.rotateLeft(v3, 31);
            h64 ^= (v3 *= -7046029288634856825L);
            h64 = h64 * -7046029288634856825L + -8796714831421723037L;
            v4 *= -4417276706812531889L;
            v4 = Long.rotateLeft(v4, 31);
            h64 ^= (v4 *= -7046029288634856825L);
            h64 = h64 * -7046029288634856825L + -8796714831421723037L;
        } else {
            h64 = seed + 2870177450012600261L;
        }
        h64 += (long)len;
        while (off <= end - 8) {
            long k1 = ByteBufferUtils.readLongLE(buf, off);
            k1 *= -4417276706812531889L;
            k1 = Long.rotateLeft(k1, 31);
            h64 ^= (k1 *= -7046029288634856825L);
            h64 = Long.rotateLeft(h64, 27) * -7046029288634856825L + -8796714831421723037L;
            off += 8;
        }
        if (off <= end - 4) {
            h64 ^= ((long)ByteBufferUtils.readIntLE(buf, off) & 0xFFFFFFFFL) * -7046029288634856825L;
            h64 = Long.rotateLeft(h64, 23) * -4417276706812531889L + 1609587929392839161L;
            off += 4;
        }
        while (off < end) {
            h64 ^= (long)(ByteBufferUtils.readByte(buf, off) & 0xFF) * 2870177450012600261L;
            h64 = Long.rotateLeft(h64, 11) * -7046029288634856825L;
            ++off;
        }
        h64 ^= h64 >>> 33;
        h64 *= -4417276706812531889L;
        h64 ^= h64 >>> 29;
        h64 *= 1609587929392839161L;
        h64 ^= h64 >>> 32;
        return h64;
    }
}

