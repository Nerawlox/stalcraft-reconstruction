/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.util.tdpx;

public class dzif {
    public static Map _a = new HashMap();
    public static List _b = new ArrayList();
    public static List _c = new ArrayList();
    public static List _d = new ArrayList();
    public static List _e = new ArrayList();
    public static rann _f = new vmzp(1000, "stat.startGame").func_75966_h().func_75971_g();
    public static rann _g = new vmzp(1001, "stat.createWorld").func_75966_h().func_75971_g();
    public static rann _h = new vmzp(1002, "stat.loadWorld").func_75966_h().func_75971_g();
    public static rann _i = new vmzp(1003, "stat.joinMultiplayer").func_75966_h().func_75971_g();
    public static rann _j = new vmzp(1004, "stat.leaveGame").func_75966_h().func_75971_g();
    public static rann _k = new vmzp(1100, "stat.playOneMinute", rann.field_75981_i).func_75966_h().func_75971_g();
    public static rann _l = new vmzp(2000, "stat.walkOneCm", rann.field_75979_j).func_75966_h().func_75971_g();
    public static rann _m = new vmzp(2001, "stat.swimOneCm", rann.field_75979_j).func_75966_h().func_75971_g();
    public static rann _n = new vmzp(2002, "stat.fallOneCm", rann.field_75979_j).func_75966_h().func_75971_g();
    public static rann _o = new vmzp(2003, "stat.climbOneCm", rann.field_75979_j).func_75966_h().func_75971_g();
    public static rann _p = new vmzp(2004, "stat.flyOneCm", rann.field_75979_j).func_75966_h().func_75971_g();
    public static rann _q = new vmzp(2005, "stat.diveOneCm", rann.field_75979_j).func_75966_h().func_75971_g();
    public static rann _r = new vmzp(2006, "stat.minecartOneCm", rann.field_75979_j).func_75966_h().func_75971_g();
    public static rann _s = new vmzp(2007, "stat.boatOneCm", rann.field_75979_j).func_75966_h().func_75971_g();
    public static rann _t = new vmzp(2008, "stat.pigOneCm", rann.field_75979_j).func_75966_h().func_75971_g();
    public static rann _u = new vmzp(2010, "stat.jump").func_75966_h().func_75971_g();
    public static rann _v = new vmzp(2011, "stat.drop").func_75966_h().func_75971_g();
    public static rann _w = new vmzp(2020, "stat.damageDealt", rann.field_111202_k).func_75971_g();
    public static rann _x = new vmzp(2021, "stat.damageTaken", rann.field_111202_k).func_75971_g();
    public static rann _y = new vmzp(2022, "stat.deaths").func_75971_g();
    public static rann _z = new vmzp(2023, "stat.mobKills").func_75971_g();
    public static rann _A = new vmzp(2024, "stat.playerKills").func_75971_g();
    public static rann _B = new vmzp(2025, "stat.fishCaught").func_75971_g();
    public static rann[] _C = dzif._a("stat.mineBlock", 0x1000000);
    public static rann[] _D;
    public static rann[] _E;
    public static rann[] _F;
    public static boolean _G;
    public static boolean _H;

    public static void _a() {
    }

    public static void _b() {
        _E = dzif._a(_E, "stat.useItem", 0x1020000, 0, 256);
        _F = dzif._b(_F, "stat.breakItem", 0x1030000, 0, 256);
        _G = true;
        dzif._d();
    }

    public static void _c() {
        _E = dzif._a(_E, "stat.useItem", 0x1020000, 256, 32000);
        _F = dzif._b(_F, "stat.breakItem", 0x1030000, 256, 32000);
        _H = true;
        dzif._d();
    }

    public static void _d() {
        if (_G && _H) {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for (lpso object : igjl._a()._b()) {
                if (object.func_77571_b() == null) continue;
                hashSet.add(object.func_77571_b()._d);
            }
            for (cvzo cvzo2 : yewu._a()._b().values()) {
                hashSet.add(cvzo2._d);
            }
            _D = new rann[32000];
            for (Integer n : hashSet) {
                if (tgdv.field_77698_e[n] == null) continue;
                String string = tdpx._a("stat.craftItem", tgdv.field_77698_e[n].func_77635_s());
                dzif._D[n.intValue()] = new huss(0x1010000 + n, string, n).func_75971_g();
            }
            dzif._a(_D);
        }
    }

