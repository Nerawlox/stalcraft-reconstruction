/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WrappedValues {
    private static final Object NULL_VALUE = new Object(){

        public String toString() {
            return "NULL_VALUE";
        }
    };
    public static volatile boolean throwWrappedProcessCanceledException = false;

    private WrappedValues() {
    }

    @Nullable
    public static <V> V unescapeNull(@NotNull Object value) {
        if (value == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "value", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues", "unescapeNull"));
        }
        if (value == NULL_VALUE) {
            return null;
        }
        return (V)value;
    }

    @NotNull
    public static <V> Object escapeNull(@Nullable V value) {
        if (value == null) {
            Object object = NULL_VALUE;
            if (object == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues", "escapeNull"));
            }
            return object;
        }
        V v = value;
        if (v == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues", "escapeNull"));
        }
        return v;
    }

    @NotNull
    public static Object escapeThrowable(@NotNull Throwable throwable) {
        if (throwable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues", "escapeThrowable"));
        }
        ThrowableWrapper throwableWrapper = new ThrowableWrapper(throwable);
        if (throwableWrapper == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues", "escapeThrowable"));
        }
        return throwableWrapper;
    }

    @Nullable
    public static <V> V unescapeExceptionOrNull(@NotNull Object value) {
        if (value == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "value", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues", "unescapeExceptionOrNull"));
        }
        return WrappedValues.unescapeNull(WrappedValues.unescapeThrowable(value));
    }

    @Nullable
    public static <V> V unescapeThrowable(@Nullable Object value) {
        if (value instanceof ThrowableWrapper) {
            Throwable originThrowable = ((ThrowableWrapper)value).getThrowable();
            if (throwWrappedProcessCanceledException && originThrowable.getClass().getName().equals("com.intellij.openapi.progress.ProcessCanceledException")) {
                throw new WrappedProcessCanceledException(originThrowable);
            }
            throw ExceptionUtilsKt.rethrow(originThrowable);
        }
        return (V)value;
    }

    public static class WrappedProcessCanceledException
    extends RuntimeException {
        public WrappedProcessCanceledException(Throwable cause) {
            super("Rethrow stored exception", cause);
        }
    }

    private static final class ThrowableWrapper {
        private final Throwable throwable;

        private ThrowableWrapper(@NotNull Throwable throwable) {
            if (throwable == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper", "<init>"));
            }
            this.throwable = throwable;
        }

        @NotNull
        public Throwable getThrowable() {
            Throwable throwable = this.throwable;
            if (throwable == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper", "getThrowable"));
            }
            return throwable;
        }

        public String toString() {
            return this.throwable.toString();
        }
    }
}

