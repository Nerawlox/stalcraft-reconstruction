/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractListMultimap;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.AbstractSortedSetMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.TransformedIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Multimaps {
    private Multimaps() {
    }

    public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> map2, Supplier<? extends Collection<V>> factory) {
        return new CustomMultimap<K, V>(map2, factory);
    }

    public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> map2, Supplier<? extends List<V>> factory) {
        return new CustomListMultimap<K, V>(map2, factory);
    }

    public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> map2, Supplier<? extends Set<V>> factory) {
        return new CustomSetMultimap<K, V>(map2, factory);
    }

    public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> map2, Supplier<? extends SortedSet<V>> factory) {
        return new CustomSortedSetMultimap<K, V>(map2, factory);
    }

    public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> source, M dest) {
        Preconditions.checkNotNull(dest);
        for (Map.Entry<V, K> entry : source.entries()) {
            dest.put(entry.getValue(), entry.getKey());
        }
        return dest;
    }

    public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> multimap) {
        return Synchronized.multimap(multimap, null);
    }

    public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> delegate) {
        if (delegate instanceof UnmodifiableMultimap || delegate instanceof ImmutableMultimap) {
            return delegate;
        }
        return new UnmodifiableMultimap<K, V>(delegate);
    }

    @Deprecated
    public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> delegate) {
        return Preconditions.checkNotNull(delegate);
    }

    public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> multimap) {
        return Synchronized.setMultimap(multimap, null);
    }

    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> delegate) {
        if (delegate instanceof UnmodifiableSetMultimap || delegate instanceof ImmutableSetMultimap) {
            return delegate;
        }
        return new UnmodifiableSetMultimap<K, V>(delegate);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> delegate) {
        return Preconditions.checkNotNull(delegate);
    }

    public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> multimap) {
        return Synchronized.sortedSetMultimap(multimap, null);
    }

    public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> delegate) {
        if (delegate instanceof UnmodifiableSortedSetMultimap) {
            return delegate;
        }
        return new UnmodifiableSortedSetMultimap<K, V>(delegate);
    }

    public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> multimap) {
        return Synchronized.listMultimap(multimap, null);
    }

    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> delegate) {
        if (delegate instanceof UnmodifiableListMultimap || delegate instanceof ImmutableListMultimap) {
            return delegate;
        }
        return new UnmodifiableListMultimap<K, V>(delegate);
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> delegate) {
        return Preconditions.checkNotNull(delegate);
    }

    private static <V> Collection<V> unmodifiableValueCollection(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet)collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set)collection);
        }
        if (collection instanceof List) {
            return Collections.unmodifiableList((List)collection);
        }
        return Collections.unmodifiableCollection(collection);
    }

    private static <K, V> Map.Entry<K, Collection<V>> unmodifiableAsMapEntry(final Map.Entry<K, Collection<V>> entry) {
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry<K, Collection<V>>(){

            @Override
            public K getKey() {
                return entry.getKey();
            }

            @Override
            public Collection<V> getValue() {
                return Multimaps.unmodifiableValueCollection((Collection)entry.getValue());
            }
        };
    }

    private static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> entries) {
        if (entries instanceof Set) {
            return Maps.unmodifiableEntrySet((Set)entries);
        }
        return new Maps.UnmodifiableEntries<K, V>(Collections.unmodifiableCollection(entries));
    }

    private static <K, V> Set<Map.Entry<K, Collection<V>>> unmodifiableAsMapEntries(Set<Map.Entry<K, Collection<V>>> asMapEntries) {
        return new UnmodifiableAsMapEntries<K, V>(Collections.unmodifiableSet(asMapEntries));
    }

    public static <K, V> SetMultimap<K, V> forMap(Map<K, V> map2) {
        return new MapMultimap<K, V>(map2);
    }

    public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> fromMultimap, final Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        Maps.EntryTransformer transformer = new Maps.EntryTransformer<K, V1, V2>(){

            @Override
            public V2 transformEntry(K key, V1 value) {
                return function.apply(value);
            }
        };
        return Multimaps.transformEntries(fromMultimap, transformer);
    }

    public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> fromMap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesMultimap<K, V1, V2>(fromMap, transformer);
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> fromMultimap, final Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        Maps.EntryTransformer transformer = new Maps.EntryTransformer<K, V1, V2>(){

            @Override
            public V2 transformEntry(K key, V1 value) {
                return function.apply(value);
            }
        };
        return Multimaps.transformEntries(fromMultimap, transformer);
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> fromMap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesListMultimap<K, V1, V2>(fromMap, transformer);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> values2, Function<? super V, K> keyFunction) {
        return Multimaps.index(values2.iterator(), keyFunction);
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> values2, Function<? super V, K> keyFunction) {
        Preconditions.checkNotNull(keyFunction);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        while (values2.hasNext()) {
            V value = values2.next();
            Preconditions.checkNotNull(value, values2);
            builder.put((Object)keyFunction.apply(value), (Object)value);
        }
        return builder.build();
    }

    @GwtIncompatible(value="untested")
    public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        if (unfiltered instanceof FilteredKeyMultimap) {
            FilteredKeyMultimap prev = (FilteredKeyMultimap)unfiltered;
            return new FilteredKeyMultimap(prev.unfiltered, Predicates.and(prev.keyPredicate, keyPredicate));
        }
        if (unfiltered instanceof FilteredMultimap) {
            FilteredMultimap prev = (FilteredMultimap)unfiltered;
            return new FilteredEntryMultimap(prev.unfiltered, Predicates.and(prev.entryPredicate(), Predicates.compose(keyPredicate, Maps.keyFunction())));
        }
        return new FilteredKeyMultimap<K, V>(unfiltered, keyPredicate);
    }

    @GwtIncompatible(value="untested")
    public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        return Multimaps.filterEntries(unfiltered, Predicates.compose(valuePredicate, Maps.valueFunction()));
    }

    @GwtIncompatible(value="untested")
    public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof FilteredMultimap ? Multimaps.filterFiltered((FilteredMultimap)unfiltered, entryPredicate) : new FilteredEntryMultimap<K, V>(Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    private static <K, V> Multimap<K, V> filterFiltered(FilteredMultimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Predicate<? super Map.Entry<K, V>> predicate = Predicates.and(multimap.entryPredicate(), entryPredicate);
        return new FilteredEntryMultimap(multimap.unfiltered, predicate);
    }

    static abstract class AsMap<K, V>
    extends Maps.ImprovedAbstractMap<K, Collection<V>> {
        AsMap() {
        }

        abstract Multimap<K, V> multimap();

        @Override
        public abstract int size();

        abstract Iterator<Map.Entry<K, Collection<V>>> entryIterator();

        @Override
        protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new EntrySet();
        }

        void removeValuesForKey(Object key) {
            this.multimap().removeAll(key);
        }

        @Override
        public Collection<V> get(Object key) {
            return this.containsKey(key) ? this.multimap().get(key) : null;
        }

        @Override
        public Collection<V> remove(Object key) {
            return this.containsKey(key) ? this.multimap().removeAll(key) : null;
        }

        @Override
        public Set<K> keySet() {
            return this.multimap().keySet();
        }

        @Override
        public boolean isEmpty() {
            return this.multimap().isEmpty();
        }

        @Override
        public boolean containsKey(Object key) {
            return this.multimap().containsKey(key);
        }

        @Override
        public void clear() {
            this.multimap().clear();
        }

        class EntrySet
        extends Maps.EntrySet<K, Collection<V>> {
            EntrySet() {
            }

            @Override
            Map<K, Collection<V>> map() {
                return AsMap.this;
            }

            @Override
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return AsMap.this.entryIterator();
            }

            @Override
            public boolean remove(Object o) {
                if (!this.contains(o)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry)o;
                AsMap.this.removeValuesForKey(entry.getKey());
                return true;
            }
        }
    }

    static abstract class EntrySet<K, V>
    extends Entries<K, V>
    implements Set<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        @Override
        public boolean equals(@Nullable Object obj) {
            return Sets.equalsImpl(this, obj);
        }
    }

    static abstract class Entries<K, V>
    extends AbstractCollection<Map.Entry<K, V>> {
        Entries() {
        }

        abstract Multimap<K, V> multimap();

        @Override
        public int size() {
            return this.multimap().size();
        }

        @Override
        public boolean contains(@Nullable Object o) {
            if (o instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)o;
                return this.multimap().containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override
        public boolean remove(@Nullable Object o) {
            if (o instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)o;
                return this.multimap().remove(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override
        public void clear() {
            this.multimap().clear();
        }
    }

    static class Values<K, V>
    extends AbstractCollection<V> {
        final Multimap<K, V> multimap;

        Values(Multimap<K, V> multimap) {
            this.multimap = multimap;
        }

        @Override
        public Iterator<V> iterator() {
            return Maps.valueIterator(this.multimap.entries().iterator());
        }

        @Override
        public int size() {
            return this.multimap.size();
        }

        @Override
        public boolean contains(@Nullable Object o) {
            return this.multimap.containsValue(o);
        }

        @Override
        public void clear() {
            this.multimap.clear();
        }
    }

    static class Keys<K, V>
    extends AbstractMultiset<K> {
        final Multimap<K, V> multimap;

        Keys(Multimap<K, V> multimap) {
            this.multimap = multimap;
        }

        @Override
        Iterator<Multiset.Entry<K>> entryIterator() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>>(this.multimap.asMap().entrySet().iterator()){

                @Override
                Multiset.Entry<K> transform(final Map.Entry<K, Collection<V>> backingEntry) {
                    return new Multisets.AbstractEntry<K>(){

                        @Override
                        public K getElement() {
                            return backingEntry.getKey();
                        }

                        @Override
                        public int getCount() {
                            return ((Collection)backingEntry.getValue()).size();
                        }
                    };
                }
            };
        }

        @Override
        int distinctElements() {
            return this.multimap.asMap().size();
        }

        @Override
        Set<Multiset.Entry<K>> createEntrySet() {
            return new KeysEntrySet();
        }

        @Override
        public boolean contains(@Nullable Object element) {
            return this.multimap.containsKey(element);
        }

        @Override
        public Iterator<K> iterator() {
            return Maps.keyIterator(this.multimap.entries().iterator());
        }

        @Override
        public int count(@Nullable Object element) {
            Collection<V> values2 = Maps.safeGet(this.multimap.asMap(), element);
            return values2 == null ? 0 : values2.size();
        }

        @Override
        public int remove(@Nullable Object element, int occurrences) {
            Preconditions.checkArgument(occurrences >= 0);
            if (occurrences == 0) {
                return this.count(element);
            }
            Collection<V> values2 = Maps.safeGet(this.multimap.asMap(), element);
            if (values2 == null) {
                return 0;
            }
            int oldCount = values2.size();
            if (occurrences >= oldCount) {
                values2.clear();
            } else {
                Iterator<V> iterator2 = values2.iterator();
                for (int i = 0; i < occurrences; ++i) {
                    iterator2.next();
                    iterator2.remove();
                }
            }
            return oldCount;
        }

        @Override
        public void clear() {
            this.multimap.clear();
        }

        @Override
        public Set<K> elementSet() {
            return this.multimap.keySet();
        }

        class KeysEntrySet
        extends Multisets.EntrySet<K> {
            KeysEntrySet() {
            }

            @Override
            Multiset<K> multiset() {
                return Keys.this;
            }

            @Override
            public Iterator<Multiset.Entry<K>> iterator() {
                return Keys.this.entryIterator();
            }

            @Override
            public int size() {
                return Keys.this.distinctElements();
            }

            @Override
            public boolean isEmpty() {
                return Keys.this.multimap.isEmpty();
            }

            @Override
            public boolean contains(@Nullable Object o) {
                if (o instanceof Multiset.Entry) {
                    Multiset.Entry entry = (Multiset.Entry)o;
                    Collection collection = Keys.this.multimap.asMap().get(entry.getElement());
                    return collection != null && collection.size() == entry.getCount();
                }
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                if (o instanceof Multiset.Entry) {
                    Multiset.Entry entry = (Multiset.Entry)o;
                    Collection collection = Keys.this.multimap.asMap().get(entry.getElement());
                    if (collection != null && collection.size() == entry.getCount()) {
                        collection.clear();
                        return true;
                    }
                }
                return false;
            }
        }
    }

    private static final class TransformedEntriesListMultimap<K, V1, V2>
    extends TransformedEntriesMultimap<K, V1, V2>
    implements ListMultimap<K, V2> {
        TransformedEntriesListMultimap(ListMultimap<K, V1> fromMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer) {
            super(fromMultimap, transformer);
        }

        @Override
        List<V2> transform(final K key, Collection<V1> values2) {
            return Lists.transform((List)values2, new Function<V1, V2>(){

                @Override
                public V2 apply(V1 value) {
                    return TransformedEntriesListMultimap.this.transformer.transformEntry(key, value);
                }
            });
        }

        @Override
        public List<V2> get(K key) {
            return this.transform((Object)key, this.fromMultimap.get(key));
        }

        @Override
        public List<V2> removeAll(Object key) {
            return this.transform(key, this.fromMultimap.removeAll(key));
        }

        @Override
        public List<V2> replaceValues(K key, Iterable<? extends V2> values2) {
            throw new UnsupportedOperationException();
        }
    }

    private static class TransformedEntriesMultimap<K, V1, V2>
    extends AbstractMultimap<K, V2> {
        final Multimap<K, V1> fromMultimap;
        final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;

        TransformedEntriesMultimap(Multimap<K, V1> fromMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer) {
            this.fromMultimap = Preconditions.checkNotNull(fromMultimap);
            this.transformer = Preconditions.checkNotNull(transformer);
        }

        Collection<V2> transform(K key, Collection<V1> values2) {
            ValueFunction<? super K, ? super V1, V2> function = new ValueFunction<K, V1, V2>(key, this.transformer);
            if (values2 instanceof List) {
                return Lists.transform((List)values2, function);
            }
            return Collections2.transform(values2, function);
        }

        @Override
        Map<K, Collection<V2>> createAsMap() {
            return Maps.transformEntries(this.fromMultimap.asMap(), new Maps.EntryTransformer<K, Collection<V1>, Collection<V2>>(){

                @Override
                public Collection<V2> transformEntry(K key, Collection<V1> value) {
                    return TransformedEntriesMultimap.this.transform(key, value);
                }
            });
        }

        @Override
        public void clear() {
            this.fromMultimap.clear();
        }

        @Override
        public boolean containsEntry(Object key, Object value) {
            Collection<V2> values2 = this.get(key);
            return values2.contains(value);
        }

        @Override
        public boolean containsKey(Object key) {
            return this.fromMultimap.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return this.values().contains(value);
        }

        @Override
        Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.transform(this.fromMultimap.entries().iterator(), new Function<Map.Entry<K, V1>, Map.Entry<K, V2>>(){

                @Override
                public Map.Entry<K, V2> apply(final Map.Entry<K, V1> entry) {
                    return new AbstractMapEntry<K, V2>(){

                        @Override
                        public K getKey() {
                            return entry.getKey();
                        }

                        @Override
                        public V2 getValue() {
                            return TransformedEntriesMultimap.this.transformer.transformEntry(entry.getKey(), entry.getValue());
                        }
                    };
                }
            });
        }

        @Override
        public Collection<V2> get(K key) {
            return this.transform(key, this.fromMultimap.get(key));
        }

        @Override
        public boolean isEmpty() {
            return this.fromMultimap.isEmpty();
        }

        @Override
        public Set<K> keySet() {
            return this.fromMultimap.keySet();
        }

        @Override
        public Multiset<K> keys() {
            return this.fromMultimap.keys();
        }

        @Override
        public boolean put(K key, V2 value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(K key, Iterable<? extends V2> values2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(Multimap<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object key, Object value) {
            return this.get(key).remove(value);
        }

        @Override
        public Collection<V2> removeAll(Object key) {
            return this.transform(key, this.fromMultimap.removeAll(key));
        }

        @Override
        public Collection<V2> replaceValues(K key, Iterable<? extends V2> values2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int size() {
            return this.fromMultimap.size();
        }

        @Override
        Collection<V2> createValues() {
            return Collections2.transform(this.fromMultimap.entries(), new Function<Map.Entry<K, V1>, V2>(){

                @Override
                public V2 apply(Map.Entry<K, V1> entry) {
                    return TransformedEntriesMultimap.this.transformer.transformEntry(entry.getKey(), entry.getValue());
                }
            });
        }
    }

    static final class ValueFunction<K, V1, V2>
    implements Function<V1, V2> {
        private final K key;
        private final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;

        ValueFunction(K key, Maps.EntryTransformer<? super K, ? super V1, V2> transformer) {
            this.key = key;
            this.transformer = transformer;
        }

        @Override
        public V2 apply(@Nullable V1 value) {
            return this.transformer.transformEntry(this.key, value);
        }
    }

    private static class MapMultimap<K, V>
    implements SetMultimap<K, V>,
    Serializable {
        final Map<K, V> map;
        transient Map<K, Collection<V>> asMap;
        private static final Joiner.MapJoiner JOINER = Joiner.on("], ").withKeyValueSeparator("=[").useForNull("null");
        private static final long serialVersionUID = 7845222491160860175L;

        MapMultimap(Map<K, V> map2) {
            this.map = Preconditions.checkNotNull(map2);
        }

        @Override
        public int size() {
            return this.map.size();
        }

        @Override
        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        @Override
        public boolean containsKey(Object key) {
            return this.map.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return this.map.containsValue(value);
        }

        @Override
        public boolean containsEntry(Object key, Object value) {
            return this.map.entrySet().contains(Maps.immutableEntry(key, value));
        }

        @Override
        public Set<V> get(final K key) {
            return new Sets.ImprovedAbstractSet<V>(){

                @Override
                public Iterator<V> iterator() {
                    return new Iterator<V>(){
                        int i;

                        @Override
                        public boolean hasNext() {
                            return this.i == 0 && MapMultimap.this.map.containsKey(key);
                        }

                        @Override
                        public V next() {
                            if (!this.hasNext()) {
                                throw new NoSuchElementException();
                            }
                            ++this.i;
                            return MapMultimap.this.map.get(key);
                        }

                        @Override
                        public void remove() {
                            Preconditions.checkState(this.i == 1);
                            this.i = -1;
                            MapMultimap.this.map.remove(key);
                        }
                    };
                }

                @Override
                public int size() {
                    return MapMultimap.this.map.containsKey(key) ? 1 : 0;
                }
            };
        }

        @Override
        public boolean put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(K key, Iterable<? extends V> values2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Set<V> replaceValues(K key, Iterable<? extends V> values2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object key, Object value) {
            return this.map.entrySet().remove(Maps.immutableEntry(key, value));
        }

        @Override
        public Set<V> removeAll(Object key) {
            HashSet<V> values2 = new HashSet<V>(2);
            if (!this.map.containsKey(key)) {
                return values2;
            }
            values2.add(this.map.remove(key));
            return values2;
        }

        @Override
        public void clear() {
            this.map.clear();
        }

        @Override
        public Set<K> keySet() {
            return this.map.keySet();
        }

        @Override
        public Multiset<K> keys() {
            return new Keys(this);
        }

        @Override
        public Collection<V> values() {
            return this.map.values();
        }

        @Override
        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        @Override
        public Map<K, Collection<V>> asMap() {
            AsMap result2 = this.asMap;
            if (result2 == null) {
                this.asMap = result2 = new AsMap();
            }
            return result2;
        }

        @Override
        public boolean equals(@Nullable Object object) {
            if (object == this) {
                return true;
            }
            if (object instanceof Multimap) {
                Multimap that = (Multimap)object;
                return this.size() == that.size() && this.asMap().equals(that.asMap());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            if (this.map.isEmpty()) {
                return "{}";
            }
            StringBuilder builder = Collections2.newStringBuilderForCollection(this.map.size()).append('{');
            JOINER.appendTo(builder, this.map);
            return builder.append("]}").toString();
        }

        class AsMap
        extends Maps.ImprovedAbstractMap<K, Collection<V>> {
            AsMap() {
            }

            @Override
            protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
                return new AsMapEntries();
            }

            @Override
            public boolean containsKey(Object key) {
                return MapMultimap.this.map.containsKey(key);
            }

            @Override
            public Collection<V> get(Object key) {
                Collection collection = MapMultimap.this.get(key);
                return collection.isEmpty() ? null : collection;
            }

            @Override
            public Collection<V> remove(Object key) {
                Collection collection = MapMultimap.this.removeAll(key);
                return collection.isEmpty() ? null : collection;
            }
        }

        class AsMapEntries
        extends Sets.ImprovedAbstractSet<Map.Entry<K, Collection<V>>> {
            AsMapEntries() {
            }

            @Override
            public int size() {
                return MapMultimap.this.map.size();
            }

            @Override
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new TransformedIterator<K, Map.Entry<K, Collection<V>>>(MapMultimap.this.map.keySet().iterator()){

                    @Override
                    Map.Entry<K, Collection<V>> transform(final K key) {
                        return new AbstractMapEntry<K, Collection<V>>(){

                            @Override
                            public K getKey() {
                                return key;
                            }

                            @Override
                            public Collection<V> getValue() {
                                return MapMultimap.this.get(key);
                            }
                        };
                    }
                };
            }

            @Override
            public boolean contains(Object o) {
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry)o;
                if (!(entry.getValue() instanceof Set)) {
                    return false;
                }
                Set set = (Set)entry.getValue();
                return set.size() == 1 && MapMultimap.this.containsEntry(entry.getKey(), set.iterator().next());
            }

            @Override
            public boolean remove(Object o) {
                if (!(o instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry)o;
                if (!(entry.getValue() instanceof Set)) {
                    return false;
                }
                Set set = (Set)entry.getValue();
                return set.size() == 1 && MapMultimap.this.map.entrySet().remove(Maps.immutableEntry(entry.getKey(), set.iterator().next()));
            }
        }
    }

    static class UnmodifiableAsMapEntries<K, V>
    extends ForwardingSet<Map.Entry<K, Collection<V>>> {
        private final Set<Map.Entry<K, Collection<V>>> delegate;

        UnmodifiableAsMapEntries(Set<Map.Entry<K, Collection<V>>> delegate) {
            this.delegate = delegate;
        }

        @Override
        protected Set<Map.Entry<K, Collection<V>>> delegate() {
            return this.delegate;
        }

        @Override
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            final Iterator<Map.Entry<K, Collection<V>>> iterator2 = this.delegate.iterator();
            return new ForwardingIterator<Map.Entry<K, Collection<V>>>(){

                @Override
                protected Iterator<Map.Entry<K, Collection<V>>> delegate() {
                    return iterator2;
                }

                @Override
                public Map.Entry<K, Collection<V>> next() {
                    return Multimaps.unmodifiableAsMapEntry((Map.Entry)iterator2.next());
                }
            };
        }

        @Override
        public Object[] toArray() {
            return this.standardToArray();
        }

        @Override
        public <T> T[] toArray(T[] array) {
            return this.standardToArray(array);
        }

        @Override
        public boolean contains(Object o) {
            return Maps.containsEntryImpl(this.delegate(), o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return this.standardContainsAll(c);
        }

        @Override
        public boolean equals(@Nullable Object object) {
            return this.standardEquals(object);
        }
    }

    private static class UnmodifiableSortedSetMultimap<K, V>
    extends UnmodifiableSetMultimap<K, V>
    implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0L;

        UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> delegate) {
            super(delegate);
        }

        @Override
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap)super.delegate();
        }

        @Override
        public SortedSet<V> get(K key) {
            return Collections.unmodifiableSortedSet(this.delegate().get(key));
        }

        @Override
        public SortedSet<V> removeAll(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public SortedSet<V> replaceValues(K key, Iterable<? extends V> values2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Comparator<? super V> valueComparator() {
            return this.delegate().valueComparator();
        }
    }

    private static class UnmodifiableSetMultimap<K, V>
    extends UnmodifiableMultimap<K, V>
    implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0L;

        UnmodifiableSetMultimap(SetMultimap<K, V> delegate) {
            super(delegate);
        }

        @Override
        public SetMultimap<K, V> delegate() {
            return (SetMultimap)super.delegate();
        }

        @Override
        public Set<V> get(K key) {
            return Collections.unmodifiableSet(this.delegate().get(key));
        }

        @Override
        public Set<Map.Entry<K, V>> entries() {
            return Maps.unmodifiableEntrySet(this.delegate().entries());
        }

        @Override
        public Set<V> removeAll(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Set<V> replaceValues(K key, Iterable<? extends V> values2) {
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableListMultimap<K, V>
    extends UnmodifiableMultimap<K, V>
    implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0L;

        UnmodifiableListMultimap(ListMultimap<K, V> delegate) {
            super(delegate);
        }

        @Override
        public ListMultimap<K, V> delegate() {
            return (ListMultimap)super.delegate();
        }

        @Override
        public List<V> get(K key) {
            return Collections.unmodifiableList(this.delegate().get(key));
        }

        @Override
        public List<V> removeAll(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<V> replaceValues(K key, Iterable<? extends V> values2) {
            throw new UnsupportedOperationException();
        }
    }

    private static class UnmodifiableAsMapValues<V>
    extends ForwardingCollection<Collection<V>> {
        final Collection<Collection<V>> delegate;

        UnmodifiableAsMapValues(Collection<Collection<V>> delegate) {
            this.delegate = Collections.unmodifiableCollection(delegate);
        }

        @Override
        protected Collection<Collection<V>> delegate() {
            return this.delegate;
        }

        @Override
        public Iterator<Collection<V>> iterator() {
            final Iterator<Collection<V>> iterator2 = this.delegate.iterator();
            return new UnmodifiableIterator<Collection<V>>(){

                @Override
                public boolean hasNext() {
                    return iterator2.hasNext();
                }

                @Override
                public Collection<V> next() {
                    return Multimaps.unmodifiableValueCollection((Collection)iterator2.next());
                }
            };
        }

        @Override
        public Object[] toArray() {
            return this.standardToArray();
        }

        @Override
        public <T> T[] toArray(T[] array) {
            return this.standardToArray(array);
        }

        @Override
        public boolean contains(Object o) {
            return this.standardContains(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return this.standardContainsAll(c);
        }
    }

    private static class UnmodifiableMultimap<K, V>
    extends ForwardingMultimap<K, V>
    implements Serializable {
        final Multimap<K, V> delegate;
        transient Collection<Map.Entry<K, V>> entries;
        transient Multiset<K> keys;
        transient Set<K> keySet;
        transient Collection<V> values;
        transient Map<K, Collection<V>> map;
        private static final long serialVersionUID = 0L;

        UnmodifiableMultimap(Multimap<K, V> delegate) {
            this.delegate = Preconditions.checkNotNull(delegate);
        }

        @Override
        protected Multimap<K, V> delegate() {
            return this.delegate;
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Map<K, Collection<V>> asMap() {
            ForwardingMap result2 = this.map;
            if (result2 == null) {
                final Map<K, Collection<V>> unmodifiableMap = Collections.unmodifiableMap(this.delegate.asMap());
                this.map = result2 = new ForwardingMap<K, Collection<V>>(){
                    Set<Map.Entry<K, Collection<V>>> entrySet;
                    Collection<Collection<V>> asMapValues;

                    @Override
                    protected Map<K, Collection<V>> delegate() {
                        return unmodifiableMap;
                    }

                    @Override
                    public Set<Map.Entry<K, Collection<V>>> entrySet() {
                        Set result2 = this.entrySet;
                        return result2 == null ? (this.entrySet = Multimaps.unmodifiableAsMapEntries(unmodifiableMap.entrySet())) : result2;
                    }

                    @Override
                    public Collection<V> get(Object key) {
                        Collection collection = (Collection)unmodifiableMap.get(key);
                        return collection == null ? null : Multimaps.unmodifiableValueCollection(collection);
                    }

                    @Override
                    public Collection<Collection<V>> values() {
                        Collection result2 = this.asMapValues;
                        return result2 == null ? (this.asMapValues = new UnmodifiableAsMapValues(unmodifiableMap.values())) : result2;
                    }

                    @Override
                    public boolean containsValue(Object o) {
                        return this.values().contains(o);
                    }
                };
            }
            return result2;
        }

        @Override
        public Collection<Map.Entry<K, V>> entries() {
            Collection result2 = this.entries;
            if (result2 == null) {
                this.entries = result2 = Multimaps.unmodifiableEntries(this.delegate.entries());
            }
            return result2;
        }

        @Override
        public Collection<V> get(K key) {
            return Multimaps.unmodifiableValueCollection(this.delegate.get(key));
        }

        @Override
        public Multiset<K> keys() {
            Multiset<K> result2 = this.keys;
            if (result2 == null) {
                this.keys = result2 = Multisets.unmodifiableMultiset(this.delegate.keys());
            }
            return result2;
        }

        @Override
        public Set<K> keySet() {
            Set<K> result2 = this.keySet;
            if (result2 == null) {
                this.keySet = result2 = Collections.unmodifiableSet(this.delegate.keySet());
            }
            return result2;
        }

        @Override
        public boolean put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(K key, Iterable<? extends V> values2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Collection<V> removeAll(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Collection<V> replaceValues(K key, Iterable<? extends V> values2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Collection<V> values() {
            Collection<V> result2 = this.values;
            if (result2 == null) {
                this.values = result2 = Collections.unmodifiableCollection(this.delegate.values());
            }
            return result2;
        }
    }

    private static class CustomSortedSetMultimap<K, V>
    extends AbstractSortedSetMultimap<K, V> {
        transient Supplier<? extends SortedSet<V>> factory;
        transient Comparator<? super V> valueComparator;
        @GwtIncompatible(value="not needed in emulated source")
        private static final long serialVersionUID = 0L;

        CustomSortedSetMultimap(Map<K, Collection<V>> map2, Supplier<? extends SortedSet<V>> factory) {
            super(map2);
            this.factory = Preconditions.checkNotNull(factory);
            this.valueComparator = factory.get().comparator();
        }

        @Override
        protected SortedSet<V> createCollection() {
            return this.factory.get();
        }

        @Override
        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        @GwtIncompatible(value="java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(this.backingMap());
        }

        @GwtIncompatible(value="java.io.ObjectInputStream")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.factory = (Supplier)stream.readObject();
            this.valueComparator = this.factory.get().comparator();
            Map map2 = (Map)stream.readObject();
            this.setMap(map2);
        }
    }

    private static class CustomSetMultimap<K, V>
    extends AbstractSetMultimap<K, V> {
        transient Supplier<? extends Set<V>> factory;
        @GwtIncompatible(value="not needed in emulated source")
        private static final long serialVersionUID = 0L;

        CustomSetMultimap(Map<K, Collection<V>> map2, Supplier<? extends Set<V>> factory) {
            super(map2);
            this.factory = Preconditions.checkNotNull(factory);
        }

        @Override
        protected Set<V> createCollection() {
            return this.factory.get();
        }

        @GwtIncompatible(value="java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(this.backingMap());
        }

        @GwtIncompatible(value="java.io.ObjectInputStream")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.factory = (Supplier)stream.readObject();
            Map map2 = (Map)stream.readObject();
            this.setMap(map2);
        }
    }

    private static class CustomListMultimap<K, V>
    extends AbstractListMultimap<K, V> {
        transient Supplier<? extends List<V>> factory;
        @GwtIncompatible(value="java serialization not supported")
        private static final long serialVersionUID = 0L;

        CustomListMultimap(Map<K, Collection<V>> map2, Supplier<? extends List<V>> factory) {
            super(map2);
            this.factory = Preconditions.checkNotNull(factory);
        }

        @Override
        protected List<V> createCollection() {
            return this.factory.get();
        }

        @GwtIncompatible(value="java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(this.backingMap());
        }

        @GwtIncompatible(value="java.io.ObjectInputStream")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.factory = (Supplier)stream.readObject();
            Map map2 = (Map)stream.readObject();
            this.setMap(map2);
        }
    }

    private static class CustomMultimap<K, V>
    extends AbstractMapBasedMultimap<K, V> {
        transient Supplier<? extends Collection<V>> factory;
        @GwtIncompatible(value="java serialization not supported")
        private static final long serialVersionUID = 0L;

        CustomMultimap(Map<K, Collection<V>> map2, Supplier<? extends Collection<V>> factory) {
            super(map2);
            this.factory = Preconditions.checkNotNull(factory);
        }

        @Override
        protected Collection<V> createCollection() {
            return this.factory.get();
        }

        @GwtIncompatible(value="java.io.ObjectOutputStream")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(this.factory);
            stream.writeObject(this.backingMap());
        }

        @GwtIncompatible(value="java.io.ObjectInputStream")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.factory = (Supplier)stream.readObject();
            Map map2 = (Map)stream.readObject();
            this.setMap(map2);
        }
    }
}

