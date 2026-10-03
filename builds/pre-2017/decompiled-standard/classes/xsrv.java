/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class xsrv
extends jjgc {
    public bsse _a = new bsse(this, 3, 3);
    public mssh _b = new wpoq();
    public ozlu _c;
    public int _d;
    public int _e;
    public int _f;

    public xsrv(eidj eidj2, ozlu ozlu2, int n, int n2, int n3) {
        int n4;
        int n5;
        this._c = ozlu2;
        this._d = n;
        this._e = n2;
        this._f = n3;
        this.func_75146_a(new pkzb(eidj2._e, this._a, this._b, 0, 124, 35));
        for (n5 = 0; n5 < 3; ++n5) {
            for (n4 = 0; n4 < 3; ++n4) {
                this.func_75146_a(new yeso(this._a, n4 + n5 * 3, 30 + n4 * 18, 17 + n5 * 18));
            }
        }
        for (n5 = 0; n5 < 3; ++n5) {
            for (n4 = 0; n4 < 9; ++n4) {
                this.func_75146_a(new yeso(eidj2, n4 + n5 * 9 + 9, 8 + n4 * 18, 84 + n5 * 18));
            }
        }
        for (n5 = 0; n5 < 9; ++n5) {
            this.func_75146_a(new yeso(eidj2, n5, 8 + n5 * 18, 142));
        }
        this.func_75130_a(this._a);
    }

    @Override
    public void func_75130_a(mssh mssh2) {
        this._b.func_70299_a(0, igjl._a()._a(this._a, this._c));
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        if (this._c.field_72995_K) {
            return;
        }
        for (int i = 0; i < 9; ++i) {
            cvzo cvzo2 = this._a.func_70304_b(i);
            if (cvzo2 == null) continue;
            entityPlayer.func_71021_b(cvzo2);
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        if (this._c.func_72798_a(this._d, this._e, this._f) != twgu.field_72060_ay.field_71990_ca) {
            return false;
        }
        return !(entityPlayer.func_70092_e((double)this._d + 0.5, (double)this._e + 0.5, (double)this._f + 0.5) > 64.0);
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n == 0) {
                if (!this.func_75135_a(cvzo3, 10, 46, true)) {
                    return null;
                }
                yeso2.func_75220_a(cvzo3, cvzo2);
            } else if (n >= 10 && n < 37 ? !this.func_75135_a(cvzo3, 37, 46, false) : (n >= 37 && n < 46 ? !this.func_75135_a(cvzo3, 10, 37, false) : !this.func_75135_a(cvzo3, 10, 46, false))) {
                return null;
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
            if (cvzo3._b == cvzo2._b) {
                return null;
            }
            yeso2.func_82870_a(entityPlayer, cvzo3);
        }
        return cvzo2;
    }

    @Override
    public boolean func_94530_a(cvzo cvzo2, yeso yeso2) {
        return yeso2.field_75224_c != this._b && super.func_94530_a(cvzo2, yeso2);
    }
}

