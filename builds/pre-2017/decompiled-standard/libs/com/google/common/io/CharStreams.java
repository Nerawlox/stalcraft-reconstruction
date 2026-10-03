/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.io.AppendableWriter;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Closer;
import com.google.common.io.InputSupplier;
import com.google.common.io.LineProcessor;
import com.google.common.io.LineReader;
import com.google.common.io.MultiReader;
import com.google.common.io.OutputSupplier;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@Beta
public final class CharStreams {
    private static final int BUF_SIZE = 2048;

    private CharStreams() {
    }

    public static InputSupplier<StringReader> newReaderSupplier(String value) {
        return CharStreams.asInputSupplier(CharStreams.asCharSource(value));
    }

    public static CharSource asCharSource(String string) {
        return new StringCharSource(string);
    }

    public static InputSupplier<InputStreamReader> newReaderSupplier(InputSupplier<? extends InputStream> in, Charset charset) {
        return CharStreams.asInputSupplier(ByteStreams.asByteSource(in).asCharSource(charset));
    }

    public static OutputSupplier<OutputStreamWriter> newWriterSupplier(OutputSupplier<? extends OutputStream> out, Charset charset) {
        return CharStreams.asOutputSupplier(ByteStreams.asByteSink(out).asCharSink(charset));
    }

    public static <W extends Appendable & Closeable> void write(CharSequence from, OutputSupplier<W> to) throws IOException {
        CharStreams.asCharSink(to).write(from);
    }

    public static <R extends Readable & Closeable, W extends Appendable & Closeable> long copy(InputSupplier<R> from, OutputSupplier<W> to) throws IOException {
        return CharStreams.asCharSource(from).copyTo(CharStreams.asCharSink(to));
    }

    public static <R extends Readable & Closeable> long copy(InputSupplier<R> from, Appendable to) throws IOException {
        return CharStreams.asCharSource(from).copyTo(to);
    }

    public static long copy(Readable from, Appendable to) throws IOException {
        Preconditions.checkNotNull(from);
        Preconditions.checkNotNull(to);
        CharBuffer buf = CharBuffer.allocate(2048);
        long total = 0L;
        while (from.read(buf) != -1) {
            buf.flip();
            to.append(buf);
            total += (long)buf.remaining();
            buf.clear();
        }
        return total;
    }

    public static String toString(Readable r) throws IOException {
        return CharStreams.toStringBuilder(r).toString();
    }

    public static <R extends Readable & Closeable> String toString(InputSupplier<R> supplier) throws IOException {
        return CharStreams.asCharSource(supplier).read();
    }

    private static StringBuilder toStringBuilder(Readable r) throws IOException {
        StringBuilder sb = new StringBuilder();
        CharStreams.copy(r, (Appendable)sb);
        return sb;
    }

    public static <R extends Readable & Closeable> String readFirstLine(InputSupplier<R> supplier) throws IOException {
        return CharStreams.asCharSource(supplier).readFirstLine();
    }

    public static <R extends Readable & Closeable> List<String> readLines(InputSupplier<R> supplier) throws IOException {
        Closer closer = Closer.create();
        try {
            Readable r = (Readable)((Object)closer.register((Closeable)supplier.getInput()));
            List<String> list = CharStreams.readLines(r);
            return list;
        }
        catch (Throwable e) {
            throw closer.rethrow(e);
        }
        finally {
            closer.close();
        }
    }

    public static List<String> readLines(Readable r) throws IOException {
        String line;
        ArrayList<String> result2 = new ArrayList<String>();
        LineReader lineReader = new LineReader(r);
        while ((line = lineReader.readLine()) != null) {
            result2.add(line);
        }
        return result2;
    }

    public static <T> T readLines(Readable readable, LineProcessor<T> processor) throws IOException {
        String line;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(processor);
        LineReader lineReader = new LineReader(readable);
        while ((line = lineReader.readLine()) != null && processor.processLine(line)) {
        }
        return processor.getResult();
    }

