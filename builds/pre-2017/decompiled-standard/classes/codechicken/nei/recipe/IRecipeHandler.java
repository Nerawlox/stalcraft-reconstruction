/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.nei.PositionedStack;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.recipe.GuiRecipe;
import java.util.List;

public interface IRecipeHandler {
    public String getRecipeName();

    public int numRecipes();

    public void drawBackground(int var1);

    public void drawForeground(int var1);

    public List<PositionedStack> getIngredientStacks(int var1);

    public List<PositionedStack> getOtherStacks(int var1);

    public PositionedStack getResultStack(int var1);

    public void onUpdate();

    public boolean hasOverlay(zybc var1, jjgc var2, int var3);

    public IRecipeOverlayRenderer getOverlayRenderer(zybc var1, int var2);

    public IOverlayHandler getOverlayHandler(zybc var1, int var2);

    public int recipiesPerPage();

    public List<String> handleTooltip(GuiRecipe var1, List<String> var2, int var3);

    public List<String> handleItemTooltip(GuiRecipe var1, cvzo var2, List<String> var3, int var4);

    public boolean keyTyped(GuiRecipe var1, char var2, int var3, int var4);

    public boolean mouseClicked(GuiRecipe var1, int var2, int var3);
}

