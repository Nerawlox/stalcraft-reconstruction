/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;

public abstract class ukcj
extends zztd {
    public int _a;
    public int _b;
    public int _c;
    public int _d = -1;

    public ukcj() {
    }

    public ukcj(Random random, int n, int n2, int n3, int n4, int n5, int n6) {
        super(0);
        this._a = n4;
        this._b = n5;
        this._c = n6;
        this._n = random.nextInt(4);
        switch (this._n) {
            case 0: 
            case 2: {
                this._m = new uken(n, n2, n3, n + n4 - 1, n2 + n5 - 1, n3 + n6 - 1);
                break;
            }
            default: {
                this._m = new uken(n, n2, n3, n + n6 - 1, n2 + n5 - 1, n3 + n4 - 1);
            }
        }
    }

    @Override
    public void _a(qoac qoac2) {
        qoac2._a("Width", this._a);
        qoac2._a("Height", this._b);
        qoac2._a("Depth", this._c);
        qoac2._a("HPos", this._d);
    }

    @Override
    public void _b(qoac qoac2) {
        this._a = qoac2._f("Width");
        this._b = qoac2._f("Height");
        this._c = qoac2._f("Depth");
        this._d = qoac2._f("HPos");
    }

    public boolean _a(ozlu ozlu2, uken uken2, int n) {
        if (this._d >= 0) {
            return true;
        }
        int n2 = 0;
        int n3 = 0;
        for (int i = this._m._c; i <= this._m._f; ++i) {
            for (int j = this._m._a; j <= this._m._d; ++j) {
                if (!uken2._b(j, 64, i)) continue;
                n2 += Math.max(ozlu2.func_72825_h(j, i), ozlu2.field_73011_w._i());
                ++n3;
            }
        }
        if (n3 == 0) {
            return false;
        }
        this._d = n2 / n3;
        this._m._a(0, this._d - this._m._b + n, 0);
        return true;
    }
}

