/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.sajh;

public class ofbx
extends zwat {
    public EntityVillager _a;
    public EntityVillager _b;
    public ozlu _c;
    public int _d;
    public mtdg _e;

    public ofbx(EntityVillager entityVillager) {
        this._a = entityVillager;
        this._c = entityVillager.field_70170_p;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        if (this._a.func_70874_b() != 0) {
            return false;
        }
        if (this._a.func_70681_au().nextInt(500) != 0) {
            return false;
        }
        this._e = this._c.field_72982_D._a(sajh._c(this._a.field_70165_t), sajh._c(this._a.field_70163_u), sajh._c(this._a.field_70161_v), 0);
        if (this._e == null) {
            return false;
        }
        if (!this._a()) {
            return false;
        }
        Entity entity = this._c.func_72857_a(EntityVillager.class, this._a.field_70121_D._b(8.0, 3.0, 8.0), this._a);
        if (entity == null) {
            return false;
        }
        this._b = (EntityVillager)entity;
        return this._b.func_70874_b() == 0;
    }

    @Override
    public void func_75249_e() {
        this._d = 300;
        this._a.func_70947_e(true);
    }

    @Override
    public void func_75251_c() {
        this._e = null;
        this._b = null;
        this._a.func_70947_e(false);
    }

    @Override
    public boolean func_75253_b() {
        return this._d >= 0 && this._a() && this._a.func_70874_b() == 0;
    }

    @Override
    public void func_75246_d() {
        --this._d;
        this._a.func_70671_ap()._a(this._b, 10.0f, 30.0f);
        if (this._a.func_70068_e(this._b) > 2.25) {
            this._a.func_70661_as()._a(this._b, 0.25);
        } else if (this._d == 0 && this._b.func_70941_o()) {
            this._b();
        }
        if (this._a.func_70681_au().nextInt(35) == 0) {
            this._c.func_72960_a(this._a, (byte)12);
        }
    }

    public boolean _a() {
        if (!this._e._n()) {
            return false;
        }
        int n = (int)((double)this._e._e() * 0.35);
        return this._e._g() < n;
    }

    public void _b() {
        EntityVillager entityVillager = this._a.func_90012_b(this._b);
        this._b.func_70873_a(6000);
        this._a.func_70873_a(6000);
        entityVillager.func_70873_a(-24000);
        entityVillager.func_70012_b(this._a.field_70165_t, this._a.field_70163_u, this._a.field_70161_v, 0.0f, 0.0f);
        this._c.func_72838_d(entityVillager);
        this._c.func_72960_a(entityVillager, (byte)12);
    }
}

