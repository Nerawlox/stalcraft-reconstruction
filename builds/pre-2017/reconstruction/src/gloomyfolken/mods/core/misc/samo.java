/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import java.util.HashMap;

public class samo<K, T> {
    protected Class _a = Object.class;
    protected HashMap<Class<? extends K>, T> _b = new HashMap();

    public samo(Class clazz) {
        this._a = clazz;
    }

    public <R extends K> void _a(Class<R> clazz, Object object) {
        this._b.put(clazz, object);
    }

    public T _a(Class<? extends K> clazz) {
        T t = this._b.get(clazz);
        for (Class<K> clazz2 = clazz; t == null && this._a.isAssignableFrom(clazz2) && clazz2 != this._a; clazz2 = clazz2.getSuperclass()) {
            t = this._b.get(clazz2);
        }
        return t;
    }
}

