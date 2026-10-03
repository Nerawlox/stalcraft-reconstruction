/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Random;

public abstract class cfof
extends zztd {
    public nwns _a = nwns._a;

    public cfof() {
    }

    public cfof(int n) {
        super(n);
    }

    @Override
    public void _a(qoac qoac2) {
        qoac2._a("EntryDoor", this._a.name());
    }

    @Override
    public void _b(qoac qoac2) {
        this._a = nwns.valueOf(qoac2._j("EntryDoor"));
    }

    public void _a(ozlu ozlu2, Random random, uken uken2, nwns nwns2, int n, int n2, int n3) {
        switch (nwns2) {
            default: {
                this._a(ozlu2, uken2, n, n2, n3, n + 3 - 1, n2 + 3 - 1, n3, 0, 0, false);
                break;
            }
            case _b: {
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n, n2, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n, n2 + 1, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n, n2 + 2, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n + 1, n2 + 2, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n + 2, n2 + 2, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n + 2, n2 + 1, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n + 2, n2, n3, uken2);
                this._a(ozlu2, twgu.field_72054_aE.field_71990_ca, 0, n + 1, n2, n3, uken2);
                this._a(ozlu2, twgu.field_72054_aE.field_71990_ca, 8, n + 1, n2 + 1, n3, uken2);
                break;
            }
            case _c: {
                this._a(ozlu2, 0, 0, n + 1, n2, n3, uken2);
                this._a(ozlu2, 0, 0, n + 1, n2 + 1, n3, uken2);
                this._a(ozlu2, twgu.field_72002_bp.field_71990_ca, 0, n, n2, n3, uken2);
                this._a(ozlu2, twgu.field_72002_bp.field_71990_ca, 0, n, n2 + 1, n3, uken2);
                this._a(ozlu2, twgu.field_72002_bp.field_71990_ca, 0, n, n2 + 2, n3, uken2);
                this._a(ozlu2, twgu.field_72002_bp.field_71990_ca, 0, n + 1, n2 + 2, n3, uken2);
                this._a(ozlu2, twgu.field_72002_bp.field_71990_ca, 0, n + 2, n2 + 2, n3, uken2);
                this._a(ozlu2, twgu.field_72002_bp.field_71990_ca, 0, n + 2, n2 + 1, n3, uken2);
                this._a(ozlu2, twgu.field_72002_bp.field_71990_ca, 0, n + 2, n2, n3, uken2);
                break;
            }
            case _d: {
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n, n2, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n, n2 + 1, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n, n2 + 2, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n + 1, n2 + 2, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n + 2, n2 + 2, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n + 2, n2 + 1, n3, uken2);
                this._a(ozlu2, twgu.field_72007_bm.field_71990_ca, 0, n + 2, n2, n3, uken2);
                this._a(ozlu2, twgu.field_72045_aL.field_71990_ca, 0, n + 1, n2, n3, uken2);
                this._a(ozlu2, twgu.field_72045_aL.field_71990_ca, 8, n + 1, n2 + 1, n3, uken2);
                this._a(ozlu2, twgu.field_72034_aR.field_71990_ca, this._e(twgu.field_72034_aR.field_71990_ca, 4), n + 2, n2 + 1, n3 + 1, uken2);
                this._a(ozlu2, twgu.field_72034_aR.field_71990_ca, this._e(twgu.field_72034_aR.field_71990_ca, 3), n + 2, n2 + 1, n3 - 1, uken2);
            }
        }
    }

    public nwns _a(Random random) {
        int n = random.nextInt(5);
        switch (n) {
            default: {
                return nwns._a;
            }
            case 2: {
                return nwns._b;
            }
            case 3: {
                return nwns._c;
            }
            case 4: 
        }
        return nwns._d;
    }

    public zztd _a(xciz xciz2, List list2, Random random, int n, int n2) {
        switch (this._n) {
            case 2: {
                return iyda._c(xciz2, list2, random, this._m._a + n, this._m._b + n2, this._m._c - 1, this._n, this._e());
            }
            case 0: {
                return iyda._c(xciz2, list2, random, this._m._a + n, this._m._b + n2, this._m._f + 1, this._n, this._e());
            }
            case 1: {
                return iyda._c(xciz2, list2, random, this._m._a - 1, this._m._b + n2, this._m._c + n, this._n, this._e());
            }
            case 3: {
                return iyda._c(xciz2, list2, random, this._m._d + 1, this._m._b + n2, this._m._c + n, this._n, this._e());
            }
        }
        return null;
    }

    public zztd _b(xciz xciz2, List list2, Random random, int n, int n2) {
        switch (this._n) {
            case 2: {
                return iyda._c(xciz2, list2, random, this._m._a - 1, this._m._b + n, this._m._c + n2, 1, this._e());
            }
            case 0: {
                return iyda._c(xciz2, list2, random, this._m._a - 1, this._m._b + n, this._m._c + n2, 1, this._e());
            }
            case 1: {
                return iyda._c(xciz2, list2, random, this._m._a + n2, this._m._b + n, this._m._c - 1, 2, this._e());
            }
            case 3: {
                return iyda._c(xciz2, list2, random, this._m._a + n2, this._m._b + n, this._m._c - 1, 2, this._e());
            }
        }
        return null;
    }

    public zztd _c(xciz xciz2, List list2, Random random, int n, int n2) {
        switch (this._n) {
            case 2: {
                return iyda._c(xciz2, list2, random, this._m._d + 1, this._m._b + n, this._m._c + n2, 3, this._e());
            }
            case 0: {
                return iyda._c(xciz2, list2, random, this._m._d + 1, this._m._b + n, this._m._c + n2, 3, this._e());
            }
            case 1: {
                return iyda._c(xciz2, list2, random, this._m._a + n2, this._m._b + n, this._m._f + 1, 0, this._e());
            }
            case 3: {
                return iyda._c(xciz2, list2, random, this._m._a + n2, this._m._b + n, this._m._f + 1, 0, this._e());
            }
        }
        return null;
    }

    public static boolean _a(uken uken2) {
        return uken2 != null && uken2._b > 10;
    }
}

