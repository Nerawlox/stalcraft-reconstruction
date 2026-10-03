/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PropertySetterDescriptorImpl
extends PropertyAccessorDescriptorImpl
implements PropertySetterDescriptor {
    private ValueParameterDescriptor parameter;
    @NotNull
    private final PropertySetterDescriptor original;

    public PropertySetterDescriptorImpl(@NotNull PropertyDescriptor correspondingProperty, @NotNull Annotations annotations2, @NotNull Modality modality, @NotNull Visibility visibility, boolean isDefault, boolean isExternal, boolean isInline, @NotNull CallableMemberDescriptor.Kind kind, @Nullable PropertySetterDescriptor original, @NotNull SourceElement source) {
        if (correspondingProperty == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "correspondingProperty", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"));
        }
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "<init>"));
        }
        super(modality, visibility, correspondingProperty, annotations2, Name.special("<set-" + correspondingProperty.getName() + ">"), isDefault, isExternal, isInline, kind, source);
        this.original = original != null ? original : this;
    }

    public void initialize(@NotNull ValueParameterDescriptor parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameter", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "initialize"));
        }
        assert (this.parameter == null);
        this.parameter = parameter;
    }

    public void initializeDefault() {
        assert (this.parameter == null);
        this.parameter = PropertySetterDescriptorImpl.createSetterParameter(this, this.getCorrespondingProperty().getReturnType());
    }

    public static ValueParameterDescriptorImpl createSetterParameter(@NotNull PropertySetterDescriptor setterDescriptor, @NotNull KotlinType type2) {
        if (setterDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "setterDescriptor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "createSetterParameter"));
        }
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "createSetterParameter"));
        }
        return new ValueParameterDescriptorImpl(setterDescriptor, null, 0, Annotations.Companion.getEMPTY(), Name.special("<set-?>"), type2, false, false, false, null, SourceElement.NO_SOURCE);
    }

    @Override
    @NotNull
    public Collection<? extends PropertySetterDescriptor> getOverriddenDescriptors() {
        Collection<PropertyAccessorDescriptor> collection = super.getOverriddenDescriptors(false);
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "getOverriddenDescriptors"));
        }
        return collection;
    }

    @Override
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        if (this.parameter == null) {
            throw new IllegalStateException();
        }
        List<ValueParameterDescriptor> list = Collections.singletonList(this.parameter);
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "getValueParameters"));
        }
        return list;
    }

    @Override
    @NotNull
    public KotlinType getReturnType() {
        SimpleType simpleType2 = DescriptorUtilsKt.getBuiltIns(this).getUnitType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "getReturnType"));
        }
        return simpleType2;
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        return visitor2.visitPropertySetterDescriptor(this, data2);
    }

    @Override
    @NotNull
    public PropertySetterDescriptor getOriginal() {
        PropertySetterDescriptor propertySetterDescriptor = this.original;
        if (propertySetterDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl", "getOriginal"));
        }
        return propertySetterDescriptor;
    }
}

