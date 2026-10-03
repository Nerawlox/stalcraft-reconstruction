/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.NameAndSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmName(name="SpecialBuiltinMembers")
public final class SpecialBuiltinMembers {
    private static final FqName child(@NotNull FqName $receiver, String name2) {
        FqName fqName2 = $receiver.child(Name.identifier(name2));
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "child(Name.identifier(name))");
        return fqName2;
    }

    private static final FqName childSafe(@NotNull FqNameUnsafe $receiver, String name2) {
        FqName fqName2 = $receiver.child(Name.identifier(name2)).toSafe();
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "child(Name.identifier(name)).toSafe()");
        return fqName2;
    }

    private static final NameAndSignature method(@NotNull String $receiver, String name2, String parameters2, String returnType) {
        Name name3 = Name.identifier(name2);
        Intrinsics.checkExpressionValueIsNotNull(name3, "Name.identifier(name)");
        return new NameAndSignature(name3, SignatureBuildingComponents.INSTANCE.signature($receiver, name2 + "(" + parameters2 + ")" + returnType));
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinWithDifferentJvmName(@NotNull T $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (BuiltinMethodsWithDifferentJvmName.INSTANCE.getORIGINAL_SHORT_NAMES().contains($receiver.getName()) ^ true && BuiltinSpecialProperties.INSTANCE.getSPECIAL_SHORT_NAMES$kotlin_core().contains(DescriptorUtilsKt.getPropertyIfAccessor($receiver).getName()) ^ true) {
            return null;
        }
        T t = $receiver;
        return (T)(t instanceof PropertyDescriptor || t instanceof PropertyAccessorDescriptor ? DescriptorUtilsKt.firstOverridden$default($receiver, false, getOverriddenBuiltinWithDifferentJvmName.1.INSTANCE, 1, null) : (t instanceof SimpleFunctionDescriptor ? DescriptorUtilsKt.firstOverridden$default($receiver, false, getOverriddenBuiltinWithDifferentJvmName.2.INSTANCE, 1, null) : null));
    }

    public static final boolean doesOverrideBuiltinWithDifferentJvmName(@NotNull CallableMemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName($receiver) != null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T getOverriddenSpecialBuiltin(@NotNull T $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        T t = SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName($receiver);
        if (t != null) {
            T t2;
            T it = t2 = t;
            return it;
        }
        if (!BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters($receiver.getName())) {
            return null;
        }
        return (T)DescriptorUtilsKt.firstOverridden$default($receiver, false, getOverriddenSpecialBuiltin.2.INSTANCE, 1, null);
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T getOverriddenBuiltinReflectingJvmDescriptor(@NotNull T $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        T t = SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName($receiver);
        if (t != null) {
            T t2;
            T it = t2 = t;
            return it;
        }
        if (!BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters($receiver.getName())) {
            return null;
        }
        CallableMemberDescriptor callableMemberDescriptor = DescriptorUtilsKt.firstOverridden$default($receiver, false, getOverriddenBuiltinReflectingJvmDescriptor.2.INSTANCE, 1, null);
        return (T)(callableMemberDescriptor != null ? callableMemberDescriptor.getOriginal() : null);
    }

    @Nullable
    public static final String getJvmMethodNameIfSpecial(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        String string;
        CallableMemberDescriptor overriddenBuiltin;
        Intrinsics.checkParameterIsNotNull(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor callableMemberDescriptor2 = SpecialBuiltinMembers.getOverriddenBuiltinThatAffectsJvmName(callableMemberDescriptor);
        if (callableMemberDescriptor2 == null || (callableMemberDescriptor2 = DescriptorUtilsKt.getPropertyIfAccessor(callableMemberDescriptor2)) == null) {
            return null;
        }
        CallableMemberDescriptor callableMemberDescriptor3 = overriddenBuiltin = callableMemberDescriptor2;
        if (callableMemberDescriptor3 instanceof PropertyDescriptor) {
            string = BuiltinSpecialProperties.INSTANCE.getBuiltinSpecialPropertyGetterName(overriddenBuiltin);
        } else if (callableMemberDescriptor3 instanceof SimpleFunctionDescriptor) {
            Name name2 = BuiltinMethodsWithDifferentJvmName.INSTANCE.getJvmName((SimpleFunctionDescriptor)overriddenBuiltin);
            string = name2 != null ? name2.asString() : null;
        } else {
            string = null;
        }
        return string;
    }

    private static final CallableMemberDescriptor getOverriddenBuiltinThatAffectsJvmName(CallableMemberDescriptor callableMemberDescriptor) {
        return KotlinBuiltIns.isBuiltIn(callableMemberDescriptor) ? SpecialBuiltinMembers.getOverriddenBuiltinWithDifferentJvmName(callableMemberDescriptor) : null;
    }

    public static final boolean hasRealKotlinSuperClassWithOverrideOf(@NotNull ClassDescriptor $receiver, @NotNull CallableDescriptor specialCallableDescriptor) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(specialCallableDescriptor, "specialCallableDescriptor");
        DeclarationDescriptor declarationDescriptor = specialCallableDescriptor.getContainingDeclaration();
        if (declarationDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        SimpleType builtinContainerDefaultType = ((ClassDescriptor)declarationDescriptor).getDefaultType();
        ClassDescriptor superClassDescriptor = DescriptorUtils.getSuperClassDescriptor($receiver);
        while (superClassDescriptor != null) {
            if (!(superClassDescriptor instanceof JavaClassDescriptor)) {
                boolean doesOverrideBuiltinDeclaration;
                boolean bl = doesOverrideBuiltinDeclaration = TypeCheckingProcedure.findCorrespondingSupertype(superClassDescriptor.getDefaultType(), builtinContainerDefaultType) != null;
                if (doesOverrideBuiltinDeclaration) {
                    return !KotlinBuiltIns.isBuiltIn(superClassDescriptor);
                }
            }
            superClassDescriptor = DescriptorUtils.getSuperClassDescriptor(superClassDescriptor);
        }
        return false;
    }

    public static final boolean isFromJava(@NotNull CallableMemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        CallableMemberDescriptor callableMemberDescriptor = DescriptorUtilsKt.getPropertyIfAccessor($receiver);
        CallableMemberDescriptor descriptor2 = callableMemberDescriptor;
        CallableMemberDescriptor callableMemberDescriptor2 = descriptor2;
        if (!(callableMemberDescriptor2 instanceof JavaCallableMemberDescriptor)) {
            callableMemberDescriptor2 = null;
        }
        JavaCallableMemberDescriptor javaCallableMemberDescriptor = (JavaCallableMemberDescriptor)callableMemberDescriptor2;
        return (javaCallableMemberDescriptor != null ? javaCallableMemberDescriptor.getContainingDeclaration() : null) instanceof JavaClassDescriptor;
    }

    public static final boolean isFromJavaOrBuiltins(@NotNull CallableMemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return SpecialBuiltinMembers.isFromJava($receiver) || KotlinBuiltIns.isBuiltIn($receiver);
    }

    @NotNull
    public static final /* synthetic */ FqName access$childSafe(@NotNull FqNameUnsafe $receiver, @NotNull String name2) {
        return SpecialBuiltinMembers.childSafe($receiver, name2);
    }

    @NotNull
    public static final /* synthetic */ FqName access$child(@NotNull FqName $receiver, @NotNull String name2) {
        return SpecialBuiltinMembers.child($receiver, name2);
    }

    @NotNull
    public static final /* synthetic */ NameAndSignature access$method(@NotNull String $receiver, @NotNull String name2, @NotNull String parameters2, @NotNull String returnType) {
        return SpecialBuiltinMembers.method($receiver, name2, parameters2, returnType);
    }
}

