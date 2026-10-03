/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;
import net.jpountz.xxhash.XXHash64;
import net.jpountz.xxhash.XXHashFactory;
import net.jpountz.xxhash.XXHashJNI;

final class XXHash64JNI
extends XXHash64 {
    public static final XXHash64 INSTANCE = new XXHash64JNI();
    private static XXHash64 SAFE_INSTANCE;

    XXHash64JNI() {
    }

    @Override
    public long hash(byte[] buf, int off, int len, long seed) {
        SafeUtils.checkRange(buf, off, len);
        return XXHashJNI.XXH64(buf, off, len, seed);
    }

    @Override
    public long hash(ByteBuffer buf, int off, int len, long seed) {
        if (buf.isDirect()) {
            ByteBufferUtils.checkRange(buf, off, len);
            return XXHashJNI.XXH64BB(buf, off, len, seed);
        }
        if (buf.hasArray()) {
            return this.hash(buf.array(), off + buf.arrayOffset(), len, seed);
        }
        XXHash64 safeInstance = SAFE_INSTANCE;
        if (safeInstance == null) {
            safeInstance = SAFE_INSTANCE = XXHashFactory.safeInstance().hash64();
        }
        return safeInstance.hash(buf, off, len, seed);
    }
}

