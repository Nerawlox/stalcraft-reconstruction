/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.lang;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class StringCanon {
    private Map<String, WeakReference<String>> _map = new WeakHashMap<String, WeakReference<String>>();

    public synchronized String intern(String string) {
        String string2;
        WeakReference<String> weakReference = this._map.get(string);
        String string3 = string2 = weakReference != null ? (String)weakReference.get() : null;
        if (string2 == null) {
            string2 = new String(string);
            this._map.put(string2, new WeakReference<String>(string2));
        }
        return string2;
    }

    public synchronized int size() {
        return this._map.size();
    }
}

