/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.sajz;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityCaveSpider
extends EntitySpider {
    public EntityCaveSpider(World world) {
        super(world);
        this.setSize(0.7f, 0.5f);
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(12.0);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (entity instanceof EntityLivingBase) {
                int n = 0;
                if (this.worldObj.difficultySetting > 1) {
                    if (this.worldObj.difficultySetting == 2) {
                        n = 7;
                    } else if (this.worldObj.difficultySetting == 3) {
                        n = 15;
                    }
                }
                if (n > 0) {
                    ((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion._u._H, n * 20, 0));
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
        return entityLivingData;
    }
}

