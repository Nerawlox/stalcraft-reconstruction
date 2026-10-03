/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.utils;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

public final class SmartSet<T>
extends AbstractSet<T> {
    private Object data;
    private int size;
    private static final int ARRAY_THRESHOLD = 5;
    public static final Companion Companion = new Companion(null);

    public int getSize() {
        return this.size;
    }

    public void setSize(int n) {
        this.size = n;
    }

    @Override
    @NotNull
    public Iterator<T> iterator() {
        Iterator iterator2;
        if (this.size() == 0) {
            iterator2 = Collections.emptySet().iterator();
        } else if (this.size() == 1) {
            iterator2 = new SingletonIterator<Object>(this.data);
        } else if (this.size() < SmartSet.Companion.getARRAY_THRESHOLD()) {
            Object object = this.data;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            iterator2 = new ArrayIterator<Object>((Object[])object);
        } else {
            Object object = this.data;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
            }
            iterator2 = TypeIntrinsics.asMutableSet(object).iterator();
        }
        return iterator2;
    }

    @Override
    public boolean add(T element) {
        if (this.size() == 0) {
            this.data = element;
        } else if (this.size() == 1) {
            Object[] objectArray;
            if (Intrinsics.areEqual(this.data, element)) {
                return false;
            }
            Object[] elements$iv = new Object[]{this.data, element};
            SmartSet smartSet = this;
            smartSet.data = objectArray = elements$iv;
        } else if (this.size() < SmartSet.Companion.getARRAY_THRESHOLD()) {
            Object[] objectArray;
            SmartSet smartSet;
            Object object = this.data;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Object[] arr = (Object[])object;
            if (ArraysKt.contains(arr, element)) {
                return false;
            }
            SmartSet smartSet2 = this;
            if (this.size() == SmartSet.Companion.getARRAY_THRESHOLD() - 1) {
                Object[] objectArray2 = SetsKt.linkedSetOf(Arrays.copyOf(arr, arr.length));
                SmartSet smartSet3 = smartSet2;
                Object[] $receiver = objectArray2;
                $receiver.add(element);
                Object[] objectArray3 = objectArray2;
                smartSet = smartSet3;
                objectArray = objectArray3;
            } else {
                Object[] objectArray4 = Arrays.copyOf(arr, this.size() + 1);
                SmartSet smartSet4 = smartSet2;
                Object[] $receiver = objectArray4;
                $receiver[$receiver.length - 1] = element;
                Object[] objectArray5 = objectArray4;
                smartSet = smartSet4;
                objectArray = objectArray5;
            }
            smartSet.data = objectArray;
        } else {
            Object object = this.data;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
            }
            Set set = TypeIntrinsics.asMutableSet(object);
            if (!set.add(element)) {
                return false;
            }
        }
        SmartSet smartSet = this;
        int n = smartSet.size();
        smartSet.setSize(n + 1);
        return true;
    }

    @Override
    public void clear() {
        this.data = null;
        this.setSize(0);
    }

    @Override
    public boolean contains(Object element) {
        boolean bl;
        if (this.size() == 0) {
            bl = false;
        } else if (this.size() == 1) {
            bl = Intrinsics.areEqual(this.data, element);
        } else if (this.size() < SmartSet.Companion.getARRAY_THRESHOLD()) {
            Object object = this.data;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            bl = ArraysKt.contains((Object[])object, element);
        } else {
            Object object = this.data;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Set<T>");
            }
            bl = ((Set)object).contains(element);
        }
        return bl;
    }

    private SmartSet() {
    }

    static {
        ARRAY_THRESHOLD = 5;
    }

    public /* synthetic */ SmartSet(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final <T> SmartSet<T> create() {
        return Companion.create();
    }

    @JvmStatic
    @NotNull
    public static final <T> SmartSet<T> create(@NotNull Collection<? extends T> set) {
        Intrinsics.checkParameterIsNotNull(set, "set");
        return Companion.create(set);
    }

    private static final class SingletonIterator<T>
    implements Iterator<T>,
    KMutableIterator {
        private boolean hasNext;
        private final T element;

        @Override
        public T next() {
            if (!this.hasNext) {
                throw (Throwable)new NoSuchElementException();
            }
            this.hasNext = false;
            return this.element;
        }

        @Override
        public boolean hasNext() {
            return this.hasNext;
        }

        @NotNull
        public Void remove() {
            throw (Throwable)new UnsupportedOperationException();
        }

        public SingletonIterator(T element) {
            this.element = element;
            this.hasNext = true;
        }
    }

    private static final class ArrayIterator<T>
    implements Iterator<T>,
    KMutableIterator {
        private final Iterator<T> arrayIterator;

        @Override
        public boolean hasNext() {
            return this.arrayIterator.hasNext();
        }

        @Override
        public T next() {
            return this.arrayIterator.next();
        }

        @NotNull
        public Void remove() {
            throw (Throwable)new UnsupportedOperationException();
        }

        public ArrayIterator(@NotNull T[] array) {
            Intrinsics.checkParameterIsNotNull(array, "array");
            this.arrayIterator = ArrayIteratorKt.iterator(array);
        }
    }

    public static final class Companion {
        private final int getARRAY_THRESHOLD() {
            return ARRAY_THRESHOLD;
        }

        @JvmStatic
        @NotNull
        public final <T> SmartSet<T> create() {
            return new SmartSet(null);
        }

        @JvmStatic
        @NotNull
        public final <T> SmartSet<T> create(@NotNull Collection<? extends T> set) {
            SmartSet smartSet;
            Intrinsics.checkParameterIsNotNull(set, "set");
            SmartSet $receiver = smartSet = new SmartSet(null);
            $receiver.addAll(set);
            return smartSet;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

