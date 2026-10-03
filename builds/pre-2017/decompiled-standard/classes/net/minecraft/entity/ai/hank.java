/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.zwat;
import net.minecraft.util.sajh;

public class hank
extends zwat {
    public EntityCreature _a;
    public ellv _b;

    public hank(EntityCreature entityCreature) {
        this._a = entityCreature;
    }

    @Override
    public boolean func_75250_a() {
        if (this._a.field_70170_p.func_72935_r()) {
            return false;
        }
        mtdg mtdg2 = this._a.field_70170_p.field_72982_D._a(sajh._c(this._a.field_70165_t), sajh._c(this._a.field_70163_u), sajh._c(this._a.field_70161_v), 16);
        if (mtdg2 == null) {
            return false;
        }
        this._b = mtdg2._b(sajh._c(this._a.field_70165_t), sajh._c(this._a.field_70163_u), sajh._c(this._a.field_70161_v));
        if (this._b == null) {
            return false;
        }
        return (double)this._b._b(sajh._c(this._a.field_70165_t), sajh._c(this._a.field_70163_u), sajh._c(this._a.field_70161_v)) < 2.25;
    }

    @Override
    public boolean func_75253_b() {
        if (this._a.field_70170_p.func_72935_r()) {
            return false;
        }
        return !this._b._g && this._b._a(sajh._c(this._a.field_70165_t), sajh._c(this._a.field_70161_v));
    }

    @Override
    public void func_75249_e() {
        this._a.func_70661_as()._b(false);
        this._a.func_70661_as()._c(false);
    }

    @Override
    public void func_75251_c() {
        this._a.func_70661_as()._b(true);
        this._a.func_70661_as()._c(true);
        this._b = null;
    }

    @Override
    public void func_75246_d() {
        this._b._e();
    }
}

