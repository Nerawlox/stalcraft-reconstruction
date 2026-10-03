/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.oredict;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class ShapelessOreRecipe
implements lpso {
    private ItemStack output = null;
    private ArrayList input = new ArrayList();

    public ShapelessOreRecipe(Block block, Object ... objectArray) {
        this(new ItemStack(block), objectArray);
    }

    public ShapelessOreRecipe(Item item, Object ... objectArray) {
        this(new ItemStack(item), objectArray);
    }

    public ShapelessOreRecipe(ItemStack itemStack, Object ... objectArray) {
        this.output = itemStack._l();
        for (Object object : objectArray) {
            if (object instanceof ItemStack) {
                this.input.add(((ItemStack)object)._l());
                continue;
            }
            if (object instanceof Item) {
                this.input.add(new ItemStack((Item)object));
                continue;
            }
            if (object instanceof Block) {
                this.input.add(new ItemStack((Block)object));
                continue;
            }
            if (object instanceof String) {
                this.input.add(OreDictionary.getOres((String)object));
                continue;
            }
            String string = "Invalid shapeless ore recipe: ";
            for (Object object2 : objectArray) {
                string = string + object2 + ", ";
            }
            string = string + this.output;
            throw new RuntimeException(string);
        }
    }

    ShapelessOreRecipe(vmoj vmoj2, Map<ItemStack, String> map) {
        this.output = vmoj2.getRecipeOutput();
        for (ItemStack itemStack : vmoj2._b) {
            Object object = itemStack;
            for (Map.Entry<ItemStack, String> entry : map.entrySet()) {
                if (!OreDictionary.itemMatches(entry.getKey(), itemStack, false)) continue;
                object = OreDictionary.getOres(entry.getValue());
                break;
            }
            this.input.add(object);
        }
    }

    @Override
    public int getRecipeSize() {
        return this.input.size();
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.output;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return this.output._l();
    }

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        ArrayList arrayList = new ArrayList(this.input);
        for (int i = 0; i < inventoryCrafting.getSizeInventory(); ++i) {
            ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
            if (itemStack == null) continue;
            boolean bl = false;
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                boolean bl2 = false;
                Object e = iterator.next();
                if (e instanceof ItemStack) {
                    bl2 = this.checkItemEquals((ItemStack)e, itemStack);
                } else if (e instanceof ArrayList) {
                    for (ItemStack itemStack2 : (ArrayList)e) {
                        bl2 = bl2 || this.checkItemEquals(itemStack2, itemStack);
                    }
                }
                if (!bl2) continue;
                bl = true;
                arrayList.remove(e);
                break;
            }
            if (bl) continue;
            return false;
        }
        return arrayList.isEmpty();
    }

    private boolean checkItemEquals(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack._d == itemStack2._d && (itemStack._j() == Short.MAX_VALUE || itemStack._j() == itemStack2._j());
    }

    public ArrayList getInput() {
        return this.input;
    }
}

