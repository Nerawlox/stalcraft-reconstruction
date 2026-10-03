/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.TransformedIterator;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Iterators {
    static final UnmodifiableListIterator<Object> EMPTY_LIST_ITERATOR = new UnmodifiableListIterator<Object>(){

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Object previous() {
            throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return -1;
        }
    };
    private static final Iterator<Object> EMPTY_MODIFIABLE_ITERATOR = new Iterator<Object>(){

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new IllegalStateException();
        }
    };

    private Iterators() {
    }

    public static <T> UnmodifiableIterator<T> emptyIterator() {
        return Iterators.emptyListIterator();
    }

    static <T> UnmodifiableListIterator<T> emptyListIterator() {
        return EMPTY_LIST_ITERATOR;
    }

    static <T> Iterator<T> emptyModifiableIterator() {
        return EMPTY_MODIFIABLE_ITERATOR;
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<T> iterator2) {
        Preconditions.checkNotNull(iterator2);
        if (iterator2 instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator)iterator2;
        }
        return new UnmodifiableIterator<T>(){

            @Override
            public boolean hasNext() {
                return iterator2.hasNext();
            }

            @Override
            public T next() {
                return iterator2.next();
            }
        };
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> iterator2) {
        return Preconditions.checkNotNull(iterator2);
    }

    public static int size(Iterator<?> iterator2) {
        int count = 0;
        while (iterator2.hasNext()) {
            iterator2.next();
            ++count;
        }
        return count;
    }

    public static boolean contains(Iterator<?> iterator2, @Nullable Object element) {
        if (element == null) {
            while (iterator2.hasNext()) {
                if (iterator2.next() != null) continue;
                return true;
            }
        } else {
            while (iterator2.hasNext()) {
                if (!element.equals(iterator2.next())) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean removeAll(Iterator<?> removeFrom, Collection<?> elementsToRemove) {
        Preconditions.checkNotNull(elementsToRemove);
        boolean modified = false;
        while (removeFrom.hasNext()) {
            if (!elementsToRemove.contains(removeFrom.next())) continue;
            removeFrom.remove();
            modified = true;
        }
        return modified;
    }

    public static <T> boolean removeIf(Iterator<T> removeFrom, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean modified = false;
        while (removeFrom.hasNext()) {
            if (!predicate.apply(removeFrom.next())) continue;
            removeFrom.remove();
            modified = true;
        }
        return modified;
    }

    public static boolean retainAll(Iterator<?> removeFrom, Collection<?> elementsToRetain) {
        Preconditions.checkNotNull(elementsToRetain);
        boolean modified = false;
        while (removeFrom.hasNext()) {
            if (elementsToRetain.contains(removeFrom.next())) continue;
            removeFrom.remove();
            modified = true;
        }
        return modified;
    }

    public static boolean elementsEqual(Iterator<?> iterator1, Iterator<?> iterator2) {
        while (iterator1.hasNext()) {
            Object o2;
            if (!iterator2.hasNext()) {
                return false;
            }
            Object o1 = iterator1.next();
            if (Objects.equal(o1, o2 = iterator2.next())) continue;
            return false;
        }
        return !iterator2.hasNext();
    }

    public static String toString(Iterator<?> iterator2) {
        return Joiner.on(", ").useForNull("null").appendTo(new StringBuilder().append('['), iterator2).append(']').toString();
    }

    public static <T> T getOnlyElement(Iterator<T> iterator2) {
        T first = iterator2.next();
        if (!iterator2.hasNext()) {
            return first;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <" + first);
        for (int i = 0; i < 4 && iterator2.hasNext(); ++i) {
            sb.append(", " + iterator2.next());
        }
        if (iterator2.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    @Nullable
    public static <T> T getOnlyElement(Iterator<? extends T> iterator2, @Nullable T defaultValue) {
        return iterator2.hasNext() ? Iterators.getOnlyElement(iterator2) : defaultValue;
    }

    @GwtIncompatible(value="Array.newInstance(Class, int)")
    public static <T> T[] toArray(Iterator<? extends T> iterator2, Class<T> type2) {
        ArrayList<? extends T> list = Lists.newArrayList(iterator2);
        return Iterables.toArray(list, type2);
    }

    public static <T> boolean addAll(Collection<T> addTo, Iterator<? extends T> iterator2) {
        Preconditions.checkNotNull(addTo);
        boolean wasModified = false;
        while (iterator2.hasNext()) {
            wasModified |= addTo.add(iterator2.next());
        }
        return wasModified;
    }

    public static int frequency(Iterator<?> iterator2, @Nullable Object element) {
        int result2 = 0;
        if (element == null) {
            while (iterator2.hasNext()) {
                if (iterator2.next() != null) continue;
                ++result2;
            }
        } else {
            while (iterator2.hasNext()) {
                if (!element.equals(iterator2.next())) continue;
                ++result2;
            }
        }
        return result2;
    }

    public static <T> Iterator<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterator<T>(){
            Iterator<T> iterator = Iterators.emptyIterator();
            Iterator<T> removeFrom;

            @Override
            public boolean hasNext() {
                if (!this.iterator.hasNext()) {
                    this.iterator = iterable.iterator();
                }
                return this.iterator.hasNext();
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                this.removeFrom = this.iterator;
                return this.iterator.next();
            }

            @Override
            public void remove() {
                Preconditions.checkState(this.removeFrom != null, "no calls to next() since last call to remove()");
                this.removeFrom.remove();
                this.removeFrom = null;
            }
        };
    }

    public static <T> Iterator<T> cycle(T ... elements) {
        return Iterators.cycle(Lists.newArrayList(elements));
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        return Iterators.concat(Arrays.asList(a, b).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b, Iterator<? extends T> c) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        Preconditions.checkNotNull(c);
        return Iterators.concat(Arrays.asList(a, b, c).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b, Iterator<? extends T> c, Iterator<? extends T> d) {
        Preconditions.checkNotNull(a);
        Preconditions.checkNotNull(b);
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(d);
        return Iterators.concat(Arrays.asList(a, b, c, d).iterator());
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> ... inputs) {
        return Iterators.concat(ImmutableList.copyOf(inputs).iterator());
    }

    public static <T> Iterator<T> concat(final Iterator<? extends Iterator<? extends T>> inputs) {
        Preconditions.checkNotNull(inputs);
        return new Iterator<T>(){
            Iterator<? extends T> current = Iterators.emptyIterator();
            Iterator<? extends T> removeFrom;

            @Override
            public boolean hasNext() {
                boolean currentHasNext;
                while (!(currentHasNext = Preconditions.checkNotNull(this.current).hasNext()) && inputs.hasNext()) {
                    this.current = (Iterator)inputs.next();
                }
                return currentHasNext;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                this.removeFrom = this.current;
                return this.current.next();
            }

            @Override
            public void remove() {
                Preconditions.checkState(this.removeFrom != null, "no calls to next() since last call to remove()");
                this.removeFrom.remove();
                this.removeFrom = null;
            }
        };
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> iterator2, int size) {
        return Iterators.partitionImpl(iterator2, size, false);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> iterator2, int size) {
        return Iterators.partitionImpl(iterator2, size, true);
    }

    private static <T> UnmodifiableIterator<List<T>> partitionImpl(final Iterator<T> iterator2, final int size, final boolean pad) {
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkArgument(size > 0);
        return new UnmodifiableIterator<List<T>>(){

            @Override
            public boolean hasNext() {
                return iterator2.hasNext();
            }

            @Override
            public List<T> next() {
                int count;
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Object[] array = new Object[size];
                for (count = 0; count < size && iterator2.hasNext(); ++count) {
                    array[count] = iterator2.next();
                }
                for (int i = count; i < size; ++i) {
                    array[i] = null;
                }
                List<Object> list = Collections.unmodifiableList(Arrays.asList(array));
                return pad || count == size ? list : list.subList(0, count);
            }
        };
    }

    public static <T> UnmodifiableIterator<T> filter(final Iterator<T> unfiltered, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(unfiltered);
        Preconditions.checkNotNull(predicate);
        return new AbstractIterator<T>(){

            @Override
            protected T computeNext() {
                while (unfiltered.hasNext()) {
                    Object element = unfiltered.next();
                    if (!predicate.apply(element)) continue;
                    return element;
                }
                return this.endOfData();
            }
        };
    }

    @GwtIncompatible(value="Class.isInstance")
    public static <T> UnmodifiableIterator<T> filter(Iterator<?> unfiltered, Class<T> type2) {
        return Iterators.filter(unfiltered, Predicates.instanceOf(type2));
    }

    public static <T> boolean any(Iterator<T> iterator2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (iterator2.hasNext()) {
            T element = iterator2.next();
            if (!predicate.apply(element)) continue;
            return true;
        }
        return false;
    }

    public static <T> boolean all(Iterator<T> iterator2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (iterator2.hasNext()) {
            T element = iterator2.next();
            if (predicate.apply(element)) continue;
            return false;
        }
        return true;
    }

    public static <T> T find(Iterator<T> iterator2, Predicate<? super T> predicate) {
        return (T)Iterators.filter(iterator2, predicate).next();
    }

    @Nullable
    public static <T> T find(Iterator<? extends T> iterator2, Predicate<? super T> predicate, @Nullable T defaultValue) {
        UnmodifiableIterator<T> filteredIterator = Iterators.filter(iterator2, predicate);
        return (T)(filteredIterator.hasNext() ? filteredIterator.next() : defaultValue);
    }

    public static <T> Optional<T> tryFind(Iterator<T> iterator2, Predicate<? super T> predicate) {
        UnmodifiableIterator<T> filteredIterator = Iterators.filter(iterator2, predicate);
        return filteredIterator.hasNext() ? Optional.of(filteredIterator.next()) : Optional.absent();
    }

    public static <T> int indexOf(Iterator<T> iterator2, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i = 0;
        while (iterator2.hasNext()) {
            T current = iterator2.next();
            if (predicate.apply(current)) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    public static <F, T> Iterator<T> transform(Iterator<F> fromIterator, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new TransformedIterator<F, T>(fromIterator){

            @Override
            T transform(F from) {
                return function.apply(from);
            }
        };
    }

    public static <T> T get(Iterator<T> iterator2, int position) {
        Iterators.checkNonnegative(position);
        int skipped = 0;
        while (iterator2.hasNext()) {
            T t = iterator2.next();
            if (skipped++ != position) continue;
            return t;
        }
        throw new IndexOutOfBoundsException("position (" + position + ") must be less than the number of elements that remained (" + skipped + ")");
    }

    private static void checkNonnegative(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("position (" + position + ") must not be negative");
        }
    }

    @Nullable
    public static <T> T get(Iterator<? extends T> iterator2, int position, @Nullable T defaultValue) {
        Iterators.checkNonnegative(position);
        try {
            return Iterators.get(iterator2, position);
        }
        catch (IndexOutOfBoundsException e) {
            return defaultValue;
        }
    }

    @Nullable
    public static <T> T getNext(Iterator<? extends T> iterator2, @Nullable T defaultValue) {
        return iterator2.hasNext() ? iterator2.next() : defaultValue;
    }

    public static <T> T getLast(Iterator<T> iterator2) {
        T current;
        do {
            current = iterator2.next();
        } while (iterator2.hasNext());
        return current;
    }

    @Nullable
    public static <T> T getLast(Iterator<? extends T> iterator2, @Nullable T defaultValue) {
        return iterator2.hasNext() ? Iterators.getLast(iterator2) : defaultValue;
    }

    public static int advance(Iterator<?> iterator2, int numberToAdvance) {
        int i;
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkArgument(numberToAdvance >= 0, "number to advance cannot be negative");
        for (i = 0; i < numberToAdvance && iterator2.hasNext(); ++i) {
            iterator2.next();
        }
        return i;
    }

    public static <T> Iterator<T> limit(final Iterator<T> iterator2, final int limitSize) {
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkArgument(limitSize >= 0, "limit is negative");
        return new Iterator<T>(){
            private int count;

            @Override
            public boolean hasNext() {
                return this.count < limitSize && iterator2.hasNext();
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                ++this.count;
                return iterator2.next();
            }

            @Override
            public void remove() {
                iterator2.remove();
            }
        };
    }

    public static <T> Iterator<T> consumingIterator(final Iterator<T> iterator2) {
        Preconditions.checkNotNull(iterator2);
        return new UnmodifiableIterator<T>(){

            @Override
            public boolean hasNext() {
                return iterator2.hasNext();
            }

            @Override
            public T next() {
                Object next = iterator2.next();
                iterator2.remove();
                return next;
            }
        };
    }

    @Nullable
    static <T> T pollNext(Iterator<T> iterator2) {
        if (iterator2.hasNext()) {
            T result2 = iterator2.next();
            iterator2.remove();
            return result2;
        }
        return null;
    }

    static void clear(Iterator<?> iterator2) {
        Preconditions.checkNotNull(iterator2);
        while (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
    }

    public static <T> UnmodifiableIterator<T> forArray(final T ... array) {
        Preconditions.checkNotNull(array);
        return new AbstractIndexedListIterator<T>(array.length){

            @Override
            protected T get(int index) {
                return array[index];
            }
        };
    }

    static <T> UnmodifiableListIterator<T> forArray(final T[] array, final int offset, int length, int index) {
        Preconditions.checkArgument(length >= 0);
        int end = offset + length;
        Preconditions.checkPositionIndexes(offset, end, array.length);
        return new AbstractIndexedListIterator<T>(length, index){

            @Override
            protected T get(int index) {
                return array[offset + index];
            }
        };
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(final @Nullable T value) {
        return new UnmodifiableIterator<T>(){
            boolean done;

            @Override
            public boolean hasNext() {
                return !this.done;
            }

            @Override
            public T next() {
                if (this.done) {
                    throw new NoSuchElementException();
                }
                this.done = true;
                return value;
            }
        };
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new UnmodifiableIterator<T>(){

            @Override
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @Override
            public T next() {
                return enumeration.nextElement();
            }
        };
    }

    public static <T> Enumeration<T> asEnumeration(final Iterator<T> iterator2) {
        Preconditions.checkNotNull(iterator2);
        return new Enumeration<T>(){

            @Override
            public boolean hasMoreElements() {
                return iterator2.hasNext();
            }

            @Override
            public T nextElement() {
                return iterator2.next();
            }
        };
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> iterator2) {
        if (iterator2 instanceof PeekingImpl) {
            PeekingImpl peeking = (PeekingImpl)iterator2;
            return peeking;
        }
        return new PeekingImpl<T>(iterator2);
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> iterator2) {
        return Preconditions.checkNotNull(iterator2);
    }

    @Beta
    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterators, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterators, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new MergingIterator<T>(iterators, comparator);
    }

    static void checkRemove(boolean canRemove) {
        Preconditions.checkState(canRemove, "no calls to next() since the last call to remove()");
    }

    static <T> ListIterator<T> cast(Iterator<T> iterator2) {
        return (ListIterator)iterator2;
    }

    private static class MergingIterator<T>
    extends AbstractIterator<T> {
        final Queue<PeekingIterator<T>> queue;
        final Comparator<? super T> comparator;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> iterators, Comparator<? super T> itemComparator) {
            this.comparator = itemComparator;
            Comparator heapComparator = new Comparator<PeekingIterator<T>>(){

                @Override
                public int compare(PeekingIterator<T> o1, PeekingIterator<T> o2) {
                    return MergingIterator.this.comparator.compare(o1.peek(), o2.peek());
                }
            };
            this.queue = new PriorityQueue<PeekingIterator<T>>(2, heapComparator);
            for (Iterator<T> iterator2 : iterators) {
                if (!iterator2.hasNext()) continue;
                this.queue.add(Iterators.peekingIterator(iterator2));
            }
        }

        @Override
        protected T computeNext() {
            if (this.queue.isEmpty()) {
                return this.endOfData();
            }
            PeekingIterator<T> nextIter = this.queue.poll();
            T next = nextIter.next();
            if (nextIter.hasNext()) {
                this.queue.add(nextIter);
            }
            return next;
        }
    }

    private static class PeekingImpl<E>
    implements PeekingIterator<E> {
        private final Iterator<? extends E> iterator;
        private boolean hasPeeked;
        private E peekedElement;

        public PeekingImpl(Iterator<? extends E> iterator2) {
            this.iterator = Preconditions.checkNotNull(iterator2);
        }

        @Override
        public boolean hasNext() {
            return this.hasPeeked || this.iterator.hasNext();
        }

        @Override
        public E next() {
            if (!this.hasPeeked) {
                return this.iterator.next();
            }
            E result2 = this.peekedElement;
            this.hasPeeked = false;
            this.peekedElement = null;
            return result2;
        }

        @Override
        public void remove() {
            Preconditions.checkState(!this.hasPeeked, "Can't remove after you've peeked at next");
            this.iterator.remove();
        }

        @Override
        public E peek() {
            if (!this.hasPeeked) {
                this.peekedElement = this.iterator.next();
                this.hasPeeked = true;
            }
            return this.peekedElement;
        }
    }
}

