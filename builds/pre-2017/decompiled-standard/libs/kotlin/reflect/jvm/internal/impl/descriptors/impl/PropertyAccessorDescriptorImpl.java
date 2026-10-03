/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PropertyAccessorDescriptorImpl
extends DeclarationDescriptorNonRootImpl
implements PropertyAccessorDescriptor {
    private final boolean isDefault;
    private final boolean isExternal;
    private final Modality modality;
    private final PropertyDescriptor correspondingProperty;
    private final boolean isInline;
    private final CallableMemberDescriptor.Kind kind;
    private Visibility visibility;
    @Nullable
    private FunctionDescriptor initialSignatureDescriptor;

    public PropertyAccessorDescriptorImpl(@NotNull Modality modality, @NotNull Visibility visibility, @NotNull PropertyDescriptor correspondingProperty, @NotNull Annotations annotations2, @NotNull Name name2, boolean isDefault, boolean isExternal, boolean isInline, CallableMemberDescriptor.Kind kind, @NotNull SourceElement source) {
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"));
        }
        if (correspondingProperty == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "correspondingProperty", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "<init>"));
        }
        super(correspondingProperty.getContainingDeclaration(), annotations2, name2, source);
        this.initialSignatureDescriptor = null;
        this.modality = modality;
        this.visibility = visibility;
        this.correspondingProperty = correspondingProperty;
        this.isDefault = isDefault;
        this.isExternal = isExternal;
        this.isInline = isInline;
        this.kind = kind;
    }

    @Override
    public boolean isDefault() {
        return this.isDefault;
    }

    @Override
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.kind;
        if (kind == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getKind"));
        }
        return kind;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public boolean isInfix() {
        return false;
    }

    @Override
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override
    public boolean isInline() {
        return this.isInline;
    }

    @Override
    public boolean isTailrec() {
        return false;
    }

    @Override
    public boolean isSuspend() {
        return false;
    }

    @Override
    public boolean isHeader() {
        return false;
    }

    @Override
    public boolean isImpl() {
        return false;
    }

    @Override
    @NotNull
    public FunctionDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        if (substitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "substitute"));
        }
        throw new UnsupportedOperationException();
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = Collections.emptyList();
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getTypeParameters"));
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
    public Modality getModality() {
        Modality modality = this.modality;
        if (modality == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getModality"));
        }
        return modality;
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        Visibility visibility = this.visibility;
        if (visibility == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getVisibility"));
        }
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    @NotNull
    public VariableDescriptorWithAccessors getCorrespondingVariable() {
        PropertyDescriptor propertyDescriptor = this.correspondingProperty;
        if (propertyDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getCorrespondingVariable"));
        }
        return propertyDescriptor;
    }

    @Override
    @NotNull
    public PropertyDescriptor getCorrespondingProperty() {
        PropertyDescriptor propertyDescriptor = this.correspondingProperty;
        if (propertyDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getCorrespondingProperty"));
        }
        return propertyDescriptor;
    }

    @Override
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.getCorrespondingProperty().getExtensionReceiverParameter();
    }

    @Override
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.getCorrespondingProperty().getDispatchReceiverParameter();
    }

    @Override
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override
    @NotNull
    public PropertyAccessorDescriptor copy(DeclarationDescriptor newOwner, Modality modality, Visibility visibility, CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @NotNull
    protected Collection<PropertyAccessorDescriptor> getOverriddenDescriptors(boolean isGetter) {
        ArrayList<PropertyAccessorDescriptor> result2 = new ArrayList<PropertyAccessorDescriptor>(0);
        for (PropertyDescriptor propertyDescriptor : this.getCorrespondingProperty().getOverriddenDescriptors()) {
            PropertyAccessorDescriptor accessorDescriptor = isGetter ? propertyDescriptor.getGetter() : propertyDescriptor.getSetter();
            if (accessorDescriptor == null) continue;
            result2.add(accessorDescriptor);
        }
        ArrayList<PropertyAccessorDescriptor> arrayList = result2;
        if (arrayList == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "getOverriddenDescriptors"));
        }
        return arrayList;
    }

    @Override
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        if (overriddenDescriptors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overriddenDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl", "setOverriddenDescriptors"));
        }
        assert (overriddenDescriptors.isEmpty()) : "Overridden accessors should be empty";
    }

    @Override
    @NotNull
    public abstract PropertyAccessorDescriptor getOriginal();

    @Override
    @Nullable
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    public void setInitialSignatureDescriptor(@Nullable FunctionDescriptor initialSignatureDescriptor) {
        this.initialSignatureDescriptor = initialSignatureDescriptor;
    }

    @Override
    public boolean isHiddenToOvercomeSignatureClash() {
        return false;
    }

    @Override
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return false;
    }

    @Override
    @Nullable
    public <V> V getUserData(FunctionDescriptor.UserDataKey<V> key) {
        return null;
    }
}

