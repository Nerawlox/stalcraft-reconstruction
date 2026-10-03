/*
 * Decompiled with CFR 0.152.
 */
public class zhkm
implements Comparable {
    public final String _a;
    public final String _b;
    public final String _c;
    public final boolean _d;

    public zhkm(String string, String string2, String string3, boolean bl) {
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
        if (!(object instanceof zhkm)) {
            return false;
        }
        return this._a.equals(((zhkm)object)._a);
    }

    public int hashCode() {
        return this._a.hashCode();
    }

    public int _a(zhkm zhkm2) {
        return this._a.compareTo(zhkm2._a);
    }

    public /* synthetic */ int compareTo(Object object) {
        return this._a((zhkm)object);
    }
}

