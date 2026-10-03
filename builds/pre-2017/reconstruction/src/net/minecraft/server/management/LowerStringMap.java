/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server.management;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LowerStringMap
implements Map {
    public final Map _a = new LinkedHashMap();

    @Override
    public int size() {
        return this._a.size();
    }

    @Override
    public boolean isEmpty() {
        return this._a.isEmpty();
    }

    @Override
    public boolean containsKey(Object object) {
        return this._a.containsKey(object.toString().toLowerCase());
    }

    @Override
    public boolean containsValue(Object object) {
        return this._a.containsKey(object);
    }

    public Object get(Object object) {
        return this._a.get(object.toString().toLowerCase());
    }

    public Object _a(String string, Object object) {
        return this._a.put(string.toLowerCase(), object);
    }

    public Object remove(Object object) {
        return this._a.remove(object.toString().toLowerCase());
    }

    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this._a((String)entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        this._a.clear();
    }

    public Set keySet() {
        return this._a.keySet();
    }

    public Collection values() {
        return this._a.values();
    }

    public Set entrySet() {
        return this._a.entrySet();
    }

    public /* synthetic */ Object put(Object object, Object object2) {
        return this._a((String)object, object2);
    }
}

