/*
 * Decompiled with CFR 0.152.
 */
public class wpmi
extends zhqo {
    public wpmi(int n, int n2) {
        super(n, n2, nvsz._h);
        this._a("digging");
    }

    @Override
    public int _a(int n) {
        return 1 + 10 * (n - 1);
    }

    @Override
    public int _b(int n) {
        return super._a(n) + 50;
    }

    @Override
    public int _c() {
        return 5;
    }

    @Override
    public boolean _a(cvzo cvzo2) {
        if (cvzo2._a().field_77779_bT == tgdv.field_77745_be.field_77779_bT) {
            return true;
        }
        return super._a(cvzo2);
    }
}

