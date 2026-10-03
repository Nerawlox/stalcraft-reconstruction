/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.primitives.UnsignedInts;
import java.io.Serializable;

@Beta
public final class HashCodes {
    private HashCodes() {
    }

    public static HashCode fromInt(int hash) {
        return new IntHashCode(hash);
    }

    public static HashCode fromLong(long hash) {
        return new LongHashCode(hash);
    }

    public static HashCode fromBytes(byte[] bytes) {
        Preconditions.checkArgument(bytes.length >= 1, "A HashCode must contain at least 1 byte.");
        return HashCodes.fromBytesNoCopy((byte[])bytes.clone());
    }

    static HashCode fromBytesNoCopy(byte[] bytes) {
        return new BytesHashCode(bytes);
    }

    private static final class BytesHashCode
    extends HashCode
    implements Serializable {
        final byte[] bytes;
        private static final long serialVersionUID = 0L;

        BytesHashCode(byte[] bytes) {
            this.bytes = Preconditions.checkNotNull(bytes);
        }

        @Override
        public int bits() {
            return this.bytes.length * 8;
        }

        @Override
        public byte[] asBytes() {
            return (byte[])this.bytes.clone();
        }

        @Override
        public int asInt() {
            Preconditions.checkState(this.bytes.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", this.bytes.length);
            return this.bytes[0] & 0xFF | (this.bytes[1] & 0xFF) << 8 | (this.bytes[2] & 0xFF) << 16 | (this.bytes[3] & 0xFF) << 24;
        }

        @Override
        public long asLong() {
            Preconditions.checkState(this.bytes.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", this.bytes.length);
            return (long)this.bytes[0] & 0xFFL | ((long)this.bytes[1] & 0xFFL) << 8 | ((long)this.bytes[2] & 0xFFL) << 16 | ((long)this.bytes[3] & 0xFFL) << 24 | ((long)this.bytes[4] & 0xFFL) << 32 | ((long)this.bytes[5] & 0xFFL) << 40 | ((long)this.bytes[6] & 0xFFL) << 48 | ((long)this.bytes[7] & 0xFFL) << 56;
        }

        @Override
        public long padToLong() {
            return this.bytes.length < 8 ? UnsignedInts.toLong(this.asInt()) : this.asLong();
        }

        @Override
        public int hashCode() {
            if (this.bytes.length >= 4) {
                return this.asInt();
            }
            int val = this.bytes[0] & 0xFF;
            for (int i = 1; i < this.bytes.length; ++i) {
                val |= (this.bytes[i] & 0xFF) << i * 8;
            }
            return val;
        }
    }

    private static final class LongHashCode
    extends HashCode
    implements Serializable {
        final long hash;
        private static final long serialVersionUID = 0L;

        LongHashCode(long hash) {
            this.hash = hash;
        }

        @Override
        public int bits() {
            return 64;
        }

        @Override
        public byte[] asBytes() {
            return new byte[]{(byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24), (byte)(this.hash >> 32), (byte)(this.hash >> 40), (byte)(this.hash >> 48), (byte)(this.hash >> 56)};
        }

        @Override
        public int asInt() {
            return (int)this.hash;
        }

        @Override
        public long asLong() {
            return this.hash;
        }

        @Override
        public long padToLong() {
            return this.hash;
        }
    }

    private static final class IntHashCode
    extends HashCode
    implements Serializable {
        final int hash;
        private static final long serialVersionUID = 0L;

        IntHashCode(int hash) {
            this.hash = hash;
        }

        @Override
        public int bits() {
            return 32;
        }

        @Override
        public byte[] asBytes() {
            return new byte[]{(byte)this.hash, (byte)(this.hash >> 8), (byte)(this.hash >> 16), (byte)(this.hash >> 24)};
        }

        @Override
        public int asInt() {
            return this.hash;
        }

        @Override
        public long asLong() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override
        public long padToLong() {
            return UnsignedInts.toLong(this.hash);
        }
    }
}

