/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import org.jetbrains.annotations.NotNull;

public interface PropertySetterDescriptor
extends PropertyAccessorDescriptor {
    @Override
    @NotNull
    public PropertySetterDescriptor getOriginal();

    @NotNull
    public Collection<? extends PropertySetterDescriptor> getOverriddenDescriptors();
}

