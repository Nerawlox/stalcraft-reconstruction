/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;

public class vmyb
extends hurg
implements mssh {
    public static final hdpq[][] _a = new hdpq[][]{{hdpq._c, hdpq._e}, {hdpq._m, hdpq._j}, {hdpq._g}, {hdpq._l}};
    @SideOnly(value=Side.CLIENT)
    public long _b;
    @SideOnly(value=Side.CLIENT)
    public float _c;
    public boolean _d;
    public int _e = -1;
    public int _f;
    public int _g;
    public cvzo _h;
    public String _i;

    @Override
    public void func_70316_g() {
        if (this.field_70331_k.func_82737_E() % 80L == 0L) {
            this._b();
            this._a();
        }
    }

    public void _a() {
        if (this._d && this._e > 0 && !this.field_70331_k.field_72995_K && this._f > 0) {
            double d = this._e * 10 + 10;
            int n = 0;
            if (this._e >= 4 && this._f == this._g) {
                n = 1;
            }
            eidj eidj2 = eidj._a()._a(this.field_70329_l, this.field_70330_m, this.field_70327_n, this.field_70329_l + 1, this.field_70330_m + 1, this.field_70327_n + 1)._b(d, d, d);
            eidj2._f = this.field_70331_k.func_72800_K();
            List list = this.field_70331_k.func_72872_a(EntityPlayer.class, eidj2);
            for (EntityPlayer entityPlayer : list) {
                entityPlayer.func_70690_d(new supr(this._f, 180, n, true));
            }
            if (this._e >= 4 && this._f != this._g && this._g > 0) {
                for (EntityPlayer entityPlayer : list) {
                    entityPlayer.func_70690_d(new supr(this._g, 180, 0, true));
                }
            }
        }
    }

    public void _b() {
        if (!this.field_70331_k.func_72937_j(this.field_70329_l, this.field_70330_m + 1, this.field_70327_n)) {
            this._d = false;
            this._e = 0;
        } else {
            int n;
            this._d = true;
            this._e = 0;
            int n2 = 1;
            while (n2 <= 4 && (n = this.field_70330_m - n2) >= 0) {
                boolean bl = true;
                block1: for (int i = this.field_70329_l - n2; i <= this.field_70329_l + n2 && bl; ++i) {
                    for (int j = this.field_70327_n - n2; j <= this.field_70327_n + n2; ++j) {
                        int n3 = this.field_70331_k.func_72798_a(i, n, j);
                        twgu twgu2 = twgu.field_71973_m[n3];
                        if (twgu2 != null && twgu2.isBeaconBase(this.field_70331_k, i, n, j, this.field_70329_l, this.field_70330_m, this.field_70327_n)) continue;
                        bl = false;
                        continue block1;
                    }
                }
                if (!bl) break;
                this._e = n2++;
            }
            if (this._e == 0) {
                this._d = false;
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public float _c() {
        if (!this._d) {
            return 0.0f;
        }
        int n = (int)(this.field_70331_k.func_82737_E() - this._b);
        this._b = this.field_70331_k.func_82737_E();
        if (n > 1) {
            this._c -= (float)n / 40.0f;
            if (this._c < 0.0f) {
                this._c = 0.0f;
            }
        }
        this._c += 0.025f;
        if (this._c > 1.0f) {
            this._c = 1.0f;
        }
        return this._c;
    }

    public int _d() {
        return this._f;
    }

    public int _e() {
        return this._g;
    }

    public int _f() {
        return this._e;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(int n) {
        this._e = n;
    }

    public void _b(int n) {
        this._f = 0;
        for (int i = 0; i < this._e && i < 3; ++i) {
            for (hdpq hdpq2 : _a[i]) {
                if (hdpq2._H != n) continue;
                this._f = n;
                return;
            }
        }
    }

    public void _c(int n) {
        this._g = 0;
        if (this._e >= 4) {
            for (int i = 0; i < 4; ++i) {
                for (hdpq hdpq2 : _a[i]) {
                    if (hdpq2._H != n) continue;
                    this._g = n;
                    return;
                }
            }
        }
    }

    @Override
    public cezg func_70319_e() {
        qoac qoac2 = new qoac();
        this.func_70310_b(qoac2);
        return new wpte(this.field_70329_l, this.field_70330_m, this.field_70327_n, 3, qoac2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public double func_82115_m() {
        return 65536.0;
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._f = qoac2._f("Primary");
        this._g = qoac2._f("Secondary");
        this._e = qoac2._f("Levels");
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("Primary", this._f);
        qoac2._a("Secondary", this._g);
        qoac2._a("Levels", this._e);
    }

    @Override
    public int func_70302_i_() {
        return 1;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return n == 0 ? this._h : null;
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (n == 0 && this._h != null) {
            if (n2 >= this._h._b) {
                cvzo cvzo2 = this._h;
                this._h = null;
                return cvzo2;
            }
            this._h._b -= n2;
            return new cvzo(this._h._d, n2, this._h._j());
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (n == 0 && this._h != null) {
            cvzo cvzo2 = this._h;
            this._h = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        if (n == 0) {
            this._h = cvzo2;
        }
    }

    @Override
    public String func_70303_b() {
        return this.func_94042_c() ? this._i : "container.beacon";
    }

    @Override
    public boolean func_94042_c() {
        return this._i != null && this._i.length() > 0;
    }

    public void _a(String string) {
        this._i = string;
    }

    @Override
    public int func_70297_j_() {
        return 10000;
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
        return cvzo2._d == tgdv.field_77817_bH.field_77779_bT || cvzo2._d == tgdv.field_77702_n.field_77779_bT || cvzo2._d == tgdv.field_77717_p.field_77779_bT || cvzo2._d == tgdv.field_77703_o.field_77779_bT;
    }
}

