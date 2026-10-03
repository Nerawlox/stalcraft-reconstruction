/*
 * Decompiled with CFR 0.152.
 */
package kotlin.io;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001a8\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\u0087\b\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2={"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"})
@JvmName(name="CloseableKt")
public final class CloseableKt {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @InlineOnly
    private static final <T extends Closeable, R> R use(T $receiver, Function1<? super T, ? extends R> block) {
        boolean closed = false;
        try {
            R r = block.invoke($receiver);
            return r;
        }
        catch (Exception e) {
            closed = true;
            try {
                T t = $receiver;
                if (t != null) {
                    t.close();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            throw (Throwable)e;
        }
        finally {
            InlineMarker.finallyStart(1);
            if (!closed) {
                T t = $receiver;
                if (t != null) {
                    t.close();
                }
            }
            InlineMarker.finallyEnd(1);
        }
    }

    @SinceKotlin(version="1.1")
    @PublishedApi
    public static final void closeFinally(@Nullable Closeable $receiver, @Nullable Throwable cause) {
        if ($receiver != null) {
            if (cause == null) {
                $receiver.close();
            } else {
                try {
                    $receiver.close();
                }
                catch (Throwable closeException) {
                    ExceptionsKt.addSuppressed(cause, closeException);
                }
            }
        }
    }
}

