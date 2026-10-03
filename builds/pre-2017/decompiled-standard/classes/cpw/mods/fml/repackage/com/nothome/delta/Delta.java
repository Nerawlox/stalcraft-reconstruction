/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.repackage.com.nothome.delta;

import cpw.mods.fml.repackage.com.nothome.delta.ByteBufferSeekableSource;
import cpw.mods.fml.repackage.com.nothome.delta.Checksum;
import cpw.mods.fml.repackage.com.nothome.delta.DebugDiffWriter;
import cpw.mods.fml.repackage.com.nothome.delta.DiffWriter;
import cpw.mods.fml.repackage.com.nothome.delta.GDiffWriter;
import cpw.mods.fml.repackage.com.nothome.delta.RandomAccessFileSeekableSource;
import cpw.mods.fml.repackage.com.nothome.delta.SeekableSource;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Delta {
    static final boolean debug = false;
    public static final int DEFAULT_CHUNK_SIZE = 16;
    private int S;
    private SourceState source;
    private TargetState target;
    private DiffWriter output;

    public Delta() {
        this.setChunkSize(16);
    }

    public void setChunkSize(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid size");
        }
        this.S = n;
    }

    public void compute(byte[] byArray, byte[] byArray2, OutputStream outputStream) throws IOException {
        this.compute(new ByteBufferSeekableSource(byArray), (InputStream)new ByteArrayInputStream(byArray2), (DiffWriter)new GDiffWriter(outputStream));
    }

    public byte[] compute(byte[] byArray, byte[] byArray2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.compute(byArray, byArray2, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void compute(byte[] byArray, InputStream inputStream, DiffWriter diffWriter) throws IOException {
        this.compute(new ByteBufferSeekableSource(byArray), inputStream, diffWriter);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void compute(File file, File file2, DiffWriter diffWriter) throws IOException {
        RandomAccessFileSeekableSource randomAccessFileSeekableSource = new RandomAccessFileSeekableSource(new RandomAccessFile(file, "r"));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
        try {
            this.compute(randomAccessFileSeekableSource, (InputStream)bufferedInputStream, diffWriter);
        }
        finally {
            randomAccessFileSeekableSource.close();
            ((InputStream)bufferedInputStream).close();
        }
    }

    public void compute(SeekableSource seekableSource, InputStream inputStream, DiffWriter diffWriter) throws IOException {
        this.source = new SourceState(seekableSource);
        this.target = new TargetState(inputStream);
        this.output = diffWriter;
        while (!this.target.eof()) {
            this.debug("!target.eof()");
            int n = this.target.find(this.source);
            if (n != -1) {
                long l = (long)n * (long)this.S;
                this.source.seek(l);
                int n2 = this.target.longestMatch(this.source);
                if (n2 >= this.S) {
                    diffWriter.addCopy(l, n2);
                    continue;
                }
                this.target.tbuf.position(this.target.tbuf.position() - n2);
                this.addData();
                continue;
            }
            this.addData();
        }
        diffWriter.close();
    }

    private void addData() throws IOException {
        int n = this.target.read();
        if (n == -1) {
            return;
        }
        this.output.addData((byte)n);
    }

    public static void main(String[] stringArray) throws Exception {
        if (stringArray.length != 3) {
            System.err.println("usage Delta [-d] source target [output]");
            System.err.println("either -d or an output filename must be specified.");
            System.err.println("aborting..");
            return;
        }
        DiffWriter diffWriter = null;
        File file = null;
        File file2 = null;
        if (stringArray[0].equals("-d")) {
            file = new File(stringArray[1]);
            file2 = new File(stringArray[2]);
            diffWriter = new DebugDiffWriter();
        } else {
            file = new File(stringArray[0]);
            file2 = new File(stringArray[1]);
            diffWriter = new GDiffWriter(new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(stringArray[2])))));
        }
        if (file.length() > Integer.MAX_VALUE || file2.length() > Integer.MAX_VALUE) {
            System.err.println("source or target is too large, max length is 2147483647");
            System.err.println("aborting..");
            diffWriter.close();
            return;
        }
        Delta delta = new Delta();
        delta.compute(file, file2, diffWriter);
        diffWriter.flush();
        diffWriter.close();
    }

    private void debug(String string) {
    }

    class TargetState {
        private ReadableByteChannel c;
        private ByteBuffer tbuf = ByteBuffer.allocate(this.blocksize());
        private ByteBuffer sbuf = ByteBuffer.allocate(this.blocksize());
        private long hash;
        private boolean hashReset = true;
        private boolean eof;

        TargetState(InputStream inputStream) throws IOException {
            this.c = Channels.newChannel(inputStream);
            this.tbuf.limit(0);
        }

        private int blocksize() {
            return Math.min(16384, Delta.this.S * 4);
        }

        public int find(SourceState sourceState) throws IOException {
            if (this.eof) {
                return -1;
            }
            this.sbuf.clear();
            this.sbuf.limit(0);
            if (this.hashReset) {
                Delta.this.debug("hashReset");
                while (this.tbuf.remaining() < Delta.this.S) {
                    this.tbuf.compact();
                    int n = this.c.read(this.tbuf);
                    this.tbuf.flip();
                    if (n != -1) continue;
                    Delta.this.debug("target ending");
                    return -1;
                }
                this.hash = Checksum.queryChecksum(this.tbuf, Delta.this.S);
                this.hashReset = false;
            }
            return sourceState.checksum.findChecksumIndex(this.hash);
        }

        public boolean eof() {
            return this.eof;
        }

        public int read() throws IOException {
            if (this.tbuf.remaining() <= Delta.this.S) {
                this.readMore();
                if (!this.tbuf.hasRemaining()) {
                    this.eof = true;
                    return -1;
                }
            }
            byte by = this.tbuf.get();
            if (this.tbuf.remaining() >= Delta.this.S) {
                byte by2 = this.tbuf.get(this.tbuf.position() + Delta.this.S - 1);
                this.hash = Checksum.incrementChecksum(this.hash, by, by2, Delta.this.S);
            } else {
                Delta.this.debug("out of char");
            }
            return by & 0xFF;
        }

        public int longestMatch(SourceState sourceState) throws IOException {
            Delta.this.debug("longestMatch");
            int n = 0;
            this.hashReset = true;
            while (true) {
                if (!this.sbuf.hasRemaining()) {
                    this.sbuf.clear();
                    int n2 = sourceState.source.read(this.sbuf);
                    this.sbuf.flip();
                    if (n2 == -1) {
                        return n;
                    }
                }
                if (!this.tbuf.hasRemaining()) {
                    this.readMore();
                    if (!this.tbuf.hasRemaining()) {
                        Delta.this.debug("target ending");
                        this.eof = true;
                        return n;
                    }
                }
                if (this.sbuf.get() != this.tbuf.get()) {
                    this.tbuf.position(this.tbuf.position() - 1);
                    return n;
                }
                ++n;
            }
        }

        private void readMore() throws IOException {
            this.tbuf.compact();
            this.c.read(this.tbuf);
            this.tbuf.flip();
        }

        void hash() {
            this.hash = Checksum.queryChecksum(this.tbuf, Delta.this.S);
        }

        public String toString() {
            return "Target[ targetBuff=" + this.dump() + " sourceBuff=" + this.sbuf + " hashf=" + this.hash + " eof=" + this.eof + "]";
        }

        private String dump() {
            return this.dump(this.tbuf);
        }

        private String dump(ByteBuffer byteBuffer) {
            return this.getTextDump(byteBuffer);
        }

        private void append(StringBuffer stringBuffer, int n) {
            char c = (char)(n >> 4 & 0xF);
            char c2 = (char)(n & 0xF);
            stringBuffer.append(Character.forDigit(c, 16));
            stringBuffer.append(Character.forDigit(c2, 16));
        }

        public String getTextDump(ByteBuffer byteBuffer) {
            StringBuffer stringBuffer = new StringBuffer(byteBuffer.remaining() * 2);
            byteBuffer.mark();
            while (byteBuffer.hasRemaining()) {
                byte by = byteBuffer.get();
                if (by > 32 && by < 127) {
                    stringBuffer.append(" ").append((char)by);
                    continue;
                }
                this.append(stringBuffer, by);
            }
            byteBuffer.reset();
            return stringBuffer.toString();
        }
    }

    class SourceState {
        private Checksum checksum;
        private SeekableSource source;

        public SourceState(SeekableSource seekableSource) throws IOException {
            this.checksum = new Checksum(seekableSource, Delta.this.S);
            this.source = seekableSource;
            seekableSource.seek(0L);
        }

        public void seek(long l) throws IOException {
            this.source.seek(l);
        }

        public String toString() {
            return "Source checksum=" + this.checksum + " source=" + this.source + "";
        }
    }
}

