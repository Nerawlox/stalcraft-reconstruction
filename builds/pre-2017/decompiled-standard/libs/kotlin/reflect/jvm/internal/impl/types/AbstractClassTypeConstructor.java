/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractClassTypeConstructor
extends AbstractTypeConstructor
implements TypeConstructor {
    private int hashCode;

    public AbstractClassTypeConstructor(@NotNull StorageManager storageManager) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor", "<init>"));
        }
        super(storageManager);
        this.hashCode = 0;
    }

    public final int hashCode() {
        int currentHashCode = this.hashCode;
        if (currentHashCode != 0) {
            return currentHashCode;
        }
        ClassifierDescriptor descriptor2 = this.getDeclarationDescriptor();
        currentHashCode = descriptor2 instanceof ClassDescriptor && AbstractClassTypeConstructor.hasMeaningfulFqName(descriptor2) ? DescriptorUtils.getFqName(descriptor2).hashCode() : System.identityHashCode(this);
        this.hashCode = currentHashCode;
        return currentHashCode;
    }

    @Override
    @NotNull
    public abstract ClassifierDescriptor getDeclarationDescriptor();

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns kotlinBuiltIns = DescriptorUtilsKt.getBuiltIns(this.getDeclarationDescriptor());
        if (kotlinBuiltIns == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor", "getBuiltIns"));
        }
        return kotlinBuiltIns;
    }

    public boolean equals(Object other) {
        ClassifierDescriptor otherDescriptor;
        if (!(other instanceof TypeConstructor)) {
            return false;
        }
        if (other.hashCode() != this.hashCode()) {
            return false;
        }
        if (((TypeConstructor)other).getParameters().size() != this.getParameters().size()) {
            return false;
        }
        ClassifierDescriptor myDescriptor = this.getDeclarationDescriptor();
        if (myDescriptor == (otherDescriptor = ((TypeConstructor)other).getDeclarationDescriptor())) {
            return true;
        }
        if (!AbstractClassTypeConstructor.hasMeaningfulFqName(myDescriptor) || otherDescriptor != null && !AbstractClassTypeConstructor.hasMeaningfulFqName(otherDescriptor)) {
            return this == other;
        }
        if (myDescriptor instanceof ClassDescriptor && otherDescriptor instanceof ClassDescriptor) {
            FqNameUnsafe otherFqName = DescriptorUtils.getFqName(otherDescriptor);
            FqNameUnsafe myFqName = DescriptorUtils.getFqName(myDescriptor);
            return myFqName.equals(otherFqName);
        }
        return false;
    }

    private static boolean hasMeaningfulFqName(@NotNull ClassifierDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor", "hasMeaningfulFqName"));
        }
        return !ErrorUtils.isError(descriptor2) && !DescriptorUtils.isLocal(descriptor2);
    }

    @Override
    @NotNull
    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph() {
        DeclarationDescriptor containingDeclaration = this.getDeclarationDescriptor().getContainingDeclaration();
        if (containingDeclaration instanceof ClassDescriptor) {
            Set<KotlinType> set = Collections.singleton(((ClassDescriptor)containingDeclaration).getDefaultType());
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor", "getAdditionalNeighboursInSupertypeGraph"));
            }
            return set;
        }
        List<KotlinType> list = Collections.emptyList();
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor", "getAdditionalNeighboursInSupertypeGraph"));
        }
        return list;
    }
}

