/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.tdpx;

public class EntityDamageSourceIndirect
extends EntityDamageSource {
    public Entity indirectEntity;

    public EntityDamageSourceIndirect(String string, Entity entity, Entity entity2) {
        super(string, entity);
        this.indirectEntity = entity2;
    }

    @Override
    public Entity getSourceOfDamage() {
        return this.damageSourceEntity;
    }

    @Override
    public Entity getEntity() {
        return this.indirectEntity;
    }

    @Override
    public ChatMessageComponent getDeathMessage(EntityLivingBase entityLivingBase) {
        String string = this.indirectEntity == null ? this.damageSourceEntity.getTranslatedEntityName() : this.indirectEntity.getTranslatedEntityName();
        ItemStack itemStack = this.indirectEntity instanceof EntityLivingBase ? ((EntityLivingBase)this.indirectEntity).getHeldItem() : null;
        String string2 = "death.attack." + this.damageType;
        String string3 = string2 + ".item";
        if (itemStack != null && itemStack._u() && tdpx._b(string3)) {
            return ChatMessageComponent._b(string3, entityLivingBase.getTranslatedEntityName(), string, itemStack._s());
        }
        return ChatMessageComponent._b(string2, entityLivingBase.getTranslatedEntityName(), string);
    }
}

