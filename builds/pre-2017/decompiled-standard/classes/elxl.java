/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class elxl
extends jjgc {
    public eidj _a;
    public tgfo _b;
    public int _c = -1;
    public boolean _d;

    public elxl(eidj eidj2) {
        this._a = eidj2;
        this._a.func_70295_k_();
        this._a(false);
    }

    public void _a() {
        if (this._d) {
            this._b = new tgfo("container.mailbox.attachment", true, 6);
            this.field_75153_a.clear();
            this.field_75151_b.clear();
            for (int i = 0; i < 6; ++i) {
                this.func_75146_a(new ukeo(this._b, i, 11, 65 + 22 * i));
            }
        } else {
            this._b = new tgfo("container.mailbox.attachment", true, 1);
            this._c();
        }
    }

    public void _b() {
        for (int i = 0; i < 6; ++i) {
            this.func_75139_a((int)i).field_75221_f = 65 + 22 * (i + (this._a(i) ? 1 : 0));
        }
    }

    public elxl _a(boolean bl) {
        this._d = bl;
        this._a();
        return this;
    }

    public boolean _a(int n) {
        return n > this._c && this._c >= 0;
    }

    public void _c() {
        this.field_75153_a.clear();
        this.field_75151_b.clear();
        this._d();
        int n = 15;
        int n2 = 183;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 12; ++j) {
                this.func_75146_a(new yeso(this._a, j + i * 12, n + 18 * j, n2 + 18 * i));
            }
        }
    }

    public void _d() {
        this.field_75153_a.clear();
        this.field_75151_b.clear();
        this.func_75146_a(new vnhr(this._b, 0, 111, 43));
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            if (cvzo3._e != null && cvzo3._e._c("clan")) {
                return null;
            }
            cvzo2 = cvzo3._l();
            if (n < 1 ? !this.func_75135_a(cvzo3, 1, 37, true) : !this.func_75135_a(cvzo3, 0, 1, false)) {
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
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }
}

