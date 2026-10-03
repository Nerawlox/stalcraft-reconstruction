/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.collections;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class InplaceSort {
    public static void sort(int[] nArray, IntComparator intComparator) {
        InplaceSort.sort(new IntArrayAccessor(nArray, 0, nArray.length, intComparator));
    }

    public static void sort(int[] nArray, int n, int n2, IntComparator intComparator) {
        InplaceSort.sort(new IntArrayAccessor(nArray, n, n2, intComparator));
    }

    public static <T extends Comparable<T>> void sort(T[] TArray) {
        InplaceSort.sort(TArray, new ComparableComparator());
    }

    public static <T extends Comparable<T>> void sort(T[] TArray, int n, int n2) {
        InplaceSort.sort(TArray, n, n2, new ComparableComparator());
    }

    public static <T> void sort(T[] TArray, Comparator<T> comparator) {
        InplaceSort.sort(new ObjectArrayAccessor<T>(TArray, 0, TArray.length, comparator));
    }

    public static <T> void sort(T[] TArray, int n, int n2, Comparator<T> comparator) {
        InplaceSort.sort(new ObjectArrayAccessor<T>(TArray, n, n2, comparator));
    }

    public static <T extends Comparable<T>> void sort(List<T> list) {
        InplaceSort.sort(list, new ComparableComparator());
    }

    public static <T extends Comparable<T>> void sort(List<T> list, int n, int n2) {
        InplaceSort.sort(list, n, n2, new ComparableComparator());
    }

    public static <T> void sort(List<T> list, Comparator<T> comparator) {
        InplaceSort.sort(new ListAccessor<T>(list, 0, list.size(), comparator));
    }

    public static <T> void sort(List<T> list, int n, int n2, Comparator<T> comparator) {
        InplaceSort.sort(new ListAccessor<T>(list, n, n2, comparator));
    }

    public static void sort(Accessor accessor) {
        int n;
        int n2 = accessor.start();
        int n3 = accessor.end();
        for (n = n2 + 1; n < n3; ++n) {
            InplaceSort.siftUp(accessor, n2, n);
        }
        n = n3 - 1;
        while (n >= n2) {
            accessor.swap(n2, n);
            InplaceSort.siftDown(accessor, n2, --n);
        }
    }

    private static void siftUp(Accessor accessor, int n, int n2) {
        int n3;
        while (n2 > n && accessor.compare(n3 = n + (n2 - n - 1) / 2, n2) <= 0) {
            accessor.swap(n3, n2);
            n2 = n3;
        }
    }

    private static void siftDown(Accessor accessor, int n, int n2) {
        int n3 = n;
        while (n3 < n2) {
            int n4;
            int n5 = n + (n3 - n) * 2 + 1;
            int n6 = n5 + 1;
            int n7 = n6 > n2 ? n5 : (n4 = accessor.compare(n5, n6) < 0 ? n6 : n5);
            if (n4 > n2) break;
            if (accessor.compare(n3, n4) < 0) {
                accessor.swap(n3, n4);
            }
            n3 = n4;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ComparableComparator<T extends Comparable<T>>
    implements Serializable,
    Comparator<T> {
        private static final long serialVersionUID = 1L;

        private ComparableComparator() {
        }

        @Override
        public int compare(T t, T t2) {
            return t.compareTo(t2);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ListAccessor<T>
    implements Accessor {
        private List<T> _list;
        private int _start;
        private int _end;
        private Comparator<T> _comparator;

        public ListAccessor(List<T> list, int n, int n2, Comparator<T> comparator) {
            this._list = list;
            this._start = n;
            this._end = n2;
            this._comparator = comparator;
        }

        @Override
        public int start() {
            return this._start;
        }

        @Override
        public int end() {
            return this._end;
        }

        @Override
        public int compare(int n, int n2) {
            return this._comparator.compare(this._list.get(n), this._list.get(n2));
        }

        @Override
        public void swap(int n, int n2) {
            T t = this._list.get(n);
            this._list.set(n, this._list.get(n2));
            this._list.set(n2, t);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class ObjectArrayAccessor<T>
    implements Accessor {
        private T[] _array;
        private int _start;
        private int _end;
        private Comparator<T> _comparator;

        public ObjectArrayAccessor(T[] TArray, int n, int n2, Comparator<T> comparator) {
            this._array = TArray;
            this._start = n;
            this._end = n2;
            this._comparator = comparator;
        }

        @Override
        public int start() {
            return this._start;
        }

        @Override
        public int end() {
            return this._end;
        }

        @Override
        public int compare(int n, int n2) {
            return this._comparator.compare(this._array[n], this._array[n2]);
        }

        @Override
        public void swap(int n, int n2) {
            T t = this._array[n];
            this._array[n] = this._array[n2];
            this._array[n2] = t;
        }
    }

    private static class IntArrayAccessor
    implements Accessor {
        private int[] _array;
        private int _start;
        private int _end;
        private IntComparator _comparator;

        public IntArrayAccessor(int[] nArray, int n, int n2, IntComparator intComparator) {
            this._array = nArray;
            this._start = n;
            this._end = n2;
            this._comparator = intComparator;
        }

        public int start() {
            return this._start;
        }

        public int end() {
            return this._end;
        }

        public int compare(int n, int n2) {
            return this._comparator.compare(this._array[n], this._array[n2]);
        }

        public void swap(int n, int n2) {
            int n3 = this._array[n];
            this._array[n] = this._array[n2];
            this._array[n2] = n3;
        }
    }

    public static interface Accessor {
        public int start();

        public int end();

        public int compare(int var1, int var2);

        public void swap(int var1, int var2);
    }

    public static interface IntComparator {
        public int compare(int var1, int var2);
    }
}

