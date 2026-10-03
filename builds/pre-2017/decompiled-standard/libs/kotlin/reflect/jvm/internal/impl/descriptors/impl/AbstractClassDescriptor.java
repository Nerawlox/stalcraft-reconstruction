/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyClassReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazySubstitutingClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractClassDescriptor
implements ClassDescriptor {
    private final Name name;
    protected final NotNullLazyValue<SimpleType> defaultType;
    private final NotNullLazyValue<MemberScope> unsubstitutedInnerClassesScope;
    private final NotNullLazyValue<ReceiverParameterDescriptor> thisAsReceiverParameter;

    public AbstractClassDescriptor(@NotNull StorageManager storageManager, @NotNull Name name2) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "<init>"));
        }
        this.name = name2;
        this.defaultType = storageManager.createLazyValue(new Function0<SimpleType>(){

            @Override
            public SimpleType invoke() {
                return TypeUtils.makeUnsubstitutedType(AbstractClassDescriptor.this, AbstractClassDescriptor.this.getUnsubstitutedMemberScope());
            }
        });
        this.unsubstitutedInnerClassesScope = storageManager.createLazyValue(new Function0<MemberScope>(){

            @Override
            public MemberScope invoke() {
                return new InnerClassesScopeWrapper(AbstractClassDescriptor.this.getUnsubstitutedMemberScope());
            }
        });
        this.thisAsReceiverParameter = storageManager.createLazyValue(new Function0<ReceiverParameterDescriptor>(){

            @Override
            public ReceiverParameterDescriptor invoke() {
                return new LazyClassReceiverParameterDescriptor(AbstractClassDescriptor.this);
            }
        });
    }

    @Override
    @NotNull
    public Name getName() {
        Name name2 = this.name;
        if (name2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getName"));
        }
        return name2;
    }

    @Override
    @NotNull
    public ClassDescriptor getOriginal() {
        AbstractClassDescriptor abstractClassDescriptor = this;
        if (abstractClassDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getOriginal"));
        }
        return abstractClassDescriptor;
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope memberScope2 = (MemberScope)this.unsubstitutedInnerClassesScope.invoke();
        if (memberScope2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getUnsubstitutedInnerClassesScope"));
        }
        return memberScope2;
    }

    @Override
    @NotNull
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        ReceiverParameterDescriptor receiverParameterDescriptor = (ReceiverParameterDescriptor)this.thisAsReceiverParameter.invoke();
        if (receiverParameterDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getThisAsReceiverParameter"));
        }
        return receiverParameterDescriptor;
    }

    @Override
    @NotNull
    public MemberScope getMemberScope(@NotNull List<? extends TypeProjection> typeArguments) {
        if (typeArguments == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeArguments", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getMemberScope"));
        }
        assert (typeArguments.size() == this.getTypeConstructor().getParameters().size()) : "Illegal number of type arguments: expected " + this.getTypeConstructor().getParameters().size() + " but was " + typeArguments.size() + " for " + this.getTypeConstructor() + " " + this.getTypeConstructor().getParameters();
        if (typeArguments.isEmpty()) {
            MemberScope memberScope2 = this.getUnsubstitutedMemberScope();
            if (memberScope2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getMemberScope"));
            }
            return memberScope2;
        }
        TypeSubstitutor substitutor = TypeConstructorSubstitution.create(this.getTypeConstructor(), typeArguments).buildSubstitutor();
        SubstitutingScope substitutingScope = new SubstitutingScope(this.getUnsubstitutedMemberScope(), substitutor);
        if (substitutingScope == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getMemberScope"));
        }
        return substitutingScope;
    }

    @Override
    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeSubstitution", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getMemberScope"));
        }
        if (typeSubstitution.isEmpty()) {
            MemberScope memberScope2 = this.getUnsubstitutedMemberScope();
            if (memberScope2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getMemberScope"));
            }
            return memberScope2;
        }
        TypeSubstitutor substitutor = TypeSubstitutor.create(typeSubstitution);
        SubstitutingScope substitutingScope = new SubstitutingScope(this.getUnsubstitutedMemberScope(), substitutor);
        if (substitutingScope == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getMemberScope"));
        }
        return substitutingScope;
    }

    @Override
    @NotNull
    public ClassDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        if (substitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "substitute"));
        }
        if (substitutor.isEmpty()) {
            AbstractClassDescriptor abstractClassDescriptor = this;
            if (abstractClassDescriptor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "substitute"));
            }
            return abstractClassDescriptor;
        }
        LazySubstitutingClassDescriptor lazySubstitutingClassDescriptor = new LazySubstitutingClassDescriptor(this, substitutor);
        if (lazySubstitutingClassDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "substitute"));
        }
        return lazySubstitutingClassDescriptor;
    }

    @Override
    @NotNull
    public SimpleType getDefaultType() {
        SimpleType simpleType2 = (SimpleType)this.defaultType.invoke();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor", "getDefaultType"));
        }
        return simpleType2;
    }

    @Override
    public void acceptVoid(DeclarationDescriptorVisitor<Void, Void> visitor2) {
        visitor2.visitClassDescriptor(this, null);
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        return visitor2.visitClassDescriptor(this, data2);
    }
}

