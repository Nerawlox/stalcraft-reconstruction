/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PropertyDescriptor
extends VariableDescriptorWithAccessors,
CallableMemberDescriptor {
    @Override
    @Nullable
    public PropertyGetterDescriptor getGetter();

    @Override
    @Nullable
    public PropertySetterDescriptor getSetter();

    public boolean isSetterProjectedOut();

    @NotNull
    public List<PropertyAccessorDescriptor> getAccessors();

    @Override
    @NotNull
    public PropertyDescriptor getOriginal();

    @NotNull
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors();

    @Override
    public PropertyDescriptor substitute(@NotNull TypeSubstitutor var1);

    public boolean isLateInit();
}

