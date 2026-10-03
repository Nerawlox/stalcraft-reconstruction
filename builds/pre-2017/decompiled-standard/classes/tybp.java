/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.VillagerRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.util.sajh;

public class tybp {
    public static void _a() {
        cfps._b(ywng.class, "ViBH");
        cfps._b(yflr.class, "ViDF");
        cfps._b(fowj.class, "ViF");
        cfps._b(bckc.class, "ViL");
        cfps._b(wqhh.class, "ViPH");
        cfps._b(wqgq.class, "ViSH");
        cfps._b(gryy.class, "ViSmH");
        cfps._b(rawz.class, "ViST");
        cfps._b(xtkf.class, "ViS");
        cfps._b(fovt.class, "ViStart");
        cfps._b(jkbf.class, "ViSR");
        cfps._b(nflv.class, "ViTRH");
        cfps._b(plsd.class, "ViW");
    }

    public static List _a(Random random, int n) {
        ArrayList<ihas> arrayList = new ArrayList<ihas>();
        arrayList.add(new ihas(wqgq.class, 4, sajh._a(random, 2 + n, 4 + n * 2)));
        arrayList.add(new ihas(rawz.class, 20, sajh._a(random, 0 + n, 1 + n)));
        arrayList.add(new ihas(ywng.class, 20, sajh._a(random, 0 + n, 2 + n)));
        arrayList.add(new ihas(gryy.class, 3, sajh._a(random, 2 + n, 5 + n * 3)));
        arrayList.add(new ihas(wqhh.class, 15, sajh._a(random, 0 + n, 2 + n)));
        arrayList.add(new ihas(yflr.class, 3, sajh._a(random, 1 + n, 4 + n)));
        arrayList.add(new ihas(fowj.class, 3, sajh._a(random, 2 + n, 4 + n * 2)));
        arrayList.add(new ihas(xtkf.class, 15, sajh._a(random, 0, 1 + n)));
        arrayList.add(new ihas(nflv.class, 8, sajh._a(random, 0 + n, 3 + n * 2)));
        VillagerRegistry.addExtraVillageComponents(arrayList, random, n);
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            if (((ihas)iterator2.next())._d != 0) continue;
            iterator2.remove();
        }
        return arrayList;
    }

    public static int _a(List list) {
        boolean bl = false;
        int n = 0;
        for (ihas ihas2 : list) {
            if (ihas2._d > 0 && ihas2._c < ihas2._d) {
                bl = true;
            }
            n += ihas2._b;
        }
        return bl ? n : -1;
    }

    public static lqhx _a(fovt fovt2, ihas ihas2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        Class clazz = ihas2._a;
        Object object = null;
        object = clazz == wqgq.class ? wqgq._a(fovt2, list, random, n, n2, n3, n4, n5) : (clazz == rawz.class ? rawz._a(fovt2, list, random, n, n2, n3, n4, n5) : (clazz == ywng.class ? ywng._a(fovt2, list, random, n, n2, n3, n4, n5) : (clazz == gryy.class ? gryy._a(fovt2, list, random, n, n2, n3, n4, n5) : (clazz == wqhh.class ? wqhh._a(fovt2, list, random, n, n2, n3, n4, n5) : (clazz == yflr.class ? yflr._a(fovt2, list, random, n, n2, n3, n4, n5) : (clazz == fowj.class ? fowj._a(fovt2, list, random, n, n2, n3, n4, n5) : (clazz == xtkf.class ? xtkf._a(fovt2, list, random, n, n2, n3, n4, n5) : (clazz == nflv.class ? nflv._a(fovt2, list, random, n, n2, n3, n4, n5) : VillagerRegistry.getVillageComponent(ihas2, fovt2, list, random, n, n2, n3, n4, n5)))))))));
        return (lqhx)object;
    }

    public static lqhx _a(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        int n6 = tybp._a(fovt2._j);
        if (n6 <= 0) {
            return null;
        }
        int n7 = 0;
        block0: while (n7 < 5) {
            ++n7;
            int n8 = random.nextInt(n6);
            for (ihas ihas2 : fovt2._j) {
                if ((n8 -= ihas2._b) >= 0) continue;
                if (!ihas2._a(n5) || ihas2 == fovt2._i && fovt2._j.size() > 1) continue block0;
                lqhx lqhx2 = tybp._a(fovt2, ihas2, list, random, n, n2, n3, n4, n5);
                if (lqhx2 == null) continue;
                ++ihas2._c;
                fovt2._i = ihas2;
                if (!ihas2._a()) {
                    fovt2._j.remove(ihas2);
                }
                return lqhx2;
            }
        }
        uken uken2 = bckc._a(fovt2, list, random, n, n2, n3, n4);
        if (uken2 != null) {
            return new bckc(fovt2, n5, random, uken2, n4);
        }
        return null;
    }

    public static zztd _b(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        if (n5 > 50) {
            return null;
        }
        if (Math.abs(n - fovt2._d()._a) <= 112 && Math.abs(n3 - fovt2._d()._c) <= 112) {
            lqhx lqhx2 = tybp._a(fovt2, list, random, n, n2, n3, n4, n5 + 1);
            if (lqhx2 != null) {
                int n6;
                int n7 = (lqhx2._m._a + lqhx2._m._d) / 2;
                int n8 = (lqhx2._m._c + lqhx2._m._f) / 2;
                int n9 = lqhx2._m._d - lqhx2._m._a;
                int n10 = lqhx2._m._f - lqhx2._m._c;
                int n11 = n6 = n9 > n10 ? n9 : n10;
                if (fovt2._b()._a(n7, n8, n6 / 2 + 4, hvak._d)) {
                    list.add(lqhx2);
                    fovt2._k.add(lqhx2);
                    return lqhx2;
                }
            }
            return null;
        }
        return null;
    }

    public static zztd _c(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        if (n5 > 3 + fovt2._h) {
            return null;
        }
        if (Math.abs(n - fovt2._d()._a) <= 112 && Math.abs(n3 - fovt2._d()._c) <= 112) {
            uken uken2 = jkbf._a(fovt2, list, random, n, n2, n3, n4);
            if (uken2 != null && uken2._b > 10) {
                int n6;
                jkbf jkbf2 = new jkbf(fovt2, n5, random, uken2, n4);
                int n7 = (jkbf2._m._a + jkbf2._m._d) / 2;
                int n8 = (jkbf2._m._c + jkbf2._m._f) / 2;
                int n9 = jkbf2._m._d - jkbf2._m._a;
                int n10 = jkbf2._m._f - jkbf2._m._c;
                int n11 = n6 = n9 > n10 ? n9 : n10;
                if (fovt2._b()._a(n7, n8, n6 / 2 + 4, hvak._d)) {
                    list.add(jkbf2);
                    fovt2._l.add(jkbf2);
                    return jkbf2;
                }
            }
            return null;
        }
        return null;
    }

    public static zztd _d(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        return tybp._b(fovt2, list, random, n, n2, n3, n4, n5);
    }

    public static zztd _e(fovt fovt2, List list, Random random, int n, int n2, int n3, int n4, int n5) {
        return tybp._c(fovt2, list, random, n, n2, n3, n4, n5);
    }
}

