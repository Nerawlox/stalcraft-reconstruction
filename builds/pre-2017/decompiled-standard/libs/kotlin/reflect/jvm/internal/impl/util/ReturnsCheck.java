/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReturnsCheck
implements Check {
    @NotNull
    private final String description;
    @NotNull
    private final String name;
    @NotNull
    private final Function1<KotlinBuiltIns, KotlinType> type;

    @Override
    @NotNull
    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final Function1<KotlinBuiltIns, KotlinType> getType() {
        return this.type;
    }

    private ReturnsCheck(String name2, Function1<? super KotlinBuiltIns, ? extends KotlinType> type2) {
        this.name = name2;
        this.type = type2;
        this.description = "must return " + this.name;
    }

    @Override
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    public /* synthetic */ ReturnsCheck(@NotNull String name2, @NotNull Function1 type2, DefaultConstructorMarker $constructor_marker) {
        this(name2, type2);
    }

    public static final class ReturnsBoolean
    extends ReturnsCheck {
        public static final ReturnsBoolean INSTANCE;

        private ReturnsBoolean() {
            super("Boolean", 1.INSTANCE, null);
            INSTANCE = this;
        }

        static {
            new ReturnsBoolean();
        }
    }

    public static final class ReturnsInt
    extends ReturnsCheck {
        public static final ReturnsInt INSTANCE;

        private ReturnsInt() {
            super("Int", 1.INSTANCE, null);
            INSTANCE = this;
        }

        static {
            new ReturnsInt();
        }
    }

    public static final class ReturnsUnit
    extends ReturnsCheck {
        public static final ReturnsUnit INSTANCE;

        private ReturnsUnit() {
            super("Unit", 1.INSTANCE, null);
            INSTANCE = this;
        }

        static {
            new ReturnsUnit();
        }
    }
}

