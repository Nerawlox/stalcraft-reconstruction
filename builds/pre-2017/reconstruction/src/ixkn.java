/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ixkn
extends xbtf {
    public ixkn() {
        super(3, 3, new ItemStack[]{new ItemStack(Item.paper), new ItemStack(Item.paper), new ItemStack(Item.paper), new ItemStack(Item.paper), new ItemStack(Item.map, 0, Short.MAX_VALUE), new ItemStack(Item.paper), new ItemStack(Item.paper), new ItemStack(Item.paper), new ItemStack(Item.paper)}, new ItemStack(Item.emptyMap, 0, 0));
    }

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        if (!super.matches(inventoryCrafting, world)) {
            return false;
        }
        ItemStack itemStack = null;
        for (int i = 0; i < inventoryCrafting.getSizeInventory() && itemStack == null; ++i) {
            ItemStack itemStack2 = inventoryCrafting.getStackInSlot(i);
            if (itemStack2 == null || itemStack2._d != Item.map.itemID) continue;
            itemStack = itemStack2;
        }
        if (itemStack == null) {
            return false;
        }
        thdd thdd2 = Item.map._a(itemStack, world);
        if (thdd2 == null) {
            return false;
        }
        return thdd2._d < 4;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        ItemStack itemStack = null;
        for (int i = 0; i < inventoryCrafting.getSizeInventory() && itemStack == null; ++i) {
            ItemStack itemStack2 = inventoryCrafting.getStackInSlot(i);
            if (itemStack2 == null || itemStack2._d != Item.map.itemID) continue;
            itemStack = itemStack2;
        }
        itemStack = itemStack._l();
        itemStack._b = 1;
        if (itemStack._q() == null) {
            itemStack._d(new NBTTagCompound());
        }
        itemStack._q()._a("map_is_scaling", true);
        return itemStack;
    }
}

