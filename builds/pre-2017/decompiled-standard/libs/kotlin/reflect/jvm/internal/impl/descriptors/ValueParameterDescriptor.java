/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValueParameterDescriptor
extends VariableDescriptor,
ParameterDescriptor {
    @Override
    @NotNull
    public CallableDescriptor getContainingDeclaration();

    public int getIndex();

    public boolean declaresDefaultValue();

    @Nullable
    public KotlinType getVarargElementType();

    @Override
    @NotNull
    public ValueParameterDescriptor getOriginal();

    @Override
    @NotNull
    public ValueParameterDescriptor substitute(@NotNull TypeSubstitutor var1);

    @NotNull
    public ValueParameterDescriptor copy(@NotNull CallableDescriptor var1, @NotNull Name var2, int var3);

    @NotNull
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors();

    public boolean isCrossinline();

    public boolean isNoinline();
}

