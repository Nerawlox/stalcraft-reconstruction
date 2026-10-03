/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.List;
import net.minecraft.entity.ai.zwat;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;

public class jxsn
extends zwat {
    public EntityVillager _a;
    public EntityIronGolem _b;
    public int _c;
    public boolean _d;

    public jxsn(EntityVillager entityVillager) {
        this._a = entityVillager;
        this.func_75248_a(3);
    }

    @Override
    public boolean func_75250_a() {
        if (this._a.func_70874_b() >= 0) {
            return false;
        }
        if (!this._a.field_70170_p.func_72935_r()) {
            return false;
        }
        List list = this._a.field_70170_p.func_72872_a(EntityIronGolem.class, this._a.field_70121_D._b(6.0, 2.0, 6.0));
        if (list.isEmpty()) {
            return false;
        }
        for (EntityIronGolem entityIronGolem : list) {
            if (entityIronGolem.func_70853_p() <= 0) continue;
            this._b = entityIronGolem;
            break;
        }
        return this._b != null;
    }

    @Override
    public boolean func_75253_b() {
        return this._b.func_70853_p() > 0;
    }

    @Override
    public void func_75249_e() {
        this._c = this._a.func_70681_au().nextInt(320);
        this._d = false;
        this._b.func_70661_as()._h();
    }

    @Override
    public void func_75251_c() {
        this._b = null;
        this._a.func_70661_as()._h();
    }

    @Override
    public void func_75246_d() {
        this._a.func_70671_ap()._a(this._b, 30.0f, 30.0f);
        if (this._b.func_70853_p() == this._c) {
            this._a.func_70661_as()._a(this._b, 0.5);
            this._d = true;
        }
        if (this._d && this._a.func_70068_e(this._b) < 4.0) {
            this._b.func_70851_e(false);
            this._a.func_70661_as()._h();
        }
    }
}

