/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class xsns
extends jjgc {
    public final mssh _a;

    public xsns(eidj eidj2, mssh mssh2) {
        int n;
        this._a = mssh2;
        mssh2.func_70295_k_();
        int n2 = 51;
        for (n = 0; n < mssh2.func_70302_i_(); ++n) {
            this.func_75146_a(new yeso(mssh2, n, 44 + n * 18, 20));
        }
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(eidj2, i + n * 9 + 9, 8 + i * 18, n * 18 + n2));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(eidj2, n, 8 + n * 18, 58 + n2));
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return this._a.func_70300_a(entityPlayer);
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n < this._a.func_70302_i_() ? !this.func_75135_a(cvzo3, this._a.func_70302_i_(), this.field_75151_b.size(), true) : !this.func_75135_a(cvzo3, 0, this._a.func_70302_i_(), false)) {
                return null;
            }
            if (cvzo3._b == 0) {
                yeso2.func_75215_d(null);
            } else {
                yeso2.func_75218_e();
            }
        }
        return cvzo2;
    }

    @Override
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        this._a.func_70305_f();
    }
}

