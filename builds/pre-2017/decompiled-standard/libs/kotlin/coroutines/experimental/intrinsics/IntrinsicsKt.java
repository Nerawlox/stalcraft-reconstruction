/*
 * Decompiled with CFR 0.152.
 */
package kotlin.coroutines.experimental.intrinsics;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u00072\u0010\b\u0004\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0083\b\u001a5\u0010\r\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u001c\b\u0004\u0010\u000b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000eH\u0087H\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001aD\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\"\u0004\b\u0000\u0010\t*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a]\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\t*#\b\u0001\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013\u00a2\u0006\u0002\b\u00142\u0006\u0010\u0015\u001a\u0002H\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u0007H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\"\u001c\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\t\u00a8\u0006\u0017"}, d2={"COROUTINE_SUSPENDED", "", "COROUTINE_SUSPENDED$annotations", "()V", "getCOROUTINE_SUSPENDED", "()Ljava/lang/Object;", "buildContinuationByInvokeCall", "Lkotlin/coroutines/experimental/Continuation;", "", "T", "completion", "block", "Lkotlin/Function0;", "suspendCoroutineOrReturn", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "createCoroutineUnchecked", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Lkotlin/coroutines/experimental/Continuation;", "kotlin-stdlib"})
@JvmName(name="IntrinsicsKt")
public final class IntrinsicsKt {
    @NotNull
    private static final Object COROUTINE_SUSPENDED = new Object();

    @SinceKotlin(version="1.1")
    @InlineOnly
    private static final <T> Object suspendCoroutineOrReturn(Function1<? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $continuation) {
        if (null == null) {
            Intrinsics.throwNpe();
        }
        return null;
    }

    @SinceKotlin(version="1.1")
    private static /* synthetic */ void COROUTINE_SUSPENDED$annotations() {
    }

    @NotNull
    public static final Object getCOROUTINE_SUSPENDED() {
        return COROUTINE_SUSPENDED;
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T> Continuation<Unit> createCoroutineUnchecked(@NotNull Function1<? super Continuation<? super T>, ? extends Object> $receiver, @NotNull Continuation<? super T> completion) {
        Continuation<Object> continuation2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        if (!($receiver instanceof CoroutineImpl)) {
            Continuation<Unit> continuation$iv = new Continuation<Unit>(completion, $receiver, completion){
                final /* synthetic */ Continuation $completion;
                final /* synthetic */ Function1 receiver$0$inlined;
                final /* synthetic */ Continuation $completion$inlined;
                {
                    this.$completion = $captured_local_variable$0;
                    this.receiver$0$inlined = function1;
                    this.$completion$inlined = continuation2;
                }

                public CoroutineContext getContext() {
                    return this.$completion.getContext();
                }

                public void resume(Unit value) {
                    Continuation continuation2 = this.$completion;
                    try {
                        Function1 function1 = this.receiver$0$inlined;
                        if (function1 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type (kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
                        }
                        R r = ((Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(this.$completion$inlined);
                        if (r != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            Continuation continuation3 = continuation2;
                            if (continuation3 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                            }
                            continuation3.resume(r);
                        }
                    }
                    catch (Throwable throwable) {
                        continuation2.resumeWithException(throwable);
                    }
                }

                public void resumeWithException(Throwable exception) {
                    this.$completion.resumeWithException(exception);
                }
            };
            continuation2 = CoroutineIntrinsics.interceptContinuationIfNeeded(completion.getContext(), (Continuation)continuation$iv);
        } else {
            Continuation<Unit> continuation3 = ((CoroutineImpl)((Object)$receiver)).create(completion);
            if (continuation3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.jvm.internal.CoroutineImpl");
            }
            continuation2 = ((CoroutineImpl)continuation3).getFacade();
        }
        return continuation2;
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <R, T> Continuation<Unit> createCoroutineUnchecked(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> $receiver, R receiver, @NotNull Continuation<? super T> completion) {
        Continuation<Object> continuation2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        if (!($receiver instanceof CoroutineImpl)) {
            Continuation<Unit> continuation$iv = new Continuation<Unit>(completion, $receiver, receiver, completion){
                final /* synthetic */ Continuation $completion;
                final /* synthetic */ Function2 receiver$0$inlined;
                final /* synthetic */ Object $receiver$inlined;
                final /* synthetic */ Continuation $completion$inlined;
                {
                    this.$completion = $captured_local_variable$0;
                    this.receiver$0$inlined = function2;
                    this.$receiver$inlined = object;
                    this.$completion$inlined = continuation2;
                }

                public CoroutineContext getContext() {
                    return this.$completion.getContext();
                }

                public void resume(Unit value) {
                    Continuation continuation2 = this.$completion;
                    try {
                        Function2 function2 = this.receiver$0$inlined;
                        if (function2 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type (R, kotlin.coroutines.experimental.Continuation<T>) -> kotlin.Any?");
                        }
                        R r = ((Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(this.$receiver$inlined, this.$completion$inlined);
                        if (r != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            Continuation continuation3 = continuation2;
                            if (continuation3 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                            }
                            continuation3.resume(r);
                        }
                    }
                    catch (Throwable throwable) {
                        continuation2.resumeWithException(throwable);
                    }
                }

                public void resumeWithException(Throwable exception) {
                    this.$completion.resumeWithException(exception);
                }
            };
            continuation2 = CoroutineIntrinsics.interceptContinuationIfNeeded(completion.getContext(), (Continuation)continuation$iv);
        } else {
            Continuation<Unit> continuation3 = ((CoroutineImpl)((Object)$receiver)).create(receiver, completion);
            if (continuation3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.jvm.internal.CoroutineImpl");
            }
            continuation2 = ((CoroutineImpl)continuation3).getFacade();
        }
        return continuation2;
    }

    private static final <T> Continuation<Unit> buildContinuationByInvokeCall(Continuation<? super T> completion, Function0<? extends Object> block) {
        Continuation<Unit> continuation2 = new Continuation<Unit>(completion, block){
            final /* synthetic */ Continuation $completion;
            final /* synthetic */ Function0 $block;

            @NotNull
            public CoroutineContext getContext() {
                return this.$completion.getContext();
            }

            public void resume(@NotNull Unit value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                Continuation continuation2 = this.$completion;
                try {
                    R r = this.$block.invoke();
                    if (r != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        Continuation continuation3 = continuation2;
                        if (continuation3 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.Continuation<kotlin.Any?>");
                        }
                        continuation3.resume(r);
                    }
                }
                catch (Throwable throwable) {
                    continuation2.resumeWithException(throwable);
                }
            }

            public void resumeWithException(@NotNull Throwable exception) {
                Intrinsics.checkParameterIsNotNull(exception, "exception");
                this.$completion.resumeWithException(exception);
            }
            {
                this.$completion = $captured_local_variable$0;
                this.$block = $captured_local_variable$1;
            }
        };
        return CoroutineIntrinsics.interceptContinuationIfNeeded(completion.getContext(), (Continuation)continuation2);
    }
}

