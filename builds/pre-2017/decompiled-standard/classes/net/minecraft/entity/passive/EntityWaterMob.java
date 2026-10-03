/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.jxtc;

public abstract class EntityWaterMob
extends EntityCreature
implements ezey {
    public EntityWaterMob(ozlu ozlu2) {
        super(ozlu2);
    }

    @Override
    public boolean func_70648_aU() {
        return true;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_72855_b(this.field_70121_D);
    }

    @Override
    public int func_70627_aG() {
        return 120;
    }

    @Override
    public boolean func_70692_ba() {
        return true;
    }

    @Override
    public int func_70693_a(EntityPlayer entityPlayer) {
        return 1 + this.field_70170_p.field_73012_v.nextInt(3);
    }

    @Override
    public void func_70030_z() {
        int n = this.func_70086_ai();
        super.func_70030_z();
        if (this.func_70089_S() && !this.func_70090_H()) {
            this.func_70050_g(--n);
            if (this.func_70086_ai() == -20) {
                this.func_70050_g(0);
                this.func_70097_a(jxtc.field_76369_e, 2.0f);
            }
        } else {
            this.func_70050_g(300);
        }
    }
}

