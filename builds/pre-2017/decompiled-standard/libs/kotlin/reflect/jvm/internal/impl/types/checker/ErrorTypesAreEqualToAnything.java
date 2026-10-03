/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext;
import org.jetbrains.annotations.NotNull;

public final class ErrorTypesAreEqualToAnything
implements KotlinTypeChecker {
    public static final ErrorTypesAreEqualToAnything INSTANCE;

    @Override
    public boolean isSubtypeOf(@NotNull KotlinType subtype, @NotNull KotlinType supertype) {
        NewKotlinTypeChecker newKotlinTypeChecker;
        Intrinsics.checkParameterIsNotNull(subtype, "subtype");
        Intrinsics.checkParameterIsNotNull(supertype, "supertype");
        NewKotlinTypeChecker $receiver = newKotlinTypeChecker = NewKotlinTypeChecker.INSTANCE;
        return $receiver.isSubtypeOf(new TypeCheckerContext(true), subtype.unwrap(), supertype.unwrap());
    }

    @Override
    public boolean equalTypes(@NotNull KotlinType a, @NotNull KotlinType b) {
        NewKotlinTypeChecker newKotlinTypeChecker;
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        NewKotlinTypeChecker $receiver = newKotlinTypeChecker = NewKotlinTypeChecker.INSTANCE;
        return $receiver.equalTypes(new TypeCheckerContext(true), a.unwrap(), b.unwrap());
    }

    private ErrorTypesAreEqualToAnything() {
        INSTANCE = this;
    }

    static {
        new ErrorTypesAreEqualToAnything();
    }
}

