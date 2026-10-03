/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class iyda {
    public static final oisg[] _a = new oisg[]{new oisg(mtkz.class, 40, 0), new oisg(zzqj.class, 5, 5), new oisg(cwpp.class, 20, 0), new oisg(ukbc.class, 20, 0), new oisg(wqhb.class, 10, 6), new oisg(rryi.class, 5, 5), new oisg(vnea.class, 5, 5), new oisg(btmr.class, 5, 4), new oisg(oiqc.class, 5, 4), new lqkn(cwpq.class, 10, 2), new jken(nwos.class, 20, 1)};
    public static List _b;
    public static Class _c;
    public static int _d;
    public static final vngw _e;

    public static void _a() {
        cfps._b(oiqc.class, "SHCC");
        cfps._b(grzx.class, "SHFC");
        cfps._b(btmr.class, "SH5C");
        cfps._b(cwpp.class, "SHLT");
        cfps._b(cwpq.class, "SHLi");
        cfps._b(nwos.class, "SHPR");
        cfps._b(zzqj.class, "SHPH");
        cfps._b(ukbc.class, "SHRT");
        cfps._b(wqhb.class, "SHRC");
        cfps._b(vnea.class, "SHSD");
        cfps._b(xciz.class, "SHStart");
        cfps._b(mtkz.class, "SHS");
        cfps._b(rryi.class, "SHSSD");
    }

    public static void _b() {
        _b = new ArrayList();
        for (oisg oisg2 : _a) {
            oisg2._c = 0;
            _b.add(oisg2);
        }
        _c = null;
    }

    public static boolean _c() {
        boolean bl = false;
        _d = 0;
        for (oisg oisg2 : _b) {
            if (oisg2._d > 0 && oisg2._c < oisg2._d) {
                bl = true;
            }
            _d += oisg2._b;
        }
        return bl;
    }

    public static cfof _a(Class clazz, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        cfof cfof2 = null;
        if (clazz == mtkz.class) {
            cfof2 = mtkz._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == zzqj.class) {
            cfof2 = zzqj._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == cwpp.class) {
            cfof2 = cwpp._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == ukbc.class) {
            cfof2 = ukbc._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == wqhb.class) {
            cfof2 = wqhb._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == rryi.class) {
            cfof2 = rryi._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == vnea.class) {
            cfof2 = vnea._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == btmr.class) {
            cfof2 = btmr._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == oiqc.class) {
            cfof2 = oiqc._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == cwpq.class) {
            cfof2 = cwpq._a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == nwos.class) {
            cfof2 = nwos._a(list, random, n, n2, n3, n4, n5);
        }
        return cfof2;
    }

    public static cfof _a(xciz xciz2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        if (!iyda._c()) {
            return null;
        }
        if (_c != null) {
            cfof cfof2 = iyda._a(_c, list, random, n, n2, n3, n4, n5);
            _c = null;
            if (cfof2 != null) {
                return cfof2;
            }
        }
        int n6 = 0;
        block0: while (n6 < 5) {
            ++n6;
            int n7 = random.nextInt(_d);
            for (oisg oisg2 : _b) {
                if ((n7 -= oisg2._b) >= 0) continue;
                if (!oisg2._a(n5) || oisg2 == xciz2._c) continue block0;
                cfof cfof3 = iyda._a(oisg2._a, list, random, n, n2, n3, n4, n5);
                if (cfof3 == null) continue;
                ++oisg2._c;
                xciz2._c = oisg2;
                if (!oisg2._a()) {
                    _b.remove(oisg2);
                }
                return cfof3;
            }
        }
        uken uken2 = grzx._a(list, random, n, n2, n3, n4);
        if (uken2 != null && uken2._b > 1) {
            return new grzx(n5, random, uken2, n4);
        }
        return null;
    }

    public static zztd _b(xciz xciz2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        if (n5 > 50) {
            return null;
        }
        if (Math.abs(n - xciz2._d()._a) > 112 || Math.abs(n3 - xciz2._d()._c) > 112) {
            return null;
        }
        cfof cfof2 = iyda._a(xciz2, list, random, n, n2, n3, n4, n5 + 1);
        if (cfof2 != null) {
            list.add(cfof2);
            xciz2._e.add(cfof2);
        }
        return cfof2;
    }

    public static /* synthetic */ zztd _c(xciz xciz2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        return iyda._b(xciz2, list, random, n, n2, n3, n4, n5);
    }

    public static /* synthetic */ Class _a(Class clazz) {
        _c = clazz;
        return _c;
    }

    public static /* synthetic */ vngw _d() {
        return _e;
    }

    static {
        _e = new vngw(null);
    }
}

