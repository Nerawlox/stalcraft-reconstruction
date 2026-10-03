/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeParameterDescriptorImpl
extends AbstractTypeParameterDescriptor {
    @Nullable
    private final Function1<KotlinType, Void> reportCycleError;
    private final List<KotlinType> upperBounds;
    private boolean initialized;

    @NotNull
    public static TypeParameterDescriptor createWithDefaultBound(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, boolean reified, @NotNull Variance variance, @NotNull Name name2, int index) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createWithDefaultBound"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createWithDefaultBound"));
        }
        if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createWithDefaultBound"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createWithDefaultBound"));
        }
        TypeParameterDescriptorImpl typeParameterDescriptor = TypeParameterDescriptorImpl.createForFurtherModification(containingDeclaration, annotations2, reified, variance, name2, index, SourceElement.NO_SOURCE);
        typeParameterDescriptor.addUpperBound(DescriptorUtilsKt.getBuiltIns(containingDeclaration).getDefaultBound());
        typeParameterDescriptor.setInitialized();
        TypeParameterDescriptorImpl typeParameterDescriptorImpl = typeParameterDescriptor;
        if (typeParameterDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createWithDefaultBound"));
        }
        return typeParameterDescriptorImpl;
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, boolean reified, @NotNull Variance variance, @NotNull Name name2, int index, @NotNull SourceElement source) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        return TypeParameterDescriptorImpl.createForFurtherModification(containingDeclaration, annotations2, reified, variance, name2, index, source, null, SupertypeLoopChecker.EMPTY.INSTANCE);
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, boolean reified, @NotNull Variance variance, @NotNull Name name2, int index, @NotNull SourceElement source, @Nullable Function1<KotlinType, Void> reportCycleError, @NotNull SupertypeLoopChecker supertypeLoopsResolver) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        if (supertypeLoopsResolver == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertypeLoopsResolver", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "createForFurtherModification"));
        }
        return new TypeParameterDescriptorImpl(containingDeclaration, annotations2, reified, variance, name2, index, source, reportCycleError, supertypeLoopsResolver);
    }

    private TypeParameterDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, boolean reified, @NotNull Variance variance, @NotNull Name name2, int index, @NotNull SourceElement source, @Nullable Function1<KotlinType, Void> reportCycleError, @NotNull SupertypeLoopChecker supertypeLoopsChecker) {
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"));
        }
        if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"));
        }
        if (supertypeLoopsChecker == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertypeLoopsChecker", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "<init>"));
        }
        super(LockBasedStorageManager.NO_LOCKS, containingDeclaration, annotations2, name2, variance, reified, index, source, supertypeLoopsChecker);
        this.upperBounds = new ArrayList<KotlinType>(1);
        this.initialized = false;
        this.reportCycleError = reportCycleError;
    }

    private void checkInitialized() {
        if (!this.initialized) {
            throw new IllegalStateException("Type parameter descriptor is not initialized: " + this.nameForAssertions());
        }
    }

    private void checkUninitialized() {
        if (this.initialized) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + this.nameForAssertions());
        }
    }

    private String nameForAssertions() {
        return this.getName() + " declared in " + DescriptorUtils.getFqName(this.getContainingDeclaration());
    }

    public void setInitialized() {
        this.checkUninitialized();
        this.initialized = true;
    }

    public void addUpperBound(@NotNull KotlinType bound) {
        if (bound == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "bound", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "addUpperBound"));
        }
        this.checkUninitialized();
        this.doAddUpperBound(bound);
    }

    private void doAddUpperBound(KotlinType bound) {
        if (bound.isError()) {
            return;
        }
        this.upperBounds.add(bound);
    }

    public void addDefaultUpperBound() {
        this.checkUninitialized();
        if (this.upperBounds.isEmpty()) {
            this.doAddUpperBound(DescriptorUtilsKt.getBuiltIns(this.getContainingDeclaration()).getDefaultBound());
        }
    }

    @Override
    protected void reportSupertypeLoopError(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "reportSupertypeLoopError"));
        }
        if (this.reportCycleError == null) {
            return;
        }
        this.reportCycleError.invoke(type2);
    }

    @Override
    @NotNull
    protected List<KotlinType> resolveUpperBounds() {
        this.checkInitialized();
        List<KotlinType> list = this.upperBounds;
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl", "resolveUpperBounds"));
        }
        return list;
    }
}

