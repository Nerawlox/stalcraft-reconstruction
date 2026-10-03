/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.player.EntityPlayer;

public class ezhm
extends zwat {
    public EntityCreature _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;
    public double _f;
    public double _g;
    public EntityPlayer _h;
    public int _i;
    public boolean _j;
    public int _k;
    public boolean _l;
    public boolean _m;

    public ezhm(EntityCreature entityCreature, double d, int n, boolean bl) {
        this._a = entityCreature;
        this._b = d;
        this._k = n;
        this._l = bl;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        if (this._i > 0) {
            --this._i;
            return false;
        }
        this._h = this._a.field_70170_p.func_72890_a(this._a, 10.0);
        if (this._h == null) {
            return false;
        }
        cvzo cvzo2 = this._h.func_71045_bC();
        if (cvzo2 == null) {
            return false;
        }
        return cvzo2._d == this._k;
    }

    @Override
    public boolean func_75253_b() {
        if (this._l) {
            if (this._a.func_70068_e(this._h) < 36.0) {
                if (this._h.func_70092_e(this._c, this._d, this._e) > 0.010000000000000002) {
                    return false;
                }
                if (Math.abs((double)this._h.field_70125_A - this._f) > 5.0 || Math.abs((double)this._h.field_70177_z - this._g) > 5.0) {
                    return false;
                }
            } else {
                this._c = this._h.field_70165_t;
                this._d = this._h.field_70163_u;
                this._e = this._h.field_70161_v;
            }
            this._f = this._h.field_70125_A;
            this._g = this._h.field_70177_z;
        }
        return this.func_75250_a();
    }

    @Override
    public void func_75249_e() {
        this._c = this._h.field_70165_t;
        this._d = this._h.field_70163_u;
        this._e = this._h.field_70161_v;
        this._j = true;
        this._m = this._a.func_70661_as()._a();
        this._a.func_70661_as()._a(false);
    }

    @Override
    public void func_75251_c() {
        this._h = null;
        this._a.func_70661_as()._h();
        this._i = 100;
        this._j = false;
        this._a.func_70661_as()._a(this._m);
    }

    @Override
    public void func_75246_d() {
        this._a.func_70671_ap()._a(this._h, 30.0f, (float)this._a.func_70646_bf());
        if (this._a.func_70068_e(this._h) < 6.25) {
            this._a.func_70661_as()._h();
        } else {
            this._a.func_70661_as()._a(this._h, this._b);
        }
    }

    public boolean _a() {
        return this._j;
    }
}

