/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

public class ClassTypeConstructorImpl
extends AbstractClassTypeConstructor
implements TypeConstructor {
    private final ClassDescriptor classDescriptor;
    private final List<TypeParameterDescriptor> parameters;
    private final Collection<KotlinType> supertypes;
    private final boolean isFinal;

    public ClassTypeConstructorImpl(@NotNull ClassDescriptor classDescriptor, boolean isFinal, @NotNull List<? extends TypeParameterDescriptor> parameters2, @NotNull Collection<KotlinType> supertypes2) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "<init>"));
        }
        if (parameters2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "parameters", "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "<init>"));
        }
        if (supertypes2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertypes", "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "<init>"));
        }
        super(LockBasedStorageManager.NO_LOCKS);
        this.classDescriptor = classDescriptor;
        this.isFinal = isFinal;
        this.parameters = Collections.unmodifiableList(new ArrayList<TypeParameterDescriptor>(parameters2));
        this.supertypes = Collections.unmodifiableCollection(supertypes2);
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> list = this.parameters;
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "getParameters"));
        }
        return list;
    }

    public String toString() {
        return DescriptorUtils.getFqName(this.classDescriptor).asString();
    }

    @Override
    public boolean isFinal() {
        return this.isFinal;
    }

    @Override
    public boolean isDenotable() {
        return true;
    }

    @Override
    @NotNull
    public ClassDescriptor getDeclarationDescriptor() {
        ClassDescriptor classDescriptor = this.classDescriptor;
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "getDeclarationDescriptor"));
        }
        return classDescriptor;
    }

    @Override
    @NotNull
    protected Collection<KotlinType> computeSupertypes() {
        Collection<KotlinType> collection = this.supertypes;
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "computeSupertypes"));
        }
        return collection;
    }

    @Override
    @NotNull
    protected SupertypeLoopChecker getSupertypeLoopChecker() {
        SupertypeLoopChecker.EMPTY eMPTY = SupertypeLoopChecker.EMPTY.INSTANCE;
        if (eMPTY == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl", "getSupertypeLoopChecker"));
        }
        return eMPTY;
    }
}

