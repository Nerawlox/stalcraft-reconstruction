/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.jetbrains.annotations.NotNull;

public abstract class DeclarationDescriptorImpl
extends AnnotatedImpl
implements DeclarationDescriptor {
    @NotNull
    private final Name name;

    public DeclarationDescriptorImpl(@NotNull Annotations annotations2, @NotNull Name name2) {
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "<init>"));
        }
        super(annotations2);
        this.name = name2;
    }

    @Override
    @NotNull
    public Name getName() {
        Name name2 = this.name;
        if (name2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "getName"));
        }
        return name2;
    }

    @Override
    @NotNull
    public DeclarationDescriptor getOriginal() {
        DeclarationDescriptorImpl declarationDescriptorImpl = this;
        if (declarationDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "getOriginal"));
        }
        return declarationDescriptorImpl;
    }

    @Override
    public void acceptVoid(DeclarationDescriptorVisitor<Void, Void> visitor2) {
        this.accept(visitor2, null);
    }

    public String toString() {
        return DeclarationDescriptorImpl.toString(this);
    }

    @NotNull
    public static String toString(@NotNull DeclarationDescriptor descriptor2) {
        String string;
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "toString"));
        }
        try {
            string = DescriptorRenderer.DEBUG_TEXT.render(descriptor2) + "[" + descriptor2.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(descriptor2)) + "]";
        }
        catch (Throwable e) {
            String string2 = descriptor2.getClass().getSimpleName() + " " + descriptor2.getName();
            if (string2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "toString"));
            }
            return string2;
        }
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorImpl", "toString"));
        }
        return string;
    }
}

