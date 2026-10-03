/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.Closer;
import com.google.common.io.InputSupplier;
import com.google.common.io.MultiInputStream;
import com.google.common.io.OutputSupplier;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.zip.Checksum;

@Beta
public final class ByteStreams {
    private static final int BUF_SIZE = 4096;
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream(){

        @Override
        public void write(int b) {
        }

        @Override
        public void write(byte[] b) {
            Preconditions.checkNotNull(b);
        }

        @Override
        public void write(byte[] b, int off, int len) {
            Preconditions.checkNotNull(b);
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }
    };

    private ByteStreams() {
    }

    public static InputSupplier<ByteArrayInputStream> newInputStreamSupplier(byte[] b) {
        return ByteStreams.asInputSupplier(ByteStreams.asByteSource(b));
    }

    public static InputSupplier<ByteArrayInputStream> newInputStreamSupplier(byte[] b, int off, int len) {
        return ByteStreams.asInputSupplier(ByteStreams.asByteSource(b).slice(off, len));
    }

    public static ByteSource asByteSource(byte[] b) {
        return new ByteArrayByteSource(b);
    }

    public static void write(byte[] from, OutputSupplier<? extends OutputStream> to) throws IOException {
        ByteStreams.asByteSink(to).write(from);
    }

    public static long copy(InputSupplier<? extends InputStream> from, OutputSupplier<? extends OutputStream> to) throws IOException {
        return ByteStreams.asByteSource(from).copyTo(ByteStreams.asByteSink(to));
    }

    public static long copy(InputSupplier<? extends InputStream> from, OutputStream to) throws IOException {
        return ByteStreams.asByteSource(from).copyTo(to);
    }

    public static long copy(InputStream from, OutputSupplier<? extends OutputStream> to) throws IOException {
        return ByteStreams.asByteSink(to).writeFrom(from);
    }

    public static long copy(InputStream from, OutputStream to) throws IOException {
        int r;
        Preconditions.checkNotNull(from);
        Preconditions.checkNotNull(to);
        byte[] buf = new byte[4096];
        long total = 0L;
        while ((r = from.read(buf)) != -1) {
            to.write(buf, 0, r);
            total += (long)r;
        }
        return total;
    }

    public static long copy(ReadableByteChannel from, WritableByteChannel to) throws IOException {
        Preconditions.checkNotNull(from);
        Preconditions.checkNotNull(to);
        ByteBuffer buf = ByteBuffer.allocate(4096);
        long total = 0L;
        while (from.read(buf) != -1) {
            buf.flip();
            while (buf.hasRemaining()) {
                total += (long)to.write(buf);
            }
            buf.clear();
        }
        return total;
    }

