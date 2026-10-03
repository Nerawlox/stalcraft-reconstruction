/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ExternalOverridabilityCondition {
    @NotNull
    public Result isOverridable(@NotNull CallableDescriptor var1, @NotNull CallableDescriptor var2, @Nullable ClassDescriptor var3);

    @NotNull
    public Contract getContract();

    public static enum Contract {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH;

    }

    public static enum Result {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN;

    }
}

