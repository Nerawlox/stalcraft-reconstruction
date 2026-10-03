/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public class EntityMinecartEmpty
extends EntityMinecart {
    public EntityMinecartEmpty(World world) {
        super(world);
    }

    public EntityMinecartEmpty(World world, double d, double d2, double d3) {
        super(world, d, d2, d3);
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        if (MinecraftForge.EVENT_BUS.post(new MinecartInteractEvent(this, entityPlayer))) {
            return true;
        }
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != entityPlayer) {
            return true;
        }
        if (this.riddenByEntity != null && this.riddenByEntity != entityPlayer) {
            return false;
        }
        if (!this.worldObj.isRemote) {
            entityPlayer.mountEntity(this);
        }
        return true;
    }

    @Override
    public int getMinecartType() {
        return 0;
    }
}

