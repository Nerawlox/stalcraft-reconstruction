/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;
import kotlin.reflect.jvm.internal.impl.util.Checks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractModifierChecks {
    @NotNull
    public abstract List<Checks> getChecks$kotlin_core();

    @Nullable
    public final String ensure(boolean cond, @NotNull Function0<String> msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        return !cond ? msg.invoke() : null;
    }

    @NotNull
    public final CheckResult check(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        for (Checks check : this.getChecks$kotlin_core()) {
            if (!check.isApplicable(functionDescriptor)) continue;
            return check.checkAll(functionDescriptor);
        }
        return CheckResult.IllegalFunctionName.INSTANCE;
    }
}

