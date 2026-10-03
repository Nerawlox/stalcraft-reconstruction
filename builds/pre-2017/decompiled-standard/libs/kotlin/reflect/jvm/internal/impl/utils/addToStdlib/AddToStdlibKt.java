/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.utils.addToStdlib;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AddToStdlibKt {
    private static final ConcurrentHashMap<Function0<?>, Object> constantMap = new ConcurrentHashMap();

    @NotNull
    public static final <T> List<T> singletonOrEmptyList(@Nullable T $receiver) {
        List list;
        if ($receiver != null) {
            List<T> list2 = Collections.singletonList($receiver);
            list = list2;
            Intrinsics.checkExpressionValueIsNotNull(list2, "Collections.singletonList(this)");
        } else {
            List list3 = Collections.emptyList();
            list = list3;
            Intrinsics.checkExpressionValueIsNotNull(list3, "Collections.emptyList()");
        }
        return list;
    }

    @NotNull
    public static final <T> List<T> singletonList(T $receiver) {
        List<T> list = Collections.singletonList($receiver);
        Intrinsics.checkExpressionValueIsNotNull(list, "Collections.singletonList(this)");
        return list;
    }

    @NotNull
    public static final <T> Set<T> singletonOrEmptySet(@Nullable T $receiver) {
        Set set;
        if ($receiver != null) {
            Set<T> set2 = Collections.singleton($receiver);
            set = set2;
            Intrinsics.checkExpressionValueIsNotNull(set2, "Collections.singleton(this)");
        } else {
            Set set3 = Collections.emptySet();
            set = set3;
            Intrinsics.checkExpressionValueIsNotNull(set3, "Collections.emptySet()");
        }
        return set;
    }

    private static final <T> T firstIsInstanceOrNull(@NotNull Sequence<?> $receiver) {
        Iterator<?> iterator2 = $receiver.iterator();
        while (iterator2.hasNext()) {
            Object element = iterator2.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(element instanceof Object)) continue;
            return (T)element;
        }
        return null;
    }

    private static final <T> T firstIsInstanceOrNull(@NotNull Iterable<?> $receiver) {
        for (Object element : $receiver) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(element instanceof Object)) continue;
            return (T)element;
        }
        return null;
    }

    private static final <T> T firstIsInstanceOrNull(@NotNull Object[] $receiver) {
        for (int i = 0; i < $receiver.length; ++i) {
            Object element = $receiver[i];
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(element instanceof Object)) continue;
            return (T)element;
        }
        return null;
    }

    private static final <T> T firstIsInstance(@NotNull Sequence<?> $receiver) {
        Iterator<?> iterator2 = $receiver.iterator();
        while (iterator2.hasNext()) {
            Object element = iterator2.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(element instanceof Object)) continue;
            return (T)element;
        }
        throw (Throwable)new NoSuchElementException("No element of given type found");
    }

    private static final <T> T firstIsInstance(@NotNull Iterable<?> $receiver) {
        for (Object element : $receiver) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(element instanceof Object)) continue;
            return (T)element;
        }
        throw (Throwable)new NoSuchElementException("No element of given type found");
    }

    private static final <T> T firstIsInstance(@NotNull Object[] $receiver) {
        for (int i = 0; i < $receiver.length; ++i) {
            Object element = $receiver[i];
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(element instanceof Object)) continue;
            return (T)element;
        }
        throw (Throwable)new NoSuchElementException("No element of given type found");
    }

    /*
     * WARNING - void declaration
     */
    private static final <T> T lastIsInstanceOrNull(@NotNull Iterable<?> $receiver) {
        T t;
        block5: {
            Iterable<?> iterable = $receiver;
            if (iterable instanceof List) {
                IntProgression intProgression = RangesKt.reversed(CollectionsKt.getIndices((Collection)$receiver));
                int n = intProgression.getFirst();
                int n2 = intProgression.getLast();
                int n3 = intProgression.getStep();
                int n4 = n;
                int n5 = n2;
                if (n3 > 0 ? n4 <= n5 : n4 >= n5) {
                    while (true) {
                        void i;
                        Object element = ((List)$receiver).get((int)i);
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (element instanceof Object) {
                            return (T)element;
                        }
                        if (i == n2) break;
                        i += n3;
                    }
                }
                return null;
            }
            Iterable $receiver$iv = CollectionsKt.reversed($receiver);
            for (Object element$iv : $receiver$iv) {
                Intrinsics.reifiedOperationMarker(3, "T");
                if (!(element$iv instanceof Object)) continue;
                t = element$iv;
                break block5;
            }
            t = null;
        }
        return t;
    }

    @NotNull
    public static final <T> Sequence<T> sequenceOfLazyValues(Function0<? extends T> ... elements) {
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        return SequencesKt.map(ArraysKt.asSequence((Object[])elements), sequenceOfLazyValues.1.INSTANCE);
    }

    @NotNull
    public static final <T1, T2> Pair<T2, T1> swap(@NotNull Pair<? extends T1, ? extends T2> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return new Pair<T2, T1>($receiver.getSecond(), $receiver.getFirst());
    }

    @Nullable
    public static final <T> T check(@NotNull T $receiver, @NotNull Function1<? super T, Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return (T)(predicate.invoke($receiver) != false ? $receiver : null);
    }

    private static final <T> T safeAs(@Nullable Object $receiver) {
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T)$receiver;
    }

    private static final <T> T cast(@Nullable Object $receiver) {
        Intrinsics.reifiedOperationMarker(1, "T");
        return (T)$receiver;
    }

    private static final <T> T assertedCast(@Nullable Object $receiver, Function0<String> message) {
        Intrinsics.reifiedOperationMarker(2, "T");
        Object object = $receiver;
        if (object == null) {
            throw (Throwable)((Object)new AssertionError((Object)message.invoke()));
        }
        return (T)object;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> T constant(@NotNull Function0<? extends T> calculator) {
        Object object;
        void $receiver$iv$iv;
        Intrinsics.checkParameterIsNotNull(calculator, "calculator");
        Object cached = constantMap.get(calculator);
        if (cached != null) {
            Object object2 = cached;
            if (object2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type T");
            }
            return (T)object2;
        }
        Object[] $receiver$iv22 = calculator.getClass().getDeclaredFields();
        Object object3 = $receiver$iv22;
        Collection destination$iv$iv = new ArrayList();
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void element$iv$iv = $receiver$iv$iv[i];
            Field it = (Field)element$iv$iv;
            if (!((it.getModifiers() & 8) == 0)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List fields2 = (List)destination$iv$iv;
        boolean $receiver$iv22 = fields2.isEmpty();
        if (_Assertions.ENABLED && !$receiver$iv22) {
            object = "No fields in the passed lambda expected but " + CollectionsKt.joinToString$default(fields2, null, null, null, 0, null, null, 63, null) + " found";
            throw (Throwable)((Object)new AssertionError(object));
        }
        T value = calculator.invoke();
        object3 = constantMap;
        object = value;
        object3.put(calculator, object);
        return value;
    }

    @Nullable
    public static final Integer indexOfOrNull(@NotNull String $receiver, char c, int startIndex, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        int index = StringsKt.indexOf((CharSequence)$receiver, c, startIndex, ignoreCase);
        return index >= 0 ? Integer.valueOf(index) : null;
    }

    @Nullable
    public static /* bridge */ /* synthetic */ Integer indexOfOrNull$default(String string, char c, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return AddToStdlibKt.indexOfOrNull(string, c, n, bl);
    }

    @Nullable
    public static final Integer lastIndexOfOrNull(@NotNull String $receiver, char c, int startIndex, boolean ignoreCase) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        int index = StringsKt.lastIndexOf((CharSequence)$receiver, c, startIndex, ignoreCase);
        return index >= 0 ? Integer.valueOf(index) : null;
    }

    @Nullable
    public static /* bridge */ /* synthetic */ Integer lastIndexOfOrNull$default(String string, char c, int n, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return AddToStdlibKt.lastIndexOfOrNull(string, c, n, bl);
    }

    @Nullable
    public static final <T, R> R firstNotNullResult(@NotNull Iterable<? extends T> $receiver, @NotNull Function1<? super T, ? extends R> transform) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        for (T element : $receiver) {
            R result2 = transform.invoke(element);
            if (result2 == null) continue;
            return result2;
        }
        return null;
    }

    public static final <T> long sumByLong(@NotNull Iterable<? extends T> $receiver, @NotNull Function1<? super T, Long> selector) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        long sum = 0L;
        for (T element : $receiver) {
            sum += ((Number)selector.invoke(element)).longValue();
        }
        return sum;
    }

    @Nullable
    public static final <T, C extends Collection<? extends T>, O> O ifNotEmpty(@NotNull C $receiver, @NotNull Function1<? super C, ? extends O> body) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(body, "body");
        C c = $receiver;
        return !c.isEmpty() ? (O)body.invoke((C)$receiver) : null;
    }

    @Nullable
    public static final <T, O> O ifNotEmpty(@NotNull T[] $receiver, @NotNull Function1<? super T[], ? extends O> body) {
        T[] TArray;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(body, "body");
        T[] TArray2 = TArray = $receiver;
        return !(TArray2.length == 0) ? (O)body.invoke((T[])$receiver) : null;
    }
}

