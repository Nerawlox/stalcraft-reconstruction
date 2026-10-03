/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ObservableStorageManager
implements StorageManager {
    private final StorageManager delegate;

    @NotNull
    protected abstract <T> Function0<T> getObservable(@NotNull Function0<? extends T> var1);

    @NotNull
    protected abstract <K, V> Function1<K, V> getObservable(@NotNull Function1<? super K, ? extends V> var1);

    @Override
    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> compute) {
        Intrinsics.checkParameterIsNotNull(compute, "compute");
        return this.delegate.createMemoizedFunction(this.getObservable(compute));
    }

    @Override
    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> compute) {
        Intrinsics.checkParameterIsNotNull(compute, "compute");
        return this.delegate.createMemoizedFunctionWithNullableValues(this.getObservable(compute));
    }

    @Override
    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> compute, @NotNull ConcurrentMap<K, Object> map2) {
        Intrinsics.checkParameterIsNotNull(compute, "compute");
        Intrinsics.checkParameterIsNotNull(map2, "map");
        return this.delegate.createMemoizedFunction(this.getObservable(compute), map2);
    }

    @Override
    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> compute, @NotNull ConcurrentMap<K, Object> map2) {
        Intrinsics.checkParameterIsNotNull(compute, "compute");
        Intrinsics.checkParameterIsNotNull(map2, "map");
        return this.delegate.createMemoizedFunctionWithNullableValues(this.getObservable(compute), map2);
    }

    @Override
    @NotNull
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return this.delegate.createCacheWithNullableValues();
    }

    @Override
    @NotNull
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return this.delegate.createCacheWithNotNullValues();
    }

    @Override
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> computable) {
        Intrinsics.checkParameterIsNotNull(computable, "computable");
        return this.delegate.createLazyValue(this.getObservable(computable));
    }

    @Override
    @NotNull
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> computable, @NotNull T onRecursiveCall) {
        Intrinsics.checkParameterIsNotNull(computable, "computable");
        Intrinsics.checkParameterIsNotNull(onRecursiveCall, "onRecursiveCall");
        return this.delegate.createRecursionTolerantLazyValue(this.getObservable(computable), onRecursiveCall);
    }

    @Override
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> computable, @Nullable Function1<? super Boolean, ? extends T> onRecursiveCall, @NotNull Function1<? super T, Unit> postCompute) {
        Intrinsics.checkParameterIsNotNull(computable, "computable");
        Intrinsics.checkParameterIsNotNull(postCompute, "postCompute");
        return this.delegate.createLazyValueWithPostCompute(this.getObservable(computable), onRecursiveCall, postCompute);
    }

    @Override
    @NotNull
    public <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> computable) {
        Intrinsics.checkParameterIsNotNull(computable, "computable");
        return this.delegate.createNullableLazyValue(this.getObservable(computable));
    }

    @Override
    @NotNull
    public <T> NullableLazyValue<T> createRecursionTolerantNullableLazyValue(@NotNull Function0<? extends T> computable, @Nullable T onRecursiveCall) {
        Intrinsics.checkParameterIsNotNull(computable, "computable");
        return this.delegate.createRecursionTolerantNullableLazyValue(this.getObservable(computable), onRecursiveCall);
    }

    @Override
    @NotNull
    public <T> NullableLazyValue<T> createNullableLazyValueWithPostCompute(@NotNull Function0<? extends T> computable, @NotNull Function1<? super T, Unit> postCompute) {
        Intrinsics.checkParameterIsNotNull(computable, "computable");
        Intrinsics.checkParameterIsNotNull(postCompute, "postCompute");
        return this.delegate.createNullableLazyValueWithPostCompute(this.getObservable(computable), postCompute);
    }

    @Override
    public <T> T compute(@NotNull Function0<? extends T> computable) {
        Intrinsics.checkParameterIsNotNull(computable, "computable");
        return this.delegate.compute(this.getObservable(computable));
    }

    public ObservableStorageManager(@NotNull StorageManager delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        this.delegate = delegate;
    }
}

