/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.buffer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

public class ByteBufferOutputStream
extends OutputStream {
    private ByteBuffer _buf;
    private boolean _isClosed;

    public ByteBufferOutputStream(ByteBuffer byteBuffer) {
        this(byteBuffer, 0);
    }

    public ByteBufferOutputStream(ByteBuffer byteBuffer, int n) {
        this._buf = byteBuffer;
        this._buf.position(n);
    }

    public void close() throws IOException {
        this._isClosed = true;
    }

    public void flush() throws IOException {
        if (this._buf instanceof MappedByteBuffer) {
            ((MappedByteBuffer)this._buf).force();
        }
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (this._isClosed) {
            throw new IOException("buffer is closed");
        }
        if (n2 > this._buf.remaining()) {
            throw new IOException("write too large: " + n2 + " bytes, " + this._buf.remaining() + " remaining in buffer");
        }
        this._buf.put(byArray, n, n2);
    }

    public void write(byte[] byArray) throws IOException {
        this.write(byArray, 0, byArray.length);
    }

    public void write(int n) throws IOException {
        if (this._isClosed) {
            throw new IOException("buffer is closed");
        }
        if (this._buf.remaining() == 0) {
            throw new IOException("no space left in buffer");
        }
        this._buf.put((byte)n);
    }
}

