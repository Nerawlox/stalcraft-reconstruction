/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.hank;

public class EntityExpBottle
extends EntityThrowable {
    public EntityExpBottle(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityExpBottle(ozlu ozlu2, EntityLivingBase entityLivingBase) {
        super(ozlu2, entityLivingBase);
    }

    public EntityExpBottle(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
    }

    @Override
    public float func_70185_h() {
        return 0.07f;
    }

    @Override
    public float func_70182_d() {
        return 0.7f;
    }

    @Override
    public float func_70183_g() {
        return -20.0f;
    }

    @Override
    public void func_70184_a(hank hank2) {
        if (!this.field_70170_p.field_72995_K) {
            int n;
            this.field_70170_p.func_72926_e(2002, (int)Math.round(this.field_70165_t), (int)Math.round(this.field_70163_u), (int)Math.round(this.field_70161_v), 0);
            for (int i = 3 + this.field_70170_p.field_73012_v.nextInt(5) + this.field_70170_p.field_73012_v.nextInt(5); i > 0; i -= n) {
                n = EntityXPOrb.func_70527_a(i);
                this.field_70170_p.func_72838_d(new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, n));
            }
            this.func_70106_y();
        }
    }
}

