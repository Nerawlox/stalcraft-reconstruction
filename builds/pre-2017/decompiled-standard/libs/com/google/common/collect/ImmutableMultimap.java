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
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.Serialization;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class ImmutableMultimap<K, V>
extends AbstractMultimap<K, V>
implements Serializable {
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;
    private static final long serialVersionUID = 0L;

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k1, V v1) {
        return ImmutableListMultimap.of(k1, v1);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k1, V v1, K k2, V v2) {
        return ImmutableListMultimap.of(k1, v1, k2, v2);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.of(k1, v1, k2, v2, k3, v3);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.of(k1, v1, k2, v2, k3, v3, k4, v4);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        ImmutableMultimap kvMultimap;
        if (multimap instanceof ImmutableMultimap && !(kvMultimap = (ImmutableMultimap)multimap).isPartialView()) {
            return kvMultimap;
        }
        return ImmutableListMultimap.copyOf(multimap);
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> map2, int size) {
        this.map = map2;
        this.size = size;
    }

    @Override
    @Deprecated
    public ImmutableCollection<V> removeAll(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public ImmutableCollection<V> replaceValues(K key, Iterable<? extends V> values2) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract ImmutableCollection<V> get(K var1);

    public abstract ImmutableMultimap<V, K> inverse();

    @Override
    @Deprecated
    public boolean put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean putAll(K key, Iterable<? extends V> values2) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public boolean remove(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override
    public boolean containsKey(@Nullable Object key) {
        return this.map.containsKey(key);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    @Override
    Map<K, Collection<V>> createAsMap() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection)super.entries();
    }

    @Override
    ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    @Override
    UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        final Iterator mapIterator = ((ImmutableSet)this.map.entrySet()).iterator();
        return new UnmodifiableIterator<Map.Entry<K, V>>(){
            K key;
            Iterator<V> valueIterator;

            @Override
            public boolean hasNext() {
                return this.key != null && this.valueIterator.hasNext() || mapIterator.hasNext();
            }

            @Override
            public Map.Entry<K, V> next() {
                if (this.key == null || !this.valueIterator.hasNext()) {
                    Map.Entry entry = (Map.Entry)mapIterator.next();
                    this.key = entry.getKey();
                    this.valueIterator = ((ImmutableCollection)entry.getValue()).iterator();
                }
                return Maps.immutableEntry(this.key, this.valueIterator.next());
            }
        };
    }

    @Override
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset)super.keys();
    }

    @Override
    ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    @Override
    public ImmutableCollection<V> values() {
        return (ImmutableCollection)super.values();
    }

    @Override
    ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    private static class Values<V>
    extends ImmutableCollection<V> {
        final ImmutableMultimap<?, V> multimap;
        private static final long serialVersionUID = 0L;

        Values(ImmutableMultimap<?, V> multimap) {
            this.multimap = multimap;
        }

        @Override
        public UnmodifiableIterator<V> iterator() {
            return Maps.valueIterator(((ImmutableCollection)this.multimap.entries()).iterator());
        }

        @Override
        public int size() {
            return this.multimap.size();
        }

        @Override
        boolean isPartialView() {
            return true;
        }
    }

    class Keys
    extends ImmutableMultiset<K> {
        Keys() {
        }

        @Override
        public boolean contains(@Nullable Object object) {
            return ImmutableMultimap.this.containsKey(object);
        }

        @Override
        public int count(@Nullable Object element) {
            Collection values2 = ImmutableMultimap.this.map.get(element);
            return values2 == null ? 0 : values2.size();
        }

        @Override
        public Set<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }

        @Override
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override
        ImmutableSet<Multiset.Entry<K>> createEntrySet() {
            return new KeysEntrySet();
        }

        @Override
        boolean isPartialView() {
            return true;
        }

        private class KeysEntrySet
        extends ImmutableMultiset.EntrySet {
            private KeysEntrySet() {
                super(Keys.this);
            }

            @Override
            public int size() {
                return ImmutableMultimap.this.keySet().size();
            }

            @Override
            public UnmodifiableIterator<Multiset.Entry<K>> iterator() {
                return this.asList().iterator();
            }

            @Override
            ImmutableList<Multiset.Entry<K>> createAsList() {
                final ImmutableList mapEntries = ((ImmutableCollection)((Object)ImmutableMultimap.this.map.entrySet())).asList();
                return new ImmutableAsList<Multiset.Entry<K>>(){

                    @Override
                    public Multiset.Entry<K> get(int index) {
                        Map.Entry entry = (Map.Entry)mapEntries.get(index);
                        return Multisets.immutableEntry(entry.getKey(), ((Collection)entry.getValue()).size());
                    }

                    @Override
                    ImmutableCollection<Multiset.Entry<K>> delegateCollection() {
                        return KeysEntrySet.this;
                    }
                };
            }
        }
    }

    private static class EntryCollection<K, V>
    extends ImmutableCollection<Map.Entry<K, V>> {
        final ImmutableMultimap<K, V> multimap;
        private static final long serialVersionUID = 0L;

        EntryCollection(ImmutableMultimap<K, V> multimap) {
            this.multimap = multimap;
        }

        @Override
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override
        boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override
        public int size() {
            return this.multimap.size();
        }

        @Override
        public boolean contains(Object object) {
            if (object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry)object;
                return this.multimap.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }
    }

    @GwtIncompatible(value="java serialization is not supported")
    static class FieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
        static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");

        FieldSettersHolder() {
        }
    }

    public static class Builder<K, V> {
        Multimap<K, V> builderMultimap = new BuilderMultimap();
        Comparator<? super K> keyComparator;
        Comparator<? super V> valueComparator;

        public Builder<K, V> put(K key, V value) {
            this.builderMultimap.put(Preconditions.checkNotNull(key), Preconditions.checkNotNull(value));
            return this;
        }

        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            this.builderMultimap.put(Preconditions.checkNotNull(entry.getKey()), Preconditions.checkNotNull(entry.getValue()));
            return this;
        }

        public Builder<K, V> putAll(K key, Iterable<? extends V> values2) {
            Collection<V> valueList = this.builderMultimap.get(Preconditions.checkNotNull(key));
            for (V value : values2) {
                valueList.add(Preconditions.checkNotNull(value));
            }
            return this;
        }

        public Builder<K, V> putAll(K key, V ... values2) {
            return this.putAll(key, (Iterable<? extends V>)Arrays.asList(values2));
        }

        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
                this.putAll(entry.getKey(), (Iterable)entry.getValue());
            }
            return this;
        }

        public Builder<K, V> orderKeysBy(Comparator<? super K> keyComparator) {
            this.keyComparator = Preconditions.checkNotNull(keyComparator);
            return this;
        }

        public Builder<K, V> orderValuesBy(Comparator<? super V> valueComparator) {
            this.valueComparator = Preconditions.checkNotNull(valueComparator);
            return this;
        }

        public ImmutableMultimap<K, V> build() {
            if (this.valueComparator != null) {
                for (Collection<V> values2 : this.builderMultimap.asMap().values()) {
                    List list = (List)values2;
                    Collections.sort(list, this.valueComparator);
                }
            }
            if (this.keyComparator != null) {
                BuilderMultimap sortedCopy = new BuilderMultimap();
                ArrayList<Map.Entry<K, Collection<V>>> entries = Lists.newArrayList(this.builderMultimap.asMap().entrySet());
                Collections.sort(entries, Ordering.from(this.keyComparator).onResultOf(new Function<Map.Entry<K, Collection<V>>, K>(){

                    @Override
                    public K apply(Map.Entry<K, Collection<V>> entry) {
                        return entry.getKey();
                    }
                }));
                for (Map.Entry entry : entries) {
                    sortedCopy.putAll(entry.getKey(), (Iterable)entry.getValue());
                }
                this.builderMultimap = sortedCopy;
            }
            return ImmutableMultimap.copyOf(this.builderMultimap);
        }
    }

    private static class BuilderMultimap<K, V>
    extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0L;

        BuilderMultimap() {
            super(new LinkedHashMap());
        }

        @Override
        Collection<V> createCollection() {
            return Lists.newArrayList();
        }
    }
}

