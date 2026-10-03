/*
 * Decompiled with CFR 0.152.
 */
public class sdai
extends zhqo {
    public sdai(int n, int n2, nvsz nvsz2) {
        super(n, n2, nvsz2);
        this._a("lootBonus");
        if (nvsz2 == nvsz._h) {
            this._a("lootBonusDigger");
        }
    }

    @Override
    public int _a(int n) {
        return 15 + (n - 1) * 9;
    }

    @Override
    public int _b(int n) {
        return super._a(n) + 50;
    }

    @Override
    public int _c() {
        return 3;
    }

    @Override
    public boolean _a(zhqo zhqo2) {
        return super._a(zhqo2) && zhqo2._y != sdai._r._y;
    }
}

