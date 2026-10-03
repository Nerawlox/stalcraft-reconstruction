/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class OneElementIterable<T>
implements Iterable<T> {
    private T _value;

    public OneElementIterable(T t) {
        this._value = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return this.hasNext;
            }

            @Override
            public T next() {
                if (this.hasNext) {
                    this.hasNext = false;
                    return OneElementIterable.this._value;
                }
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("read-only collection");
            }
        };
    }
}

