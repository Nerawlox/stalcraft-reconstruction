/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCapabilitiesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerProcedureCallbacksImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks;
import kotlin.reflect.jvm.internal.impl.types.checker.UtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeCheckingProcedure {
    private final TypeCheckingProcedureCallbacks constraints;

    @Nullable
    public static KotlinType findCorrespondingSupertype(@NotNull KotlinType subtype, @NotNull KotlinType supertype) {
        if (subtype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "findCorrespondingSupertype"));
        }
        if (supertype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "findCorrespondingSupertype"));
        }
        return TypeCheckingProcedure.findCorrespondingSupertype(subtype, supertype, new TypeCheckerProcedureCallbacksImpl());
    }

    @Nullable
    public static KotlinType findCorrespondingSupertype(@NotNull KotlinType subtype, @NotNull KotlinType supertype, @NotNull TypeCheckingProcedureCallbacks typeCheckingProcedureCallbacks) {
        if (subtype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "findCorrespondingSupertype"));
        }
        if (supertype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "findCorrespondingSupertype"));
        }
        if (typeCheckingProcedureCallbacks == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeCheckingProcedureCallbacks", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "findCorrespondingSupertype"));
        }
        return UtilsKt.findCorrespondingSupertype(subtype, supertype, typeCheckingProcedureCallbacks);
    }

    @NotNull
    private static KotlinType getOutType(@NotNull TypeParameterDescriptor parameter, @NotNull TypeProjection argument) {
        if (parameter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameter", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getOutType"));
        }
        if (argument == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "argument", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getOutType"));
        }
        boolean isInProjected = argument.getProjectionKind() == Variance.IN_VARIANCE || parameter.getVariance() == Variance.IN_VARIANCE;
        KotlinType kotlinType = isInProjected ? DescriptorUtilsKt.getBuiltIns(parameter).getNullableAnyType() : argument.getType();
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getOutType"));
        }
        return kotlinType;
    }

    @NotNull
    private static KotlinType getInType(@NotNull TypeParameterDescriptor parameter, @NotNull TypeProjection argument) {
        if (parameter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameter", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getInType"));
        }
        if (argument == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "argument", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getInType"));
        }
        boolean isOutProjected = argument.getProjectionKind() == Variance.OUT_VARIANCE || parameter.getVariance() == Variance.OUT_VARIANCE;
        KotlinType kotlinType = isOutProjected ? DescriptorUtilsKt.getBuiltIns(parameter).getNothingType() : argument.getType();
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getInType"));
        }
        return kotlinType;
    }

    public TypeCheckingProcedure(TypeCheckingProcedureCallbacks constraints) {
        this.constraints = constraints;
    }

    public boolean equalTypes(@NotNull KotlinType type1, @NotNull KotlinType type2) {
        TypeConstructor constructor2;
        if (type1 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type1", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "equalTypes"));
        }
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type2", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "equalTypes"));
        }
        if (type1 == type2) {
            return true;
        }
        if (FlexibleTypesKt.isFlexible(type1)) {
            if (FlexibleTypesKt.isFlexible(type2)) {
                return !type1.isError() && !type2.isError() && this.isSubtypeOf(type1, type2) && this.isSubtypeOf(type2, type1);
            }
            return this.heterogeneousEquivalence(type2, type1);
        }
        if (FlexibleTypesKt.isFlexible(type2)) {
            return this.heterogeneousEquivalence(type1, type2);
        }
        if (type1.isMarkedNullable() != type2.isMarkedNullable()) {
            return false;
        }
        if (type1.isMarkedNullable()) {
            return this.constraints.assertEqualTypes(TypeUtils.makeNotNullable(type1), TypeUtils.makeNotNullable(type2), this);
        }
        TypeConstructor constructor1 = type1.getConstructor();
        if (!this.constraints.assertEqualTypeConstructors(constructor1, constructor2 = type2.getConstructor())) {
            return false;
        }
        List<TypeProjection> type1Arguments = type1.getArguments();
        List<TypeProjection> type2Arguments = type2.getArguments();
        if (type1Arguments.size() != type2Arguments.size()) {
            return false;
        }
        for (int i = 0; i < type1Arguments.size(); ++i) {
            TypeProjection typeProjection1 = type1Arguments.get(i);
            TypeProjection typeProjection2 = type2Arguments.get(i);
            if (typeProjection1.isStarProjection() && typeProjection2.isStarProjection()) continue;
            TypeParameterDescriptor typeParameter1 = constructor1.getParameters().get(i);
            TypeParameterDescriptor typeParameter2 = constructor2.getParameters().get(i);
            if (this.capture(typeProjection1, typeProjection2, typeParameter1)) continue;
            if (TypeCheckingProcedure.getEffectiveProjectionKind(typeParameter1, typeProjection1) != TypeCheckingProcedure.getEffectiveProjectionKind(typeParameter2, typeProjection2)) {
                return false;
            }
            if (this.constraints.assertEqualTypes(typeProjection1.getType(), typeProjection2.getType(), this)) continue;
            return false;
        }
        return true;
    }

    protected boolean heterogeneousEquivalence(KotlinType inflexibleType, KotlinType flexibleType) {
        assert (!FlexibleTypesKt.isFlexible(inflexibleType)) : "Only inflexible types are allowed here: " + inflexibleType;
        return this.isSubtypeOf(FlexibleTypesKt.asFlexibleType(flexibleType).getLowerBound(), inflexibleType) && this.isSubtypeOf(inflexibleType, FlexibleTypesKt.asFlexibleType(flexibleType).getUpperBound());
    }

    public static EnrichedProjectionKind getEffectiveProjectionKind(@NotNull TypeParameterDescriptor typeParameter, @NotNull TypeProjection typeArgument) {
        if (typeParameter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameter", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getEffectiveProjectionKind"));
        }
        if (typeArgument == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeArgument", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "getEffectiveProjectionKind"));
        }
        Variance a = typeParameter.getVariance();
        Variance b = typeArgument.getProjectionKind();
        if (b == Variance.INVARIANT) {
            Variance t = a;
            a = b;
            b = t;
        }
        if (a == Variance.IN_VARIANCE && b == Variance.OUT_VARIANCE) {
            return EnrichedProjectionKind.STAR;
        }
        if (a == Variance.OUT_VARIANCE && b == Variance.IN_VARIANCE) {
            return EnrichedProjectionKind.STAR;
        }
        return EnrichedProjectionKind.fromVariance(b);
    }

    public boolean isSubtypeOf(@NotNull KotlinType subtype, @NotNull KotlinType supertype) {
        if (subtype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "isSubtypeOf"));
        }
        if (supertype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "isSubtypeOf"));
        }
        if (TypeCapabilitiesKt.sameTypeConstructors(subtype, supertype)) {
            return !subtype.isMarkedNullable() || supertype.isMarkedNullable();
        }
        KotlinType subtypeRepresentative = TypeCapabilitiesKt.getSubtypeRepresentative(subtype);
        KotlinType supertypeRepresentative = TypeCapabilitiesKt.getSupertypeRepresentative(supertype);
        if (subtypeRepresentative != subtype || supertypeRepresentative != supertype) {
            return this.isSubtypeOf(subtypeRepresentative, supertypeRepresentative);
        }
        return this.isSubtypeOfForRepresentatives(subtype, supertype);
    }

    private boolean isSubtypeOfForRepresentatives(KotlinType subtype, KotlinType supertype) {
        if (subtype.isError() || supertype.isError()) {
            return true;
        }
        if (!supertype.isMarkedNullable() && subtype.isMarkedNullable()) {
            return false;
        }
        if (KotlinBuiltIns.isNothingOrNullableNothing(subtype)) {
            return true;
        }
        KotlinType closestSupertype = TypeCheckingProcedure.findCorrespondingSupertype(subtype, supertype, this.constraints);
        if (closestSupertype == null) {
            return this.constraints.noCorrespondingSupertype(subtype, supertype);
        }
        if (!supertype.isMarkedNullable() && closestSupertype.isMarkedNullable()) {
            return false;
        }
        return this.checkSubtypeForTheSameConstructor(closestSupertype, supertype);
    }

    private boolean checkSubtypeForTheSameConstructor(@NotNull KotlinType subtype, @NotNull KotlinType supertype) {
        if (subtype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subtype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "checkSubtypeForTheSameConstructor"));
        }
        if (supertype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertype", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "checkSubtypeForTheSameConstructor"));
        }
        TypeConstructor constructor = subtype.getConstructor();
        List<TypeProjection> subArguments = subtype.getArguments();
        List<TypeProjection> superArguments = supertype.getArguments();
        if (subArguments.size() != superArguments.size()) {
            return false;
        }
        List<TypeParameterDescriptor> parameters2 = constructor.getParameters();
        for (int i = 0; i < parameters2.size(); ++i) {
            boolean argumentIsErrorType;
            TypeParameterDescriptor parameter = parameters2.get(i);
            TypeProjection superArgument = superArguments.get(i);
            TypeProjection subArgument = subArguments.get(i);
            if (superArgument.isStarProjection() || this.capture(subArgument, superArgument, parameter)) continue;
            boolean bl = argumentIsErrorType = subArgument.getType().isError() || superArgument.getType().isError();
            if (!argumentIsErrorType && parameter.getVariance() == Variance.INVARIANT && subArgument.getProjectionKind() == Variance.INVARIANT && superArgument.getProjectionKind() == Variance.INVARIANT) {
                if (this.constraints.assertEqualTypes(subArgument.getType(), superArgument.getType(), this)) continue;
                return false;
            }
            KotlinType superOut = TypeCheckingProcedure.getOutType(parameter, superArgument);
            KotlinType subOut = TypeCheckingProcedure.getOutType(parameter, subArgument);
            if (!this.constraints.assertSubtype(subOut, superOut, this)) {
                return false;
            }
            KotlinType superIn = TypeCheckingProcedure.getInType(parameter, superArgument);
            KotlinType subIn = TypeCheckingProcedure.getInType(parameter, subArgument);
            if (superArgument.getProjectionKind() != Variance.OUT_VARIANCE) {
                if (this.constraints.assertSubtype(superIn, subIn, this)) continue;
                return false;
            }
            assert (KotlinBuiltIns.isNothing(superIn)) : "In component must be Nothing for out-projection";
        }
        return true;
    }

    private boolean capture(@NotNull TypeProjection subtypeArgumentProjection, @NotNull TypeProjection supertypeArgumentProjection, @NotNull TypeParameterDescriptor parameter) {
        if (subtypeArgumentProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subtypeArgumentProjection", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "capture"));
        }
        if (supertypeArgumentProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertypeArgumentProjection", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "capture"));
        }
        if (parameter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameter", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure", "capture"));
        }
        if (parameter.getVariance() != Variance.INVARIANT) {
            return false;
        }
        if (subtypeArgumentProjection.getProjectionKind() != Variance.INVARIANT && supertypeArgumentProjection.getProjectionKind() == Variance.INVARIANT) {
            return this.constraints.capture(supertypeArgumentProjection.getType(), subtypeArgumentProjection);
        }
        return false;
    }

    public static enum EnrichedProjectionKind {
        IN,
        OUT,
        INV,
        STAR;


        @NotNull
        public static EnrichedProjectionKind fromVariance(@NotNull Variance variance) {
            if (variance == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "variance", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure$EnrichedProjectionKind", "fromVariance"));
            }
            switch (variance) {
                case INVARIANT: {
                    EnrichedProjectionKind enrichedProjectionKind = INV;
                    if (enrichedProjectionKind == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure$EnrichedProjectionKind", "fromVariance"));
                    }
                    return enrichedProjectionKind;
                }
                case IN_VARIANCE: {
                    EnrichedProjectionKind enrichedProjectionKind = IN;
                    if (enrichedProjectionKind == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure$EnrichedProjectionKind", "fromVariance"));
                    }
                    return enrichedProjectionKind;
                }
                case OUT_VARIANCE: {
                    EnrichedProjectionKind enrichedProjectionKind = OUT;
                    if (enrichedProjectionKind == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure$EnrichedProjectionKind", "fromVariance"));
                    }
                    return enrichedProjectionKind;
                }
            }
            throw new IllegalStateException("Unknown variance");
        }
    }
}

