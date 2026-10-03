/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;
import net.minecraft.util.vjvn;

public abstract class diqv
extends zztd {
    public static final vjvn[] _b = new vjvn[]{new vjvn(tgdv.field_77702_n.field_77779_bT, 0, 1, 3, 5), new vjvn(tgdv.field_77703_o.field_77779_bT, 0, 1, 5, 5), new vjvn(tgdv.field_77717_p.field_77779_bT, 0, 1, 3, 15), new vjvn(tgdv.field_77672_G.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77806_am.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77709_i.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_77727_br.field_77779_bT, 0, 3, 7, 5), new vjvn(tgdv.field_77765_aA.field_77779_bT, 0, 1, 1, 10), new vjvn(tgdv.field_111216_cf.field_77779_bT, 0, 1, 1, 8), new vjvn(tgdv.field_111215_ce.field_77779_bT, 0, 1, 1, 5), new vjvn(tgdv.field_111213_cg.field_77779_bT, 0, 1, 1, 3)};

    public diqv() {
    }

    public diqv(int n) {
        super(n);
    }

    @Override
    public void _b(qoac qoac2) {
    }

    @Override
    public void _a(qoac qoac2) {
    }

    public int _a(List list2) {
        boolean bl = false;
        int n = 0;
        for (zztf zztf2 : list2) {
            if (zztf2._d > 0 && zztf2._c < zztf2._d) {
                bl = true;
            }
            n += zztf2._b;
        }
        return bl ? n : -1;
    }

    public diqv _a(ozrz ozrz2, List list2, List list3, Random random, int n, int n2, int n3, int n4, int n5) {
        int n6 = this._a(list2);
        boolean bl = n6 > 0 && n5 <= 30;
        int n7 = 0;
        block0: while (n7 < 5 && bl) {
            ++n7;
            int n8 = random.nextInt(n6);
            for (zztf zztf2 : list2) {
                if ((n8 -= zztf2._b) >= 0) continue;
                if (!zztf2._a(n5) || zztf2 == ozrz2._a && !zztf2._e) continue block0;
                diqv diqv2 = yfov._b(zztf2, list3, random, n, n2, n3, n4, n5);
                if (diqv2 == null) continue;
                ++zztf2._c;
                ozrz2._a = zztf2;
                if (!zztf2._a()) {
                    list2.remove(zztf2);
                }
                return diqv2;
            }
        }
        return cwmo._a(list3, random, n, n2, n3, n4, n5);
    }

    public zztd _a(ozrz ozrz2, List list2, Random random, int n, int n2, int n3, int n4, int n5, boolean bl) {
        diqv diqv2;
        if (Math.abs(n - ozrz2._d()._a) > 112 || Math.abs(n3 - ozrz2._d()._c) > 112) {
            return cwmo._a(list2, random, n, n2, n3, n4, n5);
        }
        List list3 = ozrz2._c;
        if (bl) {
            list3 = ozrz2._d;
        }
        if ((diqv2 = this._a(ozrz2, list3, list2, random, n, n2, n3, n4, n5 + 1)) != null) {
            list2.add(diqv2);
            ozrz2._e.add(diqv2);
        }
        return diqv2;
    }

    public zztd _a(ozrz ozrz2, List list2, Random random, int n, int n2, boolean bl) {
        switch (this._n) {
            case 2: {
                return this._a(ozrz2, list2, random, this._m._a + n, this._m._b + n2, this._m._c - 1, this._n, this._e(), bl);
            }
            case 0: {
                return this._a(ozrz2, list2, random, this._m._a + n, this._m._b + n2, this._m._f + 1, this._n, this._e(), bl);
            }
            case 1: {
                return this._a(ozrz2, list2, random, this._m._a - 1, this._m._b + n2, this._m._c + n, this._n, this._e(), bl);
            }
            case 3: {
                return this._a(ozrz2, list2, random, this._m._d + 1, this._m._b + n2, this._m._c + n, this._n, this._e(), bl);
            }
        }
        return null;
    }

    public zztd _b(ozrz ozrz2, List list2, Random random, int n, int n2, boolean bl) {
        switch (this._n) {
            case 2: {
                return this._a(ozrz2, list2, random, this._m._a - 1, this._m._b + n, this._m._c + n2, 1, this._e(), bl);
            }
            case 0: {
                return this._a(ozrz2, list2, random, this._m._a - 1, this._m._b + n, this._m._c + n2, 1, this._e(), bl);
            }
            case 1: {
                return this._a(ozrz2, list2, random, this._m._a + n2, this._m._b + n, this._m._c - 1, 2, this._e(), bl);
            }
            case 3: {
                return this._a(ozrz2, list2, random, this._m._a + n2, this._m._b + n, this._m._c - 1, 2, this._e(), bl);
            }
        }
        return null;
    }

    public zztd _c(ozrz ozrz2, List list2, Random random, int n, int n2, boolean bl) {
        switch (this._n) {
            case 2: {
                return this._a(ozrz2, list2, random, this._m._d + 1, this._m._b + n, this._m._c + n2, 3, this._e(), bl);
            }
            case 0: {
                return this._a(ozrz2, list2, random, this._m._d + 1, this._m._b + n, this._m._c + n2, 3, this._e(), bl);
            }
            case 1: {
                return this._a(ozrz2, list2, random, this._m._a + n2, this._m._b + n, this._m._f + 1, 0, this._e(), bl);
            }
            case 3: {
                return this._a(ozrz2, list2, random, this._m._a + n2, this._m._b + n, this._m._f + 1, 0, this._e(), bl);
            }
        }
        return null;
    }

    public static boolean _a(uken uken2) {
        return uken2 != null && uken2._b > 10;
    }
}

