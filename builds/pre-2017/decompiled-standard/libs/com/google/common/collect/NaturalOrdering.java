/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.ReverseNaturalOrdering;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@GwtCompatible(serializable=true)
final class NaturalOrdering
extends Ordering<Comparable>
implements Serializable {
    static final NaturalOrdering INSTANCE = new NaturalOrdering();
    private static final long serialVersionUID = 0L;

    @Override
    public int compare(Comparable left, Comparable right) {
        Preconditions.checkNotNull(left);
        Preconditions.checkNotNull(right);
        if (left == right) {
            return 0;
        }
        return left.compareTo(right);
    }

    @Override
    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    @Override
    public int binarySearch(List<? extends Comparable> sortedList, Comparable key) {
        return Collections.binarySearch(sortedList, key);
    }

    @Override
    public <E extends Comparable> List<E> sortedCopy(Iterable<E> iterable) {
        ArrayList<E> list = Lists.newArrayList(iterable);
        Collections.sort(list);
        return list;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    private NaturalOrdering() {
    }
}

