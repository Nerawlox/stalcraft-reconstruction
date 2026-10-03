/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.collections;

import java.util.Arrays;
import java.util.Iterator;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class CompoundKey
implements Iterable<Object> {
    private Object[] _components;
    private int _hashCode;
    private String _stringValue;

    public CompoundKey(Object ... objectArray) {
        this._components = objectArray;
        for (Object object : objectArray) {
            if (object == null) continue;
            this._hashCode = this._hashCode * 37 + object.hashCode();
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return Arrays.asList(this._components).iterator();
    }

    public String toString() {
        if (this._stringValue == null) {
            StringBuilder stringBuilder = new StringBuilder(this._components.length * 16);
            stringBuilder.append("[");
            for (Object object : this._components) {
                if (stringBuilder.length() > 1) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(object);
            }
            stringBuilder.append("]");
            this._stringValue = stringBuilder.toString();
        }
        return this._stringValue;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof CompoundKey) {
            return Arrays.equals(this._components, ((CompoundKey)object)._components);
        }
        return false;
    }

    public int hashCode() {
        return this._hashCode;
    }
}

