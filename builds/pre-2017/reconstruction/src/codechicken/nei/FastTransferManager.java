/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class FastTransferManager {
    public LinkedList<LinkedList<Integer>> slotZones = new LinkedList();
    public HashMap<Integer, Integer> slotZoneMap = new HashMap();

    private void generateSlotMap(Container container, ItemStack itemStack) {
        itemStack = itemStack._l();
        itemStack._b = 1;
        for (int i = 0; i < container.inventorySlots.size(); ++i) {
            if (this.slotZoneMap.containsKey(i) || !container.getSlot(i).isItemValid(itemStack)) continue;
            HashSet<Integer> hashSet = new HashSet<Integer>();
            this.findConnectedSlots(container, i, hashSet);
            LinkedList<Integer> linkedList = new LinkedList<Integer>(hashSet);
            Collections.sort(linkedList, new SlotPositionComparator(container));
            this.slotZones.add(linkedList);
            Iterator iterator2 = linkedList.iterator();
            while (iterator2.hasNext()) {
                int n = (Integer)iterator2.next();
                this.slotZoneMap.put(n, this.slotZones.size() - 1);
            }
        }
    }

    private void findConnectedSlots(Container container, int n, HashSet<Integer> hashSet) {
        hashSet.add(n);
        Slot slot = container.getSlot(n);
        int n2 = 18;
        for (int i = 0; i < container.inventorySlots.size(); ++i) {
            if (hashSet.contains(i)) continue;
            Slot slot2 = container.getSlot(i);
            if (Math.abs(slot.xDisplayPosition - slot2.xDisplayPosition) > 18 || Math.abs(slot.yDisplayPosition - slot2.yDisplayPosition) > 18) continue;
            this.findConnectedSlots(container, i, hashSet);
        }
    }

    public static int findSlotWithItem(Container container, ItemStack itemStack) {
        for (int i = 0; i < container.inventorySlots.size(); ++i) {
            ItemStack itemStack2 = container.getSlot(i).getStack();
            if (itemStack2 == null || !NEIServerUtils.areStacksSameType(itemStack2, itemStack)) continue;
            return i;
        }
        return -1;
    }

    public static void clearSlots(Container container) {
        for (int i = 0; i < container.inventorySlots.size(); ++i) {
            ((Slot)container.inventorySlots.get(i)).putStack(null);
        }
    }

    public void performMassTransfer(GuiContainer guiContainer, int n, int n2, ItemStack itemStack) {
        this.generateSlotMap(guiContainer.inventorySlots, itemStack);
        Integer n3 = this.slotZoneMap.get(n);
        Integer n4 = this.slotZoneMap.get(n2);
        if (n3 == null || n4 == null || n3 == n4) {
            return;
        }
        if (NEIClientUtils.getHeldItem() != null && !NEIServerUtils.areStacksSameType(itemStack, NEIClientUtils.getHeldItem())) {
            return;
        }
        if (!this.fillZoneWithHeldItem(guiContainer, n4)) {
            return;
        }
        Iterator iterator2 = this.slotZones.get(n3).iterator();
        while (iterator2.hasNext()) {
            int n5 = (Integer)iterator2.next();
            ItemStack itemStack2 = guiContainer.inventorySlots.getSlot(n5).getStack();
            if (!NEIServerUtils.areStacksSameType(itemStack, itemStack2)) continue;
            FastTransferManager.clickSlot(guiContainer, n5);
            if (this.fillZoneWithHeldItem(guiContainer, n4)) continue;
            FastTransferManager.clickSlot(guiContainer, n5);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int findShiftClickDestinationSlot(Container container, int n) {
        LinkedList<ItemStack> linkedList = this.saveContainer(container);
        Slot slot = container.getSlot(n);
        ItemStack itemStack = slot.getStack();
        if (itemStack == null) {
            return -1;
        }
        itemStack._b = 1;
        slot.putStack(itemStack._l());
        LinkedList<ItemStack> linkedList2 = this.saveContainer(container);
        container.slotClick(n, 0, 1, NEIClientUtils.mc()._t);
        LinkedList<ItemStack> linkedList3 = this.saveContainer(container);
        try {
            int n2;
            for (n2 = 0; n2 < linkedList2.size(); ++n2) {
                ItemStack itemStack2;
                ItemStack itemStack3;
                if (n2 == n || NEIServerUtils.areStacksIdentical(itemStack3 = linkedList2.get(n2), itemStack2 = linkedList3.get(n2)) || itemStack2 == null || (itemStack3 != null || !NEIServerUtils.areStacksSameType(itemStack, itemStack2)) && (!NEIServerUtils.areStacksSameType(itemStack, itemStack2) || itemStack2._b - itemStack3._b <= 0)) continue;
                int n3 = n2;
                return n3;
            }
            n2 = -1;
            return n2;
        }
        finally {
            this.restoreContainer(container, linkedList);
        }
    }

    public LinkedList<ItemStack> saveContainer(Container container) {
        LinkedList<ItemStack> linkedList = new LinkedList<ItemStack>();
        for (int i = 0; i < container.inventorySlots.size(); ++i) {
            linkedList.add(NEIServerUtils.copyStack(container.getSlot(i).getStack()));
        }
        return linkedList;
    }

    public void restoreContainer(Container container, LinkedList<ItemStack> linkedList) {
        for (int i = 0; i < container.inventorySlots.size(); ++i) {
            container.getSlot(i).putStack(linkedList.get(i));
        }
        container.slotClick(-999, 0, 0, NEIClientUtils.mc()._t);
    }

    public void transferItem(GuiContainer guiContainer, int n) {
        int n2 = this.findShiftClickDestinationSlot(guiContainer.inventorySlots, n);
        if (n2 == -1) {
            return;
        }
        Slot slot = guiContainer.inventorySlots.getSlot(n);
        if (slot.isItemValid(slot.getStack())) {
            this.moveOneItem(guiContainer, n, n2);
        } else {
            this.moveOutputSet(guiContainer, n, n2);
        }
    }

    public void moveOutputSet(GuiContainer guiContainer, int n, int n2) {
        if (NEIClientUtils.getHeldItem() != null) {
            return;
        }
        FastTransferManager.clickSlot(guiContainer, n);
        if (NEIClientUtils.getHeldItem() == null) {
            return;
        }
        FastTransferManager.clickSlot(guiContainer, n2);
    }

    public void moveOneItem(GuiContainer guiContainer, int n, int n2) {
        FastTransferManager.clickSlot(guiContainer, n);
        FastTransferManager.clickSlot(guiContainer, n2, 1);
        FastTransferManager.clickSlot(guiContainer, n);
    }

    public void retrieveItem(GuiContainer guiContainer, int n) {
        Integer n2;
        Slot slot = guiContainer.inventorySlots.getSlot(n);
        ItemStack itemStack = slot.getStack();
        if (itemStack == null || itemStack._b == slot.getSlotStackLimit() || itemStack._b == itemStack._d()) {
            return;
        }
        this.generateSlotMap(guiContainer.inventorySlots, itemStack);
        Integer n3 = this.slotZoneMap.get(n);
        if (n3 == null) {
            return;
        }
        int n4 = this.findShiftClickDestinationSlot(guiContainer.inventorySlots, n);
        int n5 = -1;
        if (n4 != -1 && (n2 = this.slotZoneMap.get(n4)) != null && this.retrieveItemFromZone(guiContainer, n5 = n2.intValue(), n)) {
            return;
        }
        for (int i = 0; i < this.slotZones.size(); ++i) {
            if (i == n3 || i == n5 || !this.retrieveItemFromZone(guiContainer, i, n)) continue;
            return;
        }
        this.retrieveItemFromZone(guiContainer, n3, n);
    }

    private boolean retrieveItemFromZone(GuiContainer guiContainer, int n, int n2) {
        Slot slot;
        ItemStack itemStack;
        int n3;
        ItemStack itemStack2 = guiContainer.inventorySlots.getSlot(n2).getStack();
        Iterator iterator2 = this.slotZones.get(n).iterator();
        while (iterator2.hasNext()) {
            n3 = (Integer)iterator2.next();
            if (n3 == n2 || !NEIServerUtils.areStacksSameType(itemStack2, itemStack = (slot = guiContainer.inventorySlots.getSlot(n3)).getStack()) || itemStack._b == slot.getSlotStackLimit() || itemStack._b == itemStack._d()) continue;
            this.moveOneItem(guiContainer, n3, n2);
            return true;
        }
        iterator2 = this.slotZones.get(n).iterator();
        while (iterator2.hasNext()) {
            n3 = (Integer)iterator2.next();
            if (n3 == n2 || !NEIServerUtils.areStacksSameType(itemStack2, itemStack = (slot = guiContainer.inventorySlots.getSlot(n3)).getStack())) continue;
            this.moveOneItem(guiContainer, n3, n2);
            return true;
        }
        return false;
    }

    public static void clickSlot(GuiContainer guiContainer, int n) {
        FastTransferManager.clickSlot(guiContainer, n, 0);
    }

    public static void clickSlot(GuiContainer guiContainer, int n, int n2) {
        FastTransferManager.clickSlot(guiContainer, n, n2, 0);
    }

    public static void clickSlot(GuiContainer guiContainer, int n, int n2, int n3) {
        Container container = guiContainer.inventorySlots;
        Slot slot = null;
        if (n >= 0 && n < container.inventorySlots.size()) {
            slot = container.getSlot(n);
        }
        guiContainer.sendMouseClick(slot, n, n2, n3);
    }

    private boolean fillZoneWithHeldItem(GuiContainer guiContainer, int n) {
        ItemStack itemStack;
        ItemStack itemStack2;
        int n2;
        Iterator iterator2 = this.slotZones.get(n).iterator();
        while (iterator2.hasNext()) {
            n2 = (Integer)iterator2.next();
            itemStack2 = NEIClientUtils.getHeldItem();
            if (itemStack2 == null) break;
            itemStack = guiContainer.inventorySlots.getSlot(n2).getStack();
            if (!NEIServerUtils.areStacksSameType(itemStack, itemStack2)) continue;
            FastTransferManager.clickSlot(guiContainer, n2);
        }
        iterator2 = this.slotZones.get(n).iterator();
        while (iterator2.hasNext()) {
            n2 = (Integer)iterator2.next();
            itemStack2 = NEIClientUtils.getHeldItem();
            if (itemStack2 == null) break;
            itemStack = guiContainer.inventorySlots.getSlot(n2).getStack();
            if (itemStack != null) continue;
            FastTransferManager.clickSlot(guiContainer, n2);
        }
        return NEIClientUtils.getHeldItem() == null;
    }

    public void throwAll(GuiContainer guiContainer, int n) {
        ItemStack itemStack = NEIClientUtils.getHeldItem();
        if (itemStack == null) {
            return;
        }
        FastTransferManager.clickSlot(guiContainer, -999);
        this.generateSlotMap(guiContainer.inventorySlots, itemStack);
        Iterator iterator2 = this.slotZones.get(this.slotZoneMap.get(n)).iterator();
        while (iterator2.hasNext()) {
            int n2 = (Integer)iterator2.next();
            Slot slot = guiContainer.inventorySlots.getSlot(n2);
            if (!NEIServerUtils.areStacksSameType(itemStack, slot.getStack())) continue;
            FastTransferManager.clickSlot(guiContainer, n2);
            FastTransferManager.clickSlot(guiContainer, -999);
        }
    }

    public static class SlotPositionComparator
    implements Comparator<Integer> {
        Container container;

        public SlotPositionComparator(Container container) {
            this.container = container;
        }

        @Override
        public int compare(Integer n, Integer n2) {
            Slot slot = this.container.getSlot(n);
            Slot slot2 = this.container.getSlot(n2);
            if (slot2.yDisplayPosition != slot.yDisplayPosition) {
                return slot.yDisplayPosition - slot2.yDisplayPosition;
            }
            return slot.xDisplayPosition - slot2.xDisplayPosition;
        }
    }
}

