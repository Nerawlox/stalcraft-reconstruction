/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerMerchantAdd
extends Container {
    private final World theWorld;
    private IMerchant theMerchant;
    private InventoryBasic merchantInventory;

    public ContainerMerchantAdd(InventoryPlayer inventoryPlayer, IMerchant iMerchant, World world) {
        int n;
        this.theMerchant = iMerchant;
        this.theWorld = world;
        this.merchantInventory = new InventoryBasic("", false, 3);
        this.addSlotToContainer(new Slot(this.merchantInventory, 0, 36, 53));
        this.addSlotToContainer(new Slot(this.merchantInventory, 1, 62, 53));
        this.addSlotToContainer(new Slot(this.merchantInventory, 2, 120, 53));
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
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
    }

    @Override
    public void onCraftMatrixChanged(IInventory iInventory) {
        super.onCraftMatrixChanged(iInventory);
    }

    public void setCurrentRecipeIndex(int n) {
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void updateProgressBar(int n, int n2) {
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (n != 0 && n != 1 && n != 2 ? (n >= 3 && n < 30 ? !this.mergeItemStack(itemStack2, 30, 39, false) : n >= 30 && n < 39 && !this.mergeItemStack(itemStack2, 3, 30, false)) : !this.mergeItemStack(itemStack2, 3, 39, false)) {
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

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        this.theMerchant.setCustomer(null);
        super.onContainerClosed(entityPlayer);
        if (!this.theWorld.isRemote) {
            ItemStack itemStack = this.merchantInventory.getStackInSlotOnClosing(0);
            if (itemStack != null) {
                entityPlayer.dropPlayerItem(itemStack);
            }
            if ((itemStack = this.merchantInventory.getStackInSlotOnClosing(1)) != null) {
                entityPlayer.dropPlayerItem(itemStack);
            }
        }
    }
}

