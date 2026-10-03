/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ReadOnly;

public interface CallableDescriptor
extends DeclarationDescriptorWithVisibility,
DeclarationDescriptorNonRoot {
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter();

    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter();

    @NotNull
    @ReadOnly
    public List<TypeParameterDescriptor> getTypeParameters();

    @Nullable
    public KotlinType getReturnType();

    @Override
    @NotNull
    public CallableDescriptor getOriginal();

    @Override
    public CallableDescriptor substitute(@NotNull TypeSubstitutor var1);

    @NotNull
    public List<ValueParameterDescriptor> getValueParameters();

    public boolean hasStableParameterNames();

    public boolean hasSynthesizedParameterNames();

    @NotNull
    public Collection<? extends CallableDescriptor> getOverriddenDescriptors();
}

