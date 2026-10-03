/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;
import net.minecraft.util.tdpx;

public class cwsz
extends jjgc {
    public eidj _a;
    public tgfo _b;
    public boolean _c;
    public int _d = -1;

    public cwsz(boolean bl, eidj eidj2) {
        this._c = bl;
        this._a = eidj2;
        this._a.func_70295_k_();
        this._b = new tgfo(cwsz._a("container.mailbox.attachment"), true, 4);
        this._b();
    }

    public void _a() {
        this.field_75153_a.clear();
        this.field_75151_b.clear();
        if (this._c) {
            this._a(false);
        } else {
            this._b(false);
        }
    }

    public void _b() {
        this.field_75153_a.clear();
        this.field_75151_b.clear();
        if (this._c) {
            this._a(true);
        } else {
            this._b(true);
        }
    }

    public void _a(boolean bl) {
        int n;
        for (n = 0; n < 4; ++n) {
            this.func_75146_a(new yeso(this._b, n, 36 + 20 * n, 181));
        }
        if (!bl) {
            for (n = 0; n < 3; ++n) {
                for (int i = 0; i < 9; ++i) {
                    this.func_75146_a(new yeso(this._a, 9 + n * 9 + i, -7 + 18 * i, 79 + 18 * n));
                }
            }
            for (n = 0; n < 9; ++n) {
                this.func_75146_a(new yeso(this._a, n, -7 + 18 * n, 133));
            }
        }
    }

    public void _b(boolean bl) {
        for (int i = 0; i < 4; ++i) {
            this.func_75146_a(new ukeo(this._b, i, 36 + 20 * i, 191));
        }
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        cvzo cvzo2 = null;
        yeso yeso2 = (yeso)this.field_75151_b.get(n);
        if (yeso2 != null && yeso2.func_75216_d()) {
            cvzo cvzo3 = yeso2.func_75211_c();
            cvzo2 = cvzo3._l();
            if (n < 4 ? !this.func_75135_a(cvzo3, 4, 40, true) : !this.func_75135_a(cvzo3, 0, 4, false)) {
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
        if (!entityPlayer.field_70170_p.field_72995_K && this._c) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    public static String _a(String string) {
        return tdpx._a(string);
    }
}

