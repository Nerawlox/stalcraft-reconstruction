/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.util.Arrays;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.turb;

public class ydir
implements IInventory {
    public ItemStack[] _a = new ItemStack[13];
    public EntityPlayer _b;
    public boolean _c;

    public ydir(EntityPlayer entityPlayer) {
        this._b = entityPlayer;
    }

    private int _c(int n) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._a[i]._d != n) continue;
            return i;
        }
        return -1;
    }

    @ezey(_a={eidj.CLIENT})
    private int _b(int n, int n2) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || this._a[i]._d != n || this._a[i]._j() != n2) continue;
            return i;
        }
        return -1;
    }

    private int _d(ItemStack itemStack) {
        return -1;
    }

    public int _a() {
        return -1;
    }

    public int _a(int n, int n2) {
        int n3 = 0;
        for (int i = 0; i < this._a.length; ++i) {
            ItemStack itemStack = this._a[i];
            if (itemStack == null || n > -1 && itemStack._d != n || n2 > -1 && itemStack._j() != n2) continue;
            n3 += itemStack._b;
            this._a[i] = null;
        }
        return n3;
    }

    private int _e(ItemStack itemStack) {
        int n = itemStack._d;
        int n2 = itemStack._b;
        if (itemStack._d() == 1) {
            int n3 = this._a();
            if (n3 < 0) {
                return n2;
            }
            if (this._a[n3] == null) {
                this._a[n3] = ItemStack._c(itemStack);
            }
            return 0;
        }
        int n4 = this._d(itemStack);
        if (n4 < 0) {
            n4 = this._a();
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

    public void _b() {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null) continue;
            this._a[i]._a(this._b.worldObj, this._b, i, false);
        }
    }

    public boolean _a(int n) {
        int n2 = this._c(n);
        if (n2 < 0) {
            return false;
        }
        if (--this._a[n2]._b <= 0) {
            this._a[n2] = null;
        }
        return true;
    }

    public boolean _b(int n) {
        int n2 = this._c(n);
        return n2 >= 0;
    }

    public boolean _a(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack._b == 0) {
            return false;
        }
        try {
            int n;
            if (itemStack._h()) {
                int n2 = this._a();
                if (n2 >= 0) {
                    this._a[n2] = ItemStack._c(itemStack);
                    this._a[n2]._c = 5;
                    itemStack._b = 0;
                    return true;
                }
                if (this._b.capabilities._d) {
                    itemStack._b = 0;
                    return true;
                }
                return false;
            }
            do {
                n = itemStack._b;
                itemStack._b = this._e(itemStack);
            } while (itemStack._b > 0 && itemStack._b < n);
            if (itemStack._b == n && this._b.capabilities._d) {
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
            throw new turb(crashReport);
        }
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        ItemStack[] itemStackArray = this._a;
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
        if (itemStackArray[n] != null) {
            ItemStack itemStack = itemStackArray[n];
            itemStackArray[n] = null;
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        this._a[n] = itemStack;
    }

    public NBTTagList _a(NBTTagList nBTTagList) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null) continue;
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound._a("Slot", (byte)i);
            this._a[i]._b(nBTTagCompound);
            nBTTagList._a(nBTTagCompound);
        }
        return nBTTagList;
    }

    public void _b(NBTTagList nBTTagList) {
        this._a = new ItemStack[13];
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound._d("Slot") & 0xFF;
            ItemStack itemStack = ItemStack._a(nBTTagCompound);
            if (itemStack == null || n >= this._a.length) continue;
            this._a[n] = itemStack;
        }
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
    public String getInvName() {
        return "container.stalkerinventory";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    public void _c() {
        for (int i = 0; i < 12; ++i) {
            if (this._a[i] == null) continue;
            this._b.dropPlayerItemWithRandomChoice(this._a[i], true);
            this._a[i] = null;
        }
    }

    @Override
    public void onInventoryChanged() {
        this._c = true;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this._b.isDead ? false : entityPlayer.getDistanceSqToEntity(this._b) <= 64.0;
    }

    public boolean _b(ItemStack itemStack) {
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i] == null || !this._a[i]._b(itemStack)) continue;
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

    public void _a(ydir ydir2) {
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = ItemStack._c(ydir2._a[i]);
        }
    }

    public ItemStack[] _d() {
        return Arrays.copyOfRange(this._a, 5, 8);
    }

    public ItemStack _e() {
        return this._a[12];
    }

    public void _c(ItemStack itemStack) {
        this._a[12] = itemStack;
    }
}

