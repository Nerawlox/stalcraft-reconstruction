/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.eidj;

public class lplm
extends jjgc {
    public nwgz _a;
    public int _b;
    public int _c;
    public int _d;

    public lplm(eidj eidj2, nwgz nwgz2) {
        int n;
        this._a = nwgz2;
        this.func_75146_a(new yeso(nwgz2, 0, 56, 17));
        this.func_75146_a(new yeso(nwgz2, 1, 56, 53));
        this.func_75146_a(new ohwi(eidj2._e, nwgz2, 2, 116, 35));
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
        sdcd2.func_71112_a(this, 0, this._a._g);
        sdcd2.func_71112_a(this, 1, this._a._e);
        sdcd2.func_71112_a(this, 2, this._a._f);
    }

    @Override
    public void func_75142_b() {
        super.func_75142_b();
        for (int i = 0; i < this.field_75149_d.size(); ++i) {
            sdcd sdcd2 = (sdcd)this.field_75149_d.get(i);
            if (this._b != this._a._g) {
                sdcd2.func_71112_a(this, 0, this._a._g);
            }
            if (this._c != this._a._e) {
                sdcd2.func_71112_a(this, 1, this._a._e);
            }
            if (this._d == this._a._f) continue;
            sdcd2.func_71112_a(this, 2, this._a._f);
        }
        this._b = this._a._g;
        this._c = this._a._e;
        this._d = this._a._f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_75137_b(int n, int n2) {
        if (n == 0) {
            this._a._g = n2;
        }
        if (n == 1) {
            this._a._e = n2;
        }
        if (n == 2) {
            this._a._f = n2;
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
            if (n == 2) {
                if (!this.func_75135_a(cvzo3, 3, 39, true)) {
                    return null;
                }
                yeso2.func_75220_a(cvzo3, cvzo2);
            } else if (n != 1 && n != 0 ? (yewu._a()._a(cvzo3) != null ? !this.func_75135_a(cvzo3, 0, 1, false) : (nwgz._b(cvzo3) ? !this.func_75135_a(cvzo3, 1, 2, false) : (n >= 3 && n < 30 ? !this.func_75135_a(cvzo3, 30, 39, false) : n >= 30 && n < 39 && !this.func_75135_a(cvzo3, 3, 30, false)))) : !this.func_75135_a(cvzo3, 3, 39, false)) {
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

