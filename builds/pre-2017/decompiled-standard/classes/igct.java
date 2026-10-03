/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.amww;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class igct
extends jjgc {
    public amww _a;
    public sdcl _b;
    public final ozlu _c;

    public igct(eidj eidj2, amww amww2, ozlu ozlu2) {
        int n;
        this._a = amww2;
        this._c = ozlu2;
        this._b = new sdcl(eidj2._e, amww2);
        this.func_75146_a(new yeso(this._b, 0, 36, 53));
        this.func_75146_a(new yeso(this._b, 1, 62, 53));
        this.func_75146_a(new pkyo(eidj2._e, amww2, this._b, 2, 120, 53));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(eidj2, i + n * 9 + 9, 8 + i * 18, 84 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(eidj2, n, 8 + n * 18, 142));
        }
    }

    public sdcl _a() {
        return this._b;
    }

    @Override
    public void func_75132_a(sdcd sdcd2) {
        super.func_75132_a(sdcd2);
    }

    @Override
    public void func_75142_b() {
        super.func_75142_b();
    }

    @Override
    public void func_75130_a(mssh mssh2) {
        this._b._a();
        super.func_75130_a(mssh2);
    }

    public void _a(int n) {
        this._b._b(n);
    }

    @Override
    public void func_75137_b(int n, int n2) {
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return this._a.func_70931_l_() == entityPlayer;
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n == 2) {
                if (!this.func_75135_a(cvzo3, 3, 39, true)) {
                    return null;
                }
                yeso2.func_75220_a(cvzo3, cvzo2);
            } else if (n == 0 || n == 1 ? !this.func_75135_a(cvzo3, 3, 39, false) : (n >= 3 && n < 30 ? !this.func_75135_a(cvzo3, 30, 39, false) : n >= 30 && n < 39 && !this.func_75135_a(cvzo3, 3, 30, false))) {
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
    public void func_75134_a(EntityPlayer entityPlayer) {
        super.func_75134_a(entityPlayer);
        this._a.func_70932_a_(null);
        super.func_75134_a(entityPlayer);
        if (this._c.field_72995_K) {
            return;
        }
        cvzo cvzo2 = this._b.func_70304_b(0);
        if (cvzo2 != null) {
            entityPlayer.func_71021_b(cvzo2);
        }
        if ((cvzo2 = this._b.func_70304_b(1)) != null) {
            entityPlayer.func_71021_b(cvzo2);
        }
    }
}

