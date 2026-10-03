/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
final class EmptyImmutableList
extends ImmutableList<Object> {
    static final EmptyImmutableList INSTANCE = new EmptyImmutableList();
    private static final long serialVersionUID = 0L;

    private EmptyImmutableList() {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    public boolean contains(@Nullable Object target) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> targets) {
        return targets.isEmpty();
    }

    @Override
    public UnmodifiableIterator<Object> iterator() {
        return this.listIterator();
    }

    @Override
    public Object[] toArray() {
        return ObjectArrays.EMPTY_ARRAY;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length > 0) {
            a[0] = null;
        }
        return a;
    }

    @Override
    public Object get(int index) {
        Preconditions.checkElementIndex(index, 0);
        throw new AssertionError((Object)"unreachable");
    }

    @Override
    public int indexOf(@Nullable Object target) {
        return -1;
    }

    @Override
    public int lastIndexOf(@Nullable Object target) {
        return -1;
    }

    @Override
    public ImmutableList<Object> subList(int fromIndex, int toIndex) {
        Preconditions.checkPositionIndexes(fromIndex, toIndex, 0);
        return this;
    }

    @Override
    public ImmutableList<Object> reverse() {
        return this;
    }

    @Override
    public UnmodifiableListIterator<Object> listIterator() {
        return Iterators.EMPTY_LIST_ITERATOR;
    }

    @Override
    public UnmodifiableListIterator<Object> listIterator(int start) {
        Preconditions.checkPositionIndex(start, 0);
        return Iterators.EMPTY_LIST_ITERATOR;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object instanceof List) {
            List that = (List)object;
            return that.isEmpty();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "[]";
    }

    Object readResolve() {
        return INSTANCE;
    }
}

