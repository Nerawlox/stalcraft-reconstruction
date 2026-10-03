/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReflectProperties {
    @NotNull
    public static <T> LazyVal<T> lazy(@NotNull Function0<T> initializer2) {
        if (initializer2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazy"));
        }
        LazyVal<T> lazyVal = new LazyVal<T>(initializer2);
        if (lazyVal == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/ReflectProperties", "lazy"));
        }
        return lazyVal;
    }

    @NotNull
    public static <T> LazySoftVal<T> lazySoft(@Nullable T initialValue, @NotNull Function0<T> initializer2) {
        if (initializer2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
        }
        LazySoftVal<T> lazySoftVal = new LazySoftVal<T>(initialValue, initializer2);
        if (lazySoftVal == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
        }
        return lazySoftVal;
    }

    @NotNull
    public static <T> LazySoftVal<T> lazySoft(@NotNull Function0<T> initializer2) {
        if (initializer2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
        }
        LazySoftVal<Object> lazySoftVal = ReflectProperties.lazySoft(null, initializer2);
        if (lazySoftVal == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/ReflectProperties", "lazySoft"));
        }
        return lazySoftVal;
    }

    @NotNull
    public static <T> LazyWeakVal<T> lazyWeak(@NotNull Function0<T> initializer2) {
        if (initializer2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties", "lazyWeak"));
        }
        LazyWeakVal<T> lazyWeakVal = new LazyWeakVal<T>(initializer2);
        if (lazyWeakVal == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/ReflectProperties", "lazyWeak"));
        }
        return lazyWeakVal;
    }

    public static class LazyWeakVal<T>
    extends Val<T> {
        private final Function0<T> initializer;
        private WeakReference<Object> value;

        public LazyWeakVal(@NotNull Function0<T> initializer2) {
            if (initializer2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyWeakVal", "<init>"));
            }
            this.value = null;
            this.initializer = initializer2;
        }

        @Override
        public T invoke() {
            Object result2;
            WeakReference<Object> cached = this.value;
            if (cached != null && (result2 = cached.get()) != null) {
                return this.unescape(result2);
            }
            result2 = this.initializer.invoke();
            this.value = new WeakReference<Object>(this.escape(result2));
            return result2;
        }
    }

    public static class LazySoftVal<T>
    extends Val<T> {
        private final Function0<T> initializer;
        private SoftReference<Object> value;

        public LazySoftVal(@Nullable T initialValue, @NotNull Function0<T> initializer2) {
            if (initializer2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
            }
            this.value = null;
            this.initializer = initializer2;
            if (initialValue != null) {
                this.value = new SoftReference<Object>(this.escape(initialValue));
            }
        }

        @Override
        public T invoke() {
            Object result2;
            SoftReference<Object> cached = this.value;
            if (cached != null && (result2 = cached.get()) != null) {
                return this.unescape(result2);
            }
            result2 = this.initializer.invoke();
            this.value = new SoftReference<Object>(this.escape(result2));
            return (T)result2;
        }
    }

    public static class LazyVal<T>
    extends Val<T> {
        private final Function0<T> initializer;
        private Object value;

        public LazyVal(@NotNull Function0<T> initializer2) {
            if (initializer2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
            }
            this.value = null;
            this.initializer = initializer2;
        }

        @Override
        public T invoke() {
            Object cached = this.value;
            if (cached != null) {
                return this.unescape(cached);
            }
            T result2 = this.initializer.invoke();
            this.value = this.escape(result2);
            return result2;
        }
    }

    public static abstract class Val<T> {
        private static final Object NULL_VALUE = new Object(){};

        public final T getValue(Object instance, Object metadata) {
            return this.invoke();
        }

        public abstract T invoke();

        protected Object escape(T value) {
            return value == null ? NULL_VALUE : value;
        }

        protected T unescape(Object value) {
            return (T)(value == NULL_VALUE ? null : value);
        }
    }
}

