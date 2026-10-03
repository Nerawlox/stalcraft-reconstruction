/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.core.Profiler;
import codechicken.core.gui.GuiDraw;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IUsageHandler;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class ProfilerRecipeHandler
implements ICraftingHandler,
IUsageHandler {
    private static Profiler profiler = new Profiler();
    private boolean crafting;

    public static Profiler getProfiler() {
        profiler.clear();
        return profiler;
    }

    public ProfilerRecipeHandler(boolean bl) {
        this.crafting = bl;
    }

    @Override
    public String getRecipeName() {
        return NEIClientUtils.translate("recipe.profiler." + (this.crafting ? "crafting" : "usage"), new Object[0]);
    }

    @Override
    public int numRecipes() {
        if (!NEIClientConfig.getBooleanSetting("inventory.profileRecipes")) {
            return 0;
        }
        return (int)Math.ceil((double)((this.crafting ? GuiCraftingRecipe.craftinghandlers.size() : GuiUsageRecipe.usagehandlers.size()) - 1) / 6.0);
    }

    @Override
    public void drawBackground(int n) {
    }

    @Override
    public void drawForeground(int n) {
        List<Profiler.ProfilerResult> list = profiler.getResults();
        Iterator<Profiler.ProfilerResult> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            if (!iterator2.next().name.equals(this.getRecipeName())) continue;
            iterator2.remove();
        }
        Collections.sort(list, new Comparator<Profiler.ProfilerResult>(){

            @Override
            public int compare(Profiler.ProfilerResult profilerResult, Profiler.ProfilerResult profilerResult2) {
                return profilerResult.time < profilerResult2.time ? 1 : -1;
            }
        });
        for (int i = n * 6; i < list.size() && i < (n + 1) * 6; ++i) {
            Profiler.ProfilerResult profilerResult = list.get(i);
            int n2 = i % 6 * 20 + 6;
            GuiDraw.drawString(profilerResult.name, 8, n2, -8355712, false);
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            String string = decimalFormat.format(profilerResult.fraction * 100.0) + "%";
            string = profilerResult.time < 1000000L ? string + " (" + profilerResult.time / 1000L + "us)" : string + " (" + profilerResult.time / 1000000L + "ms)";
            GuiDraw.drawString(string, 156 - GuiDraw.getStringWidth(string), n2 + 10, -12566464, false);
        }
    }

    public ArrayList<PositionedStack> getIngredientStacks(int n) {
        return new ArrayList<PositionedStack>();
    }

    public ArrayList<PositionedStack> getOtherStacks(int n) {
        return new ArrayList<PositionedStack>();
    }

    @Override
    public PositionedStack getResultStack(int n) {
        return null;
    }

    @Override
    public void onUpdate() {
    }

    @Override
    public boolean hasOverlay(GuiContainer guiContainer, Container container, int n) {
        return false;
    }

    @Override
    public IRecipeOverlayRenderer getOverlayRenderer(GuiContainer guiContainer, int n) {
        return null;
    }

    @Override
    public IOverlayHandler getOverlayHandler(GuiContainer guiContainer, int n) {
        return null;
    }

    @Override
    public int recipiesPerPage() {
        return 1;
    }

    @Override
    public List<String> handleTooltip(GuiRecipe guiRecipe, List<String> list, int n) {
        return list;
    }

    @Override
    public List<String> handleItemTooltip(GuiRecipe guiRecipe, ItemStack itemStack, List<String> list, int n) {
        return list;
    }

    @Override
    public boolean keyTyped(GuiRecipe guiRecipe, char c, int n, int n2) {
        return false;
    }

    @Override
    public boolean mouseClicked(GuiRecipe guiRecipe, int n, int n2) {
        return false;
    }

    @Override
    public IUsageHandler getUsageHandler(String string, Object ... objectArray) {
        return this;
    }

    @Override
    public ICraftingHandler getRecipeHandler(String string, Object ... objectArray) {
        return this;
    }
}

