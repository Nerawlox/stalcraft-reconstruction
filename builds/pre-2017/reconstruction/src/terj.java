/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class terj
extends InputStream {
    private final ByteBuffer _a;

    public terj(ByteBuffer byteBuffer) {
        this._a = byteBuffer;
    }

    @Override
    public int read() throws IOException {
        if (!this._a.hasRemaining()) {
            return -1;
        }
        return this._a.get() & 0xFF;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) throws IOException {
        if (!this._a.hasRemaining()) {
            return -1;
        }
        n2 = Math.min(n2, this._a.remaining());
        this._a.get(byArray, n, n2);
        return n2;
    }

    @Override
    public long skip(long l) throws IOException {
        if (l > Integer.MAX_VALUE) {
            throw new IOException("Can not skip more than 2 GB");
        }
        int n = Math.min(this._a.remaining(), (int)l);
        this._a.position(this._a.position() + n);
        return n;
    }
}

