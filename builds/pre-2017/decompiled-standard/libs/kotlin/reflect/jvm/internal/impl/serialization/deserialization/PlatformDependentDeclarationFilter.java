/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import org.jetbrains.annotations.NotNull;

public interface PlatformDependentDeclarationFilter {
    public boolean isFunctionAvailable(@NotNull DeserializedClassDescriptor var1, @NotNull SimpleFunctionDescriptor var2);

    public static final class All
    implements PlatformDependentDeclarationFilter {
        public static final All INSTANCE;

        @Override
        public boolean isFunctionAvailable(@NotNull DeserializedClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor functionDescriptor) {
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            return true;
        }

        private All() {
            INSTANCE = this;
        }

        static {
            new All();
        }
    }

    public static final class NoPlatformDependent
    implements PlatformDependentDeclarationFilter {
        public static final NoPlatformDependent INSTANCE;

        @Override
        public boolean isFunctionAvailable(@NotNull DeserializedClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor functionDescriptor) {
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            return !functionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME());
        }

        private NoPlatformDependent() {
            INSTANCE = this;
        }

        static {
            new NoPlatformDependent();
        }
    }
}

