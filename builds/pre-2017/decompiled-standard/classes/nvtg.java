/*
 * Decompiled with CFR 0.152.
 */
public class nvtg
extends zhqo {
    public nvtg(int n, int n2) {
        super(n, n2, nvsz._g);
        this._a("fire");
    }

    @Override
    public int _a(int n) {
        return 10 + 20 * (n - 1);
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

