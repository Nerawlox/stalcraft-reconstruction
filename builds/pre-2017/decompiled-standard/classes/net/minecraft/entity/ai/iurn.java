/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;

public class iurn
extends zwat {
    public EntityCreature _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;

    public iurn(EntityCreature entityCreature, double d) {
        this._a = entityCreature;
        this._e = d;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (this._a.func_70654_ax() >= 100) {
            return false;
        }
        if (this._a.func_70681_au().nextInt(120) != 0) {
            return false;
        }
        ofbx ofbx2 = ofaz._a(this._a, 10, 7);
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