    public static rann[] _a(String string, int n) {
        rann[] rannArray = new rann[twgu.field_71973_m.length];
        for (int i = 0; i < twgu.field_71973_m.length; ++i) {
            if (twgu.field_71973_m[i] == null || !twgu.field_71973_m[i].func_71876_u()) continue;
            String string2 = tdpx._a(string, twgu.field_71973_m[i].func_71931_t());
            rannArray[i] = new huss(n + i, string2, i).func_75971_g();
            _e.add((huss)rannArray[i]);
        }
        dzif._a(rannArray);
        return rannArray;
    }

    public static rann[] _a(rann[] rannArray, String string, int n, int n2, int n3) {
        if (rannArray == null) {
            rannArray = new rann[32000];
        }
        for (int i = n2; i < n3; ++i) {
            if (tgdv.field_77698_e[i] == null) continue;
            String string2 = tdpx._a(string, tgdv.field_77698_e[i].func_77635_s());
            rannArray[i] = new huss(n + i, string2, i).func_75971_g();
            if (i < 256) continue;
            _d.add((huss)rannArray[i]);
        }
        dzif._a(rannArray);
        return rannArray;
    }

    public static rann[] _b(rann[] rannArray, String string, int n, int n2, int n3) {
        if (rannArray == null) {
            rannArray = new rann[32000];
        }
        for (int i = n2; i < n3; ++i) {
            if (tgdv.field_77698_e[i] == null || !tgdv.field_77698_e[i].func_77645_m()) continue;
            String string2 = tdpx._a(string, tgdv.field_77698_e[i].func_77635_s());
            rannArray[i] = new huss(n + i, string2, i).func_75971_g();
        }
        dzif._a(rannArray);
        return rannArray;
    }

    public static void _a(rann[] rannArray) {
        dzif._a(rannArray, twgu.field_71943_B.field_71990_ca, twgu.field_71942_A.field_71990_ca);
        dzif._a(rannArray, twgu.field_71938_D.field_71990_ca, twgu.field_71938_D.field_71990_ca);
        dzif._a(rannArray, twgu.field_72008_bf.field_71990_ca, twgu.field_72061_ba.field_71990_ca);
        dzif._a(rannArray, twgu.field_72052_aC.field_71990_ca, twgu.field_72051_aB.field_71990_ca);
        dzif._a(rannArray, twgu.field_72048_aO.field_71990_ca, twgu.field_72047_aN.field_71990_ca);
        dzif._a(rannArray, twgu.field_72011_bi.field_71990_ca, twgu.field_72010_bh.field_71990_ca);
        dzif._a(rannArray, twgu.field_72035_aQ.field_71990_ca, twgu.field_72049_aP.field_71990_ca);
        dzif._a(rannArray, twgu.field_72103_ag.field_71990_ca, twgu.field_72109_af.field_71990_ca);
        dzif._a(rannArray, twgu.field_72085_aj.field_71990_ca, twgu.field_72079_ak.field_71990_ca);
        dzif._a(rannArray, twgu.field_72090_bN.field_71990_ca, twgu.field_72092_bO.field_71990_ca);
        dzif._a(rannArray, twgu.field_71980_u.field_71990_ca, twgu.field_71979_v.field_71990_ca);
        dzif._a(rannArray, twgu.field_72050_aA.field_71990_ca, twgu.field_71979_v.field_71990_ca);
    }

    public static void _a(rann[] rannArray, int n, int n2) {
        if (rannArray[n] != null && rannArray[n2] == null) {
            rannArray[n2] = rannArray[n];
        } else {
            _b.remove(rannArray[n]);
            _e.remove(rannArray[n]);
            _c.remove(rannArray[n]);
            rannArray[n] = rannArray[n2];
        }
    }

    @SideOnly(value=Side.CLIENT)
    public static rann _a(int n) {
        return (rann)_a.get(n);
    }

    static {
        sdqa._a();
    }
}

