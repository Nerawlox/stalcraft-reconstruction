/*
 * Decompiled with CFR 0.152.
 */
package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.io.ByteStreamsKt;
import kotlin.io.LinesSequence;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\r\u001a\u0010\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015*\u00020\u0002\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\u0002\u001a\u0017\u0010\u0016\u001a\u00020\u000e*\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u001a*\u00020\u000eH\u0087\b\u001a2\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u0002H\u001c0\rH\u0086\b\u00a2\u0006\u0002\u0010\u001e\u00a8\u0006\u001f"}, d2={"buffered", "Ljava/io/BufferedReader;", "Ljava/io/Reader;", "bufferSize", "", "Ljava/io/BufferedWriter;", "Ljava/io/Writer;", "copyTo", "", "out", "forEachLine", "", "action", "Lkotlin/Function1;", "", "lineSequence", "Lkotlin/sequences/Sequence;", "readBytes", "", "Ljava/net/URL;", "readLines", "", "readText", "charset", "Ljava/nio/charset/Charset;", "reader", "Ljava/io/StringReader;", "useLines", "T", "block", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"})
@JvmName(name="TextStreamsKt")
public final class TextStreamsKt {
    @InlineOnly
    private static final BufferedReader buffered(@NotNull Reader $receiver, int bufferSize) {
        return $receiver instanceof BufferedReader ? (BufferedReader)$receiver : new BufferedReader($receiver, bufferSize);
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ BufferedReader buffered$default(Reader $receiver, int bufferSize, int n, Object object) {
        if ((n & 1) != 0) {
            bufferSize = 8192;
        }
        return $receiver instanceof BufferedReader ? (BufferedReader)$receiver : new BufferedReader($receiver, bufferSize);
    }

    @InlineOnly
    private static final BufferedWriter buffered(@NotNull Writer $receiver, int bufferSize) {
        return $receiver instanceof BufferedWriter ? (BufferedWriter)$receiver : new BufferedWriter($receiver, bufferSize);
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ BufferedWriter buffered$default(Writer $receiver, int bufferSize, int n, Object object) {
        if ((n & 1) != 0) {
            bufferSize = 8192;
        }
        return $receiver instanceof BufferedWriter ? (BufferedWriter)$receiver : new BufferedWriter($receiver, bufferSize);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public static final void forEachLine(@NotNull Reader $receiver, @NotNull Function1<? super String, Unit> action) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Reader $receiver$iv = $receiver;
        Closeable closeable = $receiver$iv;
        int n = 0;
        boolean bl = true;
        Object var6_9 = null;
        if (bl & true) {
            n = 8192;
        }
        closeable = closeable instanceof BufferedReader ? (BufferedReader)closeable : new BufferedReader((Reader)closeable, n);
        n = 0;
        try {
            void $receiver$iv2;
            Sequence<String> it;
            BufferedReader it$iv = (BufferedReader)closeable;
            Sequence<String> sequence = it = TextStreamsKt.lineSequence(it$iv);
            Function1<? super String, Unit> action$iv = action;
            for (Object element$iv : $receiver$iv2) {
                action$iv.invoke((String)element$iv);
            }
            Unit unit = Unit.INSTANCE;
        }
        catch (Exception exception) {
            n = 1;
            try {
                Closeable closeable2 = closeable;
                if (closeable2 != null) {
                    closeable2.close();
                }
            }
            catch (Exception exception2) {
                // empty catch block
            }
            throw (Throwable)exception;
        }
        finally {
            if (n == 0) {
                Closeable closeable3 = closeable;
                if (closeable3 != null) {
                    closeable3.close();
                }
            }
        }
    }

    @NotNull
    public static final List<String> readLines(@NotNull Reader $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ArrayList result2 = new ArrayList();
        TextStreamsKt.forEachLine($receiver, (Function1<? super String, Unit>)new Function1<String, Unit>(result2){
            final /* synthetic */ ArrayList $result;

            public final void invoke(@NotNull String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                this.$result.add(it);
            }
            {
                this.$result = arrayList;
                super(1);
            }
        });
        return result2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static final <T> T useLines(@NotNull Reader $receiver, @NotNull Function1<? super Sequence<String>, ? extends T> block) {
        T t;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Closeable closeable = $receiver;
        int n = 0;
        boolean bl = true;
        Object var6_8 = null;
        if (bl & true) {
            n = 8192;
        }
        closeable = closeable instanceof BufferedReader ? (BufferedReader)closeable : new BufferedReader((Reader)closeable, n);
        n = 0;
        try {
            BufferedReader it = (BufferedReader)closeable;
            t = block.invoke(TextStreamsKt.lineSequence(it));
        }
        catch (Exception exception) {
            n = 1;
            try {
                Closeable closeable2 = closeable;
                if (closeable2 != null) {
                    closeable2.close();
                }
            }
            catch (Exception exception2) {
                // empty catch block
            }
            throw (Throwable)exception;
        }
        finally {
            InlineMarker.finallyStart(1);
            if (n == 0) {
                Closeable closeable3 = closeable;
                if (closeable3 != null) {
                    closeable3.close();
                }
            }
            InlineMarker.finallyEnd(1);
        }
        return t;
    }

    @InlineOnly
    private static final StringReader reader(@NotNull String $receiver) {
        return new StringReader($receiver);
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull BufferedReader $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return SequencesKt.constrainOnce(new LinesSequence($receiver));
    }

    @NotNull
    public static final String readText(@NotNull Reader $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        StringWriter buffer = new StringWriter();
        TextStreamsKt.copyTo$default($receiver, buffer, 0, 2, null);
        String string = buffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "buffer.toString()");
        return string;
    }

    public static final long copyTo(@NotNull Reader $receiver, @NotNull Writer out, int bufferSize) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(out, "out");
        long charsCopied = 0L;
        char[] buffer = new char[bufferSize];
        int chars = $receiver.read(buffer);
        while (chars >= 0) {
            out.write(buffer, 0, chars);
            charsCopied += (long)chars;
            chars = $receiver.read(buffer);
        }
        return charsCopied;
    }

    public static /* bridge */ /* synthetic */ long copyTo$default(Reader reader, Writer writer, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 8192;
        }
        return TextStreamsKt.copyTo(reader, writer, n);
    }

    @InlineOnly
    private static final String readText(@NotNull URL $receiver, Charset charset) {
        byte[] byArray = TextStreamsKt.readBytes($receiver);
        return new String(byArray, charset);
    }

    @InlineOnly
    static /* bridge */ /* synthetic */ String readText$default(URL $receiver, Charset charset, int n, Object object) {
        if ((n & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        object = TextStreamsKt.readBytes($receiver);
        return new String((byte[])object, charset);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public static final byte[] readBytes(@NotNull URL $receiver) {
        byte[] byArray;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Closeable closeable = $receiver.openStream();
        boolean bl = false;
        try {
            InputStream it = (InputStream)closeable;
            byArray = ByteStreamsKt.readBytes$default(it, 0, 1, null);
        }
        catch (Exception exception) {
            bl = true;
            try {
                Closeable closeable2 = closeable;
                if (closeable2 != null) {
                    closeable2.close();
                }
            }
            catch (Exception exception2) {
                // empty catch block
            }
            throw (Throwable)exception;
        }
        finally {
            if (!bl) {
                Closeable closeable3 = closeable;
                if (closeable3 != null) {
                    closeable3.close();
                }
            }
        }
        return byArray;
    }
}

