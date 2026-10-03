/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.collections;

import java.util.Map;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MapBuilder<K, V> {
    private Map<K, V> _map;

    public MapBuilder(Map<K, V> map) {
        this._map = map;
    }

    public MapBuilder<K, V> put(K k, V v) {
        this._map.put(k, v);
        return this;
    }

    public Map<K, V> toMap() {
        return this._map;
    }
}