    public static byte[] toByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteStreams.copy(in, (OutputStream)out);
        return out.toByteArray();
    }

    public static byte[] toByteArray(InputSupplier<? extends InputStream> supplier) throws IOException {
        return ByteStreams.asByteSource(supplier).read();
    }

    public static ByteArrayDataInput newDataInput(byte[] bytes) {
        return new ByteArrayDataInputStream(bytes);
    }

    public static ByteArrayDataInput newDataInput(byte[] bytes, int start) {
        Preconditions.checkPositionIndex(start, bytes.length);
        return new ByteArrayDataInputStream(bytes, start);
    }

    public static ByteArrayDataOutput newDataOutput() {
        return new ByteArrayDataOutputStream();
    }

    public static ByteArrayDataOutput newDataOutput(int size) {
        Preconditions.checkArgument(size >= 0, "Invalid size: %s", size);
        return new ByteArrayDataOutputStream(size);
    }

    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    public static InputStream limit(InputStream in, long limit) {
        return new LimitedInputStream(in, limit);
    }

    public static long length(InputSupplier<? extends InputStream> supplier) throws IOException {
        return ByteStreams.asByteSource(supplier).size();
    }

    public static boolean equal(InputSupplier<? extends InputStream> supplier1, InputSupplier<? extends InputStream> supplier2) throws IOException {
        return ByteStreams.asByteSource(supplier1).contentEquals(ByteStreams.asByteSource(supplier2));
    }

    public static void readFully(InputStream in, byte[] b) throws IOException {
        ByteStreams.readFully(in, b, 0, b.length);
    }

    public static void readFully(InputStream in, byte[] b, int off, int len) throws IOException {
        int read = ByteStreams.read(in, b, off, len);
        if (read != len) {
            throw new EOFException("reached end of stream after reading " + read + " bytes; " + len + " bytes expected");
        }
    }

    public static void skipFully(InputStream in, long n) throws IOException {
        long toSkip = n;
        while (n > 0L) {
            long amt = in.skip(n);
            if (amt == 0L) {
                if (in.read() == -1) {
                    long skipped = toSkip - n;
                    throw new EOFException("reached end of stream after skipping " + skipped + " bytes; " + toSkip + " bytes expected");
                }
                --n;
                continue;
            }
            n -= amt;
        }
    }

    public static <T> T readBytes(InputSupplier<? extends InputStream> supplier, ByteProcessor<T> processor) throws IOException {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(processor);
        Closer closer = Closer.create();
        try {
            InputStream in = (InputStream)closer.register((Closeable)supplier.getInput());
            T t = ByteStreams.readBytes(in, processor);
            return t;
        }
        catch (Throwable e) {
            throw closer.rethrow(e);
        }
        finally {
            closer.close();
        }
    }

    public static <T> T readBytes(InputStream input, ByteProcessor<T> processor) throws IOException {
        int read;
        Preconditions.checkNotNull(input);
        Preconditions.checkNotNull(processor);
        byte[] buf = new byte[4096];
        while ((read = input.read(buf)) != -1 && processor.processBytes(buf, 0, read)) {
        }
        return processor.getResult();
    }

    @Deprecated
    public static long getChecksum(InputSupplier<? extends InputStream> supplier, final Checksum checksum) throws IOException {
        Preconditions.checkNotNull(checksum);
        return ByteStreams.readBytes(supplier, new ByteProcessor<Long>(){

            @Override
            public boolean processBytes(byte[] buf, int off, int len) {
                checksum.update(buf, off, len);
                return true;
            }

            @Override
            public Long getResult() {
                long result2 = checksum.getValue();
                checksum.reset();
                return result2;
            }
        });
    }

    public static HashCode hash(InputSupplier<? extends InputStream> supplier, HashFunction hashFunction) throws IOException {
        return ByteStreams.asByteSource(supplier).hash(hashFunction);
    }

    public static int read(InputStream in, byte[] b, int off, int len) throws IOException {
        int total;
        int result2;
        Preconditions.checkNotNull(in);
        Preconditions.checkNotNull(b);
        if (len < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        for (total = 0; total < len && (result2 = in.read(b, off + total, len - total)) != -1; total += result2) {
        }
        return total;
    }

    public static InputSupplier<InputStream> slice(InputSupplier<? extends InputStream> supplier, long offset, long length) {
        return ByteStreams.asInputSupplier(ByteStreams.asByteSource(supplier).slice(offset, length));
    }

    public static InputSupplier<InputStream> join(final Iterable<? extends InputSupplier<? extends InputStream>> suppliers) {
        Preconditions.checkNotNull(suppliers);
        return new InputSupplier<InputStream>(){

            @Override
            public InputStream getInput() throws IOException {
                return new MultiInputStream(suppliers.iterator());
            }
        };
    }

    public static InputSupplier<InputStream> join(InputSupplier<? extends InputStream> ... suppliers) {
        return ByteStreams.join(Arrays.asList(suppliers));
    }

    static <S extends InputStream> InputSupplier<S> asInputSupplier(final ByteSource source) {
        Preconditions.checkNotNull(source);
        return new InputSupplier<S>(){

            @Override
            public S getInput() throws IOException {
                return source.openStream();
            }
        };
    }

    static <S extends OutputStream> OutputSupplier<S> asOutputSupplier(final ByteSink sink) {
        Preconditions.checkNotNull(sink);
        return new OutputSupplier<S>(){

            @Override
            public S getOutput() throws IOException {
                return sink.openStream();
            }
        };
    }

    static ByteSource asByteSource(final InputSupplier<? extends InputStream> supplier) {
        Preconditions.checkNotNull(supplier);
        return new ByteSource(){

            @Override
            public InputStream openStream() throws IOException {
                return (InputStream)supplier.getInput();
            }
        };
    }

    static ByteSink asByteSink(final OutputSupplier<? extends OutputStream> supplier) {
        Preconditions.checkNotNull(supplier);
        return new ByteSink(){

            @Override
            public OutputStream openStream() throws IOException {
                return (OutputStream)supplier.getOutput();
            }
        };
    }

    private static final class LimitedInputStream
    extends FilterInputStream {
        private long left;
        private long mark = -1L;

        LimitedInputStream(InputStream in, long limit) {
            super(in);
            Preconditions.checkNotNull(in);
            Preconditions.checkArgument(limit >= 0L, "limit must be non-negative");
            this.left = limit;
        }

        @Override
        public int available() throws IOException {
            return (int)Math.min((long)this.in.available(), this.left);
        }

        @Override
        public synchronized void mark(int readLimit) {
            this.in.mark(readLimit);
            this.mark = this.left;
        }

        @Override
        public int read() throws IOException {
            if (this.left == 0L) {
                return -1;
            }
            int result2 = this.in.read();
            if (result2 != -1) {
                --this.left;
            }
            return result2;
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            if (this.left == 0L) {
                return -1;
            }
            int result2 = this.in.read(b, off, len = (int)Math.min((long)len, this.left));
            if (result2 != -1) {
                this.left -= (long)result2;
            }
            return result2;
        }

        @Override
        public synchronized void reset() throws IOException {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1L) {
                throw new IOException("Mark not set");
            }
            this.in.reset();
            this.left = this.mark;
        }

        @Override
        public long skip(long n) throws IOException {
            n = Math.min(n, this.left);
            long skipped = this.in.skip(n);
            this.left -= skipped;
            return skipped;
        }
    }

    private static class ByteArrayDataOutputStream
    implements ByteArrayDataOutput {
        final DataOutput output;
        final ByteArrayOutputStream byteArrayOutputSteam;

        ByteArrayDataOutputStream() {
            this(new ByteArrayOutputStream());
        }

        ByteArrayDataOutputStream(int size) {
            this(new ByteArrayOutputStream(size));
        }

        ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputSteam) {
            this.byteArrayOutputSteam = byteArrayOutputSteam;
            this.output = new DataOutputStream(byteArrayOutputSteam);
        }

        @Override
        public void write(int b) {
            try {
                this.output.write(b);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void write(byte[] b) {
            try {
                this.output.write(b);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void write(byte[] b, int off, int len) {
            try {
                this.output.write(b, off, len);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeBoolean(boolean v) {
            try {
                this.output.writeBoolean(v);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeByte(int v) {
            try {
                this.output.writeByte(v);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeBytes(String s) {
            try {
                this.output.writeBytes(s);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeChar(int v) {
            try {
                this.output.writeChar(v);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeChars(String s) {
            try {
                this.output.writeChars(s);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeDouble(double v) {
            try {
                this.output.writeDouble(v);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeFloat(float v) {
            try {
                this.output.writeFloat(v);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeInt(int v) {
            try {
                this.output.writeInt(v);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeLong(long v) {
            try {
                this.output.writeLong(v);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeShort(int v) {
            try {
                this.output.writeShort(v);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public void writeUTF(String s) {
            try {
                this.output.writeUTF(s);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public byte[] toByteArray() {
            return this.byteArrayOutputSteam.toByteArray();
        }
    }

    private static class ByteArrayDataInputStream
    implements ByteArrayDataInput {
        final DataInput input;

        ByteArrayDataInputStream(byte[] bytes) {
            this.input = new DataInputStream(new ByteArrayInputStream(bytes));
        }

        ByteArrayDataInputStream(byte[] bytes, int start) {
            this.input = new DataInputStream(new ByteArrayInputStream(bytes, start, bytes.length - start));
        }

        @Override
        public void readFully(byte[] b) {
            try {
                this.input.readFully(b);
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public void readFully(byte[] b, int off, int len) {
            try {
                this.input.readFully(b, off, len);
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public int skipBytes(int n) {
            try {
                return this.input.skipBytes(n);
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public byte readByte() {
            try {
                return this.input.readByte();
            }
            catch (EOFException e) {
                throw new IllegalStateException(e);
            }
            catch (IOException impossible) {
                throw new AssertionError((Object)impossible);
            }
        }

        @Override
        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public short readShort() {
            try {
                return this.input.readShort();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public char readChar() {
            try {
                return this.input.readChar();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public int readInt() {
            try {
                return this.input.readInt();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public long readLong() {
            try {
                return this.input.readLong();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public float readFloat() {
            try {
                return this.input.readFloat();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public double readDouble() {
            try {
                return this.input.readDouble();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public String readLine() {
            try {
                return this.input.readLine();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public String readUTF() {
            try {
                return this.input.readUTF();
            }
            catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static final class ByteArrayByteSource
    extends ByteSource {
        private final byte[] bytes;

        private ByteArrayByteSource(byte[] bytes) {
            this.bytes = Preconditions.checkNotNull(bytes);
        }

        @Override
        public InputStream openStream() throws IOException {
            return new ByteArrayInputStream(this.bytes);
        }

        @Override
        public long size() throws IOException {
            return this.bytes.length;
        }

        @Override
        public byte[] read() throws IOException {
            return (byte[])this.bytes.clone();
        }

        @Override
        public long copyTo(OutputStream output) throws IOException {
            output.write(this.bytes);
            return this.bytes.length;
        }

        @Override
        public HashCode hash(HashFunction hashFunction) throws IOException {
            return hashFunction.hashBytes(this.bytes);
        }

        public String toString() {
            return "ByteStreams.asByteSource(" + BaseEncoding.base16().encode(this.bytes) + ")";
        }
    }
}

