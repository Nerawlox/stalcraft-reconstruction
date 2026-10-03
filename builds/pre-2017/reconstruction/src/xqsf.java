/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class xqsf
implements IInventory {
    public HashMap<Integer, ItemStack> _a = new HashMap();
    private final String _b;
    private final String _c;

    public xqsf(String string, String string2) {
        this._b = string;
        this._c = string2;
    }

    public void _a(ItemStack itemStack) {
        int n = 0;
        while (this._a.get(n) != null) {
            ++n;
        }
        this.setInventorySlotContents(n, itemStack);
    }

    public void _a(ItemStack[] itemStackArray) {
        int n = 0;
        int n2 = -1;
        while (n < itemStackArray.length) {
            if (this.getStackInSlot(++n2) != null) continue;
            this.setInventorySlotContents(n2, itemStackArray[n++]);
        }
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound._n(this._c);
        for (int i = 0; i < nBTTagList._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList._b(i);
            int n = nBTTagCompound2._f("Slot");
            this.setInventorySlotContents(n, ItemStack._a(nBTTagCompound2));
        }
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = new NBTTagList();
        for (int n : this._a.keySet()) {
            if (this._a.get(n) == null) continue;
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            nBTTagCompound2._a("Slot", n);
            this._a.get(n)._b(nBTTagCompound2);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a(this._c, nBTTagList);
    }

    public HashMap<Integer, ItemStack> _a() {
        return this._a;
    }

    public int _b() {
        int n = 0;
        for (int n2 : this._a.keySet()) {
            if (n2 <= n) continue;
            n = n2;
        }
        int n3 = n + 2;
        if (n3 % this.getSizeInventory() == 0) {
            return n3 / this.getSizeInventory();
        }
        return n3 / this.getSizeInventory() + 1;
    }

    @Override
    public int getSizeInventory() {
        return 27;
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        if (this._a.containsKey(n)) {
            return this._a.get(n);
        }
        return null;
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (this._a.containsKey(n)) {
            if (this._a.get((Object)Integer.valueOf((int)n))._b <= n2) {
                ItemStack itemStack = this._a.get(n);
                this._a.remove(n);
                this.onInventoryChanged();
                return itemStack;
            }
            ItemStack itemStack = this._a.get(n)._a(n2);
            if (this._a.get((Object)Integer.valueOf((int)n))._b == 0) {
                this._a.remove(n);
            }
            this.onInventoryChanged();
            return itemStack;
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (this._a.containsKey(n) && this._a.get(n) != null) {
            ItemStack itemStack = this._a.get(n);
            this._a.remove(n);
            return itemStack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        if (itemStack == null) {
            this._a.remove(n);
        } else {
            this._a.put(n, itemStack);
        }
        this.onInventoryChanged();
    }

    @Override
    public String getInvName() {
        return this._b;
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return true;
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
}

