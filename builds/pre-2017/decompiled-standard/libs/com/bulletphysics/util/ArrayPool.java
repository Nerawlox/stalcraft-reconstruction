/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.util;

import com.bulletphysics.util.ObjectArrayList;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ArrayPool<T> {
    private Class componentType;
    private ObjectArrayList list = new ObjectArrayList();
    private Comparator comparator;
    private IntValue key = new IntValue();
    private static Comparator floatComparator = new Comparator(){

        public int compare(Object o1, Object o2) {
            int len2;
            int len1 = o1 instanceof IntValue ? ((IntValue)o1).value : ((float[])o1).length;
            int n = len2 = o2 instanceof IntValue ? ((IntValue)o2).value : ((float[])o2).length;
            return len1 > len2 ? 1 : (len1 < len2 ? -1 : 0);
        }
    };
    private static Comparator intComparator = new Comparator(){

        public int compare(Object o1, Object o2) {
            int len2;
            int len1 = o1 instanceof IntValue ? ((IntValue)o1).value : ((int[])o1).length;
            int n = len2 = o2 instanceof IntValue ? ((IntValue)o2).value : ((int[])o2).length;
            return len1 > len2 ? 1 : (len1 < len2 ? -1 : 0);
        }
    };
    private static Comparator objectComparator = new Comparator(){

        public int compare(Object o1, Object o2) {
            int len2;
            int len1 = o1 instanceof IntValue ? ((IntValue)o1).value : ((Object[])o1).length;
            int n = len2 = o2 instanceof IntValue ? ((IntValue)o2).value : ((Object[])o2).length;
            return len1 > len2 ? 1 : (len1 < len2 ? -1 : 0);
        }
    };
    private static ThreadLocal<Map> threadLocal = new ThreadLocal<Map>(){

        @Override
        protected Map initialValue() {
            return new HashMap();
        }
    };

    public ArrayPool(Class componentType) {
        this.componentType = componentType;
        if (componentType == Float.TYPE) {
            this.comparator = floatComparator;
        } else if (componentType == Integer.TYPE) {
            this.comparator = intComparator;
        } else if (!componentType.isPrimitive()) {
            this.comparator = objectComparator;
        } else {
            throw new UnsupportedOperationException("unsupported type " + componentType);
        }
    }

    private T create(int length) {
        return (T)Array.newInstance(this.componentType, length);
    }

    public T getFixed(int length) {
        this.key.value = length;
        int index = Collections.binarySearch(this.list, this.key, this.comparator);
        if (index < 0) {
            return this.create(length);
        }
        return this.list.remove(index);
    }

    public T getAtLeast(int length) {
        this.key.value = length;
        int index = Collections.binarySearch(this.list, this.key, this.comparator);
        if (index < 0) {
            if ((index = -index - 1) < this.list.size()) {
                return this.list.remove(index);
            }
            return this.create(length);
        }
        return this.list.remove(index);
    }

    public void release(T array) {
        int index = Collections.binarySearch(this.list, array, this.comparator);
        if (index < 0) {
            index = -index - 1;
        }
        this.list.add(index, array);
        if (this.comparator == objectComparator) {
            Object[] objArray = (Object[])array;
            for (int i = 0; i < objArray.length; ++i) {
                objArray[i] = null;
            }
        }
    }

    public static <T> ArrayPool<T> get(Class cls) {
        Map map2 = threadLocal.get();
        ArrayPool<T> pool = (ArrayPool<T>)map2.get(cls);
        if (pool == null) {
            pool = new ArrayPool<T>(cls);
            map2.put(cls, pool);
        }
        return pool;
    }

    public static void cleanCurrentThread() {
        threadLocal.remove();
    }

    private static class IntValue {
        public int value;

        private IntValue() {
        }
    }
}

