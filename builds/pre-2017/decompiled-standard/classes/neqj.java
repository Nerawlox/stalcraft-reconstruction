/*
 * Decompiled with CFR 0.152.
 */
public abstract class neqj
implements txei {
    public final String _a;
    public final double _b;
    public boolean _c;

    public neqj(String string, double d) {
        this._a = string;
        this._b = d;
        if (string == null) {
            throw new IllegalArgumentException("Name cannot be null!");
        }
    }

    @Override
    public String _a() {
        return this._a;
    }

    @Override
    public double _b() {
        return this._b;
    }

    @Override
    public boolean _c() {
        return this._c;
    }

    public neqj _a(boolean bl) {
        this._c = bl;
        return this;
    }

    public int hashCode() {
        return this._a.hashCode();
    }
}

