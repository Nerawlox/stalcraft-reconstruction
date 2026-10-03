/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.util.sajh;

public class jkbf
extends yfll {
    public int _e;

    public jkbf() {
    }

    public jkbf(fovt fovt2, int n, Random random, uken uken2, int n2) {
        super(fovt2, n);
        this._n = n2;
        this._m = uken2;
        this._e = Math.max(uken2._b(), uken2._d());
    }

    @Override
    public void _a(qoac qoac2) {
        super._a(qoac2);
        qoac2._a("Length", this._e);
    }

    @Override
    public void _b(qoac qoac2) {
        super._b(qoac2);
        this._e = qoac2._f("Length");
    }

    @Override
    public void _a(zztd zztd2, List list2, Random random) {
        zztd zztd3;
        int n;
        boolean bl = false;
        for (n = random.nextInt(5); n < this._e - 8; n += 2 + random.nextInt(5)) {
            zztd3 = this._a((fovt)zztd2, list2, random, 0, n);
            if (zztd3 == null) continue;
            n += Math.max(zztd3._m._b(), zztd3._m._d());
            bl = true;
        }
        for (n = random.nextInt(5); n < this._e - 8; n += 2 + random.nextInt(5)) {
            zztd3 = this._b((fovt)zztd2, list2, random, 0, n);
            if (zztd3 == null) continue;
            n += Math.max(zztd3._m._b(), zztd3._m._d());
            bl = true;
        }
        if (bl && random.nextInt(3) > 0) {
            switch (this._n) {
                case 2: {
                    tybp._e((fovt)zztd2, list2, random, this._m._a - 1, this._m._b, this._m._c, 1, this._e());
                    break;
                }
                case 0: {
                    tybp._e((fovt)zztd2, list2, random, this._m._a - 1, this._m._b, this._m._f - 2, 1, this._e());
                    break;
                }
                case 3: {
                    tybp._e((fovt)zztd2, list2, random, this._m._d - 2, this._m._b, this._m._c - 1, 2, this._e());
                    break;
                }
                case 1: {
                    tybp._e((fovt)zztd2, list2, random, this._m._a, this._m._b, this._m._c - 1, 2, this._e());
                }
            }
        }
        if (bl && random.nextInt(3) > 0) {
            switch (this._n) {
                case 2: {
                    tybp._e((fovt)zztd2, list2, random, this._m._d + 1, this._m._b, this._m._c, 3, this._e());
                    break;
                }
                case 0: {
                    tybp._e((fovt)zztd2, list2, random, this._m._d + 1, this._m._b, this._m._f - 2, 3, this._e());
                    break;
                }
                case 3: {
                    tybp._e((fovt)zztd2, list2, random, this._m._d - 2, this._m._b, this._m._f + 1, 0, this._e());
                    break;
                }
                case 1: {
                    tybp._e((fovt)zztd2, list2, random, this._m._a, this._m._b, this._m._f + 1, 0, this._e());
                }
            }
        }
    }

    public static uken _a(fovt fovt2, List list2, Random random, int n, int n2, int n3, int n4) {
        for (int i = 7 * sajh._a(random, 3, 5); i >= 7; i -= 7) {
            uken uken2 = uken._a(n, n2, n3, 0, 0, 0, 3, 3, i, n4);
            if (zztd._a(list2, uken2) != null) continue;
            return uken2;
        }
        return null;
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        int n = this._a(twgu.field_71940_F.field_71990_ca, 0);
        for (int i = this._m._a; i <= this._m._d; ++i) {
            for (int j = this._m._c; j <= this._m._f; ++j) {
                if (!uken2._b(i, 64, j)) continue;
                int n2 = ozlu2.func_72825_h(i, j) - 1;
                ozlu2.func_72832_d(i, n2, j, n, 0, 2);
            }
        }
        return true;
    }
}

