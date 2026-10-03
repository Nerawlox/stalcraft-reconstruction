/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.security.MessageDigest;
import javax.annotation.Nullable;

@Beta
public abstract class HashCode {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    HashCode() {
    }

    public abstract int asInt();

    public abstract long asLong();

    public abstract long padToLong();

    public abstract byte[] asBytes();

    public int writeBytesTo(byte[] dest, int offset, int maxLength) {
        byte[] hash = this.asBytes();
        maxLength = Ints.min(maxLength, hash.length);
        Preconditions.checkPositionIndexes(offset, offset + maxLength, dest.length);
        System.arraycopy(hash, 0, dest, offset, maxLength);
        return maxLength;
    }

    public abstract int bits();

    public boolean equals(@Nullable Object object) {
        if (object instanceof HashCode) {
            HashCode that = (HashCode)object;
            return MessageDigest.isEqual(this.asBytes(), that.asBytes());
        }
        return false;
    }

    public int hashCode() {
        return this.asInt();
    }

    public String toString() {
        byte[] bytes = this.asBytes();
        StringBuilder sb = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            sb.append(hexDigits[b >> 4 & 0xF]).append(hexDigits[b & 0xF]);
        }
        return sb.toString();
    }
}

