/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MutableClassDescriptor
extends ClassDescriptorBase {
    private final ClassKind kind;
    private final boolean isInner;
    private Modality modality;
    private Visibility visibility;
    private TypeConstructor typeConstructor;
    private List<TypeParameterDescriptor> typeParameters;
    private final Collection<KotlinType> supertypes;

    public MutableClassDescriptor(@NotNull DeclarationDescriptor containingDeclaration, @NotNull ClassKind kind, boolean isInner2, boolean isExternal, @NotNull Name name2, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "<init>"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "<init>"));
        }
        super(LockBasedStorageManager.NO_LOCKS, containingDeclaration, name2, source, isExternal);
        this.supertypes = new ArrayList<KotlinType>();
        assert (kind != ClassKind.OBJECT) : "Fix isCompanionObject()";
        this.kind = kind;
        this.isInner = isInner2;
    }

    @Override
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations2 = Annotations.Companion.getEMPTY();
        if (annotations2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getAnnotations"));
        }
        return annotations2;
    }

    public void setModality(@NotNull Modality modality) {
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "setModality"));
        }
        assert (modality != Modality.SEALED) : "Implement getSealedSubclasses() for this class: " + this.getClass();
        this.modality = modality;
    }

    @Override
    @NotNull
    public Modality getModality() {
        Modality modality = this.modality;
        if (modality == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getModality"));
        }
        return modality;
    }

    @Override
    @NotNull
    public ClassKind getKind() {
        ClassKind classKind = this.kind;
        if (classKind == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getKind"));
        }
        return classKind;
    }

    public void setVisibility(@NotNull Visibility visibility) {
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "setVisibility"));
        }
        this.visibility = visibility;
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        Visibility visibility = this.visibility;
        if (visibility == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getVisibility"));
        }
        return visibility;
    }

    @Override
    public boolean isInner() {
        return this.isInner;
    }

    @Override
    public boolean isData() {
        return false;
    }

    @Override
    public boolean isCompanionObject() {
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
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = this.typeConstructor;
        if (typeConstructor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getTypeConstructor"));
        }
        return typeConstructor2;
    }

    public void addSupertype(@NotNull KotlinType supertype) {
        if (supertype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertype", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "addSupertype"));
        }
        assert (!supertype.isError()) : "Error types must be filtered out in DescriptorResolver";
        if (TypeUtils.getClassDescriptor(supertype) != null) {
            this.supertypes.add(supertype);
        }
    }

    @NotNull
    public Set<ClassConstructorDescriptor> getConstructors() {
        Set<ClassConstructorDescriptor> set = Collections.emptySet();
        if (set == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getConstructors"));
        }
        return set;
    }

    @Override
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    public void setTypeParameterDescriptors(@NotNull List<TypeParameterDescriptor> typeParameters2) {
        if (typeParameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "setTypeParameterDescriptors"));
        }
        if (this.typeParameters != null) {
            throw new IllegalStateException("Type parameters are already set for " + this.getName());
        }
        this.typeParameters = new ArrayList<TypeParameterDescriptor>(typeParameters2);
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeParameters;
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getDeclaredTypeParameters"));
        }
        return list;
    }

    public void createTypeConstructor() {
        assert (this.typeConstructor == null) : this.typeConstructor;
        this.typeConstructor = new ClassTypeConstructorImpl(this, ModalityKt.isFinalClass(this), this.typeParameters, this.supertypes);
        for (ClassConstructorDescriptor functionDescriptor : this.getConstructors()) {
            ((ClassConstructorDescriptorImpl)functionDescriptor).setReturnType(this.getDefaultType());
        }
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope.Empty empty = MemberScope.Empty.INSTANCE;
        if (empty == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getUnsubstitutedMemberScope"));
        }
        return empty;
    }

    @Override
    @NotNull
    public MemberScope getStaticScope() {
        MemberScope.Empty empty = MemberScope.Empty.INSTANCE;
        if (empty == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getStaticScope"));
        }
        return empty;
    }

    @Override
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List<ClassDescriptor> list = Collections.emptyList();
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor", "getSealedSubclasses"));
        }
        return list;
    }

    public String toString() {
        return DeclarationDescriptorImpl.toString(this);
    }
}

