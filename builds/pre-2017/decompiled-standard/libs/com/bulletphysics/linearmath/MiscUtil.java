/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.util.FloatArrayList;
import com.bulletphysics.util.IntArrayList;
import com.bulletphysics.util.ObjectArrayList;
import java.util.Comparator;

public class MiscUtil {
    public static int getListCapacityForHash(ObjectArrayList<?> list) {
        return MiscUtil.getListCapacityForHash(list.size());
    }

    public static int getListCapacityForHash(int size) {
        int n;
        for (n = 2; n < size; n <<= 1) {
        }
        return n;
    }

    public static <T> void ensureIndex(ObjectArrayList<T> list, int index, T value) {
        while (list.size() <= index) {
            list.add(value);
        }
    }

    public static void resize(IntArrayList list, int size, int value) {
        while (list.size() < size) {
            list.add(value);
        }
        while (list.size() > size) {
            list.remove(list.size() - 1);
        }
    }

    public static void resize(FloatArrayList list, int size, float value) {
        while (list.size() < size) {
            list.add(value);
        }
        while (list.size() > size) {
            list.remove(list.size() - 1);
        }
    }

    public static <T> void resize(ObjectArrayList<T> list, int size, Class<T> valueCls) {
        try {
            while (list.size() < size) {
                list.add(valueCls != null ? (Object)valueCls.newInstance() : null);
            }
            while (list.size() > size) {
                list.removeQuick(list.size() - 1);
            }
        }
        catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
        catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static <T> int indexOf(T[] array, T obj) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != obj) continue;
            return i;
        }
        return -1;
    }

    public static float GEN_clamped(float a, float lb, float ub) {
        return a < lb ? lb : (ub < a ? ub : a);
    }

    private static <T> void downHeap(ObjectArrayList<T> pArr, int k, int n, Comparator<T> comparator) {
        T temp = pArr.getQuick(k - 1);
        while (k <= n / 2) {
            int child = 2 * k;
            if (child < n && comparator.compare(pArr.getQuick(child - 1), pArr.getQuick(child)) < 0) {
                ++child;
            }
            if (comparator.compare(temp, pArr.getQuick(child - 1)) >= 0) break;
            pArr.setQuick(k - 1, pArr.getQuick(child - 1));
            k = child;
        }
        pArr.setQuick(k - 1, temp);
    }

    public static <T> void heapSort(ObjectArrayList<T> list, Comparator<T> comparator) {
        int n = list.size();
        for (int k = n / 2; k > 0; --k) {
            MiscUtil.downHeap(list, k, n, comparator);
        }
        while (n >= 1) {
            MiscUtil.swap(list, 0, n - 1);
            MiscUtil.downHeap(list, 1, --n, comparator);
        }
    }

    private static <T> void swap(ObjectArrayList<T> list, int index0, int index1) {
        T temp = list.getQuick(index0);
        list.setQuick(index0, list.getQuick(index1));
        list.setQuick(index1, temp);
    }

    public static <T> void quickSort(ObjectArrayList<T> list, Comparator<T> comparator) {
        if (list.size() > 1) {
            MiscUtil.quickSortInternal(list, comparator, 0, list.size() - 1);
        }
    }

    private static <T> void quickSortInternal(ObjectArrayList<T> list, Comparator<T> comparator, int lo, int hi) {
        int i = lo;
        int j = hi;
        T x = list.getQuick((lo + hi) / 2);
        while (true) {
            if (comparator.compare(list.getQuick(i), x) < 0) {
                ++i;
                continue;
            }
            while (comparator.compare(x, list.getQuick(j)) < 0) {
                --j;
            }
            if (i <= j) {
                MiscUtil.swap(list, i, j);
                ++i;
                --j;
            }
            if (i > j) break;
        }
        if (lo < j) {
            MiscUtil.quickSortInternal(list, comparator, lo, j);
        }
        if (i < hi) {
            MiscUtil.quickSortInternal(list, comparator, i, hi);
        }
    }
}

