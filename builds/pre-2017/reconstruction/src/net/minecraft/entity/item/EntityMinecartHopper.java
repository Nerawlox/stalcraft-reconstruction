/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public class EntityMinecartHopper
extends EntityMinecartContainer
implements sdpc {
    public boolean isBlocked = true;
    public int transferTicker = -1;

    public EntityMinecartHopper(World world) {
        super(world);
    }

    public EntityMinecartHopper(World world, double d, double d2, double d3) {
        super(world, d, d2, d3);
    }

    @Override
    public int getMinecartType() {
        return 5;
    }

    @Override
    public Block getDefaultDisplayTile() {
        return Block.hopperBlock;
    }

    @Override
    public int getDefaultDisplayTileOffset() {
        return 1;
    }

    @Override
    public int getSizeInventory() {
        return 5;
    }

    @Override
    public boolean interactFirst(EntityPlayer entityPlayer) {
        if (MinecraftForge.EVENT_BUS.post(new MinecartInteractEvent(this, entityPlayer))) {
            return true;
        }
        if (!this.worldObj.isRemote) {
            entityPlayer.displayGUIHopperMinecart(this);
        }
        return true;
    }

    @Override
    public void onActivatorRailPass(int n, int n2, int n3, boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = !bl;
        if (bl2 != this.getBlocked()) {
            this.setBlocked(bl2);
        }
    }

    public boolean getBlocked() {
        return this.isBlocked;
    }

    public void setBlocked(boolean bl) {
        this.isBlocked = bl;
    }

    @Override
    public World getWorldObj() {
        return this.worldObj;
    }

    @Override
    public double getXPos() {
        return this.posX;
    }

    @Override
    public double getYPos() {
        return this.posY;
    }

    @Override
    public double getZPos() {
        return this.posZ;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.isEntityAlive() && this.getBlocked()) {
            --this.transferTicker;
            if (!this.canTransfer()) {
                this.setTransferTicker(0);
                if (this.func_96112_aD()) {
                    this.setTransferTicker(4);
                    this.onInventoryChanged();
                }
            }
        }
    }

    public boolean func_96112_aD() {
        if (TileEntityHopper._a(this)) {
            return true;
        }
        List list2 = this.worldObj.selectEntitiesWithinAABB(EntityItem.class, this.boundingBox._b(0.25, 0.0, 0.25), IEntitySelector._a);
        if (list2.size() > 0) {
            TileEntityHopper._a(this, (EntityItem)list2.get(0));
        }
        return false;
    }

    @Override
    public void killMinecart(DamageSource damageSource) {
        super.killMinecart(damageSource);
        this.dropItemWithOffset(Block.hopperBlock.blockID, 1, 0.0f);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("TransferCooldown", this.transferTicker);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.transferTicker = nBTTagCompound._f("TransferCooldown");
    }

    public void setTransferTicker(int n) {
        this.transferTicker = n;
    }

    public boolean canTransfer() {
        return this.transferTicker > 0;
    }
}

