/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;
import net.minecraft.util.zwaw;

public class amxi
extends zwat {
    public EntityCreature _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;

    public amxi(EntityCreature entityCreature, double d) {
        this._a = entityCreature;
        this._e = d;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (this._a.func_110173_bK()) {
            return false;
        }
        zwaw zwaw2 = this._a.func_110172_bL();
        ofbx ofbx2 = ofaz._a(this._a, 16, 7, this._a.field_70170_p.func_82732_R()._a(zwaw2._a, zwaw2._b, zwaw2._c));
        if (ofbx2 == null) {
            return false;
        }
        this._b = ofbx2._c;
        this._c = ofbx2._d;
        this._d = ofbx2._e;
        return true;
    }

    @Override
    public boolean func_75253_b() {
        return !this._a.func_70661_as()._g();
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._a(this._b, this._c, this._d, this._e);
    }
}

