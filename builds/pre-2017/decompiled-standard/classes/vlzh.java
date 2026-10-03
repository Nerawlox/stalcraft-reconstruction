/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

@SideOnly(value=Side.CLIENT)
public class vlzh {
    public final xpzm _a;
    public final bscn _b;
    public int _c = -1;
    public int _d = -1;
    public int _e = -1;
    public cvzo _f;
    public float _g;
    public float _h;
    public int _i;
    public boolean _j;
    public xtby _k = xtby._b;
    public int _l;

    public vlzh(xpzm xpzm2, bscn bscn2) {
        this._a = xpzm2;
        this._b = bscn2;
    }

    public static void _a(xpzm xpzm2, vlzh vlzh2, int n, int n2, int n3, int n4) {
        if (!xpzm2._r.func_72886_a(xpzm2._t, n, n2, n3, n4)) {
            vlzh2._a(n, n2, n3, n4);
        }
    }

    public void _a(EntityPlayer entityPlayer) {
        this._k._a(entityPlayer.field_71075_bZ);
    }

    public boolean _a() {
        return false;
    }

    public void _a(xtby xtby2) {
        this._k = xtby2;
        this._k._a(this._a._t.field_71075_bZ);
    }

    public void _b(EntityPlayer entityPlayer) {
        entityPlayer.field_70177_z = -180.0f;
    }

    public boolean _b() {
        return this._k._e();
    }

    public boolean _a(int n, int n2, int n3, int n4) {
        cvzo cvzo2;
        cvzo cvzo3 = this._a._t.func_71045_bC();
        if (cvzo3 != null && cvzo3._a() != null && cvzo3._a().onBlockStartBreak(cvzo3, n, n2, n3, this._a._t)) {
            return false;
        }
        if (this._k._c() && !this._a._t.func_82246_f(n, n2, n3)) {
            return false;
        }
        if (this._k._d() && this._a._t.func_70694_bm() != null && this._a._t.func_70694_bm()._a() instanceof vmpw) {
            return false;
        }
        pkix pkix2 = this._a._r;
        twgu twgu2 = twgu.field_71973_m[pkix2.func_72798_a(n, n2, n3)];
        if (twgu2 == null) {
            return false;
        }
        pkix2.func_72926_e(2001, n, n2, n3, twgu2.field_71990_ca + (pkix2.func_72805_g(n, n2, n3) << 12));
        int n5 = pkix2.func_72805_g(n, n2, n3);
        boolean bl = twgu2.removeBlockByPlayer(pkix2, this._a._t, n, n2, n3);
        if (bl) {
            twgu2.func_71898_d(pkix2, n, n2, n3, n5);
        }
        this._d = -1;
        if (!this._k._d() && (cvzo2 = this._a._t.func_71045_bC()) != null) {
            cvzo2._a(pkix2, twgu2.field_71990_ca, n, n2, n3, this._a._t);
            if (cvzo2._b == 0) {
                this._a._t.func_71028_bD();
            }
        }
        return bl;
    }

    public void _b(int n, int n2, int n3, int n4) {
        if (!this._k._c() || this._a._t.func_82246_f(n, n2, n3)) {
            if (this._k._d()) {
                this._b._b(new sdkq(0, n, n2, n3, n4));
                vlzh._a(this._a, this, n, n2, n3, n4);
                this._i = 5;
            } else if (!this._j || !this._a(n, n2, n3)) {
                if (this._j) {
                    this._b._b(new sdkq(1, this._c, this._d, this._e, n4));
                }
                this._b._b(new sdkq(0, n, n2, n3, n4));
                int n5 = this._a._r.func_72798_a(n, n2, n3);
                if (n5 > 0 && this._g == 0.0f) {
                    twgu.field_71973_m[n5].func_71921_a(this._a._r, n, n2, n3, this._a._t);
                }
                if (n5 > 0 && twgu.field_71973_m[n5].func_71908_a(this._a._t, this._a._t.field_70170_p, n, n2, n3) >= 1.0f) {
                    this._a(n, n2, n3, n4);
                } else {
                    this._j = true;
                    this._c = n;
                    this._d = n2;
                    this._e = n3;
                    this._f = this._a._t.func_70694_bm();
                    this._g = 0.0f;
                    this._h = 0.0f;
                    this._a._r.func_72888_f(this._a._t.field_70157_k, this._c, this._d, this._e, (int)(this._g * 10.0f) - 1);
                }
            }
        }
    }

