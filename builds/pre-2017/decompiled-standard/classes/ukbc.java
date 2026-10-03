/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public class ukbc
extends cwpp {
    @Override
    public void _a(zztd zztd2, List list, Random random) {
        if (this._n == 2 || this._n == 3) {
            this._c((xciz)zztd2, list, random, 1, 1);
        } else {
            this._b((xciz)zztd2, list, random, 1, 1);
        }
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        this._a(ozlu2, uken2, 0, 0, 0, 4, 4, 4, true, random, iyda._d());
        this._a(ozlu2, random, uken2, this._a, 1, 1, 0);
        if (this._n == 2 || this._n == 3) {
            this._a(ozlu2, uken2, 4, 1, 1, 4, 3, 3, 0, 0, false);
        } else {
            this._a(ozlu2, uken2, 0, 1, 1, 0, 3, 3, 0, 0, false);
        }
        return true;
    }
}

