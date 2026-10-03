/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Collections2;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class FilteredEntryMultimap<K, V>
extends FilteredMultimap<K, V> {
    final Predicate<? super Map.Entry<K, V>> predicate;

    FilteredEntryMultimap(Multimap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> predicate) {
        super(unfiltered);
        this.predicate = Preconditions.checkNotNull(predicate);
    }

    @Override
    Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return this.predicate;
    }

    @Override
    public int size() {
        return this.entries().size();
    }

    private boolean satisfies(K key, V value) {
        return this.predicate.apply(Maps.immutableEntry(key, value));
    }

    static <E> Collection<E> filterCollection(Collection<E> collection, Predicate<? super E> predicate) {
        if (collection instanceof Set) {
            return Sets.filter((Set)collection, predicate);
        }
        return Collections2.filter(collection, predicate);
    }

    @Override
    public boolean containsKey(@Nullable Object key) {
        return this.asMap().get(key) != null;
    }

    @Override
    public Collection<V> removeAll(@Nullable Object key) {
        return Objects.firstNonNull(this.asMap().remove(key), this.unmodifiableEmptyCollection());
    }

    Collection<V> unmodifiableEmptyCollection() {
        return this.unfiltered instanceof SetMultimap ? Collections.emptySet() : Collections.emptyList();
    }

    @Override
    public void clear() {
        this.entries().clear();
    }

    @Override
    public Collection<V> get(K key) {
        return FilteredEntryMultimap.filterCollection(this.unfiltered.get(key), new ValuePredicate(key));
    }

    @Override
    Collection<Map.Entry<K, V>> createEntries() {
        return FilteredEntryMultimap.filterCollection(this.unfiltered.entries(), this.predicate);
    }

    @Override
    Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    Map<K, Collection<V>> createAsMap() {
        return new AsMap();
    }

    @Override
    public Set<K> keySet() {
        return this.asMap().keySet();
    }

    boolean removeIf(Predicate<? super Map.Entry<K, Collection<V>>> predicate) {
        Iterator entryIterator = this.unfiltered.asMap().entrySet().iterator();
        boolean changed = false;
        while (entryIterator.hasNext()) {
            Map.Entry entry = entryIterator.next();
            Object key = entry.getKey();
            Collection collection = FilteredEntryMultimap.filterCollection(entry.getValue(), new ValuePredicate(key));
            if (collection.isEmpty() || !predicate.apply(Maps.immutableEntry(key, collection))) continue;
            if (collection.size() == entry.getValue().size()) {
                entryIterator.remove();
            } else {
                collection.clear();
            }
            changed = true;
        }
        return changed;
    }

    @Override
    Multiset<K> createKeys() {
        return new Keys();
    }

    class Keys
    extends Multimaps.Keys<K, V> {
        Keys() {
            super(FilteredEntryMultimap.this);
        }

        @Override
        public int remove(@Nullable Object key, int occurrences) {
            Multisets.checkNonnegative(occurrences, "occurrences");
            if (occurrences == 0) {
                return this.count(key);
            }
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(key);
            if (collection == null) {
                return 0;
            }
            Object k = key;
            int oldCount = 0;
            Iterator itr = collection.iterator();
            while (itr.hasNext()) {
                Object v = itr.next();
                if (!FilteredEntryMultimap.this.satisfies(k, v) || ++oldCount > occurrences) continue;
                itr.remove();
            }
            return oldCount;
        }

        @Override
        public Set<Multiset.Entry<K>> entrySet() {
            return new Multisets.EntrySet<K>(){

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
                    return FilteredEntryMultimap.this.keySet().size();
                }

                @Override
                private boolean removeIf(final Predicate<? super Multiset.Entry<K>> predicate) {
                    return FilteredEntryMultimap.this.removeIf(new Predicate<Map.Entry<K, Collection<V>>>(){

                        @Override
                        public boolean apply(Map.Entry<K, Collection<V>> entry) {
                            return predicate.apply(Multisets.immutableEntry(entry.getKey(), entry.getValue().size()));
                        }
                    });
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return this.removeIf(Predicates.in(c));
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return this.removeIf(Predicates.not(Predicates.in(c)));
                }
            };
        }
    }

    class AsMap
    extends AbstractMap<K, Collection<V>> {
        private Set<K> keySet;

        AsMap() {
        }

        @Override
        public boolean containsKey(@Nullable Object key) {
            return this.get(key) != null;
        }

        @Override
        public void clear() {
            FilteredEntryMultimap.this.clear();
        }

        @Override
        public Collection<V> get(@Nullable Object key) {
            Collection result2 = FilteredEntryMultimap.this.unfiltered.asMap().get(key);
            if (result2 == null) {
                return null;
            }
            Object k = key;
            return (result2 = FilteredEntryMultimap.filterCollection(result2, new ValuePredicate(k))).isEmpty() ? null : result2;
        }

        @Override
        public Collection<V> remove(@Nullable Object key) {
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(key);
            if (collection == null) {
                return null;
            }
            Object k = key;
            ArrayList result2 = Lists.newArrayList();
            Iterator itr = collection.iterator();
            while (itr.hasNext()) {
                Object v = itr.next();
                if (!FilteredEntryMultimap.this.satisfies(k, v)) continue;
                itr.remove();
                result2.add(v);
            }
            if (result2.isEmpty()) {
                return null;
            }
            if (FilteredEntryMultimap.this.unfiltered instanceof SetMultimap) {
                return Collections.unmodifiableSet(Sets.newLinkedHashSet(result2));
            }
            return Collections.unmodifiableList(result2);
        }

        @Override
        public Set<K> keySet() {
            Set result2 = this.keySet;
            if (result2 == null) {
                this.keySet = new Maps.KeySet<K, Collection<V>>(){

                    @Override
                    Map<K, Collection<V>> map() {
                        return AsMap.this;
                    }

                    @Override
                    public boolean removeAll(Collection<?> c) {
                        return FilteredEntryMultimap.this.removeIf(Predicates.compose(Predicates.in(c), Maps.keyFunction()));
                    }

                    @Override
                    public boolean retainAll(Collection<?> c) {
                        return FilteredEntryMultimap.this.removeIf(Predicates.compose(Predicates.not(Predicates.in(c)), Maps.keyFunction()));
                    }

                    @Override
                    public boolean remove(@Nullable Object o) {
                        return AsMap.this.remove(o) != null;
                    }
                };
                return this.keySet;
            }
            return result2;
        }

        @Override
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            return new Maps.EntrySet<K, Collection<V>>(){

                @Override
                Map<K, Collection<V>> map() {
                    return AsMap.this;
                }

                @Override
                public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                    return new AbstractIterator<Map.Entry<K, Collection<V>>>(){
                        final Iterator<Map.Entry<K, Collection<V>>> backingIterator;
                        {
                            this.backingIterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                        }

                        @Override
                        protected Map.Entry<K, Collection<V>> computeNext() {
                            while (this.backingIterator.hasNext()) {
                                Map.Entry entry = this.backingIterator.next();
                                Object key = entry.getKey();
                                Collection collection = FilteredEntryMultimap.filterCollection(entry.getValue(), new ValuePredicate(key));
                                if (collection.isEmpty()) continue;
                                return Maps.immutableEntry(key, collection);
                            }
                            return (Map.Entry)this.endOfData();
                        }
                    };
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return FilteredEntryMultimap.this.removeIf(Predicates.in(c));
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return FilteredEntryMultimap.this.removeIf(Predicates.not(Predicates.in(c)));
                }

                @Override
                public int size() {
                    return Iterators.size(this.iterator());
                }
            };
        }

        @Override
        public Collection<Collection<V>> values() {
            return new Maps.Values<K, Collection<V>>(){

                @Override
                Map<K, Collection<V>> map() {
                    return AsMap.this;
                }

                @Override
                public boolean remove(@Nullable Object o) {
                    if (o instanceof Collection) {
                        Collection c = (Collection)o;
                        Iterator entryIterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                        while (entryIterator.hasNext()) {
                            Map.Entry entry = entryIterator.next();
                            Object key = entry.getKey();
                            Collection collection = FilteredEntryMultimap.filterCollection(entry.getValue(), new ValuePredicate(key));
                            if (collection.isEmpty() || !c.equals(collection)) continue;
                            if (collection.size() == entry.getValue().size()) {
                                entryIterator.remove();
                            } else {
                                collection.clear();
                            }
                            return true;
                        }
                    }
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return FilteredEntryMultimap.this.removeIf(Predicates.compose(Predicates.in(c), Maps.valueFunction()));
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    return FilteredEntryMultimap.this.removeIf(Predicates.compose(Predicates.not(Predicates.in(c)), Maps.valueFunction()));
                }
            };
        }
    }

    final class ValuePredicate
    implements Predicate<V> {
        private final K key;

        ValuePredicate(K key) {
            this.key = key;
        }

        @Override
        public boolean apply(@Nullable V value) {
            return FilteredEntryMultimap.this.satisfies(this.key, value);
        }
    }
}

