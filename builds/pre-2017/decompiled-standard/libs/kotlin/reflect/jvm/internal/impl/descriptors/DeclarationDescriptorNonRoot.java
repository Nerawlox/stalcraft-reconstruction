/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import org.jetbrains.annotations.NotNull;

public interface DeclarationDescriptorNonRoot
extends DeclarationDescriptorWithSource {
    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration();
}

