/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.util.sajh;

public class ugqi
extends zwat {
    public EntityTameable _a;
    public EntityLivingBase _b;
    public ozlu _c;
    public double _d;
    public ujuz _e;
    public int _f;
    public float _g;
    public float _h;
    public boolean _i;

    public ugqi(EntityTameable entityTameable, double d, float f, float f2) {
        this._a = entityTameable;
        this._c = entityTameable.field_70170_p;
        this._d = d;
        this._e = entityTameable.func_70661_as();
        this._h = f;
        this._g = f2;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        EntityLivingBase entityLivingBase = this._a.func_130012_q();
        if (entityLivingBase == null) {
            return false;
        }
        if (this._a.func_70906_o()) {
            return false;
        }
        if (this._a.func_70068_e(entityLivingBase) < (double)(this._h * this._h)) {
            return false;
        }
        this._b = entityLivingBase;
        return true;
    }

    @Override
    public boolean func_75253_b() {
        return !this._e._g() && this._a.func_70068_e(this._b) > (double)(this._g * this._g) && !this._a.func_70906_o();
    }

    @Override
    public void func_75249_e() {
        this._f = 0;
        this._i = this._a.func_70661_as()._a();
        this._a.func_70661_as()._a(false);
    }

    @Override
    public void func_75251_c() {
        this._b = null;
        this._e._h();
        this._a.func_70661_as()._a(this._i);
    }

    @Override
    public void func_75246_d() {
        this._a.func_70671_ap()._a(this._b, 10.0f, (float)this._a.func_70646_bf());
        if (this._a.func_70906_o()) {
            return;
        }
        if (--this._f > 0) {
            return;
        }
        this._f = 10;
        if (this._e._a(this._b, this._d)) {
            return;
        }
        if (this._a.func_110167_bD()) {
            return;
        }
        if (this._a.func_70068_e(this._b) < 144.0) {
            return;
        }
        int n = sajh._c(this._b.field_70165_t) - 2;
        int n2 = sajh._c(this._b.field_70161_v) - 2;
        int n3 = sajh._c(this._b.field_70121_D._c);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 4; ++j) {
                if (i >= 1 && j >= 1 && i <= 3 && j <= 3 || !this._c.func_72797_t(n + i, n3 - 1, n2 + j) || this._c.func_72809_s(n + i, n3, n2 + j) || this._c.func_72809_s(n + i, n3 + 1, n2 + j)) continue;
                this._a.func_70012_b((float)(n + i) + 0.5f, n3, (float)(n2 + j) + 0.5f, this._a.field_70177_z, this._a.field_70125_A);
                this._e._h();
                return;
            }
        }
    }
}

