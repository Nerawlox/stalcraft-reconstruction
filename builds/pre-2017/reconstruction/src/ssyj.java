/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ssyj
extends Container {
    public ofxb _a;
    public Slot _b;
    private final EntityPlayer _c;

    public ssyj(EntityPlayer entityPlayer) {
        int n;
        this._c = entityPlayer;
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, i + n * 9 + 9, 8 + i * 18, 70 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n, 8 + n * 18, 127));
        }
        this._a = new dgmn(1);
        this._b = new Slot(this._a, 0, 80, 29){

            @Override
            public boolean isItemValid(ItemStack itemStack) {
                return itemStack == null || itemStack._a() instanceof oxnm;
            }
        };
        this.addSlotToContainer(this._b);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n == 36) {
                if (!this.mergeItemStack(itemStack2, 0, 36, false)) {
                    return null;
                }
            } else if (itemStack._a() instanceof oxnm && !this._b.getHasStack()) {
                ItemStack itemStack3 = itemStack2._l();
                itemStack3._b = 1;
                --itemStack2._b;
                this._b.putStack(itemStack3);
            }
            if (itemStack2._b == 0) {
                slot.putStack(null);
            }
            if (itemStack2._b == itemStack._b) {
                return null;
            }
            slot.onPickupFromSlot(this._c, itemStack2);
        }
        return itemStack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }
}

