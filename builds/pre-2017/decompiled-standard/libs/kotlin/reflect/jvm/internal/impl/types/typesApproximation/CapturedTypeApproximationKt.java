/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt$WhenMappings;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CapturedTypeApproximationKt {
    private static final TypeProjection toTypeProjection(@NotNull TypeArgument $receiver) {
        boolean bl = $receiver.isConsistent();
        if (_Assertions.ENABLED && !bl) {
            DescriptorRenderer descriptorRenderer2 = DescriptorRenderer.Companion.withOptions(toTypeProjection.1.descriptorRenderer.1.INSTANCE);
            String string = "Only consistent enhanced type projection can be converted to type projection, but " + ("[" + descriptorRenderer2.render($receiver.getTypeParameter()) + ": <" + descriptorRenderer2.renderType($receiver.getInProjection()) + ", " + descriptorRenderer2.renderType($receiver.getOutProjection()) + ">]") + " was found";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        Function1<Variance, Variance> removeProjectionIfRedundant$ = new Function1<Variance, Variance>($receiver){
            final /* synthetic */ TypeArgument receiver$0;

            @NotNull
            public final Variance invoke(@NotNull Variance variance) {
                Intrinsics.checkParameterIsNotNull((Object)((Object)variance), "variance");
                return Intrinsics.areEqual((Object)((Object)variance), (Object)((Object)this.receiver$0.getTypeParameter().getVariance())) ? Variance.INVARIANT : variance;
            }
            {
                this.receiver$0 = typeArgument;
                super(1);
            }
        };
        return Intrinsics.areEqual($receiver.getInProjection(), $receiver.getOutProjection()) ? (TypeProjection)new TypeProjectionImpl($receiver.getInProjection()) : (KotlinBuiltIns.isNothing($receiver.getInProjection()) && Intrinsics.areEqual((Object)$receiver.getTypeParameter().getVariance(), (Object)Variance.IN_VARIANCE) ^ true ? (TypeProjection)new TypeProjectionImpl(removeProjectionIfRedundant$.invoke(Variance.OUT_VARIANCE), $receiver.getOutProjection()) : (KotlinBuiltIns.isNullableAny($receiver.getOutProjection()) ? (TypeProjection)new TypeProjectionImpl(removeProjectionIfRedundant$.invoke(Variance.IN_VARIANCE), $receiver.getInProjection()) : (TypeProjection)new TypeProjectionImpl(removeProjectionIfRedundant$.invoke(Variance.OUT_VARIANCE), $receiver.getOutProjection())));
    }

    private static final TypeArgument toTypeArgument(@NotNull TypeProjection $receiver, TypeParameterDescriptor typeParameter) {
        TypeArgument typeArgument;
        switch (CapturedTypeApproximationKt$WhenMappings.$EnumSwitchMapping$0[TypeSubstitutor.combine(typeParameter.getVariance(), $receiver).ordinal()]) {
            case 1: {
                KotlinType kotlinType = $receiver.getType();
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "type");
                KotlinType kotlinType2 = $receiver.getType();
                Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "type");
                typeArgument = new TypeArgument(typeParameter, kotlinType, kotlinType2);
                break;
            }
            case 2: {
                KotlinType kotlinType = $receiver.getType();
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "type");
                SimpleType simpleType2 = DescriptorUtilsKt.getBuiltIns(typeParameter).getNullableAnyType();
                Intrinsics.checkExpressionValueIsNotNull(simpleType2, "typeParameter.builtIns.nullableAnyType");
                typeArgument = new TypeArgument(typeParameter, kotlinType, simpleType2);
                break;
            }
            case 3: {
                SimpleType simpleType3 = DescriptorUtilsKt.getBuiltIns(typeParameter).getNothingType();
                Intrinsics.checkExpressionValueIsNotNull(simpleType3, "typeParameter.builtIns.nothingType");
                KotlinType kotlinType = simpleType3;
                KotlinType kotlinType3 = $receiver.getType();
                Intrinsics.checkExpressionValueIsNotNull(kotlinType3, "type");
                typeArgument = new TypeArgument(typeParameter, kotlinType, kotlinType3);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return typeArgument;
    }

    @Nullable
    public static final TypeProjection approximateCapturedTypesIfNecessary(@Nullable TypeProjection typeProjection, boolean approximateContravariant) {
        if (typeProjection == null) {
            return null;
        }
        if (typeProjection.isStarProjection()) {
            return typeProjection;
        }
        KotlinType type2 = typeProjection.getType();
        if (!TypeUtils.contains(type2, approximateCapturedTypesIfNecessary.1.INSTANCE)) {
            return typeProjection;
        }
        Variance howThisTypeIsUsed = typeProjection.getProjectionKind();
        if (Intrinsics.areEqual((Object)howThisTypeIsUsed, (Object)Variance.OUT_VARIANCE)) {
            KotlinType kotlinType = type2;
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "type");
            ApproximationBounds<KotlinType> approximation = CapturedTypeApproximationKt.approximateCapturedTypes(kotlinType);
            return new TypeProjectionImpl(howThisTypeIsUsed, approximation.getUpper());
        }
        if (approximateContravariant) {
            KotlinType kotlinType = type2;
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "type");
            KotlinType approximation = CapturedTypeApproximationKt.approximateCapturedTypes(kotlinType).getLower();
            return new TypeProjectionImpl(howThisTypeIsUsed, approximation);
        }
        return CapturedTypeApproximationKt.substituteCapturedTypesWithProjections(typeProjection);
    }

    private static final TypeProjection substituteCapturedTypesWithProjections(TypeProjection typeProjection) {
        TypeSubstitutor typeSubstitutor2 = TypeSubstitutor.create(new TypeConstructorSubstitution(){

            @Nullable
            public TypeProjection get(@NotNull TypeConstructor key) {
                Intrinsics.checkParameterIsNotNull(key, "key");
                TypeConstructor typeConstructor2 = key;
                if (!(typeConstructor2 instanceof CapturedTypeConstructor)) {
                    typeConstructor2 = null;
                }
                CapturedTypeConstructor capturedTypeConstructor = (CapturedTypeConstructor)typeConstructor2;
                if (capturedTypeConstructor == null) {
                    return null;
                }
                CapturedTypeConstructor capturedTypeConstructor2 = capturedTypeConstructor;
                if (capturedTypeConstructor2.getTypeProjection().isStarProjection()) {
                    return new TypeProjectionImpl(Variance.OUT_VARIANCE, capturedTypeConstructor2.getTypeProjection().getType());
                }
                return capturedTypeConstructor2.getTypeProjection();
            }
        });
        return typeSubstitutor2.substituteWithoutApproximation(typeProjection);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final ApproximationBounds<KotlinType> approximateCapturedTypes(@NotNull KotlinType type2) {
        KotlinType kotlinType;
        boolean lowerBoundIsTrivial;
        ArrayList<Object> upperBoundArguments;
        ArrayList<Object> lowerBoundArguments;
        block13: {
            boolean bl;
            Intrinsics.checkParameterIsNotNull(type2, "type");
            if (FlexibleTypesKt.isFlexible(type2)) {
                ApproximationBounds<KotlinType> boundsForFlexibleLower = CapturedTypeApproximationKt.approximateCapturedTypes(FlexibleTypesKt.lowerIfFlexible(type2));
                ApproximationBounds<KotlinType> boundsForFlexibleUpper = CapturedTypeApproximationKt.approximateCapturedTypes(FlexibleTypesKt.upperIfFlexible(type2));
                return new ApproximationBounds<KotlinType>(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(boundsForFlexibleLower.getLower()), FlexibleTypesKt.upperIfFlexible(boundsForFlexibleUpper.getLower())), KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(boundsForFlexibleLower.getUpper()), FlexibleTypesKt.upperIfFlexible(boundsForFlexibleUpper.getUpper())));
            }
            TypeConstructor typeConstructor2 = type2.getConstructor();
            if (CapturedTypeConstructorKt.isCaptured(type2)) {
                ApproximationBounds<SimpleType> approximationBounds;
                TypeConstructor typeConstructor3 = typeConstructor2;
                if (typeConstructor3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
                }
                TypeProjection typeProjection = ((CapturedTypeConstructor)typeConstructor3).getTypeProjection();
                Function1<KotlinType, KotlinType> makeNullableIfNeeded$ = new Function1<KotlinType, KotlinType>(type2){
                    final /* synthetic */ KotlinType $type;

                    @NotNull
                    public final KotlinType invoke(@NotNull KotlinType $receiver) {
                        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                        return TypeUtils.makeNullableIfNeeded($receiver, this.$type.isMarkedNullable());
                    }
                    {
                        this.$type = kotlinType;
                        super(1);
                    }
                };
                KotlinType bound = makeNullableIfNeeded$.invoke(typeProjection.getType());
                switch (CapturedTypeApproximationKt$WhenMappings.$EnumSwitchMapping$1[typeProjection.getProjectionKind().ordinal()]) {
                    case 1: {
                        KotlinType kotlinType2 = bound;
                        Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "bound");
                        SimpleType simpleType2 = TypeUtilsKt.getBuiltIns(type2).getNullableAnyType();
                        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "type.builtIns.nullableAnyType");
                        approximationBounds = new ApproximationBounds<SimpleType>((SimpleType)kotlinType2, simpleType2);
                        break;
                    }
                    case 2: {
                        approximationBounds = new ApproximationBounds<KotlinType>(makeNullableIfNeeded$.invoke((KotlinType)TypeUtilsKt.getBuiltIns(type2).getNothingType()), bound);
                        break;
                    }
                    default: {
                        throw (Throwable)((Object)new AssertionError((Object)("Only nontrivial projections should have been captured, not: " + typeProjection)));
                    }
                }
                return approximationBounds;
            }
            if (type2.getArguments().isEmpty() || type2.getArguments().size() != typeConstructor2.getParameters().size()) {
                return new ApproximationBounds<KotlinType>(type2, type2);
            }
            lowerBoundArguments = new ArrayList<Object>();
            upperBoundArguments = new ArrayList<Object>();
            Iterable iterable = type2.getArguments();
            List<TypeParameterDescriptor> list = typeConstructor2.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(list, "typeConstructor.parameters");
            for (Pair bound : CollectionsKt.zip(iterable, (Iterable)list)) {
                void upper;
                void lower;
                TypeParameterDescriptor typeParameter;
                TypeProjection typeProjection = (TypeProjection)bound.component1();
                TypeParameterDescriptor typeParameterDescriptor = typeParameter = (TypeParameterDescriptor)bound.component2();
                Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "typeParameter");
                TypeArgument typeArgument = CapturedTypeApproximationKt.toTypeArgument(typeProjection, typeParameterDescriptor);
                if (typeProjection.isStarProjection()) {
                    lowerBoundArguments.add(typeArgument);
                    upperBoundArguments.add(typeArgument);
                    continue;
                }
                ApproximationBounds<TypeArgument> approximationBounds = CapturedTypeApproximationKt.approximateProjection(typeArgument);
                TypeArgument typeArgument2 = approximationBounds.component1();
                TypeArgument typeArgument3 = approximationBounds.component2();
                approximationBounds = null;
                lowerBoundArguments.add(lower);
                upperBoundArguments.add(upper);
            }
            Iterable $receiver$iv = lowerBoundArguments;
            for (Object element$iv : $receiver$iv) {
                TypeArgument it = (TypeArgument)element$iv;
                if (!(!it.isConsistent())) continue;
                bl = true;
                break block13;
            }
            bl = lowerBoundIsTrivial = false;
        }
        if (lowerBoundIsTrivial) {
            SimpleType simpleType3 = TypeUtilsKt.getBuiltIns(type2).getNothingType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType3, "type.builtIns.nothingType");
            kotlinType = simpleType3;
        } else {
            kotlinType = CapturedTypeApproximationKt.replaceTypeArguments(type2, (List<TypeArgument>)lowerBoundArguments);
        }
        return new ApproximationBounds<KotlinType>(kotlinType, CapturedTypeApproximationKt.replaceTypeArguments(type2, (List<TypeArgument>)upperBoundArguments));
    }

    /*
     * WARNING - void declaration
     */
    private static final KotlinType replaceTypeArguments(@NotNull KotlinType $receiver, List<TypeArgument> newTypeArguments) {
        void var3_5;
        Collection<TypeProjection> collection;
        void $receiver$iv$iv;
        void $receiver$iv;
        boolean bl;
        boolean bl2 = bl = $receiver.getArguments().size() == newTypeArguments.size();
        if (_Assertions.ENABLED && !bl) {
            String string = "Incorrect type arguments " + newTypeArguments;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        Iterable iterable = newTypeArguments;
        KotlinType kotlinType = $receiver;
        void $i$a$1$assert = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            TypeArgument typeArgument = (TypeArgument)item$iv$iv;
            collection = destination$iv$iv;
            TypeProjection typeProjection = CapturedTypeApproximationKt.toTypeProjection((TypeArgument)it);
            collection.add(typeProjection);
        }
        collection = (List)var3_5;
        return TypeSubstitutionKt.replace$default(kotlinType, (List)collection, null, 2, null);
    }

    /*
     * WARNING - void declaration
     */
    private static final ApproximationBounds<TypeArgument> approximateProjection(TypeArgument typeArgument) {
        void outUpper;
        void inLower;
        void outLower;
        void inUpper;
        Object object = CapturedTypeApproximationKt.approximateCapturedTypes(typeArgument.getInProjection());
        KotlinType kotlinType = ((ApproximationBounds)object).component1();
        KotlinType kotlinType2 = ((ApproximationBounds)object).component2();
        object = null;
        ApproximationBounds<KotlinType> approximationBounds = CapturedTypeApproximationKt.approximateCapturedTypes(typeArgument.getOutProjection());
        object = approximationBounds.component1();
        KotlinType kotlinType3 = approximationBounds.component2();
        approximationBounds = null;
        return new ApproximationBounds<TypeArgument>(new TypeArgument(typeArgument.getTypeParameter(), (KotlinType)inUpper, (KotlinType)outLower), new TypeArgument(typeArgument.getTypeParameter(), (KotlinType)inLower, (KotlinType)outUpper));
    }
}

