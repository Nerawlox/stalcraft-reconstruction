/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityLeashKnot
extends EntityHanging {
    public EntityLeashKnot(World world) {
        super(world);
    }

    public EntityLeashKnot(World world, int n, int n2, int n3) {
        super(world, n, n2, n3, 0);
        this.setPosition((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5);
    }

    @Override
    public void entityInit() {
        super.entityInit();
    }

    @Override
    public void setDirection(int n) {
    }

    @Override
    public int getWidthPixels() {
        return 9;
    }

    @Override
    public int getHeightPixels() {
        return 9;
    }

    @Override
    public boolean isInRangeToRenderDist(double d) {
        return d < 1024.0;
    }

    @Override
    public void onBroken(Entity entity) {
    }

    @Override
    public boolean writeToNBTOptional(NBTTagCompound nBTTagCompound) {
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        List list2;
        double d;
        ItemStack itemStack = entityPlayer.getHeldItem();
        boolean bl = false;
        if (itemStack != null && itemStack._d == Item.leash.itemID && !this.worldObj.isRemote) {
            d = 7.0;
            list2 = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB._a()._a(this.posX - d, this.posY - d, this.posZ - d, this.posX + d, this.posY + d, this.posZ + d));
            if (list2 != null) {
                for (EntityLiving entityLiving : list2) {
                    if (!entityLiving.getLeashed() || entityLiving.getLeashedToEntity() != entityPlayer) continue;
                    entityLiving.setLeashedToEntity(this, true);
                    bl = true;
                }
            }
        }
        if (!this.worldObj.isRemote && !bl) {
            this.setDead();
            if (entityPlayer.capabilities._d) {
                d = 7.0;
                list2 = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB._a()._a(this.posX - d, this.posY - d, this.posZ - d, this.posX + d, this.posY + d, this.posZ + d));
                if (list2 != null) {
                    for (EntityLiving entityLiving : list2) {
                        if (!entityLiving.getLeashed() || entityLiving.getLeashedToEntity() != this) continue;
                        entityLiving.clearLeashed(true, false);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean onValidSurface() {
        int n = this.worldObj.getBlockId(this.xPosition, this.yPosition, this.zPosition);
        return Block.blocksList[n] != null && Block.blocksList[n].getRenderType() == 11;
    }

    public static EntityLeashKnot func_110129_a(World world, int n, int n2, int n3) {
        EntityLeashKnot entityLeashKnot = new EntityLeashKnot(world, n, n2, n3);
        entityLeashKnot.forceSpawn = true;
        world.spawnEntityInWorld(entityLeashKnot);
        return entityLeashKnot;
    }

    public static EntityLeashKnot getKnotForBlock(World world, int n, int n2, int n3) {
        List list2 = world.getEntitiesWithinAABB(EntityLeashKnot.class, AxisAlignedBB._a()._a((double)n - 1.0, (double)n2 - 1.0, (double)n3 - 1.0, (double)n + 1.0, (double)n2 + 1.0, (double)n3 + 1.0));
        Object var5_5 = null;
        if (list2 != null) {
            for (EntityLeashKnot entityLeashKnot : list2) {
                if (entityLeashKnot.xPosition != n || entityLeashKnot.yPosition != n2 || entityLeashKnot.zPosition != n3) continue;
                return entityLeashKnot;
            }
        }
        return null;
    }
}

