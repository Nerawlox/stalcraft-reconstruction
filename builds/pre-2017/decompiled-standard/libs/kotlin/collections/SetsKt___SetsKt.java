/*
 * Decompiled with CFR 0.152.
 */
package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=5, xi=1, d1={"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002\u00a2\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002\u00a2\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b\u00a2\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002\u00a2\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002\u00a2\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\r"}, d2={"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, xs="kotlin/collections/SetsKt")
class SetsKt___SetsKt
extends SetsKt__SetsKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> $receiver, T element) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        LinkedHashSet result2 = new LinkedHashSet(MapsKt.mapCapacity($receiver.size()));
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        Iterable $receiver$iv = $receiver;
        Iterator iterator2 = $receiver$iv.iterator();
        while (iterator2.hasNext()) {
            boolean bl;
            void removed;
            Object element$iv;
            Object it = element$iv = iterator2.next();
            if (!removed.element && Intrinsics.areEqual(it, element)) {
                removed.element = true;
                bl = false;
            } else {
                bl = true;
            }
            if (!bl) continue;
            ((Collection)result2).add(element$iv);
        }
        return (Set)((Collection)result2);
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> $receiver, @NotNull T[] elements) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        LinkedHashSet result2 = new LinkedHashSet($receiver);
        CollectionsKt.removeAll((Collection)result2, elements);
        return result2;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> $receiver, @NotNull Iterable<? extends T> elements) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        Collection<T> other = CollectionsKt.convertToSetForSetOperationWith(elements, (Iterable)$receiver);
        if (other.isEmpty()) {
            return CollectionsKt.toSet((Iterable)$receiver);
        }
        if (other instanceof Set) {
            void $receiver$iv;
            Iterable iterable = $receiver;
            Collection destination$iv = new LinkedHashSet();
            for (Object element$iv : $receiver$iv) {
                Object it = element$iv;
                if (other.contains(it)) continue;
                destination$iv.add(element$iv);
            }
            return (Set)destination$iv;
        }
        LinkedHashSet result2 = new LinkedHashSet($receiver);
        result2.removeAll(other);
        return result2;
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> $receiver, @NotNull Sequence<? extends T> elements) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        LinkedHashSet result2 = new LinkedHashSet($receiver);
        CollectionsKt.removeAll((Collection)result2, elements);
        return result2;
    }

    @InlineOnly
    private static final <T> Set<T> minusElement(@NotNull Set<? extends T> $receiver, T element) {
        return SetsKt.minus($receiver, element);
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> $receiver, T element) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        LinkedHashSet<T> result2 = new LinkedHashSet<T>(MapsKt.mapCapacity($receiver.size() + 1));
        result2.addAll((Collection)$receiver);
        result2.add(element);
        return result2;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> $receiver, @NotNull T[] elements) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        LinkedHashSet result2 = new LinkedHashSet(MapsKt.mapCapacity($receiver.size() + elements.length));
        result2.addAll($receiver);
        CollectionsKt.addAll((Collection)result2, elements);
        return result2;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> $receiver, @NotNull Iterable<? extends T> elements) {
        int n;
        LinkedHashSet linkedHashSet;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        LinkedHashSet linkedHashSet3 = linkedHashSet;
        Integer n2 = CollectionsKt.collectionSizeOrNull(elements);
        if (n2 != null) {
            Integer n3 = n2;
            LinkedHashSet linkedHashSet4 = linkedHashSet2;
            LinkedHashSet linkedHashSet5 = linkedHashSet3;
            int it = ((Number)n3).intValue();
            int n4 = $receiver.size() + it;
            linkedHashSet3 = linkedHashSet5;
            linkedHashSet2 = linkedHashSet4;
            n = n4;
        } else {
            n = $receiver.size() * 2;
        }
        linkedHashSet2(MapsKt.mapCapacity(n));
        LinkedHashSet result2 = linkedHashSet3;
        result2.addAll($receiver);
        CollectionsKt.addAll((Collection)result2, elements);
        return result2;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> $receiver, @NotNull Sequence<? extends T> elements) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(elements, "elements");
        LinkedHashSet result2 = new LinkedHashSet(MapsKt.mapCapacity($receiver.size() * 2));
        result2.addAll($receiver);
        CollectionsKt.addAll((Collection)result2, elements);
        return result2;
    }

    @InlineOnly
    private static final <T> Set<T> plusElement(@NotNull Set<? extends T> $receiver, T element) {
        return SetsKt.plus($receiver, element);
    }
}

