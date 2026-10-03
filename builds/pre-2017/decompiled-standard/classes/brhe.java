/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjwj;
import gloomyfolken.mods.core.misc.tdmn;
import gloomyfolken.mods.core.misc.vjta;
import gloomyfolken.mods.core.misc.xpzm;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;
import net.minecraft.util.jxtc;

public class brhe
extends kjwj
implements aofo,
culm,
ezfa,
tdmn,
vjta,
xpzm<cdit, Integer>,
oxnm,
tezq {
    public final xafi _b;
    public final pjov _c;
    public final int _d;
    public final float _e;
    public final String _f;
    public final String _g;
    public int _h;

    public brhe(int n, String string, String string2, List<String> list2, int n2, int n3, int n4, float f, xafi xafi2, pjov pjov2, String string3, String string4) {
        super(n, string, "stalker:" + string2, list2, n2);
        this._d = n3;
        this._e = f;
        this._b = xafi2;
        this._c = pjov2;
        this._f = string3;
        this._g = string4;
        this.func_77656_e(n4);
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2) {
        if (this._d > 0) {
            double d = this._j(cvzo2);
            double d2 = this._h(cvzo2);
            if (d2 > 0.0 && d > 0.0) {
                double d3 = ((double)this.getMaxDamage(cvzo2) - d2) / d;
                long l = (long)(d3 * 60.0 * 1000.0);
                this._c(list2, "\u0418\u0437\u043d\u043e\u0441\u0438\u0442\u0441\u044f \u0447\u0435\u0440\u0435\u0437: " + andg._a(l));
            }
            jgro._a(list2, "\u0412\u043d\u0443\u0442\u0440\u0435\u043d\u043d\u044f\u044f \u0437\u0430\u0449\u0438\u0442\u0430", -jgro._a(this._k(cvzo2)));
            List<cvzo> list3 = this._k_(cvzo2);
            if (list3.size() == 0) {
                this._c(list2, "\u0410\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u044b: " + list3.size() + "/" + this._d);
            } else {
                this._c(list2, "\u0410\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u044b (" + list3.size() + "/" + this._d + "):");
                for (int i = 0; i < list3.size(); ++i) {
                    cvzo cvzo3 = list3.get(i);
                    cdit cdit2 = (cdit)cvzo3._a();
                    float f = cdit2._e(cvzo3);
                    this._c(list2, i + 1 + ". " + cvzo3._s() + (Object)((Object)(f > 1.0f ? ezfc._c : ezfc._e)) + " (" + jgro._i(f) + ")");
                }
            }
            list2.add("");
        }
        list2.addAll(this._g_(cvzo2)._a());
    }

    @Override
    public int getMaxDamage(cvzo cvzo2) {
        if (cvzo2._e != null && cvzo2._e._o("unbreakable")) {
            return 0;
        }
        float f = this.func_77612_l();
        return (int)(f *= this._e_(cvzo2));
    }

    @Override
    public int getDamage(cvzo cvzo2) {
        return (int)this._h(cvzo2);
    }

    @Override
    public void setDamage(cvzo cvzo2, int n) {
        this._a(cvzo2, (double)n);
    }

    @Override
    public int getDisplayDamage(cvzo cvzo2) {
        return this.getDamage(cvzo2);
    }

    @Override
    public boolean isDamaged(cvzo cvzo2) {
        return this.getDamage(cvzo2) > 0;
    }

    public void _a(cvzo cvzo2, jxtc jxtc2, float f) {
        xafi xafi2 = this._l(cvzo2);
        float f2 = xafi2._a(jxtc2);
        float f3 = f / (1.0f - f2);
        float f4 = f3 - f;
        if (f4 > 0.0f) {
            this._a(cvzo2, this._h(cvzo2) + (double)f4);
        }
    }

    public void _c(cvzo cvzo2, double d) {
        double d2 = this._j(cvzo2) * d;
        if (d2 > 0.0) {
            this._b(cvzo2, d2);
        }
    }

    public double _j(cvzo cvzo2) {
        double d = 0.0;
        Iterator<qoac> iterator2 = this._d(cvzo2);
        while (iterator2.hasNext()) {
            qoac qoac2 = iterator2.next();
            short s = qoac2._e("id");
            tgdv tgdv2 = tgdv.field_77698_e[s];
            if (!(tgdv2 instanceof cdit)) continue;
            d += (double)((cdit)tgdv2)._c;
        }
        return d;
    }

    @Override
    public xafi _g_(cvzo cvzo2) {
        xafi xafi2 = new xafi();
        if (this._c_(cvzo2) > 0.0f) {
            List<cvzo> list2 = this._k_(cvzo2);
            for (cvzo cvzo3 : list2) {
                cdit cdit2 = (cdit)cvzo3._a();
                cdit2._g_(cvzo3)._a(xafi2);
            }
        }
        float f = this._k(cvzo2);
        xafi2._h = this._a(xafi2._h, f);
        xafi2._i = this._a(xafi2._i, f);
        xafi2._j = this._a(xafi2._j, f);
        xafi2._k = this._a(xafi2._k, f);
        this._l(cvzo2)._a(xafi2);
        return xafi2;
    }

    private float _a(float f, float f2) {
        return f > 0.0f ? f * f2 : f;
    }

    public float _k(cvzo cvzo2) {
        return 1.0f - (1.0f - this._e) * this._c_(cvzo2);
    }

    @Override
    public pjov _i(cvzo cvzo2) {
        return this._c;
    }

    public xafi _l(cvzo cvzo2) {
        return this._b._e(this._c_(cvzo2));
    }

    public cdit _c(tgdv tgdv2) {
        return (cdit)tgdv2;
    }

    public static void _a(EntityPlayer entityPlayer, int n, int n2, int n3) {
        Object object;
        cvzo cvzo2 = entityPlayer.field_71070_bA.func_75139_a(n).func_75211_c();
        cvzo cvzo3 = n2 < 0 ? null : entityPlayer.field_71071_by.func_70301_a(n2);
        brhe brhe2 = (brhe)cvzo2._a();
        if (cvzo3 != null) {
            if (!(cvzo3._a() instanceof cdit)) {
                return;
            }
            object = (cdit)cvzo3._a();
            if (!object._a(cvzo3)) {
                return;
            }
        }
        if (n3 < 0 || n3 >= brhe2._d) {
            return;
        }
        object = brhe2._c(cvzo2, Integer.valueOf(n3));
        brhe2._a(cvzo2, cvzo3, Integer.valueOf(n3));
        InvokeSideOnly.frontend(!entityPlayer.field_70170_p.field_72995_K, () -> brhe._a(cvzo3, entityPlayer, n2, (cvzo)object));
    }

    @Override
    public boolean _a_(cvzo cvzo2) {
        return false;
    }

    @ezey(_a={eidj.CLIENT})
    public GuiItem _b(gqjz gqjz2, EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        return n < 0 ? null : new fmns(gqjz2, entityPlayer, n);
    }

    @Override
    public int _h_(cvzo cvzo2) {
        return this._h;
    }

    @Override
    public /* synthetic */ tgdv _b(tgdv tgdv2) {
        return this._c(tgdv2);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ gqjz _a(gqjz gqjz2, EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        return this._b(gqjz2, entityPlayer, cvzo2, n);
    }

    private static /* synthetic */ void _a(cvzo cvzo2, EntityPlayer entityPlayer, int n, cvzo cvzo3) {
    }
}

