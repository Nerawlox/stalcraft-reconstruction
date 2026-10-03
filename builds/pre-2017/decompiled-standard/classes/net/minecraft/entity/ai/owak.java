/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;

public class owak
extends zwat {
    public EntityIronGolem _a;
    public EntityVillager _b;
    public int _c;

    public owak(EntityIronGolem entityIronGolem) {
        this._a = entityIronGolem;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        if (!this._a.field_70170_p.func_72935_r()) {
            return false;
        }
        if (this._a.func_70681_au().nextInt(8000) != 0) {
            return false;
        }
        this._b = (EntityVillager)this._a.field_70170_p.func_72857_a(EntityVillager.class, this._a.field_70121_D._b(6.0, 2.0, 6.0), this._a);
        return this._b != null;
    }

    @Override
    public boolean func_75253_b() {
        return this._c > 0;
    }

    @Override
    public void func_75249_e() {
        this._c = 400;
        this._a.func_70851_e(true);
    }

    @Override
    public void func_75251_c() {
        this._a.func_70851_e(false);
        this._b = null;
    }

    @Override
    public void func_75246_d() {
        this._a.func_70671_ap()._a(this._b, 30.0f, 30.0f);
        --this._c;
    }
}

