/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeAliasConstructorDescriptorImpl
extends FunctionDescriptorImpl
implements TypeAliasConstructorDescriptor {
    @NotNull
    private final TypeAliasDescriptor typeAliasDescriptor;
    @NotNull
    private final ClassConstructorDescriptor underlyingConstructorDescriptor;
    public static final Companion Companion = new Companion(null);

    @Override
    public boolean isPrimary() {
        return this.getUnderlyingConstructorDescriptor().isPrimary();
    }

    @Override
    @NotNull
    public TypeAliasDescriptor getContainingDeclaration() {
        return this.getTypeAliasDescriptor();
    }

    @Override
    @NotNull
    public ClassDescriptor getConstructedClass() {
        ClassDescriptor classDescriptor = this.getUnderlyingConstructorDescriptor().getConstructedClass();
        Intrinsics.checkExpressionValueIsNotNull(classDescriptor, "underlyingConstructorDescriptor.constructedClass");
        return classDescriptor;
    }

    @Override
    @NotNull
    public KotlinType getReturnType() {
        KotlinType kotlinType = super.getReturnType();
        if (kotlinType == null) {
            Intrinsics.throwNpe();
        }
        return kotlinType;
    }

    @Override
    @NotNull
    public TypeAliasConstructorDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = super.getOriginal();
        if (functionDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        }
        return (TypeAliasConstructorDescriptor)functionDescriptor;
    }

    @Override
    @NotNull
    public TypeAliasConstructorDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        Intrinsics.checkParameterIsNotNull(substitutor, "substitutor");
        FunctionDescriptor functionDescriptor = super.substitute(substitutor);
        if (functionDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        }
        return (TypeAliasConstructorDescriptor)functionDescriptor;
    }

    @Override
    @NotNull
    public TypeAliasConstructorDescriptor copy(@NotNull DeclarationDescriptor newOwner, @NotNull Modality modality, @NotNull Visibility visibility, @NotNull CallableMemberDescriptor.Kind kind, boolean copyOverrides) {
        Intrinsics.checkParameterIsNotNull(newOwner, "newOwner");
        Intrinsics.checkParameterIsNotNull((Object)modality, "modality");
        Intrinsics.checkParameterIsNotNull(visibility, "visibility");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        FunctionDescriptor functionDescriptor = this.newCopyBuilder().setOwner(newOwner).setModality(modality).setVisibility(visibility).setKind(kind).setCopyOverrides(copyOverrides).build();
        if (functionDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        }
        return (TypeAliasConstructorDescriptor)functionDescriptor;
    }

    @Override
    @NotNull
    protected TypeAliasConstructorDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name newName, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(newOwner, "newOwner");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(source, "source");
        boolean bl2 = bl = Intrinsics.areEqual((Object)kind, (Object)CallableMemberDescriptor.Kind.DECLARATION) || Intrinsics.areEqual((Object)kind, (Object)CallableMemberDescriptor.Kind.SYNTHESIZED);
        if (_Assertions.ENABLED && !bl) {
            String string = "Creating a type alias constructor that is not a declaration: " + "\n" + "copy from: " + this + "\n" + "newOwner: " + newOwner + "\n" + "kind: " + (Object)((Object)kind);
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        boolean bl3 = bl = newName == null;
        if (_Assertions.ENABLED && !bl) {
            String string = "Renaming type alias constructor: " + this;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        return new TypeAliasConstructorDescriptorImpl(this.getTypeAliasDescriptor(), this.getUnderlyingConstructorDescriptor(), this, annotations2, CallableMemberDescriptor.Kind.DECLARATION, source);
    }

    @Override
    @NotNull
    public TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.typeAliasDescriptor;
    }

    @Override
    @NotNull
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.underlyingConstructorDescriptor;
    }

    private TypeAliasConstructorDescriptorImpl(TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor underlyingConstructorDescriptor, TypeAliasConstructorDescriptor original, Annotations annotations2, CallableMemberDescriptor.Kind kind, SourceElement source) {
        super(typeAliasDescriptor, original, annotations2, Name.special("<init>"), kind, source);
        this.typeAliasDescriptor = typeAliasDescriptor;
        this.underlyingConstructorDescriptor = underlyingConstructorDescriptor;
    }

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull ClassConstructorDescriptor underlyingConstructorDescriptor, @Nullable TypeAliasConstructorDescriptor original, @NotNull Annotations annotations2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement source, DefaultConstructorMarker $constructor_marker) {
        this(typeAliasDescriptor, underlyingConstructorDescriptor, original, annotations2, kind, source);
    }

    public static final class Companion {
        @Nullable
        public final TypeAliasConstructorDescriptor createIfAvailable(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull ClassConstructorDescriptor constructor, @NotNull TypeSubstitutor substitutor, boolean withDispatchReceiver) {
            ReceiverParameterDescriptor receiverParameterDescriptor;
            KotlinType receiverParameterType;
            KotlinType kotlinType;
            KotlinType kotlinType2;
            Intrinsics.checkParameterIsNotNull(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics.checkParameterIsNotNull(constructor, "constructor");
            Intrinsics.checkParameterIsNotNull(substitutor, "substitutor");
            Annotations annotations2 = constructor.getAnnotations();
            CallableMemberDescriptor.Kind kind = constructor.getKind();
            Intrinsics.checkExpressionValueIsNotNull((Object)kind, "constructor.kind");
            SourceElement sourceElement = typeAliasDescriptor.getSource();
            Intrinsics.checkExpressionValueIsNotNull(sourceElement, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptorImpl typeAliasConstructor = new TypeAliasConstructorDescriptorImpl(typeAliasDescriptor, constructor, null, annotations2, kind, sourceElement, null);
            List<ValueParameterDescriptor> list = FunctionDescriptorImpl.getSubstitutedValueParameters(typeAliasConstructor, constructor.getValueParameters(), substitutor, false, false);
            if (list == null) {
                return null;
            }
            List<ValueParameterDescriptor> valueParameters = list;
            Companion companion = this;
            Object $receiver = companion;
            KotlinType kotlinType3 = substitutor.substitute(constructor.getReturnType(), Variance.INVARIANT);
            if (kotlinType3 == null) {
                return null;
            }
            KotlinType returnTypeNoAbbreviation = kotlinType3;
            SimpleType abbreviation = typeAliasDescriptor.getDefaultType();
            if (returnTypeNoAbbreviation instanceof SimpleType && abbreviation instanceof SimpleType) {
                SimpleType simpleType2 = (SimpleType)returnTypeNoAbbreviation;
                SimpleType simpleType3 = abbreviation;
                Intrinsics.checkExpressionValueIsNotNull(simpleType3, "abbreviation");
                kotlinType2 = SpecialTypesKt.withAbbreviation(simpleType2, simpleType3);
            } else {
                KotlinType kotlinType4 = returnTypeNoAbbreviation;
                kotlinType2 = kotlinType4;
                Intrinsics.checkExpressionValueIsNotNull(kotlinType4, "returnTypeNoAbbreviation");
            }
            KotlinType returnType = kotlinType2;
            if (withDispatchReceiver) {
                kotlinType = null;
            } else {
                ReceiverParameterDescriptor receiverParameterDescriptor2 = constructor.getDispatchReceiverParameter();
                if (receiverParameterDescriptor2 != null) {
                    $receiver = receiverParameterDescriptor2;
                    ReceiverParameterDescriptor it = (ReceiverParameterDescriptor)$receiver;
                    kotlinType = substitutor.safeSubstitute(it.getType(), Variance.INVARIANT);
                } else {
                    kotlinType = receiverParameterType = null;
                }
            }
            if (withDispatchReceiver) {
                ReceiverParameterDescriptor receiverParameterDescriptor3 = constructor.getDispatchReceiverParameter();
                receiverParameterDescriptor = receiverParameterDescriptor3 != null ? receiverParameterDescriptor3.substitute(substitutor) : null;
            } else {
                receiverParameterDescriptor = null;
            }
            ReceiverParameterDescriptor dispatchReceiver = receiverParameterDescriptor;
            typeAliasConstructor.initialize(receiverParameterType, dispatchReceiver, typeAliasDescriptor.getDeclaredTypeParameters(), valueParameters, returnType, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return typeAliasConstructor;
        }

        @Nullable
        public static /* bridge */ /* synthetic */ TypeAliasConstructorDescriptor createIfAvailable$default(Companion companion, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor, TypeSubstitutor typeSubstitutor2, boolean bl, int n, Object object) {
            if ((n & 8) != 0) {
                bl = false;
            }
            return companion.createIfAvailable(typeAliasDescriptor, classConstructorDescriptor, typeSubstitutor2, bl);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

