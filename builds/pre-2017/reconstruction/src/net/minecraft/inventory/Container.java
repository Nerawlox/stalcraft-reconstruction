/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.inventory;

import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.sajh;

public abstract class Container {
    public List inventoryItemStacks = new ArrayList();
    public List inventorySlots = new ArrayList();
    public int windowId;
    public short transactionID;
    public int field_94535_f = -1;
    public int field_94536_g;
    public final Set field_94537_h = new HashSet();
    public List crafters = new ArrayList();
    public Set playerList = new HashSet();

    public Slot addSlotToContainer(Slot slot) {
        slot.slotNumber = this.inventorySlots.size();
        this.inventorySlots.add(slot);
        this.inventoryItemStacks.add(null);
        return slot;
    }

    public void func_75132_a(ICrafting iCrafting) {
        if (this.crafters.contains(iCrafting)) {
            throw new IllegalArgumentException("Listener already listening");
        }
        this.crafters.add(iCrafting);
        iCrafting.func_71110_a(this, this.getInventory());
        this.detectAndSendChanges();
    }

    public void removeCraftingFromCrafters(ICrafting iCrafting) {
        this.crafters.remove(iCrafting);
    }

    public List getInventory() {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (int i = 0; i < this.inventorySlots.size(); ++i) {
            arrayList.add(((Slot)this.inventorySlots.get(i)).getStack());
        }
        return arrayList;
    }

    public void detectAndSendChanges() {
        for (int i = 0; i < this.inventorySlots.size(); ++i) {
            ItemStack itemStack = ((Slot)this.inventorySlots.get(i)).getStack();
            ItemStack itemStack2 = (ItemStack)this.inventoryItemStacks.get(i);
            if (ItemStack._b(itemStack2, itemStack)) continue;
            itemStack2 = itemStack == null ? null : itemStack._l();
            this.inventoryItemStacks.set(i, itemStack2);
            for (int j = 0; j < this.crafters.size(); ++j) {
                ((ICrafting)this.crafters.get(j)).sendSlotContents(this, i, itemStack2);
            }
        }
    }

    public boolean enchantItem(EntityPlayer entityPlayer, int n) {
        return false;
    }

    public Slot getSlotFromInventory(IInventory iInventory, int n) {
        for (int i = 0; i < this.inventorySlots.size(); ++i) {
            Slot slot = (Slot)this.inventorySlots.get(i);
            if (!slot.func_75217_a(iInventory, n)) continue;
            return slot;
        }
        return null;
    }

