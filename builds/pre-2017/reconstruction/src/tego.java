/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class tego
extends Container {
    public final xqsf _a;
    public final IInventory _b;
    protected int _c = 1;

    public tego(IInventory iInventory, xqsf xqsf2) {
        this._b = iInventory;
        this._a = xqsf2;
        xqsf2.openChest();
        this._b();
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this._a.isUseableByPlayer(entityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        return null;
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        this._a.closeChest();
    }

    public void _a() {
        this.inventorySlots.clear();
        this.inventoryItemStacks.clear();
    }

    public void _b() {
        int n;
        int n2;
        int n3 = -18;
        int n4 = (this._c - 1) * this._a.getSizeInventory();
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(this._a(n4 + n + n2 * 9, 8 + n * 18, 18 + n2 * 18));
            }
        }
        for (n2 = 0; n2 < 3; ++n2) {
            for (n = 0; n < 9; ++n) {
                this.addSlotToContainer(new Slot(this._b, n + n2 * 9 + 9, 8 + n * 18, 103 + n2 * 18 + n3));
            }
        }
        for (n2 = 0; n2 < 9; ++n2) {
            this.addSlotToContainer(new Slot(this._b, n2, 8 + n2 * 18, 161 + n3));
        }
    }

    public void _a(int n) {
        if (n > 0) {
            this._c = n;
            this._a();
            this._b();
        }
    }

    public int _c() {
        return this._c;
    }

    protected abstract Slot _a(int var1, int var2, int var3);
}

