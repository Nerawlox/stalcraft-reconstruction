/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class ofxb
implements IInventory {
    public ItemStack[] _a;

    public ofxb(int n) {
        this._a = new ItemStack[n];
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
    }

    @Override
    public String getInvName() {
        return "StalkerWeapon";
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

