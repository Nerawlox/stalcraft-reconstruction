/*
 * Decompiled with CFR 0.152.
 */
package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.CoroutineContextImplKt;
import kotlin.coroutines.experimental.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u00a8\u0006\u0003"}, d2={"plusImpl", "Lkotlin/coroutines/experimental/CoroutineContext;", "context", "kotlin-stdlib"})
public final class CoroutineContextImplKt {
    private static final CoroutineContext plusImpl(@NotNull CoroutineContext $receiver, CoroutineContext context) {
        return context == EmptyCoroutineContext.INSTANCE ? $receiver : context.fold($receiver, plusImpl.1.INSTANCE);
    }

    @NotNull
    public static final /* synthetic */ CoroutineContext access$plusImpl(@NotNull CoroutineContext $receiver, @NotNull CoroutineContext context) {
        return CoroutineContextImplKt.plusImpl($receiver, context);
    }
}

