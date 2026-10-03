/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
final class SingletonImmutableTable<R, C, V>
extends ImmutableTable<R, C, V> {
    private final R singleRowKey;
    private final C singleColumnKey;
    private final V singleValue;

    SingletonImmutableTable(R rowKey, C columnKey, V value) {
        this.singleRowKey = Preconditions.checkNotNull(rowKey);
        this.singleColumnKey = Preconditions.checkNotNull(columnKey);
        this.singleValue = Preconditions.checkNotNull(value);
    }

    SingletonImmutableTable(Table.Cell<R, C, V> cell) {
        this(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }

    @Override
    public ImmutableSet<Table.Cell<R, C, V>> cellSet() {
        return ImmutableSet.of(Tables.immutableCell(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    @Override
    public ImmutableMap<R, V> column(C columnKey) {
        Preconditions.checkNotNull(columnKey);
        return this.containsColumn(columnKey) ? ImmutableMap.of(this.singleRowKey, this.singleValue) : ImmutableMap.of();
    }

    @Override
    public ImmutableSet<C> columnKeySet() {
        return ImmutableSet.of(this.singleColumnKey);
    }

    @Override
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, this.singleValue));
    }

    @Override
    public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey) {
        return this.containsRow(rowKey) && this.containsColumn(columnKey);
    }

    @Override
    public boolean containsColumn(@Nullable Object columnKey) {
        return Objects.equal(this.singleColumnKey, columnKey);
    }

    @Override
    public boolean containsRow(@Nullable Object rowKey) {
        return Objects.equal(this.singleRowKey, rowKey);
    }

    @Override
    public boolean containsValue(@Nullable Object value) {
        return Objects.equal(this.singleValue, value);
    }

    @Override
    public V get(@Nullable Object rowKey, @Nullable Object columnKey) {
        return this.contains(rowKey, columnKey) ? (V)this.singleValue : null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ImmutableMap<C, V> row(R rowKey) {
        Preconditions.checkNotNull(rowKey);
        return this.containsRow(rowKey) ? ImmutableMap.of(this.singleColumnKey, this.singleValue) : ImmutableMap.of();
    }

    @Override
    public ImmutableSet<R> rowKeySet() {
        return ImmutableSet.of(this.singleRowKey);
    }

    @Override
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, this.singleValue));
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public ImmutableCollection<V> values() {
        return ImmutableSet.of(this.singleValue);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        Table that;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Table && (that = (Table)obj).size() == 1) {
            Table.Cell thatCell = that.cellSet().iterator().next();
            return Objects.equal(this.singleRowKey, thatCell.getRowKey()) && Objects.equal(this.singleColumnKey, thatCell.getColumnKey()) && Objects.equal(this.singleValue, thatCell.getValue());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.singleRowKey, this.singleColumnKey, this.singleValue);
    }

    @Override
    public String toString() {
        return "" + '{' + this.singleRowKey + "={" + this.singleColumnKey + '=' + this.singleValue + "}}";
    }
}

