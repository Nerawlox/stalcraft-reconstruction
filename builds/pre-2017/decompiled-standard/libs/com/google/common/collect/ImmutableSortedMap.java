/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.EmptyImmutableSortedMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMapFauxverideShim;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableSortedMap;
import com.google.common.collect.RegularImmutableSortedSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableSortedMap<K, V>
extends ImmutableSortedMapFauxverideShim<K, V>
implements NavigableMap<K, V> {
    private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new EmptyImmutableSortedMap<Comparable, Object>(NATURAL_ORDER);
    private transient ImmutableSortedMap<K, V> descendingMap;
    private static final long serialVersionUID = 0L;

    static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return ImmutableSortedMap.of();
        }
        return new EmptyImmutableSortedMap(comparator);
    }

    static <K, V> ImmutableSortedMap<K, V> fromSortedEntries(Comparator<? super K> comparator, Collection<? extends Map.Entry<? extends K, ? extends V>> entries) {
        if (entries.isEmpty()) {
            return ImmutableSortedMap.emptyMap(comparator);
        }
        ImmutableList.Builder keyBuilder = ImmutableList.builder();
        ImmutableList.Builder valueBuilder = ImmutableList.builder();
        for (Map.Entry<K, V> entry : entries) {
            keyBuilder.add(entry.getKey());
            valueBuilder.add(entry.getValue());
        }
        return new RegularImmutableSortedMap(new RegularImmutableSortedSet<K>(keyBuilder.build(), comparator), valueBuilder.build());
    }

    static <K, V> ImmutableSortedMap<K, V> from(ImmutableSortedSet<K> keySet, ImmutableList<V> valueList) {
        if (keySet.isEmpty()) {
            return ImmutableSortedMap.emptyMap(keySet.comparator());
        }
        return new RegularImmutableSortedMap((RegularImmutableSortedSet)keySet, valueList);
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return NATURAL_EMPTY_MAP;
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k1, V v1) {
        return ImmutableSortedMap.from(ImmutableSortedSet.of(k1), ImmutableList.of(v1));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2) {
        return ((Builder)((Builder)new Builder(Ordering.natural()).put((Object)k1, (Object)v1)).put((Object)k2, (Object)v2)).build();
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return ((Builder)((Builder)((Builder)new Builder(Ordering.natural()).put((Object)k1, (Object)v1)).put((Object)k2, (Object)v2)).put((Object)k3, (Object)v3)).build();
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ((Builder)((Builder)((Builder)((Builder)new Builder(Ordering.natural()).put((Object)k1, (Object)v1)).put((Object)k2, (Object)v2)).put((Object)k3, (Object)v3)).put((Object)k4, (Object)v4)).build();
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ((Builder)((Builder)((Builder)((Builder)((Builder)new Builder(Ordering.natural()).put((Object)k1, (Object)v1)).put((Object)k2, (Object)v2)).put((Object)k3, (Object)v3)).put((Object)k4, (Object)v4)).put((Object)k5, (Object)v5)).build();
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map2) {
        Ordering naturalOrder = Ordering.natural();
        return ImmutableSortedMap.copyOfInternal(map2, naturalOrder);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map2, Comparator<? super K> comparator) {
        return ImmutableSortedMap.copyOfInternal(map2, Preconditions.checkNotNull(comparator));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> map2) {
        Comparator<Object> comparator = map2.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        return ImmutableSortedMap.copyOfInternal(map2, comparator);
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> map2, Comparator<? super K> comparator) {
        ImmutableSortedMap kvMap;
        boolean sameComparator = false;
        if (map2 instanceof SortedMap) {
            SortedMap sortedMap = (SortedMap)map2;
            Comparator comparator2 = sortedMap.comparator();
            boolean bl = comparator2 == null ? comparator == NATURAL_ORDER : (sameComparator = comparator.equals(comparator2));
        }
        if (sameComparator && map2 instanceof ImmutableSortedMap && !(kvMap = (ImmutableSortedMap)map2).isPartialView()) {
            return kvMap;
        }
        Map.Entry[] entries = map2.entrySet().toArray(new Map.Entry[0]);
        for (int i = 0; i < entries.length; ++i) {
            Map.Entry entry = entries[i];
            entries[i] = ImmutableSortedMap.entryOf(entry.getKey(), entry.getValue());
        }
        List<Map.Entry<K, V>> list = Arrays.asList(entries);
        if (!sameComparator) {
            ImmutableSortedMap.sortEntries(list, comparator);
            ImmutableSortedMap.validateEntries(list, comparator);
        }
        return ImmutableSortedMap.fromSortedEntries(comparator, list);
    }

    private static <K, V> void sortEntries(List<Map.Entry<K, V>> entries, final Comparator<? super K> comparator) {
        Comparator entryComparator = new Comparator<Map.Entry<K, V>>(){

            @Override
            public int compare(Map.Entry<K, V> entry1, Map.Entry<K, V> entry2) {
                return comparator.compare(entry1.getKey(), entry2.getKey());
            }
        };
        Collections.sort(entries, entryComparator);
    }

    private static <K, V> void validateEntries(List<Map.Entry<K, V>> entries, Comparator<? super K> comparator) {
        for (int i = 1; i < entries.size(); ++i) {
            if (comparator.compare(entries.get(i - 1).getKey(), entries.get(i).getKey()) != 0) continue;
            throw new IllegalArgumentException("Duplicate keys in mappings " + entries.get(i - 1) + " and " + entries.get(i));
        }
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder(Ordering.natural());
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> comparator) {
        return new Builder(comparator);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder(Ordering.natural().reverse());
    }

    ImmutableSortedMap() {
    }

    ImmutableSortedMap(ImmutableSortedMap<K, V> descendingMap) {
        this.descendingMap = descendingMap;
    }

    @Override
    public int size() {
        return this.values().size();
    }

    @Override
    public boolean containsValue(@Nullable Object value) {
        return ((ImmutableCollection)this.values()).contains(value);
    }

    @Override
    boolean isPartialView() {
        return this.keySet().isPartialView() || ((ImmutableCollection)this.values()).isPartialView();
    }

    @Override
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override
    public abstract ImmutableSortedSet<K> keySet();

    @Override
    public abstract ImmutableCollection<V> values();

    @Override
    public Comparator<? super K> comparator() {
        return ((ImmutableSortedSet)this.keySet()).comparator();
    }

    @Override
    public K firstKey() {
        return (K)((ImmutableSortedSet)this.keySet()).first();
    }

    @Override
    public K lastKey() {
        return (K)((ImmutableSortedSet)this.keySet()).last();
    }

    @Override
    public ImmutableSortedMap<K, V> headMap(K toKey) {
        return this.headMap((Object)toKey, false);
    }

    @Override
    public abstract ImmutableSortedMap<K, V> headMap(K var1, boolean var2);

    @Override
    public ImmutableSortedMap<K, V> subMap(K fromKey, K toKey) {
        return this.subMap((Object)fromKey, true, (Object)toKey, false);
    }

    @Override
    public ImmutableSortedMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        Preconditions.checkNotNull(fromKey);
        Preconditions.checkNotNull(toKey);
        Preconditions.checkArgument(this.comparator().compare(fromKey, toKey) <= 0, "expected fromKey <= toKey but %s > %s", fromKey, toKey);
        return ((ImmutableSortedMap)this.headMap((Object)toKey, toInclusive)).tailMap((Object)fromKey, fromInclusive);
    }

    @Override
    public ImmutableSortedMap<K, V> tailMap(K fromKey) {
        return this.tailMap((Object)fromKey, true);
    }

    @Override
    public abstract ImmutableSortedMap<K, V> tailMap(K var1, boolean var2);

    @Override
    public Map.Entry<K, V> lowerEntry(K key) {
        return ((ImmutableSortedMap)this.headMap((Object)key, false)).lastEntry();
    }

    @Override
    public K lowerKey(K key) {
        return Maps.keyOrNull(this.lowerEntry(key));
    }

    @Override
    public Map.Entry<K, V> floorEntry(K key) {
        return ((ImmutableSortedMap)this.headMap((Object)key, true)).lastEntry();
    }

    @Override
    public K floorKey(K key) {
        return Maps.keyOrNull(this.floorEntry(key));
    }

    @Override
    public Map.Entry<K, V> ceilingEntry(K key) {
        return ((ImmutableSortedMap)this.tailMap((Object)key, true)).firstEntry();
    }

    @Override
    public K ceilingKey(K key) {
        return Maps.keyOrNull(this.ceilingEntry(key));
    }

    @Override
    public Map.Entry<K, V> higherEntry(K key) {
        return ((ImmutableSortedMap)this.tailMap((Object)key, false)).firstEntry();
    }

    @Override
    public K higherKey(K key) {
        return Maps.keyOrNull(this.higherEntry(key));
    }

    @Override
    public Map.Entry<K, V> firstEntry() {
        return this.isEmpty() ? null : (Map.Entry)((ImmutableCollection)((Object)this.entrySet())).asList().get(0);
    }

    @Override
    public Map.Entry<K, V> lastEntry() {
        return this.isEmpty() ? null : (Map.Entry)((ImmutableCollection)((Object)this.entrySet())).asList().get(this.size() - 1);
    }

    @Override
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> result2 = this.descendingMap;
        if (result2 == null) {
            result2 = this.descendingMap = this.createDescendingMap();
        }
        return result2;
    }

    abstract ImmutableSortedMap<K, V> createDescendingMap();

    @Override
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet();
    }

    @Override
    public ImmutableSortedSet<K> descendingKeySet() {
        return ((ImmutableSortedSet)this.keySet()).descendingSet();
    }

    @Override
    Object writeReplace() {
        return new SerializedForm(this);
    }

    private static class SerializedForm
    extends ImmutableMap.SerializedForm {
        private final Comparator<Object> comparator;
        private static final long serialVersionUID = 0L;

        SerializedForm(ImmutableSortedMap<?, ?> sortedMap) {
            super(sortedMap);
            this.comparator = sortedMap.comparator();
        }

        @Override
        Object readResolve() {
            Builder<Object, Object> builder = new Builder<Object, Object>(this.comparator);
            return this.createMap(builder);
        }
    }

    public static class Builder<K, V>
    extends ImmutableMap.Builder<K, V> {
        private final Comparator<? super K> comparator;

        public Builder(Comparator<? super K> comparator) {
            this.comparator = Preconditions.checkNotNull(comparator);
        }

        @Override
        public Builder<K, V> put(K key, V value) {
            this.entries.add(ImmutableMap.entryOf(key, value));
            return this;
        }

        @Override
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put(entry);
            return this;
        }

        @Override
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map2) {
            for (Map.Entry<K, V> entry : map2.entrySet()) {
                this.put((Object)entry.getKey(), (Object)entry.getValue());
            }
            return this;
        }

        @Override
        public ImmutableSortedMap<K, V> build() {
            ImmutableSortedMap.sortEntries(this.entries, this.comparator);
            ImmutableSortedMap.validateEntries(this.entries, this.comparator);
            return ImmutableSortedMap.fromSortedEntries(this.comparator, this.entries);
        }
    }
}

