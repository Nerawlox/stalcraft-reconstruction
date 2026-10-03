/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.StandardTable$Column.KeySet
 *  com.google.common.collect.StandardTable$Column.Values
 *  com.google.common.collect.StandardTable$ColumnMap.ColumnMapValues
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.Collections2;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.GwtTransient;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.StandardTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.TransformedIterator;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class StandardTable<R, C, V>
implements Table<R, C, V>,
Serializable {
    @GwtTransient
    final Map<R, Map<C, V>> backingMap;
    @GwtTransient
    final Supplier<? extends Map<C, V>> factory;
    private transient CellSet cellSet;
    private transient RowKeySet rowKeySet;
    private transient Set<C> columnKeySet;
    private transient Values values;
    private transient RowMap rowMap;
    private transient ColumnMap columnMap;
    private static final long serialVersionUID = 0L;

    StandardTable(Map<R, Map<C, V>> backingMap, Supplier<? extends Map<C, V>> factory) {
        this.backingMap = backingMap;
        this.factory = factory;
    }

    @Override
    public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey) {
        if (rowKey == null || columnKey == null) {
            return false;
        }
        Map<C, V> map2 = Maps.safeGet(this.backingMap, rowKey);
        return map2 != null && Maps.safeContainsKey(map2, columnKey);
    }

    @Override
    public boolean containsColumn(@Nullable Object columnKey) {
        if (columnKey == null) {
            return false;
        }
        for (Map<C, V> map2 : this.backingMap.values()) {
            if (!Maps.safeContainsKey(map2, columnKey)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsRow(@Nullable Object rowKey) {
        return rowKey != null && Maps.safeContainsKey(this.backingMap, rowKey);
    }

    @Override
    public boolean containsValue(@Nullable Object value) {
        if (value == null) {
            return false;
        }
        for (Map<C, V> map2 : this.backingMap.values()) {
            if (!map2.containsValue(value)) continue;
            return true;
        }
        return false;
    }

    @Override
    public V get(@Nullable Object rowKey, @Nullable Object columnKey) {
        if (rowKey == null || columnKey == null) {
            return null;
        }
        Map<C, V> map2 = Maps.safeGet(this.backingMap, rowKey);
        return map2 == null ? null : (V)Maps.safeGet(map2, columnKey);
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public int size() {
        int size = 0;
        for (Map<C, V> map2 : this.backingMap.values()) {
            size += map2.size();
        }
        return size;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Table) {
            Table other = (Table)obj;
            return this.cellSet().equals(other.cellSet());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.cellSet().hashCode();
    }

    public String toString() {
        return this.rowMap().toString();
    }

    @Override
    public void clear() {
        this.backingMap.clear();
    }

    private Map<C, V> getOrCreate(R rowKey) {
        Map<C, V> map2 = this.backingMap.get(rowKey);
        if (map2 == null) {
            map2 = this.factory.get();
            this.backingMap.put(rowKey, map2);
        }
        return map2;
    }

    @Override
    public V put(R rowKey, C columnKey, V value) {
        Preconditions.checkNotNull(rowKey);
        Preconditions.checkNotNull(columnKey);
        Preconditions.checkNotNull(value);
        return this.getOrCreate(rowKey).put(columnKey, value);
    }

    @Override
    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Table.Cell<R, C, V> cell : table.cellSet()) {
            this.put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    @Override
    public V remove(@Nullable Object rowKey, @Nullable Object columnKey) {
        if (rowKey == null || columnKey == null) {
            return null;
        }
        Map<C, V> map2 = Maps.safeGet(this.backingMap, rowKey);
        if (map2 == null) {
            return null;
        }
        V value = map2.remove(columnKey);
        if (map2.isEmpty()) {
            this.backingMap.remove(rowKey);
        }
        return value;
    }

    private Map<R, V> removeColumn(Object column) {
        LinkedHashMap<R, V> output = new LinkedHashMap<R, V>();
        Iterator<Map.Entry<R, Map<C, V>>> iterator2 = this.backingMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<R, Map<C, V>> entry = iterator2.next();
            V value = entry.getValue().remove(column);
            if (value == null) continue;
            output.put(entry.getKey(), value);
            if (!entry.getValue().isEmpty()) continue;
            iterator2.remove();
        }
        return output;
    }

    private boolean containsMapping(Object rowKey, Object columnKey, Object value) {
        return value != null && value.equals(this.get(rowKey, columnKey));
    }

    private boolean removeMapping(Object rowKey, Object columnKey, Object value) {
        if (this.containsMapping(rowKey, columnKey, value)) {
            this.remove(rowKey, columnKey);
            return true;
        }
        return false;
    }

    @Override
    public Set<Table.Cell<R, C, V>> cellSet() {
        CellSet result2 = this.cellSet;
        return result2 == null ? (this.cellSet = new CellSet()) : result2;
    }

    @Override
    public Map<C, V> row(R rowKey) {
        return new Row(rowKey);
    }

    @Override
    public Map<R, V> column(C columnKey) {
        return new Column(columnKey);
    }

    @Override
    public Set<R> rowKeySet() {
        RowKeySet result2 = this.rowKeySet;
        return result2 == null ? (this.rowKeySet = new RowKeySet()) : result2;
    }

    @Override
    public Set<C> columnKeySet() {
        ColumnKeySet result2 = this.columnKeySet;
        return result2 == null ? (this.columnKeySet = new ColumnKeySet()) : result2;
    }

    Iterator<C> createColumnKeyIterator() {
        return new ColumnKeyIterator();
    }

    @Override
    public Collection<V> values() {
        Values result2 = this.values;
        return result2 == null ? (this.values = new Values()) : result2;
    }

    @Override
    public Map<R, Map<C, V>> rowMap() {
        RowMap result2 = this.rowMap;
        return result2 == null ? (this.rowMap = new RowMap()) : result2;
    }

    @Override
    public Map<C, Map<R, V>> columnMap() {
        ColumnMap result2 = this.columnMap;
        return result2 == null ? (this.columnMap = new ColumnMap()) : result2;
    }

    private class ColumnMap
    extends Maps.ImprovedAbstractMap<C, Map<R, V>> {
        com.google.common.collect.StandardTable$ColumnMap.ColumnMapValues columnMapValues;

        private ColumnMap() {
        }

        @Override
        public Map<R, V> get(Object key) {
            return StandardTable.this.containsColumn(key) ? StandardTable.this.column(key) : null;
        }

        @Override
        public boolean containsKey(Object key) {
            return StandardTable.this.containsColumn(key);
        }

        @Override
        public Map<R, V> remove(Object key) {
            return StandardTable.this.containsColumn(key) ? StandardTable.this.removeColumn(key) : null;
        }

        @Override
        public Set<Map.Entry<C, Map<R, V>>> createEntrySet() {
            return new ColumnMapEntrySet();
        }

        @Override
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }

        @Override
        public Collection<Map<R, V>> values() {
            com.google.common.collect.StandardTable$ColumnMap.ColumnMapValues result2 = this.columnMapValues;
            return result2 == null ? (this.columnMapValues = new ColumnMapValues()) : result2;
        }

        private class ColumnMapValues
        extends TableCollection<Map<R, V>> {
            private ColumnMapValues() {
            }

            @Override
            public Iterator<Map<R, V>> iterator() {
                return Maps.valueIterator(ColumnMap.this.entrySet().iterator());
            }

            @Override
            public boolean remove(Object obj) {
                for (Map.Entry entry : ColumnMap.this.entrySet()) {
                    if (!((Map)entry.getValue()).equals(obj)) continue;
                    StandardTable.this.removeColumn(entry.getKey());
                    return true;
                }
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                Preconditions.checkNotNull(c);
                boolean changed = false;
                for (Object columnKey : Lists.newArrayList(StandardTable.this.columnKeySet().iterator())) {
                    if (!c.contains(StandardTable.this.column(columnKey))) continue;
                    StandardTable.this.removeColumn(columnKey);
                    changed = true;
                }
                return changed;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                Preconditions.checkNotNull(c);
                boolean changed = false;
                for (Object columnKey : Lists.newArrayList(StandardTable.this.columnKeySet().iterator())) {
                    if (c.contains(StandardTable.this.column(columnKey))) continue;
                    StandardTable.this.removeColumn(columnKey);
                    changed = true;
                }
                return changed;
            }

            @Override
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }

        class ColumnMapEntrySet
        extends TableSet<Map.Entry<C, Map<R, V>>> {
            ColumnMapEntrySet() {
            }

            @Override
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return new TransformedIterator<C, Map.Entry<C, Map<R, V>>>(StandardTable.this.columnKeySet().iterator()){

                    @Override
                    Map.Entry<C, Map<R, V>> transform(C columnKey) {
                        return new ImmutableEntry(columnKey, StandardTable.this.column(columnKey));
                    }
                };
            }

            @Override
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }

            @Override
            public boolean contains(Object obj) {
                Map.Entry entry;
                if (obj instanceof Map.Entry && StandardTable.this.containsColumn((entry = (Map.Entry)obj).getKey())) {
                    Object columnKey = entry.getKey();
                    return ColumnMap.this.get(columnKey).equals(entry.getValue());
                }
                return false;
            }

            @Override
            public boolean remove(Object obj) {
                if (this.contains(obj)) {
                    Map.Entry entry = (Map.Entry)obj;
                    StandardTable.this.removeColumn(entry.getKey());
                    return true;
                }
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                boolean changed = false;
                for (Object obj : c) {
                    changed |= this.remove(obj);
                }
                return changed;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                boolean changed = false;
                for (Object columnKey : Lists.newArrayList(StandardTable.this.columnKeySet().iterator())) {
                    if (c.contains(new ImmutableEntry(columnKey, StandardTable.this.column(columnKey)))) continue;
                    StandardTable.this.removeColumn(columnKey);
                    changed = true;
                }
                return changed;
            }
        }
    }

    class RowMap
    extends Maps.ImprovedAbstractMap<R, Map<C, V>> {
        RowMap() {
        }

        @Override
        public boolean containsKey(Object key) {
            return StandardTable.this.containsRow(key);
        }

        @Override
        public Map<C, V> get(Object key) {
            return StandardTable.this.containsRow(key) ? StandardTable.this.row(key) : null;
        }

        @Override
        public Set<R> keySet() {
            return StandardTable.this.rowKeySet();
        }

        @Override
        public Map<C, V> remove(Object key) {
            return key == null ? null : StandardTable.this.backingMap.remove(key);
        }

        @Override
        protected Set<Map.Entry<R, Map<C, V>>> createEntrySet() {
            return new EntrySet();
        }

        class EntrySet
        extends TableSet<Map.Entry<R, Map<C, V>>> {
            EntrySet() {
            }

            @Override
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return new TransformedIterator<R, Map.Entry<R, Map<C, V>>>(StandardTable.this.backingMap.keySet().iterator()){

                    @Override
                    Map.Entry<R, Map<C, V>> transform(R rowKey) {
                        return new ImmutableEntry(rowKey, StandardTable.this.row(rowKey));
                    }
                };
            }

            @Override
            public int size() {
                return StandardTable.this.backingMap.size();
            }

            @Override
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry)obj;
                    return entry.getKey() != null && entry.getValue() instanceof Map && Collections2.safeContains(StandardTable.this.backingMap.entrySet(), entry);
                }
                return false;
            }

            @Override
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry)obj;
                    return entry.getKey() != null && entry.getValue() instanceof Map && StandardTable.this.backingMap.entrySet().remove(entry);
                }
                return false;
            }
        }
    }

    private class Values
    extends TableCollection<V> {
        private Values() {
        }

        @Override
        public Iterator<V> iterator() {
            return new TransformedIterator<Table.Cell<R, C, V>, V>(StandardTable.this.cellSet().iterator()){

                @Override
                V transform(Table.Cell<R, C, V> cell) {
                    return cell.getValue();
                }
            };
        }

        @Override
        public int size() {
            return StandardTable.this.size();
        }
    }

    private class ColumnKeyIterator
    extends AbstractIterator<C> {
        final Map<C, V> seen;
        final Iterator<Map<C, V>> mapIterator;
        Iterator<Map.Entry<C, V>> entryIterator;

        private ColumnKeyIterator() {
            this.seen = StandardTable.this.factory.get();
            this.mapIterator = StandardTable.this.backingMap.values().iterator();
            this.entryIterator = Iterators.emptyIterator();
        }

        @Override
        protected C computeNext() {
            while (true) {
                if (this.entryIterator.hasNext()) {
                    Map.Entry entry = this.entryIterator.next();
                    if (this.seen.containsKey(entry.getKey())) continue;
                    this.seen.put(entry.getKey(), entry.getValue());
                    return entry.getKey();
                }
                if (!this.mapIterator.hasNext()) break;
                this.entryIterator = this.mapIterator.next().entrySet().iterator();
            }
            return this.endOfData();
        }
    }

    private class ColumnKeySet
    extends TableSet<C> {
        private ColumnKeySet() {
        }

        @Override
        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override
        public int size() {
            return Iterators.size(this.iterator());
        }

        @Override
        public boolean remove(Object obj) {
            if (obj == null) {
                return false;
            }
            boolean changed = false;
            Iterator iterator2 = StandardTable.this.backingMap.values().iterator();
            while (iterator2.hasNext()) {
                Map map2 = iterator2.next();
                if (!map2.keySet().remove(obj)) continue;
                changed = true;
                if (!map2.isEmpty()) continue;
                iterator2.remove();
            }
            return changed;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            Preconditions.checkNotNull(c);
            boolean changed = false;
            Iterator iterator2 = StandardTable.this.backingMap.values().iterator();
            while (iterator2.hasNext()) {
                Map map2 = iterator2.next();
                if (!Iterators.removeAll(map2.keySet().iterator(), c)) continue;
                changed = true;
                if (!map2.isEmpty()) continue;
                iterator2.remove();
            }
            return changed;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            Preconditions.checkNotNull(c);
            boolean changed = false;
            Iterator iterator2 = StandardTable.this.backingMap.values().iterator();
            while (iterator2.hasNext()) {
                Map map2 = iterator2.next();
                if (!map2.keySet().retainAll(c)) continue;
                changed = true;
                if (!map2.isEmpty()) continue;
                iterator2.remove();
            }
            return changed;
        }

        @Override
        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            for (Map map2 : StandardTable.this.backingMap.values()) {
                if (!map2.containsKey(obj)) continue;
                return true;
            }
            return false;
        }
    }

    class RowKeySet
    extends TableSet<R> {
        RowKeySet() {
        }

        @Override
        public Iterator<R> iterator() {
            return Maps.keyIterator(StandardTable.this.rowMap().entrySet().iterator());
        }

        @Override
        public int size() {
            return StandardTable.this.backingMap.size();
        }

        @Override
        public boolean contains(Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override
        public boolean remove(Object obj) {
            return obj != null && StandardTable.this.backingMap.remove(obj) != null;
        }
    }

    private class Column
    extends Maps.ImprovedAbstractMap<R, V> {
        final C columnKey;
        com.google.common.collect.StandardTable$Column.Values columnValues;
        com.google.common.collect.StandardTable$Column.KeySet keySet;

        Column(C columnKey) {
            this.columnKey = Preconditions.checkNotNull(columnKey);
        }

        @Override
        public V put(R key, V value) {
            return StandardTable.this.put(key, this.columnKey, value);
        }

        @Override
        public V get(Object key) {
            return StandardTable.this.get(key, this.columnKey);
        }

        @Override
        public boolean containsKey(Object key) {
            return StandardTable.this.contains(key, this.columnKey);
        }

        @Override
        public V remove(Object key) {
            return StandardTable.this.remove(key, this.columnKey);
        }

        @Override
        public Set<Map.Entry<R, V>> createEntrySet() {
            return new EntrySet();
        }

        @Override
        public Collection<V> values() {
            com.google.common.collect.StandardTable$Column.Values result2 = this.columnValues;
            return result2 == null ? (this.columnValues = new Values()) : result2;
        }

        boolean removePredicate(Predicate<? super Map.Entry<R, V>> predicate) {
            boolean changed = false;
            Iterator iterator2 = StandardTable.this.backingMap.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                Map map2 = entry.getValue();
                Object value = map2.get(this.columnKey);
                if (value == null || !predicate.apply(new ImmutableEntry(entry.getKey(), value))) continue;
                map2.remove(this.columnKey);
                changed = true;
                if (!map2.isEmpty()) continue;
                iterator2.remove();
            }
            return changed;
        }

        @Override
        public Set<R> keySet() {
            com.google.common.collect.StandardTable$Column.KeySet result2 = this.keySet;
            return result2 == null ? (this.keySet = new KeySet()) : result2;
        }

        class Values
        extends AbstractCollection<V> {
            Values() {
            }

            @Override
            public Iterator<V> iterator() {
                return Maps.valueIterator(Column.this.entrySet().iterator());
            }

            @Override
            public int size() {
                return Column.this.entrySet().size();
            }

            @Override
            public boolean isEmpty() {
                return !StandardTable.this.containsColumn(Column.this.columnKey);
            }

            @Override
            public void clear() {
                Column.this.entrySet().clear();
            }

            @Override
            public boolean remove(Object obj) {
                if (obj == null) {
                    return false;
                }
                Iterator iterator2 = StandardTable.this.backingMap.values().iterator();
                while (iterator2.hasNext()) {
                    Map map2 = iterator2.next();
                    if (!map2.entrySet().remove(new ImmutableEntry(Column.this.columnKey, obj))) continue;
                    if (map2.isEmpty()) {
                        iterator2.remove();
                    }
                    return true;
                }
                return false;
            }

            @Override
            public boolean removeAll(final Collection<?> c) {
                Preconditions.checkNotNull(c);
                Predicate predicate = new Predicate<Map.Entry<R, V>>(){

                    @Override
                    public boolean apply(Map.Entry<R, V> entry) {
                        return c.contains(entry.getValue());
                    }
                };
                return Column.this.removePredicate(predicate);
            }

            @Override
            public boolean retainAll(final Collection<?> c) {
                Preconditions.checkNotNull(c);
                Predicate predicate = new Predicate<Map.Entry<R, V>>(){

                    @Override
                    public boolean apply(Map.Entry<R, V> entry) {
                        return !c.contains(entry.getValue());
                    }
                };
                return Column.this.removePredicate(predicate);
            }
        }

        class KeySet
        extends Sets.ImprovedAbstractSet<R> {
            KeySet() {
            }

            @Override
            public Iterator<R> iterator() {
                return Maps.keyIterator(Column.this.entrySet().iterator());
            }

            @Override
            public int size() {
                return Column.this.entrySet().size();
            }

            @Override
            public boolean isEmpty() {
                return !StandardTable.this.containsColumn(Column.this.columnKey);
            }

            @Override
            public boolean contains(Object obj) {
                return StandardTable.this.contains(obj, Column.this.columnKey);
            }

            @Override
            public boolean remove(Object obj) {
                return StandardTable.this.remove(obj, Column.this.columnKey) != null;
            }

            @Override
            public void clear() {
                Column.this.entrySet().clear();
            }

            @Override
            public boolean retainAll(final Collection<?> c) {
                Preconditions.checkNotNull(c);
                Predicate predicate = new Predicate<Map.Entry<R, V>>(){

                    @Override
                    public boolean apply(Map.Entry<R, V> entry) {
                        return !c.contains(entry.getKey());
                    }
                };
                return Column.this.removePredicate(predicate);
            }
        }

        class EntrySetIterator
        extends AbstractIterator<Map.Entry<R, V>> {
            final Iterator<Map.Entry<R, Map<C, V>>> iterator;

            EntrySetIterator() {
                this.iterator = StandardTable.this.backingMap.entrySet().iterator();
            }

            @Override
            protected Map.Entry<R, V> computeNext() {
                while (this.iterator.hasNext()) {
                    final Map.Entry entry = this.iterator.next();
                    if (!entry.getValue().containsKey(Column.this.columnKey)) continue;
                    return new AbstractMapEntry<R, V>(){

                        @Override
                        public R getKey() {
                            return entry.getKey();
                        }

                        @Override
                        public V getValue() {
                            return ((Map)entry.getValue()).get(Column.this.columnKey);
                        }

                        @Override
                        public V setValue(V value) {
                            return ((Map)entry.getValue()).put(Column.this.columnKey, Preconditions.checkNotNull(value));
                        }
                    };
                }
                return (Map.Entry)this.endOfData();
            }
        }

        class EntrySet
        extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
            EntrySet() {
            }

            @Override
            public Iterator<Map.Entry<R, V>> iterator() {
                return new EntrySetIterator();
            }

            @Override
            public int size() {
                int size = 0;
                for (Map map2 : StandardTable.this.backingMap.values()) {
                    if (!map2.containsKey(Column.this.columnKey)) continue;
                    ++size;
                }
                return size;
            }

            @Override
            public boolean isEmpty() {
                return !StandardTable.this.containsColumn(Column.this.columnKey);
            }

            @Override
            public void clear() {
                Predicate predicate = Predicates.alwaysTrue();
                Column.this.removePredicate(predicate);
            }

            @Override
            public boolean contains(Object o) {
                if (o instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry)o;
                    return StandardTable.this.containsMapping(entry.getKey(), Column.this.columnKey, entry.getValue());
                }
                return false;
            }

            @Override
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry)obj;
                    return StandardTable.this.removeMapping(entry.getKey(), Column.this.columnKey, entry.getValue());
                }
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return Column.this.removePredicate(Predicates.not(Predicates.in(c)));
            }
        }
    }

    class Row
    extends AbstractMap<C, V> {
        final R rowKey;
        Map<C, V> backingRowMap;
        Set<C> keySet;
        Set<Map.Entry<C, V>> entrySet;

        Row(R rowKey) {
            this.rowKey = Preconditions.checkNotNull(rowKey);
        }

        Map<C, V> backingRowMap() {
            Map map2;
            if (this.backingRowMap == null || this.backingRowMap.isEmpty() && StandardTable.this.backingMap.containsKey(this.rowKey)) {
                this.backingRowMap = this.computeBackingRowMap();
                map2 = this.backingRowMap;
            } else {
                map2 = this.backingRowMap;
            }
            return map2;
        }

        Map<C, V> computeBackingRowMap() {
            return StandardTable.this.backingMap.get(this.rowKey);
        }

        void maintainEmptyInvariant() {
            if (this.backingRowMap() != null && this.backingRowMap.isEmpty()) {
                StandardTable.this.backingMap.remove(this.rowKey);
                this.backingRowMap = null;
            }
        }

        @Override
        public boolean containsKey(Object key) {
            Map backingRowMap = this.backingRowMap();
            return key != null && backingRowMap != null && Maps.safeContainsKey(backingRowMap, key);
        }

        @Override
        public V get(Object key) {
            Map backingRowMap = this.backingRowMap();
            return key != null && backingRowMap != null ? (Object)Maps.safeGet(backingRowMap, key) : null;
        }

        @Override
        public V put(C key, V value) {
            Preconditions.checkNotNull(key);
            Preconditions.checkNotNull(value);
            if (this.backingRowMap != null && !this.backingRowMap.isEmpty()) {
                return this.backingRowMap.put(key, value);
            }
            return StandardTable.this.put(this.rowKey, key, value);
        }

        @Override
        public V remove(Object key) {
            Map backingRowMap = this.backingRowMap();
            if (backingRowMap == null) {
                return null;
            }
            Object result2 = Maps.safeRemove(backingRowMap, key);
            this.maintainEmptyInvariant();
            return result2;
        }

        @Override
        public void clear() {
            Map backingRowMap = this.backingRowMap();
            if (backingRowMap != null) {
                backingRowMap.clear();
            }
            this.maintainEmptyInvariant();
        }

        @Override
        public Set<C> keySet() {
            Set result2 = this.keySet;
            if (result2 == null) {
                this.keySet = new Maps.KeySet<C, V>(){

                    @Override
                    Map<C, V> map() {
                        return Row.this;
                    }
                };
                return this.keySet;
            }
            return result2;
        }

        @Override
        public Set<Map.Entry<C, V>> entrySet() {
            Set result2 = this.entrySet;
            if (result2 == null) {
                this.entrySet = new RowEntrySet();
                return this.entrySet;
            }
            return result2;
        }

        private class RowEntrySet
        extends Maps.EntrySet<C, V> {
            private RowEntrySet() {
            }

            @Override
            Map<C, V> map() {
                return Row.this;
            }

            @Override
            public int size() {
                Map map2 = Row.this.backingRowMap();
                return map2 == null ? 0 : map2.size();
            }

            @Override
            public Iterator<Map.Entry<C, V>> iterator() {
                Map map2 = Row.this.backingRowMap();
                if (map2 == null) {
                    return Iterators.emptyModifiableIterator();
                }
                final Iterator iterator2 = map2.entrySet().iterator();
                return new Iterator<Map.Entry<C, V>>(){

                    @Override
                    public boolean hasNext() {
                        return iterator2.hasNext();
                    }

                    @Override
                    public Map.Entry<C, V> next() {
                        final Map.Entry entry = (Map.Entry)iterator2.next();
                        return new ForwardingMapEntry<C, V>(){

                            @Override
                            protected Map.Entry<C, V> delegate() {
                                return entry;
                            }

                            @Override
                            public V setValue(V value) {
                                return super.setValue(Preconditions.checkNotNull(value));
                            }

                            @Override
                            public boolean equals(Object object) {
                                return this.standardEquals(object);
                            }
                        };
                    }

                    @Override
                    public void remove() {
                        iterator2.remove();
                        Row.this.maintainEmptyInvariant();
                    }
                };
            }
        }
    }

    private class CellIterator
    implements Iterator<Table.Cell<R, C, V>> {
        final Iterator<Map.Entry<R, Map<C, V>>> rowIterator;
        Map.Entry<R, Map<C, V>> rowEntry;
        Iterator<Map.Entry<C, V>> columnIterator;

        private CellIterator() {
            this.rowIterator = StandardTable.this.backingMap.entrySet().iterator();
            this.columnIterator = Iterators.emptyModifiableIterator();
        }

        @Override
        public boolean hasNext() {
            return this.rowIterator.hasNext() || this.columnIterator.hasNext();
        }

        @Override
        public Table.Cell<R, C, V> next() {
            if (!this.columnIterator.hasNext()) {
                this.rowEntry = this.rowIterator.next();
                this.columnIterator = this.rowEntry.getValue().entrySet().iterator();
            }
            Map.Entry columnEntry = this.columnIterator.next();
            return Tables.immutableCell(this.rowEntry.getKey(), columnEntry.getKey(), columnEntry.getValue());
        }

        @Override
        public void remove() {
            this.columnIterator.remove();
            if (this.rowEntry.getValue().isEmpty()) {
                this.rowIterator.remove();
            }
        }
    }

    private class CellSet
    extends TableSet<Table.Cell<R, C, V>> {
        private CellSet() {
        }

        @Override
        public Iterator<Table.Cell<R, C, V>> iterator() {
            return new CellIterator();
        }

        @Override
        public int size() {
            return StandardTable.this.size();
        }

        @Override
        public boolean contains(Object obj) {
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell)obj;
                return StandardTable.this.containsMapping(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
            return false;
        }

        @Override
        public boolean remove(Object obj) {
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell)obj;
                return StandardTable.this.removeMapping(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
            return false;
        }
    }

    private abstract class TableSet<T>
    extends AbstractSet<T> {
        private TableSet() {
        }

        @Override
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }

        @Override
        public void clear() {
            StandardTable.this.backingMap.clear();
        }
    }

    private abstract class TableCollection<T>
    extends AbstractCollection<T> {
        private TableCollection() {
        }

        @Override
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }

        @Override
        public void clear() {
            StandardTable.this.backingMap.clear();
        }
    }
}

