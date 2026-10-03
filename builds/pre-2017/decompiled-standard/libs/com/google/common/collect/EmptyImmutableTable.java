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
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class EmptyImmutableTable
extends ImmutableTable<Object, Object, Object> {
    static final EmptyImmutableTable INSTANCE = new EmptyImmutableTable();
    private static final long serialVersionUID = 0L;

    private EmptyImmutableTable() {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object get(@Nullable Object rowKey, @Nullable Object columnKey) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Table) {
            Table that = (Table)obj;
            return that.isEmpty();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public ImmutableSet<Table.Cell<Object, Object, Object>> cellSet() {
        return ImmutableSet.of();
    }

    @Override
    public ImmutableMap<Object, Object> column(Object columnKey) {
        Preconditions.checkNotNull(columnKey);
        return ImmutableMap.of();
    }

    @Override
    public ImmutableSet<Object> columnKeySet() {
        return ImmutableSet.of();
    }

    @Override
    public ImmutableMap<Object, Map<Object, Object>> columnMap() {
        return ImmutableMap.of();
    }

    @Override
    public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey) {
        return false;
    }

    @Override
    public boolean containsColumn(@Nullable Object columnKey) {
        return false;
    }

    @Override
    public boolean containsRow(@Nullable Object rowKey) {
        return false;
    }

    @Override
    public boolean containsValue(@Nullable Object value) {
        return false;
    }

    @Override
    public ImmutableMap<Object, Object> row(Object rowKey) {
        Preconditions.checkNotNull(rowKey);
        return ImmutableMap.of();
    }

    @Override
    public ImmutableSet<Object> rowKeySet() {
        return ImmutableSet.of();
    }

    @Override
    public ImmutableMap<Object, Map<Object, Object>> rowMap() {
        return ImmutableMap.of();
    }

    @Override
    public String toString() {
        return "{}";
    }

    @Override
    public ImmutableCollection<Object> values() {
        return ImmutableSet.of();
    }

    Object readResolve() {
        return INSTANCE;
    }
}

