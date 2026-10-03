/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class NoDefaultAndVarargsCheck
implements Check {
    @NotNull
    private static final String description = "should not have varargs or parameters with default values";
    public static final NoDefaultAndVarargsCheck INSTANCE;

    @Override
    @NotNull
    public String getDescription() {
        return description;
    }

    @Override
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        boolean bl;
        block1: {
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            Iterable $receiver$iv = functionDescriptor.getValueParameters();
            for (Object element$iv : $receiver$iv) {
                ValueParameterDescriptor it = (ValueParameterDescriptor)element$iv;
                if (!DescriptorUtilsKt.hasDefaultValue(it) && it.getVarargElementType() == null) continue;
                bl = false;
                break block1;
            }
            bl = true;
        }
        return bl;
    }

    private NoDefaultAndVarargsCheck() {
        INSTANCE = this;
        description = description;
    }

    static {
        new NoDefaultAndVarargsCheck();
    }

    @Override
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }
}

