/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

public class lplm
extends Container {
    public TileEntityFurnace _a;
    public int _b;
    public int _c;
    public int _d;

    public lplm(InventoryPlayer inventoryPlayer, TileEntityFurnace tileEntityFurnace) {
        int n;
        this._a = tileEntityFurnace;
        this.addSlotToContainer(new Slot(tileEntityFurnace, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileEntityFurnace, 1, 56, 53));
        this.addSlotToContainer(new ohwi(inventoryPlayer._e, tileEntityFurnace, 2, 116, 35));
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
        iCrafting.sendProgressBarUpdate(this, 0, this._a._g);
        iCrafting.sendProgressBarUpdate(this, 1, this._a._e);
        iCrafting.sendProgressBarUpdate(this, 2, this._a._f);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i) {
            ICrafting iCrafting = (ICrafting)this.crafters.get(i);
            if (this._b != this._a._g) {
                iCrafting.sendProgressBarUpdate(this, 0, this._a._g);
            }
            if (this._c != this._a._e) {
                iCrafting.sendProgressBarUpdate(this, 1, this._a._e);
            }
            if (this._d == this._a._f) continue;
            iCrafting.sendProgressBarUpdate(this, 2, this._a._f);
        }
        this._b = this._a._g;
        this._c = this._a._e;
        this._d = this._a._f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int n, int n2) {
        if (n == 0) {
            this._a._g = n2;
        }
        if (n == 1) {
            this._a._e = n2;
        }
        if (n == 2) {
            this._a._f = n2;
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
            if (n == 2) {
                if (!this.mergeItemStack(itemStack2, 3, 39, true)) {
                    return null;
                }
                slot.onSlotChange(itemStack2, itemStack);
            } else if (n != 1 && n != 0 ? (yewu._a()._a(itemStack2) != null ? !this.mergeItemStack(itemStack2, 0, 1, false) : (TileEntityFurnace._b(itemStack2) ? !this.mergeItemStack(itemStack2, 1, 2, false) : (n >= 3 && n < 30 ? !this.mergeItemStack(itemStack2, 30, 39, false) : n >= 30 && n < 39 && !this.mergeItemStack(itemStack2, 3, 30, false)))) : !this.mergeItemStack(itemStack2, 3, 39, false)) {
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

