/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.Deprecated;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import org.jetbrains.annotations.Nullable;

public interface VariableDescriptorWithAccessors
extends VariableDescriptor {
    @Nullable
    public VariableAccessorDescriptor getGetter();

    @Nullable
    public VariableAccessorDescriptor getSetter();

    public boolean isDelegated();

    public static final class DefaultImpls {
        @Deprecated(message="Do not call this method in the compiler front-end.")
        private static /* synthetic */ void isDelegated$annotations() {
        }
    }
}

