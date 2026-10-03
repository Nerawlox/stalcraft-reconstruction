/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Locale;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.xxhash.StreamingXXHash32;
import net.jpountz.xxhash.XXHash32;
import net.jpountz.xxhash.XXHashFactory;

public class LZ4FrameOutputStream
extends FilterOutputStream {
    static final int INTEGER_BYTES = 4;
    static final int LONG_BYTES = 8;
    static final int MAGIC = 407708164;
    static final int LZ4_MAX_HEADER_LENGTH = 15;
    static final int LZ4_FRAME_INCOMPRESSIBLE_MASK = Integer.MIN_VALUE;
    static final FLG.Bits[] DEFAULT_FEATURES = new FLG.Bits[]{FLG.Bits.BLOCK_INDEPENDENCE};
    static final String CLOSED_STREAM = "The stream is already closed";
    private final LZ4Compressor compressor;
    private final XXHash32 checksum;
    private final ByteBuffer buffer;
    private final byte[] compressedBuffer;
    private final int maxBlockSize;
    private final long knownSize;
    private final ByteBuffer intLEBuffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
    private FrameInfo frameInfo = null;

    public LZ4FrameOutputStream(OutputStream out, BLOCKSIZE blockSize, FLG.Bits ... bits) throws IOException {
        this(out, blockSize, -1L, bits);
    }

    public LZ4FrameOutputStream(OutputStream out, BLOCKSIZE blockSize, long knownSize, FLG.Bits ... bits) throws IOException {
        super(out);
        this.compressor = LZ4Factory.fastestInstance().fastCompressor();
        this.checksum = XXHashFactory.fastestInstance().hash32();
        this.frameInfo = new FrameInfo(new FLG(1, bits), new BD(blockSize));
        this.maxBlockSize = this.frameInfo.getBD().getBlockMaximumSize();
        this.buffer = ByteBuffer.allocate(this.maxBlockSize).order(ByteOrder.LITTLE_ENDIAN);
        this.compressedBuffer = new byte[this.compressor.maxCompressedLength(this.maxBlockSize)];
        if (this.frameInfo.getFLG().isEnabled(FLG.Bits.CONTENT_SIZE) && knownSize < 0L) {
            throw new IllegalArgumentException("Known size must be greater than zero in order to use the known size feature");
        }
        this.knownSize = knownSize;
        this.writeHeader();
    }

    public LZ4FrameOutputStream(OutputStream out, BLOCKSIZE blockSize) throws IOException {
        this(out, blockSize, DEFAULT_FEATURES);
    }

    public LZ4FrameOutputStream(OutputStream out) throws IOException {
        this(out, BLOCKSIZE.SIZE_4MB);
    }

    private void writeHeader() throws IOException {
        ByteBuffer headerBuffer = ByteBuffer.allocate(15).order(ByteOrder.LITTLE_ENDIAN);
        headerBuffer.putInt(407708164);
        headerBuffer.put(this.frameInfo.getFLG().toByte());
        headerBuffer.put(this.frameInfo.getBD().toByte());
        if (this.frameInfo.isEnabled(FLG.Bits.CONTENT_SIZE)) {
            headerBuffer.putLong(this.knownSize);
        }
        int hash = this.checksum.hash(headerBuffer.array(), 4, headerBuffer.position() - 4, 0) >> 8 & 0xFF;
        headerBuffer.put((byte)hash);
        this.out.write(headerBuffer.array(), 0, headerBuffer.position());
    }

    private void writeBlock() throws IOException {
        int compressMethod;
        byte[] bufferToWrite;
        if (this.buffer.position() == 0) {
            return;
        }
        Arrays.fill(this.compressedBuffer, (byte)0);
        int compressedLength = this.compressor.compress(this.buffer.array(), 0, this.buffer.position(), this.compressedBuffer, 0);
        if (compressedLength >= this.buffer.position()) {
            compressedLength = this.buffer.position();
            bufferToWrite = Arrays.copyOf(this.buffer.array(), compressedLength);
            compressMethod = Integer.MIN_VALUE;
        } else {
            bufferToWrite = this.compressedBuffer;
            compressMethod = 0;
        }
        this.intLEBuffer.putInt(0, compressedLength | compressMethod);
        this.out.write(this.intLEBuffer.array());
        this.out.write(bufferToWrite, 0, compressedLength);
        if (this.frameInfo.isEnabled(FLG.Bits.BLOCK_CHECKSUM)) {
            this.intLEBuffer.putInt(0, this.checksum.hash(bufferToWrite, 0, compressedLength, 0));
            this.out.write(this.intLEBuffer.array());
        }
        this.buffer.rewind();
    }

    private void writeEndMark() throws IOException {
        this.intLEBuffer.putInt(0, 0);
        this.out.write(this.intLEBuffer.array());
        if (this.frameInfo.isEnabled(FLG.Bits.CONTENT_CHECKSUM)) {
            this.intLEBuffer.putInt(0, this.frameInfo.currentStreamHash());
            this.out.write(this.intLEBuffer.array());
        }
        this.frameInfo.finish();
    }

    @Override
    public void write(int b) throws IOException {
        this.ensureNotFinished();
        if (this.buffer.position() == this.maxBlockSize) {
            this.writeBlock();
        }
        this.buffer.put((byte)b);
        if (this.frameInfo.isEnabled(FLG.Bits.CONTENT_CHECKSUM)) {
            this.frameInfo.updateStreamHash(new byte[]{(byte)b}, 0, 1);
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException();
        }
        this.ensureNotFinished();
        while (len > this.buffer.remaining()) {
            int sizeWritten = this.buffer.remaining();
            this.buffer.put(b, off, sizeWritten);
            if (this.frameInfo.isEnabled(FLG.Bits.CONTENT_CHECKSUM)) {
                this.frameInfo.updateStreamHash(b, off, sizeWritten);
            }
            this.writeBlock();
            off += sizeWritten;
            len -= sizeWritten;
        }
        this.buffer.put(b, off, len);
        if (this.frameInfo.isEnabled(FLG.Bits.CONTENT_CHECKSUM)) {
            this.frameInfo.updateStreamHash(b, off, len);
        }
    }

    @Override
    public void flush() throws IOException {
        if (!this.frameInfo.isFinished()) {
            this.writeBlock();
        }
        super.flush();
    }

    private void ensureNotFinished() {
        if (this.frameInfo.isFinished()) {
            throw new IllegalStateException(CLOSED_STREAM);
        }
    }

    @Override
    public void close() throws IOException {
        if (!this.frameInfo.isFinished()) {
            this.flush();
            this.writeEndMark();
        }
        super.close();
    }

    static class FrameInfo {
        private final FLG flg;
        private final BD bd;
        private final StreamingXXHash32 streamHash;
        private boolean finished = false;

        public FrameInfo(FLG flg, BD bd) {
            this.flg = flg;
            this.bd = bd;
            this.streamHash = flg.isEnabled(FLG.Bits.CONTENT_CHECKSUM) ? XXHashFactory.fastestInstance().newStreamingHash32(0) : null;
        }

        public boolean isEnabled(FLG.Bits bit) {
            return this.flg.isEnabled(bit);
        }

        public FLG getFLG() {
            return this.flg;
        }

        public BD getBD() {
            return this.bd;
        }

        public void updateStreamHash(byte[] buff, int off, int len) {
            this.streamHash.update(buff, off, len);
        }

        public int currentStreamHash() {
            return this.streamHash.getValue();
        }

        public void finish() {
            this.finished = true;
        }

        public boolean isFinished() {
            return this.finished;
        }
    }

    public static class BD {
        private static final int RESERVED_MASK = 143;
        private final BLOCKSIZE blockSizeValue;

        private BD(BLOCKSIZE blockSizeValue) {
            this.blockSizeValue = blockSizeValue;
        }

        public static BD fromByte(byte bd) {
            int blockMaximumSize = bd >>> 4 & 7;
            if ((bd & 0x8F) > 0) {
                throw new RuntimeException("Reserved fields must be 0");
            }
            return new BD(BLOCKSIZE.valueOf(blockMaximumSize));
        }

        public int getBlockMaximumSize() {
            return 1 << 2 * this.blockSizeValue.getIndicator() + 8;
        }

        public byte toByte() {
            return (byte)((this.blockSizeValue.getIndicator() & 7) << 4);
        }
    }

    public static class FLG {
        private static final int DEFAULT_VERSION = 1;
        private final BitSet bitSet;
        private final int version;

        public FLG(int version, Bits ... bits) {
            this.bitSet = new BitSet(8);
            this.version = version;
            if (bits != null) {
                for (Bits bit : bits) {
                    this.bitSet.set(bit.position);
                }
            }
            this.validate();
        }

        private FLG(int version, byte b) {
            this.bitSet = BitSet.valueOf(new byte[]{b});
            this.version = version;
            this.validate();
        }

        public static FLG fromByte(byte flg) {
            byte versionMask = (byte)(flg & 0xC0);
            return new FLG(versionMask >>> 6, (byte)(flg ^ versionMask));
        }

        public byte toByte() {
            return (byte)(this.bitSet.toByteArray()[0] | (this.version & 3) << 6);
        }

        private void validate() {
            if (this.bitSet.get(Bits.RESERVED_0.position)) {
                throw new RuntimeException("Reserved0 field must be 0");
            }
            if (this.bitSet.get(Bits.RESERVED_1.position)) {
                throw new RuntimeException("Reserved1 field must be 0");
            }
            if (!this.bitSet.get(Bits.BLOCK_INDEPENDENCE.position)) {
                throw new RuntimeException("Dependent block stream is unsupported (BLOCK_INDEPENDENCE must be set)");
            }
            if (this.version != 1) {
                throw new RuntimeException(String.format(Locale.ROOT, "Version %d is unsupported", this.version));
            }
        }

        public boolean isEnabled(Bits bit) {
            return this.bitSet.get(bit.position);
        }

        public int getVersion() {
            return this.version;
        }

        public static enum Bits {
            RESERVED_0(0),
            RESERVED_1(1),
            CONTENT_CHECKSUM(2),
            CONTENT_SIZE(3),
            BLOCK_CHECKSUM(4),
            BLOCK_INDEPENDENCE(5);

            private final int position;

            private Bits(int position) {
                this.position = position;
            }
        }
    }

    public static enum BLOCKSIZE {
        SIZE_64KB(4),
        SIZE_256KB(5),
        SIZE_1MB(6),
        SIZE_4MB(7);

        private final int indicator;

        private BLOCKSIZE(int indicator) {
            this.indicator = indicator;
        }

        public int getIndicator() {
            return this.indicator;
        }

        public static BLOCKSIZE valueOf(int indicator) {
            switch (indicator) {
                case 7: {
                    return SIZE_4MB;
                }
                case 6: {
                    return SIZE_1MB;
                }
                case 5: {
                    return SIZE_256KB;
                }
                case 4: {
                    return SIZE_64KB;
                }
            }
            throw new IllegalArgumentException(String.format(Locale.ROOT, "Block size must be 4-7. Cannot use value of [%d]", indicator));
        }
    }
}

