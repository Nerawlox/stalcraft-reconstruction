/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class tgfo
implements mssh {
    public String _b;
    public int _c;
    public cvzo[] _d;
    public List _e;
    public boolean _f;

    public tgfo(String string, boolean bl, int n) {
        this._b = string;
        this._f = bl;
        this._c = n;
        this._d = new cvzo[n];
    }

    public void _a(suea suea2) {
        if (this._e == null) {
            this._e = new ArrayList();
        }
        this._e.add(suea2);
    }

    public void _b(suea suea2) {
        this._e.remove(suea2);
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this._d[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this._d[n] != null) {
            if (this._d[n]._b <= n2) {
                cvzo cvzo2 = this._d[n];
                this._d[n] = null;
                this.func_70296_d();
                return cvzo2;
            }
            cvzo cvzo3 = this._d[n]._a(n2);
            if (this._d[n]._b == 0) {
                this._d[n] = null;
            }
            this.func_70296_d();
            return cvzo3;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this._d[n] != null) {
            cvzo cvzo2 = this._d[n];
            this._d[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this._d[n] = cvzo2;
        if (cvzo2 != null && cvzo2._b > this.func_70297_j_()) {
            cvzo2._b = this.func_70297_j_();
        }
        this.func_70296_d();
    }

    @Override
    public int func_70302_i_() {
        return this._c;
    }

    @Override
    public String func_70303_b() {
        return this._b;
    }

    @Override
    public boolean func_94042_c() {
        return this._f;
    }

    public void _a(String string) {
        this._f = true;
        this._b = string;
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
        if (this._e != null) {
            for (int i = 0; i < this._e.size(); ++i) {
                ((suea)this._e.get(i)).func_76316_a(this);
            }
        }
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void func_70295_k_() {
    }

    @Override
    public void func_70305_f() {
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }
}

