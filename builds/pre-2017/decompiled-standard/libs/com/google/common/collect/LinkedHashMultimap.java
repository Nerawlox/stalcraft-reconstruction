/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.AbstractSetMultimap;
import com.google.common.collect.Hashing;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public final class LinkedHashMultimap<K, V>
extends AbstractSetMultimap<K, V> {
    private static final int DEFAULT_KEY_CAPACITY = 16;
    private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    @VisibleForTesting
    static final double VALUE_SET_LOAD_FACTOR = 1.0;
    @VisibleForTesting
    transient int valueSetCapacity = 2;
    private transient ValueEntry<K, V> multimapHeaderEntry;
    @GwtIncompatible(value="java serialization not supported")
    private static final long serialVersionUID = 1L;

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<K, V>(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int expectedKeys, int expectedValuesPerKey) {
        return new LinkedHashMultimap<K, V>(Maps.capacity(expectedKeys), Maps.capacity(expectedValuesPerKey));
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> result2 = LinkedHashMultimap.create(multimap.keySet().size(), 2);
        result2.putAll((Multimap)multimap);
        return result2;
    }

    private static <K, V> void succeedsInValueSet(ValueSetLink<K, V> pred, ValueSetLink<K, V> succ) {
        pred.setSuccessorInValueSet(succ);
        succ.setPredecessorInValueSet(pred);
    }

    private static <K, V> void succeedsInMultimap(ValueEntry<K, V> pred, ValueEntry<K, V> succ) {
        pred.setSuccessorInMultimap(succ);
        succ.setPredecessorInMultimap(pred);
    }

    private static <K, V> void deleteFromValueSet(ValueSetLink<K, V> entry) {
        LinkedHashMultimap.succeedsInValueSet(entry.getPredecessorInValueSet(), entry.getSuccessorInValueSet());
    }

    private static <K, V> void deleteFromMultimap(ValueEntry<K, V> entry) {
        LinkedHashMultimap.succeedsInMultimap(entry.getPredecessorInMultimap(), entry.getSuccessorInMultimap());
    }

    private LinkedHashMultimap(int keyCapacity, int valueSetCapacity) {
        super(new LinkedHashMap(keyCapacity));
        Preconditions.checkArgument(valueSetCapacity >= 0, "expectedValuesPerKey must be >= 0 but was %s", valueSetCapacity);
        this.valueSetCapacity = valueSetCapacity;
        this.multimapHeaderEntry = new ValueEntry<Object, Object>(null, null, 0, null);
        LinkedHashMultimap.succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
    }

    @Override
    Set<V> createCollection() {
        return new LinkedHashSet(this.valueSetCapacity);
    }

    @Override
    Collection<V> createCollection(K key) {
        return new ValueSet(key, this.valueSetCapacity);
    }

    @Override
    public Set<V> replaceValues(@Nullable K key, Iterable<? extends V> values2) {
        return super.replaceValues((Object)key, (Iterable)values2);
    }

    @Override
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override
    public Collection<V> values() {
        return super.values();
    }

    @Override
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new Iterator<Map.Entry<K, V>>(){
            ValueEntry<K, V> nextEntry;
            ValueEntry<K, V> toRemove;
            {
                this.nextEntry = ((LinkedHashMultimap)LinkedHashMultimap.this).multimapHeaderEntry.successorInMultimap;
            }

            @Override
            public boolean hasNext() {
                return this.nextEntry != LinkedHashMultimap.this.multimapHeaderEntry;
            }

            @Override
            public Map.Entry<K, V> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                ValueEntry result2 = this.nextEntry;
                this.toRemove = result2;
                this.nextEntry = this.nextEntry.successorInMultimap;
                return result2;
            }

            @Override
            public void remove() {
                Iterators.checkRemove(this.toRemove != null);
                LinkedHashMultimap.this.remove(this.toRemove.getKey(), this.toRemove.getValue());
                this.toRemove = null;
            }
        };
    }

    @Override
    public void clear() {
        super.clear();
        LinkedHashMultimap.succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(this.valueSetCapacity);
        stream.writeInt(this.keySet().size());
        for (Object key : this.keySet()) {
            stream.writeObject(key);
        }
        stream.writeInt(this.size());
        for (Map.Entry entry : this.entries()) {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.multimapHeaderEntry = new ValueEntry<Object, Object>(null, null, 0, null);
        LinkedHashMultimap.succeedsInMultimap(this.multimapHeaderEntry, this.multimapHeaderEntry);
        this.valueSetCapacity = stream.readInt();
        int distinctKeys = stream.readInt();
        LinkedHashMap<Object, Collection<V>> map2 = new LinkedHashMap<Object, Collection<V>>(Maps.capacity(distinctKeys));
        for (int i = 0; i < distinctKeys; ++i) {
            Object key = stream.readObject();
            map2.put(key, this.createCollection(key));
        }
        int entries = stream.readInt();
        for (int i = 0; i < entries; ++i) {
            Object key = stream.readObject();
            Object value = stream.readObject();
            ((Collection)map2.get(key)).add(value);
        }
        this.setMap(map2);
    }

    @VisibleForTesting
    final class ValueSet
    extends Sets.ImprovedAbstractSet<V>
    implements ValueSetLink<K, V> {
        private final K key;
        @VisibleForTesting
        ValueEntry<K, V>[] hashTable;
        private int size = 0;
        private int modCount = 0;
        private ValueSetLink<K, V> firstEntry;
        private ValueSetLink<K, V> lastEntry;

        ValueSet(K key, int expectedValues) {
            this.key = key;
            this.firstEntry = this;
            this.lastEntry = this;
            int tableSize = Hashing.closedTableSize(expectedValues, 1.0);
            ValueEntry[] hashTable = new ValueEntry[tableSize];
            this.hashTable = hashTable;
        }

        @Override
        public ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.lastEntry;
        }

        @Override
        public ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.firstEntry;
        }

        @Override
        public void setPredecessorInValueSet(ValueSetLink<K, V> entry) {
            this.lastEntry = entry;
        }

        @Override
        public void setSuccessorInValueSet(ValueSetLink<K, V> entry) {
            this.firstEntry = entry;
        }

        @Override
        public Iterator<V> iterator() {
            return new Iterator<V>(){
                ValueSetLink<K, V> nextEntry;
                ValueEntry<K, V> toRemove;
                int expectedModCount;
                {
                    this.nextEntry = ValueSet.this.firstEntry;
                    this.expectedModCount = ValueSet.this.modCount;
                }

                private void checkForComodification() {
                    if (ValueSet.this.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override
                public boolean hasNext() {
                    this.checkForComodification();
                    return this.nextEntry != ValueSet.this;
                }

                @Override
                public V next() {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    ValueEntry entry = (ValueEntry)this.nextEntry;
                    Object result2 = entry.getValue();
                    this.toRemove = entry;
                    this.nextEntry = entry.getSuccessorInValueSet();
                    return result2;
                }

                @Override
                public void remove() {
                    this.checkForComodification();
                    Iterators.checkRemove(this.toRemove != null);
                    Object o = this.toRemove.getValue();
                    int hash = o == null ? 0 : o.hashCode();
                    int row = Hashing.smear(hash) & ValueSet.this.hashTable.length - 1;
                    ValueEntry prev = null;
                    ValueEntry entry = ValueSet.this.hashTable[row];
                    while (entry != null) {
                        if (entry == this.toRemove) {
                            if (prev == null) {
                                ValueSet.this.hashTable[row] = entry.nextInValueSetHashRow;
                            } else {
                                prev.nextInValueSetHashRow = entry.nextInValueSetHashRow;
                            }
                            LinkedHashMultimap.deleteFromValueSet(this.toRemove);
                            LinkedHashMultimap.deleteFromMultimap(this.toRemove);
                            ValueSet.this.size--;
                            this.expectedModCount = ++ValueSet.this.modCount;
                            break;
                        }
                        prev = entry;
                        entry = entry.nextInValueSetHashRow;
                    }
                    this.toRemove = null;
                }
            };
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public boolean contains(@Nullable Object o) {
            int hash = o == null ? 0 : o.hashCode();
            int row = Hashing.smear(hash) & this.hashTable.length - 1;
            ValueEntry entry = this.hashTable[row];
            while (entry != null) {
                if (hash == entry.valueHash && Objects.equal(o, entry.getValue())) {
                    return true;
                }
                entry = entry.nextInValueSetHashRow;
            }
            return false;
        }

        @Override
        public boolean add(@Nullable V value) {
            ValueEntry rowHead;
            int hash = value == null ? 0 : value.hashCode();
            int row = Hashing.smear(hash) & this.hashTable.length - 1;
            ValueEntry entry = rowHead = this.hashTable[row];
            while (entry != null) {
                if (hash == entry.valueHash && Objects.equal(value, entry.getValue())) {
                    return false;
                }
                entry = entry.nextInValueSetHashRow;
            }
            ValueEntry newEntry = new ValueEntry(this.key, value, hash, rowHead);
            LinkedHashMultimap.succeedsInValueSet(this.lastEntry, newEntry);
            LinkedHashMultimap.succeedsInValueSet(newEntry, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), newEntry);
            LinkedHashMultimap.succeedsInMultimap(newEntry, LinkedHashMultimap.this.multimapHeaderEntry);
            this.hashTable[row] = newEntry;
            ++this.size;
            ++this.modCount;
            this.rehashIfNecessary();
            return true;
        }

        private void rehashIfNecessary() {
            if (Hashing.needsResizing(this.size, this.hashTable.length, 1.0)) {
                ValueEntry[] hashTable = new ValueEntry[this.hashTable.length * 2];
                this.hashTable = hashTable;
                int mask = hashTable.length - 1;
                for (ValueSetLink entry = this.firstEntry; entry != this; entry = entry.getSuccessorInValueSet()) {
                    ValueEntry valueEntry = (ValueEntry)entry;
                    int row = Hashing.smear(valueEntry.valueHash) & mask;
                    valueEntry.nextInValueSetHashRow = hashTable[row];
                    hashTable[row] = valueEntry;
                }
            }
        }

        @Override
        public boolean remove(@Nullable Object o) {
            int hash = o == null ? 0 : o.hashCode();
            int row = Hashing.smear(hash) & this.hashTable.length - 1;
            ValueEntry prev = null;
            ValueEntry entry = this.hashTable[row];
            while (entry != null) {
                if (hash == entry.valueHash && Objects.equal(o, entry.getValue())) {
                    if (prev == null) {
                        this.hashTable[row] = entry.nextInValueSetHashRow;
                    } else {
                        prev.nextInValueSetHashRow = entry.nextInValueSetHashRow;
                    }
                    LinkedHashMultimap.deleteFromValueSet(entry);
                    LinkedHashMultimap.deleteFromMultimap(entry);
                    --this.size;
                    ++this.modCount;
                    return true;
                }
                prev = entry;
                entry = entry.nextInValueSetHashRow;
            }
            return false;
        }

        @Override
        public void clear() {
            Arrays.fill(this.hashTable, null);
            this.size = 0;
            for (ValueSetLink entry = this.firstEntry; entry != this; entry = entry.getSuccessorInValueSet()) {
                ValueEntry valueEntry = (ValueEntry)entry;
                LinkedHashMultimap.deleteFromMultimap(valueEntry);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            ++this.modCount;
        }
    }

    @VisibleForTesting
    static final class ValueEntry<K, V>
    extends AbstractMapEntry<K, V>
    implements ValueSetLink<K, V> {
        final K key;
        final V value;
        final int valueHash;
        @Nullable
        ValueEntry<K, V> nextInValueSetHashRow;
        ValueSetLink<K, V> predecessorInValueSet;
        ValueSetLink<K, V> successorInValueSet;
        ValueEntry<K, V> predecessorInMultimap;
        ValueEntry<K, V> successorInMultimap;

        ValueEntry(@Nullable K key, @Nullable V value, int valueHash, @Nullable ValueEntry<K, V> nextInValueSetHashRow) {
            this.key = key;
            this.value = value;
            this.valueHash = valueHash;
            this.nextInValueSetHashRow = nextInValueSetHashRow;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.predecessorInValueSet;
        }

        @Override
        public ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.successorInValueSet;
        }

        @Override
        public void setPredecessorInValueSet(ValueSetLink<K, V> entry) {
            this.predecessorInValueSet = entry;
        }

        @Override
        public void setSuccessorInValueSet(ValueSetLink<K, V> entry) {
            this.successorInValueSet = entry;
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            return this.predecessorInMultimap;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            return this.successorInMultimap;
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> multimapSuccessor) {
            this.successorInMultimap = multimapSuccessor;
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> multimapPredecessor) {
            this.predecessorInMultimap = multimapPredecessor;
        }
    }

    private static interface ValueSetLink<K, V> {
        public ValueSetLink<K, V> getPredecessorInValueSet();

        public ValueSetLink<K, V> getSuccessorInValueSet();

        public void setPredecessorInValueSet(ValueSetLink<K, V> var1);

        public void setSuccessorInValueSet(ValueSetLink<K, V> var1);
    }
}

