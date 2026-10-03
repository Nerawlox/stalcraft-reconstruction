/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ValueParameterCountCheck
implements Check {
    @NotNull
    private final String description;

    @Override
    @NotNull
    public String getDescription() {
        return this.description;
    }

    private ValueParameterCountCheck(String description) {
        this.description = description;
    }

    @Override
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    public /* synthetic */ ValueParameterCountCheck(@NotNull String description, DefaultConstructorMarker $constructor_marker) {
        this(description);
    }

    public static final class NoValueParameters
    extends ValueParameterCountCheck {
        public static final NoValueParameters INSTANCE;

        @Override
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().isEmpty();
        }

        private NoValueParameters() {
            super("must have no value parameters", null);
            INSTANCE = this;
        }

        static {
            new NoValueParameters();
        }
    }

    public static final class SingleValueParameter
    extends ValueParameterCountCheck {
        public static final SingleValueParameter INSTANCE;

        @Override
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == 1;
        }

        private SingleValueParameter() {
            super("must have a single value parameter", null);
            INSTANCE = this;
        }

        static {
            new SingleValueParameter();
        }
    }

    public static final class AtLeast
    extends ValueParameterCountCheck {
        private final int n;

        @Override
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() >= this.n;
        }

        public final int getN() {
            return this.n;
        }

        public AtLeast(int n) {
            super("must have at least " + n + " value parameter" + (n > 1 ? "s" : ""), null);
            this.n = n;
        }
    }

    public static final class Equals
    extends ValueParameterCountCheck {
        private final int n;

        @Override
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getValueParameters().size() == this.n;
        }

        public final int getN() {
            return this.n;
        }

        public Equals(int n) {
            super("must have exactly " + n + " value parameters", null);
            this.n = n;
        }
    }
}

