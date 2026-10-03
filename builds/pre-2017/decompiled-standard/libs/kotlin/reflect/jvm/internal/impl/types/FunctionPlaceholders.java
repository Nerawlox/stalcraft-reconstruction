/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FunctionPlaceholderTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public final class FunctionPlaceholders {
    private final KotlinBuiltIns builtIns;

    @NotNull
    public final KotlinType createFunctionPlaceholderType(@NotNull List<? extends KotlinType> argumentTypes, boolean hasDeclaredArguments) {
        Intrinsics.checkParameterIsNotNull(argumentTypes, "argumentTypes");
        SimpleType simpleType2 = ErrorUtils.createErrorTypeWithCustomConstructor("function placeholder type", new FunctionPlaceholderTypeConstructor(argumentTypes, hasDeclaredArguments, this.builtIns));
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "ErrorUtils.createErrorTy\u2026ents, builtIns)\n        )");
        return simpleType2;
    }

    public FunctionPlaceholders(@NotNull KotlinBuiltIns builtIns) {
        Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
        this.builtIns = builtIns;
    }
}

