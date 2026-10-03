/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import noppes.npcs.CustomNpcs;
import noppes.npcs.blocks.BlockNpcRedstone;
import noppes.npcs.controllers.Availability;

public class TileRedstoneBlock
extends TileEntity {
    public int onRangeX = 6;
    public int onRangeY = 6;
    public int onRangeZ = 6;
    public int offRangeX = 10;
    public int offRangeY = 10;
    public int offRangeZ = 10;
    public Availability availability = new Availability();
    public boolean isActivated = false;
    private int ticks = 10;

    @Override
    public void updateEntity() {
        if (!this.worldObj.isRemote) {
            --this.ticks;
            if (this.ticks <= 0) {
                this.ticks = 20;
                Block block = Block.blocksList[this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord)];
                if (block != null && block instanceof BlockNpcRedstone) {
                    if (CustomNpcs.FreezeNPCs) {
                        if (this.isActivated) {
                            this.setActive(block, false);
                        }
                    } else if (!this.isActivated) {
                        List list2 = this.getPlayerList(this.onRangeX, this.onRangeY, this.onRangeZ);
                        if (list2.isEmpty()) {
                            return;
                        }
                        for (EntityPlayer entityPlayer : list2) {
                            if (!this.availability.isAvailable(entityPlayer)) continue;
                            this.setActive(block, true);
                            return;
                        }
                    } else {
                        List list3 = this.getPlayerList(this.offRangeX, this.offRangeY, this.offRangeZ);
                        for (EntityPlayer entityPlayer : list3) {
                            if (!this.availability.isAvailable(entityPlayer)) continue;
                            return;
                        }
                        this.setActive(block, false);
                    }
                } else {
                    this.worldObj.removeBlockTileEntity(this.xCoord, this.yCoord, this.zCoord);
                }
            }
        }
    }

    private void setActive(Block block, boolean bl) {
        this.isActivated = bl;
        this.worldObj.func_72921_c(this.xCoord, this.yCoord, this.zCoord, this.isActivated ? 1 : 0, 2);
        this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
        if (this.hasWorldObj()) {
            block.onBlockAdded(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
        }
    }

    private List getPlayerList(int n, int n2, int n3) {
        return this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB._a(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1, this.yCoord + 1, this.zCoord + 1)._b(n, n2, n3));
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this.onRangeX = nBTTagCompound._f("BlockOnRangeX");
        this.onRangeY = nBTTagCompound._f("BlockOnRangeY");
        this.onRangeZ = nBTTagCompound._f("BlockOnRangeZ");
        this.offRangeX = nBTTagCompound._f("BlockOffRangeX");
        this.offRangeY = nBTTagCompound._f("BlockOffRangeY");
        this.offRangeZ = nBTTagCompound._f("BlockOffRangeZ");
        this.isActivated = nBTTagCompound._o("BlockActivated");
        this.availability.readFromNBT(nBTTagCompound);
        if (this.hasWorldObj()) {
            this.setActive(this.getBlockType(), this.isActivated);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("BlockOnRangeX", this.onRangeX);
        nBTTagCompound._a("BlockOnRangeY", this.onRangeY);
        nBTTagCompound._a("BlockOnRangeZ", this.onRangeZ);
        nBTTagCompound._a("BlockOffRangeX", this.offRangeX);
        nBTTagCompound._a("BlockOffRangeY", this.offRangeY);
        nBTTagCompound._a("BlockOffRangeZ", this.offRangeZ);
        nBTTagCompound._a("BlockActivated", this.isActivated);
        this.availability.writeToNBT(nBTTagCompound);
    }
}

