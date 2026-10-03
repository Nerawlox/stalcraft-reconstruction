/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;

public class jjzo
extends hurg
implements mssh {
    public cvzo[] _a = new cvzo[9];
    public Random _b = new Random();
    public String _c;

    @Override
    public int func_70302_i_() {
        return 9;
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
                this.func_70296_d();
                return cvzo2;
            }
            cvzo cvzo3 = this._a[n]._a(n2);
            if (this._a[n]._b == 0) {
                this._a[n] = null;
            }
            this.func_70296_d();
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

    public int _a() {
        int n = -1;
        int n2 = 1;
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._b.nextInt(n2++) != 0) continue;
            n = i;
        }
        return n;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this._a[n] = cvzo2;
        if (cvzo2 != null && cvzo2._b > this.func_70297_j_()) {
            cvzo2._b = this.func_70297_j_();
        }
        this.func_70296_d();
    }

    public int _a(cvzo cvzo2) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] != null && this._a[i]._d != 0) continue;
            this.func_70299_a(i, cvzo2);
            return i;
        }
        return -1;
    }

    @Override
    public String func_70303_b() {
        return this.func_94042_c() ? this._c : "container.dispenser";
    }

    public void _a(String string) {
        this._c = string;
    }

    @Override
    public boolean func_94042_c() {
        return this._c != null;
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        bsyv bsyv2 = qoac2._n("Items");
        this._a = new cvzo[this.func_70302_i_()];
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac3 = (qoac)bsyv2._b(i);
            int n = qoac3._d("Slot") & 0xFF;
            if (n < 0 || n >= this._a.length) continue;
            this._a[n] = cvzo._a(qoac3);
        }
        if (qoac2._c("CustomName")) {
            this._c = qoac2._j("CustomName");
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
        if (this.func_94042_c()) {
            qoac2._a("CustomName", this._c);
        }
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        if (this.field_70331_k.func_72796_p(this.field_70329_l, this.field_70330_m, this.field_70327_n) != this) {
            return false;
        }
        return !(entityPlayer.func_70092_e((double)this.field_70329_l + 0.5, (double)this.field_70330_m + 0.5, (double)this.field_70327_n + 0.5) > 64.0);
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
}

