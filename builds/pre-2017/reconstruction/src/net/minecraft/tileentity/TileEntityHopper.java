/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import gloomyfolken.mods.asm.GloomyHooks;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockHopper;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.owak;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class TileEntityHopper
extends TileEntity
implements sdpc {
    public ItemStack[] _a = new ItemStack[5];
    public String _b;
    public int _c = -1;

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound._n("Items");
        this._a = new ItemStack[this.getSizeInventory()];
        if (nBTTagCompound._c("CustomName")) {
            this._b = nBTTagCompound._j("CustomName");
        }
        this._c = nBTTagCompound._f("TransferCooldown");
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            byte by = nBTTagCompound2._d("Slot");
            if (by < 0 || by >= this._a.length) continue;
            this._a[by] = ItemStack._a(nBTTagCompound2);
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
        nBTTagCompound._a("TransferCooldown", this._c);
        if (this.isInvNameLocalized()) {
            nBTTagCompound._a("CustomName", this._b);
        }
    }

    @Override
    public void onInventoryChanged() {
        super.onInventoryChanged();
    }

    @Override
    public int getSizeInventory() {
        return this._a.length;
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
                return itemStack;
            }
            ItemStack itemStack = this._a[n]._a(n2);
            if (this._a[n]._b == 0) {
                this._a[n] = null;
            }
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
    }

    @Override
    public String getInvName() {
        return this.isInvNameLocalized() ? this._b : "container.hopper";
    }

    @Override
    public boolean isInvNameLocalized() {
        return this._b != null && this._b.length() > 0;
    }

    public void _a(String string) {
        this._b = string;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityPlayer.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) <= 64.0;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }

    @Override
    public void updateEntity() {
        GloomyHooks.updateEntity(this);
    }

    public boolean _a() {
        GloomyHooks.updateHopper(this);
        return false;
    }

    public boolean _b() {
        IInventory iInventory = this._c();
        if (iInventory == null) {
            return false;
        }
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            if (this.getStackInSlot(i) == null) continue;
            ItemStack itemStack = this.getStackInSlot(i)._l();
            ItemStack itemStack2 = TileEntityHopper._a(iInventory, this.decrStackSize(i, 1), owak._a[BlockHopper._a(this.getBlockMetadata())]);
            if (itemStack2 == null || itemStack2._b == 0) {
                iInventory.onInventoryChanged();
                return true;
            }
            this.setInventorySlotContents(i, itemStack);
        }
        return false;
    }

    public static boolean _a(sdpc sdpc2) {
        GloomyHooks.suckItemsIntoHopper(null, sdpc2);
        return false;
    }

    public static boolean _a(sdpc sdpc2, IInventory iInventory, int n, int n2) {
        ItemStack itemStack = iInventory.getStackInSlot(n);
        if (itemStack != null && TileEntityHopper._b(iInventory, itemStack, n, n2)) {
            ItemStack itemStack2 = itemStack._l();
            ItemStack itemStack3 = TileEntityHopper._a(sdpc2, iInventory.decrStackSize(n, 1), -1);
            if (itemStack3 == null || itemStack3._b == 0) {
                iInventory.onInventoryChanged();
                return true;
            }
            iInventory.setInventorySlotContents(n, itemStack2);
        }
        return false;
    }

    public static boolean _a(IInventory iInventory, EntityItem entityItem) {
        boolean bl = false;
        if (entityItem == null) {
            return false;
        }
        ItemStack itemStack = entityItem.getEntityItem()._l();
        ItemStack itemStack2 = TileEntityHopper._a(iInventory, itemStack, -1);
        if (itemStack2 != null && itemStack2._b != 0) {
            entityItem.setEntityItemStack(itemStack2);
        } else {
            bl = true;
            entityItem.setDead();
        }
        return bl;
    }

    public static ItemStack _a(IInventory iInventory, ItemStack itemStack, int n) {
        if (iInventory instanceof gaaa && n > -1) {
            gaaa gaaa2 = (gaaa)iInventory;
            int[] nArray = gaaa2._a(n);
            for (int i = 0; i < nArray.length && itemStack != null && itemStack._b > 0; ++i) {
                itemStack = TileEntityHopper._c(iInventory, itemStack, nArray[i], n);
            }
        } else {
            int n2 = iInventory.getSizeInventory();
            for (int i = 0; i < n2 && itemStack != null && itemStack._b > 0; ++i) {
                itemStack = TileEntityHopper._c(iInventory, itemStack, i, n);
            }
        }
        if (itemStack != null && itemStack._b == 0) {
            itemStack = null;
        }
        return itemStack;
    }

    public static boolean _a(IInventory iInventory, ItemStack itemStack, int n, int n2) {
        return !iInventory.isItemValidForSlot(n, itemStack) ? false : !(iInventory instanceof gaaa) || ((gaaa)iInventory)._a(n, itemStack, n2);
    }

    public static boolean _b(IInventory iInventory, ItemStack itemStack, int n, int n2) {
        return !(iInventory instanceof gaaa) || ((gaaa)iInventory)._b(n, itemStack, n2);
    }

    public static ItemStack _c(IInventory iInventory, ItemStack itemStack, int n, int n2) {
        ItemStack itemStack2 = iInventory.getStackInSlot(n);
        if (TileEntityHopper._a(iInventory, itemStack, n, n2)) {
            int n3;
            boolean bl = false;
            if (itemStack2 == null) {
                int n4 = Math.min(itemStack._d(), iInventory.getInventoryStackLimit());
                if (n4 >= itemStack._b) {
                    iInventory.setInventorySlotContents(n, itemStack);
                    itemStack = null;
                } else {
                    iInventory.setInventorySlotContents(n, itemStack._a(n4));
                }
                bl = true;
            } else if (TileEntityHopper._a(itemStack2, itemStack) && (n3 = Math.min(itemStack._d(), iInventory.getInventoryStackLimit())) > itemStack2._b) {
                int n5 = Math.min(itemStack._b, n3 - itemStack2._b);
                itemStack._b -= n5;
                itemStack2._b += n5;
                boolean bl2 = bl = n5 > 0;
            }
            if (bl) {
                if (iInventory instanceof TileEntityHopper) {
                    ((TileEntityHopper)iInventory)._a(8);
                    iInventory.onInventoryChanged();
                }
                iInventory.onInventoryChanged();
            }
        }
        return itemStack;
    }

    public IInventory _c() {
        int n = BlockHopper._a(this.getBlockMetadata());
        return TileEntityHopper._b(this.getWorldObj(), this.xCoord + owak._b[n], (double)(this.yCoord + owak._c[n]), (double)(this.zCoord + owak._d[n]));
    }

    public static IInventory _b(sdpc sdpc2) {
        return TileEntityHopper._b(sdpc2.getWorldObj(), sdpc2.getXPos(), sdpc2.getYPos() + 1.0, sdpc2.getZPos());
    }

    public static EntityItem _a(World world, double d, double d2, double d3) {
        List list = world.selectEntitiesWithinAABB(EntityItem.class, AxisAlignedBB._a()._a(d, d2, d3, d + 1.0, d2 + 1.0, d3 + 1.0), IEntitySelector._a);
        return list.size() > 0 ? (EntityItem)list.get(0) : null;
    }

    public static IInventory _b(World world, double d, double d2, double d3) {
        List list;
        int n;
        Block block;
        int n2;
        int n3;
        IInventory iInventory = null;
        int n4 = sajh._c(d);
        TileEntity tileEntity = world.getBlockTileEntity(n4, n3 = sajh._c(d2), n2 = sajh._c(d3));
        if (tileEntity != null && tileEntity instanceof IInventory && (iInventory = (IInventory)((Object)tileEntity)) instanceof TileEntityChest && (block = Block.blocksList[n = world.getBlockId(n4, n3, n2)]) instanceof BlockChest) {
            iInventory = ((BlockChest)block)._c(world, n4, n3, n2);
        }
        if (iInventory == null && (list = world.getEntitiesWithinAABBExcludingEntity(null, AxisAlignedBB._a()._a(d, d2, d3, d + 1.0, d2 + 1.0, d3 + 1.0), IEntitySelector._b)) != null && list.size() > 0) {
            iInventory = (IInventory)list.get(world.rand.nextInt(list.size()));
        }
        return iInventory;
    }

    public static boolean _a(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack._d != itemStack2._d ? false : (itemStack._j() != itemStack2._j() ? false : (itemStack._b > itemStack._d() ? false : ItemStack._a(itemStack, itemStack2)));
    }

    @Override
    public double getXPos() {
        return this.xCoord;
    }

    @Override
    public double getYPos() {
        return this.yCoord;
    }

    @Override
    public double getZPos() {
        return this.zCoord;
    }

    public void _a(int n) {
        this._c = n;
    }

    public boolean _d() {
        return this._c > 0;
    }
}

