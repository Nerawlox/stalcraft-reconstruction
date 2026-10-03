/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import net.sf.kdgcommons.lang.ObjectFactory;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class DefaultMap<K, V>
implements Map<K, V> {
    private Map<K, V> _delegate;
    private ObjectFactory<V> _valueFactory;
    private boolean _updateMap;

    public DefaultMap(Map<K, V> map, ObjectFactory<V> objectFactory, boolean bl) {
        this._delegate = map;
        this._valueFactory = objectFactory;
        this._updateMap = bl;
    }

    public DefaultMap(Map<K, V> map, V v) {
        this(map, new StaticValueFactory<V>(v), false);
    }

    public DefaultMap(Map<K, V> map, ObjectFactory<V> objectFactory) {
        this(map, objectFactory, true);
    }

    @Override
    public V get(Object object) {
        if (this._delegate.containsKey(object)) {
            return this._delegate.get(object);
        }
        V v = this._valueFactory.newInstance();
        if (this._updateMap) {
            this._delegate.put(object, v);
        }
        return v;
    }

    @Override
    public int size() {
        return this._delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return this._delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object object) {
        return this._delegate.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this._delegate.containsValue(object);
    }

    @Override
    public V put(K k, V v) {
        return this._delegate.put(k, v);
    }

    @Override
    public V remove(Object object) {
        return this._delegate.remove(object);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        this._delegate.putAll(map);
    }

    @Override
    public void clear() {
        this._delegate.clear();
    }

    @Override
    public Set<K> keySet() {
        return this._delegate.keySet();
    }

    @Override
    public Collection<V> values() {
        return this._delegate.values();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return this._delegate.entrySet();
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class StaticValueFactory<T>
    implements ValueFactory<T> {
        private T _value;

        public StaticValueFactory(T t) {
            this._value = t;
        }

        @Override
        public T newInstance() {
            return this._value;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static interface ValueFactory<T>
    extends ObjectFactory<T> {
        @Override
        public T newInstance();
    }
}

