/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TypeAliasDescriptor
extends ClassifierDescriptorWithTypeParameters {
    @NotNull
    public SimpleType getUnderlyingType();

    @NotNull
    public SimpleType getExpandedType();

    @Nullable
    public ClassDescriptor getClassDescriptor();

    @Override
    @NotNull
    public TypeAliasDescriptor getOriginal();

    @Override
    @NotNull
    public TypeAliasDescriptor substitute(@NotNull TypeSubstitutor var1);
}

