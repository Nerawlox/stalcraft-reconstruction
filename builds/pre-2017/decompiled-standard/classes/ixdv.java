/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class ixdv
extends jjgc {
    public vmyb _a;
    public final jjil _b;
    public int _c;
    public int _d;
    public int _e;

    public ixdv(eidj eidj2, vmyb vmyb2) {
        int n;
        this._a = vmyb2;
        this._b = new jjil(this, vmyb2, 0, 136, 110);
        this.func_75146_a(this._b);
        int n2 = 36;
        int n3 = 137;
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.func_75146_a(new yeso(eidj2, i + n * 9 + 9, n2 + i * 18, n3 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.func_75146_a(new yeso(eidj2, n, n2 + n * 18, 58 + n3));
        }
        this._c = vmyb2._f();
        this._d = vmyb2._d();
        this._e = vmyb2._e();
    }

    @Override
    public void func_75132_a(sdcd sdcd2) {
        super.func_75132_a(sdcd2);
        sdcd2.func_71112_a(this, 0, this._c);
        sdcd2.func_71112_a(this, 1, this._d);
        sdcd2.func_71112_a(this, 2, this._e);
    }

    @Override
    public void func_75137_b(int n, int n2) {
        if (n == 0) {
            this._a._a(n2);
        }
        if (n == 1) {
            this._a._b(n2);
        }
        if (n == 2) {
            this._a._c(n2);
        }
    }

    public vmyb _a() {
        return this._a;
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
            if (n == 0) {
                if (!this.func_75135_a(cvzo3, 1, 37, true)) {
                    return null;
                }
                yeso2.func_75220_a(cvzo3, cvzo2);
            } else if (!this._b.func_75216_d() && this._b.func_75214_a(cvzo3) && cvzo3._b == 1 ? !this.func_75135_a(cvzo3, 0, 1, false) : (n >= 1 && n < 28 ? !this.func_75135_a(cvzo3, 28, 37, false) : (n >= 28 && n < 37 ? !this.func_75135_a(cvzo3, 1, 28, false) : !this.func_75135_a(cvzo3, 1, 37, false)))) {
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

