/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import net.minecraft.entity.player.EntityPlayer;

public class ezey
implements mssh {
    private cvzo[] _b;
    public EntityPlayer _a;
    private int _c;

    public ezey(int n, EntityPlayer entityPlayer) {
        this._b = new cvzo[n];
        this._a = entityPlayer;
        this._c = n;
    }

    @Override
    public int func_70302_i_() {
        return this._c;
    }

    @Override
    public cvzo func_70301_a(int n) {
        return this._b[n];
    }

    @Override
    public cvzo func_70298_a(int n, int n2) {
        if (this._b[n] != null) {
            if (this._b[n]._b <= n2) {
                cvzo cvzo2 = this._b[n];
                this._b[n] = null;
                this.func_70296_d();
                return cvzo2;
            }
            cvzo cvzo3 = this._b[n]._a(n2);
            if (this._b[n]._b == 0) {
                this._b[n] = null;
            }
            this.func_70296_d();
            return cvzo3;
        }
        return null;
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
        this.func_70296_d();
    }

    @Override
    public String func_70303_b() {
        return "Trade";
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
        InvokeSideOnly.frontend(!this._a.field_70170_p.field_72995_K, () -> {});
    }

    @Override
    public boolean func_70300_a(EntityPlayer entityPlayer) {
        return entityPlayer == this._a;
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

