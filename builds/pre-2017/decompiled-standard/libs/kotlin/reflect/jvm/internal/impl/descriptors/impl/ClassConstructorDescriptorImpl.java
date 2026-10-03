/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClassConstructorDescriptorImpl
extends FunctionDescriptorImpl
implements ClassConstructorDescriptor {
    protected final boolean isPrimary;
    private static final Name NAME = Name.special("<init>");

    protected ClassConstructorDescriptorImpl(@NotNull ClassDescriptor containingDeclaration, @Nullable ConstructorDescriptor original, @NotNull Annotations annotations2, boolean isPrimary, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "<init>"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "<init>"));
        }
        super(containingDeclaration, original, annotations2, NAME, kind, source);
        this.isPrimary = isPrimary;
    }

    @NotNull
    public static ClassConstructorDescriptorImpl create(@NotNull ClassDescriptor containingDeclaration, @NotNull Annotations annotations2, boolean isPrimary, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "create"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "create"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "create"));
        }
        ClassConstructorDescriptorImpl classConstructorDescriptorImpl = new ClassConstructorDescriptorImpl(containingDeclaration, null, annotations2, isPrimary, CallableMemberDescriptor.Kind.DECLARATION, source);
        if (classConstructorDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "create"));
        }
        return classConstructorDescriptorImpl;
    }

    @NotNull
    public static ClassConstructorDescriptorImpl createSynthesized(@NotNull ClassDescriptor containingDeclaration, @NotNull Annotations annotations2, boolean isPrimary, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSynthesized"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSynthesized"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSynthesized"));
        }
        ClassConstructorDescriptorImpl classConstructorDescriptorImpl = new ClassConstructorDescriptorImpl(containingDeclaration, null, annotations2, isPrimary, CallableMemberDescriptor.Kind.SYNTHESIZED, source);
        if (classConstructorDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSynthesized"));
        }
        return classConstructorDescriptorImpl;
    }

    public ClassConstructorDescriptorImpl initialize(@NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @NotNull Visibility visibility, @NotNull List<TypeParameterDescriptor> typeParameterDescriptors) {
        if (unsubstitutedValueParameters == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "initialize"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "initialize"));
        }
        if (typeParameterDescriptors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameterDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "initialize"));
        }
        super.initialize(null, this.calculateDispatchReceiverParameter(), typeParameterDescriptors, unsubstitutedValueParameters, null, Modality.FINAL, visibility);
        return this;
    }

    public ClassConstructorDescriptorImpl initialize(@NotNull List<ValueParameterDescriptor> unsubstitutedValueParameters, @NotNull Visibility visibility) {
        if (unsubstitutedValueParameters == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unsubstitutedValueParameters", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "initialize"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "initialize"));
        }
        this.initialize(unsubstitutedValueParameters, visibility, this.getContainingDeclaration().getDeclaredTypeParameters());
        return this;
    }

    @Nullable
    private ReceiverParameterDescriptor calculateDispatchReceiverParameter() {
        DeclarationDescriptor classContainer;
        ClassDescriptor classDescriptor = this.getContainingDeclaration();
        if (classDescriptor.isInner() && (classContainer = classDescriptor.getContainingDeclaration()) instanceof ClassDescriptor) {
            return ((ClassDescriptor)classContainer).getThisAsReceiverParameter();
        }
        return null;
    }

    @Override
    @NotNull
    public ClassDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = (ClassDescriptor)super.getContainingDeclaration();
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "getContainingDeclaration"));
        }
        return classDescriptor;
    }

    @Override
    @NotNull
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor classDescriptor = this.getContainingDeclaration();
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "getConstructedClass"));
        }
        return classDescriptor;
    }

    @Override
    @NotNull
    public ClassConstructorDescriptor getOriginal() {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor)super.getOriginal();
        if (classConstructorDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "getOriginal"));
        }
        return classConstructorDescriptor;
    }

    @Override
    @Nullable
    public ClassConstructorDescriptor substitute(@NotNull TypeSubstitutor originalSubstitutor) {
        if (originalSubstitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "originalSubstitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "substitute"));
        }
        return (ClassConstructorDescriptor)super.substitute(originalSubstitutor);
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        return visitor2.visitConstructorDescriptor(this, data2);
    }

    @Override
    public boolean isPrimary() {
        return this.isPrimary;
    }

    @Override
    @NotNull
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Set set = Collections.emptySet();
        if (set == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "getOverriddenDescriptors"));
        }
        return set;
    }

    @Override
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> overriddenDescriptors) {
        if (overriddenDescriptors == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "overriddenDescriptors", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "setOverriddenDescriptors"));
        }
        assert (overriddenDescriptors.isEmpty()) : "Constructors cannot override anything";
    }

    @Override
    @NotNull
    protected ClassConstructorDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name newName, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        if (newOwner == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newOwner", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSubstitutedCopy"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSubstitutedCopy"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSubstitutedCopy"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSubstitutedCopy"));
        }
        if (kind != CallableMemberDescriptor.Kind.DECLARATION && kind != CallableMemberDescriptor.Kind.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\n" + "newOwner: " + newOwner + "\n" + "kind: " + (Object)((Object)kind));
        }
        assert (newName == null) : "Attempt to rename constructor: " + this;
        ClassConstructorDescriptorImpl classConstructorDescriptorImpl = new ClassConstructorDescriptorImpl((ClassDescriptor)newOwner, this, annotations2, this.isPrimary, CallableMemberDescriptor.Kind.DECLARATION, source);
        if (classConstructorDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "createSubstitutedCopy"));
        }
        return classConstructorDescriptorImpl;
    }

    @Override
    @NotNull
    public ClassConstructorDescriptor copy(DeclarationDescriptor newOwner, Modality modality, Visibility visibility, CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor)super.copy(newOwner, modality, visibility, kind, copyOverrides);
        if (classConstructorDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassConstructorDescriptorImpl", "copy"));
        }
        return classConstructorDescriptor;
    }
}

