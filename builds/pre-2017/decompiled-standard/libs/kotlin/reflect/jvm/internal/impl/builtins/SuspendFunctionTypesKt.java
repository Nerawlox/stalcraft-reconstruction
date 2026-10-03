/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.MutableClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SuspendFunctionTypesKt {
    @NotNull
    private static final MutableClassDescriptor FAKE_CONTINUATION_CLASS_DESCRIPTOR;

    @NotNull
    public static final MutableClassDescriptor getFAKE_CONTINUATION_CLASS_DESCRIPTOR() {
        return FAKE_CONTINUATION_CLASS_DESCRIPTOR;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final SimpleType transformSuspendFunctionToRuntimeFunctionType(@NotNull KotlinType suspendFunType) {
        void var2_4;
        Collection<KotlinType> collection;
        void $receiver$iv$iv;
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull(suspendFunType, "suspendFunType");
        boolean bl = FunctionTypesKt.isSuspendFunctionType(suspendFunType);
        if (_Assertions.ENABLED && !bl) {
            String string = "This type should be suspend function type: " + suspendFunType;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        Iterable iterable = FunctionTypesKt.getValueParameterTypesFromFunctionType(suspendFunType);
        KotlinType kotlinType = FunctionTypesKt.getReceiverTypeFromFunctionType(suspendFunType);
        Annotations annotations2 = suspendFunType.getAnnotations();
        KotlinBuiltIns kotlinBuiltIns = TypeUtilsKt.getBuiltIns(suspendFunType);
        void $i$a$1$assert = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void p1;
            TypeProjection typeProjection = (TypeProjection)item$iv$iv;
            collection = destination$iv$iv;
            KotlinType kotlinType2 = p1.getType();
            collection.add(kotlinType2);
        }
        collection = (List)var2_4;
        Collection collection2 = collection;
        Annotations annotations3 = Annotations.Companion.getEMPTY();
        TypeConstructor typeConstructor2 = FAKE_CONTINUATION_CLASS_DESCRIPTOR.getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        List<SimpleType> list = CollectionsKt.plus(collection2, KotlinTypeFactory.simpleType$default(annotations3, typeConstructor2, CollectionsKt.listOf(TypeUtilsKt.asTypeProjection(FunctionTypesKt.getReturnTypeFromFunctionType(suspendFunType))), false, null, 16, null));
        SimpleType simpleType2 = TypeUtilsKt.getBuiltIns(suspendFunType).getNullableAnyType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "suspendFunType.builtIns.nullableAnyType");
        return FunctionTypesKt.createFunctionType$default(kotlinBuiltIns, annotations2, kotlinType, list, null, simpleType2, false, 64, null).makeNullableAsSpecified(suspendFunType.isMarkedNullable());
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final SimpleType transformRuntimeFunctionTypeToSuspendFunction(@NotNull KotlinType funType) {
        Collection<KotlinType> collection;
        void $receiver$iv$iv;
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull(funType, "funType");
        boolean bl = FunctionTypesKt.isFunctionType(funType);
        if (_Assertions.ENABLED && !bl) {
            String string = "This type should be function type: " + funType;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        Object object = CollectionsKt.lastOrNull(FunctionTypesKt.getValueParameterTypesFromFunctionType(funType));
        if (object == null || (object = object.getType()) == null) {
            return null;
        }
        Object continuationArgumentType = object;
        ClassifierDescriptor classifierDescriptor = ((KotlinType)continuationArgumentType).getConstructor().getDeclarationDescriptor();
        if (Intrinsics.areEqual(classifierDescriptor != null ? DescriptorUtilsKt.getFqNameSafe(classifierDescriptor) : null, DescriptorUtils.CONTINUATION_INTERFACE_FQ_NAME) ^ true || ((KotlinType)continuationArgumentType).getArguments().size() != 1) {
            return null;
        }
        KotlinType suspendReturnType = CollectionsKt.single(((KotlinType)continuationArgumentType).getArguments()).getType();
        Iterable iterable = CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(funType), 1);
        KotlinType kotlinType = FunctionTypesKt.getReceiverTypeFromFunctionType(funType);
        Annotations annotations2 = funType.getAnnotations();
        KotlinBuiltIns kotlinBuiltIns = TypeUtilsKt.getBuiltIns(funType);
        void var7_9 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void p1;
            TypeProjection typeProjection = (TypeProjection)item$iv$iv;
            collection = destination$iv$iv;
            KotlinType kotlinType2 = p1.getType();
            collection.add(kotlinType2);
        }
        collection = (List)destination$iv$iv;
        KotlinType kotlinType3 = suspendReturnType;
        Intrinsics.checkExpressionValueIsNotNull(kotlinType3, "suspendReturnType");
        return FunctionTypesKt.createFunctionType(kotlinBuiltIns, annotations2, kotlinType, (List<? extends KotlinType>)collection, null, kotlinType3, true).makeNullableAsSpecified(funType.isMarkedNullable());
    }

    static {
        MutableClassDescriptor mutableClassDescriptor;
        ModuleDescriptor moduleDescriptor = ErrorUtils.getErrorModule();
        Intrinsics.checkExpressionValueIsNotNull(moduleDescriptor, "ErrorUtils.getErrorModule()");
        FqName fqName2 = DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME");
        MutableClassDescriptor $receiver = mutableClassDescriptor = new MutableClassDescriptor(new EmptyPackageFragmentDescriptor(moduleDescriptor, fqName2), ClassKind.INTERFACE, false, false, DescriptorUtils.CONTINUATION_INTERFACE_FQ_NAME.shortName(), SourceElement.NO_SOURCE);
        $receiver.setModality(Modality.ABSTRACT);
        $receiver.setVisibility(Visibilities.PUBLIC);
        TypeParameterDescriptor typeParameterDescriptor = TypeParameterDescriptorImpl.createWithDefaultBound($receiver, Annotations.Companion.getEMPTY(), false, Variance.IN_VARIANCE, Name.identifier("T"), 0);
        MutableClassDescriptor mutableClassDescriptor2 = $receiver;
        TypeParameterDescriptor p1 = typeParameterDescriptor;
        List<TypeParameterDescriptor> list = CollectionsKt.listOf(p1);
        mutableClassDescriptor2.setTypeParameterDescriptors(list);
        $receiver.createTypeConstructor();
        FAKE_CONTINUATION_CLASS_DESCRIPTOR = mutableClassDescriptor;
    }
}

