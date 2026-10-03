/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class IsKPropertyCheck
implements Check {
    @NotNull
    private static final String description = "second parameter must have a KProperty type or its supertype";
    public static final IsKPropertyCheck INSTANCE;

    @Override
    @NotNull
    public String getDescription() {
        return description;
    }

    @Override
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        ValueParameterDescriptor secondParameter = functionDescriptor.getValueParameters().get(1);
        KotlinType kotlinType = ReflectionTypes.Companion.createKPropertyStarType(DescriptorUtilsKt.getModule(secondParameter));
        if (kotlinType != null) {
            KotlinType kotlinType2 = TypeUtilsKt.makeNotNullable(secondParameter.getType());
            Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "secondParameter.type.makeNotNullable()");
            bl = TypeUtilsKt.isSubtypeOf(kotlinType, kotlinType2);
        } else {
            bl = false;
        }
        return bl;
    }

    private IsKPropertyCheck() {
        INSTANCE = this;
        description = description;
    }

    static {
        new IsKPropertyCheck();
    }

    @Override
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }
}

