/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;

public interface TypeAliasConstructorDescriptor
extends ConstructorDescriptor {
    @NotNull
    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor();

    @NotNull
    public TypeAliasDescriptor getTypeAliasDescriptor();

    @Override
    @NotNull
    public TypeAliasDescriptor getContainingDeclaration();

    @Override
    @NotNull
    public KotlinType getReturnType();

    @Override
    @NotNull
    public TypeAliasConstructorDescriptor getOriginal();

    @Override
    @NotNull
    public TypeAliasConstructorDescriptor substitute(@NotNull TypeSubstitutor var1);

    @Override
    @NotNull
    public TypeAliasConstructorDescriptor copy(@NotNull DeclarationDescriptor var1, @NotNull Modality var2, @NotNull Visibility var3, @NotNull CallableMemberDescriptor.Kind var4, boolean var5);
}

