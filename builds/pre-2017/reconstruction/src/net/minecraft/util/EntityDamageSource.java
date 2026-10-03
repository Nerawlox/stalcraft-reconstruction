/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.tdpx;

public class EntityDamageSource
extends DamageSource {
    public Entity damageSourceEntity;

    public EntityDamageSource(String string, Entity entity) {
        super(string);
        this.damageSourceEntity = entity;
    }

    @Override
    public Entity getEntity() {
        return this.damageSourceEntity;
    }

    @Override
    public ChatMessageComponent getDeathMessage(EntityLivingBase entityLivingBase) {
        ItemStack itemStack = this.damageSourceEntity instanceof EntityLivingBase ? ((EntityLivingBase)this.damageSourceEntity).getHeldItem() : null;
        String string = "death.attack." + this.damageType;
        String string2 = string + ".item";
        if (itemStack != null && itemStack._u() && tdpx._b(string2)) {
            return ChatMessageComponent._b(string2, entityLivingBase.getTranslatedEntityName(), this.damageSourceEntity.getTranslatedEntityName(), itemStack._s());
        }
        return ChatMessageComponent._b(string, entityLivingBase.getTranslatedEntityName(), this.damageSourceEntity.getTranslatedEntityName());
    }

    @Override
    public boolean isDifficultyScaled() {
        return this.damageSourceEntity != null && this.damageSourceEntity instanceof EntityLivingBase && !(this.damageSourceEntity instanceof EntityPlayer);
    }
}

