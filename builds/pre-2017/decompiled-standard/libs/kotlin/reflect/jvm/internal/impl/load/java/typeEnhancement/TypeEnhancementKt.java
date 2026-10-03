/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancedTypeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.EnhancementResult;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.Result;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SimpleResult;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt$WhenMappings;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeEnhancementKt {
    private static final EnhancedTypeAnnotations ENHANCED_NULLABILITY_ANNOTATIONS;
    private static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS;

    @Nullable
    public static final KotlinType enhance(@NotNull KotlinType $receiver, @NotNull Function1<? super Integer, JavaTypeQualifiers> qualifiers) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(qualifiers, "qualifiers");
        return TypeEnhancementKt.enhancePossiblyFlexible($receiver.unwrap(), qualifiers, 0).getTypeIfChanged();
    }

    public static final boolean hasEnhancedNullability(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Annotations annotations2 = $receiver.getAnnotations();
        FqName fqName2 = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        return annotations2.findAnnotation(fqName2) != null;
    }

    private static final Result enhancePossiblyFlexible(@NotNull UnwrappedType $receiver, Function1<? super Integer, JavaTypeQualifiers> qualifiers, int index) {
        Result result2;
        if ($receiver.isError()) {
            return new Result($receiver, 1, false);
        }
        UnwrappedType unwrappedType = $receiver;
        if (unwrappedType instanceof FlexibleType) {
            boolean wereChanges;
            boolean bl;
            SimpleResult lowerResult = TypeEnhancementKt.enhanceInflexible(((FlexibleType)$receiver).getLowerBound(), qualifiers, index, TypeComponentPosition.FLEXIBLE_LOWER);
            SimpleResult upperResult = TypeEnhancementKt.enhanceInflexible(((FlexibleType)$receiver).getUpperBound(), qualifiers, index, TypeComponentPosition.FLEXIBLE_UPPER);
            boolean bl2 = bl = lowerResult.getSubtreeSize() == upperResult.getSubtreeSize();
            if (_Assertions.ENABLED && !bl) {
                String string = "Different tree sizes of bounds: " + ("lower = (" + ((FlexibleType)$receiver).getLowerBound() + ", " + lowerResult.getSubtreeSize() + "), ") + ("upper = (" + ((FlexibleType)$receiver).getUpperBound() + ", " + upperResult.getSubtreeSize() + ")");
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            boolean bl3 = wereChanges = lowerResult.getWereChanges() || upperResult.getWereChanges();
            result2 = new Result(wereChanges ? ($receiver instanceof RawTypeImpl ? (UnwrappedType)new RawTypeImpl(lowerResult.getType(), upperResult.getType()) : KotlinTypeFactory.flexibleType(lowerResult.getType(), upperResult.getType())) : $receiver, lowerResult.getSubtreeSize(), wereChanges);
        } else if (unwrappedType instanceof SimpleType) {
            result2 = TypeEnhancementKt.enhanceInflexible((SimpleType)$receiver, qualifiers, index, TypeComponentPosition.INFLEXIBLE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return result2;
    }

    /*
     * WARNING - void declaration
     */
    private static final SimpleResult enhanceInflexible(@NotNull SimpleType $receiver, Function1<? super Integer, JavaTypeQualifiers> qualifiers, int index, TypeComponentPosition position) {
        void enhancedNullability;
        void enhancedNullabilityAnnotations;
        void wereChanges;
        void globalArgIndex;
        Annotations $receiver$iv$iv;
        Iterable $receiver$iv22;
        void enhancedMutabilityAnnotations;
        void enhancedClassifier;
        boolean shouldEnhance = TypeEnhancementKt.shouldEnhance(position);
        if (!shouldEnhance && $receiver.getArguments().isEmpty()) {
            return new SimpleResult($receiver, 1, false);
        }
        ClassifierDescriptor classifierDescriptor = $receiver.getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            return new SimpleResult($receiver, 1, false);
        }
        ClassifierDescriptor originalClass = classifierDescriptor;
        JavaTypeQualifiers effectiveQualifiers = qualifiers.invoke((Integer)index);
        EnhancementResult<ClassifierDescriptor> enhancementResult = TypeEnhancementKt.enhanceMutability(originalClass, effectiveQualifiers, position);
        ClassifierDescriptor classifierDescriptor2 = enhancementResult.component1();
        Annotations annotations2 = enhancementResult.component2();
        enhancementResult = null;
        TypeConstructor typeConstructor2 = enhancedClassifier.getTypeConstructor();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = index + 1;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = enhancedMutabilityAnnotations != null;
        Iterable iterable = $receiver$iv22 = (Iterable)$receiver.getArguments();
        Object destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv22, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $receiver$iv$iv) {
            TypeProjection typeProjection;
            void localArgIndex;
            void arg;
            int n = index$iv$iv++;
            TypeProjection typeProjection2 = (TypeProjection)item$iv$iv;
            int n2 = n;
            Collection collection = destination$iv$iv;
            if (arg.isStarProjection()) {
                int n3 = globalArgIndex.element;
                globalArgIndex.element = n3 + 1;
                typeProjection = TypeUtils.makeStarProjection(enhancedClassifier.getTypeConstructor().getParameters().get((int)localArgIndex));
            } else {
                Result enhanced = TypeEnhancementKt.enhancePossiblyFlexible(arg.getType().unwrap(), qualifiers, globalArgIndex.element);
                wereChanges.element = wereChanges.element || enhanced.getWereChanges();
                globalArgIndex.element += enhanced.getSubtreeSize();
                KotlinType kotlinType = enhanced.getType();
                Variance variance = arg.getProjectionKind();
                Intrinsics.checkExpressionValueIsNotNull((Object)variance, "arg.projectionKind");
                typeProjection = TypeUtilsKt.createProjection(kotlinType, variance, typeConstructor2.getParameters().get((int)localArgIndex));
            }
            TypeProjection typeProjection3 = typeProjection;
            collection.add(typeProjection3);
        }
        List enhancedArguments = (List)destination$iv$iv;
        destination$iv$iv = TypeEnhancementKt.getEnhancedNullability($receiver, effectiveQualifiers, position);
        boolean $receiver$iv22 = (Boolean)((EnhancementResult)destination$iv$iv).component1();
        $receiver$iv$iv = ((EnhancementResult)destination$iv$iv).component2();
        destination$iv$iv = null;
        wereChanges.element = wereChanges.element || enhancedNullabilityAnnotations != null;
        int subtreeSize = globalArgIndex.element - index;
        if (!wereChanges.element) {
            return new SimpleResult($receiver, subtreeSize, false);
        }
        Annotations newAnnotations = TypeEnhancementKt.compositeAnnotationsOrSingle(CollectionsKt.filterNotNull((Iterable)CollectionsKt.listOf(new Annotations[]{$receiver.getAnnotations(), enhancedMutabilityAnnotations, enhancedNullabilityAnnotations})));
        TypeConstructor typeConstructor3 = typeConstructor2;
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor3, "typeConstructor");
        SimpleType enhancedType = KotlinTypeFactory.simpleType$default(newAnnotations, typeConstructor3, enhancedArguments, (boolean)enhancedNullability, null, 16, null);
        SimpleType result2 = effectiveQualifiers.isNotNullTypeParameter$kotlin_core() ? (SimpleType)new NotNullTypeParameter(enhancedType) : enhancedType;
        return new SimpleResult(result2, subtreeSize, true);
    }

    private static final Annotations compositeAnnotationsOrSingle(@NotNull List<? extends Annotations> $receiver) {
        Annotations annotations2;
        switch ($receiver.size()) {
            case 0: {
                String string = "At least one Annotations object expected";
                throw (Throwable)new IllegalStateException(string.toString());
            }
            case 1: {
                annotations2 = CollectionsKt.single($receiver);
                break;
            }
            default: {
                annotations2 = new CompositeAnnotations(kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((Collection)$receiver));
            }
        }
        return annotations2;
    }

    private static final boolean shouldEnhance(@NotNull TypeComponentPosition $receiver) {
        return Intrinsics.areEqual((Object)$receiver, (Object)TypeComponentPosition.INFLEXIBLE) ^ true;
    }

    private static final <T> EnhancementResult<T> noChange(T $receiver) {
        return new EnhancementResult<T>($receiver, null);
    }

    private static final <T> EnhancementResult<T> enhancedNullability(T $receiver) {
        return new EnhancementResult<T>($receiver, ENHANCED_NULLABILITY_ANNOTATIONS);
    }

    private static final <T> EnhancementResult<T> enhancedMutability(T $receiver) {
        return new EnhancementResult<T>($receiver, ENHANCED_MUTABILITY_ANNOTATIONS);
    }

    private static final EnhancementResult<ClassifierDescriptor> enhanceMutability(@NotNull ClassifierDescriptor $receiver, JavaTypeQualifiers qualifiers, TypeComponentPosition position) {
        if (!TypeEnhancementKt.shouldEnhance(position)) {
            return TypeEnhancementKt.noChange($receiver);
        }
        if (!($receiver instanceof ClassDescriptor)) {
            return TypeEnhancementKt.noChange($receiver);
        }
        JavaToKotlinClassMap mapping = JavaToKotlinClassMap.INSTANCE;
        MutabilityQualifier mutabilityQualifier = qualifiers.getMutability();
        if (mutabilityQualifier != null) {
            switch (TypeEnhancementKt$WhenMappings.$EnumSwitchMapping$0[mutabilityQualifier.ordinal()]) {
                case 1: {
                    if (!Intrinsics.areEqual((Object)position, (Object)TypeComponentPosition.FLEXIBLE_LOWER) || !mapping.isMutable((ClassDescriptor)$receiver)) break;
                    return TypeEnhancementKt.enhancedMutability(mapping.convertMutableToReadOnly((ClassDescriptor)$receiver));
                }
                case 2: {
                    if (!Intrinsics.areEqual((Object)position, (Object)TypeComponentPosition.FLEXIBLE_UPPER) || !mapping.isReadOnly((ClassDescriptor)$receiver)) break;
                    return TypeEnhancementKt.enhancedMutability(mapping.convertReadOnlyToMutable((ClassDescriptor)$receiver));
                }
            }
        }
        return TypeEnhancementKt.noChange($receiver);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final EnhancementResult<Boolean> getEnhancedNullability(@NotNull KotlinType $receiver, JavaTypeQualifiers qualifiers, TypeComponentPosition position) {
        EnhancementResult<Boolean> enhancementResult;
        if (!TypeEnhancementKt.shouldEnhance(position)) {
            return TypeEnhancementKt.noChange($receiver.isMarkedNullable());
        }
        NullabilityQualifier nullabilityQualifier = qualifiers.getNullability();
        if (nullabilityQualifier != null) {
            switch (TypeEnhancementKt$WhenMappings.$EnumSwitchMapping$1[nullabilityQualifier.ordinal()]) {
                case 1: {
                    enhancementResult = TypeEnhancementKt.enhancedNullability(true);
                    return enhancementResult;
                }
                case 2: {
                    enhancementResult = TypeEnhancementKt.enhancedNullability(false);
                    return enhancementResult;
                }
            }
        }
        enhancementResult = TypeEnhancementKt.noChange($receiver.isMarkedNullable());
        return enhancementResult;
    }

    static {
        FqName fqName2 = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName2);
        FqName fqName3 = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
        ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName3);
    }
}

