/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.oredict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class ShapedOreRecipe
implements lpso {
    private static final int MAX_CRAFT_GRID_WIDTH = 3;
    private static final int MAX_CRAFT_GRID_HEIGHT = 3;
    private ItemStack output = null;
    private Object[] input = null;
    private int width = 0;
    private int height = 0;
    private boolean mirrored = true;

    public ShapedOreRecipe(Block block, Object ... objectArray) {
        this(new ItemStack(block), objectArray);
    }

    public ShapedOreRecipe(Item item, Object ... objectArray) {
        this(new ItemStack(item), objectArray);
    }

    /*
     * WARNING - void declaration
     */
    public ShapedOreRecipe(ItemStack itemStack, Object ... objectArray) {
        void var9_22;
        Object object;
        this.output = itemStack._l();
        String string = "";
        int n = 0;
        if (objectArray[n] instanceof Boolean) {
            this.mirrored = (Boolean)objectArray[n];
            if (objectArray[n + 1] instanceof Object[]) {
                objectArray = (Object[])objectArray[n + 1];
            } else {
                n = 1;
            }
        }
        if (objectArray[n] instanceof String[]) {
            object = (String[])objectArray[n++];
            for (String string2 : object) {
                this.width = string2.length();
                string = string + string2;
            }
            this.height = ((String[])object).length;
        } else {
            while (objectArray[n] instanceof String) {
                object = (String)objectArray[n++];
                string = string + (String)object;
                this.width = ((String)object).length();
                ++this.height;
            }
        }
        if (this.width * this.height != string.length()) {
            object = "Invalid shaped ore recipe: ";
            for (Object object2 : objectArray) {
                object = (String)object + object2 + ", ";
            }
            object = (String)object + this.output;
            throw new RuntimeException((String)object);
        }
        object = new HashMap();
        while (n < objectArray.length) {
            Character c = (Character)objectArray[n];
            Object object3 = objectArray[n + 1];
            if (object3 instanceof ItemStack) {
                ((HashMap)object).put(c, ((ItemStack)object3)._l());
            } else if (object3 instanceof Item) {
                ((HashMap)object).put(c, new ItemStack((Item)object3));
            } else if (object3 instanceof Block) {
                ((HashMap)object).put(c, new ItemStack((Block)object3, 1, Short.MAX_VALUE));
            } else if (object3 instanceof String) {
                ((HashMap)object).put(c, OreDictionary.getOres((String)object3));
            } else {
                String string3 = "Invalid shaped ore recipe: ";
                for (Object object4 : objectArray) {
                    string3 = string3 + object4 + ", ";
                }
                string3 = string3 + this.output;
                throw new RuntimeException(string3);
            }
            n += 2;
        }
        this.input = new Object[this.width * this.height];
        boolean bl = false;
        char[] cArray = string.toCharArray();
        int n2 = cArray.length;
        boolean bl2 = false;
        while (var9_22 < n2) {
            char c = cArray[var9_22];
            this.input[++var6_11] = ((HashMap)object).get(Character.valueOf(c));
            ++var9_22;
        }
    }

    ShapedOreRecipe(xbtf xbtf2, Map<ItemStack, String> map) {
        this.output = xbtf2.getRecipeOutput();
        this.width = xbtf2._a;
        this.height = xbtf2._b;
        this.input = new Object[xbtf2._c.length];
        block0: for (int i = 0; i < this.input.length; ++i) {
            ItemStack itemStack = xbtf2._c[i];
            if (itemStack == null) continue;
            this.input[i] = xbtf2._c[i];
            for (Map.Entry<ItemStack, String> entry : map.entrySet()) {
                if (!OreDictionary.itemMatches(entry.getKey(), itemStack, true)) continue;
                this.input[i] = OreDictionary.getOres(entry.getValue());
                continue block0;
            }
        }
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return this.output._l();
    }

    @Override
    public int getRecipeSize() {
        return this.input.length;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.output;
    }

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        for (int i = 0; i <= 3 - this.width; ++i) {
            for (int j = 0; j <= 3 - this.height; ++j) {
                if (this.checkMatch(inventoryCrafting, i, j, false)) {
                    return true;
                }
                if (!this.mirrored || !this.checkMatch(inventoryCrafting, i, j, true)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean checkMatch(InventoryCrafting inventoryCrafting, int n, int n2, boolean bl) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                int n3 = i - n;
                int n4 = j - n2;
                Object object = null;
                if (n3 >= 0 && n4 >= 0 && n3 < this.width && n4 < this.height) {
                    object = bl ? this.input[this.width - n3 - 1 + n4 * this.width] : this.input[n3 + n4 * this.width];
                }
                ItemStack itemStack = inventoryCrafting.getStackInRowAndColumn(i, j);
                if (object instanceof ItemStack) {
                    if (this.checkItemEquals((ItemStack)object, itemStack)) continue;
                    return false;
                }
                if (object instanceof ArrayList) {
                    boolean bl2 = false;
                    for (ItemStack itemStack2 : (ArrayList)object) {
                        bl2 = bl2 || this.checkItemEquals(itemStack2, itemStack);
                    }
                    if (bl2) continue;
                    return false;
                }
                if (object != null || itemStack == null) continue;
                return false;
            }
        }
        return true;
    }

    private boolean checkItemEquals(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack2 == null && itemStack != null || itemStack2 != null && itemStack == null) {
            return false;
        }
        return itemStack._d == itemStack2._d && (itemStack._j() == Short.MAX_VALUE || itemStack._j() == itemStack2._j());
    }

    public ShapedOreRecipe setMirrored(boolean bl) {
        this.mirrored = bl;
        return this;
    }

    public Object[] getInput() {
        return this.input;
    }
}

