/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeHolder;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TypeHolderArgument<D extends TypeHolder<? extends D>> {
    @NotNull
    public TypeProjection getProjection();

    @Nullable
    public TypeParameterDescriptor getTypeParameter();

    @NotNull
    public D getHolder();
}

