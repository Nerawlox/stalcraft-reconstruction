/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UtilKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<ValueParameterDescriptor> copyValueParameters(@NotNull Collection<? extends KotlinType> newValueParametersTypes, @NotNull Collection<? extends ValueParameterDescriptor> oldValueParameters, @NotNull CallableDescriptor newOwner) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        boolean bl;
        Intrinsics.checkParameterIsNotNull(newValueParametersTypes, "newValueParametersTypes");
        Intrinsics.checkParameterIsNotNull(oldValueParameters, "oldValueParameters");
        Intrinsics.checkParameterIsNotNull(newOwner, "newOwner");
        boolean bl2 = bl = newValueParametersTypes.size() == oldValueParameters.size();
        if (_Assertions.ENABLED && !bl) {
            String string = "Different value parameters sizes: Enhanced = " + newValueParametersTypes.size() + ", Old = " + oldValueParameters.size();
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        Iterable $i$a$1$assert = $receiver$iv = (Iterable)CollectionsKt.zip((Iterable)newValueParametersTypes, (Iterable)oldValueParameters);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void newType;
            void oldParameter;
            void pair;
            Pair pair2 = (Pair)item$iv$iv;
            Collection collection = destination$iv$iv;
            Object var10_12 = pair;
            KotlinType kotlinType = (KotlinType)var10_12.component1();
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor)var10_12.component2();
            var10_12 = null;
            int n = oldParameter.getIndex();
            Annotations annotations2 = oldParameter.getAnnotations();
            Name name2 = oldParameter.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "oldParameter.name");
            boolean bl3 = oldParameter.declaresDefaultValue();
            boolean bl4 = oldParameter.isCrossinline();
            boolean bl5 = oldParameter.isNoinline();
            KotlinType kotlinType2 = oldParameter.getVarargElementType() != null ? DescriptorUtilsKt.getModule(newOwner).getBuiltIns().getArrayElementType((KotlinType)newType) : null;
            SourceElement sourceElement = oldParameter.getSource();
            Intrinsics.checkExpressionValueIsNotNull(sourceElement, "oldParameter.source");
            ValueParameterDescriptorImpl valueParameterDescriptorImpl = new ValueParameterDescriptorImpl(newOwner, (ValueParameterDescriptor)oldParameter, n, annotations2, name2, (KotlinType)newType, bl3, bl4, bl5, kotlinType2, sourceElement);
            collection.add(valueParameterDescriptorImpl);
        }
        return (List)destination$iv$iv;
    }

    @Nullable
    public static final LazyJavaStaticClassScope getParentJavaStaticClassScope(@NotNull ClassDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassDescriptor classDescriptor = DescriptorUtilsKt.getSuperClassNotAny($receiver);
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor superClassDescriptor = classDescriptor;
        MemberScope staticScope = superClassDescriptor.getStaticScope();
        if (!(staticScope instanceof LazyJavaStaticClassScope)) {
            return UtilKt.getParentJavaStaticClassScope(superClassDescriptor);
        }
        return (LazyJavaStaticClassScope)staticScope;
    }

    @Nullable
    public static final Name getImplClassNameForDeserialized(@NotNull DeserializedMemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        DeserializedContainerSource deserializedContainerSource = $receiver.getContainerSource();
        if (!(deserializedContainerSource instanceof JvmPackagePartSource)) {
            deserializedContainerSource = null;
        }
        JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource)deserializedContainerSource;
        return jvmPackagePartSource != null ? jvmPackagePartSource.getSimpleName() : null;
    }

    public static final boolean isFromJvmPackagePart(@NotNull DeserializedMemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.getContainerSource() instanceof JvmPackagePartSource;
    }
}

