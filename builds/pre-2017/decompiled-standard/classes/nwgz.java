/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;

public class nwgz
extends hurg
implements gaaa {
    public static final int[] _a = new int[]{0};
    public static final int[] _b = new int[]{2, 1};
    public static final int[] _c = new int[]{1};
    public cvzo[] _d = new cvzo[3];
    public int _e;
    public int _f;
    public int _g;
    public String _h;

    @Override
    public int func_70302_i_() {
        return this._d.length;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this._d[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this._d[n] != null) {
            if (this._d[n]._b <= n2) {
                cvzo cvzo2 = this._d[n];
                this._d[n] = null;
                return cvzo2;
            }
            cvzo cvzo3 = this._d[n]._a(n2);
            if (this._d[n]._b == 0) {
                this._d[n] = null;
            }
            return cvzo3;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this._d[n] != null) {
            cvzo cvzo2 = this._d[n];
            this._d[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this._d[n] = cvzo2;
        if (cvzo2 != null && cvzo2._b > this.func_70297_j_()) {
            cvzo2._b = this.func_70297_j_();
        }
    }

    @Override
    public String func_70303_b() {
        return this.func_94042_c() ? this._h : "container.furnace";
    }

    @Override
    public boolean func_94042_c() {
        return this._h != null && this._h.length() > 0;
    }

    public void _a(String string) {
        this._h = string;
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        bsyv bsyv2 = qoac2._n("Items");
        this._d = new cvzo[this.func_70302_i_()];
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            byte by = qoac3._d("Slot");
            if (by < 0 || by >= this._d.length) continue;
            this._d[by] = cvzo._a(qoac3);
        }
        this._e = qoac2._e("BurnTime");
        this._g = qoac2._e("CookTime");
        this._f = nwgz._a(this._d[1]);
        if (qoac2._c("CustomName")) {
            this._h = qoac2._j("CustomName");
        }
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("BurnTime", (short)this._e);
        qoac2._a("CookTime", (short)this._g);
        bsyv bsyv2 = new bsyv();
        for (int i = 0; i < this._d.length; ++i) {
            if (this._d[i] == null) continue;
            qoac qoac3 = new qoac();
            qoac3._a("Slot", (byte)i);
            this._d[i]._b(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("Items", bsyv2);
        if (this.func_94042_c()) {
            qoac2._a("CustomName", this._h);
        }
    }

    @Override
    public int func_70297_j_() {
        return 64;
    }

    @SideOnly(value=Side.CLIENT)
    public int _b(int n) {
        return this._g * n / 200;
    }

    @SideOnly(value=Side.CLIENT)
    public int _c(int n) {
        if (this._f == 0) {
            this._f = 200;
        }
        return this._e * n / this._f;
    }

    public boolean _a() {
        return this._e > 0;
    }

    @Override
    public void func_70316_g() {
        boolean bl = this._e > 0;
        boolean bl2 = false;
        if (this._e > 0) {
            --this._e;
        }
        if (!this.field_70331_k.field_72995_K) {
            if (this._e == 0 && this._b()) {
                this._f = this._e = nwgz._a(this._d[1]);
                if (this._e > 0) {
                    bl2 = true;
                    if (this._d[1] != null) {
                        --this._d[1]._b;
                        if (this._d[1]._b == 0) {
                            this._d[1] = this._d[1]._a().getContainerItemStack(this._d[1]);
                        }
                    }
                }
            }
            if (this._a() && this._b()) {
                ++this._g;
                if (this._g == 200) {
                    this._g = 0;
                    this._c();
                    bl2 = true;
                }
            } else {
                this._g = 0;
            }
            if (bl != this._e > 0) {
                bl2 = true;
                nuxm._a(this._e > 0, this.field_70331_k, this.field_70329_l, this.field_70330_m, this.field_70327_n);
            }
        }
        if (bl2) {
            this.func_70296_d();
        }
    }

    public boolean _b() {
        if (this._d[0] == null) {
            return false;
        }
        cvzo cvzo2 = yewu._a()._a(this._d[0]);
        if (cvzo2 == null) {
            return false;
        }
        if (this._d[2] == null) {
            return true;
        }
        if (!this._d[2]._b(cvzo2)) {
            return false;
        }
        int n = this._d[2]._b + cvzo2._b;
        return n <= this.func_70297_j_() && n <= cvzo2._d();
    }

    public void _c() {
        if (this._b()) {
            cvzo cvzo2 = yewu._a()._a(this._d[0]);
            if (this._d[2] == null) {
                this._d[2] = cvzo2._l();
            } else if (this._d[2]._b(cvzo2)) {
                this._d[2]._b += cvzo2._b;
            }
            --this._d[0]._b;
            if (this._d[0]._b <= 0) {
                this._d[0] = null;
            }
        }
    }

    public static int _a(cvzo cvzo2) {
        if (cvzo2 == null) {
            return 0;
        }
        int n = cvzo2._a().field_77779_bT;
        tgdv tgdv2 = cvzo2._a();
        if (cvzo2._a() instanceof mbpd && twgu.field_71973_m[n] != null) {
            twgu twgu2 = twgu.field_71973_m[n];
            if (twgu2 == twgu.field_72092_bO) {
                return 150;
            }
            if (twgu2.field_72018_cp == tflj._d) {
                return 300;
            }
            if (twgu2 == twgu.field_111034_cE) {
                return 16000;
            }
        }
        if (tgdv2 instanceof focs && ((focs)tgdv2)._a().equals("WOOD")) {
            return 200;
        }
        if (tgdv2 instanceof vmpw && ((vmpw)tgdv2).func_77825_f().equals("WOOD")) {
            return 200;
        }
        if (tgdv2 instanceof zhxn && ((zhxn)tgdv2)._a().equals("WOOD")) {
            return 200;
        }
        if (n == tgdv.field_77669_D.field_77779_bT) {
            return 100;
        }
        if (n == tgdv.field_77705_m.field_77779_bT) {
            return 1600;
        }
        if (n == tgdv.field_77775_ay.field_77779_bT) {
            return 20000;
        }
        if (n == twgu.field_71987_y.field_71990_ca) {
            return 100;
        }
        if (n == tgdv.field_77731_bo.field_77779_bT) {
            return 2400;
        }
        return GameRegistry.getFuelValue(cvzo2);
    }

    public static boolean _b(cvzo cvzo2) {
        return nwgz._a(cvzo2) > 0;
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
        return n == 2 ? false : (n == 1 ? nwgz._b(cvzo2) : true);
    }

    @Override
    public int[] _a(int n) {
        return n == 0 ? _b : (n == 1 ? _a : _c);
    }

    @Override
    public boolean _a(int n, cvzo cvzo2, int n2) {
        return this.func_94041_b(n, cvzo2);
    }

    @Override
    public boolean _b(int n, cvzo cvzo2, int n2) {
        return n2 != 0 || n != 1 || cvzo2._d == tgdv.field_77788_aw.field_77779_bT;
    }
}

