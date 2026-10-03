/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class wpkx
extends jjgc {
    public mssh _a;
    public int _b;

    public wpkx(mssh mssh2, mssh mssh3) {
        int n;
        int n2;
        this._a = mssh3;
        this._b = mssh3.func_70302_i_() / 9;
        mssh3.func_70295_k_();
        int n3 = (this._b - 4) * 18;
        for (n2 = 0; n2 < this._b; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(mssh3, n + n2 * 9, 8 + n * 18, 18 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(mssh2, n + n2 * 9 + 9, 8 + n * 18, 103 + n2 * 18 + n3));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.func_75146_a(new yeso(mssh2, n2, 8 + n2 * 18, 161 + n3));
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
            if (n < this._b * 9 ? !this.func_75135_a(cvzo3, this._b * 9, this.field_75151_b.size(), true) : !this.func_75135_a(cvzo3, 0, this._b * 9, false)) {
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

    public mssh _a() {
        return this._a;
    }
}

