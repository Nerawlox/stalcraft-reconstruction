/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import net.minecraft.block.Block;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.kjui;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.turb;

public class InventoryPlayer
implements IInventory {
    public ItemStack[] _a = new ItemStack[36];
    public ItemStack[] _b = new ItemStack[4];
    public int _c;
    @SideOnly(value=Side.CLIENT)
    public ItemStack _d;
    public EntityPlayer _e;
    public ItemStack _f;
    public boolean _g;

    public InventoryPlayer(EntityPlayer entityPlayer) {
        this._e = entityPlayer;
    }

    public ItemStack _a() {
        return this._c < 9 && this._c >= 0 ? this._a[this._c] : null;
    }

    public static int _b() {
        return 9;
    }

    public int _a(int n) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._a[i]._d != n) continue;
            return i;
        }
        return -1;
    }

    @SideOnly(value=Side.CLIENT)
    public int _a(int n, int n2) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._a[i]._d != n || this._a[i]._j() != n2) continue;
            return i;
        }
        return -1;
    }

    public int _a(ItemStack itemStack) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._a[i]._d != itemStack._d || !this._a[i]._e() || this._a[i]._b >= this._a[i]._d() || this._a[i]._b >= this.getInventoryStackLimit() || this._a[i]._g() && this._a[i]._j() != itemStack._j() || !ItemStack._a(this._a[i], itemStack)) continue;
            return i;
        }
        return -1;
    }

    public int _c() {
        int n = GloomyHooks.getFirstEmptyStack(this);
        return n;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(int n, int n2, boolean bl, boolean bl2) {
        boolean bl3 = true;
        this._d = this._a();
        int n3 = bl ? this._a(n, n2) : this._a(n);
        if (n3 >= 0 && n3 < 9) {
            this._c = n3;
        } else if (bl2 && n > 0) {
            int n4 = this._c();
            if (n4 >= 0 && n4 < 9) {
                this._c = n4;
            }
            this._a(Item.itemsList[n], n2);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void _b(int n) {
        if (n > 0) {
            n = 1;
        }
        if (n < 0) {
            n = -1;
        }
        this._c -= n;
        while (this._c < 0) {
            this._c += 9;
        }
        while (this._c >= 9) {
            this._c -= 9;
        }
        GloomyHooks.changeCurrentItem(this, n);
    }

    public int _b(int n, int n2) {
        ItemStack itemStack;
        int n3;
        int n4 = 0;
        for (n3 = 0; n3 < this._a.length; ++n3) {
            itemStack = this._a[n3];
            if (itemStack == null || n > -1 && itemStack._d != n || n2 > -1 && itemStack._j() != n2) continue;
            n4 += itemStack._b;
            this._a[n3] = null;
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            itemStack = this._b[n3];
            if (itemStack == null || n > -1 && itemStack._d != n || n2 > -1 && itemStack._j() != n2) continue;
            n4 += itemStack._b;
            this._b[n3] = null;
        }
        if (this._f != null) {
            if (n > -1 && this._f._d != n) {
                return n4;
            }
            if (n2 > -1 && this._f._j() != n2) {
                return n4;
            }
            n4 += this._f._b;
            this._d(null);
        }
        return n4;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(Item item, int n) {
        if (item != null) {
            if (this._d != null && this._d._x() && this._a(this._d._d, this._d._i()) == this._c) {
                return;
            }
            int n2 = this._a(item.itemID, n);
            if (n2 >= 0) {
                int n3 = this._a[n2]._b;
                this._a[n2] = this._a[this._c];
                this._a[this._c] = new ItemStack(Item.itemsList[item.itemID], n3, n);
            } else {
                this._a[this._c] = new ItemStack(Item.itemsList[item.itemID], 1, n);
            }
        }
    }

    public int _b(ItemStack itemStack) {
        int n = itemStack._d;
        int n2 = itemStack._b;
        if (itemStack._d() == 1) {
            int n3 = this._c();
            if (n3 < 0) {
                return n2;
            }
            if (this._a[n3] == null) {
                this._a[n3] = ItemStack._c(itemStack);
            }
            return 0;
        }
        int n4 = this._a(itemStack);
        if (n4 < 0) {
            n4 = this._c();
        }
        if (n4 < 0) {
            return n2;
        }
        if (this._a[n4] == null) {
            this._a[n4] = new ItemStack(n, 0, itemStack._j());
            if (itemStack._p()) {
                this._a[n4]._d((NBTTagCompound)itemStack._q()._c());
            }
        }
        int n5 = n2;
        if (n2 > this._a[n4]._d() - this._a[n4]._b) {
            n5 = this._a[n4]._d() - this._a[n4]._b;
        }
        if (n5 > this.getInventoryStackLimit() - this._a[n4]._b) {
            n5 = this.getInventoryStackLimit() - this._a[n4]._b;
        }
        if (n5 == 0) {
            return n2;
        }
        this._a[n4]._b += n5;
        this._a[n4]._c = 5;
        return n2 -= n5;
    }

    public void _d() {
        int n;
        for (n = 0; n < this._a.length; ++n) {
            if (this._a[n] == null) continue;
            this._a[n]._a(this._e.worldObj, this._e, n, this._c == n);
        }
        for (n = 0; n < this._b.length; ++n) {
            if (this._b[n] == null) continue;
            this._b[n]._a().onArmorTickUpdate(this._e.worldObj, this._e, this._b[n]);
        }
    }

    public boolean _c(int n) {
        int n2 = this._a(n);
        if (n2 < 0) {
            return false;
        }
        if (--this._a[n2]._b <= 0) {
            this._a[n2] = null;
        }
        return true;
    }

    public boolean _d(int n) {
        int n2 = this._a(n);
        return n2 >= 0;
    }

    public boolean _c(ItemStack itemStack) {
        int n = qlgf._a(this, itemStack);
        if (n != 0) {
            return qlgf._b(this, itemStack);
        }
        if (itemStack == null) {
            return false;
        }
        if (itemStack._b == 0) {
            return false;
        }
        try {
            if (itemStack._h()) {
                n = this._c();
                if (n >= 0) {
                    this._a[n] = ItemStack._c(itemStack);
                    this._a[n]._c = 5;
                    itemStack._b = 0;
                    return true;
                }
                if (this._e.capabilities._d) {
                    itemStack._b = 0;
                    return true;
                }
                return false;
            }
            do {
                n = itemStack._b;
                itemStack._b = this._b(itemStack);
            } while (itemStack._b > 0 && itemStack._b < n);
            if (itemStack._b == n && this._e.capabilities._d) {
                itemStack._b = 0;
                return true;
            }
            return itemStack._b < n;
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Adding item to inventory");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Item being added");
            crashReportCategory._a("Item ID", itemStack._d);
            crashReportCategory._a("Item data", itemStack._j());
            crashReportCategory._a("Item name", new kjui(this, itemStack));
            throw new turb(crashReport);
        }
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        ItemStack[] itemStackArray = this._a;
        if (n >= this._a.length) {
            itemStackArray = this._b;
            n -= this._a.length;
        }
        if (itemStackArray[n] != null) {
            if (itemStackArray[n]._b <= n2) {
                ItemStack itemStack = itemStackArray[n];
                itemStackArray[n] = null;
                return itemStack;
            }
            ItemStack itemStack = itemStackArray[n]._a(n2);
            if (itemStackArray[n]._b == 0) {
                itemStackArray[n] = null;
            }
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        ItemStack[] itemStackArray = this._a;
        if (n >= this._a.length) {
            itemStackArray = this._b;
            n -= this._a.length;
        }
        if (itemStackArray[n] != null) {
            ItemStack itemStack = itemStackArray[n];
            itemStackArray[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        GloomyHooks.setInventorySlotContents(this, n, itemStack);
        ItemStack[] itemStackArray = this._a;
        if (n >= itemStackArray.length) {
            n -= itemStackArray.length;
            itemStackArray = this._b;
        }
        itemStackArray[n] = itemStack;
    }

    public float _a(Block block) {
        float f = 1.0f;
        if (this._a[this._c] != null) {
            f *= this._a[this._c]._a(block);
        }
        return f;
    }

    public NBTTagList _a(NBTTagList nBTTagList) {
        NBTTagCompound nBTTagCompound;
        int n;
        for (n = 0; n < this._a.length; ++n) {
            if (this._a[n] == null) continue;
            nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", (byte)n);
            this._a[n]._b(nBTTagCompound);
            nBTTagList._a(nBTTagCompound);
        }
        for (n = 0; n < this._b.length; ++n) {
            if (this._b[n] == null) continue;
            nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", (byte)(n + 100));
            this._b[n]._b(nBTTagCompound);
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public void _b(NBTTagList nBTTagList) {
        this._a = new ItemStack[36];
        this._b = new ItemStack[4];
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound._d("Slot") & 0xFF;
            ItemStack itemStack = ItemStack._a(nBTTagCompound);
            if (itemStack == null) continue;
            if (n >= 0 && n < this._a.length) {
                this._a[n] = itemStack;
            }
            if (n < 100 || n >= this._b.length + 100) continue;
            this._b[n - 100] = itemStack;
        }
    }

    @Override
    public int getSizeInventory() {
        return this._a.length + 4;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        ItemStack[] itemStackArray = this._a;
        if (n >= itemStackArray.length) {
            n -= itemStackArray.length;
            itemStackArray = this._b;
        }
        return itemStackArray[n];
    }

    @Override
    public String getInvName() {
        return "container.inventory";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    public boolean _b(Block block) {
        if (block.blockMaterial._l()) {
            return true;
        }
        ItemStack itemStack = this.getStackInSlot(this._c);
        return itemStack != null ? itemStack._b(block) : false;
    }

    public ItemStack _e(int n) {
        return this._b[n];
    }

    public int _e() {
        int n = 0;
        for (int i = 0; i < this._b.length; ++i) {
            if (this._b[i] == null || !(this._b[i]._a() instanceof ItemArmor)) continue;
            int n2 = ((ItemArmor)this._b[i]._a()).damageReduceAmount;
            n += n2;
        }
        return n;
    }

    public void _a(float f) {
        GloomyHooks.damageArmor(this, f);
    }

    public void _f() {
        int n;
        for (n = 0; n < this._a.length; ++n) {
            if (this._a[n] == null) continue;
            this._e.dropPlayerItemWithRandomChoice(this._a[n], true);
            this._a[n] = null;
        }
        for (n = 0; n < this._b.length; ++n) {
            if (this._b[n] == null) continue;
            this._e.dropPlayerItemWithRandomChoice(this._b[n], true);
            this._b[n] = null;
        }
    }

    @Override
    public void onInventoryChanged() {
        this._g = true;
    }

    public void _d(ItemStack itemStack) {
        this._f = itemStack;
    }

    public ItemStack _g() {
        return this._f;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this._e.isDead ? false : entityPlayer.getDistanceSqToEntity(this._e) <= 64.0;
    }

    public boolean _e(ItemStack itemStack) {
        int n;
        for (n = 0; n < this._b.length; ++n) {
            if (this._b[n] == null || !this._b[n]._b(itemStack)) continue;
            return true;
        }
        for (n = 0; n < this._a.length; ++n) {
            if (this._a[n] == null || !this._a[n]._b(itemStack)) continue;
            return true;
        }
        return false;
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

    public void _a(InventoryPlayer inventoryPlayer) {
        int n;
        for (n = 0; n < this._a.length; ++n) {
            this._a[n] = ItemStack._c(inventoryPlayer._a[n]);
        }
        for (n = 0; n < this._b.length; ++n) {
            this._b[n] = ItemStack._c(inventoryPlayer._b[n]);
        }
        this._c = inventoryPlayer._c;
    }
}

