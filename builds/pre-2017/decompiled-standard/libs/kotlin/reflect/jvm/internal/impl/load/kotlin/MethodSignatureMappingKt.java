/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfigurationImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MethodSignatureMappingKt {
    @NotNull
    public static final String computeJvmDescriptor(@NotNull FunctionDescriptor $receiver, boolean withReturnType) {
        String string;
        StringBuilder stringBuilder;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        StringBuilder $receiver2 = stringBuilder = new StringBuilder();
        if ($receiver instanceof ConstructorDescriptor) {
            string = "<init>";
        } else {
            String string2 = $receiver.getName().asString();
            string = string2;
            Intrinsics.checkExpressionValueIsNotNull(string2, "name.asString()");
        }
        $receiver2.append(string);
        $receiver2.append("(");
        Iterable $receiver$iv = $receiver.getValueParameters();
        for (Object element$iv : $receiver$iv) {
            ValueParameterDescriptor it = (ValueParameterDescriptor)element$iv;
            KotlinType kotlinType = it.getType();
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "it.type");
            MethodSignatureMappingKt.appendErasedType($receiver2, kotlinType);
        }
        $receiver2.append(")");
        if (withReturnType) {
            if (TypeSignatureMappingKt.hasVoidReturnType($receiver)) {
                $receiver2.append("V");
            } else {
                KotlinType kotlinType = $receiver.getReturnType();
                if (kotlinType == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "returnType!!");
                MethodSignatureMappingKt.appendErasedType($receiver2, kotlinType);
            }
        }
        return stringBuilder.toString();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ String computeJvmDescriptor$default(FunctionDescriptor functionDescriptor, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return MethodSignatureMappingKt.computeJvmDescriptor(functionDescriptor, bl);
    }

    public static final boolean forceSingleValueParameterBoxing(@NotNull FunctionDescriptor f) {
        Intrinsics.checkParameterIsNotNull(f, "f");
        if (f.getValueParameters().size() != 1 || SpecialBuiltinMembers.isFromJavaOrBuiltins(f) || Intrinsics.areEqual(f.getName().asString(), "remove") ^ true) {
            return false;
        }
        JvmType jvmType = MethodSignatureMappingKt.mapToJvmType(CollectionsKt.single(f.getOriginal().getValueParameters()).getType());
        if (!(jvmType instanceof JvmType.Primitive)) {
            jvmType = null;
        }
        JvmType.Primitive primitive = (JvmType.Primitive)jvmType;
        if (Intrinsics.areEqual((Object)(primitive != null ? primitive.getJvmPrimitiveType() : null), (Object)JvmPrimitiveType.INT) ^ true) {
            return false;
        }
        FunctionDescriptor functionDescriptor = BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(f);
        if (functionDescriptor == null) {
            return false;
        }
        FunctionDescriptor overridden = functionDescriptor;
        JvmType overriddenParameterType = MethodSignatureMappingKt.mapToJvmType(CollectionsKt.single(overridden.getOriginal().getValueParameters()).getType());
        return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe(overridden.getContainingDeclaration()), KotlinBuiltIns.FQ_NAMES.mutableCollection.toUnsafe()) && overriddenParameterType instanceof JvmType.Object && Intrinsics.areEqual(((JvmType.Object)overriddenParameterType).getInternalName(), "java/lang/Object");
    }

    @Nullable
    public static final String computeJvmSignature(@NotNull CallableDescriptor $receiver) {
        SignatureBuildingComponents signatureBuildingComponents;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        SignatureBuildingComponents $receiver2 = signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        if (DescriptorUtils.isLocal($receiver)) {
            return null;
        }
        DeclarationDescriptor declarationDescriptor = $receiver.getContainingDeclaration();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)declarationDescriptor;
        if (classDescriptor == null) {
            return null;
        }
        ClassDescriptor classDescriptor2 = classDescriptor;
        if (classDescriptor2.getName().isSpecial()) {
            return null;
        }
        CallableDescriptor callableDescriptor = $receiver.getOriginal();
        if (!(callableDescriptor instanceof SimpleFunctionDescriptor)) {
            callableDescriptor = null;
        }
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor)callableDescriptor;
        if (simpleFunctionDescriptor == null) {
            return null;
        }
        String string = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, 1, null);
        Intrinsics.checkExpressionValueIsNotNull(string, "(original as? SimpleFunc\u2026l).computeJvmDescriptor()");
        return $receiver2.signature(classDescriptor2, string);
    }

    @NotNull
    public static final String getInternalName(@NotNull ClassDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassId classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(DescriptorUtilsKt.getFqNameSafe($receiver).toUnsafe());
        if (classId != null) {
            ClassId classId2;
            ClassId it = classId2 = classId;
            String string = JvmClassName.byClassId(it).getInternalName();
            Intrinsics.checkExpressionValueIsNotNull(string, "JvmClassName.byClassId(it).internalName");
            return string;
        }
        return TypeSignatureMappingKt.computeInternalName$default($receiver, null, 2, null);
    }

    @NotNull
    public static final String getInternalName(@NotNull ClassId $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassId classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava($receiver.asSingleFqName().toUnsafe());
        if (classId == null) {
            classId = $receiver;
        }
        String string = JvmClassName.byClassId(classId).getInternalName();
        Intrinsics.checkExpressionValueIsNotNull(string, "JvmClassName.byClassId(J\u2026()) ?: this).internalName");
        return string;
    }

    private static final void appendErasedType(@NotNull StringBuilder $receiver, KotlinType type2) {
        $receiver.append(MethodSignatureMappingKt.mapToJvmType(type2));
    }

    @NotNull
    public static final JvmType mapToJvmType(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return (JvmType)TypeSignatureMappingKt.mapType$default($receiver, JvmTypeFactoryImpl.INSTANCE, TypeMappingMode.DEFAULT, TypeMappingConfigurationImpl.INSTANCE, null, null, 32, null);
    }
}

