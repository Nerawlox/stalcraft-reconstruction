/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.brewing.PotionBrewedEvent;

public class TileEntityBrewingStand
extends TileEntity
implements gaaa {
    public static final int[] _a = new int[]{3};
    public static final int[] _b = new int[]{0, 1, 2};
    public ItemStack[] _c = new ItemStack[4];
    public int _d;
    public int _e;
    public int _f;
    public String _g;

    @Override
    public String getInvName() {
        return this.isInvNameLocalized() ? this._g : "container.brewing";
    }

    @Override
    public boolean isInvNameLocalized() {
        return this._g != null && this._g.length() > 0;
    }

    public void _a(String string) {
        this._g = string;
    }

    @Override
    public int getSizeInventory() {
        return this._c.length;
    }

    @Override
    public void updateEntity() {
        if (this._d > 0) {
            --this._d;
            if (this._d == 0) {
                this._c();
                this.onInventoryChanged();
            } else if (!this._b()) {
                this._d = 0;
                this.onInventoryChanged();
            } else if (this._f != this._c[3]._d) {
                this._d = 0;
                this.onInventoryChanged();
            }
        } else if (this._b()) {
            this._d = 400;
            this._f = this._c[3]._d;
        }
        int n = this._d();
        if (n != this._e) {
            this._e = n;
            this.worldObj.func_72921_c(this.xCoord, this.yCoord, this.zCoord, n, 2);
        }
        super.updateEntity();
    }

    public int _a() {
        return this._d;
    }

    public boolean _b() {
        if (this._c[3] != null && this._c[3]._b > 0) {
            ItemStack itemStack = this._c[3];
            if (!Item.itemsList[itemStack._d].isPotionIngredient()) {
                return false;
            }
            boolean bl = false;
            for (int i = 0; i < 3; ++i) {
                if (this._c[i] == null || !(this._c[i]._a() instanceof ItemPotion)) continue;
                int n = this._c[i]._j();
                int n2 = this._a(n, itemStack);
                if (!ItemPotion._b(n) && ItemPotion._b(n2)) {
                    bl = true;
                    break;
                }
                List list2 = Item.potion._a(n);
                List list3 = Item.potion._a(n2);
                if (n > 0 && list2 == list3 || list2 != null && (list2.equals(list3) || list3 == null) || n == n2) continue;
                bl = true;
                break;
            }
            return bl;
        }
        return false;
    }

    public void _c() {
        if (this._b()) {
            ItemStack itemStack = this._c[3];
            for (int i = 0; i < 3; ++i) {
                if (this._c[i] == null || !(this._c[i]._a() instanceof ItemPotion)) continue;
                int n = this._c[i]._j();
                int n2 = this._a(n, itemStack);
                List list2 = Item.potion._a(n);
                List list3 = Item.potion._a(n2);
                if (!(n > 0 && list2 == list3 || list2 != null && (list2.equals(list3) || list3 == null))) {
                    if (n == n2) continue;
                    this._c[i]._b(n2);
                    continue;
                }
                if (ItemPotion._b(n) || !ItemPotion._b(n2)) continue;
                this._c[i]._b(n2);
            }
            if (Item.itemsList[itemStack._d].hasContainerItem()) {
                this._c[3] = Item.itemsList[itemStack._d].getContainerItemStack(this._c[3]);
            } else {
                --this._c[3]._b;
                if (this._c[3]._b <= 0) {
                    this._c[3] = null;
                }
            }
            MinecraftForge.EVENT_BUS.post(new PotionBrewedEvent(this._c));
        }
    }

    public int _a(int n, ItemStack itemStack) {
        return itemStack == null ? n : (Item.itemsList[itemStack._d].isPotionIngredient() ? PotionHelper._a(n, Item.itemsList[itemStack._d].getPotionEffect()) : n);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound._n("Items");
        this._c = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            byte by = nBTTagCompound2._d("Slot");
            if (by < 0 || by >= this._c.length) continue;
            this._c[by] = ItemStack._a(nBTTagCompound2);
        }
        this._d = nBTTagCompound._e("BrewTime");
        if (nBTTagCompound._c("CustomName")) {
            this._g = nBTTagCompound._j("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound._a("BrewTime", (short)this._d);
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this._c.length; ++i) {
            if (this._c[i] == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Slot", (byte)i);
            this._c[i]._b(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Items", nBTTagList);
        if (this.isInvNameLocalized()) {
            nBTTagCompound._a("CustomName", this._g);
        }
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        return n >= 0 && n < this._c.length ? this._c[n] : null;
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (n >= 0 && n < this._c.length) {
            ItemStack itemStack = this._c[n];
            this._c[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (n >= 0 && n < this._c.length) {
            ItemStack itemStack = this._c[n];
            this._c[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        if (n >= 0 && n < this._c.length) {
            this._c[n] = itemStack;
        }
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
        return n == 3 ? Item.itemsList[itemStack._d].isPotionIngredient() : itemStack._a() instanceof ItemPotion || itemStack._d == Item.glassBottle.itemID;
    }

    @SideOnly(value=Side.CLIENT)
    public void _b(int n) {
        this._d = n;
    }

    public int _d() {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (this._c[i] == null) continue;
            n |= 1 << i;
        }
        return n;
    }

    @Override
    public int[] _a(int n) {
        return n == 1 ? _a : _b;
    }

    @Override
    public boolean _a(int n, ItemStack itemStack, int n2) {
        return this.isItemValidForSlot(n, itemStack);
    }

    @Override
    public boolean _b(int n, ItemStack itemStack, int n2) {
        return true;
    }
}

