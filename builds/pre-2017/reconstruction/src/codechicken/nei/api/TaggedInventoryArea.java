/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.api;

import java.util.HashSet;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class TaggedInventoryArea {
    public HashSet<Integer> slots = new HashSet();
    public String tag;
    private IInventory inventory;
    private Container container;

    public TaggedInventoryArea(InventoryPlayer inventoryPlayer) {
        this("InventoryPlayer", 0, 39, null);
        this.inventory = inventoryPlayer;
    }

    public TaggedInventoryArea(String string, int n, int n2, Container container) {
        this.container = container;
        this.tag = string;
        for (int i = n; i <= n2; ++i) {
            this.slots.add(i);
        }
    }

    public ItemStack getStackInSlot(int n) {
        if (this.inventory != null) {
            return this.inventory.getStackInSlot(n);
        }
        return this.container.getSlot(n).getStack();
    }

    public boolean isContainer() {
        return this.inventory == null;
    }
}

