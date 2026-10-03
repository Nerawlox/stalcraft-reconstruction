/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class ofxb
implements mssh {
    public cvzo[] _a;

    public ofxb(int n) {
        this._a = new cvzo[n];
    }

    @Override
    public int func_70302_i_() {
        return this._a.length;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this._a[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this._a[n] != null) {
            if (this._a[n]._b <= n2) {
                cvzo cvzo2 = this._a[n];
                this._a[n] = null;
                return cvzo2;
            }
            cvzo cvzo3 = this._a[n]._a(n2);
            if (this._a[n]._b == 0) {
                this._a[n] = null;
            }
            return cvzo3;
        }
        return null;
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (this._a[n] != null) {
            cvzo cvzo2 = this._a[n];
            this._a[n] = null;
            return cvzo2;
        }
        return null;
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        this._a[n] = cvzo2;
    }

    @Override
    public String func_70303_b() {
        return "StalkerWeapon";
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
    public void func_70296_d() {
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

