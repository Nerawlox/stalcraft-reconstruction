/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
class RegularImmutableBiMap<K, V>
extends ImmutableBiMap<K, V> {
    static final double MAX_LOAD_FACTOR = 1.2;
    private final transient BiMapEntry<K, V>[] kToVTable;
    private final transient BiMapEntry<K, V>[] vToKTable;
    private final transient BiMapEntry<K, V>[] entries;
    private final transient int mask;
    private final transient int hashCode;
    private transient ImmutableBiMap<V, K> inverse;

    RegularImmutableBiMap(Collection<? extends Map.Entry<? extends K, ? extends V>> entriesToAdd) {
        int n = entriesToAdd.size();
        int tableSize = Hashing.closedTableSize(n, 1.2);
        this.mask = tableSize - 1;
        BiMapEntry<K, V>[] kToVTable = RegularImmutableBiMap.createEntryArray(tableSize);
        BiMapEntry<K, V>[] vToKTable = RegularImmutableBiMap.createEntryArray(tableSize);
        BiMapEntry<K, V>[] entries = RegularImmutableBiMap.createEntryArray(n);
        int i = 0;
        int hashCode2 = 0;
        for (Map.Entry<K, V> entry : entriesToAdd) {
            BiMapEntry<K, V> nextInVToKBucket;
            BiMapEntry<K, V> nextInKToVBucket;
            K key = Preconditions.checkNotNull(entry.getKey());
            V value = Preconditions.checkNotNull(entry.getValue());
            int keyHash = key.hashCode();
            int valueHash = value.hashCode();
            int keyBucket = Hashing.smear(keyHash) & this.mask;
            int valueBucket = Hashing.smear(valueHash) & this.mask;
            for (BiMapEntry<K, V> kToVEntry = nextInKToVBucket = kToVTable[keyBucket]; kToVEntry != null; kToVEntry = kToVEntry.getNextInKToVBucket()) {
                if (!key.equals(kToVEntry.getKey())) continue;
                throw new IllegalArgumentException("Multiple entries with same key: " + entry + " and " + kToVEntry);
            }
            for (BiMapEntry<K, V> vToKEntry = nextInVToKBucket = vToKTable[valueBucket]; vToKEntry != null; vToKEntry = vToKEntry.getNextInVToKBucket()) {
                if (!value.equals(vToKEntry.getValue())) continue;
                throw new IllegalArgumentException("Multiple entries with same value: " + entry + " and " + vToKEntry);
            }
            BiMapEntry newEntry = nextInKToVBucket == null && nextInVToKBucket == null ? new BiMapEntry<K, V>(key, value) : new NonTerminalBiMapEntry<K, V>(key, value, nextInKToVBucket, nextInVToKBucket);
            kToVTable[keyBucket] = newEntry;
            vToKTable[valueBucket] = newEntry;
            entries[i++] = newEntry;
            hashCode2 += keyHash ^ valueHash;
        }
        this.kToVTable = kToVTable;
        this.vToKTable = vToKTable;
        this.entries = entries;
        this.hashCode = hashCode2;
    }

    private static <K, V> BiMapEntry<K, V>[] createEntryArray(int length) {
        return new BiMapEntry[length];
    }

    @Override
    @Nullable
    public V get(@Nullable Object key) {
        if (key == null) {
            return null;
        }
        int bucket = Hashing.smear(key.hashCode()) & this.mask;
        for (BiMapEntry<K, V> entry = this.kToVTable[bucket]; entry != null; entry = entry.getNextInKToVBucket()) {
            if (!key.equals(entry.getKey())) continue;
            return entry.getValue();
        }
        return null;
    }

    @Override
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet<K, V>(){

            @Override
            ImmutableMap<K, V> map() {
                return RegularImmutableBiMap.this;
            }

            @Override
            public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                return this.asList().iterator();
            }

            @Override
            ImmutableList<Map.Entry<K, V>> createAsList() {
                return new RegularImmutableAsList(this, RegularImmutableBiMap.this.entries);
            }

            @Override
            boolean isHashCodeFast() {
                return true;
            }

            @Override
            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }
        };
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    public int size() {
        return this.entries.length;
    }

    @Override
    public ImmutableBiMap<V, K> inverse() {
        Inverse result2 = this.inverse;
        return result2 == null ? (this.inverse = new Inverse()) : result2;
    }

    private static class InverseSerializedForm<K, V>
    implements Serializable {
        private final ImmutableBiMap<K, V> forward;
        private static final long serialVersionUID = 1L;

        InverseSerializedForm(ImmutableBiMap<K, V> forward) {
            this.forward = forward;
        }

        Object readResolve() {
            return this.forward.inverse();
        }
    }

    private final class Inverse
    extends ImmutableBiMap<V, K> {
        private Inverse() {
        }

        @Override
        public int size() {
            return this.inverse().size();
        }

        @Override
        public ImmutableBiMap<K, V> inverse() {
            return RegularImmutableBiMap.this;
        }

        @Override
        public K get(@Nullable Object value) {
            if (value == null) {
                return null;
            }
            int bucket = Hashing.smear(value.hashCode()) & RegularImmutableBiMap.this.mask;
            for (BiMapEntry entry = RegularImmutableBiMap.this.vToKTable[bucket]; entry != null; entry = entry.getNextInVToKBucket()) {
                if (!value.equals(entry.getValue())) continue;
                return entry.getKey();
            }
            return null;
        }

        @Override
        ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new InverseEntrySet();
        }

        @Override
        boolean isPartialView() {
            return false;
        }

        @Override
        Object writeReplace() {
            return new InverseSerializedForm(RegularImmutableBiMap.this);
        }

        final class InverseEntrySet
        extends ImmutableMapEntrySet<V, K> {
            InverseEntrySet() {
            }

            @Override
            ImmutableMap<V, K> map() {
                return Inverse.this;
            }

            @Override
            boolean isHashCodeFast() {
                return true;
            }

            @Override
            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }

            @Override
            public UnmodifiableIterator<Map.Entry<V, K>> iterator() {
                return this.asList().iterator();
            }

            @Override
            ImmutableList<Map.Entry<V, K>> createAsList() {
                return new ImmutableAsList<Map.Entry<V, K>>(){

                    @Override
                    public Map.Entry<V, K> get(int index) {
                        BiMapEntry entry = RegularImmutableBiMap.this.entries[index];
                        return Maps.immutableEntry(entry.getValue(), entry.getKey());
                    }

                    @Override
                    ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
                        return InverseEntrySet.this;
                    }
                };
            }
        }
    }

    private static class NonTerminalBiMapEntry<K, V>
    extends BiMapEntry<K, V> {
        @Nullable
        private final BiMapEntry<K, V> nextInKToVBucket;
        @Nullable
        private final BiMapEntry<K, V> nextInVToKBucket;

        NonTerminalBiMapEntry(K key, V value, @Nullable BiMapEntry<K, V> nextInKToVBucket, @Nullable BiMapEntry<K, V> nextInVToKBucket) {
            super(key, value);
            this.nextInKToVBucket = nextInKToVBucket;
            this.nextInVToKBucket = nextInVToKBucket;
        }

        @Override
        @Nullable
        BiMapEntry<K, V> getNextInKToVBucket() {
            return this.nextInKToVBucket;
        }

        @Override
        @Nullable
        BiMapEntry<K, V> getNextInVToKBucket() {
            return this.nextInVToKBucket;
        }
    }

    private static class BiMapEntry<K, V>
    extends ImmutableEntry<K, V> {
        BiMapEntry(K key, V value) {
            super(key, value);
        }

        @Nullable
        BiMapEntry<K, V> getNextInKToVBucket() {
            return null;
        }

        @Nullable
        BiMapEntry<K, V> getNextInVToKBucket() {
            return null;
        }
    }
}

