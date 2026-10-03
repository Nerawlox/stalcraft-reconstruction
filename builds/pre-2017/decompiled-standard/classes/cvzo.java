/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.util.dwan;
import net.minecraft.util.ezfc;
import net.minecraft.util.tdpx;
import net.minecraftforge.event.ForgeEventFactory;

public final class cvzo {
    public static final DecimalFormat _a = new DecimalFormat("#.###");
    public int _b;
    public int _c;
    public int _d;
    public qoac _e;
    public int _f;
    public EntityItemFrame _g;

    public cvzo(twgu twgu2) {
        this(twgu2, 1);
    }

    public cvzo(twgu twgu2, int n) {
        this(twgu2.field_71990_ca, n, 0);
    }

    public cvzo(twgu twgu2, int n, int n2) {
        this(twgu2.field_71990_ca, n, n2);
    }

    public cvzo(tgdv tgdv2) {
        this(tgdv2.field_77779_bT, 1, 0);
    }

    public cvzo(tgdv tgdv2, int n) {
        this(tgdv2.field_77779_bT, n, 0);
    }

    public cvzo(tgdv tgdv2, int n, int n2) {
        this(tgdv2.field_77779_bT, n, n2);
    }

    public cvzo(int n, int n2, int n3) {
        this._d = n;
        this._b = n2;
        this._f = n3;
        if (this._f < 0) {
            this._f = 0;
        }
    }

    public static cvzo _a(qoac qoac2) {
        cvzo cvzo2 = new cvzo();
        cvzo2._c(qoac2);
        return cvzo2._a() != null ? cvzo2 : null;
    }

    public cvzo() {
    }

    public cvzo _a(int n) {
        cvzo cvzo2 = new cvzo(this._d, n, this._f);
        if (this._e != null) {
            cvzo2._e = (qoac)this._e._c();
        }
        this._b -= n;
        return cvzo2;
    }

    public tgdv _a() {
        return tgdv.field_77698_e[this._d];
    }

    @SideOnly(value=Side.CLIENT)
    public dwan _b() {
        return this._a().func_77650_f(this);
    }

    @SideOnly(value=Side.CLIENT)
    public int _c() {
        return this._a().func_94901_k();
    }

    public boolean _a(EntityPlayer entityPlayer, ozlu ozlu2, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        boolean bl = this._a().func_77648_a(this, entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3);
        if (bl) {
            entityPlayer.func_71064_a(dzif._E[this._d], 1);
        }
        return bl;
    }

    public float _a(twgu twgu2) {
        return this._a().func_77638_a(this, twgu2);
    }

    public cvzo _a(ozlu ozlu2, EntityPlayer entityPlayer) {
        return this._a().func_77659_a(this, ozlu2, entityPlayer);
    }

    public cvzo _b(ozlu ozlu2, EntityPlayer entityPlayer) {
        return this._a().func_77654_b(this, ozlu2, entityPlayer);
    }

    public qoac _b(qoac qoac2) {
        qoac2._a("id", (short)this._d);
        qoac2._a("Count", (byte)this._b);
        qoac2._a("Damage", (short)this._f);
        if (this._e != null) {
            qoac2._a("tag", (huhy)this._e);
        }
        owtc._a(this, qoac2);
        return qoac2;
    }

    public void _c(qoac qoac2) {
        this._d = qoac2._e("id");
        this._b = qoac2._d("Count");
        this._f = qoac2._e("Damage");
        if (this._f < 0) {
            this._f = 0;
        }
        if (qoac2._c("tag")) {
            this._e = qoac2._m("tag");
        }
        owtc._b(this, qoac2);
    }

    public int _d() {
        return this._a().getItemStackLimit(this);
    }

    public boolean _e() {
        return this._d() > 1 && (!this._f() || !this._h());
    }

    public boolean _f() {
        return tgdv.field_77698_e[this._d].getMaxDamage(this) > 0;
    }

    public boolean _g() {
        return tgdv.field_77698_e[this._d].func_77614_k();
    }

