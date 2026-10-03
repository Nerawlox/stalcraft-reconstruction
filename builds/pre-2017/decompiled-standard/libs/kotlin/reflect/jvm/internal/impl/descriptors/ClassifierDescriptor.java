/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

public interface ClassifierDescriptor
extends DeclarationDescriptorNonRoot {
    @NotNull
    public TypeConstructor getTypeConstructor();

    @NotNull
    public SimpleType getDefaultType();

    @Override
    @NotNull
    public ClassifierDescriptor getOriginal();
}