    public void _c() {
        if (this._j) {
            this._b._b(new sdkq(1, this._c, this._d, this._e, -1));
        }
        this._j = false;
        this._g = 0.0f;
        this._a._r.func_72888_f(this._a._t.field_70157_k, this._c, this._d, this._e, -1);
    }

    public void _c(int n, int n2, int n3, int n4) {
        this._f();
        if (this._i > 0) {
            --this._i;
        } else if (this._k._d()) {
            this._i = 5;
            this._b._b(new sdkq(0, n, n2, n3, n4));
            vlzh._a(this._a, this, n, n2, n3, n4);
        } else if (this._a(n, n2, n3)) {
            int n5 = this._a._r.func_72798_a(n, n2, n3);
            if (n5 == 0) {
                this._j = false;
                return;
            }
            twgu twgu2 = twgu.field_71973_m[n5];
            this._g += twgu2.func_71908_a(this._a._t, this._a._t.field_70170_p, n, n2, n3);
            if (this._h % 4.0f == 0.0f && twgu2 != null) {
                this._a._N._a(twgu2.field_72020_cn._d(), (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, (twgu2.field_72020_cn._a() + 1.0f) / 8.0f, twgu2.field_72020_cn._b() * 0.5f);
            }
            this._h += 1.0f;
            if (this._g >= 1.0f) {
                this._j = false;
                this._b._b(new sdkq(2, n, n2, n3, n4));
                this._a(n, n2, n3, n4);
                this._g = 0.0f;
                this._h = 0.0f;
                this._i = 5;
            }
            this._a._r.func_72888_f(this._a._t.field_70157_k, this._c, this._d, this._e, (int)(this._g * 10.0f) - 1);
        } else {
            this._b(n, n2, n3, n4);
        }
    }

    public float _d() {
        return this._k._d() ? 5.0f : 4.5f;
    }

    public void _e() {
        this._f();
        this._a._N._e();
    }

    public boolean _a(int n, int n2, int n3) {
        boolean bl;
        cvzo cvzo2 = this._a._t.func_70694_bm();
        boolean bl2 = bl = this._f == null && cvzo2 == null;
        if (this._f != null && cvzo2 != null) {
            bl = cvzo2._d == this._f._d && cvzo._a(cvzo2, this._f) && (cvzo2._f() || cvzo2._j() == this._f._j());
        }
        return n == this._c && n2 == this._d && n3 == this._e && bl;
    }

    public void _f() {
        int n = this._a._t.field_71071_by._c;
        if (n != this._l) {
            this._l = n;
            this._b._b(new jjre(this._l));
        }
    }

    public boolean _a(EntityPlayer entityPlayer, ozlu ozlu2, cvzo cvzo2, int n, int n2, int n3, int n4, ofbx ofbx2) {
        mbpd mbpd2;
        int n5;
        this._f();
        float f = (float)ofbx2._c - (float)n;
        float f2 = (float)ofbx2._d - (float)n2;
        float f3 = (float)ofbx2._e - (float)n3;
        boolean bl = false;
        if (cvzo2 != null && cvzo2._a() != null && cvzo2._a().onItemUseFirst(cvzo2, entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3)) {
            return true;
        }
        if ((!entityPlayer.func_70093_af() || entityPlayer.func_70694_bm() == null || entityPlayer.func_70694_bm()._a().shouldPassSneakingClickToBlock(ozlu2, n, n2, n3)) && (n5 = ozlu2.func_72798_a(n, n2, n3)) > 0 && twgu.field_71973_m[n5].func_71903_a(ozlu2, n, n2, n3, entityPlayer, n4, f, f2, f3)) {
            bl = true;
        }
        if (!bl && cvzo2 != null && cvzo2._a() instanceof mbpd && !(mbpd2 = (mbpd)cvzo2._a()).func_77884_a(ozlu2, n, n2, n3, n4, entityPlayer, cvzo2)) {
            return false;
        }
        this._b._b(new kmuc(n, n2, n3, n4, entityPlayer.field_71071_by._a(), f, f2, f3));
        if (bl) {
            return true;
        }
        if (cvzo2 == null) {
            return false;
        }
        if (this._k._d()) {
            n5 = cvzo2._j();
            int n6 = cvzo2._b;
            boolean bl2 = cvzo2._a(entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3);
            cvzo2._b(n5);
            cvzo2._b = n6;
            return bl2;
        }
        if (!cvzo2._a(entityPlayer, ozlu2, n, n2, n3, n4, f, f2, f3)) {
            return false;
        }
        if (cvzo2._b <= 0) {
            MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(entityPlayer, cvzo2));
        }
        return true;
    }

