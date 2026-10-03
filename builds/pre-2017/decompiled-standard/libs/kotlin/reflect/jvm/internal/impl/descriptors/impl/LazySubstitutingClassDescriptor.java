/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LazySubstitutingClassDescriptor
implements ClassDescriptor {
    private final ClassDescriptor original;
    private final TypeSubstitutor originalSubstitutor;
    private TypeSubstitutor newSubstitutor;
    private List<TypeParameterDescriptor> typeConstructorParameters;
    private List<TypeParameterDescriptor> declaredTypeParameters;
    private TypeConstructor typeConstructor;

    public LazySubstitutingClassDescriptor(ClassDescriptor descriptor2, TypeSubstitutor substitutor) {
        this.original = descriptor2;
        this.originalSubstitutor = substitutor;
    }

    private TypeSubstitutor getSubstitutor() {
        if (this.newSubstitutor == null) {
            if (this.originalSubstitutor.isEmpty()) {
                this.newSubstitutor = this.originalSubstitutor;
            } else {
                List<TypeParameterDescriptor> originalTypeParameters = this.original.getTypeConstructor().getParameters();
                this.typeConstructorParameters = new ArrayList<TypeParameterDescriptor>(originalTypeParameters.size());
                this.newSubstitutor = DescriptorSubstitutor.substituteTypeParameters(originalTypeParameters, this.originalSubstitutor.getSubstitution(), this, this.typeConstructorParameters);
                this.declaredTypeParameters = CollectionsKt.filter(this.typeConstructorParameters, new Function1<TypeParameterDescriptor, Boolean>(){

                    @Override
                    public Boolean invoke(TypeParameterDescriptor descriptor2) {
                        return !descriptor2.isCapturedFromOuterDeclaration();
                    }
                });
            }
        }
        return this.newSubstitutor;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        TypeConstructor originalTypeConstructor = this.original.getTypeConstructor();
        if (this.originalSubstitutor.isEmpty()) {
            TypeConstructor typeConstructor2 = originalTypeConstructor;
            if (typeConstructor2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getTypeConstructor"));
            }
            return typeConstructor2;
        }
        if (this.typeConstructor == null) {
            TypeSubstitutor substitutor = this.getSubstitutor();
            Collection<KotlinType> originalSupertypes = originalTypeConstructor.getSupertypes();
            ArrayList<KotlinType> supertypes2 = new ArrayList<KotlinType>(originalSupertypes.size());
            for (KotlinType supertype : originalSupertypes) {
                supertypes2.add(substitutor.substitute(supertype, Variance.INVARIANT));
            }
            this.typeConstructor = new ClassTypeConstructorImpl(this, originalTypeConstructor.isFinal(), this.typeConstructorParameters, supertypes2);
        }
        TypeConstructor typeConstructor3 = this.typeConstructor;
        if (typeConstructor3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getTypeConstructor"));
        }
        return typeConstructor3;
    }

    @Override
    @NotNull
    public MemberScope getMemberScope(@NotNull List<? extends TypeProjection> typeArguments) {
        if (typeArguments == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeArguments", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getMemberScope"));
        }
        MemberScope memberScope2 = this.original.getMemberScope(typeArguments);
        if (this.originalSubstitutor.isEmpty()) {
            MemberScope memberScope3 = memberScope2;
            if (memberScope3 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getMemberScope"));
            }
            return memberScope3;
        }
        SubstitutingScope substitutingScope = new SubstitutingScope(memberScope2, this.getSubstitutor());
        if (substitutingScope == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getMemberScope"));
        }
        return substitutingScope;
    }

    @Override
    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeSubstitution", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getMemberScope"));
        }
        MemberScope memberScope2 = this.original.getMemberScope(typeSubstitution);
        if (this.originalSubstitutor.isEmpty()) {
            MemberScope memberScope3 = memberScope2;
            if (memberScope3 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getMemberScope"));
            }
            return memberScope3;
        }
        SubstitutingScope substitutingScope = new SubstitutingScope(memberScope2, this.getSubstitutor());
        if (substitutingScope == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getMemberScope"));
        }
        return substitutingScope;
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope memberScope2 = this.original.getUnsubstitutedMemberScope();
        if (this.originalSubstitutor.isEmpty()) {
            MemberScope memberScope3 = memberScope2;
            if (memberScope3 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getUnsubstitutedMemberScope"));
            }
            return memberScope3;
        }
        SubstitutingScope substitutingScope = new SubstitutingScope(memberScope2, this.getSubstitutor());
        if (substitutingScope == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getUnsubstitutedMemberScope"));
        }
        return substitutingScope;
    }

    @Override
    @NotNull
    public MemberScope getStaticScope() {
        MemberScope memberScope2 = this.original.getStaticScope();
        if (memberScope2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getStaticScope"));
        }
        return memberScope2;
    }

    @Override
    @NotNull
    public SimpleType getDefaultType() {
        List<TypeProjection> typeProjections = TypeUtils.getDefaultTypeProjections(this.getTypeConstructor().getParameters());
        SimpleType simpleType2 = KotlinTypeFactory.simpleNotNullType(this.getAnnotations(), this, typeProjections);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getDefaultType"));
        }
        return simpleType2;
    }

    @Override
    @NotNull
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    @Override
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> originalConstructors = this.original.getConstructors();
        ArrayList<ClassConstructorDescriptor> result2 = new ArrayList<ClassConstructorDescriptor>(originalConstructors.size());
        for (ClassConstructorDescriptor constructor : originalConstructors) {
            ClassConstructorDescriptor copy = constructor.copy(this, constructor.getModality(), constructor.getVisibility(), constructor.getKind(), false);
            result2.add(copy.substitute(this.getSubstitutor()));
        }
        ArrayList<ClassConstructorDescriptor> arrayList = result2;
        if (arrayList == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getConstructors"));
        }
        return arrayList;
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations2 = this.original.getAnnotations();
        if (annotations2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getAnnotations"));
        }
        return annotations2;
    }

    @Override
    @NotNull
    public Name getName() {
        Name name2 = this.original.getName();
        if (name2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getName"));
        }
        return name2;
    }

    @Override
    @NotNull
    public ClassDescriptor getOriginal() {
        ClassDescriptor classDescriptor = this.original.getOriginal();
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getOriginal"));
        }
        return classDescriptor;
    }

    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor declarationDescriptor = this.original.getContainingDeclaration();
        if (declarationDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getContainingDeclaration"));
        }
        return declarationDescriptor;
    }

    @Override
    @NotNull
    public ClassDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        if (substitutor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutor", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "substitute"));
        }
        if (substitutor.isEmpty()) {
            LazySubstitutingClassDescriptor lazySubstitutingClassDescriptor = this;
            if (lazySubstitutingClassDescriptor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "substitute"));
            }
            return lazySubstitutingClassDescriptor;
        }
        LazySubstitutingClassDescriptor lazySubstitutingClassDescriptor = new LazySubstitutingClassDescriptor(this, TypeSubstitutor.createChainedSubstitutor(substitutor.getSubstitution(), this.getSubstitutor().getSubstitution()));
        if (lazySubstitutingClassDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "substitute"));
        }
        return lazySubstitutingClassDescriptor;
    }

    @Override
    public ClassDescriptor getCompanionObjectDescriptor() {
        return this.original.getCompanionObjectDescriptor();
    }

    @Override
    @NotNull
    public ClassKind getKind() {
        ClassKind classKind = this.original.getKind();
        if (classKind == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getKind"));
        }
        return classKind;
    }

    @Override
    @NotNull
    public Modality getModality() {
        Modality modality = this.original.getModality();
        if (modality == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getModality"));
        }
        return modality;
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        Visibility visibility = this.original.getVisibility();
        if (visibility == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getVisibility"));
        }
        return visibility;
    }

    @Override
    public boolean isInner() {
        return this.original.isInner();
    }

    @Override
    public boolean isData() {
        return this.original.isData();
    }

    @Override
    public boolean isExternal() {
        return this.original.isExternal();
    }

    @Override
    public boolean isCompanionObject() {
        return this.original.isCompanionObject();
    }

    @Override
    public boolean isHeader() {
        return this.original.isHeader();
    }

    @Override
    public boolean isImpl() {
        return this.original.isImpl();
    }

    @Override
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        return visitor2.visitClassDescriptor(this, data2);
    }

    @Override
    public void acceptVoid(DeclarationDescriptorVisitor<Void, Void> visitor2) {
        throw new UnsupportedOperationException();
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope memberScope2 = this.original.getUnsubstitutedInnerClassesScope();
        if (memberScope2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getUnsubstitutedInnerClassesScope"));
        }
        return memberScope2;
    }

    @Override
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.original.getUnsubstitutedPrimaryConstructor();
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        if (sourceElement == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getSource"));
        }
        return sourceElement;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        this.getSubstitutor();
        List<TypeParameterDescriptor> list = this.declaredTypeParameters;
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getDeclaredTypeParameters"));
        }
        return list;
    }

    @Override
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        Collection<ClassDescriptor> collection = this.original.getSealedSubclasses();
        if (collection == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor", "getSealedSubclasses"));
        }
        return collection;
    }
}

