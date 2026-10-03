/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityCustomChest
extends TileEntity
implements IInventory {
    private ItemStack[] chestContents = new ItemStack[27];
    public float lidAngle;
    public float prevLidAngle;
    public int numUsingPlayers;
    private int ticksSinceSync;
    private int cachedChestType;
    private String customName;

    public TileEntityCustomChest() {
        this.cachedChestType = -1;
    }

    @SideOnly(value=Side.CLIENT)
    public TileEntityCustomChest(int n) {
        this.cachedChestType = n;
    }

    @Override
    public int getSizeInventory() {
        return 27;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this.chestContents[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this.chestContents[n] != null) {
            if (this.chestContents[n]._b <= n2) {
                ItemStack itemStack = this.chestContents[n];
                this.chestContents[n] = null;
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this.chestContents[n]._a(n2);
            if (this.chestContents[n]._b == 0) {
                this.chestContents[n] = null;
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this.chestContents[n] != null) {
            ItemStack itemStack = this.chestContents[n];
            this.chestContents[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this.chestContents[n] = itemStack;
        if (itemStack != null && itemStack._b > this.getInventoryStackLimit()) {
            itemStack._b = this.getInventoryStackLimit();
        }
        this.onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return this.isInvNameLocalized() ? this.customName : "\u0413\u043e\u043b\u0443\u0431\u043e\u0439 \u0448\u043a\u0430\u0444";
    }

    @Override
    public boolean isInvNameLocalized() {
        return this.customName != null && this.customName.length() > 0;
    }

    public void setChestGuiName(String string) {
        this.customName = string;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityPlayer.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) <= 64.0;
    }

    private boolean func_94044_a(int n, int n2, int n3) {
        Block block = Block.blocksList[this.worldObj.getBlockId(n, n2, n3)];
        return block != null && block instanceof BlockChest ? ((BlockChest)block)._b == this.getChestType() : false;
    }

    @Override
    public void updateEntity() {
        float f;
        super.updateEntity();
        ++this.ticksSinceSync;
        if (!this.worldObj.isRemote && this.numUsingPlayers != 0 && (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0) {
            this.numUsingPlayers = 0;
            f = 5.0f;
            List list2 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB._a()._a((float)this.xCoord - f, (float)this.yCoord - f, (float)this.zCoord - f, (float)(this.xCoord + 1) + f, (float)(this.yCoord + 1) + f, (float)(this.zCoord + 1) + f));
            for (EntityPlayer entityPlayer : list2) {
                IInventory iInventory;
                if (!(entityPlayer.openContainer instanceof wpkx) || (iInventory = ((wpkx)entityPlayer.openContainer)._a()) != this && (!(iInventory instanceof huew) || !((huew)iInventory)._a(this))) continue;
                ++this.numUsingPlayers;
            }
        }
        this.prevLidAngle = this.lidAngle;
        f = 0.1f;
        if (this.numUsingPlayers == 0 && this.lidAngle > 0.0f || this.numUsingPlayers > 0 && this.lidAngle < 1.0f) {
            float f2 = this.lidAngle;
            this.lidAngle = this.numUsingPlayers > 0 ? (this.lidAngle += f) : (this.lidAngle -= f);
            if (this.lidAngle > 1.0f) {
                this.lidAngle = 1.0f;
            }
            float f3 = 0.5f;
            if (this.lidAngle < 0.0f) {
                this.lidAngle = 0.0f;
            }
        }
    }

    @Override
    public boolean receiveClientEvent(int n, int n2) {
        if (n == 1) {
            this.numUsingPlayers = n2;
            return true;
        }
        return super.receiveClientEvent(n, n2);
    }

    @Override
    public void openChest() {
        if (this.numUsingPlayers < 0) {
            this.numUsingPlayers = 0;
        }
        ++this.numUsingPlayers;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID, 1, this.numUsingPlayers);
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID);
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType().blockID);
    }

    @Override
    public void closeChest() {
        if (this.getBlockType() != null && this.getBlockType() instanceof BlockChest) {
            --this.numUsingPlayers;
            this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID, 1, this.numUsingPlayers);
            this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID);
            this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType().blockID);
        }
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        this.updateContainingBlockInfo();
    }

    public int getChestType() {
        if (this.cachedChestType == -1) {
            if (this.worldObj == null || !(this.getBlockType() instanceof BlockChest)) {
                return 0;
            }
            this.cachedChestType = ((BlockChest)this.getBlockType())._b;
        }
        return this.cachedChestType;
    }
}

