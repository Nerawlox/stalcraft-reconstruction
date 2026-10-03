/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

public class Language
implements Comparable {
    public final String _a;
    public final String _b;
    public final String _c;
    public final boolean _d;

    public Language(String string, String string2, String string3, boolean bl) {
        this._a = string;
        this._b = string2;
        this._c = string3;
        this._d = bl;
    }

    public String _a() {
        return this._a;
    }

    public boolean _b() {
        return this._d;
    }

    public String toString() {
        return String.format("%s (%s)", this._c, this._b);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Language)) {
            return false;
        }
        return this._a.equals(((Language)object)._a);
    }

    public int hashCode() {
        return this._a.hashCode();
    }

    public int _a(Language language) {
        return this._a.compareTo(language._a);
    }

    public /* synthetic */ int compareTo(Object object) {
        return this._a((Language)object);
    }
}

