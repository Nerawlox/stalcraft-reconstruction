/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.sajh;

public class amww
extends zwat {
    public EntityLiving _a;
    public EntityLivingBase _b;
    public float _c;

    public amww(EntityLiving entityLiving, float f) {
        this._a = entityLiving;
        this._c = f;
        this.func_75248_a(5);
    }

    @Override
    public boolean func_75250_a() {
        this._b = this._a.func_70638_az();
        if (this._b == null) {
            return false;
        }
        double d = this._a.func_70068_e(this._b);
        if (d < 4.0 || d > 16.0) {
            return false;
        }
        if (!this._a.field_70122_E) {
            return false;
        }
        return this._a.func_70681_au().nextInt(5) == 0;
    }

    @Override
    public boolean func_75253_b() {
        return !this._a.field_70122_E;
    }

    @Override
    public void func_75249_e() {
        double d = this._b.field_70165_t - this._a.field_70165_t;
        double d2 = this._b.field_70161_v - this._a.field_70161_v;
        float f = sajh._a(d * d + d2 * d2);
        this._a.field_70159_w += d / (double)f * 0.5 * (double)0.8f + this._a.field_70159_w * (double)0.2f;
        this._a.field_70179_y += d2 / (double)f * 0.5 * (double)0.8f + this._a.field_70179_y * (double)0.2f;
        this._a.field_70181_x = this._c;
    }
}

