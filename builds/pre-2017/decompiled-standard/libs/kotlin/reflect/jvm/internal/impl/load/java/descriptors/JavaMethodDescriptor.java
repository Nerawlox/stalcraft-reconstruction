/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.OperatorChecks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaMethodDescriptor
extends SimpleFunctionDescriptorImpl
implements JavaCallableMemberDescriptor {
    private ParameterNamesStatus parameterNamesStatus;

    protected JavaMethodDescriptor(@NotNull DeclarationDescriptor containingDeclaration, @Nullable SimpleFunctionDescriptor original, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "<init>"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "<init>"));
        }
        super(containingDeclaration, original, annotations2, name2, kind, source);
        this.parameterNamesStatus = null;
    }

    @NotNull
    public static JavaMethodDescriptor createJavaMethod(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createJavaMethod"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createJavaMethod"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createJavaMethod"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createJavaMethod"));
        }
        JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(containingDeclaration, null, annotations2, name2, CallableMemberDescriptor.Kind.DECLARATION, source);
        if (javaMethodDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createJavaMethod"));
        }
        return javaMethodDescriptor;
    }

    @Override
    @NotNull
    public SimpleFunctionDescriptorImpl initialize(@Nullable KotlinType receiverParameterType, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @NotNull List<? extends TypeParameterDescriptor> typeParameters2, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @Nullable KotlinType unsubstitutedReturnType, @Nullable Modality modality, @NotNull Visibility visibility) {
        if (typeParameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "initialize"));
        }
        if (unsubstitutedValueParameters == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "initialize"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "initialize"));
        }
        FunctionDescriptorImpl descriptor2 = super.initialize(receiverParameterType, dispatchReceiverParameter, (List)typeParameters2, (List)unsubstitutedValueParameters, unsubstitutedReturnType, modality, visibility);
        this.setOperator(OperatorChecks.INSTANCE.check(descriptor2).isSuccess());
        FunctionDescriptorImpl functionDescriptorImpl = descriptor2;
        if (functionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "initialize"));
        }
        return functionDescriptorImpl;
    }

    @Override
    public boolean hasStableParameterNames() {
        assert (this.parameterNamesStatus != null) : "Parameter names status was not set: " + this;
        return this.parameterNamesStatus.isStable;
    }

    @Override
    public boolean hasSynthesizedParameterNames() {
        assert (this.parameterNamesStatus != null) : "Parameter names status was not set: " + this;
        return this.parameterNamesStatus.isSynthesized;
    }

    public void setParameterNamesStatus(boolean hasStableParameterNames, boolean hasSynthesizedParameterNames) {
        this.parameterNamesStatus = ParameterNamesStatus.get(hasStableParameterNames, hasSynthesizedParameterNames);
    }

    @Override
    @NotNull
    protected JavaMethodDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name newName, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        if (newOwner == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newOwner", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createSubstitutedCopy"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createSubstitutedCopy"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createSubstitutedCopy"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createSubstitutedCopy"));
        }
        JavaMethodDescriptor result2 = new JavaMethodDescriptor(newOwner, (SimpleFunctionDescriptor)original, annotations2, newName != null ? newName : this.getName(), kind, source);
        result2.setParameterNamesStatus(this.hasStableParameterNames(), this.hasSynthesizedParameterNames());
        JavaMethodDescriptor javaMethodDescriptor = result2;
        if (javaMethodDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "createSubstitutedCopy"));
        }
        return javaMethodDescriptor;
    }

    @Override
    @NotNull
    public JavaMethodDescriptor enhance(@Nullable KotlinType enhancedReceiverType, @NotNull List<KotlinType> enhancedValueParametersTypes, @NotNull KotlinType enhancedReturnType) {
        if (enhancedValueParametersTypes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enhancedValueParametersTypes", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "enhance"));
        }
        if (enhancedReturnType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enhancedReturnType", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "enhance"));
        }
        List<ValueParameterDescriptor> enhancedValueParameters = UtilKt.copyValueParameters(enhancedValueParametersTypes, this.getValueParameters(), this);
        JavaMethodDescriptor enhancedMethod = (JavaMethodDescriptor)this.newCopyBuilder().setValueParameters(enhancedValueParameters).setReturnType(enhancedReturnType).setExtensionReceiverType(enhancedReceiverType).setDropOriginalInContainingParts().setPreserveSourceElement().build();
        assert (enhancedMethod != null) : "null after substitution while enhancing " + this.toString();
        JavaMethodDescriptor javaMethodDescriptor = enhancedMethod;
        if (javaMethodDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor", "enhance"));
        }
        return javaMethodDescriptor;
    }

    private static enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean isStable;
        public final boolean isSynthesized;

        private ParameterNamesStatus(boolean isStable, boolean isSynthesized) {
            this.isStable = isStable;
            this.isSynthesized = isSynthesized;
        }

        @NotNull
        public static ParameterNamesStatus get(boolean stable, boolean synthesized) {
            ParameterNamesStatus parameterNamesStatus = stable ? (synthesized ? STABLE_SYNTHESIZED : STABLE_DECLARED) : (synthesized ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED);
            if (parameterNamesStatus == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
            }
            return parameterNamesStatus;
        }
    }
}

