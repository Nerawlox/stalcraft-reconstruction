/*
 * Decompiled with CFR 0.152.
 */
public class sdan
extends zhqo {
    public sdan(int n, int n2) {
        super(n, n2, nvsz._g);
        this._a("knockback");
    }

    @Override
    public int _a(int n) {
        return 5 + 20 * (n - 1);
    }

    @Override
    public int _b(int n) {
        return super._a(n) + 50;
    }

    @Override
    public int _c() {
        return 2;
    }
}

