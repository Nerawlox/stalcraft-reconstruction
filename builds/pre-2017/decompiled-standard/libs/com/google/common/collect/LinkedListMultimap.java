/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Iterators;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import com.google.common.collect.TransformedIterator;
import com.google.common.collect.TransformedListIterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public class LinkedListMultimap<K, V>
implements ListMultimap<K, V>,
Serializable {
    private transient Node<K, V> head;
    private transient Node<K, V> tail;
    private transient Map<K, KeyList<K, V>> keyToKeyList;
    private transient int size;
    private transient int modCount;
    private transient Set<K> keySet;
    private transient Multiset<K> keys;
    private transient List<V> valuesList;
    private transient List<Map.Entry<K, V>> entries;
    private transient Map<K, Collection<V>> map;
    @GwtIncompatible(value="java serialization not supported")
    private static final long serialVersionUID = 0L;

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<K, V>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int expectedKeys) {
        return new LinkedListMultimap<K, V>(expectedKeys);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<K, V>(multimap);
    }

    LinkedListMultimap() {
        this.keyToKeyList = Maps.newHashMap();
    }

    private LinkedListMultimap(int expectedKeys) {
        this.keyToKeyList = new HashMap<K, KeyList<K, V>>(expectedKeys);
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        this.putAll(multimap);
    }

    private Node<K, V> addNode(@Nullable K key, @Nullable V value, @Nullable Node<K, V> nextSibling) {
        Node<K, V> node = new Node<K, V>(key, value);
        if (this.head == null) {
            this.tail = node;
            this.head = this.tail;
            this.keyToKeyList.put(key, new KeyList<K, V>(node));
            ++this.modCount;
        } else if (nextSibling == null) {
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
            KeyList<K, V> keyList = this.keyToKeyList.get(key);
            if (keyList == null) {
                keyList = new KeyList<K, V>(node);
                this.keyToKeyList.put(key, keyList);
                ++this.modCount;
            } else {
                ++keyList.count;
                Node keyTail = keyList.tail;
                keyTail.nextSibling = node;
                node.previousSibling = keyTail;
                keyList.tail = node;
            }
        } else {
            KeyList<K, V> keyList = this.keyToKeyList.get(key);
            ++keyList.count;
            node.previous = nextSibling.previous;
            node.previousSibling = nextSibling.previousSibling;
            node.next = nextSibling;
            node.nextSibling = nextSibling;
            if (nextSibling.previousSibling == null) {
                this.keyToKeyList.get(key).head = node;
            } else {
                nextSibling.previousSibling.nextSibling = node;
            }
            if (nextSibling.previous == null) {
                this.head = node;
            } else {
                nextSibling.previous.next = node;
            }
            nextSibling.previous = node;
            nextSibling.previousSibling = node;
        }
        ++this.size;
        return node;
    }

    private void removeNode(Node<K, V> node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            this.head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            this.tail = node.previous;
        }
        if (node.previousSibling == null && node.nextSibling == null) {
            KeyList<K, V> keyList = this.keyToKeyList.remove(node.key);
            keyList.count = 0;
            ++this.modCount;
        } else {
            KeyList<K, V> keyList = this.keyToKeyList.get(node.key);
            --keyList.count;
            if (node.previousSibling == null) {
                keyList.head = node.nextSibling;
            } else {
                node.previousSibling.nextSibling = node.nextSibling;
            }
            if (node.nextSibling == null) {
                keyList.tail = node.previousSibling;
            } else {
                node.nextSibling.previousSibling = node.previousSibling;
            }
        }
        --this.size;
    }

    private void removeAllNodes(@Nullable Object key) {
        ValueForKeyIterator i = new ValueForKeyIterator(key);
        while (i.hasNext()) {
            i.next();
            i.remove();
        }
    }

    private static void checkElement(@Nullable Object node) {
        if (node == null) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public boolean containsKey(@Nullable Object key) {
        return this.keyToKeyList.containsKey(key);
    }

    @Override
    public boolean containsValue(@Nullable Object value) {
        NodeIterator i = new NodeIterator();
        while (i.hasNext()) {
            if (!Objects.equal(((Node)i.next()).value, value)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsEntry(@Nullable Object key, @Nullable Object value) {
        ValueForKeyIterator i = new ValueForKeyIterator(key);
        while (i.hasNext()) {
            if (!Objects.equal(i.next(), value)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean put(@Nullable K key, @Nullable V value) {
        this.addNode(key, value, null);
        return true;
    }

    @Override
    public boolean remove(@Nullable Object key, @Nullable Object value) {
        ValueForKeyIterator values2 = new ValueForKeyIterator(key);
        while (values2.hasNext()) {
            if (!Objects.equal(values2.next(), value)) continue;
            values2.remove();
            return true;
        }
        return false;
    }

    @Override
    public boolean putAll(@Nullable K key, Iterable<? extends V> values2) {
        boolean changed = false;
        for (V value : values2) {
            changed |= this.put(key, value);
        }
        return changed;
    }

    @Override
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        boolean changed = false;
        for (Map.Entry<K, V> entry : multimap.entries()) {
            changed |= this.put(entry.getKey(), entry.getValue());
        }
        return changed;
    }

    @Override
    public List<V> replaceValues(@Nullable K key, Iterable<? extends V> values2) {
        List<V> oldValues = this.getCopy(key);
        ValueForKeyIterator keyValues = new ValueForKeyIterator(key);
        Iterator<V> newValues = values2.iterator();
        while (keyValues.hasNext() && newValues.hasNext()) {
            keyValues.next();
            keyValues.set(newValues.next());
        }
        while (keyValues.hasNext()) {
            keyValues.next();
            keyValues.remove();
        }
        while (newValues.hasNext()) {
            keyValues.add(newValues.next());
        }
        return oldValues;
    }

    private List<V> getCopy(@Nullable Object key) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(key)));
    }

    @Override
    public List<V> removeAll(@Nullable Object key) {
        List<V> oldValues = this.getCopy(key);
        this.removeAllNodes(key);
        return oldValues;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        ++this.modCount;
    }

    @Override
    public List<V> get(final @Nullable K key) {
        return new AbstractSequentialList<V>(){

            @Override
            public int size() {
                KeyList keyList = (KeyList)LinkedListMultimap.this.keyToKeyList.get(key);
                return keyList == null ? 0 : keyList.count;
            }

            @Override
            public ListIterator<V> listIterator(int index) {
                return new ValueForKeyIterator(key, index);
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return Iterators.removeAll(this.iterator(), c);
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return Iterators.retainAll(this.iterator(), c);
            }
        };
    }

    @Override
    public Set<K> keySet() {
        Sets.ImprovedAbstractSet result2 = this.keySet;
        if (result2 == null) {
            this.keySet = result2 = new Sets.ImprovedAbstractSet<K>(){

                @Override
                public int size() {
                    return LinkedListMultimap.this.keyToKeyList.size();
                }

                @Override
                public Iterator<K> iterator() {
                    return new DistinctKeyIterator();
                }

                @Override
                public boolean contains(Object key) {
                    return LinkedListMultimap.this.containsKey(key);
                }

                @Override
                public boolean remove(Object o) {
                    return !LinkedListMultimap.this.removeAll(o).isEmpty();
                }
            };
        }
        return result2;
    }

    @Override
    public Multiset<K> keys() {
        MultisetView result2 = this.keys;
        if (result2 == null) {
            this.keys = result2 = new MultisetView();
        }
        return result2;
    }

    @Override
    public List<V> values() {
        AbstractSequentialList result2 = this.valuesList;
        if (result2 == null) {
            this.valuesList = result2 = new AbstractSequentialList<V>(){

                @Override
                public int size() {
                    return LinkedListMultimap.this.size;
                }

                @Override
                public ListIterator<V> listIterator(int index) {
                    final NodeIterator nodes = new NodeIterator(index);
                    return new TransformedListIterator<Node<K, V>, V>(nodes){

                        @Override
                        V transform(Node<K, V> node) {
                            return node.value;
                        }

                        @Override
                        public void set(V value) {
                            nodes.setValue(value);
                        }
                    };
                }
            };
        }
        return result2;
    }

    private static <K, V> Map.Entry<K, V> createEntry(final Node<K, V> node) {
        return new AbstractMapEntry<K, V>(){

            @Override
            public K getKey() {
                return node.key;
            }

            @Override
            public V getValue() {
                return node.value;
            }

            @Override
            public V setValue(V value) {
                Object oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        };
    }

    @Override
    public List<Map.Entry<K, V>> entries() {
        AbstractSequentialList result2 = this.entries;
        if (result2 == null) {
            this.entries = result2 = new AbstractSequentialList<Map.Entry<K, V>>(){

                @Override
                public int size() {
                    return LinkedListMultimap.this.size;
                }

                @Override
                public ListIterator<Map.Entry<K, V>> listIterator(int index) {
                    return new TransformedListIterator<Node<K, V>, Map.Entry<K, V>>(new NodeIterator(index)){

                        @Override
                        Map.Entry<K, V> transform(Node<K, V> node) {
                            return LinkedListMultimap.createEntry(node);
                        }
                    };
                }
            };
        }
        return result2;
    }

    @Override
    public Map<K, Collection<V>> asMap() {
        Multimaps.AsMap result2 = this.map;
        if (result2 == null) {
            this.map = result2 = new Multimaps.AsMap<K, V>(){

                @Override
                public int size() {
                    return LinkedListMultimap.this.keyToKeyList.size();
                }

                @Override
                Multimap<K, V> multimap() {
                    return LinkedListMultimap.this;
                }

                @Override
                Iterator<Map.Entry<K, Collection<V>>> entryIterator() {
                    return new TransformedIterator<K, Map.Entry<K, Collection<V>>>(new DistinctKeyIterator()){

                        @Override
                        Map.Entry<K, Collection<V>> transform(final K key) {
                            return new AbstractMapEntry<K, Collection<V>>(){

                                @Override
                                public K getKey() {
                                    return key;
                                }

                                @Override
                                public Collection<V> getValue() {
                                    return LinkedListMultimap.this.get(key);
                                }
                            };
                        }
                    };
                }
            };
        }
        return result2;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Multimap) {
            Multimap that = (Multimap)other;
            return this.asMap().equals(that.asMap());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.asMap().hashCode();
    }

    public String toString() {
        return this.asMap().toString();
    }

    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(this.size());
        for (Map.Entry entry : this.entries()) {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }

    @GwtIncompatible(value="java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.keyToKeyList = Maps.newLinkedHashMap();
        int size = stream.readInt();
        for (int i = 0; i < size; ++i) {
            Object key = stream.readObject();
            Object value = stream.readObject();
            this.put(key, value);
        }
    }

    private class MultisetView
    extends AbstractMultiset<K> {
        private MultisetView() {
        }

        @Override
        public int size() {
            return LinkedListMultimap.this.size;
        }

        @Override
        public int count(Object element) {
            KeyList keyList = (KeyList)LinkedListMultimap.this.keyToKeyList.get(element);
            return keyList == null ? 0 : keyList.count;
        }

        @Override
        Iterator<Multiset.Entry<K>> entryIterator() {
            return new TransformedIterator<K, Multiset.Entry<K>>(new DistinctKeyIterator()){

                @Override
                Multiset.Entry<K> transform(final K key) {
                    return new Multisets.AbstractEntry<K>(){

                        @Override
                        public K getElement() {
                            return key;
                        }

                        @Override
                        public int getCount() {
                            return ((KeyList)((LinkedListMultimap)LinkedListMultimap.this).keyToKeyList.get((Object)key)).count;
                        }
                    };
                }
            };
        }

        @Override
        int distinctElements() {
            return this.elementSet().size();
        }

        @Override
        public Iterator<K> iterator() {
            return new TransformedIterator<Node<K, V>, K>(new NodeIterator()){

                @Override
                K transform(Node<K, V> node) {
                    return node.key;
                }
            };
        }

        @Override
        public int remove(@Nullable Object key, int occurrences) {
            Preconditions.checkArgument(occurrences >= 0);
            int oldCount = this.count(key);
            ValueForKeyIterator values2 = new ValueForKeyIterator(key);
            while (occurrences-- > 0 && values2.hasNext()) {
                values2.next();
                values2.remove();
            }
            return oldCount;
        }

        @Override
        public Set<K> elementSet() {
            return LinkedListMultimap.this.keySet();
        }
    }

    private class ValueForKeyIterator
    implements ListIterator<V> {
        final Object key;
        int nextIndex;
        Node<K, V> next;
        Node<K, V> current;
        Node<K, V> previous;

        ValueForKeyIterator(Object key) {
            this.key = key;
            KeyList keyList = (KeyList)LinkedListMultimap.this.keyToKeyList.get(key);
            this.next = keyList == null ? null : keyList.head;
        }

        public ValueForKeyIterator(Object key, int index) {
            KeyList keyList = (KeyList)LinkedListMultimap.this.keyToKeyList.get(key);
            int size = keyList == null ? 0 : keyList.count;
            Preconditions.checkPositionIndex(index, size);
            if (index >= size / 2) {
                this.previous = keyList == null ? null : keyList.tail;
                this.nextIndex = size;
                while (index++ < size) {
                    this.previous();
                }
            } else {
                Node node = this.next = keyList == null ? null : keyList.head;
                while (index-- > 0) {
                    this.next();
                }
            }
            this.key = key;
            this.current = null;
        }

        @Override
        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public V next() {
            LinkedListMultimap.checkElement(this.next);
            this.current = this.next;
            this.previous = this.current;
            this.next = this.next.nextSibling;
            ++this.nextIndex;
            return this.current.value;
        }

        @Override
        public boolean hasPrevious() {
            return this.previous != null;
        }

        @Override
        public V previous() {
            LinkedListMultimap.checkElement(this.previous);
            this.current = this.previous;
            this.next = this.current;
            this.previous = this.previous.previousSibling;
            --this.nextIndex;
            return this.current.value;
        }

        @Override
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override
        public int previousIndex() {
            return this.nextIndex - 1;
        }

        @Override
        public void remove() {
            Preconditions.checkState(this.current != null);
            if (this.current != this.next) {
                this.previous = this.current.previousSibling;
                --this.nextIndex;
            } else {
                this.next = this.current.nextSibling;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
        }

        @Override
        public void set(V value) {
            Preconditions.checkState(this.current != null);
            this.current.value = value;
        }

        @Override
        public void add(V value) {
            this.previous = LinkedListMultimap.this.addNode(this.key, value, this.next);
            ++this.nextIndex;
            this.current = null;
        }
    }

    private class DistinctKeyIterator
    implements Iterator<K> {
        final Set<K> seenKeys;
        Node<K, V> next;
        Node<K, V> current;
        int expectedModCount;

        private DistinctKeyIterator() {
            this.seenKeys = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.next = LinkedListMultimap.this.head;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            this.checkForConcurrentModification();
            return this.next != null;
        }

        @Override
        public K next() {
            this.checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.next);
            this.current = this.next;
            this.seenKeys.add(this.current.key);
            do {
                this.next = this.next.next;
            } while (this.next != null && !this.seenKeys.add(this.next.key));
            return this.current.key;
        }

        @Override
        public void remove() {
            this.checkForConcurrentModification();
            Preconditions.checkState(this.current != null);
            LinkedListMultimap.this.removeAllNodes(this.current.key);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }
    }

    private class NodeIterator
    implements ListIterator<Node<K, V>> {
        int nextIndex;
        Node<K, V> next;
        Node<K, V> current;
        Node<K, V> previous;
        int expectedModCount;

        NodeIterator() {
            this.expectedModCount = LinkedListMultimap.this.modCount;
            this.next = LinkedListMultimap.this.head;
        }

        NodeIterator(int index) {
            this.expectedModCount = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(index, size);
            if (index >= size / 2) {
                this.previous = LinkedListMultimap.this.tail;
                this.nextIndex = size;
                while (index++ < size) {
                    this.previous();
                }
            } else {
                this.next = LinkedListMultimap.this.head;
                while (index-- > 0) {
                    this.next();
                }
            }
            this.current = null;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            this.checkForConcurrentModification();
            return this.next != null;
        }

        @Override
        public Node<K, V> next() {
            this.checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.next);
            this.current = this.next;
            this.previous = this.current;
            this.next = this.next.next;
            ++this.nextIndex;
            return this.current;
        }

        @Override
        public void remove() {
            this.checkForConcurrentModification();
            Preconditions.checkState(this.current != null);
            if (this.current != this.next) {
                this.previous = this.current.previous;
                --this.nextIndex;
            } else {
                this.next = this.current.next;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        @Override
        public boolean hasPrevious() {
            this.checkForConcurrentModification();
            return this.previous != null;
        }

        @Override
        public Node<K, V> previous() {
            this.checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.previous);
            this.current = this.previous;
            this.next = this.current;
            this.previous = this.previous.previous;
            --this.nextIndex;
            return this.current;
        }

        @Override
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override
        public int previousIndex() {
            return this.nextIndex - 1;
        }

        @Override
        public void set(Node<K, V> e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(Node<K, V> e) {
            throw new UnsupportedOperationException();
        }

        void setValue(V value) {
            Preconditions.checkState(this.current != null);
            this.current.value = value;
        }
    }

    private static class KeyList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;
        int count;

        KeyList(Node<K, V> firstNode) {
            this.head = firstNode;
            this.tail = firstNode;
            firstNode.previousSibling = null;
            firstNode.nextSibling = null;
            this.count = 1;
        }
    }

    private static final class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        Node<K, V> previous;
        Node<K, V> nextSibling;
        Node<K, V> previousSibling;

        Node(@Nullable K key, @Nullable V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }
}

