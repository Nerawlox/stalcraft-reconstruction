/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.gomc;
import net.minecraft.util.eidj;

public class ezfa
extends gomc {
    public boolean _a;
    public int _b;

    public ezfa(EntityCreature entityCreature, boolean bl) {
        super(entityCreature, false);
        this._a = bl;
        this.func_75248_a(1);
    }

    @Override
    public boolean func_75250_a() {
        int n = this.field_75299_d.func_142015_aE();
        return n != this._b && this.func_75296_a(this.field_75299_d.func_70643_av(), false);
    }

    @Override
    public void func_75249_e() {
        this.field_75299_d.func_70624_b(this.field_75299_d.func_70643_av());
        this._b = this.field_75299_d.func_142015_aE();
        if (this._a) {
            double d = this.func_111175_f();
            List list2 = this.field_75299_d.field_70170_p.func_72872_a(this.field_75299_d.getClass(), eidj._a()._a(this.field_75299_d.field_70165_t, this.field_75299_d.field_70163_u, this.field_75299_d.field_70161_v, this.field_75299_d.field_70165_t + 1.0, this.field_75299_d.field_70163_u + 1.0, this.field_75299_d.field_70161_v + 1.0)._b(d, 10.0, d));
            for (EntityCreature entityCreature : list2) {
                if (this.field_75299_d == entityCreature || entityCreature.func_70638_az() != null || entityCreature.func_142014_c(this.field_75299_d.func_70643_av())) continue;
                entityCreature.func_70624_b(this.field_75299_d.func_70643_av());
            }
        }
        super.func_75249_e();
    }
}

