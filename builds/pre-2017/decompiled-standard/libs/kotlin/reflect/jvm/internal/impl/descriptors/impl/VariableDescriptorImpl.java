/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class VariableDescriptorImpl
extends DeclarationDescriptorNonRootImpl
implements VariableDescriptor {
    protected KotlinType outType;

    public VariableDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, @NotNull Name name2, @Nullable KotlinType outType, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "<init>"));
        }
        super(containingDeclaration, annotations2, name2, source);
        this.outType = outType;
    }

    @Override
    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = this.outType;
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getType"));
        }
        return kotlinType;
    }

    public void setOutType(KotlinType outType) {
        assert (this.outType == null);
        this.outType = outType;
    }

    @Override
    @NotNull
    public VariableDescriptor getOriginal() {
        VariableDescriptor variableDescriptor = (VariableDescriptor)super.getOriginal();
        if (variableDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getOriginal"));
        }
        return variableDescriptor;
    }

    @Override
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = Collections.emptyList();
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getValueParameters"));
        }
        return list;
    }

    @Override
    public boolean hasStableParameterNames() {
        return false;
    }

    @Override
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override
    @NotNull
    public Collection<? extends CallableDescriptor> getOverriddenDescriptors() {
        Set set = Collections.emptySet();
        if (set == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getOverriddenDescriptors"));
        }
        return set;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = Collections.emptyList();
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getTypeParameters"));
        }
        return list;
    }

    @Override
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return null;
    }

    @Override
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return null;
    }

    @Override
    @NotNull
    public KotlinType getReturnType() {
        KotlinType kotlinType = this.getType();
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl", "getReturnType"));
        }
        return kotlinType;
    }

    @Override
    public boolean isConst() {
        return false;
    }
}

