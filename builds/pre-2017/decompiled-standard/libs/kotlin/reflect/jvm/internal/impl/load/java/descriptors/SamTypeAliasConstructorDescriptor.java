/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamConstructorDescriptor;
import org.jetbrains.annotations.NotNull;

public interface SamTypeAliasConstructorDescriptor
extends SamConstructorDescriptor {
    @NotNull
    public TypeAliasDescriptor getTypeAliasDescriptor();
}

