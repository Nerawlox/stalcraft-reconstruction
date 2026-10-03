/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CollectionsKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <K, V> Map<K, V> keysToMap(@NotNull Iterable<? extends K> $receiver, @NotNull Function1<? super K, ? extends V> value) {
        void $receiver$iv$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(value, "value");
        Iterable<? extends K> $receiver$iv = $receiver;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
        Iterable<? extends K> iterable = $receiver$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        Iterator iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void it;
            Object element$iv$iv;
            Object t = element$iv$iv = iterator2.next();
            Map map2 = destination$iv$iv;
            void var10_10 = it;
            map2.put(var10_10, value.invoke(element$iv$iv));
        }
        return destination$iv$iv;
    }

    @NotNull
    public static final <K, V> Map<K, V> keysToMapExceptNulls(@NotNull Iterable<? extends K> $receiver, @NotNull Function1<? super K, ? extends V> value) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(value, "value");
        LinkedHashMap map2 = new LinkedHashMap();
        for (K k : $receiver) {
            V v = value.invoke(k);
            if (v == null) continue;
            Map map3 = map2;
            V v2 = v;
            map3.put(k, v2);
        }
        return map2;
    }

    @NotNull
    public static final <K> Map<K, Integer> mapToIndex(@NotNull Iterable<? extends K> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        LinkedHashMap map2 = new LinkedHashMap();
        for (IndexedValue<K> indexedValue : kotlin.collections.CollectionsKt.withIndex($receiver)) {
            int index = indexedValue.component1();
            K k = indexedValue.component2();
            Map map3 = map2;
            Integer n = index;
            map3.put(k, n);
        }
        return map2;
    }

    /*
     * WARNING - void declaration
     */
    public static final <K, V> V getOrPutNullable(@NotNull Map<K, V> $receiver, K key, @NotNull Function0<? extends V> defaultValue) {
        V v;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        if (!$receiver.containsKey(key)) {
            void var3_3;
            V answer = defaultValue.invoke();
            $receiver.put(key, answer);
            v = var3_3;
        } else {
            v = $receiver.get(key);
        }
        return v;
    }

    @NotNull
    public static final <T, C extends Collection<? extends T>> C ifEmpty(@NotNull C $receiver, @NotNull Function0<? extends C> body) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(body, "body");
        return (C)($receiver.isEmpty() ? (Collection)body.invoke() : $receiver);
    }

    @NotNull
    public static final <T> T[] ifEmpty(@NotNull T[] $receiver, @NotNull Function0<? extends T[]> body) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(body, "body");
        T[] TArray = $receiver;
        return TArray.length == 0 ? body.invoke() : $receiver;
    }

    @NotNull
    public static final <T> List<T> emptyOrSingletonList(@Nullable T item) {
        return kotlin.collections.CollectionsKt.listOfNotNull(item);
    }

    public static final <T> void addIfNotNull(@NotNull Collection<T> $receiver, @Nullable T t) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (t != null) {
            $receiver.add(t);
        }
    }

    @NotNull
    public static final <K, V> HashMap<K, V> newHashMapWithExpectedSize(int expectedSize) {
        return new HashMap(CollectionsKt.capacity(expectedSize));
    }

    @NotNull
    public static final <E> HashSet<E> newHashSetWithExpectedSize(int expectedSize) {
        return new HashSet(CollectionsKt.capacity(expectedSize));
    }

    @NotNull
    public static final <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int expectedSize) {
        return new LinkedHashMap(CollectionsKt.capacity(expectedSize));
    }

    @NotNull
    public static final <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int expectedSize) {
        return new LinkedHashSet(CollectionsKt.capacity(expectedSize));
    }

    private static final int capacity(int expectedSize) {
        return expectedSize < 3 ? 3 : expectedSize + expectedSize / 3 + 1;
    }

    @NotNull
    public static final <T> List<T> toReadOnlyList(@NotNull Collection<? extends T> $receiver) {
        List list;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        switch ($receiver.size()) {
            case 0: {
                list = kotlin.collections.CollectionsKt.emptyList();
                break;
            }
            case 1: {
                list = kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first((Iterable)$receiver));
                break;
            }
            default: {
                list = new ArrayList<T>($receiver);
            }
        }
        return list;
    }

    @NotNull
    public static final <T> List<T> compactIfPossible(@NotNull ArrayList<T> $receiver) {
        List list;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        switch ($receiver.size()) {
            case 0: {
                list = kotlin.collections.CollectionsKt.emptyList();
                break;
            }
            case 1: {
                list = kotlin.collections.CollectionsKt.listOf(kotlin.collections.CollectionsKt.first((List)$receiver));
                break;
            }
            default: {
                ArrayList<T> arrayList;
                ArrayList<T> p1 = arrayList = $receiver;
                p1.trimToSize();
                list = arrayList;
            }
        }
        return list;
    }

    @NotNull
    public static final <T> List<T> singletonOrEmptyList(@Nullable T $receiver) {
        return $receiver != null ? kotlin.collections.CollectionsKt.listOf($receiver) : kotlin.collections.CollectionsKt.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    public static final <T> int indexOfFirst(@NotNull List<? extends T> $receiver, int startFrom, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        int n = startFrom;
        int n2 = kotlin.collections.CollectionsKt.getLastIndex($receiver);
        if (n <= n2) {
            while (true) {
                void index;
                if (predicate.invoke($receiver.get((int)index)).booleanValue()) {
                    return (int)index;
                }
                if (index == n2) break;
                ++index;
            }
        }
        return -1;
    }
}

