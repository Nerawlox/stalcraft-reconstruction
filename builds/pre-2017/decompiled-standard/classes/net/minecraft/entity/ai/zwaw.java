/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;

public class zwaw
extends zwat {
    public EntityWolf _a;
    public EntityPlayer _b;
    public ozlu _c;
    public float _d;
    public int _e;

    public zwaw(EntityWolf entityWolf, float f) {
        this._a = entityWolf;
        this._c = entityWolf.field_70170_p;
        this._d = f;
        this.func_75248_a(2);
    }

    @Override
    public boolean func_75250_a() {
        this._b = this._c.func_72890_a(this._a, this._d);
        if (this._b == null) {
            return false;
        }
        return this._a(this._b);
    }

    @Override
    public boolean func_75253_b() {
        if (!this._b.func_70089_S()) {
            return false;
        }
        if (this._a.func_70068_e(this._b) > (double)(this._d * this._d)) {
            return false;
        }
        return this._e > 0 && this._a(this._b);
    }

    @Override
    public void func_75249_e() {
        this._a.func_70918_i(true);
        this._e = 40 + this._a.func_70681_au().nextInt(40);
    }

    @Override
    public void func_75251_c() {
        this._a.func_70918_i(false);
        this._b = null;
    }

    @Override
    public void func_75246_d() {
        this._a.func_70671_ap()._a(this._b.field_70165_t, this._b.field_70163_u + (double)this._b.func_70047_e(), this._b.field_70161_v, 10.0f, this._a.func_70646_bf());
        --this._e;
    }

    public boolean _a(EntityPlayer entityPlayer) {
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        if (cvzo2 == null) {
            return false;
        }
        if (!this._a.func_70909_n() && cvzo2._d == tgdv.field_77755_aX.field_77779_bT) {
            return true;
        }
        return this._a.func_70877_b(cvzo2);
    }
}

