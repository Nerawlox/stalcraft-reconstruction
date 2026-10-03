/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.inventory;

import codechicken.core.inventory.SlotHandleClicks;
import codechicken.lib.packet.PacketCustom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class ContainerExtended
extends Container
implements ICrafting {
    public LinkedList<EntityPlayerMP> playerCrafters = new LinkedList();

    public ContainerExtended() {
        this.crafters.add(this);
    }

    @Override
    public void func_75132_a(ICrafting iCrafting) {
        if (iCrafting instanceof EntityPlayerMP) {
            this.playerCrafters.add((EntityPlayerMP)iCrafting);
            this.sendContainerAndContentsToPlayer(this, this.getInventory(), Arrays.asList((EntityPlayerMP)iCrafting));
            this.detectAndSendChanges();
        } else {
            super.func_75132_a(iCrafting);
        }
    }

    @Override
    public void removeCraftingFromCrafters(ICrafting iCrafting) {
        if (iCrafting instanceof EntityPlayerMP) {
            this.playerCrafters.remove(iCrafting);
        } else {
            super.removeCraftingFromCrafters(iCrafting);
        }
    }

    @Override
    public void func_71110_a(Container container, List list) {
        this.sendContainerAndContentsToPlayer(container, list, this.playerCrafters);
    }

    public void sendContainerAndContentsToPlayer(Container container, List<ItemStack> list, List<EntityPlayerMP> list2) {
        LinkedList<ItemStack> linkedList = new LinkedList<ItemStack>();
        for (int i = 0; i < list.size(); ++i) {
            ItemStack object2 = list.get(i);
            if (object2 != null && object2._b > 127) {
                list.set(i, null);
                linkedList.add(object2);
                continue;
            }
            linkedList.add(null);
        }
        for (EntityPlayerMP entityPlayerMP : list2) {
            entityPlayerMP.func_71110_a(container, list);
        }
        for (int i = 0; i < linkedList.size(); ++i) {
            ItemStack itemStack = (ItemStack)linkedList.get(i);
            if (itemStack == null) continue;
            this.sendLargeStack(itemStack, i, list2);
        }
    }

    public void sendLargeStack(ItemStack itemStack, int n, List<EntityPlayerMP> list) {
    }

    @Override
    public void sendProgressBarUpdate(Container container, int n, int n2) {
        for (EntityPlayerMP entityPlayerMP : this.playerCrafters) {
            entityPlayerMP.sendProgressBarUpdate(container, n, n2);
        }
    }

    @Override
    public void sendSlotContents(Container container, int n, ItemStack itemStack) {
        if (itemStack != null && itemStack._b > 127) {
            this.sendLargeStack(itemStack, n, this.playerCrafters);
        } else {
            for (EntityPlayerMP entityPlayerMP : this.playerCrafters) {
                entityPlayerMP.sendSlotContents(container, n, itemStack);
            }
        }
    }

    @Override
    public ItemStack slotClick(int n, int n2, int n3, EntityPlayer entityPlayer) {
        Slot slot;
        if (n >= 0 && n < this.inventorySlots.size() && (slot = this.getSlot(n)) instanceof SlotHandleClicks) {
            return ((SlotHandleClicks)slot).slotClick(this, entityPlayer, n2, n3);
        }
        return super.slotClick(n, n2, n3, entityPlayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        ItemStack itemStack = null;
        Slot slot = (Slot)this.inventorySlots.get(n);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack2 = slot.getStack();
            itemStack = itemStack2._l();
            if (!this.doMergeStackAreas(n, itemStack2)) {
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
    public boolean mergeItemStack(ItemStack itemStack, int n, int n2, boolean bl) {
        Slot slot;
        int n3;
        boolean bl2 = false;
        int n4 = n3 = bl ? n2 - 1 : n;
        if (itemStack == null) {
            return false;
        }
        if (itemStack._e()) {
            while (itemStack._b > 0 && (bl ? n3 >= n : n3 < n2)) {
                slot = (Slot)this.inventorySlots.get(n3);
                ItemStack itemStack2 = slot.getStack();
                if (itemStack2 != null && itemStack2._d == itemStack._d && (!itemStack._g() || itemStack._j() == itemStack2._j()) && ItemStack._a(itemStack, itemStack2)) {
                    int n5 = itemStack2._b + itemStack._b;
                    int n6 = Math.min(itemStack._d(), slot.getSlotStackLimit());
                    if (n5 <= n6) {
                        itemStack._b = 0;
                        itemStack2._b = n5;
                        slot.onSlotChanged();
                        bl2 = true;
                    } else if (itemStack2._b < n6) {
                        itemStack._b -= n6 - itemStack2._b;
                        itemStack2._b = n6;
                        slot.onSlotChanged();
                        bl2 = true;
                    }
                }
                n3 += bl ? -1 : 1;
            }
        }
        if (itemStack._b > 0) {
            int n7 = n3 = bl ? n2 - 1 : n;
            while (itemStack._b > 0 && (bl ? n3 >= n : n3 < n2)) {
                slot = (Slot)this.inventorySlots.get(n3);
                if (!slot.getHasStack() && slot.isItemValid(itemStack)) {
                    int n8 = Math.min(itemStack._d(), slot.getSlotStackLimit());
                    if (itemStack._b <= n8) {
                        slot.putStack(itemStack._l());
                        slot.onSlotChanged();
                        itemStack._b = 0;
                        bl2 = true;
                    } else {
                        slot.putStack(itemStack._a(n8));
                        slot.onSlotChanged();
                        bl2 = true;
                    }
                }
                n3 += bl ? -1 : 1;
            }
        }
        return bl2;
    }

    public boolean doMergeStackAreas(int n, ItemStack itemStack) {
        return false;
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
        this.bindPlayerInventory(inventoryPlayer, 8, 84);
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer, int n, int n2) {
        int n3;
        for (n3 = 0; n3 < 3; ++n3) {
            for (int i = 0; i < 9; ++i) {
                this.addSlotToContainer(new Slot(inventoryPlayer, i + n3 * 9 + 9, n + i * 18, n2 + n3 * 18));
            }
        }
        for (n3 = 0; n3 < 9; ++n3) {
            this.addSlotToContainer(new Slot(inventoryPlayer, n3, n + n3 * 18, n2 + 58));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    public void sendContainerPacket(PacketCustom packetCustom) {
        for (EntityPlayerMP entityPlayerMP : this.playerCrafters) {
            packetCustom.sendToPlayer(entityPlayerMP);
        }
    }

    public void handleOutputPacket(PacketCustom packetCustom) {
    }

    public void handleInputPacket(PacketCustom packetCustom) {
    }

    public void handleGuiChange(int n, int n2) {
    }

    public void sendProgressBarUpdate(int n, int n2) {
        for (ICrafting iCrafting : this.crafters) {
            iCrafting.sendProgressBarUpdate(this, n, n2);
        }
    }
}

