/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class dyct
extends Container {
    public List _a = new ArrayList();

    public dyct(EntityPlayer entityPlayer) {
        int n;
        InventoryPlayer inventoryPlayer = entityPlayer.inventory;
        for (n = 0; n < 5; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(qngy._d(), n * 9 + i, 9 + i * 18, 18 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n, 9 + n * 18, 112));
        }
        this._a(0.0f);
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    public void _a(float f) {
        int n = this._a.size() / 9 - 5 + 1;
        int n2 = (int)((double)(f * (float)n) + 0.5);
        if (n2 < 0) {
            n2 = 0;
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 9; ++j) {
                int n3 = j + (i + n2) * 9;
                if (n3 >= 0 && n3 < this._a.size()) {
                    qngy._d().setInventorySlotContents(j + i * 9, (ItemStack)this._a.get(n3));
                    continue;
                }
                qngy._d().setInventorySlotContents(j + i * 9, null);
            }
        }
    }

    public boolean _a() {
        return this._a.size() > 45;
    }

    @Override
    public void retrySlotClick(int n, int n2, boolean bl, EntityPlayer entityPlayer) {
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        Slot slot;
        if (n >= this.inventorySlots.size() - 9 && n < this.inventorySlots.size() && (slot = (Slot)this.inventorySlots.get(n)) != null && slot.getHasStack()) {
            slot.putStack(null);
        }
        return null;
    }

    @Override
    public boolean func_94530_a(ItemStack itemStack, Slot slot) {
        return slot.yDisplayPosition > 90;
    }

    @Override
    public boolean canDragIntoSlot(Slot slot) {
        return slot.inventory instanceof InventoryPlayer || slot.yDisplayPosition > 90 && slot.xDisplayPosition <= 162;
    }
}

