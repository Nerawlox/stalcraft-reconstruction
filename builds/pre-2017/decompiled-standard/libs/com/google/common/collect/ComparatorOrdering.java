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
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class ComparatorOrdering<T>
extends Ordering<T>
implements Serializable {
    final Comparator<T> comparator;
    private static final long serialVersionUID = 0L;

    ComparatorOrdering(Comparator<T> comparator) {
        this.comparator = Preconditions.checkNotNull(comparator);
    }

    @Override
    public int compare(T a, T b) {
        return this.comparator.compare(a, b);
    }

    @Override
    public int binarySearch(List<? extends T> sortedList, T key) {
        return Collections.binarySearch(sortedList, key, this.comparator);
    }

    @Override
    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        ArrayList<E> list = Lists.newArrayList(iterable);
        Collections.sort(list, this.comparator);
        return list;
    }

    @Override
    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        Object[] elements;
        for (Object e : elements = Iterables.toArray(iterable)) {
            Preconditions.checkNotNull(e);
        }
        Arrays.sort(elements, this.comparator);
        return ImmutableList.asImmutableList(elements);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof ComparatorOrdering) {
            ComparatorOrdering that = (ComparatorOrdering)object;
            return this.comparator.equals(that.comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}