    public Slot getSlot(int n) {
        return (Slot)this.inventorySlots.get(n);
    }

    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null) {
            return slot.getStack();
        }
        return null;
    }

    public ItemStack slotClick(int n, int n2, int n3, EntityPlayer entityPlayer) {
        ItemStack itemStack = GloomyHooks.slotClick(this, n, n2, n3, entityPlayer);
        return itemStack;
    }

    public boolean func_94530_a(ItemStack itemStack, Slot slot) {
        return true;
    }

    public void retrySlotClick(int n, int n2, boolean bl, EntityPlayer entityPlayer) {
        this.slotClick(n, n2, 1, entityPlayer);
    }

    public void onContainerClosed(EntityPlayer entityPlayer) {
        InventoryPlayer inventoryPlayer = entityPlayer.inventory;
        if (inventoryPlayer._g() != null) {
            entityPlayer.dropPlayerItem(inventoryPlayer._g());
            inventoryPlayer._d(null);
        }
    }

    public void onCraftMatrixChanged(IInventory iInventory) {
        this.detectAndSendChanges();
    }

    public void putStackInSlot(int n, ItemStack itemStack) {
        this.getSlot(n).putStack(itemStack);
    }

    public void putStacksInSlots(ItemStack[] itemStackArray) {
        for (int i = 0; i < itemStackArray.length; ++i) {
            this.getSlot(i).putStack(itemStackArray[i]);
        }
    }

    public void updateProgressBar(int n, int n2) {
    }

    public short getNextTransactionID(InventoryPlayer inventoryPlayer) {
        this.transactionID = (short)(this.transactionID + 1);
        return this.transactionID;
    }

    public boolean func_75129_b(EntityPlayer entityPlayer) {
        return !this.playerList.contains(entityPlayer);
    }

    public void func_75128_a(EntityPlayer entityPlayer, boolean bl) {
        if (bl) {
            this.playerList.remove(entityPlayer);
        } else {
            this.playerList.add(entityPlayer);
        }
    }

    public abstract boolean canInteractWith(EntityPlayer var1);

    public boolean mergeItemStack(ItemStack itemStack, int n, int n2, boolean bl) {
        ItemStack itemStack2;
        Slot slot;
        boolean bl2 = false;
        int n3 = n;
        if (bl) {
            n3 = n2 - 1;
        }
        if (itemStack._e()) {
            while (itemStack._b > 0 && (!bl && n3 < n2 || bl && n3 >= n)) {
                slot = (Slot)this.inventorySlots.get(n3);
                itemStack2 = slot.getStack();
                if (itemStack2 != null && itemStack2._d == itemStack._d && (!itemStack._g() || itemStack._j() == itemStack2._j()) && ItemStack._a(itemStack, itemStack2)) {
                    int n4 = itemStack2._b + itemStack._b;
                    if (n4 <= itemStack._d()) {
                        itemStack._b = 0;
                        itemStack2._b = n4;
                        slot.onSlotChanged();
                        bl2 = true;
                    } else if (itemStack2._b < itemStack._d()) {
                        itemStack._b -= itemStack._d() - itemStack2._b;
                        itemStack2._b = itemStack._d();
                        slot.onSlotChanged();
                        bl2 = true;
                    }
                }
                if (bl) {
                    --n3;
                    continue;
                }
                ++n3;
            }
        }
        if (itemStack._b > 0) {
            n3 = bl ? n2 - 1 : n;
            while (!bl && n3 < n2 || bl && n3 >= n) {
                slot = (Slot)this.inventorySlots.get(n3);
                itemStack2 = slot.getStack();
                if (itemStack2 == null) {
                    slot.putStack(itemStack._l());
                    slot.onSlotChanged();
                    itemStack._b = 0;
                    bl2 = true;
                    break;
                }
                if (bl) {
                    --n3;
                    continue;
                }
                ++n3;
            }
        }
        return bl2;
    }

    public static int func_94529_b(int n) {
        return n >> 2 & 3;
    }

    public static int func_94532_c(int n) {
        return n & 3;
    }

    public static int func_94534_d(int n, int n2) {
        return n & 3 | (n2 & 3) << 2;
    }

    public static boolean func_94528_d(int n) {
        return n == 0 || n == 1;
    }

    public void func_94533_d() {
        this.field_94536_g = 0;
        this.field_94537_h.clear();
    }

    public static boolean func_94527_a(Slot slot, ItemStack itemStack, boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = slot == null || !slot.getHasStack();
        if (slot != null && slot.getHasStack() && itemStack != null && itemStack._b(slot.getStack()) && ItemStack._a(slot.getStack(), itemStack)) {
            bl2 |= slot.getStack()._b + (bl ? 0 : itemStack._b) <= itemStack._d();
        }
        return bl2;
    }

    public static void func_94525_a(Set set, int n, ItemStack itemStack, int n2) {
        switch (n) {
            case 0: {
                itemStack._b = sajh._d((float)itemStack._b / (float)set.size());
                break;
            }
            case 1: {
                itemStack._b = 1;
            }
        }
        itemStack._b += n2;
    }

    public boolean canDragIntoSlot(Slot slot) {
        return true;
    }

    public static int calcRedstoneFromInventory(IInventory iInventory) {
        if (iInventory == null) {
            return 0;
        }
        int n = 0;
        float f = 0.0f;
        for (int i = 0; i < iInventory.getSizeInventory(); ++i) {
            ItemStack itemStack = iInventory.getStackInSlot(i);
            if (itemStack == null) continue;
            f += (float)itemStack._b / (float)Math.min(iInventory.getInventoryStackLimit(), itemStack._d());
            ++n;
        }
        return sajh._d((f /= (float)iInventory.getSizeInventory()) * 14.0f) + (n > 0 ? 1 : 0);
    }
}

