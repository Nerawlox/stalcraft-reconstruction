/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract class OverridingStrategy {
    public abstract void addFakeOverride(@NotNull CallableMemberDescriptor var1);

    public abstract void overrideConflict(@NotNull CallableMemberDescriptor var1, @NotNull CallableMemberDescriptor var2);

    public abstract void inheritanceConflict(@NotNull CallableMemberDescriptor var1, @NotNull CallableMemberDescriptor var2);

    public void setOverriddenDescriptors(@NotNull CallableMemberDescriptor member, @NotNull Collection<? extends CallableMemberDescriptor> overridden) {
        Intrinsics.checkParameterIsNotNull(member, "member");
        Intrinsics.checkParameterIsNotNull(overridden, "overridden");
        member.setOverriddenDescriptors(overridden);
    }
}

