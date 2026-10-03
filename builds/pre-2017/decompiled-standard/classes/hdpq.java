/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.UUID;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.eifc;
import net.minecraft.util.jxtc;

public class hdpq {
    public static final hdpq[] _a = new hdpq[32];
    public static final hdpq _b = null;
    public static final hdpq _c = new hdpq(1, false, 8171462)._a("potion.moveSpeed")._a(0, 0)._a(sajz._d, "91AEAA56-376B-4498-935B-2F7F68070635", 0.2f, 2);
    public static final hdpq _d = new hdpq(2, true, 5926017)._a("potion.moveSlowdown")._a(1, 0)._a(sajz._d, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15f, 2);
    public static final hdpq _e = new hdpq(3, false, 14270531)._a("potion.digSpeed")._a(2, 0)._a(1.5);
    public static final hdpq _f = new hdpq(4, true, 4866583)._a("potion.digSlowDown")._a(3, 0);
    public static final hdpq _g = new zidk(5, false, 9643043)._a("potion.damageBoost")._a(4, 0)._a(sajz._e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 3.0, 2);
    public static final hdpq _h = new btak(6, false, 16262179)._a("potion.heal");
    public static final hdpq _i = new btak(7, true, 4393481)._a("potion.harm");
    public static final hdpq _j = new hdpq(8, false, 7889559)._a("potion.jump")._a(2, 1);
    public static final hdpq _k = new hdpq(9, true, 5578058)._a("potion.confusion")._a(3, 1)._a(0.25);
    public static final hdpq _l = new hdpq(10, false, 13458603)._a("potion.regeneration")._a(7, 0)._a(0.25);
    public static final hdpq _m = new hdpq(11, false, 10044730)._a("potion.resistance")._a(6, 1);
    public static final hdpq _n = new hdpq(12, false, 14981690)._a("potion.fireResistance")._a(7, 1);
    public static final hdpq _o = new hdpq(13, false, 3035801)._a("potion.waterBreathing")._a(0, 2);
    public static final hdpq _p = new hdpq(14, false, 8356754)._a("potion.invisibility")._a(0, 1);
    public static final hdpq _q = new hdpq(15, true, 2039587)._a("potion.blindness")._a(5, 1)._a(0.25);
    public static final hdpq _r = new hdpq(16, false, 0x1F1FA1)._a("potion.nightVision")._a(4, 1);
    public static final hdpq _s = new hdpq(17, true, 5797459)._a("potion.hunger")._a(1, 1);
    public static final hdpq _t = new zidk(18, true, 0x484D48)._a("potion.weakness")._a(5, 0)._a(sajz._e, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0, 0);
    public static final hdpq _u = new hdpq(19, true, 5149489)._a("potion.poison")._a(6, 0)._a(0.25);
    public static final hdpq _v = new hdpq(20, true, 3484199)._a("potion.wither")._a(1, 2)._a(0.25);
    public static final hdpq _w = new qojl(21, false, 16284963)._a("potion.healthBoost")._a(2, 2)._a(sajz._a, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0, 0);
    public static final hdpq _x = new hdps(22, false, 0x2552A5)._a("potion.absorption")._a(2, 2);
    public static final hdpq _y = new btak(23, false, 16262179)._a("potion.saturation");
    public static final hdpq _z = null;
    public static final hdpq _A = null;
    public static final hdpq _B = null;
    public static final hdpq _C = null;
    public static final hdpq _D = null;
    public static final hdpq _E = null;
    public static final hdpq _F = null;
    public static final hdpq _G = null;
    public final int _H;
    public final Map _I = Maps.newHashMap();
    public final boolean _J;
    public final int _K;
    public String _L = "";
    public int _M = -1;
    public double _N;
    public boolean _O;

    public hdpq(int n, boolean bl, int n2) {
        this._H = n;
        hdpq._a[n] = this;
        this._J = bl;
        this._N = bl ? 0.5 : 1.0;
        this._K = n2;
    }

    public hdpq _a(int n, int n2) {
        this._M = n + n2 * 8;
        return this;
    }

    public int _a() {
        return this._H;
    }