    public boolean _a(EntityPlayer entityPlayer, ozlu ozlu2, cvzo cvzo2) {
        this._f();
        this._b._b(new kmuc(-1, -1, -1, 255, entityPlayer.field_71071_by._a(), 0.0f, 0.0f, 0.0f));
        int n = cvzo2._b;
        cvzo cvzo3 = cvzo2._a(ozlu2, entityPlayer);
        if (cvzo3 == cvzo2 && (cvzo3 == null || cvzo3._b == n)) {
            return false;
        }
        entityPlayer.field_71071_by._a[entityPlayer.field_71071_by._c] = cvzo3;
        if (cvzo3._b <= 0) {
            entityPlayer.field_71071_by._a[entityPlayer.field_71071_by._c] = null;
            MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(entityPlayer, cvzo3));
        }
        return true;
    }

    public EntityClientPlayerMP _a(ozlu ozlu2) {
        return new EntityClientPlayerMP(this._a, ozlu2, this._a._P(), this._b);
    }

    public void _a(EntityPlayer entityPlayer, Entity entity) {
        boolean bl = qlgf._a(this, entityPlayer, entity);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        this._f();
        this._b._b(new sdlx(entityPlayer.field_70157_k, entity.field_70157_k, 1));
        entityPlayer.func_71059_n(entity);
    }

    public boolean _b(EntityPlayer entityPlayer, Entity entity) {
        this._f();
        this._b._b(new sdlx(entityPlayer.field_70157_k, entity.field_70157_k, 0));
        return entityPlayer.func_70998_m(entity);
    }

    public cvzo _a(int n, int n2, int n3, int n4, EntityPlayer entityPlayer) {
        short s = entityPlayer.field_71070_bA.func_75136_a(entityPlayer.field_71071_by);
        cvzo cvzo2 = entityPlayer.field_71070_bA.func_75144_a(n2, n3, n4, entityPlayer);
        this._b._b(new kmrj(n, n2, n3, n4, cvzo2, s));
        return cvzo2;
    }

    public void _a(int n, int n2) {
        this._b._b(new lptv(n, n2));
    }

    public void _a(cvzo cvzo2, int n) {
        if (this._k._d()) {
            this._b._b(new bsye(n, cvzo2));
        }
    }

    public void _a(cvzo cvzo2) {
        if (this._k._d() && cvzo2 != null) {
            this._b._b(new bsye(-1, cvzo2));
        }
    }

    public void _c(EntityPlayer entityPlayer) {
        GloomyHooks.onStoppedUsingItem(this, entityPlayer);
    }

    public boolean _g() {
        return this._k._e();
    }

    public boolean _h() {
        return !this._k._d();
    }

    public boolean _i() {
        return this._k._d();
    }

    public boolean _j() {
        return this._k._d();
    }

    public boolean _k() {
        return this._a._t.func_70115_ae() && this._a._t.field_70154_o instanceof EntityHorse;
    }
}

