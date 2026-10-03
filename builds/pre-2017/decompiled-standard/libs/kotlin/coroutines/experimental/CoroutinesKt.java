/*
 * Decompiled with CFR 0.152.
 */
package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.SafeContinuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a%\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0081\b\u001a3\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0004\u0012\u00020\u00010\tH\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u001aD\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u001a]\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\b*#\b\u0001\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e\u00a2\u0006\u0002\b\u000f2\u0006\u0010\u0010\u001a\u0002H\r2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a>\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013\u001aW\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\b*#\b\u0001\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e\u00a2\u0006\u0002\b\u000f2\u0006\u0010\u0010\u001a\u0002H\r2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\t\u00a8\u0006\u0015"}, d2={"processBareContinuationResume", "", "completion", "Lkotlin/coroutines/experimental/Continuation;", "block", "Lkotlin/Function0;", "", "suspendCoroutine", "T", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "createCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "startCoroutine", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)V", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)V", "kotlin-stdlib"})
@JvmName(name="CoroutinesKt")
public final class CoroutinesKt {
    @SinceKotlin(version="1.1")
    public static final <R, T> void startCoroutine(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> $receiver, R receiver, @NotNull Continuation<? super T> completion) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        IntrinsicsKt.createCoroutineUnchecked($receiver, receiver, completion).resume(Unit.INSTANCE);
    }

    @SinceKotlin(version="1.1")
    public static final <T> void startCoroutine(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $receiver, @NotNull Continuation<? super T> completion) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        IntrinsicsKt.createCoroutineUnchecked($receiver, completion).resume(Unit.INSTANCE);
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <R, T> Continuation<Unit> createCoroutine(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> $receiver, R receiver, @NotNull Continuation<? super T> completion) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        return new SafeContinuation<Unit>(IntrinsicsKt.createCoroutineUnchecked($receiver, receiver, completion), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T> Continuation<Unit> createCoroutine(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $receiver, @NotNull Continuation<? super T> completion) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        return new SafeContinuation<Unit>(IntrinsicsKt.createCoroutineUnchecked($receiver, completion), IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final <T> Object suspendCoroutine(@NotNull Function1<? super Continuation<? super T>, Unit> block, @NotNull Continuation<? super T> $continuation) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        Intrinsics.checkParameterIsNotNull($continuation, "$continuation");
        Continuation<? super T> c = CoroutineIntrinsics.normalizeContinuation($continuation);
        SafeContinuation<T> safe = new SafeContinuation<T>(c);
        block.invoke(safe);
        return safe.getResult();
    }

    @InlineOnly
    private static final void processBareContinuationResume(Continuation<?> completion, Function0<? extends Object> block) {
        try {
            Object result2 = block.invoke();
            if (result2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Continuation<?> continuation2 = completion;
                if (continuation2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                }
                continuation2.resume(result2);
            }
        }
        catch (Throwable t) {
            completion.resumeWithException(t);
        }
    }
}

