/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.amww;
import net.minecraft.entity.player.EntityPlayer;

public class pkyo
extends yeso {
    public final sdcl _a;
    public EntityPlayer _b;
    public int _c;
    public final amww _d;

    public pkyo(EntityPlayer entityPlayer, amww amww2, sdcl sdcl2, int n, int n2, int n3) {
        super(sdcl2, n, n2, n3);
        this._b = entityPlayer;
        this._d = amww2;
        this._a = sdcl2;
    }

    @Override
    public boolean func_75214_a(cvzo cvzo2) {
        return false;
    }

    @Override
    public cvzo func_75209_a(int n) {
        if (this.func_75216_d()) {
            this._c += Math.min(n, this.func_75211_c()._b);
        }
        return super.func_75209_a(n);
    }

    @Override
    public void func_75210_a(cvzo cvzo2, int n) {
        this._c += n;
        this.func_75208_c(cvzo2);
    }

    @Override
    public void func_75208_c(cvzo cvzo2) {
        cvzo2._a(this._b.field_70170_p, this._b, this._c);
        this._c = 0;
    }

    @Override
    public void func_82870_a(EntityPlayer entityPlayer, cvzo cvzo2) {
        cvzo cvzo3;
        cvzo cvzo4;
        this.func_75208_c(cvzo2);
        ozjk ozjk2 = this._a._b();
        if (ozjk2 != null && (this._a(ozjk2, cvzo4 = this._a.func_70301_a(0), cvzo3 = this._a.func_70301_a(1)) || this._a(ozjk2, cvzo3, cvzo4))) {
            this._d.func_70933_a(ozjk2);
            if (cvzo4 != null && cvzo4._b <= 0) {
                cvzo4 = null;
            }
            if (cvzo3 != null && cvzo3._b <= 0) {
                cvzo3 = null;
            }
            this._a.func_70299_a(0, cvzo4);
            this._a.func_70299_a(1, cvzo3);
        }
    }

    public boolean _a(ozjk ozjk2, cvzo cvzo2, cvzo cvzo3) {
        cvzo cvzo4 = ozjk2._a();
        cvzo cvzo5 = ozjk2._b();
        if (cvzo2 != null && cvzo2._d == cvzo4._d) {
            if (cvzo5 != null && cvzo3 != null && cvzo5._d == cvzo3._d) {
                cvzo2._b -= cvzo4._b;
                cvzo3._b -= cvzo5._b;
                return true;
            }
            if (cvzo5 == null && cvzo3 == null) {
                cvzo2._b -= cvzo4._b;
                return true;
            }
        }
        return false;
    }
}

