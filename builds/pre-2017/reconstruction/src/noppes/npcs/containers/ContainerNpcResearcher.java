/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.misc.sajh;
import gloomyfolken.mods.core.misc.srli;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerNpcResearcher
extends Container {
    private final EntityPlayer player;
    private final ofxb researchInventory;
    private final SlotResearch researchSlot;

    public ContainerNpcResearcher(EntityPlayer entityPlayer) {
        int n;
        this.player = entityPlayer;
        for (n = 0; n < 3; ++n) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, i + n * 9 + 9, 8 + i * 18, 70 + n * 18));
            }
        }
        for (n = 0; n < 9; ++n) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n, 8 + n * 18, 127));
        }
        this.researchInventory = new ofxb(1);
        this.researchSlot = new SlotResearch(this.researchInventory, 0, 80, 29);
        this.addSlotToContainer(this.researchSlot);
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
            } else if (itemStack._a() instanceof srli && !this.researchSlot.getHasStack()) {
                ItemStack itemStack3 = itemStack2._l();
                itemStack3._b = 1;
                --itemStack2._b;
                this.researchSlot.putStack(itemStack3);
            }
            if (itemStack2._b == 0) {
                slot.putStack(null);
            }
            if (itemStack2._b == itemStack._b) {
                return null;
            }
            slot.onPickupFromSlot(this.player, itemStack2);
        }
        return itemStack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    public ItemStack getSelectedStack() {
        return this.researchSlot.getStack();
    }

    public void probeItem() {
        ItemStack itemStack = this.researchSlot.getStack();
        if (itemStack != null && itemStack._a() instanceof srli) {
            srli srli2 = (srli)((Object)itemStack._a());
            srli2._f(itemStack);
            sajh._n._a(itemStack, null, false);
        }
        this.detectAndSendChanges();
    }

    @Override
    public void onContainerClosed(EntityPlayer entityPlayer) {
        super.onContainerClosed(entityPlayer);
        if (!entityPlayer.worldObj.isRemote && this.researchSlot.getHasStack()) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    static class SlotResearch
    extends Slot {
        public SlotResearch(IInventory iInventory, int n, int n2, int n3) {
            super(iInventory, n, n2, n3);
        }

        @Override
        public int getSlotStackLimit() {
            return 1;
        }

        @Override
        public boolean isItemValid(ItemStack itemStack) {
            return itemStack == null || itemStack._a() instanceof srli;
        }
    }
}

