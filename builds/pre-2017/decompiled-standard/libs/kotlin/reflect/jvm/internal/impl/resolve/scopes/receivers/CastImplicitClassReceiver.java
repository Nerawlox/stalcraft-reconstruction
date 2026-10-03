/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class CastImplicitClassReceiver
extends ImplicitClassReceiver {
    @NotNull
    private final KotlinType targetType;

    @NotNull
    public final KotlinType getTargetType() {
        return this.targetType;
    }

    public CastImplicitClassReceiver(@NotNull ClassDescriptor originalDescriptor, @NotNull KotlinType targetType) {
        Intrinsics.checkParameterIsNotNull(originalDescriptor, "originalDescriptor");
        Intrinsics.checkParameterIsNotNull(targetType, "targetType");
        super(originalDescriptor);
        this.targetType = targetType;
    }
}

