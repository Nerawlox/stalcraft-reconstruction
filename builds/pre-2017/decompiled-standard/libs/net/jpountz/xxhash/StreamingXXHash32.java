/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import java.util.zip.Checksum;

public abstract class StreamingXXHash32 {
    final int seed;

    StreamingXXHash32(int seed) {
        this.seed = seed;
    }

    public abstract int getValue();

    public abstract void update(byte[] var1, int var2, int var3);

    public abstract void reset();

    public String toString() {
        return this.getClass().getSimpleName() + "(seed=" + this.seed + ")";
    }

    public final Checksum asChecksum() {
        return new Checksum(){

            @Override
            public long getValue() {
                return (long)StreamingXXHash32.this.getValue() & 0xFFFFFFFL;
            }

            @Override
            public void reset() {
                StreamingXXHash32.this.reset();
            }

            @Override
            public void update(int b) {
                StreamingXXHash32.this.update(new byte[]{(byte)b}, 0, 1);
            }

            @Override
            public void update(byte[] b, int off, int len) {
                StreamingXXHash32.this.update(b, off, len);
            }

            public String toString() {
                return StreamingXXHash32.this.toString();
            }
        };
    }

    static interface Factory {
        public StreamingXXHash32 newStreamingHash(int var1);
    }
}

