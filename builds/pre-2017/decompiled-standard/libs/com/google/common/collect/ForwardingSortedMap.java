/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingMap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedMap<K, V>
extends ForwardingMap<K, V>
implements SortedMap<K, V> {
    protected ForwardingSortedMap() {
    }

    @Override
    protected abstract SortedMap<K, V> delegate();

    @Override
    public Comparator<? super K> comparator() {
        return this.delegate().comparator();
    }

    @Override
    public K firstKey() {
        return this.delegate().firstKey();
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return this.delegate().headMap(toKey);
    }

    @Override
    public K lastKey() {
        return this.delegate().lastKey();
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return this.delegate().subMap(fromKey, toKey);
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return this.delegate().tailMap(fromKey);
    }

    private int unsafeCompare(Object k1, Object k2) {
        Comparator<K> comparator = this.comparator();
        if (comparator == null) {
            return ((Comparable)k1).compareTo(k2);
        }
        return comparator.compare(k1, k2);
    }

    @Override
    @Beta
    protected boolean standardContainsKey(@Nullable Object key) {
        try {
            ForwardingSortedMap self = this;
            Object ceilingKey = self.tailMap(key).firstKey();
            return this.unsafeCompare(ceilingKey, key) == 0;
        }
        catch (ClassCastException e) {
            return false;
        }
        catch (NoSuchElementException e) {
            return false;
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    @Beta
    protected V standardRemove(@Nullable Object key) {
        try {
            Map.Entry ceilingEntry;
            ForwardingSortedMap self = this;
            Iterator entryIterator = self.tailMap(key).entrySet().iterator();
            if (entryIterator.hasNext() && this.unsafeCompare((ceilingEntry = entryIterator.next()).getKey(), key) == 0) {
                Object value = ceilingEntry.getValue();
                entryIterator.remove();
                return value;
            }
        }
        catch (ClassCastException e) {
            return null;
        }
        catch (NullPointerException e) {
            return null;
        }
        return null;
    }

    @Beta
    protected SortedMap<K, V> standardSubMap(K fromKey, K toKey) {
        return this.tailMap(fromKey).headMap(toKey);
    }
}

