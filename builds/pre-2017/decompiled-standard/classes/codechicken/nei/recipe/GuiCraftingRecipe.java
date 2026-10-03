/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.core.Profiler;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IRecipeHandler;
import codechicken.nei.recipe.ProfilerRecipeHandler;
import java.util.ArrayList;
import net.minecraft.client.xpzm;

public class GuiCraftingRecipe
extends GuiRecipe {
    public ArrayList<ICraftingHandler> currenthandlers;
    public static ArrayList<ICraftingHandler> craftinghandlers = new ArrayList();

    private GuiCraftingRecipe(zybc zybc2, ArrayList<ICraftingHandler> arrayList) {
        super(zybc2);
        this.currenthandlers = arrayList;
    }

    public static void registerRecipeHandler(ICraftingHandler iCraftingHandler) {
        for (ICraftingHandler iCraftingHandler2 : craftinghandlers) {
            if (iCraftingHandler2.getClass() != iCraftingHandler.getClass()) continue;
            return;
        }
        craftinghandlers.add(iCraftingHandler);
    }

    public static boolean openRecipeGui(String string, Object ... objectArray) {
        xpzm xpzm2 = NEIClientUtils.mc();
        if (!(xpzm2._B instanceof zybc)) {
            return false;
        }
        zybc zybc2 = (zybc)xpzm2._B;
        Profiler profiler = ProfilerRecipeHandler.getProfiler();
        ArrayList<ICraftingHandler> arrayList = new ArrayList<ICraftingHandler>();
        for (ICraftingHandler iCraftingHandler : craftinghandlers) {
            profiler.start(iCraftingHandler.getRecipeName());
            ICraftingHandler iCraftingHandler2 = iCraftingHandler.getRecipeHandler(string, objectArray);
            if (iCraftingHandler2.numRecipes() <= 0) continue;
            arrayList.add(iCraftingHandler2);
        }
        profiler.end();
        if (arrayList.isEmpty()) {
            return false;
        }
        NEIClientUtils.overlayScreen(new GuiCraftingRecipe(zybc2, arrayList));
        return true;
    }

    @Override
    public ArrayList<? extends IRecipeHandler> getCurrentRecipeHandlers() {
        return this.currenthandlers;
    }
}

