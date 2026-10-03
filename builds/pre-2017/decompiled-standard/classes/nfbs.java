/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.brewing.PotionBrewedEvent;

public class nfbs
extends hurg
implements gaaa {
    public static final int[] _a = new int[]{3};
    public static final int[] _b = new int[]{0, 1, 2};
    public cvzo[] _c = new cvzo[4];
    public int _d;
    public int _e;
    public int _f;
    public String _g;

    @Override
    public String func_70303_b() {
        return this.func_94042_c() ? this._g : "container.brewing";
    }

    @Override
    public boolean func_94042_c() {
        return this._g != null && this._g.length() > 0;
    }

    public void _a(String string) {
        this._g = string;
    }

    @Override
    public int func_70302_i_() {
        return this._c.length;
    }

    @Override
    public void func_70316_g() {
        if (this._d > 0) {
            --this._d;
            if (this._d == 0) {
                this._c();
                this.func_70296_d();
            } else if (!this._b()) {
                this._d = 0;
                this.func_70296_d();
            } else if (this._f != this._c[3]._d) {
                this._d = 0;
                this.func_70296_d();
            }
        } else if (this._b()) {
            this._d = 400;
            this._f = this._c[3]._d;
        }
        int n = this._d();
        if (n != this._e) {
            this._e = n;
            this.field_70331_k.func_72921_c(this.field_70329_l, this.field_70330_m, this.field_70327_n, n, 2);
        }
        super.func_70316_g();
    }

    public int _a() {
        return this._d;
    }

    public boolean _b() {
        if (this._c[3] != null && this._c[3]._b > 0) {
            cvzo cvzo2 = this._c[3];
            if (!tgdv.field_77698_e[cvzo2._d].func_77632_u()) {
                return false;
            }
            boolean bl = false;
            for (int i = 0; i < 3; ++i) {
                if (this._c[i] == null || !(this._c[i]._a() instanceof zyyc)) continue;
                int n = this._c[i]._j();
                int n2 = this._a(n, cvzo2);
                if (!zyyc._b(n) && zyyc._b(n2)) {
                    bl = true;
                    break;
                }
                List list2 = tgdv.field_77726_bs._a(n);
                List list3 = tgdv.field_77726_bs._a(n2);
                if (n > 0 && list2 == list3 || list2 != null && (list2.equals(list3) || list3 == null) || n == n2) continue;
                bl = true;
                break;
            }
            return bl;
        }
        return false;
    }

    public void _c() {
        if (this._b()) {
            cvzo cvzo2 = this._c[3];
            for (int i = 0; i < 3; ++i) {
                if (this._c[i] == null || !(this._c[i]._a() instanceof zyyc)) continue;
                int n = this._c[i]._j();
                int n2 = this._a(n, cvzo2);
                List list2 = tgdv.field_77726_bs._a(n);
                List list3 = tgdv.field_77726_bs._a(n2);
                if (!(n > 0 && list2 == list3 || list2 != null && (list2.equals(list3) || list3 == null))) {
                    if (n == n2) continue;
                    this._c[i]._b(n2);
                    continue;
                }
                if (zyyc._b(n) || !zyyc._b(n2)) continue;
                this._c[i]._b(n2);
            }
            if (tgdv.field_77698_e[cvzo2._d].func_77634_r()) {
                this._c[3] = tgdv.field_77698_e[cvzo2._d].getContainerItemStack(this._c[3]);
            } else {
                --this._c[3]._b;
                if (this._c[3]._b <= 0) {
                    this._c[3] = null;
                }
            }
            MinecraftForge.EVENT_BUS.post(new PotionBrewedEvent(this._c));
        }
    }

    public int _a(int n, cvzo cvzo2) {
        return cvzo2 == null ? n : (tgdv.field_77698_e[cvzo2._d].func_77632_u() ? hdoy._a(n, tgdv.field_77698_e[cvzo2._d].func_77666_t()) : n);
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        bsyv bsyv2 = qoac2._n("Items");
        this._c = new cvzo[this.func_70302_i_()];
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            byte by = qoac3._d("Slot");
            if (by < 0 || by >= this._c.length) continue;
            this._c[by] = cvzo._a(qoac3);
        }
        this._d = qoac2._e("BrewTime");
        if (qoac2._c("CustomName")) {
            this._g = qoac2._j("CustomName");
        }
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("BrewTime", (short)this._d);
        bsyv bsyv2 = new bsyv();
        for (int i = 0; i < this._c.length; ++i) {
            if (this._c[i] == null) continue;
            qoac qoac3 = new qoac();
            qoac3._a("Slot", (byte)i);
            this._c[i]._b(qoac3);
            bsyv2._a(qoac3);
        }
        qoac2._a("Items", bsyv2);
        if (this.func_94042_c()) {
            qoac2._a("CustomName", this._g);
        }
    }

    @Override
    public cvzo func_70301_a(int n) {
        return n >= 0 && n < this._c.length ? this._c[n] : null;
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (n >= 0 && n < this._c.length) {
            cvzo cvzo2 = this._c[n];
            this._c[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (n >= 0 && n < this._c.length) {
            cvzo cvzo2 = this._c[n];
            this._c[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        if (n >= 0 && n < this._c.length) {
            this._c[n] = cvzo2;
        }
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
        return n == 3 ? tgdv.field_77698_e[cvzo2._d].func_77632_u() : cvzo2._a() instanceof zyyc || cvzo2._d == tgdv.field_77729_bt.field_77779_bT;
    }

    @SideOnly(value=Side.CLIENT)
    public void _b(int n) {
        this._d = n;
    }

    public int _d() {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (this._c[i] == null) continue;
            n |= 1 << i;
        }
        return n;
    }

    @Override
    public int[] _a(int n) {
        return n == 1 ? _a : _b;
    }

    @Override
    public boolean _a(int n, cvzo cvzo2, int n2) {
        return this.func_94041_b(n, cvzo2);
    }

    @Override
    public boolean _b(int n, cvzo cvzo2, int n2) {
        return true;
    }
}

