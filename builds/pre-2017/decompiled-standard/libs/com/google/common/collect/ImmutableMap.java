/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.ImmutableEnumMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableMapKeySet;
import com.google.common.collect.ImmutableMapValues;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableMap;
import com.google.common.collect.SingletonImmutableBiMap;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableMap<K, V>
implements Map<K, V>,
Serializable {
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableCollection<V> values;
    private transient ImmutableSetMultimap<K, V> multimapView;

    public static <K, V> ImmutableMap<K, V> of() {
        return ImmutableBiMap.of();
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1) {
        return ImmutableBiMap.of(k1, v1);
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2) {
        return new RegularImmutableMap(ImmutableMap.entryOf(k1, v1), ImmutableMap.entryOf(k2, v2));
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return new RegularImmutableMap(ImmutableMap.entryOf(k1, v1), ImmutableMap.entryOf(k2, v2), ImmutableMap.entryOf(k3, v3));
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new RegularImmutableMap(ImmutableMap.entryOf(k1, v1), ImmutableMap.entryOf(k2, v2), ImmutableMap.entryOf(k3, v3), ImmutableMap.entryOf(k4, v4));
    }

    public static <K, V> ImmutableMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new RegularImmutableMap(ImmutableMap.entryOf(k1, v1), ImmutableMap.entryOf(k2, v2), ImmutableMap.entryOf(k3, v3), ImmutableMap.entryOf(k4, v4), ImmutableMap.entryOf(k5, v5));
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    static <K, V> Map.Entry<K, V> entryOf(K key, V value) {
        Preconditions.checkNotNull(key, "null key in entry: null=%s", value);
        Preconditions.checkNotNull(value, "null value in entry: %s=null", key);
        return Maps.immutableEntry(key, value);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map2) {
        if (map2 instanceof ImmutableMap && !(map2 instanceof ImmutableSortedMap)) {
            ImmutableMap kvMap = (ImmutableMap)map2;
            if (!kvMap.isPartialView()) {
                return kvMap;
            }
        } else if (map2 instanceof EnumMap) {
            EnumMap enumMap = (EnumMap)map2;
            for (Map.Entry entry : enumMap.entrySet()) {
                Preconditions.checkNotNull(entry.getKey());
                Preconditions.checkNotNull(entry.getValue());
            }
            ImmutableMap result2 = ImmutableEnumMap.asImmutable(new EnumMap(enumMap));
            return result2;
        }
        Map.Entry[] entries = map2.entrySet().toArray(new Map.Entry[0]);
        switch (entries.length) {
            case 0: {
                return ImmutableMap.of();
            }
            case 1: {
                return new SingletonImmutableBiMap(ImmutableMap.entryOf(entries[0].getKey(), entries[0].getValue()));
            }
        }
        for (int i = 0; i < entries.length; ++i) {
            Object k = entries[i].getKey();
            Object v = entries[i].getValue();
            entries[i] = ImmutableMap.entryOf(k, v);
        }
        return new RegularImmutableMap(entries);
    }

    ImmutableMap() {
    }

    @Override
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final V remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map2) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean containsKey(@Nullable Object key) {
        return this.get(key) != null;
    }

    @Override
    public boolean containsValue(@Nullable Object value) {
        return value != null && Maps.containsValueImpl(this, value);
    }

    @Override
    public abstract V get(@Nullable Object var1);

    @Override
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> result2 = this.entrySet;
        return result2 == null ? (this.entrySet = this.createEntrySet()) : result2;
    }

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    @Override
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> result2 = this.keySet;
        return result2 == null ? (this.keySet = this.createKeySet()) : result2;
    }

    ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> result2 = this.values;
        return result2 == null ? (this.values = new ImmutableMapValues(this)) : result2;
    }

    @Beta
    public ImmutableSetMultimap<K, V> asMultimap() {
        ImmutableSetMultimap<K, V> result2 = this.multimapView;
        return result2 == null ? (this.multimapView = this.createMultimapView()) : result2;
    }

    private ImmutableSetMultimap<K, V> createMultimapView() {
        ImmutableMap<K, ImmutableSet<V>> map2 = this.viewMapValuesAsSingletonSets();
        return new ImmutableSetMultimap<K, V>(map2, map2.size(), null);
    }

    private ImmutableMap<K, ImmutableSet<V>> viewMapValuesAsSingletonSets() {
        class MapViewOfValuesAsSingletonSets
        extends ImmutableMap<K, ImmutableSet<V>> {
            MapViewOfValuesAsSingletonSets() {
            }

            @Override
            public int size() {
                return ImmutableMap.this.size();
            }

            @Override
            public boolean containsKey(@Nullable Object key) {
                return ImmutableMap.this.containsKey(key);
            }

            @Override
            public ImmutableSet<V> get(@Nullable Object key) {
                Object outerValue = ImmutableMap.this.get(key);
                return outerValue == null ? null : ImmutableSet.of(outerValue);
            }

            @Override
            boolean isPartialView() {
                return false;
            }

            @Override
            ImmutableSet<Map.Entry<K, ImmutableSet<V>>> createEntrySet() {
                return new ImmutableMapEntrySet<K, ImmutableSet<V>>(){

                    @Override
                    ImmutableMap<K, ImmutableSet<V>> map() {
                        return this;
                    }

                    @Override
                    public UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> iterator() {
                        final Iterator backingIterator = ((ImmutableSet)ImmutableMap.this.entrySet()).iterator();
                        return new UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>(){

                            @Override
                            public boolean hasNext() {
                                return backingIterator.hasNext();
                            }

                            @Override
                            public Map.Entry<K, ImmutableSet<V>> next() {
                                final Map.Entry backingEntry = (Map.Entry)backingIterator.next();
                                return new AbstractMapEntry<K, ImmutableSet<V>>(){

                                    @Override
                                    public K getKey() {
                                        return backingEntry.getKey();
                                    }

                                    @Override
                                    public ImmutableSet<V> getValue() {
                                        return ImmutableSet.of(backingEntry.getValue());
                                    }
                                };
                            }
                        };
                    }
                };
            }
        }
        return new MapViewOfValuesAsSingletonSets();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Maps.equalsImpl(this, object);
    }

    abstract boolean isPartialView();

    @Override
    public int hashCode() {
        return ((ImmutableSet)this.entrySet()).hashCode();
    }

    public String toString() {
        return Maps.toStringImpl(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    static class SerializedForm
    implements Serializable {
        private final Object[] keys;
        private final Object[] values;
        private static final long serialVersionUID = 0L;

        SerializedForm(ImmutableMap<?, ?> map2) {
            this.keys = new Object[map2.size()];
            this.values = new Object[map2.size()];
            int i = 0;
            for (Map.Entry entry : map2.entrySet()) {
                this.keys[i] = entry.getKey();
                this.values[i] = entry.getValue();
                ++i;
            }
        }

        Object readResolve() {
            Builder<Object, Object> builder = new Builder<Object, Object>();
            return this.createMap(builder);
        }

        Object createMap(Builder<Object, Object> builder) {
            for (int i = 0; i < this.keys.length; ++i) {
                builder.put(this.keys[i], this.values[i]);
            }
            return builder.build();
        }
    }

    public static class Builder<K, V> {
        final ArrayList<Map.Entry<K, V>> entries = Lists.newArrayList();

        public Builder<K, V> put(K key, V value) {
            this.entries.add(ImmutableMap.entryOf(key, value));
            return this;
        }

        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (entry instanceof ImmutableEntry) {
                Preconditions.checkNotNull(key);
                Preconditions.checkNotNull(value);
                Map.Entry<K, V> immutableEntry = entry;
                this.entries.add(immutableEntry);
            } else {
                this.entries.add(ImmutableMap.entryOf(key, value));
            }
            return this;
        }

        public Builder<K, V> putAll(Map<? extends K, ? extends V> map2) {
            this.entries.ensureCapacity(this.entries.size() + map2.size());
            for (Map.Entry<K, V> entry : map2.entrySet()) {
                this.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public ImmutableMap<K, V> build() {
            return Builder.fromEntryList(this.entries);
        }

        private static <K, V> ImmutableMap<K, V> fromEntryList(List<Map.Entry<K, V>> entries) {
            int size = entries.size();
            switch (size) {
                case 0: {
                    return ImmutableMap.of();
                }
                case 1: {
                    return new SingletonImmutableBiMap<K, V>(Iterables.getOnlyElement(entries));
                }
            }
            Map.Entry[] entryArray = entries.toArray(new Map.Entry[entries.size()]);
            return new RegularImmutableMap(entryArray);
        }
    }
}

