/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

public class ChannelInputStream
extends InputStream {
    private ReadableByteChannel _channel;
    private byte[] _singleByte = new byte[1];
    private ByteBuffer _singleByteBuf = ByteBuffer.wrap(this._singleByte);

    public ChannelInputStream(ReadableByteChannel readableByteChannel) {
        this._channel = readableByteChannel;
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        this._singleByteBuf.clear();
        int n = this._channel.read(this._singleByteBuf);
        if (n <= 0) {
            return -1;
        }
        return this._singleByte[0] & 0xFF;
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray, n, n2);
        return this._channel.read(byteBuffer);
    }

    @Deprecated
    public void close() throws IOException {
        this._channel.close();
    }

    @Deprecated
    public int available() throws IOException {
        return 0;
    }

    @Deprecated
    public long skip(long l) throws IOException {
        return super.skip(l);
    }
}

