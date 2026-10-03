/*
 * Decompiled with CFR 0.152.
 */
package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ByteIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u000b\u001a\u00020\f*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\u0087\b\u001a\u001d\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0086\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u001a\u0017\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u00a8\u0006\u001f"}, d2={"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", "out", "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"})
@JvmName(name="ByteStreamsKt")
public final class ByteStreamsKt {
    @NotNull
    public static final ByteIterator iterator(@NotNull BufferedInputStream $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return new ByteIterator($receiver){
            private int nextByte;
            private boolean nextPrepared;
            private boolean finished;
            final /* synthetic */ BufferedInputStream receiver$0;

            public final int getNextByte() {
                return this.nextByte;
            }

            public final void setNextByte(int n) {
                this.nextByte = n;
            }

            public final boolean getNextPrepared() {
                return this.nextPrepared;
            }

            public final void setNextPrepared(boolean bl) {
                this.nextPrepared = bl;
            }

            public final boolean getFinished() {
                return this.finished;
            }

            public final void setFinished(boolean bl) {
                this.finished = bl;
            }

            private final void prepareNext() {
                if (!this.nextPrepared && !this.finished) {
                    this.nextByte = this.receiver$0.read();
                    this.nextPrepared = true;
                    this.finished = this.nextByte == -1;
                }
            }

            public boolean hasNext() {
                this.prepareNext();
                return !this.finished;
            }

            public byte nextByte() {
                this.prepareNext();
                if (this.finished) {
                    throw (Throwable)new NoSuchElementException("Input stream is over.");
                }
                byte res = (byte)this.nextByte;
                this.nextPrepared = false;
                return res;
            }
            {
                this.receiver$0 = $receiver;
                this.nextByte = -1;
            }
        };
    }

