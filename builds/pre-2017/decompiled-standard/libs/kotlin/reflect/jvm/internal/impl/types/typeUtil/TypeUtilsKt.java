/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeCapabilitiesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeNullability;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeUtilsKt {
    @NotNull
    public static final TypeNullability nullability(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return FlexibleTypesKt.isNullabilityFlexible($receiver) ? TypeNullability.FLEXIBLE : (TypeUtils.isNullableType($receiver) ? TypeNullability.NULLABLE : TypeNullability.NOT_NULL);
    }

    @NotNull
    public static final KotlinBuiltIns getBuiltIns(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KotlinBuiltIns kotlinBuiltIns = $receiver.getConstructor().getBuiltIns();
        Intrinsics.checkExpressionValueIsNotNull(kotlinBuiltIns, "constructor.builtIns");
        return kotlinBuiltIns;
    }

    @NotNull
    public static final KotlinType makeNullable(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return TypeUtils.makeNullable($receiver);
    }

    @NotNull
    public static final KotlinType makeNotNullable(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return TypeUtils.makeNotNullable($receiver);
    }

    @NotNull
    public static final Collection<KotlinType> immediateSupertypes(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        List<KotlinType> list = TypeUtils.getImmediateSupertypes($receiver);
        Intrinsics.checkExpressionValueIsNotNull(list, "TypeUtils.getImmediateSupertypes(this)");
        return list;
    }

    @NotNull
    public static final Collection<KotlinType> supertypes(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Set<KotlinType> set = TypeUtils.getAllSupertypes($receiver);
        Intrinsics.checkExpressionValueIsNotNull(set, "TypeUtils.getAllSupertypes(this)");
        return set;
    }

    public static final boolean isNothing(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return KotlinBuiltIns.isNothing($receiver);
    }

    public static final boolean isNullableNothing(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return KotlinBuiltIns.isNullableNothing($receiver);
    }

    public static final boolean isUnit(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return KotlinBuiltIns.isUnit($receiver);
    }

    public static final boolean isAnyOrNullableAny(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return KotlinBuiltIns.isAnyOrNullableAny($receiver);
    }

    public static final boolean isNullableAny(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return KotlinBuiltIns.isNullableAny($receiver);
    }

    public static final boolean isBoolean(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return KotlinBuiltIns.isBoolean($receiver);
    }

    public static final boolean isPrimitiveNumberType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return KotlinBuiltIns.isPrimitiveType($receiver) && !TypeUtilsKt.isBoolean($receiver);
    }

    public static final boolean isBooleanOrNullableBoolean(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return KotlinBuiltIns.isBooleanOrNullableBoolean($receiver);
    }

    public static final boolean isThrowable(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.throwable;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.throwable");
        return TypeUtilsKt.isConstructedFromClassWithGivenFqName($receiver, fqName2) && !$receiver.isMarkedNullable();
    }

    public static final boolean isIterator(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        FqName fqName2 = KotlinBuiltIns.FQ_NAMES.iterator;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "KotlinBuiltIns.FQ_NAMES.iterator");
        return TypeUtilsKt.isConstructedFromClassWithGivenFqName($receiver, fqName2) && !$receiver.isMarkedNullable();
    }

    public static final boolean isConstructedFromClassWithGivenFqName(@NotNull KotlinType $receiver, @NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        ClassifierDescriptor classifierDescriptor = $receiver.getConstructor().getDeclarationDescriptor();
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
        return Intrinsics.areEqual(classDescriptor != null ? DescriptorUtilsKt.getFqNameUnsafe(classDescriptor) : null, fqName2.toUnsafe());
    }

    public static final boolean isTypeParameter(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return TypeUtils.isTypeParameter($receiver);
    }

    public static final boolean isInterface(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassifierDescriptor classifierDescriptor = $receiver.getConstructor().getDeclarationDescriptor();
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
        return Intrinsics.areEqual((Object)(classDescriptor != null ? classDescriptor.getKind() : null), (Object)ClassKind.INTERFACE);
    }

    public static final boolean isArrayOfNothing(@Nullable KotlinType $receiver) {
        if ($receiver == null || !KotlinBuiltIns.isArray($receiver)) {
            return false;
        }
        TypeProjection typeProjection = CollectionsKt.firstOrNull($receiver.getArguments());
        KotlinType typeArg = typeProjection != null ? typeProjection.getType() : null;
        return typeArg != null && KotlinBuiltIns.isNothingOrNullableNothing(typeArg);
    }

    public static final boolean isSubtypeOf(@NotNull KotlinType $receiver, @NotNull KotlinType superType) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(superType, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf($receiver, superType);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isNullabilityMismatch(@NotNull KotlinType expected, @NotNull KotlinType actual) {
        Intrinsics.checkParameterIsNotNull(expected, "expected");
        Intrinsics.checkParameterIsNotNull(actual, "actual");
        if (expected.isMarkedNullable()) return false;
        if (!actual.isMarkedNullable()) return false;
        KotlinType kotlinType = TypeUtils.makeNullable(expected);
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "TypeUtils.makeNullable(expected)");
        if (!TypeUtilsKt.isSubtypeOf(actual, kotlinType)) return false;
        return true;
    }

    public static final boolean cannotBeReified(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return KotlinBuiltIns.isNothingOrNullableNothing($receiver) || DynamicTypesKt.isDynamic($receiver) || CapturedTypeConstructorKt.isCaptured($receiver);
    }

    @NotNull
    public static final TypeProjection substitute(@NotNull TypeProjection $receiver, @NotNull Function1<? super KotlinType, ? extends KotlinType> doSubstitute) {
        TypeProjection typeProjection;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(doSubstitute, "doSubstitute");
        if ($receiver.isStarProjection()) {
            typeProjection = $receiver;
        } else {
            Variance variance = $receiver.getProjectionKind();
            KotlinType kotlinType = $receiver.getType();
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "type");
            typeProjection = new TypeProjectionImpl(variance, doSubstitute.invoke(kotlinType));
        }
        return typeProjection;
    }

    @NotNull
    public static final KotlinType replaceAnnotations(@NotNull KotlinType $receiver, @NotNull Annotations newAnnotations) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        if ($receiver.getAnnotations().isEmpty() && newAnnotations.isEmpty()) {
            return $receiver;
        }
        return $receiver.unwrap().replaceAnnotations(newAnnotations);
    }

    public static final boolean equalTypesOrNulls(@NotNull KotlinTypeChecker $receiver, @Nullable KotlinType type1, @Nullable KotlinType type2) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (type1 == type2) {
            return true;
        }
        if (type1 == null || type2 == null) {
            return false;
        }
        return $receiver.equalTypes(type1, type2);
    }

    public static final boolean containsError(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return ErrorUtils.containsErrorType($receiver);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<TypeProjection> defaultProjections(@NotNull List<? extends KotlinType> $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable iterable = $receiver$iv = (Iterable)$receiver;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            KotlinType kotlinType = (KotlinType)item$iv$iv;
            Collection collection = destination$iv$iv;
            TypeProjectionImpl typeProjectionImpl = new TypeProjectionImpl((KotlinType)it);
            collection.add(typeProjectionImpl);
        }
        return (List)var3_3;
    }

    public static final boolean isDefaultBound(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return KotlinBuiltIns.isDefaultBound(TypeCapabilitiesKt.getSupertypeRepresentative($receiver));
    }

    @NotNull
    public static final TypeProjection createProjection(@NotNull KotlinType type2, @NotNull Variance projectionKind, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull((Object)projectionKind, "projectionKind");
        TypeParameterDescriptor typeParameterDescriptor2 = typeParameterDescriptor;
        return new TypeProjectionImpl(Intrinsics.areEqual((Object)(typeParameterDescriptor2 != null ? typeParameterDescriptor2.getVariance() : null), (Object)projectionKind) ? Variance.INVARIANT : projectionKind, type2);
    }

    @NotNull
    public static final Collection<KotlinType> closure(@NotNull Collection<? extends KotlinType> $receiver, @NotNull Function1<? super KotlinType, ? extends Collection<? extends KotlinType>> f) {
        HashSet<KotlinType> result2;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(f, "f");
        if ($receiver.size() == 0) {
            return $receiver;
        }
        HashSet<KotlinType> elementsToCheck = result2 = new HashSet<KotlinType>($receiver);
        int oldSize = 0;
        while (result2.size() > oldSize) {
            oldSize = result2.size();
            HashSet<? extends KotlinType> toAdd = new HashSet<KotlinType>();
            Iterable $receiver$iv = elementsToCheck;
            for (Object element$iv : $receiver$iv) {
                KotlinType it;
                KotlinType kotlinType = it = (KotlinType)element$iv;
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "it");
                toAdd.addAll(f.invoke(kotlinType));
            }
            result2.addAll((Collection<KotlinType>)toAdd);
            elementsToCheck = toAdd;
        }
        return result2;
    }

    @NotNull
    public static final Collection<KotlinType> boundClosure(@NotNull Collection<? extends KotlinType> types) {
        Intrinsics.checkParameterIsNotNull(types, "types");
        return TypeUtilsKt.closure(types, boundClosure.1.INSTANCE);
    }

    @NotNull
    public static final Collection<KotlinType> constituentTypes(@NotNull Collection<? extends KotlinType> types) {
        Intrinsics.checkParameterIsNotNull(types, "types");
        HashSet result2 = new HashSet();
        TypeUtilsKt.constituentTypes(result2, types);
        return result2;
    }

    @NotNull
    public static final Collection<KotlinType> constituentTypes(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return TypeUtilsKt.constituentTypes((Collection<? extends KotlinType>)CollectionsKt.listOf($receiver));
    }

    /*
     * WARNING - void declaration
     */
    private static final void constituentTypes(Set<KotlinType> result2, Collection<? extends KotlinType> types) {
        result2.addAll(types);
        for (KotlinType kotlinType : types) {
            void $receiver$iv$iv;
            void $receiver$iv;
            FlexibleType $receiver;
            Object object;
            if (FlexibleTypesKt.isFlexible(kotlinType)) {
                object = FlexibleTypesKt.asFlexibleType(kotlinType);
                $receiver = object;
                TypeUtilsKt.constituentTypes(result2, (Collection<? extends KotlinType>)SetsKt.setOf(new SimpleType[]{$receiver.getLowerBound(), $receiver.getUpperBound()}));
                continue;
            }
            object = kotlinType.getArguments();
            Set<KotlinType> set = result2;
            $receiver = $receiver$iv;
            Collection destination$iv$iv = new ArrayList();
            void $receiver$iv$iv$iv = $receiver$iv$iv;
            for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
                KotlinType kotlinType2;
                Object element$iv$iv = element$iv$iv$iv;
                TypeProjection it = (TypeProjection)element$iv$iv;
                KotlinType kotlinType3 = !it.isStarProjection() ? it.getType() : null;
                if (kotlinType3 == null) continue;
                KotlinType it$iv$iv = kotlinType2 = kotlinType3;
                destination$iv$iv.add(it$iv$iv);
            }
            List list = (List)destination$iv$iv;
            TypeUtilsKt.constituentTypes(set, list);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final KotlinType getImmediateSuperclassNotAny(@NotNull KotlinType $receiver) {
        KotlinType kotlinType;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getConstructor().getSupertypes();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            KotlinType it = (KotlinType)element$iv$iv;
            if (!(DescriptorUtils.isClassOrEnumClass(it.getConstructor().getDeclarationDescriptor()) && !KotlinBuiltIns.isAnyOrNullableAny(it))) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List superclasses = (List)destination$iv$iv;
        KotlinType kotlinType2 = (KotlinType)CollectionsKt.singleOrNull(superclasses);
        if (kotlinType2 != null) {
            KotlinType kotlinType3;
            KotlinType it = kotlinType3 = kotlinType2;
            kotlinType = TypeUtils.createSubstitutedSupertype($receiver, it, TypeSubstitutor.create($receiver));
        } else {
            kotlinType = null;
        }
        return kotlinType;
    }

    @NotNull
    public static final TypeProjection asTypeProjection(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return new TypeProjectionImpl($receiver);
    }

    public static final boolean contains(@NotNull KotlinType $receiver, @NotNull Function1<? super UnwrappedType, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return TypeUtils.contains($receiver, predicate);
    }

    @NotNull
    public static final KotlinType replaceArgumentsWithStarProjections(@NotNull KotlinType $receiver) {
        KotlinType kotlinType;
        UnwrappedType unwrapped;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        UnwrappedType unwrappedType = unwrapped = $receiver.unwrap();
        if (unwrappedType instanceof FlexibleType) {
            kotlinType = KotlinTypeFactory.flexibleType(TypeUtilsKt.replaceArgumentsWithStarProjections(((FlexibleType)unwrapped).getLowerBound()), TypeUtilsKt.replaceArgumentsWithStarProjections(((FlexibleType)unwrapped).getUpperBound()));
        } else if (unwrappedType instanceof SimpleType) {
            kotlinType = TypeUtilsKt.replaceArgumentsWithStarProjections((SimpleType)unwrapped);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return kotlinType;
    }

    /*
     * WARNING - void declaration
     */
    private static final SimpleType replaceArgumentsWithStarProjections(@NotNull SimpleType $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        if ($receiver.getConstructor().getParameters().isEmpty() || $receiver.getConstructor().getDeclarationDescriptor() == null) {
            return $receiver;
        }
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getConstructor().getParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void p1;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            StarProjectionImpl starProjectionImpl = new StarProjectionImpl((TypeParameterDescriptor)p1);
            collection.add(starProjectionImpl);
        }
        List newArguments2 = (List)var3_3;
        return TypeSubstitutionKt.replace$default($receiver, newArguments2, null, 2, null);
    }

    public static final boolean containsTypeAliasParameters(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return TypeUtilsKt.contains($receiver, containsTypeAliasParameters.1.INSTANCE);
    }

    public static final boolean containsTypeAliases(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return TypeUtilsKt.contains($receiver, containsTypeAliases.1.INSTANCE);
    }

    public static final boolean isTypeAliasParameter(@NotNull ClassifierDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver instanceof TypeParameterDescriptor && ((TypeParameterDescriptor)$receiver).getContainingDeclaration() instanceof TypeAliasDescriptor;
    }

    public static final boolean requiresTypeAliasExpansion(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return TypeUtilsKt.contains($receiver, requiresTypeAliasExpansion.1.INSTANCE);
    }

    public static final boolean containsTypeProjectionsInTopLevelArguments(@NotNull KotlinType $receiver) {
        boolean bl;
        block3: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            if ($receiver.isError()) {
                return false;
            }
            PossiblyInnerType possiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType($receiver);
            if (possiblyInnerType == null) {
                return false;
            }
            PossiblyInnerType possiblyInnerType2 = possiblyInnerType;
            Iterable $receiver$iv = possiblyInnerType2.getArguments();
            for (Object element$iv : $receiver$iv) {
                TypeProjection it = (TypeProjection)element$iv;
                if (!(it.isStarProjection() || Intrinsics.areEqual((Object)it.getProjectionKind(), (Object)Variance.INVARIANT) ^ true)) continue;
                bl = true;
                break block3;
            }
            bl = false;
        }
        return bl;
    }
}

