/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;

public final class FunctionsKt {
    private static final Function1<Object, Object> IDENTITY = IDENTITY.1.INSTANCE;
    private static final Function1<Object, Boolean> ALWAYS_TRUE = ALWAYS_TRUE.1.INSTANCE;
    private static final Function1<Object, Object> ALWAYS_NULL = ALWAYS_NULL.1.INSTANCE;
    @NotNull
    private static final Function1<Object, Unit> DO_NOTHING = DO_NOTHING.1.INSTANCE;
    @NotNull
    private static final Function2<Object, Object, Unit> DO_NOTHING_2 = DO_NOTHING_2.1.INSTANCE;
    @NotNull
    private static final Function3<Object, Object, Object, Unit> DO_NOTHING_3 = DO_NOTHING_3.1.INSTANCE;

    @NotNull
    public static final <T> Function1<T, T> identity() {
        Function1<Object, Object> function1 = IDENTITY;
        if (function1 == null) {
            throw new TypeCastException("null cannot be cast to non-null type (T) -> T");
        }
        return (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1);
    }

    @NotNull
    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return ALWAYS_TRUE;
    }

    @NotNull
    public static final <T, R> Function1<T, R> alwaysNull() {
        Function1<Object, Object> function1 = ALWAYS_NULL;
        if (function1 == null) {
            throw new TypeCastException("null cannot be cast to non-null type (T) -> R?");
        }
        return (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1);
    }

    @NotNull
    public static final Function1<Object, Unit> getDO_NOTHING() {
        return DO_NOTHING;
    }

    @NotNull
    public static final Function2<Object, Object, Unit> getDO_NOTHING_2() {
        return DO_NOTHING_2;
    }

    @NotNull
    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }

    @NotNull
    public static final <T> Function1<T, Unit> doNothing() {
        return DO_NOTHING;
    }
}

