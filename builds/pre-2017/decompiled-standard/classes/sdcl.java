/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.amww;
import net.minecraft.entity.player.EntityPlayer;

public class sdcl
implements mssh {
    public final amww _a;
    public cvzo[] _b = new cvzo[3];
    public final EntityPlayer _c;
    public ozjk _d;
    public int _e;

    public sdcl(EntityPlayer entityPlayer, amww amww2) {
        this._c = entityPlayer;
        this._a = amww2;
    }

    @Override
    public int func_70302_i_() {
        return this._b.length;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this._b[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this._b[n] != null) {
            if (n == 2) {
                cvzo cvzo2 = this._b[n];
                this._b[n] = null;
                return cvzo2;
            }
            if (this._b[n]._b <= n2) {
                cvzo cvzo3 = this._b[n];
                this._b[n] = null;
                if (this._a(n)) {
                    this._a();
                }
                return cvzo3;
            }
            cvzo cvzo4 = this._b[n]._a(n2);
            if (this._b[n]._b == 0) {
                this._b[n] = null;
            }
            if (this._a(n)) {
                this._a();
            }
            return cvzo4;
        }
        return null;
    }

    public boolean _a(int n) {
        return n == 0 || n == 1;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this._b[n] != null) {
            cvzo cvzo2 = this._b[n];
            this._b[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this._b[n] = cvzo2;
        if (cvzo2 != null && cvzo2._b > this.func_70297_j_()) {
            cvzo2._b = this.func_70297_j_();
        }
        if (this._a(n)) {
            this._a();
        }
    }

    @Override
    public String func_70303_b() {
        return "mob.villager";
    }

    @Override
    public boolean func_94042_c() {
        return false;
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return this._a.func_70931_l_() == entityPlayer;
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

    @Override
    public void func_70296_d() {
        this._a();
    }

    public void _a() {
        this._d = null;
        cvzo cvzo2 = this._b[0];
        cvzo cvzo3 = this._b[1];
        if (cvzo2 == null) {
            cvzo2 = cvzo3;
            cvzo3 = null;
        }
        if (cvzo2 == null) {
            this.func_70299_a(2, null);
        } else {
            ywfi ywfi2 = this._a.func_70934_b(this._c);
            if (ywfi2 != null) {
                ozjk ozjk2 = ywfi2._a(cvzo2, cvzo3, this._e);
                if (ozjk2 != null && !ozjk2._f()) {
                    this._d = ozjk2;
                    this.func_70299_a(2, ozjk2._d()._l());
                } else if (cvzo3 != null) {
                    ozjk2 = ywfi2._a(cvzo3, cvzo2, this._e);
                    if (ozjk2 != null && !ozjk2._f()) {
                        this._d = ozjk2;
                        this.func_70299_a(2, ozjk2._d()._l());
                    } else {
                        this.func_70299_a(2, null);
                    }
                } else {
                    this.func_70299_a(2, null);
                }
            }
        }
        this._a.func_110297_a_(this.func_70301_a(2));
    }

    public ozjk _b() {
        return this._d;
    }

    public void _b(int n) {
        this._e = n;
        this._a();
    }
}

