/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

public interface ErrorReporter {
    public static final ErrorReporter DO_NOTHING = new ErrorReporter(){

        @Override
        public void reportIncompleteHierarchy(@NotNull ClassDescriptor descriptor2, @NotNull List<String> unresolvedSuperClasses) {
            if (descriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1", "reportIncompleteHierarchy"));
            }
            if (unresolvedSuperClasses == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unresolvedSuperClasses", "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1", "reportIncompleteHierarchy"));
            }
        }

        @Override
        public void reportCannotInferVisibility(@NotNull CallableMemberDescriptor descriptor2) {
            if (descriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1", "reportCannotInferVisibility"));
            }
        }
    };

    public void reportIncompleteHierarchy(@NotNull ClassDescriptor var1, @NotNull List<String> var2);

    public void reportCannotInferVisibility(@NotNull CallableMemberDescriptor var1);
}

