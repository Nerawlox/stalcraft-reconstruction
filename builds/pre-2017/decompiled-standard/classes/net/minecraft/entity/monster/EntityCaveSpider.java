/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.sajz;
import net.minecraft.entity.tupg;

public class EntityCaveSpider
extends EntitySpider {
    public EntityCaveSpider(ozlu ozlu2) {
        super(ozlu2);
        this.func_70105_a(0.7f, 0.5f);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(sajz._a)._a(12.0);
    }

    @Override
    public boolean func_70652_k(Entity entity) {
        if (super.func_70652_k(entity)) {
            if (entity instanceof EntityLivingBase) {
                int n = 0;
                if (this.field_70170_p.field_73013_u > 1) {
                    if (this.field_70170_p.field_73013_u == 2) {
                        n = 7;
                    } else if (this.field_70170_p.field_73013_u == 3) {
                        n = 15;
                    }
                }
                if (n > 0) {
                    ((EntityLivingBase)entity).func_70690_d(new supr(hdpq._u._H, n * 20, 0));
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public tupg func_110161_a(tupg tupg2) {
        return tupg2;
    }
}

