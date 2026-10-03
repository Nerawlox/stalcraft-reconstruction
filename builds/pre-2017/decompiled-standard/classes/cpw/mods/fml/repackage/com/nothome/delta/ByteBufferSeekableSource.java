/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.repackage.com.nothome.delta;

import cpw.mods.fml.repackage.com.nothome.delta.SeekableSource;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferSeekableSource
implements SeekableSource {
    private ByteBuffer bb;
    private ByteBuffer cur;

    public ByteBufferSeekableSource(byte[] byArray) {
        this(ByteBuffer.wrap(byArray));
    }

    public ByteBufferSeekableSource(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new NullPointerException("bb");
        }
        this.bb = byteBuffer;
        byteBuffer.rewind();
        try {
            this.seek(0L);
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    @Override
    public void seek(long l) throws IOException {
        this.cur = this.bb.slice();
        if (l > (long)this.cur.limit()) {
            throw new IOException("pos " + l + " cannot seek " + this.cur.limit());
        }
        this.cur.position((int)l);
    }

    @Override
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (!this.cur.hasRemaining()) {
            return -1;
        }
        int n = 0;
        while (this.cur.hasRemaining() && byteBuffer.hasRemaining()) {
            byteBuffer.put(this.cur.get());
            ++n;
        }
        return n;
    }

    @Override
    public void close() throws IOException {
        this.bb = null;
        this.cur = null;
    }

    public String toString() {
        return "BBSeekable bb=" + this.bb.position() + "-" + this.bb.limit() + " cur=" + this.cur.position() + "-" + this.cur.limit() + "";
    }
}

