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
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class RecipeItemInputHandler
implements IContainerInputHandler {
    @Override
    public boolean lastKeyTyped(GuiContainer guiContainer, char c, int n) {
        ItemStack itemStack = guiContainer.manager.getStackMouseOver();
        if (itemStack == null) {
            return false;
        }
        if (n == NEIClientConfig.getKeyBinding("gui.usage") || n == NEIClientConfig.getKeyBinding("gui.recipe") && NEIClientUtils.shiftKey()) {
            return GuiUsageRecipe.openRecipeGui("item", itemStack._l());
        }
        if (n == NEIClientConfig.getKeyBinding("gui.recipe")) {
            return GuiCraftingRecipe.openRecipeGui("item", itemStack._l());
        }
        return false;
    }

    @Override
    public boolean mouseClicked(GuiContainer guiContainer, int n, int n2, int n3) {
        ItemStack itemStack = guiContainer.manager.getStackMouseOver();
        if (itemStack == null || !(guiContainer instanceof GuiRecipe)) {
            return false;
        }
        if (n3 == 0) {
            return GuiCraftingRecipe.openRecipeGui("item", itemStack._l());
        }
        if (n3 == 1) {
            return GuiUsageRecipe.openRecipeGui("item", itemStack._l());
        }
        return false;
    }

    @Override
    public void onKeyTyped(GuiContainer guiContainer, char c, int n) {
    }

    @Override
    public void onMouseClicked(GuiContainer guiContainer, int n, int n2, int n3) {
    }

    @Override
    public void onMouseUp(GuiContainer guiContainer, int n, int n2, int n3) {
    }

    @Override
    public boolean keyTyped(GuiContainer guiContainer, char c, int n) {
        return false;
    }

    @Override
    public boolean mouseScrolled(GuiContainer guiContainer, int n, int n2, int n3) {
        return false;
    }

    @Override
    public void onMouseScrolled(GuiContainer guiContainer, int n, int n2, int n3) {
    }

    @Override
    public void onMouseDragged(GuiContainer guiContainer, int n, int n2, int n3, long l) {
    }
}