    public boolean _h() {
        boolean bl;
        boolean bl2 = bl = this._f > 0;
        if (this._a() != null) {
            bl = this._a().isDamaged(this);
        }
        return this._f() && bl;
    }

    public int _i() {
        if (this._a() != null) {
            return this._a().getDisplayDamage(this);
        }
        return this._f;
    }

    public int _j() {
        if (this._a() != null) {
            return this._a().getDamage(this);
        }
        return this._f;
    }

    public void _b(int n) {
        if (this._a() != null) {
            this._a().setDamage(this, n);
            return;
        }
        this._f = n;
        if (this._f < 0) {
            this._f = 0;
        }
    }

    public int _k() {
        return this._a().getMaxDamage(this);
    }

    public boolean _a(int n, Random random) {
        if (!this._f()) {
            return false;
        }
        if (n > 0) {
            int n2 = zhty._a(zhqo._s._y, this);
            int n3 = 0;
            for (int i = 0; n2 > 0 && i < n; ++i) {
                if (!zhua._a(this, n2, random)) continue;
                ++n3;
            }
            if ((n -= n3) <= 0) {
                return false;
            }
        }
        this._b(this._j() + n);
        return this._j() > this._k();
    }

    public void _a(int n, EntityLivingBase entityLivingBase) {
        if ((!(entityLivingBase instanceof EntityPlayer) || !((EntityPlayer)entityLivingBase).field_71075_bZ._d) && this._f() && this._a(n, entityLivingBase.func_70681_au())) {
            entityLivingBase.func_70669_a(this);
            --this._b;
            if (entityLivingBase instanceof EntityPlayer) {
                EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
                entityPlayer.func_71064_a(dzif._F[this._d], 1);
                if (this._b == 0 && this._a() instanceof txfj) {
                    entityPlayer.func_71028_bD();
                }
            }
            if (this._b < 0) {
                this._b = 0;
            }
            this._f = 0;
        }
    }

    public void _a(EntityLivingBase entityLivingBase, EntityPlayer entityPlayer) {
        boolean bl = tgdv.field_77698_e[this._d].func_77644_a(this, entityLivingBase, entityPlayer);
        if (bl) {
            entityPlayer.func_71064_a(dzif._E[this._d], 1);
        }
    }

    public void _a(ozlu ozlu2, int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        boolean bl = tgdv.field_77698_e[this._d].func_77660_a(this, ozlu2, n, n2, n3, n4, entityPlayer);
        if (bl) {
            entityPlayer.func_71064_a(dzif._E[this._d], 1);
        }
    }

    public boolean _b(twgu twgu2) {
        return tgdv.field_77698_e[this._d].canHarvestBlock(twgu2, this);
    }

    public boolean _a(EntityPlayer entityPlayer, EntityLivingBase entityLivingBase) {
        return tgdv.field_77698_e[this._d].func_111207_a(this, entityPlayer, entityLivingBase);
    }

    public cvzo _l() {
        cvzo cvzo2 = new cvzo(this._d, this._b, this._f);
        if (this._e != null) {
            cvzo2._e = (qoac)this._e._c();
        }
        return cvzo2;
    }

    public static boolean _a(cvzo cvzo2, cvzo cvzo3) {
        return cvzo2 == null && cvzo3 == null ? true : (cvzo2 != null && cvzo3 != null ? (cvzo2._e == null && cvzo3._e != null ? false : cvzo2._e == null || cvzo2._e.equals(cvzo3._e)) : false);
    }

    public static boolean _b(cvzo cvzo2, cvzo cvzo3) {
        return cvzo2 == null && cvzo3 == null ? true : (cvzo2 != null && cvzo3 != null ? cvzo2._a(cvzo3) : false);
    }

    public boolean _a(cvzo cvzo2) {
        return this._b != cvzo2._b ? false : (this._d != cvzo2._d ? false : (this._f != cvzo2._f ? false : (this._e == null && cvzo2._e != null ? false : this._e == null || this._e.equals(cvzo2._e))));
    }

    public boolean _b(cvzo cvzo2) {
        return this._d == cvzo2._d && this._f == cvzo2._f;
    }

