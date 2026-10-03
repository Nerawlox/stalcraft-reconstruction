/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.DisjointKeysUnionTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCapabilitiesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeSubstitutor {
    private static final int MAX_RECURSION_DEPTH = 100;
    public static final TypeSubstitutor EMPTY = TypeSubstitutor.create(TypeSubstitution.EMPTY);
    @NotNull
    private final TypeSubstitution substitution;

    @NotNull
    public static TypeSubstitutor create(@NotNull TypeSubstitution substitution) {
        if (substitution == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitution", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "create"));
        }
        TypeSubstitutor typeSubstitutor2 = new TypeSubstitutor(substitution);
        if (typeSubstitutor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "create"));
        }
        return typeSubstitutor2;
    }

    @NotNull
    public static TypeSubstitutor createChainedSubstitutor(@NotNull TypeSubstitution first, @NotNull TypeSubstitution second) {
        if (first == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "first", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "createChainedSubstitutor"));
        }
        if (second == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "second", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "createChainedSubstitutor"));
        }
        TypeSubstitutor typeSubstitutor2 = TypeSubstitutor.create(DisjointKeysUnionTypeSubstitution.create(first, second));
        if (typeSubstitutor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "createChainedSubstitutor"));
        }
        return typeSubstitutor2;
    }

    @NotNull
    public static TypeSubstitutor create(@NotNull Map<TypeConstructor, TypeProjection> substitutionContext) {
        if (substitutionContext == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutionContext", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "create"));
        }
        TypeSubstitutor typeSubstitutor2 = TypeSubstitutor.create(TypeConstructorSubstitution.createByConstructorsMap(substitutionContext));
        if (typeSubstitutor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "create"));
        }
        return typeSubstitutor2;
    }

    @NotNull
    public static TypeSubstitutor create(@NotNull KotlinType context) {
        if (context == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "context", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "create"));
        }
        TypeSubstitutor typeSubstitutor2 = TypeSubstitutor.create(TypeConstructorSubstitution.create(context.getConstructor(), context.getArguments()));
        if (typeSubstitutor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "create"));
        }
        return typeSubstitutor2;
    }

    protected TypeSubstitutor(@NotNull TypeSubstitution substitution) {
        if (substitution == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitution", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "<init>"));
        }
        this.substitution = substitution;
    }

    public boolean isEmpty() {
        return this.substitution.isEmpty();
    }

    @NotNull
    public TypeSubstitution getSubstitution() {
        TypeSubstitution typeSubstitution = this.substitution;
        if (typeSubstitution == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "getSubstitution"));
        }
        return typeSubstitution;
    }

    @NotNull
    public KotlinType safeSubstitute(@NotNull KotlinType type2, @NotNull Variance howThisTypeIsUsed) {
        KotlinType kotlinType;
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "safeSubstitute"));
        }
        if (howThisTypeIsUsed == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "howThisTypeIsUsed", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "safeSubstitute"));
        }
        if (this.isEmpty()) {
            KotlinType kotlinType2 = type2;
            if (kotlinType2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "safeSubstitute"));
            }
            return kotlinType2;
        }
        try {
            kotlinType = this.unsafeSubstitute(new TypeProjectionImpl(howThisTypeIsUsed, type2), 0).getType();
        }
        catch (SubstitutionException e) {
            SimpleType simpleType2 = ErrorUtils.createErrorType(e.getMessage());
            if (simpleType2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "safeSubstitute"));
            }
            return simpleType2;
        }
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "safeSubstitute"));
        }
        return kotlinType;
    }

    @Nullable
    public KotlinType substitute(@NotNull KotlinType type2, @NotNull Variance howThisTypeIsUsed) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "substitute"));
        }
        if (howThisTypeIsUsed == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "howThisTypeIsUsed", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "substitute"));
        }
        TypeProjection projection = this.substitute(new TypeProjectionImpl(howThisTypeIsUsed, this.getSubstitution().prepareTopLevelType(type2, howThisTypeIsUsed)));
        return projection == null ? null : projection.getType();
    }

    @Nullable
    public TypeProjection substitute(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeProjection", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "substitute"));
        }
        TypeProjection substitutedTypeProjection = this.substituteWithoutApproximation(typeProjection);
        if (!this.substitution.approximateCapturedTypes() && !this.substitution.approximateContravariantCapturedTypes()) {
            return substitutedTypeProjection;
        }
        return CapturedTypeApproximationKt.approximateCapturedTypesIfNecessary(substitutedTypeProjection, this.substitution.approximateContravariantCapturedTypes());
    }

    @Nullable
    public TypeProjection substituteWithoutApproximation(@NotNull TypeProjection typeProjection) {
        if (typeProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeProjection", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "substituteWithoutApproximation"));
        }
        if (this.isEmpty()) {
            return typeProjection;
        }
        try {
            return this.unsafeSubstitute(typeProjection, 0);
        }
        catch (SubstitutionException e) {
            return null;
        }
    }

    @NotNull
    private TypeProjection unsafeSubstitute(@NotNull TypeProjection originalProjection, int recursionDepth) throws SubstitutionException {
        if (originalProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "originalProjection", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"));
        }
        TypeSubstitutor.assertRecursionDepth(recursionDepth, originalProjection, this.substitution);
        if (originalProjection.isStarProjection()) {
            TypeProjection typeProjection = originalProjection;
            if (typeProjection == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"));
            }
            return typeProjection;
        }
        KotlinType type2 = originalProjection.getType();
        if (DynamicTypesKt.isDynamic(type2) || type2.unwrap() instanceof RawType) {
            TypeProjection typeProjection = originalProjection;
            if (typeProjection == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"));
            }
            return typeProjection;
        }
        TypeProjection replacement = this.substitution.get(type2);
        Variance originalProjectionKind = originalProjection.getProjectionKind();
        if (replacement == null && FlexibleTypesKt.isFlexible(type2) && !TypeCapabilitiesKt.isCustomTypeVariable(type2)) {
            FlexibleType flexibleType = FlexibleTypesKt.asFlexibleType(type2);
            TypeProjection substitutedLower = this.unsafeSubstitute(new TypeProjectionImpl(originalProjectionKind, flexibleType.getLowerBound()), recursionDepth + 1);
            TypeProjection substitutedUpper = this.unsafeSubstitute(new TypeProjectionImpl(originalProjectionKind, flexibleType.getUpperBound()), recursionDepth + 1);
            Variance substitutedProjectionKind = substitutedLower.getProjectionKind();
            assert (substitutedProjectionKind == substitutedUpper.getProjectionKind() && originalProjectionKind == Variance.INVARIANT || originalProjectionKind == substitutedProjectionKind) : "Unexpected substituted projection kind: " + (Object)((Object)substitutedProjectionKind) + "; original: " + (Object)((Object)originalProjectionKind);
            UnwrappedType substitutedFlexibleType = KotlinTypeFactory.flexibleType(TypeSubstitutionKt.asSimpleType(substitutedLower.getType()), TypeSubstitutionKt.asSimpleType(substitutedUpper.getType()));
            TypeProjectionImpl typeProjectionImpl = new TypeProjectionImpl(substitutedProjectionKind, substitutedFlexibleType);
            if (typeProjectionImpl == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"));
            }
            return typeProjectionImpl;
        }
        if (KotlinBuiltIns.isNothing(type2) || type2.isError()) {
            TypeProjection typeProjection = originalProjection;
            if (typeProjection == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"));
            }
            return typeProjection;
        }
        if (replacement != null) {
            VarianceConflictType varianceConflict = TypeSubstitutor.conflictType(originalProjectionKind, replacement.getProjectionKind());
            boolean allowVarianceConflict = CapturedTypeConstructorKt.isCaptured(type2);
            if (!allowVarianceConflict) {
                switch (varianceConflict) {
                    case OUT_IN_IN_POSITION: {
                        throw new SubstitutionException("Out-projection in in-position");
                    }
                    case IN_IN_OUT_POSITION: {
                        TypeProjectionImpl typeProjectionImpl = new TypeProjectionImpl(Variance.OUT_VARIANCE, type2.getConstructor().getBuiltIns().getNullableAnyType());
                        if (typeProjectionImpl == null) {
                            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"));
                        }
                        return typeProjectionImpl;
                    }
                }
            }
            CustomTypeVariable typeVariable = TypeCapabilitiesKt.getCustomTypeVariable(type2);
            if (replacement.isStarProjection()) {
                TypeProjection typeProjection = replacement;
                if (typeProjection == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"));
                }
                return typeProjection;
            }
            KotlinType substitutedType = typeVariable != null ? typeVariable.substitutionResult(replacement.getType()) : TypeUtils.makeNullableIfNeeded(replacement.getType(), type2.isMarkedNullable());
            if (!type2.getAnnotations().isEmpty()) {
                Annotations typeAnnotations2 = TypeSubstitutor.filterOutUnsafeVariance(this.substitution.filterAnnotations(type2.getAnnotations()));
                substitutedType = TypeUtilsKt.replaceAnnotations(substitutedType, new CompositeAnnotations(substitutedType.getAnnotations(), typeAnnotations2));
            }
            Variance resultingProjectionKind = varianceConflict == VarianceConflictType.NO_CONFLICT ? TypeSubstitutor.combine(originalProjectionKind, replacement.getProjectionKind()) : originalProjectionKind;
            TypeProjectionImpl typeProjectionImpl = new TypeProjectionImpl(resultingProjectionKind, substitutedType);
            if (typeProjectionImpl == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"));
            }
            return typeProjectionImpl;
        }
        TypeProjection typeProjection = this.substituteCompoundType(originalProjection, recursionDepth);
        if (typeProjection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "unsafeSubstitute"));
        }
        return typeProjection;
    }

    @NotNull
    private static Annotations filterOutUnsafeVariance(@NotNull Annotations annotations2) {
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "filterOutUnsafeVariance"));
        }
        if (!annotations2.hasAnnotation(KotlinBuiltIns.FQ_NAMES.unsafeVariance)) {
            Annotations annotations3 = annotations2;
            if (annotations3 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "filterOutUnsafeVariance"));
            }
            return annotations3;
        }
        FilteredAnnotations filteredAnnotations = new FilteredAnnotations(annotations2, (Function1<? super FqName, Boolean>)new Function1<FqName, Boolean>(){

            @Override
            public Boolean invoke(@NotNull FqName name2) {
                if (name2 == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
                }
                return !name2.equals(KotlinBuiltIns.FQ_NAMES.unsafeVariance);
            }
        });
        if (filteredAnnotations == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "filterOutUnsafeVariance"));
        }
        return filteredAnnotations;
    }

    private TypeProjection substituteCompoundType(TypeProjection originalProjection, int recursionDepth) throws SubstitutionException {
        List<TypeProjection> substitutedArguments;
        KotlinType substitutedType;
        KotlinType type2 = originalProjection.getType();
        Variance projectionKind = originalProjection.getProjectionKind();
        if (type2.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return originalProjection;
        }
        KotlinType substitutedAbbreviation = null;
        SimpleType abbreviation = SpecialTypesKt.getAbbreviation(type2);
        if (abbreviation != null) {
            substitutedAbbreviation = this.substitute(abbreviation, Variance.INVARIANT);
        }
        if ((substitutedType = TypeSubstitutionKt.replace(type2, substitutedArguments = this.substituteTypeArguments(type2.getConstructor().getParameters(), type2.getArguments(), recursionDepth), this.substitution.filterAnnotations(type2.getAnnotations()))) instanceof SimpleType && substitutedAbbreviation instanceof SimpleType) {
            substitutedType = SpecialTypesKt.withAbbreviation((SimpleType)substitutedType, (SimpleType)substitutedAbbreviation);
        }
        return new TypeProjectionImpl(projectionKind, substitutedType);
    }

    private List<TypeProjection> substituteTypeArguments(List<TypeParameterDescriptor> typeParameters2, List<TypeProjection> typeArguments, int recursionDepth) throws SubstitutionException {
        ArrayList<TypeProjection> substitutedArguments = new ArrayList<TypeProjection>(typeParameters2.size());
        for (int i = 0; i < typeParameters2.size(); ++i) {
            TypeParameterDescriptor typeParameter = typeParameters2.get(i);
            TypeProjection typeArgument = typeArguments.get(i);
            TypeProjection substitutedTypeArgument = this.unsafeSubstitute(typeArgument, recursionDepth + 1);
            switch (TypeSubstitutor.conflictType(typeParameter.getVariance(), substitutedTypeArgument.getProjectionKind())) {
                case NO_CONFLICT: {
                    if (typeParameter.getVariance() == Variance.INVARIANT || substitutedTypeArgument.isStarProjection()) break;
                    substitutedTypeArgument = new TypeProjectionImpl(Variance.INVARIANT, substitutedTypeArgument.getType());
                    break;
                }
                case OUT_IN_IN_POSITION: 
                case IN_IN_OUT_POSITION: {
                    substitutedTypeArgument = TypeUtils.makeStarProjection(typeParameter);
                }
            }
            substitutedArguments.add(substitutedTypeArgument);
        }
        return substitutedArguments;
    }

    @NotNull
    public static Variance combine(@NotNull Variance typeParameterVariance, @NotNull TypeProjection typeProjection) {
        if (typeParameterVariance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameterVariance", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"));
        }
        if (typeProjection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeProjection", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"));
        }
        if (typeProjection.isStarProjection()) {
            Variance variance = Variance.OUT_VARIANCE;
            if (variance == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"));
            }
            return variance;
        }
        Variance variance = TypeSubstitutor.combine(typeParameterVariance, typeProjection.getProjectionKind());
        if (variance == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"));
        }
        return variance;
    }

    @NotNull
    public static Variance combine(@NotNull Variance typeParameterVariance, @NotNull Variance projectionKind) {
        if (typeParameterVariance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameterVariance", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"));
        }
        if (projectionKind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "projectionKind", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"));
        }
        if (typeParameterVariance == Variance.INVARIANT) {
            Variance variance = projectionKind;
            if (variance == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"));
            }
            return variance;
        }
        if (projectionKind == Variance.INVARIANT) {
            Variance variance = typeParameterVariance;
            if (variance == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"));
            }
            return variance;
        }
        if (typeParameterVariance == projectionKind) {
            Variance variance = projectionKind;
            if (variance == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor", "combine"));
            }
            return variance;
        }
        throw new AssertionError((Object)("Variance conflict: type parameter variance '" + (Object)((Object)typeParameterVariance) + "' and " + "projection kind '" + (Object)((Object)projectionKind) + "' cannot be combined"));
    }

    private static VarianceConflictType conflictType(Variance position, Variance argument) {
        if (position == Variance.IN_VARIANCE && argument == Variance.OUT_VARIANCE) {
            return VarianceConflictType.OUT_IN_IN_POSITION;
        }
        if (position == Variance.OUT_VARIANCE && argument == Variance.IN_VARIANCE) {
            return VarianceConflictType.IN_IN_OUT_POSITION;
        }
        return VarianceConflictType.NO_CONFLICT;
    }

    private static void assertRecursionDepth(int recursionDepth, TypeProjection projection, TypeSubstitution substitution) {
        if (recursionDepth > 100) {
            throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + TypeSubstitutor.safeToString(projection) + "; substitution: " + TypeSubstitutor.safeToString(substitution));
        }
    }

    private static String safeToString(Object o) {
        try {
            return o.toString();
        }
        catch (Throwable e) {
            if (e.getClass().getName().equals("com.intellij.openapi.progress.ProcessCanceledException")) {
                throw (RuntimeException)e;
            }
            return "[Exception while computing toString(): " + e + "]";
        }
    }

    private static enum VarianceConflictType {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION;

    }

    private static final class SubstitutionException
    extends Exception {
        public SubstitutionException(String message) {
            super(message);
        }
    }
}

