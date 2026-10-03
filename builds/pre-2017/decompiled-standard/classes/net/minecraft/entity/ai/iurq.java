/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.player.EntityPlayer;

public class iurq
extends zwat {
    public EntityLiving _b;
    public Entity _c;
    public float _d;
    public int _e;
    public float _f;
    public Class _g;

    public iurq(EntityLiving entityLiving, Class clazz, float f) {
        this._b = entityLiving;
        this._g = clazz;
        this._d = f;
        this._f = 0.02f;
        this.func_75248_a(2);
    }

    public iurq(EntityLiving entityLiving, Class clazz, float f, float f2) {
        this._b = entityLiving;
        this._g = clazz;
        this._d = f;
        this._f = f2;
        this.func_75248_a(2);
    }

    @Override
    public boolean func_75250_a() {
        if (this._b.func_70681_au().nextFloat() >= this._f) {
            return false;
        }
        if (this._b.func_70638_az() != null) {
            this._c = this._b.func_70638_az();
        }
        this._c = this._g == EntityPlayer.class ? this._b.field_70170_p.func_72890_a(this._b, this._d) : this._b.field_70170_p.func_72857_a(this._g, this._b.field_70121_D._b(this._d, 3.0, this._d), this._b);
        return this._c != null;
    }

    @Override
    public boolean func_75253_b() {
        if (!this._c.func_70089_S()) {
            return false;
        }
        if (this._b.func_70068_e(this._c) > (double)(this._d * this._d)) {
            return false;
        }
        return this._e > 0;
    }

    @Override
    public void func_75249_e() {
        this._e = 40 + this._b.func_70681_au().nextInt(40);
    }

    @Override
    public void func_75251_c() {
        this._c = null;
    }

    @Override
    public void func_75246_d() {
        this._b.func_70671_ap()._a(this._c.field_70165_t, this._c.field_70163_u + (double)this._c.func_70047_e(), this._c.field_70161_v, 10.0f, this._b.func_70646_bf());
        --this._e;
    }
}

