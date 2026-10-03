/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ClassConstructorDescriptor
extends ConstructorDescriptor {
    @Override
    @NotNull
    public ClassDescriptor getContainingDeclaration();

    @Override
    @NotNull
    public ClassConstructorDescriptor getOriginal();

    @Override
    @Nullable
    public ClassConstructorDescriptor substitute(@NotNull TypeSubstitutor var1);

    @Override
    @NotNull
    public ClassConstructorDescriptor copy(@NotNull DeclarationDescriptor var1, @NotNull Modality var2, @NotNull Visibility var3, @NotNull CallableMemberDescriptor.Kind var4, boolean var5);
}

