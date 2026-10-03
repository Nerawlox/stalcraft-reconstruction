/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.repackage.com.nothome.delta;

import cpw.mods.fml.repackage.com.nothome.delta.SeekableSource;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class RandomAccessFileSeekableSource
implements SeekableSource {
    private RandomAccessFile raf;

    public RandomAccessFileSeekableSource(RandomAccessFile randomAccessFile) {
        if (randomAccessFile == null) {
            throw new NullPointerException("raf");
        }
        this.raf = randomAccessFile;
    }

    @Override
    public void seek(long l) throws IOException {
        this.raf.seek(l);
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        return this.raf.read(byArray, n, n2);
    }

    public long length() throws IOException {
        return this.raf.length();
    }

    @Override
    public void close() throws IOException {
        this.raf.close();
    }

    @Override
    public int read(ByteBuffer byteBuffer) throws IOException {
        int n = this.raf.read(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
        if (n == -1) {
            return -1;
        }
        byteBuffer.position(byteBuffer.position() + n);
        return n;
    }
}

