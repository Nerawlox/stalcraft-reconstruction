/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.zwat;

public class sajh
extends zwat {
    public ozlu _a;
    public EntityLiving _b;
    public EntityLivingBase _c;
    public int _d;

    public sajh(EntityLiving entityLiving) {
        this._b = entityLiving;
        this._a = entityLiving.field_70170_p;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        EntityLivingBase entityLivingBase = this._b.func_70638_az();
        if (entityLivingBase == null) {
            return false;
        }
        this._c = entityLivingBase;
        return true;
    }

    @Override
    public boolean func_75253_b() {
        if (!this._c.func_70089_S()) {
            return false;
        }
        if (this._b.func_70068_e(this._c) > 225.0) {
            return false;
        }
        return !this._b.func_70661_as()._g() || this.func_75250_a();
    }

    @Override
    public void func_75251_c() {
        this._c = null;
        this._b.func_70661_as()._h();
    }

    @Override
    public void func_75246_d() {
        this._b.func_70671_ap()._a(this._c, 30.0f, 30.0f);
        double d = this._b.field_70130_N * 2.0f * (this._b.field_70130_N * 2.0f);
        double d2 = this._b.func_70092_e(this._c.field_70165_t, this._c.field_70121_D._c, this._c.field_70161_v);
        double d3 = 0.8;
        if (d2 > d && d2 < 16.0) {
            d3 = 1.33;
        } else if (d2 < 225.0) {
            d3 = 0.6;
        }
        this._b.func_70661_as()._a(this._c, d3);
        this._d = Math.max(this._d - 1, 0);
        if (d2 > d) {
            return;
        }
        if (this._d > 0) {
            return;
        }
        this._d = 20;
        this._b.func_70652_k(this._c);
    }
}

