/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;

public class qnzl
extends jjgc {
    public mssh _a;
    public EntityHorse _b;

    public qnzl(mssh mssh2, mssh mssh3, EntityHorse entityHorse) {
        int n;
        int n2;
        this._a = mssh3;
        this._b = entityHorse;
        int n3 = 3;
        mssh3.func_70295_k_();
        int n4 = (n3 - 4) * 18;
        this.func_75146_a(new dhud(this, mssh3, 0, 8, 18));
        this.func_75146_a(new txdj(this, mssh3, 1, 8, 36, entityHorse));
        if (entityHorse.func_110261_ca()) {
            for (n2 = 0; n2 < n3; ++n2) {
                for (n = 0; n < 5; ++n) {
                    this.func_75146_a(new yeso(mssh3, 2 + n + n2 * 5, 80 + n * 18, 18 + n2 * 18));
                }
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(mssh2, n + n2 * 9 + 9, 8 + n * 18, 102 + n2 * 18 + n4));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.func_75146_a(new yeso(mssh2, n2, 8 + n2 * 18, 160 + n4));
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return this._a.func_70300_a(entityPlayer) && this._b.func_70089_S() && this._b.func_70032_d(entityPlayer) < 8.0f;
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n < this._a.func_70302_i_() ? !this.func_75135_a(cvzo3, this._a.func_70302_i_(), this.field_75151_b.size(), true) : (this.func_75139_a(1).func_75214_a(cvzo3) && !this.func_75139_a(1).func_75216_d() ? !this.func_75135_a(cvzo3, 1, 2, false) : (this.func_75139_a(0).func_75214_a(cvzo3) ? !this.func_75135_a(cvzo3, 0, 1, false) : this._a.func_70302_i_() <= 2 || !this.func_75135_a(cvzo3, 2, this._a.func_70302_i_(), false)))) {
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

