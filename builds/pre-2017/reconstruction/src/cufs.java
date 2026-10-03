/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.misc.pidb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class cufs
extends tego {
    public cufs(IInventory iInventory, xqsf xqsf2) {
        super(iInventory, xqsf2);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            if (!(slot instanceof kkzz) && !pidb._a(itemStack2)) {
                return null;
            }
            itemStack = itemStack2._l();
            if (n < 27 ? !this.mergeItemStack(itemStack2, 27, this.inventorySlots.size(), true) : !this.mergeItemStack(itemStack2, 0, 27, false)) {
                return null;
            }
            if (itemStack2._b == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }

    @Override
    protected Slot _a(int n, int n2, int n3) {
        return new kkzz(this._a, n, n2, n3);
    }
}

