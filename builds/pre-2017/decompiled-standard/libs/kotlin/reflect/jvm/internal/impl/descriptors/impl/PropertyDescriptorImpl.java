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
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorWithInitializerImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ReadOnly;

public class PropertyDescriptorImpl
extends VariableDescriptorWithInitializerImpl
implements PropertyDescriptor {
    private final Modality modality;
    private Visibility visibility;
    private Collection<? extends PropertyDescriptor> overriddenProperties;
    private final PropertyDescriptor original;
    private final CallableMemberDescriptor.Kind kind;
    private final boolean lateInit;
    private final boolean isConst;
    private final boolean isHeader;
    private final boolean isImpl;
    private final boolean isExternal;
    private final boolean isDelegated;
    private ReceiverParameterDescriptor dispatchReceiverParameter;
    private ReceiverParameterDescriptor extensionReceiverParameter;
    private List<TypeParameterDescriptor> typeParameters;
    private PropertyGetterDescriptorImpl getter;
    private PropertySetterDescriptor setter;
    private boolean setterProjectedOut;

    protected PropertyDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @Nullable PropertyDescriptor original, @NotNull Annotations annotations2, @NotNull Modality modality, @NotNull Visibility visibility, boolean isVar, @NotNull Name name2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement source, boolean lateInit, boolean isConst, boolean isHeader, boolean isImpl, boolean isExternal, boolean isDelegated) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"));
        }
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "<init>"));
        }
        super(containingDeclaration, annotations2, name2, null, isVar, source);
        this.overriddenProperties = null;
        this.modality = modality;
        this.visibility = visibility;
        this.original = original == null ? this : original;
        this.kind = kind;
        this.lateInit = lateInit;
        this.isConst = isConst;
        this.isHeader = isHeader;
        this.isImpl = isImpl;
        this.isExternal = isExternal;
        this.isDelegated = isDelegated;
    }

    @NotNull
    public static PropertyDescriptorImpl create(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, @NotNull Modality modality, @NotNull Visibility visibility, boolean isVar, @NotNull Name name2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement source, boolean lateInit, boolean isConst, boolean isHeader, boolean isImpl, boolean isExternal, boolean isDelegated) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"));
        }
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"));
        }
        PropertyDescriptorImpl propertyDescriptorImpl = new PropertyDescriptorImpl(containingDeclaration, null, annotations2, modality, visibility, isVar, name2, kind, source, lateInit, isConst, isHeader, isImpl, isExternal, isDelegated);
        if (propertyDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "create"));
        }
        return propertyDescriptorImpl;
    }

    public void setType(@NotNull KotlinType outType, @ReadOnly @NotNull List<? extends TypeParameterDescriptor> typeParameters2, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @Nullable KotlinType receiverType) {
        if (outType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "outType", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setType"));
        }
        if (typeParameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setType"));
        }
        ReceiverParameterDescriptor extensionReceiverParameter = DescriptorFactory.createExtensionReceiverParameterForCallable(this, receiverType);
        this.setType(outType, typeParameters2, dispatchReceiverParameter, extensionReceiverParameter);
    }

    public void setType(@NotNull KotlinType outType, @ReadOnly @NotNull List<? extends TypeParameterDescriptor> typeParameters2, @Nullable ReceiverParameterDescriptor dispatchReceiverParameter, @Nullable ReceiverParameterDescriptor extensionReceiverParameter) {
        if (outType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "outType", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setType"));
        }
        if (typeParameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setType"));
        }
        this.setOutType(outType);
        this.typeParameters = new ArrayList<TypeParameterDescriptor>(typeParameters2);
        this.extensionReceiverParameter = extensionReceiverParameter;
        this.dispatchReceiverParameter = dispatchReceiverParameter;
    }

    public void initialize(@Nullable PropertyGetterDescriptorImpl getter, @Nullable PropertySetterDescriptor setter) {
        this.getter = getter;
        this.setter = setter;
    }

    public void setSetterProjectedOut(boolean setterProjectedOut) {
        this.setterProjectedOut = setterProjectedOut;
    }

    public void setVisibility(@NotNull Visibility visibility) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setVisibility"));
        }
        this.visibility = visibility;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeParameters;
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getTypeParameters"));
        }
        return list;
    }

    @Override
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    @Override
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    @Override
    @NotNull
    public KotlinType getReturnType() {
        KotlinType kotlinType = this.getType();
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getReturnType"));
        }
        return kotlinType;
    }

    @Override
    @NotNull
    public Modality getModality() {
        Modality modality = this.modality;
        if (modality == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getModality"));
        }
        return modality;
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        Visibility visibility = this.visibility;
        if (visibility == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getVisibility"));
        }
        return visibility;
    }

    @Override
    @Nullable
    public PropertyGetterDescriptorImpl getGetter() {
        return this.getter;
    }

    @Override
    @Nullable
    public PropertySetterDescriptor getSetter() {
        return this.setter;
    }

    @Override
    public boolean isSetterProjectedOut() {
        return this.setterProjectedOut;
    }

    @Override
    public boolean isLateInit() {
        return this.lateInit;
    }

    @Override
    public boolean isConst() {
        return this.isConst;
    }

    @Override
    public boolean isExternal() {
        return this.isExternal;
    }

    @Override
    public boolean isDelegated() {
        return this.isDelegated;
    }

    @Override
    @NotNull
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList<PropertyAccessorDescriptor> result2 = new ArrayList<PropertyAccessorDescriptor>(2);
        if (this.getter != null) {
            result2.add(this.getter);
        }
        if (this.setter != null) {
            result2.add(this.setter);
        }
        ArrayList<PropertyAccessorDescriptor> arrayList = result2;
        if (arrayList == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getAccessors"));
        }
        return arrayList;
    }

    @Override
    public PropertyDescriptor substitute(@NotNull TypeSubstitutor originalSubstitutor) {
        if (originalSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "originalSubstitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "substitute"));
        }
        if (originalSubstitutor.isEmpty()) {
            return this;
        }
        return this.doSubstitute(originalSubstitutor, this.getContainingDeclaration(), this.modality, this.visibility, this.getOriginal(), true, this.getKind());
    }

    @Nullable
    protected PropertyDescriptor doSubstitute(@NotNull TypeSubstitutor originalSubstitutor, @NotNull DeclarationDescriptor newOwner, @NotNull Modality newModality, @NotNull Visibility newVisibility, @Nullable PropertyDescriptor original, boolean copyOverrides, @NotNull CallableMemberDescriptor.Kind kind) {
        PropertySetterDescriptorImpl newSetter;
        PropertyGetterDescriptorImpl newGetter;
        KotlinType substitutedReceiverType;
        ReceiverParameterDescriptor substitutedDispatchReceiver;
        KotlinType originalOutType;
        if (originalSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "originalSubstitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "doSubstitute"));
        }
        if (newOwner == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newOwner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "doSubstitute"));
        }
        if (newModality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newModality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "doSubstitute"));
        }
        if (newVisibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newVisibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "doSubstitute"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "doSubstitute"));
        }
        PropertyDescriptorImpl substitutedDescriptor = this.createSubstitutedCopy(newOwner, newModality, newVisibility, original, kind);
        List<TypeParameterDescriptor> originalTypeParameters = this.getTypeParameters();
        ArrayList<TypeParameterDescriptor> substitutedTypeParameters = new ArrayList<TypeParameterDescriptor>(originalTypeParameters.size());
        TypeSubstitutor substitutor = DescriptorSubstitutor.substituteTypeParameters(originalTypeParameters, originalSubstitutor.getSubstitution(), substitutedDescriptor, substitutedTypeParameters);
        KotlinType outType = substitutor.substitute(originalOutType = this.getType(), Variance.OUT_VARIANCE);
        if (outType == null) {
            return null;
        }
        ReceiverParameterDescriptor dispatchReceiver = this.getDispatchReceiverParameter();
        if (dispatchReceiver != null) {
            substitutedDispatchReceiver = dispatchReceiver.substitute(substitutor);
            if (substitutedDispatchReceiver == null) {
                return null;
            }
        } else {
            substitutedDispatchReceiver = null;
        }
        if (this.extensionReceiverParameter != null) {
            substitutedReceiverType = substitutor.substitute(this.extensionReceiverParameter.getType(), Variance.IN_VARIANCE);
            if (substitutedReceiverType == null) {
                return null;
            }
        } else {
            substitutedReceiverType = null;
        }
        substitutedDescriptor.setType(outType, substitutedTypeParameters, substitutedDispatchReceiver, substitutedReceiverType);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.getter == null ? null : (newGetter = new PropertyGetterDescriptorImpl(substitutedDescriptor, this.getter.getAnnotations(), newModality, PropertyDescriptorImpl.normalizeVisibility(this.getter.getVisibility(), kind), this.getter.isDefault(), this.getter.isExternal(), this.getter.isInline(), kind, original == null ? null : original.getGetter(), SourceElement.NO_SOURCE));
        if (newGetter != null) {
            KotlinType returnType = this.getter.getReturnType();
            newGetter.setInitialSignatureDescriptor(PropertyDescriptorImpl.getSubstitutedInitialSignatureDescriptor(substitutor, this.getter));
            newGetter.initialize(returnType != null ? substitutor.substitute(returnType, Variance.OUT_VARIANCE) : null);
        }
        PropertySetterDescriptorImpl propertySetterDescriptorImpl = this.setter == null ? null : (newSetter = new PropertySetterDescriptorImpl(substitutedDescriptor, this.setter.getAnnotations(), newModality, PropertyDescriptorImpl.normalizeVisibility(this.setter.getVisibility(), kind), this.setter.isDefault(), this.setter.isExternal(), this.setter.isInline(), kind, original == null ? null : original.getSetter(), SourceElement.NO_SOURCE));
        if (newSetter != null) {
            List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(newSetter, this.setter.getValueParameters(), substitutor, false, false);
            if (substitutedValueParameters == null) {
                substitutedDescriptor.setSetterProjectedOut(true);
                substitutedValueParameters = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(newSetter, DescriptorUtilsKt.getBuiltIns(newOwner).getNothingType()));
            }
            if (substitutedValueParameters.size() != 1) {
                throw new IllegalStateException();
            }
            newSetter.setInitialSignatureDescriptor(PropertyDescriptorImpl.getSubstitutedInitialSignatureDescriptor(substitutor, this.setter));
            newSetter.initialize(substitutedValueParameters.get(0));
        }
        substitutedDescriptor.initialize(newGetter, newSetter);
        if (copyOverrides) {
            SmartSet overridden = SmartSet.create();
            for (PropertyDescriptor propertyDescriptor : this.getOverriddenDescriptors()) {
                overridden.add(propertyDescriptor.substitute(substitutor));
            }
            substitutedDescriptor.setOverriddenDescriptors(overridden);
        }
        return substitutedDescriptor;
    }

    private static Visibility normalizeVisibility(Visibility prev, CallableMemberDescriptor.Kind kind) {
        if (kind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && Visibilities.isPrivate(prev.normalize())) {
            return Visibilities.INVISIBLE_FAKE;
        }
        return prev;
    }

    private static FunctionDescriptor getSubstitutedInitialSignatureDescriptor(@NotNull TypeSubstitutor substitutor, @NotNull PropertyAccessorDescriptor accessorDescriptor) {
        if (substitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getSubstitutedInitialSignatureDescriptor"));
        }
        if (accessorDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "accessorDescriptor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getSubstitutedInitialSignatureDescriptor"));
        }
        return accessorDescriptor.getInitialSignatureDescriptor() != null ? accessorDescriptor.getInitialSignatureDescriptor().substitute(substitutor) : null;
    }

    @NotNull
    protected PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @NotNull Modality newModality, @NotNull Visibility newVisibility, @Nullable PropertyDescriptor original, @NotNull CallableMemberDescriptor.Kind kind) {
        if (newOwner == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newOwner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "createSubstitutedCopy"));
        }
        if (newModality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newModality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "createSubstitutedCopy"));
        }
        if (newVisibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newVisibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "createSubstitutedCopy"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "createSubstitutedCopy"));
        }
        PropertyDescriptorImpl propertyDescriptorImpl = new PropertyDescriptorImpl(newOwner, original, this.getAnnotations(), newModality, newVisibility, this.isVar(), this.getName(), kind, SourceElement.NO_SOURCE, this.isLateInit(), this.isConst(), this.isHeader(), this.isImpl(), this.isExternal(), this.isDelegated());
        if (propertyDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "createSubstitutedCopy"));
        }
        return propertyDescriptorImpl;
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        return visitor2.visitPropertyDescriptor(this, data2);
    }

    @Override
    @NotNull
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.original == this ? this : this.original.getOriginal();
        if (propertyDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getOriginal"));
        }
        return propertyDescriptor;
    }

    @Override
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.kind;
        if (kind == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getKind"));
        }
        return kind;
    }

    @Override
    public boolean isHeader() {
        return this.isHeader;
    }

    @Override
    public boolean isImpl() {
        return this.isImpl;
    }

    @Override
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        if (overriddenDescriptors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overriddenDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "setOverriddenDescriptors"));
        }
        this.overriddenProperties = overriddenDescriptors;
    }

    @Override
    @NotNull
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<Object> collection = this.overriddenProperties != null ? this.overriddenProperties : Collections.emptyList();
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "getOverriddenDescriptors"));
        }
        return collection;
    }

    @Override
    @NotNull
    public PropertyDescriptor copy(DeclarationDescriptor newOwner, Modality modality, Visibility visibility, CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        PropertyDescriptor propertyDescriptor = this.doSubstitute(TypeSubstitutor.EMPTY, newOwner, modality, visibility, null, copyOverrides, kind);
        if (propertyDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl", "copy"));
        }
        return propertyDescriptor;
    }
}

