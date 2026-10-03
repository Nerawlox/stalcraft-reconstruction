/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mo
 *  u
 */
package ru.stalcraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StalkerInventory
implements mo {
    public ye[] mainInventory = new ye[21];
    public uf player;
    public boolean inventoryChanged;

    public StalkerInventory(uf par1EntityPlayer) {
        this.player = par1EntityPlayer;
    }

    private int getInventorySlotContainItem(int par1) {
        for (int j2 = 0; j2 < this.mainInventory.length; ++j2) {
            if (this.mainInventory[j2] == null || this.mainInventory[j2].d != par1) continue;
            return j2;
        }
        return -1;
    }

    @SideOnly(value=Side.CLIENT)
    private int getInventorySlotContainItemAndDamage(int par1, int par2) {
        for (int k2 = 0; k2 < this.mainInventory.length; ++k2) {
            if (this.mainInventory[k2] == null || this.mainInventory[k2].d != par1 || this.mainInventory[k2].k() != par2) continue;
            return k2;
        }
        return -1;
    }

    private int storeItemStack(ye par1ItemStack) {
        if (this.mainInventory[12] != null) {
            for (int i2 = 13; i2 < 21; ++i2) {
                if (this.mainInventory[i2] == null || this.mainInventory[i2].d != par1ItemStack.d || !this.mainInventory[i2].f() || this.mainInventory[i2].b >= this.mainInventory[i2].e() || this.mainInventory[i2].b >= this.d() || this.mainInventory[i2].h() && this.mainInventory[i2].k() != par1ItemStack.k() || !ye.a(this.mainInventory[i2], par1ItemStack)) continue;
                return i2;
            }
        }
        return -1;
    }

    public int getFirstEmptyStack() {
        if (this.mainInventory[12] != null) {
            for (int i2 = 13; i2 < 21; ++i2) {
                if (this.mainInventory[i2] != null) continue;
                return i2;
            }
        }
        return -1;
    }

    public int clearInventory(int par1, int par2) {
        int k2 = 0;
        for (int l2 = 0; l2 < this.mainInventory.length; ++l2) {
            ye itemstack = this.mainInventory[l2];
            if (itemstack == null || par1 > -1 && itemstack.d != par1 || par2 > -1 && itemstack.k() != par2) continue;
            k2 += itemstack.b;
            this.mainInventory[l2] = null;
        }
        return k2;
    }

    private int storePartialItemStack(ye par1ItemStack) {
        int i2 = par1ItemStack.d;
        int j2 = par1ItemStack.b;
        if (par1ItemStack.e() == 1) {
            int k2 = this.getFirstEmptyStack();
            if (k2 < 0) {
                return j2;
            }
            if (this.mainInventory[k2] == null) {
                this.mainInventory[k2] = ye.b(par1ItemStack);
            }
            return 0;
        }
        int k3 = this.storeItemStack(par1ItemStack);
        if (k3 < 0) {
            k3 = this.getFirstEmptyStack();
        }
        if (k3 < 0) {
            return j2;
        }
        if (this.mainInventory[k3] == null) {
            this.mainInventory[k3] = new ye(i2, 0, par1ItemStack.k());
            if (par1ItemStack.p()) {
                this.mainInventory[k3].d((by)par1ItemStack.q().b());
            }
        }
        int l2 = j2;
        if (j2 > this.mainInventory[k3].e() - this.mainInventory[k3].b) {
            l2 = this.mainInventory[k3].e() - this.mainInventory[k3].b;
        }
        if (l2 > this.d() - this.mainInventory[k3].b) {
            l2 = this.d() - this.mainInventory[k3].b;
        }
        if (l2 == 0) {
            return j2;
        }
        this.mainInventory[k3].b += l2;
        this.mainInventory[k3].c = 5;
        return j2 -= l2;
    }

    public void decrementAnimations() {
        for (int i2 = 0; i2 < this.mainInventory.length; ++i2) {
            if (this.mainInventory[i2] == null) continue;
            this.mainInventory[i2].a(this.player.q, this.player, i2, false);
        }
    }

    public boolean consumeInventoryItem(int par1) {
        int j2 = this.getInventorySlotContainItem(par1);
        if (j2 < 0) {
            return false;
        }
        if (--this.mainInventory[j2].b <= 0) {
            this.mainInventory[j2] = null;
        }
        return true;
    }

    public boolean hasItem(int par1) {
        int j2 = this.getInventorySlotContainItem(par1);
        return j2 >= 0;
    }

    public boolean addItemStackToInventory(ye par1ItemStack) {
        if (par1ItemStack == null) {
            return false;
        }
        if (par1ItemStack.b == 0) {
            return false;
        }
        try {
            int throwable;
            if (par1ItemStack.i()) {
                int throwable2 = this.getFirstEmptyStack();
                if (throwable2 >= 0) {
                    this.mainInventory[throwable2] = ye.b(par1ItemStack);
                    this.mainInventory[throwable2].c = 5;
                    par1ItemStack.b = 0;
                    return true;
                }
                if (this.player.bG.d) {
                    par1ItemStack.b = 0;
                    return true;
                }
                return false;
            }
            do {
                throwable = par1ItemStack.b;
                par1ItemStack.b = this.storePartialItemStack(par1ItemStack);
            } while (par1ItemStack.b > 0 && par1ItemStack.b < throwable);
            if (par1ItemStack.b == throwable && this.player.bG.d) {
                par1ItemStack.b = 0;
                return true;
            }
            return par1ItemStack.b < throwable;
        }
        catch (Throwable var5) {
            b crashreport = b.a(var5, "Adding item to inventory");
            m crashreportcategory = crashreport.a("Item being added");
            crashreportcategory.a("Item ID", par1ItemStack.d);
            crashreportcategory.a("Item data", par1ItemStack.k());
            throw new u(crashreport);
        }
    }

    public boolean isItemValidForSlot(uy par1, int par2, ye par3) {
        return par1.a(par2).a(par3);
    }

    public ye a(int par1, int par2) {
        ye[] aitemstack = this.mainInventory;
        if (aitemstack[par1] != null) {
            if (aitemstack[par1].b <= par2) {
                ye itemstack = aitemstack[par1];
                aitemstack[par1] = null;
                return itemstack;
            }
            ye itemstack = aitemstack[par1].a(par2);
            if (aitemstack[par1].b == 0) {
                aitemstack[par1] = null;
            }
            return itemstack;
        }
        return null;
    }

    public ye a_(int par1) {
        ye[] aitemstack = this.mainInventory;
        if (aitemstack[par1] != null) {
            ye itemstack = aitemstack[par1];
            aitemstack[par1] = null;
            return itemstack;
        }
        return null;
    }

    public void a(int par1, ye par2ItemStack) {
        this.mainInventory[par1] = par2ItemStack;
    }

    public cg writeToNBT(cg par1NBTTagList) {
        for (int i2 = 0; i2 < this.mainInventory.length; ++i2) {
            if (this.mainInventory[i2] == null) continue;
            by nbttagcompound = new by();
            nbttagcompound.a("Slot", (byte)i2);
            this.mainInventory[i2].b(nbttagcompound);
            par1NBTTagList.a(nbttagcompound);
        }
        return par1NBTTagList;
    }

    public void readFromNBT(cg par1NBTTagList) {
        this.mainInventory = new ye[21];
        by nbttagcompound = null;
        int j2 = 0;
        ye itemstack = null;
        for (int i2 = 0; i2 < par1NBTTagList.c(); ++i2) {
            nbttagcompound = (by)par1NBTTagList.b(i2);
            j2 = nbttagcompound.c("Slot") & 0xFF;
            itemstack = ye.a(nbttagcompound);
            if (itemstack == null || j2 < 0 || j2 >= this.mainInventory.length) continue;
            this.mainInventory[j2] = itemstack;
        }
    }

    public int j_() {
        return this.mainInventory.length;
    }

    public ye a(int par1) {
        return this.mainInventory[par1];
    }

    public String b() {
        return "container.stalkerinventory";
    }

    public boolean c() {
        return false;
    }

    public int d() {
        return 64;
    }

    public void dropAllItems() {
        for (int i2 = 0; i2 < 12; ++i2) {
            if (this.mainInventory[i2] == null) continue;
            this.player.a(this.mainInventory[i2], true);
            this.mainInventory[i2] = null;
        }
    }

    public void e() {
        this.inventoryChanged = true;
    }

    public boolean a(uf par1EntityPlayer) {
        return this.player.M ? false : par1EntityPlayer.e((nn)this.player) <= 64.0;
    }

    public boolean hasItemStack(ye par1ItemStack) {
        for (int i2 = 0; i2 < this.mainInventory.length; ++i2) {
            if (this.mainInventory[i2] == null || !this.mainInventory[i2].a(par1ItemStack)) continue;
            return true;
        }
        return false;
    }

    public void k_() {
    }

    public void g() {
    }

    public void copyInventory(StalkerInventory par1InventoryPlayer) {
        for (int i2 = 0; i2 < this.mainInventory.length; ++i2) {
            this.mainInventory[i2] = ye.b(par1InventoryPlayer.mainInventory[i2]);
        }
    }

    public int getBackpack() {
        return this.mainInventory[12] == null ? 0 : this.mainInventory[12].d;
    }

    public boolean b(int i2, ye itemstack) {
        return false;
    }
}

