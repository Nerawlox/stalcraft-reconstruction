/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.entity;

import atomicstryker.dynamiclights.client.DynamicLights;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.weapon.ugqx;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;

@ezey(_a={eidj.CLIENT})
public class EntityFlashlight
extends Entity {
    private EntityPlayer player;

    public EntityFlashlight(EntityPlayer entityPlayer) {
        super(entityPlayer.worldObj);
        this.player = entityPlayer;
        this.setSize(0.0f, 0.0f);
        this.noClip = true;
        ugqx._a((EntityPlayer)entityPlayer)._m = true;
        this.updatePos();
        DynamicLights.addLightSource(new gpzl(this));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        ugqx ugqx2 = ugqx._a(this.player);
        if (this.player.isDead || this.player.getHealth() <= 0.0f || !ClientProxy.dynamicLights.enabled || !ugqx2._s()) {
            this.setDead();
        } else {
            this.updatePos();
        }
    }

    @Override
    public void setDead() {
        super.setDead();
        ugqx._a((EntityPlayer)this.player)._m = false;
    }

    private void updatePos() {
        MovingObjectPosition movingObjectPosition = ugqx._a(this.player)._h();
        if (movingObjectPosition != null) {
            int n = movingObjectPosition._d;
            int n2 = movingObjectPosition._e;
            int n3 = movingObjectPosition._f;
            if (movingObjectPosition._g == 0) {
                --n2;
            }
            if (movingObjectPosition._g == 1) {
                ++n2;
            }
            if (movingObjectPosition._g == 2) {
                --n3;
            }
            if (movingObjectPosition._g == 3) {
                ++n3;
            }
            if (movingObjectPosition._g == 4) {
                --n;
            }
            if (movingObjectPosition._g == 5) {
                ++n;
            }
            this.setPosition((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5);
        } else {
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

