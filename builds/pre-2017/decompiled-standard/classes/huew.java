/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;

public class huew
implements mssh {
    public String _a;
    public mssh _b;
    public mssh _c;

    public huew(String string, mssh mssh2, mssh mssh3) {
        this._a = string;
        if (mssh2 == null) {
            mssh2 = mssh3;
        }
        if (mssh3 == null) {
            mssh3 = mssh2;
        }
        this._b = mssh2;
        this._c = mssh3;
    }

    @Override
    public int func_70302_i_() {
        return this._b.func_70302_i_() + this._c.func_70302_i_();
    }

    public boolean _a(mssh mssh2) {
        return this._b == mssh2 || this._c == mssh2;
    }

    @Override
    public String func_70303_b() {
        if (this._b.func_94042_c()) {
            return this._b.func_70303_b();
        }
        if (this._c.func_94042_c()) {
            return this._c.func_70303_b();
        }
        return this._a;
    }

    @Override
    public boolean func_94042_c() {
        return this._b.func_94042_c() || this._c.func_94042_c();
    }

    @Override
    public cvzo func_70301_a(int n) {
        if (n >= this._b.func_70302_i_()) {
            return this._c.func_70301_a(n - this._b.func_70302_i_());
        }
        return this._b.func_70301_a(n);
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (n >= this._b.func_70302_i_()) {
            return this._c.func_70298_a(n - this._b.func_70302_i_(), n2);
        }
        return this._b.func_70298_a(n, n2);
    }

    @Override
    public cvzo func_70304_b(int n) {
        if (n >= this._b.func_70302_i_()) {
            return this._c.func_70304_b(n - this._b.func_70302_i_());
        }
        return this._b.func_70304_b(n);
    }

    @Override
    public void func_70299_a(int n, cvzo cvzo2) {
        if (n >= this._b.func_70302_i_()) {
            this._c.func_70299_a(n - this._b.func_70302_i_(), cvzo2);
        } else {
            this._b.func_70299_a(n, cvzo2);
        }
    }

    @Override
    public int func_70297_j_() {
        return 10000;
    }

    @Override
    public void func_70296_d() {
        this._b.func_70296_d();
        this._c.func_70296_d();
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return this._b.func_70300_a(entityPlayer) && this._c.func_70300_a(entityPlayer);
    }

    @Override
    public void func_70295_k_() {
        this._b.func_70295_k_();
        this._c.func_70295_k_();
    }

    @Override
    public void func_70305_f() {
        this._b.func_70305_f();
        this._c.func_70305_f();
    }

    @Override
    public boolean func_94041_b(int n, cvzo cvzo2) {
        return true;
    }
}

