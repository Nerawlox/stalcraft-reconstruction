/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.collections;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class BinarySearch {
    public static <T> int search(Accessor<T> accessor, T t) {
        int n;
        int n2 = accessor.start();
        int n3 = accessor.end() - 1;
        if (n3 < n2) {
            return -1;
        }
        while (n3 > n2) {
            n = n2 + (n3 - n2) / 2;
            if (accessor.compare(t, n) <= 0) {
                n3 = n;
                continue;
            }
            n2 = n + 1;
        }
        n = accessor.compare(t, n2);
        return n == 0 ? n2 : (n < 0 ? -n2 - 1 : -(n2 + 1) - 1);
    }

    public static <T> int search(int[] nArray, T t, IndexedComparator<T> indexedComparator) {
        return BinarySearch.search(new IndexedAccessor<T>(nArray, indexedComparator), t);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    private static class IndexedAccessor<T>
    implements Accessor<T> {
        private int[] _array;
        private IndexedComparator<T> _cmp;

        public IndexedAccessor(int[] nArray, IndexedComparator<T> indexedComparator) {
            this._array = nArray;
            this._cmp = indexedComparator;
        }

        @Override
        public int start() {
            return 0;
        }

        @Override
        public int end() {
            return this._array.length;
        }

        @Override
        public int compare(T t, int n) {
            return this._cmp.compare(t, this._array[n]);
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface IndexedComparator<T> {
        public int compare(T var1, int var2);
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface Accessor<T> {
        public int start();

        public int end();

        public int compare(T var1, int var2);
    }
}

