/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.pcollections;

import java.io.Serializable;

final class MapEntry<K, V>
implements Serializable {
    private static final long serialVersionUID = 7138329143949025153L;
    public final K key;
    public final V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean equals(Object o) {
        if (!(o instanceof MapEntry)) {
            return false;
        }
        MapEntry e = (MapEntry)o;
        return (this.key == null ? e.key == null : this.key.equals(e.key)) && (this.value == null ? e.value == null : this.value.equals(e.value));
    }

    public int hashCode() {
        return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
    }

    public String toString() {
        return this.key + "=" + this.value;
    }
}

