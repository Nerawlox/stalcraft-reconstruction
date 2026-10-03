/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.util;

import com.bulletphysics.util.ObjectArrayList;
import java.util.HashMap;
import java.util.Map;

public class ObjectPool<T> {
    private Class<T> cls;
    private ObjectArrayList<T> list = new ObjectArrayList();
    private static ThreadLocal<Map> threadLocal = new ThreadLocal<Map>(){

        @Override
        protected Map initialValue() {
            return new HashMap();
        }
    };

    public ObjectPool(Class<T> cls) {
        this.cls = cls;
    }

    private T create() {
        try {
            return this.cls.newInstance();
        }
        catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
        catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    public T get() {
        if (this.list.size() > 0) {
            return this.list.remove(this.list.size() - 1);
        }
        return this.create();
    }

    public void release(T obj) {
        this.list.add(obj);
    }

    public static <T> ObjectPool<T> get(Class<T> cls) {
        Map map2 = threadLocal.get();
        ObjectPool<T> pool = (ObjectPool<T>)map2.get(cls);
        if (pool == null) {
            pool = new ObjectPool<T>(cls);
            map2.put(cls, pool);
        }
        return pool;
    }

    public static void cleanCurrentThread() {
        threadLocal.remove();
    }
}

