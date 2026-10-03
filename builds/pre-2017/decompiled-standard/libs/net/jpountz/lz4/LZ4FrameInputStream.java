/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FrameOutputStream;
import net.jpountz.lz4.LZ4SafeDecompressor;
import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;

public class LZ4FrameInputStream
extends FilterInputStream {
    static final String PREMATURE_EOS = "Stream ended prematurely";
    static final String NOT_SUPPORTED = "Stream unsupported";
    static final String BLOCK_HASH_MISMATCH = "Block checksum mismatch";
    static final String DESCRIPTOR_HASH_MISMATCH = "Stream frame descriptor corrupted";
    static final int MAGIC_SKIPPABLE_BASE = 407710288;
    private final LZ4SafeDecompressor decompressor;
    private final XXHash32 checksum;
    private final byte[] headerArray = new byte[15];
    private final ByteBuffer headerBuffer = ByteBuffer.wrap(this.headerArray).order(ByteOrder.LITTLE_ENDIAN);
    private byte[] compressedBuffer;
    private ByteBuffer buffer = null;
    private byte[] rawBuffer = null;
    private int maxBlockSize = -1;
    private long expectedContentSize = -1L;
    private long totalContentSize = 0L;
    private LZ4FrameOutputStream.FrameInfo frameInfo = null;
    private final ByteBuffer readNumberBuff = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    public LZ4FrameInputStream(InputStream in) throws IOException {
        this(in, LZ4Factory.fastestInstance().safeDecompressor(), XXHashFactory.fastestInstance().hash32());
    }

    public LZ4FrameInputStream(InputStream in, LZ4SafeDecompressor decompressor, XXHash32 checksum) throws IOException {
        super(in);
        this.decompressor = decompressor;
        this.checksum = checksum;
        this.nextFrameInfo();
    }

    private boolean nextFrameInfo() throws IOException {
        while (true) {
            int mySize;
            int size = 0;
            do {
                if ((mySize = this.in.read(this.readNumberBuff.array(), size, 4 - size)) >= 0) continue;
                return false;
            } while ((size += mySize) < 4);
            int magic = this.readNumberBuff.getInt(0);
            if (magic == 407708164) {
                this.readHeader();
                return true;
            }
            if (magic >>> 4 != 25481893) break;
            this.skippableFrame();
        }
        throw new IOException(NOT_SUPPORTED);
    }

    private void skippableFrame() throws IOException {
        int mySize;
        byte[] skipBuffer = new byte[1024];
        for (int skipSize = this.readInt(this.in); skipSize > 0; skipSize -= mySize) {
            mySize = this.in.read(skipBuffer, 0, Math.min(skipSize, skipBuffer.length));
            if (mySize >= 0) continue;
            throw new IOException(PREMATURE_EOS);
        }
    }

    private void readHeader() throws IOException {
        this.headerBuffer.rewind();
        int flgRead = this.in.read();
        if (flgRead < 0) {
            throw new IOException(PREMATURE_EOS);
        }
        int bdRead = this.in.read();
        if (bdRead < 0) {
            throw new IOException(PREMATURE_EOS);
        }
        byte flgByte = (byte)(flgRead & 0xFF);
        LZ4FrameOutputStream.FLG flg = LZ4FrameOutputStream.FLG.fromByte(flgByte);
        this.headerBuffer.put(flgByte);
        byte bdByte = (byte)(bdRead & 0xFF);
        LZ4FrameOutputStream.BD bd = LZ4FrameOutputStream.BD.fromByte(bdByte);
        this.headerBuffer.put(bdByte);
        this.frameInfo = new LZ4FrameOutputStream.FrameInfo(flg, bd);
        if (flg.isEnabled(LZ4FrameOutputStream.FLG.Bits.CONTENT_SIZE)) {
            this.expectedContentSize = this.readLong(this.in);
            this.headerBuffer.putLong(this.expectedContentSize);
        }
        this.totalContentSize = 0L;
        byte hash = (byte)(this.checksum.hash(this.headerArray, 0, this.headerBuffer.position(), 0) >> 8 & 0xFF);
        int expectedHash = this.in.read();
        if (expectedHash < 0) {
            throw new IOException(PREMATURE_EOS);
        }
        if (hash != (byte)(expectedHash & 0xFF)) {
            throw new IOException(DESCRIPTOR_HASH_MISMATCH);
        }
        this.maxBlockSize = this.frameInfo.getBD().getBlockMaximumSize();
        this.compressedBuffer = new byte[this.maxBlockSize];
        this.rawBuffer = new byte[this.maxBlockSize];
        this.buffer = ByteBuffer.wrap(this.rawBuffer);
        this.buffer.limit(0);
    }

    private long readLong(InputStream stream) throws IOException {
        int mySize;
        int offset = 0;
        do {
            if ((mySize = stream.read(this.readNumberBuff.array(), offset, 8 - offset)) >= 0) continue;
            throw new IOException(PREMATURE_EOS);
        } while ((offset += mySize) < 8);
        return this.readNumberBuff.getLong(0);
    }

    private int readInt(InputStream stream) throws IOException {
        int mySize;
        int offset = 0;
        do {
            if ((mySize = stream.read(this.readNumberBuff.array(), offset, 4 - offset)) >= 0) continue;
            throw new IOException(PREMATURE_EOS);
        } while ((offset += mySize) < 4);
        return this.readNumberBuff.getInt(0);
    }

    private void readBlock() throws IOException {
        int currentBufferSize;
        int hashCheck;
        int lastRead;
        boolean compressed;
        int blockSize = this.readInt(this.in);
        boolean bl = compressed = (blockSize & Integer.MIN_VALUE) == 0;
        if ((blockSize &= Integer.MAX_VALUE) == 0) {
            int contentChecksum;
            if (this.frameInfo.isEnabled(LZ4FrameOutputStream.FLG.Bits.CONTENT_CHECKSUM) && (contentChecksum = this.readInt(this.in)) != this.frameInfo.currentStreamHash()) {
                throw new IOException("Content checksum mismatch");
            }
            if (this.frameInfo.isEnabled(LZ4FrameOutputStream.FLG.Bits.CONTENT_SIZE) && this.expectedContentSize != this.totalContentSize) {
                throw new IOException("Size check mismatch");
            }
            this.frameInfo.finish();
            return;
        }
        byte[] tmpBuffer = compressed ? this.compressedBuffer : this.rawBuffer;
        if (blockSize > this.maxBlockSize) {
            throw new IOException(String.format(Locale.ROOT, "Block size %s exceeded max: %s", blockSize, this.maxBlockSize));
        }
        for (int offset = 0; offset < blockSize; offset += lastRead) {
            lastRead = this.in.read(tmpBuffer, offset, blockSize - offset);
            if (lastRead >= 0) continue;
            throw new IOException(PREMATURE_EOS);
        }
        if (this.frameInfo.isEnabled(LZ4FrameOutputStream.FLG.Bits.BLOCK_CHECKSUM) && (hashCheck = this.readInt(this.in)) != this.checksum.hash(tmpBuffer, 0, blockSize, 0)) {
            throw new IOException(BLOCK_HASH_MISMATCH);
        }
        if (compressed) {
            try {
                currentBufferSize = this.decompressor.decompress(tmpBuffer, 0, blockSize, this.rawBuffer, 0, this.rawBuffer.length);
            }
            catch (LZ4Exception e) {
                throw new IOException(e);
            }
        } else {
            currentBufferSize = blockSize;
        }
        if (this.frameInfo.isEnabled(LZ4FrameOutputStream.FLG.Bits.CONTENT_CHECKSUM)) {
            this.frameInfo.updateStreamHash(this.rawBuffer, 0, currentBufferSize);
        }
        this.totalContentSize += (long)currentBufferSize;
        this.buffer.limit(currentBufferSize);
        this.buffer.rewind();
    }

    @Override
    public int read() throws IOException {
        while (this.buffer.remaining() == 0) {
            if (this.frameInfo.isFinished() && !this.nextFrameInfo()) {
                return -1;
            }
            this.readBlock();
        }
        return this.buffer.get();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException();
        }
        while (this.buffer.remaining() == 0) {
            if (this.frameInfo.isFinished() && !this.nextFrameInfo()) {
                return -1;
            }
            this.readBlock();
        }
        len = Math.min(len, this.buffer.remaining());
        this.buffer.get(b, off, len);
        return len;
    }

    @Override
    public long skip(long n) throws IOException {
        while (this.buffer.remaining() == 0) {
            if (this.frameInfo.isFinished() && !this.nextFrameInfo()) {
                return 0L;
            }
            this.readBlock();
        }
        n = Math.min(n, (long)this.buffer.remaining());
        this.buffer.position(this.buffer.position() + (int)n);
        return n;
    }

    @Override
    public int available() throws IOException {
        return this.buffer.remaining();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    @Override
    public synchronized void mark(int readlimit) {
        throw new UnsupportedOperationException("mark not supported");
    }

    @Override
    public synchronized void reset() throws IOException {
        throw new UnsupportedOperationException("reset not supported");
    }

    @Override
    public boolean markSupported() {
        return false;
    }
}

