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

public abstract class MemberKindCheck
implements Check {
    @NotNull
    private final String description;

    @Override
    @NotNull
    public String getDescription() {
        return this.description;
    }

    private MemberKindCheck(String description) {
        this.description = description;
    }

    @Override
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    public /* synthetic */ MemberKindCheck(@NotNull String description, DefaultConstructorMarker $constructor_marker) {
        this(description);
    }

    public static final class MemberOrExtension
    extends MemberKindCheck {
        public static final MemberOrExtension INSTANCE;

        @Override
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getDispatchReceiverParameter() != null || functionDescriptor.getExtensionReceiverParameter() != null;
        }

        private MemberOrExtension() {
            super("must be a member or an extension function", null);
            INSTANCE = this;
        }

        static {
            new MemberOrExtension();
        }
    }

    public static final class Member
    extends MemberKindCheck {
        public static final Member INSTANCE;

        @Override
        public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            return functionDescriptor.getDispatchReceiverParameter() != null;
        }

        private Member() {
            super("must be a member function", null);
            INSTANCE = this;
        }

        static {
            new Member();
        }
    }
}

