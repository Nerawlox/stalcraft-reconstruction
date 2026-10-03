/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.containers;

import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import noppes.npcs.controllers.RecipeCarpentry;

public class ContainerManageRecipes
extends Container {
    public int size;
    public int width;
    private InventoryBasic craftingMatrix;
    private RecipeCarpentry recipe;
    private boolean init = false;

    public ContainerManageRecipes(EntityPlayer entityPlayer, int n) {
        int n2;
        int n3;
        this.size = n * n;
        this.width = n;
        this.craftingMatrix = new InventoryBasic("crafting", false, this.size + 1);
        this.recipe = new RecipeCarpentry();
        this.addSlotToContainer(new Slot(this.craftingMatrix, 0, 87, 44));
        for (n3 = 0; n3 < n; ++n3) {
            for (n2 = 0; n2 < n; ++n2) {
                this.addSlotToContainer(new Slot(this.craftingMatrix, n3 * this.width + n2 + 1, n2 * 18 + 8, n3 * 18 + 18));
            }
        }
        for (n3 = 0; n3 < 3; ++n3) {
            for (n2 = 0; n2 < 9; ++n2) {
                this.addSlotToContainer(new Slot(entityPlayer.inventory, n2 + n3 * 9 + 9, 8 + n2 * 18, 96 + n3 * 18));
            }
        }
        for (n3 = 0; n3 < 9; ++n3) {
            this.addSlotToContainer(new Slot(entityPlayer.inventory, n3, 8 + n3 * 18, 154));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        return null;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    public void setRecipe(RecipeCarpentry recipeCarpentry) {
        this.craftingMatrix.setInventorySlotContents(0, recipeCarpentry.recipeOutput);
        for (int i = 0; i < this.width; ++i) {
            for (int j = 0; j < this.width; ++j) {
                if (j >= recipeCarpentry.recipeWidth) {
                    this.craftingMatrix.setInventorySlotContents(i * this.width + j + 1, null);
                    continue;
                }
                this.craftingMatrix.setInventorySlotContents(i * this.width + j + 1, recipeCarpentry.getCraftingItem(i * recipeCarpentry.recipeWidth + j));
            }
        }
        this.recipe = recipeCarpentry;
    }

    public void saveRecipe() {
        Object object;
        int n;
        int n2 = 0;
        char[] cArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'};
        HashMap<ItemStack, Object> hashMap = new HashMap<ItemStack, Object>();
        int n3 = this.width;
        int n4 = 0;
        int n5 = this.width;
        int n6 = 0;
        boolean bl = false;
        for (int i = 0; i < this.width; ++i) {
            n = 0;
            for (int j = 0; j < this.width; ++j) {
                ItemStack itemStack = this.craftingMatrix.getStackInSlot(i * this.width + j + 1);
                if (itemStack == null) continue;
                if (n == 0 && j < n5) {
                    n5 = j;
                }
                if (j > n6) {
                    n6 = j;
                }
                n = 1;
                object = null;
                for (ItemStack itemStack2 : hashMap.keySet()) {
                    if (!ncwh._a(itemStack2, itemStack, false)) continue;
                    object = (Character)hashMap.get(itemStack2);
                }
                if (object != null) continue;
                object = Character.valueOf(cArray[n2]);
                ++n2;
                hashMap.put(itemStack, object);
            }
            if (n == 0) continue;
            if (!bl) {
                n3 = i;
                n4 = i;
                bl = true;
                continue;
            }
            n4 = i;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (n = 0; n < this.width; ++n) {
            if (n < n3 || n > n4) continue;
            String string = "";
            for (int i = 0; i < this.width; ++i) {
                if (i < n5 || i > n6) continue;
                object = this.craftingMatrix.getStackInSlot(n * this.width + i + 1);
                if (object == null) {
                    string = string + " ";
                    continue;
                }
                for (ItemStack itemStack2 : hashMap.keySet()) {
                    if (!ncwh._a(itemStack2, (ItemStack)object, false)) continue;
                    string = string + hashMap.get(itemStack2);
                }
            }
            arrayList.add(string);
        }
        if (hashMap.isEmpty()) {
            this.recipe.clear();
        } else {
            for (ItemStack itemStack : hashMap.keySet()) {
                Character c = (Character)hashMap.get(itemStack);
                arrayList.add(c);
                arrayList.add(itemStack);
            }
            this.recipe.addRecipe(this.craftingMatrix.getStackInSlot(0), arrayList.toArray());
        }
    }
}

