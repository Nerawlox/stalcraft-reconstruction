/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public interface ValueDescriptor
extends CallableDescriptor {
    @NotNull
    public KotlinType getType();

    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration();
}

