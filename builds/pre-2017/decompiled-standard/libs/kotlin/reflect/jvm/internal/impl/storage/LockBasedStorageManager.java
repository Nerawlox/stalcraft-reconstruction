/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.storage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NoLock;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.ExceptionUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LockBasedStorageManager
implements StorageManager {
    private static final String PACKAGE_NAME = StringsKt.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");
    public static final StorageManager NO_LOCKS = new LockBasedStorageManager("NO_LOCKS", ExceptionHandlingStrategy.THROW, NoLock.INSTANCE){

        @Override
        @NotNull
        protected <T> RecursionDetectedResult<T> recursionDetectedDefault() {
            RecursionDetectedResult recursionDetectedResult = RecursionDetectedResult.fallThrough();
            if (recursionDetectedResult == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1", "recursionDetectedDefault"));
            }
            return recursionDetectedResult;
        }
    };
    protected final Lock lock;
    private final ExceptionHandlingStrategy exceptionHandlingStrategy;
    private final String debugText;

    @NotNull
    public static LockBasedStorageManager createWithExceptionHandling(@NotNull ExceptionHandlingStrategy exceptionHandlingStrategy) {
        if (exceptionHandlingStrategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "exceptionHandlingStrategy", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createWithExceptionHandling"));
        }
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager(exceptionHandlingStrategy);
        if (lockBasedStorageManager == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createWithExceptionHandling"));
        }
        return lockBasedStorageManager;
    }

    private LockBasedStorageManager(@NotNull String debugText, @NotNull ExceptionHandlingStrategy exceptionHandlingStrategy, @NotNull Lock lock) {
        if (debugText == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugText", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "<init>"));
        }
        if (exceptionHandlingStrategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "exceptionHandlingStrategy", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "<init>"));
        }
        if (lock == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "lock", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "<init>"));
        }
        this.lock = lock;
        this.exceptionHandlingStrategy = exceptionHandlingStrategy;
        this.debugText = debugText;
    }

    public LockBasedStorageManager() {
        this(LockBasedStorageManager.defaultDebugName(), ExceptionHandlingStrategy.THROW, new ReentrantLock());
    }

    protected LockBasedStorageManager(@NotNull ExceptionHandlingStrategy exceptionHandlingStrategy) {
        if (exceptionHandlingStrategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "exceptionHandlingStrategy", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "<init>"));
        }
        this(LockBasedStorageManager.defaultDebugName(), exceptionHandlingStrategy, new ReentrantLock());
    }

    private static String defaultDebugName() {
        return "<unknown creating class>";
    }

    public String toString() {
        return this.getClass().getSimpleName() + "@" + Integer.toHexString(this.hashCode()) + " (" + this.debugText + ")";
    }

    @Override
    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> compute) {
        if (compute == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "compute", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createMemoizedFunction"));
        }
        MemoizedFunctionToNotNull<? super K, ? extends V> memoizedFunctionToNotNull = this.createMemoizedFunction(compute, LockBasedStorageManager.<K>createConcurrentHashMap());
        if (memoizedFunctionToNotNull == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createMemoizedFunction"));
        }
        return memoizedFunctionToNotNull;
    }

    @Override
    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> compute, @NotNull ConcurrentMap<K, Object> map2) {
        if (compute == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "compute", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createMemoizedFunction"));
        }
        if (map2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "map", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createMemoizedFunction"));
        }
        MapBasedMemoizedFunctionToNotNull<? super K, ? extends V> mapBasedMemoizedFunctionToNotNull = new MapBasedMemoizedFunctionToNotNull<K, V>(this, map2, compute);
        if (mapBasedMemoizedFunctionToNotNull == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createMemoizedFunction"));
        }
        return mapBasedMemoizedFunctionToNotNull;
    }

    @Override
    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> compute) {
        if (compute == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "compute", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createMemoizedFunctionWithNullableValues"));
        }
        MemoizedFunctionToNullable<? super K, ? extends V> memoizedFunctionToNullable = this.createMemoizedFunctionWithNullableValues(compute, LockBasedStorageManager.<K>createConcurrentHashMap());
        if (memoizedFunctionToNullable == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createMemoizedFunctionWithNullableValues"));
        }
        return memoizedFunctionToNullable;
    }

    @Override
    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> compute, @NotNull ConcurrentMap<K, Object> map2) {
        if (compute == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "compute", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createMemoizedFunctionWithNullableValues"));
        }
        if (map2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "map", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createMemoizedFunctionWithNullableValues"));
        }
        MapBasedMemoizedFunction<? super K, ? extends V> mapBasedMemoizedFunction = new MapBasedMemoizedFunction<K, V>(this, map2, compute);
        if (mapBasedMemoizedFunction == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createMemoizedFunctionWithNullableValues"));
        }
        return mapBasedMemoizedFunction;
    }

    @Override
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> computable) {
        if (computable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createLazyValue"));
        }
        LockBasedNotNullLazyValue<? extends T> lockBasedNotNullLazyValue = new LockBasedNotNullLazyValue<T>(this, computable);
        if (lockBasedNotNullLazyValue == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createLazyValue"));
        }
        return lockBasedNotNullLazyValue;
    }

    @Override
    @NotNull
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> computable, final @NotNull T onRecursiveCall) {
        if (computable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createRecursionTolerantLazyValue"));
        }
        if (onRecursiveCall == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "onRecursiveCall", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createRecursionTolerantLazyValue"));
        }
        LockBasedNotNullLazyValue lockBasedNotNullLazyValue = new LockBasedNotNullLazyValue<T>(this, computable){

            @Override
            @NotNull
            protected RecursionDetectedResult<T> recursionDetected(boolean firstTime) {
                RecursionDetectedResult<Object> recursionDetectedResult = RecursionDetectedResult.value(onRecursiveCall);
                if (recursionDetectedResult == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$2", "recursionDetected"));
                }
                return recursionDetectedResult;
            }
        };
        if (lockBasedNotNullLazyValue == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createRecursionTolerantLazyValue"));
        }
        return lockBasedNotNullLazyValue;
    }

    @Override
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> computable, final Function1<? super Boolean, ? extends T> onRecursiveCall, final @NotNull Function1<? super T, Unit> postCompute) {
        if (computable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createLazyValueWithPostCompute"));
        }
        if (postCompute == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "postCompute", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createLazyValueWithPostCompute"));
        }
        LockBasedNotNullLazyValue lockBasedNotNullLazyValue = new LockBasedNotNullLazyValue<T>(this, computable){

            @Override
            @NotNull
            protected RecursionDetectedResult<T> recursionDetected(boolean firstTime) {
                if (onRecursiveCall == null) {
                    RecursionDetectedResult recursionDetectedResult = super.recursionDetected(firstTime);
                    if (recursionDetectedResult == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$3", "recursionDetected"));
                    }
                    return recursionDetectedResult;
                }
                RecursionDetectedResult recursionDetectedResult = RecursionDetectedResult.value(onRecursiveCall.invoke(firstTime));
                if (recursionDetectedResult == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$3", "recursionDetected"));
                }
                return recursionDetectedResult;
            }

            @Override
            protected void postCompute(@NotNull T value) {
                if (value == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "value", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$3", "postCompute"));
                }
                postCompute.invoke(value);
            }
        };
        if (lockBasedNotNullLazyValue == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createLazyValueWithPostCompute"));
        }
        return lockBasedNotNullLazyValue;
    }

    @Override
    @NotNull
    public <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> computable) {
        if (computable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createNullableLazyValue"));
        }
        LockBasedLazyValue<? extends T> lockBasedLazyValue = new LockBasedLazyValue<T>(this, computable);
        if (lockBasedLazyValue == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createNullableLazyValue"));
        }
        return lockBasedLazyValue;
    }

    @Override
    @NotNull
    public <T> NullableLazyValue<T> createRecursionTolerantNullableLazyValue(@NotNull Function0<? extends T> computable, final T onRecursiveCall) {
        if (computable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createRecursionTolerantNullableLazyValue"));
        }
        LockBasedLazyValue lockBasedLazyValue = new LockBasedLazyValue<T>(this, computable){

            @Override
            @NotNull
            protected RecursionDetectedResult<T> recursionDetected(boolean firstTime) {
                RecursionDetectedResult<Object> recursionDetectedResult = RecursionDetectedResult.value(onRecursiveCall);
                if (recursionDetectedResult == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
                }
                return recursionDetectedResult;
            }
        };
        if (lockBasedLazyValue == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createRecursionTolerantNullableLazyValue"));
        }
        return lockBasedLazyValue;
    }

    @Override
    @NotNull
    public <T> NullableLazyValue<T> createNullableLazyValueWithPostCompute(@NotNull Function0<? extends T> computable, final @NotNull Function1<? super T, Unit> postCompute) {
        if (computable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createNullableLazyValueWithPostCompute"));
        }
        if (postCompute == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "postCompute", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createNullableLazyValueWithPostCompute"));
        }
        LockBasedLazyValue lockBasedLazyValue = new LockBasedLazyValue<T>(this, computable){

            @Override
            protected void postCompute(@Nullable T value) {
                postCompute.invoke(value);
            }
        };
        if (lockBasedLazyValue == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createNullableLazyValueWithPostCompute"));
        }
        return lockBasedLazyValue;
    }

    @Override
    public <T> T compute(@NotNull Function0<? extends T> computable) {
        if (computable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "compute"));
        }
        this.lock.lock();
        try {
            T t = computable.invoke();
            return t;
        }
        catch (Throwable throwable) {
            throw this.exceptionHandlingStrategy.handleException(throwable);
        }
        finally {
            this.lock.unlock();
        }
    }

    @NotNull
    private static <K> ConcurrentMap<K, Object> createConcurrentHashMap() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(3, 1.0f, 2);
        if (concurrentHashMap == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createConcurrentHashMap"));
        }
        return concurrentHashMap;
    }

    @NotNull
    protected <T> RecursionDetectedResult<T> recursionDetectedDefault() {
        throw LockBasedStorageManager.sanitizeStackTrace(new IllegalStateException("Recursive call in a lazy value under " + this));
    }

    @NotNull
    public static LockBasedStorageManager createDelegatingWithSameLock(@NotNull LockBasedStorageManager base, @NotNull ExceptionHandlingStrategy newStrategy) {
        if (base == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "base", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createDelegatingWithSameLock"));
        }
        if (newStrategy == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newStrategy", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createDelegatingWithSameLock"));
        }
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager(LockBasedStorageManager.defaultDebugName(), newStrategy, base.lock);
        if (lockBasedStorageManager == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createDelegatingWithSameLock"));
        }
        return lockBasedStorageManager;
    }

    @NotNull
    private static <T extends Throwable> T sanitizeStackTrace(@NotNull T throwable) {
        if (throwable == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "sanitizeStackTrace"));
        }
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int size = stackTrace.length;
        int firstNonStorage = -1;
        for (int i = 0; i < size; ++i) {
            if (stackTrace[i].getClassName().startsWith(PACKAGE_NAME)) continue;
            firstNonStorage = i;
            break;
        }
        assert (firstNonStorage >= 0) : "This method should only be called on exceptions created in LockBasedStorageManager";
        List<StackTraceElement> list = Arrays.asList(stackTrace).subList(firstNonStorage, size);
        throwable.setStackTrace(list.toArray(new StackTraceElement[list.size()]));
        T t = throwable;
        if (t == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "sanitizeStackTrace"));
        }
        return t;
    }

    @Override
    @NotNull
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        CacheWithNullableValuesBasedOnMemoizedFunction cacheWithNullableValuesBasedOnMemoizedFunction = new CacheWithNullableValuesBasedOnMemoizedFunction(this, (ConcurrentMap)LockBasedStorageManager.<K>createConcurrentHashMap());
        if (cacheWithNullableValuesBasedOnMemoizedFunction == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createCacheWithNullableValues"));
        }
        return cacheWithNullableValuesBasedOnMemoizedFunction;
    }

    @Override
    @NotNull
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        CacheWithNotNullValuesBasedOnMemoizedFunction cacheWithNotNullValuesBasedOnMemoizedFunction = new CacheWithNotNullValuesBasedOnMemoizedFunction(this, (ConcurrentMap)LockBasedStorageManager.<K>createConcurrentHashMap());
        if (cacheWithNotNullValuesBasedOnMemoizedFunction == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager", "createCacheWithNotNullValues"));
        }
        return cacheWithNotNullValuesBasedOnMemoizedFunction;
    }

    private static class KeyWithComputation<K, V> {
        private final K key;
        private final Function0<? extends V> computation;

        public KeyWithComputation(K key, Function0<? extends V> computation) {
            this.key = key;
            this.computation = computation;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            KeyWithComputation that = (KeyWithComputation)o;
            return this.key.equals(that.key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }
    }

    private static class CacheWithNotNullValuesBasedOnMemoizedFunction<K, V>
    extends CacheWithNullableValuesBasedOnMemoizedFunction<K, V>
    implements CacheWithNotNullValues<K, V> {
        private CacheWithNotNullValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager storageManager, @NotNull ConcurrentMap<KeyWithComputation<K, V>, Object> map2) {
            if (storageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction", "<init>"));
            }
            if (map2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "map", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction", "<init>"));
            }
            super(storageManager, map2);
        }

        @Override
        @NotNull
        public V computeIfAbsent(K key, @NotNull Function0<? extends V> computation) {
            if (computation == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computation", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction", "computeIfAbsent"));
            }
            V result2 = super.computeIfAbsent(key, computation);
            assert (result2 != null) : "computeIfAbsent() returned null under " + this.getStorageManager();
            V v = result2;
            if (v == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction", "computeIfAbsent"));
            }
            return v;
        }
    }

    private static class CacheWithNullableValuesBasedOnMemoizedFunction<K, V>
    extends MapBasedMemoizedFunction<KeyWithComputation<K, V>, V>
    implements CacheWithNullableValues<K, V> {
        private CacheWithNullableValuesBasedOnMemoizedFunction(@NotNull LockBasedStorageManager storageManager, @NotNull ConcurrentMap<KeyWithComputation<K, V>, Object> map2) {
            if (storageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction", "<init>"));
            }
            if (map2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "map", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction", "<init>"));
            }
            super(storageManager, map2, new Function1<KeyWithComputation<K, V>, V>(){

                @Override
                public V invoke(KeyWithComputation<K, V> computation) {
                    return computation.computation.invoke();
                }
            });
        }

        @Override
        @Nullable
        public V computeIfAbsent(K key, @NotNull Function0<? extends V> computation) {
            if (computation == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computation", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction", "computeIfAbsent"));
            }
            return this.invoke(new KeyWithComputation<K, V>(key, computation));
        }
    }

    private static class MapBasedMemoizedFunctionToNotNull<K, V>
    extends MapBasedMemoizedFunction<K, V>
    implements MemoizedFunctionToNotNull<K, V> {
        public MapBasedMemoizedFunctionToNotNull(@NotNull LockBasedStorageManager storageManager, @NotNull ConcurrentMap<K, Object> map2, @NotNull Function1<? super K, ? extends V> compute) {
            if (storageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull", "<init>"));
            }
            if (map2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "map", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull", "<init>"));
            }
            if (compute == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "compute", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull", "<init>"));
            }
            super(storageManager, map2, compute);
        }

        @Override
        @NotNull
        public V invoke(K input) {
            Object result2 = super.invoke(input);
            assert (result2 != null) : "compute() returned null under " + this.getStorageManager();
            Object v = result2;
            if (v == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull", "invoke"));
            }
            return v;
        }
    }

    private static class MapBasedMemoizedFunction<K, V>
    implements MemoizedFunctionToNullable<K, V> {
        private final LockBasedStorageManager storageManager;
        private final ConcurrentMap<K, Object> cache;
        private final Function1<? super K, ? extends V> compute;

        public MapBasedMemoizedFunction(@NotNull LockBasedStorageManager storageManager, @NotNull ConcurrentMap<K, Object> map2, @NotNull Function1<? super K, ? extends V> compute) {
            if (storageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction", "<init>"));
            }
            if (map2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "map", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction", "<init>"));
            }
            if (compute == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "compute", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction", "<init>"));
            }
            this.storageManager = storageManager;
            this.cache = map2;
            this.compute = compute;
        }

        @Override
        @Nullable
        public V invoke(K input) {
            Object value = this.cache.get(input);
            if (value != null && value != NotValue.COMPUTING) {
                return WrappedValues.unescapeExceptionOrNull(value);
            }
            this.storageManager.lock.lock();
            try {
                V v;
                value = this.cache.get(input);
                if (value == NotValue.COMPUTING) {
                    throw this.recursionDetected(input);
                }
                if (value != null) {
                    Object v2 = WrappedValues.unescapeExceptionOrNull(value);
                    return v2;
                }
                AssertionError error = null;
                try {
                    this.cache.put(input, (Object)NotValue.COMPUTING);
                    V typedValue = this.compute.invoke(input);
                    Object oldValue = this.cache.put(input, WrappedValues.escapeNull(typedValue));
                    if (oldValue != NotValue.COMPUTING) {
                        error = this.raceCondition(input, oldValue);
                        throw error;
                    }
                    v = typedValue;
                }
                catch (Throwable throwable) {
                    if (throwable == error) {
                        throw this.storageManager.exceptionHandlingStrategy.handleException(throwable);
                    }
                    Object oldValue = this.cache.put(input, WrappedValues.escapeThrowable(throwable));
                    if (oldValue != NotValue.COMPUTING) {
                        throw this.raceCondition(input, oldValue);
                    }
                    throw this.storageManager.exceptionHandlingStrategy.handleException(throwable);
                }
                return v;
            }
            finally {
                this.storageManager.lock.unlock();
            }
        }

        @NotNull
        private AssertionError recursionDetected(K input) {
            AssertionError assertionError = (AssertionError)((Object)LockBasedStorageManager.sanitizeStackTrace((Throwable)((Object)new AssertionError((Object)("Recursion detected on input: " + input + " under " + this.storageManager)))));
            if (assertionError == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction", "recursionDetected"));
            }
            return assertionError;
        }

        @NotNull
        private AssertionError raceCondition(K input, Object oldValue) {
            AssertionError assertionError = (AssertionError)((Object)LockBasedStorageManager.sanitizeStackTrace((Throwable)((Object)new AssertionError((Object)("Race condition detected on input " + input + ". Old value is " + oldValue + " under " + this.storageManager)))));
            if (assertionError == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction", "raceCondition"));
            }
            return assertionError;
        }

        @Override
        public boolean isComputed(K key) {
            Object value = this.cache.get(key);
            return value != null && value != NotValue.COMPUTING;
        }

        protected LockBasedStorageManager getStorageManager() {
            return this.storageManager;
        }
    }

    private static class LockBasedNotNullLazyValue<T>
    extends LockBasedLazyValue<T>
    implements NotNullLazyValue<T> {
        public LockBasedNotNullLazyValue(@NotNull LockBasedStorageManager storageManager, @NotNull Function0<? extends T> computable) {
            if (storageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue", "<init>"));
            }
            if (computable == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue", "<init>"));
            }
            super(storageManager, computable);
        }

        @Override
        @NotNull
        public T invoke() {
            Object result2 = super.invoke();
            assert (result2 != null) : "compute() returned null";
            Object t = result2;
            if (t == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue", "invoke"));
            }
            return t;
        }
    }

    private static class LockBasedLazyValue<T>
    implements NullableLazyValue<T> {
        private final LockBasedStorageManager storageManager;
        private final Function0<? extends T> computable;
        @Nullable
        private volatile Object value;

        public LockBasedLazyValue(@NotNull LockBasedStorageManager storageManager, @NotNull Function0<? extends T> computable) {
            if (storageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue", "<init>"));
            }
            if (computable == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "computable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue", "<init>"));
            }
            this.value = NotValue.NOT_COMPUTED;
            this.storageManager = storageManager;
            this.computable = computable;
        }

        @Override
        public boolean isComputed() {
            return this.value != NotValue.NOT_COMPUTED && this.value != NotValue.COMPUTING;
        }

        @Override
        public boolean isComputing() {
            return this.value == NotValue.COMPUTING;
        }

        @Override
        public T invoke() {
            Object _value = this.value;
            if (!(_value instanceof NotValue)) {
                return (T)WrappedValues.unescapeThrowable(_value);
            }
            this.storageManager.lock.lock();
            try {
                T t;
                RecursionDetectedResult<T> result2;
                _value = this.value;
                if (!(_value instanceof NotValue)) {
                    Object v = WrappedValues.unescapeThrowable(_value);
                    return (T)v;
                }
                if (_value == NotValue.COMPUTING) {
                    this.value = NotValue.RECURSION_WAS_DETECTED;
                    result2 = this.recursionDetected(true);
                    if (!result2.isFallThrough()) {
                        T t2 = result2.getValue();
                        return t2;
                    }
                }
                if (_value == NotValue.RECURSION_WAS_DETECTED && !(result2 = this.recursionDetected(false)).isFallThrough()) {
                    T t3 = result2.getValue();
                    return t3;
                }
                this.value = NotValue.COMPUTING;
                try {
                    T typedValue = this.computable.invoke();
                    this.value = typedValue;
                    this.postCompute(typedValue);
                    t = typedValue;
                }
                catch (Throwable throwable) {
                    if (this.value == NotValue.COMPUTING) {
                        this.value = WrappedValues.escapeThrowable(throwable);
                    }
                    throw this.storageManager.exceptionHandlingStrategy.handleException(throwable);
                }
                return t;
            }
            finally {
                this.storageManager.lock.unlock();
            }
        }

        @NotNull
        protected RecursionDetectedResult<T> recursionDetected(boolean firstTime) {
            RecursionDetectedResult recursionDetectedResult = this.storageManager.recursionDetectedDefault();
            if (recursionDetectedResult == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue", "recursionDetected"));
            }
            return recursionDetectedResult;
        }

        protected void postCompute(T value) {
        }
    }

    private static enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED;

    }

    private static class RecursionDetectedResult<T> {
        private final T value;
        private final boolean fallThrough;

        @NotNull
        public static <T> RecursionDetectedResult<T> value(T value) {
            RecursionDetectedResult<T> recursionDetectedResult = new RecursionDetectedResult<T>(value, false);
            if (recursionDetectedResult == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$RecursionDetectedResult", "value"));
            }
            return recursionDetectedResult;
        }

        @NotNull
        public static <T> RecursionDetectedResult<T> fallThrough() {
            RecursionDetectedResult<Object> recursionDetectedResult = new RecursionDetectedResult<Object>(null, true);
            if (recursionDetectedResult == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$RecursionDetectedResult", "fallThrough"));
            }
            return recursionDetectedResult;
        }

        private RecursionDetectedResult(T value, boolean fallThrough) {
            this.value = value;
            this.fallThrough = fallThrough;
        }

        public T getValue() {
            assert (!this.fallThrough) : "A value requested from FALL_THROUGH in " + this;
            return this.value;
        }

        public boolean isFallThrough() {
            return this.fallThrough;
        }

        public String toString() {
            return this.isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.value);
        }
    }

    public static interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new ExceptionHandlingStrategy(){

            @Override
            @NotNull
            public RuntimeException handleException(@NotNull Throwable throwable) {
                if (throwable == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
                }
                throw ExceptionUtilsKt.rethrow(throwable);
            }
        };

        @NotNull
        public RuntimeException handleException(@NotNull Throwable var1);
    }
}

