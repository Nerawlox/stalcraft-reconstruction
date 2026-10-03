/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBeacon;

public class ixdv
extends Container {
    public TileEntityBeacon _a;
    public final jjil _b;
    public int _c;
    public int _d;
    public int _e;

    public ixdv(InventoryPlayer inventoryPlayer, TileEntityBeacon tileEntityBeacon) {
        int n;
        this._a = tileEntityBeacon;
        this._b = new jjil(this, tileEntityBeacon, 0, 136, 110);
        this.addSlotToContainer(this._b);
        int n2 = 36;
        int n3 = 137;
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i + n * 9 + 9, n2 + i * 18, n3 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n, n2 + n * 18, 58 + n3));
        }
        this._c = tileEntityBeacon._f();
        this._d = tileEntityBeacon._d();
        this._e = tileEntityBeacon._e();
    }

    @Override
    public void func_75132_a(ICrafting iCrafting) {
        super.func_75132_a(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this._c);
        iCrafting.sendProgressBarUpdate(this, 1, this._d);
        iCrafting.sendProgressBarUpdate(this, 2, this._e);
    }

    @Override
    public void updateProgressBar(int n, int n2) {
        if (n == 0) {
            this._a._a(n2);
        }
        if (n == 1) {
            this._a._b(n2);
        }
        if (n == 2) {
            this._a._c(n2);
        }
    }

    public TileEntityBeacon _a() {
        return this._a;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this._a.isUseableByPlayer(entityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n == 0) {
                if (!this.mergeItemStack(itemStack2, 1, 37, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack2, itemStack);
            } else if (!this._b.getHasStack() && this._b.isItemValid(itemStack2) && itemStack2._b == 1 ? !this.mergeItemStack(itemStack2, 0, 1, false) : (n >= 1 && n < 28 ? !this.mergeItemStack(itemStack2, 28, 37, false) : (n >= 28 && n < 37 ? !this.mergeItemStack(itemStack2, 1, 28, false) : !this.mergeItemStack(itemStack2, 1, 37, false)))) {
                return null;
            }
            if (itemStack2._b == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemStack2._b == itemStack._b) {
                return null;
            }
            slot.onPickupFromSlot(entityPlayer, itemStack2);
        }
        return itemStack;
    }
}

