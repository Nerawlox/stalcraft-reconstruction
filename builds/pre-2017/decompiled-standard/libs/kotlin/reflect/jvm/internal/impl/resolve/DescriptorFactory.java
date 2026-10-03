/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DescriptorFactory {
    private DescriptorFactory() {
    }

    @NotNull
    public static PropertySetterDescriptorImpl createDefaultSetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations2) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createDefaultSetter"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createDefaultSetter"));
        }
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = DescriptorFactory.createSetter(propertyDescriptor, annotations2, true, false, false, propertyDescriptor.getSource());
        if (propertySetterDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createDefaultSetter"));
        }
        return propertySetterDescriptorImpl;
    }

    @NotNull
    public static PropertySetterDescriptorImpl createSetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations2, boolean isDefault, boolean isExternal, boolean isInline, @NotNull SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"));
        }
        if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "sourceElement", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"));
        }
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = DescriptorFactory.createSetter(propertyDescriptor, annotations2, isDefault, isExternal, isInline, propertyDescriptor.getVisibility(), sourceElement);
        if (propertySetterDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"));
        }
        return propertySetterDescriptorImpl;
    }

    @NotNull
    public static PropertySetterDescriptorImpl createSetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations2, boolean isDefault, boolean isExternal, boolean isInline, @NotNull Visibility visibility, @NotNull SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"));
        }
        if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "sourceElement", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"));
        }
        PropertySetterDescriptorImpl setterDescriptor = new PropertySetterDescriptorImpl(propertyDescriptor, annotations2, propertyDescriptor.getModality(), visibility, isDefault, isExternal, isInline, CallableMemberDescriptor.Kind.DECLARATION, null, sourceElement);
        setterDescriptor.initializeDefault();
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = setterDescriptor;
        if (propertySetterDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createSetter"));
        }
        return propertySetterDescriptorImpl;
    }

    @NotNull
    public static PropertyGetterDescriptorImpl createDefaultGetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations2) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createDefaultGetter"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createDefaultGetter"));
        }
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = DescriptorFactory.createGetter(propertyDescriptor, annotations2, true, false, false);
        if (propertyGetterDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createDefaultGetter"));
        }
        return propertyGetterDescriptorImpl;
    }

    @NotNull
    public static PropertyGetterDescriptorImpl createGetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations2, boolean isDefault, boolean isExternal, boolean isInline) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"));
        }
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = DescriptorFactory.createGetter(propertyDescriptor, annotations2, isDefault, isExternal, isInline, propertyDescriptor.getSource());
        if (propertyGetterDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"));
        }
        return propertyGetterDescriptorImpl;
    }

    @NotNull
    public static PropertyGetterDescriptorImpl createGetter(@NotNull PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations2, boolean isDefault, boolean isExternal, boolean isInline, @NotNull SourceElement sourceElement) {
        if (propertyDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "propertyDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"));
        }
        if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "sourceElement", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"));
        }
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(propertyDescriptor, annotations2, propertyDescriptor.getModality(), propertyDescriptor.getVisibility(), isDefault, isExternal, isInline, CallableMemberDescriptor.Kind.DECLARATION, null, sourceElement);
        if (propertyGetterDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createGetter"));
        }
        return propertyGetterDescriptorImpl;
    }

    @NotNull
    public static ClassConstructorDescriptorImpl createPrimaryConstructorForObject(@NotNull ClassDescriptor containingClass, @NotNull SourceElement source) {
        if (containingClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createPrimaryConstructorForObject"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createPrimaryConstructorForObject"));
        }
        DefaultClassConstructorDescriptor defaultClassConstructorDescriptor = new DefaultClassConstructorDescriptor(containingClass, source);
        if (defaultClassConstructorDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createPrimaryConstructorForObject"));
        }
        return defaultClassConstructorDescriptor;
    }

    @NotNull
    public static SimpleFunctionDescriptor createEnumValuesMethod(@NotNull ClassDescriptor enumClass) {
        if (enumClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createEnumValuesMethod"));
        }
        SimpleFunctionDescriptorImpl values2 = SimpleFunctionDescriptorImpl.create(enumClass, Annotations.Companion.getEMPTY(), DescriptorUtils.ENUM_VALUES, CallableMemberDescriptor.Kind.SYNTHESIZED, enumClass.getSource());
        FunctionDescriptorImpl functionDescriptorImpl = values2.initialize((KotlinType)null, (ReceiverParameterDescriptor)null, Collections.emptyList(), Collections.emptyList(), (KotlinType)DescriptorUtilsKt.getBuiltIns(enumClass).getArrayType(Variance.INVARIANT, enumClass.getDefaultType()), Modality.FINAL, Visibilities.PUBLIC);
        if (functionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createEnumValuesMethod"));
        }
        return functionDescriptorImpl;
    }

    @NotNull
    public static SimpleFunctionDescriptor createEnumValueOfMethod(@NotNull ClassDescriptor enumClass) {
        if (enumClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createEnumValueOfMethod"));
        }
        SimpleFunctionDescriptorImpl valueOf = SimpleFunctionDescriptorImpl.create(enumClass, Annotations.Companion.getEMPTY(), DescriptorUtils.ENUM_VALUE_OF, CallableMemberDescriptor.Kind.SYNTHESIZED, enumClass.getSource());
        ValueParameterDescriptorImpl parameterDescriptor = new ValueParameterDescriptorImpl(valueOf, null, 0, Annotations.Companion.getEMPTY(), Name.identifier("value"), DescriptorUtilsKt.getBuiltIns(enumClass).getStringType(), false, false, false, null, enumClass.getSource());
        FunctionDescriptorImpl functionDescriptorImpl = valueOf.initialize((KotlinType)null, (ReceiverParameterDescriptor)null, Collections.emptyList(), Collections.singletonList(parameterDescriptor), (KotlinType)enumClass.getDefaultType(), Modality.FINAL, Visibilities.PUBLIC);
        if (functionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createEnumValueOfMethod"));
        }
        return functionDescriptorImpl;
    }

    @Nullable
    public static ReceiverParameterDescriptor createExtensionReceiverParameterForCallable(@NotNull CallableDescriptor owner, @Nullable KotlinType receiverParameterType) {
        if (owner == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "owner", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory", "createExtensionReceiverParameterForCallable"));
        }
        return receiverParameterType == null ? null : new ReceiverParameterDescriptorImpl(owner, new ExtensionReceiver(owner, receiverParameterType));
    }

    private static class DefaultClassConstructorDescriptor
    extends ClassConstructorDescriptorImpl {
        public DefaultClassConstructorDescriptor(@NotNull ClassDescriptor containingClass, @NotNull SourceElement source) {
            if (containingClass == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor", "<init>"));
            }
            if (source == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor", "<init>"));
            }
            super(containingClass, null, Annotations.Companion.getEMPTY(), true, CallableMemberDescriptor.Kind.DECLARATION, source);
            this.initialize(Collections.<ValueParameterDescriptor>emptyList(), DescriptorUtils.getDefaultConstructorVisibility(containingClass));
        }
    }
}

