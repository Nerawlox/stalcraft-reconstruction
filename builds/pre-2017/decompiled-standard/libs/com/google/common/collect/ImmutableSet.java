/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.EmptyImmutableSet;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.SingletonImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public abstract class ImmutableSet<E>
extends ImmutableCollection<E>
implements Set<E> {
    static final int MAX_TABLE_SIZE = 0x40000000;
    private static final double DESIRED_LOAD_FACTOR = 0.7;
    private static final int CUTOFF = (int)Math.floor(7.516192768E8);

    public static <E> ImmutableSet<E> of() {
        return EmptyImmutableSet.INSTANCE;
    }

    public static <E> ImmutableSet<E> of(E element) {
        return new SingletonImmutableSet<E>(element);
    }

    public static <E> ImmutableSet<E> of(E e1, E e2) {
        return ImmutableSet.construct(2, e1, e2);
    }

    public static <E> ImmutableSet<E> of(E e1, E e2, E e3) {
        return ImmutableSet.construct(3, e1, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e1, E e2, E e3, E e4) {
        return ImmutableSet.construct(4, e1, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> of(E e1, E e2, E e3, E e4, E e5) {
        return ImmutableSet.construct(5, e1, e2, e3, e4, e5);
    }

    public static <E> ImmutableSet<E> of(E e1, E e2, E e3, E e4, E e5, E e6, E ... others) {
        int paramCount = 6;
        Object[] elements = new Object[6 + others.length];
        elements[0] = e1;
        elements[1] = e2;
        elements[2] = e3;
        elements[3] = e4;
        elements[4] = e5;
        elements[5] = e6;
        System.arraycopy(others, 0, elements, 6, others.length);
        return ImmutableSet.construct(elements.length, elements);
    }

    private static <E> ImmutableSet<E> construct(int n, Object ... elements) {
        switch (n) {
            case 0: {
                return ImmutableSet.of();
            }
            case 1: {
                Object elem = elements[0];
                return ImmutableSet.of(elem);
            }
        }
        int tableSize = ImmutableSet.chooseTableSize(n);
        Object[] table = new Object[tableSize];
        int mask = tableSize - 1;
        int hashCode2 = 0;
        int uniques = 0;
        block4: for (int i = 0; i < n; ++i) {
            Object element = ObjectArrays.checkElementNotNull(elements[i], i);
            int hash = element.hashCode();
            int j = Hashing.smear(hash);
            while (true) {
                int index;
                Object value;
                if ((value = table[index = j & mask]) == null) {
                    elements[uniques++] = element;
                    table[index] = element;
                    hashCode2 += hash;
                    continue block4;
                }
                if (value.equals(element)) continue block4;
                ++j;
            }
        }
        Arrays.fill(elements, uniques, n, null);
        if (uniques == 1) {
            Object element = elements[0];
            return new SingletonImmutableSet<Object>(element, hashCode2);
        }
        if (tableSize != ImmutableSet.chooseTableSize(uniques)) {
            return ImmutableSet.construct(uniques, elements);
        }
        Object[] uniqueElements = uniques < elements.length ? ObjectArrays.arraysCopyOf(elements, uniques) : elements;
        return new RegularImmutableSet(uniqueElements, hashCode2, table, mask);
    }

    @VisibleForTesting
    static int chooseTableSize(int setSize) {
        if (setSize < CUTOFF) {
            int tableSize = Integer.highestOneBit(setSize - 1) << 1;
            while ((double)tableSize * 0.7 < (double)setSize) {
                tableSize <<= 1;
            }
            return tableSize;
        }
        Preconditions.checkArgument(setSize < 0x40000000, "collection too large");
        return 0x40000000;
    }

    public static <E> ImmutableSet<E> copyOf(E[] elements) {
        switch (elements.length) {
            case 0: {
                return ImmutableSet.of();
            }
            case 1: {
                return ImmutableSet.of(elements[0]);
            }
        }
        return ImmutableSet.construct(elements.length, (Object[])elements.clone());
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> elements) {
        return elements instanceof Collection ? ImmutableSet.copyOf(Collections2.cast(elements)) : ImmutableSet.copyOf(elements.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> elements) {
        if (!elements.hasNext()) {
            return ImmutableSet.of();
        }
        E first = elements.next();
        if (!elements.hasNext()) {
            return ImmutableSet.of(first);
        }
        return ((Builder)((Builder)new Builder().add((Object)first)).addAll(elements)).build();
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> elements) {
        if (elements instanceof ImmutableSet && !(elements instanceof ImmutableSortedSet)) {
            ImmutableSet set = (ImmutableSet)elements;
            if (!set.isPartialView()) {
                return set;
            }
        } else if (elements instanceof EnumSet) {
            EnumSet enumSet = EnumSet.copyOf((EnumSet)elements);
            ImmutableSet result2 = ImmutableEnumSet.asImmutable(enumSet);
            return result2;
        }
        return ImmutableSet.copyFromCollection(elements);
    }

    private static <E> ImmutableSet<E> copyFromCollection(Collection<? extends E> collection) {
        Object[] elements = collection.toArray();
        switch (elements.length) {
            case 0: {
                return ImmutableSet.of();
            }
            case 1: {
                Object onlyElement = elements[0];
                return ImmutableSet.of(onlyElement);
            }
        }
        return ImmutableSet.construct(elements.length, elements);
    }

    ImmutableSet() {
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof ImmutableSet && this.isHashCodeFast() && ((ImmutableSet)object).isHashCodeFast() && this.hashCode() != object.hashCode()) {
            return false;
        }
        return Sets.equalsImpl(this, object);
    }

    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @Override
    public abstract UnmodifiableIterator<E> iterator();

    @Override
    Object writeReplace() {
        return new SerializedForm(this.toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }

    public static class Builder<E>
    extends ImmutableCollection.Builder<E> {
        Object[] contents;
        int size;

        public Builder() {
            this(4);
        }

        Builder(int capacity) {
            Preconditions.checkArgument(capacity >= 0, "capacity must be >= 0 but was %s", capacity);
            this.contents = new Object[capacity];
            this.size = 0;
        }

        Builder<E> ensureCapacity(int minCapacity) {
            if (this.contents.length < minCapacity) {
                this.contents = ObjectArrays.arraysCopyOf(this.contents, Builder.expandedCapacity(this.contents.length, minCapacity));
            }
            return this;
        }

        @Override
        public Builder<E> add(E element) {
            this.ensureCapacity(this.size + 1);
            this.contents[this.size++] = Preconditions.checkNotNull(element);
            return this;
        }

        @Override
        public Builder<E> add(E ... elements) {
            for (int i = 0; i < elements.length; ++i) {
                ObjectArrays.checkElementNotNull(elements[i], i);
            }
            this.ensureCapacity(this.size + elements.length);
            System.arraycopy(elements, 0, this.contents, this.size, elements.length);
            this.size += elements.length;
            return this;
        }

        @Override
        public Builder<E> addAll(Iterable<? extends E> elements) {
            if (elements instanceof Collection) {
                Collection collection = (Collection)elements;
                this.ensureCapacity(this.size + collection.size());
            }
            super.addAll(elements);
            return this;
        }

        @Override
        public Builder<E> addAll(Iterator<? extends E> elements) {
            super.addAll(elements);
            return this;
        }

        @Override
        public ImmutableSet<E> build() {
            ImmutableSet result2 = ImmutableSet.construct(this.size, this.contents);
            this.size = result2.size();
            return result2;
        }
    }

    private static class SerializedForm
    implements Serializable {
        final Object[] elements;
        private static final long serialVersionUID = 0L;

        SerializedForm(Object[] elements) {
            this.elements = elements;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    static abstract class ArrayImmutableSet<E>
    extends ImmutableSet<E> {
        final transient Object[] elements;

        ArrayImmutableSet(Object[] elements) {
            this.elements = elements;
        }

        @Override
        public int size() {
            return this.elements.length;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public UnmodifiableIterator<E> iterator() {
            return this.asList().iterator();
        }

        @Override
        public Object[] toArray() {
            return this.asList().toArray();
        }

        @Override
        public <T> T[] toArray(T[] array) {
            return this.asList().toArray(array);
        }

        @Override
        public boolean containsAll(Collection<?> targets) {
            if (targets == this) {
                return true;
            }
            if (!(targets instanceof ArrayImmutableSet)) {
                return super.containsAll(targets);
            }
            if (targets.size() > this.size()) {
                return false;
            }
            for (Object target : ((ArrayImmutableSet)targets).elements) {
                if (this.contains(target)) continue;
                return false;
            }
            return true;
        }

        @Override
        boolean isPartialView() {
            return false;
        }

        @Override
        ImmutableList<E> createAsList() {
            return new RegularImmutableAsList(this, this.elements);
        }
    }
}

