/*
 * Decompiled with CFR 0.152.
 */
package berryBushes.te;

import berryBushes.Base;
import berryBushes.BerryCrops;
import berryBushes.Bush;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;

public class BushTE
extends TileEntity {
    protected int Meta;
    public float count = 0.0f;
    public boolean isCrop = false;
    public ItemStack stack;

    @Override
    public void updateEntity() {
        super.updateEntity();
        Block block = Block.blocksList[this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord)];
        if (block != null && block instanceof Bush) {
            Bush bush2 = (Bush)block;
            if (this.Meta != bush2.Meta) {
                this.Meta = bush2.Meta;
            }
        }
        if (block != null && block instanceof BerryCrops) {
            if (this.count >= 0.0f && this.count < 24000.0f) {
                if (this.worldObj.getBlockMaterial(this.xCoord, this.yCoord - 2, this.zCoord).equals(Material._e)) {
                    this.count -= 0.3f;
                }
                if (this.worldObj.getBlockId(this.xCoord, this.yCoord - 2, this.zCoord) == Block.whiteStone.blockID) {
                    this.count += 5.0f;
                }
                if (this.worldObj.getBlockId(this.xCoord, this.yCoord - 2, this.zCoord) == Block.dirt.blockID) {
                    this.count += 0.2f;
                    if (this.worldObj.getBlockId(this.xCoord, this.yCoord - 3, this.zCoord) == Block.dirt.blockID) {
                        this.count += 0.2f;
                    }
                }
                if (this.worldObj.getBlockId(this.xCoord, this.yCoord - 4, this.zCoord) == Block.blockClay.blockID) {
                    this.count += 0.5f;
                }
                this.count += 1.0f;
                int n = this.worldObj.rand.nextInt(10);
                switch (n) {
                    case 0: {
                        this.count += 0.5f;
                        break;
                    }
                    case 2: {
                        this.count += 0.2f;
                        break;
                    }
                    case 3: {
                        this.count -= 0.1f;
                        break;
                    }
                }
            }
            if (this.count > 8000.0f && this.count < 12000.0f) {
                this.stack = new ItemStack(Base.berry);
            }
            if (this.count >= 12000.0f && this.count < 18000.0f) {
                this.stack = new ItemStack(Base.berryII);
            }
            if (this.count >= 18000.0f && this.count < 24000.0f) {
                this.stack = new ItemStack(Base.berryIII);
            }
            if (this.count >= 24000.0f) {
                this.stack = new ItemStack(Base.berryIV);
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.isCrop = nBTTagCompound._o("isCrop");
        this.count = nBTTagCompound._h("count");
        super.readFromNBT(nBTTagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("isCrop", this.isCrop);
        nBTTagCompound._a("count", this.count);
        super.writeToNBT(nBTTagCompound);
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public Packet getDescriptionPacket() {
        wpte wpte2 = null;
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        wpte2 = new wpte(this.xCoord, this.yCoord, this.zCoord, 5, nBTTagCompound);
        return wpte2;
    }

    @Override
    public void onDataPacket(jjpj jjpj2, wpte wpte2) {
        this.readFromNBT(wpte2._e);
    }
}

