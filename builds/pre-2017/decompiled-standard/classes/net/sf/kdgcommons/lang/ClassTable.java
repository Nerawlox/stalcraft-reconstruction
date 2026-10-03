/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.lang;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class ClassTable<T> {
    private volatile ConcurrentHashMap<Class<?>, T> _map = new ConcurrentHashMap();

    public int size() {
        return this._map.size();
    }

    public void put(Class<?> clazz, T t) {
        this._map.put(clazz, t);
    }

    public T get(Class<?> clazz) {
        T t = this._map.get(clazz);
        if (t != null) {
            return t;
        }
        Class<?> clazz2 = clazz.getSuperclass();
        if (clazz2 == null) {
            return null;
        }
        t = this.get(clazz2);
        if (t != null) {
            this._map.put(clazz, t);
        }
        return t;
    }

    public T getByObject(Object object) {
        return this.get(object.getClass());
    }

    public void replace(Class<?> clazz, T t) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<Class<?>, T> entry : this._map.entrySet()) {
            if (clazz.isAssignableFrom(entry.getKey())) {
                concurrentHashMap.put(entry.getKey(), t);
                continue;
            }
            concurrentHashMap.put(entry.getKey(), entry.getValue());
        }
        this._map = concurrentHashMap;
    }
}

