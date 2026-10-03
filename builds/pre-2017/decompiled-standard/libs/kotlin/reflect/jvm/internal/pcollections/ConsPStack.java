/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class ConsPStack<E>
implements Iterable<E> {
    private static final ConsPStack<Object> EMPTY = new ConsPStack();
    final E first;
    final ConsPStack<E> rest;
    private final int size;

    public static <E> ConsPStack<E> empty() {
        return EMPTY;
    }

    private ConsPStack() {
        this.size = 0;
        this.first = null;
        this.rest = null;
    }

    private ConsPStack(E first, ConsPStack<E> rest) {
        this.first = first;
        this.rest = rest;
        this.size = 1 + rest.size;
    }

    public E get(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return this.iterator(index).next();
        }
        catch (NoSuchElementException e) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return this.iterator(0);
    }

    public int size() {
        return this.size;
    }

    private Iterator<E> iterator(int index) {
        return new Itr<E>(this.subList(index));
    }

    public ConsPStack<E> plus(E e) {
        return new ConsPStack<E>(e, this);
    }

    private ConsPStack<E> minus(Object e) {
        if (this.size == 0) {
            return this;
        }
        if (this.first.equals(e)) {
            return this.rest;
        }
        ConsPStack<E> newRest = super.minus(e);
        if (newRest == this.rest) {
            return this;
        }
        return new ConsPStack<E>(this.first, newRest);
    }

    public ConsPStack<E> minus(int i) {
        return this.minus(this.get(i));
    }

    private ConsPStack<E> subList(int start) {
        if (start < 0 || start > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (start == 0) {
            return this;
        }
        return super.subList(start - 1);
    }

    private static class Itr<E>
    implements Iterator<E> {
        private ConsPStack<E> next;

        public Itr(ConsPStack<E> first) {
            this.next = first;
        }

        @Override
        public boolean hasNext() {
            return ((ConsPStack)this.next).size > 0;
        }

        @Override
        public E next() {
            Object e = this.next.first;
            this.next = this.next.rest;
            return e;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

