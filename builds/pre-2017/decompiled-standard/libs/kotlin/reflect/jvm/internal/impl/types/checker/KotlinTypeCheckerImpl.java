/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerProcedureCallbacksImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
import org.jetbrains.annotations.NotNull;

public class KotlinTypeCheckerImpl
implements KotlinTypeChecker {
    private final TypeCheckingProcedure procedure;

    @NotNull
    public static KotlinTypeChecker withAxioms(final @NotNull KotlinTypeChecker.TypeConstructorEquality equalityAxioms) {
        if (equalityAxioms == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "equalityAxioms", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "withAxioms"));
        }
        KotlinTypeCheckerImpl kotlinTypeCheckerImpl = new KotlinTypeCheckerImpl(new TypeCheckingProcedure(new TypeCheckerProcedureCallbacksImpl(){

            @Override
            public boolean assertEqualTypeConstructors(@NotNull TypeConstructor constructor1, @NotNull TypeConstructor constructor2) {
                if (constructor1 == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "constructor1", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl$1", "assertEqualTypeConstructors"));
                }
                if (constructor2 == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "constructor2", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl$1", "assertEqualTypeConstructors"));
                }
                return constructor1.equals(constructor2) || equalityAxioms.equals(constructor1, constructor2);
            }
        }));
        if (kotlinTypeCheckerImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "withAxioms"));
        }
        return kotlinTypeCheckerImpl;
    }

    protected KotlinTypeCheckerImpl(@NotNull TypeCheckingProcedure procedure) {
        if (procedure == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "procedure", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "<init>"));
        }
        this.procedure = procedure;
    }

    @Override
    public boolean isSubtypeOf(@NotNull KotlinType subtype, @NotNull KotlinType supertype) {
        if (subtype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subtype", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "isSubtypeOf"));
        }
        if (supertype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertype", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "isSubtypeOf"));
        }
        return this.procedure.isSubtypeOf(subtype, supertype);
    }

    @Override
    public boolean equalTypes(@NotNull KotlinType a, @NotNull KotlinType b) {
        if (a == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "a", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "equalTypes"));
        }
        if (b == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "b", "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl", "equalTypes"));
        }
        return this.procedure.equalTypes(a, b);
    }
}

