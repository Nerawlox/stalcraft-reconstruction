/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Check {
    @NotNull
    public String getDescription();

    public boolean check(@NotNull FunctionDescriptor var1);

    @Nullable
    public String invoke(@NotNull FunctionDescriptor var1);

    public static final class DefaultImpls {
        @Nullable
        public static String invoke(@NotNull Check $this, FunctionDescriptor functionDescriptor) {
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            return !$this.check(functionDescriptor) ? $this.getDescription() : null;
        }
    }
}

