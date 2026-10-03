/*
 * Decompiled with CFR 0.152.
 */
public enum nvsz {
    _a,
    _b,
    _c,
    _d,
    _e,
    _f,
    _g,
    _h,
    _i;


    public boolean _a(tgdv tgdv2) {
        if (this == _a) {
            return true;
        }
        if (tgdv2 instanceof lpno) {
            if (this == _b) {
                return true;
            }
            lpno lpno2 = (lpno)tgdv2;
            if (lpno2.field_77881_a == 0) {
                return this == _f;
            }
            if (lpno2.field_77881_a == 2) {
                return this == _d;
            }
            if (lpno2.field_77881_a == 1) {
                return this == _e;
            }
            if (lpno2.field_77881_a == 3) {
                return this == _c;
            }
            return false;
        }
        if (tgdv2 instanceof vmpw) {
            return this == _g;
        }
        if (tgdv2 instanceof focs) {
            return this == _h;
        }
        if (tgdv2 instanceof txfj) {
            return this == _i;
        }
        return false;
    }
}

