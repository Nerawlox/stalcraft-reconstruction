/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.buffer;

import java.nio.ByteBuffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ByteBufferThreadLocal
extends ThreadLocal<ByteBuffer> {
    private ByteBuffer _src;

    public ByteBufferThreadLocal(ByteBuffer byteBuffer) {
        this._src = byteBuffer;
    }

    @Override
    protected synchronized ByteBuffer initialValue() {
        return this._src.duplicate();
    }
}

