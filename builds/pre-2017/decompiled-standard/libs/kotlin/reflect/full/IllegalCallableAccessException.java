/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/reflect/full/IllegalCallableAccessException;", "Lkotlin/reflect/IllegalCallableAccessException;", "cause", "Ljava/lang/IllegalAccessException;", "(Ljava/lang/IllegalAccessException;)V", "kotlin-reflection"})
@SinceKotlin(version="1.1")
public final class IllegalCallableAccessException
extends kotlin.reflect.IllegalCallableAccessException {
    public IllegalCallableAccessException(@NotNull IllegalAccessException cause) {
        Intrinsics.checkParameterIsNotNull(cause, "cause");
        super(cause);
    }
}

