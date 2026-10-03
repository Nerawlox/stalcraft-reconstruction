/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityChest
extends TileEntity
implements IInventory {
    public ItemStack[] _a = new ItemStack[36];
    public boolean _b;
    public TileEntityChest _c;
    public TileEntityChest _d;
    public TileEntityChest _e;
    public TileEntityChest _f;
    public float _g;
    public float _h;
    public int _i;
    public int _j;
    public int _k;
    public String _l;

    public TileEntityChest() {
        this._k = -1;
    }

    public TileEntityChest(int n) {
        this._k = n;
    }

    @Override
    public int getSizeInventory() {
        return 27;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this._a[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this._a[n] != null) {
            if (this._a[n]._b <= n2) {
                ItemStack itemStack = this._a[n];
                this._a[n] = null;
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this._a[n]._a(n2);
            if (this._a[n]._b == 0) {
                this._a[n] = null;
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this._a[n] != null) {
            ItemStack itemStack = this._a[n];
            this._a[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this._a[n] = itemStack;
        if (itemStack != null && itemStack._b > this.getInventoryStackLimit()) {
            itemStack._b = this.getInventoryStackLimit();
        }
        this.onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return this.isInvNameLocalized() ? this._l : "container.chest";
    }

    @Override
    public boolean isInvNameLocalized() {
        return this._l != null && this._l.length() > 0;
    }

    public void _a(String string) {
        this._l = string;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound._n("Items");
        this._a = new ItemStack[this.getSizeInventory()];
        if (nBTTagCompound._c("CustomName")) {
            this._l = nBTTagCompound._j("CustomName");
        }
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound2._d("Slot") & 0xFF;
            if (n < 0 || n >= this._a.length) continue;
            this._a[n] = ItemStack._a(nBTTagCompound2);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Slot", (byte)i);
            this._a[i]._b(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Items", nBTTagList);
        if (this.isInvNameLocalized()) {
            nBTTagCompound._a("CustomName", this._l);
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
            return false;
        }
        return !(entityPlayer.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) > 64.0);
    }

    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        this._b = false;
    }

    public void _a(TileEntityChest tileEntityChest, int n) {
        if (tileEntityChest.isInvalid()) {
            this._b = false;
        } else if (this._b) {
            switch (n) {
                case 2: {
                    if (this._c == tileEntityChest) break;
                    this._b = false;
                    break;
                }
                case 0: {
                    if (this._f == tileEntityChest) break;
                    this._b = false;
                    break;
                }
                case 3: {
                    if (this._d == tileEntityChest) break;
                    this._b = false;
                    break;
                }
                case 1: {
                    if (this._e == tileEntityChest) break;
                    this._b = false;
                }
            }
        }
    }

    public void _b() {
        if (this._b) {
            return;
        }
        this._b = true;
        this._c = null;
        this._d = null;
        this._e = null;
        this._f = null;
        if (this._a(this.xCoord - 1, this.yCoord, this.zCoord)) {
            this._e = (TileEntityChest)this.worldObj.getBlockTileEntity(this.xCoord - 1, this.yCoord, this.zCoord);
        }
        if (this._a(this.xCoord + 1, this.yCoord, this.zCoord)) {
            this._d = (TileEntityChest)this.worldObj.getBlockTileEntity(this.xCoord + 1, this.yCoord, this.zCoord);
        }
        if (this._a(this.xCoord, this.yCoord, this.zCoord - 1)) {
            this._c = (TileEntityChest)this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord - 1);
        }
        if (this._a(this.xCoord, this.yCoord, this.zCoord + 1)) {
            this._f = (TileEntityChest)this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord + 1);
        }
        if (this._c != null) {
            this._c._a(this, 0);
        }
        if (this._f != null) {
            this._f._a(this, 2);
        }
        if (this._d != null) {
            this._d._a(this, 1);
        }
        if (this._e != null) {
            this._e._a(this, 3);
        }
    }

    public boolean _a(int n, int n2, int n3) {
        Block block = Block.blocksList[this.worldObj.getBlockId(n, n2, n3)];
        if (block == null || !(block instanceof BlockChest)) {
            return false;
        }
        return ((BlockChest)block)._b == this._c();
    }

    @Override
    public void updateEntity() {
        double d;
        float f;
        super.updateEntity();
        this._b();
        ++this._j;
        if (!this.worldObj.isRemote && this._i != 0 && (this._j + this.xCoord + this.yCoord + this.zCoord) % 200 == 0) {
            this._i = 0;
            f = 5.0f;
            List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB._a()._a((float)this.xCoord - f, (float)this.yCoord - f, (float)this.zCoord - f, (float)(this.xCoord + 1) + f, (float)(this.yCoord + 1) + f, (float)(this.zCoord + 1) + f));
            for (EntityPlayer entityPlayer : list) {
                IInventory iInventory;
                if (!(entityPlayer.openContainer instanceof wpkx) || (iInventory = ((wpkx)entityPlayer.openContainer)._a()) != this && (!(iInventory instanceof huew) || !((huew)iInventory)._a(this))) continue;
                ++this._i;
            }
        }
        this._h = this._g;
        f = 0.1f;
        if (this._i > 0 && this._g == 0.0f && this._c == null && this._e == null) {
            double d2 = (double)this.xCoord + 0.5;
            d = (double)this.zCoord + 0.5;
            if (this._f != null) {
                d += 0.5;
            }
            if (this._d != null) {
                d2 += 0.5;
            }
            this.worldObj.playSoundEffect(d2, (double)this.yCoord + 0.5, d, "random.chestopen", 0.5f, this.worldObj.rand.nextFloat() * 0.1f + 0.9f);
        }
        if (this._i == 0 && this._g > 0.0f || this._i > 0 && this._g < 1.0f) {
            float f2;
            float f3 = this._g;
            this._g = this._i > 0 ? (this._g += f) : (this._g -= f);
            if (this._g > 1.0f) {
                this._g = 1.0f;
            }
            if (this._g < (f2 = 0.5f) && f3 >= f2 && this._c == null && this._e == null) {
                d = (double)this.xCoord + 0.5;
                double d3 = (double)this.zCoord + 0.5;
                if (this._f != null) {
                    d3 += 0.5;
                }
                if (this._d != null) {
                    d += 0.5;
                }
                this.worldObj.playSoundEffect(d, (double)this.yCoord + 0.5, d3, "random.chestclosed", 0.5f, this.worldObj.rand.nextFloat() * 0.1f + 0.9f);
            }
            if (this._g < 0.0f) {
                this._g = 0.0f;
            }
        }
    }

    @Override
    public boolean receiveClientEvent(int n, int n2) {
        if (n == 1) {
            this._i = n2;
            return true;
        }
        return super.receiveClientEvent(n, n2);
    }

    @Override
    public void openChest() {
        if (this._i < 0) {
            this._i = 0;
        }
        ++this._i;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID, 1, this._i);
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID);
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType().blockID);
    }

    @Override
    public void closeChest() {
        if (this.getBlockType() == null || !(this.getBlockType() instanceof BlockChest)) {
            return;
        }
        --this._i;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID, 1, this._i);
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType().blockID);
        this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType().blockID);
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        this.updateContainingBlockInfo();
        this._b();
    }

    public int _c() {
        if (this._k == -1) {
            if (this.worldObj != null && this.getBlockType() instanceof BlockChest) {
                this._k = ((BlockChest)this.getBlockType())._b;
            } else {
                return 0;
            }
        }
        return this._k;
    }
}

