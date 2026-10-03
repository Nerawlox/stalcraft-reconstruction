/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.EmptyImmutableTable;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.SingletonImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ImmutableTable<R, C, V>
implements Table<R, C, V> {
    public static final <R, C, V> ImmutableTable<R, C, V> of() {
        return EmptyImmutableTable.INSTANCE;
    }

    public static final <R, C, V> ImmutableTable<R, C, V> of(R rowKey, C columnKey, V value) {
        return new SingletonImmutableTable<R, C, V>(rowKey, columnKey, value);
    }

    public static final <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> table) {
        if (table instanceof ImmutableTable) {
            ImmutableTable parameterizedTable = (ImmutableTable)table;
            return parameterizedTable;
        }
        int size = table.size();
        switch (size) {
            case 0: {
                return ImmutableTable.of();
            }
            case 1: {
                Table.Cell<R, C, V> onlyCell = Iterables.getOnlyElement(table.cellSet());
                return ImmutableTable.of(onlyCell.getRowKey(), onlyCell.getColumnKey(), onlyCell.getValue());
            }
        }
        ImmutableSet.Builder cellSetBuilder = ImmutableSet.builder();
        for (Table.Cell<R, C, V> cell : table.cellSet()) {
            cellSetBuilder.add(ImmutableTable.cellOf(cell.getRowKey(), cell.getColumnKey(), cell.getValue()));
        }
        return RegularImmutableTable.forCells(cellSetBuilder.build());
    }

    public static final <R, C, V> Builder<R, C, V> builder() {
        return new Builder();
    }

    static <R, C, V> Table.Cell<R, C, V> cellOf(R rowKey, C columnKey, V value) {
        return Tables.immutableCell(Preconditions.checkNotNull(rowKey), Preconditions.checkNotNull(columnKey), Preconditions.checkNotNull(value));
    }

    ImmutableTable() {
    }

    @Override
    public abstract ImmutableSet<Table.Cell<R, C, V>> cellSet();

    @Override
    public abstract ImmutableMap<R, V> column(C var1);

    @Override
    public abstract ImmutableSet<C> columnKeySet();

    @Override
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override
    public abstract ImmutableMap<C, V> row(R var1);

    @Override
    public abstract ImmutableSet<R> rowKeySet();

    @Override
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final V put(R rowKey, C columnKey, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final V remove(Object rowKey, Object columnKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Table) {
            Table that = (Table)obj;
            return ((ImmutableSet)this.cellSet()).equals(that.cellSet());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((ImmutableSet)this.cellSet()).hashCode();
    }

    public String toString() {
        return ((ImmutableMap)this.rowMap()).toString();
    }

    public static final class Builder<R, C, V> {
        private final List<Table.Cell<R, C, V>> cells = Lists.newArrayList();
        private Comparator<? super R> rowComparator;
        private Comparator<? super C> columnComparator;

        public Builder<R, C, V> orderRowsBy(Comparator<? super R> rowComparator) {
            this.rowComparator = Preconditions.checkNotNull(rowComparator);
            return this;
        }

        public Builder<R, C, V> orderColumnsBy(Comparator<? super C> columnComparator) {
            this.columnComparator = Preconditions.checkNotNull(columnComparator);
            return this;
        }

        public Builder<R, C, V> put(R rowKey, C columnKey, V value) {
            this.cells.add(ImmutableTable.cellOf(rowKey, columnKey, value));
            return this;
        }

        public Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> cell) {
            if (cell instanceof Tables.ImmutableCell) {
                Preconditions.checkNotNull(cell.getRowKey());
                Preconditions.checkNotNull(cell.getColumnKey());
                Preconditions.checkNotNull(cell.getValue());
                Table.Cell<R, C, V> immutableCell = cell;
                this.cells.add(immutableCell);
            } else {
                this.put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
            return this;
        }

        public Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> table) {
            for (Table.Cell<R, C, V> cell : table.cellSet()) {
                this.put(cell);
            }
            return this;
        }

        public ImmutableTable<R, C, V> build() {
            int size = this.cells.size();
            switch (size) {
                case 0: {
                    return ImmutableTable.of();
                }
                case 1: {
                    return new SingletonImmutableTable<R, C, V>(Iterables.getOnlyElement(this.cells));
                }
            }
            return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
        }
    }
}

