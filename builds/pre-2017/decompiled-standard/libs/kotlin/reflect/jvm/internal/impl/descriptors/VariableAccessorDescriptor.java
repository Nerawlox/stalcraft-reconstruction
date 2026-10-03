/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors;
import org.jetbrains.annotations.NotNull;

public interface VariableAccessorDescriptor
extends FunctionDescriptor {
    @NotNull
    public VariableDescriptorWithAccessors getCorrespondingVariable();
}

