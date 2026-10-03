/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.zwat;

public class tdmn
extends zwat {
    public EntityLiving _a;
    public double _b;
    public double _c;
    public int _d;

    public tdmn(EntityLiving entityLiving) {
        this._a = entityLiving;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        return this._a.func_70681_au().nextFloat() < 0.02f;
    }

    @Override
    public boolean func_75253_b() {
        return this._d >= 0;
    }

    @Override
    public void func_75249_e() {
        double d = Math.PI * 2 * this._a.func_70681_au().nextDouble();
        this._b = Math.cos(d);
        this._c = Math.sin(d);
        this._d = 20 + this._a.func_70681_au().nextInt(20);
    }

    @Override
    public void func_75246_d() {
        --this._d;
        this._a.func_70671_ap()._a(this._a.field_70165_t + this._b, this._a.field_70163_u + (double)this._a.func_70047_e(), this._a.field_70161_v + this._c, 10.0f, this._a.func_70646_bf());
    }
}

