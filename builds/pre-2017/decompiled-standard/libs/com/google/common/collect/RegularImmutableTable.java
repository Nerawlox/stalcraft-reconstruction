/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.Immutable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
abstract class RegularImmutableTable<R, C, V>
extends ImmutableTable<R, C, V> {
    private transient ImmutableCollection<V> values;
    private transient ImmutableSet<Table.Cell<R, C, V>> cellSet;

    private RegularImmutableTable() {
    }

    @Override
    public final ImmutableCollection<V> values() {
        ImmutableCollection<V> result2 = this.values;
        return result2 == null ? (this.values = this.createValues()) : result2;
    }

    abstract ImmutableCollection<V> createValues();

    @Override
    public abstract int size();

    @Override
    public final boolean containsValue(@Nullable Object value) {
        return ((ImmutableCollection)this.values()).contains(value);
    }

    @Override
    public final ImmutableSet<Table.Cell<R, C, V>> cellSet() {
        ImmutableSet<Table.Cell<R, C, V>> result2 = this.cellSet;
        return result2 == null ? (this.cellSet = this.createCellSet()) : result2;
    }

    abstract ImmutableSet<Table.Cell<R, C, V>> createCellSet();

    @Override
    public final boolean isEmpty() {
        return false;
    }

    static final <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> cells, final @Nullable Comparator<? super R> rowComparator, final @Nullable Comparator<? super C> columnComparator) {
        Preconditions.checkNotNull(cells);
        if (rowComparator != null || columnComparator != null) {
            Comparator comparator = new Comparator<Table.Cell<R, C, V>>(){

                @Override
                public int compare(Table.Cell<R, C, V> cell1, Table.Cell<R, C, V> cell2) {
                    int rowCompare;
                    int n = rowCompare = rowComparator == null ? 0 : rowComparator.compare(cell1.getRowKey(), cell2.getRowKey());
                    if (rowCompare != 0) {
                        return rowCompare;
                    }
                    return columnComparator == null ? 0 : columnComparator.compare(cell1.getColumnKey(), cell2.getColumnKey());
                }
            };
            Collections.sort(cells, comparator);
        }
        return RegularImmutableTable.forCellsInternal(cells, rowComparator, columnComparator);
    }

    static final <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> cells) {
        return RegularImmutableTable.forCellsInternal(cells, null, null);
    }

    /*
     * WARNING - void declaration
     */
    private static final <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> cells, @Nullable Comparator<? super R> rowComparator, @Nullable Comparator<? super C> columnComparator) {
        void var7_12;
        ImmutableSet.Builder rowSpaceBuilder = ImmutableSet.builder();
        ImmutableSet.Builder columnSpaceBuilder = ImmutableSet.builder();
        ImmutableList<Table.Cell<R, C, V>> cellList = ImmutableList.copyOf(cells);
        for (Table.Cell cell : cellList) {
            rowSpaceBuilder.add(cell.getRowKey());
            columnSpaceBuilder.add(cell.getColumnKey());
        }
        ImmutableSet rowSpace = rowSpaceBuilder.build();
        if (rowComparator != null) {
            ArrayList arrayList = Lists.newArrayList(rowSpace);
            Collections.sort(arrayList, rowComparator);
            rowSpace = ImmutableSet.copyOf(arrayList);
        }
        ImmutableCollection immutableCollection = columnSpaceBuilder.build();
        if (columnComparator != null) {
            ArrayList columnList = Lists.newArrayList(immutableCollection);
            Collections.sort(columnList, columnComparator);
            ImmutableSet immutableSet = ImmutableSet.copyOf(columnList);
        }
        return cellList.size() > rowSpace.size() * var7_12.size() / 2 ? new DenseImmutableTable<R, C, V>(cellList, rowSpace, var7_12) : new SparseImmutableTable<R, C, V>(cellList, rowSpace, var7_12);
    }

    @Immutable
    @VisibleForTesting
    static final class DenseImmutableTable<R, C, V>
    extends RegularImmutableTable<R, C, V> {
        private final ImmutableMap<R, Integer> rowKeyToIndex;
        private final ImmutableMap<C, Integer> columnKeyToIndex;
        private final ImmutableMap<R, Map<C, V>> rowMap;
        private final ImmutableMap<C, Map<R, V>> columnMap;
        private final int[] rowCounts;
        private final int[] columnCounts;
        private final V[][] values;
        private final int[] iterationOrderRow;
        private final int[] iterationOrderColumn;

        private static <E> ImmutableMap<E, Integer> makeIndex(ImmutableSet<E> set) {
            ImmutableMap.Builder indexBuilder = ImmutableMap.builder();
            int i = 0;
            for (Object key : set) {
                indexBuilder.put(key, i);
                ++i;
            }
            return indexBuilder.build();
        }

        DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> cellList, ImmutableSet<R> rowSpace, ImmutableSet<C> columnSpace) {
            Object[][] array = new Object[rowSpace.size()][columnSpace.size()];
            this.values = array;
            this.rowKeyToIndex = DenseImmutableTable.makeIndex(rowSpace);
            this.columnKeyToIndex = DenseImmutableTable.makeIndex(columnSpace);
            this.rowCounts = new int[this.rowKeyToIndex.size()];
            this.columnCounts = new int[this.columnKeyToIndex.size()];
            int[] iterationOrderRow = new int[cellList.size()];
            int[] iterationOrderColumn = new int[cellList.size()];
            for (int i = 0; i < cellList.size(); ++i) {
                int columnIndex;
                Table.Cell cell = (Table.Cell)cellList.get(i);
                Object rowKey = cell.getRowKey();
                Object columnKey = cell.getColumnKey();
                int rowIndex = this.rowKeyToIndex.get(rowKey);
                V existingValue = this.values[rowIndex][columnIndex = this.columnKeyToIndex.get(columnKey).intValue()];
                Preconditions.checkArgument(existingValue == null, "duplicate key: (%s, %s)", rowKey, columnKey);
                this.values[rowIndex][columnIndex] = cell.getValue();
                int n = rowIndex;
                this.rowCounts[n] = this.rowCounts[n] + 1;
                int n2 = columnIndex;
                this.columnCounts[n2] = this.columnCounts[n2] + 1;
                iterationOrderRow[i] = rowIndex;
                iterationOrderColumn[i] = columnIndex;
            }
            this.iterationOrderRow = iterationOrderRow;
            this.iterationOrderColumn = iterationOrderColumn;
            this.rowMap = new RowMap();
            this.columnMap = new ColumnMap();
        }

        @Override
        public ImmutableMap<R, V> column(C columnKey) {
            Integer columnIndex = this.columnKeyToIndex.get(Preconditions.checkNotNull(columnKey));
            if (columnIndex == null) {
                return ImmutableMap.of();
            }
            return new Column(columnIndex);
        }

        @Override
        public ImmutableSet<C> columnKeySet() {
            return this.columnKeyToIndex.keySet();
        }

        @Override
        public ImmutableMap<C, Map<R, V>> columnMap() {
            return this.columnMap;
        }

        @Override
        public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey) {
            return this.get(rowKey, columnKey) != null;
        }

        @Override
        public boolean containsColumn(@Nullable Object columnKey) {
            return this.columnKeyToIndex.containsKey(columnKey);
        }

        @Override
        public boolean containsRow(@Nullable Object rowKey) {
            return this.rowKeyToIndex.containsKey(rowKey);
        }

        @Override
        public V get(@Nullable Object rowKey, @Nullable Object columnKey) {
            Integer rowIndex = this.rowKeyToIndex.get(rowKey);
            Integer columnIndex = this.columnKeyToIndex.get(columnKey);
            return rowIndex == null || columnIndex == null ? null : (V)this.values[rowIndex][columnIndex];
        }

        @Override
        public ImmutableMap<C, V> row(R rowKey) {
            Preconditions.checkNotNull(rowKey);
            Integer rowIndex = this.rowKeyToIndex.get(rowKey);
            if (rowIndex == null) {
                return ImmutableMap.of();
            }
            return new Row(rowIndex);
        }

        @Override
        public ImmutableSet<R> rowKeySet() {
            return this.rowKeyToIndex.keySet();
        }

        @Override
        public ImmutableMap<R, Map<C, V>> rowMap() {
            return this.rowMap;
        }

        @Override
        ImmutableCollection<V> createValues() {
            return new ImmutableList<V>(){

                @Override
                public int size() {
                    return DenseImmutableTable.this.iterationOrderRow.length;
                }

                @Override
                public V get(int index) {
                    return DenseImmutableTable.this.values[DenseImmutableTable.this.iterationOrderRow[index]][DenseImmutableTable.this.iterationOrderColumn[index]];
                }

                @Override
                boolean isPartialView() {
                    return true;
                }
            };
        }

        @Override
        public int size() {
            return this.iterationOrderRow.length;
        }

        @Override
        ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
            return new DenseCellSet();
        }

        class DenseCellSet
        extends CellSet {
            DenseCellSet() {
            }

            @Override
            public UnmodifiableIterator<Table.Cell<R, C, V>> iterator() {
                return this.asList().iterator();
            }

            @Override
            ImmutableList<Table.Cell<R, C, V>> createAsList() {
                return new ImmutableAsList<Table.Cell<R, C, V>>(){

                    @Override
                    public Table.Cell<R, C, V> get(int index) {
                        int rowIndex = DenseImmutableTable.this.iterationOrderRow[index];
                        int columnIndex = DenseImmutableTable.this.iterationOrderColumn[index];
                        Object rowKey = ((ImmutableCollection)((Object)DenseImmutableTable.this.rowKeySet())).asList().get(rowIndex);
                        Object columnKey = ((ImmutableCollection)((Object)DenseImmutableTable.this.columnKeySet())).asList().get(columnIndex);
                        Object value = DenseImmutableTable.this.values[rowIndex][columnIndex];
                        return Tables.immutableCell(rowKey, columnKey, value);
                    }

                    @Override
                    ImmutableCollection<Table.Cell<R, C, V>> delegateCollection() {
                        return DenseCellSet.this;
                    }
                };
            }
        }

        private final class ColumnMap
        extends ImmutableArrayMap<C, Map<R, V>> {
            private ColumnMap() {
                super(DenseImmutableTable.this.columnCounts.length);
            }

            @Override
            ImmutableMap<C, Integer> keyToIndex() {
                return DenseImmutableTable.this.columnKeyToIndex;
            }

            @Override
            Map<R, V> getValue(int keyIndex) {
                return new Column(keyIndex);
            }

            @Override
            boolean isPartialView() {
                return false;
            }
        }

        private final class RowMap
        extends ImmutableArrayMap<R, Map<C, V>> {
            private RowMap() {
                super(DenseImmutableTable.this.rowCounts.length);
            }

            @Override
            ImmutableMap<R, Integer> keyToIndex() {
                return DenseImmutableTable.this.rowKeyToIndex;
            }

            @Override
            Map<C, V> getValue(int keyIndex) {
                return new Row(keyIndex);
            }

            @Override
            boolean isPartialView() {
                return false;
            }
        }

        private final class Column
        extends ImmutableArrayMap<R, V> {
            private final int columnIndex;

            Column(int columnIndex) {
                super(DenseImmutableTable.this.columnCounts[columnIndex]);
                this.columnIndex = columnIndex;
            }

            @Override
            ImmutableMap<R, Integer> keyToIndex() {
                return DenseImmutableTable.this.rowKeyToIndex;
            }

            @Override
            V getValue(int keyIndex) {
                return DenseImmutableTable.this.values[keyIndex][this.columnIndex];
            }

            @Override
            boolean isPartialView() {
                return true;
            }
        }

        private final class Row
        extends ImmutableArrayMap<C, V> {
            private final int rowIndex;

            Row(int rowIndex) {
                super(DenseImmutableTable.this.rowCounts[rowIndex]);
                this.rowIndex = rowIndex;
            }

            @Override
            ImmutableMap<C, Integer> keyToIndex() {
                return DenseImmutableTable.this.columnKeyToIndex;
            }

            @Override
            V getValue(int keyIndex) {
                return DenseImmutableTable.this.values[this.rowIndex][keyIndex];
            }

            @Override
            boolean isPartialView() {
                return true;
            }
        }
    }

    private static abstract class ImmutableArrayMap<K, V>
    extends ImmutableMap<K, V> {
        private final int size;

        ImmutableArrayMap(int size) {
            this.size = size;
        }

        abstract ImmutableMap<K, Integer> keyToIndex();

        private boolean isFull() {
            return this.size == this.keyToIndex().size();
        }

        K getKey(int index) {
            return (K)((ImmutableCollection)((Object)this.keyToIndex().keySet())).asList().get(index);
        }

        @Nullable
        abstract V getValue(int var1);

        @Override
        ImmutableSet<K> createKeySet() {
            return this.isFull() ? this.keyToIndex().keySet() : super.createKeySet();
        }

        @Override
        public int size() {
            return this.size;
        }

        @Override
        public V get(@Nullable Object key) {
            Integer keyIndex = this.keyToIndex().get(key);
            return keyIndex == null ? null : (V)this.getValue(keyIndex);
        }

        @Override
        ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            if (this.isFull()) {
                return new ImmutableMapEntrySet<K, V>(){

                    @Override
                    ImmutableMap<K, V> map() {
                        return ImmutableArrayMap.this;
                    }

                    @Override
                    public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                        return new AbstractIndexedListIterator<Map.Entry<K, V>>(this.size()){

                            @Override
                            protected Map.Entry<K, V> get(int index) {
                                return Maps.immutableEntry(ImmutableArrayMap.this.getKey(index), ImmutableArrayMap.this.getValue(index));
                            }
                        };
                    }
                };
            }
            return new ImmutableMapEntrySet<K, V>(){

                @Override
                ImmutableMap<K, V> map() {
                    return ImmutableArrayMap.this;
                }

                @Override
                public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                    return new AbstractIterator<Map.Entry<K, V>>(){
                        private int index = -1;
                        private final int maxIndex;
                        {
                            this.maxIndex = ImmutableArrayMap.this.keyToIndex().size();
                        }

                        @Override
                        protected Map.Entry<K, V> computeNext() {
                            ++this.index;
                            while (this.index < this.maxIndex) {
                                Object value = ImmutableArrayMap.this.getValue(this.index);
                                if (value != null) {
                                    return Maps.immutableEntry(ImmutableArrayMap.this.getKey(this.index), value);
                                }
                                ++this.index;
                            }
                            return (Map.Entry)this.endOfData();
                        }
                    };
                }
            };
        }
    }

    @Immutable
    @VisibleForTesting
    static final class SparseImmutableTable<R, C, V>
    extends RegularImmutableTable<R, C, V> {
        private final ImmutableMap<R, Map<C, V>> rowMap;
        private final ImmutableMap<C, Map<R, V>> columnMap;
        private final int[] iterationOrderRow;
        private final int[] iterationOrderColumn;

        SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> cellList, ImmutableSet<R> rowSpace, ImmutableSet<C> columnSpace) {
            HashMap rowIndex = Maps.newHashMap();
            LinkedHashMap rows = Maps.newLinkedHashMap();
            for (Object row : rowSpace) {
                rowIndex.put(row, rows.size());
                rows.put(row, new LinkedHashMap());
            }
            LinkedHashMap columns = Maps.newLinkedHashMap();
            for (Object col : columnSpace) {
                columns.put(col, new LinkedHashMap());
            }
            int[] iterationOrderRow = new int[cellList.size()];
            int[] iterationOrderColumn = new int[cellList.size()];
            for (int i = 0; i < cellList.size(); ++i) {
                Table.Cell cell = (Table.Cell)cellList.get(i);
                Object rowKey = cell.getRowKey();
                Object columnKey = cell.getColumnKey();
                Object value = cell.getValue();
                iterationOrderRow[i] = (Integer)rowIndex.get(rowKey);
                Map thisRow = (Map)rows.get(rowKey);
                iterationOrderColumn[i] = thisRow.size();
                Object oldValue = thisRow.put(columnKey, value);
                if (oldValue != null) {
                    throw new IllegalArgumentException("Duplicate value for row=" + rowKey + ", column=" + columnKey + ": " + value + ", " + oldValue);
                }
                ((Map)columns.get(columnKey)).put(rowKey, value);
            }
            this.iterationOrderRow = iterationOrderRow;
            this.iterationOrderColumn = iterationOrderColumn;
            ImmutableMap.Builder rowBuilder = ImmutableMap.builder();
            for (Map.Entry row : rows.entrySet()) {
                rowBuilder.put(row.getKey(), ImmutableMap.copyOf((Map)row.getValue()));
            }
            this.rowMap = rowBuilder.build();
            ImmutableMap.Builder columnBuilder = ImmutableMap.builder();
            for (Map.Entry col : columns.entrySet()) {
                columnBuilder.put(col.getKey(), ImmutableMap.copyOf((Map)col.getValue()));
            }
            this.columnMap = columnBuilder.build();
        }

        @Override
        public ImmutableMap<R, V> column(C columnKey) {
            Preconditions.checkNotNull(columnKey);
            return Objects.firstNonNull((ImmutableMap)this.columnMap.get(columnKey), ImmutableMap.of());
        }

        @Override
        public ImmutableSet<C> columnKeySet() {
            return this.columnMap.keySet();
        }

        @Override
        public ImmutableMap<C, Map<R, V>> columnMap() {
            return this.columnMap;
        }

        @Override
        public ImmutableMap<C, V> row(R rowKey) {
            Preconditions.checkNotNull(rowKey);
            return Objects.firstNonNull((ImmutableMap)this.rowMap.get(rowKey), ImmutableMap.of());
        }

        @Override
        public ImmutableSet<R> rowKeySet() {
            return this.rowMap.keySet();
        }

        @Override
        public ImmutableMap<R, Map<C, V>> rowMap() {
            return this.rowMap;
        }

        @Override
        public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey) {
            Map<C, V> row = this.rowMap.get(rowKey);
            return row != null && row.containsKey(columnKey);
        }

        @Override
        public boolean containsColumn(@Nullable Object columnKey) {
            return this.columnMap.containsKey(columnKey);
        }

        @Override
        public boolean containsRow(@Nullable Object rowKey) {
            return this.rowMap.containsKey(rowKey);
        }

        @Override
        public V get(@Nullable Object rowKey, @Nullable Object columnKey) {
            Map<C, V> row = this.rowMap.get(rowKey);
            return row == null ? null : (V)row.get(columnKey);
        }

        @Override
        ImmutableCollection<V> createValues() {
            return new ImmutableList<V>(){

                @Override
                public int size() {
                    return SparseImmutableTable.this.iterationOrderRow.length;
                }

                @Override
                public V get(int index) {
                    int rowIndex = SparseImmutableTable.this.iterationOrderRow[index];
                    ImmutableMap row = (ImmutableMap)((ImmutableCollection)SparseImmutableTable.this.rowMap.values()).asList().get(rowIndex);
                    int columnIndex = SparseImmutableTable.this.iterationOrderColumn[index];
                    return ((ImmutableCollection)row.values()).asList().get(columnIndex);
                }

                @Override
                boolean isPartialView() {
                    return true;
                }
            };
        }

        @Override
        public int size() {
            return this.iterationOrderRow.length;
        }

        @Override
        ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
            return new SparseCellSet();
        }

        class SparseCellSet
        extends CellSet {
            SparseCellSet() {
            }

            @Override
            public UnmodifiableIterator<Table.Cell<R, C, V>> iterator() {
                return this.asList().iterator();
            }

            @Override
            ImmutableList<Table.Cell<R, C, V>> createAsList() {
                return new ImmutableAsList<Table.Cell<R, C, V>>(){

                    @Override
                    public Table.Cell<R, C, V> get(int index) {
                        int rowIndex = SparseImmutableTable.this.iterationOrderRow[index];
                        Map.Entry rowEntry = (Map.Entry)((ImmutableCollection)((Object)SparseImmutableTable.this.rowMap.entrySet())).asList().get(rowIndex);
                        ImmutableMap row = (ImmutableMap)rowEntry.getValue();
                        int columnIndex = SparseImmutableTable.this.iterationOrderColumn[index];
                        Map.Entry colEntry = (Map.Entry)((ImmutableCollection)((Object)row.entrySet())).asList().get(columnIndex);
                        return Tables.immutableCell(rowEntry.getKey(), colEntry.getKey(), colEntry.getValue());
                    }

                    @Override
                    ImmutableCollection<Table.Cell<R, C, V>> delegateCollection() {
                        return SparseCellSet.this;
                    }
                };
            }
        }
    }

    abstract class CellSet
    extends ImmutableSet<Table.Cell<R, C, V>> {
        CellSet() {
        }

        @Override
        public int size() {
            return RegularImmutableTable.this.size();
        }

        @Override
        public boolean contains(@Nullable Object object) {
            if (object instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell)object;
                Object value = RegularImmutableTable.this.get(cell.getRowKey(), cell.getColumnKey());
                return value != null && value.equals(cell.getValue());
            }
            return false;
        }

        @Override
        boolean isPartialView() {
            return false;
        }
    }
}

