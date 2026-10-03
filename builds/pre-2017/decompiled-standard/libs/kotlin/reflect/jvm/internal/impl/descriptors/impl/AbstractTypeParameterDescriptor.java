/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractTypeParameterDescriptor
extends DeclarationDescriptorNonRootImpl
implements TypeParameterDescriptor {
    private final Variance variance;
    private final boolean reified;
    private final int index;
    private final NotNullLazyValue<TypeConstructor> typeConstructor;
    private final NotNullLazyValue<SimpleType> defaultType;

    protected AbstractTypeParameterDescriptor(final @NotNull StorageManager storageManager, @NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, final @NotNull Name name2, @NotNull Variance variance, boolean isReified, int index, @NotNull SourceElement source, final @NotNull SupertypeLoopChecker supertypeLoopChecker) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"));
        }
        if (containingDeclaration == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingDeclaration", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"));
        }
        if (variance == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "variance", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"));
        }
        if (supertypeLoopChecker == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertypeLoopChecker", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "<init>"));
        }
        super(containingDeclaration, annotations2, name2, source);
        this.variance = variance;
        this.reified = isReified;
        this.index = index;
        this.typeConstructor = storageManager.createLazyValue(new Function0<TypeConstructor>(){

            @Override
            public TypeConstructor invoke() {
                return new TypeParameterTypeConstructor(storageManager, supertypeLoopChecker);
            }
        });
        this.defaultType = storageManager.createLazyValue(new Function0<SimpleType>(){

            @Override
            public SimpleType invoke() {
                return KotlinTypeFactory.simpleType(Annotations.Companion.getEMPTY(), AbstractTypeParameterDescriptor.this.getTypeConstructor(), Collections.emptyList(), false, new LazyScopeAdapter(storageManager.createLazyValue(new Function0<MemberScope>(){

                    @Override
                    public MemberScope invoke() {
                        return TypeIntersectionScope.create("Scope for type parameter " + name2.asString(), AbstractTypeParameterDescriptor.this.getUpperBounds());
                    }
                })));
            }
        });
    }

    protected abstract void reportSupertypeLoopError(@NotNull KotlinType var1);

    @NotNull
    protected abstract List<KotlinType> resolveUpperBounds();

    @Override
    @NotNull
    public Variance getVariance() {
        Variance variance = this.variance;
        if (variance == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "getVariance"));
        }
        return variance;
    }

    @Override
    public boolean isReified() {
        return this.reified;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean isCapturedFromOuterDeclaration() {
        return false;
    }

    @Override
    @NotNull
    public List<KotlinType> getUpperBounds() {
        Collection collection = ((TypeParameterTypeConstructor)this.getTypeConstructor()).getSupertypes();
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "getUpperBounds"));
        }
        return collection;
    }

    @Override
    @NotNull
    public final TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = (TypeConstructor)this.typeConstructor.invoke();
        if (typeConstructor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "getTypeConstructor"));
        }
        return typeConstructor2;
    }

    @Override
    @NotNull
    public SimpleType getDefaultType() {
        SimpleType simpleType2 = (SimpleType)this.defaultType.invoke();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "getDefaultType"));
        }
        return simpleType2;
    }

    @Override
    @NotNull
    public TypeParameterDescriptor getOriginal() {
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)super.getOriginal();
        if (typeParameterDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "getOriginal"));
        }
        return typeParameterDescriptor;
    }

    @Override
    @Deprecated
    @NotNull
    public TypeParameterDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        if (substitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor", "substitute"));
        }
        throw new UnsupportedOperationException("Don't call substitute() on type parameters");
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        return visitor2.visitTypeParameterDescriptor(this, data2);
    }

    private class TypeParameterTypeConstructor
    extends AbstractTypeConstructor {
        private final SupertypeLoopChecker supertypeLoopChecker;

        public TypeParameterTypeConstructor(StorageManager storageManager, SupertypeLoopChecker supertypeLoopChecker) {
            if (storageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "<init>"));
            }
            super(storageManager);
            this.supertypeLoopChecker = supertypeLoopChecker;
        }

        @Override
        @NotNull
        protected Collection<KotlinType> computeSupertypes() {
            List<KotlinType> list = AbstractTypeParameterDescriptor.this.resolveUpperBounds();
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "computeSupertypes"));
            }
            return list;
        }

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> list = Collections.emptyList();
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "getParameters"));
            }
            return list;
        }

        @Override
        public boolean isFinal() {
            return false;
        }

        @Override
        public boolean isDenotable() {
            return true;
        }

        @Override
        @NotNull
        public ClassifierDescriptor getDeclarationDescriptor() {
            AbstractTypeParameterDescriptor abstractTypeParameterDescriptor = AbstractTypeParameterDescriptor.this;
            if (abstractTypeParameterDescriptor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "getDeclarationDescriptor"));
            }
            return abstractTypeParameterDescriptor;
        }

        @Override
        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns kotlinBuiltIns = DescriptorUtilsKt.getBuiltIns(AbstractTypeParameterDescriptor.this);
            if (kotlinBuiltIns == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "getBuiltIns"));
            }
            return kotlinBuiltIns;
        }

        public String toString() {
            return AbstractTypeParameterDescriptor.this.getName().toString();
        }

        @Override
        @NotNull
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            SupertypeLoopChecker supertypeLoopChecker = this.supertypeLoopChecker;
            if (supertypeLoopChecker == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "getSupertypeLoopChecker"));
            }
            return supertypeLoopChecker;
        }

        @Override
        protected void reportSupertypeLoopError(@NotNull KotlinType type2) {
            if (type2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor", "reportSupertypeLoopError"));
            }
            AbstractTypeParameterDescriptor.this.reportSupertypeLoopError(type2);
        }

        @Override
        @Nullable
        protected KotlinType defaultSupertypeIfEmpty() {
            return ErrorUtils.createErrorType("Cyclic upper bounds");
        }
    }
}

