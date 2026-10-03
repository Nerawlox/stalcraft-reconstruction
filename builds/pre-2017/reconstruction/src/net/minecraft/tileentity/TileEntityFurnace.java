/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFurnace
extends TileEntity
implements gaaa {
    public static final int[] _a = new int[]{0};
    public static final int[] _b = new int[]{2, 1};
    public static final int[] _c = new int[]{1};
    public ItemStack[] _d = new ItemStack[3];
    public int _e;
    public int _f;
    public int _g;
    public String _h;

    @Override
    public int getSizeInventory() {
        return this._d.length;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return this._d[n];
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this._d[n] != null) {
            if (this._d[n]._b <= n2) {
                ItemStack itemStack = this._d[n];
                this._d[n] = null;
                return itemStack;
            }
            ItemStack itemStack = this._d[n]._a(n2);
            if (this._d[n]._b == 0) {
                this._d[n] = null;
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this._d[n] != null) {
            ItemStack itemStack = this._d[n];
            this._d[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this._d[n] = itemStack;
        if (itemStack != null && itemStack._b > this.getInventoryStackLimit()) {
            itemStack._b = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInvName() {
        return this.isInvNameLocalized() ? this._h : "container.furnace";
    }

    @Override
    public boolean isInvNameLocalized() {
        return this._h != null && this._h.length() > 0;
    }

    public void _a(String string) {
        this._h = string;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound._n("Items");
        this._d = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            byte by = nBTTagCompound2._d("Slot");
            if (by < 0 || by >= this._d.length) continue;
            this._d[by] = ItemStack._a(nBTTagCompound2);
        }
        this._e = nBTTagCompound._e("BurnTime");
        this._g = nBTTagCompound._e("CookTime");
        this._f = TileEntityFurnace._a(this._d[1]);
        if (nBTTagCompound._c("CustomName")) {
            this._h = nBTTagCompound._j("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("BurnTime", (short)this._e);
        nBTTagCompound._a("CookTime", (short)this._g);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this._d.length; ++i) {
            if (this._d[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Slot", (byte)i);
            this._d[i]._b(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Items", nBTTagList);
        if (this.isInvNameLocalized()) {
            nBTTagCompound._a("CustomName", this._h);
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @SideOnly(value=Side.CLIENT)
    public int _b(int n) {
        return this._g * n / 200;
    }

    @SideOnly(value=Side.CLIENT)
    public int _c(int n) {
        if (this._f == 0) {
            this._f = 200;
        }
        return this._e * n / this._f;
    }

    public boolean _a() {
        return this._e > 0;
    }

    @Override
    public void updateEntity() {
        boolean bl = this._e > 0;
        boolean bl2 = false;
        if (this._e > 0) {
            --this._e;
        }
        if (!this.worldObj.isRemote) {
            if (this._e == 0 && this._b()) {
                this._f = this._e = TileEntityFurnace._a(this._d[1]);
                if (this._e > 0) {
                    bl2 = true;
                    if (this._d[1] != null) {
                        --this._d[1]._b;
                        if (this._d[1]._b == 0) {
                            this._d[1] = this._d[1]._a().getContainerItemStack(this._d[1]);
                        }
                    }
                }
            }
            if (this._a() && this._b()) {
                ++this._g;
                if (this._g == 200) {
                    this._g = 0;
                    this._c();
                    bl2 = true;
                }
            } else {
                this._g = 0;
            }
            if (bl != this._e > 0) {
                bl2 = true;
                BlockFurnace._a(this._e > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }
        if (bl2) {
            this.onInventoryChanged();
        }
    }

    public boolean _b() {
        if (this._d[0] == null) {
            return false;
        }
        ItemStack itemStack = yewu._a()._a(this._d[0]);
        if (itemStack == null) {
            return false;
        }
        if (this._d[2] == null) {
            return true;
        }
        if (!this._d[2]._b(itemStack)) {
            return false;
        }
        int n = this._d[2]._b + itemStack._b;
        return n <= this.getInventoryStackLimit() && n <= itemStack._d();
    }

    public void _c() {
        if (this._b()) {
            ItemStack itemStack = yewu._a()._a(this._d[0]);
            if (this._d[2] == null) {
                this._d[2] = itemStack._l();
            } else if (this._d[2]._b(itemStack)) {
                this._d[2]._b += itemStack._b;
            }
            --this._d[0]._b;
            if (this._d[0]._b <= 0) {
                this._d[0] = null;
            }
        }
    }

    public static int _a(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        int n = itemStack._a().itemID;
        Item item = itemStack._a();
        if (itemStack._a() instanceof ItemBlock && Block.blocksList[n] != null) {
            Block block = Block.blocksList[n];
            if (block == Block.woodSingleSlab) {
                return 150;
            }
            if (block.blockMaterial == Material._d) {
                return 300;
            }
            if (block == Block.coalBlock) {
                return 16000;
            }
        }
        if (item instanceof focs && ((focs)item)._a().equals("WOOD")) {
            return 200;
        }
        if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) {
            return 200;
        }
        if (item instanceof zhxn && ((zhxn)item)._a().equals("WOOD")) {
            return 200;
        }
        if (n == Item.stick.itemID) {
            return 100;
        }
        if (n == Item.coal.itemID) {
            return 1600;
        }
        if (n == Item.bucketLava.itemID) {
            return 20000;
        }
        if (n == Block.sapling.blockID) {
            return 100;
        }
        if (n == Item.blazeRod.itemID) {
            return 2400;
        }
        return GameRegistry.getFuelValue(itemStack);
    }

    public static boolean _b(ItemStack itemStack) {
        return TileEntityFurnace._a(itemStack) > 0;
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
        return n == 2 ? false : (n == 1 ? TileEntityFurnace._b(itemStack) : true);
    }

    @Override
    public int[] _a(int n) {
        return n == 0 ? _b : (n == 1 ? _a : _c);
    }

    @Override
    public boolean _a(int n, ItemStack itemStack, int n2) {
        return this.isItemValidForSlot(n, itemStack);
    }

    @Override
    public boolean _b(int n, ItemStack itemStack, int n2) {
        return n2 != 0 || n != 1 || itemStack._d == Item.bucketEmpty.itemID;
    }
}

