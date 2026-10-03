/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CapturedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeParameterUtilsKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(@NotNull ClassifierDescriptorWithTypeParameters $receiver) {
        void $receiver$iv$iv;
        void $receiver$iv;
        Sequence<DeclarationDescriptor> containingClassTypeConstructorParameters;
        Object object;
        Sequence<DeclarationDescriptor> sequence;
        DeclarationDescriptor declarationDescriptor;
        DeclarationDescriptor element$iv;
        Object object2;
        Sequence<DeclarationDescriptor> $receiver$iv2;
        List parametersFromContainingFunctions2;
        List<TypeParameterDescriptor> declaredParameters2;
        block5: {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            declaredParameters2 = $receiver.getDeclaredTypeParameters();
            if (!$receiver.isInner() && !($receiver.getContainingDeclaration() instanceof CallableDescriptor)) {
                List<TypeParameterDescriptor> list = declaredParameters2;
                Intrinsics.checkExpressionValueIsNotNull(list, "declaredParameters");
                return list;
            }
            parametersFromContainingFunctions2 = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.takeWhile(DescriptorUtilsKt.getParents($receiver), computeConstructorTypeParameters.parametersFromContainingFunctions.1.INSTANCE), computeConstructorTypeParameters.parametersFromContainingFunctions.2.INSTANCE));
            $receiver$iv2 = DescriptorUtilsKt.getParents($receiver);
            object2 = $receiver$iv2.iterator();
            while (object2.hasNext()) {
                element$iv = object2.next();
                if (!(element$iv instanceof ClassDescriptor)) continue;
                declarationDescriptor = element$iv;
                break block5;
            }
            declarationDescriptor = null;
        }
        if ((sequence = ($receiver$iv2 = (object = (ClassDescriptor)declarationDescriptor) != null && (object = object.getTypeConstructor()) != null ? object.getParameters() : null)) == null) {
            sequence = containingClassTypeConstructorParameters = CollectionsKt.emptyList();
        }
        if (parametersFromContainingFunctions2.isEmpty() && containingClassTypeConstructorParameters.isEmpty()) {
            List<TypeParameterDescriptor> list = $receiver.getDeclaredTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(list, "declaredTypeParameters");
            return list;
        }
        object2 = CollectionsKt.plus((Collection)parametersFromContainingFunctions2, (Iterable)((Object)containingClassTypeConstructorParameters));
        element$iv = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            CapturedTypeParameterDescriptor capturedTypeParameterDescriptor = TypeParameterUtilsKt.capturedCopyForInnerDeclaration((TypeParameterDescriptor)it, $receiver, declaredParameters2.size());
            collection.add(capturedTypeParameterDescriptor);
        }
        List additional = (List)destination$iv$iv;
        return CollectionsKt.plus((Collection)declaredParameters2, (Iterable)additional);
    }

    private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(@NotNull TypeParameterDescriptor $receiver, DeclarationDescriptor declarationDescriptor, int declaredTypeParametersCount) {
        return new CapturedTypeParameterDescriptor($receiver, declarationDescriptor, declaredTypeParametersCount);
    }

    @Nullable
    public static final PossiblyInnerType buildPossiblyInnerType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassifierDescriptor classifierDescriptor = $receiver.getConstructor().getDeclarationDescriptor();
        if (!(classifierDescriptor instanceof ClassifierDescriptorWithTypeParameters)) {
            classifierDescriptor = null;
        }
        return TypeParameterUtilsKt.buildPossiblyInnerType($receiver, (ClassifierDescriptorWithTypeParameters)classifierDescriptor, 0);
    }

    private static final PossiblyInnerType buildPossiblyInnerType(@NotNull KotlinType $receiver, ClassifierDescriptorWithTypeParameters classifierDescriptor, int index) {
        if (classifierDescriptor == null || ErrorUtils.isError(classifierDescriptor)) {
            return null;
        }
        int toIndex = classifierDescriptor.getDeclaredTypeParameters().size() + index;
        if (!classifierDescriptor.isInner()) {
            boolean bl;
            boolean bl2 = bl = toIndex == $receiver.getArguments().size() || DescriptorUtils.isLocal(classifierDescriptor);
            if (_Assertions.ENABLED && !bl) {
                String string = $receiver.getArguments().size() - toIndex + " trailing arguments were found in " + $receiver + " type";
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            return new PossiblyInnerType(classifierDescriptor, $receiver.getArguments().subList(index, $receiver.getArguments().size()), null);
        }
        List<TypeProjection> argumentsSubList = $receiver.getArguments().subList(index, toIndex);
        DeclarationDescriptor declarationDescriptor = classifierDescriptor.getContainingDeclaration();
        if (!(declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters)) {
            declarationDescriptor = null;
        }
        return new PossiblyInnerType(classifierDescriptor, argumentsSubList, TypeParameterUtilsKt.buildPossiblyInnerType($receiver, (ClassifierDescriptorWithTypeParameters)declarationDescriptor, toIndex));
    }
}

