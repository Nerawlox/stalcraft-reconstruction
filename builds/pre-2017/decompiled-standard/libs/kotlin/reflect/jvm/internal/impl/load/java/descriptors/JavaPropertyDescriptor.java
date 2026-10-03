/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstUtil;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaPropertyDescriptor
extends PropertyDescriptorImpl
implements JavaCallableMemberDescriptor {
    private final boolean isStaticFinal;

    private JavaPropertyDescriptor(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, @NotNull Modality modality, @NotNull Visibility visibility, boolean isVar, @NotNull Name name2, @NotNull SourceElement source, @Nullable PropertyDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, boolean isStaticFinal) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"));
        }
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "<init>"));
        }
        super(containingDeclaration, original, annotations2, modality, visibility, isVar, name2, kind, source, false, false, false, false, false, false);
        this.isStaticFinal = isStaticFinal;
    }

    @NotNull
    public static JavaPropertyDescriptor create(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, @NotNull Modality modality, @NotNull Visibility visibility, boolean isVar, @NotNull Name name2, @NotNull SourceElement source, boolean isStaticFinal) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"));
        }
        if (modality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "modality", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"));
        }
        if (visibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"));
        }
        JavaPropertyDescriptor javaPropertyDescriptor = new JavaPropertyDescriptor(containingDeclaration, annotations2, modality, visibility, isVar, name2, source, null, CallableMemberDescriptor.Kind.DECLARATION, isStaticFinal);
        if (javaPropertyDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "create"));
        }
        return javaPropertyDescriptor;
    }

    @Override
    @NotNull
    protected PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @NotNull Modality newModality, @NotNull Visibility newVisibility, @Nullable PropertyDescriptor original, @NotNull CallableMemberDescriptor.Kind kind) {
        if (newOwner == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newOwner", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "createSubstitutedCopy"));
        }
        if (newModality == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newModality", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "createSubstitutedCopy"));
        }
        if (newVisibility == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newVisibility", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "createSubstitutedCopy"));
        }
        if (kind == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kind", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "createSubstitutedCopy"));
        }
        JavaPropertyDescriptor javaPropertyDescriptor = new JavaPropertyDescriptor(newOwner, this.getAnnotations(), newModality, newVisibility, this.isVar(), this.getName(), SourceElement.NO_SOURCE, original, kind, this.isStaticFinal);
        if (javaPropertyDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "createSubstitutedCopy"));
        }
        return javaPropertyDescriptor;
    }

    @Override
    public boolean hasSynthesizedParameterNames() {
        return false;
    }

    @Override
    @NotNull
    public JavaCallableMemberDescriptor enhance(@Nullable KotlinType enhancedReceiverType, @NotNull List<KotlinType> enhancedValueParametersTypes, @NotNull KotlinType enhancedReturnType) {
        if (enhancedValueParametersTypes == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enhancedValueParametersTypes", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "enhance"));
        }
        if (enhancedReturnType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enhancedReturnType", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "enhance"));
        }
        JavaPropertyDescriptor enhanced = new JavaPropertyDescriptor(this.getContainingDeclaration(), this.getAnnotations(), this.getModality(), this.getVisibility(), this.isVar(), this.getName(), this.getSource(), this.getOriginal(), this.getKind(), this.isStaticFinal);
        PropertyGetterDescriptorImpl newGetter = null;
        PropertyGetterDescriptorImpl getter = this.getGetter();
        if (getter != null) {
            newGetter = new PropertyGetterDescriptorImpl(enhanced, getter.getAnnotations(), getter.getModality(), getter.getVisibility(), getter.isDefault(), getter.isExternal(), getter.isInline(), this.getKind(), getter, getter.getSource());
            newGetter.setInitialSignatureDescriptor(getter.getInitialSignatureDescriptor());
            newGetter.initialize(enhancedReturnType);
        }
        PropertySetterDescriptorImpl newSetter = null;
        PropertySetterDescriptor setter = this.getSetter();
        if (setter != null) {
            newSetter = new PropertySetterDescriptorImpl(enhanced, setter.getAnnotations(), setter.getModality(), setter.getVisibility(), setter.isDefault(), setter.isExternal(), setter.isInline(), this.getKind(), setter, setter.getSource());
            newSetter.setInitialSignatureDescriptor(newSetter.getInitialSignatureDescriptor());
            newSetter.initialize(setter.getValueParameters().get(0));
        }
        enhanced.initialize(newGetter, newSetter);
        enhanced.setSetterProjectedOut(this.isSetterProjectedOut());
        if (this.compileTimeInitializer != null) {
            enhanced.setCompileTimeInitializer(this.compileTimeInitializer);
        }
        enhanced.setOverriddenDescriptors(this.getOverriddenDescriptors());
        enhanced.setType(enhancedReturnType, this.getTypeParameters(), this.getDispatchReceiverParameter(), enhancedReceiverType);
        JavaPropertyDescriptor javaPropertyDescriptor = enhanced;
        if (javaPropertyDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor", "enhance"));
        }
        return javaPropertyDescriptor;
    }

    @Override
    public boolean isConst() {
        KotlinType type2 = this.getType();
        return this.isStaticFinal && ConstUtil.canBeUsedForConstVal(type2) && (!TypeEnhancementKt.hasEnhancedNullability(type2) || KotlinBuiltIns.isString(type2));
    }
}

