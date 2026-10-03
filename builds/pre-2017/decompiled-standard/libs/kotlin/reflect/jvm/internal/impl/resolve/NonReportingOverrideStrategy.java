/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy;
import org.jetbrains.annotations.NotNull;

public abstract class NonReportingOverrideStrategy
extends OverridingStrategy {
    @Override
    public void overrideConflict(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
        Intrinsics.checkParameterIsNotNull(fromSuper, "fromSuper");
        Intrinsics.checkParameterIsNotNull(fromCurrent, "fromCurrent");
        this.conflict(fromSuper, fromCurrent);
    }

    @Override
    public void inheritanceConflict(@NotNull CallableMemberDescriptor first, @NotNull CallableMemberDescriptor second) {
        Intrinsics.checkParameterIsNotNull(first, "first");
        Intrinsics.checkParameterIsNotNull(second, "second");
        this.conflict(first, second);
    }

    protected abstract void conflict(@NotNull CallableMemberDescriptor var1, @NotNull CallableMemberDescriptor var2);
}

