/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class StringMap<V>
extends AbstractMap<String, V> {
    private static final int MINIMUM_CAPACITY = 4;
    private static final int MAXIMUM_CAPACITY = 0x40000000;
    private LinkedEntry<V> header;
    private static final Map.Entry[] EMPTY_TABLE = new LinkedEntry[2];
    private LinkedEntry<V>[] table = (LinkedEntry[])EMPTY_TABLE;
    private int size;
    private int threshold = -1;
    private Set<String> keySet;
    private Set<Map.Entry<String, V>> entrySet;
    private Collection<V> values;
    private static final int seed = new Random().nextInt();

    public StringMap() {
        this.header = new LinkedEntry();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean containsKey(Object key) {
        return key instanceof String && this.getEntry((String)key) != null;
    }

    @Override
    public V get(Object key) {
        if (key instanceof String) {
            LinkedEntry<V> entry = this.getEntry((String)key);
            return entry != null ? (V)entry.value : null;
        }
        return null;
    }

    private LinkedEntry<V> getEntry(String key) {
        if (key == null) {
            return null;
        }
        int hash = StringMap.hash(key);
        LinkedEntry<V>[] tab = this.table;
        LinkedEntry<V> e = tab[hash & tab.length - 1];
        while (e != null) {
            String eKey = e.key;
            if (eKey == key || e.hash == hash && key.equals(eKey)) {
                return e;
            }
            e = e.next;
        }
        return null;
    }

    @Override
    public V put(String key, V value) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        int hash = StringMap.hash(key);
        LinkedEntry<V>[] tab = this.table;
        int index = hash & tab.length - 1;
        LinkedEntry<V> e = tab[index];
        while (e != null) {
            if (e.hash == hash && key.equals(e.key)) {
                Object oldValue = e.value;
                e.value = value;
                return oldValue;
            }
            e = e.next;
        }
        if (this.size++ > this.threshold) {
            tab = this.doubleCapacity();
            index = hash & tab.length - 1;
        }
        this.addNewEntry(key, value, hash, index);
        return null;
    }

    private void addNewEntry(String key, V value, int hash, int index) {
        LinkedEntry<V> header = this.header;
        LinkedEntry oldTail = header.prv;
        LinkedEntry<V> newTail = new LinkedEntry<V>(key, value, hash, this.table[index], header, oldTail);
        header.prv = newTail;
        oldTail.nxt = header.prv;
        this.table[index] = header.prv;
    }

    private LinkedEntry<V>[] makeTable(int newCapacity) {
        LinkedEntry[] newTable = new LinkedEntry[newCapacity];
        this.table = newTable;
        this.threshold = (newCapacity >> 1) + (newCapacity >> 2);
        return newTable;
    }

    private LinkedEntry<V>[] doubleCapacity() {
        LinkedEntry<V>[] oldTable = this.table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == 0x40000000) {
            return oldTable;
        }
        int newCapacity = oldCapacity * 2;
        LinkedEntry<V>[] newTable = this.makeTable(newCapacity);
        if (this.size == 0) {
            return newTable;
        }
        for (int j = 0; j < oldCapacity; ++j) {
            LinkedEntry<V> e = oldTable[j];
            if (e == null) continue;
            int highBit = e.hash & oldCapacity;
            LinkedEntry<V> broken = null;
            newTable[j | highBit] = e;
            LinkedEntry n = e.next;
            while (n != null) {
                int nextHighBit = n.hash & oldCapacity;
                if (nextHighBit != highBit) {
                    if (broken == null) {
                        newTable[j | nextHighBit] = n;
                    } else {
                        broken.next = n;
                    }
                    broken = e;
                    highBit = nextHighBit;
                }
                e = n;
                n = n.next;
            }
            if (broken == null) continue;
            broken.next = null;
        }
        return newTable;
    }

    @Override
    public V remove(Object key) {
        if (key == null || !(key instanceof String)) {
            return null;
        }
        int hash = StringMap.hash((String)key);
        LinkedEntry<V>[] tab = this.table;
        int index = hash & tab.length - 1;
        LinkedEntry<V> e = tab[index];
        LinkedEntry<V> prev = null;
        while (e != null) {
            if (e.hash == hash && key.equals(e.key)) {
                if (prev == null) {
                    tab[index] = e.next;
                } else {
                    prev.next = e.next;
                }
                --this.size;
                this.unlink(e);
                return e.value;
            }
            prev = e;
            e = e.next;
        }
        return null;
    }

    private void unlink(LinkedEntry<V> e) {
        e.prv.nxt = e.nxt;
        e.nxt.prv = e.prv;
        e.prv = null;
        e.nxt = null;
    }

    @Override
    public void clear() {
        if (this.size != 0) {
            Arrays.fill(this.table, null);
            this.size = 0;
        }
        LinkedEntry<V> header = this.header;
        LinkedEntry e = header.nxt;
        while (e != header) {
            LinkedEntry nxt = e.nxt;
            e.prv = null;
            e.nxt = null;
            e = nxt;
        }
        header.prv = header;
        header.nxt = header.prv;
    }

    @Override
    public Set<String> keySet() {
        KeySet ks = this.keySet;
        return ks != null ? ks : (this.keySet = new KeySet());
    }

    @Override
    public Collection<V> values() {
        Values vs = this.values;
        return vs != null ? vs : (this.values = new Values());
    }

    @Override
    public Set<Map.Entry<String, V>> entrySet() {
        EntrySet es = this.entrySet;
        return es != null ? es : (this.entrySet = new EntrySet());
    }

    private boolean removeMapping(Object key, Object value) {
        if (key == null || !(key instanceof String)) {
            return false;
        }
        int hash = StringMap.hash((String)key);
        LinkedEntry<V>[] tab = this.table;
        int index = hash & tab.length - 1;
        LinkedEntry<V> e = tab[index];
        LinkedEntry<V> prev = null;
        while (e != null) {
            if (e.hash == hash && key.equals(e.key)) {
                if (value == null ? e.value != null : !value.equals(e.value)) {
                    return false;
                }
                if (prev == null) {
                    tab[index] = e.next;
                } else {
                    prev.next = e.next;
                }
                --this.size;
                this.unlink(e);
                return true;
            }
            prev = e;
            e = e.next;
        }
        return false;
    }

    private static int hash(String key) {
        int h = seed;
        for (int i = 0; i < key.length(); ++i) {
            int h2 = h + key.charAt(i);
            int h3 = h2 + h2 << 10;
            h = h3 ^ h3 >>> 6;
        }
        h ^= h >>> 20 ^ h >>> 12;
        return h ^ h >>> 7 ^ h >>> 4;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private final class EntrySet
    extends AbstractSet<Map.Entry<String, V>> {
        private EntrySet() {
        }

        @Override
        public Iterator<Map.Entry<String, V>> iterator() {
            return new LinkedHashIterator<Map.Entry<String, V>>(){

                @Override
                public final Map.Entry<String, V> next() {
                    return this.nextEntry();
                }
            };
        }

        @Override
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry e = (Map.Entry)o;
            Object mappedValue = StringMap.this.get(e.getKey());
            return mappedValue != null && mappedValue.equals(e.getValue());
        }

        @Override
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry e = (Map.Entry)o;
            return StringMap.this.removeMapping(e.getKey(), e.getValue());
        }

        @Override
        public int size() {
            return StringMap.this.size;
        }

        @Override
        public void clear() {
            StringMap.this.clear();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private final class Values
    extends AbstractCollection<V> {
        private Values() {
        }

        @Override
        public Iterator<V> iterator() {
            return new LinkedHashIterator<V>(){

                @Override
                public final V next() {
                    return this.nextEntry().value;
                }
            };
        }

        @Override
        public int size() {
            return StringMap.this.size;
        }

        @Override
        public boolean contains(Object o) {
            return StringMap.this.containsValue(o);
        }

        @Override
        public void clear() {
            StringMap.this.clear();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private final class KeySet
    extends AbstractSet<String> {
        private KeySet() {
        }

        @Override
        public Iterator<String> iterator() {
            return new LinkedHashIterator<String>(){

                @Override
                public final String next() {
                    return this.nextEntry().key;
                }
            };
        }

        @Override
        public int size() {
            return StringMap.this.size;
        }

        @Override
        public boolean contains(Object o) {
            return StringMap.this.containsKey(o);
        }

        @Override
        public boolean remove(Object o) {
            int oldSize = StringMap.this.size;
            StringMap.this.remove(o);
            return StringMap.this.size != oldSize;
        }

        @Override
        public void clear() {
            StringMap.this.clear();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private abstract class LinkedHashIterator<T>
    implements Iterator<T> {
        LinkedEntry<V> next;
        LinkedEntry<V> lastReturned;

        private LinkedHashIterator() {
            this.next = ((StringMap)StringMap.this).header.nxt;
            this.lastReturned = null;
        }

        @Override
        public final boolean hasNext() {
            return this.next != StringMap.this.header;
        }

        final LinkedEntry<V> nextEntry() {
            LinkedEntry e = this.next;
            if (e == StringMap.this.header) {
                throw new NoSuchElementException();
            }
            this.next = e.nxt;
            this.lastReturned = e;
            return this.lastReturned;
        }

        @Override
        public final void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            StringMap.this.remove(this.lastReturned.key);
            this.lastReturned = null;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static class LinkedEntry<V>
    implements Map.Entry<String, V> {
        final String key;
        V value;
        final int hash;
        LinkedEntry<V> next;
        LinkedEntry<V> nxt;
        LinkedEntry<V> prv;

        LinkedEntry() {
            this(null, null, 0, null, null, null);
            this.prv = this;
            this.nxt = this.prv;
        }

        LinkedEntry(String key, V value, int hash, LinkedEntry<V> next, LinkedEntry<V> nxt, LinkedEntry<V> prv) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
            this.nxt = nxt;
            this.prv = prv;
        }

        @Override
        public final String getKey() {
            return this.key;
        }

        @Override
        public final V getValue() {
            return this.value;
        }

        @Override
        public final V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public final boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry e = (Map.Entry)o;
            Object eValue = e.getValue();
            return this.key.equals(e.getKey()) && (this.value == null ? eValue == null : this.value.equals(eValue));
        }

        @Override
        public final int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }
    }
}