    public String _m() {
        return tgdv.field_77698_e[this._d].func_77667_c(this);
    }

    public static cvzo _c(cvzo cvzo2) {
        return cvzo2 == null ? null : cvzo2._l();
    }

    public String toString() {
        return this._b + "x" + tgdv.field_77698_e[this._d].func_77658_a() + "@" + this._f;
    }

    public void _a(ozlu ozlu2, Entity entity, int n, boolean bl) {
        if (this._c > 0) {
            --this._c;
        }
        tgdv.field_77698_e[this._d].func_77663_a(this, ozlu2, entity, n, bl);
    }

    public void _a(ozlu ozlu2, EntityPlayer entityPlayer, int n) {
        entityPlayer.func_71064_a(dzif._D[this._d], n);
        tgdv.field_77698_e[this._d].func_77622_d(this, ozlu2, entityPlayer);
    }

    public int _n() {
        return this._a().func_77626_a(this);
    }

    public bsre _o() {
        return this._a().func_77661_b(this);
    }

    public void _b(ozlu ozlu2, EntityPlayer entityPlayer, int n) {
        this._a().func_77615_a(this, ozlu2, entityPlayer, n);
    }

    public boolean _p() {
        return this._e != null;
    }

    public qoac _q() {
        return this._e;
    }

    public bsyv _r() {
        return this._e == null ? null : (bsyv)this._e._b("ench");
    }

    public void _d(qoac qoac2) {
        this._e = qoac2;
    }

    public String _s() {
        qoac qoac2;
        String string = this._a().func_77628_j(this);
        if (this._e != null && this._e._c("display") && (qoac2 = this._e._m("display"))._c("Name")) {
            string = qoac2._j("Name");
        }
        String string2 = string;
        String string3 = GloomyHooks.getDisplayName(this, string2);
        return string3;
    }

    public void _a(String string) {
        if (this._e == null) {
            this._e = new qoac("tag");
        }
        if (!this._e._c("display")) {
            this._e._a("display", new qoac());
        }
        this._e._m("display")._a("Name", string);
    }

    public void _t() {
        if (this._e != null && this._e._c("display")) {
            qoac qoac2 = this._e._m("display");
            qoac2._p("Name");
            if (qoac2._e()) {
                this._e._p("display");
                if (this._e._e()) {
                    this._d(null);
                }
            }
        }
    }

    public boolean _u() {
        return this._e == null ? false : (!this._e._c("display") ? false : this._e._m("display")._c("Name"));
    }

    @SideOnly(value=Side.CLIENT)
    public List _a(EntityPlayer entityPlayer, boolean bl) {
        Object object;
        ArrayList<String> arrayList = new ArrayList<String>();
        tgdv tgdv2 = tgdv.field_77698_e[this._d];
        String string = this._s();
        if (this._u()) {
            string = (Object)((Object)ezfc._u) + string + (Object)((Object)ezfc._v);
        }
        if (bl) {
            object = "";
            if (string.length() > 0) {
                string = string + " (";
                object = ")";
            }
            string = this._g() ? string + String.format("#%04d/%d%s", this._d, this._f, object) : string + String.format("#%04d%s", this._d, object);
        } else if (!this._u() && this._d == tgdv.field_77744_bd.field_77779_bT) {
            string = string + " #" + this._f;
        }
        arrayList.add(string);
        tgdv2.func_77624_a(this, entityPlayer, arrayList, bl);
        if (this._p()) {
            int n;
            object = this._r();
            if (object != null) {
                for (int i = 0; i < ((bsyv)object)._d(); ++i) {
                    short s = ((qoac)((bsyv)object)._b(i))._e("id");
                    n = ((qoac)((bsyv)object)._b(i))._e("lvl");
                    if (zhqo._a[s] == null) continue;
                    arrayList.add(zhqo._a[s]._c(n));
                }
            }
            if (this._e._c("display")) {
                bsyv bsyv2;
                qoac qoac2 = this._e._m("display");
                if (qoac2._c("color")) {
                    if (bl) {
                        arrayList.add("Color: #" + Integer.toHexString(qoac2._f("color")).toUpperCase());
                    } else {
                        arrayList.add((Object)((Object)ezfc._u) + tdpx._a("item.dyed"));
                    }
                }
                if (qoac2._c("Lore") && (bsyv2 = qoac2._n("Lore"))._d() > 0) {
                    for (n = 0; n < bsyv2._d(); ++n) {
                        arrayList.add((Object)((Object)ezfc._f) + "" + (Object)((Object)ezfc._u) + ((xsxy)bsyv2._b((int)n))._c);
                    }
                }
            }
        }
        if (!(object = this._D()).isEmpty()) {
            arrayList.add("");
            for (Map.Entry entry : object.entries()) {
                xson xson2 = (xson)entry.getValue();
                double d = xson2._d();
                double d2 = xson2._c() != 1 && xson2._c() != 2 ? xson2._d() : xson2._d() * 100.0;
                if (d > 0.0) {
                    arrayList.add((Object)((Object)ezfc._j) + tdpx._a("attribute.modifier.plus." + xson2._c(), _a.format(d2), tdpx._a("attribute.name." + (String)entry.getKey())));
                    continue;
                }
                if (!(d < 0.0)) continue;
                arrayList.add((Object)((Object)ezfc._m) + tdpx._a("attribute.modifier.take." + xson2._c(), _a.format(d2 *= -1.0), tdpx._a("attribute.name." + (String)entry.getKey())));
            }
        }
        if (bl && this._h()) {
            arrayList.add("Durability: " + (this._k() - this._i()) + " / " + this._k());
        }
        ForgeEventFactory.onItemTooltip(this, entityPlayer, arrayList, bl);
        return arrayList;
    }

