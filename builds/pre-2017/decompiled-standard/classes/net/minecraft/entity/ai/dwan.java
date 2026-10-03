/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class dwan
extends zwat {
    public EntityCreature _a;
    public double _b;
    public suqn _c;
    public ellv _d;
    public boolean _e;
    public List _f = new ArrayList();

    public dwan(EntityCreature entityCreature, double d, boolean bl) {
        this._a = entityCreature;
        this._b = d;
        this._e = bl;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        this._a();
        if (this._e && this._a.field_70170_p.func_72935_r()) {
            return false;
        }
        mtdg mtdg2 = this._a.field_70170_p.field_72982_D._a(sajh._c(this._a.field_70165_t), sajh._c(this._a.field_70163_u), sajh._c(this._a.field_70161_v), 0);
        if (mtdg2 == null) {
            return false;
        }
        this._d = this._a(mtdg2);
        if (this._d == null) {
            return false;
        }
        boolean bl = this._a.func_70661_as()._b();
        this._a.func_70661_as()._b(false);
        this._c = this._a.func_70661_as()._a(this._d._a, this._d._b, this._d._c);
        this._a.func_70661_as()._b(bl);
        if (this._c != null) {
            return true;
        }
        ofbx ofbx2 = ofaz._a(this._a, 10, 7, this._a.field_70170_p.func_82732_R()._a(this._d._a, this._d._b, this._d._c));
        if (ofbx2 == null) {
            return false;
        }
        this._a.func_70661_as()._b(false);
        this._c = this._a.func_70661_as()._a(ofbx2._c, ofbx2._d, ofbx2._e);
        this._a.func_70661_as()._b(bl);
        return this._c != null;
    }

    @Override
    public boolean func_75253_b() {
        if (this._a.func_70661_as()._g()) {
            return false;
        }
        float f = this._a.field_70130_N + 4.0f;
        return this._a.func_70092_e(this._d._a, this._d._b, this._d._c) > (double)(f * f);
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._a(this._c, this._b);
    }

    @Override
    public void func_75251_c() {
        if (this._a.func_70661_as()._g() || this._a.func_70092_e(this._d._a, this._d._b, this._d._c) < 16.0) {
            this._f.add(this._d);
        }
    }

    public ellv _a(mtdg mtdg2) {
        ellv ellv2 = null;
        int n = Integer.MAX_VALUE;
        List list = mtdg2._h();
        for (ellv ellv3 : list) {
            int n2 = ellv3._a(sajh._c(this._a.field_70165_t), sajh._c(this._a.field_70163_u), sajh._c(this._a.field_70161_v));
            if (n2 >= n || this._a(ellv3)) continue;
            ellv2 = ellv3;
            n = n2;
        }
        return ellv2;
    }

    public boolean _a(ellv ellv2) {
        for (ellv ellv3 : this._f) {
            if (ellv2._a != ellv3._a || ellv2._b != ellv3._b || ellv2._c != ellv3._c) continue;
            return true;
        }
        return false;
    }

    public void _a() {
        if (this._f.size() > 15) {
            this._f.remove(0);
        }
    }
}

