/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class qoaz
implements lpso {
    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        int n = 0;
        ItemStack itemStack = null;
        for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            ItemStack itemStack2 = inventoryCrafting.getStackInSlot(i);
            if (itemStack2 == null) continue;
            if (itemStack2._d == Item.map.itemID) {
                if (itemStack != null) {
                    return false;
                }
                itemStack = itemStack2;
                continue;
            }
            if (itemStack2._d == Item.emptyMap.itemID) {
                ++n;
                continue;
            }
            return false;
        }
        return itemStack != null && n > 0;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        int n = 0;
        ItemStack itemStack = null;
        for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            ItemStack itemStack2 = inventoryCrafting.getStackInSlot(i);
            if (itemStack2 == null) continue;
            if (itemStack2._d == Item.map.itemID) {
                if (itemStack != null) {
                    return null;
                }
                itemStack = itemStack2;
                continue;
            }
            if (itemStack2._d == Item.emptyMap.itemID) {
                ++n;
                continue;
            }
            return null;
        }
        if (itemStack == null || n < 1) {
            return null;
        }
        ItemStack itemStack3 = new ItemStack(Item.map, n + 1, itemStack._j());
        if (itemStack._u()) {
            itemStack3._a(itemStack._s());
        }
        return itemStack3;
    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
}

