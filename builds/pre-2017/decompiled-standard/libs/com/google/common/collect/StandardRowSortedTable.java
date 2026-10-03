/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.StandardTable;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
class StandardRowSortedTable<R, C, V>
extends StandardTable<R, C, V>
implements RowSortedTable<R, C, V> {
    private transient SortedSet<R> rowKeySet;
    private transient RowSortedMap rowMap;
    private static final long serialVersionUID = 0L;

    StandardRowSortedTable(SortedMap<R, Map<C, V>> backingMap, Supplier<? extends Map<C, V>> factory) {
        super(backingMap, factory);
    }

    private SortedMap<R, Map<C, V>> sortedBackingMap() {
        return (SortedMap)this.backingMap;
    }

    @Override
    public SortedSet<R> rowKeySet() {
        RowKeySortedSet result2 = this.rowKeySet;
        return result2 == null ? (this.rowKeySet = new RowKeySortedSet()) : result2;
    }

    @Override
    public SortedMap<R, Map<C, V>> rowMap() {
        RowSortedMap result2 = this.rowMap;
        return result2 == null ? (this.rowMap = new RowSortedMap()) : result2;
    }

    private class RowSortedMap
    extends StandardTable.RowMap
    implements SortedMap<R, Map<C, V>> {
        private RowSortedMap() {
            super(StandardRowSortedTable.this);
        }

        @Override
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.this.sortedBackingMap().comparator();
        }

        @Override
        public R firstKey() {
            return StandardRowSortedTable.this.sortedBackingMap().firstKey();
        }

        @Override
        public R lastKey() {
            return StandardRowSortedTable.this.sortedBackingMap().lastKey();
        }

        @Override
        public SortedMap<R, Map<C, V>> headMap(R toKey) {
            Preconditions.checkNotNull(toKey);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().headMap(toKey), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override
        public SortedMap<R, Map<C, V>> subMap(R fromKey, R toKey) {
            Preconditions.checkNotNull(fromKey);
            Preconditions.checkNotNull(toKey);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().subMap(fromKey, toKey), StandardRowSortedTable.this.factory).rowMap();
        }

        @Override
        public SortedMap<R, Map<C, V>> tailMap(R fromKey) {
            Preconditions.checkNotNull(fromKey);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().tailMap(fromKey), StandardRowSortedTable.this.factory).rowMap();
        }
    }

    private class RowKeySortedSet
    extends StandardTable.RowKeySet
    implements SortedSet<R> {
        private RowKeySortedSet() {
            super(StandardRowSortedTable.this);
        }

        @Override
        public Comparator<? super R> comparator() {
            return StandardRowSortedTable.this.sortedBackingMap().comparator();
        }

        @Override
        public R first() {
            return StandardRowSortedTable.this.sortedBackingMap().firstKey();
        }

        @Override
        public R last() {
            return StandardRowSortedTable.this.sortedBackingMap().lastKey();
        }

        @Override
        public SortedSet<R> headSet(R toElement) {
            Preconditions.checkNotNull(toElement);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().headMap(toElement), StandardRowSortedTable.this.factory).rowKeySet();
        }

        @Override
        public SortedSet<R> subSet(R fromElement, R toElement) {
            Preconditions.checkNotNull(fromElement);
            Preconditions.checkNotNull(toElement);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().subMap(fromElement, toElement), StandardRowSortedTable.this.factory).rowKeySet();
        }

        @Override
        public SortedSet<R> tailSet(R fromElement) {
            Preconditions.checkNotNull(fromElement);
            return new StandardRowSortedTable(StandardRowSortedTable.this.sortedBackingMap().tailMap(fromElement), StandardRowSortedTable.this.factory).rowKeySet();
        }
    }
}

