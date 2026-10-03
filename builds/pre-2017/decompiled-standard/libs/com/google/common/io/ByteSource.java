/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;

public abstract class ByteSource {
    private static final int BUF_SIZE = 4096;
    private static final byte[] countBuffer = new byte[4096];

    public CharSource asCharSource(Charset charset) {
        return new AsCharSource(charset);
    }

    public abstract InputStream openStream() throws IOException;

    public BufferedInputStream openBufferedStream() throws IOException {
        InputStream in = this.openStream();
        return in instanceof BufferedInputStream ? (BufferedInputStream)in : new BufferedInputStream(in);
    }

    public ByteSource slice(long offset, long length) {
        return new SlicedByteSource(offset, length);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long size() throws IOException {
        Closer closer = Closer.create();
        try {
            InputStream in = closer.register(this.openStream());
            long l = this.countBySkipping(in);
            return l;
        }
        catch (IOException e) {
        }
        finally {
            closer.close();
        }
        closer = Closer.create();
        try {
            InputStream in = closer.register(this.openStream());
            long l = this.countByReading(in);
            return l;
        }
        catch (Throwable e) {
            throw closer.rethrow(e);
        }
        finally {
            closer.close();
        }
    }

    private long countBySkipping(InputStream in) throws IOException {
        long count = 0L;
        while (true) {
            long skipped;
            if ((skipped = in.skip(Math.min(in.available(), Integer.MAX_VALUE))) <= 0L) {
                if (in.read() == -1) {
                    return count;
                }
                ++count;
                continue;
            }
            count += skipped;
        }
    }

    private long countByReading(InputStream in) throws IOException {
        long read;
        long count = 0L;
        while ((read = (long)in.read(countBuffer)) != -1L) {
            count += read;
        }
        return count;
    }

    public long copyTo(OutputStream output) throws IOException {
        Preconditions.checkNotNull(output);
        Closer closer = Closer.create();
        try {
            InputStream in = closer.register(this.openStream());
            long l = ByteStreams.copy(in, output);
            return l;
        }
        catch (Throwable e) {
            throw closer.rethrow(e);
        }
        finally {
            closer.close();
        }
    }

    public long copyTo(ByteSink sink) throws IOException {
        Preconditions.checkNotNull(sink);
        Closer closer = Closer.create();
        try {
            InputStream in = closer.register(this.openStream());
            OutputStream out = closer.register(sink.openStream());
            long l = ByteStreams.copy(in, out);
            return l;
        }
        catch (Throwable e) {
            throw closer.rethrow(e);
        }
        finally {
            closer.close();
        }
    }

    public byte[] read() throws IOException {
        Closer closer = Closer.create();
        try {
            InputStream in = closer.register(this.openStream());
            byte[] byArray = ByteStreams.toByteArray(in);
            return byArray;
        }
        catch (Throwable e) {
            throw closer.rethrow(e);
        }
        finally {
            closer.close();
        }
    }

    public HashCode hash(HashFunction hashFunction) throws IOException {
        Hasher hasher = hashFunction.newHasher();
        this.copyTo(Funnels.asOutputStream(hasher));
        return hasher.hash();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean contentEquals(ByteSource other) throws IOException {
        Preconditions.checkNotNull(other);
        byte[] buf1 = new byte[4096];
        byte[] buf2 = new byte[4096];
        Closer closer = Closer.create();
        try {
            InputStream in1 = closer.register(this.openStream());
            InputStream in2 = closer.register(other.openStream());
            while (true) {
                int read2;
                int read1;
                if ((read1 = ByteStreams.read(in1, buf1, 0, 4096)) != (read2 = ByteStreams.read(in2, buf2, 0, 4096)) || !Arrays.equals(buf1, buf2)) {
                    boolean bl = false;
                    return bl;
                }
                if (read1 != 4096) {
                    boolean bl = true;
                    return bl;
                }
                continue;
                break;
            }
        }
        catch (Throwable e) {
            throw closer.rethrow(e);
        }
        finally {
            closer.close();
        }
    }

    private final class SlicedByteSource
    extends ByteSource {
        private final long offset;
        private final long length;

        private SlicedByteSource(long offset, long length) {
            Preconditions.checkArgument(offset >= 0L, "offset (%s) may not be negative", offset);
            Preconditions.checkArgument(length >= 0L, "length (%s) may not be negative", length);
            this.offset = offset;
            this.length = length;
        }

        @Override
        public InputStream openStream() throws IOException {
            InputStream in = ByteSource.this.openStream();
            if (this.offset > 0L) {
                try {
                    ByteStreams.skipFully(in, this.offset);
                }
                catch (Throwable e) {
                    Closer closer = Closer.create();
                    closer.register(in);
                    try {
                        throw closer.rethrow(e);
                    }
                    catch (Throwable throwable) {
                        closer.close();
                        throw throwable;
                    }
                }
            }
            return ByteStreams.limit(in, this.length);
        }

        @Override
        public ByteSource slice(long offset, long length) {
            Preconditions.checkArgument(offset >= 0L, "offset (%s) may not be negative", offset);
            Preconditions.checkArgument(length >= 0L, "length (%s) may not be negative", length);
            long maxLength = this.length - offset;
            return ByteSource.this.slice(this.offset + offset, Math.min(length, maxLength));
        }

        public String toString() {
            return ByteSource.this.toString() + ".slice(" + this.offset + ", " + this.length + ")";
        }
    }

    private final class AsCharSource
    extends CharSource {
        private final Charset charset;

        private AsCharSource(Charset charset) {
            this.charset = Preconditions.checkNotNull(charset);
        }

        @Override
        public Reader openStream() throws IOException {
            return new InputStreamReader(ByteSource.this.openStream(), this.charset);
        }

        public String toString() {
            return ByteSource.this.toString() + ".asCharSource(" + this.charset + ")";
        }
    }
}

