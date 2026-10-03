/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

public class SmartList<E>
extends AbstractList<E>
implements RandomAccess {
    private int mySize;
    private Object myElem;

    public SmartList() {
    }

    public SmartList(E element) {
        this.add(element);
    }

    public SmartList(@NotNull Collection<? extends E> elements) {
        if (elements == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "elements", "kotlin/reflect/jvm/internal/impl/utils/SmartList", "<init>"));
        }
        int size = elements.size();
        if (size == 1) {
            E element = elements instanceof List ? ((List)elements).get(0) : elements.iterator().next();
            this.add(element);
        } else if (size > 0) {
            this.mySize = size;
            this.myElem = elements.toArray(new Object[size]);
        }
    }

    public SmartList(E ... elements) {
        if (elements == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "elements", "kotlin/reflect/jvm/internal/impl/utils/SmartList", "<init>"));
        }
        if (elements.length == 1) {
            this.add(elements[0]);
        } else if (elements.length > 0) {
            this.mySize = elements.length;
            this.myElem = Arrays.copyOf(elements, this.mySize);
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.mySize);
        }
        if (this.mySize == 1) {
            return (E)this.myElem;
        }
        return (E)((Object[])this.myElem)[index];
    }

    @Override
    public boolean add(E e) {
        if (this.mySize == 0) {
            this.myElem = e;
        } else if (this.mySize == 1) {
            Object[] array = new Object[]{this.myElem, e};
            this.myElem = array;
        } else {
            Object[] array = (Object[])this.myElem;
            int oldCapacity = array.length;
            if (this.mySize >= oldCapacity) {
                int newCapacity = oldCapacity * 3 / 2 + 1;
                int minCapacity = this.mySize + 1;
                if (newCapacity < minCapacity) {
                    newCapacity = minCapacity;
                }
                Object[] oldArray = array;
                array = new Object[newCapacity];
                this.myElem = array;
                System.arraycopy(oldArray, 0, array, 0, oldCapacity);
            }
            array[this.mySize] = e;
        }
        ++this.mySize;
        ++this.modCount;
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.mySize);
        }
        if (this.mySize == 0) {
            this.myElem = e;
        } else if (this.mySize == 1 && index == 0) {
            Object[] array = new Object[]{e, this.myElem};
            this.myElem = array;
        } else {
            Object[] array = new Object[this.mySize + 1];
            if (this.mySize == 1) {
                array[0] = this.myElem;
            } else {
                Object[] oldArray = (Object[])this.myElem;
                System.arraycopy(oldArray, 0, array, 0, index);
                System.arraycopy(oldArray, index, array, index + 1, this.mySize - index);
            }
            array[index] = e;
            this.myElem = array;
        }
        ++this.mySize;
        ++this.modCount;
    }

    @Override
    public int size() {
        return this.mySize;
    }

    @Override
    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        ++this.modCount;
    }

    @Override
    public E set(int index, E element) {
        Object oldValue;
        if (index < 0 || index >= this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.mySize);
        }
        if (this.mySize == 1) {
            oldValue = this.myElem;
            this.myElem = element;
        } else {
            Object[] array = (Object[])this.myElem;
            oldValue = array[index];
            array[index] = element;
        }
        return (E)oldValue;
    }

    @Override
    public E remove(int index) {
        Object oldValue;
        if (index < 0 || index >= this.mySize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.mySize);
        }
        if (this.mySize == 1) {
            oldValue = this.myElem;
            this.myElem = null;
        } else {
            Object[] array = (Object[])this.myElem;
            oldValue = array[index];
            if (this.mySize == 2) {
                this.myElem = array[1 - index];
            } else {
                int numMoved = this.mySize - index - 1;
                if (numMoved > 0) {
                    System.arraycopy(array, index + 1, array, index, numMoved);
                }
                array[this.mySize - 1] = null;
            }
        }
        --this.mySize;
        ++this.modCount;
        return (E)oldValue;
    }

    @Override
    @NotNull
    public Iterator<E> iterator() {
        if (this.mySize == 0) {
            EmptyIterator emptyIterator = EmptyIterator.getInstance();
            if (emptyIterator == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/SmartList", "iterator"));
            }
            return emptyIterator;
        }
        if (this.mySize == 1) {
            SingletonIterator singletonIterator = new SingletonIterator();
            if (singletonIterator == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/SmartList", "iterator"));
            }
            return singletonIterator;
        }
        Iterator iterator2 = super.iterator();
        if (iterator2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/SmartList", "iterator"));
        }
        return iterator2;
    }

    @Override
    public void sort(Comparator<? super E> comparator) {
        if (this.mySize >= 2) {
            Arrays.sort((Object[])this.myElem, 0, this.mySize, comparator);
        }
    }

    public int getModificationCount() {
        return this.modCount;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    @NotNull
    public <T> T[] toArray(@NotNull T[] a) {
        int aLength;
        block10: {
            if (a == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "a", "kotlin/reflect/jvm/internal/impl/utils/SmartList", "toArray"));
            }
            aLength = a.length;
            if (this.mySize == 1) {
                if (aLength != 0) {
                    a[0] = this.myElem;
                    break block10;
                } else {
                    Object[] r = (Object[])Array.newInstance(a.getClass().getComponentType(), 1);
                    r[0] = this.myElem;
                    if (r == null) {
                        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/SmartList", "toArray"));
                    }
                    return r;
                }
            }
            if (aLength < this.mySize) {
                T[] TArray = Arrays.copyOf((Object[])this.myElem, this.mySize, a.getClass());
                if (TArray == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/SmartList", "toArray"));
                }
                return TArray;
            }
            if (this.mySize != 0) {
                System.arraycopy(this.myElem, 0, a, 0, this.mySize);
            }
        }
        if (aLength > this.mySize) {
            a[this.mySize] = null;
        }
        if (a == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/utils/SmartList", "toArray"));
        }
        return a;
    }

    public void trimToSize() {
        if (this.mySize < 2) {
            return;
        }
        Object[] array = (Object[])this.myElem;
        int oldCapacity = array.length;
        if (this.mySize < oldCapacity) {
            ++this.modCount;
            this.myElem = Arrays.copyOf(array, this.mySize);
        }
    }

    private class SingletonIterator
    extends SingletonIteratorBase<E> {
        private final int myInitialModCount;

        public SingletonIterator() {
            this.myInitialModCount = SmartList.this.modCount;
        }

        @Override
        protected E getElement() {
            return SmartList.this.myElem;
        }

        @Override
        protected void checkCoModification() {
            if (SmartList.this.modCount != this.myInitialModCount) {
                throw new ConcurrentModificationException("ModCount: " + SmartList.this.modCount + "; expected: " + this.myInitialModCount);
            }
        }

        @Override
        public void remove() {
            this.checkCoModification();
            SmartList.this.clear();
        }
    }

    private static abstract class SingletonIteratorBase<T>
    implements Iterator<T> {
        private boolean myVisited;

        private SingletonIteratorBase() {
        }

        @Override
        public final boolean hasNext() {
            return !this.myVisited;
        }

        @Override
        public final T next() {
            if (this.myVisited) {
                throw new NoSuchElementException();
            }
            this.myVisited = true;
            this.checkCoModification();
            return this.getElement();
        }

        protected abstract void checkCoModification();

        protected abstract T getElement();
    }

    private static class EmptyIterator<T>
    implements Iterator<T> {
        private static final EmptyIterator INSTANCE = new EmptyIterator();

        private EmptyIterator() {
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new IllegalStateException();
        }
    }
}

