/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaClassConstructorDescriptor
extends ClassConstructorDescriptorImpl
implements JavaCallableMemberDescriptor {
    private Boolean hasStableParameterNames;
    private Boolean hasSynthesizedParameterNames;

    protected JavaClassConstructorDescriptor(@NotNull ClassDescriptor containingDeclaration, @Nullable JavaClassConstructorDescriptor original, @NotNull Annotations annotations2, boolean isPrimary, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "<init>"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "<init>"));
        }
        super(containingDeclaration, original, annotations2, isPrimary, kind, source);
        this.hasStableParameterNames = null;
        this.hasSynthesizedParameterNames = null;
    }

    @NotNull
    public static JavaClassConstructorDescriptor createJavaConstructor(@NotNull ClassDescriptor containingDeclaration, @NotNull Annotations annotations2, boolean isPrimary, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createJavaConstructor"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createJavaConstructor"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createJavaConstructor"));
        }
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = new JavaClassConstructorDescriptor(containingDeclaration, null, annotations2, isPrimary, CallableMemberDescriptor.Kind.DECLARATION, source);
        if (javaClassConstructorDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createJavaConstructor"));
        }
        return javaClassConstructorDescriptor;
    }

    @Override
    public boolean hasStableParameterNames() {
        assert (this.hasStableParameterNames != null) : "hasStableParameterNames was not set: " + this;
        return this.hasStableParameterNames;
    }

    @Override
    public void setHasStableParameterNames(boolean hasStableParameterNames) {
        this.hasStableParameterNames = hasStableParameterNames;
    }

    @Override
    public boolean hasSynthesizedParameterNames() {
        assert (this.hasSynthesizedParameterNames != null) : "hasSynthesizedParameterNames was not set: " + this;
        return this.hasSynthesizedParameterNames;
    }

    @Override
    public void setHasSynthesizedParameterNames(boolean hasSynthesizedParameterNames) {
        this.hasSynthesizedParameterNames = hasSynthesizedParameterNames;
    }

    @Override
    @NotNull
    protected JavaClassConstructorDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name newName, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        if (newOwner == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newOwner", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createSubstitutedCopy"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createSubstitutedCopy"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createSubstitutedCopy"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createSubstitutedCopy"));
        }
        if (kind != CallableMemberDescriptor.Kind.DECLARATION && kind != CallableMemberDescriptor.Kind.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\n" + "newOwner: " + newOwner + "\n" + "kind: " + (Object)((Object)kind));
        }
        assert (newName == null) : "Attempt to rename constructor: " + this;
        JavaClassConstructorDescriptor result2 = this.createDescriptor((ClassDescriptor)newOwner, (JavaClassConstructorDescriptor)original, kind, source, annotations2);
        result2.setHasStableParameterNames(this.hasStableParameterNames());
        result2.setHasSynthesizedParameterNames(this.hasSynthesizedParameterNames());
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = result2;
        if (javaClassConstructorDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createSubstitutedCopy"));
        }
        return javaClassConstructorDescriptor;
    }

    @NotNull
    protected JavaClassConstructorDescriptor createDescriptor(@NotNull ClassDescriptor newOwner, @Nullable JavaClassConstructorDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, @NotNull Annotations annotations2) {
        if (newOwner == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newOwner", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createDescriptor"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createDescriptor"));
        }
        if (sourceElement == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "sourceElement", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createDescriptor"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createDescriptor"));
        }
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = new JavaClassConstructorDescriptor(newOwner, original, annotations2, this.isPrimary, kind, sourceElement);
        if (javaClassConstructorDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "createDescriptor"));
        }
        return javaClassConstructorDescriptor;
    }

    @Override
    @NotNull
    public JavaClassConstructorDescriptor enhance(@Nullable KotlinType enhancedReceiverType, @NotNull List<KotlinType> enhancedValueParametersTypes, @NotNull KotlinType enhancedReturnType) {
        if (enhancedValueParametersTypes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enhancedValueParametersTypes", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "enhance"));
        }
        if (enhancedReturnType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enhancedReturnType", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "enhance"));
        }
        JavaClassConstructorDescriptor enhanced = this.createSubstitutedCopy(this.getContainingDeclaration(), null, this.getKind(), null, this.getAnnotations(), this.getSource());
        enhanced.initialize(enhancedReceiverType, this.getDispatchReceiverParameter(), this.getTypeParameters(), UtilKt.copyValueParameters(enhancedValueParametersTypes, this.getValueParameters(), enhanced), enhancedReturnType, this.getModality(), this.getVisibility());
        JavaClassConstructorDescriptor javaClassConstructorDescriptor = enhanced;
        if (javaClassConstructorDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor", "enhance"));
        }
        return javaClassConstructorDescriptor;
    }
}

