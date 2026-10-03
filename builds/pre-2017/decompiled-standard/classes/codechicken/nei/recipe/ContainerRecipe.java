/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerRecipe
extends jjgc {
    private RecipeInventory recipeInventory = new RecipeInventory();

    public void clearInventory() {
        this.field_75153_a.clear();
        this.field_75151_b.clear();
    }

    public cvzo slotClick(int n, int n2, boolean bl, EntityPlayer entityPlayer) {
        if (n < 0) {
            return null;
        }
        cvzo cvzo2 = this.recipeInventory.func_70301_a(n);
        if (cvzo2 != null) {
            if (n2 == 0) {
                GuiCraftingRecipe.openRecipeGui("item", cvzo2);
            } else if (n2 == 1) {
                GuiUsageRecipe.openRecipeGui("item", cvzo2);
            }
        }
        return null;
    }

    public void addSlot(PositionedStack positionedStack, int n, int n2) {
        int n3 = this.field_75151_b.size();
        this.func_75146_a(new yeso(this.recipeInventory, n3, n + positionedStack.relx, n2 + positionedStack.rely){

            @Override
            public boolean func_75214_a(cvzo cvzo2) {
                return false;
            }
        });
        this.recipeInventory.func_70299_a(n3, positionedStack.item);
    }

    public yeso getSlotWithStack(PositionedStack positionedStack, int n, int n2) {
        for (int i = 0; i < this.field_75151_b.size(); ++i) {
            yeso yeso2 = (yeso)this.field_75151_b.get(i);
            if (yeso2.field_75223_e != positionedStack.relx + n || yeso2.field_75221_f != positionedStack.rely + n2) continue;
            return yeso2;
        }
        return null;
    }

    @Override
    public boolean func_75145_c(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void func_75141_a(int n, cvzo cvzo2) {
    }

    @Override
    public cvzo func_82846_b(EntityPlayer entityPlayer, int n) {
        return null;
    }

    private class RecipeInventory
    implements mssh {
        private RecipeInventory() {
        }

        @Override
        public boolean func_70300_a(EntityPlayer entityPlayer) {
            return true;
        }

        @Override
        public int func_70302_i_() {
            return ContainerRecipe.this.field_75151_b.size();
        }

        @Override
        public cvzo func_70301_a(int n) {
            if (n < 0 || n > ContainerRecipe.this.field_75153_a.size()) {
                return null;
            }
            return (cvzo)ContainerRecipe.this.field_75153_a.get(n);
        }

        @Override
        public cvzo func_70298_a(int n, int n2) {
            return null;
        }

        @Override
        public void func_70299_a(int n, cvzo cvzo2) {
            if (n < 0 || n >= ContainerRecipe.this.field_75153_a.size()) {
                return;
            }
            ContainerRecipe.this.field_75153_a.set(n, cvzo2);
        }

        @Override
        public String func_70303_b() {
            return null;
        }

        @Override
        public int func_70297_j_() {
            return 10000;
        }

        @Override
        public void func_70296_d() {
        }

        @Override
        public void func_70295_k_() {
        }

        @Override
        public void func_70305_f() {
        }

        @Override
        public cvzo func_70304_b(int n) {
            return null;
        }

        @Override
        public boolean func_94041_b(int n, cvzo cvzo2) {
            return false;
        }

        @Override
        public boolean func_94042_c() {
            return false;
        }
    }
}

