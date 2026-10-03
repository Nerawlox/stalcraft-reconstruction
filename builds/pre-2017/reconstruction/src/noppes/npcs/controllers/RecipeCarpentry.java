/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.controllers;

import java.util.HashMap;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import noppes.npcs.NBTTags;
import noppes.npcs.controllers.Availability;

public class RecipeCarpentry
implements lpso {
    public int id = -1;
    public String name = "";
    public int recipeWidth = 4;
    public int recipeHeight = 4;
    public ItemStack recipeOutput;
    public Availability availability = new Availability();
    public boolean isGlobal = false;
    public boolean ignoreDamage = false;
    private ItemStack[] recipeItems = new ItemStack[16];

    public RecipeCarpentry() {
    }

    public RecipeCarpentry(int n, String string) {
        this.id = n;
        this.name = string;
    }

    public void readNBT(NBTTagCompound nBTTagCompound) {
        this.id = nBTTagCompound._f("ID");
        this.recipeWidth = nBTTagCompound._f("Width");
        this.recipeHeight = nBTTagCompound._f("Height");
        this.recipeOutput = ItemStack._a(nBTTagCompound._m("Item"));
        this.recipeItems = NBTTags.getItemStackArray(nBTTagCompound._n("Materials"));
        this.availability.readFromNBT(nBTTagCompound._m("Availability"));
        this.ignoreDamage = nBTTagCompound._o("IgnoreDamage");
        this.name = nBTTagCompound._j("Name");
        this.isGlobal = nBTTagCompound._o("Global");
    }

    public NBTTagCompound writeNBT() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound._a("ID", this.id);
        nBTTagCompound._a("Width", this.recipeWidth);
        nBTTagCompound._a("Height", this.recipeHeight);
        if (this.recipeOutput != null) {
            nBTTagCompound._a("Item", this.recipeOutput._b(new NBTTagCompound()));
        }
        nBTTagCompound._a("Materials", NBTTags.nbtItemStackArray(this.recipeItems));
        nBTTagCompound._a("Availability", this.availability.writeToNBT(new NBTTagCompound()));
        nBTTagCompound._a("Name", this.name);
        nBTTagCompound._a("Global", this.isGlobal);
        nBTTagCompound._a("IgnoreDamage", this.ignoreDamage);
        return nBTTagCompound;
    }

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        for (int i = 0; i <= 4 - this.recipeWidth; ++i) {
            for (int j = 0; j <= 4 - this.recipeHeight; ++j) {
                if (this.checkMatch(inventoryCrafting, i, j, true)) {
                    return true;
                }
                if (!this.checkMatch(inventoryCrafting, i, j, false)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean checkMatch(InventoryCrafting inventoryCrafting, int n, int n2, boolean bl) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                ItemStack itemStack;
                int n3 = i - n;
                int n4 = j - n2;
                ItemStack itemStack2 = null;
                if (n3 >= 0 && n4 >= 0 && n3 < this.recipeWidth && n4 < this.recipeHeight) {
                    itemStack2 = bl ? this.recipeItems[this.recipeWidth - n3 - 1 + n4 * this.recipeWidth] : this.recipeItems[n3 + n4 * this.recipeWidth];
                }
                if ((itemStack = inventoryCrafting.getStackInRowAndColumn(i, j)) == null && itemStack2 == null || ncwh._a(itemStack2, itemStack, this.ignoreDamage)) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        return this.recipeOutput == null ? null : this.recipeOutput._l();
    }

    @Override
    public int getRecipeSize() {
        return 16;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return this.recipeOutput;
    }

    public void addRecipe(ItemStack itemStack, Object ... objectArray) {
        int n;
        int n2;
        Object object;
        Object object2;
        String string = "";
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        if (objectArray[n3] instanceof String[]) {
            object2 = (String[])objectArray[n3++];
            object = object2;
            n2 = ((String[])object2).length;
            for (n = 0; n < n2; ++n) {
                String string2 = object[n];
                ++n5;
                n4 = string2.length();
                string = string + string2;
            }
        } else {
            while (objectArray[n3] instanceof String) {
                object2 = (String)objectArray[n3++];
                ++n5;
                n4 = ((String)object2).length();
                string = string + (String)object2;
            }
        }
        object2 = new HashMap();
        while (n3 < objectArray.length) {
            object = (Character)objectArray[n3];
            ItemStack itemStack2 = null;
            if (objectArray[n3 + 1] instanceof Item) {
                itemStack2 = new ItemStack((Item)objectArray[n3 + 1]);
            } else if (objectArray[n3 + 1] instanceof Block) {
                itemStack2 = new ItemStack((Block)objectArray[n3 + 1], 1, -1);
            } else if (objectArray[n3 + 1] instanceof ItemStack) {
                itemStack2 = (ItemStack)objectArray[n3 + 1];
            }
            ((HashMap)object2).put(object, itemStack2);
            n3 += 2;
        }
        object = new ItemStack[n4 * n5];
        for (n2 = 0; n2 < n4 * n5; ++n2) {
            n = string.charAt(n2);
            object[n2] = ((HashMap)object2).containsKey(Character.valueOf((char)n)) ? ((ItemStack)((HashMap)object2).get(Character.valueOf((char)n)))._l() : null;
        }
        this.recipeOutput = itemStack;
        this.recipeItems = object;
        this.recipeWidth = n4;
        this.recipeHeight = n5;
        if (n4 == 4 || n5 == 4) {
            this.isGlobal = false;
        }
    }

    public ItemStack getCraftingItem(int n) {
        return this.recipeItems != null && n < this.recipeItems.length ? this.recipeItems[n] : null;
    }

    public void setCraftingItem(int n, ItemStack itemStack) {
        if (n < this.recipeItems.length) {
            this.recipeItems[n] = itemStack;
        }
    }

    public void clear() {
        this.recipeOutput = null;
        this.recipeItems = new ItemStack[16];
    }
}

