/*
 * Decompiled with CFR 0.152.
 */
public class ivtu {
    private final Runnable _a;
    private final int _b;
    private int _c;

    public ivtu(Runnable runnable, int n) {
        this._a = runnable;
        this._b = n;
        if (n <= 0) {
            throw new IllegalArgumentException("targetCallbacks must be positive!");
        }
    }

    public void _a() {
        if (++this._c == this._b) {
            this._a.run();
        }
    }

    public void _a(Object object) {
        this._a();
    }
}

