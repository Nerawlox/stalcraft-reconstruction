/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.PositionedStack;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.recipe.GuiRecipe;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public interface IRecipeHandler {
    public String getRecipeName();

    public int numRecipes();

    public void drawBackground(int var1);

    public void drawForeground(int var1);

    public List<PositionedStack> getIngredientStacks(int var1);

    public List<PositionedStack> getOtherStacks(int var1);

    public PositionedStack getResultStack(int var1);

    public void onUpdate();

    public boolean hasOverlay(GuiContainer var1, Container var2, int var3);

    public IRecipeOverlayRenderer getOverlayRenderer(GuiContainer var1, int var2);

    public IOverlayHandler getOverlayHandler(GuiContainer var1, int var2);

    public int recipiesPerPage();

    public List<String> handleTooltip(GuiRecipe var1, List<String> var2, int var3);

    public List<String> handleItemTooltip(GuiRecipe var1, ItemStack var2, List<String> var3, int var4);

    public boolean keyTyped(GuiRecipe var1, char var2, int var3, int var4);

    public boolean mouseClicked(GuiRecipe var1, int var2, int var3);
}