    public static <R extends Readable & Closeable, T> T readLines(InputSupplier<R> supplier, LineProcessor<T> callback) throws IOException {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callback);
        Closer closer = Closer.create();
        try {
            Readable r = (Readable)((Object)closer.register((Closeable)supplier.getInput()));
            T t = CharStreams.readLines(r, callback);
            return t;
        }
        catch (Throwable e) {
            throw closer.rethrow(e);
        }
        finally {
            closer.close();
        }
    }

    public static InputSupplier<Reader> join(final Iterable<? extends InputSupplier<? extends Reader>> suppliers) {
        Preconditions.checkNotNull(suppliers);
        return new InputSupplier<Reader>(){

            @Override
            public Reader getInput() throws IOException {
                return new MultiReader(suppliers.iterator());
            }
        };
    }

    public static InputSupplier<Reader> join(InputSupplier<? extends Reader> ... suppliers) {
        return CharStreams.join(Arrays.asList(suppliers));
    }

    public static void skipFully(Reader reader, long n) throws IOException {
        Preconditions.checkNotNull(reader);
        while (n > 0L) {
            long amt = reader.skip(n);
            if (amt == 0L) {
                if (reader.read() == -1) {
                    throw new EOFException();
                }
                --n;
                continue;
            }
            n -= amt;
        }
    }

    public static Writer asWriter(Appendable target) {
        if (target instanceof Writer) {
            return (Writer)target;
        }
        return new AppendableWriter(target);
    }

    static <R extends Readable & Closeable> Reader asReader(final R readable) {
        Preconditions.checkNotNull(readable);
        if (readable instanceof Reader) {
            return (Reader)readable;
        }
        return new Reader(){

            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return this.read(CharBuffer.wrap(cbuf, off, len));
            }

            @Override
            public int read(CharBuffer target) throws IOException {
                return readable.read(target);
            }

            @Override
            public void close() throws IOException {
                ((Closeable)((Object)readable)).close();
            }
        };
    }

    static <R extends Reader> InputSupplier<R> asInputSupplier(final CharSource source) {
        Preconditions.checkNotNull(source);
        return new InputSupplier<R>(){

            @Override
            public R getInput() throws IOException {
                return source.openStream();
            }
        };
    }

    static <W extends Writer> OutputSupplier<W> asOutputSupplier(final CharSink sink) {
        Preconditions.checkNotNull(sink);
        return new OutputSupplier<W>(){

            @Override
            public W getOutput() throws IOException {
                return sink.openStream();
            }
        };
    }

    static <R extends Readable & Closeable> CharSource asCharSource(final InputSupplier<R> supplier) {
        Preconditions.checkNotNull(supplier);
        return new CharSource(){

            @Override
            public Reader openStream() throws IOException {
                return CharStreams.asReader((Readable)supplier.getInput());
            }
        };
    }

    static <W extends Appendable & Closeable> CharSink asCharSink(final OutputSupplier<W> supplier) {
        Preconditions.checkNotNull(supplier);
        return new CharSink(){

            @Override
            public Writer openStream() throws IOException {
                return CharStreams.asWriter((Appendable)supplier.getOutput());
            }
        };
    }

    private static final class StringCharSource
    extends CharSource {
        private static final Splitter LINE_SPLITTER = Splitter.on(Pattern.compile("\r\n|\n|\r"));
        private final String string;

        private StringCharSource(String string) {
            this.string = Preconditions.checkNotNull(string);
        }

        @Override
        public Reader openStream() {
            return new StringReader(this.string);
        }

        @Override
        public String read() {
            return this.string;
        }

        private Iterable<String> lines() {
            return new Iterable<String>(){

                @Override
                public Iterator<String> iterator() {
                    return new AbstractIterator<String>(){
                        Iterator<String> lines;
                        {
                            this.lines = LINE_SPLITTER.split(StringCharSource.this.string).iterator();
                        }

                        @Override
                        protected String computeNext() {
                            if (this.lines.hasNext()) {
                                String next = this.lines.next();
                                if (this.lines.hasNext() || !next.isEmpty()) {
                                    return next;
                                }
                            }
                            return (String)this.endOfData();
                        }
                    };
                }
            };
        }

        @Override
        public String readFirstLine() {
            Iterator<String> lines = this.lines().iterator();
            return lines.hasNext() ? lines.next() : null;
        }

        @Override
        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(this.lines());
        }

        public String toString() {
            String limited = this.string.length() <= 15 ? this.string : this.string.substring(0, 12) + "...";
            return "CharStreams.asCharSource(" + limited + ")";
        }
    }
}

