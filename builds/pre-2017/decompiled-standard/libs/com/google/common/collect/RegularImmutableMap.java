/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.Immutable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible(serializable=true, emulated=true)
final class RegularImmutableMap<K, V>
extends ImmutableMap<K, V> {
    private final transient LinkedEntry<K, V>[] entries;
    private final transient LinkedEntry<K, V>[] table;
    private final transient int mask;
    private static final double MAX_LOAD_FACTOR = 1.2;
    private static final long serialVersionUID = 0L;

    RegularImmutableMap(Map.Entry<?, ?> ... immutableEntries) {
        int size = immutableEntries.length;
        this.entries = this.createEntryArray(size);
        int tableSize = Hashing.closedTableSize(size, 1.2);
        this.table = this.createEntryArray(tableSize);
        this.mask = tableSize - 1;
        for (int entryIndex = 0; entryIndex < size; ++entryIndex) {
            LinkedEntry<K, V> existing;
            Map.Entry<?, ?> entry = immutableEntries[entryIndex];
            Object key = entry.getKey();
            int keyHashCode = key.hashCode();
            int tableIndex = Hashing.smear(keyHashCode) & this.mask;
            LinkedEntry<?, ?> linkedEntry = RegularImmutableMap.newLinkedEntry(key, entry.getValue(), existing);
            this.table[tableIndex] = linkedEntry;
            this.entries[entryIndex] = linkedEntry;
            for (existing = this.table[tableIndex]; existing != null; existing = existing.next()) {
                Preconditions.checkArgument(!key.equals(existing.getKey()), "duplicate key: %s", key);
            }
        }
    }

    private LinkedEntry<K, V>[] createEntryArray(int size) {
        return new LinkedEntry[size];
    }

    private static <K, V> LinkedEntry<K, V> newLinkedEntry(K key, V value, @Nullable LinkedEntry<K, V> next) {
        return (LinkedEntry)((Object)(next == null ? new TerminalEntry<K, V>(key, value) : new NonTerminalEntry<K, V>(key, value, next)));
    }

    @Override
    public V get(@Nullable Object key) {
        if (key == null) {
            return null;
        }
        int index = Hashing.smear(key.hashCode()) & this.mask;
        for (LinkedEntry<K, V> entry = this.table[index]; entry != null; entry = entry.next()) {
            Object candidateKey = entry.getKey();
            if (!key.equals(candidateKey)) continue;
            return entry.getValue();
        }
        return null;
    }

    @Override
    public int size() {
        return this.entries.length;
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet();
    }

    private class EntrySet
    extends ImmutableMapEntrySet<K, V> {
        private EntrySet() {
        }

        @Override
        ImmutableMap<K, V> map() {
            return RegularImmutableMap.this;
        }

        @Override
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.asList().iterator();
        }

        @Override
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new RegularImmutableAsList(this, RegularImmutableMap.this.entries);
        }
    }

    @Immutable
    private static final class TerminalEntry<K, V>
    extends ImmutableEntry<K, V>
    implements LinkedEntry<K, V> {
        TerminalEntry(K key, V value) {
            super(key, value);
        }

        @Override
        @Nullable
        public LinkedEntry<K, V> next() {
            return null;
        }
    }

    @Immutable
    private static final class NonTerminalEntry<K, V>
    extends ImmutableEntry<K, V>
    implements LinkedEntry<K, V> {
        final LinkedEntry<K, V> next;

        NonTerminalEntry(K key, V value, LinkedEntry<K, V> next) {
            super(key, value);
            this.next = next;
        }

        @Override
        public LinkedEntry<K, V> next() {
            return this.next;
        }
    }

    private static interface LinkedEntry<K, V>
    extends Map.Entry<K, V> {
        @Nullable
        public LinkedEntry<K, V> next();
    }
}

