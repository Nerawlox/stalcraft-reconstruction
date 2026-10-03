/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingNavigableSet;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ForwardingSortedMap;
import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.ImmutableEnumMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Ordering;
import com.google.common.collect.Platform;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedMapDifference;
import com.google.common.collect.Synchronized;
import com.google.common.collect.TransformedIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Maps {
    static final Joiner.MapJoiner STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");

    private Maps() {
    }

    static <K> Function<Map.Entry<K, ?>, K> keyFunction() {
        return EntryFunction.KEY;
    }

    static <V> Function<Map.Entry<?, V>, V> valueFunction() {
        return EntryFunction.VALUE;
    }

    @GwtCompatible(serializable=true)
    @Beta
    public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, V> map2) {
        if (map2 instanceof ImmutableEnumMap) {
            return (ImmutableEnumMap)map2;
        }
        if (map2.isEmpty()) {
            return ImmutableMap.of();
        }
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            Preconditions.checkNotNull(entry.getKey());
            Preconditions.checkNotNull(entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(new EnumMap<K, V>(map2));
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int expectedSize) {
        return new HashMap(Maps.capacity(expectedSize));
    }

    static int capacity(int expectedSize) {
        if (expectedSize < 3) {
            Preconditions.checkArgument(expectedSize >= 0);
            return expectedSize + 1;
        }
        if (expectedSize < 0x40000000) {
            return expectedSize + expectedSize / 3;
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map2) {
        return new HashMap<K, V>(map2);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map2) {
        return new LinkedHashMap<K, V>(map2);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new MapMaker().makeMap();
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap();
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> map2) {
        return new TreeMap<K, V>(map2);
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@Nullable Comparator<C> comparator) {
        return new TreeMap(comparator);
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> type2) {
        return new EnumMap(Preconditions.checkNotNull(type2));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> map2) {
        return new EnumMap<K, V>(map2);
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap();
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
        if (left instanceof SortedMap) {
            SortedMap sortedLeft = (SortedMap)left;
            SortedMapDifference<? extends K, ? extends V> result2 = Maps.difference(sortedLeft, right);
            return result2;
        }
        return Maps.difference(left, right, Equivalence.equals());
    }

    @Beta
    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right, Equivalence<? super V> valueEquivalence) {
        Preconditions.checkNotNull(valueEquivalence);
        HashMap<K, V> onlyOnLeft = Maps.newHashMap();
        HashMap<K, V> onlyOnRight = new HashMap<K, V>(right);
        HashMap<K, V> onBoth = Maps.newHashMap();
        HashMap<K, MapDifference.ValueDifference<V>> differences = Maps.newHashMap();
        boolean eq = true;
        for (Map.Entry<K, V> entry : left.entrySet()) {
            K leftKey = entry.getKey();
            V leftValue = entry.getValue();
            if (right.containsKey(leftKey)) {
                Object rightValue = onlyOnRight.remove(leftKey);
                if (valueEquivalence.equivalent(leftValue, rightValue)) {
                    onBoth.put(leftKey, leftValue);
                    continue;
                }
                eq = false;
                differences.put(leftKey, ValueDifferenceImpl.create(leftValue, rightValue));
                continue;
            }
            eq = false;
            onlyOnLeft.put(leftKey, leftValue);
        }
        boolean areEqual = eq && onlyOnRight.isEmpty();
        return Maps.mapDifference(areEqual, onlyOnLeft, onlyOnRight, onBoth, differences);
    }

    private static <K, V> MapDifference<K, V> mapDifference(boolean areEqual, Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, MapDifference.ValueDifference<V>> differences) {
        return new MapDifferenceImpl<K, V>(areEqual, Collections.unmodifiableMap(onlyOnLeft), Collections.unmodifiableMap(onlyOnRight), Collections.unmodifiableMap(onBoth), Collections.unmodifiableMap(differences));
    }

    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> left, Map<? extends K, ? extends V> right) {
        Preconditions.checkNotNull(left);
        Preconditions.checkNotNull(right);
        Comparator<K> comparator = Maps.orNaturalOrder(left.comparator());
        TreeMap<K, V> onlyOnLeft = Maps.newTreeMap(comparator);
        TreeMap<? extends K, ? extends V> onlyOnRight = Maps.newTreeMap(comparator);
        onlyOnRight.putAll(right);
        TreeMap<K, V> onBoth = Maps.newTreeMap(comparator);
        TreeMap<K, MapDifference.ValueDifference<V>> differences = Maps.newTreeMap(comparator);
        boolean eq = true;
        for (Map.Entry<K, V> entry : left.entrySet()) {
            K leftKey = entry.getKey();
            V leftValue = entry.getValue();
            if (right.containsKey(leftKey)) {
                Object rightValue = onlyOnRight.remove(leftKey);
                if (Objects.equal(leftValue, rightValue)) {
                    onBoth.put(leftKey, leftValue);
                    continue;
                }
                eq = false;
                differences.put(leftKey, ValueDifferenceImpl.create(leftValue, rightValue));
                continue;
            }
            eq = false;
            onlyOnLeft.put(leftKey, leftValue);
        }
        boolean areEqual = eq && onlyOnRight.isEmpty();
        return Maps.sortedMapDifference(areEqual, onlyOnLeft, onlyOnRight, onBoth, differences);
    }

    private static <K, V> SortedMapDifference<K, V> sortedMapDifference(boolean areEqual, SortedMap<K, V> onlyOnLeft, SortedMap<K, V> onlyOnRight, SortedMap<K, V> onBoth, SortedMap<K, MapDifference.ValueDifference<V>> differences) {
        return new SortedMapDifferenceImpl<K, V>(areEqual, Collections.unmodifiableSortedMap(onlyOnLeft), Collections.unmodifiableSortedMap(onlyOnRight), Collections.unmodifiableSortedMap(onBoth), Collections.unmodifiableSortedMap(differences));
    }

    static <E> Comparator<? super E> orNaturalOrder(@Nullable Comparator<? super E> comparator) {
        if (comparator != null) {
            return comparator;
        }
        return Ordering.natural();
    }

    @Beta
    public static <K, V> Map<K, V> asMap(Set<K> set, Function<? super K, V> function) {
        if (set instanceof SortedSet) {
            return Maps.asMap((SortedSet)set, function);
        }
        return new AsMapView<K, V>(set, function);
    }

    @Beta
    public static <K, V> SortedMap<K, V> asMap(SortedSet<K> set, Function<? super K, V> function) {
        return Platform.mapsAsMapSortedSet(set, function);
    }

    static <K, V> SortedMap<K, V> asMapSortedIgnoreNavigable(SortedSet<K> set, Function<? super K, V> function) {
        return new SortedAsMapView<K, V>(set, function);
    }

    @Beta
    @GwtIncompatible(value="NavigableMap")
    public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> set, Function<? super K, V> function) {
        return new NavigableAsMapView<K, V>(set, function);
    }

    private static <K, V> Iterator<Map.Entry<K, V>> asSetEntryIterator(Set<K> set, final Function<? super K, V> function) {
        return new TransformedIterator<K, Map.Entry<K, V>>(set.iterator()){

            @Override
            Map.Entry<K, V> transform(K key) {
                return Maps.immutableEntry(key, function.apply(key));
            }
        };
    }

    private static <E> Set<E> removeOnlySet(final Set<E> set) {
        return new ForwardingSet<E>(){

            @Override
            protected Set<E> delegate() {
                return set;
            }

            @Override
            public boolean add(E element) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean addAll(Collection<? extends E> es) {
                throw new UnsupportedOperationException();
            }
        };
    }

    private static <E> SortedSet<E> removeOnlySortedSet(final SortedSet<E> set) {
        return new ForwardingSortedSet<E>(){

            @Override
            protected SortedSet<E> delegate() {
                return set;
            }

            @Override
            public boolean add(E element) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean addAll(Collection<? extends E> es) {
                throw new UnsupportedOperationException();
            }

            @Override
            public SortedSet<E> headSet(E toElement) {
                return Maps.removeOnlySortedSet(super.headSet(toElement));
            }

            @Override
            public SortedSet<E> subSet(E fromElement, E toElement) {
                return Maps.removeOnlySortedSet(super.subSet(fromElement, toElement));
            }

            @Override
            public SortedSet<E> tailSet(E fromElement) {
                return Maps.removeOnlySortedSet(super.tailSet(fromElement));
            }
        };
    }

    @GwtIncompatible(value="NavigableSet")
    private static <E> NavigableSet<E> removeOnlyNavigableSet(final NavigableSet<E> set) {
        return new ForwardingNavigableSet<E>(){

            @Override
            protected NavigableSet<E> delegate() {
                return set;
            }

            @Override
            public boolean add(E element) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean addAll(Collection<? extends E> es) {
                throw new UnsupportedOperationException();
            }

            @Override
            public SortedSet<E> headSet(E toElement) {
                return Maps.removeOnlySortedSet(super.headSet(toElement));
            }

            @Override
            public SortedSet<E> subSet(E fromElement, E toElement) {
                return Maps.removeOnlySortedSet(super.subSet(fromElement, toElement));
            }

            @Override
            public SortedSet<E> tailSet(E fromElement) {
                return Maps.removeOnlySortedSet(super.tailSet(fromElement));
            }

            @Override
            public NavigableSet<E> headSet(E toElement, boolean inclusive) {
                return Maps.removeOnlyNavigableSet(super.headSet(toElement, inclusive));
            }

            @Override
            public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
                return Maps.removeOnlyNavigableSet(super.tailSet(fromElement, inclusive));
            }

            @Override
            public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
                return Maps.removeOnlyNavigableSet(super.subSet(fromElement, fromInclusive, toElement, toInclusive));
            }

            @Override
            public NavigableSet<E> descendingSet() {
                return Maps.removeOnlyNavigableSet(super.descendingSet());
            }
        };
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> keys2, Function<? super K, V> valueFunction) {
        return Maps.toMap(keys2.iterator(), valueFunction);
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> keys2, Function<? super K, V> valueFunction) {
        Preconditions.checkNotNull(valueFunction);
        LinkedHashMap<K, V> builder = Maps.newLinkedHashMap();
        while (keys2.hasNext()) {
            K key = keys2.next();
            builder.put(key, valueFunction.apply(key));
        }
        return ImmutableMap.copyOf(builder);
    }

    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> values2, Function<? super V, K> keyFunction) {
        return Maps.uniqueIndex(values2.iterator(), keyFunction);
    }

    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> values2, Function<? super V, K> keyFunction) {
        Preconditions.checkNotNull(keyFunction);
        ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
        while (values2.hasNext()) {
            V value = values2.next();
            builder.put(keyFunction.apply(value), value);
        }
        return builder.build();
    }

    @GwtIncompatible(value="java.util.Properties")
    public static ImmutableMap<String, String> fromProperties(Properties properties2) {
        ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
        Enumeration<?> e = properties2.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String)e.nextElement();
            builder.put(key, properties2.getProperty(key));
        }
        return builder.build();
    }

    @GwtCompatible(serializable=true)
    public static <K, V> Map.Entry<K, V> immutableEntry(@Nullable K key, @Nullable V value) {
        return new ImmutableEntry<K, V>(key, value);
    }

    static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> entrySet) {
        return new UnmodifiableEntrySet<K, V>(Collections.unmodifiableSet(entrySet));
    }

    static <K, V> Map.Entry<K, V> unmodifiableEntry(final Map.Entry<K, V> entry) {
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry<K, V>(){

            @Override
            public K getKey() {
                return entry.getKey();
            }

            @Override
            public V getValue() {
                return entry.getValue();
            }
        };
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> bimap) {
        return Synchronized.biMap(bimap, null);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> bimap) {
        return new UnmodifiableBiMap<K, V>(bimap, null);
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> fromMap, Function<? super V1, V2> function) {
        return Maps.transformEntries(fromMap, Maps.asEntryTransformer(function));
    }

    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> fromMap, Function<? super V1, V2> function) {
        return Maps.transformEntries(fromMap, Maps.asEntryTransformer(function));
    }

    @GwtIncompatible(value="NavigableMap")
    public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> fromMap, Function<? super V1, V2> function) {
        return Maps.transformEntries(fromMap, Maps.asEntryTransformer(function));
    }

    private static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(final Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return new EntryTransformer<K, V1, V2>(){

            @Override
            public V2 transformEntry(K key, V1 value) {
                return function.apply(value);
            }
        };
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        if (fromMap instanceof SortedMap) {
            return Maps.transformEntries((SortedMap)fromMap, transformer);
        }
        return new TransformedEntriesMap<K, V1, V2>(fromMap, transformer);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return Platform.mapsTransformEntriesSortedMap(fromMap, transformer);
    }

    @GwtIncompatible(value="NavigableMap")
    public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesNavigableMap<K, V1, V2>(fromMap, transformer);
    }

    static <K, V1, V2> SortedMap<K, V2> transformEntriesIgnoreNavigable(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesSortedMap<K, V1, V2>(fromMap, transformer);
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        if (unfiltered instanceof SortedMap) {
            return Maps.filterKeys((SortedMap)unfiltered, keyPredicate);
        }
        if (unfiltered instanceof BiMap) {
            return Maps.filterKeys((BiMap)unfiltered, keyPredicate);
        }
        Preconditions.checkNotNull(keyPredicate);
        KeyPredicate entryPredicate = new KeyPredicate(keyPredicate);
        return unfiltered instanceof AbstractFilteredMap ? Maps.filterFiltered((AbstractFilteredMap)unfiltered, entryPredicate) : new FilteredKeyMap<K, V>(Preconditions.checkNotNull(unfiltered), keyPredicate, entryPredicate);
    }

    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        return Maps.filterEntries(unfiltered, new KeyPredicate(keyPredicate));
    }

    @GwtIncompatible(value="NavigableMap")
    public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        return Maps.filterEntries(unfiltered, new KeyPredicate(keyPredicate));
    }

    public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        Preconditions.checkNotNull(keyPredicate);
        return Maps.filterEntries(unfiltered, new KeyPredicate(keyPredicate));
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        if (unfiltered instanceof SortedMap) {
            return Maps.filterValues((SortedMap)unfiltered, valuePredicate);
        }
        if (unfiltered instanceof BiMap) {
            return Maps.filterValues((BiMap)unfiltered, valuePredicate);
        }
        return Maps.filterEntries(unfiltered, new ValuePredicate(valuePredicate));
    }

    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        return Maps.filterEntries(unfiltered, new ValuePredicate(valuePredicate));
    }

    @GwtIncompatible(value="NavigableMap")
    public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        return Maps.filterEntries(unfiltered, new ValuePredicate(valuePredicate));
    }

    public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        return Maps.filterEntries(unfiltered, new ValuePredicate(valuePredicate));
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        if (unfiltered instanceof SortedMap) {
            return Maps.filterEntries((SortedMap)unfiltered, entryPredicate);
        }
        if (unfiltered instanceof BiMap) {
            return Maps.filterEntries((BiMap)unfiltered, entryPredicate);
        }
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof AbstractFilteredMap ? Maps.filterFiltered((AbstractFilteredMap)unfiltered, entryPredicate) : new FilteredEntryMap<K, V>(Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        return Platform.mapsFilterSortedMap(unfiltered, entryPredicate);
    }

    static <K, V> SortedMap<K, V> filterSortedIgnoreNavigable(SortedMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof FilteredEntrySortedMap ? Maps.filterFiltered((FilteredEntrySortedMap)unfiltered, entryPredicate) : new FilteredEntrySortedMap<K, V>(Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    @GwtIncompatible(value="NavigableMap")
    public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof FilteredEntryNavigableMap ? Maps.filterFiltered((FilteredEntryNavigableMap)unfiltered, entryPredicate) : new FilteredEntryNavigableMap<K, V>(Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(unfiltered);
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof FilteredEntryBiMap ? Maps.filterFiltered((FilteredEntryBiMap)unfiltered, entryPredicate) : new FilteredEntryBiMap<K, V>(unfiltered, entryPredicate);
    }

    private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> map2, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Predicate<? super Map.Entry<K, V>> predicate = Predicates.and(map2.predicate, entryPredicate);
        return new FilteredEntryMap(map2.unfiltered, predicate);
    }

    private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> map2, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Predicate<? super Map.Entry<K, V>> predicate = Predicates.and(map2.predicate, entryPredicate);
        return new FilteredEntrySortedMap<K, V>(map2.sortedMap(), predicate);
    }

    @GwtIncompatible(value="NavigableMap")
    private static <K, V> NavigableMap<K, V> filterFiltered(FilteredEntryNavigableMap<K, V> map2, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Predicate<? super Map.Entry<K, V>> predicate = Predicates.and(map2.predicate, entryPredicate);
        return new FilteredEntryNavigableMap(map2.sortedMap(), predicate);
    }

    private static <K, V> BiMap<K, V> filterFiltered(FilteredEntryBiMap<K, V> map2, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Predicate<? super Map.Entry<K, V>> predicate = Predicates.and(map2.predicate, entryPredicate);
        return new FilteredEntryBiMap<K, V>(map2.unfiltered(), predicate);
    }

    @GwtIncompatible(value="NavigableMap")
    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, V> map2) {
        Preconditions.checkNotNull(map2);
        if (map2 instanceof UnmodifiableNavigableMap) {
            return map2;
        }
        return new UnmodifiableNavigableMap<K, V>(map2);
    }

    @Nullable
    private static <K, V> Map.Entry<K, V> unmodifiableOrNull(@Nullable Map.Entry<K, V> entry) {
        return entry == null ? null : Maps.unmodifiableEntry(entry);
    }

    @GwtIncompatible(value="NavigableMap")
    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> navigableMap) {
        return Synchronized.navigableMap(navigableMap);
    }

    static <V> V safeGet(Map<?, V> map2, Object key) {
        Preconditions.checkNotNull(map2);
        try {
            return map2.get(key);
        }
        catch (ClassCastException e) {
            return null;
        }
        catch (NullPointerException e) {
            return null;
        }
    }

    static boolean safeContainsKey(Map<?, ?> map2, Object key) {
        Preconditions.checkNotNull(map2);
        try {
            return map2.containsKey(key);
        }
        catch (ClassCastException e) {
            return false;
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    static <V> V safeRemove(Map<?, V> map2, Object key) {
        Preconditions.checkNotNull(map2);
        try {
            return map2.remove(key);
        }
        catch (ClassCastException e) {
            return null;
        }
        catch (NullPointerException e) {
            return null;
        }
    }

    static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> c, Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        return c.contains(Maps.unmodifiableEntry((Map.Entry)o));
    }

    static <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> c, Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        return c.remove(Maps.unmodifiableEntry((Map.Entry)o));
    }

    static boolean equalsImpl(Map<?, ?> map2, Object object) {
        if (map2 == object) {
            return true;
        }
        if (object instanceof Map) {
            Map o = (Map)object;
            return map2.entrySet().equals(o.entrySet());
        }
        return false;
    }

    static String toStringImpl(Map<?, ?> map2) {
        StringBuilder sb = Collections2.newStringBuilderForCollection(map2.size()).append('{');
        STANDARD_JOINER.appendTo(sb, map2);
        return sb.append('}').toString();
    }

    static <K, V> void putAllImpl(Map<K, V> self, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            self.put(entry.getKey(), entry.getValue());
        }
    }

    static boolean containsKeyImpl(Map<?, ?> map2, @Nullable Object key) {
        return Iterators.contains(Maps.keyIterator(map2.entrySet().iterator()), key);
    }

    static boolean containsValueImpl(Map<?, ?> map2, @Nullable Object value) {
        return Iterators.contains(Maps.valueIterator(map2.entrySet().iterator()), value);
    }

    static <K, V> Iterator<K> keyIterator(Iterator<Map.Entry<K, V>> entryIterator) {
        return new TransformedIterator<Map.Entry<K, V>, K>(entryIterator){

            @Override
            K transform(Map.Entry<K, V> entry) {
                return entry.getKey();
            }
        };
    }

    @Nullable
    static <K> K keyOrNull(@Nullable Map.Entry<K, ?> entry) {
        return entry == null ? null : (K)entry.getKey();
    }

    @Nullable
    static <V> V valueOrNull(@Nullable Map.Entry<?, V> entry) {
        return entry == null ? null : (V)entry.getValue();
    }

    static <K, V> Iterator<V> valueIterator(Iterator<Map.Entry<K, V>> entryIterator) {
        return new TransformedIterator<Map.Entry<K, V>, V>(entryIterator){

            @Override
            V transform(Map.Entry<K, V> entry) {
                return entry.getValue();
            }
        };
    }

    static <K, V> UnmodifiableIterator<V> valueIterator(final UnmodifiableIterator<Map.Entry<K, V>> entryIterator) {
        return new UnmodifiableIterator<V>(){

            @Override
            public boolean hasNext() {
                return entryIterator.hasNext();
            }

            @Override
            public V next() {
                return ((Map.Entry)entryIterator.next()).getValue();
            }
        };
    }

    @GwtIncompatible(value="NavigableMap")
    static abstract class DescendingMap<K, V>
    extends ForwardingMap<K, V>
    implements NavigableMap<K, V> {
        private transient Comparator<? super K> comparator;
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient NavigableSet<K> navigableKeySet;

        DescendingMap() {
        }

        abstract NavigableMap<K, V> forward();

        @Override
        protected final Map<K, V> delegate() {
            return this.forward();
        }

        @Override
        public Comparator<? super K> comparator() {
            Comparator<? super K> result2 = this.comparator;
            if (result2 == null) {
                Comparator forwardCmp = this.forward().comparator();
                if (forwardCmp == null) {
                    forwardCmp = Ordering.natural();
                }
                result2 = this.comparator = DescendingMap.reverse(forwardCmp);
            }
            return result2;
        }

        private static <T> Ordering<T> reverse(Comparator<T> forward) {
            return Ordering.from(forward).reverse();
        }

        @Override
        public K firstKey() {
            return this.forward().lastKey();
        }

        @Override
        public K lastKey() {
            return this.forward().firstKey();
        }

        @Override
        public Map.Entry<K, V> lowerEntry(K key) {
            return this.forward().higherEntry(key);
        }

        @Override
        public K lowerKey(K key) {
            return this.forward().higherKey(key);
        }

        @Override
        public Map.Entry<K, V> floorEntry(K key) {
            return this.forward().ceilingEntry(key);
        }

        @Override
        public K floorKey(K key) {
            return this.forward().ceilingKey(key);
        }

        @Override
        public Map.Entry<K, V> ceilingEntry(K key) {
            return this.forward().floorEntry(key);
        }

        @Override
        public K ceilingKey(K key) {
            return this.forward().floorKey(key);
        }

        @Override
        public Map.Entry<K, V> higherEntry(K key) {
            return this.forward().lowerEntry(key);
        }

        @Override
        public K higherKey(K key) {
            return this.forward().lowerKey(key);
        }

        @Override
        public Map.Entry<K, V> firstEntry() {
            return this.forward().lastEntry();
        }

        @Override
        public Map.Entry<K, V> lastEntry() {
            return this.forward().firstEntry();
        }

        @Override
        public Map.Entry<K, V> pollFirstEntry() {
            return this.forward().pollLastEntry();
        }

        @Override
        public Map.Entry<K, V> pollLastEntry() {
            return this.forward().pollFirstEntry();
        }

        @Override
        public NavigableMap<K, V> descendingMap() {
            return this.forward();
        }

        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> result2 = this.entrySet;
            return result2 == null ? (this.entrySet = this.createEntrySet()) : result2;
        }

        abstract Iterator<Map.Entry<K, V>> entryIterator();

        Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet<K, V>(){

                @Override
                Map<K, V> map() {
                    return DescendingMap.this;
                }

                @Override
                public Iterator<Map.Entry<K, V>> iterator() {
                    return DescendingMap.this.entryIterator();
                }
            };
        }

        @Override
        public Set<K> keySet() {
            return this.navigableKeySet();
        }

        @Override
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> result2 = this.navigableKeySet;
            return result2 == null ? (this.navigableKeySet = new NavigableKeySet(this)) : result2;
        }

        @Override
        public NavigableSet<K> descendingKeySet() {
            return this.forward().navigableKeySet();
        }

        @Override
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return this.forward().subMap(toKey, toInclusive, fromKey, fromInclusive).descendingMap();
        }

        @Override
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return this.forward().tailMap(toKey, inclusive).descendingMap();
        }

        @Override
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return this.forward().headMap(fromKey, inclusive).descendingMap();
        }

        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return this.subMap(fromKey, true, toKey, false);
        }

        @Override
        public SortedMap<K, V> headMap(K toKey) {
            return this.headMap(toKey, false);
        }

        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            return this.tailMap(fromKey, true);
        }

        @Override
        public Collection<V> values() {
            return new Values<K, V>(){

                @Override
                Map<K, V> map() {
                    return DescendingMap.this;
                }
            };
        }
    }

    static abstract class EntrySet<K, V>
    extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        abstract Map<K, V> map();

        @Override
        public int size() {
            return this.map().size();
        }

        @Override
        public void clear() {
            this.map().clear();
        }

        @Override
        public boolean contains(Object o) {
            if (o instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)o;
                Object key = entry.getKey();
                V value = this.map().get(key);
                return Objects.equal(value, entry.getValue()) && (value != null || this.map().containsKey(key));
            }
            return false;
        }

        @Override
        public boolean isEmpty() {
            return this.map().isEmpty();
        }

        @Override
        public boolean remove(Object o) {
            if (this.contains(o)) {
                Map.Entry entry = (Map.Entry)o;
                return this.map().keySet().remove(entry.getKey());
            }
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            try {
                return super.removeAll(Preconditions.checkNotNull(c));
            }
            catch (UnsupportedOperationException e) {
                boolean changed = true;
                for (Object o : c) {
                    changed |= this.remove(o);
                }
                return changed;
            }
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            try {
                return super.retainAll(Preconditions.checkNotNull(c));
            }
            catch (UnsupportedOperationException e) {
                HashSet keys2 = Sets.newHashSetWithExpectedSize(c.size());
                for (Object o : c) {
                    if (!this.contains(o)) continue;
                    Map.Entry entry = (Map.Entry)o;
                    keys2.add(entry.getKey());
                }
                return this.map().keySet().retainAll(keys2);
            }
        }
    }

    static abstract class Values<K, V>
    extends AbstractCollection<V> {
        Values() {
        }

        abstract Map<K, V> map();

        @Override
        public Iterator<V> iterator() {
            return Maps.valueIterator(this.map().entrySet().iterator());
        }

        @Override
        public boolean remove(Object o) {
            try {
                return super.remove(o);
            }
            catch (UnsupportedOperationException e) {
                for (Map.Entry<K, V> entry : this.map().entrySet()) {
                    if (!Objects.equal(o, entry.getValue())) continue;
                    this.map().remove(entry.getKey());
                    return true;
                }
                return false;
            }
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            try {
                return super.removeAll(Preconditions.checkNotNull(c));
            }
            catch (UnsupportedOperationException e) {
                HashSet<K> toRemove = Sets.newHashSet();
                for (Map.Entry<K, V> entry : this.map().entrySet()) {
                    if (!c.contains(entry.getValue())) continue;
                    toRemove.add(entry.getKey());
                }
                return this.map().keySet().removeAll(toRemove);
            }
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            try {
                return super.retainAll(Preconditions.checkNotNull(c));
            }
            catch (UnsupportedOperationException e) {
                HashSet<K> toRetain = Sets.newHashSet();
                for (Map.Entry<K, V> entry : this.map().entrySet()) {
                    if (!c.contains(entry.getValue())) continue;
                    toRetain.add(entry.getKey());
                }
                return this.map().keySet().retainAll(toRetain);
            }
        }

        @Override
        public int size() {
            return this.map().size();
        }

        @Override
        public boolean isEmpty() {
            return this.map().isEmpty();
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return this.map().containsValue(o);
        }

        @Override
        public void clear() {
            this.map().clear();
        }
    }

    @GwtIncompatible(value="NavigableMap")
    static class NavigableKeySet<K, V>
    extends KeySet<K, V>
    implements NavigableSet<K> {
        private final NavigableMap<K, V> map;

        NavigableKeySet(NavigableMap<K, V> map2) {
            this.map = Preconditions.checkNotNull(map2);
        }

        @Override
        NavigableMap<K, V> map() {
            return this.map;
        }

        @Override
        public Comparator<? super K> comparator() {
            return this.map().comparator();
        }

        @Override
        public K first() {
            return this.map().firstKey();
        }

        @Override
        public K last() {
            return this.map().lastKey();
        }

        @Override
        public K lower(K e) {
            return this.map().lowerKey(e);
        }

        @Override
        public K floor(K e) {
            return this.map().floorKey(e);
        }

        @Override
        public K ceiling(K e) {
            return this.map().ceilingKey(e);
        }

        @Override
        public K higher(K e) {
            return this.map().higherKey(e);
        }

        @Override
        public K pollFirst() {
            return Maps.keyOrNull(this.map().pollFirstEntry());
        }

        @Override
        public K pollLast() {
            return Maps.keyOrNull(this.map().pollLastEntry());
        }

        @Override
        public NavigableSet<K> descendingSet() {
            return this.map().descendingKeySet();
        }

        @Override
        public Iterator<K> descendingIterator() {
            return this.descendingSet().iterator();
        }

        @Override
        public NavigableSet<K> subSet(K fromElement, boolean fromInclusive, K toElement, boolean toInclusive) {
            return this.map().subMap(fromElement, fromInclusive, toElement, toInclusive).navigableKeySet();
        }

        @Override
        public NavigableSet<K> headSet(K toElement, boolean inclusive) {
            return this.map().headMap(toElement, inclusive).navigableKeySet();
        }

        @Override
        public NavigableSet<K> tailSet(K fromElement, boolean inclusive) {
            return this.map().tailMap(fromElement, inclusive).navigableKeySet();
        }

        @Override
        public SortedSet<K> subSet(K fromElement, K toElement) {
            return this.subSet(fromElement, true, toElement, false);
        }

        @Override
        public SortedSet<K> headSet(K toElement) {
            return this.headSet(toElement, false);
        }

        @Override
        public SortedSet<K> tailSet(K fromElement) {
            return this.tailSet(fromElement, true);
        }
    }

    static abstract class KeySet<K, V>
    extends Sets.ImprovedAbstractSet<K> {
        KeySet() {
        }

        abstract Map<K, V> map();

        @Override
        public Iterator<K> iterator() {
            return Maps.keyIterator(this.map().entrySet().iterator());
        }

        @Override
        public int size() {
            return this.map().size();
        }

        @Override
        public boolean isEmpty() {
            return this.map().isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return this.map().containsKey(o);
        }

        @Override
        public boolean remove(Object o) {
            if (this.contains(o)) {
                this.map().remove(o);
                return true;
            }
            return false;
        }

        @Override
        public void clear() {
            this.map().clear();
        }
    }

    @GwtCompatible
    static abstract class ImprovedAbstractMap<K, V>
    extends AbstractMap<K, V> {
        private Set<Map.Entry<K, V>> entrySet;
        private Set<K> keySet;
        private Collection<V> values;

        ImprovedAbstractMap() {
        }

        protected abstract Set<Map.Entry<K, V>> createEntrySet();

        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> result2 = this.entrySet;
            if (result2 == null) {
                this.entrySet = result2 = this.createEntrySet();
            }
            return result2;
        }

        @Override
        public Set<K> keySet() {
            Set<K> result2 = this.keySet;
            if (result2 == null) {
                this.keySet = new KeySet<K, V>(){

                    @Override
                    Map<K, V> map() {
                        return ImprovedAbstractMap.this;
                    }
                };
                return this.keySet;
            }
            return result2;
        }

        @Override
        public Collection<V> values() {
            Collection<V> result2 = this.values;
            if (result2 == null) {
                this.values = new Values<K, V>(){

                    @Override
                    Map<K, V> map() {
                        return ImprovedAbstractMap.this;
                    }
                };
                return this.values;
            }
            return result2;
        }
    }

    @GwtIncompatible(value="NavigableMap")
    static class UnmodifiableNavigableMap<K, V>
    extends ForwardingSortedMap<K, V>
    implements NavigableMap<K, V>,
    Serializable {
        private final NavigableMap<K, V> delegate;
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        UnmodifiableNavigableMap(NavigableMap<K, V> delegate) {
            this.delegate = delegate;
        }

        @Override
        protected SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }

        @Override
        public Map.Entry<K, V> lowerEntry(K key) {
            return Maps.unmodifiableOrNull(this.delegate.lowerEntry(key));
        }

        @Override
        public K lowerKey(K key) {
            return this.delegate.lowerKey(key);
        }

        @Override
        public Map.Entry<K, V> floorEntry(K key) {
            return Maps.unmodifiableOrNull(this.delegate.floorEntry(key));
        }

        @Override
        public K floorKey(K key) {
            return this.delegate.floorKey(key);
        }

        @Override
        public Map.Entry<K, V> ceilingEntry(K key) {
            return Maps.unmodifiableOrNull(this.delegate.ceilingEntry(key));
        }

        @Override
        public K ceilingKey(K key) {
            return this.delegate.ceilingKey(key);
        }

        @Override
        public Map.Entry<K, V> higherEntry(K key) {
            return Maps.unmodifiableOrNull(this.delegate.higherEntry(key));
        }

        @Override
        public K higherKey(K key) {
            return this.delegate.higherKey(key);
        }

        @Override
        public Map.Entry<K, V> firstEntry() {
            return Maps.unmodifiableOrNull(this.delegate.firstEntry());
        }

        @Override
        public Map.Entry<K, V> lastEntry() {
            return Maps.unmodifiableOrNull(this.delegate.lastEntry());
        }

        @Override
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> result2 = this.descendingMap;
            if (result2 == null) {
                this.descendingMap = result2 = new UnmodifiableNavigableMap<K, V>(this.delegate.descendingMap());
                result2.descendingMap = this;
            }
            return result2;
        }

        @Override
        public Set<K> keySet() {
            return this.navigableKeySet();
        }

        @Override
        public NavigableSet<K> navigableKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
        }

        @Override
        public NavigableSet<K> descendingKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
        }

        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return this.subMap(fromKey, true, toKey, false);
        }

        @Override
        public SortedMap<K, V> headMap(K toKey) {
            return this.headMap(toKey, false);
        }

        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            return this.tailMap(fromKey, true);
        }

        @Override
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return Maps.unmodifiableNavigableMap(this.delegate.subMap(fromKey, fromInclusive, toKey, toInclusive));
        }

        @Override
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return Maps.unmodifiableNavigableMap(this.delegate.headMap(toKey, inclusive));
        }

        @Override
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return Maps.unmodifiableNavigableMap(this.delegate.tailMap(fromKey, inclusive));
        }
    }

    static class FilteredEntryMap<K, V>
    extends AbstractFilteredMap<K, V> {
        final Set<Map.Entry<K, V>> filteredEntrySet;
        Set<Map.Entry<K, V>> entrySet;
        Set<K> keySet;

        FilteredEntryMap(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
            this.filteredEntrySet = Sets.filter(unfiltered.entrySet(), this.predicate);
        }

        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            EntrySet result2 = this.entrySet;
            return result2 == null ? (this.entrySet = new EntrySet()) : result2;
        }

        @Override
        public Set<K> keySet() {
            Set<K> result2 = this.keySet;
            return result2 == null ? (this.keySet = this.createKeySet()) : result2;
        }

        Set<K> createKeySet() {
            return new KeySet();
        }

        private class KeySet
        extends Sets.ImprovedAbstractSet<K> {
            private KeySet() {
            }

            @Override
            public Iterator<K> iterator() {
                final Iterator iterator2 = FilteredEntryMap.this.filteredEntrySet.iterator();
                return new UnmodifiableIterator<K>(){

                    @Override
                    public boolean hasNext() {
                        return iterator2.hasNext();
                    }

                    @Override
                    public K next() {
                        return ((Map.Entry)iterator2.next()).getKey();
                    }
                };
            }

            @Override
            public int size() {
                return FilteredEntryMap.this.filteredEntrySet.size();
            }

            @Override
            public void clear() {
                FilteredEntryMap.this.filteredEntrySet.clear();
            }

            @Override
            public boolean contains(Object o) {
                return FilteredEntryMap.this.containsKey(o);
            }

            @Override
            public boolean remove(Object o) {
                if (FilteredEntryMap.this.containsKey(o)) {
                    FilteredEntryMap.this.unfiltered.remove(o);
                    return true;
                }
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                boolean changed = false;
                Iterator iterator2 = FilteredEntryMap.this.unfiltered.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry entry = iterator2.next();
                    if (!FilteredEntryMap.this.predicate.apply(entry) || collection.contains(entry.getKey())) continue;
                    iterator2.remove();
                    changed = true;
                }
                return changed;
            }

            @Override
            public Object[] toArray() {
                return Lists.newArrayList(this.iterator()).toArray();
            }

            @Override
            public <T> T[] toArray(T[] array) {
                return Lists.newArrayList(this.iterator()).toArray(array);
            }
        }

        private class EntrySet
        extends ForwardingSet<Map.Entry<K, V>> {
            private EntrySet() {
            }

            @Override
            protected Set<Map.Entry<K, V>> delegate() {
                return FilteredEntryMap.this.filteredEntrySet;
            }

            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                final Iterator iterator2 = FilteredEntryMap.this.filteredEntrySet.iterator();
                return new UnmodifiableIterator<Map.Entry<K, V>>(){

                    @Override
                    public boolean hasNext() {
                        return iterator2.hasNext();
                    }

                    @Override
                    public Map.Entry<K, V> next() {
                        final Map.Entry entry = (Map.Entry)iterator2.next();
                        return new ForwardingMapEntry<K, V>(){

                            @Override
                            protected Map.Entry<K, V> delegate() {
                                return entry;
                            }

                            @Override
                            public V setValue(V value) {
                                Preconditions.checkArgument(FilteredEntryMap.this.apply(entry.getKey(), value));
                                return super.setValue(value);
                            }
                        };
                    }
                };
            }
        }
    }

    private static class FilteredKeyMap<K, V>
    extends AbstractFilteredMap<K, V> {
        Predicate<? super K> keyPredicate;
        Set<Map.Entry<K, V>> entrySet;
        Set<K> keySet;

        FilteredKeyMap(Map<K, V> unfiltered, Predicate<? super K> keyPredicate, Predicate<Map.Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
            this.keyPredicate = keyPredicate;
        }

        @Override
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> result2 = this.entrySet;
            return result2 == null ? (this.entrySet = Sets.filter(this.unfiltered.entrySet(), this.predicate)) : result2;
        }

        @Override
        public Set<K> keySet() {
            Set<K> result2 = this.keySet;
            return result2 == null ? (this.keySet = Sets.filter(this.unfiltered.keySet(), this.keyPredicate)) : result2;
        }

        @Override
        public boolean containsKey(Object key) {
            return this.unfiltered.containsKey(key) && this.keyPredicate.apply(key);
        }
    }

    static final class FilteredEntryBiMap<K, V>
    extends FilteredEntryMap<K, V>
    implements BiMap<K, V> {
        private final BiMap<V, K> inverse;

        private static <K, V> Predicate<Map.Entry<V, K>> inversePredicate(final Predicate<? super Map.Entry<K, V>> forwardPredicate) {
            return new Predicate<Map.Entry<V, K>>(){

                @Override
                public boolean apply(Map.Entry<V, K> input) {
                    return forwardPredicate.apply(Maps.immutableEntry(input.getValue(), input.getKey()));
                }
            };
        }

        FilteredEntryBiMap(BiMap<K, V> delegate, Predicate<? super Map.Entry<K, V>> predicate) {
            super(delegate, predicate);
            this.inverse = new FilteredEntryBiMap<K, V>(delegate.inverse(), FilteredEntryBiMap.inversePredicate(predicate), this);
        }

        private FilteredEntryBiMap(BiMap<K, V> delegate, Predicate<? super Map.Entry<K, V>> predicate, BiMap<V, K> inverse) {
            super(delegate, predicate);
            this.inverse = inverse;
        }

        BiMap<K, V> unfiltered() {
            return (BiMap)this.unfiltered;
        }

        @Override
        public V forcePut(@Nullable K key, @Nullable V value) {
            Preconditions.checkArgument(this.predicate.apply(Maps.immutableEntry(key, value)));
            return this.unfiltered().forcePut(key, value);
        }

        @Override
        public BiMap<V, K> inverse() {
            return this.inverse;
        }

        @Override
        public Set<V> values() {
            return this.inverse.keySet();
        }
    }

    @GwtIncompatible(value="NavigableMap")
    private static class FilteredEntryNavigableMap<K, V>
    extends FilteredEntrySortedMap<K, V>
    implements NavigableMap<K, V> {
        FilteredEntryNavigableMap(NavigableMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
        }

        @Override
        NavigableMap<K, V> sortedMap() {
            return (NavigableMap)super.sortedMap();
        }

        @Override
        public Map.Entry<K, V> lowerEntry(K key) {
            return this.headMap(key, false).lastEntry();
        }

        @Override
        public K lowerKey(K key) {
            return Maps.keyOrNull(this.lowerEntry(key));
        }

        @Override
        public Map.Entry<K, V> floorEntry(K key) {
            return this.headMap(key, true).lastEntry();
        }

        @Override
        public K floorKey(K key) {
            return Maps.keyOrNull(this.floorEntry(key));
        }

        @Override
        public Map.Entry<K, V> ceilingEntry(K key) {
            return this.tailMap(key, true).firstEntry();
        }

        @Override
        public K ceilingKey(K key) {
            return Maps.keyOrNull(this.ceilingEntry(key));
        }

        @Override
        public Map.Entry<K, V> higherEntry(K key) {
            return this.tailMap(key, false).firstEntry();
        }

        @Override
        public K higherKey(K key) {
            return Maps.keyOrNull(this.higherEntry(key));
        }

        @Override
        public Map.Entry<K, V> firstEntry() {
            return Iterables.getFirst(this.entrySet(), null);
        }

        @Override
        public Map.Entry<K, V> lastEntry() {
            return Iterables.getFirst(this.descendingMap().entrySet(), null);
        }

        @Override
        public Map.Entry<K, V> pollFirstEntry() {
            return this.pollFirstSatisfyingEntry(this.sortedMap().entrySet().iterator());
        }

        @Override
        public Map.Entry<K, V> pollLastEntry() {
            return this.pollFirstSatisfyingEntry(this.sortedMap().descendingMap().entrySet().iterator());
        }

        @Nullable
        Map.Entry<K, V> pollFirstSatisfyingEntry(Iterator<Map.Entry<K, V>> entryIterator) {
            while (entryIterator.hasNext()) {
                Map.Entry<K, V> entry = entryIterator.next();
                if (!this.predicate.apply(entry)) continue;
                entryIterator.remove();
                return entry;
            }
            return null;
        }

        @Override
        public NavigableMap<K, V> descendingMap() {
            return Maps.filterEntries(this.sortedMap().descendingMap(), this.predicate);
        }

        @Override
        public NavigableSet<K> keySet() {
            return (NavigableSet)super.keySet();
        }

        @Override
        NavigableSet<K> createKeySet() {
            return new NavigableKeySet<K, V>(this){

                @Override
                public boolean removeAll(Collection<?> c) {
                    boolean changed = false;
                    Iterator entryIterator = FilteredEntryNavigableMap.this.sortedMap().entrySet().iterator();
                    while (entryIterator.hasNext()) {
                        Map.Entry entry = entryIterator.next();
                        if (!c.contains(entry.getKey()) || !FilteredEntryNavigableMap.this.predicate.apply(entry)) continue;
                        entryIterator.remove();
                        changed = true;
                    }
                    return changed;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    boolean changed = false;
                    Iterator entryIterator = FilteredEntryNavigableMap.this.sortedMap().entrySet().iterator();
                    while (entryIterator.hasNext()) {
                        Map.Entry entry = entryIterator.next();
                        if (c.contains(entry.getKey()) || !FilteredEntryNavigableMap.this.predicate.apply(entry)) continue;
                        entryIterator.remove();
                        changed = true;
                    }
                    return changed;
                }
            };
        }

        @Override
        public NavigableSet<K> navigableKeySet() {
            return this.keySet();
        }

        @Override
        public NavigableSet<K> descendingKeySet() {
            return this.descendingMap().navigableKeySet();
        }

        @Override
        public NavigableMap<K, V> subMap(K fromKey, K toKey) {
            return this.subMap(fromKey, true, toKey, false);
        }

        @Override
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return Maps.filterEntries(this.sortedMap().subMap(fromKey, fromInclusive, toKey, toInclusive), this.predicate);
        }

        @Override
        public NavigableMap<K, V> headMap(K toKey) {
            return this.headMap(toKey, false);
        }

        @Override
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return Maps.filterEntries(this.sortedMap().headMap(toKey, inclusive), this.predicate);
        }

        @Override
        public NavigableMap<K, V> tailMap(K fromKey) {
            return this.tailMap(fromKey, true);
        }

        @Override
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return Maps.filterEntries(this.sortedMap().tailMap(fromKey, inclusive), this.predicate);
        }
    }

    private static class FilteredEntrySortedMap<K, V>
    extends FilteredEntryMap<K, V>
    implements SortedMap<K, V> {
        FilteredEntrySortedMap(SortedMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
        }

        SortedMap<K, V> sortedMap() {
            return (SortedMap)this.unfiltered;
        }

        @Override
        public Comparator<? super K> comparator() {
            return this.sortedMap().comparator();
        }

        @Override
        public K firstKey() {
            return this.keySet().iterator().next();
        }

        @Override
        public K lastKey() {
            SortedMap<K, V> headMap = this.sortedMap();
            K key;
            while (!this.apply(key = headMap.lastKey(), this.unfiltered.get(key))) {
                headMap = this.sortedMap().headMap(key);
            }
            return key;
        }

        @Override
        public SortedMap<K, V> headMap(K toKey) {
            return new FilteredEntrySortedMap<K, V>(this.sortedMap().headMap(toKey), this.predicate);
        }

        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return new FilteredEntrySortedMap<K, V>(this.sortedMap().subMap(fromKey, toKey), this.predicate);
        }

        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            return new FilteredEntrySortedMap<K, V>(this.sortedMap().tailMap(fromKey), this.predicate);
        }
    }

    private static abstract class AbstractFilteredMap<K, V>
    extends AbstractMap<K, V> {
        final Map<K, V> unfiltered;
        final Predicate<? super Map.Entry<K, V>> predicate;
        Collection<V> values;

        AbstractFilteredMap(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> predicate) {
            this.unfiltered = unfiltered;
            this.predicate = predicate;
        }

        boolean apply(Object key, V value) {
            Object k = key;
            return this.predicate.apply(Maps.immutableEntry(k, value));
        }

        @Override
        public V put(K key, V value) {
            Preconditions.checkArgument(this.apply(key, value));
            return this.unfiltered.put(key, value);
        }

        @Override
        public void putAll(Map<? extends K, ? extends V> map2) {
            for (Map.Entry<K, V> entry : map2.entrySet()) {
                Preconditions.checkArgument(this.apply(entry.getKey(), entry.getValue()));
            }
            this.unfiltered.putAll(map2);
        }

        @Override
        public boolean containsKey(Object key) {
            return this.unfiltered.containsKey(key) && this.apply(key, this.unfiltered.get(key));
        }

        @Override
        public V get(Object key) {
            V value = this.unfiltered.get(key);
            return value != null && this.apply(key, value) ? (V)value : null;
        }

        @Override
        public boolean isEmpty() {
            return this.entrySet().isEmpty();
        }

        @Override
        public V remove(Object key) {
            return this.containsKey(key) ? (V)this.unfiltered.remove(key) : null;
        }

        @Override
        public Collection<V> values() {
            Values result2 = this.values;
            return result2 == null ? (this.values = new Values()) : result2;
        }

        class Values
        extends AbstractCollection<V> {
            Values() {
            }

            @Override
            public Iterator<V> iterator() {
                final Iterator entryIterator = AbstractFilteredMap.this.entrySet().iterator();
                return new UnmodifiableIterator<V>(){

                    @Override
                    public boolean hasNext() {
                        return entryIterator.hasNext();
                    }

                    @Override
                    public V next() {
                        return ((Map.Entry)entryIterator.next()).getValue();
                    }
                };
            }

            @Override
            public int size() {
                return AbstractFilteredMap.this.entrySet().size();
            }

            @Override
            public void clear() {
                AbstractFilteredMap.this.entrySet().clear();
            }

            @Override
            public boolean isEmpty() {
                return AbstractFilteredMap.this.entrySet().isEmpty();
            }

            @Override
            public boolean remove(Object o) {
                Iterator iterator2 = AbstractFilteredMap.this.unfiltered.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry entry = iterator2.next();
                    if (!Objects.equal(o, entry.getValue()) || !AbstractFilteredMap.this.predicate.apply(entry)) continue;
                    iterator2.remove();
                    return true;
                }
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                boolean changed = false;
                Iterator iterator2 = AbstractFilteredMap.this.unfiltered.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry entry = iterator2.next();
                    if (!collection.contains(entry.getValue()) || !AbstractFilteredMap.this.predicate.apply(entry)) continue;
                    iterator2.remove();
                    changed = true;
                }
                return changed;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                Preconditions.checkNotNull(collection);
                boolean changed = false;
                Iterator iterator2 = AbstractFilteredMap.this.unfiltered.entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry entry = iterator2.next();
                    if (collection.contains(entry.getValue()) || !AbstractFilteredMap.this.predicate.apply(entry)) continue;
                    iterator2.remove();
                    changed = true;
                }
                return changed;
            }

            @Override
            public Object[] toArray() {
                return Lists.newArrayList(this.iterator()).toArray();
            }

            @Override
            public <T> T[] toArray(T[] array) {
                return Lists.newArrayList(this.iterator()).toArray(array);
            }
        }
    }

    private static final class ValuePredicate<K, V>
    implements Predicate<Map.Entry<K, V>> {
        private final Predicate<? super V> valuePredicate;

        ValuePredicate(Predicate<? super V> valuePredicate) {
            this.valuePredicate = Preconditions.checkNotNull(valuePredicate);
        }

        @Override
        public boolean apply(Map.Entry<K, V> input) {
            return this.valuePredicate.apply(input.getValue());
        }
    }

    private static final class KeyPredicate<K, V>
    implements Predicate<Map.Entry<K, V>> {
        private final Predicate<? super K> keyPredicate;

        KeyPredicate(Predicate<? super K> keyPredicate) {
            this.keyPredicate = Preconditions.checkNotNull(keyPredicate);
        }

        @Override
        public boolean apply(Map.Entry<K, V> input) {
            return this.keyPredicate.apply(input.getKey());
        }
    }

    @GwtIncompatible(value="NavigableMap")
    private static class TransformedEntriesNavigableMap<K, V1, V2>
    extends TransformedEntriesSortedMap<K, V1, V2>
    implements NavigableMap<K, V2> {
        TransformedEntriesNavigableMap(NavigableMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            super(fromMap, transformer);
        }

        @Override
        public Map.Entry<K, V2> ceilingEntry(K key) {
            return this.transformEntry(this.fromMap().ceilingEntry(key));
        }

        @Override
        public K ceilingKey(K key) {
            return this.fromMap().ceilingKey(key);
        }

        @Override
        public NavigableSet<K> descendingKeySet() {
            return this.fromMap().descendingKeySet();
        }

        @Override
        public NavigableMap<K, V2> descendingMap() {
            return Maps.transformEntries(this.fromMap().descendingMap(), this.transformer);
        }

        @Override
        public Map.Entry<K, V2> firstEntry() {
            return this.transformEntry(this.fromMap().firstEntry());
        }

        @Override
        public Map.Entry<K, V2> floorEntry(K key) {
            return this.transformEntry(this.fromMap().floorEntry(key));
        }

        @Override
        public K floorKey(K key) {
            return this.fromMap().floorKey(key);
        }

        @Override
        public NavigableMap<K, V2> headMap(K toKey) {
            return this.headMap(toKey, false);
        }

        @Override
        public NavigableMap<K, V2> headMap(K toKey, boolean inclusive) {
            return Maps.transformEntries(this.fromMap().headMap(toKey, inclusive), this.transformer);
        }

        @Override
        public Map.Entry<K, V2> higherEntry(K key) {
            return this.transformEntry(this.fromMap().higherEntry(key));
        }

        @Override
        public K higherKey(K key) {
            return this.fromMap().higherKey(key);
        }

        @Override
        public Map.Entry<K, V2> lastEntry() {
            return this.transformEntry(this.fromMap().lastEntry());
        }

        @Override
        public Map.Entry<K, V2> lowerEntry(K key) {
            return this.transformEntry(this.fromMap().lowerEntry(key));
        }

        @Override
        public K lowerKey(K key) {
            return this.fromMap().lowerKey(key);
        }

        @Override
        public NavigableSet<K> navigableKeySet() {
            return this.fromMap().navigableKeySet();
        }

        @Override
        public Map.Entry<K, V2> pollFirstEntry() {
            return this.transformEntry(this.fromMap().pollFirstEntry());
        }

        @Override
        public Map.Entry<K, V2> pollLastEntry() {
            return this.transformEntry(this.fromMap().pollLastEntry());
        }

        @Override
        public NavigableMap<K, V2> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return Maps.transformEntries(this.fromMap().subMap(fromKey, fromInclusive, toKey, toInclusive), this.transformer);
        }

        @Override
        public NavigableMap<K, V2> subMap(K fromKey, K toKey) {
            return this.subMap(fromKey, true, toKey, false);
        }

        @Override
        public NavigableMap<K, V2> tailMap(K fromKey) {
            return this.tailMap(fromKey, true);
        }

        @Override
        public NavigableMap<K, V2> tailMap(K fromKey, boolean inclusive) {
            return Maps.transformEntries(this.fromMap().tailMap(fromKey, inclusive), this.transformer);
        }

        private Map.Entry<K, V2> transformEntry(Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            K key = entry.getKey();
            Object v2 = this.transformer.transformEntry(key, entry.getValue());
            return Maps.immutableEntry(key, v2);
        }

        @Override
        protected NavigableMap<K, V1> fromMap() {
            return (NavigableMap)super.fromMap();
        }
    }

    static class TransformedEntriesSortedMap<K, V1, V2>
    extends TransformedEntriesMap<K, V1, V2>
    implements SortedMap<K, V2> {
        protected SortedMap<K, V1> fromMap() {
            return (SortedMap)this.fromMap;
        }

        TransformedEntriesSortedMap(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            super(fromMap, transformer);
        }

        @Override
        public Comparator<? super K> comparator() {
            return this.fromMap().comparator();
        }

        @Override
        public K firstKey() {
            return this.fromMap().firstKey();
        }

        @Override
        public SortedMap<K, V2> headMap(K toKey) {
            return Maps.transformEntries(this.fromMap().headMap(toKey), this.transformer);
        }

        @Override
        public K lastKey() {
            return this.fromMap().lastKey();
        }

        @Override
        public SortedMap<K, V2> subMap(K fromKey, K toKey) {
            return Maps.transformEntries(this.fromMap().subMap(fromKey, toKey), this.transformer);
        }

        @Override
        public SortedMap<K, V2> tailMap(K fromKey) {
            return Maps.transformEntries(this.fromMap().tailMap(fromKey), this.transformer);
        }
    }

    static class TransformedEntriesMap<K, V1, V2>
    extends AbstractMap<K, V2> {
        final Map<K, V1> fromMap;
        final EntryTransformer<? super K, ? super V1, V2> transformer;
        Set<Map.Entry<K, V2>> entrySet;
        Collection<V2> values;

        TransformedEntriesMap(Map<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            this.fromMap = Preconditions.checkNotNull(fromMap);
            this.transformer = Preconditions.checkNotNull(transformer);
        }

        @Override
        public int size() {
            return this.fromMap.size();
        }

        @Override
        public boolean containsKey(Object key) {
            return this.fromMap.containsKey(key);
        }

        @Override
        public V2 get(Object key) {
            V1 value = this.fromMap.get(key);
            return (V2)(value != null || this.fromMap.containsKey(key) ? this.transformer.transformEntry(key, value) : null);
        }

        @Override
        public V2 remove(Object key) {
            return this.fromMap.containsKey(key) ? (V2)this.transformer.transformEntry((K)key, (V1)this.fromMap.remove(key)) : null;
        }

        @Override
        public void clear() {
            this.fromMap.clear();
        }

        @Override
        public Set<K> keySet() {
            return this.fromMap.keySet();
        }

        @Override
        public Set<Map.Entry<K, V2>> entrySet() {
            EntrySet result2 = this.entrySet;
            if (result2 == null) {
                this.entrySet = result2 = new EntrySet<K, V2>(){

                    @Override
                    Map<K, V2> map() {
                        return TransformedEntriesMap.this;
                    }

                    @Override
                    public Iterator<Map.Entry<K, V2>> iterator() {
                        return new TransformedIterator<Map.Entry<K, V1>, Map.Entry<K, V2>>(TransformedEntriesMap.this.fromMap.entrySet().iterator()){

                            @Override
                            Map.Entry<K, V2> transform(final Map.Entry<K, V1> entry) {
                                return new AbstractMapEntry<K, V2>(){

                                    @Override
                                    public K getKey() {
                                        return entry.getKey();
                                    }

                                    @Override
                                    public V2 getValue() {
                                        return TransformedEntriesMap.this.transformer.transformEntry(entry.getKey(), entry.getValue());
                                    }
                                };
                            }
                        };
                    }
                };
            }
            return result2;
        }

        @Override
        public Collection<V2> values() {
            Collection<V2> result2 = this.values;
            if (result2 == null) {
                this.values = new Values<K, V2>(){

                    @Override
                    Map<K, V2> map() {
                        return TransformedEntriesMap.this;
                    }
                };
                return this.values;
            }
            return result2;
        }
    }

    public static interface EntryTransformer<K, V1, V2> {
        public V2 transformEntry(@Nullable K var1, @Nullable V1 var2);
    }

    private static class UnmodifiableBiMap<K, V>
    extends ForwardingMap<K, V>
    implements BiMap<K, V>,
    Serializable {
        final Map<K, V> unmodifiableMap;
        final BiMap<? extends K, ? extends V> delegate;
        BiMap<V, K> inverse;
        transient Set<V> values;
        private static final long serialVersionUID = 0L;

        UnmodifiableBiMap(BiMap<? extends K, ? extends V> delegate, @Nullable BiMap<V, K> inverse) {
            this.unmodifiableMap = Collections.unmodifiableMap(delegate);
            this.delegate = delegate;
            this.inverse = inverse;
        }

        @Override
        protected Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override
        public V forcePut(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public BiMap<V, K> inverse() {
            BiMap<K, V> result2 = this.inverse;
            return result2 == null ? (this.inverse = new UnmodifiableBiMap<V, K>(this.delegate.inverse(), this)) : result2;
        }

        @Override
        public Set<V> values() {
            Set<V> result2 = this.values;
            return result2 == null ? (this.values = Collections.unmodifiableSet(this.delegate.values())) : result2;
        }
    }

    static class UnmodifiableEntrySet<K, V>
    extends UnmodifiableEntries<K, V>
    implements Set<Map.Entry<K, V>> {
        UnmodifiableEntrySet(Set<Map.Entry<K, V>> entries) {
            super(entries);
        }

        @Override
        public boolean equals(@Nullable Object object) {
            return Sets.equalsImpl(this, object);
        }

        @Override
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    static class UnmodifiableEntries<K, V>
    extends ForwardingCollection<Map.Entry<K, V>> {
        private final Collection<Map.Entry<K, V>> entries;

        UnmodifiableEntries(Collection<Map.Entry<K, V>> entries) {
            this.entries = entries;
        }

        @Override
        protected Collection<Map.Entry<K, V>> delegate() {
            return this.entries;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            final Iterator delegate = super.iterator();
            return new ForwardingIterator<Map.Entry<K, V>>(){

                @Override
                public Map.Entry<K, V> next() {
                    return Maps.unmodifiableEntry((Map.Entry)super.next());
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override
                protected Iterator<Map.Entry<K, V>> delegate() {
                    return delegate;
                }
            };
        }

        @Override
        public boolean add(Map.Entry<K, V> element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object[] toArray() {
            return this.standardToArray();
        }

        @Override
        public <T> T[] toArray(T[] array) {
            return this.standardToArray(array);
        }
    }

    @GwtIncompatible(value="NavigableMap")
    private static final class NavigableAsMapView<K, V>
    extends AbstractNavigableMap<K, V> {
        private final NavigableSet<K> set;
        private final Function<? super K, V> function;

        NavigableAsMapView(NavigableSet<K> ks, Function<? super K, V> vFunction) {
            this.set = Preconditions.checkNotNull(ks);
            this.function = Preconditions.checkNotNull(vFunction);
        }

        @Override
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return Maps.asMap(this.set.subSet(fromKey, fromInclusive, toKey, toInclusive), this.function);
        }

        @Override
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return Maps.asMap(this.set.headSet(toKey, inclusive), this.function);
        }

        @Override
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return Maps.asMap(this.set.tailSet(fromKey, inclusive), this.function);
        }

        @Override
        public Comparator<? super K> comparator() {
            return this.set.comparator();
        }

        @Override
        @Nullable
        public V get(@Nullable Object key) {
            if (this.set.contains(key)) {
                Object k = key;
                return this.function.apply(k);
            }
            return null;
        }

        @Override
        public void clear() {
            this.set.clear();
        }

        @Override
        Iterator<Map.Entry<K, V>> entryIterator() {
            return Maps.asSetEntryIterator(this.set, this.function);
        }

        @Override
        Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return this.descendingMap().entrySet().iterator();
        }

        @Override
        public NavigableSet<K> navigableKeySet() {
            return Maps.removeOnlyNavigableSet(this.set);
        }

        @Override
        public int size() {
            return this.set.size();
        }

        @Override
        public NavigableMap<K, V> descendingMap() {
            return Maps.asMap(this.set.descendingSet(), this.function);
        }
    }

    private static class SortedAsMapView<K, V>
    extends AsMapView<K, V>
    implements SortedMap<K, V> {
        SortedAsMapView(SortedSet<K> set, Function<? super K, V> function) {
            super(set, function);
        }

        @Override
        SortedSet<K> backingSet() {
            return (SortedSet)super.backingSet();
        }

        @Override
        public Comparator<? super K> comparator() {
            return this.backingSet().comparator();
        }

        @Override
        public Set<K> keySet() {
            return Maps.removeOnlySortedSet((SortedSet)this.backingSet());
        }

        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return Maps.asMap(this.backingSet().subSet(fromKey, toKey), this.function);
        }

        @Override
        public SortedMap<K, V> headMap(K toKey) {
            return Maps.asMap(this.backingSet().headSet(toKey), this.function);
        }

        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            return Maps.asMap(this.backingSet().tailSet(fromKey), this.function);
        }

        @Override
        public K firstKey() {
            return (K)this.backingSet().first();
        }

        @Override
        public K lastKey() {
            return (K)this.backingSet().last();
        }
    }

    private static class AsMapView<K, V>
    extends ImprovedAbstractMap<K, V> {
        private final Set<K> set;
        final Function<? super K, V> function;

        Set<K> backingSet() {
            return this.set;
        }

        AsMapView(Set<K> set, Function<? super K, V> function) {
            this.set = Preconditions.checkNotNull(set);
            this.function = Preconditions.checkNotNull(function);
        }

        @Override
        public Set<K> keySet() {
            return Maps.removeOnlySet(this.backingSet());
        }

        @Override
        public Collection<V> values() {
            return Collections2.transform(this.set, this.function);
        }

        @Override
        public int size() {
            return this.backingSet().size();
        }

        @Override
        public boolean containsKey(@Nullable Object key) {
            return this.backingSet().contains(key);
        }

        @Override
        public V get(@Nullable Object key) {
            if (this.backingSet().contains(key)) {
                Object k = key;
                return this.function.apply(k);
            }
            return null;
        }

        @Override
        public V remove(@Nullable Object key) {
            if (this.backingSet().remove(key)) {
                Object k = key;
                return this.function.apply(k);
            }
            return null;
        }

        @Override
        public void clear() {
            this.backingSet().clear();
        }

        @Override
        protected Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet<K, V>(){

                @Override
                Map<K, V> map() {
                    return AsMapView.this;
                }

                @Override
                public Iterator<Map.Entry<K, V>> iterator() {
                    return Maps.asSetEntryIterator(AsMapView.this.backingSet(), AsMapView.this.function);
                }
            };
        }
    }

    static class SortedMapDifferenceImpl<K, V>
    extends MapDifferenceImpl<K, V>
    implements SortedMapDifference<K, V> {
        SortedMapDifferenceImpl(boolean areEqual, SortedMap<K, V> onlyOnLeft, SortedMap<K, V> onlyOnRight, SortedMap<K, V> onBoth, SortedMap<K, MapDifference.ValueDifference<V>> differences) {
            super(areEqual, onlyOnLeft, onlyOnRight, onBoth, differences);
        }

        @Override
        public SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return (SortedMap)super.entriesDiffering();
        }

        @Override
        public SortedMap<K, V> entriesInCommon() {
            return (SortedMap)super.entriesInCommon();
        }

        @Override
        public SortedMap<K, V> entriesOnlyOnLeft() {
            return (SortedMap)super.entriesOnlyOnLeft();
        }

        @Override
        public SortedMap<K, V> entriesOnlyOnRight() {
            return (SortedMap)super.entriesOnlyOnRight();
        }
    }

    static class ValueDifferenceImpl<V>
    implements MapDifference.ValueDifference<V> {
        private final V left;
        private final V right;

        static <V> MapDifference.ValueDifference<V> create(@Nullable V left, @Nullable V right) {
            return new ValueDifferenceImpl<V>(left, right);
        }

        private ValueDifferenceImpl(@Nullable V left, @Nullable V right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public V leftValue() {
            return this.left;
        }

        @Override
        public V rightValue() {
            return this.right;
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object instanceof MapDifference.ValueDifference) {
                MapDifference.ValueDifference that = (MapDifference.ValueDifference)object;
                return Objects.equal(this.left, that.leftValue()) && Objects.equal(this.right, that.rightValue());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.left, this.right);
        }

        public String toString() {
            return "(" + this.left + ", " + this.right + ")";
        }
    }

    static class MapDifferenceImpl<K, V>
    implements MapDifference<K, V> {
        final boolean areEqual;
        final Map<K, V> onlyOnLeft;
        final Map<K, V> onlyOnRight;
        final Map<K, V> onBoth;
        final Map<K, MapDifference.ValueDifference<V>> differences;

        MapDifferenceImpl(boolean areEqual, Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, MapDifference.ValueDifference<V>> differences) {
            this.areEqual = areEqual;
            this.onlyOnLeft = onlyOnLeft;
            this.onlyOnRight = onlyOnRight;
            this.onBoth = onBoth;
            this.differences = differences;
        }

        @Override
        public boolean areEqual() {
            return this.areEqual;
        }

        @Override
        public Map<K, V> entriesOnlyOnLeft() {
            return this.onlyOnLeft;
        }

        @Override
        public Map<K, V> entriesOnlyOnRight() {
            return this.onlyOnRight;
        }

        @Override
        public Map<K, V> entriesInCommon() {
            return this.onBoth;
        }

        @Override
        public Map<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return this.differences;
        }

        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object instanceof MapDifference) {
                MapDifference other = (MapDifference)object;
                return this.entriesOnlyOnLeft().equals(other.entriesOnlyOnLeft()) && this.entriesOnlyOnRight().equals(other.entriesOnlyOnRight()) && this.entriesInCommon().equals(other.entriesInCommon()) && this.entriesDiffering().equals(other.entriesDiffering());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.entriesOnlyOnLeft(), this.entriesOnlyOnRight(), this.entriesInCommon(), this.entriesDiffering());
        }

        public String toString() {
            if (this.areEqual) {
                return "equal";
            }
            StringBuilder result2 = new StringBuilder("not equal");
            if (!this.onlyOnLeft.isEmpty()) {
                result2.append(": only on left=").append(this.onlyOnLeft);
            }
            if (!this.onlyOnRight.isEmpty()) {
                result2.append(": only on right=").append(this.onlyOnRight);
            }
            if (!this.differences.isEmpty()) {
                result2.append(": value differences=").append(this.differences);
            }
            return result2.toString();
        }
    }

    private static enum EntryFunction implements Function<Map.Entry, Object>
    {
        KEY{

            @Override
            @Nullable
            public Object apply(Map.Entry entry) {
                return entry.getKey();
            }
        }
        ,
        VALUE{

            @Override
            @Nullable
            public Object apply(Map.Entry entry) {
                return entry.getValue();
            }
        };

    }
}

