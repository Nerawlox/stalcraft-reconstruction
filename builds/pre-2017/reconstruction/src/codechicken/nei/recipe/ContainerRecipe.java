/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerRecipe
extends Container {
    private RecipeInventory recipeInventory = new RecipeInventory();

    public void clearInventory() {
        this.inventoryItemStacks.clear();
        this.inventorySlots.clear();
    }

    public ItemStack slotClick(int n, int n2, boolean bl, EntityPlayer entityPlayer) {
        if (n < 0) {
            return null;
        }
        ItemStack itemStack = this.recipeInventory.getStackInSlot(n);
        if (itemStack != null) {
            if (n2 == 0) {
                GuiCraftingRecipe.openRecipeGui("item", itemStack);
            } else if (n2 == 1) {
                GuiUsageRecipe.openRecipeGui("item", itemStack);
            }
        }
        return null;
    }

    public void addSlot(PositionedStack positionedStack, int n, int n2) {
        int n3 = this.inventorySlots.size();
        this.addSlotToContainer(new Slot(this.recipeInventory, n3, n + positionedStack.relx, n2 + positionedStack.rely){

            @Override
            public boolean isItemValid(ItemStack itemStack) {
                return false;
            }
        });
        this.recipeInventory.setInventorySlotContents(n3, positionedStack.item);
    }

    public Slot getSlotWithStack(PositionedStack positionedStack, int n, int n2) {
        for (int i = 0; i < this.inventorySlots.size(); ++i) {
            Slot slot = (Slot)this.inventorySlots.get(i);
            if (slot.xDisplayPosition != positionedStack.relx + n || slot.yDisplayPosition != positionedStack.rely + n2) continue;
            return slot;
        }
        return null;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void putStackInSlot(int n, ItemStack itemStack) {
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int n) {
        return null;
    }

    private class RecipeInventory
    implements IInventory {
        private RecipeInventory() {
        }

        @Override
        public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
            return true;
        }

        @Override
        public int getSizeInventory() {
            return ContainerRecipe.this.inventorySlots.size();
        }

        @Override
        public ItemStack getStackInSlot(int n) {
            if (n < 0 || n > ContainerRecipe.this.inventoryItemStacks.size()) {
                return null;
            }
            return (ItemStack)ContainerRecipe.this.inventoryItemStacks.get(n);
        }

        @Override
        public ItemStack decrStackSize(int n, int n2) {
            return null;
        }

        @Override
        public void setInventorySlotContents(int n, ItemStack itemStack) {
            if (n < 0 || n >= ContainerRecipe.this.inventoryItemStacks.size()) {
                return;
            }
            ContainerRecipe.this.inventoryItemStacks.set(n, itemStack);
        }

        @Override
        public String getInvName() {
            return null;
        }

        @Override
        public int getInventoryStackLimit() {
            return 10000;
        }

        @Override
        public void onInventoryChanged() {
        }

        @Override
        public void openChest() {
        }

        @Override
        public void closeChest() {
        }

        @Override
        public ItemStack getStackInSlotOnClosing(int n) {
            return null;
        }

        @Override
        public boolean isItemValidForSlot(int n, ItemStack itemStack) {
            return false;
        }

        @Override
        public boolean isInvNameLocalized() {
            return false;
        }
    }
}

