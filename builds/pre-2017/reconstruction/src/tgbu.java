/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBrewingStand;

public class tgbu
extends Container {
    public TileEntityBrewingStand _a;
    public final Slot _b;
    public int _c;

    public tgbu(InventoryPlayer inventoryPlayer, TileEntityBrewingStand tileEntityBrewingStand) {
        int n;
        this._a = tileEntityBrewingStand;
        this.addSlotToContainer(new rrag(inventoryPlayer._e, tileEntityBrewingStand, 0, 56, 46));
        this.addSlotToContainer(new rrag(inventoryPlayer._e, tileEntityBrewingStand, 1, 79, 53));
        this.addSlotToContainer(new rrag(inventoryPlayer._e, tileEntityBrewingStand, 2, 102, 46));
        this._b = this.addSlotToContainer(new sdbw(this, tileEntityBrewingStand, 3, 79, 17));
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i + n * 9 + 9, 8 + i * 18, 84 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n, 8 + n * 18, 142));
        }
    }

    @Override
    public void func_75132_a(ICrafting iCrafting) {
        super.func_75132_a(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this._a._a());
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting iCrafting = (ICrafting)this.crafters.get(i);
            if (this._c == this._a._a()) continue;
            iCrafting.sendProgressBarUpdate(this, 0, this._a._a());
        }
        this._c = this._a._a();
    }

    @Override
    public void updateProgressBar(int n, int n2) {
        if (n == 0) {
            this._a._b(n2);
        }
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
            if (n >= 0 && n <= 2 || n == 3) {
                if (!this.mergeItemStack(itemStack2, 4, 40, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack2, itemStack);
            } else if (!this._b.getHasStack() && this._b.isItemValid(itemStack2) ? !this.mergeItemStack(itemStack2, 3, 4, false) : (rrag._a(itemStack) ? !this.mergeItemStack(itemStack2, 0, 3, false) : (n >= 4 && n < 31 ? !this.mergeItemStack(itemStack2, 31, 40, false) : (n >= 31 && n < 40 ? !this.mergeItemStack(itemStack2, 4, 31, false) : !this.mergeItemStack(itemStack2, 4, 40, false))))) {
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

