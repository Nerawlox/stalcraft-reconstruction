/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly.entity;

import atomicstryker.dynamiclights.client.DynamicLights;
import gloomyfolken.mods.anomaly.tupg;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;

public class EntityLighterLight
extends Entity {
    public ivaa tile;

    public EntityLighterLight(ivaa ivaa2) {
        super(ivaa2.worldObj);
        this.tile = ivaa2;
        this.setSize(0.0f, 0.0f);
        this.noClip = true;
        this.setPosition((double)ivaa2.xCoord + 0.5, (double)ivaa2.yCoord + 0.5, (double)ivaa2.zCoord + 0.5);
        DynamicLights.addLightSource(new tupg(this));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.tile.isInvalid() || this.tile._c <= 0) {
            this.setDead();
        }
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }
}

