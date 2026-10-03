/*
 * Decompiled with CFR 0.152.
 */
public class pzop<F, S, T> {
    public F _a;
    public S _b;
    public T _c;

    public pzop(F f, S s, T t) {
        this._a = f;
        this._b = s;
        this._c = t;
    }

    public static <F, S, T> pzop<F, S, T> _a(F f, S s, T t) {
        return new pzop<F, S, T>(f, s, t);
    }
}

