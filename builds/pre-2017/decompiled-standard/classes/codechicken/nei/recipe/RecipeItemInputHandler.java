/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.forge.IContainerInputHandler;
import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;

public class RecipeItemInputHandler
implements IContainerInputHandler {
    @Override
    public boolean lastKeyTyped(zybc zybc2, char c, int n) {
        cvzo cvzo2 = zybc2.manager.getStackMouseOver();
        if (cvzo2 == null) {
            return false;
        }
        if (n == NEIClientConfig.getKeyBinding("gui.usage") || n == NEIClientConfig.getKeyBinding("gui.recipe") && NEIClientUtils.shiftKey()) {
            return GuiUsageRecipe.openRecipeGui("item", cvzo2._l());
        }
        if (n == NEIClientConfig.getKeyBinding("gui.recipe")) {
            return GuiCraftingRecipe.openRecipeGui("item", cvzo2._l());
        }
        return false;
    }

    @Override
    public boolean mouseClicked(zybc zybc2, int n, int n2, int n3) {
        cvzo cvzo2 = zybc2.manager.getStackMouseOver();
        if (cvzo2 == null || !(zybc2 instanceof GuiRecipe)) {
            return false;
        }
        if (n3 == 0) {
            return GuiCraftingRecipe.openRecipeGui("item", cvzo2._l());
        }
        if (n3 == 1) {
            return GuiUsageRecipe.openRecipeGui("item", cvzo2._l());
        }
        return false;
    }

    @Override
    public void onKeyTyped(zybc zybc2, char c, int n) {
    }

    @Override
    public void onMouseClicked(zybc zybc2, int n, int n2, int n3) {
    }

    @Override
    public void onMouseUp(zybc zybc2, int n, int n2, int n3) {
    }

    @Override
    public boolean keyTyped(zybc zybc2, char c, int n) {
        return false;
    }

    @Override
    public boolean mouseScrolled(zybc zybc2, int n, int n2, int n3) {
        return false;
    }

    @Override
    public void onMouseScrolled(zybc zybc2, int n, int n2, int n3) {
    }

    @Override
    public void onMouseDragged(zybc zybc2, int n, int n2, int n3, long l) {
    }
}

