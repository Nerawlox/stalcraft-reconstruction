/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ReadOnly;

public interface ClassDescriptor
extends ClassifierDescriptorWithTypeParameters,
ClassOrPackageFragmentDescriptor {
    @NotNull
    public MemberScope getMemberScope(@NotNull List<? extends TypeProjection> var1);

    @NotNull
    public MemberScope getMemberScope(@NotNull TypeSubstitution var1);

    @NotNull
    public MemberScope getUnsubstitutedMemberScope();

    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope();

    @NotNull
    public MemberScope getStaticScope();

    @NotNull
    @ReadOnly
    public Collection<ClassConstructorDescriptor> getConstructors();

    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration();

    @Override
    @NotNull
    public SimpleType getDefaultType();

    @Override
    @NotNull
    public ClassDescriptor substitute(@NotNull TypeSubstitutor var1);

    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor();

    @NotNull
    public ClassKind getKind();

    @Override
    @NotNull
    public Modality getModality();

    @Override
    @NotNull
    public Visibility getVisibility();

    public boolean isCompanionObject();

    public boolean isData();

    @NotNull
    public ReceiverParameterDescriptor getThisAsReceiverParameter();

    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor();

    @Override
    @ReadOnly
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters();

    @ReadOnly
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses();

    @Override
    @NotNull
    public ClassDescriptor getOriginal();
}

