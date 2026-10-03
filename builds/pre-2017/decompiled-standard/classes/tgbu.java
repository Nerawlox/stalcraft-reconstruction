/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class tgbu
extends jjgc {
    public nfbs _a;
    public final yeso _b;
    public int _c;

    public tgbu(eidj eidj2, nfbs nfbs2) {
        int n;
        this._a = nfbs2;
        this.func_75146_a(new rrag(eidj2._e, nfbs2, 0, 56, 46));
        this.func_75146_a(new rrag(eidj2._e, nfbs2, 1, 79, 53));
        this.func_75146_a(new rrag(eidj2._e, nfbs2, 2, 102, 46));
        this._b = this.func_75146_a(new sdbw(this, nfbs2, 3, 79, 17));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(eidj2, i + n * 9 + 9, 8 + i * 18, 84 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(eidj2, n, 8 + n * 18, 142));
        }
    }

    @Override
    public void func_75132_a(sdcd sdcd2) {
        super.func_75132_a(sdcd2);
        sdcd2.func_71112_a(this, 0, this._a._a());
    }

    @Override
    public void func_75142_b() {
        super.func_75142_b();
        for (int i = 0; i < this.field_75149_d.size(); ++i) {
            sdcd sdcd2 = (sdcd)this.field_75149_d.get(i);
            if (this._c == this._a._a()) continue;
            sdcd2.func_71112_a(this, 0, this._a._a());
        }
        this._c = this._a._a();
    }

    @Override
    public void func_75137_b(int n, int n2) {
        if (n == 0) {
            this._a._b(n2);
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
            if (n >= 0 && n <= 2 || n == 3) {
                if (!this.func_75135_a(cvzo3, 4, 40, true)) {
                    return null;
                }
                yeso2.func_75220_a(cvzo3, cvzo2);
            } else if (!this._b.func_75216_d() && this._b.func_75214_a(cvzo3) ? !this.func_75135_a(cvzo3, 3, 4, false) : (rrag._a(cvzo2) ? !this.func_75135_a(cvzo3, 0, 3, false) : (n >= 4 && n < 31 ? !this.func_75135_a(cvzo3, 31, 40, false) : (n >= 31 && n < 40 ? !this.func_75135_a(cvzo3, 4, 31, false) : !this.func_75135_a(cvzo3, 4, 40, false))))) {
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
}

