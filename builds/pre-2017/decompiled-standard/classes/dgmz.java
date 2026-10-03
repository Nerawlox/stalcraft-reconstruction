/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.screens.GuiItem;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.eifc;
import gloomyfolken.mods.core.misc.ezfa;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.jxsn;
import gloomyfolken.mods.core.misc.tdmn;
import gloomyfolken.mods.core.misc.vjta;
import gloomyfolken.mods.stalker.misc.tupg;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.ezfc;
import net.minecraft.util.jxtc;
import net.minecraftforge.common.ISpecialArmor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class dgmz
extends lpno
implements aofo,
culm,
ezfa,
jxsn,
tdmn,
vjta,
ISpecialArmor,
oxnm,
tezq,
tfdj {
    static final String _b = "DURABILITY_FACTOR";
    public String _c = "";
    public String _d = "";
    public String _e;
    public String _f;
    public String _g;
    public int _h = 0;
    public boolean _i;
    public boolean _j;
    public xafi _k = new xafi();
    public List<String> _l = new ArrayList<String>();
    public boolean _m;
    public int _n;
    public zywl _o;
    public pjov _p = new pjov();
    public int[] _q;
    public float _r = 0.0f;
    public final boolean _s;
    private static final String _t = "upgrades";
    private static final String _u = "id";
    private static final String _v = "level";
    private static final xafi _w = new xafi();

    public dgmz(int n, String string, yery yery2, int n2, int n3) {
        super(n - 256, yery2, dgmz._a(yery2.name().toLowerCase() + dgmz._a(n2)), n2);
        this.func_77637_a(GloomyCore.tab);
        this.func_77655_b(eifc._a(string) + "_" + this.field_77779_bT);
        LanguageRegistry.addName(this, string);
        this._s = n2 == 1;
        this.func_77656_e(n3);
    }

    @Override
    public zywl func_77613_e(cvzo cvzo2) {
        return this._o == null ? tgdv.field_77747_aY.func_77613_e(cvzo2) : this._o;
    }

    @Override
    public void _a(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2) {
        if (!this._m) {
            if (this._q == null) {
                list2.add((Object)((Object)ezfc._c) + "\u0421\u043e\u0432\u043c\u0435\u0441\u0442\u0438\u043c\u043e \u0441 \u043b\u044e\u0431\u044b\u043c \u0440\u044e\u043a\u0437\u0430\u043a\u043e\u043c");
            } else if (this._q.length == 0) {
                list2.add((Object)((Object)ezfc._e) + "\u041d\u0435\u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e \u043d\u043e\u0441\u0438\u0442\u044c \u0441 \u0440\u044e\u043a\u0437\u0430\u043a\u043e\u043c");
            } else {
                list2.add((Object)((Object)ezfc._o) + "\u0421\u043e\u0432\u043c\u0435\u0441\u0442\u0438\u043c\u043e \u0441 \u043d\u0435\u043a\u043e\u0442\u043e\u0440\u044b\u043c\u0438 \u0440\u044e\u043a\u0437\u0430\u043a\u0430\u043c\u0438");
            }
            if (this._i) {
                list2.add((Object)((Object)ezfc._c) + "\u041d\u0430\u043b\u043e\u0431\u043d\u044b\u0439 \u0444\u043e\u043d\u0430\u0440\u044c");
            }
            if (this._j) {
                list2.add((Object)((Object)ezfc._c) + "\u041f\u0440\u0438\u0431\u043e\u0440 \u043d\u043e\u0447\u043d\u043e\u0433\u043e \u0432\u0438\u0434\u0435\u043d\u0438\u044f");
            }
            if (this._n != 0) {
                list2.add((Object)((Object)ezfc._c) + "\u0421\u043b\u043e\u0442\u043e\u0432 \u0434\u043b\u044f \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u043e\u0432: " + this._n);
            }
            if (cvzo2._e != null) {
                bsyv bsyv2 = cvzo2._e._n(_t);
                for (int i = 0; i < bsyv2._d(); ++i) {
                    qoac qoac2 = (qoac)bsyv2._b(i);
                    int n = qoac2._f(_u);
                    int n2 = qoac2._f(_v);
                    if (n <= 0 || n >= 32000 || !(tgdv.field_77698_e[n] instanceof bafv)) continue;
                    bafv bafv2 = (bafv)tgdv.field_77698_e[n];
                    list2.add((Object)((Object)ezfc._c) + bafv2.func_77628_j(null) + " " + n2);
                }
            }
            list2.addAll(this._g_(cvzo2)._a());
            this._a(cvzo2, list2);
        }
    }

    private void _a(cvzo cvzo2, List<String> list2) {
        float f;
        if (cvzo2._e != null && cvzo2._e._c(_b) && (double)Math.abs(f = jgro._a(cvzo2._e._h(_b))) >= 0.01) {
            list2.add(" ");
            list2.add((Object)((Object)ezfc._j) + "\u041f\u0440\u043e\u0447\u043d\u043e\u0441\u0442\u044c \u0431\u0440\u043e\u043d\u0438: " + jgro._g(f));
        }
    }

    @Override
    public void _b(cvzo cvzo2, EntityPlayer entityPlayer, List<String> list2) {
        if (this._q != null && this._q.length > 0) {
            ArrayList<String> arrayList = new ArrayList<String>(this._q.length);
            for (int i = 0; i < this._q.length; ++i) {
                tgdv tgdv2 = tgdv.field_77698_e[this._q[i]];
                if (!(tgdv2 instanceof brhe)) continue;
                arrayList.add(tgdv2.func_77628_j(null));
            }
            list2.add("\u0421\u043e\u0432\u043c\u0435\u0441\u0442\u0438\u043c\u044b\u0435 \u0440\u044e\u043a\u0437\u0430\u043a\u0438: " + StringUtils.join(arrayList, ", ") + ".");
        }
        list2.addAll(this._l);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean func_77623_v() {
        return false;
    }

    @Override
    public boolean func_82816_b_(cvzo cvzo2) {
        return false;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public String getArmorTexture(cvzo cvzo2, Entity entity, int n, int n2) {
        return "stalker:textures/armor/empty.png";
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void func_94581_a(nege nege2) {
        this.field_77791_bV = nege2._b("stalker:" + this._c);
    }

    public static String _a(int n) {
        if (n == 0) {
            return "_helm";
        }
        if (n == 1) {
            return "_chest";
        }
        if (n == 2) {
            return "_legs";
        }
        if (n == 3) {
            return "_boots";
        }
        return "";
    }

    public static int _a(String string) {
        if (GloomyCore.side == Side.CLIENT) {
            return ModLoader.addArmor(string);
        }
        return 1;
    }

    @Override
    public int getEntityLifespan(cvzo cvzo2, ozlu ozlu2) {
        return 288000;
    }

    @Override
    public boolean _j(cvzo cvzo2) {
        return this._i;
    }

    @Override
    public boolean _b() {
        return false;
    }

    @Override
    public cvzo func_77659_a(cvzo cvzo2, ozlu ozlu2, EntityPlayer entityPlayer) {
        if (this.field_77881_a == 1 && !this._k(tupg._a((EntityPlayer)entityPlayer)._c._e())) {
            return cvzo2;
        }
        return super.func_77659_a(cvzo2, ozlu2, entityPlayer);
    }

    public boolean _k(cvzo cvzo2) {
        return this._q == null || cvzo2 == null || ArrayUtils.contains(this._q, cvzo2._d);
    }

    @Override
    public xafi _g_(cvzo cvzo2) {
        if (cvzo2._f() && cvzo2._j() >= cvzo2._k()) {
            return _w;
        }
        if (cvzo2._e == null && !this.func_77645_m()) {
            return this._k;
        }
        xafi xafi2 = this._k._c();
        qoac qoac2 = ncwh._c(cvzo2);
        if (qoac2._c(_t)) {
            bsyv bsyv2 = qoac2._n(_t);
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac3 = (qoac)bsyv2._b(i);
                int n = qoac3._f(_u);
                int n2 = qoac3._f(_v);
                if (n <= 0 || n >= 32000 || !(tgdv.field_77698_e[n] instanceof bafv)) continue;
                bafv bafv2 = (bafv)tgdv.field_77698_e[n];
                bafv2._b._a(xafi2, n2);
            }
        }
        xafi2._f(this._c_(cvzo2));
        return xafi2;
    }

    public static int _a(cvzo cvzo2, bafv bafv2) {
        if (cvzo2._e == null) {
            return 0;
        }
        qoac qoac2 = ncwh._c(cvzo2);
        bsyv bsyv2 = qoac2._n(_t);
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            int n = qoac3._f(_u);
            if (n != bafv2.field_77779_bT) continue;
            return qoac3._f(_v);
        }
        return 0;
    }

    public static void _a(cvzo cvzo2, bafv bafv2, int n) {
        qoac qoac2 = ncwh._b(cvzo2);
        if (!qoac2._c(_t)) {
            qoac2._a(_t, new bsyv());
        }
        bsyv bsyv2 = qoac2._n(_t);
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            int n2 = qoac3._f(_u);
            if (n2 != bafv2.field_77779_bT) continue;
            if (n > 0) {
                qoac3._a(_v, n);
            } else {
                bsyv2._a(i);
            }
            return;
        }
        if (n > 0) {
            qoac qoac4 = new qoac();
            qoac4._a(_u, bafv2.field_77779_bT);
            qoac4._a(_v, n);
            bsyv2._a(qoac4);
        }
    }

    @Override
    public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase entityLivingBase, cvzo cvzo2, jxtc jxtc2, double d, int n) {
        return new ISpecialArmor.ArmorProperties(0, 0.0, 0);
    }

    @Override
    public int getArmorDisplay(EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        return 0;
    }

    @Override
    public pjov _i(cvzo cvzo2) {
        return this._p;
    }

    @Override
    public void damageArmor(EntityLivingBase entityLivingBase, cvzo cvzo2, jxtc jxtc2, int n, int n2) {
    }

    @Override
    public int getDamage(cvzo cvzo2) {
        return (int)this._h(cvzo2);
    }

    @Override
    public int getMaxDamage(cvzo cvzo2) {
        if (cvzo2._e != null && cvzo2._e._o("unbreakable")) {
            return 0;
        }
        float f = super.getMaxDamage(cvzo2);
        if (cvzo2._e != null && cvzo2._q()._c(_b)) {
            f *= cvzo2._e._h(_b);
        }
        return (int)(f *= this._e_(cvzo2));
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

    @Override
    public int _h_(cvzo cvzo2) {
        return this._h;
    }

    @Override
    public String _a() {
        return "stalker:disassembly_armor";
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean _l_(cvzo cvzo2) {
        return this._s;
    }

    @ezey(_a={eidj.CLIENT})
    public GuiItem _b(gqjz gqjz2, EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        return n < 0 ? new gpqn(gqjz2, cvzo2) : new ievb(gqjz2, entityPlayer, n);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ gqjz _a(gqjz gqjz2, EntityPlayer entityPlayer, cvzo cvzo2, int n) {
        return this._b(gqjz2, entityPlayer, cvzo2, n);
    }
}

