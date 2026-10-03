/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks;
import org.jetbrains.annotations.NotNull;

class TypeCheckerProcedureCallbacksImpl
implements TypeCheckingProcedureCallbacks {
    TypeCheckerProcedureCallbacksImpl() {
    }

    @Override
    public boolean assertEqualTypes(@NotNull KotlinType a, @NotNull KotlinType b, @NotNull TypeCheckingProcedure typeCheckingProcedure) {
        if (a == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "a", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertEqualTypes"));
        }
        if (b == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "b", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertEqualTypes"));
        }
        if (typeCheckingProcedure == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeCheckingProcedure", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertEqualTypes"));
        }
        return typeCheckingProcedure.equalTypes(a, b);
    }

    @Override
    public boolean assertEqualTypeConstructors(@NotNull TypeConstructor a, @NotNull TypeConstructor b) {
        if (a == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "a", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertEqualTypeConstructors"));
        }
        if (b == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "b", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertEqualTypeConstructors"));
        }
        return a.equals(b);
    }

    @Override
    public boolean assertSubtype(@NotNull KotlinType subtype, @NotNull KotlinType supertype, @NotNull TypeCheckingProcedure typeCheckingProcedure) {
        if (subtype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertSubtype"));
        }
        if (supertype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertSubtype"));
        }
        if (typeCheckingProcedure == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeCheckingProcedure", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "assertSubtype"));
        }
        return typeCheckingProcedure.isSubtypeOf(subtype, supertype);
    }

    @Override
    public boolean capture(@NotNull KotlinType type2, @NotNull TypeProjection typeProjection) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "capture"));
        }
        if (typeProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeProjection", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "capture"));
        }
        return false;
    }

    @Override
    public boolean noCorrespondingSupertype(@NotNull KotlinType subtype, @NotNull KotlinType supertype) {
        if (subtype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "noCorrespondingSupertype"));
        }
        if (supertype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl", "noCorrespondingSupertype"));
        }
        return false;
    }
}

