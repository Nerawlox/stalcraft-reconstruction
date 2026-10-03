/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ReceiverParameterDescriptor
extends ParameterDescriptor {
    @NotNull
    public ReceiverValue getValue();

    @Override
    @Nullable
    public ReceiverParameterDescriptor substitute(@NotNull TypeSubstitutor var1);
}

