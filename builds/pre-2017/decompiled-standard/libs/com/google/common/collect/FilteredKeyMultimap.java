/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.ForwardingList;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class FilteredKeyMultimap<K, V>
extends FilteredMultimap<K, V> {
    final Predicate<? super K> keyPredicate;

    FilteredKeyMultimap(Multimap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        super(unfiltered);
        this.keyPredicate = Preconditions.checkNotNull(keyPredicate);
    }

    @Override
    Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return Predicates.compose(this.keyPredicate, Maps.keyFunction());
    }

    @Override
    public int size() {
        int size = 0;
        for (Collection collection : this.asMap().values()) {
            size += collection.size();
        }
        return size;
    }

    @Override
    public boolean containsKey(@Nullable Object key) {
        if (this.unfiltered.containsKey(key)) {
            Object k = key;
            return this.keyPredicate.apply(k);
        }
        return false;
    }

    @Override
    public Collection<V> removeAll(Object key) {
        return this.containsKey(key) ? this.unfiltered.removeAll(key) : this.unmodifiableEmptyCollection();
    }

    Collection<V> unmodifiableEmptyCollection() {
        if (this.unfiltered instanceof SetMultimap) {
            return ImmutableSet.of();
        }
        return ImmutableList.of();
    }

    @Override
    public void clear() {
        this.keySet().clear();
    }

    @Override
    Set<K> createKeySet() {
        return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }

    @Override
    public Collection<V> get(K key) {
        if (this.keyPredicate.apply(key)) {
            return this.unfiltered.get(key);
        }
        if (this.unfiltered instanceof SetMultimap) {
            return new AddRejectingSet(key);
        }
        return new AddRejectingList(key);
    }

    @Override
    Iterator<Map.Entry<K, V>> entryIterator() {
        return Iterators.filter(this.unfiltered.entries().iterator(), Predicates.compose(this.keyPredicate, Maps.keyFunction()));
    }

    @Override
    Collection<Map.Entry<K, V>> createEntries() {
        return new Multimaps.Entries<K, V>(){

            @Override
            Multimap<K, V> multimap() {
                return FilteredKeyMultimap.this;
            }

            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                return FilteredKeyMultimap.this.entryIterator();
            }

            @Override
            public boolean remove(@Nullable Object o) {
                Map.Entry entry;
                if (o instanceof Map.Entry && FilteredKeyMultimap.this.unfiltered.containsEntry((entry = (Map.Entry)o).getKey(), entry.getValue()) && FilteredKeyMultimap.this.keyPredicate.apply(entry.getKey())) {
                    return FilteredKeyMultimap.this.unfiltered.remove(entry.getKey(), entry.getValue());
                }
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                Predicate combinedPredicate = Predicates.and(Predicates.compose(FilteredKeyMultimap.this.keyPredicate, Maps.keyFunction()), Predicates.in(c));
                return Iterators.removeIf(FilteredKeyMultimap.this.unfiltered.entries().iterator(), combinedPredicate);
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                Predicate combinedPredicate = Predicates.and(Predicates.compose(FilteredKeyMultimap.this.keyPredicate, Maps.keyFunction()), Predicates.not(Predicates.in(c)));
                return Iterators.removeIf(FilteredKeyMultimap.this.unfiltered.entries().iterator(), combinedPredicate);
            }
        };
    }

    @Override
    Map<K, Collection<V>> createAsMap() {
        return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
    }

    @Override
    Multiset<K> createKeys() {
        return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
    }

    static class AddRejectingList<K, V>
    extends ForwardingList<V> {
        final K key;

        AddRejectingList(K key) {
            this.key = key;
        }

        @Override
        public boolean add(V v) {
            this.add(0, v);
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends V> collection) {
            this.addAll(0, collection);
            return true;
        }

        @Override
        public void add(int index, V element) {
            Preconditions.checkPositionIndex(index, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override
        public boolean addAll(int index, Collection<? extends V> elements) {
            Preconditions.checkNotNull(elements);
            Preconditions.checkPositionIndex(index, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override
        protected List<V> delegate() {
            return Collections.emptyList();
        }
    }

    static class AddRejectingSet<K, V>
    extends ForwardingSet<V> {
        final K key;

        AddRejectingSet(K key) {
            this.key = key;
        }

        @Override
        public boolean add(V element) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override
        public boolean addAll(Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @Override
        protected Set<V> delegate() {
            return Collections.emptySet();
        }
    }
}