    @Deprecated
    @SideOnly(value=Side.CLIENT)
    public boolean _v() {
        return this._c(0);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean _c(int n) {
        return this._a().hasEffect(this, n);
    }

    @SideOnly(value=Side.CLIENT)
    public zywl _w() {
        return this._a().func_77613_e(this);
    }

    public boolean _x() {
        return !this._a().func_77616_k(this) ? false : !this._y();
    }

    public void _a(zhqo zhqo2, int n) {
        if (this._e == null) {
            this._d(new qoac());
        }
        if (!this._e._c("ench")) {
            this._e._a("ench", new bsyv("ench"));
        }
        bsyv bsyv2 = (bsyv)this._e._b("ench");
        qoac qoac2 = new qoac();
        qoac2._a("id", (short)zhqo2._y);
        qoac2._a("lvl", (short)((byte)n));
        bsyv2._a(qoac2);
    }

    public boolean _y() {
        return this._e != null && this._e._c("ench");
    }

    public void _a(String string, huhy huhy2) {
        if (this._e == null) {
            this._d(new qoac());
        }
        this._e._a(string, huhy2);
    }

    public boolean _z() {
        return this._a().func_82788_x();
    }

    public boolean _A() {
        return this._g != null;
    }

    public void _a(EntityItemFrame entityItemFrame) {
        this._g = entityItemFrame;
    }

    public EntityItemFrame _B() {
        return this._g;
    }

    public int _C() {
        return this._p() && this._e._c("RepairCost") ? this._e._f("RepairCost") : 0;
    }

    public void _d(int n) {
        if (!this._p()) {
            this._e = new qoac("tag");
        }
        this._e._a("RepairCost", n);
    }

    public Multimap _D() {
        HashMultimap hashMultimap;
        if (this._p() && this._e._c("AttributeModifiers")) {
            hashMultimap = HashMultimap.create();
            bsyv bsyv2 = this._e._n("AttributeModifiers");
            for (int i = 0; i < bsyv2._d(); ++i) {
                qoac qoac2 = (qoac)bsyv2._b(i);
                xson xson2 = sajz._a(qoac2);
                if (xson2._a().getLeastSignificantBits() == 0L || xson2._a().getMostSignificantBits() == 0L) continue;
                ((Multimap)hashMultimap).put(qoac2._j("AttributeName"), xson2);
            }
        } else {
            hashMultimap = this._a().func_111205_h();
        }
        return hashMultimap;
    }
}

