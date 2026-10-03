/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;

public class pibn
extends zwat {
    public EntityCreature _a;
    public EntityLivingBase _b;
    public double _c;
    public double _d;
    public double _e;
    public double _f;
    public float _g;

    public pibn(EntityCreature entityCreature, double d, float f) {
        this._a = entityCreature;
        this._f = d;
        this._g = f;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        this._b = this._a.func_70638_az();
        if (this._b == null) {
            return false;
        }
        if (this._b.func_70068_e(this._a) > (double)(this._g * this._g)) {
            return false;
        }
        ofbx ofbx2 = ofaz._a(this._a, 16, 7, this._a.field_70170_p.func_82732_R()._a(this._b.field_70165_t, this._b.field_70163_u, this._b.field_70161_v));
        if (ofbx2 == null) {
            return false;
        }
        this._c = ofbx2._c;
        this._d = ofbx2._d;
        this._e = ofbx2._e;
        return true;
    }

    @Override
    public boolean func_75253_b() {
        return !this._a.func_70661_as()._g() && this._b.func_70089_S() && this._b.func_70068_e(this._a) < (double)(this._g * this._g);
    }

    @Override
    public void func_75251_c() {
        this._b = null;
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._a(this._c, this._d, this._e, this._f);
    }
}

