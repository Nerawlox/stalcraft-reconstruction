/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.bean;

import java.util.HashMap;
import java.util.Map;
import net.sf.kdgcommons.bean.Introspection;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class IntrospectionCache {
    private static Map<Class<?>, Introspection> _staticCache = new HashMap();
    private Map<Class<?>, Introspection> _cache;

    public IntrospectionCache() {
        this(false);
    }

    public IntrospectionCache(boolean bl) {
        this._cache = bl ? _staticCache : new HashMap();
    }

    public synchronized Introspection lookup(Class<?> clazz) {
        Introspection introspection = this._cache.get(clazz);
        if (introspection == null) {
            introspection = new Introspection(clazz);
            this._cache.put(clazz, introspection);
        }
        return introspection;
    }
}

