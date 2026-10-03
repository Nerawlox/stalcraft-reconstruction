/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.List;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.owak;
import net.minecraft.util.sajh;

public class cffd
extends hurg
implements sdpc {
    public cvzo[] _a = new cvzo[5];
    public String _b;
    public int _c = -1;

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        bsyv bsyv2 = qoac2._n("Items");
        this._a = new cvzo[this.func_70302_i_()];
        if (qoac2._c("CustomName")) {
            this._b = qoac2._j("CustomName");
        }
        this._c = qoac2._f("TransferCooldown");
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            byte by = qoac3._d("Slot");
            if (by < 0 || by >= this._a.length) continue;
            this._a[by] = cvzo._a(qoac3);
        }
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        bsyv bsyv2 = new bsyv();
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null) continue;
            qoac qoac3 = new qoac();
            qoac3._a("Slot", (byte)i);
            this._a[i]._b(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("Items", bsyv2);
        qoac2._a("TransferCooldown", this._c);
        if (this.func_94042_c()) {
            qoac2._a("CustomName", this._b);
        }
    }

    @Override
    public void func_70296_d() {
        super.func_70296_d();
    }

    @Override
    public int func_70302_i_() {
        return this._a.length;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this._a[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this._a[n] != null) {
            if (this._a[n]._b <= n2) {
                cvzo cvzo2 = this._a[n];
                this._a[n] = null;
                return cvzo2;
            }
            cvzo cvzo3 = this._a[n]._a(n2);
            if (this._a[n]._b == 0) {
                this._a[n] = null;
            }
            return cvzo3;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this._a[n] != null) {
            cvzo cvzo2 = this._a[n];
            this._a[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this._a[n] = cvzo2;
        if (cvzo2 != null && cvzo2._b > this.func_70297_j_()) {
            cvzo2._b = this.func_70297_j_();
        }
    }

    @Override
    public String func_70303_b() {
        return this.func_94042_c() ? this._b : "container.hopper";
    }

    @Override
    public boolean func_94042_c() {
        return this._b != null && this._b.length() > 0;
    }

    public void _a(String string) {
        this._b = string;
    }

    @Override
    public int func_70297_j_() {
        return 64;
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this ? false : entityPlayer.func_70092_e((double)this.field_70329_l + 0.5, (double)this.field_70330_m + 0.5, (double)this.field_70327_n + 0.5) <= 64.0;
    }

    @Override
    public void func_70295_k_() {
    }

    @Override
    public void func_70305_f() {
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }

    @Override
    public void func_70316_g() {
        GloomyHooks.updateEntity(this);
    }

    public boolean _a() {
        GloomyHooks.updateHopper(this);
        return false;
    }

    public boolean _b() {
        mssh mssh2 = this._c();
        if (mssh2 == null) {
            return false;
        }
        for (int i = 0; i < this.func_70302_i_(); ++i) {
            if (this.func_70301_a(i) == null) continue;
            cvzo cvzo2 = this.func_70301_a(i)._l();
            cvzo cvzo3 = cffd._a(mssh2, this.func_70298_a(i, 1), owak._a[ndvl._a(this.func_70322_n())]);
            if (cvzo3 == null || cvzo3._b == 0) {
                mssh2.func_70296_d();
                return true;
            }
            this.func_70299_a(i, cvzo2);
        }
        return false;
    }

    public static boolean _a(sdpc sdpc2) {
        GloomyHooks.suckItemsIntoHopper(null, sdpc2);
        return false;
    }

    public static boolean _a(sdpc sdpc2, mssh mssh2, int n, int n2) {
        cvzo cvzo2 = mssh2.func_70301_a(n);
        if (cvzo2 != null && cffd._b(mssh2, cvzo2, n, n2)) {
            cvzo cvzo3 = cvzo2._l();
            cvzo cvzo4 = cffd._a(sdpc2, mssh2.func_70298_a(n, 1), -1);
            if (cvzo4 == null || cvzo4._b == 0) {
                mssh2.func_70296_d();
                return true;
            }
            mssh2.func_70299_a(n, cvzo3);
        }
        return false;
    }

    public static boolean _a(mssh mssh2, EntityItem entityItem) {
        boolean bl = false;
        if (entityItem == null) {
            return false;
        }
        cvzo cvzo2 = entityItem.func_92059_d()._l();
        cvzo cvzo3 = cffd._a(mssh2, cvzo2, -1);
        if (cvzo3 != null && cvzo3._b != 0) {
            entityItem.func_92058_a(cvzo3);
        } else {
            bl = true;
            entityItem.func_70106_y();
        }
        return bl;
    }

    public static cvzo _a(mssh mssh2, cvzo cvzo2, int n) {
        if (mssh2 instanceof gaaa && n > -1) {
            gaaa gaaa2 = (gaaa)mssh2;
            int[] nArray = gaaa2._a(n);
            for (int i = 0; i < nArray.length && cvzo2 != null && cvzo2._b > 0; ++i) {
                cvzo2 = cffd._c(mssh2, cvzo2, nArray[i], n);
            }
        } else {
            int n2 = mssh2.func_70302_i_();
            for (int i = 0; i < n2 && cvzo2 != null && cvzo2._b > 0; ++i) {
                cvzo2 = cffd._c(mssh2, cvzo2, i, n);
            }
        }
        if (cvzo2 != null && cvzo2._b == 0) {
            cvzo2 = null;
        }
        return cvzo2;
    }

    public static boolean _a(mssh mssh2, cvzo cvzo2, int n, int n2) {
        return !mssh2.func_94041_b(n, cvzo2) ? false : !(mssh2 instanceof gaaa) || ((gaaa)mssh2)._a(n, cvzo2, n2);
    }

    public static boolean _b(mssh mssh2, cvzo cvzo2, int n, int n2) {
        return !(mssh2 instanceof gaaa) || ((gaaa)mssh2)._b(n, cvzo2, n2);
    }

    public static cvzo _c(mssh mssh2, cvzo cvzo2, int n, int n2) {
        cvzo cvzo3 = mssh2.func_70301_a(n);
        if (cffd._a(mssh2, cvzo2, n, n2)) {
            int n3;
            boolean bl = false;
            if (cvzo3 == null) {
                int n4 = Math.min(cvzo2._d(), mssh2.func_70297_j_());
                if (n4 >= cvzo2._b) {
                    mssh2.func_70299_a(n, cvzo2);
                    cvzo2 = null;
                } else {
                    mssh2.func_70299_a(n, cvzo2._a(n4));
                }
                bl = true;
            } else if (cffd._a(cvzo3, cvzo2) && (n3 = Math.min(cvzo2._d(), mssh2.func_70297_j_())) > cvzo3._b) {
                int n5 = Math.min(cvzo2._b, n3 - cvzo3._b);
                cvzo2._b -= n5;
                cvzo3._b += n5;
                boolean bl2 = bl = n5 > 0;
            }
            if (bl) {
                if (mssh2 instanceof cffd) {
                    ((cffd)mssh2)._a(8);
                    mssh2.func_70296_d();
                }
                mssh2.func_70296_d();
            }
        }
        return cvzo2;
    }

    public mssh _c() {
        int n = ndvl._a(this.func_70322_n());
        return cffd._b(this.func_70314_l(), this.field_70329_l + owak._b[n], (double)(this.field_70330_m + owak._c[n]), (double)(this.field_70327_n + owak._d[n]));
    }

    public static mssh _b(sdpc sdpc2) {
        return cffd._b(sdpc2.func_70314_l(), sdpc2.func_96107_aA(), sdpc2.func_96109_aB() + 1.0, sdpc2.func_96108_aC());
    }

    public static EntityItem _a(ozlu ozlu2, double d, double d2, double d3) {
        List list = ozlu2.func_82733_a(EntityItem.class, eidj._a()._a(d, d2, d3, d + 1.0, d2 + 1.0, d3 + 1.0), zhos._a);
        return list.size() > 0 ? (EntityItem)list.get(0) : null;
    }

    public static mssh _b(ozlu ozlu2, double d, double d2, double d3) {
        List list;
        int n;
        twgu twgu2;
        int n2;
        int n3;
        mssh mssh2 = null;
        int n4 = sajh._c(d);
        hurg hurg2 = ozlu2.func_72796_p(n4, n3 = sajh._c(d2), n2 = sajh._c(d3));
        if (hurg2 != null && hurg2 instanceof mssh && (mssh2 = (mssh)((Object)hurg2)) instanceof yfav && (twgu2 = twgu.field_71973_m[n = ozlu2.func_72798_a(n4, n3, n2)]) instanceof ydso) {
            mssh2 = ((ydso)twgu2)._c(ozlu2, n4, n3, n2);
        }
        if (mssh2 == null && (list = ozlu2.func_94576_a(null, eidj._a()._a(d, d2, d3, d + 1.0, d2 + 1.0, d3 + 1.0), zhos._b)) != null && list.size() > 0) {
            mssh2 = (mssh)list.get(ozlu2.field_73012_v.nextInt(list.size()));
        }
        return mssh2;
    }

    public static boolean _a(cvzo cvzo2, cvzo cvzo3) {
        return cvzo2._d != cvzo3._d ? false : (cvzo2._j() != cvzo3._j() ? false : (cvzo2._b > cvzo2._d() ? false : cvzo._a(cvzo2, cvzo3)));
    }

    @Override
    public double func_96107_aA() {
        return this.field_70329_l;
    }

    @Override
    public double func_96109_aB() {
        return this.field_70330_m;
    }

    @Override
    public double func_96108_aC() {
        return this.field_70327_n;
    }

    public void _a(int n) {
        this._c = n;
    }

    public boolean _d() {
        return this._c > 0;
    }
}

