/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.EmptyImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.SingletonImmutableBiMap;
import java.util.Collection;
import java.util.Map;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableBiMap<K, V>
extends ImmutableMap<K, V>
implements BiMap<K, V> {
    public static <K, V> ImmutableBiMap<K, V> of() {
        return EmptyImmutableBiMap.INSTANCE;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k1, V v1) {
        Preconditions.checkNotNull(k1, "null key in entry: null=%s", v1);
        Preconditions.checkNotNull(v1, "null value in entry: %s=null", k1);
        return new SingletonImmutableBiMap<K, V>(k1, v1);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k1, V v1, K k2, V v2) {
        return ((Builder)((Builder)new Builder().put((Object)k1, (Object)v1)).put((Object)k2, (Object)v2)).build();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return ((Builder)((Builder)((Builder)new Builder().put((Object)k1, (Object)v1)).put((Object)k2, (Object)v2)).put((Object)k3, (Object)v3)).build();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ((Builder)((Builder)((Builder)((Builder)new Builder().put((Object)k1, (Object)v1)).put((Object)k2, (Object)v2)).put((Object)k3, (Object)v3)).put((Object)k4, (Object)v4)).build();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ((Builder)((Builder)((Builder)((Builder)((Builder)new Builder().put((Object)k1, (Object)v1)).put((Object)k2, (Object)v2)).put((Object)k3, (Object)v3)).put((Object)k4, (Object)v4)).put((Object)k5, (Object)v5)).build();
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map2) {
        ImmutableBiMap bimap;
        if (map2 instanceof ImmutableBiMap && !(bimap = (ImmutableBiMap)map2).isPartialView()) {
            return bimap;
        }
        return ImmutableBiMap.fromEntries(ImmutableList.copyOf(map2.entrySet()));
    }

    static <K, V> ImmutableBiMap<K, V> fromEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> entries) {
        switch (entries.size()) {
            case 0: {
                return ImmutableBiMap.of();
            }
            case 1: {
                Map.Entry<K, V> entry = Iterables.getOnlyElement(entries);
                return new SingletonImmutableBiMap<K, V>(entry.getKey(), entry.getValue());
            }
        }
        return new RegularImmutableBiMap(entries);
    }

    ImmutableBiMap() {
    }

    @Override
    public abstract ImmutableBiMap<V, K> inverse();

    @Override
    public ImmutableSet<V> values() {
        return ((ImmutableMap)((Object)this.inverse())).keySet();
    }

    @Override
    @Deprecated
    public V forcePut(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    Object writeReplace() {
        return new SerializedForm(this);
    }

    private static class SerializedForm
    extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0L;

        SerializedForm(ImmutableBiMap<?, ?> bimap) {
            super(bimap);
        }

        @Override
        Object readResolve() {
            Builder<Object, Object> builder = new Builder<Object, Object>();
            return this.createMap(builder);
        }
    }

    public static final class Builder<K, V>
    extends ImmutableMap.Builder<K, V> {
        @Override
        public Builder<K, V> put(K key, V value) {
            super.put(key, value);
            return this;
        }

        @Override
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map2) {
            super.putAll(map2);
            return this;
        }

        @Override
        public ImmutableBiMap<K, V> build() {
            return ImmutableBiMap.fromEntries(this.entries);
        }
    }
}

