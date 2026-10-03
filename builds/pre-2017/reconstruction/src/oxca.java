/*
 * Decompiled with CFR 0.152.
 */
public interface oxca {
    public kjui getState();

    default public boolean _q() {
        return this.getState() == kjui._c;
    }

    default public boolean _r() {
        return this.getState() == kjui._d;
    }

    default public boolean _s() {
        return this.getState() == kjui._b;
    }

    default public boolean _t() {
        return this.getState() == kjui._a;
    }

    public static enum kjui {
        _a,
        _b,
        _c,
        _d;

    }
}

