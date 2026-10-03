/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ezfa;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;

public class EntityDragonPart
extends Entity {
    public final ezfa entityDragonObj;
    public final String name;

    public EntityDragonPart(ezfa ezfa2, String string, float f, float f2) {
        super(ezfa2.func_82194_d());
        this.setSize(f, f2);
        this.entityDragonObj = ezfa2;
        this.name = string;
    }

    @Override
    public void entityInit() {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        return this.entityDragonObj.attackEntityFromPart(this, damageSource, f);
    }

    @Override
    public boolean isEntityEqual(Entity entity) {
        return this == entity || this.entityDragonObj == entity;
    }
}