    public void _a(EntityLivingBase entityLivingBase, int n) {
        if (this._H == hdpq._l._H) {
            if (entityLivingBase.func_110143_aJ() < entityLivingBase.func_110138_aP()) {
                entityLivingBase.func_70691_i(1.0f);
            }
        } else if (this._H == hdpq._u._H) {
            if (entityLivingBase.func_110143_aJ() > 1.0f) {
                entityLivingBase.func_70097_a(jxtc.field_76376_m, 1.0f);
            }
        } else if (this._H == hdpq._v._H) {
            entityLivingBase.func_70097_a(jxtc.field_82727_n, 1.0f);
        } else if (this._H == hdpq._s._H && entityLivingBase instanceof EntityPlayer) {
            ((EntityPlayer)entityLivingBase).func_71020_j(0.025f * (float)(n + 1));
        } else if (this._H == hdpq._y._H && entityLivingBase instanceof EntityPlayer) {
            if (!entityLivingBase.field_70170_p.field_72995_K) {
                ((EntityPlayer)entityLivingBase).func_71024_bL()._a(n + 1, 1.0f);
            }
        } else if (this._H == hdpq._h._H && !entityLivingBase.func_70662_br() || this._H == hdpq._i._H && entityLivingBase.func_70662_br()) {
            entityLivingBase.func_70691_i(Math.max(4 << n, 0));
        } else if (this._H == hdpq._i._H && !entityLivingBase.func_70662_br() || this._H == hdpq._h._H && entityLivingBase.func_70662_br()) {
            entityLivingBase.func_70097_a(jxtc.field_76376_m, 6 << n);
        }
    }

    public void _a(EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2, int n, double d) {
        if (this._H == hdpq._h._H && !entityLivingBase2.func_70662_br() || this._H == hdpq._i._H && entityLivingBase2.func_70662_br()) {
            int n2 = (int)(d * (double)(4 << n) + 0.5);
            entityLivingBase2.func_70691_i(n2);
        } else if (this._H == hdpq._i._H && !entityLivingBase2.func_70662_br() || this._H == hdpq._h._H && entityLivingBase2.func_70662_br()) {
            int n3 = (int)(d * (double)(6 << n) + 0.5);
            if (entityLivingBase == null) {
                entityLivingBase2.func_70097_a(jxtc.field_76376_m, n3);
            } else {
                entityLivingBase2.func_70097_a(jxtc.func_76354_b(entityLivingBase2, entityLivingBase), n3);
            }
        }
    }

    public boolean _b() {
        return false;
    }

    public boolean _b(int n, int n2) {
        if (this._H == hdpq._l._H) {
            int n3 = 50 >> n2;
            if (n3 > 0) {
                return n % n3 == 0;
            }
            return true;
        }
        if (this._H == hdpq._u._H) {
            int n4 = 25 >> n2;
            if (n4 > 0) {
                return n % n4 == 0;
            }
            return true;
        }
        if (this._H == hdpq._v._H) {
            int n5 = 40 >> n2;
            if (n5 > 0) {
                return n % n5 == 0;
            }
            return true;
        }
        return this._H == hdpq._s._H;
    }

    public hdpq _a(String string) {
        this._L = string;
        return this;
    }

    public String _c() {
        return this._L;
    }

    public boolean _d() {
        return this._M >= 0;
    }

    public int _e() {
        return this._M;
    }

    public boolean _f() {
        return this._J;
    }

    public static String _a(supr supr2) {
        if (supr2._h()) {
            return "**:**";
        }
        int n = supr2._b();
        return eifc._a(n);
    }

    public hdpq _a(double d) {
        this._N = d;
        return this;
    }

    public double _g() {
        return this._N;
    }

    public boolean _h() {
        return this._O;
    }

    public int _i() {
        return this._K;
    }

    public hdpq _a(txei txei2, String string, double d, int n) {
        xson xson2 = new xson(UUID.fromString(string), this._c(), d, n);
        this._I.put(txei2, xson2);
        return this;
    }

    public Map _j() {
        return this._I;
    }

    public void _a(EntityLivingBase entityLivingBase, mbno mbno2, int n) {
        for (Map.Entry entry : this._I.entrySet()) {
            hubf hubf2 = mbno2._a((txei)entry.getKey());
            if (hubf2 == null) continue;
            hubf2._b((xson)entry.getValue());
        }
    }

    public void _b(EntityLivingBase entityLivingBase, mbno mbno2, int n) {
        for (Map.Entry entry : this._I.entrySet()) {
            hubf hubf2 = mbno2._a((txei)entry.getKey());
            if (hubf2 == null) continue;
            xson xson2 = (xson)entry.getValue();
            hubf2._b(xson2);
            hubf2._a(new xson(xson2._a(), this._c() + " " + n, this._a(n, xson2), xson2._c()));
        }
    }

    public double _a(int n, xson xson2) {
        return xson2._d() * (double)(n + 1);
    }
}

