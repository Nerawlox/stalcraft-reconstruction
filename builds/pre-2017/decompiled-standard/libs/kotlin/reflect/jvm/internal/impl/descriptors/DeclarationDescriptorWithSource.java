/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import org.jetbrains.annotations.NotNull;

public interface DeclarationDescriptorWithSource
extends DeclarationDescriptor {
    @NotNull
    public SourceElement getSource();

    @Override
    @NotNull
    public DeclarationDescriptorWithSource getOriginal();
}

