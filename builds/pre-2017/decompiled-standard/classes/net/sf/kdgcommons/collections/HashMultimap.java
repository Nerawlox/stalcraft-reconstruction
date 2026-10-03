/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.collections;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class HashMultimap<K, V> {
    private Behavior _behavior;
    private int _size = 0;
    private int _modCount = 0;
    private HashEntry<K, V>[] _table;
    private int _mask;
    private int _resizeThreshold;
    private int _filledSlots;
    private HashEntry<K, V> _prev;

    public HashMultimap(Behavior behavior, int n, double d) {
        this._behavior = behavior;
        int n2 = 8;
        while (n > 8) {
            n2 <<= 1;
            n >>= 1;
        }
        this._mask = n2 - 1;
        this._table = new HashEntry[n2];
        this._resizeThreshold = (int)((double)this._table.length * d);
    }

    public HashMultimap(Behavior behavior) {
        this(behavior, 8, 0.75);
    }

    public HashMultimap() {
        this(Behavior.SET, 8, 0.75);
    }

    public int size() {
        return this._size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void clear() {
        ++this._modCount;
        this._size = 0;
        for (int i = 0; i < this._table.length; ++i) {
            this._table[i] = null;
        }
    }

    public void put(K k, V v) {
        int n;
        HashEntry<K, V> hashEntry;
        if (this._filledSlots >= this._resizeThreshold) {
            this.resize();
        }
        if ((hashEntry = this.findEntry(this._table[n = this.index(k)], k, v)) != null && this._behavior == Behavior.SET) {
            return;
        }
        if (hashEntry == null) {
            hashEntry = this._table[n];
        }
        hashEntry = this.skipToEnd(hashEntry);
        ++this._size;
        ++this._modCount;
        if (hashEntry == null) {
            this._table[n] = new HashEntry<K, V>(k, v, null);
            ++this._filledSlots;
        } else {
            hashEntry.next = new HashEntry<K, V>(k, v, null);
        }
    }

    public V get(K k) {
        HashEntry<K, V> hashEntry = this.findFirstEntry(k);
        return hashEntry == null ? null : (V)hashEntry.value;
    }

    public Collection<V> getAll(K k) {
        AbstractCollection abstractCollection = this._behavior == Behavior.LIST ? new ArrayList() : new HashSet();
        Iterator<V> iterator2 = this.getIterator(k);
        while (iterator2.hasNext()) {
            abstractCollection.add(iterator2.next());
        }
        return abstractCollection;
    }

    public Iterator<V> getIterator(K k) {
        return new KeyIterator(k);
    }

    public Iterable<V> getIterable(K k) {
        return new KeyIterable(k);
    }

    public V remove(K k) {
        KeyIterator keyIterator = new KeyIterator(k);
        if (keyIterator.hasNext()) {
            Object e = keyIterator.next();
            keyIterator.remove();
            return (V)e;
        }
        return null;
    }

    public Collection<V> removeAll(K k) {
        ArrayList<V> arrayList = new ArrayList<V>();
        Iterator<V> iterator2 = this.getIterator(k);
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next());
            iterator2.remove();
        }
        return arrayList;
    }

    public boolean remove(K k, V v) {
        KeyValueIterator keyValueIterator = new KeyValueIterator(k, v);
        if (keyValueIterator.hasNext()) {
            keyValueIterator.next();
            keyValueIterator.remove();
            return true;
        }
        return false;
    }

    public Collection<V> removeAll(K k, V v) {
        ArrayList<V> arrayList = new ArrayList<V>();
        Iterator<V> iterator2 = this.getIterator(k);
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next());
            iterator2.remove();
        }
        return arrayList;
    }

    public boolean containsKey(K k) {
        return this.findFirstEntry(k) != null;
    }

    public boolean containsMapping(K k, V v) {
        return this.findFirstEntry(k, v) != null;
    }

    public Set<K> keySet() {
        HashSet hashSet = new HashSet();
        InternalEntryIterator internalEntryIterator = new InternalEntryIterator();
        while (internalEntryIterator.hasNext()) {
            hashSet.add(((HashEntry)internalEntryIterator.next()).key);
        }
        return hashSet;
    }

    public Collection<Map.Entry<K, V>> entries() {
        ArrayList<Map.Entry<K, V>> arrayList = new ArrayList<Map.Entry<K, V>>(this.size());
        Iterator<Map.Entry<K, V>> iterator2 = this.entryIterator();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next());
        }
        return arrayList;
    }

    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new PublicEntryIterator();
    }

    private int index(K k) {
        return k.hashCode() & this._mask;
    }

    private HashEntry<K, V> findFirstEntry(K k) {
        return this.findEntry(this._table[this.index(k)], k);
    }

    private HashEntry<K, V> findFirstEntry(K k, V v) {
        return this.findEntry(this._table[this.index(k)], k, v);
    }

    private HashEntry<K, V> findEntry(HashEntry<K, V> hashEntry, K k) {
        this._prev = null;
        while (hashEntry != null) {
            if (hashEntry.isEqualTo(k)) {
                return hashEntry;
            }
            this._prev = hashEntry;
            hashEntry = hashEntry.next;
        }
        return null;
    }

    private HashEntry<K, V> findEntry(HashEntry<K, V> hashEntry, K k, V v) {
        this._prev = null;
        while (hashEntry != null) {
            if (hashEntry.isEqualTo(k, v)) {
                return hashEntry;
            }
            this._prev = hashEntry;
            hashEntry = hashEntry.next;
        }
        return null;
    }

    private HashEntry<K, V> skipToEnd(HashEntry<K, V> hashEntry) {
        while (hashEntry != null && hashEntry.next != null) {
            hashEntry = hashEntry.next;
        }
        return hashEntry;
    }

    private void resize() {
        int n;
        if ((this._mask & 0x40000000) != 0) {
            this._resizeThreshold = Integer.MAX_VALUE;
            return;
        }
        HashEntry<K, V>[] hashEntryArray = this._table;
        ++this._modCount;
        this._table = new HashEntry[hashEntryArray.length * 2];
        this._mask = this._mask << 1 | 1;
        this._resizeThreshold *= 2;
        HashEntry[] hashEntryArray2 = new HashEntry[hashEntryArray.length * 2];
        for (n = 0; n < hashEntryArray.length; ++n) {
            HashEntry<Object, Object> hashEntry = hashEntryArray[n];
            while (hashEntry != null) {
                int n2 = hashEntry.key.hashCode() & this._mask;
                if (this._table[n2] == null) {
                    this._table[n2] = hashEntry;
                }
                if (hashEntryArray2[n2] != null) {
                    hashEntryArray2[n2].next = hashEntry;
                }
                hashEntryArray2[n2] = hashEntry;
                hashEntry = hashEntry.next;
            }
        }
        this._filledSlots = 0;
        for (n = 0; n < hashEntryArray2.length; ++n) {
            if (hashEntryArray2[n] == null) continue;
            hashEntryArray2[n].next = null;
            ++this._filledSlots;
        }
    }

    protected int getTableSize() {
        return this._table.length;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class PublicEntryIterator
    implements Iterator<Map.Entry<K, V>> {
        private InternalEntryIterator _realItx;

        private PublicEntryIterator() {
            this._realItx = new InternalEntryIterator();
        }

        @Override
        public boolean hasNext() {
            return this._realItx.hasNext();
        }

        @Override
        public Map.Entry<K, V> next() {
            return this._realItx.next();
        }

        @Override
        public void remove() {
            this._realItx.remove();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class InternalEntryIterator
    implements Iterator<HashEntry<K, V>> {
        protected int _myModCount;
        protected int _tableIndex;
        protected HashEntry<K, V> _current;

        public InternalEntryIterator() {
            this._myModCount = HashMultimap.this._modCount;
            this._tableIndex = 0;
            this.findNext();
        }

        @Override
        public boolean hasNext() {
            if (this._myModCount != HashMultimap.this._modCount) {
                throw new ConcurrentModificationException();
            }
            return this._current != null;
        }

        @Override
        public HashEntry<K, V> next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException("end of entry iterator");
            }
            HashEntry hashEntry = this._current;
            this.findNext();
            return hashEntry;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void findNext() {
            if (this._current != null) {
                this._current = this._current.next;
            }
            while (this._current == null && this._tableIndex < HashMultimap.this._table.length) {
                this._current = HashMultimap.this._table[this._tableIndex++];
            }
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class KeyValueIterator
    extends KeyIterator
    implements Iterator<V> {
        private V _myValue;

        public KeyValueIterator(K k, V v) {
            super(k);
            this._myValue = v;
            this._current = HashMultimap.this.findFirstEntry(k, v);
            this._pred = HashMultimap.this._prev;
        }

        @Override
        public V next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException("no more values for: " + this._myKey);
            }
            if (this._current != null) {
                this._last = this._current;
                this._pred = HashMultimap.this._prev;
                this._current = HashMultimap.this.findEntry(this._current.next, this._myKey, this._myValue);
            }
            return this._last.value;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class KeyIterator
    implements Iterator<V> {
        protected int _myModCount;
        protected K _myKey;
        protected HashEntry<K, V> _pred;
        protected HashEntry<K, V> _current;
        protected HashEntry<K, V> _last;

        public KeyIterator(K k) {
            this._myModCount = HashMultimap.this._modCount;
            this._myKey = k;
            this._current = HashMultimap.this.findFirstEntry(k);
            this._pred = HashMultimap.this._prev;
        }

        @Override
        public boolean hasNext() {
            if (this._myModCount != HashMultimap.this._modCount) {
                throw new ConcurrentModificationException();
            }
            return this._current != null;
        }

        @Override
        public V next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException("no more values for: " + this._myKey);
            }
            if (this._current != null) {
                this._last = this._current;
                this._pred = HashMultimap.this._prev;
                this._current = HashMultimap.this.findEntry(this._current.next, this._myKey);
            }
            return this._last.value;
        }

        @Override
        public void remove() {
            if (this._last == null) {
                throw new IllegalStateException("must call next()");
            }
            if (this._pred == null) {
                ((HashMultimap)HashMultimap.this)._table[((HashMultimap)HashMultimap.this).index(this._myKey)] = this._last.next;
            } else {
                this._pred.next = this._last.next;
            }
            HashMultimap.this._size--;
            this._myModCount = ++HashMultimap.this._modCount;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private class KeyIterable
    implements Iterable<V> {
        private K _myKey;

        public KeyIterable(K k) {
            this._myKey = k;
        }

        @Override
        public Iterator<V> iterator() {
            return new KeyIterator(this._myKey);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class HashEntry<KK, VV>
    implements Map.Entry<KK, VV> {
        public KK key;
        public VV value;
        public HashEntry<KK, VV> next;

        public HashEntry(KK KK, VV VV, HashEntry<KK, VV> hashEntry) {
            this.key = KK;
            this.value = VV;
            this.next = hashEntry;
        }

        public boolean isEqualTo(KK KK) {
            return this.key.equals(KK);
        }

        public boolean isEqualTo(KK KK, VV VV) {
            if (!this.isEqualTo(KK)) {
                return false;
            }
            if (this.value == null) {
                return VV == null;
            }
            return this.value.equals(VV);
        }

        public String toString() {
            return super.toString() + "[" + this.key + "," + this.value + "," + (this.next == null ? "null" : Integer.toHexString(System.identityHashCode(this.next))) + "]";
        }

        @Override
        public KK getKey() {
            return this.key;
        }

        @Override
        public VV getValue() {
            return this.value;
        }

        @Override
        public VV setValue(VV VV) {
            throw new UnsupportedOperationException();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static enum Behavior {
        LIST,
        SET;

    }
}

