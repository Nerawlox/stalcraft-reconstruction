/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class jxtc
implements IEntitySelector {
    public final ItemStack _c;

    public jxtc(ItemStack itemStack) {
        this._c = itemStack;
    }

    @Override
    public boolean isEntityApplicable(Entity entity) {
        if (!entity.isEntityAlive()) {
            return false;
        }
        if (!(entity instanceof EntityLivingBase)) {
            return false;
        }
        EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
        if (entityLivingBase.func_71124_b(EntityLiving.getArmorPosition(this._c)) != null) {
            return false;
        }
        if (entityLivingBase instanceof EntityLiving) {
            return ((EntityLiving)entityLivingBase).canPickUpLoot();
        }
        return entityLivingBase instanceof EntityPlayer;
    }
}

