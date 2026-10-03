/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CombiningIterable<T>
implements Iterable<T> {
    private Iterable<T>[] _iterables;

    public CombiningIterable(Iterable<T> ... iterableArray) {
        this._iterables = iterableArray;
    }

    @Override
    public Iterator<T> iterator() {
        LinkedList<Iterator<Iterator<T>>> linkedList = new LinkedList<Iterator<Iterator<T>>>();
        for (Iterable<T> iterable : this._iterables) {
            linkedList.add(iterable.iterator());
        }
        return new CombiningIterator(linkedList);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class CombiningIterator<E>
    implements Iterator<E> {
        private LinkedList<Iterator<E>> _iterators;
        private Iterator<E> _curItx;

        public CombiningIterator(Iterator<E> ... iteratorArray) {
            this._iterators = new LinkedList();
            for (Iterator<E> iterator2 : iteratorArray) {
                this._iterators.add(iterator2);
            }
        }

        public CombiningIterator(LinkedList<Iterator<E>> linkedList) {
            this._iterators = linkedList;
        }

        @Override
        public boolean hasNext() {
            if (this._curItx != null && this._curItx.hasNext()) {
                return true;
            }
            if (this._iterators.size() == 0) {
                return false;
            }
            this._curItx = this._iterators.removeFirst();
            return this.hasNext();
        }

        @Override
        public E next() {
            if (this.hasNext()) {
                return this._curItx.next();
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            if (this._curItx != null) {
                this._curItx.remove();
            }
        }
    }
}

