/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class huew
implements IInventory {
    public String _a;
    public IInventory _b;
    public IInventory _c;

    public huew(String string, IInventory iInventory, IInventory iInventory2) {
        this._a = string;
        if (iInventory == null) {
            iInventory = iInventory2;
        }
        if (iInventory2 == null) {
            iInventory2 = iInventory;
        }
        this._b = iInventory;
        this._c = iInventory2;
    }

    @Override
    public int getSizeInventory() {
        return this._b.getSizeInventory() + this._c.getSizeInventory();
    }

    public boolean _a(IInventory iInventory) {
        return this._b == iInventory || this._c == iInventory;
    }

    @Override
    public String getInvName() {
        if (this._b.isInvNameLocalized()) {
            return this._b.getInvName();
        }
        if (this._c.isInvNameLocalized()) {
            return this._c.getInvName();
        }
        return this._a;
    }

    @Override
    public boolean isInvNameLocalized() {
        return this._b.isInvNameLocalized() || this._c.isInvNameLocalized();
    }

    @Override
    public ItemStack getStackInSlot(int n) {
        if (n >= this._b.getSizeInventory()) {
            return this._c.getStackInSlot(n - this._b.getSizeInventory());
        }
        return this._b.getStackInSlot(n);
    }

    @Override
    public ItemStack decrStackSize(int n, int n2) {
        if (n >= this._b.getSizeInventory()) {
            return this._c.decrStackSize(n - this._b.getSizeInventory(), n2);
        }
        return this._b.decrStackSize(n, n2);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int n) {
        if (n >= this._b.getSizeInventory()) {
            return this._c.getStackInSlotOnClosing(n - this._b.getSizeInventory());
        }
        return this._b.getStackInSlotOnClosing(n);
    }

    @Override
    public void setInventorySlotContents(int n, ItemStack itemStack) {
        if (n >= this._b.getSizeInventory()) {
            this._c.setInventorySlotContents(n - this._b.getSizeInventory(), itemStack);
        } else {
            this._b.setInventorySlotContents(n, itemStack);
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 10000;
    }

    @Override
    public void onInventoryChanged() {
        this._b.onInventoryChanged();
        this._c.onInventoryChanged();
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this._b.isUseableByPlayer(entityPlayer) && this._c.isUseableByPlayer(entityPlayer);
    }

    @Override
    public void openChest() {
        this._b.openChest();
        this._c.openChest();
    }

    @Override
    public void closeChest() {
        this._b.closeChest();
        this._c.closeChest();
    }

    @Override
    public boolean isItemValidForSlot(int n, ItemStack itemStack) {
        return true;
    }
}

