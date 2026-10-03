/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.synthetic;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;

public interface SyntheticMemberDescriptor<T extends DeclarationDescriptor> {
    @NotNull
    public T getBaseDescriptorForSynthetic();
}