    @InlineOnly
    private static final ByteArrayInputStream byteInputStream(@NotNull String $receiver, Charset charset) {
        ByteArrayInputStream byteArrayInputStream;
        String string = $receiver;
        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream;
        String string2 = string;
        if (string2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] byArray = string2.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(byArray, "(this as java.lang.String).getBytes(charset)");
        byte[] byArray2 = byArray;
        byteArrayInputStream2(byArray2);
        return byteArrayInputStream3;
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ ByteArrayInputStream byteInputStream$default(String $receiver, Charset charset, int n, Object object) {
        ByteArrayInputStream byteArrayInputStream;
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        object = $receiver;
        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream;
        Object object2 = object;
        if (object2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] byArray = ((String)object2).getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(byArray, "(this as java.lang.String).getBytes(charset)");
        byte[] byArray2 = byArray;
        byteArrayInputStream2(byArray2);
        return byteArrayInputStream3;
    }

    @InlineOnly
    private static final ByteArrayInputStream inputStream(@NotNull byte[] $receiver) {
        return new ByteArrayInputStream($receiver);
    }

    @InlineOnly
    private static final ByteArrayInputStream inputStream(@NotNull byte[] $receiver, int offset, int length) {
        return new ByteArrayInputStream($receiver, offset, length);
    }

    @InlineOnly
    private static final BufferedInputStream buffered(@NotNull InputStream $receiver, int bufferSize) {
        return $receiver instanceof BufferedInputStream ? (BufferedInputStream)$receiver : new BufferedInputStream($receiver, bufferSize);
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ BufferedInputStream buffered$default(InputStream $receiver, int bufferSize, int n, Object object) {
        if ((n & 1) != 0) {
            bufferSize = 8192;
        }
        return $receiver instanceof BufferedInputStream ? (BufferedInputStream)$receiver : new BufferedInputStream($receiver, bufferSize);
    }

    @InlineOnly
    private static final InputStreamReader reader(@NotNull InputStream $receiver, Charset charset) {
        return new InputStreamReader($receiver, charset);
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ InputStreamReader reader$default(InputStream $receiver, Charset charset, int n, Object object) {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new InputStreamReader($receiver, charset);
    }

    @InlineOnly
    private static final BufferedReader bufferedReader(@NotNull InputStream $receiver, Charset charset) {
        Closeable closeable = $receiver;
        closeable = new InputStreamReader((InputStream)closeable, charset);
        int n = 0;
        boolean bl = true;
        Object var6_5 = null;
        if (bl & true) {
            n = 8192;
        }
        return closeable instanceof BufferedReader ? (BufferedReader)closeable : new BufferedReader((Reader)closeable, n);
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ BufferedReader bufferedReader$default(InputStream $receiver, Charset charset, int n, Object object) {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        object = $receiver;
        object = new InputStreamReader((InputStream)object, charset);
        int n2 = 0;
        boolean bl = true;
        Object var6_6 = null;
        if (bl & true) {
            n2 = 8192;
        }
        return object instanceof BufferedReader ? (BufferedReader)object : new BufferedReader((Reader)object, n2);
    }

    @InlineOnly
    private static final BufferedOutputStream buffered(@NotNull OutputStream $receiver, int bufferSize) {
        return $receiver instanceof BufferedOutputStream ? (BufferedOutputStream)$receiver : new BufferedOutputStream($receiver, bufferSize);
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ BufferedOutputStream buffered$default(OutputStream $receiver, int bufferSize, int n, Object object) {
        if ((n & 1) != 0) {
            bufferSize = 8192;
        }
        return $receiver instanceof BufferedOutputStream ? (BufferedOutputStream)$receiver : new BufferedOutputStream($receiver, bufferSize);
    }

    @InlineOnly
    private static final OutputStreamWriter writer(@NotNull OutputStream $receiver, Charset charset) {
        return new OutputStreamWriter($receiver, charset);
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ OutputStreamWriter writer$default(OutputStream $receiver, Charset charset, int n, Object object) {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new OutputStreamWriter($receiver, charset);
    }

    @InlineOnly
    private static final BufferedWriter bufferedWriter(@NotNull OutputStream $receiver, Charset charset) {
        Closeable closeable = $receiver;
        closeable = new OutputStreamWriter((OutputStream)closeable, charset);
        int n = 0;
        boolean bl = true;
        Object var6_5 = null;
        if (bl & true) {
            n = 8192;
        }
        return closeable instanceof BufferedWriter ? (BufferedWriter)closeable : new BufferedWriter((Writer)closeable, n);
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ BufferedWriter bufferedWriter$default(OutputStream $receiver, Charset charset, int n, Object object) {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        object = $receiver;
        object = new OutputStreamWriter((OutputStream)object, charset);
        int n2 = 0;
        boolean bl = true;
        Object var6_6 = null;
        if (bl & true) {
            n2 = 8192;
        }
        return object instanceof BufferedWriter ? (BufferedWriter)object : new BufferedWriter((Writer)object, n2);
    }

    public static final long copyTo(@NotNull InputStream $receiver, @NotNull OutputStream out, int bufferSize) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(out, "out");
        long bytesCopied = 0L;
        byte[] buffer = new byte[bufferSize];
        int bytes = $receiver.read(buffer);
        while (bytes >= 0) {
            out.write(buffer, 0, bytes);
            bytesCopied += (long)bytes;
            bytes = $receiver.read(buffer);
        }
        return bytesCopied;
    }

    public static /* bridge */ /* synthetic */ long copyTo$default(InputStream inputStream, OutputStream outputStream, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 8192;
        }
        return ByteStreamsKt.copyTo(inputStream, outputStream, n);
    }

    @NotNull
    public static final byte[] readBytes(@NotNull InputStream $receiver, int estimatedSize) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(Math.max(estimatedSize, $receiver.available()));
        ByteStreamsKt.copyTo$default($receiver, buffer, 0, 2, null);
        byte[] byArray = buffer.toByteArray();
        Intrinsics.checkExpressionValueIsNotNull(byArray, "buffer.toByteArray()");
        return byArray;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ byte[] readBytes$default(InputStream inputStream, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 8192;
        }
        return ByteStreamsKt.readBytes(inputStream, n);
    }
}

