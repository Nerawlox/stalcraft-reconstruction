/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import javax.annotation.Nullable;

final class RegularImmutableSortedMultiset<E>
extends ImmutableSortedMultiset<E> {
    private final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int[] counts;
    private final transient long[] cumulativeCounts;
    private final transient int offset;
    private final transient int length;

    RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> elementSet, int[] counts, long[] cumulativeCounts, int offset, int length) {
        this.elementSet = elementSet;
        this.counts = counts;
        this.cumulativeCounts = cumulativeCounts;
        this.offset = offset;
        this.length = length;
    }

    private Multiset.Entry<E> getEntry(int index) {
        return Multisets.immutableEntry(this.elementSet.asList().get(index), this.counts[this.offset + index]);
    }

    @Override
    public Multiset.Entry<E> firstEntry() {
        return this.getEntry(0);
    }

    @Override
    public Multiset.Entry<E> lastEntry() {
        return this.getEntry(this.length - 1);
    }

    @Override
    public int count(@Nullable Object element) {
        int index = this.elementSet.indexOf(element);
        return index == -1 ? 0 : this.counts[index + this.offset];
    }

    @Override
    public int size() {
        long size = this.cumulativeCounts[this.offset + this.length] - this.cumulativeCounts[this.offset];
        return Ints.saturatedCast(size);
    }

    @Override
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    @Override
    public ImmutableSortedMultiset<E> headMultiset(E upperBound, BoundType boundType) {
        return this.getSubMultiset(0, this.elementSet.headIndex(upperBound, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }

    @Override
    public ImmutableSortedMultiset<E> tailMultiset(E lowerBound, BoundType boundType) {
        return this.getSubMultiset(this.elementSet.tailIndex(lowerBound, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.length);
    }

    ImmutableSortedMultiset<E> getSubMultiset(int from, int to) {
        Preconditions.checkPositionIndexes(from, to, this.length);
        if (from == to) {
            return RegularImmutableSortedMultiset.emptyMultiset(this.comparator());
        }
        if (from == 0 && to == this.length) {
            return this;
        }
        RegularImmutableSortedSet subElementSet = (RegularImmutableSortedSet)this.elementSet.getSubSet(from, to);
        return new RegularImmutableSortedMultiset<E>(subElementSet, this.counts, this.cumulativeCounts, this.offset + from, to - from);
    }

    @Override
    ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet();
    }

    @Override
    boolean isPartialView() {
        return this.offset > 0 || this.length < this.counts.length;
    }

    private final class EntrySet
    extends ImmutableMultiset.EntrySet {
        private EntrySet() {
            super(RegularImmutableSortedMultiset.this);
        }

        @Override
        public int size() {
            return RegularImmutableSortedMultiset.this.length;
        }

        @Override
        public UnmodifiableIterator<Multiset.Entry<E>> iterator() {
            return this.asList().iterator();
        }

        @Override
        ImmutableList<Multiset.Entry<E>> createAsList() {
            return new ImmutableAsList<Multiset.Entry<E>>(){

                @Override
                public Multiset.Entry<E> get(int index) {
                    return RegularImmutableSortedMultiset.this.getEntry(index);
                }

                @Override
                ImmutableCollection<Multiset.Entry<E>> delegateCollection() {
                    return EntrySet.this;
                }
            };
        }
    }
}

