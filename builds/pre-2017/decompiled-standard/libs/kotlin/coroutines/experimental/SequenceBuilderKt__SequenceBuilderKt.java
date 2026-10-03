/*
 * Decompiled with CFR 0.152.
 */
package kotlin.coroutines.experimental;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.SequenceBuilder;
import kotlin.coroutines.experimental.SequenceBuilderIterator;
import kotlin.coroutines.experimental.SequenceBuilderKt;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000:\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0004\b\u0000\u0010\t2-\u0010\n\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u00a2\u0006\u0002\b\u0010H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001aK\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\t0\u0013\"\u0004\b\u0000\u0010\t2-\u0010\n\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b\u00a2\u0006\u0002\b\u0010H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0012\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0012\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0012\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002X\u0082T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\t\u00a8\u0006\u0015"}, d2={"State_Done", "", "Lkotlin/coroutines/experimental/State;", "State_Failed", "State_ManyReady", "State_NotReady", "State_Ready", "buildIterator", "", "T", "builderAction", "Lkotlin/Function2;", "Lkotlin/coroutines/experimental/SequenceBuilder;", "Lkotlin/coroutines/experimental/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "buildSequence", "Lkotlin/sequences/Sequence;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, xs="kotlin/coroutines/experimental/SequenceBuilderKt")
class SequenceBuilderKt__SequenceBuilderKt {
    private static final int State_NotReady = 0;
    private static final int State_ManyReady = 1;
    private static final int State_Ready = 2;
    private static final int State_Done = 3;
    private static final int State_Failed = 4;

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T> Sequence<T> buildSequence(@NotNull Function2<? super SequenceBuilder<? super T>, ? super Continuation<? super Unit>, ? extends Object> builderAction) {
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        return new Sequence<T>(builderAction){
            final /* synthetic */ Function2 $builderAction$inlined;
            {
                this.$builderAction$inlined = function2;
            }

            public Iterator<T> iterator() {
                return SequenceBuilderKt.buildIterator(this.$builderAction$inlined);
            }
        };
    }

    @SinceKotlin(version="1.1")
    @NotNull
    public static final <T> Iterator<T> buildIterator(@NotNull Function2<? super SequenceBuilder<? super T>, ? super Continuation<? super Unit>, ? extends Object> builderAction) {
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        SequenceBuilderIterator iterator2 = new SequenceBuilderIterator();
        iterator2.setNextStep(IntrinsicsKt.createCoroutineUnchecked(builderAction, iterator2, iterator2));
        return iterator2;
    }
}

