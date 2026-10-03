/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;

public class EntityEgg
extends EntityThrowable {
    public EntityEgg(ozlu ozlu2) {
        super(ozlu2);
    }

    public EntityEgg(ozlu ozlu2, EntityLivingBase entityLivingBase) {
        super(ozlu2, entityLivingBase);
    }

    public EntityEgg(ozlu ozlu2, double d, double d2, double d3) {
        super(ozlu2, d, d2, d3);
    }

    @Override
    public void func_70184_a(hank hank2) {
        int n;
        if (hank2._i != null) {
            hank2._i.func_70097_a(jxtc.func_76356_a(this, this.func_85052_h()), 0.0f);
        }
        if (!this.field_70170_p.field_72995_K && this.field_70146_Z.nextInt(8) == 0) {
            n = 1;
            if (this.field_70146_Z.nextInt(32) == 0) {
                n = 4;
            }
            for (int i = 0; i < n; ++i) {
                EntityChicken entityChicken = new EntityChicken(this.field_70170_p);
                entityChicken.func_70873_a(-24000);
                entityChicken.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, 0.0f);
                this.field_70170_p.func_72838_d(entityChicken);
            }
        }
        for (n = 0; n < 8; ++n) {
            this.field_70170_p.func_72869_a("snowballpoof", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0);
        }
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }
}

