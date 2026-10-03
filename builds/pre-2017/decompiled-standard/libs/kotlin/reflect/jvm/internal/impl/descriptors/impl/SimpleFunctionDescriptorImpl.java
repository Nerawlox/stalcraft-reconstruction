/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimpleFunctionDescriptorImpl
extends FunctionDescriptorImpl
implements SimpleFunctionDescriptor {
    protected SimpleFunctionDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @Nullable SimpleFunctionDescriptor original, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "<init>"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "<init>"));
        }
        super(containingDeclaration, original, annotations2, name2, kind, source);
    }

    @NotNull
    public static SimpleFunctionDescriptorImpl create(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"));
        }
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = new SimpleFunctionDescriptorImpl(containingDeclaration, null, annotations2, name2, kind, source);
        if (simpleFunctionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "create"));
        }
        return simpleFunctionDescriptorImpl;
    }

    @Override
    @NotNull
    public SimpleFunctionDescriptorImpl initialize(@Nullable KotlinType receiverParameterType, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @NotNull List<? extends TypeParameterDescriptor> typeParameters2, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @Nullable KotlinType unsubstitutedReturnType, @Nullable Modality modality, @NotNull Visibility visibility) {
        if (typeParameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"));
        }
        if (unsubstitutedValueParameters == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"));
        }
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = this.initialize(receiverParameterType, dispatchReceiverParameter, typeParameters2, unsubstitutedValueParameters, unsubstitutedReturnType, modality, visibility, null);
        if (simpleFunctionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"));
        }
        return simpleFunctionDescriptorImpl;
    }

    @NotNull
    public SimpleFunctionDescriptorImpl initialize(@Nullable KotlinType receiverParameterType, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @NotNull List<? extends TypeParameterDescriptor> typeParameters2, @NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @Nullable KotlinType unsubstitutedReturnType, @Nullable Modality modality, @NotNull Visibility visibility, @Nullable Map<? extends FunctionDescriptor.UserDataKey<?>, ?> userData) {
        if (typeParameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"));
        }
        if (unsubstitutedValueParameters == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"));
        }
        super.initialize(receiverParameterType, dispatchReceiverParameter, typeParameters2, unsubstitutedValueParameters, unsubstitutedReturnType, modality, visibility);
        if (userData != null) {
            this.userDataMap = new LinkedHashMap(userData);
        }
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = this;
        if (simpleFunctionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "initialize"));
        }
        return simpleFunctionDescriptorImpl;
    }

    @Override
    @NotNull
    public SimpleFunctionDescriptor getOriginal() {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor)super.getOriginal();
        if (simpleFunctionDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "getOriginal"));
        }
        return simpleFunctionDescriptor;
    }

    @Override
    @NotNull
    protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name newName, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        if (newOwner == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newOwner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "createSubstitutedCopy"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "createSubstitutedCopy"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "createSubstitutedCopy"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "createSubstitutedCopy"));
        }
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImpl = new SimpleFunctionDescriptorImpl(newOwner, (SimpleFunctionDescriptor)original, annotations2, newName != null ? newName : this.getName(), kind, source);
        if (simpleFunctionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "createSubstitutedCopy"));
        }
        return simpleFunctionDescriptorImpl;
    }

    @Override
    @NotNull
    public SimpleFunctionDescriptor copy(DeclarationDescriptor newOwner, Modality modality, Visibility visibility, CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor)super.copy(newOwner, modality, visibility, kind, copyOverrides);
        if (simpleFunctionDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "copy"));
        }
        return simpleFunctionDescriptor;
    }

    @Override
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder() {
        FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> copyBuilder = super.newCopyBuilder();
        if (copyBuilder == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl", "newCopyBuilder"));
        }
        return copyBuilder;
    }
}

