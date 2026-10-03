/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import javax.annotation.Nullable;

abstract class AbstractRangeSet<C extends Comparable>
implements RangeSet<C> {
    AbstractRangeSet() {
    }

    @Override
    public boolean contains(C value) {
        return this.rangeContaining(value) != null;
    }

    @Override
    public Range<C> rangeContaining(C value) {
        Preconditions.checkNotNull(value);
        for (Range<C> range : this.asRanges()) {
            if (!range.contains(value)) continue;
            return range;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.asRanges().isEmpty();
    }

    @Override
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.remove(Range.all());
    }

    @Override
    public boolean enclosesAll(RangeSet<C> other) {
        for (Range<C> range : other.asRanges()) {
            if (this.encloses(range)) continue;
            return false;
        }
        return true;
    }

    @Override
    public void addAll(RangeSet<C> other) {
        for (Range<C> range : other.asRanges()) {
            this.add(range);
        }
    }

    @Override
    public void removeAll(RangeSet<C> other) {
        for (Range<C> range : other.asRanges()) {
            this.remove(range);
        }
    }

    @Override
    public boolean encloses(Range<C> otherRange) {
        for (Range<C> range : this.asRanges()) {
            if (!range.encloses(otherRange)) continue;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof RangeSet) {
            RangeSet other = (RangeSet)obj;
            return this.asRanges().equals(other.asRanges());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.asRanges().hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('{');
        for (Range range : this.asRanges()) {
            builder.append(range);
        }
        builder.append('}');
        return builder.toString();
    }
}

