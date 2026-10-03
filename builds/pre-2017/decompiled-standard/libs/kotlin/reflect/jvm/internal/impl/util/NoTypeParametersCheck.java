/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class NoTypeParametersCheck
implements Check {
    @NotNull
    private static final String description = "should not have type parameters";
    public static final NoTypeParametersCheck INSTANCE;

    @Override
    @NotNull
    public String getDescription() {
        return description;
    }

    @Override
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        return functionDescriptor.getTypeParameters().isEmpty();
    }

    private NoTypeParametersCheck() {
        INSTANCE = this;
        description = description;
    }

    static {
        new NoTypeParametersCheck();
    }

    @Override
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }
}

