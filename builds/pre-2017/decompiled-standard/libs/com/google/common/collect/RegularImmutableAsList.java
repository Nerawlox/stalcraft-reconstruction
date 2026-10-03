/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;

@GwtCompatible
class RegularImmutableAsList<E>
extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    RegularImmutableAsList(ImmutableCollection<E> delegate, ImmutableList<? extends E> delegateList) {
        this.delegate = delegate;
        this.delegateList = delegateList;
    }

    RegularImmutableAsList(ImmutableCollection<E> delegate, Object[] array) {
        this(delegate, ImmutableList.asImmutableList(array));
    }

    @Override
    ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override
    public UnmodifiableListIterator<E> listIterator(int index) {
        return this.delegateList.listIterator(index);
    }

    @Override
    public Object[] toArray() {
        return this.delegateList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] other) {
        return this.delegateList.toArray(other);
    }

    @Override
    public int indexOf(Object object) {
        return this.delegateList.indexOf(object);
    }

    @Override
    public int lastIndexOf(Object object) {
        return this.delegateList.lastIndexOf(object);
    }

    @Override
    public boolean equals(Object obj) {
        return this.delegateList.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.delegateList.hashCode();
    }

    @Override
    public E get(int index) {
        return this.delegateList.get(index);
    }
}

