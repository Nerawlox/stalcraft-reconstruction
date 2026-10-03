/*
 * Decompiled with CFR 0.152.
 */
public enum yery {
    _a(5, new int[]{1, 3, 2, 1}, 15),
    _b(15, new int[]{2, 5, 4, 1}, 12),
    _c(15, new int[]{2, 6, 5, 2}, 9),
    _d(7, new int[]{2, 5, 3, 1}, 25),
    _e(33, new int[]{3, 8, 6, 3}, 10);

    public int _f;
    public int[] _g;
    public int _h;
    public tgdv _i = null;

    public yery(int n2, int[] nArray, int n3) {
        this._f = n2;
        this._g = nArray;
        this._h = n3;
    }

    public int _a(int n) {
        return lpno.func_77877_c()[n] * this._f;
    }

    public int _b(int n) {
        return this._g[n];
    }

    public int _a() {
        return this._h;
    }

    public int _b() {
        switch (this) {
            case _a: {
                return tgdv.field_77770_aF.field_77779_bT;
            }
            case _b: {
                return tgdv.field_77703_o.field_77779_bT;
            }
            case _d: {
                return tgdv.field_77717_p.field_77779_bT;
            }
            case _c: {
                return tgdv.field_77703_o.field_77779_bT;
            }
            case _e: {
                return tgdv.field_77702_n.field_77779_bT;
            }
        }
        return this._i == null ? 0 : this._i.field_77779_bT;
    }
}

