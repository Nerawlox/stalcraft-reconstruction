/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.iurq;
import net.minecraft.util.jxtc;

public class zhty {
    public static final Random _a = new Random();
    public static final xspi _b = new xspi(null);
    public static final pkxv _c = new pkxv(null);

    public static int _a(int n, cvzo cvzo2) {
        if (cvzo2 == null) {
            return 0;
        }
        bsyv bsyv2 = cvzo2._r();
        if (bsyv2 == null) {
            return 0;
        }
        for (int i = 0; i < bsyv2._d(); ++i) {
            short s = ((qoac)bsyv2._b(i))._e("id");
            short s2 = ((qoac)bsyv2._b(i))._e("lvl");
            if (s != n) continue;
            return s2;
        }
        return 0;
    }

    public static Map _a(cvzo cvzo2) {
        bsyv bsyv2;
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        bsyv bsyv3 = bsyv2 = cvzo2._d == tgdv.field_92105_bW.field_77779_bT ? tgdv.field_92105_bW._a(cvzo2) : cvzo2._r();
        if (bsyv2 != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                short s = ((qoac)bsyv2._b(i))._e("id");
                short s2 = ((qoac)bsyv2._b(i))._e("lvl");
                linkedHashMap.put(Integer.valueOf(s), Integer.valueOf(s2));
            }
        }
        return linkedHashMap;
    }

    public static void _a(Map map, cvzo cvzo2) {
        bsyv bsyv2 = new bsyv();
        Iterator iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            qoac qoac2 = new qoac();
            qoac2._a("id", (short)n);
            qoac2._a("lvl", (short)((Integer)map.get(n)).intValue());
            bsyv2._a(qoac2);
            if (cvzo2._d != tgdv.field_92105_bW.field_77779_bT) continue;
            tgdv.field_92105_bW._a(cvzo2, new ixcc(n, (int)((Integer)map.get(n))));
        }
        if (bsyv2._d() > 0) {
            if (cvzo2._d != tgdv.field_92105_bW.field_77779_bT) {
                cvzo2._a("ench", bsyv2);
            }
        } else if (cvzo2._p()) {
            cvzo2._q()._p("ench");
        }
    }

    public static int _a(int n, cvzo[] cvzoArray) {
        if (cvzoArray == null) {
            return 0;
        }
        int n2 = 0;
        cvzo[] cvzoArray2 = cvzoArray;
        int n3 = cvzoArray.length;
        for (int i = 0; i < n3; ++i) {
            cvzo cvzo2 = cvzoArray2[i];
            int n4 = zhty._a(n, cvzo2);
            if (n4 <= n2) continue;
            n2 = n4;
        }
        return n2;
    }

    public static void _a(dywt dywt2, cvzo cvzo2) {
        bsyv bsyv2;
        if (cvzo2 != null && (bsyv2 = cvzo2._r()) != null) {
            for (int i = 0; i < bsyv2._d(); ++i) {
                short s = ((qoac)bsyv2._b(i))._e("id");
                short s2 = ((qoac)bsyv2._b(i))._e("lvl");
                if (zhqo._a[s] == null) continue;
                dywt2._a(zhqo._a[s], s2);
            }
        }
    }

    public static void _a(dywt dywt2, cvzo[] cvzoArray) {
        cvzo[] cvzoArray2 = cvzoArray;
        int n = cvzoArray.length;
        for (int i = 0; i < n; ++i) {
            cvzo cvzo2 = cvzoArray2[i];
            zhty._a(dywt2, cvzo2);
        }
    }

    public static int _a(cvzo[] cvzoArray, jxtc jxtc2) {
        zhty._b._a = 0;
        zhty._b._b = jxtc2;
        zhty._a((dywt)_b, cvzoArray);
        if (zhty._b._a > 25) {
            zhty._b._a = 25;
        }
        int n = (zhty._b._a + 1 >> 1) + _a.nextInt((zhty._b._a >> 1) + 1);
        GloomyHooks.getEnchantmentModifierDamage(null, cvzoArray, jxtc2);
        return n;
    }

    public static float _a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        zhty._c._a = 0.0f;
        zhty._c._b = entityLivingBase2;
        zhty._a((dywt)_c, entityLivingBase.func_70694_bm());
        float f = zhty._c._a;
        GloomyHooks.getEnchantmentModifierLiving(null, entityLivingBase, entityLivingBase2);
        return f;
    }

    public static int _b(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2) {
        return zhty._a(zhqo._n._y, entityLivingBase.func_70694_bm());
    }

    public static int _a(EntityLivingBase entityLivingBase) {
        return zhty._a(zhqo._o._y, entityLivingBase.func_70694_bm());
    }

    public static int _b(EntityLivingBase entityLivingBase) {
        return zhty._a(zhqo._h._y, entityLivingBase.func_70035_c());
    }

    public static int _c(EntityLivingBase entityLivingBase) {
        return zhty._a(zhqo._q._y, entityLivingBase.func_70694_bm());
    }

    public static boolean _d(EntityLivingBase entityLivingBase) {
        return zhty._a(zhqo._r._y, entityLivingBase.func_70694_bm()) > 0;
    }

    public static int _e(EntityLivingBase entityLivingBase) {
        return zhty._a(zhqo._t._y, entityLivingBase.func_70694_bm());
    }

    public static int _f(EntityLivingBase entityLivingBase) {
        return zhty._a(zhqo._p._y, entityLivingBase.func_70694_bm());
    }

    public static boolean _g(EntityLivingBase entityLivingBase) {
        return zhty._a(zhqo._i._y, entityLivingBase.func_70035_c()) > 0;
    }

    public static int _h(EntityLivingBase entityLivingBase) {
        return zhty._a(zhqo._j._y, entityLivingBase.func_70035_c());
    }

    public static cvzo _a(zhqo zhqo2, EntityLivingBase entityLivingBase) {
        for (cvzo cvzo2 : entityLivingBase.func_70035_c()) {
            if (cvzo2 == null || zhty._a(zhqo2._y, cvzo2) <= 0) continue;
            return cvzo2;
        }
        return null;
    }

    public static int _a(Random random, int n, int n2, cvzo cvzo2) {
        tgdv tgdv2 = cvzo2._a();
        int n3 = tgdv2.func_77619_b();
        if (n3 <= 0) {
            return 0;
        }
        if (n2 > 15) {
            n2 = 15;
        }
        int n4 = random.nextInt(8) + 1 + (n2 >> 1) + random.nextInt(n2 + 1);
        return n == 0 ? Math.max(n4 / 3, 1) : (n == 1 ? n4 * 2 / 3 + 1 : Math.max(n4, n2 * 2));
    }

    public static cvzo _a(Random random, cvzo cvzo2, int n) {
        boolean bl;
        List list = zhty._b(random, cvzo2, n);
        boolean bl2 = bl = cvzo2._d == tgdv.field_77760_aL.field_77779_bT;
        if (bl) {
            cvzo2._d = tgdv.field_92105_bW.field_77779_bT;
        }
        if (list != null) {
            for (ixcc ixcc2 : list) {
                if (bl) {
                    tgdv.field_92105_bW._a(cvzo2, ixcc2);
                    continue;
                }
                cvzo2._a(ixcc2._a, ixcc2._b);
            }
        }
        return cvzo2;
    }

    public static List _b(Random random, cvzo cvzo2, int n) {
        ixcc ixcc2;
        float f;
        tgdv tgdv2 = cvzo2._a();
        int n2 = tgdv2.func_77619_b();
        if (n2 <= 0) {
            return null;
        }
        n2 /= 2;
        int n3 = (n2 = 1 + random.nextInt((n2 >> 1) + 1) + random.nextInt((n2 >> 1) + 1)) + n;
        int n4 = (int)((float)n3 * (1.0f + (f = (random.nextFloat() + random.nextFloat() - 1.0f) * 0.15f)) + 0.5f);
        if (n4 < 1) {
            n4 = 1;
        }
        ArrayList<Object> arrayList = null;
        Map map = zhty._b(n4, cvzo2);
        if (map != null && !map.isEmpty() && (ixcc2 = (ixcc)iurq._a(random, map.values())) != null) {
            arrayList = new ArrayList<Object>();
            arrayList.add(ixcc2);
            for (int i = n4; random.nextInt(50) <= i; i >>= 1) {
                Object object;
                Iterator iterator2 = map.keySet().iterator();
                while (iterator2.hasNext()) {
                    object = (Integer)iterator2.next();
                    boolean bl = true;
                    for (ixcc ixcc3 : arrayList) {
                        if (ixcc3._a._a(zhqo._a[(Integer)object])) continue;
                        bl = false;
                        break;
                    }
                    if (bl) continue;
                    iterator2.remove();
                }
                if (map.isEmpty()) continue;
                object = (ixcc)iurq._a(random, map.values());
                arrayList.add(object);
            }
        }
        return arrayList;
    }

    public static Map _b(int n, cvzo cvzo2) {
        tgdv tgdv2 = cvzo2._a();
        HashMap<Integer, ixcc> hashMap = null;
        boolean bl = cvzo2._d == tgdv.field_77760_aL.field_77779_bT;
        for (zhqo zhqo2 : zhqo._a) {
            if (zhqo2 == null) continue;
            boolean bl2 = bl = cvzo2._d == tgdv.field_77760_aL.field_77779_bT && zhqo2._e();
            if (!zhqo2._b(cvzo2) && !bl) continue;
            for (int i = zhqo2._b(); i <= zhqo2._c(); ++i) {
                if (n < zhqo2._a(i) || n > zhqo2._b(i)) continue;
                if (hashMap == null) {
                    hashMap = new HashMap<Integer, ixcc>();
                }
                hashMap.put(zhqo2._y, new ixcc(zhqo2, i));
            }
        }
        return hashMap;
    }
}

