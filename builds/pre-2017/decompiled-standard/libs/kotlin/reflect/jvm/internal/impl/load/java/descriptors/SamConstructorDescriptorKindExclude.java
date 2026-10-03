/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import org.jetbrains.annotations.NotNull;

public final class SamConstructorDescriptorKindExclude
extends DescriptorKindExclude {
    public static final SamConstructorDescriptorKindExclude INSTANCE;

    @Override
    public boolean excludes(@NotNull DeclarationDescriptor descriptor2) {
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        return descriptor2 instanceof SamConstructorDescriptor;
    }

    @Override
    public int getFullyExcludedDescriptorKinds() {
        return 0;
    }

    private SamConstructorDescriptorKindExclude() {
        INSTANCE = this;
    }

    static {
        new SamConstructorDescriptorKindExclude();
    }
}

