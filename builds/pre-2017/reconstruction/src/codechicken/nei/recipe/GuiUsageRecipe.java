/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei.recipe;

import codechicken.core.Profiler;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.IRecipeHandler;
import codechicken.nei.recipe.IUsageHandler;
import codechicken.nei.recipe.ProfilerRecipeHandler;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;

public class GuiUsageRecipe
extends GuiRecipe {
    public ArrayList<IUsageHandler> currenthandlers;
    public static ArrayList<IUsageHandler> usagehandlers = new ArrayList();

    private GuiUsageRecipe(GuiContainer guiContainer, ArrayList<IUsageHandler> arrayList) {
        super(guiContainer);
        this.currenthandlers = arrayList;
    }

    public static void registerUsageHandler(IUsageHandler iUsageHandler) {
        for (IUsageHandler iUsageHandler2 : usagehandlers) {
            if (iUsageHandler2.getClass() != iUsageHandler.getClass()) continue;
            return;
        }
        usagehandlers.add(iUsageHandler);
    }

    public static boolean openRecipeGui(String string, Object ... objectArray) {
        Minecraft minecraft = NEIClientUtils.mc();
        if (!(minecraft._B instanceof GuiContainer)) {
            return false;
        }
        GuiContainer guiContainer = (GuiContainer)minecraft._B;
        Profiler profiler = ProfilerRecipeHandler.getProfiler();
        ArrayList<IUsageHandler> arrayList = new ArrayList<IUsageHandler>();
        for (IUsageHandler iUsageHandler : usagehandlers) {
            profiler.start(iUsageHandler.getRecipeName());
            IUsageHandler iUsageHandler2 = iUsageHandler.getUsageHandler(string, objectArray);
            if (iUsageHandler2.numRecipes() <= 0) continue;
            arrayList.add(iUsageHandler2);
        }
        profiler.end();
        if (arrayList.isEmpty()) {
            return false;
        }
        NEIClientUtils.overlayScreen(new GuiUsageRecipe(guiContainer, arrayList));
        return true;
    }

    @Override
    public ArrayList<? extends IRecipeHandler> getCurrentRecipeHandlers() {
        return this.currenthandlers;
    }
}

