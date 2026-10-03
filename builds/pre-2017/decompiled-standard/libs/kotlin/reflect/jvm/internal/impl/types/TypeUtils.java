/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeUtils {
    public static final SimpleType DONT_CARE = ErrorUtils.createErrorTypeWithCustomDebugName("DONT_CARE");
    public static final SimpleType CANT_INFER_FUNCTION_PARAM_TYPE = ErrorUtils.createErrorType("Cannot be inferred");
    @NotNull
    public static final SimpleType NO_EXPECTED_TYPE = new SpecialType("NO_EXPECTED_TYPE");
    public static final SimpleType UNIT_EXPECTED_TYPE = new SpecialType("UNIT_EXPECTED_TYPE");

    public static boolean noExpectedType(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "noExpectedType"));
        }
        return type2 == NO_EXPECTED_TYPE || type2 == UNIT_EXPECTED_TYPE;
    }

    public static boolean isDontCarePlaceholder(@Nullable KotlinType type2) {
        return type2 != null && type2.getConstructor() == DONT_CARE.getConstructor();
    }

    @NotNull
    public static KotlinType makeNullable(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullable"));
        }
        KotlinType kotlinType = TypeUtils.makeNullableAsSpecified(type2, true);
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullable"));
        }
        return kotlinType;
    }

    @NotNull
    public static KotlinType makeNotNullable(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNotNullable"));
        }
        KotlinType kotlinType = TypeUtils.makeNullableAsSpecified(type2, false);
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNotNullable"));
        }
        return kotlinType;
    }

    @NotNull
    public static KotlinType makeNullableAsSpecified(@NotNull KotlinType type2, boolean nullable) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableAsSpecified"));
        }
        UnwrappedType unwrappedType = type2.unwrap().makeNullableAsSpecified(nullable);
        if (unwrappedType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableAsSpecified"));
        }
        return unwrappedType;
    }

    @NotNull
    public static SimpleType makeNullableIfNeeded(@NotNull SimpleType type2, boolean nullable) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableIfNeeded"));
        }
        if (nullable) {
            SimpleType simpleType2 = type2.makeNullableAsSpecified(true);
            if (simpleType2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableIfNeeded"));
            }
            return simpleType2;
        }
        SimpleType simpleType3 = type2;
        if (simpleType3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableIfNeeded"));
        }
        return simpleType3;
    }

    @NotNull
    public static KotlinType makeNullableIfNeeded(@NotNull KotlinType type2, boolean nullable) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableIfNeeded"));
        }
        if (nullable) {
            KotlinType kotlinType = TypeUtils.makeNullable(type2);
            if (kotlinType == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableIfNeeded"));
            }
            return kotlinType;
        }
        KotlinType kotlinType = type2;
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeNullableIfNeeded"));
        }
        return kotlinType;
    }

    public static boolean canHaveSubtypes(KotlinTypeChecker typeChecker, @NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "canHaveSubtypes"));
        }
        if (type2.isMarkedNullable()) {
            return true;
        }
        if (!type2.getConstructor().isFinal()) {
            return true;
        }
        List<TypeParameterDescriptor> parameters2 = type2.getConstructor().getParameters();
        List<TypeProjection> arguments2 = type2.getArguments();
        int parametersSize = parameters2.size();
        block10: for (int i = 0; i < parametersSize; ++i) {
            TypeParameterDescriptor parameterDescriptor = parameters2.get(i);
            TypeProjection typeProjection = arguments2.get(i);
            if (typeProjection.isStarProjection()) {
                return true;
            }
            Variance projectionKind = typeProjection.getProjectionKind();
            KotlinType argument = typeProjection.getType();
            switch (parameterDescriptor.getVariance()) {
                case INVARIANT: {
                    switch (projectionKind) {
                        case INVARIANT: {
                            if (!TypeUtils.lowerThanBound(typeChecker, argument, parameterDescriptor) && !TypeUtils.canHaveSubtypes(typeChecker, argument)) break;
                            return true;
                        }
                        case IN_VARIANCE: {
                            if (!TypeUtils.lowerThanBound(typeChecker, argument, parameterDescriptor)) break;
                            return true;
                        }
                        case OUT_VARIANCE: {
                            if (!TypeUtils.canHaveSubtypes(typeChecker, argument)) break;
                            return true;
                        }
                    }
                    continue block10;
                }
                case IN_VARIANCE: {
                    if (!(projectionKind != Variance.OUT_VARIANCE ? TypeUtils.lowerThanBound(typeChecker, argument, parameterDescriptor) : TypeUtils.canHaveSubtypes(typeChecker, argument))) continue block10;
                    return true;
                }
                case OUT_VARIANCE: {
                    if (!(projectionKind != Variance.IN_VARIANCE ? TypeUtils.canHaveSubtypes(typeChecker, argument) : TypeUtils.lowerThanBound(typeChecker, argument, parameterDescriptor))) continue block10;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean lowerThanBound(KotlinTypeChecker typeChecker, KotlinType argument, TypeParameterDescriptor parameterDescriptor) {
        for (KotlinType bound : parameterDescriptor.getUpperBounds()) {
            if (!typeChecker.isSubtypeOf(argument, bound) || argument.getConstructor().equals(bound.getConstructor())) continue;
            return true;
        }
        return false;
    }

    @NotNull
    public static SimpleType makeUnsubstitutedType(ClassifierDescriptor classifierDescriptor, MemberScope unsubstitutedMemberScope) {
        if (ErrorUtils.isError(classifierDescriptor)) {
            SimpleType simpleType2 = ErrorUtils.createErrorType("Unsubstituted type for " + classifierDescriptor);
            if (simpleType2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeUnsubstitutedType"));
            }
            return simpleType2;
        }
        TypeConstructor typeConstructor2 = classifierDescriptor.getTypeConstructor();
        List<TypeProjection> arguments2 = TypeUtils.getDefaultTypeProjections(typeConstructor2.getParameters());
        SimpleType simpleType3 = KotlinTypeFactory.simpleType(Annotations.Companion.getEMPTY(), typeConstructor2, arguments2, false, unsubstitutedMemberScope);
        if (simpleType3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeUnsubstitutedType"));
        }
        return simpleType3;
    }

    @NotNull
    public static List<TypeProjection> getDefaultTypeProjections(@NotNull List<TypeParameterDescriptor> parameters2) {
        if (parameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameters", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getDefaultTypeProjections"));
        }
        ArrayList<TypeProjectionImpl> result2 = new ArrayList<TypeProjectionImpl>(parameters2.size());
        for (TypeParameterDescriptor parameterDescriptor : parameters2) {
            result2.add(new TypeProjectionImpl(parameterDescriptor.getDefaultType()));
        }
        List<TypeProjection> list = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList(result2);
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getDefaultTypeProjections"));
        }
        return list;
    }

    @NotNull
    public static List<KotlinType> getImmediateSupertypes(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getImmediateSupertypes"));
        }
        TypeSubstitutor substitutor = TypeSubstitutor.create(type2);
        Collection<KotlinType> originalSupertypes = type2.getConstructor().getSupertypes();
        ArrayList<KotlinType> result2 = new ArrayList<KotlinType>(originalSupertypes.size());
        for (KotlinType supertype : originalSupertypes) {
            KotlinType substitutedType = TypeUtils.createSubstitutedSupertype(type2, supertype, substitutor);
            if (substitutedType == null) continue;
            result2.add(substitutedType);
        }
        ArrayList<KotlinType> arrayList = result2;
        if (arrayList == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getImmediateSupertypes"));
        }
        return arrayList;
    }

    @Nullable
    public static KotlinType createSubstitutedSupertype(@NotNull KotlinType subType, @NotNull KotlinType superType, @NotNull TypeSubstitutor substitutor) {
        if (subType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "subType", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "createSubstitutedSupertype"));
        }
        if (superType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "superType", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "createSubstitutedSupertype"));
        }
        if (substitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutor", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "createSubstitutedSupertype"));
        }
        KotlinType substitutedType = substitutor.substitute(superType, Variance.INVARIANT);
        if (substitutedType != null) {
            return TypeUtils.makeNullableIfNeeded(substitutedType, subType.isMarkedNullable());
        }
        return null;
    }

    private static void collectAllSupertypes(@NotNull KotlinType type2, @NotNull Set<KotlinType> result2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "collectAllSupertypes"));
        }
        if (result2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "collectAllSupertypes"));
        }
        List<KotlinType> immediateSupertypes = TypeUtils.getImmediateSupertypes(type2);
        result2.addAll(immediateSupertypes);
        for (KotlinType supertype : immediateSupertypes) {
            TypeUtils.collectAllSupertypes(supertype, result2);
        }
    }

    @NotNull
    public static Set<KotlinType> getAllSupertypes(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getAllSupertypes"));
        }
        LinkedHashSet<KotlinType> result2 = new LinkedHashSet<KotlinType>(15);
        TypeUtils.collectAllSupertypes(type2, result2);
        LinkedHashSet<KotlinType> linkedHashSet = result2;
        if (linkedHashSet == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getAllSupertypes"));
        }
        return linkedHashSet;
    }

    public static boolean isNullableType(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "isNullableType"));
        }
        if (type2.isMarkedNullable()) {
            return true;
        }
        if (FlexibleTypesKt.isFlexible(type2) && TypeUtils.isNullableType(FlexibleTypesKt.asFlexibleType(type2).getUpperBound())) {
            return true;
        }
        if (TypeUtils.isTypeParameter(type2)) {
            return TypeUtils.hasNullableSuperType(type2);
        }
        return false;
    }

    public static boolean acceptsNullable(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "acceptsNullable"));
        }
        if (type2.isMarkedNullable()) {
            return true;
        }
        return FlexibleTypesKt.isFlexible(type2) && TypeUtils.acceptsNullable(FlexibleTypesKt.asFlexibleType(type2).getUpperBound());
    }

    public static boolean hasNullableSuperType(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "hasNullableSuperType"));
        }
        if (type2.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
            return false;
        }
        for (KotlinType supertype : TypeUtils.getImmediateSupertypes(type2)) {
            if (!TypeUtils.isNullableType(supertype)) continue;
            return true;
        }
        return false;
    }

    @Nullable
    public static ClassDescriptor getClassDescriptor(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getClassDescriptor"));
        }
        ClassifierDescriptor declarationDescriptor = type2.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor)declarationDescriptor;
        }
        return null;
    }

    @NotNull
    public static KotlinType substituteParameters(@NotNull ClassDescriptor clazz, @NotNull List<KotlinType> typeArguments) {
        if (clazz == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "clazz", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "substituteParameters"));
        }
        if (typeArguments == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeArguments", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "substituteParameters"));
        }
        List<TypeProjection> projections = CollectionsKt.map(typeArguments, new Function1<KotlinType, TypeProjection>(){

            @Override
            public TypeProjection invoke(KotlinType type2) {
                return new TypeProjectionImpl(type2);
            }
        });
        KotlinType kotlinType = TypeUtils.substituteProjectionsForParameters(clazz, projections);
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "substituteParameters"));
        }
        return kotlinType;
    }

    @NotNull
    public static KotlinType substituteProjectionsForParameters(@NotNull ClassDescriptor clazz, @NotNull List<TypeProjection> projections) {
        if (clazz == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "clazz", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "substituteProjectionsForParameters"));
        }
        if (projections == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "projections", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "substituteProjectionsForParameters"));
        }
        List<TypeParameterDescriptor> clazzTypeParameters = clazz.getTypeConstructor().getParameters();
        if (clazzTypeParameters.size() != projections.size()) {
            throw new IllegalArgumentException("type parameter counts do not match: " + clazz + ", " + projections);
        }
        HashMap<TypeConstructor, TypeProjection> substitutions = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newHashMapWithExpectedSize(clazzTypeParameters.size());
        for (int i = 0; i < clazzTypeParameters.size(); ++i) {
            TypeConstructor typeConstructor2 = clazzTypeParameters.get(i).getTypeConstructor();
            substitutions.put(typeConstructor2, projections.get(i));
        }
        KotlinType kotlinType = TypeSubstitutor.create(substitutions).substitute(clazz.getDefaultType(), Variance.INVARIANT);
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "substituteProjectionsForParameters"));
        }
        return kotlinType;
    }

    public static boolean equalTypes(@NotNull KotlinType a, @NotNull KotlinType b) {
        if (a == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "a", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "equalTypes"));
        }
        if (b == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "b", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "equalTypes"));
        }
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(a, b) && KotlinTypeChecker.DEFAULT.isSubtypeOf(b, a);
    }

    public static boolean dependsOnTypeParameters(@NotNull KotlinType type2, @NotNull Collection<TypeParameterDescriptor> typeParameters2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "dependsOnTypeParameters"));
        }
        if (typeParameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "dependsOnTypeParameters"));
        }
        return TypeUtils.dependsOnTypeConstructors(type2, CollectionsKt.map(typeParameters2, new Function1<TypeParameterDescriptor, TypeConstructor>(){

            @Override
            public TypeConstructor invoke(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
                if (typeParameterDescriptor == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameterDescriptor", "kotlin/reflect/jvm/internal/impl/types/TypeUtils$2", "invoke"));
                }
                return typeParameterDescriptor.getTypeConstructor();
            }
        }));
    }

    public static boolean dependsOnTypeConstructors(@NotNull KotlinType type2, @NotNull Collection<TypeConstructor> typeParameterConstructors) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "dependsOnTypeConstructors"));
        }
        if (typeParameterConstructors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameterConstructors", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "dependsOnTypeConstructors"));
        }
        if (typeParameterConstructors.contains(type2.getConstructor())) {
            return true;
        }
        for (TypeProjection typeProjection : type2.getArguments()) {
            if (typeProjection.isStarProjection() || !TypeUtils.dependsOnTypeConstructors(typeProjection.getType(), typeParameterConstructors)) continue;
            return true;
        }
        return false;
    }

    public static boolean contains(@Nullable KotlinType type2, final @NotNull KotlinType specialType) {
        if (specialType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "specialType", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "contains"));
        }
        return TypeUtils.contains(type2, new Function1<UnwrappedType, Boolean>(){

            @Override
            public Boolean invoke(UnwrappedType type2) {
                return specialType.equals(type2);
            }
        });
    }

    public static boolean contains(@Nullable KotlinType type2, @NotNull Function1<UnwrappedType, Boolean> isSpecialType) {
        FlexibleType flexibleType;
        if (isSpecialType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "isSpecialType", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "contains"));
        }
        if (type2 == null) {
            return false;
        }
        UnwrappedType unwrappedType = type2.unwrap();
        if (isSpecialType.invoke(unwrappedType).booleanValue()) {
            return true;
        }
        FlexibleType flexibleType2 = flexibleType = unwrappedType instanceof FlexibleType ? (FlexibleType)unwrappedType : null;
        if (flexibleType != null && (TypeUtils.contains((KotlinType)flexibleType.getLowerBound(), isSpecialType) || TypeUtils.contains((KotlinType)flexibleType.getUpperBound(), isSpecialType))) {
            return true;
        }
        for (TypeProjection projection : type2.getArguments()) {
            if (projection.isStarProjection() || !TypeUtils.contains(projection.getType(), isSpecialType)) continue;
            return true;
        }
        return false;
    }

    @NotNull
    public static TypeProjection makeStarProjection(@NotNull TypeParameterDescriptor parameterDescriptor) {
        if (parameterDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameterDescriptor", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeStarProjection"));
        }
        StarProjectionImpl starProjectionImpl = new StarProjectionImpl(parameterDescriptor);
        if (starProjectionImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "makeStarProjection"));
        }
        return starProjectionImpl;
    }

    @NotNull
    public static KotlinType getDefaultPrimitiveNumberType(@NotNull IntegerValueTypeConstructor numberValueTypeConstructor) {
        if (numberValueTypeConstructor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "numberValueTypeConstructor", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getDefaultPrimitiveNumberType"));
        }
        KotlinType type2 = TypeUtils.getDefaultPrimitiveNumberType(numberValueTypeConstructor.getSupertypes());
        assert (type2 != null) : "Strange number value type constructor: " + numberValueTypeConstructor + ". " + "Super types doesn't contain double, int or long: " + numberValueTypeConstructor.getSupertypes();
        KotlinType kotlinType = type2;
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getDefaultPrimitiveNumberType"));
        }
        return kotlinType;
    }

    @Nullable
    public static KotlinType getDefaultPrimitiveNumberType(@NotNull Collection<KotlinType> supertypes2) {
        if (supertypes2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertypes", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getDefaultPrimitiveNumberType"));
        }
        if (supertypes2.isEmpty()) {
            return null;
        }
        KotlinBuiltIns builtIns = supertypes2.iterator().next().getConstructor().getBuiltIns();
        SimpleType doubleType = builtIns.getDoubleType();
        if (supertypes2.contains(doubleType)) {
            return doubleType;
        }
        SimpleType intType = builtIns.getIntType();
        if (supertypes2.contains(intType)) {
            return intType;
        }
        SimpleType longType = builtIns.getLongType();
        if (supertypes2.contains(longType)) {
            return longType;
        }
        return null;
    }

    @NotNull
    public static KotlinType getPrimitiveNumberType(@NotNull IntegerValueTypeConstructor numberValueTypeConstructor, @NotNull KotlinType expectedType) {
        if (numberValueTypeConstructor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "numberValueTypeConstructor", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getPrimitiveNumberType"));
        }
        if (expectedType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "expectedType", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getPrimitiveNumberType"));
        }
        if (TypeUtils.noExpectedType(expectedType) || expectedType.isError()) {
            KotlinType kotlinType = TypeUtils.getDefaultPrimitiveNumberType(numberValueTypeConstructor);
            if (kotlinType == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getPrimitiveNumberType"));
            }
            return kotlinType;
        }
        for (KotlinType primitiveNumberType : numberValueTypeConstructor.getSupertypes()) {
            if (!KotlinTypeChecker.DEFAULT.isSubtypeOf(primitiveNumberType, expectedType)) continue;
            KotlinType kotlinType = primitiveNumberType;
            if (kotlinType == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getPrimitiveNumberType"));
            }
            return kotlinType;
        }
        KotlinType kotlinType = TypeUtils.getDefaultPrimitiveNumberType(numberValueTypeConstructor);
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getPrimitiveNumberType"));
        }
        return kotlinType;
    }

    public static boolean isTypeParameter(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "isTypeParameter"));
        }
        return TypeUtils.getTypeParameterDescriptorOrNull(type2) != null;
    }

    public static boolean isReifiedTypeParameter(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "isReifiedTypeParameter"));
        }
        TypeParameterDescriptor typeParameterDescriptor = TypeUtils.getTypeParameterDescriptorOrNull(type2);
        return typeParameterDescriptor != null && typeParameterDescriptor.isReified();
    }

    public static boolean isNonReifiedTypeParameter(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "isNonReifiedTypeParameter"));
        }
        TypeParameterDescriptor typeParameterDescriptor = TypeUtils.getTypeParameterDescriptorOrNull(type2);
        return typeParameterDescriptor != null && !typeParameterDescriptor.isReified();
    }

    @Nullable
    public static TypeParameterDescriptor getTypeParameterDescriptorOrNull(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/types/TypeUtils", "getTypeParameterDescriptorOrNull"));
        }
        if (type2.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) {
            return (TypeParameterDescriptor)type2.getConstructor().getDeclarationDescriptor();
        }
        return null;
    }

    public static class SpecialType
    extends DelegatingSimpleType {
        private final String name;

        public SpecialType(String name2) {
            this.name = name2;
        }

        @Override
        @NotNull
        protected SimpleType getDelegate() {
            throw new IllegalStateException(this.name);
        }

        @Override
        public boolean isError() {
            return false;
        }

        @Override
        @NotNull
        public SimpleType replaceAnnotations(@NotNull Annotations newAnnotations) {
            if (newAnnotations == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newAnnotations", "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType", "replaceAnnotations"));
            }
            throw new IllegalStateException(this.name);
        }

        @Override
        @NotNull
        public SimpleType makeNullableAsSpecified(boolean newNullability) {
            throw new IllegalStateException(this.name);
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}

