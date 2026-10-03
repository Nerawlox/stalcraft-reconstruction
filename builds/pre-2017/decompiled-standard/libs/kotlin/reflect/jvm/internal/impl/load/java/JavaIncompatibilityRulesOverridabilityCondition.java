/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaIncompatibilityRulesOverridabilityCondition
implements ExternalOverridabilityCondition {
    public static final Companion Companion = new Companion(null);

    @Override
    @NotNull
    public ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, @Nullable ClassDescriptor subClassDescriptor) {
        Intrinsics.checkParameterIsNotNull(superDescriptor, "superDescriptor");
        Intrinsics.checkParameterIsNotNull(subDescriptor, "subDescriptor");
        if (this.isIncompatibleInAccordanceWithBuiltInOverridabilityRules(superDescriptor, subDescriptor, subClassDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        if (Companion.doesJavaOverrideHaveIncompatibleValueParameterKinds(superDescriptor, subDescriptor)) {
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }

    private final boolean isIncompatibleInAccordanceWithBuiltInOverridabilityRules(CallableDescriptor superDescriptor, CallableDescriptor subDescriptor, ClassDescriptor subClassDescriptor) {
        if (!(superDescriptor instanceof CallableMemberDescriptor) || !(subDescriptor instanceof FunctionDescriptor) || KotlinBuiltIns.isBuiltIn(subDescriptor)) {
            return false;
        }
        if (!BuiltinMethodsWithSpecialGenericSignature.INSTANCE.getSameAsBuiltinMethodWithErasedValueParameters(((FunctionDescriptor)subDescriptor).getName()) && !BuiltinMethodsWithDifferentJvmName.INSTANCE.getSameAsRenamedInJvmBuiltin(((FunctionDescriptor)subDescriptor).getName())) {
            return false;
        }
        CallableMemberDescriptor overriddenBuiltin = SpecialBuiltinMembers.getOverriddenSpecialBuiltin((CallableMemberDescriptor)superDescriptor);
        Boolean bl = ((FunctionDescriptor)subDescriptor).isHiddenToOvercomeSignatureClash();
        CallableDescriptor callableDescriptor = superDescriptor;
        if (!(callableDescriptor instanceof FunctionDescriptor)) {
            callableDescriptor = null;
        }
        FunctionDescriptor functionDescriptor = (FunctionDescriptor)callableDescriptor;
        boolean isOneOfDescriptorsHidden = Intrinsics.areEqual(bl, functionDescriptor != null ? Boolean.valueOf(functionDescriptor.isHiddenToOvercomeSignatureClash()) : null) ^ true;
        if (isOneOfDescriptorsHidden && (overriddenBuiltin == null || !((FunctionDescriptor)subDescriptor).isHiddenToOvercomeSignatureClash())) {
            return true;
        }
        if (!(subClassDescriptor instanceof JavaClassDescriptor) || ((FunctionDescriptor)subDescriptor).getInitialSignatureDescriptor() != null) {
            return false;
        }
        if (overriddenBuiltin == null || SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(subClassDescriptor, overriddenBuiltin)) {
            return false;
        }
        return !(overriddenBuiltin instanceof FunctionDescriptor) || !(superDescriptor instanceof FunctionDescriptor) || BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava((FunctionDescriptor)overriddenBuiltin) == null || !Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor((FunctionDescriptor)subDescriptor, false), MethodSignatureMappingKt.computeJvmDescriptor(((FunctionDescriptor)superDescriptor).getOriginal(), false));
    }

    @Override
    @NotNull
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    public static final class Companion {
        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor) {
            boolean bl;
            Intrinsics.checkParameterIsNotNull(superDescriptor, "superDescriptor");
            Intrinsics.checkParameterIsNotNull(subDescriptor, "subDescriptor");
            if (!(subDescriptor instanceof JavaMethodDescriptor) || !(superDescriptor instanceof FunctionDescriptor)) {
                return false;
            }
            boolean bl2 = bl = ((JavaMethodDescriptor)subDescriptor).getValueParameters().size() == ((FunctionDescriptor)superDescriptor).getValueParameters().size();
            if (_Assertions.ENABLED && !bl) {
                String string = "External overridability condition with CONFLICTS_ONLY should not be run with different value parameters size";
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            Iterable iterable = ((JavaMethodDescriptor)subDescriptor).getOriginal().getValueParameters();
            List<ValueParameterDescriptor> list = ((FunctionDescriptor)superDescriptor).getOriginal().getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(list, "superDescriptor.original.valueParameters");
            for (Pair pair : CollectionsKt.zip(iterable, (Iterable)list)) {
                ValueParameterDescriptor subParameter = (ValueParameterDescriptor)pair.component1();
                ValueParameterDescriptor superParameter = (ValueParameterDescriptor)pair.component2();
                FunctionDescriptor functionDescriptor = (FunctionDescriptor)subDescriptor;
                ValueParameterDescriptor valueParameterDescriptor = subParameter;
                Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor, "subParameter");
                boolean isSubPrimitive = this.mapValueParameterType(functionDescriptor, valueParameterDescriptor) instanceof JvmType.Primitive;
                FunctionDescriptor functionDescriptor2 = (FunctionDescriptor)superDescriptor;
                ValueParameterDescriptor valueParameterDescriptor2 = superParameter;
                Intrinsics.checkExpressionValueIsNotNull(valueParameterDescriptor2, "superParameter");
                boolean isSuperPrimitive = this.mapValueParameterType(functionDescriptor2, valueParameterDescriptor2) instanceof JvmType.Primitive;
                if (isSubPrimitive == isSuperPrimitive) continue;
                return true;
            }
            return false;
        }

        private final JvmType mapValueParameterType(FunctionDescriptor f, ValueParameterDescriptor valueParameterDescriptor) {
            return MethodSignatureMappingKt.forceSingleValueParameterBoxing(f) || this.isPrimitiveCompareTo(f) ? MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(valueParameterDescriptor.getType())) : MethodSignatureMappingKt.mapToJvmType(valueParameterDescriptor.getType());
        }

        private final boolean isPrimitiveCompareTo(FunctionDescriptor f) {
            if (f.getValueParameters().size() != 1) {
                return false;
            }
            DeclarationDescriptor declarationDescriptor = f.getContainingDeclaration();
            if (!(declarationDescriptor instanceof ClassDescriptor)) {
                declarationDescriptor = null;
            }
            ClassDescriptor classDescriptor = (ClassDescriptor)declarationDescriptor;
            if (classDescriptor == null) {
                return false;
            }
            ClassDescriptor classDescriptor2 = classDescriptor;
            ClassifierDescriptor classifierDescriptor = CollectionsKt.single(f.getValueParameters()).getType().getConstructor().getDeclarationDescriptor();
            if (!(classifierDescriptor instanceof ClassDescriptor)) {
                classifierDescriptor = null;
            }
            ClassDescriptor classDescriptor3 = (ClassDescriptor)classifierDescriptor;
            if (classDescriptor3 == null) {
                return false;
            }
            ClassDescriptor parameterClass = classDescriptor3;
            return KotlinBuiltIns.isPrimitiveClass(classDescriptor2) && Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(classDescriptor2), DescriptorUtilsKt.getFqNameSafe(parameterClass));
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

