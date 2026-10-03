/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
class RegularImmutableList<E>
extends ImmutableList<E> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] array;

    RegularImmutableList(Object[] array, int offset, int size) {
        this.offset = offset;
        this.size = size;
        this.array = array;
    }

    RegularImmutableList(Object[] array) {
        this(array, 0, array.length);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    boolean isPartialView() {
        return this.offset != 0 || this.size != this.array.length;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[this.size()];
        System.arraycopy(this.array, this.offset, newArray, 0, this.size);
        return newArray;
    }

    @Override
    public <T> T[] toArray(T[] other) {
        if (other.length < this.size) {
            other = ObjectArrays.newArray(other, this.size);
        } else if (other.length > this.size) {
            other[this.size] = null;
        }
        System.arraycopy(this.array, this.offset, other, 0, this.size);
        return other;
    }

    @Override
    public E get(int index) {
        Preconditions.checkElementIndex(index, this.size);
        return (E)this.array[index + this.offset];
    }

    @Override
    ImmutableList<E> subListUnchecked(int fromIndex, int toIndex) {
        return new RegularImmutableList<E>(this.array, this.offset + fromIndex, toIndex - fromIndex);
    }

    @Override
    public UnmodifiableListIterator<E> listIterator(int index) {
        return Iterators.forArray(this.array, this.offset, this.size, index);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof List)) {
            return false;
        }
        List that = (List)object;
        if (this.size() != that.size()) {
            return false;
        }
        int index = this.offset;
        if (object instanceof RegularImmutableList) {
            RegularImmutableList other = (RegularImmutableList)object;
            for (int i = other.offset; i < other.offset + other.size; ++i) {
                if (this.array[index++].equals(other.array[i])) continue;
                return false;
            }
        } else {
            for (Object element : that) {
                if (this.array[index++].equals(element)) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = Collections2.newStringBuilderForCollection(this.size()).append('[').append(this.array[this.offset]);
        for (int i = this.offset + 1; i < this.offset + this.size; ++i) {
            sb.append(", ").append(this.array[i]);
        }
        return sb.append(']').toString();
    }
}

