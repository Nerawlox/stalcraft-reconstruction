/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StarProjectionImplKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final KotlinType starProjectionType(@NotNull TypeParameterDescriptor $receiver) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        DeclarationDescriptor declarationDescriptor = $receiver.getContainingDeclaration();
        if (declarationDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
        }
        ClassifierDescriptorWithTypeParameters classDescriptor = (ClassifierDescriptorWithTypeParameters)declarationDescriptor;
        Iterable iterable = $receiver$iv = (Iterable)classDescriptor.getTypeConstructor().getParameters();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            TypeConstructor typeConstructor2 = it.getTypeConstructor();
            collection.add(typeConstructor2);
        }
        List typeParameters2 = (List)destination$iv$iv;
        KotlinType kotlinType = TypeSubstitutor.create(new TypeConstructorSubstitution(typeParameters2){
            final /* synthetic */ List $typeParameters;

            @Nullable
            public TypeProjection get(@NotNull TypeConstructor key) {
                TypeProjection typeProjection;
                Intrinsics.checkParameterIsNotNull(key, "key");
                if (this.$typeParameters.contains(key)) {
                    ClassifierDescriptor classifierDescriptor = key.getDeclarationDescriptor();
                    if (classifierDescriptor == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    }
                    typeProjection = TypeUtils.makeStarProjection((TypeParameterDescriptor)classifierDescriptor);
                } else {
                    typeProjection = null;
                }
                return typeProjection;
            }
            {
                this.$typeParameters = $captured_local_variable$0;
            }
        }).substitute(CollectionsKt.first($receiver.getUpperBounds()), Variance.OUT_VARIANCE);
        if (kotlinType == null) {
            SimpleType simpleType2 = DescriptorUtilsKt.getBuiltIns($receiver).getDefaultBound();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "builtIns.defaultBound");
            kotlinType = simpleType2;
        }
        return kotlinType;
    }
}

