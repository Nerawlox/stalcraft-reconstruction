/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor;
import org.jetbrains.annotations.NotNull;

public interface ParameterDescriptor
extends ValueDescriptor {
    @Override
    @NotNull
    public ParameterDescriptor getOriginal();
}

