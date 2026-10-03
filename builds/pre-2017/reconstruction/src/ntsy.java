/*
 * Decompiled with CFR 0.152.
 */
public class ntsy {
    public final String _a;
    public final int _b;
    public final boolean _c;
    public int _d;

    public ntsy(String string, int n, int n2) {
        this._a = string;
        this._b = n;
        this._c = n2 > 0;
        this._d = n2;
    }

    public boolean _a() {
        return this._c && --this._d <= 0;
    }
}

