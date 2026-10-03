/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.buffer;

import net.sf.kdgcommons.buffer.MappedFileBuffer;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MappedFileBufferThreadLocal
extends ThreadLocal<MappedFileBuffer> {
    private MappedFileBuffer _src;

    public MappedFileBufferThreadLocal(MappedFileBuffer mappedFileBuffer) {
        this._src = mappedFileBuffer;
    }

    @Override
    protected synchronized MappedFileBuffer initialValue() {
        return this._src.clone();
    }
}

