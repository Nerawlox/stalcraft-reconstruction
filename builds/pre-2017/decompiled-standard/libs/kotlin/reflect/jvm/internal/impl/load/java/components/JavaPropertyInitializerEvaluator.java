/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaPropertyInitializerEvaluator {
    @Nullable
    public ConstantValue<?> getInitializerConstant(@NotNull JavaField var1, @NotNull PropertyDescriptor var2);

    public boolean isNotNullCompileTimeConstant(@NotNull JavaField var1);

    public static final class DoNothing
    implements JavaPropertyInitializerEvaluator {
        public static final DoNothing INSTANCE;

        @Nullable
        public Void getInitializerConstant(@NotNull JavaField field, @NotNull PropertyDescriptor descriptor2) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            return null;
        }

        @Override
        public boolean isNotNullCompileTimeConstant(@NotNull JavaField field) {
            Intrinsics.checkParameterIsNotNull(field, "field");
            return false;
        }

        private DoNothing() {
            INSTANCE = this;
        }

        static {
            new DoNothing();
        }
    }
}

