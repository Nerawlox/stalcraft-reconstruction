/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class ohws
extends jjgc {
    public bsse _a = new bsse(this, 2, 2);
    public mssh _b = new wpoq();
    public boolean _c;
    public final EntityPlayer _d;

    public ohws(eidj eidj2, boolean bl, EntityPlayer entityPlayer) {
        int n;
        int n2;
        this._c = bl;
        this._d = entityPlayer;
        this.func_75146_a(new pkzb(eidj2._e, this._a, this._b, 0, 144, 36));
        for (n2 = 0; n2 < 2; ++n2) {
            for (n = 0; n < 2; ++n) {
                this.func_75146_a(new yeso(this._a, n + n2 * 2, 88 + n * 18, 26 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 4; ++n2) {
            n = n2;
            this.func_75146_a(new yesp(this, eidj2, eidj2.func_70302_i_() - 1 - n2, 8, 8 + n2 * 18, n));
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(eidj2, n + (n2 + 1) * 9, 8 + n * 18, 84 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.func_75146_a(new yeso(eidj2, n2, 8 + n2 * 18, 142));
        }
        this.func_75130_a(this._a);
    }

    @Override
    public void func_75130_a(mssh mssh2) {
        this._b.func_70299_a(0, igjl._a()._a(this._a, this._d.field_70170_p));
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        for (int i = 0; i < 4; ++i) {
            cvzo cvzo2 = this._a.func_70304_b(i);
            if (cvzo2 == null) continue;
            entityPlayer.func_71021_b(cvzo2);
        }
        this._b.func_70299_a(0, null);
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            int n2;
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n == 0) {
                if (!this.func_75135_a(cvzo3, 9, 45, true)) {
                    return null;
                }
                yeso2.func_75220_a(cvzo3, cvzo2);
            } else if (n >= 1 && n < 5 ? !this.func_75135_a(cvzo3, 9, 45, false) : (n >= 5 && n < 9 ? !this.func_75135_a(cvzo3, 9, 45, false) : (cvzo2._a() instanceof lpno && !((yeso)this.field_75151_b.get(5 + ((lpno)cvzo2._a()).field_77881_a)).func_75216_d() ? !this.func_75135_a(cvzo3, n2 = 5 + ((lpno)cvzo2._a()).field_77881_a, n2 + 1, false) : (n >= 9 && n < 36 ? !this.func_75135_a(cvzo3, 36, 45, false) : (n >= 36 && n < 45 ? !this.func_75135_a(cvzo3, 9, 36, false) : !this.func_75135_a(cvzo3, 9, 45, false)))))) {
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

