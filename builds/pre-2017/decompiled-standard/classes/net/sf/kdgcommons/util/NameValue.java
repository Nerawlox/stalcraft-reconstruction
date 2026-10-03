/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.util;

import net.sf.kdgcommons.lang.ObjectUtil;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class NameValue<T>
implements Comparable<NameValue<T>> {
    private String _name;
    private T _value;

    public NameValue(String string, T t) {
        this._name = string;
        this._value = t;
    }

    public String getName() {
        return this._name;
    }

    public T getValue() {
        return this._value;
    }

    public final boolean equals(Object object) {
        if (object instanceof NameValue) {
            NameValue nameValue = (NameValue)object;
            return ObjectUtil.equals(this._name, nameValue._name) && ObjectUtil.equals(this._value, nameValue._value);
        }
        return false;
    }

    public int hashCode() {
        return ObjectUtil.hashCode(this._name) * 31 + ObjectUtil.hashCode(this._value);
    }

    public String toString() {
        return "[" + this._name + "=" + String.valueOf(this._value) + "]";
    }

    @Override
    public int compareTo(NameValue<T> nameValue) {
        int n = this._name.compareTo(nameValue._name);
        if (n != 0) {
            return n;
        }
        if (this._value instanceof Comparable) {
            return ((Comparable)this._value).compareTo(nameValue._value);
        }
        if (ObjectUtil.equals(this._value, nameValue._value)) {
            return 0;
        }
        return String.valueOf(this._value).compareTo(String.valueOf(nameValue._value));
    }
}

