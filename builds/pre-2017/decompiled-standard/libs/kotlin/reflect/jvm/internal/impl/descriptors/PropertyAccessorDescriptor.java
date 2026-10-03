/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;

public interface PropertyAccessorDescriptor
extends VariableAccessorDescriptor {
    public boolean isDefault();

    @Override
    @NotNull
    public PropertyAccessorDescriptor getOriginal();

    @NotNull
    public Collection<? extends PropertyAccessorDescriptor> getOverriddenDescriptors();

    @NotNull
    public PropertyDescriptor getCorrespondingProperty();

    @Override
    @NotNull
    public PropertyAccessorDescriptor copy(DeclarationDescriptor var1, Modality var2, Visibility var3, CallableMemberDescriptor.Kind var4, boolean var5);
}

