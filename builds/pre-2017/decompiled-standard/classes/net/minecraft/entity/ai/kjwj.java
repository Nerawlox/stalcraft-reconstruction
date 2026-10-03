/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.ofaz;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.ofbx;

public class kjwj
extends zwat {
    public EntityCreature _a;
    public double _b;
    public double _c;
    public double _d;
    public double _e;

    public kjwj(EntityCreature entityCreature, double d) {
        this._a = entityCreature;
        this._b = d;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        if (this._a.func_70643_av() == null && !this._a.func_70027_ad()) {
            return false;
        }
        ofbx ofbx2 = ofaz._a(this._a, 5, 4);
        if (ofbx2 == null) {
            return false;
        }
        this._c = ofbx2._c;
        this._d = ofbx2._d;
        this._e = ofbx2._e;
        return true;
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._a(this._c, this._d, this._e, this._b);
    }

    @Override
    public boolean func_75253_b() {
        return !this._a.func_70661_as()._g();
    }
}

