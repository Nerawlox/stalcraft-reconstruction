/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class nwmc
extends zztd {
    public List _a = new LinkedList();

    public nwmc() {
    }

    public nwmc(int n, Random random, int n2, int n3) {
        super(n);
        this._m = new uken(n2, 50, n3, n2 + 7 + random.nextInt(6), 54 + random.nextInt(6), n3 + 7 + random.nextInt(6));
    }

    @Override
    public void _a(zztd zztd2, List list2, Random random) {
        uken uken2;
        zztd zztd3;
        int n;
        int n2 = this._e();
        int n3 = this._m._c() - 3 - 1;
        if (n3 <= 0) {
            n3 = 1;
        }
        for (n = 0; n < this._m._b() && (n += random.nextInt(this._m._b())) + 3 <= this._m._b(); n += 4) {
            zztd3 = mtob._b(zztd2, list2, random, this._m._a + n, this._m._b + random.nextInt(n3) + 1, this._m._c - 1, 2, n2);
            if (zztd3 == null) continue;
            uken2 = zztd3._d();
            this._a.add(new uken(uken2._a, uken2._b, this._m._c, uken2._d, uken2._e, this._m._c + 1));
        }
        for (n = 0; n < this._m._b() && (n += random.nextInt(this._m._b())) + 3 <= this._m._b(); n += 4) {
            zztd3 = mtob._b(zztd2, list2, random, this._m._a + n, this._m._b + random.nextInt(n3) + 1, this._m._f + 1, 0, n2);
            if (zztd3 == null) continue;
            uken2 = zztd3._d();
            this._a.add(new uken(uken2._a, uken2._b, this._m._f - 1, uken2._d, uken2._e, this._m._f));
        }
        for (n = 0; n < this._m._d() && (n += random.nextInt(this._m._d())) + 3 <= this._m._d(); n += 4) {
            zztd3 = mtob._b(zztd2, list2, random, this._m._a - 1, this._m._b + random.nextInt(n3) + 1, this._m._c + n, 1, n2);
            if (zztd3 == null) continue;
            uken2 = zztd3._d();
            this._a.add(new uken(this._m._a, uken2._b, uken2._c, this._m._a + 1, uken2._e, uken2._f));
        }
        for (n = 0; n < this._m._d() && (n += random.nextInt(this._m._d())) + 3 <= this._m._d(); n += 4) {
            zztd3 = mtob._b(zztd2, list2, random, this._m._d + 1, this._m._b + random.nextInt(n3) + 1, this._m._c + n, 3, n2);
            if (zztd3 == null) continue;
            uken2 = zztd3._d();
            this._a.add(new uken(this._m._d - 1, uken2._b, uken2._c, this._m._d, uken2._e, uken2._f));
        }
    }

    @Override
    public boolean _a(ozlu ozlu2, Random random, uken uken2) {
        if (this._b(ozlu2, uken2)) {
            return false;
        }
        this._a(ozlu2, uken2, this._m._a, this._m._b, this._m._c, this._m._d, this._m._b, this._m._f, twgu.field_71979_v.field_71990_ca, 0, true);
        this._a(ozlu2, uken2, this._m._a, this._m._b + 1, this._m._c, this._m._d, Math.min(this._m._b + 3, this._m._e), this._m._f, 0, 0, false);
        for (uken uken3 : this._a) {
            this._a(ozlu2, uken2, uken3._a, uken3._e - 2, uken3._c, uken3._d, uken3._e, uken3._f, 0, 0, false);
        }
        this._a(ozlu2, uken2, this._m._a, this._m._b + 4, this._m._c, this._m._d, this._m._e, this._m._f, 0, false);
        return true;
    }

    @Override
    public void _a(qoac qoac2) {
        bsyv bsyv2 = new bsyv("Entrances");
        for (uken uken2 : this._a) {
            bsyv2._a(uken2._a(""));
        }
        qoac2._a("Entrances", bsyv2);
    }

    @Override
    public void _b(qoac qoac2) {
        bsyv bsyv2 = qoac2._n("Entrances");
        for (int i = 0; i < bsyv2._d(); ++i) {
            this._a.add(new uken(((qoak)bsyv2._b((int)i))._c));
        }
    }
}

