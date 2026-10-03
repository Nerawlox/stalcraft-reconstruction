/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
final class EmptyImmutableMultiset
extends ImmutableMultiset<Object> {
    static final EmptyImmutableMultiset INSTANCE = new EmptyImmutableMultiset();
    private static final long serialVersionUID = 0L;

    EmptyImmutableMultiset() {
    }

    @Override
    public int count(@Nullable Object element) {
        return 0;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> targets) {
        return targets.isEmpty();
    }

    @Override
    public UnmodifiableIterator<Object> iterator() {
        return Iterators.emptyIterator();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object instanceof Multiset) {
            Multiset other = (Multiset)object;
            return other.isEmpty();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public ImmutableSet<Object> elementSet() {
        return ImmutableSet.of();
    }

    @Override
    public ImmutableSet<Multiset.Entry<Object>> entrySet() {
        return ImmutableSet.of();
    }

    @Override
    ImmutableSet<Multiset.Entry<Object>> createEntrySet() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return ObjectArrays.EMPTY_ARRAY;
    }

    @Override
    public <T> T[] toArray(T[] other) {
        return this.asList().toArray(other);
    }

    @Override
    public ImmutableList<Object> asList() {
        return ImmutableList.of();
    }

    Object readResolve() {
        return INSTANCE;
    }
}

