/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

public interface ScriptDescriptor
extends ClassDescriptor {
    public int getPriority();

    @Override
    @NotNull
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor();
}

