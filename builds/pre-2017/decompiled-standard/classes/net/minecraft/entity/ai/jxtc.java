/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.gomc;
import net.minecraft.entity.monster.EntityIronGolem;

public class jxtc
extends gomc {
    public EntityIronGolem _a;
    public EntityLivingBase _b;

    public jxtc(EntityIronGolem entityIronGolem) {
        super(entityIronGolem, false, true);
        this._a = entityIronGolem;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        mtdg mtdg2 = this._a.func_70852_n();
        if (mtdg2 == null) {
            return false;
        }
        this._b = mtdg2._b(this._a);
        if (!this.func_75296_a(this._b, false)) {
            if (this.field_75299_d.func_70681_au().nextInt(20) == 0) {
                this._b = mtdg2._c(this._a);
                return this.func_75296_a(this._b, false);
            }
            return false;
        }
        return true;
    }

    @Override
    public void func_75249_e() {
        this._a.func_70624_b(this._b);
        super.func_75249_e();
    }
}

