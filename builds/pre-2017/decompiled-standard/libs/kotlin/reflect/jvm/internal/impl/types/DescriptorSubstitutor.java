/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.Mutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ReadOnly;

public class DescriptorSubstitutor {
    private DescriptorSubstitutor() {
    }

    @NotNull
    public static TypeSubstitutor substituteTypeParameters(@ReadOnly @NotNull List<TypeParameterDescriptor> typeParameters2, @NotNull TypeSubstitution originalSubstitution, @NotNull DeclarationDescriptor newContainingDeclaration, @NotNull @Mutable List<TypeParameterDescriptor> result2) {
        if (typeParameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor", "substituteTypeParameters"));
        }
        if (originalSubstitution == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "originalSubstitution", "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor", "substituteTypeParameters"));
        }
        if (newContainingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newContainingDeclaration", "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor", "substituteTypeParameters"));
        }
        if (result2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor", "substituteTypeParameters"));
        }
        HashMap<TypeConstructor, TypeProjectionImpl> mutableSubstitution = new HashMap<TypeConstructor, TypeProjectionImpl>();
        HashMap<TypeParameterDescriptor, TypeParameterDescriptorImpl> substitutedMap = new HashMap<TypeParameterDescriptor, TypeParameterDescriptorImpl>();
        int index = 0;
        for (TypeParameterDescriptor descriptor2 : typeParameters2) {
            TypeParameterDescriptorImpl substituted = TypeParameterDescriptorImpl.createForFurtherModification(newContainingDeclaration, descriptor2.getAnnotations(), descriptor2.isReified(), descriptor2.getVariance(), descriptor2.getName(), index++, SourceElement.NO_SOURCE);
            mutableSubstitution.put(descriptor2.getTypeConstructor(), new TypeProjectionImpl(substituted.getDefaultType()));
            substitutedMap.put(descriptor2, substituted);
            result2.add(substituted);
        }
        TypeSubstitutor substitutor = TypeSubstitutor.createChainedSubstitutor(originalSubstitution, TypeConstructorSubstitution.createByConstructorsMap(mutableSubstitution));
        for (TypeParameterDescriptor descriptor3 : typeParameters2) {
            TypeParameterDescriptorImpl substituted = (TypeParameterDescriptorImpl)substitutedMap.get(descriptor3);
            for (KotlinType upperBound : descriptor3.getUpperBounds()) {
                KotlinType substitutedBound = substitutor.substitute(upperBound, Variance.IN_VARIANCE);
                assert (substitutedBound != null) : "Upper bound failed to substitute: " + descriptor3;
                substituted.addUpperBound(substitutedBound);
            }
            substituted.setInitialized();
        }
        TypeSubstitutor typeSubstitutor2 = substitutor;
        if (typeSubstitutor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor", "substituteTypeParameters"));
        }
        return typeSubstitutor2;
    }
}

